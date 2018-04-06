package net.fexcraft.mod.fvtm.util.rail;

import java.util.TreeMap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RailMap implements ICapabilitySerializable<NBTBase> {
	
	@SubscribeEvent
	public static void onWorldLoad(AttachCapabilitiesEvent<World> event){
		if(event.getObject() instanceof World){
			event.addCapability(REGNAME, new RailMap(event.getObject()));
		}
	}
	
	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event){
		
	}
	
	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Unload event){
		
	}
	
	// --- // --- //
	
	@CapabilityInject(RailMapCapability.class)
	public static Capability<RailMapCapability> CAPABILITY = null;
	public static final ResourceLocation REGNAME = new ResourceLocation("fvtm:railmap");
	private final RailMapCapability instance;
	
	public RailMap(World world){
		instance = CAPABILITY.getDefaultInstance();
		instance.setWorld(world);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return hasCapability(capability, facing) ? CAPABILITY.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<RailMapCapability>{
		
		@Override
		public NBTBase writeNBT(Capability<RailMapCapability> capability, RailMapCapability instance, EnumFacing side){
			return instance.writeToNBT(capability, side);
		}

		@Override
		public void readNBT(Capability<RailMapCapability> capability, RailMapCapability instance, EnumFacing side, NBTBase nbt){
			instance.readFromNBT(capability, side, nbt);
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<RailMapCapability>{

		@Override
		public RailMapCapability call() throws Exception {
			return new RailMap.Implementation();
		}
		
	}
	
	public static class Implementation implements RailMapCapability {
		
		private TreeMap<BlockPos, RailPiece> railmap = new TreeMap<BlockPos, RailPiece>();
		private World world;

		@Override
		public NBTBase writeToNBT(Capability<RailMapCapability> capability, EnumFacing side){
			NBTTagCompound compound = new NBTTagCompound();
			return compound;
		}

		@Override
		public void readFromNBT(Capability<RailMapCapability> capability, EnumFacing side, NBTBase nbt){
			//NBTTagCompound compound = (NBTTagCompound)nbt;
		}

		@Override
		public void setWorld(World world){
			this.world = world;
		}

		@Override
		public World getWorld(){
			return world;
		}

		@Override
		public Vec3d getNearestRailPosition(Vec3d vehpos){
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Vec3d getSupposedPosition(Vec3d vehpos, double expected_distance, boolean direction){
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}