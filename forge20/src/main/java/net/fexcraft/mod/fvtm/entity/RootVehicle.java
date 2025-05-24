package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.*;
import net.fexcraft.mod.fvtm.data.InteractZone;
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
import net.fexcraft.mod.fvtm.util.CollisionUtil;
import net.fexcraft.mod.fvtm.util.MathUtils;
import net.fexcraft.mod.fvtm.util.EntityWIE;
import net.fexcraft.mod.fvtm.util.OBB;
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
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
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
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

import java.util.ArrayList;
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
public class RootVehicle extends Entity implements IEntityAdditionalSpawnData {

	public VehicleInstance vehicle;
	public float rotZ = 0;
	public float protZ = 0;
	public float wheel_radius = 0;
	public float wheel_rotation = 0;
	public boolean should_sit = true;

	public RootVehicle(EntityType<?> type, Level level){
		super(type, level);
		vehicle = new VehicleInstance(new EntityWIE(this), null);
	}

	public void initVD(VehicleData data){
		vehicle.init(data, null);
		init(null);
	}

	protected void init(TagCW com){
		//
	}

	@Override
	protected void defineSynchedData(){

	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag){
		TagCW com = TagCW.wrap(tag);
		setXRot(com.getFloat("RotationPitch"));
		setYRot(com.getFloat("RotationYaw"));
		protZ = rotZ = com.getFloat("RotationYaw");
		setOldPosAndRot();
		vehicle.init(null, com);
		init(com);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag){
		TagCW com = TagCW.wrap(tag);
		vehicle.data.write(com);
		vehicle.point.savePivot(com);
	}

	@Override
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

	@Override
	public void readSpawnData(FriendlyByteBuf buffer){
		try{
			TagCW com = TagCW.wrap(buffer.readNbt());
			vehicle.init(null, com);
			readSpawnData(com);
			init(com);
			setYRot(vehicle.point.getPivot().deg_yaw());
			setXRot(vehicle.point.getPivot().deg_pitch());
			protZ = rotZ = vehicle.point.getPivot().deg_roll();
			setOldPosAndRot();
		}
		catch(Exception e){
			e.printStackTrace();
			FvtmLogger.LOGGER.log("Failed to read additional spawn data for vehicle entity with ID " + getId() + "!");
		}
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void writeSpawnData(TagCW com){}

	public void readSpawnData(TagCW com){}

	@Override
	public void kill(){
		if(vehicle != null) vehicle.onRemove();
		super.kill();
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
		int res = vehicle.onInteract((Passenger)UniEntity.getEntity(player), UniStack.getStack(player.getItemInHand(hand)));
		return res == 1 ? InteractionResult.SUCCESS : res == 0 ? InteractionResult.PASS : InteractionResult.FAIL;
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
		//tickCount++;
		if(tickCount >= Integer.MAX_VALUE) tickCount = 0;
		yRotO = vehicle.point.getPivot().deg_yaw();
		xRotO = vehicle.point.getPivot().deg_pitch();
		protZ = vehicle.point.getPivot().deg_roll();
		vehicle.onUpdate();
		checkCollision();
		if(!level().isClientSide && tickCount % VEHICLE_SYNC_RATE == 0){
			vehicle.sendUpdatePacket();
		}
	}

	private void checkCollision(){
		if(Config.DISABLE_OBB || vehicle.obb.isEmpty()) return;
		ArrayList<Entity> checked = new ArrayList<>();
		for(InteractZone zone : vehicle.data.getInteractZones().values()){
			level().getEntities(this, AABB.ofSize(position().add(zone.pos.x, zone.pos.y, zone.pos.z), zone.range, zone.range, zone.range),
				ent -> (ent instanceof LivingEntity) && !(ent instanceof WheelEntity)).forEach(entity -> {
				if(entity.getVehicle() != null || checked.contains(entity)) return;
				OBB bb = new OBB().set(net.fexcraft.mod.fvtm.data.block.AABB.wrap(entity.getBoundingBox()));
				for(OBB obb : vehicle.obb.values()){
					var res = CollisionUtil.check(bb, obb);
					if(res != null){
						Vec3 vec = new Vec3(-res.x, res.y, -res.z);
						entity.setDeltaMovement(entity.getDeltaMovement().scale(0.9).add(vec));
						checked.add(entity);
					}
				}
			});
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

	@Override
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
			if(seat.passenger() != null){
				if(seat.passenger().isPlayer()) return false;
				if(seat.passenger().isLiving()){
					Mob ent = seat.passenger().local();
					ent.unRide();
					ent.setLeashedTo(player, true);
					seat.interacttimer += 10;
					return true;
				}
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
