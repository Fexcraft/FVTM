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
import net.fexcraft.mod.fvtm.sys.rail.cmds.JEC;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.MiniBB;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
	protected boolean forward = true;
	public float throttle, passed;
	public Vec3f pos = new Vec3f(), prev = new Vec3f(),
		cfront = new Vec3f(), crear = new Vec3f(),
		bfront = new Vec3f(), brear = new Vec3f();
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	public Coupler front = new Coupler(this, true), rear = new Coupler(this, false);
	public VehicleData vehdata;
	public float frbogiedis, rrbogiedis, frconndis, rrconndis, length, moverq;//push_rq, pull_rq;
	public Section[] sectionson = new Section[4];
	//
	private short lastcheck = 20;//for entity despawn/spawning;
	private static final short interval = 100;//300
	private MiniBB ccalc = new MiniBB();
	private boolean hascoupled;
	protected REC recom;
	protected ArrayList<JEC> commands = new ArrayList<>();
	public ArrayList<String> lines = new ArrayList<>();//TODO use attribute instead
	
	public RailEntity(RailData data, VehicleData vdata, Track track, UUID placer){
		current = track; region = data.getRegions().get(track.start, true); if(placer != null) this.placer = placer;
		uid = data.getNewEntityId(); data.updateEntityEntry(uid, region.getKey()); vehdata = vdata;
		frbogiedis = (float)vdata.getWheelPositions().get("bogie_front").x;
		rrbogiedis  = (float)-vdata.getWheelPositions().get("bogie_rear").x;
		frconndis = (float)vdata.getFrontConnector().x; rrconndis = (float)-vdata.getRearConnector().x;
		//
		bfront = move(rrconndis + frbogiedis, TrainPoint.BOGIE_FRONT);
		brear = move(rrconndis - rrbogiedis, TrainPoint.BOGIE_REAR);
		pos = medium(bfront, brear); moverq += 0.02f;
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
			if(current == null || vehdata == null){ this.dispose(); return; }
			checkIfShouldHaveEntity(); checkIfShouldStop();
			//for(JunctionCommand command : commands) command.processEntity(this);
			commands.removeIf(cmd -> cmd.processEntity(this));
			//
			if(!vehdata.getType().isTrailerOrWagon() && throttle > 0.001f){
				EngineFunction engine = vehdata.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine");
				if(CMODE() || processConsumption(engine)){
					float eng = throttle * engine.getLegacyEngineSpeed();
					if(recom != null) recom.accumulator += eng;
					else moverq = forward ? eng : -eng;
				}
			}
			float am = moverq; boolean move = false;
			if(recom != null && (recom.forward() ? recom.isHead(this) : recom.isEnd(this))){
				float amount = recom.accumulator;
				if(recom.forward() && recom.isHead(this)){
					am += front.hasEntity() ? -amount : amount; recom.accumulator = 0; move = true;
				}
				else if(!recom.forward() && recom.isEnd(this)){
					am += rear.hasEntity() ? amount : -amount; recom.accumulator = 0; move = true;
				}
			}
			if(am != 0f && (am > 0.001 || am < -0.001)){//prevents unnecessary calculations, theoretically, comment out otherwise
				TRO tro = getTrack(current, passed + am, false); am = checkForPushCoupling(tro, am);
				//
				tro = getTrack(current, passed + am, true);
				last = current; current = tro.track; passed = tro.passed;
				if(!last.equals(current)) this.updateClient("track"); this.updateClient("passed");
				if(!region.isInRegion(current.start)) this.updateRegion(current.start);
				updatePosition();
				//
				if(!hascoupled && isCoupled()){
					//if(am < 0 && front.hasEntity() && !front.coupled && !front.inRange()) front.decouple();
					//if(am > 0 && rear.hasEntity() && !rear.coupled && !rear.inRange()) rear.decouple();
					if(recom != null && move) moveCompound(am);
				} hascoupled = false; moverq = 0;
			}
		}
		//
		region.getWorld().updateEntityEntry(uid, region.getKey());
	}
	
	private boolean CMODE(){
		if(!Config.VEHICLES_NEED_FUEL) return true;
		if(entity != null){
			return entity.seats != null && entity.seats[0] != null
	        	&& entity.seats[0].getControllingPassenger() instanceof EntityPlayer
	        	&& ((EntityPlayer)entity.seats[0].getControllingPassenger()).capabilities.isCreativeMode;
		} else return false;
	}

	private byte fuel_accu;
	private float consumed;

	private boolean processConsumption(EngineFunction engine){
    	if(engine == null) return false;
    	if(fuel_accu < 20){
    		if(!engine.isOn()){
    			//pass
    		}
    		else if(throttle == 0f || (throttle < 0.05f && throttle > -0.05f)){
    			consumed += engine.getIdleFuelConsumption();
    		}
    		else{
    			consumed += engine.getFuelConsumption(vehdata.getAttribute("fuel_secondary").getStringValue()) * throttle;
    		}
    		fuel_accu++; return true;
    	}
    	else{
    		if(consumed > 0){
    			int con = (int)(consumed / 20f);
    			vehdata.getAttribute("fuel_stored").decrease(con < 1 ? 1 : con);
    		}
    		if(entity != null && engine.isOn() && vehdata.getAttribute("fuel_stored").getFloatValue() <= 0){
    			NBTTagCompound compound  = new NBTTagCompound();
    			compound.setString("task", "engine_toggle");
    			compound.setBoolean("engine_toggle_result", false);
            	compound.setBoolean("no_fuel", true); throttle = 0; engine.setState(false);
                ApiUtil.sendEntityUpdatePacketToAllAround(entity, compound);
    		}
    		fuel_accu = 0; consumed = 0; return true;
    	}
	}

	public void checkIfShouldStop(){
		if(entity == null) return; boolean decrease = false;
		if(!isActive() && entity.seats.length > 0 && entity.seats[0] != null){
			if(entity.seats[0].getControllingPassenger() instanceof EntityPlayer == false) decrease = true;
			else if(!((EntityPlayer)entity.seats[0].getControllingPassenger()).capabilities.isCreativeMode
				&& vehdata.getAttribute("fuel_stored").getIntegerValue() <= 0) decrease = true;
		}
		if(decrease) throttle *= 0.98F;
	}

	private boolean isCoupled(){
		return front.hasEntity() || rear.hasEntity();
	}

	//Well, only do this as "head" of the compound.
	public final void moveCompound(float amount){
		Coupler coupler = front.hasEntity() ? rear : front; boolean rev = false;
		while(coupler.getOpposite().hasEntity()){
			coupler = coupler.getOpposite(); if(coupler.isFrontal() ? coupler.isFront() : coupler.isRear()) rev = !rev;
			coupler = coupler.getCounterpart(); coupler.root.moverq += rev ? -amount : amount;
		}
	}

	private float checkForPushCoupling(TRO tro, float am){
		if(front.hasEntity() && rear.hasEntity()) return am;
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
					hascoupled = true; couplers[i].couple(ent, false, false); am = coucen.distanceTo(ent.crear); 
					if(ent.brear.distanceTo(coucen) < ent.crear.distanceTo(coucen)) am = -am;
					Print.debug("coupling " + (i == 0 ? "front" : "rear") + " to rear");
				}
				if(ent.front.mbb.contains(coucen)){
					float entpos = ent.pos.distanceTo(pos);
					float coupos = ent.cfront.distanceTo(pos);
					if(entpos < coupos) continue;//upon testing, we're for sure in the other entity
					hascoupled = true; couplers[i].couple(ent, true, false); am = coucen.distanceTo(ent.cfront);
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
		return am;
	}

	public void updatePosition(){
		bfront = move(passed, TrainPoint.BOGIE_FRONT);
		brear = move(passed - frbogiedis - rrbogiedis, TrainPoint.BOGIE_REAR);
		cfront = move(passed + (frconndis - frbogiedis), TrainPoint.COUPLER_FRONT);
		crear = move(passed - frbogiedis - rrconndis, TrainPoint.COUPLER_REAR);
		prev.copyFrom(pos); pos = medium(bfront, brear);
		front.mbb.update(cfront, 0.25f); rear.mbb.update(crear, 0.25f);
	}

	private ArrayList<RailEntity> railentlist = new ArrayList<>();

	private ArrayList<RailEntity> getEntitiesOnTrackAndNext(Track track, boolean forward){
		railentlist.clear(); railentlist.addAll(track.section.getEntities().values());
		Junction junction = region.getJunction(track.start); Track track0;
		//TODO alternative for when a specific path is followed
		if(junction != null){ track0 = junction.getNext(null, track.getId(), false);
			if(track0 != null)railentlist.addAll(track0.section.getEntities().values());
		}
		junction = region.getJunction(track.end);
		if(junction != null){ track0 = junction.getNext(null, track.getOppositeId(), false);
			if(track0 != null)railentlist.addAll(track0.section.getEntities().values());
		} return railentlist;
	}

	protected void updateClient(String string){
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
			case "couplers":{
				compound.setString("task", "update_coupled");
				compound.setLong("front", front.hasEntity() ? front.entity.uid : -1l);
				compound.setBoolean("front_static", front.coupled);
				compound.setLong("rear", rear.hasEntity() ? rear.entity.uid : -1l);
				compound.setBoolean("rear_static", rear.coupled);
				break;
			}
			case "commands":{
				compound.setString("task", "update_commands");
				NBTTagList list = new NBTTagList();
				for(JEC cmd : commands) list.appendTag(cmd.write(null));
				compound.setTag("commands", list);
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
		TRO tro = getTrack(current, passed, point.updatesJunction(passed > 0));
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
		TRO tro = getTrack(current, passed, true); return tro.track.getVectorPosition(tro.passed, false);
	}

	private TRO getTrack(Track track, float passed, boolean apply){
		while(passed > track.length){
			Junction junk = region.getJunction(track.end);
			if(junk == null) new TRO(track, track.length);
			Track newtrack = junk.getNext(this, track.getOppositeId(), apply);
			if(newtrack != null){
				passed -= track.length; track = newtrack;
			} else return new TRO(track, track.length);
		}
		while(passed < 0){
			Junction junk = region.getJunction(track.start);
			if(junk == null) return new TRO(track, 0);
			Track newtrack = junk.getNext(this, track.getId(), apply);
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
		if(!commands.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(JEC cmd : commands) list.appendTag(cmd.write(null));
			compound.setTag("Commands", list);
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
		//
		if(compound.hasKey("Commands")){
			commands.clear(); NBTTagList cmds = (NBTTagList)compound.getTag("Commands");
			for(NBTBase base : cmds){
				if(base instanceof NBTTagCompound == false) continue;
				JEC command = JEC.read((NBTTagCompound)base);
				if(command != null) commands.add(command);
			}
		}
		//
		placer = new UUID(compound.getLong("Placer0"), compound.getLong("Placer1"));
		if(vehdata == null) vehdata = Resources.getVehicleData(compound);
		else vehdata.read(compound);
		if(vehdata == null){ this.dispose(); return this; }
		//if(compound.hasKey("front_coupled")) loadCouple(true, compound.getLong("front_coupled"), compound.getBoolean("front_coupler"));
		//if(compound.hasKey("rear_coupled")) loadCouple(false, compound.getLong("rear_coupled"), compound.getBoolean("rear_coupler"));
		//TODO try coupling later, to prevent overflow
		//TODO add REC loading instead later
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
		for(Section section : sectionson) if(section != null) section.getEntities().remove(uid);
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
		
		public boolean updatesJunction(boolean forward){
			return true;//(this == COUPLER_FRONT && forward || this == COUPLER_REAR && !forward);
		}
		
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
				if(coupler.hasEntity() && !coupler.coupled){
					coupler.decouple(); Print.chat(player, (thefront ? "Front" : "Rear") + " disconnected.");
				}
				else{
					Print.chat(player, "Nothing found to connect to.");
				}
			}
		}
	}

	public MiniBB[] getCouplerMBBs(){
		return new MiniBB[]{ front.mbb, rear.mbb };
	}

	public void setForward(EntityPlayer player, boolean bool){
		vehdata.getAttribute("forward").setValue(forward = bool);
		if(recom != null) recom.entities.get(0).forward = bool;
		Print.bar(player, "&e&oDirection set to " + (forward ? "FORWARD" : "REVERSE"));
		if(entity != null && !region.getWorld().getWorld().isRemote){
			NBTTagCompound packet = new NBTTagCompound(); packet.setString("target_listener", "fvtm:gui");
			packet.setString("task", "attr_update"); packet.setString("attr", "forward");
			packet.setString("value", vehdata.getAttribute("forward").getBooleanValue() + "");
			packet.setInteger("entity", entity.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		}
	}

	public void setActive(boolean bool){
		vehdata.getAttribute("active").setValue(bool);
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
		return vehdata.getAttribute("active").getBooleanValue();
	}
	
	@Override
	public String toString(){
		return "RE['" + uid + "', '" + vehdata.getType().getName() + "', '" + pos.toString() + "']";
	}

}
