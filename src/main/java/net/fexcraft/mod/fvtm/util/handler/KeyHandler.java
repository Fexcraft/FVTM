package net.fexcraft.mod.fvtm.util.handler;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.gui.GuiVehicleController;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyHandler {

    private final Minecraft minecraft;
    public static KeyBinding engineToggle;
    public static KeyBinding openInventory;
    public static KeyBinding doorToggle, scriptsGUI, lightsToggle, trailerToggle, wagonToggle;
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
    }

    //TODO sunscribe keyinput event
    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event){
        switch(event.phase){
            case START: { break; }
            case END: {
                if(minecraft.player == null || minecraft.world == null){ return; }
                if(minecraft.player.getRidingEntity() instanceof SeatEntity && minecraft.currentScreen == null){
                    minecraft.displayGuiScreen(new GuiVehicleController((SeatEntity)minecraft.player.getRidingEntity()));
                } break;
            }
        }
    }

}
