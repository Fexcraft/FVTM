package net.fexcraft.mod.fvtm.gui;

import static net.fexcraft.mod.fvtm.Config.OVERLAY_ON_BOTTOM;

import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class NoHotbar {
	
    @SubscribeEvent
    public static void render(RenderGameOverlayEvent.Pre event){
    	if(Minecraft.getMinecraft().player.getRidingEntity() instanceof RootVehicle && event.getType() == ElementType.HOTBAR){
    		if(Minecraft.getMinecraft().gameSettings.hideGUI || OVERLAY_ON_BOTTOM) event.setCanceled(true);
    	}
    }

}
