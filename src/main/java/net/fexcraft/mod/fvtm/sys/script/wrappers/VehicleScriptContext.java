package net.fexcraft.mod.fvtm.sys.script.wrappers;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.entity.Entity;

public class VehicleScriptContext extends WrapperElm {
	
	private GenericVehicle entity;
	private VehicleData data;

	public VehicleScriptContext update(Entity entity, VehicleData data){
		this.entity = (GenericVehicle)entity;
		this.data = data;
		return this;
	}

	@Override
	public String string_val(){
		return "{vehicle-context}";
	}

}
