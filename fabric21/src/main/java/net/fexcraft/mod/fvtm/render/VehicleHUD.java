package net.fexcraft.mod.fvtm.render;

import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class VehicleHUD implements IdentifiedLayer {

	public static final ResourceLocation ID = ResourceLocation.parse("fvtm:vehicle");
	public static VehicleInstance vehicle;
	
	@Override
	public ResourceLocation id(){
		return ID;
	}

	@Override
	public void render(GuiGraphics gg, DeltaTracker delta){
		if(Minecraft.getInstance().player.getVehicle() instanceof RootVehicle == false) return;
		vehicle = ((RootVehicle)Minecraft.getInstance().player.getVehicle()).vehicle;
		if(vehicle == null) return;
		gg.drawString(Minecraft.getInstance().font, "Throttle: " + round(vehicle.throttle), 10, 10, 0xffffff);
		gg.drawString(Minecraft.getInstance().font, "Steering: " + round(vehicle.steer_yaw), 10, 20, 0xffffff);
		gg.drawString(Minecraft.getInstance().font, "Speed: " + round(vehicle.speed), 10, 30, 0xffffff);
	}

	private static double round(double var){
		return (int)(var * 100) / 100D;
	}
	
}
