package net.fexcraft.mod.fmt.capabilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Editor Player data Container Capability Util
 * @author Ferdinand (FEX___96)
 */
public class EPDCCU implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(EditorPlayerDataContainerCapability.class)
	public static final Capability<EditorPlayerDataContainerCapability> CAPABILITY = null;
	public static final ResourceLocation REGISTRY_NAME = new ResourceLocation("states:player");
	private EditorPlayerDataContainerCapability instance;
	
	public EPDCCU(EntityPlayer player){
		instance = CAPABILITY.getDefaultInstance();
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability == CAPABILITY ? CAPABILITY.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
	}
	
	public static class Callable implements java.util.concurrent.Callable<EditorPlayerDataContainerCapability>{

		@Override
		public EditorPlayerDataContainerCapability call() throws Exception {
			return new EPDCCI();
		}
		
	}

}
