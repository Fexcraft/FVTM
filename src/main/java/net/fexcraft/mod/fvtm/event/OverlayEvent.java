package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OverlayEvent extends Event {
	
	private VehicleEntity entity;
	private VehicleData data;
	private String selected;

	public OverlayEvent(VehicleEntity ent, VehicleData data){
		entity = ent;
		this.data = data;
		selected = data.getType().getOverlay();
	}
	
	public VehicleEntity getVehicleEntity(){
		return entity;
	}
	
	public VehicleData getVehicleData(){
		return data;
	}
	
	public String getOverlay(){
		return selected;
	}
	
	public void setOverlay(String overlay_id){
		selected = overlay_id;
	}

}
