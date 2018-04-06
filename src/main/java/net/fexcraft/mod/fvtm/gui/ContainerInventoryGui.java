package net.fexcraft.mod.fvtm.gui;

import com.google.common.collect.Lists;

import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerInventoryGui {
	
	//Recycling is good for earth, recycling is good for health, basically this a cut down "Vehicle Inventory".
	
	private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory.png");
	
	public static class Client extends GuiContainer {
		
		private ContainerTileEntity tile;
		private GenericGuiButton arrowUp, arrowDown;
		private static Server server;
		private int scroll;

		public Client(EntityPlayer player, World world, int x, int y, int z){
			super(server = new Server(player, world, x, y, z));
			this.tile = (ContainerTileEntity) world.getTileEntity(new BlockPos(x, y, z));
			this.xSize = 226;
			this.ySize = 195;
		}
		
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	        this.drawDefaultBackground();
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        this.renderHoveredToolTip(mouseX, mouseY);
	    }

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
			int i = this.guiLeft, j = this.guiTop;
			this.mc.getTextureManager().bindTexture(invtex);
			this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 16, this.ySize);
			this.fontRenderer.drawString(tile.getContainerData().getContainer().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
			//
			String curr = "&a" + ((scroll * 60) + 1) + "&c-&a" + ((scroll * 60 + 60) > tile.getContainerData().getContainer().getInventorySize() ? tile.getContainerData().getContainer().getInventorySize() : (scroll * 60 + 60));
			this.fontRenderer.drawString(scroll + "", i + 171, j + 118, MapColor.SNOW.colorValue);
			this.fontRenderer.drawString(Formatter.format(curr), i + 171, j + 146, MapColor.SNOW.colorValue);
			this.fontRenderer.drawString(Formatter.format("&6" + tile.getContainerData().getContainer().getInventorySize() + " max"), i + 171, j + 160, MapColor.SNOW.colorValue);
		}
		
		@Override
		protected void actionPerformed(GuiButton button){
			int oldscroll = scroll;
			if(button.id == 0){
				scroll--;
				if(scroll < 0){
					scroll = 0;
				}
			}
			else{
				if((scroll + 1) * 60 <= tile.getContainerData().getContainer().getInventorySize()){
					scroll++;
				}
			}
			arrowUp.enabled = scroll > 0;
			arrowDown.enabled = (scroll + 1) * 60 < tile.getContainerData().getContainer().getInventorySize();
			if(scroll != oldscroll){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("target_listener", "fvtm");
				nbt.setString("task", "container_gui_scroll");
				nbt.setInteger("scroll", scroll);
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
				server.refresh(scroll);
			}
		}
		
		@Override
		public void initGui(){
			super.initGui();
			this.buttonList.clear();
			int i = this.guiLeft;
			int j = this.guiTop;
			this.buttonList.add(arrowUp = new GenericGuiButton(0, 225 + i, 127 + j, 12, 15, ""));
			arrowUp.setTexturePos(0, 12, 211);
			arrowUp.setTexturePos(1, 12, 196);
			arrowUp.setTexturePos(2, 12, 226);
			arrowUp.setTexturePos(3, 12, 241);
			arrowUp.setTexture(invtex);
			arrowUp.enabled = scroll > 0;
			this.buttonList.add(arrowDown = new GenericGuiButton(1, 225 + i, 144 + j, 12, 15, ""));
			arrowDown.setTexturePos(0, 0, 211);
			arrowDown.setTexturePos(1, 0, 196);
			arrowDown.setTexturePos(2, 0, 226);
			arrowDown.setTexturePos(3, 0, 241);
			arrowDown.setTexture(invtex);
			arrowDown.enabled = (scroll + 1) * 60 < tile.getContainerData().getContainer().getInventorySize();
		}
		
		@Override
		public void onGuiClosed(){
			//TODO
		}
		
	}
	
	public static class Server extends Container {
		
		private EntityPlayer player;
		private ContainerTileEntity tile;
		public static int scroll, slots = 60;
		private TempContainerTileInventory container;
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
			this.player = player;
			tile = (ContainerTileEntity) world.getTileEntity(new BlockPos(x, y, z));
			container = new TempContainerTileInventory(tile);
			refresh(scroll = 0);
		}
		
		public void refresh(int i){
			scroll = i;
			this.inventorySlots = Lists.<Slot>newArrayList();
			this.inventoryItemStacks = NonNullList.<ItemStack>create();
			this.onContainerClosed(player);
			for(int row = 0; row < 5; row++){
				for(int col = 0; col < 12; col++){
					int index = (col + row * 12) + (scroll * 60);
					if(index >= tile.getContainerData().getContainer().getInventorySize()){
						break;
					}
					addSlotToContainer(new TempInventorySlot(container, index, 6 + col * 18, 20 + row * 18, null, tile.getContainerData()));
				}
			}
			//
			for(int row = 0; row < 3; row++){
				for(int col = 0; col < 9; col++){
					addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 117 + row * 18));
				}
			}
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 173));
			}
		}
		
		@Override
		public boolean canInteractWith(EntityPlayer player){
			return player != null && !player.isDead;
		}
		
		@Override
		public void onContainerClosed(EntityPlayer player){
			super.onContainerClosed(player);
		}
		
		@Override
		public void detectAndSendChanges(){
			super.detectAndSendChanges();
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