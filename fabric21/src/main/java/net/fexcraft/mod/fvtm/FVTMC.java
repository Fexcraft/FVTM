package net.fexcraft.mod.fvtm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FVTMC implements ClientModInitializer {

	private static boolean modelsloaded;

	@Override
	public void onInitializeClient(){
		EnvInfo.CLIENT = true;
		FvtmRegistry.CONFIG.addListener(DefaultPrograms::setupSignalTimer);
		Renderer.RENDERER = new Renderer21();
		GLO.SUPPLIER = (() -> new GLObject());
		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
			if(modelsloaded) return;
			FvtmResources.initModelSystem();
			if(DefaultPrograms.SIGNAL_TIMER[0] == null){
				DefaultPrograms.setupSignalTimer();
			}
			modelsloaded = true;
		});
		BlockEntityRenderers.register(Resources21.LIFT_ENTITY, context -> new VehicleLiftRenderer());
		BlockEntityRenderers.register(Resources21.CONST_ENTITY, context -> new ConstRenderer());
		BlockEntityRenderers.register(Resources21.FUELFILLER_ENTITY, context -> new FuelFillerRenderer());
		EntityRendererRegistry.register(Resources21.WHEEL_ENTITY, context -> new EmptyRenderer(context));
		EntityRendererRegistry.register(Resources21.VEHICLE_ENTITY, context -> new RVRenderer(context));
		EntityRendererRegistry.register(Resources21.RAIL_ENTITY, context -> new RVRenderer(context));
	}

}
