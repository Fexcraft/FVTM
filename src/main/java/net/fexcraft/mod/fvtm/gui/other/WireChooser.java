package net.fexcraft.mod.fvtm.gui.other;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class WireChooser extends GenericGui<WireContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/wires.png");
	private static int scroll;

	public WireChooser(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new WireContainer(player, world, x, y, z), player);
		this.container.gui = this;
		this.defbackground = true;
		this.deftexrect = true;
		this.xSize = 200;
		this.ySize = 138;
	}

	@Override
	protected void init(){
		buttons.put("prev", new BasicButton("prev", guiLeft + 177, guiTop + 6, 177, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 186, guiTop + 6, 186, 6, 8, 8, true));
		texts.put("title", new BasicText(guiLeft + 7, guiTop + 6, 162, MapColor.SNOW.colorValue, "Wire Management"));
		for(int i = 0; i < 8; i++){
			buttons.put("idx" + i, new BasicButton("idx" + i, guiLeft + 181, guiTop + 17 + (i * 14), 216, 244, 12, 12, true));
			texts.put("idx" + i, new BasicText(guiLeft + 9, guiTop + 19 + (i * 14), 168, MapColor.SNOW.colorValue, "..."));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		//
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll += am > 0 ? -1 : 1;
		if(scroll < 0) scroll = 0;
		this.updateFields();
	}

	private void updateFields(){
		//
	}
	
}

