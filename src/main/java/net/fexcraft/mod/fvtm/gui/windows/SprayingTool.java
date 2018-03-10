package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class SprayingTool implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_rgb_painter.png");
	private static GenericGuiButton close;
	private static String[] groups = new String[]{"primary", "secondary"};//trimary, etc.
	private static byte brush = 1, group = 0;
	private static ARB[] buttons = new ARB[10];

	@Override
	public String getId(){
		return "rgb_painter";
	}

	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
		//
		RGB rgb = gui.tile.vehicledata == null ? RGB.WHITE : (group == 0 ? gui.tile.vehicledata.getPrimaryColor() : gui.tile.vehicledata.getSecondaryColor());
		rgb.glColorApply();
		gui.drawTexturedModalRect(i + 172, j + 15, 172, 15, 78, 30);
		RGB.glColorReset();
		//
		drawRGB(15, rgb.red);
		drawRGB(27, rgb.green);
		drawRGB(39, rgb.blue);
		//
		for(int k = 0; k < 16; k++){
			for(int l = 0; l < 6; l++){
				//TODO draw "colour map"
			}
		}
		//
		mc.fontRenderer.drawString("ColorGroup: " + groups[group], i + 6, j + 150, MapColor.GRAY.colorValue, false);
		mc.fontRenderer.drawString("Brush: " + brush, i + 182, j + 150, MapColor.GRAY.colorValue, false);
	}

	private void drawRGB(int i, byte blue){
		//TODO
	}

	@Override
	public boolean closesOther(){
		return true;
	}

	@Override
	public void close(ConstructorMainGUI gui, String rqFrom){
		gui.getButtonList().remove(close);
		for(ARB button : buttons){
			gui.getButtonList().remove(button);
		}
	}

	@Override
	public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
		if(button.id == 12){
			gui.closeWindow(getId());
		}
		else if(button instanceof ARB){
			//TODO
		}
		else return;
	}

	@Override
	public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList){
		int i = gui.getGuiLeft(), j = gui.getGuiTop();
		close = new GenericGuiButton(12, i + 246, j + 2, 8, 8, "");
		close.setTexture(texture);
		close.setTexturePos(0, 246, 2);
		close.setTexturePos(1, 246, 2);
		buttonList.add(close);
		buttonList.add(buttons[0] = new ARB(13, i + 146, j + 13, true));
		buttonList.add(buttons[1] = new ARB(14, i + 158, j + 13, false));
		buttonList.add(buttons[2] = new ARB(15, i + 146, j + 25, true));
		buttonList.add(buttons[3] = new ARB(16, i + 158, j + 25, false));
		buttonList.add(buttons[4] = new ARB(17, i + 146, j + 37, true));
		buttonList.add(buttons[5] = new ARB(18, i + 158, j + 37, false));
		buttonList.add(buttons[6] = new ARB(19, i + 152, j + 149, true));
		buttonList.add(buttons[7] = new ARB(20, i + 165, j + 149, false));
		buttonList.add(buttons[8] = new ARB(21, i + 230, j + 149, true));
		buttonList.add(buttons[9] = new ARB(22, i + 242, j + 149, false));
	}

	@Override
	public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
		close.visible = visible;
		for(ARB button : buttons){
			button.visible = visible;
		}
		Print.debug("buttons " + (visible ? "enabled" : "disabled"));
	}

	@Override
	public String getTitle(){
		return "FN Paint";
	}
	
	private static class ARB extends GuiButton {
		
		private boolean left = false;

		public ARB(int buttonId, int x, int y, boolean left){
			super(buttonId, x, y, 10, 10, "");
			this.left = left;
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
			if(!visible){ return; }
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(this.enabled){
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, left ? 199 : 210, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, left ? 146 : 158, 13, this.width, this.height);
    			}
    		}
    		else{
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, left ? 177 : 188, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, left ? 146 : 158, 13, this.width, this.height);
    			}
    		}
	    }
		
	}
	
}