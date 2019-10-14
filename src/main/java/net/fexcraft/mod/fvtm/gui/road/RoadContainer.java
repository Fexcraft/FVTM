package net.fexcraft.mod.fvtm.gui.road;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class RoadContainer extends GenericContainer {
	
	protected GenericGui<RoadContainer> gui;
	protected RoadInventory roadinv;
	protected ItemStack stack;
	protected int slots;

	public RoadContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player); roadinv = new RoadInventory(slots = 8); stack = player.getHeldItemOffhand();
        for(int i = 0; i < 3; i++){ addSlotToContainer(new Slot(roadinv, 0 + i, 26 + (i * 18), 48)); }
        for(int i = 0; i < 3; i++){ addSlotToContainer(new Slot(roadinv, 3 + i, 26 + (i * 18),  8)); }
    	addSlotToContainer(new Slot(roadinv, 6, 8 , 28)); addSlotToContainer(new Slot(roadinv, 7, 80, 28));
		//
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 9; col++){
                addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 72 + row * 18));
            }
        }
        for(int col = 0; col < 9; col++){
            addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 128));
        }
        //
    	if(stack.getTagCompound().hasKey("BottomFill")){
            roadinv.setInventorySlotContents(0, new ItemStack(stack.getTagCompound().getCompoundTag("BottomFill")));
    	}
    	if(stack.getTagCompound().hasKey("TopFill")){
            roadinv.setInventorySlotContents(3, new ItemStack(stack.getTagCompound().getCompoundTag("TopFill")));
    	}
    	if(stack.getTagCompound().hasKey("SideRFill")){
    		roadinv.setInventorySlotContents(7, new ItemStack(stack.getTagCompound().getCompoundTag("SideRFill")));
    	}
    	if(stack.getTagCompound().hasKey("SideLFill")){
    		roadinv.setInventorySlotContents(6, new ItemStack(stack.getTagCompound().getCompoundTag("SideLFill")));
    	}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
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
        if(roadinv != null){
        	//roadinv.closeInventory(player);
        	if(!roadinv.getStackInSlot(0).isEmpty()){
        		stack.getTagCompound().setTag("BottomFill", roadinv.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        	} else stack.getTagCompound().removeTag("BottomFill");
        	if(!roadinv.getStackInSlot(3).isEmpty()){
        		stack.getTagCompound().setTag("TopFill", roadinv.getStackInSlot(3).writeToNBT(new NBTTagCompound()));
        	} else stack.getTagCompound().removeTag("TopFill");
        	if(!roadinv.getStackInSlot(6).isEmpty()){
        		stack.getTagCompound().setTag("SideLFill", roadinv.getStackInSlot(6).writeToNBT(new NBTTagCompound()));
        	} else stack.getTagCompound().removeTag("SideLFill");
        	if(!roadinv.getStackInSlot(7).isEmpty()){
        		stack.getTagCompound().setTag("SideRFill", roadinv.getStackInSlot(7).writeToNBT(new NBTTagCompound()));
        	} else stack.getTagCompound().removeTag("SideRFill");
        	roadinv.clear();
        }
    }
    
    @Override
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
    }

}
