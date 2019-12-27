package net.fexcraft.mod.fvtm.sys.rail.vis;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity.TRO;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;

public class Reltrs {
	
	private RailEntity entity;
	private VehicleData data;
	public final Long uid;
	public Track last, current;
	public float passed;
	public RailSys sys;
	public float frbogiedis, rrbogiedis;
	
	public Reltrs(RailSys system, RailEntity entity, Long id){
		this.entity = entity; uid = entity == null ? id : entity.uid; sys = system;
		frbogiedis = entity.frbogiedis; rrbogiedis = entity.rrbogiedis;
	}
	
	public Reltrs(RailSys system, NBTTagCompound compound){
		uid = compound.getLong("UID"); sys = system;
		current = sys.getTrack(new PathKey(compound));
		if(entity == null){
			if(data == null){
				data = Resources.getVehicleData(compound);
			} else data.read(compound);
		} else entity.read(compound);
		frbogiedis = compound.getFloat("fr_bogie");
		rrbogiedis = compound.getFloat("rr_bogie");
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound = entity.vehdata.write(compound);
		compound.setLong("UID", entity.uid);
		compound.setFloat("fr_bogie", frbogiedis);
		compound.setFloat("rr_bogie", frbogiedis);
		entity.current.id.write(compound);
		return compound;
	}
	
	public RailEntity ent(){
		return entity;
	}
	
	public VehicleData data(){
		return entity == null ? data : entity.vehdata;
	}

	public Vec3f moveOnly(float passed){
		TRO tro = getTrack(current, passed); return tro.track.getVectorPosition(tro.passed, false);
	}

	private TRO getTrack(Track track, float passed){
		while(passed > track.length){
			Junction junk = sys.getJunction(track.end);
			if(junk == null){ new TRO(track, track.length); }
			Track newtrack = junk.getNext(null, track.getOppositeId(), false);
			if(newtrack != null){
				passed -= track.length; track = newtrack;
			} else return new TRO(track, track.length);
		}
		while(passed < 0){
			Junction junk = sys.getJunction(track.start);
			if(junk == null){ return new TRO(track, 0); }
			Track newtrack = junk.getNext(null, track.getId(), false);
			if(newtrack != null){
				passed += newtrack.length; track = newtrack.createOppositeCopy();
			} else return new TRO(track, 0);
			
		} return new TRO(track, passed);
	}

	public void updatePosition(){
		// TODO Auto-generated method stub
		
	}

}
