package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailDataSerializer implements ICapabilitySerializable<NBTBase>{
	
	public static final String REGNAM = "fvtm:raildata";
	private RailSystem instance;
	
	public RailDataSerializer(World world, int dimension){
		(instance = Capabilities.RAILSYSTEM.getDefaultInstance()).setWorld(world, dimension);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.RAILSYSTEM;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.RAILSYSTEM ? Capabilities.RAILSYSTEM.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.RAILSYSTEM.getStorage().writeNBT(Capabilities.RAILSYSTEM, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.RAILSYSTEM.getStorage().readNBT(Capabilities.RAILSYSTEM, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<RailSystem> {

		@Override
		public NBTBase writeNBT(Capability<RailSystem> capability, RailSystem instance, EnumFacing side){
			return instance.write(side);
		}

		@Override
		public void readNBT(Capability<RailSystem> capability, RailSystem instance, EnumFacing side, NBTBase nbt){
			instance.read(side, (NBTTagCompound)nbt);
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<RailSystem> {

		@Override
		public RailSystem call() throws Exception {
			return new RailData();
		}
		
	}

}
