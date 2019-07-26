package net.fexcraft.mod.fvtm.gui.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleContainer extends GenericContainer {
	
	protected GenericGui<VehicleContainer> gui;
	@Nullable protected NBTTagCompound initpacket;
	//
	private boolean invmode;
	protected InventoryFunction function;
	protected VehicleEntity veh;
	protected PartData invpart;
	protected String inv_id;
	protected TIFI temp;
	protected GenericIInventory fluid_io;
	protected int empty_index = -1, page, slots;
	protected long fluid_date;
	protected EntityPlayerMP mpp;

	public VehicleContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
	}
	
	public VehicleContainer(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(player); initpacket = compound; if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		if(!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false){ player.closeScreen(); return; }
		//
		if(compound.hasKey("inventory")){ invmode = true;
			SeatEntity ent = (SeatEntity)player.getRidingEntity(); veh = ent.getVehicle();
			invpart = veh.getVehicleData().getPart(inv_id = compound.getString("inventory"));
			function = invpart.getFunction("fvtm:inventory");
			this.populateSlots();
		}
	}

	protected void populateSlots(){
		this.inventoryItemStacks.clear(); this.inventorySlots.clear(); this.empty_index = -1; slots = 0;
		switch(function.getInventoryType()){
			case CONTAINER:
				break;
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
		        Print.debug("slots " + this.inventorySlots.size());
		        break;
			}
			case ITEM:{
				temp = new TIFI(invpart, function);
		        for(int row = 0; row < 6; row++){
		            for(int col = 0; col < 13; col++){
		                int index = (col + row * 12) + (page * 78);
		                if(index >= temp.getSizeInventory()){ if(empty_index == -1) empty_index = (col + row * 12); break; }
		                addSlotToContainer(new TIS(temp, index, 8 + col * 18, 22 + row * 18, temp.getData(), null)); slots++;
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
		if(invmode){
			if(side.isServer()){
				if(packet.getString("cargo").equals("inventory_page")){
					page = packet.getInteger("page"); this.populateSlots();
				}
			}
			else{
				if(packet.getString("cargo").equals("update_fluid_tank")){
                    function.getFluidTank().readFromNBT(packet.getCompoundTag("state"));
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
    }
    
    @Override
    public void detectAndSendChanges(){
        if(fluid_io != null && function != null){
            if(fluid_date + 50 <= Time.getDate()){
                fluid_date = Time.getDate(); boolean anychange = false;
                //
                ItemStack stack = fluid_io.getStackInSlot(0);
                if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
                    IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                    if(item.getTankProperties().length > 0 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
                        FluidActionResult result = FluidUtil.tryEmptyContainer(stack, function.getFluidTank(), 1000, player, true);
                        if(result.success){ anychange = true;
                        	fluid_io.setInventorySlotContents(0, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                            if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, stack));
                        }
                    }
                }
                //
                if(function.getFluidTank().getFluidAmount() > 0){
                    stack = fluid_io.getStackInSlot(1);
                    if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
                    	FluidActionResult result = FluidUtil.tryFillContainer(stack, function.getFluidTank(), 1000, player, true);
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
                    compound.setTag("state", function.getFluidTank().writeToNBT(new NBTTagCompound()));
                	this.send(Side.CLIENT, compound);
                }
            }
        }
        //
        super.detectAndSendChanges();
        /*for(int i = 0; i < this.inventorySlots.size(); ++i){
            ItemStack itemstack = ((Slot)this.inventorySlots.get(i)).getStack();
            ItemStack itemstack1 = this.inventoryItemStacks.get(i);
            if(!ItemStack.areItemStacksEqual(itemstack1, itemstack)){
                boolean clientStackChanged = !ItemStack.areItemStacksEqualUsingNBTShareTag(itemstack1, itemstack);
                itemstack1 = itemstack.isEmpty() ? ItemStack.EMPTY : itemstack.copy();
                this.inventoryItemStacks.set(i, itemstack1);
                //
                if(clientStackChanged){ Print.debug(i, itemstack);
                    for(int j = 0; j < this.listeners.size(); ++j){
                        ((IContainerListener)this.listeners.get(j)).sendSlotContents(this, i, itemstack1);
                    }
                }
            }
        }*/
    }

}
