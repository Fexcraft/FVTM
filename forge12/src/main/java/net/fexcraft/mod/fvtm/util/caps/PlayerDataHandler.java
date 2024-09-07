package net.fexcraft.mod.fvtm.util.caps;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.PlayerData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerDataHandler implements ICapabilitySerializable<NBTBase>{
	
	private PlayerData instance;
	
	public PlayerDataHandler(Entity entity){
		(instance = Capabilities.PLAYERDATA.getDefaultInstance()).setPlayer((EntityPlayer)entity);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability == Capabilities.PLAYERDATA;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability == Capabilities.PLAYERDATA ? Capabilities.PLAYERDATA.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.PLAYERDATA.getStorage().writeNBT(Capabilities.PLAYERDATA, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.PLAYERDATA.getStorage().readNBT(Capabilities.PLAYERDATA, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<PlayerData> {

		@Override
		public NBTBase writeNBT(Capability<PlayerData> capability, PlayerData instance, EnumFacing side){
			NBTTagCompound com = new NBTTagCompound(); 
			return com;
		}

		@Override
		public void readNBT(Capability<PlayerData> capability, PlayerData instance, EnumFacing side, NBTBase nbt){
			//
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<PlayerData> {

		@Override
		public PlayerData call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static class Implementation implements PlayerData {
		
		private EntityPlayer player;
		private HashMap<VehicleType, String> systems = new HashMap<>();
		private Vec3d position;
		
		@Override
		public void setPlayer(EntityPlayer player){
			this.player = player;
		}

		@Override
		public EntityPlayer getPlayer(){
			return player;
		}

		@Override
		public String getFavoriteSpawnSystemFor(VehicleType type){
			return systems.get(type);
		}

		@Override
		public boolean setFavoriteSpawnSystemFor(VehicleType type, String systemid){
			return systems.put(type, systemid) == null;
		}

		@Override
		public void setActiveSpawnPoint(Vec3d vector){
			position = vector;
		}

		@Override
		public Vec3d getActiveSpawnPoint(){
			return position;
		}

	}

}
