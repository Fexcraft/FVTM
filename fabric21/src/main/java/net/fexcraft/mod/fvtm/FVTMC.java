package net.fexcraft.mod.fvtm;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientChunkEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.impl.Packets21;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.BakingPlugin;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.fvtm.util.SpawnPacketEntity;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniChunk;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
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

	public static KeyMapping engine_toggle;
	public static KeyMapping inventory_open;
	public static KeyMapping control;
	public static KeyMapping script_ui;
	public static KeyMapping lights_toggle;
	public static KeyMapping trailer_toggle;
	public static KeyMapping wagon_toggle;
	public static KeyMapping reset;
	public static KeyMapping brake;
	public static KeyMapping pbrake;
	public static KeyMapping arrow_up;
	public static KeyMapping arrow_down;
	public static KeyMapping arrow_left;
	public static KeyMapping arrow_right;
	public static final String category = "keycompound.fvtm.controls";

	@Override
	public void onInitializeClient(){
		EnvInfo.CLIENT = true;
		FvtmRegistry.CONFIG.addListener(DefaultPrograms::setupSignalTimer);
		Renderer.RENDERER = new Renderer21();
		GLO.SUPPLIER = (() -> new GLObject());
		ClientLifecycleEvents.CLIENT_STARTED.register(server -> {
			FvtmResources.initModelSystem();
			if(DefaultPrograms.SIGNAL_TIMER[0] == null){
				DefaultPrograms.setupSignalTimer();
			}
		});
		BlockEntityRenderers.register(Resources21.CONST_ENTITY, context -> new ConstRenderer());
		BlockEntityRenderers.register(Resources21.FUELFILLER_ENTITY, context -> new FuelFillerRenderer());
		BlockEntityRenderers.register(Resources21.BASE_ENTITY, context -> new BaseBlockRenderer());
		BlockEntityRenderers.register(Resources21.JACK_ENTITY, context -> new BaseBlockRenderer());
		EntityRendererRegistry.register(Resources21.WHEEL_ENTITY, context -> new EmptyRenderer(context));
		EntityRendererRegistry.register(Resources21.VEHICLE_ENTITY, context -> new RVRenderer(context));
		EntityRendererRegistry.register(Resources21.RAIL_ENTITY, context -> new RVRenderer(context));
		EntityRendererRegistry.register(Resources21.ROAD_MARKER_ENTITY, context -> new RoadMarkerRenderer(context));
		EntityRendererRegistry.register(Resources21.RAIL_MARKER_ENTITY, context -> new RailMarkerRenderer(context));
		EntityRendererRegistry.register(Resources21.DECO_ENTITY, context -> new DecoRenderer(context));
		Packets21.PACKET_HANDLERS.add(() -> {
			registerClientPacket(TAG_PACKET_TYPE, HTL);
			registerClientPacket(VEHMOVE_PACKET_TYPE, HVM);
			registerClientPacket(VEHKEYPRESS_PACKET_TYPE, HVK);
			registerClientPacket(VEHKEYSTATE_PACKET_TYPE, HVKS);
			registerClientPacket(SEATUPDATE_PACKET_TYPE, HSU);
			registerClientPacket(SPUPDATE_PACKET_TYPE, HSPU);
			Packets21.INSTANCE.initClient();
		});
		//
		KeyBindingHelper.registerKeyBinding(engine_toggle = new KeyMapping("key.fvtm.engine", InputConstants.Type.KEYSYM, InputConstants.KEY_I, category));
		KeyBindingHelper.registerKeyBinding(inventory_open = new KeyMapping("key.fvtm.vehicle_inventory", InputConstants.Type.KEYSYM, InputConstants.KEY_R, category));
		KeyBindingHelper.registerKeyBinding(control = new KeyMapping("key.fvtm.vehicle_control", InputConstants.Type.KEYSYM, InputConstants.KEY_K, category));
		KeyBindingHelper.registerKeyBinding(script_ui = new KeyMapping("key.fvtm.vehicle_scripts", InputConstants.Type.KEYSYM, InputConstants.KEY_G, category));
		KeyBindingHelper.registerKeyBinding(lights_toggle = new KeyMapping("key.fvtm.vehicle_lights", InputConstants.Type.KEYSYM, InputConstants.KEY_U, category));
		KeyBindingHelper.registerKeyBinding(trailer_toggle = new KeyMapping("key.fvtm.vehicle_trailer", InputConstants.Type.KEYSYM, InputConstants.KEY_0, category));
		KeyBindingHelper.registerKeyBinding(wagon_toggle = new KeyMapping("key.fvtm.vehicle_wagon", InputConstants.Type.KEYSYM, InputConstants.KEY_MINUS, category));
		KeyBindingHelper.registerKeyBinding(arrow_up = new KeyMapping("key.fvtm.arrow_up", InputConstants.Type.KEYSYM, InputConstants.KEY_UP, category));
		KeyBindingHelper.registerKeyBinding(arrow_down = new KeyMapping("key.fvtm.arrow_down", InputConstants.Type.KEYSYM, InputConstants.KEY_DOWN, category));
		KeyBindingHelper.registerKeyBinding(arrow_left = new KeyMapping("key.fvtm.arrow_left", InputConstants.Type.KEYSYM, InputConstants.KEY_LEFT, category));
		KeyBindingHelper.registerKeyBinding(arrow_right = new KeyMapping("key.fvtm.arrow_right", InputConstants.Type.KEYSYM, InputConstants.KEY_RIGHT, category));
		KeyBindingHelper.registerKeyBinding(reset = new KeyMapping("key.fvtm.reset", InputConstants.Type.KEYSYM, InputConstants.KEY_SEMICOLON, category));
		KeyBindingHelper.registerKeyBinding(brake = new KeyMapping("key.fvtm.brake", InputConstants.Type.KEYSYM, InputConstants.KEY_SPACE, category));
		KeyBindingHelper.registerKeyBinding(pbrake = new KeyMapping("key.fvtm.pbrake", InputConstants.Type.KEYSYM, InputConstants.KEY_O, category));
		ClientTickEvents.END_CLIENT_TICK.register(mc -> handleKeyboardInput(mc));
		//
		AttackBlockCallback.EVENT.register((player, world, hand, pos, dir) -> {
			if(hand == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_MAIN, UniStack.getStack(player.getItemInHand(hand)))){
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
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
		ClientChunkEvents.CHUNK_LOAD.register((level, chunk) -> {
			SystemManager.onChunkLoad(WrapperHolder.getWorld(level), UniChunk.getChunk(chunk));
		});
		ClientChunkEvents.CHUNK_UNLOAD.register((level, chunk) -> {
			SystemManager.onChunkUnload(WrapperHolder.getWorld(level), UniChunk.getChunk(chunk));
		});
		ClientTickEvents.START_CLIENT_TICK.register(serv -> {
			SystemManager.onClientTick();
		});
		WorldRenderEvents.AFTER_ENTITIES.register(SignRenderer::renderSigns);
		WorldRenderEvents.AFTER_ENTITIES.register(SepRenderer::renderSeparate);
		WorldRenderEvents.AFTER_ENTITIES.register(VehicleRenderer::renderVehicles);
		WorldRenderEvents.AFTER_TRANSLUCENT.register(WireRenderer::renderWires);
		WorldRenderEvents.AFTER_TRANSLUCENT.register(RailRenderer::renderRails);
		WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register(RailRenderer::renderGrid);
		WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register(RailRenderer::renderRailPreview);
		WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register(RoadRenderer::renderRoadPreview);
		HudElementRegistry.attachElementAfter(VanillaHudElements.HOTBAR, VehicleHUD.ID, new VehicleHUD());

		ModelLoadingPlugin.register(new BakingPlugin());
	}

	public static <T extends CustomPacketPayload> void registerClientPacket(CustomPacketPayload.Type<T> type, PacketHandler ph){
		ClientPlayNetworking.registerGlobalReceiver(type, (packet, context) -> context.client().execute(ph.handleClient((PacketBase)packet, UniEntity.getEntity(context.player()))));
	}

	private static void handleKeyboardInput(Minecraft minecraft){
		if(minecraft.player == null || minecraft.player.getVehicle() instanceof RootVehicle == false) return;
		Passenger pass = UniEntity.getApp(minecraft.player, Passenger.class);
		EntityW player = pass.entity;
		SeatInstance seat = pass.getSeatOn();
		if(seat == null) return;
		boolean state = minecraft.options.keyUp.isDown();
		if(state != seat.root.getKeyPressState(KeyPress.ACCELERATE)){
			seat.onKeyPress(KeyPress.ACCELERATE, player, state);
		}
		state = minecraft.options.keyDown.isDown();
		if(state != seat.root.getKeyPressState(KeyPress.DECELERATE)){
			seat.onKeyPress(KeyPress.DECELERATE, player, state);
		}
		if(minecraft.options.keyLeft.isDown()){
			seat.onKeyPress(KeyPress.TURN_LEFT, player);
		}
		if(minecraft.options.keyRight.isDown()){
			seat.onKeyPress(KeyPress.TURN_RIGHT, player);
		}
		if(arrow_up.isDown()){
			seat.onKeyPress(seat.root.type.isAirVehicle() ? KeyPress.ACCELERATE : KeyPress.GEAR_UP, player);
		}
		if(arrow_down.isDown()){
			seat.onKeyPress(seat.root.type.isAirVehicle() ? KeyPress.DECELERATE : KeyPress.GEAR_DOWN, player);
		}
		if(arrow_left.isDown()){
			seat.onKeyPress(KeyPress.ROLL_LEFT, player);
		}
		if(arrow_right.isDown()){
			seat.onKeyPress(KeyPress.ROLL_RIGHT, player);
		}
		if(pbrake.isDown()){
			seat.onKeyPress(KeyPress.PBRAKE, player);
		}
		state = minecraft.options.keyJump.isDown() || brake.isDown();
		if(state != seat.root.getKeyPressState(KeyPress.BRAKE)){
			seat.onKeyPress(KeyPress.BRAKE, player, state);
		}
		if(engine_toggle.isDown()){
			seat.onKeyPress(KeyPress.ENGINE, player);
		}
		if(minecraft.options.keyShift.isDown()){
			seat.onKeyPress(KeyPress.DISMOUNT, player);
		}
		if(inventory_open.isDown()){
			seat.onKeyPress(KeyPress.INVENTORY, player);
		}
		if(control.isDown()){
			seat.onKeyPress(KeyPress.CONTROL, player);
		}
		if(script_ui.isDown()){
			seat.onKeyPress(KeyPress.SCRIPTS, player);
		}
		if(lights_toggle.isDown()){
			seat.onKeyPress(KeyPress.LIGHTS, player);
		}
		if(trailer_toggle.isDown()){
			seat.onKeyPress(KeyPress.COUPLER_REAR, player);
		}
		if(wagon_toggle.isDown()){
			seat.onKeyPress(KeyPress.COUPLER_FRONT, player);
		}
		if(reset.isDown()){
			seat.onKeyPress(KeyPress.RESET, player);
		}
	}

}
