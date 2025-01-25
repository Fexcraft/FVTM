package net.fexcraft.mod.fvtm.gui.container;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;

public class ContainerInvContainer extends GenericContainer {

	protected GenericGui<ContainerInvContainer> gui;
	//
	protected long fluid_date;
	protected IInventory fluid_io;
	protected FluidTank tank;
	protected int slots;
	//
	protected ContainerEntity tile;

	public ContainerInvContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		this.tile = (ContainerEntity)world.getTileEntity(new BlockPos(x, y, z));
		this.populateSlots();
	}

	protected void populateSlots(){
		this.inventoryItemStacks.clear();
		this.inventorySlots.clear();
		slots = 0;
		InvType type = tile.getInventoryType();
		if(type.isFluid()){
			fluid_io = UniInventory.create(2).stacksize(1).cast();
			slots = 2;
			addSlotToContainer(new Slot(fluid_io, 0, 116, 50));
			addSlotToContainer(new Slot(fluid_io, 1, 152, 50));
			//
			for(int row = 0; row < 3; row++){
				for(int col = 0; col < 9; col++){
					addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 74 + row * 18));
				}
			}
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 130));
			}
			tank = tile.getContainerData().getInventory().getTank();
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			//
		}
		else{
			if(packet.getString("cargo").equals("update_fluid_tank")){
				tile.getContainerData().getInventory().load(new TagCWI(packet), "state");
				if(packet.hasKey("stack_0")) fluid_io.setInventorySlotContents(0, new ItemStack(packet.getCompoundTag("stack_0")));
				if(packet.hasKey("stack_1")) fluid_io.setInventorySlotContents(1, new ItemStack(packet.getCompoundTag("stack_1")));
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
		if(fluid_io != null){
			fluid_io.closeInventory(player);
		}
		tile.markDirty();
	}

	@Override
	public void detectAndSendChanges(){
		if(fluid_io != null && tile.getContainerData().getInventory().getTank() != null){
			if(fluid_date + 50 <= Time.getDate()){
				fluid_date = Time.getDate();
				boolean anychange = false;
				//
				ItemStack stack = fluid_io.getStackInSlot(0);
				if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
					IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
					if(item.getTankProperties().length > 0 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
						FluidActionResult result = FluidUtil.tryEmptyContainer(stack, tile.getContainerData().getInventory().getTank(), 1000, player, true);
						if(result.success){
							anychange = true;
							fluid_io.setInventorySlotContents(0, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
				}
				//
				if(((FluidTank)tile.getContainerData().getInventory().getTank()).getFluidAmount() > 0){
					stack = fluid_io.getStackInSlot(1);
					if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
						FluidActionResult result = FluidUtil.tryFillContainer(stack, tile.getContainerData().getInventory().getTank(), 1000, player, true);
						if(result.success){
							anychange = true;
							fluid_io.setInventorySlotContents(1, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
				}
				//
				if(!player.world.isRemote && anychange){
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "update_fluid_tank");
					tile.getContainerData().getInventory().save(new TagCWI(compound), "state");
					compound.setTag("stack_0", fluid_io.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
					compound.setTag("stack_1", fluid_io.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
					this.send(Side.CLIENT, compound);
				}
			}
		}
		//
		super.detectAndSendChanges();
	}

}
