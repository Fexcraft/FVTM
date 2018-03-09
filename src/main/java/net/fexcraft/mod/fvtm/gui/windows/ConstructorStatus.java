package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity.Client;
import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class ConstructorStatus implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_settings.png");
	private static GenericGuiButton close;

	@Override
	public String getId(){
		return "status";
	}

	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
		gui.drawString(mc.fontRenderer, "System Status of Constructor", i + 3, j + 12, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "World Coordinates:", i + 3, j + 22, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "> X: " + gui.pos.getX(), i + 3, j + 32, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "> Y: " + gui.pos.getY(), i + 3, j + 42, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "> Z: " + gui.pos.getZ(), i + 3, j + 52, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "Version: " + FVTM.VERSION, i + 3, j + 66, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "Connected: " + ConstructorMainGUI.connected, i + 3, j + 76, ConstructorMainGUI.COLOR);
		gui.drawString(mc.fontRenderer, "Paint Module: " + (ConstructorMainGUI.paint ? "connected" : "unavailable"), i + 3, j + 86, ConstructorMainGUI.COLOR);
		Client cl = (Client)ConstructorMainGUI.world.getTileEntity(gui.pos);
		gui.drawString(mc.fontRenderer, "Loaded Vehicle: " + (cl.vehicledata == null ? "none" : cl.vehicledata.getVehicle().getRegistryName().toString()), i + 3, j + 96, ConstructorMainGUI.COLOR);
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
			gui.openWindow(getId());
		}
		else return;
	}

	@Override
	public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList){
		close = new GenericGuiButton(14, gui.getGuiLeft() + 246, gui.getGuiTop() + 2, 8, 8, "");
		close.setTexture(texture);
		close.setTexturePos(0, 246, 2);
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
	
}