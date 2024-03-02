package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.entity.player.EntityPlayer;

import java.util.TreeMap;

/**
 * Prototype of Addon based steering overlays.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class AddonSteeringOverlay {

	public static TreeMap<String, Class<? extends AddonSteeringOverlay>> OVERLAYS = new TreeMap<>();
	//
	protected net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay root;
	protected EntityPlayer playerentity;
	protected EntityW player;

	public AddonSteeringOverlay(net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay root, EntityPlayer player){
		this.root = root;
		this.player = (playerentity = player).getCapability(Capabilities.PASSENGER, null).asWrapper();
	}

	/** Called on GuiScreen.initGui(); */
	public abstract void init();

	/** Return true to skip default mouse input handling. */
	public abstract boolean handleMouseInput();

	/** Mouse scroll input. */
	public abstract void scroll(int wheel);

	/** Mouse click input.*/
	public abstract void mouseClick(int button);

	/** Return true to skip default key typed checks. */
	public abstract boolean keyTyped(char c, int key);

	/** Called on GuiScreen.updateScreen(); */
	public abstract void updateScreen();

	public abstract void handleKeyboardInput();

	/** Called on GuiScreen.onGuiClosed(); */
	public abstract void guiClosed();

	/** Called on GuiSccreen.drawScreen(); */
	public abstract void drawScreen(int mouseX, int mouseY, float partialTicks, RootVehicle ent, VehicleData data);

	/** Called after the TOGGABLES Keybind, which toggles if the GUI should show the toggables overlay or not. */
	public abstract void onToggablesToggle();

}
