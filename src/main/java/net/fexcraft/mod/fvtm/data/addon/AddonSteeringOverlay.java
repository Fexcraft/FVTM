package net.fexcraft.mod.fvtm.data.addon;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Prototype of Addon based steering overlays.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class AddonSteeringOverlay {
	
	protected VehicleSteeringOverlay root;
	protected EntityPlayer player;

	public AddonSteeringOverlay(VehicleSteeringOverlay root, EntityPlayer player){
		this.root = root;
		this.player = player;
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
	public abstract void drawScreen(int mouseX, int mouseY, float partialTicks, GenericVehicle ent, VehicleData data);

	/** Called after the TOGGABLES Keybind, which toggles if the GUI should show the toggables overlay or not. */
	public abstract void onToggablesToggle();

}
