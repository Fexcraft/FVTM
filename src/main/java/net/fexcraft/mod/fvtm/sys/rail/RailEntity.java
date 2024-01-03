package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.VEHICLES_NEED_FUEL;
import static net.fexcraft.mod.fvtm.util.packet.Packets.getTargetPoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.rail.cmds.CMD_SignalWait;
import net.fexcraft.mod.fvtm.sys.rail.cmds.JEC;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.fexcraft.mod.fvtm.util.MiniBB;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	public Region region;
	//protected boolean forward = true;
	public double throttle, passed;
	public V3D pos = new V3D(), prev = new V3D(),
		cfront = new V3D(), crear = new V3D(),
		bfront = new V3D(), brear = new V3D();
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	public Coupler front = new Coupler(this, true), rear = new Coupler(this, false);
	public VehicleData vehdata;
	public double frbogiedis, rrbogiedis, frconndis, rrconndis, length, moverq;//push_rq, pull_rq;
	public TrackUnit[] unitson = new TrackUnit[4];
	//
	private Short lastcheck = null;//for entity despawn/spawning;
	private static final short interval = 100;//300
	private MiniBB ccalc = new MiniBB();
	private boolean hascoupled;
	protected Compound com;
	protected ArrayList<JEC> commands = new ArrayList<>();
	public ArrayList<String> lines = new ArrayList<>();//TODO use attribute instead
	private byte ticks;
	
	public RailEntity(RailSystem data, VehicleData vdata, Track track, UUID placer){
		current = track; region = data.getRegions().get(track.start, true); if(placer != null) this.placer = placer;
		uid = data.getNewEntityId(); data.updateEntityEntry(uid, region.getKey()); vehdata = vdata;
		frbogiedis = (float)vdata.getWheelPositions().get("bogie_front").x;
		rrbogiedis  = (float)-vdata.getWheelPositions().get("bogie_rear").x;
		frconndis = (float)vdata.getFrontConnector().x;
		rrconndis = (float)-vdata.getRearConnector().x;
		com = new Compound.Singular(this); 
		//
		//this.passed = passed + rrconndis + frbogiedis;
		bfront = move(rrconndis + frbogiedis, TrainPoint.BOGIE_FRONT);
		brear = move(rrconndis - rrbogiedis, TrainPoint.BOGIE_REAR);
		pos = bfront.middle(brear);
		moverq += 0.02f;
		cfront = move(rrconndis + frconndis, TrainPoint.COUPLER_FRONT);
		crear = move(0, TrainPoint.COUPLER_REAR);
		front.mbb.update(cfront, vehdata.getType().getCouplerRange() / 2); rear.mbb.update(crear, vehdata.getType().getCouplerRange() / 2);
		//
		region.spawnEntity(this.start());
	}

	/** only to use with read() afterwards 
	 * @param compound */
	public RailEntity(Region railregion, Compound compound){
		region = railregion; this.com = compound;
	}
	
	/** only to use with read() afterwards || CLIENT SIDE METHOD */
	@SideOnly(Side.CLIENT)
	public RailEntity(Region railregion, long uid){
		region = railregion; this.uid = uid;
		com = Compound.getNewClientCompound(this);
	}

	public long getUID(){
		return uid;
	}

	public Region getRegion(){
		return region;
	}
	
	public void onUpdate(){
		if(region.getWorld().isRemote()){
			this.updatePosition();
			Print.debug(current, current.unit);
			return;
		}
		//
		if(current == null || vehdata == null){
			this.dispose();
			return;
		}
		checkIfShouldHaveEntity();
		checkIfShouldStop();
		for(JEC command : commands) command.processEntity(this);
		commands.removeIf(cmd -> cmd.isDone());
		//
		if(!vehdata.getType().isTrailer() && !isPaused() && throttle > 0.001f){
			if(vehdata.hasPart("engine")){
				EngineFunction engine = vehdata.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine");
				if(CMODE() || processConsumption(engine)){
					double eng = throttle * engine.getSphEngineSpeed();
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
			if(!region.getKey().isInRegion(current.start)) this.updateRegion(current.start);
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
		region.getWorld().updateEntityEntry(uid, region.getKey());
	}

	private boolean CMODE(){
		if(!VEHICLES_NEED_FUEL) return true;
		if(entity != null){
	    	Entity con = entity.getDriver();
	    	return con != null && ((EntityPlayer)con).capabilities.isCreativeMode;
		}
		else return false;
	}

	private byte fuel_accu;
	private float consumed;

	private boolean processConsumption(EngineFunction engine){
    	if(engine == null) return false;
    	if(vehdata.getAttributeInteger("fuel_stored", 0) <= 0) return false;
    	if(fuel_accu < 20){
    		if(engine.isOn()){
    			if(throttle == 0f || (throttle < 0.05f && throttle > -0.05f)){
        			consumed += engine.getIdleFuelConsumption();
        		}
        		else{
        			consumed += engine.getFuelConsumption(vehdata.getAttribute("fuel_secondary").asString()) * throttle;
        		}
    		}
    		fuel_accu++;
    		return engine.isOn();
    	}
    	else{
    		boolean bool = false;
    		if(consumed > 0){
    			int con = (int)(consumed / 20f);
    			vehdata.getAttribute("fuel_stored").decrease(con < 1 ? 1 : con);
    			bool = true;
    		}
    		if(entity != null && engine.isOn() && vehdata.getAttribute("fuel_stored").asFloat() <= 0){
    			NBTTagCompound compound  = new NBTTagCompound();
    			compound.setString("task", "engine_toggle");
    			compound.setBoolean("engine_toggle_result", false);
            	compound.setBoolean("no_fuel", true);
            	throttle = 0;
            	engine.setState(false);
                ApiUtil.sendEntityUpdatePacketToAllAround(entity, compound);
    		}
    		fuel_accu = 0;
    		consumed = 0;
    		return bool;
    	}
	}

	public void checkIfShouldStop(){
		if(entity == null) return;
		boolean decrease = false;
		Entity con = entity.getDriver();
		if(!isActive() && con != null){
			if(!((EntityPlayer)con).capabilities.isCreativeMode && vehdata.getAttribute("fuel_stored").asInteger() <= 0) decrease = true;
		}
		if(decrease) throttle *= 0.98F;
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
			if(coupler.root == null) continue;
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
					Print.debug("coupling " + (i == 0 ? "front" : "rear") + " to rear");
				}
				if(ent.front.mbb.contains(coucen)){
					//float entpos = ent.pos.distanceTo(pos);
					//float coupos = ent.cfront.distanceTo(pos);
					//if(entpos < coupos) continue;//upon testing, we're for sure in the other entity
					hascoupled = true; couplers[i].couple(ent, true); am = coucen.dis(ent.cfront);
					if(ent.bfront.dis(coucen) < ent.cfront.dis(coucen)) am = -am;
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
		prev.copy(pos); pos = bfront.middle(brear);
		front.mbb.update(cfront, vehdata.getType().getCouplerRange());
		rear.mbb.update(crear, vehdata.getType().getCouplerRange());
	}

	private ArrayList<RailEntity> railentlist = new ArrayList<>();

	private ArrayList<RailEntity> getEntitiesOnTrackAndNext(Track track){
		railentlist.clear(); railentlist.addAll(track.unit.getEntities());
		Junction junction = region.getJunction(track.start); Track track0;
		//TODO alternative for when a specific path is followed
		if(junction != null){ track0 = junction.getNext(null, track.getId(), false);
			if(track0 != null) railentlist.addAll(track0.unit.getEntities());
		}
		junction = region.getJunction(track.end);
		if(junction != null){ track0 = junction.getNext(null, track.getOppositeId(), false);
			if(track0 != null) railentlist.addAll(track0.unit.getEntities());
		} return railentlist;
	}

	protected void updateClient(String string){
		if(entity == null) return; NBTTagCompound compound = new NBTTagCompound();
		switch(string){
			case "track":{
				compound.setString("task", "update_track");
				current.getId().write(compound);
				break;
			}
			case "passed":{
				compound.setString("task", "update_passed");
				compound.setDouble("passed", passed);
				break;
			}
			case "couplers":{
				compound.setString("task", "update_coupled");
				compound.setLong("front", front.hasEntity() ? front.entity.uid : -1l);
				//compound.setBoolean("front_static", front.coupled);
				compound.setLong("rear", rear.hasEntity() ? rear.entity.uid : -1l);
				//compound.setBoolean("rear_static", rear.coupled);
				break;
			}
			case "commands":{
				compound.setString("task", "update_commands");
				NBTTagList list = new NBTTagList();
				for(JEC cmd : commands) list.appendTag(cmd.write(null));
				compound.setTag("commands", list);
				break;
			}
			case "forward":{
				compound.setString("task", "update_forward");
				compound.setBoolean("forward", vehdata.getAttribute("forward").asBoolean());
				break;
			}
		}
		ApiUtil.sendEntityUpdatePacketToAllAround(entity, compound);
	}

	public void updateRegion(GridV3D start){
		region.getEntities().remove(uid);
		region = region.getWorld().getRegions().get(RegionKey.getRegionXZ(start), true);
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
		while(passed > track.length){
			Junction junk = region.getJunction(track.end);
			if(junk == null){
				com.stop(track, track.length);
				new TRO(track, track.length);
			}
			if(signal && junk.hasSignal(track.getId()) && isActiveEnd()){
				junk.pollSignal(this);
				if(!junk.getSignalState(track.getId()) && !isPaused()){
					commands.add(new CMD_SignalWait("signal_wait", junk, junk.eqTrack(track.getOppositeId(), 0) ? EntryDirection.FORWARD : EntryDirection.BACKWARD));
					this.setPaused(true);
				}
				return new TRO(track, track.length);
			}
			Track newtrack = junk.getNext(this, track.getOppositeId(), apply);
			if(newtrack != null){
				passed -= track.length; track = newtrack;
			}
			else{
				if(signal){ com.stop(track, track.length); }
				return new TRO(track, track.length);
			}
		}
		while(passed < 0){
			Junction junk = region.getJunction(track.start);
			if(junk == null){ com.stop(track, 0); return new TRO(track, 0); }
			if(signal && junk.hasSignal(track.getId()) && isActiveEnd()){
				junk.pollSignal(this);
				if(!junk.getSignalState(track.getId()) && !isPaused()){
					commands.add(new CMD_SignalWait("signal_wait", junk, junk.eqTrack(track.getId(), 0) ? EntryDirection.FORWARD : EntryDirection.BACKWARD));
					this.setPaused(true);
				}
				return new TRO(track, 0);
			}
			Track newtrack = junk.getNext(this, track.getId(), apply);
			if(newtrack != null){
				passed += newtrack.length; track = newtrack.createOppositeCopy();
			}
			else{
				if(signal){ com.stop(track, 0); }
				return new TRO(track, 0);
			}
			
		} return new TRO(track, passed);
	}
	
	public static class TRO {//track return object

		public TRO(Track track, double passed){
			this.track = track;
			this.passed = passed;
		}

		public Track track;
		public double passed;

	}

	private void checkIfShouldHaveEntity(){
		if(lastcheck == null) return; if(lastcheck > 0){ lastcheck--; return; }
		if(entity != null){
			if(entity.seats != null)
				for(SeatCache seat : entity.seats)
					if(seat.passenger() != null){
						lastcheck = interval;
						return;
					}
			if(isInPlayerRange()){
				lastcheck = interval;
				return;
			}
			entity.setDead();
			entity = null;
			lastcheck = interval;
			return;
		}
		else{
			if(!isInPlayerRange()){
				lastcheck = interval;
				return;
			}
			region.getWorld().getWorld().spawnEntity(new RailVehicle(this));
		}
	}

	private boolean isInPlayerRange(){
		for(EntityPlayer pl : region.getWorld().getWorld().playerEntities){
			if(pos.dis(pl.posX, pl.posY, pl.posZ) < 256) return true;
		}
		return false;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setLong("uid", uid);
		compound.setIntArray("region", region.getKey().toArray());
		current.getId().write(compound);
		compound.setTag("pos", DataUtil.writeVec(pos));
		compound.setTag("prev", DataUtil.writeVec(prev));
		compound.setTag("cfront", DataUtil.writeVec(cfront));
		compound.setTag("bfront", DataUtil.writeVec(bfront));
		compound.setTag("crear", DataUtil.writeVec(crear));
		compound.setTag("brear", DataUtil.writeVec(brear));
		compound.setBoolean("forward", com.getOrient(this));
		compound.setDouble("passed", passed);
		compound.setLong("Placer0", placer.getMostSignificantBits());
		compound.setLong("Placer1", placer.getLeastSignificantBits());
		if(front.entity != null){
			compound.setLong("front_coupled", front.entity.uid);
			compound.setBoolean("front_coupler", front.isFront());
		}
		compound.setBoolean("front_auto", front.autocoupler);
		if(rear.entity != null){
			compound.setLong("rear_coupled", rear.entity.uid);
			compound.setBoolean("rear_coupler", rear.isFront());
		}
		compound.setBoolean("rear_auto", rear.autocoupler);
		if(!commands.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(JEC cmd : commands) list.appendTag(cmd.write(null));
			compound.setTag("Commands", list);
		}
		compound.setLong("Compound", com.getUID());
		compound.setBoolean("Singular", com.isSingular());
		compound.setDouble("throttle", throttle);
		return vehdata.write(new TagCWI(compound)).local();
	}
	
	public RailEntity read(NBTTagCompound compound){
		uid = compound.getLong("uid"); if(region == null) Print.debug("region is NULL");
		current = region.getTrack(new PathKey(compound));
		if(current == null) Print.log("track not found! " + new PathKey(compound).toString());
		if(current == null){ this.dispose(); return this; }
		pos = DataUtil.readVec(compound.getTag("pos"));
		prev = DataUtil.readVec(compound.getTag("prev"));
		cfront = DataUtil.readVec(compound.getTag("cfront"));
		bfront = DataUtil.readVec(compound.getTag("bfront"));
		crear = DataUtil.readVec(compound.getTag("crear"));
		brear = DataUtil.readVec(compound.getTag("brear"));
		//forward = compound.hasKey("forward") ? compound.getBoolean("forward") : true;
		passed = compound.getFloat("passed");
		throttle = compound.getFloat("throttle");
		front.autocoupler = compound.getBoolean("front_auto");
		rear.autocoupler = compound.getBoolean("rear_auto");
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
		if(vehdata == null) vehdata = null;//TODO Resources.getVehicleData(compound);
		else vehdata.read(new TagCWI(compound));
		if(vehdata == null){ this.dispose(); return null; }
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
		Coupler coupler = frontcoupler ? front : rear; coupler.entity = ent;
		coupler = asfront ? ent.front : ent.rear; coupler.entity = this;
	}

	public void alignEntity(boolean initial){
		if(entity == null) return;
		if(initial){
			entity.prevPosX = entity.lastTickPosX = entity.posX = pos.x;
			entity.prevPosY = entity.lastTickPosY = entity.posY = pos.y;
			entity.prevPosZ = entity.lastTickPosZ = entity.posZ = pos.z;
	        entity.setEntityBoundingBox(new AxisAlignedBB(pos.x - 0.25, pos.y, pos.z - 0.25,
	        	pos.x + 0.25, pos.y + 0.25, pos.z + 0.25));
		}
		else{ entity.setPosition(pos.x, pos.y, pos.z); }
	}

	public void dispose(){
		Print.debug("Disposing of TrackEntity " + uid + "!");
		front.decouple();
		rear.decouple();
		lastcheck = null;
		region.getWorld().delEntity(this);
		if(entity != null && !entity.isDead) entity.setDead();
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

	public void tryCoupling(EntityPlayer player, boolean thefront){
		Coupler coupler = thefront ? front : rear;
		V3D vec = thefront ? cfront : crear;
		if(coupler.hasEntity()){
			coupler.decouple(); Print.chat(player, (thefront ? "Front" : "Rear") + " disconnected.");
		}
		else{
			Collection<RailEntity> ents = getEntitiesOnTrackAndNext(current);
			RailEntity found = null;
			for(RailEntity ent : ents){
				Print.debug(ent.vehdata.getName());
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
				Print.chat(player, (thefront ? "Front" : "Rear") + " connected.");
				Print.chat(player, "&7&o" + found.vehdata.getName());
			}
			else{
				if(coupler.hasEntity()){
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
		com.forward = bool;
		if(player != null) Print.bar(player, "&e&oDirection set to " + (bool ? "FORWARD" : "REVERSE"));
		for(RailEntity ent : com.entities){
			ent.vehdata.getAttribute("forward").set(com.getOrient(ent));
			ent.sendForwardUpdate();
		}
	}
	
	private void sendForwardUpdate(){
		if(entity == null || region.getWorld().getWorld().isRemote) return;
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", GuiHandler.LISTENERID);
		packet.setString("task", "attr_update");
		packet.setString("attr", "forward");
		packet.setString("value", vehdata.getAttribute("forward").asString());
		packet.setInteger("entity", entity.getEntityId());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), getTargetPoint(entity));
	}

	private void updateOrientationAttr(){
		for(RailEntity ent : com.entities){
			if(com.getOrient(ent) != true){
				ent.sendForwardUpdate();
			}
		}
	}

	public void setActive(boolean bool){
		vehdata.getAttribute("active").set(bool);
		if(entity != null && !region.getWorld().getWorld().isRemote){
			NBTTagCompound packet = new NBTTagCompound();
			packet.setString("target_listener", GuiHandler.LISTENERID);
			packet.setString("task", "attr_update");
			packet.setString("attr", "active");
			packet.setString("value", vehdata.getAttribute("active").asString());
			packet.setInteger("entity", entity.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		}
	}
	
	public boolean isHeadingForward(){
		return com.getOrient(this);
	}
	
	public boolean isActive(){
		return vehdata.getAttribute("active").asBoolean();
	}
	
	@Override
	public String toString(){
		return "RE['" + uid + "', '" + vehdata.getName() + "', '" + pos.toString() + "']";
	}

	public void setPaused(boolean bool){
		vehdata.getAttribute("paused").set(com.paused = bool);
		if(entity != null && !region.getWorld().getWorld().isRemote){
			NBTTagCompound packet = new NBTTagCompound(); packet.setString("target_listener", "fvtm:railsys");
			packet.setString("task", "attr_update"); packet.setString("attr", "paused");
			packet.setString("value", vehdata.getAttribute("paused").asBoolean() + "");
			packet.setInteger("entity", entity.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
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
		lastcheck = interval / 2; return this;
	}

	public ArrayList<JEC> getCommands(){
		return commands;
	}

	public void flip(){
		if(!com.isSingular()) return;
		if(last != null) last = last.createOppositeCopy();
		current = current.createOppositeCopy();
		passed = current.oppositePassed(passed);
		updatePosition();
	}

}
