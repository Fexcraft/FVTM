package net.fexcraft.mod.fvtm.gui;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity.Client;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ConstructorMainGUI extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000.png");
	private static ConstructorControllerEntity.Client tile;
	private static EntityPlayer player;
	private static BlockPos pos;
	private static int id;

	public ConstructorMainGUI(int iD, EntityPlayer ply, World world, int x, int y, int z){
		super(new GenericPlaceholderContainer());
		this.xSize = 256;
		this.ySize = 192;
		player = ply;
		pos = new BlockPos(x, y, z);
		tile = (Client)world.getTileEntity(pos);
		id = iD;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		this.mc.getTextureManager().bindTexture(texture);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		//
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		int i = this.guiLeft;
		int j = this.guiTop;
		//
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);
		//
    }
	
	@Override
	protected void actionPerformed(GuiButton button){
		//
	}
	
}