package net.fexcraft.mod.fvtm.entity;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.impl.EntityWIE;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.SpawnPacket;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.PKT_UPD_LOCK;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity implements SpawnPacket.PacketEntity {

	public VehicleInstance vehicle;
	public BoundingBox renderbox;
	public float rotZ = 0;
	public float protZ = 0;
	private int synctimer;
	public boolean should_sit = true;

	public RootVehicle(EntityType<?> type, Level level){
		super(type, level);
		vehicle = new VehicleInstance(new EntityWIE(this), null);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder){

	}

	public void initVD(VehicleData data){
		vehicle.init(data, null);
		init(null);
	}

	protected void init(TagCW com){
		if(level().isClientSide){
			int w = vehicle.data.getAttribute("hitbox_width").asInteger();
			int h = vehicle.data.getAttribute("hitbox_height").asInteger();
			renderbox = new BoundingBox(-w, -h, -w, w, h, w);
		}
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag){
		TagCW com = TagCW.wrap(tag);
		setXRot(com.getFloat("RotationPitch"));
		setYRot(com.getFloat("RotationYaw"));
		protZ = rotZ = com.getFloat("RotationRoll");
		setOldPosAndRot();
		vehicle.init(null, com);
		init(com);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag){
		TagCW com = TagCW.wrap(tag);
		if(vehicle.data == null){
			FvtmLogger.log("Entity with ID '" + getId() + "' has no vehicle data, not saving.");
			remove(RemovalReason.DISCARDED);
			return;
		}
		vehicle.data.write(com);
		vehicle.point.savePivot(com);
	}

	@Override
	public void writeSpawnData(TagCW com){
		if(vehicle.data == null){
			FvtmLogger.log("Entity with ID '" + getId() + "' has no vehicle data, removing.");
			remove(RemovalReason.DISCARDED);
			return;
		}
		vehicle.point.savePivot(com);
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
		vehicle.data.write(com);
	}

	@Override
	public void readSpawnData(TagCW com){
		try{
			vehicle.init(null, com);
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
	public void kill(ServerLevel level){
		if(vehicle != null) vehicle.onRemove();
		super.kill(level);
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
			if(level().isClientSide && synctimer < 1){
				ClientPlayNetworking.send(new SpawnPacket((Entity)this));
				synctimer = 10;
			}
			synctimer--;
			FvtmLogger.log("Vehicle '" + getId() + "' has no data, skipping update. " + level().isClientSide);
			return;
		}
		tickCount++;
		if(tickCount >= Integer.MAX_VALUE) tickCount = 0;
		yRotO = vehicle.point.getPivot().deg_yaw();
		xRotO = vehicle.point.getPivot().deg_pitch();
		protZ = vehicle.point.getPivot().deg_roll();
		vehicle.onUpdate();
		//collchecks
		if(!level().isClientSide && tickCount % VEHICLE_SYNC_RATE == 0){
			vehicle.sendUpdatePacket();
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

	/*@Override
	public boolean shouldRiderSit(){
		return should_sit;
	}*/

	public SeatInstance getSeatOf(Entity entity){
		Passenger pass = UniEntity.getCasted(entity);
		if(pass == null || pass.seat() < 0 || vehicle.seats.isEmpty() || pass.seat() >= vehicle.seats.size()) return null;
		return vehicle.seats.get(pass.seat());
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float f){
		if(source.getDirectEntity() instanceof Player && getDriver() == null){
			Passenger pass = UniEntity.getCasted(source.getDirectEntity());
			Player player = (Player)source.getDirectEntity();
			if(vehicle.data.getLock().isLocked()){
				pass.send("interact.fvtm.vehicle.remove_locked");
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
					rear.spawnAtLocation(level, trailer.data.newItemStack().local(), 0.5f);
					rear.kill(level);
				}
			}
			spawnAtLocation(level, vehicle.data.newItemStack().local(), 0.5f);
			kill(level);
			return true;
		}
		return true;
	}

	@Override
	public ItemStack getPickResult(){
		return vehicle.data.newItemStack().local();
	}

	@Override
	public void lerpMotion(double x, double y, double z){
		//
	}

	@Override
	public void lerpHeadTo(float y, int x){
		//
	}

	@Override
	public void lerpPositionAndRotationStep(int sm, double x, double y, double z, double yr, double xr){
        //
    }

	@Override
	public void moveOrInterpolateTo(Vec3 vec3, float f, float g){
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
					//mob.dropLeash(true, !player.isCreative());
					mob.dropLeash();
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
