package net.fexcraft.mod.fvtm.render;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.ui.VehicleOverlay;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;

public class VehicleHUD implements HudElement {

	public static final Identifier ID = Identifier.parse("fvtm:vehicle");
	public static VehicleInstance vehicle;

	@Override
	public void extractRenderState(GuiGraphicsExtractor gg, DeltaTracker delta){
		if(Minecraft.getInstance().player.getVehicle() instanceof RootVehicle == false) return;
		vehicle = ((RootVehicle)Minecraft.getInstance().player.getVehicle()).vehicle;
		if(vehicle == null || vehicle.data == null) return;
		VehicleOverlay.RS[] rs = VehicleOverlay.update(vehicle);
		for(VehicleOverlay.RS r : rs){
			gg.text(Minecraft.getInstance().font, r.str, r.x, r.y, 0xffffffff);
		}
	}

}
