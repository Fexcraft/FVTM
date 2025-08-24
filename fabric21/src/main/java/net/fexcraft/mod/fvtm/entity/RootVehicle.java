package net.fexcraft.mod.fvtm.entity;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fcl.util.EntityWI;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.CollisionUtil;
import net.fexcraft.mod.fvtm.util.OBB;
import net.fexcraft.mod.fvtm.util.SpawnPacket;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity implements SpawnPacket.PacketEntity, VehicleInstance.Holder {

	public VehicleInstance vehicle;
	public float rotZ = 0;
	public float protZ = 0;
	private boolean cl_sync;
	public boolean should_sit = true;

	public RootVehicle(EntityType<?> type, Level level){
		super(type, level);
		vehicle = new VehicleInstance(new EntityWI(this), null);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder){

	}

	public void initVD(VehicleData data){
		vehicle.init(data, null);
		init(null);
	}

	protected void init(TagCW com){
		//
	}

	@Override
	protected void readAdditionalSaveData(ValueInput in){
		setXRot(in.getFloatOr("RotationPitch", 0));
		setYRot(in.getFloatOr("RotationYaw", 0));
		protZ = rotZ = in.getFloatOr("RotationRoll",0);
		setOldPosAndRot();
		TagCW com = TagCW.wrap(in);
		vehicle.init(null, com);
		init(com);
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput out){
		if(vehicle.data == null){
			FvtmLogger.log("Entity with ID '" + getId() + "' has no vehicle data, not saving.");
			remove(RemovalReason.DISCARDED);
			return;
		}
		vehicle.save(TagCW.wrap(out));
	}

	@Override
	public void writeSpawnData(TagCW com){
		if(vehicle.data == null){
			FvtmLogger.log("Entity with ID '" + getId() + "' has no vehicle data, removing.");
			remove(RemovalReason.DISCARDED);
			return;
		}
		vehicle.save(com);
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
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
		FvtmLogger.debug("Received sync for " + getId());
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
	public boolean canBeCollidedWith(Entity entity){
		return true;
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand){
		if(isRemoved() || hand == InteractionHand.OFF_HAND) return InteractionResult.PASS;
		int res = vehicle.onInteract(UniEntity.getEntity(player), UniStack.getStack(player.getItemInHand(hand)));
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
			if(level().isClientSide){
				if(!cl_sync){
					FvtmLogger.debug("Sending sync request for " + getId());
					ClientPlayNetworking.send(new SpawnPacket((Entity)this));
					cl_sync = true;
				}
			}
			else{
				FvtmLogger.log("Vehicle '" + getId() + "' has no data, removing!");
				kill((ServerLevel)level());
			}
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
		SeatInstance seat = vehicle.getSeatOf(pass);
		if(seat != null) updatePassenger(pass, seat);
		else{
			if(level().isClientSide) UniEntity.getApp(pass, Passenger.class).reqPassUpdate();
			pass.setPos(position());
		}
	}

	public void updatePassenger(Entity pass, SeatInstance seat){
		if(seat.passenger_direct() != pass){
			seat.passenger(UniEntity.getEntity(pass));
		}
		V3D pos = seat.getCurrentGlobalPosition();
		pass.setPos(pos.x, pos.y - (pass instanceof Player ? 0.7 : 0), pos.z);
		//check if flight reset is necessary on 1.20
	}

	@Override
	public void addPassenger(Entity pass){
		super.addPassenger(pass);
		SeatInstance seat = vehicle.getSeatOf(pass);
		if(seat != null) seat.passenger(UniEntity.getEntity(pass));
	}

	@Override
	public void removePassenger(Entity pass){
		for(SeatInstance seat : vehicle.seats){
			if(pass.equals(seat.passenger_direct())){
				seat.passenger(null);
			}
		}
		if(!level().isClientSide){
			UniEntity.getApp(pass, Passenger.class).set(-1, -1);
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

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float f){
		if(source.getDirectEntity() instanceof Player && getDriver() == null){
			EntityW pass = UniEntity.getEntity(source.getDirectEntity());
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

	@Override
	public VehicleInstance getVehicleInstance(){
		return vehicle;
	}

	public void onPacket(EntityW player, TagCW packet){
		//
	}

}
