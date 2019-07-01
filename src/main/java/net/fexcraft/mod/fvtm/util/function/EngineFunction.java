package net.fexcraft.mod.fvtm.util.function;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.minecraft.nbt.NBTTagCompound;

public class EngineFunction extends Function {
	
	private float engine_speed, fuel_consumption;
	private boolean ison;

	public EngineFunction(JsonObject obj){
		super(obj); engine_speed = JsonUtil.getIfExists(obj, "engine_speed", 0.245f).floatValue();
		fuel_consumption = JsonUtil.getIfExists(obj, "fuel_consumption", 0.34f).floatValue();
	}

	public EngineFunction(float es, boolean io){
		super(null); engine_speed = es; ison = io;
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
	
	public float getLegacyFuelConsumption(){
		return fuel_consumption;
	}

	public boolean toggle(){
		return ison = !ison;
	}
	@Override
	public Function copy(){
		return new EngineFunction(engine_speed, ison);
	}

	public boolean setState(boolean bool){
		return ison = bool;
	}

	public boolean isOn(){
		return ison;
	}

}
