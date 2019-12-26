package net.fexcraft.mod.fvtm.sys.rail.vis;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;

public class Reltrs {
	
	private RailEntity entity;
	private VehicleData data;
	public final Long uid;
	
	public Reltrs(RailEntity entity, Long id){
		this.entity = entity; uid = entity == null ? id : entity.uid;
	}
	
	public Reltrs read(NBTTagCompound compound){
		if(entity == null){
			if(data == null){
				data = Resources.getVehicleData(compound);
			} else data.read(compound);
		} else entity.read(compound);
		return this;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		
		
		
		return compound;
	}
	
	public RailEntity ent(){
		return entity;
	}
	
	public VehicleData data(){
		return entity == null ? data : entity.vehdata;
	}

}
