package net.fexcraft.mod.fvtm.util.function;

import java.util.List;
import java.util.TreeMap;

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

	public EngineFunction(Part part, JsonObject obj){
		super(part, obj);
		engine_speed = JsonUtil.getIfExists(obj, "engine_speed", 0.245f).floatValue();
		idle_con = JsonUtil.getIfExists(obj, "idle_consumption", 1).intValue();
		con = JsonUtil.getIfExists(obj, "active_consumption", 1).intValue();
		fuelgroup = DataUtil.getStringArray(obj, "fuel_group", false, false).toArray(new String[0]);
		if(obj.has("consumptions") && obj.get("consumptions").isJsonObject()){//todo find better naming
			obj.get("consumptions").getAsJsonObject().entrySet().forEach(entry -> cons.put(entry.getKey(), entry.getValue().getAsFloat()));
		}
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
		return new EngineFunction(engine_speed, ison, idle_con, con, cons, fuelgroup);
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
    }

	public float getFuelConsumption(String fuel_branch){
		return cons.containsKey(fuel_branch) ? cons.get(fuel_branch) : con;
	}

	public int getIdleFuelConsumption(){
		return idle_con;
	}

}
