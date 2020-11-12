package net.fexcraft.mod.fvtm.util.function;

import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TireFunction extends Function {
	
	private String inst_on;
	private WheelSlot wheel;

	public TireFunction(Part part, JsonObject obj){
		super(part, obj);
	}

	@Override
	public Function read(NBTTagCompound compound){
		inst_on = compound.hasKey("wheel_on") ? compound.getString("wheel_on") : null;
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(inst_on != null) compound.setString("wheel_on", inst_on);
		return compound;
	}
	
	public @Nullable WheelSlot getWheelPos(){
		return wheel;
	}
	
	public @Nullable WheelSlot getWheelPos(VehicleData vehicle){
		if(wheel != null) return wheel;
		if(inst_on != null) return wheel = vehicle.getWheelSlots().get(inst_on);
		return null;
	}

	@Override
	public String getId(){
		return "fvtm:wheel";
	}

	public void setWheel(String cat, WheelSlot slot){
		this.inst_on = cat; wheel = slot;
	}

	@Override
	public Function copy(Part part){
		return new TireFunction(part, null);
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
    	WheelData wdata = data.getType().getInstallationHandlerData();
        tooltip.add(Formatter.format("&9Tire Radius: &7" + wdata.getRadius()));
        tooltip.add(Formatter.format("&9Tire Width: &7" + wdata.getWidth()));
    }

}
