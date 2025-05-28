package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.VEHICLES_NEED_FUEL;
import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.sys.rail.cmd.JEC;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.fvtm.util.MiniBB;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.util.SaveUtils;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.EntityW;
import org.apache.commons.lang3.tuple.Pair;

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
	public VehicleInstance vehicle;
	public long uid;
	public RailRegion region;
	//protected boolean forward = true;
	public double passed;
	public V3D pos = new V3D();
	public V3D prev = new V3D();
	public V3D cfront = new V3D();
	public V3D crear = new V3D();
	public V3D bfront = new V3D();
	public V3D brear = new V3D();
	private UUID placer = FvtmLogger.NULL_UUID;
	public Coupler front = new Coupler(this, true);
	public Coupler rear = new Coupler(this, false);
	public double frbogiedis;
	public double rrbogiedis;
	public double frconndis;
	public double rrconndis;
	public double length;
	public double moverq;//push_rq, pull_rq;
	public TrackUnit[] unitson = new TrackUnit[4];
	//
	private MiniBB ccalc = new MiniBB();
	private boolean hascoupled;
	protected Compound com;
	protected Pair<Junction, EntryDirection> waiting_signal;
	public ArrayList<String> lines = new ArrayList<>();//TODO use attribute instead
	private byte ticks;
	
	public RailEntity(RailSystem data, VehicleInstance veh, Track track, UUID placer){
		setveh(veh);
		current = track;
		region = data.getRegions().getC(track.start.pos, true);
		if(placer != null) this.placer = placer;
		uid = data.getNewEntityId();
		data.updateEntityEntry(uid, region.key);
		frbogiedis = -veh.data.getWheelPositions().get("bogie_front").z;
		rrbogiedis = veh.data.getWheelPositions().get("bogie_rear").z;
		frconndis = -veh.data.getConnectorFor("front").z;
		rrconndis = veh.data.getConnectorFor("rear").z;
		com = new Compound.Singular(this);
		//
		//this.passed = passed + rrconndis + frbogiedis;
		bfront = move(rrconndis + frbogiedis, TrainPoint.BOGIE_FRONT);
		brear = move(rrconndis - rrbogiedis, TrainPoint.BOGIE_REAR);
		pos = bfront.middle(brear);
		moverq += 0.02f;
		cfront = move(rrconndis + frconndis, TrainPoint.COUPLER_FRONT);
		crear = move(0, TrainPoint.COUPLER_REAR);
		front.mbb.update(cfront, veh.data.getType().getCouplerRange() / 2);
		rear.mbb.update(crear, veh.data.getType().getCouplerRange() / 2);
		//
		region.spawnEntity(this.start());
	}

	public void setveh(VehicleInstance veh){
		vehicle = veh;
		vehicle.railent = this;
		vehicle.iref().update();
	}

	/** only to use with read() afterward
	 * @param compound */
	public RailEntity(RailRegion railregion, Compound compound){
		region = railregion;
		com = compound;
		setveh(new VehicleInstance(null, null));
	}
	
	/** only to use with read() afterward || CLIENT SIDE METHOD */
	public RailEntity(RailRegion railregion, long uid){
		region = railregion;
		this.uid = uid;
		com = Compound.getNewClientCompound(this);
		setveh(new VehicleInstance(null, null));
	}

	public long getUID(){
		return uid;
	}

	public RailRegion getRegion(){
		return region;
	}
	
	public void onUpdate(){
		if(region.getSystem().isRemote()){
			this.updatePosition();
			//FvtmLogger.debug(current, current.unit);
			return;
		}
		//
		if(current == null || vehicle == null || vehicle.data == null){
			this.remove();
			return;
		}
		checkIfShouldStop();
		if(waiting_signal != null){
			if(waiting_signal.getLeft().getSignalState(waiting_signal.getRight())){
				setPaused(false);
			}
		}
		//
		if(!vehicle.data.getType().isTrailer() && !isPaused() && vehicle.throttle > 0.001f){
			if(vehicle.data.hasPart("engine")){
				EngineFunction engine = vehicle.data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine");
				if(CMODE() || (vehicle.engine != null && vehicle.consumeFuel())){
					double eng = vehicle.throttle * engine.getSphEngineSpeed();
					if(com.isMultiple()) com.accumulator += eng;
					else moverq = com.forward ? eng : -eng;
				}
			}
		}
		double am = moverq;
		boolean move = false;
		if(com.isMultiple() && (com.forward ? com.isHead(this) : com.isEnd(this))){
			double amount = com.accumulator;
			if(com.forward && com.isHead(this)){
				am += front.hasEntity() ? -amount : amount;
				com.accumulator = 0;
				move = true;
			}
			else if(!com.forward && com.isEnd(this)){
				am += rear.hasEntity() ? amount : -amount;
				com.accumulator = 0;
				move = true;
			}
		}
		else if(com.isSingular()) move = true;
		if(am != 0f && (am > 0.001 || am < -0.001)){//prevents unnecessary calculations, theoretically, comment out otherwise
			TRO tro = getTrack(current, passed + am, false, false);
			am = checkForPushCoupling(tro, am);
			//
			if(move){
				tro = getTrack(current, passed + (am > 0 ? frconndis - frbogiedis : -rrconndis - frbogiedis) + am, true, true);
				if(com.last_stop != null && tro.track != com.last_stop){
					if(tro.passed > com.last_stop_passed || tro.passed < com.last_stop_passed){
						com.last_stop = null;
						com.last_stop_passed = tro.passed;
					}
				}
			}
			tro = getTrack(current, passed + am, true, false);
			last = current;
			current = tro.track;
			passed = tro.passed;
			if(!last.equals(current)) this.updateClient("track");
			this.updateClient("passed");
			if(!region.key.isInRegion(current.start)) this.updateRegion(current.start);
			updatePosition();
			//
			if(!hascoupled && isCoupled()){
				//if(am < 0 && front.hasEntity() && !front.coupled && !front.inRange()) front.decouple();
				//if(am > 0 && rear.hasEntity() && !rear.coupled && !rear.inRange()) rear.decouple();
				if(com.isMultiple() && move) moveCompound(am);
			}
			hascoupled = false; moverq = 0;
		}
		//
		if(com.isHead(this)){
			if(++ticks > 10){
				updateOrientationAttr();
				ticks = 0;
			}
		}
		//
		region.getSystem().updateEntityEntry(uid, region.key);
		if(vehicle.entity != null && !vehicle.entity.inSimRange()){
			vehicle.onUpdate();
			if(vehicle.entity.pushTicks() % VEHICLE_SYNC_RATE == 0){
				vehicle.sendUpdatePacket();
			}
		}
	}

	private boolean CMODE(){
		if(!VEHICLES_NEED_FUEL || !vehicle.data.getAttribute("use-fuel").asBoolean()) return true;
		EntityW driver = vehicle.driver();
		if(driver != null){
	    	return driver.isCreative();
		}
		else return false;
	}

	public void checkIfShouldStop(){
		if(vehicle.entity == null) return;
		boolean decrease = false;
		EntityW con = vehicle.driver();
		if(!isActive() && con != null){
			if(!con.isCreative() && vehicle.data.getAttribute("fuel_stored").asInteger() <= 0) decrease = true;
		}
		if(decrease) vehicle.throttle *= 0.98F;
	}

	private boolean isCoupled(){
		return front.hasEntity() || rear.hasEntity();
	}

	//Well, only do this as "head" of the compound.
	public final void moveCompound(double amount){
		Coupler coupler = front.hasEntity() ? rear : front;
		boolean rev = false;
		while(coupler.getOpposite().hasEntity()){
			coupler = coupler.getOpposite();
			if(coupler.isFrontal() ? coupler.isFront() : coupler.isRear()) rev = !rev;
			coupler = coupler.getCounterpart();
			if(coupler == null || coupler.root == null) continue;
			coupler.root.moverq += rev ? -amount : amount;
		}
	}

	private double checkForPushCoupling(TRO tro, double am){
		if(front.hasEntity() && rear.hasEntity()) return am;
		Collection<RailEntity> ents = getEntitiesOnTrackAndNext(tro.track);
		Coupler[] couplers = new Coupler[]{ front, rear };
		for(int i = 0; i < 2; i++){
			if(couplers[i].hasEntity()) continue;
			V3D coucen = i == 0 ? cfront : crear;
			for(RailEntity ent : ents){
				if(ent == this || ent == front.entity || ent == rear.entity || ent.com.uid == com.uid) continue;
				ccalc.update(ent.cfront, ent.crear, 0.125f); if(!ccalc.contains(coucen)) continue;
				if(ent.rear.mbb.contains(coucen)){
					//float entpos = ent.pos.distanceTo(pos);
					//float coupos = ent.crear.distanceTo(pos);
					//if(entpos < coupos) continue;//we're probably inside the other entity, abort!
					hascoupled = true; couplers[i].couple(ent, false); am = coucen.dis(ent.crear); 
					if(ent.brear.dis(coucen) < ent.crear.dis(coucen)) am = -am;
					FvtmLogger.debug("coupling " + (i == 0 ? "front" : "rear") + " to rear");
				}
				if(ent.front.mbb.contains(coucen)){
					//float entpos = ent.pos.distanceTo(pos);
					//float coupos = ent.cfront.distanceTo(pos);
					//if(entpos < coupos) continue;//upon testing, we're for sure in the other entity
					hascoupled = true; couplers[i].couple(ent, true); am = coucen.dis(ent.cfront);
					if(ent.bfront.dis(coucen) < ent.cfront.dis(coucen)) am = -am;
					FvtmLogger.debug("coupling " + (i == 0 ? "front" : "rear") + " to front");
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
		prev.copy(pos);
		pos = bfront.middle(brear);
		front.mbb.update(cfront, vehicle.data.getType().getCouplerRange());
		rear.mbb.update(crear, vehicle.data.getType().getCouplerRange());
	}

	private ArrayList<RailEntity> railentlist = new ArrayList<>();

	private ArrayList<RailEntity> getEntitiesOnTrackAndNext(Track track){
		railentlist.clear();
		railentlist.addAll(track.unit.getEntities());
		Junction junction = region.get(track.start.pos);
		Track track0;
		//TODO alternative for when a specific path is followed
		if(junction != null){
			track0 = junction.getNext(null, track.getId(), false);
			if(track0 != null) railentlist.addAll(track0.unit.getEntities());
		}
		junction = region.get(track.end.pos);
		if(junction != null){
			track0 = junction.getNext(null, track.getOppositeId(), false);
			if(track0 != null) railentlist.addAll(track0.unit.getEntities());
		}
		return railentlist;
	}

	protected void updateClient(String string){
		if(vehicle.entity == null) return;
		TagCW compound = TagCW.create();
		switch(string){
			case "track":{
				compound.set("sub", "track");
				current.getId().write(compound);
				break;
			}
			case "passed":{
				compound.set("sub", "passed");
				compound.set("passed", passed);
				break;
			}
			/*case "couplers":{
				compound.set("sub", "update_coupled");
				compound.set("front", front.hasEntity() ? front.entity.uid : -1l);
				//compound.set("front_static", front.coupled);
				compound.set("rear", rear.hasEntity() ? rear.entity.uid : -1l);
				//compound.set("rear_static", rear.coupled);
				break;
			}
			case "commands":{
				compound.set("sub", "update_commands");
				TagLW list = TagLW.create();
				for(JEC cmd : commands) list.add(cmd.write(null));
				compound.set("commands", list);
				break;
			}
			case "forward":{
				compound.set("sub", "update_forward");
				compound.set("forward", vehicle.data.getAttribute("forward").asBoolean());
				break;
			}*/
		}
		vehicle.sendUpdate(PKT_UPD_RAILENTITY, compound);
	}

	public void onPacket(EntityW pass, TagCW com){
		if(vehicle.entity == null) return;
		switch(com.getString("sub")){
			case "track":{
				current = region.getTrack(new PathKey(com));
				break;
			}
			case "passed":{
				passed = com.getDouble("passed");
				break;
			}
		}
	}

	public void updateRegion(QV3D start){
		region.getEntities().remove(uid);
		region = region.getSystem().getRegions().getC(RegionKey.getRegionXZ(start), true);
		region.getEntities().put(uid, this);
	}

	public V3D move(double passed, TrainPoint point){
		TRO tro = getTrack(current, passed, point.updatesJunction(passed > 0), false);
		if(unitson[point.index] == null){
			(unitson[point.index] = tro.track.unit).update(this, true);
		}
		else{
			unitson[point.index].update(this, false);
			(unitson[point.index] = tro.track.unit).update(this, true);
		}
		return tro.track.getVectorPosition(tro.passed, false);
	}

	public V3D moveOnly(float passed){
		TRO tro = getTrack(current, passed, true, false);
		return tro.track.getVectorPosition(tro.passed, false);
	}

	private TRO getTrack(Track track, double passed, boolean apply, boolean signal){
		Junction junc;
		while(passed > track.length){
			junc = region.get(track.end.pos);
			if(junc == null){
				com.stop(track, track.length);
				return new TRO(track, track.length);
			}
			if(signal && junc.hasSignal(track.getOppositeId()) && isActiveEnd()){
				junc.pollSignal(this, track.getOppositeId());
				if(!junc.getSignalState(track.getOppositeId()) && !isPaused()){
					waiting_signal = Pair.of(junc, junc.eqTrack(track.getOppositeId(), 0) ? EntryDirection.FORWARD : EntryDirection.BACKWARD);
					setPaused(true);
				}
				return new TRO(track, track.length);
			}
			Track newtrack = junc.getNext(this, track.getOppositeId(), apply);
			if(newtrack != null){
				passed -= track.length;
				track = newtrack;
			}
			else{
				if(signal) com.stop(track, track.length);
				return new TRO(track, track.length);
			}
		}
		while(passed < 0){
			junc = region.get(track.start.pos);
			if(junc == null){
				com.stop(track, 0);
				return new TRO(track, 0);
			}
			if(signal && junc.hasSignal(track.getId()) && isActiveEnd()){
				junc.pollSignal(this, track.getOppositeId());
				if(!junc.getSignalState(track.getId()) && !isPaused()){
					waiting_signal = Pair.of(junc, junc.eqTrack(track.getId(), 0) ? EntryDirection.FORWARD : EntryDirection.BACKWARD);
					setPaused(true);
				}
				return new TRO(track, 0);
			}
			Track newtrack = junc.getNext(this, track.getId(), apply);
			if(newtrack != null){
				passed += newtrack.length;
				track = newtrack.createOppositeCopy();
			}
			else{
				if(signal) com.stop(track, 0);
				return new TRO(track, 0);
			}
			
		}
		return new TRO(track, passed);
	}
	
	public static class TRO {//track return object

		public TRO(Track track, double passed){
			this.track = track;
			this.passed = passed;
		}

		public Track track;
		public double passed;

	}

	public void checkIfShouldHaveEntity(){
		if(vehicle.entity != null){
			if(vehicle.seats != null){
				for(SeatInstance seat : vehicle.seats){
					if(seat.passenger() != null) return;
				}
			}
			if(isInPlayerRange()) return;
			vehicle.entity.remove();
			vehicle.entity = null;
		}
		else{
			if(!isInPlayerRange()) return;
			FvtmWorld world = (FvtmWorld)region.getSystem().getWorld();
			world.spawnRailEntity(this);
		}
	}

	private boolean isInPlayerRange(){
		for(EntityW pl : region.getSystem().getWorld().getPlayers()){
			if(pos.dis(pl.getPos()) < 256) return true;
		}
		return false;
	}

	public TagCW write(TagCW compound){
		if(compound == null) compound = TagCW.create();
		compound.set("uid", uid);
		compound.set("region", region.key.toArray());
		if(current != null) current.getId().write(compound);
		compound.set("pos", SaveUtils.saveV3D(pos));
		compound.set("prev", SaveUtils.saveV3D(prev));
		compound.set("cfront", SaveUtils.saveV3D(cfront));
		compound.set("bfront", SaveUtils.saveV3D(bfront));
		compound.set("crear", SaveUtils.saveV3D(crear));
		compound.set("brear", SaveUtils.saveV3D(brear));
		compound.set("forward", com.getOrient(this));
		compound.set("passed", passed);
		compound.set("Placer0", placer.getMostSignificantBits());
		compound.set("Placer1", placer.getLeastSignificantBits());
		if(front.entity != null){
			compound.set("front_coupled", front.entity.uid);
			compound.set("front_coupler", front.isFront());
		}
		compound.set("front_auto", front.autocoupler);
		if(rear.entity != null){
			compound.set("rear_coupled", rear.entity.uid);
			compound.set("rear_coupler", rear.isFront());
		}
		compound.set("rear_auto", rear.autocoupler);
		if(waiting_signal != null){
			compound.set("WaitSig", waiting_signal.getLeft().getPos().pos);
			compound.set("WaitSigDir", waiting_signal.getRight().ordinal());
		}
		compound.set("Compound", com.getUID());
		compound.set("Singular", com.isSingular());
		compound.set("throttle", vehicle.throttle);
		return vehicle.data.write(compound);
	}
	
	public RailEntity read(TagCW compound){
		uid = compound.getLong("uid");
		if(region == null) FvtmLogger.debug("region is NULL");
		current = region.getTrack(new PathKey(compound));
		if(current == null) FvtmLogger.log("track not found! " + new PathKey(compound).toString());
		if(current == null){ this.remove(); return this; }
		pos = SaveUtils.loadV3D(compound.getList("pos"));
		prev = SaveUtils.loadV3D(compound.getList("prev"));
		cfront = SaveUtils.loadV3D(compound.getList("cfront"));
		bfront = SaveUtils.loadV3D(compound.getList("bfront"));
		crear = SaveUtils.loadV3D(compound.getList("crear"));
		brear = SaveUtils.loadV3D(compound.getList("brear"));
		//forward = compound.has("forward") ? compound.getBoolean("forward") : true;
		passed = compound.getFloat("passed");
		vehicle.throttle = compound.getFloat("throttle");
		front.autocoupler = compound.getBoolean("front_auto");
		rear.autocoupler = compound.getBoolean("rear_auto");
		//
		if(compound.has("WaitSig")){
			try{
				waiting_signal = Pair.of(region.system.getJunction(compound.getV3I("WaitSid")), EntryDirection.values()[compound.getInteger("WaitSigDir")]);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//
		placer = new UUID(compound.getLong("Placer0"), compound.getLong("Placer1"));
		if(vehicle.data == null) vehicle.init(FvtmResources.getVehicleData(compound), null);
		else vehicle.data.read(compound);
		if(vehicle.data == null){ this.remove(); return null; }
		//if(compound.has("front_coupled")) loadCouple(true, compound.getLong("front_coupled"), compound.getBoolean("front_coupler"));
		//if(compound.has("rear_coupled")) loadCouple(false, compound.getLong("rear_coupled"), compound.getBoolean("rear_coupler"));
		//TODO try coupling later, to prevent overflow
		//TODO add REC loading instead later
		//
		frbogiedis = -vehicle.data.getWheelPositions().get("bogie_front").z;
		rrbogiedis  = vehicle.data.getWheelPositions().get("bogie_rear").z;
		frconndis = -vehicle.data.getConnectorFor("front").z;
		rrconndis = vehicle.data.getConnectorFor("rear").z;
		//
		updatePosition();
		return this;
	}

	public void loadCouple(boolean frontcoupler, long uid, boolean asfront){
		RailEntity ent = region.getSystem().getEntity(uid, true);
		if(ent == null) return;
		Coupler coupler = frontcoupler ? front : rear; coupler.entity = ent;
		coupler = asfront ? ent.front : ent.rear; coupler.entity = this;
	}

	public void alignEntity(boolean initial){
		if(vehicle.entity == null) return;
		vehicle.entity.setPos(pos);
		/*if(initial){
			entity.prevPosX = entity.lastTickPosX = entity.posX = pos.x;
			entity.prevPosY = entity.lastTickPosY = entity.posY = pos.y;
			entity.prevPosZ = entity.lastTickPosZ = entity.posZ = pos.z;
	        entity.setEntityBoundingBox(new AxisAlignedBB(pos.x - 0.25, pos.y, pos.z - 0.25,
	        	pos.x + 0.25, pos.y + 0.25, pos.z + 0.25));
		}
		else{ entity.setPosition(pos.x, pos.y, pos.z); }*/
	}

	public void remove(){
		FvtmLogger.debug("Removing TrackEntity " + uid + "!");
		front.decouple();
		rear.decouple();
		region.getSystem().delEntity(this);
		if(vehicle.entity != null && !vehicle.entity.isRemoved()) vehicle.entity.remove();
		for(TrackUnit section : unitson) if(section != null) section.getEntities().remove(this);
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

	public void tryCoupling(EntityW player, boolean thefront){
		Coupler coupler = thefront ? front : rear;
		V3D vec = thefront ? cfront : crear;
		if(coupler.hasEntity()){
			coupler.decouple();
			player.send((thefront ? "Front" : "Rear") + " disconnected.");
		}
		else{
			Collection<RailEntity> ents = getEntitiesOnTrackAndNext(current);
			RailEntity found = null;
			for(RailEntity ent : ents){
				FvtmLogger.debug(ent.vehicle.data.getName());
				if(ent.uid == this.uid) continue;
				if(ent.rear.mbb.contains(vec)){
					found = ent; coupler.couple(ent, false); break;
					//TODO push/pull the moved entity / or this
				}
				if(ent.front.mbb.contains(vec)){
					found = ent; coupler.couple(ent, true); break;
					//TODO push/pull the moved entity / or this
				}
			}
			if(found != null){
				player.send((thefront ? "Front" : "Rear") + " connected.");
				player.send("&7&o" + found.vehicle.data.getName());
			}
			else{
				if(coupler.hasEntity()){
					coupler.decouple();
					player.send((thefront ? "Front" : "Rear") + " disconnected.");
				}
				else{
					player.send("Nothing found to connect to.");
				}
			}
		}
	}

	public MiniBB[] getCouplerMBBs(){
		return new MiniBB[]{ front.mbb, rear.mbb };
	}

	public void setForward(EntityW player, boolean bool){
		com.forward = bool;
		if(player != null) player.bar("fvtm.rail.direction_" + (bool ? "forward" : "reverse"));
		for(RailEntity ent : com.entities){
			ent.vehicle.data.getAttribute("forward").set(com.getOrient(ent));
			ent.sendForwardUpdate();
		}
	}
	
	private void sendForwardUpdate(){
		if(vehicle.entity == null || region.getSystem().getWorld().isClient()) return;
		vehicle.updateAttr("forward");
	}

	private void updateOrientationAttr(){
		for(RailEntity ent : com.entities){
			if(com.getOrient(ent) != true){
				ent.sendForwardUpdate();
			}
		}
	}

	public void setActive(boolean bool){
		vehicle.data.getAttribute("active").set(bool);
		if(vehicle.entity != null && !region.getSystem().getWorld().isClient()){
			vehicle.updateAttr("active");
		}
	}
	
	public boolean isHeadingForward(){
		return com.getOrient(this);
	}
	
	public boolean isActive(){
		return vehicle.data.getAttribute("active").asBoolean();
	}
	
	@Override
	public String toString(){
		return "RE['" + uid + "', '" + vehicle.data.getName() + "', '" + pos.toString() + "']";
	}

	public void setPaused(boolean bool){
		vehicle.data.getAttribute("paused").set(com.paused = bool);
		if(vehicle.entity != null && !region.getSystem().getWorld().isClient()){
			vehicle.updateAttr("paused");
		}
	}
	
	public boolean isPaused(){
		return com.paused;
	}

	public boolean isActiveEnd(){
		if(com.isSingular()) return true; return com.forward ? com.isHead(this) : com.isEnd(this);
	}
	
	public Compound getCompound(){
		return com;
	}

	public RailEntity start(){
		return this;
	}

	public void flip(){
		if(!com.isSingular()) return;
		if(last != null) last = last.createOppositeCopy();
		current = current.createOppositeCopy();
		passed = current.oppositePassed(passed);
		updatePosition();
	}

}
