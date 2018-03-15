package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class PartManagerEdit implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_part_manager_edit.png");
	private static GenericGuiButton close, b0, b1, b2, remdrop, autoinst;
	private static int scrolll, scrollr, fields = 7;
	private static ARB upl, upr, downl, downr;
	private static FieldButton[] buttons = new FieldButton[fields * 2];
	private static String cat = null;

	@Override
	public String getId(){
		return "part_manager_new";
	}

	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
		//
		if(cat == null){
			return;
		}
		PartData data = gui.tile.vehicledata == null ? null : gui.tile.vehicledata.getPart(cat);
		mc.fontRenderer.drawString("Installable as:", (i + 6), (j + 57), gui.COLOR, false);
		mc.fontRenderer.drawString("Compatible with:", (i + 132), (j + 57), gui.COLOR, false);
		mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth("Part: " + (data == null ? "no part selected" : data.getPart().getName()), 176), (i + 6), (j + 15), gui.COLOR, false);
		mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth("RSLC: " + (data == null ? "no part selected" : data.getPart().getRegistryName().toString()), 176), (i + 6), (j + 29), gui.COLOR, false);
		//
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		mc.fontRenderer.drawString("Scroll: " + scrolll, (i + 6) * 2, (j + 168) * 2, MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue, false);
		mc.fontRenderer.drawString("Scroll: " + scrollr, (i + 132) * 2, (j + 168) * 2, MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue, false);
		GL11.glScalef(2, 2, 2);
		if(data == null){
			return;
		}
		//
		List<String> list = data.getPart().getCategories();
		List<ResourceLocation> rss = data.getPart().getCompatibleVehicles();
		for(int k = 0; k < fields; k++){
			int l = k + scrolll;
			if(l >= list.size()){
				buttons[k].enabled = false;
				buttons[k].displayString = "";
				continue;
			}
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(list.get(l), 106 - 4), (i + 6 + 4), (j + 71) + (k * 14), gui.COLOR, false);
			buttons[k].enabled = gui.tile.vehicledata.getPart(list.get(l)) == null;
			buttons[k].displayString = " ";
			//
			int m = k + scrollr;
			if(m >= rss.size()){
				buttons[k + fields].enabled = false;
				buttons[k + fields].displayString = "";
				continue;
			}
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(rss.get(m).toString(), 106 - 4, true), (i + 132 + 4), (j + 71) + (k * 14), gui.COLOR, false);
			buttons[k + fields].displayString = " ";
		}
	}

	@Override
	public boolean closesOther(){
		return true;
	}

	@Override
	public void close(ConstructorMainGUI gui, String rqFrom){
		gui.getButtonList().remove(close);
		gui.getButtonList().remove(b0);
		gui.getButtonList().remove(b1);
		gui.getButtonList().remove(b2);
		//
		gui.getButtonList().remove(upl);
		gui.getButtonList().remove(upr);
		gui.getButtonList().remove(downl);
		gui.getButtonList().remove(downr);
		//
		for(FieldButton button : buttons){
			gui.getButtonList().remove(button);
		}
		gui.getButtonList().remove(remdrop);
		gui.getButtonList().remove(autoinst);
		//
		cat = null;
	}

	@Override
	public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
		if(button.id == 12){
			gui.closeWindow(getId());
		}
		else if(button.id == 60){
			if(cat == null){ return; }
			Print.chat(gui.player, "Feature not available yet.");
			return;
		}
		else if(button.id == 61){
			if(cat == null){ return; }
			gui.openWindow("texture_tool", "type:part", cat);
			return;
		}
		else if(button.id >= 27 && button.id <= 29){
			switch(button.id){
				case 27:{
					gui.openWindow("part_manager_list");
					break;
				}
				case 28:{
					gui.openWindow("part_manager_new");
					break;
				}
				case 29:{
					//Do nothing, it's this gui.
					break;
				}
			}
			return;
		}
		else if(button.id == 30 || button.id == 31){
			scrolll += button.id == 30 ? -1 : 1;
			scrolll = scrolll < 0 ? 0 : scrolll;
			return;
		}
		else if(button.id == 32 || button.id == 33){
			scrollr += button.id == 32 ? -1 : 1;
			scrollr = scrollr < 0 ? 0 : scrollr;
			return;
		}
		else if(button.id >= 40 && button instanceof FieldButton){
			return;
		}
		else return;
	}

	@Override
	public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList){
		close = new GenericGuiButton(12, gui.getGuiLeft() + 246, gui.getGuiTop() + 2, 8, 8, "");
		close.setTexture(texture);
		close.setTexturePos(0, 246, 2);
		close.setTexturePos(1, 246, 2);
		buttonList.add(close);
		//
		b0 = new GenericGuiButton(27, gui.getGuiLeft() + 2, gui.getGuiTop() + 2, 74, 8, "Overview");
		b0.setTexture(texture); b0.setTexturePos(0, 2, 2); b0.setTexturePos(1, 2, 2);
		b0.setTextPos(gui.getGuiLeft() + 4, gui.getGuiTop() + 3);
		buttonList.add(b0);
		//
		b1 = new GenericGuiButton(28, gui.getGuiLeft() + 77, gui.getGuiTop() + 2, 74, 8, "Install New");
		b1.setTexture(texture); b1.setTexturePos(0, 77, 2); b1.setTexturePos(1, 77, 2);
		b1.setTextPos(gui.getGuiLeft() + 79, gui.getGuiTop() + 3);
		buttonList.add(b1);
		//
		b2 = new GenericGuiButton(29, gui.getGuiLeft() + 152, gui.getGuiTop() + 2, 74, 8, "Edit Part");
		b2.setTexture(texture); b2.setTexturePos(0, 152, 2); b2.setTexturePos(1, 152, 2);
		b2.setTextPos(gui.getGuiLeft() + 154, gui.getGuiTop() + 3);
		buttonList.add(b2);
		//
		buttonList.add(upl = new ARB(30, gui.getGuiLeft() + 116, gui.getGuiTop() + 69, true));
		buttonList.add(downl = new ARB(31, gui.getGuiLeft() + 116, gui.getGuiTop() + 164, false));
		buttonList.add(upr = new ARB(32, gui.getGuiLeft() + 242, gui.getGuiTop() + 69, true));
		buttonList.add(downr = new ARB(33, gui.getGuiLeft() + 242, gui.getGuiTop() + 164, false));
		//
		for(int i = 0; i < fields; i++){
			buttonList.add(buttons[i] = new FieldButton(i + 40, gui.getGuiLeft() + 4, gui.getGuiTop() + 69 + (i * 14)));
			buttonList.add(buttons[i + fields] = new FieldButton(i + 40 + fields, gui.getGuiLeft() + 130, gui.getGuiTop() + 69 + (i * 14)));
		}
		remdrop = new GenericGuiButton(60, gui.getGuiLeft() + 186, gui.getGuiTop() + 27, 66, 12, "Attributes");
		remdrop.setTexture(texture);
		remdrop.setTexturePos(0, 186, 27);
		remdrop.setTexturePos(1, 186, 27);
		remdrop.setTextPos(gui.getGuiLeft() + 188, gui.getGuiTop() + 29);
		buttonList.add(remdrop);
		autoinst = new GenericGuiButton(61, gui.getGuiLeft() + 186, gui.getGuiTop() + 13, 66, 12, "Textures");
		autoinst.setTexture(texture);
		autoinst.setTexturePos(0, 186, 13);
		autoinst.setTexturePos(1, 186, 13);
		autoinst.setTextPos(gui.getGuiLeft() + 188, gui.getGuiTop() + 15);
		buttonList.add(autoinst);
	}

	@Override
	public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
		close.visible = visible;
		b0.visible = b1.visible = b2.visible = visible;
		upl.visible = upr.visible = downl.visible = downr.visible = visible;
		//
		for(FieldButton button : buttons){
			button.visible = visible;
		}
		remdrop.visible = autoinst.visible = visible;
	}

	@Override
	public String getTitle(){
		return "Part Editor";
	}

	@Override
	public void applyArguments(ConstructorMainGUI gui, String[] args){
		cat = args[0];
	}
	
	private static class ARB extends GuiButton {
		
		private boolean up = false;

		public ARB(int buttonId, int x, int y, boolean up){
			super(buttonId, x, y, 10, 10, "");
			this.up = up;
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
			if(!visible){ return; }
			mc.getTextureManager().bindTexture(texture);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(!this.enabled){
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, up ? 199 : 210, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, 116, up ?  69 : 164, this.width, this.height);
    			}
    		}
    		else{
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, up ? 177 : 188, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, 116, up ?  69 : 164, this.width, this.height);
    			}
    		}
	    }
		
	}
	
	private static class FieldButton extends GuiButton {

		private static RGB lime = new RGB(182, 255, 0), orange = new RGB(255, 106, 0);

		public FieldButton(int buttonId, int x, int y){
			super(buttonId, x, y, 110, 12, "");
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
			if(!visible){ return; }
			mc.getTextureManager().bindTexture(texture);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(id >= (fields + 40)){
            	if(hovered && !displayString.equals("")){
            		//lime.glColorApply();
            		RGB.BLACK.glColorApply();
            	}
    			this.drawTexturedModalRect(this.x, this.y, 4, 69, 4, this.height);
    			if(hovered && !displayString.equals("")){
    				RGB.glColorReset();
    			}
            }
            else{
            	if(hovered && !displayString.equals("")){
            		if(enabled){
        				lime.glColorApply();
            		}
            		else{
        				orange.glColorApply();
            		}
            	}
    			this.drawTexturedModalRect(this.x, this.y, 4, 69, 4, this.height);
    			if(hovered){
    				RGB.glColorReset();
    			}
            }
	    }
		
	}
	
}