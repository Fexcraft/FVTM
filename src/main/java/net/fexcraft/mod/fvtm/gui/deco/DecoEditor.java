package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class DecoEditor extends GenericGui<DecoEditorContainer> {
	
	private static final ResourceLocation texl = new ResourceLocation("fvtm:textures/gui/deco_editor_left.png");
	private static final ResourceLocation texr = new ResourceLocation("fvtm:textures/gui/deco_editor_right.png");

	public DecoEditor(EntityPlayer player, World world, int entid){
		super(null, new DecoEditorContainer(player, world, entid), player);
		this.xSize = this.ySize = 256;
		this.deftexrect = false;
		this.defbackground = false;
	}
	
	@Override
	protected void init(){
		
	}
	
	@Override
	public void drawbackground(float ticks, int mx, int my){
		TexUtil.bindTexture(texl);
		drawTexturedModalRect(0, 0, 0, 0, 144, 198);
		drawTexturedModalRect(144, 2, 144, 2, 15, 40);
		TexUtil.bindTexture(texr);
		drawTexturedModalRect(width - 144, 0, 112, 0, 144, 188);
	}

}
