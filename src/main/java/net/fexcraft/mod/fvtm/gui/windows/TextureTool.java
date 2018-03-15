package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class TextureTool implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_texture_tool.png");
	private static GenericGuiButton close;
	private static boolean vehicle = false;
	private static String part = null;
	private GuiTextField ifield, efield;
	private ARB[] arbs = new ARB[4];

	@Override
	public String getId(){
		return "texture_tool";
	}

	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
		//
		if(gui.tile.vehicledata == null){
			return;
		}
		int k = getTextureMode(gui);
		RGB rgb = k == 0 ? RGB.GREEN : RGB.RED;
		rgb.glColorApply();
		gui.drawTexturedModalRect(i + 245, j + 12, 245, 12, 8, 53);
		RGB.glColorReset();
		rgb = k == 1 ? RGB.GREEN : RGB.RED;
		rgb.glColorApply();
		gui.drawTexturedModalRect(i + 245, j + 67, 245, 67, 8, 53);
		RGB.glColorReset();
		rgb = k == 2 ? RGB.GREEN : RGB.RED;
		rgb.glColorApply();
		gui.drawTexturedModalRect(i + 245, j + 122, 245, 122, 8, 53);
		RGB.glColorReset();
		//
		//TODO render texture miniature
		//
		mc.fontRenderer.drawString("Texture Type: SUPPLIED", i +  7, j +  53, gui.COLOR, false);
		mc.fontRenderer.drawString("Texture Type: INTERNAL", i +  7, j + 108, gui.COLOR, false);
		mc.fontRenderer.drawString("Texture Type: EXTERNAL", i +  7, j + 163, gui.COLOR, false);
		mc.fontRenderer.drawString(getSelectedTextureText(gui), i + 7, j + 30, gui.COLOR, false);
		//
		mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(getSelectedTexture(gui), 184, true), i +  7, j +   16, MapColor.GRAY.colorValue, false);
		//mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(getCustomTexture(gui)  , 184, true), i +  7, j +   71, MapColor.GRAY.colorValue, false);
		//mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(getExternalTexture(gui), 184, true), i +  7, j +  126, MapColor.GRAY.colorValue, false);
		//
		GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        ifield.drawTextBox();
        efield.drawTextBox();
	}

	private String getSelectedTextureText(ConstructorMainGUI gui){
		if(vehicle){
			return "Selected nr. '" + (gui.tile.vehicledata.getSelectedTexture() + 1) + "' out of " + gui.tile.vehicledata.getVehicle().getTextures().size() + ".";
		}
		else{
			PartData data = gui.tile.vehicledata.getPart(part);
			return "Selected nr. '" + (data.getSelectedTexture() + 1) + "' out of " + data.getPart().getTextures().size() + ".";
		}
	}

	private String getExternalTexture(ConstructorMainGUI gui){
		if(vehicle){
			if(!gui.tile.vehicledata.isTextureExternal()){
				return "none";
			}
			else{
				String str = gui.tile.vehicledata.getCustomTexture().toString();
				return str.equals("minecraft:") ? "none" : str;
			}
		}
		else{
			PartData data = gui.tile.vehicledata.getPart(part);
			if(!data.isTextureExternal()){
				return "none";
			}
			else{
				String str = data.getCustomTexture().toString();
				return str.equals("minecraft:") ? "none" : str;
			}
		}
	}

	private String getCustomTexture(ConstructorMainGUI gui){
		if(vehicle){
			if(gui.tile.vehicledata.isTextureExternal()){
				return "none";
			}
			else{
				String str = gui.tile.vehicledata.getCustomTexture().toString();
				return str.equals("minecraft:") ? "none" : str;
			}
		}
		else{
			PartData data = gui.tile.vehicledata.getPart(part);
			if(data.isTextureExternal()){
				return "none";
			}
			else{
				String str = data.getCustomTexture().toString();
				return str.equals("minecraft:") ? "none" : str;
			}
		}
	}

	private String getSelectedTexture(ConstructorMainGUI gui){
		if(vehicle){
			if(gui.tile.vehicledata.getSelectedTexture() == -1){
				return "none";
			}
			else{
				return gui.tile.vehicledata.getVehicle().getTextures().get(gui.tile.vehicledata.getSelectedTexture()).toString();
			}
		}
		else{
			PartData data = gui.tile.vehicledata.getPart(part);
			if(data.getSelectedTexture() == -1){
				return "none";
			}
			else{
				return data.getPart().getTextures().get(data.getSelectedTexture()).toString();
			}
		}
	}

	private int getTextureMode(ConstructorMainGUI gui){
		if(vehicle){
			return gui.tile.vehicledata.getSelectedTexture() >= 0 ? 0 : gui.tile.vehicledata.isTextureExternal() ? 2 : 1;
		}
		else{
			PartData data = gui.tile.vehicledata.getPart(part);
			return data.getSelectedTexture() >= 0 ? 0 : data.isTextureExternal() ? 2 : 1;
		}
	}

	@Override
	public boolean closesOther(){
		return true;
	}

	@Override
	public void close(ConstructorMainGUI gui, String rqFrom){
		gui.getButtonList().remove(close);
		for(ARB arb : arbs){
			gui.getButtonList().remove(arb);
		}
        Keyboard.enableRepeatEvents(false);
		//
	}

	@Override
	public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
		if(button.id == 12){
			gui.closeWindow(getId());
		}
		else if(button instanceof ARB){
			switch(button.id){
				case 15:{
					sendUpdate(gui, 0, "prev");
					break;
				}
				case 16:{
					sendUpdate(gui, 0, "next");
					break;
				}
				case 17:{
					sendUpdate(gui, 1, ifield.getText());
					break;
				}
				case 18:{
					sendUpdate(gui, 2, efield.getText());
					break;
				}
			}
		}
		//
		else return;
	}
	
	private void sendUpdate(ConstructorMainGUI gui, int cat, String str){
		NBTTagCompound compound = gui.getPacketNBT("constructor_9000");
		compound.setString("payload", "texture_update");
		compound.setString("type", vehicle ? "vehicle" : "part:" + part);
		compound.setInteger("category", cat);
		compound.setString("data", str);
		gui.sendPacket(compound);
	}

	@Override
	public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList){
		int i = gui.getGuiLeft(), j = gui.getGuiTop();
		close = new GenericGuiButton(12, i + 246, j + 2, 8, 8, "");
		close.setTexture(texture);
		close.setTexturePos(0, 246, 2);
		close.setTexturePos(1, 246, 2);
		buttonList.add(close);
		//
        Keyboard.enableRepeatEvents(true);
		ifield = new GuiTextField(13, gui.mc.fontRenderer, i + 7, j + 71, 184, 8);
		ifield.setText(getCustomTexture(gui));
		ifield.setTextColor(gui.COLOR);
        ifield.setDisabledTextColour(MapColor.RED.colorValue);
        ifield.setEnableBackgroundDrawing(false);
        ifield.setMaxStringLength(1024);
        //
        efield = new GuiTextField(14, gui.mc.fontRenderer, i + 7, j + 126, 184, 8);
		efield.setText(getExternalTexture(gui));
		efield.setTextColor(gui.COLOR);
        efield.setDisabledTextColour(MapColor.RED.colorValue);
        efield.setEnableBackgroundDrawing(false);
        efield.setMaxStringLength(1024);
        //
        buttonList.add(arbs[0] = new ARB(15, i + 171, j +  28, true));
        buttonList.add(arbs[1] = new ARB(16, i + 183, j +  28, false));
        buttonList.add(arbs[2] = new ARB(17, i + 183, j +  83, false));
        buttonList.add(arbs[3] = new ARB(18, i + 183, j + 138, false));
	}

	@Override
	public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
		close.visible = visible;
		for(ARB arb : arbs){
			arb.visible = visible;
		}
	}

	@Override
	public String getTitle(){
		return "Texture Util";
	}

	@Override
	public void applyArguments(ConstructorMainGUI gui, String[] args){
		vehicle = false;
		if(args.length >= 1 && args[0].startsWith("type")){
			vehicle = args[0].equals("type:vehicle");
		}
		if(!vehicle){
			if(args.length < 2 || args[1] == null){
				Print.chat(gui.player, "Set as editing part, but no part specified! Closing Window.");
				gui.closeWindow(getId());
			}
			part = args[1];
		}
		//
	}

	@Override
	public boolean isKeyTyped(char typedChar, int keyCode){
		return ifield.textboxKeyTyped(typedChar, keyCode) || efield.textboxKeyTyped(typedChar, keyCode);
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton){
        ifield.mouseClicked(mouseX, mouseY, mouseButton);
        efield.mouseClicked(mouseX, mouseY, mouseButton);
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
    				this.drawTexturedModalRect(this.x, this.y, left ? 171 : 183, 28, this.width, this.height);
    			}
    		}
    		else{
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, left ? 177 : 188, 180, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, left ? 171 : 183, 28, this.width, this.height);
    			}
    		}
	    }
		
	}
	
}