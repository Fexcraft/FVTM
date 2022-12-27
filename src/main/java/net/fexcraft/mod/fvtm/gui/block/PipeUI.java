package net.fexcraft.mod.fvtm.gui.block;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.util.I19U;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class PipeUI extends GenericGui<PipeContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/pipe_main.png");

	public PipeUI(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new PipeContainer(player, world, x, y, z), player);
		this.xSize = 132;
		this.ySize = 48;
	}

	@Override
	protected void init(){
		texts.put("title", new BasicText(guiLeft + 6, guiTop + 6, 120, MapColor.SNOW.colorValue, I19U.trsc("gui.fvtm.pipe.title", container.id)).autoscale());
		for(int i = 0; i < 4; i++){
			buttons.put("up" + i, new BasicButton("up" + i, guiLeft + 25 + (i * 30), guiTop + 19, 25, 19, 8, 8, true){
				@Override
				public boolean onclick(int mx, int my, int mb){
					//
					return true;
				}
			});
			buttons.put("dw" + i, new BasicButton("dw" + i, guiLeft + 25 + (i * 30), guiTop + 27, 25, 27, 8, 8, true){
				@Override
				public boolean onclick(int mx, int my, int mb){
					//
					return true;
				}
			});
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

}
