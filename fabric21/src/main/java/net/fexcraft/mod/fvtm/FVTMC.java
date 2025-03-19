package net.fexcraft.mod.fvtm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fcl.local.CraftingRenderer;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.render.ConstRenderer;
import net.fexcraft.mod.fvtm.render.FuelFillerRenderer;
import net.fexcraft.mod.fvtm.render.Renderer21;
import net.fexcraft.mod.fvtm.render.VehicleLiftRenderer;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;

import static net.fexcraft.mod.fcl.FCL.CRAFTING_ENTITY;

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
	}

}
