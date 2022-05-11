package net.fexcraft.mod.fvtm.util.function;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EngineFunction extends Function {
	
	private float engine_speed;
	private int idle_con, con;
	private TreeMap<String, Float> cons = new TreeMap<>();
	private boolean ison;
	private String[] fuelgroup;
	//
	private int min_rpm, max_rpm;
	private float[][] torque_chart;
	private float highest_torque;

	public EngineFunction(Part part, JsonObject obj){
		super(part, obj);
		engine_speed = JsonUtil.getIfExists(obj, "engine_speed", 0.245f).floatValue();
		idle_con = JsonUtil.getIfExists(obj, "idle_consumption", 1).intValue();
		con = JsonUtil.getIfExists(obj, "active_consumption", 1).intValue();
		fuelgroup = DataUtil.getStringArray(obj, "fuel_group", false, false).toArray(new String[0]);
		if(obj.has("consumptions") && obj.get("consumptions").isJsonObject()){//todo find better naming
			obj.get("consumptions").getAsJsonObject().entrySet().forEach(entry -> cons.put(entry.getKey(), entry.getValue().getAsFloat()));
		}
		//
		if(!obj.has("torque_chart")) return;
		min_rpm = JsonUtil.getIfExists(obj, "min_rpm", 1000).intValue();
		max_rpm = JsonUtil.getIfExists(obj, "max_rpm", 6000).intValue();
		JsonObject tor = obj.get("torque_chart").getAsJsonObject();
		torque_chart = new float[tor.size()][2];
		TreeMap<Integer, Float> map = new TreeMap<>();
		for(Map.Entry<String, JsonElement> entry : tor.entrySet()){
			map.put(Integer.parseInt(entry.getKey()), entry.getValue().getAsFloat());
		}
		int index = 0;
		for(Map.Entry<Integer, Float> entry : map.entrySet()){
			torque_chart[index][0] = entry.getKey();
			torque_chart[index++][1] = entry.getValue();
			if(entry.getValue() > highest_torque) highest_torque = entry.getValue();
		}
		//TODO validation, e.g. check if there are at least 2 entries
	}

	public EngineFunction(float es, boolean io, int ic, int c, TreeMap<String, Float> cs, String[] fg){
		super(null, null); engine_speed = es; ison = io; idle_con = ic; con = c; cons = cs; this.fuelgroup = fg;
	}

	@Override
	public String getId(){
		return "fvtm:engine";
	}

	@Override
	public Function read(NBTTagCompound compound){
		ison = compound.getBoolean("IsOn");
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setBoolean("IsOn", ison);
		return compound;
	}
	
	public float getLegacyEngineSpeed(){
		return engine_speed;
	}

	public boolean toggle(){
		return ison = !ison;
	}
	
	@Override
	public Function copy(Part part){
		EngineFunction func = new EngineFunction(engine_speed, ison, idle_con, con, cons, fuelgroup);
		func.min_rpm = min_rpm;
		func.max_rpm = max_rpm;
		func.torque_chart = torque_chart;
		func.highest_torque = highest_torque;
		return func;
	}

	public boolean setState(boolean bool){
		return ison = bool;
	}

	public boolean isOn(){
		return ison;
	}

	public String[] getFuelGroup(){
		return fuelgroup;
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
    	for(String str : fuelgroup){
            tooltip.add(Formatter.format("&9Engine Fuel: &7" + str));
    	}
    	if(torque_chart != null){
            tooltip.add(Formatter.format("&9Range: &7" + min_rpm + "-" + max_rpm + " rpm"));
            tooltip.add(Formatter.format("&9Torque: &7" + torque_chart[0][1] + "-" + highest_torque));
    	}
    	else{
            tooltip.add(Formatter.format("&8&oLegacy Engine, not U12/Basic Compatible."));
    	}
    }

	public float getFuelConsumption(String fuel_branch){
		return cons.containsKey(fuel_branch) ? cons.get(fuel_branch) : con;
	}

	public int getIdleFuelConsumption(){
		return idle_con;
	}
	
	public int minRPM(){
		return min_rpm;
	}
	
	public int maxRPM(){
		return max_rpm;
	}
	
	public float[][] getTorqueChart(){
		return torque_chart;
	}
	
	public float getTorque(int rpm){
		if(rpm <= min_rpm) return torque_chart[0][1];
		if(rpm >= max_rpm) return torque_chart[torque_chart.length - 1][1];
		float[] last, curr = torque_chart[0];
		for(int i = 1; i < torque_chart.length; i++){
			last = curr; curr = torque_chart[i];
			if(rpm >= last[0] && rpm < curr[0]){
				float diff = curr[0] - last[0];
				float rrpm = rpm - last[0];
				diff = rrpm / diff;
				return last[1] + (diff * (curr[1] - last[1]));
			}
			if(i != torque_chart.length - 1) continue;
			else return curr[1];
		}
		return 0;
	}
	
	@Override
	public boolean onCondition(String[] targets, String mode, String condi){
		if(mode.equals("on")) return ison;
		else if(mode.equals("off")) return !ison;
		else return ison = Boolean.parseBoolean(condi);
	}

}
