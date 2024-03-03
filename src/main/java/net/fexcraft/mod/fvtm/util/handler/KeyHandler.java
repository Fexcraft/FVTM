package net.fexcraft.mod.fvtm.util.handler;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class KeyHandler {

    private static Minecraft minecraft;
    public static KeyBinding engineToggle, openInventory;
    public static KeyBinding doorToggle, scriptsGUI, lightsToggle;
    public static KeyBinding trailerToggle, wagonToggle, reset, brake, pbrake;
    public static KeyBinding arrow_up, arrow_down, arrow_left, arrow_right;
    public static final String category = "keycompound.fvtm.controls";
    private static boolean toggables;

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
        ClientRegistry.registerKeyBinding(brake = new KeyBinding("key.fvtm.brake", KeyConflictContex.VEHICLE, Keyboard.KEY_SPACE, category));
        ClientRegistry.registerKeyBinding(pbrake = new KeyBinding("key.fvtm.pbrake", KeyConflictContex.VEHICLE, Keyboard.KEY_O, category));
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
    			return ToggableHandler.handleClick(KeyPress.RESET, ItemStack.EMPTY);
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
        if(minecraft.player == null || minecraft.world == null) return;
        switch(event.phase){
            case START: {
                if(minecraft.player.getRidingEntity() instanceof RootVehicle){
                    handleKeyboardInput();
                }
            }
            case END: {
                /*if(minecraft.player.getRidingEntity() instanceof RootVehicle && minecraft.currentScreen == null){
                    RootVehicle veh = (RootVehicle)minecraft.player.getRidingEntity();
                	if(veh.getSeatOf(minecraft.player) == null) return;//temp
                    minecraft.displayGuiScreen(new VehicleSteeringOverlay(minecraft.player));
                }*/
                break;
            }
        }
    }

    public void handleKeyboardInput(){
        Passenger player = minecraft.player.getCapability(Capabilities.PASSENGER, null).asWrapper();
        SeatInstance seat = ((RootVehicle)minecraft.player.getRidingEntity()).getSeatOf(minecraft.player);
        if(seat == null) return;
        boolean uni12 = false;
        if(isKeyDown(minecraft.gameSettings.keyBindForward.getKeyCode())){
            seat.onKeyPress(seat.root.type.isAirVehicle() ? KeyPress.TURN_DOWN : KeyPress.ACCELERATE, player);
        }
        if(isKeyDown(minecraft.gameSettings.keyBindBack.getKeyCode())){
            seat.onKeyPress(seat.root.type.isAirVehicle() ? KeyPress.TURN_UP : KeyPress.DECELERATE, player);
        }
        if(isKeyDown(minecraft.gameSettings.keyBindLeft.getKeyCode())){
            seat.onKeyPress(KeyPress.TURN_LEFT, player);
        }
        if(isKeyDown(minecraft.gameSettings.keyBindRight.getKeyCode())){
            seat.onKeyPress(KeyPress.TURN_RIGHT, player);
        }
        if(isKeyDown(KeyHandler.arrow_up.getKeyCode())){
            /*if(toggables) scroll(0, -1);
            else*/ seat.onKeyPress(seat.root.type.isAirVehicle() ? KeyPress.ACCELERATE : KeyPress.GEAR_UP, player);
        }
        if(isKeyDown(KeyHandler.arrow_down.getKeyCode())){
            /*if(toggables) scroll(0, 1);
            else*/ seat.onKeyPress(seat.root.type.isAirVehicle() ? KeyPress.DECELERATE : KeyPress.GEAR_DOWN, player);
        }
        if(isKeyDown(KeyHandler.arrow_left.getKeyCode())){
            /*if(toggables) scroll(-1, 0);
            else*/ seat.onKeyPress(KeyPress.ROLL_LEFT, player);
        }
        if(isKeyDown(KeyHandler.arrow_right.getKeyCode())){
            /*if(toggables) scroll(1, 0);
            else*/ seat.onKeyPress(KeyPress.ROLL_RIGHT, player);
        }
        if(uni12){
            if(isKeyDown(KeyHandler.pbrake.getKeyCode())){
                seat.onKeyPress(KeyPress.PBRAKE, player);
            }
            boolean state = isKeyDown(KeyHandler.brake.getKeyCode());
            if(state != seat.root.getKeyPressState(KeyPress.BRAKE)){
                seat.root.onKeyPress(KeyPress.BRAKE, seat.seat, player, state);
            }
        }
        else{
            if(isKeyDown(KeyHandler.brake.getKeyCode())){
                seat.onKeyPress(KeyPress.BRAKE, player);
            }
        }
        if(isKeyDown(KeyHandler.engineToggle.getKeyCode())){
            seat.onKeyPress(KeyPress.ENGINE, player);
        }
        if(isKeyDown(minecraft.gameSettings.keyBindSneak.getKeyCode())){
            seat.onKeyPress(KeyPress.DISMOUNT, player);
        }
        if(isKeyDown(KeyHandler.openInventory.getKeyCode())){
            //root.resetview = false;
            seat.onKeyPress(KeyPress.INVENTORY, player);
        }
        if(isKeyDown(KeyHandler.doorToggle.getKeyCode())){
            seat.onKeyPress(KeyPress.TOGGABLES, player);
        }
        if(isKeyDown(KeyHandler.scriptsGUI.getKeyCode())){
            //root.resetview = false;
            seat.onKeyPress(KeyPress.SCRIPTS, player);
        }
        if(isKeyDown(KeyHandler.lightsToggle.getKeyCode())){
            seat.onKeyPress(KeyPress.LIGHTS, player);
        }
        if(isKeyDown(KeyHandler.trailerToggle.getKeyCode())){
            seat.onKeyPress(KeyPress.COUPLER_REAR, player);
        }
        if(isKeyDown(KeyHandler.wagonToggle.getKeyCode())){
            seat.onKeyPress(KeyPress.COUPLER_FRONT, player);
        }
        if(isKeyDown(KeyHandler.reset.getKeyCode())){
            /*if(toggables) processToggleClick(2);
            else*/ seat.onKeyPress(KeyPress.RESET, player);
        }
    }

    public boolean isKeyDown(int keycode){
        return keycode < 0 ? Mouse.isButtonDown(keycode + 100) : keycode > 255 ? /* invalid code - PASS */ false : Keyboard.isKeyDown(keycode);
    }

    @SubscribeEvent
    public void clickEmpty(RightClickEmpty event){
    	//if(!event.getItemStack().isEmpty()) return;
        if(event.getHand() == EnumHand.MAIN_HAND) ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, event.getItemStack());
    }

    @SubscribeEvent
    public void clickEmpty(LeftClickEmpty event){
    	//if(!event.getItemStack().isEmpty()) return;
    	if(event.getHand() == EnumHand.MAIN_HAND) ToggableHandler.handleClick(KeyPress.MOUSE_MAIN, event.getItemStack());
    }
    
    //unsure if those 3 bellow won't be processing intensive
    //TODO remove if we manage to get larger bounding boxes instead

    @SubscribeEvent
    public void clickItem(RightClickItem event){
        if(event.getHand() == EnumHand.MAIN_HAND && ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, event.getItemStack())){
        	event.setCanceled(true);
        	event.setCancellationResult(EnumActionResult.PASS);
        }
    }

    @SubscribeEvent
    public void clickBlock(RightClickBlock event){
    	//if(!event.getItemStack().isEmpty()) return;
        if(event.getHand() == EnumHand.MAIN_HAND && ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, event.getItemStack())){
        	event.setCanceled(true);
        	event.setCancellationResult(EnumActionResult.PASS);
        }
    }

    @SubscribeEvent
    public void clickBlock(LeftClickBlock event){
    	//if(!event.getItemStack().isEmpty()) return;
        if(event.getHand() == EnumHand.MAIN_HAND && ToggableHandler.handleClick(KeyPress.MOUSE_MAIN, event.getItemStack())){
        	event.setCanceled(true);
        	event.setCancellationResult(EnumActionResult.PASS);
        }
    }

}
