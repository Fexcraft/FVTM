package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.fexcraft.mod.fvtm.event.ClientEvents.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class InputEvents {

	@SubscribeEvent
	public static void clientTick(TickEvent.ClientTickEvent event){
		if(minecraft.player == null || minecraft.level == null) return;
		switch(event.phase){
			case START:{
				if(minecraft.player.getVehicle() instanceof RootVehicle){
					handleKeyboardInput();
				}
			}
			case END:{
				//
				break;
			}
		}
	}

	private static void handleKeyboardInput(){
		Passenger pass = UniEntity.getApp(minecraft.player, Passenger.class);
		EntityW player = pass.entity;
		SeatInstance seat = pass.getSeatOn();
		if(seat == null) return;
		boolean state = accelerate.isDown();
		if(state != seat.root.getKeyPressState(KeyPress.ACCELERATE)){
			seat.root.onKeyPress(KeyPress.ACCELERATE, seat.seat, player, state, false);
		}
		state = decelerate.isDown();
		if(state != seat.root.getKeyPressState(KeyPress.DECELERATE)){
			seat.root.onKeyPress(KeyPress.DECELERATE, seat.seat, player, state, false);
		}
		if(turn_left.isDown()){
			seat.onKeyPress(KeyPress.TURN_LEFT, player);
		}
		if(turn_right.isDown()){
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
		state = brake.isDown();
		if(state != seat.root.getKeyPressState(KeyPress.BRAKE)){
			seat.root.onKeyPress(KeyPress.BRAKE, seat.seat, player, state, false);
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

	@SubscribeEvent
	public static void clickEmpty(PlayerInteractEvent.RightClickEmpty event){
		if(event.getHand() == InteractionHand.MAIN_HAND){
			InteractionHandler.handle(KeyPress.MOUSE_RIGHT, UniStack.getStack(event.getItemStack()));
		}
	}

	@SubscribeEvent
	public static void clickEmpty(PlayerInteractEvent.LeftClickEmpty event){
		if(event.getHand() == InteractionHand.MAIN_HAND){
			InteractionHandler.handle(KeyPress.MOUSE_MAIN, UniStack.getStack(event.getItemStack()));
		}
	}

	@SubscribeEvent
	public static void clickItem(PlayerInteractEvent.RightClickItem event){
		if(!event.getLevel().isClientSide) return;
		if(event.getHand() == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_RIGHT, UniStack.getStack(event.getItemStack()))){
			event.setCanceled(true);
			event.setCancellationResult(InteractionResult.PASS);
		}
	}

	@SubscribeEvent
	public static void clickBlock(PlayerInteractEvent.RightClickBlock event){
		if(!event.getLevel().isClientSide) return;
		if(event.getHand() == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_RIGHT, UniStack.getStack(event.getItemStack()))){
			event.setCanceled(true);
			event.setCancellationResult(InteractionResult.PASS);
		}
	}

	@SubscribeEvent
	public static void clickBlock(PlayerInteractEvent.LeftClickBlock event){
		if(event.getHand() == InteractionHand.MAIN_HAND && InteractionHandler.handle(KeyPress.MOUSE_MAIN, UniStack.getStack(event.getItemStack()))){
			event.setCanceled(true);
			event.setCancellationResult(InteractionResult.PASS);
		}
	}

}
