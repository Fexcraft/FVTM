package net.fexcraft.mod.fvtm.function.part;

import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelFunction extends PartFunction implements GetWheelPos {
	
	private String inst_pos;
	private WheelSlot wheel;

	@Override
	public PartFunction init(Part part, FJson json){
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		inst_pos = compound.has("wheel_pos") ? compound.getString("wheel_pos") : null;
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
		if(inst_pos != null) compound.set("wheel_pos", inst_pos);
		return compound;
	}

	@Override
	public WheelSlot getWheelPos(VehicleData vehicle){
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
	public PartFunction copy(Part part){
		return new WheelFunction().init(part, null);
	}

    @Override
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
    	WheelData wdata = data.getType().getInstallHandlerData();
        tooltip.add(Formatter.format("&9Wheel Radius: &7" + wdata.getRadius()));
        tooltip.add(Formatter.format("&9Wheel Width: &7" + wdata.getWidth()));
    }

}
