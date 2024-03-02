package net.fexcraft.mod.fvtm.gui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.AddonSteeringOverlay;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class VehicleSteeringOverlay extends GuiScreen {

	private static AddonSteeringOverlay overlay;
	private static VehicleSteeringOverlay instance;
	private SeatInstance seat;
	public boolean toggables, uni12;

	public VehicleSteeringOverlay(EntityPlayerSP player){
		super();
		seat = ((RootVehicle)player.getRidingEntity()).getSeatOf(player);
		//uni12 = seat.root instanceof ULandVehicle;
		instance = this;
		Class<? extends AddonSteeringOverlay> clazz = null;
		try{
			clazz = DefaultSteeringOverlay.class;
			overlay = clazz.getConstructor(VehicleSteeringOverlay.class, EntityPlayer.class).newInstance(this, player);
		}
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e){
			Print.debug("FAILED TO LOAD STEERING OVERLAY");
			Print.debug("CLASS: " + clazz);
			e.printStackTrace();
			Static.stop();
		}
	}

	@Override
	public void initGui(){
		// TODO see about alternative camera
		toggables = false;
		//if(resetview) oldview = mc.gameSettings.thirdPersonView;
		//resetview = true;
		//mc.gameSettings.thirdPersonView = seat.seatdata.getViewValue(oldview, false);
		overlay.init();
	}
	
	public static AddonSteeringOverlay overlay(){
		return overlay;
	}
	
	public static VehicleSteeringOverlay instance(){
		return instance;
	}
	
	public SeatInstance seat(){
		return seat;
	}

	@Override
	public void onGuiClosed(){
		mc.mouseHelper.ungrabMouseCursor();
		mc.setRenderViewEntity(mc.player);
		//if(resetview) resetView();
		overlay.guiClosed();
	}

	public void resetView(){
		//net.minecraft.client.Minecraft.getMinecraft().gameSettings.thirdPersonView = oldview;
		//resetview = true;
	}

	@Override
	public void handleMouseInput(){
		EntityPlayer player = seat.passenger().local();
		if(player != mc.player){
			mc.displayGuiScreen(null);
			return;
		}
		if(overlay.handleMouseInput()) return;
		//
		int wheel = Mouse.getDWheel();
		if(wheel != 0) overlay.scroll(wheel);
		//
		if(Mouse.isButtonDown(0)) overlay.mouseClick(0);
		if(Mouse.isButtonDown(1)) overlay.mouseClick(1);
	}

	@Override
	protected void keyTyped(char c, int i){
		if(overlay.keyTyped(c, i)) return;
		switch(i){
			case 1:{
				mc.displayGuiScreen(null);
				mc.displayInGameMenu();
				return;
			}
			case 59:{
				mc.gameSettings.hideGUI = !mc.gameSettings.hideGUI;
				return;
			}
			case 61:{
				mc.gameSettings.showDebugInfo = !mc.gameSettings.showDebugInfo;
				return;
			}
			case 63:{
				////mc.gameSettings.thirdPersonView = seat.seatdata.getViewValue(mc.gameSettings.thirdPersonView, true);
				/*if(mc.gameSettings.thirdPersonView == 1){
					mc.setRenderViewEntity(mc.player);
				}
				else{
					mc.setRenderViewEntity(mc.player);
				}*/
				mc.setRenderViewEntity(mc.player);
				// Print.chat(mc.player, mc.gameSettings.thirdPersonView);
				return;
			}
			case 66:{
				mc.gameSettings.smoothCamera = !mc.gameSettings.smoothCamera;
				return;
			}
			default:
				break;
		}
		if(i == mc.gameSettings.keyBindInventory.getKeyCode()){
			//resetview = false;
			mc.displayGuiScreen(new GuiInventory(mc.player));
		}
		if(i == mc.gameSettings.keyBindDrop.getKeyCode()){
			mc.player.getHeldItem(EnumHand.MAIN_HAND);
		}
		if(i == mc.gameSettings.keyBindChat.getKeyCode()){
			//resetview = false;
			mc.displayGuiScreen(new GuiChat());
		}
		if(i == mc.gameSettings.keyBindCommand.getKeyCode()){
			//resetview = false;
			mc.displayGuiScreen(new GuiChat("/"));
		}
	}

	@Override
	public void updateScreen(){
		overlay.updateScreen();
		// TODO camera stuff, probably, maybe, possibly.
	}

	private int s = 0;

	@Override
	public void handleInput(){
		EntityPlayer player = (EntityPlayer)seat.passenger_direct();
		if(player != mc.player){
			mc.displayGuiScreen(null);
			return;
		}
		if(!Mouse.isGrabbed()) mc.mouseHelper.grabMouseCursor();
		handleMouseInput();
		//TODO seat.onMouseMoved(Mouse.getDX(), Mouse.getDY());
		for(;Keyboard.next();){
			try{
				handleKeyboardInput();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		if(seat != null && seat.passenger().isPlayer()){
			overlay.handleKeyboardInput();
			if(s > 0){
				s--;
			}
			if(s == 0){
				seat.onKeyPress(null, player.getCapability(Capabilities.PASSENGER, null).asWrapper());
				s = 4;/* //5//20//10//4 */
			}
		}
		else{
			mc.displayGuiScreen(null);
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		if(mc.gameSettings.hideGUI) return;
		VehicleInstance ent = seat.root;
		if(ent == null) return;
		VehicleData data = ent.data;
		if(data == null) return;
		GL11.glPushMatrix();
		overlay.drawScreen(mouseX, mouseY, partialTicks, ent.entity.local(), data);
	}

	public void drawRectIcon(int x, int y, int width, int height){
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos(x, y + height, 0).tex(0, 1).endVertex();
		bufferbuilder.pos(x + width, y + height, 0).tex(1, 1).endVertex();
		bufferbuilder.pos(x + width, y, 0).tex(1, 0).endVertex();
		bufferbuilder.pos(x, y, 0).tex(0, 0).endVertex();
		tessellator.draw();
	}

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

	public FontRenderer fontRenderer(){
		return fontRenderer;
	}

	public static final float calculateSpeed(Entity ent){
		double dX = ent.posX - ent.prevPosX, dY = ent.posY - ent.prevPosY, dZ = ent.posZ - ent.prevPosZ;
		float speed = (float)Math.sqrt(dX * dX + dY * dY + dZ * dZ) * 1000F;// / 16F;
		return (speed /*= (int)(speed * 10F) / 10F*/) / 20f;
	}

	public static void toggle(){
		instance.toggables = !instance.toggables;
		overlay.onToggablesToggle();
	}

}
