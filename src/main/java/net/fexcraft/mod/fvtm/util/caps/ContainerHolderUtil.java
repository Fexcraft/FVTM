package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerHolderUtil implements ICapabilitySerializable<NBTBase> {

	public static final String REGNAM = "fvtm:containerholder";
	private Implementation instance;
	
	public ContainerHolderUtil(Entity entity){
		instance = new Implementation().setEntity(entity);
		instance.conhol.setupCapability(instance); instance.setup = true;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.CONTAINER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.CONTAINER ? Capabilities.CONTAINER.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.CONTAINER.getStorage().writeNBT(Capabilities.CONTAINER, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.CONTAINER.getStorage().readNBT(Capabilities.CONTAINER, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<ContainerHolder> {

		@Override
		public NBTBase writeNBT(Capability<ContainerHolder> capability, ContainerHolder instance, EnumFacing side){
			return ((Implementation)instance).write(side);
		}

		@Override
		public void readNBT(Capability<ContainerHolder> capability, ContainerHolder instance, EnumFacing side, NBTBase nbt){
			try{ Implementation impl = (Implementation)instance; impl.read(side, (NBTTagCompound)nbt); impl.sync(false); }
			catch(Exception e){ e.printStackTrace(); }
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<ContainerHolder> {

		@Override
		public ContainerHolder call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static class Implementation implements ContainerHolder {
		
		private Entity entity;
		private ContainerHoldingEntity conhol;
		private ContainerSlot[] slots = new ContainerSlot[0];
		public boolean setup;
		
		public Implementation(){}

		public NBTTagCompound write(EnumFacing side){
			NBTTagCompound compound = new NBTTagCompound();
			for(int i = 0; i < slots.length; i++){
				compound.setTag("Slot" + i, slots[i].write(null));
			} compound.setInteger("Slots", slots.length); return compound;
		}
		
		public void read(EnumFacing side, NBTTagCompound compound){
			slots = new ContainerSlot[compound.getInteger("Slots")];
			for(int i = 0; i < slots.length; i++){
				if(!compound.hasKey("Slot" + i)) continue;//this rather bad
				slots[i] = new ContainerSlot().read(compound.getCompoundTag("Slot" + i));
			}
		}

		public Implementation setEntity(Entity ent){
			conhol = (ContainerHoldingEntity)(entity = ent); return this;
		}

		@Override
		public ContainerSlot[] getContainerSlots(){
			return slots;
		}

		@Override
		public ContainerSlot getContainerSlot(String id){
			for(ContainerSlot slot : slots) if(slot.id.equals(id)) return slot; return null;
		}

		@Override
		public String[] getContainerSlotIds(){
			String[] strings = new String[slots.length];
			for(int i = 0; i < strings.length; i++) strings[i] = slots[i].id;
			return strings;
		}

		@Override
		public void addContainerSlot(ContainerSlot slot){
			if(setup){ Print.log(entity.getName() + " --> Tried to register a new Container Slot, but setup is already over."); return; }
			if(contains(slot.id)){
				ContainerSlot con = getContainerSlot(slot.id);
				con.position = slot.position; con.rotation = slot.rotation; return;
			}
			ContainerSlot[] arr = new ContainerSlot[slots.length + 1];
			for(int i = 0; i < slots.length; i++) arr[i] = slots[i];
			arr[slots.length] = slot; slots = arr; this.sync(false);
		}

		private boolean contains(String id){
			for(String str : this.getContainerSlotIds()) if(str.equals(id)) return true; return false;
		}

		@SideOnly(Side.CLIENT) @Override
		public void render(double x, double y, double z){
			org.lwjgl.opengl.GL11.glPushMatrix();
			if(x != 0d || y != 0d || z != 0d) org.lwjgl.opengl.GL11.glTranslated(x, y, z);
			for(ContainerSlot slot : slots) slot.render(entity);
			org.lwjgl.opengl.GL11.glPopMatrix();
		}

		@Override
		public void sync(boolean fromside){
			NBTTagCompound compound = fromside ? new NBTTagCompound() : write(null);
			compound.setString("target_listener", "fvtm:gui");
			compound.setString("task", "update_container_holder");
			compound.setInteger("entity", entity.getEntityId());
			if(fromside){ PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound)); }
			else{ PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(entity)); }
		}

		@SideOnly(Side.CLIENT) @Override
		public void openGUI(EntityPlayer player){
			if(entity.world.isRemote){
				GenericGui.openGui("fvtm", 937, new int[]{ entity.getEntityId(), 0, 0 }); return;
			}
			if(player == null) Static.exception(new Exception("Tried to open GUI on server side, but no player specified / is NULL."), false);
			GenericGui.openGui("fvtm", 937, new int[]{ entity.getEntityId(), 0, 0 }, player);
		}

		@Override
		public void dropContents(){
			if(entity.world.isRemote) return;
			for(ContainerSlot slot : slots){
				for(ContainerData data : slot.getContainers()){
					if(data == null) continue;
					EntityItem stack = new EntityItem(entity.world);
					stack.setItem(data.newItemStack());
					stack.setPosition(entity.posX, entity.posY + 1, entity.posZ);
					entity.world.spawnEntity(stack);
				}
				slot.clear();
			}
		}
		
	}

}
