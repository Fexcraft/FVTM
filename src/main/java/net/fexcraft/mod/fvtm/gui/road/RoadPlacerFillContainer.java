package net.fexcraft.mod.fvtm.gui.road;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GuiCommandSender;
import net.fexcraft.mod.fvtm.ui.RoadInventory;
import net.fexcraft.mod.fvtm.util.Perms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerFillContainer extends GenericContainer {
	
	public static final String[] fills = new String[]{ "RoadFill", "BottomFill", "SideLeftFill", "SideRightFill", "TopFill", "LinesFill" };
	protected GenericGui<RoadPlacerFillContainer> gui;
	protected GuiCommandSender sender;
	protected RoadInventory roadinv;
	protected ItemStack stack;
	protected boolean cr, ct, cl;
	protected int slots;
	
	public RoadPlacerFillContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		if(!player.world.isRemote && !Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		sender = new GuiCommandSender(player);
		stack = player.getHeldItemMainhand();
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		cr = stack.getTagCompound().hasKey("CustomRoadFill");
		ct = stack.getTagCompound().hasKey("CustomTopFill");
		cl = stack.getTagCompound().hasKey("CustomLinesFill");
		roadinv = new RoadInventory();
        for(int i = 0; i < slots; i++){
        	addSlotToContainer(new RoadInventory.RoadSlot(roadinv, i, 8, 8 + i * 20, false, false));
        }
		//
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 9; col++){
                addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 132 + row * 18));
            }
        }
        for(int col = 0; col < 9; col++){
            addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 188));
        }
        //
        for(int i = 0; i < fills.length; i++){
        	if(stack.getTagCompound().hasKey(fills[i])){
                roadinv.setInventorySlotContents(i, new ItemStack(stack.getTagCompound().getCompoundTag(fills[i])));
        	}
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
				stack.getTagCompound().setIntArray("RoadLayers", packet.getIntArray("sizes"));
				if(packet.getBoolean("close")) player.closeScreen();
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
        for(int i = 0; i < fills.length; i++){
        	if(!roadinv.getStackInSlot(i).isEmpty()){
        		stack.getTagCompound().setTag(fills[i], roadinv.getStackInSlot(i).writeToNBT(new NBTTagCompound()));
        	}
        	else stack.getTagCompound().removeTag(fills[i]);
        }
    	roadinv.clear();
    }
    
    @Override
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
    }
    
}
