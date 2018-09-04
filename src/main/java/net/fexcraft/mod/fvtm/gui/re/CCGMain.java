package net.fexcraft.mod.fvtm.gui.re;

import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class CCGMain extends GenericGui {

	public CCGMain(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_main.png"), null);
		this.xSize = 128; this.ySize = 112;
	}

	@Override
	protected void init(){
		this.texts.put("row_0", new BasicText(13,  4, 112, null, "Constructor Status"));
		this.texts.put("row_1", new BasicText(13, 16, 112, null, "Vehicle Data"));
		this.texts.put("row_2", new BasicText(13, 28, 112, null, "Part Data"));
		//
		this.texts.put("row_3", new BasicText(13, 44, 112, null, "Part Manager"));
		this.texts.put("row_4", new BasicText(13, 56, 112, null, "Part Adjuster"));
		this.texts.put("row_5", new BasicText(13, 68, 112, null, "Part Installer"));
		//
		this.texts.put("row_6", new BasicText(13, 84, 112, null, "Texture Manager"));
		this.texts.put("row_7", new BasicText(13, 96, 112, null, "Spraying Tool"));
		//
		texts.forEach((key, text) -> {
			buttons.put(key, new BasicButton(key, guiLeft + 11, guiTop + text.y - 1, 11, text.y - 1, 114, 10, true));
		});
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
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "row_0":{
				
				break;
			}
			case "row_1":{
				
				break;
			}
			case "row_2":{
				
				break;
			}
			case "row_3":{
				
				break;
			}
			case "row_4":{
				
				break;
			}
			case "row_5":{
				
				break;
			}
			case "row_6":{
				
				break;
			}
			case "row_7":{
				
				break;
			}
		}
	}
	
}