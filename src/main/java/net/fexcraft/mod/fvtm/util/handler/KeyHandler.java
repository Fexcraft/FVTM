package net.fexcraft.mod.fvtm.util.handler;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyHandler {

    private final Minecraft minecraft;
    public static KeyBinding engineToggle, openInventory;
    public static KeyBinding doorToggle, scriptsGUI, lightsToggle;
    public static KeyBinding trailerToggle, wagonToggle, other;
    public static KeyBinding arrow_up, arrow_down, arrow_left, arrow_right;
    public static final String category = "FVTM Controls";

    public KeyHandler(){
        this.minecraft = Minecraft.getMinecraft();
        ClientRegistry.registerKeyBinding(engineToggle = new KeyBinding("fvtm:engine", Keyboard.KEY_LCONTROL, category));
        ClientRegistry.registerKeyBinding(openInventory = new KeyBinding("fvtm:vehicle_inventory", Keyboard.KEY_R, category));
        ClientRegistry.registerKeyBinding(doorToggle = new KeyBinding("fvtm:vehicle_doors", Keyboard.KEY_K, category));
        ClientRegistry.registerKeyBinding(scriptsGUI = new KeyBinding("fvtm:vehicle_scripts", Keyboard.KEY_G, category));
        ClientRegistry.registerKeyBinding(lightsToggle = new KeyBinding("fvtm:vehicle_lights", Keyboard.KEY_L, category));
        ClientRegistry.registerKeyBinding(trailerToggle = new KeyBinding("fvtm:vehicle_trailer", Keyboard.KEY_0, category));
        ClientRegistry.registerKeyBinding(wagonToggle = new KeyBinding("fvtm:vehicle_wagon", Keyboard.KEY_MINUS, category));
        ClientRegistry.registerKeyBinding(arrow_up = new KeyBinding("fvtm:arrow_up", Keyboard.KEY_UP, category));
        ClientRegistry.registerKeyBinding(arrow_down = new KeyBinding("fvtm:arrow_down", Keyboard.KEY_DOWN, category));
        ClientRegistry.registerKeyBinding(arrow_left = new KeyBinding("fvtm:arrow_left", Keyboard.KEY_LEFT, category));
        ClientRegistry.registerKeyBinding(arrow_right = new KeyBinding("fvtm:arrow_right", Keyboard.KEY_RIGHT, category));
        ClientRegistry.registerKeyBinding(other = new KeyBinding("fvtm:other", Keyboard.KEY_COLON, category));
    }

    //TODO subscribe key-input event
    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event){
        switch(event.phase){
            case START: { break; }
            case END: {
                if(minecraft.player == null || minecraft.world == null){ return; }
                if(minecraft.player.getRidingEntity() instanceof SeatEntity && minecraft.currentScreen == null){
                    minecraft.displayGuiScreen(new VehicleSteeringOverlay((SeatEntity)minecraft.player.getRidingEntity()));
                } break;
            }
        }
    }

}
