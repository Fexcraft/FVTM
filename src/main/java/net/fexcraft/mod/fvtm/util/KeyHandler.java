package net.fexcraft.mod.fvtm.util;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.gui.GuiVehicleConroller;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyHandler {
	
	private final Minecraft minecraft;
	public static KeyBinding engineToggle;
	public static KeyBinding openInventory;
	public static KeyBinding leftMouse;
	public static KeyBinding rightMouse;
	public static KeyBinding doorToggle;
	public static final String category = "FVTM Controls";
	
	public KeyHandler(){
		this.minecraft = Minecraft.getMinecraft();
		engineToggle = new KeyBinding("Engine", Keyboard.KEY_LCONTROL, category);
		openInventory = new KeyBinding("Inventory", Keyboard.KEY_R, category);
		leftMouse = new KeyBinding("Prototype LM", Keyboard.KEY_8, category);
		rightMouse = new KeyBinding("Prototype RM", Keyboard.KEY_9, category);
		doorToggle = new KeyBinding("Doors", Keyboard.KEY_K, category);
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
					minecraft.displayGuiScreen(new GuiVehicleConroller((SeatEntity)minecraft.player.getRidingEntity()));
				}
				break;
			}
		}	
	}
	
}
