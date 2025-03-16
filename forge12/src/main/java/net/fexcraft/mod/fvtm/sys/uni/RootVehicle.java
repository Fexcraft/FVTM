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
	public float rotationRoll = 0;
	public float prevRotationRoll = 0;
	public boolean should_sit = true;

	public RootVehicle(World world){
		super(world);
		vehicle = new VehicleInstance(new EntityWIE(this), null, isAdv());
	}

	protected void init(TagCW com){
		setSize(vehicle.data.getAttribute("hitbox_width").asFloat(), vehicle.data.getAttribute("hitbox_height").asFloat());
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
		prevRotationYaw = com.getFloat("RotationYaw");
		prevRotationPitch = com.getFloat("RotationPitch");
		prevRotationRoll = com.getFloat("RotationRoll");
		vehicle.init(com);
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
			vehicle.init(com);
			readSpawnData(com);
			init(com);
			prevRotationYaw = vehicle.point.getPivot().deg_yaw();
			prevRotationPitch = vehicle.point.getPivot().deg_pitch();
			prevRotationRoll = vehicle.point.getPivot().deg_roll();
		}
		catch(Exception e){
			e.printStackTrace();
			FvtmLogger.LOGGER.log("Failed to receive additional spawn data for vehicle entity with ID " + getEntityId() + "!");
		}
	}

	@Override
	public void setDead(){
		if(vehicle != null) vehicle.onRemove();
		super.setDead();
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
		int res = vehicle.onInteract((Passenger)UniEntity.getEntity(player), UniStack.getStack(player.getHeldItemMainhand()));
		return res >= 0;
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
		if(isDead) return;
		if(vehicle.data == null){
			FvtmLogger.LOGGER.log("Vehicle '" + getEntityId() + "' has no data, skipping update.");
			return;
		}
		ticksExisted++;
		if(ticksExisted >= Integer.MAX_VALUE) ticksExisted = 0;
		prevRotationYaw = vehicle.point.getPivot().deg_yaw();
		prevRotationPitch = vehicle.point.getPivot().deg_pitch();
		prevRotationRoll = vehicle.point.getPivot().deg_roll();
		vehicle.onUpdate();
		//collchecks
		if(!world.isRemote && ticksExisted % VEHICLE_SYNC_RATE == 0){
			vehicle.sendUpdatePacket();
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
