package net.fexcraft.mod.fvtm.function.part;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TransmissionFunction extends StaticFunction {
	
	private double[] fgears;
	private double[] rgears;
	private float u_low, u_mid, u_high;
	private float d_low, d_mid, d_high;
	private int shift_speed;
	private float efficiency;
	private boolean automatic;

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.isMap() ? json.asMap() : new JsonMap();
		JsonArray rats = map.has("gear_ratios") ? map.getArray("gear_ratios") : null;
		if(rats == null){
			fgears = new double[]{ 3, 2, 1, 0.5 };
			rgears = new double[]{ -3 };
		}
		else{
			ArrayList<Float> fr = new ArrayList<>();
			ArrayList<Float> rr = new ArrayList<>();
			for(JsonValue<?> val : rats.value){
				if(val.float_value() > 0) fr.add(val.float_value());
				else if(val.float_value() < 0) rr.add(val.float_value());
			}
			fgears = new double[fr.size()];
			rgears = new double[rr.size()];
			for(int i = 0; i < fr.size(); i++) fgears[i] = fr.get(i);
			for(int i = 0; i < rr.size(); i++) rgears[i] = rr.get(i);
		}
		automatic = map.getBoolean("automatic", false);
		rats = map.has("throttle_ratios_up") ? map.getArray("throttle_ratios_up") : null;
		if(rats == null){
			u_low = 0.35f;
			u_mid = 0.5f;
			u_high = 0.75f;
		}
		else{
			u_low = rats.get(0).float_value();
			u_mid = rats.get(1).float_value();
			u_high = rats.get(2).float_value();
		}
		rats = map.has("throttle_ratios_down") ? map.getArray("throttle_ratios_down") : null;
		if(rats == null){
			d_low = 0.25f;
			d_mid = 0.4f;
			d_high = 0.6f;
		}
		else{
			d_low = rats.get(0).float_value();
			d_mid = rats.get(1).float_value();
			d_high = rats.get(2).float_value();
		}
		efficiency = map.getFloat("efficiency", 0.7f);
		shift_speed = map.getInteger("shift_speed", 40);
		return this;
	}

	@Override
	public String getId(){
		return "fvtm:transmission";
	}

    @Override
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
        tooltip.add(Formatter.format("&9Gears: &7" + fgears.length + " / N / " + (rgears.length == 1 ? "R" : rgears.length)));
		tooltip.add(Formatter.format("&9Range: &7" + (fgears[0] + "-" + fgears[fgears.length - 1] + " / R " + (rgears.length == 1 ? -rgears[0] : -rgears[0] + "-" + -rgears[rgears.length - 1]))));
        tooltip.add(Formatter.format("&9Type: &7" + (automatic ? "automatic" : "manual")));
    }
    
    public double[] getFRatios(){
    	return fgears;
    }

	public double[] getRRatios(){
		return rgears;
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
		return fgears.length;
	}
	
	public int getRGearAmount(){
		return rgears.length;
	}
	
	public double getRatio(int gear){
		if(gear == 0) return 0;
		if(gear < 0){
			return rgears[-gear - 1];
		}
		else{
			return fgears[gear - 1];
		}
	}
	
	/** To be called from the vehicle when this is an automatic transmission, to check if it should change gears. */
	public int processAutoShift(int gear, int rpm, int rpm_max, double throttle){
		if(gear == 0) return 0;
		if(throttle < 0.001f){
			return gear < -1 ? gear + 1 : gear > 1 ? gear - 1 : gear;
		}
		float max = rpm_max * (throttle < 0.3 ? u_low : throttle < 0.7 ? u_mid : u_high);
		float min = rpm_max * (throttle < 0.3 ? d_low : throttle < 0.7 ? d_mid : d_high);
		boolean rev = gear < 0;
		if(rev) gear = -gear;
		if(rpm < min){
			gear = gear <= 1 ? 1 : gear - 1;
		}
		else if(rpm > max){
			int gears = (rev ? rgears.length : fgears.length);
			gear = gear >= gears ? gears : gear + 1;
		}
		return rev ? -gear : gear;
	}

	public int getShiftSpeed(){
		return shift_speed;
	}

}
