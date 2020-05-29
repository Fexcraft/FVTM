package net.fexcraft.mod.fvtm.data.block;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MultiBlock {
	
	private ResourceLocation regname;
	private Map<String, InventoryType> inventories = new LinkedHashMap<>();
	private Map<String, Integer> inventorysizes = new LinkedHashMap<>();
	private Map<String, Object> inventorydata = new LinkedHashMap<>();
	private ArrayList<Entry<ResourceLocation, EnumFacing>> blocks = new ArrayList<>();
	private ArrayList<MB_Trigger> triggers = new ArrayList<>();
	private ArrayList<MB_Access> access = new ArrayList<>();
	private ArrayList<BlockPos> blockpos = new ArrayList<>();
	private Class<? extends BlockScript> clazz;
	private boolean tickable;

	@SuppressWarnings("unchecked")
	public MultiBlock(ResourceLocation registryname, JsonObject obj){
		regname = registryname;
		if(obj.has("Inventories")){
			JsonObject invs = obj.get("Inventories").getAsJsonObject();
			for(Entry<String, JsonElement> entry : invs.entrySet()){
				String[] split = entry.getValue().getAsString().split("-");
				String invtype = split[0];
				int capacity = Integer.parseInt(split[1]);
				String invdata = split.length > 2 ? split[2] : null;
				Object data = null;
				InventoryType type = InventoryType.valueOf(invtype.toUpperCase());
				if(invdata != null){
					switch(type){
						case ENERGY:
							break;
						case FLUID:
							data = FluidRegistry.getFluid(invdata);
							break;
						case ITEM:
				        	data = ContentFilter.FILTER_REGISTRY.get(obj.get("ContentFilter").getAsString());
							break;
						default:
							break;
					}
				}
				inventories.put(entry.getKey(), type);
				inventorysizes.put(entry.getKey(), capacity);
				if(data != null) inventorydata.put(entry.getKey(), data);
			}
		}
		if(obj.has("Blocks")){
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
		if(obj.has("Trigger")){
			triggers.add(new MB_Trigger(obj.get("Trigger").getAsJsonObject()));
		}
		if(obj.has("Triggers")){
			JsonArray array = obj.get("Triggers").getAsJsonArray();
			for(JsonElement elm : array){
				triggers.add(new MB_Trigger(elm.getAsJsonObject()));
			}
		}
		if(obj.has("Access")){
			if(obj.get("Access").isJsonObject()){
				access.add(new MB_Access(obj.get("Access").getAsJsonObject()));
			}
			else if(obj.get("Access").isJsonArray()){
				JsonArray array = obj.get("Access").getAsJsonArray();
				for(JsonElement elm : array){
					access.add(new MB_Access(elm.getAsJsonObject()));
				}
			}
		}
		if(obj.has("Script")){
			try{
				clazz = (Class<? extends BlockScript>)Class.forName(obj.get("Script").getAsString().replace(".class", ""));
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
				Static.stop();
			}
		}
		tickable = JsonUtil.getIfExists(obj, "Tickable", false);
	}

	public ResourceLocation getRegName(){
		return regname;
	}

	public Map<String, InventoryType> getInventoryTypes(){
		return inventories;
	}

	public Map<String, Integer> getInventorySizes(){
		return inventorysizes;
	}

	public Map<String, Object> getInventoryData(){
		return inventorydata;
	}

	public ArrayList<Entry<ResourceLocation, EnumFacing>> getBlocks(){
		return blocks;
	}

	public ArrayList<MB_Trigger> getTriggers(){
		return triggers;
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

	public ArrayList<BlockPos> getPositions(Block type, BlockPos corepos, EnumFacing facing){
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

	public boolean isTickable(){
		return tickable;
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

	public void getCapabilities(MultiBlockData data, EnumFacing facing, BlockPos pos, BlockPos core, Map<EnumFacing, List<MB_Access.CapabilityContainer>> capabilities){
		pos = core.subtract(pos);
		pos = pos.up(-pos.getY() * 2);
		pos = pos.rotate(getRotation(facing, true));
		BlockPos rpos = pos;
		access.forEach(access -> {
			if(access.getBlockPos().equals(rpos)){
				Print.debug("found " + rpos);
				access.fill(data, null, facing, capabilities);
			}
		});
	}

}
