package net.fexcraft.mod.fvtm.sys.rail.vis;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity.TRO;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;

public class Reltrs {
	
	private RailEntity entity;
	private VehicleData data;
	public final Long uid;
	public Track last, current;
	public double passed;
	public RailSystem sys;
	public double frbogiedis, rrbogiedis;
	
	public Reltrs(RailSystem system, RailEntity entity, Long id){
		this.entity = entity; uid = entity == null ? id : entity.uid; sys = system;
		frbogiedis = entity.frbogiedis;
		rrbogiedis = entity.rrbogiedis;
	}
	
	public Reltrs(RailSystem system, NBTTagCompound compound){
		uid = compound.getLong("UID"); sys = system;
		//current = sys.getTrack(new PathKey(compound));
		current = new Track(null).read(TagCW.wrap(compound.getCompoundTag("Track")));
		if(entity == null){
			if(data == null){
				//TODO data = Resources.getVehicleData(compound);
			}
			else data.read(new TagCWI(compound));
		}
		else entity.read(TagCW.wrap(compound));
		frbogiedis = compound.getDouble("fr_bogie");
		rrbogiedis = compound.getDouble("rr_bogie");
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound = entity.vehdata.write(new TagCWI(compound)).local();
		compound.setLong("UID", entity.uid);
		compound.setDouble("fr_bogie", frbogiedis);
		compound.setDouble("rr_bogie", frbogiedis);
		//entity.current.id.write(compound);
		compound.setTag("Track", entity.current.write(null).local());
		return compound;
	}
	
	public RailEntity ent(){
		return entity;
	}
	
	public VehicleData data(){
		return entity == null ? data : entity.vehdata;
	}

	public V3D moveOnly(double passed){
		TRO tro = getTrack(current, passed);
		return tro.track == null ? null : tro.track.getVectorPosition(tro.passed, false);
	}

	private TRO getTrack(Track track, double passed){
		if(track == null) return new TRO(track, passed);
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
