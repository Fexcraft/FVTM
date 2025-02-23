package net.fexcraft.mod.fvtm.sys.uni;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.*;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.PassCap;
import net.fexcraft.mod.fvtm.data.attribute.AttrFloat;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.function.part.TireFunction;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NRailVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.ess.SimplePhysSpawnSystem;
import net.fexcraft.mod.fvtm.util.MathUtils;
import net.fexcraft.mod.fvtm.event.EventHandler;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.EntityWIE;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemLead;
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

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import static net.fexcraft.lib.common.Static.rad180;
import static net.fexcraft.lib.common.Static.rad90;
import static net.fexcraft.mod.fvtm.Config.*;
import static net.fexcraft.mod.fvtm.data.Capabilities.PASSENGER;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.*;
import static net.fexcraft.mod.fvtm.ui.UIKeys.VEHICLE_MAIN;
import static net.fexcraft.mod.fvtm.util.MathUtils.*;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.getTargetPoint;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

	public VehicleInstance vehicle;
	public HashMap<String, NWheelEntity> wheels = new HashMap<>();
	public float rotationRoll = 0;
	public float prevRotationRoll = 0;
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

	public RootVehicle(World world){
		super(world);
		vehicle = new VehicleInstance(new EntityWIE(this), null, isAdv());
	}

	protected void init(TagCW com){
		wheels.clear();
		wheel_radius = 0;
		if(!vehicle.type.isRailVehicle()){
			for(Entry<String, V3D> entry : vehicle.data.getWheelPositions().entrySet()){
				if(entry.getKey().endsWith(":tire")) continue;
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
		setSize(vehicle.data.getAttribute("hitbox_width").asFloat(), vehicle.data.getAttribute("hitbox_height").asFloat());
		//TODO spawn script/event
		if(!world.isRemote && vehicle.front != null){
			vehicle.sendUpdate(PKT_UPD_CONNECTOR);
		}
		if(world.isRemote){
			//TODO register for particles
		}
	}

	public boolean isAdv(){
		return false;
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		TagCW com = TagCW.wrap(compound);
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
		init(com);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		TagCW com = TagCW.wrap(compound);
		vehicle.data.write(com);
		vehicle.point.savePivot(com);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		TagCW com = TagCW.create();
		vehicle.point.savePivot(com);
		writeSpawnData(com);
		vehicle.data.write(com);
		ByteBufUtils.writeTag(buffer, com.local());
	}

	public void writeSpawnData(TagCW com){}

	public void readSpawnData(TagCW com){}

	@Override
	public void readSpawnData(ByteBuf buffer){
		try{
			TagCW com = TagCW.wrap(ByteBufUtils.readTag(buffer));
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
			vehicle.point.loadPivot(com);
			prevRotationYaw = vehicle.point.getPivot().deg_yaw();
			prevRotationPitch = vehicle.point.getPivot().deg_pitch();
			prevRotationRoll = vehicle.point.getPivot().deg_roll();
			readSpawnData(com);
			init(com);
		}
		catch(Exception e){
			e.printStackTrace();
			FvtmLogger.LOGGER.log("Failed to receive additional spawn data for vehicle entity with ID " + getEntityId() + "!");
		}
	}

	@Override
	public void setDead(){
		if(Config.VEHICLES_DROP_CONTENTS && !world.isRemote){
			for(String part : vehicle.data.getInventories()){
            	InventoryFunction func = vehicle.data.getPart(part).getFunction("fvtm:inventory");
            	if(func == null) continue;
        		func.inventory().clearAt(vehicle.entity);
            }
		}
		super.setDead();
		if(!wheels.isEmpty()){
			for(NWheelEntity wheel : wheels.values()) wheel.setDead();
		}
		//TODO vehicle removal script/event
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
		StackWrapper wrapper = UniStack.getStack(stack);
		Passenger pass = player.getCapability(PASSENGER, null).asWrapper();
		if(world.isRemote){
			if(!stack.isEmpty() && stack.getItem() instanceof PartItem == false) return true;
			if(Lockable.isKey(wrapper.getItem())) return true;
			if(vehicle.data.getLock().isLocked()){
				player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.locked"), true);
				return true;
			}
			InteractionHandler.handle(KeyPress.MOUSE_RIGHT, vehicle.data, vehicle.iref(), null, pass, UniStack.getStack(stack));
			return true;
		}
		if(Lockable.isKey(wrapper.getItem()) && !isFuelContainer(stack.getItem())){
			vehicle.data.getLock().toggle(player.getCapability(PASSENGER, null).asSender(), wrapper);
			vehicle.sendUpdate(PKT_UPD_LOCK);
			return true;
		}
		if(!stack.isEmpty()){
			if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isFuelContainer()){
				pass.openUI(UIKeys.VEHICLE_FUEL, new V3I(getEntityId(), 0, 0));
				return true;
			}
			else if(stack.getItem() instanceof ToolboxItem){
				if(stack.getMetadata() == 0){

				}
				else if(stack.getMetadata() == 1){
					pass.openUI(UIKeys.TOOLBOX_TEXTURE, new V3I(getEntityId(), 0, 0));
				}
				else if(stack.getMetadata() == 2){
					pass.openUI(UIKeys.TOOLBOX_COLORS, new V3I(getEntityId(), 0, 0));
				}
				return true;
			}
			else if(stack.getItem() instanceof VehicleItem && vehicle.type.isLandVehicle()){
				VehicleData data = ((VehicleItem)stack.getItem()).getData(TagCW.wrap(stack.getTagCompound()));
				if(data.getType().isTrailer()){
					if(!vehicle.data.hasCompatibleConnector(data.getType().getCategories())){
						pass.send("interact.fvtm.vehicle.no_compatible_connector");
						FvtmLogger.debug(vehicle.data.getConnectors());
						return true;
					}
                	if(!SimplePhysSpawnSystem.validToSpawn(UniEntity.getEntity(player), UniStack.getStack(stack), data)) return true;
					if(vehicle.rear != null){
						pass.send("interact.fvtm.vehicle.disconnect_trailer");
						return true;
					}
					world.spawnEntity(new NLandVehicle((NLandVehicle)this, data, player));
				}
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
					player.openGui(FVTM.getInstance(), VEHICLE_MAIN.id, world, 0, this.getEntityId(), 0);
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
		if(vehicle.gear_timer > 0) vehicle.gear_timer--;
		if(vehicle.autogear_timer > 0) vehicle.autogear_timer--;
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
				vehicle.steer_yaw += (serverSteer - vehicle.steer_yaw) / server_sync;
				server_sync--;
				setPosition(x, y, z);
				vehicle.pivot().set_rotation(rotationYaw, rotationPitch, rotationRoll, true);
			}
			if(vehicle.type.isRailVehicle()){
				((NRailVehicle)this).updBogieRot();
			}
			else{
				AttrFloat attr = (AttrFloat)vehicle.data.getAttribute("steering_angle");
				attr.initial = attr.value;
				attr.value = (float)vehicle.steer_yaw;
				double dir = Math.abs(vehicle.pivot().yaw() + rad180) - Math.abs(-Math.atan2(prevPosX - posX, prevPosZ - posZ) + rad180);
				dir = dir > rad90 || dir < -rad90? -1 : 1;
				wheel_rotation = valDegF(wheel_rotation + (vehicle.speed * dir * wheel_radius * 100));
				vehicle.data.setAttribute("wheel_angle", wheel_rotation);
				vehicle.data.setAttribute("throttle", vehicle.throttle);
				vehicle.data.setAttribute("speed", vehicle.speed);
			}
		}
		for(NWheelEntity wheel : wheels.values()){
			if(wheel == null) continue;
			wheel.prevPosX = wheel.posX;
			wheel.prevPosY = wheel.posY;
			wheel.prevPosZ = wheel.posZ;
		}
		onUpdateMovement();
		vehicle.updatePointsSeats();
		//collchecks
		if(!world.isRemote && ticksExisted % VEHICLE_SYNC_RATE == 0){
			vehicle.sendUpdatePacket();
		}
	}

	protected void onUpdateMovement(){
		EntityW driver = vehicle.driver();
		if(!world.isRemote){
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
				NWheelEntity fl = wheels.get(vehicle.w_front_l.id);
				NWheelEntity fr = wheels.get(vehicle.w_front_r.id);
				NWheelEntity rl = wheels.get(vehicle.w_rear_l.id);
				NWheelEntity rr = wheels.get(vehicle.w_rear_r.id);
				fron = new V3D((fl.posX + fr.posX) * 0.5, (fl.posY + fr.posY) * 0.5, (fl.posZ + fr.posZ) * 0.5);
				rear = new V3D((rl.posX + rr.posX) * 0.5, (rl.posY + rr.posY) * 0.5, (rl.posZ + rr.posZ) * 0.5);
				left = new V3D((fl.posX + rl.posX) * 0.5, (fl.posY + rl.posY) * 0.5, (fl.posZ + rl.posZ) * 0.5);
				righ = new V3D((fr.posX + rr.posX) * 0.5, (fr.posY + rr.posY) * 0.5, (fr.posZ + rr.posZ) * 0.5);
			}
			double dx = rear.x - fron.x, dy = rear.y - fron.y, dz = rear.z - fron.z;
			double drx = righ.x - left.x, dry = righ.y - left.y, drz = righ.z - left.z;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			double y = -Math.atan2(dx, dz);
			double p = -Math.atan2(dy, dxz);
			double r = Math.atan2(dry, Math.sqrt((drx * drx + drz * drz)));
			//double t = valRad(Math.toRadians(ticksExisted / 10 % 360));
			//Print.debug(y + " " + Math.toDegrees(y) + " / " + t + " " + Math.toDegrees(t) + " / " + (y - t) + " " + Math.toDegrees(y - t));
			//y = Command.getValB("rot", false) ? t : y;
			vehicle.pivot().set_rotation(y, p, r, false);
			//align_wheels();
		}
		else{
			vehicle.speed = MathUtils.calcSpeed(posX, posY, posZ, prevPosX, prevPosY, prevPosZ);
		}
	}

	protected void move(boolean needsnofuel){
		onGround = true;
		V3D move = new V3D();
		if(vehicle.data.getType().isTrailer()){
			for(NWheelEntity wheel : wheels.values()){
				wheel.onGround = true;
				wheel.rotationYaw = vehicle.pivot().deg_yaw();
				wheel.motionX *= 0.9;
				wheel.motionZ *= 0.9;
				wheel.motionY = -GRAVITY_20th;
				wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
				V3D dest = vehicle.pivot().get_vector(wheel.wheel.pos);
				dest.x = (dest.x - (wheel.posX - posX)) * 0.5;
				dest.y = (dest.y - (wheel.posY - posY)) * 0.5;
				dest.z = (dest.z - (wheel.posZ - posZ)) * 0.5;
				if(dest.length() > 0.001){
					if(dest.length() > 16) wheel.setPosition(wheel.posX + dest.x, wheel.posY + dest.y, wheel.posZ + dest.z);
					else wheel.move(MoverType.SELF, dest.x, dest.y, dest.z);
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
				boolean consumed = vehicle.engine != null && vehicle.consumeFuel();
				for(NWheelEntity wheel : wheels.values()){
					wheel.onGround = true;
					wheel.motionX *= 0.9;
					//wheel.motionY *= 0.9;
					wheel.motionZ *= 0.9;
					wheel.motionY /*-*/= -GRAVITY_20th;
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
								wheel.rotationYaw = vehicle.pivot().deg_yaw() + (float)vehicle.steer_yaw;
							}
							else{
								wheel.rotationYaw = vehicle.pivot().deg_yaw();
							}
							wheel.motionX -= Math.sin(-wheelrot) * scal;
							wheel.motionZ -= Math.cos(-wheelrot) * scal;
						}
					}
					wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
					V3D dest = vehicle.pivot().get_vector(wheel.wheel.pos);
					dest.x = (dest.x - (wheel.posX - posX)) * 0.25;
					dest.y = (dest.y - (wheel.posY - posY)) * 0.25;
					dest.z = (dest.z - (wheel.posZ - posZ)) * 0.25;
					if(dest.length() > 0.001){
						if(dest.length() > 16) wheel.setPosition(wheel.posX + dest.x, wheel.posY + dest.y, wheel.posZ + dest.z);
						else wheel.move(MoverType.SELF, dest.x, dest.y, dest.z);
						move.x -= dest.x * 0.5;
						move.y -= dest.y * 0.5;
						move.z -= dest.z * 0.5;
					}
				}
				move(MoverType.SELF, move.x, move.y, move.z);
				vehicle.speed = Math.sqrt(move.x * move.x + move.z * move.z);
			}
		}
	}

	/** for trailers */
	protected void align(){
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		if(wheels.isEmpty() || vehicle.front == null) return;
		V3D conn = vehicle.front.pivot().get_vector(vehicle.front.data.getConnectorFor(vehicle.data.getType().getCategories()));
		conn = conn.add(vehicle.front.getV3D());
		setPosition(conn.x, conn.y, conn.z);
		vehicle.throttle = vehicle.front.throttle;
		NWheelEntity wl = wheels.get(vehicle.w_rear_l.id);
		NWheelEntity wr = wheels.get(vehicle.w_rear_r.id);
		vehicle.pivot().set_rotation(-Math.atan2((wl.posX + wr.posX) * 0.5 - conn.x, (wl.posZ + wr.posZ) * 0.5 - conn.z), vehicle.pivot().pitch(), vehicle.pivot().roll(), false);
		//alignWheels();
		if(vehicle.rear != null) ((RootVehicle)vehicle.rear.entity).align();
	}

	protected void alignWheels(){
		onGround = true;
		for(NWheelEntity wheel : wheels.values()){
			wheel.onGround = true;
			wheel.rotationYaw = vehicle.pivot().deg_yaw();
			V3D dest = vehicle.pivot().get_vector(wheel.wheel.pos);
			dest.x = (dest.x - (wheel.posX - posX)) * 0.5;
			dest.y = (dest.y - (wheel.posY - posY)) * 0.5;
			dest.z = (dest.z - (wheel.posZ - posZ)) * 0.5;
			if(dest.length() > 0.001){
				wheel.move(MoverType.SELF, dest.x, dest.y, dest.z);
			}
			if(wheel.getPositionVector().distanceTo(getPositionVector()) > wheel.getHorSpeed() * 2){
				dest = vehicle.pivot().get_vector(wheel.wheel.pos);
				wheel.posX = dest.x + posX;
				wheel.posY = dest.y + posY;
				wheel.posZ = dest.z + posZ;
			}
		}
	}

	@Override
	public Entity getControllingPassenger(){
		return null;
	}

	@Override
	public void updatePassenger(Entity pass){
		SeatInstance seat = getSeatOf(pass);
		if(seat != null) updatePassenger(pass, seat);
		else{
			if(world.isRemote) pass.getCapability(Capabilities.PASSENGER, null).reconn(true);
			pass.setPosition(posX, posY, posZ);
		}
	}

	public void updatePassenger(Entity pass, SeatInstance seat){
		if(seat.passenger_direct() != pass){
			seat.passenger(pass.getCapability(PASSENGER, null).asWrapper());
		}
		V3D pos = seat.getCurrentGlobalPosition();
		/*pass.rotationYaw = seat.eyaw;
		pass.rotationPitch = seat.epitch;
		pass.prevRotationYaw = seat.peyaw;
		pass.prevRotationPitch = seat.pepitch;*/
		pass.setPosition(pos.x, pos.y - (pass instanceof EntityPlayer ? 0.7 : 0), pos.z);
		if(!world.isRemote && pass instanceof EntityPlayerMP){
			EventHandler.resetFlight((EntityPlayerMP)pass);
		}
	}

	@Override
	public void addPassenger(Entity pass){
		super.addPassenger(pass);
		SeatInstance seat = getSeatOf(pass);
		if(seat != null) seat.passenger(pass.getCapability(PASSENGER, null).asWrapper());
	}

	@Override
	public void removePassenger(Entity pass){
		for(SeatInstance seat : vehicle.seats){
			if(pass.equals(seat.passenger_direct())){
				seat.passenger(null);
			}
		}
		if(!world.isRemote){
			pass.getCapability(Capabilities.PASSENGER, null).set(-1, -1);
		}
		super.removePassenger(pass);
	}

	@Override
	public void removePassengers(){
		super.removePassengers();
	}

	@Override
	protected boolean canFitPassenger(Entity passenger){
		return true;
	}

	@Override
	public boolean shouldRiderSit(){
		return should_sit;
	}

	public void updateSittingState(Entity pass){
		SeatInstance seat = getSeatOf(pass);
		if(seat != null) should_sit = seat.seat.sitting;
	}

	public SeatInstance getSeatOf(Entity entity){
		PassCap pass = entity.getCapability(Capabilities.PASSENGER, null);
		if(pass == null || pass.seat() < 0 || vehicle.seats.isEmpty() || pass.seat() >= vehicle.seats.size()) return null;
		return vehicle.seats.get(pass.seat());
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount){
		if(world.isRemote || isDead) return true;
		if(source.damageType.equals("player") && vehicle.driver() == null){
			EntityPlayer player = (EntityPlayer)source.getImmediateSource();
			if(vehicle.data.getLock().isLocked()){
				player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.remove_locked"), true);
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
					rear.entityDropItem(trailer.data.newItemStack().local(), 0.5f);
					rear.setDead();
				}
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

	public boolean processSeatInteract(int seatidx, EntityPlayerMP player, EnumHand hand){
		if(world.isRemote || seatidx < 0 || seatidx >= vehicle.seats.size()) return false;
		ItemStack stack = player.getHeldItem(hand);
		SeatInstance seat = vehicle.seats.get(seatidx);
		PassCap pass = player.getCapability(PASSENGER, null);
		if(Lockable.isKey(FvtmRegistry.getItem(stack.getItem().getRegistryName().toString())) && !isFuelContainer(stack.getItem())){
			vehicle.data.getLock().toggle(pass.asSender(), UniStack.getStack(stack));
			sendLockStateUpdate();
			return true;
		}
		if(vehicle.data.getLock().isLocked()){
			player.sendStatusMessage(new TextComponentTranslation("interact.fvtm.vehicle.locked"), true);
			return true;
		}
		if(seat.interacttimer > 0) return false;
		if(stack.getItem() instanceof ItemLead){
			if(seat.passenger() != null){
				if(seat.passenger().isPlayer()) return false;
				if(seat.passenger().isLiving()){
					EntityLiving ent = seat.passenger().local();
					ent.dismountRidingEntity();
					ent.setLeashHolder(player, true);
					seat.interacttimer += 10;
					return true;
				}
			}
			double range = 10;
			V3D pos = new V3D(posX, posY, posZ);
			AxisAlignedBB aabb = new AxisAlignedBB(pos.x - range, pos.y - range, pos.z - range, pos.x + range, pos.y + range, pos.z + range);
			List<EntityLiving> nearbyMobs = world.getEntitiesWithinAABB(EntityLiving.class, aabb);
			for(EntityLiving entity : nearbyMobs){
				if(entity.getLeashed() && entity.getLeashHolder() == player){
					if(!seat.seat.allow(entity.getCapability(PASSENGER, null).asWrapper())){
						Print.bar(player, "&eSeat does not accept this entity kind. (" + entity.getName() + ")");
						continue;
					}
					entity.getCapability(Capabilities.PASSENGER, null).set(getEntityId(), seatidx);
					seat.elook.set_rotation(-entity.rotationYaw, entity.rotationPitch, 0F, true);
					entity.clearLeashed(true, !player.capabilities.isCreativeMode);
					entity.startRiding(this);
					break;
				}
			}
			seat.interacttimer += 10;
			return true;
		}
		if(seat.passenger() == null){
			if(!seat.seat.allow(pass.asWrapper())){
				Print.bar(player, "&eSeat does not accept players as passengers.");
				return false;
			}
			if(player.isRiding() && player.getRidingEntity().equals(vehicle)){
				SeatInstance oseat = vehicle.getSeatOf(player);
				oseat.passenger(null);
				pass.set(getEntityId(), seatidx);
				seat.passenger(pass.asWrapper());
			}
			else{
				player.dismountRidingEntity();
				player.getCapability(Capabilities.PASSENGER, null).set(getEntityId(), seatidx);
				player.startRiding(this);
			}
			seat.interacttimer += 10;
			return true;
		}
		return false;
	}

	private boolean isFuelContainer(Item item){
		if(item instanceof MaterialItem == false) return false;
		return ((MaterialItem)item).getContent().isFuelContainer();
	}

	public void sendLockStateUpdate(){
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", UTIL_LISTENER);
		packet.setString("task", "lock_state");
		packet.setBoolean("state", vehicle.data.getLock().isLocked());
		packet.setInteger("entity", getEntityId());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), getTargetPoint(this));
	}

	public void sendColorChannelUpdate(String channel){
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", UTIL_LISTENER);
		packet.setString("task", "color_channel");
		packet.setString("channel", channel);
		packet.setInteger("color", vehicle.data.getColorChannel(channel).packed);
		packet.setInteger("entity", getEntityId());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), getTargetPoint(this));
	}

	@Override
	public void processServerPacket(PacketEntityUpdate packet){
		if(!packet.nbt.hasKey("task")) return;
		switch(packet.nbt.getString("task")){
			case "resync": {
				NBTTagCompound nbt = vehicle.data.write(TagCW.create()).local();
				nbt.setString("task", "update_vehicledata");
				ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void processClientPacket(PacketEntityUpdate packet){
		if(!packet.nbt.hasKey("task")) return;
		switch(packet.nbt.getString("task")){
			case "resync":
			case "update_vehicledata": {
				vehicle.data.read(new TagCWI(packet.nbt));
				break;
			}
			case "toggle_lights": {
				vehicle.data.getAttribute("lights").set(packet.nbt.getBoolean("lights"));
				vehicle.data.getAttribute("lights_long").set(packet.nbt.getBoolean("lights_long"));
				VehicleInstance rear = vehicle.rear;
				while(rear != null){
					rear.data.getAttribute("lights").set(packet.nbt.getBoolean("lights"));
					rear.data.getAttribute("lights_long").set(packet.nbt.getBoolean("lights_long"));
					rear = rear.rear;
				}
				break;
			}
		}
	}

    public boolean isBraking(){
		return false;
    }

	public void onPacket(EntityW player, TagCW packet){

	}

}
