package net.fexcraft.mod.fvtm.impl.caps;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class WorldRailDataSerializer implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(WorldRailData.class)
	public static final Capability<WorldRailData> CAPABILITY = null;
	private WorldRailData instance;
	
	public WorldRailDataSerializer(World world, int dimension){
		(instance = CAPABILITY.getDefaultInstance()).setWorld(world, dimension);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == CAPABILITY ? CAPABILITY.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<WorldRailData> {

		@Override
		public NBTBase writeNBT(Capability<WorldRailData> capability, WorldRailData instance, EnumFacing side){
			return instance.write(side);
		}

		@Override
		public void readNBT(Capability<WorldRailData> capability, WorldRailData instance, EnumFacing side, NBTBase nbt){
			instance.read(side, nbt);
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<WorldRailData> {

		@Override
		public WorldRailData call() throws Exception {
			return new WorldRailUtil();
		}
		
	}

}
