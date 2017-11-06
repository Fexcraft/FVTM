package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyHandler {
	
	private static Minecraft mcc;
	//private static final String category = "FVTM - Vehicle Controls";
	//public static KeyBinding accelerate = new KeyBinding("Accelerate", Keyboard.KEY_W, category);
	//public static KeyBinding decelerate = new KeyBinding("Decelerate", Keyboard.KEY_S, category);
	//public static KeyBinding turn_right = new KeyBinding("Turn Right", Keyboard.KEY_D, category);
	//public static KeyBinding turn_left  = new KeyBinding("Turn Left",  Keyboard.KEY_A, category);
	//public static KeyBinding brake  = new KeyBinding("Brake", Keyboard.KEY_SPACE, category);
	
	public KeyHandler(){
		//ClientRegistry.registerKeyBinding(accelerate);
		//ClientRegistry.registerKeyBinding(decelerate);
		//ClientRegistry.registerKeyBinding(turn_right);
		//ClientRegistry.registerKeyBinding(turn_left);
		//ClientRegistry.registerKeyBinding(brake);
		mcc = Minecraft.getMinecraft();
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event){
		if(FMLClientHandler.instance().isGUIOpen(GuiChat.class) || mcc.currentScreen != null){
			return;
		}
		//
		EntityPlayer player = mcc.player;
		if(player.isRiding() && player.getRidingEntity() instanceof VehicleEntity){
			VehicleEntity ent = (VehicleEntity)player.getRidingEntity();
			if(mcc.gameSettings.keyBindForward.isPressed()){
				ent.keyPress("accelerate", player);
			}
			if(mcc.gameSettings.keyBindBack.isPressed()){
				ent.keyPress("decelerate", player);
			}
			if(mcc.gameSettings.keyBindRight.isPressed()){
				ent.keyPress("turn_right", player);
			}
			if(mcc.gameSettings.keyBindLeft.isPressed()){
				ent.keyPress("turn_left", player);
			}
			if(mcc.gameSettings.keyBindJump.isPressed()){
				ent.keyPress("brake", player);
			}
		}
	}
	
}