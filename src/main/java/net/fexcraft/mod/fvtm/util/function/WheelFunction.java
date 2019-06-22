package net.fexcraft.mod.fvtm.util.function;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.nbt.NBTTagCompound;

public class WheelFunction extends Function {
	
	private String inst_pos;
	private WheelSlot wheel;

	public WheelFunction(JsonObject obj){
		super(obj);
	}

	@Override
	public Function read(NBTTagCompound compound){
		inst_pos = compound.hasKey("wheel_pos") ? compound.getString("wheel_pos") : null;
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(inst_pos != null) compound.setString("wheel_pos", inst_pos);
		return compound;
	}
	
	public @Nullable WheelSlot getWheelPos(){
		return wheel;
	}
	
	public @Nullable WheelSlot getWheelPos(VehicleData vehicle){
		if(wheel != null) return wheel; if(inst_pos != null) return wheel = vehicle.getWheelPositions().get(inst_pos);
		return null;
	}

	@Override
	public String getId(){
		return "fvtm:wheel";
	}

	public void setWheel(String cat, WheelSlot slot){
		this.inst_pos = cat; wheel = slot;
	}

	@Override
	public Function copy(){
		return new WheelFunction(null);
	}

}
