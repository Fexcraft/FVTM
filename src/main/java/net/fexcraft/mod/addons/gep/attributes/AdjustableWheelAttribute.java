package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class AdjustableWheelAttribute implements Attribute {

	private static final ResourceLocation rs = new ResourceLocation("adjustable_wheel");
	private static final ResourceLocation ALL = new ResourceLocation("all");
	private Table<ResourceLocation, String, Pos> offsets = TreeBasedTable.create();
	
	@Override
	public ResourceLocation getRegistryName(){
		return rs;
	}

	@Override
	public void load(JsonObject obj){
		if(!obj.has("Adjustable-Wheel-Positions")){
			return;
		}
		for(JsonElement elm : obj.get("Adjustable-Wheel-Positions").getAsJsonArray()){
			JsonObject jsn = elm.getAsJsonObject();
			if(jsn.has("part")){
				try{
					offsets.put(jsn.has("vehicle") ? new ResourceLocation(jsn.get("vehicle").getAsString()) : ALL, jsn.get("part").getAsString(), Pos.fromJSON(jsn));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else continue;
		}
	}

	@Override
	public String getName(){
		return "Adjustable Wheel Attribute";
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
		tooltip.add(Formatter.format("&9Adjustable Wheel &7(" + offsets.size() + ")"));
	}

	@Override
	public boolean hasDataClass(){
		return false;
	}

	@Override
	public Class<? extends AttributeData> getDataClass(){
		return null;
	}
	
	public Pos getOffsetFor(ResourceLocation rs, String str){
		return offsets.get(rs, str);
	}
	
	public Pos getOffsetFor(VehicleData data, String str){
		if(data == null){
			return offsets.get(ALL, str);
		}
		Pos pos = offsets.get(data.getVehicle().getRegistryName(), str);
		return pos == null ? getOffsetFor((VehicleData)null, str) : pos;
	}
	
	public Table<ResourceLocation, String, Pos> getOffsets(){
		return offsets;
	}
	
}