package net.fexcraft.mod.fvtm.sys.rail.cap;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Static;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/** @author Ferdinand Calo' (FEX___96) **/
public class WorldRailDataSerializer implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(WorldRailData.class)
	public static final Capability<WorldRailData> CAPABILITY = null;
	public static final String REGNAM = "fvtm:raildata";
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
			return new WorldRailImpl();
		}
		
	}
	
	public static class Client implements IPacketListener<PacketNBTTagCompound> {

		@Override public String getId(){ return REGNAM; }

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")) return;
			//int dim = packet.nbt.getInteger("dimension");
			World world = net.minecraft.client.Minecraft.getMinecraft().world;
			WorldRailData data = world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
			//if(data == null) return;
			int x = packet.nbt.getInteger("RegionX");
			int z = packet.nbt.getInteger("RegionZ");
			if(packet.nbt.getString("task").equals("update")){
				data.updateRegion(x, z, packet.nbt);
			}
			else if(packet.nbt.getString("task").equals("unload")){
				data.unloadRegion(x, z);
			}
			//Print.console(packet.nbt); Static.stop();
		}
		
	}
	
	public static class Server implements IPacketListener<PacketNBTTagCompound> {

		@Override public String getId(){ return REGNAM; }

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")) return;
			int dim = packet.nbt.getInteger("dimension");
			World world = Static.getServer().getWorld(dim);
			WorldRailData data = world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
			//if(data == null) return;
			int[] reg = packet.nbt.getIntArray("region");
			if(packet.nbt.getString("task").equals("sync_region")){
				data.doTask("sync_region", reg, packet.nbt);
			}
			//Print.console(packet.nbt); Static.stop();
		}
		
	}

}
