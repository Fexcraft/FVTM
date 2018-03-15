package net.fexcraft.mod.fvtm.gui.windows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class PartManagerInstalled implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_part_manager_list.png");
	private static GenericGuiButton close, b0, b1, b2;
	private static int scroll, fields = 11;
	private static ARB up, down;
	private static ArrayList<String> missing = new ArrayList<String>();
	private static StateButton[] buttons = new StateButton[fields * 2];

	@Override
	public String getId(){
		return "part_manager_list";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
		//mc.fontRenderer.drawString("Overview", (i + 3), (j + 3), gui.COLOR, false);
		//
		//TreeMap<String, PartData> parts = gui.tile.vehicledata.getParts();
		Object[] parts = gui.tile.vehicledata.getParts().entrySet().toArray();
		refreshMissingParts(gui);
		for(int k = 0; k < fields; k++){
			int l = k + scroll;
			if(l >= parts.length){
				int m = l - parts.length;
				if(missing.isEmpty() || m >= missing.size()){
					buttons[k].enabled = false;
					buttons[k + fields].enabled = false;
					buttons[k].empty = true;
					buttons[k + fields].empty = true;
					continue;
				}
				mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth("missing", 145), i + 5, j + 15 + (k * 14), MapColor.RED_STAINED_HARDENED_CLAY.colorValue, false);
				GL11.glScalef(0.5f, 0.5f, 0.5f);
				mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(missing.get(m), 116), (i + 153) * 2, (j + 15 + (k * 14)) * 2, MapColor.RED_STAINED_HARDENED_CLAY.colorValue, false);
				GL11.glScalef(2, 2, 2);
				//
				buttons[k].enabled = false;
				buttons[k + fields].enabled = false;
				buttons[k].empty = true;
				buttons[k + fields].empty = true;
				continue;
			}
			Entry<String, PartData> entry = (Entry<String, PartData>)parts[l];
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(entry.getValue().getPart().getName(), 145), i + 5, j + 15 + (k * 14), gui.COLOR, false);
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(entry.getKey(), 116), (i + 153) * 2, (j + 15 + (k * 14)) * 2, gui.COLOR, false);
			GL11.glScalef(2, 2, 2);
			//
			buttons[k].enabled = entry.getValue().getPart().isAvailable();
			buttons[k + fields].enabled = entry.getValue().getPart().isRemovable();
			buttons[k].empty = false;
			buttons[k + fields].empty = false;
		}
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		mc.fontRenderer.drawString("Scroll: " + scroll, (i + 5) * 2, (j + 168) * 2, MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue, false);
		mc.fontRenderer.drawString("Parts: " + parts.length, (i + 88) * 2, (j + 168) * 2, MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue, false);
		mc.fontRenderer.drawString("Missing: " + missing.size(), (i + 178) * 2, (j + 168) * 2, MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue, false);
		GL11.glScalef(2, 2, 2);
		//
		up.enabled = scroll > 0;
		down.enabled = scroll < parts.length + missing.size() + fields;
		//
	}
	
	@Override
	public void handleMouseInput(){
		int e = Mouse.getEventDWheel();
		if(e != 0){
			scroll += e > 0 ? -1 : 1;
			scroll = scroll < 0 ? 0 : scroll;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String getAt(ConstructorMainGUI gui, int k){
		Object[] parts = gui.tile.vehicledata.getParts().entrySet().toArray();
		return ((Entry<String, PartData>)parts[k]).getKey();
	}
	
	@SuppressWarnings("unchecked")
	public PartData getPartAt(ConstructorMainGUI gui, int k){
		Object[] parts = gui.tile.vehicledata.getParts().entrySet().toArray();
		return ((Entry<String, PartData>)parts[k]).getValue();
	}

	private void refreshMissingParts(ConstructorMainGUI gui){
		missing.clear();
		for(String string : gui.tile.vehicledata.getVehicle().getRequiredParts()){
			if(gui.tile.vehicledata.getPart(string) == null){
				missing.add(string);
			}
		}
	}

	@Override
	public boolean closesOther(){
		return true;
	}

	@Override
	public void close(ConstructorMainGUI gui, String rqFrom){
		gui.getButtonList().remove(close);
		gui.getButtonList().remove(up);
		gui.getButtonList().remove(down);
		for(StateButton state : buttons){
			gui.getButtonList().remove(state);
		}
		gui.getButtonList().remove(b0);
		gui.getButtonList().remove(b1);
		gui.getButtonList().remove(b2);
	}
	
	private void sendUpdate(ConstructorMainGUI gui, String str){
		NBTTagCompound compound = gui.getPacketNBT("constructor_9000");
		compound.setString("payload", "part_remove");
		compound.setString("part", str);
		gui.sendPacket(compound);
	}

	@Override
	public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
		if(button.id == 12){
			gui.closeWindow(getId());
		}
		else if(button.id == 13 || button.id == 14){
			scroll += button.id == 13 ? -4 : 4;
			scroll = scroll < 0 ? 0 : scroll;
			return;
		}
		else if(button.id >= 37 && button.id <= 39){
			switch(button.id){
				case 37:{
					//Do nothing, it's this gui.
					break;
				}
				case 38:{
					gui.openWindow("part_manager_new");
					break;
				}
				case 39:{
					gui.openWindow("part_manager_edit");
					break;
				}
			}
			return;
		}
		else if(button instanceof StateButton){
			int i = button.id - 15;
			if(i >= fields){//"remove"
				sendUpdate(gui, getAt(gui, i - fields));
			}
			else{//"edit/adjust"
				gui.closeWindow(this.getId());
				gui.openWindow("part_manager_edit", getAt(gui, i));
			}
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
		buttonList.add(up = new ARB(13, gui.getGuiLeft() + 242, gui.getGuiTop() + 13, true));
		buttonList.add(down = new ARB(14, gui.getGuiLeft() + 242, gui.getGuiTop() + 164, false));
		for(int i = 0; i < fields; i++){
			buttonList.add(buttons[i] = new StateButton(15 + i, gui.getGuiLeft() + 214, gui.getGuiTop() + 13 + (i * 14), true));
			buttonList.add(buttons[i + fields] = new StateButton(15 + i + fields, gui.getGuiLeft() + 228, gui.getGuiTop() + 13 + (i * 14), false));
		}
		//
		b0 = new GenericGuiButton(37, gui.getGuiLeft() + 2, gui.getGuiTop() + 2, 74, 8, "Overview");
		b0.setTexture(texture); b0.setTexturePos(0, 2, 2); b0.setTexturePos(1, 2, 2);
		b0.setTextPos(gui.getGuiLeft() + 4, gui.getGuiTop() + 3);
		buttonList.add(b0);
		//
		b1 = new GenericGuiButton(38, gui.getGuiLeft() + 77, gui.getGuiTop() + 2, 74, 8, "Install New");
		b1.setTexture(texture); b1.setTexturePos(0, 77, 2); b1.setTexturePos(1, 77, 2);
		b1.setTextPos(gui.getGuiLeft() + 79, gui.getGuiTop() + 3);
		buttonList.add(b1);
		//
		b2 = new GenericGuiButton(39, gui.getGuiLeft() + 152, gui.getGuiTop() + 2, 74, 8, "Edit Part");
		b2.setTexture(texture); b2.setTexturePos(0, 152, 2); b2.setTexturePos(1, 152, 2);
		b2.setTextPos(gui.getGuiLeft() + 154, gui.getGuiTop() + 3);
		buttonList.add(b2);
	}

	@Override
	public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
		close.visible = visible;
		up.visible = visible;
		down.visible = visible;
		for(StateButton button : buttons){
			button.visible = visible;
		}
		b0.visible = b1.visible = b2.visible = visible;
	}

	@Override
	public String getTitle(){
		return "Part Manager";
	}

	@Override
	public void applyArguments(ConstructorMainGUI gui, String[] args){
		//
	}
	
	private static class ARB extends GuiButton {
		
		private boolean up = false;

		public ARB(int buttonId, int x, int y, boolean left){
			super(buttonId, x, y, 10, 10, "");
			this.up = left;
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
            if(!this.enabled){
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, up ? 199 : 210, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, 242, up ?  13 : 164, this.width, this.height);
    			}
    		}
    		else{
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, up ? 177 : 188, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, 242, up ?  13 : 164, this.width, this.height);
    			}
    		}
	    }
		
	}
	
	private static class StateButton extends GuiButton {
		
		private boolean left = false, empty = false;
		private static RGB lime = new RGB(182, 255, 0), orange = new RGB(127, 106, 0), yellow = new RGB(255, 106, 0);

		public StateButton(int buttonId, int x, int y, boolean left){
			super(buttonId, x, y, 12, 12, "");
			this.left = left;
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
			if(!visible || empty){ return; }
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(this.enabled){
    			if(this.hovered){ lime.glColorApply(); }
    			else{ RGB.GREEN.glColorApply(); }
    		}
    		else{
    			if(this.hovered){ orange.glColorApply(); }
    			else{ yellow.glColorApply(); }
    		}
			this.drawTexturedModalRect(this.x, this.y, left ? 214 : 228, 13, this.width, this.height);
			RGB.glColorReset();
	    }
		
	}
	
}