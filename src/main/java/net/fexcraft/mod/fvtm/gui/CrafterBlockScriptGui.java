package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrafterBlockScriptGui {

	private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/universal_block_io.png");

    public static class Client extends GuiContainer {

        private UniversalTileEntity tile;
        private static Server server;

        public Client(EntityPlayer player, World world, int x, int y, int z){
            super(server = new Server(player, world, x, y, z));
            this.tile = (UniversalTileEntity)world.getTileEntity(new BlockPos(x, y, z));
            this.xSize = 226;
            this.ySize = 159;
        }

        @Override
        public void drawScreen(int mouseX, int mouseY, float partialTicks){
            this.drawDefaultBackground();
            super.drawScreen(mouseX, mouseY, partialTicks);
            this.renderHoveredToolTip(mouseX, mouseY);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
            int i = this.guiLeft, j = this.guiTop;
            this.mc.getTextureManager().bindTexture(invtex);
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 16, this.ySize);
            this.fontRenderer.drawString(tile.getBlockData().getBlock().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
        }

        @Override
        protected void actionPerformed(GuiButton button){
            //
        }

        @Override
        public void initGui(){
            super.initGui();
            this.buttonList.clear();
            int i = this.guiLeft;
            int j = this.guiTop;
            //TODO
        }

        @Override
        public void onGuiClosed(){
            //TODO
        }

    }

    public static class Server extends Container {

        private EntityPlayer player;
        private UniversalTileEntity tile;
        private int slots = 9;

        public Server(EntityPlayer player, World world, int x, int y, int z){
            this.player = player;
            tile = (UniversalTileEntity)world.getTileEntity(new BlockPos(x, y, z));
            //refresh(scroll = 0);
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
