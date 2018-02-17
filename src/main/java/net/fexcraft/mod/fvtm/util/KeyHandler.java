package net.fexcraft.mod.fvtm.util;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.gui.GuiVehicleController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyHandler {
	
	private final Minecraft minecraft;
	public static KeyBinding engineToggle;
	public static KeyBinding openInventory;
	public static KeyBinding leftMouse;
	public static KeyBinding rightMouse;
	public static KeyBinding doorToggle, scriptsGUI, lightsToggle;
	public static final String category = "FVTM Controls";
	
	public KeyHandler(){
		this.minecraft = Minecraft.getMinecraft();
		ClientRegistry.registerKeyBinding(engineToggle = new KeyBinding("Engine", Keyboard.KEY_LCONTROL, category));
		ClientRegistry.registerKeyBinding(openInventory = new KeyBinding("Inventory", Keyboard.KEY_R, category));
		ClientRegistry.registerKeyBinding(leftMouse = new KeyBinding("Prototype LM", Keyboard.KEY_8, category));
		ClientRegistry.registerKeyBinding(rightMouse = new KeyBinding("Prototype RM", Keyboard.KEY_9, category));
		ClientRegistry.registerKeyBinding(doorToggle = new KeyBinding("Doors", Keyboard.KEY_K, category));
		ClientRegistry.registerKeyBinding(scriptsGUI = new KeyBinding("Scripts GUI", Keyboard.KEY_G, category));
		ClientRegistry.registerKeyBinding(lightsToggle = new KeyBinding("Lights", Keyboard.KEY_L, category));
	}
	
	//TODO sunscribe keyinput event
	
	@SubscribeEvent
	public void clientTick(TickEvent.ClientTickEvent event){
		switch(event.phase){
			case START :{
				Tabs.update();
				break;
			}
			case END :{
				if(minecraft.player == null || minecraft.world == null){ return; }
				if(minecraft.player.getRidingEntity() instanceof SeatEntity && minecraft.currentScreen == null){
					minecraft.displayGuiScreen(new GuiVehicleController((SeatEntity)minecraft.player.getRidingEntity()));
				}
				break;
			}
		}	
	}
	
}
