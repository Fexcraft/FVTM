package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.*;
import net.fexcraft.mod.fvtm.data.attribute.AttrFloat;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.vehicle.SimplePhysData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.function.part.TireFunction;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.MathUtils;
import net.fexcraft.mod.fvtm.util.EntityWIE;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.fexcraft.lib.common.Static.rad180;
import static net.fexcraft.lib.common.Static.rad90;
import static net.fexcraft.mod.fvtm.Config.VEHICLES_NEED_FUEL;
import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.*;
import static net.fexcraft.mod.fvtm.ui.UIKeys.VEHICLE_MAIN;
import static net.fexcraft.mod.fvtm.util.MathUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity {

	public VehicleInstance vehicle;
	protected SimplePhysData spdata;
	public HashMap<String, WheelEntity> wheels = new HashMap<>();
	public BoundingBox renderbox;
	public float rotZ = 0;
	public float protZ = 0;
	public float wheel_radius = 0;
	public float wheel_rotation = 0;
	public boolean should_sit = true;
	//
	public double serverX;
	public double serverY;
	public double serverZ;
	public double serverYaw;
	public double serverPitch;
	public double serverRoll;
	public double serverSteer;
	public byte server_sync;

	public RootVehicle(EntityType<?> type, Level level){
		super(type, level);
		vehicle = new VehicleInstance(new EntityWIE(this), null);
	}

	public void initVD(VehicleData data){
		vehicle.init(data);
		init(null);
	}

	protected void init(TagCW com){
		spdata = vehicle.data.getType().getSphData();
		wheels.clear();
		wheel_radius = 0;
		if(!vehicle.type.isRailVehicle()){
			for(Map.Entry<String, V3D> entry : vehicle.data.getWheelPositions().entrySet()){
				if(entry.getKey().endsWith(":tire")) continue;
				WheelTireData wheel = new WheelTireData(entry.getKey());
				wheel.pos = entry.getValue();
				PartData part = vehicle.data.getPart(entry.getKey());
				if(!((WheelInstallationHandler.WheelData)part.getType().getInstallHandlerData()).hasTire()){
					part = vehicle.data.getPart(entry.getKey() + ":tire");
					wheel_radius += ((TireInstallationHandler.TireData)part.getType().getInstallHandlerData()).getOuterRadius();
				}
				else{
					wheel_radius += ((WheelInstallationHandler.WheelData)part.getType().getInstallHandlerData()).getRadius();
				}
				wheel.function = part.getFunction(TireFunction.class, "fvtm:tire").getTireAttr(part);
				wheel.steering = vehicle.data.getWheelSlots().get(entry.getKey()).steering;
				wheel.mirror = vehicle.data.getWheelSlots().get(entry.getKey()).mirror;
				vehicle.wheeldata.put(entry.getKey(), wheel);
			}
			vehicle.assignWheels();
			wheel_radius /= vehicle.wheeldata.size();
		}
		vehicle.seats.clear();
		for(int i = 0; i < vehicle.data.getSeats().size(); i++){
			vehicle.seats.add(new SeatInstance(vehicle, i));
		}
		if(!level().isClientSide && vehicle.front != null && !vehicle.type.isRailVehicle()){
			vehicle.sendUpdate(PKT_UPD_CONNECTOR);
		}
		if(level().isClientSide){
			int cr = (int)vehicle.data.getAttributeFloat("collision_range", 2f);
			renderbox = new BoundingBox(-cr, -cr, -cr, cr, cr, cr);
		}
	}

	@Override
	protected void defineSynchedData(){

	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag){
		TagCW com = TagCW.wrap(tag);
		if(vehicle.data == null){
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
		}
		else{
			vehicle.data.read(com);
		}
		setXRot(com.getFloat("RotationPitch"));
		setYRot(com.getFloat("RotationYaw"));
		protZ = rotZ = com.getFloat("RotationYaw");
		setOldPosAndRot();
		vehicle.point.loadPivot(com);
		init(com);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag){
		TagCW com = TagCW.wrap(tag);
		vehicle.data.write(com);
		vehicle.point.savePivot(com);
	}

	public void writeSpawnData(FriendlyByteBuf buffer){
		TagCW com = TagCW.create();
		vehicle.point.savePivot(com);
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
		writeSpawnData(com);
		vehicle.data.write(com);
		buffer.writeNbt(com.local());
	}

	public void readSpawnData(FriendlyByteBuf buffer){
		try{
			TagCW com = TagCW.wrap(buffer.readNbt());
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
			vehicle.point.loadPivot(com);
			readSpawnData(com);
			setYRot(vehicle.point.getPivot().deg_yaw());
			setXRot(vehicle.point.getPivot().deg_pitch());
			protZ = rotZ = vehicle.point.getPivot().deg_roll();
			setOldPosAndRot();
			if(com.has("TruckId")){
				vehicle.front = ((RootVehicle)level().getEntity(com.getInteger("TruckId"))).vehicle;
				vehicle.front.rear = vehicle;
			}
			init(com);
		}
		catch(Exception e){
			e.printStackTrace();
			FvtmLogger.LOGGER.log("Failed to read additional spawn data for vehicle entity with ID " + getId() + "!");
		}
	}

	public void writeSpawnData(TagCW com){}

	public void readSpawnData(TagCW com){}

	@Override
	public void kill(){
		if(Config.VEHICLES_DROP_CONTENTS && !level().isClientSide){
			for(String part : vehicle.data.getInventories()){
				InventoryFunction func = vehicle.data.getPart(part).getFunction("fvtm:inventory");
				if(func == null) continue;
				//TODO func.inventory().dropAllAt(this);
			}
		}
		super.kill();
		if(!wheels.isEmpty()){
			for(WheelEntity wheel : wheels.values()) wheel.kill();
		}
		if(!vehicle.type.isRailVehicle()){
			if(vehicle.front != null) vehicle.front.rear = null;
			if(vehicle.rear != null) vehicle.rear.front = null;
		}
	}

	public void setPosRotMot(V3D pos, double yaw, double pit, double rol, double thr, double steer, int fuel){
		serverX = pos.x;
		serverY = pos.y;
		serverZ = pos.z;
		serverYaw = yaw;
		serverPitch = pit;
		serverRoll = rol;
		serverSteer = steer;
		server_sync = Config.VEHICLE_SYNC_RATE;
		vehicle.throttle = thr;
		vehicle.data.getAttribute("fuel_stored").set(fuel);
	}

	@Override
	public boolean isPickable(){
		return true;
	}

	@Override
	public boolean canBeCollidedWith(){
		return true;
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand){
		if(isRemoved() || hand == InteractionHand.OFF_HAND) return InteractionResult.PASS;
		ItemStack stack = player.getItemInHand(hand);
		StackWrapper wrapper = UniStack.getStack(stack);
		Passenger pass = UniEntity.getCasted(player);
		if(level().isClientSide){
			if(!stack.isEmpty() && stack.getItem() instanceof PartItem == false) return InteractionResult.SUCCESS;
			if(Lockable.isKey(wrapper.getItem())) return InteractionResult.SUCCESS;
			if(vehicle.data.getLock().isLocked()){
				player.sendSystemMessage(Component.translatable("interact.fvtm.vehicle.locked"));
				return InteractionResult.SUCCESS;
			}
			InteractionHandler.handle(KeyPress.MOUSE_RIGHT, vehicle.data, vehicle.iref(), null, pass, wrapper);
			return InteractionResult.SUCCESS;
		}
		if(Lockable.isKey(wrapper.getItem()) && !isFuelContainer(stack.getItem())){
			vehicle.data.getLock().toggle(pass, wrapper);
			vehicle.sendUpdate(PKT_UPD_LOCK);
			return InteractionResult.SUCCESS;
		}
		if(!stack.isEmpty()){
			if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isFuelContainer()){
				pass.openUI(UIKeys.VEHICLE_FUEL, new V3I(getId(), 0, 0));
				return InteractionResult.SUCCESS;
			}
			else if(stack.getItem() instanceof ToolboxItem){
				int var = ((ToolboxItem)stack.getItem()).var;
				if(var == 0){

				}
				else if(var == 1){
					pass.openUI(UIKeys.TOOLBOX_TEXTURE, new V3I(getId(), 0, 0));
				}
				else if(var == 2){
					pass.openUI(UIKeys.TOOLBOX_COLORS, new V3I(getId(), 0, 0));
				}
				return InteractionResult.SUCCESS;
			}
			else if(stack.getItem() instanceof VehicleItem && vehicle.type.isLandVehicle()){
				VehicleData data = ((VehicleItem)stack.getItem()).getData(TagCW.wrap(stack.getTag()));
				if(data.getType().isTrailer()){
					if(!vehicle.data.hasCompatibleConnector(data.getType().getCategories())){
						pass.send("interact.fvtm.vehicle.no_compatible_connector");
						FvtmLogger.debug(vehicle.data.getConnectors());
						return InteractionResult.SUCCESS;
					}
                	//TODO position/data validation
					if(vehicle.rear != null){
						pass.send("interact.fvtm.vehicle.disconnect_trailer");
						return InteractionResult.SUCCESS;
					}
					RootVehicle veh = FvtmGetters.getNewVehicle(level());
					veh.vehicle.front = this.vehicle;
					vehicle.rear = veh.vehicle;
					veh.initVD(data);
					veh.vehicle.point.updatePrevAxe();
					veh.vehicle.point.getPivot().copy(vehicle.point.getPivot());
					veh.setPos(position());
					level().addFreshEntity(veh);
				}
				return InteractionResult.SUCCESS;
			}
			/*else if(stack.getItem() instanceof ContainerItem){
				//TODO open container ui
				return InteractionResult.SUCCESS;
			}*/
			else{
				if(vehicle.data.hasPart("engine") && vehicle.data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
					player.sendSystemMessage(Component.translatable("interact.fvtm.vehicle.engine_on"));
				}
				else{
					pass.openUI(VEHICLE_MAIN, new V3I(0, getId(), 0));
				}
				return InteractionResult.SUCCESS;
			}
		}
		if(vehicle.data.getLock().isLocked()){
			player.sendSystemMessage(Component.translatable("interact.fvtm.vehicle.locked"));
			return InteractionResult.SUCCESS;
		}
		//temporary until seat interaction is added
		player.startRiding(this);
		return InteractionResult.SUCCESS;
		//return InteractionResult.FAIL;
	}

	private boolean isFuelContainer(Item item){
		if(item instanceof MaterialItem == false) return false;
		return ((MaterialItem)item).getContent().isFuelContainer();
	}

	@Override
	public void tick(){
		super.tick();
		if(isRemoved()) return;
		if(vehicle.data == null){
			FvtmLogger.LOGGER.log("Vehicle '" + getId() + "' has no data, skipping update.");
			return;
		}
		if(!level().isClientSide){
			for(Map.Entry<String, WheelTireData> entry : vehicle.wheeldata.entrySet()){
				if(!wheels.containsKey(entry.getKey()) || !wheels.get(entry.getKey()).isAddedToWorld()){
					wheels.put(entry.getKey(), FvtmGetters.getNewWheel(this, entry.getKey()));
					level().addFreshEntity(wheels.get(entry.getKey()));
				}
			}
		}
		yRotO = vehicle.point.getPivot().deg_yaw();
		xRotO = vehicle.point.getPivot().deg_pitch();
		protZ = vehicle.point.getPivot().deg_roll();
		vehicle.point.updatePrevAxe();
		tickCount++;
		if(tickCount >= Integer.MAX_VALUE) tickCount = 0;
		if(vehicle.toggable_timer > 0) vehicle.toggable_timer--;
		//
		vehicle.checkSteerAngle(level().isClientSide);
		if(level().isClientSide){
			if(server_sync > 0){
				double x = position().x + (serverX - position().x) / server_sync;
				double y = position().y + (serverY - position().y) / server_sync;
				double z = position().z + (serverZ - position().z) / server_sync;
				double yw = valDeg(serverYaw - vehicle.pivot().deg_yaw());
				double pt = valDeg(serverPitch - vehicle.pivot().deg_pitch());
				double rl = valDeg(serverRoll - vehicle.pivot().deg_roll());
				setYRot((float)(vehicle.pivot().deg_yaw() + yw / server_sync));
				setXRot((float)(vehicle.pivot().deg_pitch() + pt / server_sync));
				rotZ = (float)(vehicle.pivot().deg_roll() + rl / server_sync);
				vehicle.steer_yaw += (serverSteer - vehicle.steer_yaw) / server_sync;
				server_sync--;
				setPos(x, y, z);
				vehicle.pivot().set_rotation(getYRot(), getXRot(), rotZ, true);
			}
			if(vehicle.type.isRailVehicle()){
				((RailVehicle)this).updBogieRot();
			}
			else{
				AttrFloat attr = (AttrFloat)vehicle.data.getAttribute("steering_angle");
				attr.initial = attr.value;
				attr.value = (float)vehicle.steer_yaw;
				double dir = Math.abs(vehicle.pivot().yaw() + rad180) - Math.abs(-Math.atan2(xOld - position().x, zOld - position().z) + rad180);
				dir = dir > rad90 || dir < -rad90 ? -1 : 1;
				wheel_rotation = valDegF(wheel_rotation + (vehicle.speed * dir * wheel_radius * 100));
				vehicle.data.setAttribute("wheel_angle", wheel_rotation);
				vehicle.data.setAttribute("throttle", vehicle.throttle);
				vehicle.data.setAttribute("speed", vehicle.speed);
			}
		}
		for(WheelEntity wheel : wheels.values()){
			if(wheel == null) continue;
			wheel.setOldPosAndRot();
		}
		Player driver = getDriver();
		if(!level().isClientSide){
			V3D fron, rear, left, righ;
			if(vehicle.type.isRailVehicle()){
				vehicle.data.getAttribute("section_on").set(vehicle.railent.current.getUnit().section().getUID());
				vehicle.railent.alignEntity(false);
				//
				fron = vehicle.railent.bfront;
				rear = vehicle.railent.brear;
				left = righ = new V3D((fron.x + rear.x) * 0.5, (fron.y + rear.y) * 0.5, (fron.z + rear.z) * 0.5);
			}
			else{
				boolean creative = driver != null && driver.isCreative();
				if(driver == null || (!creative && vehicle.data.outoffuel())){
					vehicle.throttle *= 0.98;
				}
				move(!VEHICLES_NEED_FUEL || creative);
				if(vehicle.rear != null) ((RootVehicle)vehicle.rear.entity.direct()).align();
				//
				WheelEntity fl = wheels.get(vehicle.w_front_l.id);
				WheelEntity fr = wheels.get(vehicle.w_front_r.id);
				WheelEntity rl = wheels.get(vehicle.w_rear_l.id);
				WheelEntity rr = wheels.get(vehicle.w_rear_r.id);
				if(fl == null) return;
				fron = new V3D((fl.position().x + fr.position().x) * 0.5, (fl.position().y + fr.position().y) * 0.5, (fl.position().z + fr.position().z) * 0.5);
				rear = new V3D((rl.position().x + rr.position().x) * 0.5, (rl.position().y + rr.position().y) * 0.5, (rl.position().z + rr.position().z) * 0.5);
				left = new V3D((fl.position().x + rl.position().x) * 0.5, (fl.position().y + rl.position().y) * 0.5, (fl.position().z + rl.position().z) * 0.5);
				righ = new V3D((fr.position().x + rr.position().x) * 0.5, (fr.position().y + rr.position().y) * 0.5, (fr.position().z + rr.position().z) * 0.5);
			}
			double dx = rear.x - fron.x, dy = rear.y - fron.y, dz = rear.z - fron.z;
			double drx = righ.x - left.x, dry = righ.y - left.y, drz = righ.z - left.z;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			double y = -Math.atan2(dx, dz);
			double p = -Math.atan2(dy, dxz);
			double r = Math.atan2(dry, Math.sqrt((drx * drx + drz * drz)));
			//double t = valRad(Math.toRadians(tickCount / 10 % 360));
			vehicle.pivot().set_rotation(y, p, r, false);
			//align_wheels();
		}
		else{
			vehicle.speed = MathUtils.calcSpeed(position().x, position().y, position().z, xOld, yOld, zOld);
		}
		vehicle.updatePointsSeats();
		//collchecks
		if(!level().isClientSide && tickCount % VEHICLE_SYNC_RATE == 0){
			vehicle.sendUpdatePacket();
		}
	}

	protected void move(boolean needsnofuel){
		setOnGround(true);
		V3D move = new V3D();
		if(vehicle.data.getType().isTrailer()){
			for(WheelEntity wheel : wheels.values()){
				wheel.setOnGround(true);
				wheel.setYRot(vehicle.pivot().deg_yaw());
				if(!vehicle.data.getType().isTracked() && wheel.wheel.steering){
					wheel.setYRot((float)(wheel.getYRot() + vehicle.steer_yaw));
				}
				wheel.motionX *= 0.9;
				wheel.motionZ *= 0.9;
				wheel.motionY = -GRAVITY_20th;
				wheel.move(MoverType.SELF, wheel.motion());
				V3D dest = vehicle.pivot().get_vector(wheel.wheel.pos);
				dest.x = (dest.x - (wheel.position().x - position().x)) * 0.5;
				dest.y = (dest.y - (wheel.position().y - position().y)) * 0.5;
				dest.z = (dest.z - (wheel.position().z - position().z)) * 0.5;
				if(dest.length() > 0.001){
					wheel.move(MoverType.SELF, new Vec3(dest.x, dest.y, dest.z));
					move = move.sub(dest.scale(0.5));
				}
			}
			move(MoverType.SELF, new Vec3(move.x, move.y, move.z));
		}
		else{
			if(vehicle.type.isWaterVehicle()){
				//TODO
			}
			else{
				boolean consumed = vehicle.engine != null && vehicle.consumeFuel();
				for(WheelEntity wheel : wheels.values()){
					wheel.setOnGround(true);
					wheel.motionX *= 0.9;
					//wheel.motionY *= 0.9;
					wheel.motionZ *= 0.9;
					wheel.motionY /*-*/ = -GRAVITY_20th;
					double steer = Math.toRadians(vehicle.steer_yaw);
					if(vehicle.engine != null && (needsnofuel || consumed)){
						double scal = 0;
						double wheelrot = valRad(vehicle.pivot().yaw());
						if(vehicle.data.getType().isTracked()){
							wheel.motionX *= 1 - (Math.abs(vehicle.steer_yaw) * 0.02);
							wheel.motionZ *= 1 - (Math.abs(vehicle.steer_yaw) * 0.02);
							scal = 0.04 * (vehicle.throttle > 0 ? vehicle.data.getType().getSphData().max_throttle : vehicle.data.getType().getSphData().min_throttle) * vehicle.engine.getSphEngineSpeed();
							double steerscal = 0.1f * (vehicle.steer_yaw > 0 ? vehicle.data.getType().getSphData().turn_left_mod : vehicle.data.getType().getSphData().turn_right_mod);
							double wheelspeed = (vehicle.throttle + (vehicle.steer_yaw * (wheel.wheel.mirror ? -1 : 1) * steerscal)) * scal;
							wheel.motionX += wheelspeed * Math.cos(wheelrot);
							wheel.motionZ += wheelspeed * Math.sin(wheelrot);
						}
						else{
							scal = 0.05 * vehicle.throttle * (vehicle.throttle > 0 ? vehicle.data.getType().getSphData().max_throttle : vehicle.data.getType().getSphData().min_throttle) * vehicle.engine.getSphEngineSpeed();
							if(wheel.wheel.steering){
								wheelrot = valRad(wheelrot + steer);
								wheel.setYRot(vehicle.pivot().deg_yaw() + (float)vehicle.steer_yaw);
							}
							else{
								wheel.setYRot(vehicle.pivot().deg_yaw());
							}
							wheel.motionX -= Math.sin(-wheelrot) * scal;
							wheel.motionZ -= Math.cos(-wheelrot) * scal;
						}
					}
					wheel.move(MoverType.SELF, wheel.motion());
					V3D dest = vehicle.pivot().get_vector(wheel.wheel.pos);
					dest.x = (dest.x - (wheel.position().x - position().x)) * 0.5;
					dest.y = (dest.y - (wheel.position().y - position().y)) * 0.5;
					dest.z = (dest.z - (wheel.position().z - position().z)) * 0.5;
					if(dest.length() > 0.001){
						if(dest.length() > 16) wheel.setPos(dest.x, dest.y, dest.z);
						else wheel.move(MoverType.SELF, new Vec3(dest.x, dest.y, dest.z));
						move.x -= dest.x * 0.5;
						move.y -= dest.y * 0.5;
						move.z -= dest.z * 0.5;
					}
				}
				move(MoverType.SELF, new Vec3(move.x, move.y, move.z));
				vehicle.speed = Math.sqrt(move.x * move.x + move.z * move.z);
			}
		}
	}

	/** for trailers */
	protected void align(){
		setOldPosAndRot();
		if(wheels.isEmpty() || vehicle.front == null) return;
		V3D conn = vehicle.front.pivot().get_vector(vehicle.front.data.getConnectorFor(vehicle.data.getType().getCategories()));
		conn = conn.add(vehicle.front.getV3D());
		setPos(conn.x, conn.y, conn.z);
		vehicle.throttle = vehicle.front.throttle;
		WheelEntity wl = wheels.get(vehicle.w_rear_l.id);
		WheelEntity wr = wheels.get(vehicle.w_rear_r.id);
		vehicle.pivot().set_rotation(-Math.atan2((wl.position().x + wr.position().x) * 0.5 - conn.x, (wl.position().z + wr.position().z) * 0.5 - conn.z), vehicle.pivot().pitch(), vehicle.pivot().roll(), false);
		//alignWheels();
		if(vehicle.rear != null) ((RootVehicle)vehicle.rear.entity).align();
	}

	protected void alignWheels(){
		setOnGround(true);
		for(WheelEntity wheel : wheels.values()){
			wheel.setOnGround(true);
			wheel.setYRot(vehicle.pivot().deg_yaw());
			V3D dest = vehicle.pivot().get_vector(wheel.wheel.pos);
			dest.x = (dest.x - (wheel.position().x - position().x)) * 0.5;
			dest.y = (dest.y - (wheel.position().y - position().y)) * 0.5;
			dest.z = (dest.z - (wheel.position().z - position().z)) * 0.5;
			if(dest.length() > 0.001){
				wheel.move(MoverType.SELF, new Vec3(dest.x, dest.y, dest.z));
			}
			if(wheel.position().distanceTo(position()) > wheel.getHorSpeed() * 2){
				dest = vehicle.pivot().get_vector(wheel.wheel.pos);
				wheel.setPos(dest.x + position().x, dest.y + position().y, dest.z + position().z);
			}
		}
	}

	public Player getDriver(){
		for(SeatInstance seat : vehicle.seats){
			if(seat.seat.driver && seat.passengerIsPlayer()){
				return seat.passenger().local();
			}
		}
		return null;
	}

	@Override
	public LivingEntity getControllingPassenger(){
		return null;
	}

	@Override
	public void positionRider(Entity pass, MoveFunction movefunc){
		SeatInstance seat = getSeatOf(pass);
		if(seat != null) updatePassenger(pass, seat);
		else{
			//if(level(.isClientSide) pass.getData(PASSENGER).reconn(true);
			pass.setPos(position());
		}
	}

	public void updatePassenger(Entity pass, SeatInstance seat){
		if(seat.passenger_direct() != pass){
			seat.passenger(UniEntity.getCasted(pass));
		}
		V3D pos = seat.getCurrentGlobalPosition();
		pass.setPos(pos.x, pos.y - (pass instanceof Player ? 0.7 : 0), pos.z);
		//check if flight reset is necessary on 1.20
	}

	@Override
	public void addPassenger(Entity pass){
		super.addPassenger(pass);
		SeatInstance seat = getSeatOf(pass);
		if(seat != null) seat.passenger(UniEntity.getCasted(pass));
	}

	@Override
	public void removePassenger(Entity pass){
		for(SeatInstance seat : vehicle.seats){
			if(pass.equals(seat.passenger_direct())){
				seat.passenger(null);
			}
		}
		if(!level().isClientSide){
			((Passenger)UniEntity.getCasted(pass)).set(-1, -1);
		}
		super.removePassenger(pass);
	}

	@Override
	public void ejectPassengers(){
		super.ejectPassengers();
	}

	@Override
	protected boolean canAddPassenger(Entity passenger){
		return true;
	}

	@Override
	public boolean shouldRiderSit(){
		return should_sit;
	}

	public SeatInstance getSeatOf(Entity entity){
		Passenger pass = UniEntity.getCasted(entity);
		if(pass == null || pass.seat() < 0 || vehicle.seats.isEmpty() || pass.seat() >= vehicle.seats.size()) return null;
		return vehicle.seats.get(pass.seat());
	}

	@Override
	public boolean hurt(DamageSource source, float am){
		if(level().isClientSide || isRemoved()) return true;
		if(source.getDirectEntity() instanceof Player && getDriver() == null){
			Player player = (Player)source.getDirectEntity();
			if(vehicle.data.getLock().isLocked()){
				player.sendSystemMessage(Component.translatable("interact.fvtm.vehicle.remove_locked"));
				return false;
			}
			EngineFunction engine = vehicle.data.hasPart("engine") ? vehicle.data.getFunctionInPart("engine", "fvtm:engine") : null;
			if(engine != null) engine.setState(false);
			//TODO perm check
			if(vehicle.type.isRailVehicle()){
				vehicle.railent.remove();
			}
			else{
				VehicleInstance trailer = vehicle;
				while((trailer = trailer.rear) != null){
					Entity rear = trailer.entity.local();
					rear.spawnAtLocation(trailer.data.newItemStack().local(), 0.5f);
					rear.kill();
				}
			}
			spawnAtLocation(vehicle.data.newItemStack().local(), 0.5f);
			kill();
			return true;
		}
		return true;
	}

	@Override
	public ItemStack getPickedResult(HitResult rtr){
		return vehicle.data.newItemStack().local();
	}

	//@Override
	public void lerpTo(double x, double y, double z, float yrot, float xrot, int steps){
		//
	}

	public void lerpTo(double x, double y, double z, float yr, float xr, int s, boolean b) {
        //
    }

	public boolean processSeatInteract(int seatidx, ServerPlayer player, InteractionHand hand){
		if(level().isClientSide || seatidx < 0 || seatidx >= vehicle.seats.size()) return false;
		ItemStack stack = player.getItemInHand(hand);
		SeatInstance seat = vehicle.seats.get(seatidx);
		Passenger pass = UniEntity.getCasted(player);
		if(Lockable.isKey(FvtmRegistry.getItem(BuiltInRegistries.ITEM.getKey(stack.getItem()).toString())) && !isFuelContainer(stack.getItem())){
			vehicle.data.getLock().toggle(pass, UniStack.getStack(stack));
			vehicle.sendUpdate(PKT_UPD_LOCK);
			return true;
		}
		if(vehicle.data.getLock().isLocked()){
			player.sendSystemMessage(Component.translatable("interact.fvtm.vehicle.locked"));
			return true;
		}
		if(seat.interacttimer > 0) return false;
		if(stack.getItem() instanceof LeadItem){
			if(seat.passenger().isPlayer()) return false;
			if(seat.passenger().isLiving()){
				Mob ent = seat.passenger().local();
				ent.unRide();
				ent.setLeashedTo(player, true);
				seat.interacttimer += 10;
				return true;
			}
			double range = 10;
			V3D pos = new V3D(position().x, position().y, position().z);
			AABB aabb = new AABB(pos.x - range, pos.y - range, pos.z - range, pos.x + range, pos.y + range, pos.z + range);
			List<Entity> nearby = level().getEntities(this, aabb, ent -> ent instanceof Mob);
			for(Entity entity : nearby){
				Mob mob = (Mob)entity;
				Passenger ment = UniEntity.getCasted(mob);
				if(mob.isLeashed() && mob.getLeashHolder() == player){
					if(!seat.seat.allow(ment)){
						player.sendSystemMessage(Component.literal("&eSeat does not accept this entity kind. (" + entity.getName() + ")"));
						continue;
					}
					ment.set(getId(), seatidx);
					seat.elook.set_rotation(-entity.getYRot(), entity.getXRot(), 0F, true);
					mob.dropLeash(true, !player.isCreative());
					entity.startRiding(this);
					break;
				}
			}
			seat.interacttimer += 10;
			return true;
		}
		if(seat.passenger() == null){
			if(!seat.seat.allow(pass)){
				player.sendSystemMessage(Component.literal("&eSeat does not accept players as passengers."));
				return false;
			}
			if(player.isPassenger() && player.getVehicle().equals(vehicle)){
				SeatInstance oseat = vehicle.getSeatOf(player);
				oseat.passenger(null);
				pass.set(getId(), seatidx);
				seat.passenger(pass);
			}
			else{
				player.unRide();
				pass.set(getId(), seatidx);
				player.startRiding(this);
			}
			seat.interacttimer += 10;
			return true;
		}
		return false;
	}

	public void onPacket(EntityW player, TagCW packet){
		//
	}

}
