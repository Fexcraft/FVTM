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

import net.fexcraft.mod.fvtm.data.InventoryType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MultiBlock {
	
	private ResourceLocation regname;
	private Map<String, InventoryType> inventories = new LinkedHashMap<>();
	private ArrayList<Entry<ResourceLocation, Integer>> blocks = new ArrayList<>();
	private ArrayList<MB_Trigger> triggers = new ArrayList<>();
	private ArrayList<BlockPos> blockpos = new ArrayList<>();

	public MultiBlock(ResourceLocation registryname, JsonObject obj){
		regname = registryname;
		if(obj.has("Inventories")){
			JsonObject invs = obj.get("Inventories").getAsJsonObject();
			for(Entry<String, JsonElement> entry : invs.entrySet()){
				inventories.put(entry.getKey(), InventoryType.valueOf(entry.getValue().getAsString().toUpperCase()));
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
	}

	public ResourceLocation getRegName(){
		return regname;
	}

	public Map<String, InventoryType> getInventories(){
		return inventories;
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

}
