package net.fexcraft.mod.fvtm.entities;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packets.PacketSeatDismount;
import net.fexcraft.mod.fvtm.util.packets.PacketSeatUpdate;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import com.google.common.collect.Lists;

public class SeatEntity extends Entity implements /*IEntityAdditionalSpawnData,*/ IPacketReceiver<PacketEntityUpdate> {
	
	private int vehicleid;
	private int seatid;
	private VehicleEntity vehicle;
	//
	public boolean driver;
	public FMSeat seatdata;
	public VehicleAxes looking, prevlooking, passlooking, prevpasslooking;
	//
	private double pass_x, pass_y, pass_z;
	private float pass_yaw, pass_pitch, pass_roll;
	private double prev_pass_x, prev_pass_y, prev_pass_z;
	@SuppressWarnings("unused")
	private float prev_pass_yaw, prev_pass_pitch, prev_pass_roll;
    private Entity passenger;
	
	public SeatEntity(World world){
		super(world);
		setSize(0.5F, 0.5F);
		prevlooking= new VehicleAxes();
		looking = new VehicleAxes();
		passlooking = new VehicleAxes();
		prevpasslooking = new VehicleAxes();
        this.passenger = null;
        if(world.isRemote){
        	rqSync();
        }
	}
	
	public SeatEntity(World world, VehicleEntity veh, int id){
		this(world);
		vehicle = veh;
		seatid = id;
		driver = id == 0;
		vehicleid = veh.getEntity().getEntityId();
		seatdata = vehicle.getVehicleData().getSeats().get(id);
		setPosition(veh.getEntity().posX, veh.getEntity().posY, veh.getEntity().posZ);
		pass_x = prev_pass_x = posX; pass_y = prev_pass_y = posY; pass_z = prev_pass_z = posZ;
		looking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
		prevlooking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
        this.passenger = null;
	}
	
	@Nullable
	public VehicleEntity getVehicle(){
		return vehicle;
	}
	
	public void rqSync(){
		NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setString("request", "sync");
    	ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
	}
	
	@Override
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int partialticks, boolean b){
		super.setPositionAndRotationDirect(x, y, z, yaw, pitch, partialticks, b);//TODO check
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		//
		if(world.isRemote && vehicle == null){
			rqSync();
		}
		//
		if((world.isRemote && vehicle == null) || !Config.ALTERNATIVE_SEAT_UPDATE){
			return;
		}
		prev_pass_x = pass_x; prev_pass_y = pass_y; prev_pass_z = pass_z;
		prev_pass_yaw = pass_yaw; prev_pass_pitch = pass_pitch; prev_pass_roll = pass_roll;

		Vec3d relpos = vehicle.getAxes().getRelativeVector(seatdata.getPos().to16Double());
		setPosition(vehicle.getEntity().posX + relpos.x, vehicle.getEntity().posY + relpos.y, vehicle.getEntity().posZ + relpos.z);
		this.lastTickPosX = this.prevPosX = posX; this.lastTickPosY = this.prevPosY = posY; this.lastTickPosZ = this.prevPosZ = posZ;

		if(this.getControllingPassenger() != null){
			Vec3d yOffset = vehicle.getAxes().getRelativeVector(new Vec3d(0, this.getControllingPassenger().getEyeHeight() * 3 / 4, 0)).subtract(0, this.getControllingPassenger().getEyeHeight(), 0);
			pass_x = posX + yOffset.x; pass_y = posY + yOffset.y; pass_z = posZ + yOffset.z;
			this.updatePassenger();
			//
			VehicleAxes globalLookAxes = vehicle.getAxes().getRelativeVector(passlooking);
			pass_yaw = -90F + globalLookAxes.getYaw();
			pass_pitch = globalLookAxes.getPitch();
			//
			double yaw = pass_yaw - prev_pass_yaw;
			if(yaw >  180){ prev_pass_yaw += 360F; }
			if(yaw < -180){ prev_pass_yaw -= 360F; }
			if(this.getControllingPassenger() instanceof EntityPlayer){
				this.getControllingPassenger().prevRotationYaw = prev_pass_yaw;
				this.getControllingPassenger().prevRotationPitch = prev_pass_pitch;
				//
				this.getControllingPassenger().rotationYaw = pass_yaw;
				this.getControllingPassenger().rotationPitch = pass_pitch;
			}
			if(world.isRemote){
				pass_roll = -globalLookAxes.getRoll();
			}
		}
	}
	
	public void updatePosition(){
		if(world.isRemote && vehicle == null){
			return;
		}
		if(Config.ALTERNATIVE_SEAT_UPDATE){
			return;
		}
		prev_pass_x = pass_x; prev_pass_y = pass_y; prev_pass_z = pass_z;
		prev_pass_yaw = pass_yaw; prev_pass_pitch = pass_pitch; prev_pass_roll = pass_roll;

		Vec3d relpos = vehicle.getAxes().getRelativeVector(seatdata.getPos().to16Double());
		//this.posX = vehicle.getEntity().posX + relpos.x; this.posY = vehicle.getEntity().posY + relpos.y; this.posZ = vehicle.getEntity().posZ + relpos.z;
		setPosition(vehicle.getEntity().posX + relpos.x, vehicle.getEntity().posY + relpos.y, vehicle.getEntity().posZ + relpos.z);
		this.lastTickPosX = this.prevPosX = posX; this.lastTickPosY = this.prevPosY = posY; this.lastTickPosZ = this.prevPosZ = posZ;

		if(this.getControllingPassenger() != null){
			pass_x = posX; pass_y = posY - 0.5; pass_z = posZ;
			this.updatePassenger();
			//
			VehicleAxes globalLookAxes = vehicle.getAxes().getRelativeVector(passlooking);
			pass_yaw = -90F + globalLookAxes.getYaw();
			pass_pitch = globalLookAxes.getPitch();
			//
			double yaw = pass_yaw - prev_pass_yaw;
			if(yaw >  180){ prev_pass_yaw += 360F; }
			if(yaw < -180){ prev_pass_yaw -= 360F; }
			if(this.getControllingPassenger() instanceof EntityPlayer){
				this.getControllingPassenger().prevRotationYaw = prev_pass_yaw;
				this.getControllingPassenger().prevRotationPitch = prev_pass_pitch;
				//
				this.getControllingPassenger().rotationYaw = pass_yaw;
				this.getControllingPassenger().rotationPitch = pass_pitch;
			}
			if(world.isRemote){
				pass_roll = -globalLookAxes.getRoll();
			}
		}
	}

	@Override
	public void updatePassenger(Entity passengerr){
		if(passengerr == null){ return; }
		//
		passenger.rotationYaw = pass_yaw;
		passenger.rotationPitch = pass_pitch;
		passenger.prevRotationYaw = prev_pass_yaw;
		passenger.prevRotationPitch = prev_pass_pitch;
		passenger.lastTickPosX = passenger.prevPosX = prev_pass_x;
		passenger.lastTickPosY = passenger.prevPosY = prev_pass_y;
		passenger.lastTickPosZ = passenger.prevPosZ = prev_pass_z;
		//
		passenger.setPosition(pass_x, pass_y, pass_z);
	}

	public void processServerPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("request")){
			switch(pkt.nbt.getString("request")){
				case "sync":{
					try{
						NBTTagCompound nbt = new NBTTagCompound();
						nbt = seatdata.write(nbt);
						nbt.setString("task", "sync");
						nbt.setInteger("id", seatid);
						nbt.setInteger("vid", vehicle.getEntity().getEntityId());
						ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
					}
					catch(Exception e){
						e.printStackTrace();
						//remove seat since it's apparently non existent or broken.
					}
					break;
				}
			}
		}
	}

	public void processClientPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("task")){
			switch(pkt.nbt.getString("task")){
				case "sync":{
					this.seatdata = new FMSeat(pkt.nbt);
					this.seatid = pkt.nbt.getInteger("id");
					this.vehicleid = pkt.nbt.getInteger("vid");
					this.vehicle = (VehicleEntity)world.getEntityByID(vehicleid);
					this.driver = seatid == 0;
					this.vehicle.getSeats()[seatid] = this;
					//
					Print.debug(seatdata.getPos().toString());
					looking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
					prevlooking.setAngles((seatdata.minyaw + seatdata.maxyaw) / 2, 0F, 0F);
					Vec3d relpos = vehicle.getAxes().getRelativeVector(seatdata.getPos().to16Double());
					pass_x = prev_pass_x = prevPosX = posX = vehicle.getEntity().posX + relpos.x;
					pass_y = prev_pass_y = prevPosY = posY = vehicle.getEntity().posY + relpos.y;
					pass_z = prev_pass_z = prevPosZ = posZ = vehicle.getEntity().posZ + relpos.z;
					setPosition(posX, posY, posZ);
					break;
				}
			}
		}
	}
	
	public void updatePassenger(){
		this.updatePassenger(passenger);
	}

	@Override
	public boolean canBeCollidedWith(){
		return !isDead;
	}
	
	@Override
	protected void entityInit(){
		//
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound tags){
		//
	}
	
	@Override
	public boolean isPassenger(Entity entity){
		return passenger.equals(entity);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tags){
		//
	}
	
	@Override
	public boolean writeToNBTOptional(NBTTagCompound tags){
		return false;
	}

	public void onMouseMoved(int dx, int dy){
		if(vehicle == null){ return; }	
		//
		prevlooking = looking.clone();
		prevpasslooking = passlooking.clone();
		//
		double lookSpeed = 4F;
		double npasspitch = passlooking.getPitch() - dy / lookSpeed * Minecraft.getMinecraft().gameSettings.mouseSensitivity;
		if(npasspitch > -seatdata.minpitch){ npasspitch = -seatdata.minpitch; }
		if(npasspitch < -seatdata.maxpitch){ npasspitch = -seatdata.maxpitch; }
		//
		double npassyaw = passlooking.getYaw() + dx / lookSpeed * Minecraft.getMinecraft().gameSettings.mouseSensitivity;
		double opassyaw = npassyaw - 360F; 
		if(npassyaw < 0){ opassyaw = npassyaw + 360F;}
		if(!(npassyaw >= seatdata.minyaw && npassyaw <= seatdata.maxyaw) || (opassyaw >= seatdata.minyaw && opassyaw <= seatdata.maxyaw)){
			double npassyawd = Math.min(Math.abs(npassyaw - seatdata.minyaw), Math.abs(npassyaw - seatdata.maxyaw));
			double opassyawd = Math.min(Math.abs(opassyaw - seatdata.minyaw), Math.abs(opassyaw - seatdata.maxyaw));
			if(npassyawd <= opassyawd){
				if(npassyaw > seatdata.maxyaw){ npassyaw = seatdata.maxyaw; }
				if(npassyaw < seatdata.minyaw){ npassyaw = seatdata.minyaw; }
			}
			else{
				if(opassyaw > seatdata.maxyaw){ opassyaw = seatdata.maxyaw; }
				if(opassyaw < seatdata.minyaw){ opassyaw = seatdata.minyaw; }
				if(npassyaw < 0){ npassyaw = opassyaw - 360F; }
				else npassyaw = opassyaw + 360F;
			}
		}
		passlooking.setAngles(npassyaw, npasspitch, 0F);
		//
		Vec3d vecais = new Vec3d(1, 1, 0);
		double targetx = passlooking.getYaw();
		double yawToMove = (targetx - looking.getYaw());
		for(; yawToMove > 180F; yawToMove -= 360F) {}
		for(; yawToMove <= -180F; yawToMove += 360F) {}
		float signDeltaX = 0;
		if(yawToMove > (vecais.x / 2)){ signDeltaX = 1; }
		else if(yawToMove < -(vecais.x  /2)){ signDeltaX = -1; }
		else { signDeltaX = 0; }
		//
		double newYaw = 0f;
		if((signDeltaX == 0 && dx == 0)){
			newYaw = passlooking.getYaw();
		} else {
			newYaw = looking.getYaw() + signDeltaX * vecais.x;
		}
		//
		double otherNewYaw = newYaw - 360F; 
		if(newYaw < 0){ otherNewYaw = newYaw + 360F; }
		if(!(newYaw >= seatdata.minyaw && newYaw <= seatdata.maxyaw) || (otherNewYaw >= seatdata.minyaw && otherNewYaw <= seatdata.maxyaw)){
			double newYawDistFromRange = Math.min(Math.abs(newYaw - seatdata.minyaw), Math.abs(newYaw - seatdata.maxyaw));
			double otherNewYawDistFromRange = Math.min(Math.abs(otherNewYaw - seatdata.minyaw), Math.abs(otherNewYaw - seatdata.maxyaw));
			if(newYawDistFromRange <= otherNewYawDistFromRange){
				if(newYaw > seatdata.maxyaw){ newYaw = seatdata.maxyaw; }
				if(newYaw < seatdata.minyaw){ newYaw = seatdata.minyaw; }
			}
			else{
				if(otherNewYaw > seatdata.maxyaw){ otherNewYaw = seatdata.maxyaw; }
				if(otherNewYaw < seatdata.minyaw){ otherNewYaw = seatdata.minyaw; }
				if(newYaw < 0){ newYaw = otherNewYaw - 360F; }
				else newYaw = otherNewYaw + 360F;
			}
		}
		//
		double targetY = passlooking.getPitch();
		double pitchToMove = (targetY - looking.getPitch());
		for(; pitchToMove > 180F; pitchToMove -= 360F) {}
		for(; pitchToMove <= -180F; pitchToMove += 360F) {}
		//
		double signDeltaY = 0;
		if(pitchToMove > (vecais.y / 2)){ signDeltaY = 1; }
		else if(pitchToMove < -(vecais.y / 2)){ signDeltaY = -1; }
		else{ signDeltaY = 0; } 
		//
		double newPitch = 0f;
		double minYawToMove = 0f;
		double currentYawToMove = 0f;
		minYawToMove = (Math.sqrt((pitchToMove / vecais.y) * (pitchToMove / vecais.y))) * vecais.x;
		currentYawToMove = (float)Math.sqrt((yawToMove)*(yawToMove));
		if((signDeltaY == 0 && dy == 0)){ newPitch = passlooking.getPitch(); }
		else if(currentYawToMove < minYawToMove){ newPitch = looking.getPitch() + signDeltaY * vecais.y; }
		else{ newPitch = looking.getPitch(); }
		if(newPitch > -seatdata.minpitch){ newPitch = -seatdata.minpitch; }
		if(newPitch < -seatdata.maxpitch){ newPitch = -seatdata.maxpitch; }
		looking.setAngles(newYaw, newPitch, 0F);
		PacketHandler.getInstance().sendToServer(new PacketSeatUpdate(this));
		return;
	}

	public boolean onKeyPress(int key, EntityPlayer player){
		//Print.debug("S: " + key + " " + seatid + " " + player.getName() + " [" + Time.getDate() + "];");
		if(key < 0){
			this.vehicle.getVehicleData().getScripts().forEach((script) -> script.onKeyInput(key, this.seatid, this.vehicle));
			return false;
		}
		if(vehicle != null){
			/*if(world.isRemote){
				PacketHandler.getInstance().sendToServer(new PacketVehicleKeyPress(key));
				return false;
			}
			else*/ return vehicle.onKeyPress(key, seatid, player);
		}
		if(key == 6){
			passenger.dismountRidingEntity();
		}
		return false;
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand hand){
		if(isDead || world.isRemote){
			return false;
		}
		ItemStack currentItem = entityplayer.getHeldItem(hand);
		if(vehicle.getVehicleData().isLocked()){
			Print.chat(entityplayer, "Vehicle is Locked.");
			return true;
		}
		if(currentItem != null && currentItem.getItem() instanceof ItemLead){
			if(this.getControllingPassenger() != null && this.getControllingPassenger() instanceof EntityLiving && !(this.getControllingPassenger() instanceof EntityPlayer)){
				EntityLiving mob = (EntityLiving)this.getControllingPassenger();
				this.getControllingPassenger().dismountRidingEntity();
				Print.spam(1, "PASSENGER != ENTITYPLAYER >>> DISMOUNTING");
				mob.setLeashedToEntity(entityplayer, true);
				return true;
			}
			double checkRange = 10;
			List<EntityLiving> nearbyMobs = world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(posX - checkRange, posY - checkRange, posZ - checkRange, posX + checkRange, posY + checkRange, posZ + checkRange));
			for(EntityLiving entity : nearbyMobs){
				if(entity.getLeashed() && entity.getLeashedToEntity() == entityplayer){
					entity.startRiding(this);
					looking.setAngles(-entity.rotationYaw, entity.rotationPitch, 0F);
					entity.clearLeashed(true, !entityplayer.capabilities.isCreativeMode);
				}
			}
			return true;
		}
		if(this.getControllingPassenger() == null){
			entityplayer.startRiding(this);
			return true;
		}
		return false;
	}
	
	@Override
	public Entity getControllingPassenger(){
		return passenger;
	}
	
	@Override
	public List<Entity> getPassengers(){
		List<Entity> list = Lists.<Entity>newArrayList();
		if(passenger != null){
			list.add(passenger);
		}
		return list;
	}
	
	@Override
	public void addPassenger(Entity passenger){
		if(passenger.getRidingEntity() != this){
            throw new IllegalStateException("Use x.startRiding(y), not y.addPassenger(x)");
        }
        else{
        	this.passenger = passenger;
        }
		Print.debug("AP => " + Time.getDate() + " " + seatid + " " +(world.isRemote ? "[CLIENT]" : "[SERVER]"));
	}
	
	@Override
	public void removePassenger(Entity entity){
		if(world.isRemote){
			passenger = null;
			Print.debug("RM => " + Time.getDate() + " " + seatid + " [CLIENT] OK");
		}
		else{
			PacketHandler.getInstance().sendToAllAround(new PacketSeatDismount(passenger.getEntityId()), Resources.getTargetPoint(this));
			passenger = null;
			Print.debug("RM => " + Time.getDate() + " " + seatid + " [SERVER]");
		}
	}
	
	@Override
	public void setDead(){
		if(world.isRemote){
			this.isDead = true;
			Print.debug("DD => " + Time.getDate() + " " + seatid + " [CLIENT] OK;");
		}
		else{
			this.isDead = true;
			Print.debug("DD => " + Time.getDate() + " " + seatid + " [SERVER]");
		}
	}
	
	public float getCameraDistance(){
		return vehicle != null && seatid == 0 ? vehicle.getVehicleData().getVehicle().getFMCameraDistance() : 5F;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float f){
		return !(world.isRemote && vehicle != null) && vehicle.getEntity().attackEntityFrom(source, f);
	}

	public int getSeatId(){
		return seatid;
	}

	@Override
	public void applyEntityCollision(Entity entity){
		return;
	}
	
	@Override
	public boolean shouldRiderSit(){
        return seatdata == null ? true : seatdata.sitting;
    }
	
	@Override
	public boolean canRiderInteract(){
        return super.canRiderInteract();//TODO test this
    }
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity){
		return null;//entity.getEntityBoundingBox();
	}

	@Override
	public boolean canBePushed(){
		return false;
	}

	public boolean isPassengerThePlayer(){
		if(world.isRemote){
			return passenger == net.minecraft.client.Minecraft.getMinecraft().player;
		}
		else return false;
	}

}