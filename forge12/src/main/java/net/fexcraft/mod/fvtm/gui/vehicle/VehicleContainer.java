package net.fexcraft.mod.fvtm.gui.vehicle;

import static net.fexcraft.mod.fvtm.util.GuiHandler.VEHICLE_CONTAINER;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleContainer extends GenericContainer {

	protected GenericGui<VehicleContainer> gui;
	//
	private boolean invmode;
	protected InventoryFunction function;
	protected RootVehicle vehent;
	protected PartData invpart;
	protected String inv_id;
	protected int slots;
	/** When things have to be fixed by force. */
	protected EntityPlayerMP mpp;
	//
	protected ContainerSlot slot;
	protected ConSlotInv slotInv;
	protected String slotid;
	protected Entity entity;

	public VehicleContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		if(x == VEHICLE_CONTAINER){
			if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
			entity = player.world.getEntityByID(y);
			this.inventoryItemStacks.clear();
			this.inventorySlots.clear();
			slotid = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlotIds()[z];
			slot = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlot(slotid);
			//
			slotInv = new ConSlotInv(slot, entity);
			slots = slot.length;
			for(int col = 0; col < 12; col++){
				if(col >= slot.length) break;
				addSlotToContainer(new ConSlotInv.SSlot(slotInv, col, 8 + col * 18, 22));
			}
			//
			for(int row = 0; row < 3; row++){
				for(int col = 0; col < 9; col++){
					addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 64 + row * 18));
				}
			}
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 120));
			}
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(invmode){
			if(side.isServer()){
				//
			}
			else{
				if(packet.getString("cargo").equals("update_stack")){
					inventorySlots.get(packet.getInteger("index")).putStack(new ItemStack(packet.getCompoundTag("stack")));
					inventoryItemStacks.set(packet.getInteger("index"), new ItemStack(packet.getCompoundTag("stack")));
				}
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(index < slots){
				if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)){ return ItemStack.EMPTY; }
			}
			else if(!this.mergeItemStack(itemstack1, 0, slots, false)){ return ItemStack.EMPTY; }
			if(itemstack1.isEmpty()){
				slot.putStack(ItemStack.EMPTY);
			}
			else{
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		if(slotInv != null){
			slotInv.closeInventory(player);
		}
	}

	@Override
	public void detectAndSendChanges(){
		if(slotInv == null){
			super.detectAndSendChanges();
		}
		else{
			for(int i = 0; i < this.inventorySlots.size(); ++i){
				ItemStack itemstack = ((Slot)this.inventorySlots.get(i)).getStack(), itemstack1 = this.inventoryItemStacks.get(i);
				if(ItemStack.areItemStacksEqual(itemstack1, itemstack)) continue;
				boolean clientStackChanged = !ItemStack.areItemStacksEqualUsingNBTShareTag(itemstack1, itemstack);
				itemstack1 = itemstack.isEmpty() ? ItemStack.EMPTY : itemstack.copy();
				this.inventoryItemStacks.set(i, itemstack1);
				if(!clientStackChanged) continue;
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "update_stack");
				compound.setInteger("index", i);
				compound.setTag("stack", itemstack1.writeToNBT(new NBTTagCompound()));
				this.send(Side.CLIENT, compound);
			}
		}
	}

}
