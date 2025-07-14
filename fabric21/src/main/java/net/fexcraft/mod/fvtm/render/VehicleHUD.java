package net.fexcraft.mod.fvtm.render;

import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.ui.VehicleOverlay;
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
		if(vehicle == null || vehicle.data == null) return;
		VehicleOverlay.RS[] rs = VehicleOverlay.update(vehicle);
		for(VehicleOverlay.RS r : rs){
			gg.drawString(Minecraft.getInstance().font, r.str, r.x, r.y, 0xffffff);
		}
	}
	
}
