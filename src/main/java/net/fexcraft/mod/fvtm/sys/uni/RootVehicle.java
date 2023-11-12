package net.fexcraft.mod.fvtm.sys.uni;

import static net.fexcraft.mod.fvtm.Config.RENDER_OUT_OF_VIEW;
import static net.fexcraft.mod.fvtm.Config.VEHICLES_NEED_FUEL;
import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;
import static net.fexcraft.mod.fvtm.data.Capabilities.PASSENGER;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.GRAVITY_20th;
import static net.fexcraft.mod.fvtm.util.MathUtils.valDeg;
import static net.fexcraft.mod.fvtm.util.MathUtils.valDegF;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.function.EngineFunction;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.util.MathUtils;
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityWI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity implements IEntityAdditionalSpawnData {

	public VehicleInstance vehicle;
	public WheelTireData w_front_l;
	public WheelTireData w_front_r;
	public WheelTireData w_rear_l;
	public WheelTireData w_rear_r;
	public HashMap<String, NWheelEntity> wheels = new HashMap<>();
	public AxisAlignedBB renderbox;
	public float rotationRoll = 0;
	public float prevRotationRoll = 0;
	public float wheel_radius = 0;
	public float wheel_rotation = 0;
	//
	public double serverX;
	public double serverY;
	public double serverZ;
	public double serverYaw;
	public double serverPitch;
	public double serverRoll;
	public double serverSteer;
	public byte server_sync;

	public RootVehicle(World world){
		super(world);
		vehicle = new VehicleInstance(new EntityWI(this), null);
	}

	protected void init(){
		wheels.clear();
		wheel_radius = 0;
		for(Entry<String, V3D> entry : vehicle.data.getWheelPositions().entrySet()){
			WheelTireData wheel = new WheelTireData(entry.getKey());
			wheel.pos = entry.getValue();
			PartData part = vehicle.data.getPart(entry.getKey());
			if(!((WheelData)part.getType().getInstallHandlerData()).hasTire()){
				part = vehicle.data.getPart(entry.getKey()+ ":tire");
				wheel_radius += ((TireData)part.getType().getInstallHandlerData()).getOuterRadius();
			}
			else{
				wheel_radius += ((WheelData)part.getType().getInstallHandlerData()).getRadius();
			}
			wheel.function = part.getFunction(TireFunction.class, "fvtm:tire").getTireAttr(part);
			vehicle.wheeldata.put(entry.getKey(), wheel);
		}
		assignWheels();
		assignWheels();
		wheel_radius /= vehicle.wheeldata.size();
		vehicle.seats.clear();
		for(int i = 0; i < vehicle.data.getSeats().size(); i++){
			vehicle.seats.add(new SeatInstance(vehicle, i));
		}
		setSize(vehicle.data.getAttribute("hitbox_width").asFloat(), vehicle.data.getAttribute("hitbox_height").asFloat());
		//TODO spawn script/event
		if(!world.isRemote && vehicle.front != null){
			//TODO send connection state update
		}
		if(world.isRemote){
			float cr = vehicle.data.getAttributeFloat("collission_range", 2f);
			renderbox = new AxisAlignedBB(-cr, -cr, -cr, cr, cr, cr);
			//TODO register for particles
		}
	}

	private void assignWheels(){
		for(WheelTireData wheel : vehicle.wheeldata.values()){
			if(w_front_l == null || (wheel.pos.x <= w_front_l.pos.x && wheel.pos.z < w_front_l.pos.z)){
				w_front_l = wheel;
				continue;
			}
			if(w_front_r == null || (wheel.pos.x >= w_front_r.pos.x && wheel.pos.z < w_front_r.pos.z)){
				w_front_r = wheel;
				continue;
			}
			if(w_rear_l == null || (wheel.pos.x <= w_rear_l.pos.x && wheel.pos.z > w_rear_l.pos.z)){
				w_rear_l = wheel;
				continue;
			}
			if(w_rear_r == null || (wheel.pos.x >= w_rear_r.pos.x && wheel.pos.z > w_rear_r.pos.z)){
				w_rear_r = wheel;
			}
		}
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		TagCW com = new TagCWI(compound);
		if(vehicle.data == null){
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
		}
		else{
			vehicle.data.read(com);
		}
		prevRotationYaw = com.getFloat("RotationYaw");
		prevRotationPitch = com.getFloat("RotationYaw");
		prevRotationRoll = com.getFloat("RotationYaw");
		vehicle.point.loadPivot(com);
		init();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		TagCW com = new TagCWI(compound);
		vehicle.data.write(com);
		vehicle.point.savePivot(com);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		TagCW com = TagCW.create();
		vehicle.point.savePivot(com);
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
		vehicle.data.write(com);
		ByteBufUtils.writeTag(buffer, com.local());
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		try{
			TagCW com = new TagCWI(ByteBufUtils.readTag(buffer));
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
			vehicle.point.loadPivot(com);
			prevRotationYaw = vehicle.point.getPivot().deg_yaw();
			prevRotationPitch = vehicle.point.getPivot().deg_pitch();
			prevRotationRoll = vehicle.point.getPivot().deg_roll();
			if(com.has("TruckId")){
				vehicle.front = ((NLandVehicle)world.getEntityByID(com.getInteger("TrickId"))).vehicle;
				vehicle.front.rear = vehicle;
			}
			init();
		}
		catch(Exception e){
			e.printStackTrace();
			FvtmLogger.LOGGER.log("Failed to receive additional spawn data for vehicle entity with ID " + getEntityId() + "!");
		}
	}

	@Override
	public void setDead(){
		if(Config.VEHICLES_DROP_CONTENTS && !world.isRemote){
			//TODO drop inventory contents
		}
		super.setDead();
		if(!wheels.isEmpty()){
			for(NWheelEntity wheel : wheels.values()) wheel.setDead();
		}
		//TODO vehicle removal script/event
		if(vehicle.front != null) vehicle.front.rear = null;
		if(vehicle.rear != null) vehicle.rear.front = null;
	}

	public void setPosRotMot(double px, double py, double pz, double yaw, double pit, double rol, double thr, double steer, int fuel){
		serverX = px;
		serverY = py;
		serverZ = pz;
		serverYaw = yaw;
		serverPitch = pit;
		serverRoll = rol;
		serverSteer = steer;
		server_sync = Config.VEHICLE_SYNC_RATE;
		vehicle.throttle = thr;
		vehicle.data.getAttribute("fuel_stored").set(fuel);
	}

	//-- General Vanilla --//

	@Override
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posrotincr, boolean teleport){
		//
	}

	@Override
	protected boolean canTriggerWalking(){
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity){
		return null;
	}

	@Override
	public AxisAlignedBB getEntityBoundingBox(){
		return super.getEntityBoundingBox();
	}

	@Override
	public boolean isNonBoss(){
		return true;
	}

	@Override
	public boolean canBePushed(){
		return false;
	}

	@Override
	public double getMountedYOffset(){
		return 0;
	}

	@Override
	public SoundCategory getSoundCategory(){
		return SoundCategory.NEUTRAL;
	}

	@Override
	public double getYOffset(){
		return 0;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player){
		//
	}

	@Override
	public boolean canBeCollidedWith(){
		return true;
	}

	@Override
	public void fall(float distance, float multiplier){
		//
	}

	@Override
	public String getName(){
		return vehicle.data.getName();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double dist){
		return RENDER_OUT_OF_VIEW ? true : super.isInRangeToRenderDist(dist);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(){
		return this.getCollisionBox(this);
	}

	//-- General Vanilla END --//

	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
		if(isDead || hand == EnumHand.OFF_HAND) return false;
		ItemStack stack = player.getHeldItemMainhand();
		StackWrapper wrapper = FvtmResources.INSTANCE.newStack(stack);
		if(world.isRemote){
			if(!stack.isEmpty() && stack.getItem() instanceof PartItem == false) return true;
			if(Lockable.isKey(wrapper.getItem())) return true;
			if(vehicle.data.getLock().isLocked()){
				player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.locked"), true);
				return true;
			}
			return true;
		}
		if(Lockable.isKey(wrapper.getItem())){
			vehicle.data.getLock().toggle(player.getCapability(PASSENGER, null).asSender(), wrapper);
			//TODO send lock state update
			return true;
		}
		if(!stack.isEmpty()){
			if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isFuelContainer()){
				//TODO open fuel ui
				return true;
			}
			else if(stack.getItem() instanceof VehicleItem){
				//TODO check if trailer and connect
				return true;
			}
			else if(stack.getItem() instanceof ContainerItem){
				//TODO open container ui
				return true;
			}
			else{
				if(vehicle.data.hasPart("engine") && vehicle.data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
					player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.engine_on"), true);
				}
				else{
					//TODO open vehicle main ui
				}
				return true;
			}
		}
		if(vehicle.data.getLock().isLocked()){
			player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.locked"), true);
			return true;
		}
		//TODO script interact event
		return false;
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
		if(isDead) return;
		if(vehicle.data == null){
			FvtmLogger.LOGGER.log("Vehicle '" + getEntityId() + "' has no data, skipping update.");
			return;
		}
		if(!world.isRemote){
			for(Entry<String, WheelTireData> entry : vehicle.wheeldata.entrySet()){
				if(!wheels.containsKey(entry.getKey()) || !wheels.get(entry.getKey()).addedToChunk){
					wheels.put(entry.getKey(), new NWheelEntity(this, entry.getKey()));
					world.spawnEntity(wheels.get(entry.getKey()));
				}
			}
		}
		prevRotationYaw = vehicle.point.getPivot().deg_yaw();
		prevRotationPitch = vehicle.point.getPivot().deg_pitch();
		prevRotationRoll = vehicle.point.getPivot().deg_roll();
		vehicle.point.updatePrevAxe();
		ticksExisted++;
		if(ticksExisted >= Integer.MAX_VALUE) ticksExisted = 0;
		if(vehicle.toggable_timer > 0) vehicle.toggable_timer--;
		//
		vehicle.checkSteerAngle(world.isRemote);
		if(world.isRemote){
			if(server_sync > 0){
				double x = posX + (serverX - posX) / server_sync;
				double y = posY + (serverY - posY) / server_sync;
				double z = posZ + (serverZ - posZ) / server_sync;
				double yw = valDeg(serverYaw - vehicle.pivot().deg_yaw());
				double pt = valDeg(serverPitch - vehicle.pivot().deg_pitch());
				double rl = valDeg(serverRoll - vehicle.pivot().deg_roll());
				rotationYaw = (float)(vehicle.pivot().deg_yaw() + yw / server_sync);
				rotationPitch = (float)(vehicle.pivot().deg_pitch() + pt / server_sync);
				rotationRoll = (float)(vehicle.pivot().deg_roll() + rl / server_sync);
				vehicle.steer_yaw = (serverSteer - vehicle.steer_yaw) / server_sync;
				server_sync--;
				setPosition(x, y, z);
				vehicle.pivot().set_rotation(rotationYaw, rotationPitch, rotationRoll, true);
			}
			vehicle.data.setAttribute("steering_angle", vehicle.steer_yaw);
			wheel_rotation = valDegF(wheel_rotation + (vehicle.throttle * wheel_radius));
			vehicle.data.setAttribute("wheel_angle", wheel_rotation);
			vehicle.data.setAttribute("throttle", vehicle.throttle);
			vehicle.data.setAttribute("speed", vehicle.speed);
		}
		for(NWheelEntity wheel : wheels.values()){
			if(wheel == null) continue;
			wheel.prevPosX = wheel.posX;
			wheel.prevPosY = wheel.posY;
			wheel.prevPosZ = wheel.posZ;
		}
		EntityPlayer driver = getDriver();
		if(!world.isRemote){
			boolean creative = driver != null && driver.capabilities.isCreativeMode;
			if(driver == null || (!creative && vehicle.data.outoffuel())){
				vehicle.throttle *= 0.98;
			}
			move(!VEHICLES_NEED_FUEL || creative);
			if(vehicle.rear != null) ((RootVehicle)vehicle.rear.entity.direct()).align();
			//
			NWheelEntity fl = wheels.get(w_front_l.id);
			NWheelEntity fr = wheels.get(w_front_r.id);
			NWheelEntity rl = wheels.get(w_rear_l.id);
			NWheelEntity rr = wheels.get(w_rear_r.id);
			V3D fron = new V3D((fl.posX + fr.posX) * 0.5, (fl.posY + fr.posY) * 0.5, (fl.posZ + fr.posZ) * 0.5);
			V3D rear = new V3D((rl.posX + rr.posX) * 0.5, (rl.posY + rr.posY) * 0.5, (rl.posZ + rr.posZ) * 0.5);
			V3D left = new V3D((fl.posX + rl.posX) * 0.5, (fl.posY + rl.posY) * 0.5, (fl.posZ + rl.posZ) * 0.5);
			V3D righ = new V3D((fr.posX + rr.posX) * 0.5, (fr.posY + rr.posY) * 0.5, (fr.posZ + rr.posZ) * 0.5);
			double dx = fron.x - rear.x, dy = fron.y - rear.y, dz = fron.z - rear.z;
			double drx = left.x - righ.x, dry = left.y - righ.y, drz = left.z - righ.z;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			double drxz = Math.sqrt((drx * drx + drz * drz));
			double y = Math.atan2(dx, dz);
			double p = Math.atan2(dy, dxz);
			double r = Math.atan2(dry, drxz);
			if(vehicle.data.getType().isTracked()){
				y = Math.atan2(fl.posX - fr.posX, fl.posZ - fr.posZ);
			}
			vehicle.pivot().set_rotation(y, p, r, false);
		}
		else{
			vehicle.speed = MathUtils.calcSpeed(posX, posY, posZ, prevPosX, prevPosY, prevPosZ);
		}
		vehicle.updatePointsSeats();
		//collchecks
		if(!world.isRemote && ticksExisted % VEHICLE_SYNC_RATE == 0){
			vehicle.sendUpdatePacket();
		}
	}

	protected void move(boolean needsnofuel){
		onGround = true;
		V3D move = new V3D();
		if(vehicle.data.getType().isTrailer()){
			for(NWheelEntity wheel : wheels.values()){
				wheel.onGround = true;
				wheel.rotationYaw = vehicle.pivot().deg_yaw();
				if(!vehicle.data.getType().isTracked() && wheel.wheel.steering){
					wheel.rotationYaw += vehicle.steer_yaw;
				}
				wheel.motionX *= 0.9;
				wheel.motionY *= 0.9;
				wheel.motionZ *= 0.9;
				wheel.motionY -= GRAVITY_20th;
				wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
				V3D curr = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
				V3D dest = vehicle.pivot().get_vector(wheel.position).sub(curr).scale(0.5);
				if(dest.length() > 0.001){
					wheel.move(MoverType.SELF, dest.x, dest.y, dest.z);
					move = move.sub(dest.scale(0.5));
				}
			}
			move(MoverType.SELF, move.x, move.y, move.z);
		}
		else{
			if(vehicle.type.isWaterVehicle()){
				//TODO
			}
			else{
				EngineFunction engine = vehicle.data.getFunctionInPart("engine", "fvtm:engine");
				boolean consumed = engine != null && vehicle.consumeFuel(engine);
				for(NWheelEntity wheel : wheels.values()){
					wheel.onGround = true;
					wheel.rotationYaw = vehicle.pivot().deg_yaw();
					if(!vehicle.data.getType().isTracked() && wheel.wheel.steering){
						wheel.rotationYaw += vehicle.steer_yaw;
					}
					wheel.motionX *= 0.9;
					wheel.motionY *= 0.9;
					wheel.motionZ *= 0.9;
					wheel.motionY -= GRAVITY_20th;
					if(engine != null && (needsnofuel || consumed)){
						double scal = 0;
						double wheelrot = Math.toRadians(wheel.rotationYaw);
						if(vehicle.data.getType().isTracked()){
							wheel.motionX *= 1 - (Math.abs(vehicle.steer_yaw) * 0.02);
							wheel.motionZ *= 1 - (Math.abs(vehicle.steer_yaw) * 0.02);
							scal = 0.04 * (vehicle.throttle > 0 ? vehicle.data.getType().getSphData().max_throttle : vehicle.data.getType().getSphData().min_throttle) * engine.getSphEngineSpeed();
							double steerscal = 0.1f * (vehicle.steer_yaw > 0 ? vehicle.data.getType().getSphData().turn_left_mod : vehicle.data.getType().getSphData().turn_right_mod);
							double wheelspeed = (vehicle.throttle + (vehicle.steer_yaw * (wheel.wheel.mirror ? -1 : 1) * steerscal)) * scal;
							wheel.motionX += wheelspeed * Math.cos(wheelrot);
							wheel.motionZ += wheelspeed * Math.sin(wheelrot);
						}
						else{
							scal = 0.01 * vehicle.throttle * (vehicle.throttle > 0 ? vehicle.data.getType().getSphData().max_throttle : vehicle.data.getType().getSphData().min_throttle) * engine.getSphEngineSpeed();
							wheel.motionX += Math.cos(wheelrot) * scal;
							wheel.motionX += Math.sin(wheelrot) * scal;
							if(wheel.wheel.steering){
								scal = 0.01 * (vehicle.steer_yaw > 0 ? vehicle.data.getType().getSphData().turn_left_mod : vehicle.data.getType().getSphData().turn_right_mod);
								scal *= vehicle.throttle > 0 ? 1 : -1;
								wheel.motionX -= wheel.getHorSpeed() * Math.sin(wheelrot) * scal * vehicle.steer_yaw;
								wheel.motionZ += wheel.getHorSpeed() * Math.cos(wheelrot) * scal * vehicle.steer_yaw;
							}
							else{
								wheel.motionX *= 0.9;
								wheel.motionZ *= 0.9;
							}
						}
					}
					wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
					V3D curr = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
					V3D dest = vehicle.pivot().get_vector(wheel.position).sub(curr).scale(0.5);
					if(dest.length() > 0.001){
						wheel.move(MoverType.SELF, dest.x, dest.y, dest.z);
						move = move.sub(dest.scale(0.5));
					}
				}
				move(MoverType.SELF, move.x, move.y, move.z);
			}
		}
	}

	/** for trailers */
	protected void align(){
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		if(wheels.isEmpty() || vehicle.front == null) return;
		V3D conn = vehicle.front.pivot().get_vector(vehicle.front.data.getRearConnector());
		conn.add(vehicle.front.getV3D());
		setPosition(conn.x, conn.y, conn.z);
		vehicle.throttle = vehicle.front.throttle;
		double thr = Math.abs(vehicle.throttle);
		double rawy = vehicle.front.pivot().deg_yaw() - vehicle.pivot().deg_yaw();
		double diff = rawy * thr * 0.2;
		diff = rawy > 0 ? (diff > rawy ? rawy : diff) : (diff < rawy ? rawy : diff);
		vehicle.pivot().set_rotation(vehicle.pivot().yaw() + Math.toRadians(diff), vehicle.pivot().pitch(), vehicle.pivot().roll(), false);
		alignWheels();
	}

	protected void alignWheels(){
		onGround = true;
		for(NWheelEntity wheel : wheels.values()){
			wheel.onGround = true;
			wheel.rotationYaw = vehicle.pivot().deg_yaw();
			V3D curr = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
			V3D dest = vehicle.pivot().get_vector(wheel.position).sub(curr).scale(0.5);
			if(dest.length() > 0.001){
				wheel.move(MoverType.SELF, dest.x, dest.y, dest.z);
			}
			if(wheel.getPositionVector().distanceTo(getPositionVector()) > 256){
				wheel.posX = dest.x;
				wheel.posY = dest.y;
				wheel.posZ = dest.z;
			}
		}
	}

	/**
	 * @return first found Player passenger in a driver's seat
	 */
	public EntityPlayer getDriver(){
		for(SeatInstance seat : vehicle.seats){
			if(seat.seat.driver && seat.passengerIsPlayer()){
				return seat.passenger().local();
			}
		}
		return null;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount){
		if(world.isRemote || isDead) return true;
		if(source.damageType.equals("player") && getDriver() == null){
			EntityPlayer player = (EntityPlayer)source.getImmediateSource();
			if(vehicle.data.getLock().isLocked()){
				player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.remove_locked"), true);
				return false;
			}
			EngineFunction engine = vehicle.data.hasPart("engine") ? vehicle.data.getFunctionInPart("engine", "fvtm:engine") : null;
			if(engine != null) engine.setState(false);
			//TODO perm check
			VehicleInstance trailer = vehicle;
			while((trailer = trailer.rear) != null){
				Entity rear = trailer.entity.local();
				rear.entityDropItem(trailer.data.newItemStack().local(), 0.5f);
				rear.setDead();
			}
			entityDropItem(vehicle.data.newItemStack().local(), 0.5f);
			setDead();
			return true;
		}
		return true;
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult rtr){
		return vehicle.data.newItemStack().local();
	}

	//TODO packets

}
