package net.fexcraft.mod.fvtm.sys.rail;

import java.util.UUID;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * First prototype of RailEntity system.
 * 
 * 30/August/2019
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailEntity {
	
	public Track current;
	public RailVehicle entity;
	public long uid, fcid, rcid;
	public RailRegion region;
	public boolean active, forward = true;
	public float throttle, passed;
	public Vec3f pos = new Vec3f(), prev = new Vec3f(),
		cfront = new Vec3f(), crear = new Vec3f(),
		bfront = new Vec3f(), brear = new Vec3f();
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	public RailEntity front_coupler, rear_coupler;
	public VehicleData vehdata;
	public float frbogiedis, rrbogiedis, frconndis, rrconndis, length; 
	//
	private short lastcheck = 0;//for entity despawn/spawning;
	
	public RailEntity(RailData data, VehicleData vdata, Track track, UUID placer){
		current = track; region = data.getRegions().get(track.start, true); if(placer != null) this.placer = placer;
		uid = data.getNewEntityId(); data.updateEntityEntry(uid, region.getKey()); vehdata = vdata;
		frbogiedis = (float)vdata.getWheelPositions().get("bogie_front").x;
		rrbogiedis  = (float)-vdata.getWheelPositions().get("bogie_rear").x;
		frconndis = (float)vdata.getFrontConnector().x; rrconndis = (float)-vdata.getRearConnector().x;
		cfront = track.getVectorPosition(rrconndis + frconndis, false);
		bfront = track.getVectorPosition(rrconndis + frbogiedis, false);
		pos = track.getVectorPosition(rrconndis, false);
		brear = track.getVectorPosition(rrconndis - rrbogiedis, false);
		crear = track.getVectorPosition(0, false);
		region.spawnEntity(this);
	}

	/** only to use with read() afterwards */
	public RailEntity(RailRegion railregion){
		region = railregion;
	}

	public long getUID(){
		return uid;
	}

	public RailRegion getRegion(){
		return region;
	}
	
	public void onUpdate(){
		if(!region.getWorld().getWorld().isRemote){
			checkIfShouldHaveEntity();
			//
			//TODO collision/path check
			TRO tro = getTrack(current, passed + (forward ? throttle : -throttle));//TODO calc via engine speed
			current = tro.track; passed = tro.passed;
			if(!region.isInRegion(current.start)) this.updateRegion(current.start);
			prev.copyFrom(pos); pos = move(passed);
			cfront = move(passed + frconndis);
			bfront = move(passed + frbogiedis);
			crear = move(passed - rrconndis);
			brear = move(passed - rrbogiedis);
			//Print.debug(prev, pos, prev.distanceTo(pos));
		}
		//
		region.getWorld().updateEntityEntry(uid, region.getKey());
	}

	private void updateRegion(Vec316f start){
		region.getEntities().remove(uid);
		region = region.getWorld().getRegions().get(RailData.getRegionXZ(start), true);
		region.getEntities().put(uid, this);
	}

	private Vec3f move(float passed){
		TRO tro = getTrack(current, passed); return tro.track.getVectorPosition(tro.passed, false);
	}

	private TRO getTrack(Track track, float passed){
		while(passed > track.length){
			Junction junk = region.getJunction(track.end);
			if(junk == null) new TRO(track, track.length);
			Track newtrack = junk.getNext(track.getOppositeId());
			if(newtrack != null){
				passed -= track.length; track = newtrack;
			} else return new TRO(track, track.length);
		}
		while(passed < 0){
			Junction junk = region.getJunction(track.start);
			if(junk == null) return new TRO(track, 0);
			Track newtrack = junk.getNext(track.getId());
			if(newtrack != null){
				passed += newtrack.length; track = newtrack.createOppositeCopy();
			} else return new TRO(track, 0);
			
		} return new TRO(track, passed);
	}
	
	private static class TRO {//track return object
		public TRO(Track track, float passed){
			this.track = track; this.passed = passed;
		} Track track; float passed;
	}

	private void checkIfShouldHaveEntity(){
		if(lastcheck > 0){ lastcheck--; return; }
		if(entity != null){
			if(entity.seats != null) for(SeatEntity seat : entity.seats)
				if(seat != null && seat.hasPassenger()){ lastcheck = 300; return; }
			if(isInPlayerRange()){ lastcheck = 300; return; }
			entity.setDead(); entity = null; lastcheck = 300; return;
		}
		else{
			if(!isInPlayerRange()){ lastcheck = 300; return; }
			region.getWorld().getWorld().spawnEntity(new RailVehicle(this));
		}
	}

	private boolean isInPlayerRange(){
		for(EntityPlayer pl : region.getWorld().getWorld().playerEntities){
			if(pos.distanceTo(new Vec3f(pl.posX, pl.posY, pl.posZ)) < 256) return true;
		} return false;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setLong("uid", uid);
		compound.setTag("track", current.write(null));
		compound.setTag("pos", DataUtil.writeVec3f(pos));
		compound.setTag("prev", DataUtil.writeVec3f(prev));
		compound.setTag("cfront", DataUtil.writeVec3f(cfront));
		compound.setTag("bfront", DataUtil.writeVec3f(bfront));
		compound.setTag("crear", DataUtil.writeVec3f(crear));
		compound.setTag("brear", DataUtil.writeVec3f(brear));
		compound.setBoolean("forward", forward);
		compound.setLong("Placer0", placer.getMostSignificantBits());
		compound.setLong("Placer1", placer.getLeastSignificantBits());
		return vehdata.write(compound);
	}
	
	public RailEntity read(NBTTagCompound compound){
		uid = compound.getLong("uid");
		current = new Track().read(compound.getCompoundTag("track"));
		pos = DataUtil.readVec3f(compound.getTag("pos"));
		prev = DataUtil.readVec3f(compound.getTag("prev"));
		cfront = DataUtil.readVec3f(compound.getTag("cfront"));
		bfront = DataUtil.readVec3f(compound.getTag("bfront"));
		crear = DataUtil.readVec3f(compound.getTag("crear"));
		brear = DataUtil.readVec3f(compound.getTag("brear"));
		forward = compound.hasKey("forward") ? compound.getBoolean("forward") : true;
		placer = new UUID(compound.getLong("Placer0"), compound.getLong("Placer1"));
		if(vehdata == null) vehdata = Resources.getVehicleData(compound);
		else vehdata.read(compound);
		//
		frbogiedis = (float)vehdata.getWheelPositions().get("bogie_front").x;
		rrbogiedis  = (float)-vehdata.getWheelPositions().get("bogie_rear").x;
		frconndis = (float)vehdata.getFrontConnector().x;
		rrconndis = (float)-vehdata.getRearConnector().x;
		//
		return this;
	}

	public void alignEntity(boolean initial){
		if(entity == null) return;
		if(initial){
			entity.prevPosX = entity.lastTickPosX = entity.posX = pos.xCoord;
			entity.prevPosY = entity.lastTickPosY = entity.posY = pos.yCoord;
			entity.prevPosZ = entity.lastTickPosZ = entity.posZ = pos.zCoord;
	        entity.setEntityBoundingBox(new AxisAlignedBB(pos.xCoord - 0.25, pos.yCoord, pos.zCoord - 0.25,
	        	pos.xCoord + 0.25, pos.yCoord + 0.25, pos.zCoord + 0.25));
		}
		else{ entity.setPosition(pos.xCoord, pos.yCoord, pos.zCoord); }
	}

	public void dispose(){
		if(front_coupler != null)
			if(front_coupler.front_coupler == this) front_coupler.front_coupler = null;
			else front_coupler.rear_coupler = null;
		if(rear_coupler != null)
			if(rear_coupler.front_coupler == this) rear_coupler.front_coupler = null;
			else rear_coupler.rear_coupler = null;
		region.getWorld().delEntity(this); if(entity != null && !entity.isDead) entity.setDead();
	}

	public UUID getPlacer(){
		return placer;
	}

}
