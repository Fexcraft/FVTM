package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFuntion;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TransmissionFunction extends StaticFuntion {
	
	private ArrayList<Float> ratios = new ArrayList<>();
	private float u_low, u_mid, u_high;
	private float d_low, d_mid, d_high;
	private int fgears, rgears;
	private float efficiency;
	private boolean automatic;

	public TransmissionFunction(Part part, JsonObject obj){
		super(part, obj);
		if(obj == null) obj = new JsonObject();
		JsonArray rats = obj.has("gear_ratios") ? obj.get("gear_ratios").getAsJsonArray() : null;
		if(rats == null){
			ratios.add(3f);
			ratios.add(2f);
			ratios.add(1f);
			ratios.add(0.5f);
			ratios.add(0f);
			ratios.add(-3f);
		}
		else for(JsonElement elm : rats){
			ratios.add(elm.getAsFloat());
		}
		if(!ratios.contains(0f)) ratios.add(0f);
		for(float f : ratios){
			if(f > 0) fgears++;
			if(f < 0) rgears++;
		}
		Collections.sort(ratios);
		automatic = JsonUtil.getIfExists(obj, "automatic", false);
		rats = obj.has("throttle_ratios_up") ? obj.get("throttle_ratios_up").getAsJsonArray() : null;
		if(rats == null){
			u_low = 0.35f;
			u_mid = 0.5f;
			u_high = 0.75f;
		}
		else{
			u_low = rats.get(0).getAsFloat();
			u_mid = rats.get(1).getAsFloat();
			u_high = rats.get(2).getAsFloat();
		}
		rats = obj.has("throttle_ratios_down") ? obj.get("throttle_ratios_down").getAsJsonArray() : null;
		if(rats == null){
			d_low = 0.25f;
			d_mid = 0.4f;
			d_high = 0.6f;
		}
		else{
			d_low = rats.get(0).getAsFloat();
			d_mid = rats.get(1).getAsFloat();
			d_high = rats.get(2).getAsFloat();
		}
		efficiency = JsonUtil.getIfExists(obj, "efficiency", 0.7).floatValue();
	}

	@Override
	public String getId(){
		return "fvtm:transmission";
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Gears: &7" + fgears + " / N / " + (rgears == 1 ? "R" : rgears)));
        tooltip.add(Formatter.format("&9Range: &7" + (ratios.get(rgears + 1) + "-" + ratios.get(ratios.size() - 1)) + " / " + (rgears == 1 ? ratios.get(0) : ratios.get(0) + "-" + ratios.get(rgears))));
        tooltip.add(Formatter.format("&9Type: &7" + (automatic ? "automatic" : "manual")));
    }
    
    public ArrayList<Float> getRatios(){
    	return ratios;
    }
    
    public boolean isAutomatic(){
    	return automatic;
    }
    
    public boolean isManual(){
    	return !automatic;
    }
    
    public float getEfficiency(){
    	return efficiency;
    }
	
	public int getFGearAmount(){
		return fgears;
	}
	
	public int getRGearAmount(){
		return fgears;
	}
	
	public float getRatio(int gear){
		return ratios.get(gear);
	}
	
	/** To be called from the vehicle vehicle when this is an automatic transmission, to check if it should change gears. */
	public int processAutoShift(int gear, int rpm, int rpm_max, float throttle, boolean forward){
		float max = rpm_max * (throttle < 0.3 ? u_low : throttle < 0.7 ? u_mid : u_high);
		float min = rpm_max * (throttle < 0.3 ? d_low : throttle < 0.7 ? d_mid : d_high);
		if(rpm < min){
			if(gear <= 1) return 1;
			else return gear - 1;
		}
		else if(rpm > max){
			int gears = (forward ? fgears : rgears);
			if(gear >= gears) return gears;
			else return gear + 1;
		}
		return gear;
	}

}
