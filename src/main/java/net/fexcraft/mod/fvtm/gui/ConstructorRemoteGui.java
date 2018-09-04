package net.fexcraft.mod.fvtm.gui;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class ConstructorRemoteGui extends GuiContainer {

    private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructorremotegui.png");
    private static ConstructorControllerEntity tile;
    private static EntityPlayer player;
    private static BlockPos pos;
    private static GenericGuiButton buttonHome;
    private static GenericGuiButton buttonReturn;
    private static GenericGuiButton buttonLeft;
    private static GenericGuiButton buttonRight;
    private static GenericGuiButton buttonUp;
    private static GenericGuiButton buttonDown;
    private static GenericGuiButton buttonSelect;
    private static GenericGuiButton buttonRemove;

    public ConstructorRemoteGui(ConstructorControllerEntity ent, EntityPlayer entityplayer, BlockPos blockpos){
        super(new GenericGuiContainer.DefImpl());
        this.xSize = 158;
        this.ySize = 109;
        player = entityplayer;
        pos = blockpos;
        tile = ent;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        this.mc.getTextureManager().bindTexture(texture);
        int i = this.guiLeft, j = this.guiTop;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        //
        for(int k = 0; k < 8; k++){
            //this.fontRenderer.drawString(Formatter.format((k == tile.selection ? "&6> &e" : "&7> &f") + tile.text[k]), i + 8, j + 8 + (k * 11), MapColor.GRAY.colorValue);
            //Renderer.drawTextOutlined(fontRenderer, tile.text[k], i + 8, j + 8 + (k * 11), MapColor.GRAY.colorValue);
        }
    }

    @Override
    public void initGui(){
        Keyboard.enableRepeatEvents(true);
        super.initGui();
        this.buttonList.clear();
        int i = this.guiLeft;
        int j = this.guiTop;
        //
        this.buttonList.add(buttonHome = new GenericGuiButton(0, 6 + i, 96 + j, 8, 8, ""));
        buttonHome.setTexturePos(0, 6, 96);
        buttonHome.setTexturePos(1, 6, 109);
        buttonHome.setTexture(texture);
        buttonHome.enabled = true;
        //
        this.buttonList.add(buttonReturn = new GenericGuiButton(1, 16 + i, 96 + j, 8, 8, ""));
        buttonReturn.setTexturePos(0, 16, 96);
        buttonReturn.setTexturePos(1, 16, 109);
        buttonReturn.setTexture(texture);
        buttonReturn.enabled = true;
        //
        this.buttonList.add(buttonLeft = new GenericGuiButton(2, 26 + i, 96 + j, 8, 8, ""));
        buttonLeft.setTexturePos(0, 26, 96);
        buttonLeft.setTexturePos(1, 26, 109);
        buttonLeft.setTexture(texture);
        buttonLeft.enabled = true;
        //
        this.buttonList.add(buttonRight = new GenericGuiButton(3, 36 + i, 96 + j, 8, 8, ""));
        buttonRight.setTexturePos(0, 36, 96);
        buttonRight.setTexturePos(1, 36, 109);
        buttonRight.setTexture(texture);
        buttonRight.enabled = true;
        //
        this.buttonList.add(buttonUp = new GenericGuiButton(4, 114 + i, 96 + j, 8, 8, ""));
        buttonUp.setTexturePos(0, 114, 96);
        buttonUp.setTexturePos(1, 114, 109);
        buttonUp.setTexture(texture);
        buttonUp.enabled = true;
        //
        this.buttonList.add(buttonDown = new GenericGuiButton(5, 124 + i, 96 + j, 8, 8, ""));
        buttonDown.setTexturePos(0, 124, 96);
        buttonDown.setTexturePos(1, 124, 109);
        buttonDown.setTexture(texture);
        buttonDown.enabled = true;
        //
        this.buttonList.add(buttonSelect = new GenericGuiButton(6, 134 + i, 96 + j, 8, 8, ""));
        buttonSelect.setTexturePos(0, 134, 96);
        buttonSelect.setTexturePos(1, 134, 109);
        buttonSelect.setTexture(texture);
        buttonSelect.enabled = true;
        //
        this.buttonList.add(buttonRemove = new GenericGuiButton(7, 144 + i, 96 + j, 8, 8, ""));
        buttonRemove.setTexturePos(0, 144, 96);
        buttonRemove.setTexturePos(1, 144, 109);
        buttonRemove.setTexture(texture);
        buttonRemove.enabled = true;
        //
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        super.drawScreen(mouseX, mouseY, partialTicks);
        if(tile == null || pos == null || pos.distanceSq(player.getPosition()) >= 328){
            Print.chat(player, "Either something is NULL or distance is too large.");
            Minecraft.getMinecraft().displayGuiScreen(null);
        }
    }

    @Override
    protected void actionPerformed(GuiButton button){
        if(button.id < 8){
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("target_listener", "fvtm");
            compound.setString("task", "constructor_remote");
            compound.setLong("pos", pos.toLong());
            compound.setInteger("button", button.id);
            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
        }
    }

}
