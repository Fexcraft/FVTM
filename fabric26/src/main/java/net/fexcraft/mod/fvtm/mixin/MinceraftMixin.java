package net.fexcraft.mod.fvtm.mixin;

import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.uni.inv.UniStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mixin(Minecraft.class)
public class MinceraftMixin {

	@Shadow
	public MultiPlayerGameMode gameMode;
	@Shadow
	public LocalPlayer player;
	@Shadow
	public ClientLevel level;

	@Shadow
	public int missTime;

	@Inject(at = @At("HEAD"), method = "startUseItem", cancellable = true)
	private void processRight(CallbackInfo ci){
		if(gameMode.isDestroying() || player.isHandsBusy()) return;
		ItemStack held = player.getMainHandItem();
		if(held.isItemEnabled(level.enabledFeatures())){
			if(InteractionHandler.handle(KeyPress.MOUSE_RIGHT, UniStack.getStack(held))){
				ci.cancel();
			}
		}
	}

	@Inject(at = @At("HEAD"), method = "startAttack", cancellable = true)
	private void processLeft(CallbackInfoReturnable<Boolean> cir){
		if(missTime > 0 || player.isHandsBusy()) return;
		ItemStack held = player.getMainHandItem();
		if(held.isItemEnabled(level.enabledFeatures())){
			if(InteractionHandler.handle(KeyPress.MOUSE_MAIN, UniStack.getStack(held))){
				cir.setReturnValue(true);
			}
		}
	}

}