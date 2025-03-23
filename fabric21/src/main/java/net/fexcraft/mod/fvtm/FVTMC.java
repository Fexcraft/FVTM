package net.fexcraft.mod.fvtm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.impl.Packets21;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.fvtm.util.SpawnPacket;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;

import static net.fexcraft.mod.fvtm.impl.Packets21.*;

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
		Packets21.PACKET_HANDLERS.add(() -> {
			ClientPlayNetworking.registerGlobalReceiver(SPAWN_PACKET_TYPE, (packet, context) -> {
				context.client().execute(() -> {
					Entity ent = context.player().level().getEntity(packet.entity());
					if(ent instanceof SpawnPacket.PacketEntity pe){
						pe.readSpawnData(packet.com());
					}
				});
			});
			registerClientPacket(TAG_PACKET_TYPE, HTL);
			registerClientPacket(VEHMOVE_PACKET_TYPE, HVM);
			registerClientPacket(VEHKEYPRESS_PACKET_TYPE, HVK);
			registerClientPacket(VEHKEYSTATE_PACKET_TYPE, HVKS);
			registerClientPacket(SEATUPDATE_PACKET_TYPE, HSU);
			registerClientPacket(SPUPDATE_PACKET_TYPE, HSPU);
		});
		UseBlockCallback.EVENT.register((player, world, hand, res) -> {
			if(hand == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_RIGHT, UniStack.getStack(player.getItemInHand(hand)))){
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		});
		UseItemCallback.EVENT.register((player, world, hand) -> {
			if(hand == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_RIGHT, UniStack.getStack(player.getItemInHand(hand)))){
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		});
		AttackBlockCallback.EVENT.register((player, world, hand, pos, dir) -> {
			if(hand == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_MAIN, UniStack.getStack(player.getItemInHand(hand)))){
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		});
	}

	public static <T extends CustomPacketPayload> void registerClientPacket(CustomPacketPayload.Type<T> type, PacketHandler ph){
		ClientPlayNetworking.registerGlobalReceiver(type, (packet, context) -> context.client().execute(ph.handleClient((PacketBase)packet, UniEntity.getEntity(context.player()))));
	}

}
