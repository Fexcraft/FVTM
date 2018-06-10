package net.fexcraft.mod.fvtm.gui;

import com.google.common.collect.Lists;

import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UniversalBlockInventoryGui {
	
	private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory.png");
	public static EnumFacing lastside; //Client Only - Temporary use.

    public static class Client extends GuiContainer {

        private UniversalTileEntity tile;
        private GenericGuiButton arrowUp, arrowDown;
        private static Server server;
        private int scroll, size;
        private String sel;

        public Client(EntityPlayer player, World world, int x, int y, int z){
            super(server = new Server(player, world, x, y, z));
            this.tile = (UniversalTileEntity)world.getTileEntity(new BlockPos(x, y, z));
            this.xSize = 226;
            this.ySize = 195;
            sel = tile.getBlockData().getBlock().getSubBlocks().get(tile.getRelPos()).getGuiType(tile.getRelFacing(lastside)).split(":")[1];
            size = tile.getBlockData().getInventories().get(sel).getSlots();
            Print.debug(size, sel);
            server.refresh(0, sel);
            //
    		NBTTagCompound compound = new NBTTagCompound();
    		compound.setString("target_listener", "fvtm");
    		compound.setString("task", "block_inventory_handler_set");
    		compound.setString("string", sel); sel = null;
            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
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
            //
            String curr = "&a" + ((scroll * 60) + 1) + "&c-&a" + ((scroll * 60 + 60) > size ? size : (scroll * 60 + 60));
            this.fontRenderer.drawString(scroll + "", i + 171, j + 118, MapColor.SNOW.colorValue);
            this.fontRenderer.drawString(Formatter.format(curr), i + 171, j + 146, MapColor.SNOW.colorValue);
            this.fontRenderer.drawString(Formatter.format("&6" + size + " max"), i + 171, j + 160, MapColor.SNOW.colorValue);
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
                if((scroll + 1) * 60 <= size){
                    scroll++;
                }
            }
            arrowUp.enabled = scroll > 0;
            arrowDown.enabled = (scroll + 1) * 60 < size;
            if(scroll != oldscroll){
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString("target_listener", "fvtm");
                nbt.setString("task", "block_inventory_handler_scroll");
                nbt.setInteger("scroll", scroll);
                PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
                server.refresh(scroll, sel);
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
            arrowDown.enabled = (scroll + 1) * 60 < size;
        }

        @Override
        public void onGuiClosed(){
            //TODO
        }

    }

    public static class Server extends Container {

        private EntityPlayer player;
        private UniversalTileEntity tile;
        public static int scroll, slots = 60;
        private TempUTInventory container;
        private String sel;

        public Server(EntityPlayer player, World world, int x, int y, int z){
            this.player = player;
            tile = (UniversalTileEntity)world.getTileEntity(new BlockPos(x, y, z));
            //refresh(scroll = 0);
        }

        public void refresh(Integer i, String s){
        	if(s == null && this.sel == null){ return; }
            scroll = i == null ? scroll : i; sel = s == null ? sel : s;
            container = new TempUTInventory(tile.getBlockData().getItemStacks().get(sel), sel);
            this.inventorySlots = Lists.<Slot>newArrayList();
            this.inventoryItemStacks = NonNullList.<ItemStack>create();
            this.onContainerClosed(player);
            for(int row = 0; row < 5; row++){
                for(int col = 0; col < 12; col++){
                    int index = (col + row * 12) + (scroll * 60);
                    if(index >= tile.getBlockData().getInventories().get(sel).getSlots()){
                        break;
                    }
                    addSlotToContainer(new Slot(container, index, 6 + col * 18, 20 + row * 18){
                        @Override
                        public boolean isItemValid(ItemStack stack){
                        	if(sel.endsWith("_out")){ return false; }
                            if(stack.getItem() instanceof VehicleItem){ return false; }
                            if(stack.getItem() instanceof ContainerItem){ return false; }
                            if(stack.getItem() instanceof PartItem){
                                PartData data = ((PartItem) stack.getItem()).getPart(stack);
                                if(data.getAttributeData(InventoryAttributeData.class) != null && !data.getAttributeData(InventoryAttributeData.class).isEmpty()){
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
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
        	if(container == null){ return; }
            super.onContainerClosed(player);
        }

        @Override
        public void detectAndSendChanges(){
        	if(container == null){ return; }
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
