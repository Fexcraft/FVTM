package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class GenericAdjustableInventory {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/generic_adjustable_inventory.png");
	
	public static class Gui extends GuiContainer {
		
		private static Container container;

		public Gui(World world, EntityPlayer player, int x, int y, int z){
			super(container = new Container(world, player, x, y, z));
			this.xSize = 226;
			this.ySize = 256;
			container.arr = new String[]{ "Waiting for data from server... " };
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
            this.mc.getTextureManager().bindTexture(texture);
            this.ySize = getProbableHeight();
            int i = this.guiLeft; int j = this.guiTop = (this.height - this.ySize) / 2;;
            //
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		}
		
		private int getProbableHeight(){
			return 128;//TODO
		}

		@Override
		public void onGuiClosed(){
			container.arr = null;
			container.stacks = null;
			container = null;
		}
		
	}
	
	public static class Container extends net.minecraft.inventory.Container {

		private NonNullList<ItemStack> stacks;
		private String[] arr;
		private EntityPlayer player;
		private int slots = 0, scroll = 0;
		private BlockPos pos;
		private World world;

		public Container(World world, EntityPlayer player, int x, int y, int z){
			this.world = world; this.player = player; pos = new BlockPos(x, y, z);
		}

		@Override
		public boolean canInteractWith(EntityPlayer player){
			return player != null && !player.isDead;
		}
		
		public void scroll(int i){
			this.scroll += i;
			//TODO calc
		}

		public void setup(EntityPlayer player, String[] str){
			if(str == null){
				Print.chat(player, "No data array for GUI received.");
			}
			switch(str[0]){
				case "entity":{
					
					break;
				}
				case "block":{
					
					break;
				}
				case "container":{
					
					break;
				}
				default:{
					Print.chat(player, "Invalid Inventory type for GUI supplied.");
					return;
				}
			}
			if(!world.isRemote){
	    		NBTTagCompound compound = new NBTTagCompound();
	    		compound.setString("target_listener", "fvtm");
	    		compound.setString("task", "generic_adjustable_inventory_data");
	    		String data = str[0];
	    		for(int i = 1; i < str.length; i++){
	    			data += "|" + str[i];
	    		}
	    		compound.setString("data", data);
	            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
			}
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
                else if(!this.mergeItemStack(itemstack1, 0, slots, false)){
                    return ItemStack.EMPTY;
                }
                if(itemstack1.isEmpty()){
                    slot.putStack(ItemStack.EMPTY);
                }
                else{
                    slot.onSlotChanged();
                }
            }
            return itemstack;
        }
		
	}
	
}