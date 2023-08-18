package net.fexcraft.mod.fvtm.util.function;

import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class WheelFunction extends Function {
	
	private String inst_pos;
	private WheelSlot wheel;

	public WheelFunction(Part part, JsonObject obj){
		super(part, obj);
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
		if(wheel != null) return wheel;
		if(inst_pos != null) return wheel = vehicle.getWheelSlots().get(inst_pos);
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
	public Function copy(Part part){
		return new WheelFunction(part, null);
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
    	WheelData wdata = data.getType().getInstallationHandlerData();
        tooltip.add(Formatter.format("&9Wheel Radius: &7" + wdata.getRadius()));
        tooltip.add(Formatter.format("&9Wheel Width: &7" + wdata.getWidth()));
    }

}
