package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class NoHotbar {
	
    @SubscribeEvent
    public static void render(RenderGameOverlayEvent.Pre event){
    	if(Minecraft.getMinecraft().player.getRidingEntity() instanceof VehicleEntity && event.getType() == ElementType.HOTBAR){
    		if(Minecraft.getMinecraft().gameSettings.hideGUI || Config.OVERLAY_ON_BOTTOM) event.setCanceled(true);
    	}
    }

}
