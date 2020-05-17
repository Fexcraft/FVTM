package net.fexcraft.mod.fvtm.data.block;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
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
	private ArrayList<Entry<ResourceLocation, Integer>> blocks = new ArrayList<>();
	private ArrayList<MB_Trigger> triggers = new ArrayList<>();
	private ArrayList<BlockPos> blockpos = new ArrayList<>();
	private Class<? extends BlockScript> clazz;

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
			JsonObject blks = obj.get("Blocks").getAsJsonObject();
			for(Entry<String, JsonElement> entry : blks.entrySet()){
				JsonArray values = entry.getValue().getAsJsonArray();
				BlockPos pos = new BlockPos(values.get(0).getAsInt(), values.get(1).getAsInt(), values.get(2).getAsInt());
				String value = values.size() >= 3 ? values.get(3).getAsString() : "0";
				int val = 0;
				if(NumberUtils.isCreatable(value)){
					val = Integer.parseInt(value);
				}
				else{
					val = EnumFacing.byName(value).getIndex();
				}
				blocks.add(new SimpleEntry<>(new ResourceLocation(entry.getKey()), val));
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
		if(obj.has("Script")){
			try{
				clazz = (Class<? extends BlockScript>)Class.forName(obj.get("Script").getAsString().replace(".class", ""));
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
				Static.stop();
			}
		}
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

	public ArrayList<Entry<ResourceLocation, Integer>> getBlocks(){
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

}
