package net.fexcraft.mod.fvtm.gui.road;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.ROADTOOLFILL;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.gui.GuiCommandSender;
import net.fexcraft.mod.fvtm.util.Perms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerCustomFillContainer extends GenericContainer {
	
	protected GenericGui<RoadPlacerCustomFillContainer> gui;
	protected int[] size = new int[]{ 1, 0, 0, 0, 0 };
	protected GuiCommandSender sender;
	protected RoadInventory roadinv;
	protected ItemStack stack;
	protected int slots, off;
	
	public RoadPlacerCustomFillContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		sender = new GuiCommandSender(player);
		stack = player.getHeldItemMainhand();
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("RoadLayers")){
			stack.getTagCompound().setIntArray("RoadLayers", size);
		}
		else size = stack.getTagCompound().getIntArray("RoadLayers");
		roadinv = new RoadInventory(slots = size[0]);
		off = (size[0] * 9);
        for(int i = 0; i < slots; i++){
        	addSlotToContainer(new RoadInventory.RoadSlot(roadinv, i, 88 - off + 1 + i * 18, 8, true));
        }
		//
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 9; col++){
                addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 44 + row * 18));
            }
        }
        for(int col = 0; col < 9; col++){
            addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 100));
        }
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//RoadToolItem item = (RoadToolItem)stack.getItem();
		switch(packet.getString("cargo")){
			case "save":{
				//TODO
				player.closeScreen();
				player.openGui(FVTM.getInstance(), ROADTOOLFILL, player.world, 0, 0, 0);
				break;
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
                if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)) return ItemStack.EMPTY;
            }
            else if(!this.mergeItemStack(itemstack1, 0, slots, false)) return ItemStack.EMPTY;
            else{
                if(itemstack1.isEmpty()) slot.putStack(ItemStack.EMPTY);
                else slot.onSlotChanged();
            }
        }
        return itemstack;
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
