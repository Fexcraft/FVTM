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
			mc.fontRenderer.drawStringWithShadow("Throttle: " + tobar(ent.vehicle.throttle, 1, 'b') + RGB.df.format(ent.vehicle.throttle), 10, 20, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("Brake: " + tobar(ent.vehicle.brake, 1, 'c') + RGB.df.format(ent.vehicle.brake), 10, 30, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("Speed: " + RGB.df.format(ent.vehicle.speed * 72), 10, 40, 0xffffff);
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
			mc.fontRenderer.drawStringWithShadow("RPM/F/T: " + (ent.vehicle.md.rpm / 100 * 100) + " | " + ((int)(ent.vehicle.md.force * 100) / 100) + " | " + ((int)(ent.vehicle.torq * 100) / 100), 10, 50, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("Gear: " + gear_label, 10, 60, 0xffffff);
			//mc.fontRenderer.drawStringWithShadow("Braking: " + (ent.vehicle.braking ? "yes" : "no"), 10, 60, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("P-Brake: " + (ent.vehicle.pbrake ? "ON" : "OFF"), 10, 70, 0xffffff);
			mc.fontRenderer.drawStringWithShadow("Engine: " + (ent.vehicle.engine.isOn() ? "ON" : "OFF"), 10, 80, 0xffffff);
			if(ent.vehicle.md.overloaded) mc.fontRenderer.drawStringWithShadow("Towing limit reached, vehicle is overloaded.", 10, 90, 0xffffff);
		}
		/*if(event.getType() == ElementType.HOTBAR){
			if(mc.gameSettings.hideGUI || OVERLAY_ON_BOTTOM) event.setCanceled(true);
		}*/
    }

	private static String tobar(double val, int max, char code){
		double div = val / max * 10;
		int rou = (int)div;
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 10; i++){
			if(rou > i){
				str.append("\u00a7" + code + "\u2588");
			}
			else{
				str.append("\u00a7f\u2588");
			}
		}
		str.append(" \u00a7r");
		return str.toString();
	}

}
