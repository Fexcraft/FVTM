package net.fexcraft.mod.fvtm.util.function;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EngineFunction extends Function {
	
	private float engine_speed, fuel_consumption;
	private boolean ison;
	private String[] fuelgroup;

	public EngineFunction(JsonObject obj){
		super(obj);
		engine_speed = JsonUtil.getIfExists(obj, "engine_speed", 0.245f).floatValue();
		fuel_consumption = JsonUtil.getIfExists(obj, "fuel_consumption", 0.34f).floatValue();
		fuelgroup = DataUtil.getStringArray(obj, "fuel_group", false, false).toArray(new String[0]);
	}

	public EngineFunction(float es, boolean io, float fc, String[] fg){
		super(null); engine_speed = es; ison = io; this.fuel_consumption = fc; this.fuelgroup = fg;
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
		return new EngineFunction(engine_speed, ison, fuel_consumption, fuelgroup);
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

}
