package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public interface Window {
	
	public String getId();

	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks);
	
	public boolean closesOther();
	
	public void close(ConstructorMainGUI gui, String rqFrom);

	public void actionPerformed(ConstructorMainGUI gui, GuiButton button);

	public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList);

	public void toggleButtonState(ConstructorMainGUI gui, boolean visible);

	public String getTitle();

	public void applyArguments(ConstructorMainGUI gui, String[] args);

	public default boolean isKeyTyped(char typedChar, int keyCode){
		return true;
	}
	
}