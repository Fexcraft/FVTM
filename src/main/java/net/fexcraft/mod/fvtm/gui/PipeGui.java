package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.blocks.PipeTileEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PipeGui {

    private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/pipe_connections.png");

    public static class Client extends GuiContainer {

        private GuiButton[][] buttons;

        private PipeTileEntity tile;
        @SuppressWarnings("unused")
        private static Server server;

        public Client(EntityPlayer player, World world, int x, int y, int z){
            super(server = new Server(player, world, x, y, z));
            this.tile = (PipeTileEntity) world.getTileEntity(new BlockPos(x, y, z));
            this.xSize = 105;
            this.ySize = 101;
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
            this.mc.getTextureManager().bindTexture(texture);
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
            //
            for(int k = 0; k < buttons.length; k++){
                int m = i + 63, n = j + 24 + (k * 12);
                int idx = EnumFacing.getFront(PipeTileEntity.order[k]).getIndex();
                this.drawTexturedModalRect(m, n, 223, tile.conn[idx] ? tile.mode[idx] ? 220 : 244 : 208, 11, 12);
                this.drawTexturedModalRect(m + 13, n, 234, tile.conn[idx] ? !tile.mode[idx] ? 220 : 244 : 208, 11, 12);
                this.drawTexturedModalRect(m + 26, n, 245, tile.conn[idx] ? tile.getFlowDirection() != null && tile.getFlowDirection().getIndex() == idx ? 220 : 244 : 208, 11, 12);
            }
            //
            this.fontRenderer.drawString(tile.getTank().getFluidAmount() + " mB", i + 7, j + 7, MapColor.SNOW.colorValue);
            for(int l = 0; l < PipeTileEntity.order.length; l++){
                EnumFacing facing = EnumFacing.getFront(PipeTileEntity.order[l]);
                this.fontRenderer.drawString(facing.getName(), i + 7, j + 26 + (l * 12), MapColor.SNOW.colorValue);
            }
        }

        @Override
        public void initGui(){
            super.initGui();
            this.buttonList.clear();
            int id = 0;
            buttons = new GuiButton[6][3];
            int i = this.guiLeft, j = this.guiTop;
            for(int k = 0; k < buttons.length; k++){
                buttons[k] = new GuiButton[3];
                this.buttonList.add(buttons[k][0] = new StateButton(id++, i + 63, j + 24 + (k * 12)));
                this.buttonList.add(buttons[k][1] = new StateButton(id++, i + 76, j + 24 + (k * 12)));
                this.buttonList.add(buttons[k][2] = new StateButton(id++, i + 89, j + 24 + (k * 12)));
            }
        }

        @Override
        public void actionPerformed(GuiButton button){
            Print.debug(button.id);
            int f = button.id / 3;
            EnumFacing facing = EnumFacing.getFront(PipeTileEntity.order[f]);
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("target_listener", "fvtm");
            compound.setString("task", "set_pipe_state");
            compound.setLong("pos", tile.getPos().toLong());
            compound.setInteger("facing", facing.getIndex());
            compound.setString("iod", button.id % 3 == 0 ? "red" : button.id % 3 == 1 ? "blue" : "green");
            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
            Print.debug(compound.toString());
        }

    }

    private static class StateButton extends GuiButton {

        public StateButton(int buttonId, int x, int y){
            super(buttonId, x, y, 11, 12, "");
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
            if(!visible){
                return;
            }
            //
        }

    }

    public static class Server extends Container {

        //private EntityPlayer player;
        private PipeTileEntity tile;

        public Server(EntityPlayer player, World world, int x, int y, int z){
            //this.player = player;
            tile = (PipeTileEntity) world.getTileEntity(new BlockPos(x, y, z));
        }

        @Override
        public boolean canInteractWith(EntityPlayer player){
            return player != null && !player.isDead;
        }

        @Override
        public void onContainerClosed(EntityPlayer player){
            super.onContainerClosed(player);
        }

        private long date = 0;

        @Override
        public void detectAndSendChanges(){
            super.detectAndSendChanges();
            if(tile.getWorld().isRemote){
                return;
            }
            if(date + 50 <= Time.getDate()){
                date = Time.getDate();
                tile.sendUpdate();
            }
        }

    }

}
