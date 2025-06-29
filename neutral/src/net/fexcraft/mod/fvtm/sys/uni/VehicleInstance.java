package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.AttrFloat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.AttributeUtil;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.*;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPress;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPressState;
import net.fexcraft.mod.fvtm.packet.Packet_VehMove;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.OBB;
import net.fexcraft.mod.fvtm.util.Pivot;
import net.fexcraft.mod.fvtm.util.ess.SimplePhysSpawnSystem;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.*;

import static net.fexcraft.lib.common.Static.*;
import static net.fexcraft.mod.fvtm.Config.*;
import static net.fexcraft.mod.fvtm.data.Material.isFuelContainer;
import static net.fexcraft.mod.fvtm.util.MathUtils.*;
import static net.fexcraft.mod.uni.inv.StackWrapper.IT_LEAD;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleInstance {

	public VehicleData data;
	public VehicleType type;
	public EntityW entity;
	private UUID placer;
	public VehicleInstance front, rear;
	public SwivelPoint point;
	private InteractRef ref;
	public RenderCache cache;
	//
	public double[] serv_pos = new double[3];
	public double[] serv_rot = new double[3];
	public double serv_steer;
	public byte serv_sync;
	public WheelTireData w_front_l;
	public WheelTireData w_front_r;
	public WheelTireData w_rear_l;
	public WheelTireData w_rear_r;
	public RailEntity railent;
	public Map<String, OBB> obb = new LinkedHashMap<>();
	//
	public ArrayList<Axle> axles = new ArrayList<>();
	public Axle ax_fron;
	public Axle ax_rear;
	public double wheelbase;
	public double cg_height;
	public int rpm, orpm, crpm;
	private ArrayList<Double> avsp = new ArrayList<>();
	private double appmass = 0;
	private double accel = 0f;
	private double angor = 0f;
	public boolean overloaded;
	//
	public WheelMap wheels = new WheelMap();
	public double steer_yaw;
	public double throttle;
	public double speed;
	public V3D pos;
	public V3D prev;
	public V3D move = new V3D();
	public double[] rot;
	public ArrayList<SeatInstance> seats = new ArrayList<>();
	public HashMap<String, WheelTireData> wheeldata = new HashMap<>();
	public byte toggable_timer;
	public double max_steering_yaw;
	public int fuel_accumulator;
	public int fuel_consumed;
	public HashMap<String, LoopedSound> activesounds = new LinkedHashMap<>();
	//
	public boolean braking;
	public boolean pbrake;
	public boolean driven;
	public int gear_timer;
	public int autogear_timer;
	public EngineFunction engine;
	public TransmissionFunction transmission;
	//
	public static final float GRAVITY = 9.81f;
	public static final float GRAVITY_20th = GRAVITY / 20;
	public static final float GRAVITY_200th = GRAVITY / 200;
	//
	public static final int INTERACT_SUCCESS = 1;
	public static final int INTERACT_PASS = 0;
	public static final int INTERACT_FAIL = -1;
	//
	public static final String PKT_UPD_VEHICLEDATA = "vehicledata";
	public static final String PKT_UPD_LIGHTS = "toggle_lights";
	public static final String PKT_UPD_LOCK = "lock_state";
	public static final String PKT_UPD_TOGGLE_ATTR = "toggle_attr";
	public static final String PKT_UPD_UPDATE_ATTR = "update_attr";
	public static final String PKT_UPD_CONNECTOR = "vehicle_front";
	public static final String PKT_UPD_START_SOUND = "start_sound";
	public static final String PKT_UPD_STOP_SOUND = "stop_sound";
	public static final String PKT_UPD_ENGINE_TOGGLE = "engine_toggle";
	public static final String PKT_UPD_RAILENTITY = "rail_ent";
	public static final String PKT_UPD_ENTITY = "entity";

	public VehicleInstance(EntityW wrapper, VehicleData vdata){
		entity = wrapper;
		ref = new InteractRef(this);
		init(vdata, null);
	}

	public UUID getPlacer(){
		return placer;
	}

	public void setPlacer(UUID uuid){
		if(placer == null) placer = uuid;
	}

	public Pivot pivot(){
		return point.getPivot();
	}

	public Pivot prev_pivot(){
		return point.getPrevPivot();
	}

	public boolean onKeyPress(KeyPress key, Seat seat, EntityW player, boolean state, boolean sync){
		//TODO script key press event
		if(!seat.driver && key.driver_only()) return false;
		if(entity.isOnClient() && !key.control() && !sync){
			if(key.synced() && key.sync_state()){
				Packets.send(Packet_VehKeyPressState.class, key, state, entity.getId(), player.getId());
			}
			else{
				Packets.send(Packet_VehKeyPress.class, key);
			}
			if(!driven) return true;
		}
		switch(key){
			case ACCELERATE:{
				if(railent != null) railent.setThrottle(throttle);
				else{
					throttle += 0.01;
					if(throttle > 1) throttle = 1;
				}
				return true;
			}
			case DECELERATE:{
				if(railent != null) railent.setThrottle(throttle);
				else{
					throttle -= braking ? 0.05f : 0.01f;
					if(throttle < 0F) throttle = 0F;
				}
				/*else{
					throttle -= throttle > 0 ? 0.02 : 0.01;
					if(throttle < -1){
						throttle = -1;
					}
					SimplePhysData spdata = data.getType().getSphData();
					if(spdata != null && throttle < 0 && spdata.min_throttle == 0){
						throttle = 0;
					}

				}*/
				return true;
			}
			case TURN_LEFT:{
				if(type.isRailVehicle()){
					if(throttle > 0.05f) player.bar("fvtm.rail.decrease_throttle");
					else railent.setForward(player, false);
					return true;
				}
				steer_yaw -= 5;
				return true;
			}
			case TURN_RIGHT:{
				if(type.isRailVehicle()){
					if(throttle > 0.05f) player.bar("fvtm.rail.decrease_throttle");
					else railent.setForward(player, true);
					return true;
				}
				steer_yaw += 5;
				return true;
			}
			case BRAKE:{
				braking = state;
				/*if(braking){
					throttle *= 0.9;
					if(throttle > -0.001 && throttle < 0.0001) throttle = 0;
					for(UniWheel wheel : wheels.values()){
						if(wheel != null) wheel.mulMotion(0.9);
					}
				}*/
				return true;
			}
			case PBRAKE:{
				if(toggable_timer > 0) return true;
				pbrake = !pbrake;
				toggable_timer += 10;
				return true;
			}
			case ENGINE:{
				if(entity.isOnClient()) return true;
				toggleEngine();
				return true;
			}
			case DISMOUNT:{
				player.dismount(data.getRotationPoint(seat.swivel_point).getRelativeVector(seat.dis).add(getV3D()));
				return true;
			}
			case INVENTORY:{
				player.openUI(UIKeys.VEHICLE_MAIN, new V3I(entity.getId(), 0, 0));
				return true;
			}
			case SCRIPTS:{
				//TODO scripts ui
				return true;
			}
			case LIGHTS:{
				if(toggable_timer > 0) return true;
				if(data.getAttribute("lights").asBoolean()){
					if(type.isRailVehicle()){
						data.getAttribute("lights").set(false);
					}
					else if(data.getAttribute("lights_long").asBoolean()){
						data.getAttribute("lights").set(false);
						data.getAttribute("lights_long").set(false);
					}
					else{
						data.getAttribute("lights_long").set(true);
					}
				}
				else{
					data.getAttribute("lights").set(true);
				}
				sendUpdate(PKT_UPD_LIGHTS);
				if(type.isRailVehicle()){
					if(railent.getCompound().isMultiple()){
						boolean bool = data.getAttributeBoolean("lights", false);
						for(RailEntity ent : railent.getCompound().getEntitites()){
							ent.vehicle.data.getAttribute("lights").set(bool);
							ent.vehicle.sendUpdate(PKT_UPD_LIGHTS);
						}
					}
				}
				else{
					VehicleInstance trailer = rear;
					while(trailer != null){
						trailer.data.getAttribute("lights").set(data.getAttribute("lights").asBoolean());
						trailer.data.getAttribute("lights_long").set(data.getAttribute("lights_long").asBoolean());
						trailer.sendUpdate(PKT_UPD_LIGHTS);
						trailer = trailer.rear;
					}
				}
				toggable_timer = 10;
				return true;
			}
			case COUPLER_REAR:{
				if(toggable_timer > 0) return true;
				if(type.isRailVehicle()){
					railent.tryCoupling(player, false);
					toggable_timer = 10;
					return true;
				}
				return true;
			}
			case COUPLER_FRONT:{
				if(toggable_timer > 0) return true;
				if(type.isRailVehicle()){
					railent.tryCoupling(player, true);
					toggable_timer = 10;
					return true;
				}
				return true;
			}
			case GEAR_UP: {
				if(gear_timer <= 0){
					if(transmission == null) return true;
					int gear = data.getAttributeInteger("gear", 0);
					if(transmission.isAutomatic()){
						if(gear < 0){
							data.getAttribute("gear").set(0);
							updateAttr("gear");
						}
						else if(gear == 0){
							data.getAttribute("gear").set(1);
							updateAttr("gear");
						}
						autogear_timer += transmission.getShiftSpeed();
					}
					else if(gear + 1 <= transmission.getFGearAmount()){
						data.getAttribute("gear").set(gear + 1);
						updateAttr("gear");
					}
					gear_timer += 10;
				}
				return true;
			}
			case GEAR_DOWN: {
				if(gear_timer <= 0){
					if(transmission == null) return true;
					int gear = data.getAttributeInteger("gear", 0);
					if(transmission.isAutomatic()){
						if(gear > 0){
							data.getAttribute("gear").set(0);
							updateAttr("gear");
						}
						else if(gear == 0){
							data.getAttribute("gear").set(-1);
							updateAttr("gear");
						}
						autogear_timer += transmission.getShiftSpeed();
					}
					else if(gear - 1 >= -transmission.getRGearAmount()){
						data.getAttribute("gear").set(gear - 1);
						updateAttr("gear");
					}
					gear_timer += 10;
				}
				return true;
			}
			default:{
				player.bar("Action '" + key + "' not found.");
				return false;
			}
		}
	}

	public void toggleEngine(){
		if(toggable_timer > 0) return;
		TagCW com = TagCW.create();
		com.set("cargo", "engine_toggle");
		toggable_timer += 10;
		engine = data.getPart("engine").getFunction("fvtm:engine");
		if(entity.isOnClient()) engine.setState(com.getBoolean("engine_toggle_result"));
		else com.set("engine_toggle_result", engine.toggle());
		if(data.getStoredFuel() == 0){
			com.set("engine_toggle_result", engine.setState(false));
			com.set("no_fuel", true);
		}
		Packets.INSTANCE.send(this, com);
		throttle = 0;
	}

	public void updateAttr(String attrid){
		Attribute attr = data.getAttribute(attrid);
		if(attr == null) return;
		TagCW com = TagCW.create();
		com.set("cargo", PKT_UPD_UPDATE_ATTR);
		com.set("id", attrid);
		attr.save(com);
		Packets.INSTANCE.send(this, com);
	}

	public boolean getKeyPressState(KeyPress key){
		if(key == KeyPress.BRAKE){
			return braking;
		}
		return false;
	}

	public boolean consumeFuel(){
		if(data.outoffuel()) return false;
		if(engine.isOn()){
			if(throttle == 0d || (throttle < .05 && throttle > -.05)){
				fuel_consumed += engine.getIdleFuelConsumption();
			}
			else{
				fuel_consumed += engine.getFuelConsumption(data.getAttribute("fuel_secondary").asString()) * throttle;
			}
		}
		fuel_accumulator++;
		if(fuel_accumulator < 20) return engine.isOn();
		else{
			boolean cons = false;
			if(fuel_consumed > 0){
				int consumed = (int)(fuel_consumed / 20f);
				data.getAttribute("fuel_stored").decrease(consumed < 0 ? 1 : consumed);
				cons = true;
			}
			if(engine.isOn() && data.outoffuel()){
				//TODO send out of fuel packet
				//TODO play out of fuel sound
				throttle = 0;
				engine.setState(false);
			}
			fuel_accumulator = 0;
			fuel_consumed = 0;
			return cons;
		}
	}

	public V3D getV3D(){
		return entity.getPos();
	}

	public void updatePointsSeats(){
		for(SwivelPoint point : data.getRotationPoints().values()) point.update(this);
		for(SeatInstance seat : seats) seat.update();
		for(OBB.OBBRef ref : data.getBoundBoxes()){
			SwivelPoint point = data.getRotationPoint(ref.point);
			if(!obb.containsKey(ref.key)){
				obb.put(ref.key, new OBB());
			}
			obb.get(ref.key).update(point, ref.pos, entity.getPos(), ref.size.x, ref.size.y, ref.size.z);
		}
	}

	public void sendUpdatePacket(){
		data.getAttribute("throttle").set(throttle);
		if(entity.isOnClient()){
			Packets.send(Packet_VehMove.class, entity, this);
		}
		else{
			Packets.sendToAllTrackingEnt(Packet_VehMove.class, entity, entity, this);
		}
	}

	public SeatInstance getSeatOf(Object passenger){
		for(SeatInstance seat : seats){
			if(seat.passenger_direct() == passenger) return seat;
		}
		return null;
	}

	public SeatInstance getSeatOf(EntityW entity){
		return getSeatOf(entity.direct());
	}

	public void packet(TagCW packet, EntityW pass){
		String cargo = packet.getString("cargo");
		switch(cargo){
			case PKT_UPD_LOCK:{
				data.getLock().setLocked(packet.getBoolean("state"));
				return;
			}
			case PKT_UPD_LIGHTS:{
				data.getAttribute("lights").set(packet.getBoolean("lights"));
				if(data.hasAttribute("lights_long")){
					data.getAttribute("lights_long").set(packet.getBoolean("lights_long"));
				}
				return;
			}
			case PKT_UPD_TOGGLE_ATTR:{
				if(entity.isOnClient()){
					try{
						AttributeUtil.processToggleClient(this, packet, pass);
					}
					catch(Exception e){
						FvtmLogger.log(e, "attr toggle packet / " + packet);
					}
				}
				return;
			}
			case PKT_UPD_VEHICLEDATA:{
				data.read(packet);
				return;
			}
			case PKT_UPD_ENGINE_TOGGLE:{
				SeatInstance seaton = getSeatOf(pass);
				if(seaton != null && seaton.root == this){
					boolean state = packet.getBoolean("engine_toggle_result");
					if(engine.setState(state)){
						pass.send("interact.fvtm.vehicle.engine_toggled_on");
					}
					else{
						pass.send("interact.fvtm.vehicle.engine_toggled_off");
					}
					if(packet.has("no_fuel") && packet.getBoolean("no_fuel")){
						pass.send("interact.fvtm.vehicle.engine_no_fuel");
					}
					//TODO sounds
				}
				throttle = 0;
				Sound sound = data.getSound("engine_running");
				if(sound != null && sound.event != null){
					if(data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
						if(!isSoundActive("engine_running")) startSound("engine_running");
					}
					else stopSound("engine_running");
				}
				return;
			}
			case PKT_UPD_CONNECTOR:{
				int id = packet.getInteger("vehid");
				if(id < 0){
					if(front != null) front.rear = null;
					front = null;
				}
				VehicleInstance veh = ((FvtmWorld)entity.getWorld()).getVehicle(id);
				if(veh != null){
					veh.rear = this;
					front = veh;
				}
				return;
			}
			case PKT_UPD_START_SOUND:{
				if(pass.isOnClient()) startSound(packet.getString("sound"));
				return;
			}
			case PKT_UPD_STOP_SOUND:{
				if(pass.isOnClient()) stopSound(packet.getString("sound"));
				return;
			}
			case PKT_UPD_ENTITY:{
				if(entity != null) ((Holder)entity).onPacket(pass, packet);
				return;
			}
			case PKT_UPD_RAILENTITY:{
				if(railent != null) railent.onPacket(pass, packet);
				return;
			}
			case PKT_UPD_UPDATE_ATTR:{
				Attribute attr = data.getAttribute(packet.getString("id"));
				if(attr != null){
					attr.load(packet);
				}
				return;
			}
			default:{
				FvtmLogger.LOGGER.log("'" + data.getName() + "'/" + entity.getId() + " received invalid packet: " + packet.toString());
				return;
			}
		}
	}

	public boolean isBraking(){
		return braking;
	}

	public void assignWheels(){
		w_front_l = w_front_r = w_rear_l = w_rear_r = new WheelTireData();
		for(WheelTireData wheel : wheeldata.values()){
			if(!data.getType().isTrailer()){
				if(wheel.pos.x <= w_front_l.pos.x && wheel.pos.z <= w_front_l.pos.z){
					w_front_l = wheel;
					continue;
				}
				if(wheel.pos.x >= w_front_r.pos.x && wheel.pos.z <= w_front_r.pos.z){
					w_front_r = wheel;
					continue;
				}
			}
			if(wheel.pos.x <= w_rear_l.pos.x && wheel.pos.z >= w_rear_l.pos.z){
				w_rear_l = wheel;
				continue;
			}
			if(wheel.pos.x >= w_rear_r.pos.x && wheel.pos.z >= w_rear_r.pos.z){
				w_rear_r = wheel;
			}
		}
		if(data.getType().isTrailer()){
			w_front_l = new WheelTireData("_" + w_rear_l.id);
			w_front_l.asTrailerFront(w_rear_l);
			wheeldata.put(w_front_l.id, w_front_l);
			w_front_r = new WheelTireData("_" + w_rear_r.id);
			w_front_r.asTrailerFront(w_rear_r);
			wheeldata.put(w_front_r.id, w_front_r);
		}
	}

	private void setupAxles(){
		axles.clear();
		for(WheelTireData wheel : wheeldata.values()){
			Axle axle = null;
			for(Axle ax : axles){
				if(ax.pos.z == wheel.pos.z && ax.pos.y == wheel.pos.y){
					axle = ax;
					break;
				}
			}
			if(axle == null){
				axle = new Axle(axles.size(), new V3D(0, wheel.pos.y, wheel.pos.z));
				axles.add(axle);
			}
			axle.wheels.add(wheel);
			wheel.axle = axle;
		}
		axles.forEach(Axle::initCenter);
		double amin = 16, amax = -16;
		for(Axle axle : axles){
			if(axle.pos.z < amin){
				amin = axle.pos.z;
				ax_fron = axle;
			}
			if(axle.pos.z > amax){
				amax = axle.pos.z;
				ax_rear = axle;
			}
		}
		wheelbase = Math.abs(amin) + Math.abs(amax);
		cg_height = 0;
		for(Axle axle : axles){
			axle.weight_ratio = Math.abs(axle.pos.z) / wheelbase;
			cg_height += axle.pos.y;
		}
		cg_height /= axles.size();
	}

	public void sendUpdate(String type){
		sendUpdate(type, null);
	}

	public void sendUpdate(String type, TagCW com){
		if(entity == null) return;
		if(com == null) com = TagCW.create();
		com.set("cargo", type);
		switch(type){
			case PKT_UPD_VEHICLEDATA:{
				data.write(com);
				break;
			}
			case PKT_UPD_LOCK:{
				com.set("state", data.getLock().isLocked());
				break;
			}
			case PKT_UPD_LIGHTS:{
				com.set("lights", data.getAttribute("lights").asBoolean());
				if(data.hasAttribute("lights_long")) com.set("lights_long", data.getAttribute("lights_long").asBoolean());
				break;
			}
			case PKT_UPD_TOGGLE_ATTR:{
				break;
			}
			case PKT_UPD_CONNECTOR:{
				com.set("vehid", front == null ? -1 : front.entity.getId());
				break;
			}
		}
		Packets.INSTANCE.send(this, com);
	}

	public InteractRef iref(){
		ref.update();
		return ref;
	}

	private boolean isSoundActive(String key){
		return activesounds.containsKey(key) && activesounds.get(key).active;
	}

	public void startSound(String key){
		if(!entity.isOnClient()){
			TagCW com = TagCW.create();
			com.set("sound", key);
			sendUpdate(PKT_UPD_START_SOUND, com);
			return;
		}
		if(!activesounds.containsKey(key)){
			activesounds.put(key, new LoopedSound(this, data.getSound(key)));
		}
		activesounds.get(key).start();
	}

	public void stopSound(String key){
		if(!entity.isOnClient()){
			TagCW com = TagCW.create();
			com.set("sound", key);
			sendUpdate(PKT_UPD_STOP_SOUND, com);
			return;
		}
		if(activesounds.containsKey(key)) activesounds.get(key).stop();
	}

	/**
	 * @return first found Player passenger in a driver's seat
	 */
	public EntityW driver(){
		for(SeatInstance seat : seats){
			if(seat.seat.driver && seat.passengerIsPlayer()){
				return seat.passenger();
			}
		}
		return null;
	}

	public void onVehMovePkt(Packet_VehMove packet){
		if(driven) return;
		serv_pos = packet.pos;
		serv_rot = packet.rot;
		serv_steer = packet.steering;
		throttle = packet.throttle;
		if(data != null) data.getAttribute("fuel_stored").set(packet.fuel);
		serv_sync = Config.VEHICLE_SYNC_RATE;
		if(!entity.isOnClient()) sendUpdatePacket();
	}

	public void init(VehicleData vdata, TagCW com){
		if(vdata != null) data = vdata;
		if(com != null) read(com);
		if(data == null) return;
		type = data.getType().getVehicleType();
		point = data.getRotationPoint(null);
		if(com != null) point.loadPivot(com);
		max_steering_yaw = data.getAttributeInteger("max_steering_angle", 45);
		engine = data.getFunctionInPart("engine", "fvtm:engine");
		transmission = data.getFunctionInPart("transmission", "fvtm:transmission");
		//
		initWheels();
		seats.clear();
		for(int i = 0; i < data.getSeats().size(); i++){
			seats.add(new SeatInstance(this, i));
		}
		if(entity != null && !entity.isOnClient()){
			if(front != null) sendUpdate(PKT_UPD_CONNECTOR);
		}
		else{
			//TODO register for particles
		}
	}

	public void initWheels(){
		wheels.clear();
		if(!type.isRailVehicle()){
			for(Map.Entry<String, V3D> entry : data.getWheelPositions().entrySet()){
				if(entry.getKey().endsWith(":tire")) continue;
				WheelTireData wheel = new WheelTireData(entry.getKey());
				wheel.pos = entry.getValue();
				PartData part = data.getPart(entry.getKey());
				if(!((WheelInstallationHandler.WheelData)part.getType().getInstallHandlerData()).hasTire()){
					part = data.getPart(entry.getKey()+ ":tire");
					wheel.radius = ((TireInstallationHandler.TireData)part.getType().getInstallHandlerData()).getOuterRadius();
				}
				else{
					wheel.radius += ((WheelInstallationHandler.WheelData)part.getType().getInstallHandlerData()).getRadius();
				}
				wheel.function = part.getFunction(TireFunction.class, "fvtm:tire").getTireAttr(part);
				wheel.steering = data.getWheelSlots().get(entry.getKey()).steering;
				wheel.slot = data.getWheelSlots().get(entry.getKey());
				wheel.mirror = data.getWheelSlots().get(entry.getKey()).mirror;
				wheeldata.put(entry.getKey(), wheel);
			}
			assignWheels();
			setupAxles();
		}
	}

	public void onRemove(){
		if(Config.VEHICLES_DROP_CONTENTS && !entity.isOnClient()){
			for(String part : data.getInventories()){
				InventoryFunction func = data.getPart(part).getFunction("fvtm:inventory");
				if(func == null) continue;
				func.inventory().clearAt(entity);
			}
		}
		for(UniWheel wheel : wheels.values()) wheel.remove();
		if(!type.isRailVehicle()){
			if(front != null) front.rear = null;
			if(rear != null) rear.front = null;
		}
	}

	public int onInteract(EntityW player, StackWrapper stack){
		if(entity.isOnClient()){
			if(!stack.empty() && stack.isItemOf(ContentType.PART.item_type)) return INTERACT_SUCCESS;
			if(Lockable.isKey(stack.getItem())) return INTERACT_SUCCESS;
			if(data.getLock().isLocked()){
				player.bar("interact.fvtm.vehicle.locked");
				return INTERACT_SUCCESS;
			}
			InteractionHandler.handle(KeyPress.MOUSE_RIGHT, data, iref(), null, player, stack);
			return INTERACT_SUCCESS;
		}
		if(Lockable.isKey(stack.getItem()) && !isFuelContainer(stack)){
			data.getLock().toggle(player, stack);
			sendUpdate(PKT_UPD_LOCK);
		}
		if(!stack.empty()){
			if(isFuelContainer(stack)){
				player.openUI(UIKeys.VEHICLE_FUEL, entity.getId(), 0, 0);
			}
			else if(stack.isItemOf(ContentType.TOOLBOX.item_type)){
				int type = stack.getContent(ContentType.TOOLBOX.item_type);
				switch(type){
					case 1:{
						player.openUI(UIKeys.TOOLBOX_TEXTURE, entity.getId(), 0, 0);
						break;
					}
					case 2:{
						player.openUI(UIKeys.TOOLBOX_COLORS, entity.getId(), 0, 0);
						break;
					}
					default: break;
				}
				return INTERACT_SUCCESS;
			}
			else if(stack.isItemOf(ContentType.VEHICLE.item_type) && type.isLandVehicle()){
				VehicleData tdat = stack.getContent(ContentType.VEHICLE.item_type);
				if(tdat.getType().isTrailer()){
					if(!data.hasCompatibleConnector(tdat.getType().getCategories())){
						player.send("interact.fvtm.vehicle.no_compatible_connector");
						FvtmLogger.debug(data.getConnectors());
						return INTERACT_SUCCESS;
					}
					if(!SimplePhysSpawnSystem.validToSpawn(player, stack, tdat)) return INTERACT_SUCCESS;
					if(rear != null){
						player.send("interact.fvtm.vehicle.disconnect_trailer");
						return INTERACT_SUCCESS;
					}
					((FvtmWorld)entity.getWorld()).spawnLandEntity(tdat, this, player);
				}
				return INTERACT_SUCCESS;
			}
			else if(stack.isItemOf(ContentType.CONTAINER.item_type)){
				//TODO
				return INTERACT_SUCCESS;
			}
			else{
				if(engine != null && engine.isOn()){
					player.send("interact.fvtm.vehicle.engine_on");
				}
				else{
					player.openUI(UIKeys.VEHICLE_MAIN, entity.getId(), 0, 0);
				}
				return INTERACT_SUCCESS;
			}
		}
		if(data.getLock().isLocked()){
			player.bar("interact.fvtm.vehicle.locked");
		}
		return INTERACT_PASS;
	}

	public boolean onSeatInteract(SeatInstance seat, EntityW player){
		if(entity.isOnClient()) return false;
		StackWrapper stack = player.getHeldItem(true);
		Passenger pass = UniEntity.getApp(player, Passenger.class);
		if(Lockable.isKey(stack.getItem()) && !isFuelContainer(stack)){
			data.getLock().toggle(pass.entity, UniStack.getStack(stack));
			sendUpdate(VehicleInstance.PKT_UPD_LOCK);
			return true;
		}
		if(data.getLock().isLocked()){
			player.send("interact.fvtm.vehicle.locked");
			return true;
		}
		if(seat.interacttimer > 0) return false;
		if(stack.isItemOf(IT_LEAD)){
			if(seat.passenger() != null){
				if(seat.passenger().isPlayer()) return false;
				if(seat.passenger().isLiving()){
					EntityW ent = seat.passenger().local();
					ent.dismount(seat.seat.dis);
					ent.setLeash(player, true);
					seat.interacttimer += 10;
					return true;
				}
			}
			List<EntityW> nearby = entity.getWorld().getEntities(pos, 10);
			for(EntityW lent : nearby){
				if(!lent.isLiving() || lent == player) continue;
				if(lent.getLeash().direct() == player.direct()){
					Passenger lpass = UniEntity.getApp(lent, Passenger.class);
					if(!seat.seat.allow(lpass.entity)){
						player.bar("interact.fvtm.vehicle.seat_wrong_type", lent.getName());
						continue;
					}
					lent.setLeash(player, false);
					lpass.set(entity.getId(), seat.index);
					seat.passenger(lent);
					lent.mount(entity);
					break;
				}
			}
			seat.interacttimer += 10;
			return true;
		}
		if(seat.passenger() == null){
			if(!seat.seat.allow(pass.entity)){
				player.send("interact.fvtm.vehicle.seat_not_player");
				return false;
			}
			if(player.isRiding() && player.getVehicleDirect().equals(entity.direct())){
				SeatInstance oseat = getSeatOf(player);
				oseat.passenger(null);
			}
			else{
				player.mount(entity);
			}
			pass.set(entity.getId(), seat.index);
			seat.passenger(pass.entity);
			seat.interacttimer += 10;
			return true;
		}
		return false;
	}

	public boolean isDriverInstance(){
		if(entity == null) return true;
		if(type.isRailVehicle()) return !entity.isOnClient();
		boolean driven = false;
		for(SeatInstance seat : seats){
			if(seat.seat.driver && seat.passengerIsPlayer()){
				driven = true;
				break;
			}
		}
		return driven == entity.isOnClient();
	}

	public void onUpdate(){
		driven = isDriverInstance();
		boolean remote = entity.isOnClient();
		if(!remote && !type.isRailVehicle()){
			checkWheelPresence(w_front_l.id);
			checkWheelPresence(w_front_r.id);
			checkWheelPresence(w_rear_l.id);
			checkWheelPresence(w_rear_r.id);
		}
		point.updatePrevAxe();
		if(toggable_timer > 0) toggable_timer--;
		if(gear_timer > 0) gear_timer--;
		if(autogear_timer > 0) autogear_timer--;
		if(driven) steer_yaw *= Config.STEER_RESET_RATE;
		if(steer_yaw > max_steering_yaw) steer_yaw = max_steering_yaw;
		if(steer_yaw < -max_steering_yaw) steer_yaw = -max_steering_yaw;
		//
		pos = entity.getPos();
		prev = entity.getPrevPos();
		rot = point.getPivot().toArray();
		for(UniWheel wheel : wheels.values()){
			if(wheel != null) wheel.updatePrevPos();
		}
		if(!driven){
			if(serv_sync > 0){
				if(rot[0] < -90 && serv_rot[0] > 90) rot[0] += 360;
				if(rot[0] > 90 && serv_rot[0] < -90) rot[0] -= 360;
				pos.x = pos.x + (serv_pos[0] - pos.x) / serv_sync;
				pos.y = pos.y + (serv_pos[1] - pos.y) / serv_sync;
				pos.z = pos.z + (serv_pos[2] - pos.z) / serv_sync;
				rot[0] = valDeg(rot[0] + (serv_rot[0] - rot[0]) / serv_sync);
				rot[1] = valDeg(rot[1] + (serv_rot[1] - rot[1]) / serv_sync);
				rot[2] = valDeg(rot[2] + (serv_rot[2] - rot[2]) / serv_sync);
				steer_yaw += (serv_steer - steer_yaw) / serv_sync;
				serv_sync--;
				entity.setPos(pos);
				pivot().set_rotation(rot[0], rot[1], rot[2], true);
				V3D om = new V3D();
				for(UniWheel wheel : wheels.values()){
					if(wheel != null && wheel.wtd() != null){
						wheel.fillMotion(om);
						pullBackWheel(wheel);
						wheel.setMotion(om.x, om.y, om.z);
					}
				}
			}
			if(type.isRailVehicle()){
				if(railent == null || railent.current == null) return;
				V3D bf0 = railent.moveOnly((float)(railent.passed + 0.1));
				V3D bf1 = railent.moveOnly((float)(railent.passed - 0.1));
				V3D br0 = railent.moveOnly((float)(railent.passed - railent.frbogiedis - railent.rrbogiedis + 0.1));
				V3D br1 = railent.moveOnly((float)(railent.passed - railent.frbogiedis - railent.rrbogiedis - 0.1));
				if(bf0 != null && br0 != null && bf1 != null && br1 != null){
					data.getAttribute("bogie_front_angle").set(-toDegrees(Math.atan2(bf0.z - bf1.z, bf0.x - bf1.x) - point.getPivot().yaw()) + 90);
					data.getAttribute("bogie_rear_angle").set(-toDegrees(Math.atan2(br0.z - br1.z, br0.x - br1.x) - point.getPivot().yaw()) + 90);
				}
			}
		}
		else{
			serv_sync = 0;
			onUpdateMovement();
		}
		updatePointsSeats();
		if(driven && entity.getTicks() % VEHICLE_SYNC_RATE == 0){
			sendUpdatePacket();
		}
		if(remote){
			updateSpeed();
			if(!type.isRailVehicle()){
				AttrFloat attr = (AttrFloat)data.getAttribute("steering_angle");
				attr.initial = attr.value;
				attr.value = (float)steer_yaw;
				double dir = Math.abs(pivot().yaw() + rad180) - Math.abs(-Math.atan2(prev.x - pos.x, prev.z - pos.z) + rad180);
				dir = dir > rad90 || dir < -rad90 ? -1 : 1;
				for(WheelTireData val : wheeldata.values()){
					val.rotation = valDegF(val.rotation + speed * dir * val.radius * 100);
				}
			}
			data.setAttribute("throttle", throttle);
			data.setAttribute("speed", speed * 72);
			data.getAttribute("rpm").set(rpm / 100 * 100);
		}
		else{
			for(SwivelPoint point : data.getRotationPoints().values()){
				point.sendUpdatePacket(entity);
			}
		}
	}

	private void updateSpeed(){
		double x = pos.x - prev.x, y = pos.y - prev.y, z = pos.z - prev.z;
		while(avsp.size() < 10) avsp.add(speed);
		avsp.add(Math.sqrt(x * x + y * y + z * z) * 1000F / 20f);
		avsp.remove(0);
		speed = 0;
		for(double d : avsp) speed += d;
		speed /= avsp.size();
	}

	private void checkWheelPresence(String id){
		if(!wheels.containsKey(id) || !wheels.get(id).isAdded()){
			wheels.put(id, ((FvtmWorld)entity.getWorld()).spawnWheel(this, id));
		}
	}

	private void onUpdateMovement(){
		EntityW driver = driver();
		boolean creative = driver != null && driver.isCreative();
		V3D fro, rea, lef, rig;
		if(type.isRailVehicle()){
			data.getAttribute("section_on").set(railent.current.getUnit().section().getUID());
			railent.alignEntity(false);
			//
			fro = railent.bfront;
			rea = railent.brear;
			lef = rig = new V3D((fro.x + rea.x) * 0.5, (fro.y + rea.y) * 0.5, (fro.z + rea.z) * 0.5);
		}
		else{
			if(driver == null || (!creative && data.outoffuel())){
				throttle *= 0.98;
				speed *= 0.9;
			}
			if(front == null) remass();
			move(!VEHICLES_NEED_FUEL || !data.getAttribute("use-fuel").asBoolean() || creative);
			if(rear != null) rear.align();
			//
			V3D fl = wheels.get(w_front_l.id).pos();
			V3D fr = wheels.get(w_front_r.id).pos();
			V3D rl = wheels.get(w_rear_l.id).pos();
			V3D rr = wheels.get(w_rear_r.id).pos();
			if(fl == null) return;
			fro = new V3D((fl.x + fr.x) * 0.5, (fl.y + fr.y) * 0.5, (fl.z + fr.z) * 0.5);
			rea = new V3D((rl.x + rr.x) * 0.5, (rl.y + rr.y) * 0.5, (rl.z + rr.z) * 0.5);
			lef = new V3D((fl.x + rl.x) * 0.5, (fl.y + rl.y) * 0.5, (fl.z + rl.z) * 0.5);
			rig = new V3D((fr.x + rr.x) * 0.5, (fr.y + rr.y) * 0.5, (fr.z + rr.z) * 0.5);
		}
		double dx = rea.x - fro.x, dy = rea.y - fro.y, dz = rea.z - fro.z;
		double drx = rig.x - lef.x, dry = rig.y - lef.y, drz = rig.z - lef.z;
		double dxz = Math.sqrt(dx * dx + dz * dz);
		double y = -Math.atan2(dx, dz);
		double p = -Math.atan2(dy, dxz);
		double r = Math.atan2(dry, Math.sqrt((drx * drx + drz * drz)));
		pivot().set_rotation(y, p, r, false);
		angor = pivot().yaw() - prev_pivot().yaw();
	}

	private void remass(){
		if(rear != null){
			VehicleInstance trailer = rear;
			while(trailer.rear != null) trailer = trailer.rear;
			VehicleInstance truck = trailer.front;
			trailer.appmass = trailer.data.getAttributeFloat("weight", 1000);
			while(truck != null){
				truck.appmass = truck.data.getAttributeFloat("weight", 1000);
				truck.appmass += truck.rear.appmass * truck.rear.data.getAttributeFloat("trailer_weight_ratio", 0.2f);
				truck = truck.front;
			}
		}
		else appmass = data.getAttributeFloat("weight", 1000f);
	}

	private boolean noPassengers(){
		for(SeatInstance seat : seats){
			if(seat.passenger() != null) return false;
		}
		return true;
	}

	private void move(boolean nocons){
		if(data.getType().isTrailer()) return;
		double mass = appmass;
		double rr = data.getAttributeFloat("roll_resistance", 8f);
		double ar = data.getAttributeFloat("air_resistance", 2.5f);
		for(Axle axle : axles) axle.calc(mass, accel, cg_height, wheelbase, angor);
		overloaded = appmass - data.getAttributeFloat("weight", 1000f) > data.getAttributeFloat("max_towing", 3500f);
		move.set(0, 0, 0);
		boolean cons = nocons || (engine != null && consumeFuel());
		boolean nopass = noPassengers();
		double brkf = data.getAttributeFloat("brake_force", 10000f);
		double brake = Math.min((braking ? brkf : 0) + (pbrake ? data.getAttributeFloat("parking_brake_force", 5000f) : 0), brkf);
		int gear = data.getAttributeInteger("gear", 0);
		float diff = data.getAttributeFloat("differential_ratio", 3.5f);
		if(engine != null && transmission != null){
			orpm = rpm;
			rpm = (int)((speed / axles.get(0).wheels.get(0).radius) * transmission.getRatio(gear) * diff * 60 / Static.PI2);
			rpm = (orpm + rpm) / 2;
			if(rpm < 0) rpm = -rpm;
			if(rpm < engine.minRPM()) rpm = engine.minRPM();
			if(rpm > engine.maxRPM()) rpm = engine.maxRPM();
		}
		float force = 0;
		if(!overloaded && engine != null && transmission != null){
			force = engine.getTorque(rpm) * transmission.getRatio(gear) * diff * transmission.getEfficiency() / axles.get(0).wheels.get(0).radius;
			if(transmission.isAutomatic() && autogear_timer <= 0){
				int ngear = transmission.processAutoShift(gear, rpm, engine.maxRPM(), throttle);
				if(ngear != gear){
					data.getAttribute("gear").set(ngear);
					updateAttr("gear");
				}
				autogear_timer += transmission.getShiftSpeed();
			}
		}
		double thr = throttle * force;
		double steer_rad = Math.toRadians(steer_yaw);
		boolean slowdown = throttle < 0.001f || gear == 0 || nopass;
		entity.setOnGround(true);
		accel = 0;
		//
		boolean raining;
		V3D wmot = new V3D();
		WheelTireData wtd;
		for(UniWheel wheel : wheels.values()){
			if(wheel == null || wheel.wtd() == null) continue;
			wtd = wheel.wtd();
			wheel.prepare();
			wheel.yaw(pivot().deg_yaw());
			raining = entity.getWorld().isRainingAt(wheel.pos().x, wheel.pos().y - sixteenth, wheel.pos().z);
			wheel.fillMotion(wmot);
			if(slowdown || speed < 1){
				boolean brk = braking || pbrake;
				double by = brk || (slowdown && speed < 1) ? 0 : speed < 1 ? 0.9 : 0.99;
				wmot.x *= by;
				wmot.z *= by;
			}
			wmot.x *= 0.8;
			wmot.y = -GRAVITY_20th;
			wmot.z *= 0.8;
			//
			double s = -Math.cos(-pivot().yaw());
			double c = -Math.sin(-pivot().yaw());
			double mov_for = c * wmot.x + s * wmot.z;
			double mov_sid = c * wmot.z - s * wmot.x;
			double steer_sig = wtd.slot.steering ? Math.signum(mov_for) * steer_rad : 0;
			double slip = Math.atan2(mov_sid + wtd.axle.yaw_speed, Math.abs(mov_for)) - steer_sig;
			double grip = wtd.function.getGripFor(null, raining);
			if(wtd.slot.braking && pbrake) grip *= wtd.function.brake_grip;
			double fric = Static.clamp(-wtd.function.getCornerStiffnessFor(null, wtd.slot.steering) * slip, -grip, grip) * wtd.axle.weight_on;
			double trac = (cons ? thr : 0) - brake * Math.signum(mov_for);
			//if(trac < 0) trac = 0;
			double drag_f = -rr * mov_for - ar * mov_for * Math.abs(mov_for);
			double drag_s = -rr * mov_sid - ar * mov_sid * Math.abs(mov_sid);
			double total_f = drag_f + trac;
			double total_s = drag_s + Math.cos(steer_rad) * fric;
			double res_f = (total_f / mass) * 0.05;// * MOTION_SCALE;
			double res_s = (total_s / mass) * 0.05;// * MOTION_SCALE;
			accel += (total_f / mass);
			wmot.x += c * res_f - s * res_s;
			wmot.z += s * res_f + c * res_s;
			//
			wheel.setMotion(wmot.x, wmot.y, wmot.z);
			wheel.move();
			moveToWheel(wheel);
			wheel.fillMotion(wmot);
			pullBackWheel(wheel);
			wheel.setMotion(wmot.x, wmot.y, wmot.z);
		}
		moveFinish();
		accel /= wheels.size();
	}

	private void pullBackWheel(UniWheel wheel){
		wheel.prepare();
		wheel.yaw(pivot().deg_yaw());
		V3D dest = pivot().get_vector(wheel.wtd().pos);
		dest.x = (dest.x - (wheel.pos().x - pos.x)) * 0.25;
		dest.y = (dest.y - (wheel.pos().y - pos.y)) * 0.25;
		dest.z = (dest.z - (wheel.pos().z - pos.z)) * 0.25;
		wheel.setMotion(dest.x, dest.y, dest.z);
		wheel.move();
	}

	private void moveFinish(){
		move.x += pos.x;
		move.y += pos.y;
		move.z += pos.z;
		entity.setPrevPos(pos);
		entity.setPos(move);
		//speed = Math.sqrt(move.x * move.x + move.z * move.z);
	}

	private void moveToWheel(UniWheel wheel){
		V3D dest = pivot().get_vector(wheel.wtd().pos);
		dest.x = (dest.x - (wheel.pos().x - pos.x)) * 0.25;
		dest.y = (dest.y - (wheel.pos().y - pos.y)) * 0.25;
		dest.z = (dest.z - (wheel.pos().z - pos.z)) * 0.25;
		if(dest.length() > 0.001){
			V3D.sub(dest, move);
		}
	}

	/** for trailers */
	private void align(){
		entity.setPrevPos(entity.getPos());
		if(wheels.isEmpty() || front == null) return;
		V3D conn = front.pivot().get_vector(front.data.getConnectorFor(data.getType().getCategories()));
		V3D.add(front.getV3D(), conn);
		entity.setPos(conn);
		throttle = front.throttle;
		V3D wl = wheels.get(w_rear_l.id).pos();
		V3D wr = wheels.get(w_rear_r.id).pos();
		pivot().set_rotation(-Math.atan2((wl.x + wr.x) * 0.5 - conn.x, (wl.z + wr.z) * 0.5 - conn.z), pivot().pitch(), pivot().roll(), false);
		move.x = move.y = move.z = 0;
		pos = entity.getPos();
		for(UniWheel wheel : wheels.values()){
			wheel.prepare();
			wheel.yaw(pivot().deg_yaw());
			V3D dest = pivot().get_vector(wheel.wtd().pos);
			dest.x = (dest.x - (wheel.pos().x - pos.x)) * 0.5;
			dest.y = (dest.y - (wheel.pos().y - pos.y)) * 0.5;
			dest.z = (dest.z - (wheel.pos().z - pos.z)) * 0.5;
			wheel.addMotion(dest.x, dest.y, dest.z);
			wheel.move();
			moveToWheel(wheel);
		}
		moveFinish();
		if(rear != null) rear.align();
	}

	public void save(TagCW com){
		data.write(com);
		point.savePivot(com);
		com.set("ParkingBrake", pbrake);
	}

	private void read(TagCW com){
		if(data == null){
			data = FvtmResources.getVehicleData(com);
		}
		else{
			data.read(com);
		}
		pbrake = com.getBoolean("ParkingBrake");
	}

	public static interface Holder {

		public VehicleInstance getVehicleInstance();

		public void onPacket(EntityW pass, TagCW com);

		public static VehicleInstance getFromPlayer(EntityW player){
			if(player.getVehicleDirect() instanceof Holder){
				return ((Holder)player.getVehicleDirect()).getVehicleInstance();
			}
			return null;
		}

	}

}
