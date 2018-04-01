package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class ConstructorStatus implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_settings.png");
	private static GenericGuiButton close;
	private static final int color = 16777120;

	@Override
	public String getId(){
		return "status";
	}

	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
		mc.fontRenderer.drawString("System Status of Constructor", i + 3, j + 12, color, false);
		mc.fontRenderer.drawString("World Coordinates:", i + 3, j + 22, color, false);
		mc.fontRenderer.drawString("> X: " + gui.pos.getX(), i + 3, j + 32, color, false);
		mc.fontRenderer.drawString("> Y: " + gui.pos.getY(), i + 3, j + 42, color, false);
		mc.fontRenderer.drawString("> Z: " + gui.pos.getZ(), i + 3, j + 52, color, false);
		mc.fontRenderer.drawString("Version: " + FVTM.VERSION, i + 3, j + 66, color, false);
		mc.fontRenderer.drawString("Connected: " + ConstructorMainGUI.connected, i + 3, j + 76, color, false);
		mc.fontRenderer.drawString("Paint Module: " + (ConstructorMainGUI.paint ? "connected" : "unavailable"), i + 3, j + 86, color, false);
		ConstructorControllerEntity cl = (ConstructorControllerEntity)ConstructorMainGUI.world.getTileEntity(gui.pos);
		if(cl.getContainerData() == null){
			mc.fontRenderer.drawString("Loaded Vehicle: " + (cl.getVehicleData() == null ? "none" : cl.getVehicleData().getVehicle().getRegistryName().toString()), i + 3, j + 96, color, false);
		}
		else{
			mc.fontRenderer.drawString("Loaded Container: " + cl.getContainerData().getContainer().getRegistryName().toString(), i + 3, j + 96, color, false);
		}
	}

	@Override
	public boolean closesOther(){
		return true;
	}

	@Override
	public void close(ConstructorMainGUI gui, String rqFrom){
		gui.getButtonList().remove(close);
	}

	@Override
	public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
		if(button.id == 12){
			gui.closeWindow(getId());
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
	}

	@Override
	public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
		close.visible = visible;
	}

	@Override
	public String getTitle(){
		return "System Status";
	}

	@Override
	public void applyArguments(ConstructorMainGUI gui, String[] args){
		//
	}
	
}