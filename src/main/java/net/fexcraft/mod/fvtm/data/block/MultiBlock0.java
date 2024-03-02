package net.fexcraft.mod.fvtm.data.block;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.MultiBlockItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.script.FSBlockScript;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MultiBlock0 extends TypeCore<MultiBlock0> implements ItemTextureable {

	private Map<String, InvHandler> inventories = new LinkedHashMap<>();
	private ArrayList<Entry<ResourceLocation, EnumFacing>> blocks = new ArrayList<>();
	private ArrayList<MB_Trigger> triggers = new ArrayList<>();
	private ArrayList<MB_Access> access = new ArrayList<>();
	private ArrayList<BlockPos> blockpos = new ArrayList<>();
	private Class<? extends BlockScript> clazz;
	private IDL itemloc;
	private JsonObject scriptdata;
	private MultiBlockItem item;
	private String ctab;

	@Override
	public MultiBlock0 parse(JsonObject obj){
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		this.registryname = DataUtil.getRegistryName(pack, obj);
		if(registryname == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed MultiBlock");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
		//
		if(obj.has("Inventories")){
			JsonObject invs = obj.get("Inventories").getAsJsonObject();
			for(Entry<String, JsonElement> entry : invs.entrySet()){
				String[] split = entry.getValue().getAsString().split("-");
				String invtype = split[0];
				InvHandler handler = new InvHandler(InvType.parse(invtype, true));
				handler.setCapacity(Integer.parseInt(split[1]));
				if(split.length > 2){
					handler.setArg(split[2]);
				}
				inventories.put(entry.getKey(), handler);
			}
		}
		BlockPos core = null;
		if(obj.has("Core")){
			JsonArray corearr = obj.get("Core").getAsJsonArray();
			core = new BlockPos(corearr.get(0).getAsInt(), corearr.get(1).getAsInt(), corearr.get(2).getAsInt());
		}
		if(obj.has("Blocks")){
			boolean pattern = obj.has("Pattern");
			if(!pattern){
				JsonArray blks = obj.get("Blocks").getAsJsonArray();
				for(JsonElement entry : blks){
					JsonArray values = entry.getAsJsonArray();
					BlockPos pos = new BlockPos(values.get(1).getAsInt(), values.get(2).getAsInt(), values.get(3).getAsInt());
					EnumFacing val = EnumFacing.NORTH;
					if(values.size() > 4){
						String value = values.get(4).getAsString();
						if(NumberUtils.isCreatable(value)){
							val = EnumFacing.byIndex(Integer.parseInt(value));
						}
						else{
							val = EnumFacing.byName(value);
						}
					}
					blocks.add(new SimpleEntry<>(new ResourceLocation(values.get(0).getAsString()), val));
					blockpos.add(pos);
				}
			}
			else{
				ArrayList<Entry<Character, BlockPos>> list = new ArrayList<>();
				JsonArray array = obj.get("Pattern").getAsJsonArray();
				int x = 0;
				for(JsonElement elm : array){
					if(elm.isJsonArray()){
						int y = 0;
						for(JsonElement e : elm.getAsJsonArray()){
							parsePatternArray(list, x, y, e.getAsString());
							y++;
						}
					}
					else parsePatternArray(list, 0, x, elm.getAsString());
					x++;
				}
				HashMap<Character, ResourceLocation> blkmap = new HashMap<>();
				HashMap<Character, EnumFacing> facemap = new HashMap<>();
				JsonObject blks = obj.get("Blocks").getAsJsonObject();
				for(Entry<String, JsonElement> elm : blks.entrySet()){
					if(elm.getValue().isJsonArray()){
						JsonArray arr = elm.getValue().getAsJsonArray();
						blkmap.put(elm.getKey().charAt(0), new ResourceLocation(arr.get(0).getAsString()));
						EnumFacing val = EnumFacing.NORTH;
						String value = arr.get(1).getAsString();
						if(NumberUtils.isCreatable(value)){
							val = EnumFacing.byIndex(Integer.parseInt(value));
						}
						else{
							val = EnumFacing.byName(value);
						}
						facemap.put(elm.getKey().charAt(0), val);
					}
					else{
						blkmap.put(elm.getKey().charAt(0), new ResourceLocation(elm.getValue().getAsString()));
						facemap.put(elm.getKey().charAt(0), EnumFacing.NORTH);
					}
				}
				for(Entry<Character, BlockPos> entry : list){
					if(!blkmap.containsKey(entry.getKey())) continue;
					BlockPos pos = entry.getValue().add(-core.getX(), -core.getY(), -core.getZ());
					pos = new BlockPos(pos.getZ(), pos.getY(), pos.getX());
					blocks.add(new SimpleEntry<>(blkmap.get(entry.getKey()), facemap.get(entry.getKey())));
					blockpos.add(pos);
					//Print.debug(entry.getKey() + "/" + pos + "/" + blkmap.get(entry.getKey()));
				}
				//Static.stop();
			}
		}
		if(obj.has("Triggers")){
			JsonArray array = obj.get("Triggers").getAsJsonArray();
			for(JsonElement elm : array){
				triggers.add(new MB_Trigger(elm.getAsJsonArray(), core));
			}
		}
		if(obj.has("Access")){
			JsonArray array = obj.get("Access").getAsJsonArray();
			for(JsonElement elm : array){
				access.add(new MB_Access(elm.getAsJsonArray(), core));
			}
		}
		if(obj.has("Script")){
			try{
				String loc = obj.get("Script").getAsString();
				if(loc.endsWith(".script")){
					if(obj.has("ScriptRoot")) clazz = (Class<? extends BlockScript>)Class.forName(obj.get("ScriptRoot").getAsString().replace(".class", ""));
					else clazz = FSBlockScript.class;
					if(obj.has("ScriptData")){
						JsonObject elm = obj.get("ScriptData").getAsJsonObject();
						elm.addProperty("script_location", loc);
					}
					else{
						JsonObject elm = new JsonObject();
						elm.addProperty("script_location", loc);
						obj.add("ScriptData", elm);
					}
				}
				else clazz = (Class<? extends BlockScript>)Class.forName(loc.replace(".class", ""));
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
				Static.stop();
			}
		}
		if(obj.has("ScriptData")){
			scriptdata = obj.get("ScriptData").getAsJsonObject();
		}
		itemloc = IDLManager.getIDLCached(DataUtil.getItemTexture(registryname, getDataType(), obj).toString());
		item = new MultiBlockItem(this);
		return this;
	}

	private void parsePatternArray(ArrayList<Entry<Character, BlockPos>> list, int height, int row, String string){
		char[] arr = string.toCharArray();
		for(int c = 0; c < arr.length; c++){
			if(arr[c] == ' ') continue;
			list.add(new SimpleEntry<>(arr[c], new BlockPos(row, height, c)));
		}
	}

	public Map<String, InvHandler> getDefaultInventories(){
		return inventories;
	}

	public ArrayList<Entry<ResourceLocation, EnumFacing>> getBlocks(){
		return blocks;
	}

	public ArrayList<MB_Trigger> getTriggers(){
		return triggers;
	}

	public ArrayList<MB_Access> getAccess(){
		return access;
	}

	public ArrayList<BlockPos> getBlockLocations(){
		return blockpos;
	}
	
	public Class<? extends BlockScript> getScript(){
		return clazz;
	}
	
	public boolean hasScript(){
		return clazz != null;
	}

	public ArrayList<BlockPos> getPositions(BlockPos corepos, EnumFacing facing){
		ArrayList<BlockPos> list = new ArrayList<>();
		Rotation rot = getRotation(facing, false);
		for(BlockPos pos : blockpos){
			list.add(corepos.add(pos.rotate(rot)));
		}
		return list;
	}

	private Rotation getRotation(EnumFacing facing, boolean counter){
		switch(facing){
			case EAST:
				return counter ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90;
			case SOUTH:
				return Rotation.CLOCKWISE_180;
			case WEST:
				return counter ? Rotation.CLOCKWISE_90 : Rotation.COUNTERCLOCKWISE_90;
			case UP:
			case DOWN:
			case NORTH:
			default:
				return Rotation.NONE;
		}
	}

	public static EnumFacing rotate(EnumFacing facing, EnumFacing rotateby){
		if(facing.getAxis() == EnumFacing.Axis.Y) return facing;
		switch(rotateby){
			case EAST:
				return facing.rotateY();
			case SOUTH:
				return facing.getOpposite();
			case WEST:
				return facing.rotateYCCW();
			case NORTH:
			case DOWN:
			case UP:
			default:
				return facing;
			
		}
	}

	public List<MB_Trigger> getTriggers(EnumFacing facing, BlockPos pos, BlockPos core){
		//Print.debug(pos);
		//Print.debug(core.subtract(pos));
		pos = core.subtract(pos);
		pos = pos.up(-pos.getY() * 2);
		pos = pos.rotate(getRotation(facing, true));
		//Print.debug(pos);
		BlockPos rpos = pos;
		return triggers.stream().filter(trigger -> trigger.getBlockPos().equals(rpos)).collect(Collectors.toList());
	}

	public void getCapabilities(MultiBlockData0 data, EnumFacing facing, BlockPos pos, BlockPos core, Map<EnumFacing, List<MB_Access.CapabilityContainer>> capabilities){
		pos = core.subtract(pos);
		pos = pos.up(-pos.getY() * 2);
		pos = pos.rotate(getRotation(facing, true));
		BlockPos rpos = pos;
		access.forEach(access -> {
			if(access.getBlockPos().equals(rpos)){
				//Print.debug("found " + rpos);
				access.fill(data, null, facing, capabilities);
			}
		});
	}

	public JsonObject getScriptData(){
		return scriptdata;
	}

	@Override
	public ContentType getDataType(){
		return ContentType.MULTIBLOCK;
	}

	@Override
	public Class<?> getDataClass(){
		return MultiBlockData0.class;
	}

	@Nullable
	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	//@Override
	public String getCreativeTab(){
		return ctab;
	}

	public MultiBlockItem getBlockItem(){
		return item;
	}

	@Override
	public Item getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}

	@Override
	public IDL getItemTexture(){
		return itemloc;
	}

	@Override
	public boolean noCustomItemModel(){
		return true;
	}
}
