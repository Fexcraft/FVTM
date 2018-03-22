package net.fexcraft.mod.fme.gui;

import net.fexcraft.mod.fme.blocks.EditorTileEntity;
import net.fexcraft.mod.fvtm.gui.GenericPlaceholderContainer;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiEditor extends GuiContainer {
	
	private EditorTileEntity tile;
	private EntityPlayer player;
	//
	
	public GuiEditor(int ID, EntityPlayer player, World world, int x, int y, int z){
		super(new GenericPlaceholderContainer());
		this.player = player;
		this.tile = ID == 0 ? (EditorTileEntity)world.getTileEntity(new BlockPos(x, y, z)) : tile;
	}
	
	@Override
	public void initGui(){
		super.initGui();
		if(tile == null){
			Print.chat(player, "No Editor Selected, closing!");
			player.closeScreen();
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		// TODO Auto-generated method stub
		
	}
	
}