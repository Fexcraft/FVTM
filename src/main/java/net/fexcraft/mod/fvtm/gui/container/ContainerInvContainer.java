package net.fexcraft.mod.fvtm.gui.container;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.util.handler.ItemStackHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerInvContainer extends GenericContainer {
	
	protected GenericGui<ContainerInvContainer> gui;
	//
	protected long fluid_date;
	protected EntityPlayerMP mpp;
	protected ItemStackHandler temp;
	protected GenericIInventory fluid_io;
	protected int empty_index = -1, page, slots;
	//
	protected ContainerEntity tile;

	public ContainerInvContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player); this.tile = (ContainerEntity)world.getTileEntity(new BlockPos(x, y, z));
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		this.populateSlots();
	}

	protected void populateSlots(){
		this.inventoryItemStacks.clear(); this.inventorySlots.clear(); this.empty_index = -1; slots = 0;
		switch(tile.getInventoryType()){
			case ENERGY:
				break;
			case FLUID:{
				fluid_io = new GenericIInventory(null, 2, 1); slots = 2;
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
		        break;
			}
			case ITEM:{
				temp = new ItemStackHandler(tile.getContainerData(), tile.getContainerData().getInventory());
		        for(int row = 0; row < 6; row++){
		            for(int col = 0; col < 13; col++){
		                int index = (col + row * 12) + (page * 78);
		                if(index >= tile.getContainerData().getType().getCapacity()){ if(empty_index == -1) empty_index = (col + row * 12); break; }
		                addSlotToContainer(new SlotItemHandler(temp, index, 8 + col * 18, 22 + row * 18)); slots++;
		            }
		        }
		        //
		        for(int row = 0; row < 3; row++){
		            for(int col = 0; col < 9; col++){
		                addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 136 + row * 18));
		            }
		        }
		        for(int col = 0; col < 9; col++){
		            addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 192));
		        }
		        break;
			}
			default: return;
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			if(packet.getString("cargo").equals("inventory_page")){
				page = packet.getInteger("page"); this.populateSlots();
			}
		}
		else{
			if(packet.getString("cargo").equals("update_fluid_tank")){
                tile.getContainerData().getFluidTank().readFromNBT(packet.getCompoundTag("state"));
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
                if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 0, slots, false)){ return ItemStack.EMPTY; }
            if(itemstack1.isEmpty()){ slot.putStack(ItemStack.EMPTY); } else{ slot.onSlotChanged(); }
        } return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer player){
        super.onContainerClosed(player);
        if(fluid_io != null){ fluid_io.closeInventory(player); }
        tile.markDirty();
    }
    
    @Override
    public void detectAndSendChanges(){
        if(fluid_io != null && tile.getContainerData().getFluidTank() != null){
            if(fluid_date + 50 <= Time.getDate()){
                fluid_date = Time.getDate(); boolean anychange = false;
                //
                ItemStack stack = fluid_io.getStackInSlot(0);
                if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
                    IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                    if(item.getTankProperties().length > 0 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
                        FluidActionResult result = FluidUtil.tryEmptyContainer(stack, tile.getContainerData().getFluidTank(), 1000, player, true);
                        if(result.success){ anychange = true;
                        	fluid_io.setInventorySlotContents(0, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                            if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, stack));
                        }
                    }
                }
                //
                if(tile.getContainerData().getFluidTank().getFluidAmount() > 0){
                    stack = fluid_io.getStackInSlot(1);
                    if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
                    	FluidActionResult result = FluidUtil.tryFillContainer(stack, tile.getContainerData().getFluidTank(), 1000, player, true);
                        if(result.success){ anychange = true;
                        	fluid_io.setInventorySlotContents(1, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                            if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, 1, stack));
                        }
                    }
                }
                //
                if(!player.world.isRemote && anychange){
                    NBTTagCompound compound = new NBTTagCompound();
                    compound.setString("cargo", "update_fluid_tank");
                    compound.setTag("state", tile.getContainerData().getFluidTank().writeToNBT(new NBTTagCompound()));
                	this.send(Side.CLIENT, compound);
                }
            }
        }
        //
        super.detectAndSendChanges();
    }

}
