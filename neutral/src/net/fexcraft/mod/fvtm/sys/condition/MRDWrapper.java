package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.sys.event.EventData;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MRDWrapper extends EventData {

	public static MRDWrapper WRAPPER = new MRDWrapper();

	public EventData update(ModelRenderData data){
		vehent = data.vehent();
		if(vehent == null){
			entity = null;
			vehicle = null;
		}
		else{
			entity = vehent.entity;
			vehicle = vehent.data;
		}
		block_entity = data.block_entity();
		return this;
	}

	public EventData set(VehicleInstance veh){
		vehent = veh;
		vehicle = veh.data;
		entity = veh.entity;
		return this;
	}

}
