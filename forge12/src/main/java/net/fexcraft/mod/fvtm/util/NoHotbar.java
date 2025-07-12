package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.ui.VehicleOverlay;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class NoHotbar {

	private static Minecraft mc;
	private static RootVehicle ent;
	
    @SubscribeEvent
    public static void render(RenderGameOverlayEvent.Pre event){
		if(mc == null) mc = Minecraft.getMinecraft();
		if(mc.player.getRidingEntity() instanceof RootVehicle == false) return;
		ent = (RootVehicle)mc.player.getRidingEntity();
		if(event.getType() == ElementType.ALL){
			VehicleOverlay.RS[] rs = VehicleOverlay.update(ent.vehicle);
			for(VehicleOverlay.RS r : rs){
				mc.fontRenderer.drawStringWithShadow(r.str, r.x, r.y, 0xffffffff);
			}
			/*if(Config.LAND_PROTOTYPE){
				pro = ent.vehicle.vm();
				int gear = ent.vehicle.data.getAttributeInteger("gear", 0);
				if(lastgear != gear){
					lastgear = gear;
					boolean auto = ent.vehicle.transmission != null && ent.vehicle.transmission.isAutomatic();
					if(gear < 0){
						gear_label = (auto ? "A-" : "") + "R" + (ent.vehicle.transmission.getRGearAmount() == 1 ? "" : -gear);
					}
					else if(gear == 0){
						gear_label = "N";
					}
					else{
						gear_label = ent.vehicle.transmission != null && ent.vehicle.transmission.isAutomatic() && gear != 0 ? "A" : "";
						gear_label += gear;
					}
				}
				mc.fontRenderer.drawStringWithShadow("RPM/F/T: " + (pro.rpm / 100 * 100) + " | " + ((int)(pro.force * 100) / 100) + " | " + ((int)(pro.torq * 100) / 100), 10, 50, 0xffffff);
				mc.fontRenderer.drawStringWithShadow("Gear: " + gear_label, 10, 60, 0xffffff);
				mc.fontRenderer.drawStringWithShadow("P-Brake: " + (ent.vehicle.pbrake ? "ON" : "OFF"), 10, 70, 0xffffff);
				if(pro.overloaded) mc.fontRenderer.drawStringWithShadow("Towing limit reached, vehicle is overloaded.", 10, 90, 0xffffff);
			}*/
		}
		/*if(event.getType() == ElementType.HOTBAR){
			if(mc.gameSettings.hideGUI || OVERLAY_ON_BOTTOM) event.setCanceled(true);
		}*/
    }

}
