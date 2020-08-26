package net.fexcraft.mod.fvtm.util.handler;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyHandler {

    private static Minecraft minecraft;
    public static KeyBinding engineToggle, openInventory;
    public static KeyBinding doorToggle, scriptsGUI, lightsToggle;
    public static KeyBinding trailerToggle, wagonToggle, reset;
    public static KeyBinding arrow_up, arrow_down, arrow_left, arrow_right;
    public static final String category = "keycompound.fvtm.controls";

    public KeyHandler(){
        minecraft = Minecraft.getMinecraft();
        ClientRegistry.registerKeyBinding(engineToggle = new KeyBinding("key.fvtm.engine", KeyConflictContex.VEHICLE, Keyboard.KEY_LCONTROL, category));
        ClientRegistry.registerKeyBinding(openInventory = new KeyBinding("key.fvtm.vehicle_inventory", KeyConflictContex.VEHICLE, Keyboard.KEY_R, category));
        ClientRegistry.registerKeyBinding(doorToggle = new KeyBinding("key.fvtm.vehicle_doors", KeyConflictContex.VEHICLE, Keyboard.KEY_K, category));
        ClientRegistry.registerKeyBinding(scriptsGUI = new KeyBinding("key.fvtm.vehicle_scripts", KeyConflictContex.VEHICLE, Keyboard.KEY_G, category));
        ClientRegistry.registerKeyBinding(lightsToggle = new KeyBinding("key.fvtm.vehicle_lights", KeyConflictContex.VEHICLE, Keyboard.KEY_L, category));
        ClientRegistry.registerKeyBinding(trailerToggle = new KeyBinding("key.fvtm.vehicle_trailer", KeyConflictContex.VEHICLE, Keyboard.KEY_0, category));
        ClientRegistry.registerKeyBinding(wagonToggle = new KeyBinding("key.fvtm.vehicle_wagon", KeyConflictContex.VEHICLE, Keyboard.KEY_MINUS, category));
        ClientRegistry.registerKeyBinding(arrow_up = new KeyBinding("key.fvtm.arrow_up", KeyConflictContex.VEHICLE, Keyboard.KEY_UP, category));
        ClientRegistry.registerKeyBinding(arrow_down = new KeyBinding("key.fvtm.arrow_down", KeyConflictContex.VEHICLE, Keyboard.KEY_DOWN, category));
        ClientRegistry.registerKeyBinding(arrow_left = new KeyBinding("key.fvtm.arrow_left", KeyConflictContex.VEHICLE, Keyboard.KEY_LEFT, category));
        ClientRegistry.registerKeyBinding(arrow_right = new KeyBinding("key.fvtm.arrow_right", KeyConflictContex.VEHICLE, Keyboard.KEY_RIGHT, category));
        ClientRegistry.registerKeyBinding(reset = new KeyBinding("key.fvtm.reset", KeyConflictContex.TOGGABLE, Keyboard.KEY_SEMICOLON, category));
    }
    
    public static enum KeyConflictContex implements IKeyConflictContext {

    	VEHICLE {
    		@Override
    		public boolean isActive(){
    			return minecraft.player != null && minecraft.player.getRidingEntity() instanceof GenericVehicle;
    		}
    		@Override
    		public boolean conflicts(IKeyConflictContext other){
    			return other == this;
    		}
    	},
    	TOGGABLE {
    		@Override
    		public boolean isActive(){
    			return ToggableHandler.handleClick(KeyPress.RESET, EnumHand.MAIN_HAND);
    		}
    		@Override
    		public boolean conflicts(IKeyConflictContext other){
    			return other == this;
    		}
    	}
    	
    }

    //TODO subscribe key-input event
    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event){
        switch(event.phase){
            case START: { break; }
            case END: {
                if(minecraft.player == null || minecraft.world == null){ return; }
                if(minecraft.player.getRidingEntity() instanceof GenericVehicle && minecraft.currentScreen == null){
                    minecraft.displayGuiScreen(new VehicleSteeringOverlay(minecraft.player));
                } break;
            }
        }
    }

    @SubscribeEvent
    public void clickEmpty(RightClickEmpty event){
    	if(!event.getItemStack().isEmpty()) return;
        ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, event.getHand());
    }

    @SubscribeEvent
    public void clickEmpty(LeftClickEmpty event){
    	if(!event.getItemStack().isEmpty()) return;
        ToggableHandler.handleClick(KeyPress.MOUSE_MAIN, event.getHand());
    }
    
    //unsure if those 2 bellow won't be processing intensive
    //TODO remove if we manage to get larger bounding boxes instead

    @SubscribeEvent
    public void clickEmpty(RightClickBlock event){
    	if(!event.getItemStack().isEmpty()) return;
        if(ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, event.getHand())){
        	event.setCanceled(true);
        	event.setCancellationResult(EnumActionResult.PASS);
        }
    }

    @SubscribeEvent
    public void clickEmpty(LeftClickBlock event){
    	if(!event.getItemStack().isEmpty()) return;
        if(ToggableHandler.handleClick(KeyPress.MOUSE_MAIN, event.getHand())){
        	event.setCanceled(true);
        	event.setCancellationResult(EnumActionResult.PASS);
        }
    }

}
