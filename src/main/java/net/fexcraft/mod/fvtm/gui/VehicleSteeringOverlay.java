package net.fexcraft.mod.fvtm.gui;

import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_BACK;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_FALSE;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_TRI0;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_TRI1;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_TRUE;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.handler.KeyHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;

public class VehicleSteeringOverlay extends GuiScreen {

	public static boolean toggables, resetview, uni12;
	public static int scroll = 0, page, timer, clicktimer, oldview;// TODO replace to something fps independent
	private SeatCache seat;
	//
	private static final RGB HOVER = new RGB(RGB.GREEN);
	static{ HOVER.alpha = 0.5f; }
	private static final int perpage = 8;
	private static VehicleSteeringOverlay instance;
	private static ArrayList<Attribute<?>> attributes = new ArrayList<>();

	public VehicleSteeringOverlay(EntityPlayerSP player){
		super();
		this.seat = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
		uni12 = seat.vehicle instanceof ULandVehicle;
		instance = this;
	}

	@Override
	public void initGui(){
		// TODO see about alternative camera
		scroll = 0;
		page = 0;
		attributes.clear();
		toggables = false;
		Print.debug(seat, seat.seatdata);
		if(resetview) oldview = mc.gameSettings.thirdPersonView;
		resetview = true;
		mc.gameSettings.thirdPersonView = seat.seatdata.getViewValue(oldview, false);
		lastgear = 100;
	}

	@Override
	public void onGuiClosed(){
		mc.mouseHelper.ungrabMouseCursor();
		mc.setRenderViewEntity(mc.player);
		if(resetview) resetView();
	}

	public static void resetView(){
		net.minecraft.client.Minecraft.getMinecraft().gameSettings.thirdPersonView = oldview;
		resetview = true;
	}

	@Override
	public void handleMouseInput(){
		EntityPlayer player = (EntityPlayer)seat.passenger();
		if(player != mc.player){
			mc.displayGuiScreen(null);
			return;
		}
		int wheel = Mouse.getDWheel();
		if(wheel != 0){
			if(toggables){
				scroll(wheel, false);
			}
			else player.inventory.changeCurrentItem(wheel);
		}
		//
		// TODO toggables
		if(Mouse.isButtonDown(0)){
			if(toggables) processToggleClick(1);
			else seat.onKeyPress(KeyPress.MOUSE_MAIN, player);
		}
		if(Mouse.isButtonDown(1)){
			if(toggables) processToggleClick(-1);
			else seat.onKeyPress(KeyPress.MOUSE_RIGHT, player);
		}
	}

	private void scroll(int wheel, boolean usetimer){
		if(usetimer) if(timer > 0) return;
		scroll += wheel > 0 ? -1 : 1;
		if(scroll >= perpage) scroll = 0;
		if(scroll < 0) scroll = 0; // 0 was -1;
		if(usetimer) timer = 10;
	}

	private void page(int am){
		if(timer > 0) return;
		page += am;
		if(page > attributes.size() / perpage) page = 0;
		if(page < 0) page = 0;
		timer = 15;
		scroll = 0;
	}

	private void processToggleClick(int i){
		if(scroll < 0 || scroll > perpage) return;
		if(clicktimer > 0) return;
		NBTTagCompound packet = new NBTTagCompound();
		Attribute<?> attr = attributes.get((page * perpage) + scroll);
		packet.setString("target_listener", "fvtm:gui");
		packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id());
		if(i > 1) packet.setBoolean("reset", true);
		packet.setBoolean("bool", !attr.type().isBoolean() ? i < 0 : i > 0);
		packet.setInteger("entity", seat.vehicle.getEntityId());
		Print.debug(packet);
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		clicktimer += 10;
	}

	@Override
	protected void keyTyped(char c, int i){
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
				mc.gameSettings.thirdPersonView = seat.seatdata.getViewValue(mc.gameSettings.thirdPersonView, true);
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
			resetview = false;
			mc.displayGuiScreen(new GuiInventory(mc.player));
		}
		if(i == mc.gameSettings.keyBindDrop.getKeyCode()){
			mc.player.getHeldItem(EnumHand.MAIN_HAND);
		}
		if(i == mc.gameSettings.keyBindChat.getKeyCode()){
			resetview = false;
			mc.displayGuiScreen(new GuiChat());
		}
		if(i == mc.gameSettings.keyBindCommand.getKeyCode()){
			resetview = false;
			mc.displayGuiScreen(new GuiChat("/"));
		}
	}

	@Override
	public void updateScreen(){
		// TODO camera stuff, probably, maybe, possibly.
	}

	private int s = 0;

	@Override
	public void handleInput(){
		EntityPlayer player = (EntityPlayer)seat.passenger();
		if(player != mc.player){
			mc.displayGuiScreen(null);
			return;
		}
		if(!Mouse.isGrabbed()){
			mc.mouseHelper.grabMouseCursor();
		}
		handleMouseInput();
		seat.onMouseMoved(Mouse.getDX(), Mouse.getDY());
		for(; Keyboard.next();){
			try{
				handleKeyboardInput();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		if(seat != null && seat.passenger() instanceof EntityPlayer){
			if(isKeyDown(mc.gameSettings.keyBindForward.getKeyCode())){
				seat.onKeyPress(seat.vehicle.getVehicleType().isAirVehicle() ? KeyPress.TURN_DOWN : KeyPress.ACCELERATE, player);
			}
			if(isKeyDown(mc.gameSettings.keyBindBack.getKeyCode())){
				seat.onKeyPress(seat.vehicle.getVehicleType().isAirVehicle() ? KeyPress.TURN_UP : KeyPress.DECELERATE, player);
			}
			if(isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode())){
				seat.onKeyPress(KeyPress.TURN_LEFT, player);
			}
			if(isKeyDown(mc.gameSettings.keyBindRight.getKeyCode())){
				seat.onKeyPress(KeyPress.TURN_RIGHT, player);
			}
			if(isKeyDown(KeyHandler.arrow_up.getKeyCode())){
				if(toggables) scroll(1, true);
				else seat.onKeyPress(seat.vehicle.getVehicleType().isAirVehicle() ? KeyPress.ACCELERATE : KeyPress.GEAR_UP, player);
			}
			if(isKeyDown(KeyHandler.arrow_down.getKeyCode())){
				if(toggables) scroll(-1, true);
				else seat.onKeyPress(seat.vehicle.getVehicleType().isAirVehicle() ? KeyPress.DECELERATE : KeyPress.GEAR_DOWN, player);
			}
			if(isKeyDown(KeyHandler.arrow_left.getKeyCode())){
				if(toggables) page(-1);
				else seat.onKeyPress(KeyPress.ROLL_LEFT, player);
			}
			if(isKeyDown(KeyHandler.arrow_right.getKeyCode())){
				if(toggables) page(1);
				else seat.onKeyPress(KeyPress.ROLL_RIGHT, player);
			}
			if(uni12){
				if(isKeyDown(KeyHandler.pbrake.getKeyCode())){
					seat.onKeyPress(KeyPress.PBRAKE, player);
				}
				boolean state = isKeyDown(KeyHandler.brake.getKeyCode());
				if(state != seat.vehicle.getKeyPressState(KeyPress.BRAKE)){
					seat.vehicle.onKeyPress(KeyPress.BRAKE, seat.seatdata, player, state);
				}
			}
			else{
				if(/*isKeyDown(mc.gameSettings.keyBindJump.getKeyCode()) ||*/ isKeyDown(KeyHandler.brake.getKeyCode())){
					seat.onKeyPress(KeyPress.BRAKE, player);
				}
			}
			if(isKeyDown(KeyHandler.engineToggle.getKeyCode())){
				seat.onKeyPress(KeyPress.ENGINE, player);
			}
			if(isKeyDown(mc.gameSettings.keyBindSneak.getKeyCode())){
				seat.onKeyPress(KeyPress.DISMOUNT, player);
			}
			if(isKeyDown(KeyHandler.openInventory.getKeyCode())){
				resetview = false;
				seat.onKeyPress(KeyPress.INVENTORY, player);
			}
			if(isKeyDown(KeyHandler.doorToggle.getKeyCode())){
				seat.onKeyPress(KeyPress.TOGGABLES, player);
			}
			if(isKeyDown(KeyHandler.scriptsGUI.getKeyCode())){
				resetview = false;
				seat.onKeyPress(KeyPress.SCRIPTS, player);
			}
			if(isKeyDown(KeyHandler.lightsToggle.getKeyCode())){
				seat.onKeyPress(KeyPress.LIGHTS, player);
			}
			if(isKeyDown(KeyHandler.trailerToggle.getKeyCode())){
				seat.onKeyPress(KeyPress.COUPLER_REAR, player);
			}
			if(isKeyDown(KeyHandler.wagonToggle.getKeyCode())){
				seat.onKeyPress(KeyPress.COUPLER_FRONT, player);
			}
			if(isKeyDown(KeyHandler.reset.getKeyCode())){
				if(toggables) processToggleClick(2);
				else seat.onKeyPress(KeyPress.RESET, player);
			}
			if(s > 0){
				s--;
			}
			if(s == 0){
				seat.onKeyPress(null, player);
				s = 4;
				/* //5//20//10//4 */ }
		}
		else{
			mc.displayGuiScreen(null);
		}
	}

	public boolean isKeyDown(int keycode){
		return keycode < 0 ? Mouse.isButtonDown(keycode + 100) : keycode > 255 ? /* invalid code - PASS */ false : Keyboard.isKeyDown(keycode);
	}

	public static final ResourceLocation ENGINE_MISSING = new ResourceLocation("fvtm:textures/gui/icons/engine_missing.png");
	public static final ResourceLocation ENGINE_ON = new ResourceLocation("fvtm:textures/gui/icons/engine_on.png");
	public static final ResourceLocation ENGINE_OFF = new ResourceLocation("fvtm:textures/gui/icons/engine_off.png");
	public static final ResourceLocation INDICATOR_LEFT_OFF = new ResourceLocation("fvtm:textures/gui/icons/indicator_left.png");
	public static final ResourceLocation INDICATOR_LEFT_ON = new ResourceLocation("fvtm:textures/gui/icons/indicator_left_glow.png");
	public static final ResourceLocation INDICATOR_RIGHT_OFF = new ResourceLocation("fvtm:textures/gui/icons/indicator_right.png");
	public static final ResourceLocation INDICATOR_RIGHT_ON = new ResourceLocation("fvtm:textures/gui/icons/indicator_right_glow.png");
	public static final ResourceLocation LIGHTS_LOW_OFF = new ResourceLocation("fvtm:textures/gui/icons/lights_low_off.png");
	public static final ResourceLocation LIGHTS_LOW_ON = new ResourceLocation("fvtm:textures/gui/icons/lights_low_on.png");
	public static final ResourceLocation LIGHTS_HIGH_OFF = new ResourceLocation("fvtm:textures/gui/icons/lights_high_off.png");
	public static final ResourceLocation LIGHTS_HIGH_ON = new ResourceLocation("fvtm:textures/gui/icons/lights_high_on.png");
	public static final ResourceLocation LIGHTS_FOG_OFF = new ResourceLocation("fvtm:textures/gui/icons/lights_fog_off.png");
	public static final ResourceLocation LIGHTS_FOG_ON = new ResourceLocation("fvtm:textures/gui/icons/lights_fog_on.png");
	public static final ResourceLocation PBRAKE_OFF = new ResourceLocation("fvtm:textures/gui/icons/pbrake_off.png");
	public static final ResourceLocation PBRAKE_ON = new ResourceLocation("fvtm:textures/gui/icons/pbrake_on.png");
	public static final ResourceLocation BRAKE_OFF = new ResourceLocation("fvtm:textures/gui/icons/brake_off.png");
	public static final ResourceLocation BRAKE_ON = new ResourceLocation("fvtm:textures/gui/icons/brake_on.png");

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		GenericVehicle ent = seat.vehicle;
		if(ent == null){ return; }
		VehicleData data = ent.getVehicleData();
		if(data == null) return;
		GL11.glPushMatrix();
		this.mc.getTextureManager().bindTexture(ConstructorGui.STONE);
		this.drawTexturedModalRect(0, 0, 0, 0, this.width, 34);
		boolean noengine = false;
		if(!data.hasPart("engine") || !data.getPart("engine").hasFunction("fvtm:engine")){
			this.mc.getTextureManager().bindTexture(ENGINE_MISSING);
			noengine = true;
		}
		else{
			this.mc.getTextureManager().bindTexture(data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() ? ENGINE_ON : ENGINE_OFF);
		}
		drawRectIcon(width - 33, 1, 32, 32);
		//
		if(!ent.isRailType()){
			//this.mc.getTextureManager().bindTexture(ConstructorGui.ANVIL);
			//drawRectIcon(width - 97 - 16, 1, 80, 16);
			boolean turnleft = DefaultPrograms.BLINKER_TOGGLE && (data.getTurnLightLeft() || data.getWarningLights());
			mc.getTextureManager().bindTexture(turnleft ? INDICATOR_LEFT_ON : INDICATOR_LEFT_OFF);
			drawRectIcon(width - 97 - 16, 1, 16, 16);
			boolean turnright = DefaultPrograms.BLINKER_TOGGLE && (data.getTurnLightRight() || data.getWarningLights());
			mc.getTextureManager().bindTexture(turnright ? INDICATOR_RIGHT_ON : INDICATOR_RIGHT_OFF);
			drawRectIcon(width - 65 + 16, 1, 16, 16);
			//
			mc.getTextureManager().bindTexture(data.getAttribute("lights").getBooleanValue() ? LIGHTS_LOW_ON : LIGHTS_LOW_OFF);
			drawRectIcon(width - 97 + 32, 1, 16, 16);
			mc.getTextureManager().bindTexture(data.getAttribute("lights_long").getBooleanValue() ? LIGHTS_HIGH_ON : LIGHTS_HIGH_OFF);
			drawRectIcon(width - 97 + 16, 1, 16, 16);
			mc.getTextureManager().bindTexture(data.getAttribute("lights_fog").getBooleanValue() ? LIGHTS_FOG_ON : LIGHTS_FOG_OFF);
			drawRectIcon(width - 97, 1, 16, 16);
			//
			if(uni12){
				mc.getTextureManager().bindTexture(((ULandVehicle)seat.vehicle).pbrake ? PBRAKE_ON : PBRAKE_OFF);
				drawRectIcon(width - 97 - 34, 1, 16, 16);
				mc.getTextureManager().bindTexture(((ULandVehicle)seat.vehicle).braking ? BRAKE_ON : BRAKE_OFF);
				drawRectIcon(width - 97 - 50, 1, 16, 16);
			}
		}
		//
		if(!attributes.isEmpty()){
			int offset = 0;
			for(int j = 0; j < perpage; j++){
				int i = page * perpage + j;
				if(i >= attributes.size()){
					if(scroll >= j) scroll = j - 1;
					break;
				}
				Attribute<?> attr = attributes.get(i);
				offset = j * 12 + 34;
				mc.renderEngine.bindTexture(ICON_BOOL_BACK);
				if(attr.type().isTristate()){
					int width = fontRenderer.getStringWidth(attr.id());
					if(scroll == j) HOVER.glColorApply();
					this.drawTexturedModalRect(this.width - width - 14, offset, 0, 0, width + 2, 12);
					if(scroll == j) RGB.glColorReset();
					mc.fontRenderer.drawString(attr.id(), this.width - width - 12, offset + 3, 0xffffff);
					if(attr.type().isBoolean()){
						mc.renderEngine.bindTexture(attr.getBooleanValue() ? ICON_BOOL_TRUE : ICON_BOOL_FALSE);
					}
					else{
						Boolean bool = attr.getTriStateValue();
						mc.renderEngine.bindTexture(bool == null ? ICON_BOOL_FALSE : bool ? ICON_BOOL_TRI1 : ICON_BOOL_TRI0);
					}
					drawRectIcon(this.width - 12, offset, 12, 12);
				}
				else{
					String str = attr.id() + " - " + attr.getFloatValue();
					int width = fontRenderer.getStringWidth(str);
					if(scroll == j) HOVER.glColorApply();
					this.drawTexturedModalRect(this.width - width - 2, offset, 0, 0, width + 2, 12);
					if(scroll == j) RGB.glColorReset();
					mc.fontRenderer.drawString(str, this.width - width, offset + 3, 0xffffff);
				}
			}
			if(attributes.size() > 8){
				mc.renderEngine.bindTexture(ICON_BOOL_BACK);
				String string = "Page " + (page + 1) + "/" + (attributes.size() / perpage + 1);
				int width = fontRenderer.getStringWidth(string) + 4;
				this.drawTexturedModalRect(this.width - width, offset + 12, 0, 0, width, 12);
				mc.fontRenderer.drawString(string, this.width - width + 2, offset + 15, 0xffffff);
			}
		}
		//
		if(timer > 0) timer--;
		if(clicktimer > 0) clicktimer--;
		//
		if(noengine){
			mc.fontRenderer.drawString("No Engine installed.", 7, 7, 0xffffff);
			GL11.glPopMatrix();
			return;
		}
		mc.fontRenderer.drawString(Formatter.format("Speed: " + format((int)ent.getSpeed())), 7, 3, 0xffffff);
		mc.fontRenderer.drawString(Formatter.format("Fuel: " + fuelColour(ent.getVehicleData()) + format(ent.getVehicleData().getStoredFuel()) + "&f/&b" + ent.getVehicleData().getFuelCapacity()), 7, 25, 0xffffff);
		if(!ent.isRailType() && ent.getCoupledEntity(false) != null){
			mc.fontRenderer.drawString(Formatter.format("&a&oTrailer Attached."), 7, 40, 0xffffff);
		}
		if(uni12){
			mc.fontRenderer.drawString(Formatter.format("Throttle: "), 7, 14, 0xffffff);
			{
				RGB.BLACK.glColorApply();
				this.mc.getTextureManager().bindTexture(ConstructorGui.STONE);
				this.drawTexturedModalRect(59, 13, 0, 0, 102, 10);
				RGB.glColorReset();
				(ent.throttle > 0.8 ? ConstructorGui.RGB_ORANGE : RGB.GREEN).glColorApply();
				this.drawTexturedModalRect(60, 14, 0, 0, (int)(ent.throttle * 100), 8);
				RGB.glColorReset();
			}
			ULandVehicle veh = (ULandVehicle)seat.vehicle;
			int gear = veh.getVehicleData().getAttributeInteger("gear", 0);
			if(lastgear != gear){
				lastgear = gear;
				boolean auto = veh.transmission != null && veh.transmission.isAutomatic();
				gear_label = veh.transmission != null && veh.transmission.isAutomatic() && gear != 0 ? "A" : "";
				if(gear < 0){
					gear_label = (auto ? "A-" : "") + "R" + (veh.transmission.getRGearAmount() == 1 ? "" : -gear);
				}
				else if(gear == 0){
					gear_label = "N";
				}
				else{
					gear_label += gear;
				}
			}
			mc.fontRenderer.drawString(Formatter.format("RPM: " + (veh.crpm / 100 * 100)), 167, 3, 0xffffff);
			mc.fontRenderer.drawString(Formatter.format("Gear: " + gear_label), 167, 14, 0xffffff);
		}
		else{
			mc.fontRenderer.drawString(Formatter.format("Throttle: " + throttleColour(ent.throttle) + pc(ent.throttle) + "%"), 7, 14, 0xffffff);
		}
		if(Command.OTHER && seat.vehicle.wheels != null){
			for(int i = 0; i < seat.vehicle.wheels.length; i++){
				WheelEntity wheel = seat.vehicle.wheels[i];
				mc.fontRenderer.drawString(Formatter.format(wheel == null ? "none" : wheel.slot == null ? "no_slot" : (wheel.slot.steering() ? "steering, " : "") + (wheel.slot.powered(seat.vehicle.getVehicleData()) ? "powered" : "idle")), 7, 62 + (i * 11), 0xffffff);
			}
		}
		else if(STRS.size() > 0){
			int i = 0;
			for(String str : STRS){
				mc.fontRenderer.drawString(Formatter.format(str), 7, 62 + (i++ * 11), 0xffffff);
			}
		}
		GL11.glPopMatrix();
	}
	
	public static CopyOnWriteArrayList<String> STRS = new CopyOnWriteArrayList<String>();
	private static String gear_label;
	private static int lastgear = -100;

	public static void drawRectIcon(int x, int y, int width, int height){
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos(x, y + height, 0).tex(0, 1).endVertex();
		bufferbuilder.pos(x + width, y + height, 0).tex(1, 1).endVertex();
		bufferbuilder.pos(x + width, y, 0).tex(1, 0).endVertex();
		bufferbuilder.pos(x, y, 0).tex(0, 0).endVertex();
		tessellator.draw();
	}

	private String fuelColour(VehicleData data){
		double d = data.getStoredFuel() / data.getFuelCapacity();
		return d < 0.3 ? d < 0.1 ? "&c" : "&e" : "&a";
	}

	private String throttleColour(double throttle){
		if(throttle > 0.7){ return throttle > 0.9 ? "&c" : "&e"; }
		if(throttle < -0.7){ return throttle < -0.9 ? "&c" : "&e"; }
		return "&f";
	}

	private String pc(double f){
		return format(f * 100);
	}

	private static final DecimalFormat df = new DecimalFormat("##.##");
	// static { df.setRoundingMode(RoundingMode.DOWN); }

	public static String format(double d){
		return df.format(d);
	}

	public static final float calculateSpeed(Entity ent){
		double dX = ent.posX - ent.prevPosX, dY = ent.posY - ent.prevPosY, dZ = ent.posZ - ent.prevPosZ;
		float speed = (float)Math.sqrt(dX * dX + dY * dY + dZ * dZ) * 1000F;// / 16F;
		return (speed /*= (int)(speed * 10F) / 10F*/) / 20f;
	}

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

	public static void toggle(){
		toggables = !toggables;
		attributes.clear();
		if(!toggables) return;
		Print.debug("Toggled " + (toggables ? "ON" : "OFF"));
		if(instance.seat == null || instance.seat.vehicle == null) return;
		for(Attribute<?> attr : instance.seat.vehicle.getVehicleData().getAttributes().values()){
			if(attr.seats().contains(instance.seat.seatdata.name)){
				attributes.add(attr);
			}
		}
	}

}
