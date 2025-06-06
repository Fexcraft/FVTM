
package net.fexcraft.mod.fvtm.event;


import com.mojang.blaze3d.platform.InputConstants;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.render.*;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class ClientEvents {

	protected static Minecraft minecraft;
	//
	public static KeyMapping accelerate;
	public static KeyMapping decelerate;
	public static KeyMapping turn_left;
	public static KeyMapping turn_right;
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

	@SubscribeEvent
	public static void clientInit(FMLClientSetupEvent event){
		EntityRenderers.register(FVTM4.DECORATION_ENTITY.get(), ctx -> new DecoRenderer(ctx));
		EntityRenderers.register(FVTM4.ROAD_MARKER_ENTITY.get(), ctx -> new RoadMarkerRenderer(ctx));
		EntityRenderers.register(FVTM4.RAIL_MARKER_ENTITY.get(), ctx -> new RailMarkerRenderer(ctx));
		EntityRenderers.register(FVTM4.WHEEL_ENTITY.get(), ctx -> new WheelRenderer(ctx));
		EntityRenderers.register(FVTM4.VEHICLE_ENTITY.get(), ctx -> new RVRenderer(ctx));
		EntityRenderers.register(FVTM4.RAILVEH_ENTITY.get(), ctx -> new RVRenderer(ctx));
		//
		minecraft = Minecraft.getInstance();
	}

	@SubscribeEvent
	public static void renderInit(EntityRenderersEvent.RegisterRenderers event){
		event.registerBlockEntityRenderer(FVTM4.LIFT_ENTITY.get(), con -> new VehicleLiftRenderer());
		event.registerBlockEntityRenderer(FVTM4.CONST_ENTITY.get(), con -> new ConstRenderer());
		event.registerBlockEntityRenderer(FVTM4.FUELFILLER_ENT.get(), con -> new FuelFillerRenderer());
		event.registerBlockEntityRenderer(FVTM4.BLOCK_ENTITY.get(), con -> new BaseBlockRenderer());
	}

	@SubscribeEvent
	public static void registerKeys(RegisterKeyMappingsEvent event){
		event.register(accelerate = new KeyMapping("key.fvtm.accelerate", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_W, category));
		event.register(decelerate = new KeyMapping("key.fvtm.decelerate", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_S, category));
		event.register(turn_left = new KeyMapping("key.fvtm.turn_left", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_A, category));
		event.register(turn_right = new KeyMapping("key.fvtm.turn_right", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_D, category));
		event.register(engine_toggle = new KeyMapping("key.fvtm.engine", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_I, category));
		event.register(inventory_open = new KeyMapping("key.fvtm.vehicle_inventory", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_R, category));
		event.register(control = new KeyMapping("key.fvtm.vehicle_control", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_K, category));
		event.register(script_ui = new KeyMapping("key.fvtm.vehicle_scripts", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_G, category));
		event.register(lights_toggle = new KeyMapping("key.fvtm.vehicle_lights", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_U, category));
		event.register(trailer_toggle = new KeyMapping("key.fvtm.vehicle_trailer", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_0, category));
		event.register(wagon_toggle = new KeyMapping("key.fvtm.vehicle_wagon", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_MINUS, category));
		event.register(arrow_up = new KeyMapping("key.fvtm.arrow_up", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_UP, category));
		event.register(arrow_down = new KeyMapping("key.fvtm.arrow_down", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_DOWN, category));
		event.register(arrow_left = new KeyMapping("key.fvtm.arrow_left", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_LEFT, category));
		event.register(arrow_right = new KeyMapping("key.fvtm.arrow_right", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_RIGHT, category));
		event.register(reset = new KeyMapping("key.fvtm.reset", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_SEMICOLON, category));
		event.register(brake = new KeyMapping("key.fvtm.brake", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_SPACE, category));
		event.register(pbrake = new KeyMapping("key.fvtm.pbrake", KeyConflictContext.VEHICLE, InputConstants.Type.KEYSYM, InputConstants.KEY_O, category));
	}

	public enum KeyConflictContext implements IKeyConflictContext {

		VEHICLE {
			@Override
			public boolean isActive(){
				return minecraft.player != null && minecraft.player.getVehicle() instanceof RootVehicle;
			}

			@Override
			public boolean conflicts(IKeyConflictContext other){
				return other != this;
			}
		}

	}

}