package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RoadSystem;
import net.fexcraft.mod.fvtm.sys.road.RoadSys;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/** @author Ferdinand Calo' (FEX___96) **/
public class RoadDataSerializer implements ICapabilitySerializable<NBTBase>{
	
	public static final String REGNAM = "fvtm:roaddata";
	private RoadSystem instance;
	
	public RoadDataSerializer(World world, int dimension){
		(instance = Capabilities.ROADSYSTEM.getDefaultInstance()).setWorld(world, dimension);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.ROADSYSTEM;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.ROADSYSTEM ? Capabilities.ROADSYSTEM.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.ROADSYSTEM.getStorage().writeNBT(Capabilities.ROADSYSTEM, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.ROADSYSTEM.getStorage().readNBT(Capabilities.ROADSYSTEM, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<RoadSystem> {

		@Override
		public NBTBase writeNBT(Capability<RoadSystem> capability, RoadSystem instance, EnumFacing side){
			return instance.write(side);
		}

		@Override
		public void readNBT(Capability<RoadSystem> capability, RoadSystem instance, EnumFacing side, NBTBase nbt){
			instance.read(side, (NBTTagCompound)nbt);
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<RoadSystem> {

		@Override
		public RoadSystem call() throws Exception {
			return new RoadSys();
		}
		
	}

}
