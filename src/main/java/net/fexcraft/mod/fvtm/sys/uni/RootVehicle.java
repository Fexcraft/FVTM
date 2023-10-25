package net.fexcraft.mod.fvtm.sys.uni;

import static net.fexcraft.mod.fvtm.Config.RENDER_OUT_OF_VIEW;
import static net.fexcraft.mod.fvtm.data.Capabilities.PASSENGER;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
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
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityWI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
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
	public ArrayList<NWheelEntity> wheels = new ArrayList<>();
	public AxisAlignedBB renderbox;
	public float prevRotationRoll = 0;
	public float wheel_radius = 0;
	//
	public double serverX;
	public double serverY;
	public double serverZ;
	public double serverYaw;
	public double serverPitch;
	public double serverRoll;
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
			//
			if(w_front_l == null || (wheel.pos.x <= w_front_l.pos.x && wheel.pos.z <= w_front_l.pos.z)){
				w_front_l = wheel;
			}
			if(w_front_r == null || (wheel.pos.x >= w_front_r.pos.x && wheel.pos.z <= w_front_r.pos.z)){
				w_front_r = wheel;
			}
			if(w_rear_l == null || (wheel.pos.x <= w_rear_l.pos.x && wheel.pos.z >= w_rear_l.pos.z)){
				w_rear_l = wheel;
			}
			if(w_rear_r == null || (wheel.pos.x >= w_rear_r.pos.x && wheel.pos.z >= w_rear_r.pos.z)){
				w_rear_r = wheel;
			}
		}
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
			for(NWheelEntity wheel : wheels) wheel.setDead();
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

}
