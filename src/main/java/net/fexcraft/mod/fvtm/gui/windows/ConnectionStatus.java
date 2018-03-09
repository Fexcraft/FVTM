package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class ConnectionStatus implements Window {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_connection_status.png");
	private static GenericGuiButton search, manual, close;

	@Override
	public String getId(){
		return "connection_status";
	}

	@Override
	public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
		mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(i + 170, j + 115, 170, 115, 85, 64);
		mc.fontRenderer.drawString(ConstructorMainGUI.connected ? "Connected" : "Disconnected", i + 174, j + 119, 14737632, false);
		//
		search.enabled = manual.enabled = !ConstructorMainGUI.connected;
	}

	@Override
	public boolean closesOther(){
		return false;
	}

	@Override
	public void close(ConstructorMainGUI gui, String rqFrom){
		gui.getButtonList().remove(search);
		gui.getButtonList().remove(manual);
		gui.getButtonList().remove(close);
		//Nothing to do here.
	}

	@Override
	public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
		if(button.id == 12){
			NBTTagCompound nbt = gui.getPacketNBT("constructor_9000");
			nbt.setString("payload", "auto_connect");
			gui.sendPacket(nbt);
		}
		else if(button.id == 13){
			Print.chat(ConstructorMainGUI.player, "Function not available yet.");
		}
		else if(button.id == 14){
			gui.openWindow(getId());
		}
		else return;
	}

	@Override
	public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList){
		int i = gui.getGuiLeft(); int j = gui.getGuiTop();
		search = new GenericGuiButton(12, i + 173, j + 128, 79, 8, "Auto Connect");
		search.setTexture(texture);
		search.setTexturePos(0, 177, 232);
		search.setTexturePos(1, 98, 232);
		search.setTexturePos(2, 177, 208);
		search.setTexturePos(3, 98, 208);
		search.setTextPos(i + 182, j + 129);
		manual = new GenericGuiButton(13, i + 173, j + 138, 79, 8, "Manual Conn..");
		manual.setTexture(texture);
		manual.setTexturePos(0, 177, 240);
		manual.setTexturePos(1, 98, 240);
		manual.setTexturePos(2, 177, 216);
		manual.setTexturePos(3, 98, 216);
		manual.setTextPos(i + 182, j + 139);
		close = new GenericGuiButton(14, i + 173, j + 168, 79, 8, "Close");
		close.setTexture(texture);
		close.setTexturePos(0, 177, 248);
		close.setTexturePos(1, 98, 248);
		close.setTexturePos(2, 177, 224);
		close.setTexturePos(3, 98, 224);
		close.setTextPos(i + 182, j + 169);
		buttonList.add(search);
		buttonList.add(manual);
		buttonList.add(close);
	}

	@Override
	public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
		if(!visible){
			gui.openWindow(getId());
		}
	}

	@Override
	public String getTitle(){
		return null;
	}
	
}