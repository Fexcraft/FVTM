package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.MiniBB;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
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
public class RailEntity implements Comparable<RailEntity>{
	
	public Track current, last;
	public RailVehicle entity;
	public long uid;
	public RailRegion region;
	private boolean active, forward = true;
	public float throttle, passed;
	public Vec3f pos = new Vec3f(), prev = new Vec3f(),
		cfront = new Vec3f(), crear = new Vec3f(),
		bfront = new Vec3f(), brear = new Vec3f();
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	public Coupler front = new Coupler(this), rear = new Coupler(this);
	public VehicleData vehdata;
	public float frbogiedis, rrbogiedis, frconndis, rrconndis, length, push_rq, pull_rq;
	public Section[] sectionson = new Section[4];
	//
	private short lastcheck = 20;//for entity despawn/spawning;
	private static final short interval = 100;//300
	private MiniBB ccalc = new MiniBB();
	
	public RailEntity(RailData data, VehicleData vdata, Track track, UUID placer){
		current = track; region = data.getRegions().get(track.start, true); if(placer != null) this.placer = placer;
		uid = data.getNewEntityId(); data.updateEntityEntry(uid, region.getKey()); vehdata = vdata;
		frbogiedis = (float)vdata.getWheelPositions().get("bogie_front").x;
		rrbogiedis  = (float)-vdata.getWheelPositions().get("bogie_rear").x;
		frconndis = (float)vdata.getFrontConnector().x; rrconndis = (float)-vdata.getRearConnector().x;
		//
		bfront = move(rrconndis + frbogiedis, TrainPoint.BOGIE_FRONT);
		brear = move(rrconndis - rrbogiedis, TrainPoint.BOGIE_REAR);
		pos = medium(bfront, brear); push_rq = 0.002f;
		cfront = move(rrconndis + frconndis, TrainPoint.COUPLER_FRONT);
		crear = move(0, TrainPoint.COUPLER_REAR);
		front.mbb.update(cfront, 0.125f); rear.mbb.update(crear, 0.125f);
		//
		region.spawnEntity(this);
	}

	private Vec3f medium(Vec3f vec0, Vec3f vec1){
		return new Vec3f((vec0.xCoord + vec1.xCoord) * 0.5f, (vec0.yCoord + vec1.yCoord) * 0.5f, (vec0.zCoord + vec1.zCoord) * 0.5f);
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
			if(current == null) this.dispose();
			checkIfShouldHaveEntity();
			//
			float am = vehdata.getType().isTrailerOrWagon() ? 0 : throttle * vehdata.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").getLegacyEngineSpeed();
			if(!forward) am = -am; am += push_rq + pull_rq;
			//if(am != 0f && (am > 0.001 || am < -0.001)){//prevents unnecessary calculations
				TRO tro = getTrack(current, passed + am); boolean coupled = false;
				//
				if(!front.hasEntity() || !rear.hasEntity()){
					Collection<RailEntity> ents = getEntitiesOnTrackAndNext(tro.track, forward);
					Coupler[] couplers = new Coupler[]{ front, rear };
					for(int i = 0; i < 2; i++){
						if(couplers[i].hasEntity()) continue; Vec3f coucen = i == 0 ? cfront : crear;
						for(RailEntity ent : ents){
							if(ent == this || ent == front.entity || ent == rear.entity) continue;
							ccalc.update(ent.cfront, ent.crear, 0.125f); if(!ccalc.contains(coucen)) continue;
							if(ent.rear.mbb.contains(coucen)){
								float entpos = ent.pos.distanceTo(pos);
								float coupos = ent.crear.distanceTo(pos);
								if(entpos < coupos) continue;//we're probably inside the other entity, abort!
								coupled = true; couplers[i].couple(ent, false, false); am = coucen.distanceTo(ent.crear); 
								if(ent.brear.distanceTo(coucen) < ent.crear.distanceTo(coucen)) am = -am;
								Print.debug("coupling " + (i == 0 ? "front" : "rear") + " to rear");
							}
							if(ent.front.mbb.contains(coucen)){
								float entpos = ent.pos.distanceTo(pos);
								float coupos = ent.cfront.distanceTo(pos);
								if(entpos < coupos) continue;//upon testing, we're for sure in the other entity
								coupled = true; couplers[i].couple(ent, true, false); am = coucen.distanceTo(ent.cfront);
								if(ent.bfront.distanceTo(coucen) < ent.cfront.distanceTo(coucen)) am = -am;
								Print.debug("coupling " + (i == 0 ? "front" : "rear") + " to front");
							}
						}//TODO align the freshly connected entities
					}
					/*float fc = ent.cfront.distanceTo(coupler0), rc = ent.crear.distanceTo(coupler0);
					if(fc > abs && rc > abs) continue;
					else if(fc < rc){//front
						Print.debugChat("coupling " + (am > 0 ? "front" : "rear") + " to front");
						(am > 0 ? front : rear).couple(ent, true, false); coupled = true;
						if(ent.bfront.distanceTo(coupler0) > fc){
							ent.push_rq -= abs - fc; am = am > 0 ? fc : -fc;
						} else{ ent.push_rq -= abs; am -= am > 0 ? abs - fc : -(abs - fc); }
					}
					else if(rc < fc){//rear
						Print.debugChat("coupling " + (am > 0 ? "front" : "rear") + " to rear");
						(am > 0 ? front : rear).couple(ent, false, false); coupled = true;
						if(ent.brear.distanceTo(coupler0) > rc){
							ent.push_rq += abs - rc; am -= am > 0 ? rc : -rc;
						} else{ ent.push_rq += abs; am -= am > 0 ? abs - rc : -(abs - rc); }
					}*/
				}
				if(!coupled){
					if(am > 0){//front
						if(rear.hasEntity()){
							if(rear.coupled){
								rear.entity.pull_rq += rear.isFront() ? am : -am;
							} else if(!rear.inRange()){ Print.debug("decoupling rear"); rear.decouple(); }
						}
						if(front.hasEntity()){
							front.entity.push_rq += front.isFront() ? -am : am;
						}
					}
					else{//rear
						if(front.hasEntity()){
							if(front.coupled){
								front.entity.pull_rq -= front.isFront() ? am : -am;
							} else if(!front.inRange()){ Print.debug("decoupling front"); front.decouple(); }
						}
						if(rear.hasEntity()){
							rear.entity.push_rq -= rear.isFront() ? -am : am;
						}
					}
					tro = getTrack(current, passed + am);
				} else tro = getTrack(current, passed);
				//
				pull_rq = 0; push_rq = 0;
				//
				last = current; current = tro.track; passed = tro.passed;
				if(!last.equals(current)) this.updateClient("track"); this.updateClient("passed");
				if(!region.isInRegion(current.start)) this.updateRegion(current.start);
				updatePosition();
				//net.fexcraft.lib.mc.utils.Print.debug(pos, bfront, brear);
			//}
		}
		//
		region.getWorld().updateEntityEntry(uid, region.getKey());
	}

	public void updatePosition(){
		bfront = move(passed, TrainPoint.BOGIE_FRONT);
		brear = move(passed - frbogiedis - rrbogiedis, TrainPoint.BOGIE_REAR);
		cfront = move(passed + (frconndis - frbogiedis), TrainPoint.COUPLER_FRONT);
		crear = move(passed - frbogiedis - rrconndis, TrainPoint.COUPLER_REAR);
		prev.copyFrom(pos); pos = medium(bfront, brear);
		front.mbb.update(cfront, 0.125f); rear.mbb.update(crear, 0.125f);
	}

	private ArrayList<RailEntity> railentlist = new ArrayList<>();

	private ArrayList<RailEntity> getEntitiesOnTrackAndNext(Track track, boolean forward){
		railentlist.clear(); railentlist.addAll(track.section.getEntities().values());
		Junction junction = region.getJunction(track.start); Track track0;
		if(junction != null){ track0 = junction.getNext(track.getId());
			if(track0 != null)railentlist.addAll(track0.section.getEntities().values());
		}
		junction = region.getJunction(track.end);
		if(junction != null){ track0 = junction.getNext(track.getOppositeId());
			if(track0 != null)railentlist.addAll(track0.section.getEntities().values());
		} return railentlist;
	}

	private void updateClient(String string){
		if(entity == null) return; NBTTagCompound compound = new NBTTagCompound();
		switch(string){
			case "track":{
				compound.setString("task", "update_track"); current.getId().write(compound);
				break;
			}
			case "passed":{
				compound.setString("task", "update_passed");
				compound.setFloat("passed", passed);
				break;
			}
		}
		ApiUtil.sendEntityUpdatePacketToAllAround(entity, compound);
	}

	protected void updateRegion(Vec316f start){
		region.getEntities().remove(uid);
		region = region.getWorld().getRegions().get(RailData.getRegionXZ(start), true);
		region.getEntities().put(uid, this);
	}

	public Vec3f move(float passed, TrainPoint point){
		TRO tro = getTrack(current, passed);
		if(sectionson[point.index] == null){
			(sectionson[point.index] = tro.track.section).update(this, true);
		}
		else{
			sectionson[point.index].update(this, false);
			(sectionson[point.index] = tro.track.section).update(this, true);
		}
		return tro.track.getVectorPosition(tro.passed, false);
	}

	public Vec3f moveOnly(float passed){
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
	
	public static class TRO {//track return object
		public TRO(Track track, float passed){
			this.track = track; this.passed = passed;
		} Track track; float passed;
	}

	private void checkIfShouldHaveEntity(){
		if(lastcheck > 0){ lastcheck--; return; }
		if(entity != null){
			if(entity.seats != null) for(SeatEntity seat : entity.seats)
				if(seat != null && seat.hasPassenger()){ lastcheck = interval; return; }
			if(isInPlayerRange()){ lastcheck = interval; return; }
			entity.setDead(); entity = null; lastcheck = interval; return;
		}
		else{
			if(!isInPlayerRange()){ lastcheck = interval; return; }
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
		current.getId().write(compound);
		compound.setTag("pos", DataUtil.writeVec3f(pos));
		compound.setTag("prev", DataUtil.writeVec3f(prev));
		compound.setTag("cfront", DataUtil.writeVec3f(cfront));
		compound.setTag("bfront", DataUtil.writeVec3f(bfront));
		compound.setTag("crear", DataUtil.writeVec3f(crear));
		compound.setTag("brear", DataUtil.writeVec3f(brear));
		compound.setBoolean("forward", forward);
		compound.setFloat("passed", passed);
		compound.setLong("Placer0", placer.getMostSignificantBits());
		compound.setLong("Placer1", placer.getLeastSignificantBits());
		if(front.entity != null && front.coupled){
			compound.setLong("front_coupled", front.entity.uid);
			compound.setBoolean("front_coupler", front.isFront());
		}
		if(rear.entity != null && rear.coupled){
			compound.setLong("rear_coupled", rear.entity.uid);
			compound.setBoolean("rear_coupler", rear.isFront());
		}
		return vehdata.write(compound);
	}
	
	public RailEntity read(NBTTagCompound compound){
		uid = compound.getLong("uid");
		current = region.getTrack(new Track.TrackKey(compound));
		pos = DataUtil.readVec3f(compound.getTag("pos"));
		prev = DataUtil.readVec3f(compound.getTag("prev"));
		cfront = DataUtil.readVec3f(compound.getTag("cfront"));
		bfront = DataUtil.readVec3f(compound.getTag("bfront"));
		crear = DataUtil.readVec3f(compound.getTag("crear"));
		brear = DataUtil.readVec3f(compound.getTag("brear"));
		forward = compound.hasKey("forward") ? compound.getBoolean("forward") : true;
		passed = compound.getFloat("passed");
		placer = new UUID(compound.getLong("Placer0"), compound.getLong("Placer1"));
		if(vehdata == null) vehdata = Resources.getVehicleData(compound);
		else vehdata.read(compound);
		//if(compound.hasKey("front_coupled")) loadCouple(true, compound.getLong("front_coupled"), compound.getBoolean("front_coupler"));
		//if(compound.hasKey("rear_coupled")) loadCouple(false, compound.getLong("rear_coupled"), compound.getBoolean("rear_coupler"));
		//TODO try coupling later, to prevent overflow
		//
		frbogiedis = (float)vehdata.getWheelPositions().get("bogie_front").x;
		rrbogiedis  = (float)-vehdata.getWheelPositions().get("bogie_rear").x;
		frconndis = (float)vehdata.getFrontConnector().x;
		rrconndis = (float)-vehdata.getRearConnector().x;
		//
		this.updatePosition(); return this;
	}

	public void loadCouple(boolean frontcoupler, long uid, boolean asfront){
		RailEntity ent = region.getWorld().getEntity(uid, true); if(ent == null) return;
		Coupler coupler = frontcoupler ? front : rear; coupler.coupled = true; coupler.entity = ent;
		coupler = asfront ? ent.front : ent.rear; coupler.coupled = true; coupler.entity = this;
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
		Print.debug("Disposing of TrackEntity " + uid + "!"); front.decouple(); rear.decouple();
		region.getWorld().delEntity(this); if(entity != null && !entity.isDead) entity.setDead();
	}

	public UUID getPlacer(){
		return placer;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof RailEntity == false) return false;
		return ((RailEntity)obj).getUID() == this.getUID();
	}
	
	@Override
	public int compareTo(RailEntity obj){
		return Long.compare(obj.getUID(), getUID());
	}
	
	public static enum TrainPoint {
		COUPLER_FRONT(0), BOGIE_FRONT(1), BOGIE_REAR(2), COUPLER_REAR(3); int index; TrainPoint(int idx){ this.index = idx; }
	}

	public void tryCoupling(EntityPlayer player, boolean thefront){
		Coupler coupler = thefront ? front : rear; Vec3f vec = thefront ? cfront : crear;
		if(coupler.hasEntity() && coupler.coupled){
			coupler.decouple(); Print.chat(player, (thefront ? "Front" : "Rear") + " disconnected.");
		}
		else{
			Collection<RailEntity> ents = getEntitiesOnTrackAndNext(current, forward);
			RailEntity found = null;
			for(RailEntity ent : ents){
				Print.debug(ent.vehdata.getType().getName());
				if(ent.uid == this.uid) continue;
				if(ent.rear.mbb.contains(vec)){
					found = ent; coupler.couple(ent, false, true); break;
					//TODO push/pull the moved entity / or this
				}
				if(ent.front.mbb.contains(vec)){
					found = ent; coupler.couple(ent, true, true); break;
					//TODO push/pull the moved entity / or this
				}
			}
			if(found != null){
				Print.chat(player, (thefront ? "Front" : "Rear") + " connected.");
				Print.chat(player, "&7&o" + found.vehdata.getType().getName());
			}
			else{
				Print.chat(player, "Nothing found to connect to.");
			}
		}
	}

	public MiniBB[] getCouplerMBBs(){
		return new MiniBB[]{ front.mbb, rear.mbb };
	}

	public void setForward(boolean bool){
		vehdata.getAttribute("forward").setValue(forward = bool);
		if(entity != null && !region.getWorld().getWorld().isRemote){
			NBTTagCompound packet = new NBTTagCompound(); packet.setString("target_listener", "fvtm:gui");
			packet.setString("task", "attr_update"); packet.setString("attr", "forward");
			packet.setString("value", vehdata.getAttribute("forward").getBooleanValue() + "");
			packet.setInteger("entity", entity.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		}
	}

	public void setActive(boolean bool){
		vehdata.getAttribute("active").setValue(active = bool);
		if(entity != null && !region.getWorld().getWorld().isRemote){
			NBTTagCompound packet = new NBTTagCompound(); packet.setString("target_listener", "fvtm:gui");
			packet.setString("task", "attr_update"); packet.setString("attr", "active");
			packet.setString("value", vehdata.getAttribute("active").getBooleanValue() + "");
			packet.setInteger("entity", entity.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		}
	}
	
	public boolean isHeadingForward(){
		return forward;
	}
	
	public boolean isActive(){
		return active;
	}

}
