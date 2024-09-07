package net.fexcraft.mod.fvtm.function.part;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.sys.condition.CondMode;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EngineFunction extends PartFunction {
	
	private float engine_speed;
	private int idle_con, con;
	private TreeMap<String, Float> cons = new TreeMap<>();
	private boolean ison;
	private String[] fuelgroup;
	//
	private int min_rpm, max_rpm;
	private float[][] torque_chart;
	private float highest_torque;

	public EngineFunction(){}

	public EngineFunction(float es, boolean io, int ic, int c, TreeMap<String, Float> cs, String[] fg){
		engine_speed = es; ison = io; idle_con = ic; con = c; cons = cs; this.fuelgroup = fg;
	}

	@Override
	public String getId(){
		return "fvtm:engine";
	}

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		engine_speed = map.getFloat("engine_speed", 0.245f);
		idle_con = map.getInteger("idle_consumption", 1);
		con = map.getInteger("active_consumption", 1);
		fuelgroup = map.get("fuel_group").isArray() ? map.getArray("fuel_group").toStringArray() : new String[]{ map.getString("fuel_group", "diesel")};
		if(map.has("consumptions") && map.get("consumptions").isMap()){
			map.getMap("consumptions").entries().forEach(entry -> cons.put(entry.getKey(), entry.getValue().float_value()));
		}
		//
		if(!map.has("torque_chart")) return this;
		min_rpm = map.getInteger("min_rpm", 1000);
		max_rpm = map.getInteger("max_rpm", 6000);
		JsonMap tor = map.getMap("torque_chart");
		torque_chart = new float[tor.size()][2];
		TreeMap<Integer, Float> tree = new TreeMap<>();
		for(Entry<String, JsonValue<?>> entry : tor.entries()){
			tree.put(Integer.parseInt(entry.getKey()), entry.getValue().float_value());
		}
		int index = 0;
		for(Map.Entry<Integer, Float> entry : tree.entrySet()){
			torque_chart[index][0] = entry.getKey();
			torque_chart[index++][1] = entry.getValue();
			if(entry.getValue() > highest_torque) highest_torque = entry.getValue();
		}
		//TODO validation, e.g. check if there are at least 2 entries
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		ison = compound.getBoolean("IsOn");
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
		compound.set("IsOn", ison);
		return compound;
	}
	
	public float getSphEngineSpeed(){
		return engine_speed;
	}

	public boolean toggle(){
		return ison = !ison;
	}
	
	@Override
	public PartFunction copy(Part part){
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
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
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
	public boolean onCondition(String[] targets, CondMode mode, String condi){
		if(mode.equals("on")) return ison;
		else if(mode.equals("off")) return !ison;
		else return ison = Boolean.parseBoolean(condi);
	}

}
