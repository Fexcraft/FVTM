package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerInit;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MultiBlock extends Content<MultiBlock> implements WithItem, ItemTextureable {

	private Map<String, InvHandler> inventories = new LinkedHashMap<>();
	private ArrayList<Entry<IDL, CubeSide>> blocks = new ArrayList<>();
	private ArrayList<MB_Interact> interact = new ArrayList<>();
	private ArrayList<MB_Access> access = new ArrayList<>();
	private ArrayList<V3I> blockpos = new ArrayList<>();
	private String ctab;
	private IDL itemtexloc;
	private boolean no3ditem;

	@Override
	public MultiBlock parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Block");
		description = ContentConfigUtil.getStringList(map, "Description");
		ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		no3ditem = map.getBoolean("Disable3DItemModel", false);
		//
		if(map.has("Inventories")){
			JsonMap invs = map.getMap("Inventories");
			for(Entry<String, JsonValue<?>> entry : invs.entries()){
				JsonArray array = entry.getValue().asArray();
				InvHandler handler = new InvHandlerInit(InvType.parse(array.get(0).string_value()));
				handler.setCapacity(array.get(1).integer_value());
				if(array.size() > 2){
					handler.setArg(array.get(2).string_value());
				}
				inventories.put(entry.getKey(), handler);
			}
		}
		V3I core = null;
		if(map.has("Core")){
			core = new V3I(map.getArray("Core").toIntegerArray(), 0);
		}
		if(map.has("Blocks") && map.has("Pattern")){
			ArrayList<Entry<Character, V3I>> list = new ArrayList<>();
			JsonArray array = map.getArray("Pattern");
			int x = 0;
			for(JsonValue<?> val : array.value){
				if(val.isArray()){
					int y = 0;
					for(JsonValue<?> v : val.asArray().value){
						parsePattern(list, x, y, v.string_value());
					}
				}
				else parsePattern(list, 0, x, val.string_value());
				x++;
			}
			Map<Character, IDL> blkmap = new HashMap<>();
			Map<Character, CubeSide> sidemap = new HashMap<>();
			JsonMap blks = map.getMap("Blocks");
			for(Entry<String, JsonValue<?>> entry : blks.entries()){
				char key = entry.getKey().charAt(0);
				if(entry.getValue().isArray()){
					JsonArray arr = entry.getValue().asArray();
					blkmap.put(key, IDLManager.getIDLCached(arr.get(0).string_value()));
					CubeSide side = CubeSide.NORTH;
					if(arr.get(1).isNumber()){
						side = CubeSide.fromIndex(arr.get(1).integer_value(), CubeSide.NORTH);
					}
					else{
						side = CubeSide.valueOf(arr.get(1).string_value().toUpperCase());
					}
					sidemap.put(key, side);
				}
				else{
					blkmap.put(key, IDLManager.getIDLCached(entry.getValue().string_value()));
					sidemap.put(key, CubeSide.NORTH);
				}
			}
			for(Entry<Character, V3I> entry : list){
				if(!blkmap.containsKey(entry.getKey())) continue;
				V3I pos = entry.getValue().sub(core);
				blocks.add(new AbstractMap.SimpleEntry<>(blkmap.get(entry.getKey()), sidemap.get(entry.getKey())));
				blockpos.add(new V3I(pos.z, pos.y, pos.x));
			}
		}
		if(map.has("Interact")){
			for(JsonValue<?> val : map.getArray("Interact").value){
				try{
					interact.add(new MB_Interact(val.asArray(), core));
				}
				catch(Exception e){
					FvtmLogger.log(e, "MultiBlock Interact Parse / " + id);
				}
			}
		}
		if(map.has("Access")){
			for(JsonValue<?> val : map.getArray("Access").value){
				try{
					access.add(new MB_Access(val.asArray(), core));
				}
				catch(Exception e){
					FvtmLogger.log(e, "MultiBlock Access Parse " + id);
				}
			}
		}
		//TODO scripts
		return this;
	}

	private void parsePattern(ArrayList<Entry<Character, V3I>> list, int height, int row, String string){
		char[] arr = string.toCharArray();
		for(int c = 0; c < arr.length; c++){
			if(arr[c] == ' ') continue;
			list.add(new AbstractMap.SimpleEntry<>(arr[c], new V3I(row, height, c)));
		}
	}

	@Override
	public ContentType getContentType(){
		return ContentType.MULTIBLOCK;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	@Override
	public boolean noCustomItemModel(){
		return no3ditem;
	}

	public ArrayList<V3I> getPositions(V3I core, CubeSide side){
		ArrayList<V3I> list = new ArrayList<>();
		int rots = getRotations(side, false);
		for(V3I pos : blockpos){
			list.add(core.add(pos.rotate(rots)));
		}
		return list;
	}

	private int getRotations(CubeSide side, boolean counter){
		switch(side){
			case EAST: return counter ? 3 : 1;
			case SOUTH: return 2;
			case WEST: return counter ? 1 : 3;
			default: return 0;
		}
	}

	public static CubeSide rotate(CubeSide side, CubeSide by){
		if(side.axe() == CubeSide.Axe.Y) return side;
		switch(by){
			case EAST: return side.rotate();
			case SOUTH: return side.rotate().rotate();
			case WEST: return side.rotateCC();
			default: return side;
		}
	}

	public static CubeSide rotate(CubeSide side, Object by){
		return rotate(side, WrapperHolder.getSide(by));
	}

	public static CubeSide rotate(Object side, Object by){
		return rotate(WrapperHolder.getSide(side), WrapperHolder.getSide(by));
	}

	public List<MB_Interact> getInteract(CubeSide side, V3I pos, V3I core){
		pos = core.sub(pos);
		pos = pos.add(0, -pos.y * 2, 0);
		pos = pos.rotate(getRotations(side, true));
		V3I rpos = pos;
		return interact.stream().filter(trigger -> trigger.getPos().equals(rpos)).collect(Collectors.toList());
	}

	public Map<String, InvHandler> getDefInventories(){
		return inventories;
	}

	public ArrayList<Entry<IDL, CubeSide>> getBlocks(){
		return blocks;
	}

	public ArrayList<MB_Access> getAccess(){
		return access;
	}

}
