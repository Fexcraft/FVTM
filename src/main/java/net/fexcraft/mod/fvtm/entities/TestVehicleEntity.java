package net.fexcraft.mod.fvtm.entities;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.packets.PacketSeatDismount;
import com.flansmod.common.util.Config;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class TestVehicleEntity extends Entity implements VehicleEntity, IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate>, LockableObject {
	
	private VehicleData data;
	private Entity passenger;
	
	public TestVehicleEntity(World world){
		super(world);
		Print.debug("Spawning! N:" + world.isRemote);
		if(!world.isRemote){
			this.setDead();
		}
		this.setSize(1, 1);
	}
	
	public TestVehicleEntity(World world, VehicleData data, Vec3d vec3d){
		super(world);
		this.data = data;
		this.posX = vec3d.x;
		this.posY = vec3d.y;
		this.posZ = vec3d.z;
		this.setSize(1, 1);
		Print.debug("Spawning! E:" + world.isRemote);
	}

	@Override
	protected void entityInit(){
		
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		ByteBufUtils.writeTag(buffer, data.writeToNBT(new NBTTagCompound()));
		//
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		data = Resources.getVehicleData(ByteBufUtils.readTag(buffer), world.isRemote);
		if(data == null){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("request", "remove");
			ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
		}
	}
	
	public void processServerPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("request")){
			switch(pkt.nbt.getString("request")){
				case "remove":{
					this.setDead();
					return;
				}
			}
		}
	}
	
	public void processClientPacket(PacketEntityUpdate pkt){
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		
	}

	@Override
	public VehicleData getVehicleData(){
		return data;
	}

	@Override
	public void keyPress(String string, EntityPlayer player){
		switch(string){
			case "accelerate":{
				
				break;
			}
			case "decelerate":{
				
				break;
			}
			case "turn_right":{
				
				break;
			}
			case "turn_left":{
				
				break;
			}
			case "brake":{
				
				break;
			}
		}
		Print.chat(player, string);
	}

	@Override
	public VehicleType getVehicleType(){
		return VehicleType.LAND;
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
		if(isDead || world.isRemote){
			return false;
		}
		ItemStack stack = player.getHeldItem(hand);
		if(!stack.isEmpty() && stack.getItem() instanceof KeyItem){
			if(this.isLocked()){
				this.unlock(world, player, stack, (KeyItem)stack.getItem());
			}
			else{
				this.lock(world, player, stack, (KeyItem)stack.getItem());
			}
			return true;
		}
		if(data.isLocked()){
			Print.chat(player, "Vehicle is locked.");
			return true;
		}
		//
		/*if(!stack.isEmpty() && stack.getItem() instanceof FuelItem){
			player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 2, 0, 0);//Fuel Inventory.
		}*/
		//
		if(!data.getScripts().isEmpty()){
			for(VehicleScript script : data.getScripts()){
				if(script.onInteract(this, data, player)){
					return true;
				}
			}
		}
		
		//TODO Item interaction
		
		/*for(int i = 0; i <= data.getFMSeats().size(); i++){
			if(seats[i] != null && seats[i].processInitialInteract(player, hand)){
				return true;
			}
		}*/
		if(this.passenger == null){
			player.startRiding(this);
			return true;
		}
		return false;
	}

	@Override
	public boolean isLocked(){
		return this.getVehicleData().isLocked();
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void addPassenger(Entity passenger){
		if(passenger.getRidingEntity() != this){
            throw new IllegalStateException("Use x.startRiding(y), not y.addPassenger(x)");
        }
        else{
        	this.passenger = passenger;
        }
		Print.debug("AP => " + Time.getDate() + " " + (world.isRemote ? "[CLIENT]" : "[SERVER]"));
	}
	
	@Override
	public void removePassenger(Entity entity){
		if(world.isRemote){
			passenger = null;
			Print.debug("RM => " + Time.getDate() + " [CLIENT] OK");
		}
		else{
			FlansMod.getNewPacketHandler().sendToAllAround(new PacketSeatDismount(passenger.getEntityId()), Config.getTargetPoint(this));
			passenger = null;
			Print.debug("RM => " + Time.getDate() + " [SERVER]");
		}
	}
	
	@Override
    public void updatePassenger(Entity passengerr){
		if(passengerr == null){
			return;
		}
		passenger.rotationYaw = this.rotationYaw;
		passenger.rotationPitch = this.rotationPitch;
		passenger.prevRotationYaw = this.prevRotationYaw;
		passenger.prevRotationPitch = this.prevRotationPitch;
		passenger.lastTickPosX = passenger.prevPosX = this.prevPosX;
		passenger.lastTickPosY = passenger.prevPosY = this.prevPosY;
		passenger.lastTickPosZ = passenger.prevPosZ = this.prevPosZ;
		
		passenger.setPosition(this.posX, this.posY, this.posZ);
    }
	
}