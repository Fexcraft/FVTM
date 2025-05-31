package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.OVERLAY_ON_BOTTOM;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.sys.pro.ULandVehicle;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class NoHotbar {

	private static Minecraft mc;
	private static RootVehicle ent;
	private static String gear_label;
	private static int lastgear = 100;
	
    @SubscribeEvent
    public static void render(RenderGameOverlayEvent.Pre event){
		if(mc == null) mc = Minecraft.getMinecraft();
		if(mc.player.getRidingEntity() instanceof RootVehicle == false) return;
		ent = (RootVehicle)mc.player.getRidingEntity();
		if(event.getType() == ElementType.ALL){
			mc.fontRenderer.drawStringWithShadow("Fuel: " + ent.vehicle.data.getStoredFuel() + "/" + ent.vehicle.data.getFuelCapacity(), 10, 10, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("Throttle: " + RGB.df.format(ent.vehicle.throttle), 10, 18, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("Speed: " + RGB.df.format(ent.vehicle.speed), 10, 26, 0xffffff);
			if(ent instanceof ULandVehicle){
				ULandVehicle veh = (ULandVehicle)ent;
				int gear = veh.vehicle.data.getAttributeInteger("gear", 0);
				if(lastgear != gear){
					lastgear = gear;
					boolean auto = veh.vehicle.transmission != null && veh.vehicle.transmission.isAutomatic();
					gear_label = veh.vehicle.transmission != null && veh.vehicle.transmission.isAutomatic() && gear != 0 ? "A" : "";
					if(gear < 0){
						gear_label = (auto ? "A-" : "") + "R" + (veh.vehicle.transmission.getRGearAmount() == 1 ? "" : -gear);
					}
					else if(gear == 0){
						gear_label = "N";
					}
					else{
						gear_label += gear;
					}
				}
				mc.fontRenderer.drawStringWithShadow("RPM: " + (veh.crpm / 100 * 100), 10, 34, 0xffffff);
				mc.fontRenderer.drawStringWithShadow("Gear: " + gear_label, 10, 42, 0xffffff);
				mc.fontRenderer.drawStringWithShadow("Braking: " + (veh.vehicle.braking ? "yes" : "no"), 10, 50, 0xffffff);
				mc.fontRenderer.drawStringWithShadow("P-Brake: " + (veh.vehicle.pbrake ? "ON" : "OFF"), 10, 58, 0xffffff);
				mc.fontRenderer.drawStringWithShadow("Engine: " + (veh.vehicle.engine.isOn() ? "ON" : "OFF"), 10, 66, 0xffffff);
			}
		}
		/*if(event.getType() == ElementType.HOTBAR){
			if(mc.gameSettings.hideGUI || OVERLAY_ON_BOTTOM) event.setCanceled(true);
		}*/
    }

}
