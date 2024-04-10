package net.fexcraft.mod.fvtm.gui.road;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.gui.GuiCommandSender;
import net.fexcraft.mod.fvtm.ui.RoadInventory;
import net.fexcraft.mod.fvtm.ui.UIKey;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCon;
import net.fexcraft.mod.fvtm.util.Perms;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerCustomFillContainer extends GenericContainer {
	
	protected GenericGui<RoadPlacerCustomFillContainer> gui;
	protected int[] size = new int[]{ 1, 0, 0, 0, 0, 0 };
	protected GuiCommandSender sender;
	protected RoadInventory roadinv;
	protected ItemStack stack;
	protected int slots, off, idx;
	
	public RoadPlacerCustomFillContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		if(!player.world.isRemote && !Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		sender = new GuiCommandSender(player);
		stack = player.getHeldItemMainhand();
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("RoadLayers")){
			stack.getTagCompound().setIntArray("RoadLayers", size);
		}
		else size = stack.getTagCompound().getIntArray("RoadLayers");
		if(size.length < 6) size = new int[]{ size[0], size[1], size[2], size[3], size[4], 0 };
		roadinv = new RoadInventory();
		off = (size[0] * 9);
		idx = x;
        for(int i = 0; i < slots; i++){
        	addSlotToContainer(new RoadInventory.RoadSlot(roadinv, i, 88 - off + 1 + i * 18, 8, true, x > 0));
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
        //
		String tagname = "Custom" + RoadToolCon.fills[x];
        if(stack.getTagCompound().hasKey(tagname)){
        	NBTTagCompound compound = stack.getTagCompound().getCompoundTag(tagname);
        	int size = compound.getInteger("Size");
        	for(int i = 0; i < size; i++){
        		if(!compound.hasKey("Block" + i)) continue;
        		if(i >= roadinv.getSizeInventory()) break;
        		Block block = Block.REGISTRY.getObject(new ResourceLocation(compound.getString("Block" + i)));
        		byte meta = compound.hasKey("Meta" + i) ? compound.getByte("Meta" + i) : 0;
        		roadinv.setInventorySlotContents(i, new ItemStack(block, 1, meta));
        	}
        }
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		switch(packet.getString("cargo")){
			case "save":{
				try{
					boolean empty = true;
					for(ItemStack stack : roadinv.getStacks()){
						if(!stack.isEmpty()){
							empty = false;
							break;
						}
					}
					String tagname = "Custom" + RoadToolCon.fills[idx];
					if(empty){
						if(stack.getTagCompound().hasKey(tagname)) stack.getTagCompound().removeTag(tagname);
					}
					else{
						NBTTagCompound com = new NBTTagCompound();
						com.setInteger("Size", size[0]);
						for(int i = 0; i < roadinv.getSizeInventory(); i++){
							ItemStack item = roadinv.getStackInSlot(i);
							if(!item.isEmpty()){
								com.setString("Block" + i, ((ItemBlock)item.getItem()).getBlock().getRegistryName().toString());
								if(idx > 0) com.setByte("Meta" + i, (byte)item.getMetadata());
							}
						}
						stack.getTagCompound().setTag(tagname, com);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				player.closeScreen();
				player.openGui(FVTM.getInstance(), UIKey.ID12_ROAD_TOOL, player.world, 0, 0, 0);
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
