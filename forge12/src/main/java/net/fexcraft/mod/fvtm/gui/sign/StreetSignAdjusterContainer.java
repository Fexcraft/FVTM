package net.fexcraft.mod.fvtm.gui.sign;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.getTargetPoint;

public class StreetSignAdjusterContainer extends GenericContainer {
	
	protected GenericGui<StreetSignAdjusterContainer> gui;
	protected StreetSign entity;
	protected int slots;

	public StreetSignAdjusterContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player); entity = (StreetSign)world.getEntityByID(x); if(entity == null) player.closeScreen();
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(entity == null){ Print.chat(player, "Error, Sign Entity is null."); return; } entity.read(packet);
		PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(entity, packet), getTargetPoint(entity));
		player.closeScreen();
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
    }
    
    @Override
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
    }

}
