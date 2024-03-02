package net.fexcraft.mod.fvtm.gui;

import static net.fexcraft.mod.fvtm.Config.OVERLAY_ON_BOTTOM;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.AddonSteeringOverlay;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.gui.construct.ConstGui;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.handler.KeyHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/**
 * Default Steering Overlay
 * 
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultSteeringOverlay extends AddonSteeringOverlay {

	public static final ResourceLocation OVERLAY_TEX = new ResourceLocation("fvtm:textures/gui/vehicle_overlay.png");
	
	public static final ResourceLocation ENGINE_MISSING = new ResourceLocation("fvtm:textures/gui/icons/engine_missing.png");
	public static final ResourceLocation ENGINE_ON = new ResourceLocation("fvtm:textures/gui/icons/engine_on.png");
	public static final ResourceLocation ENGINE_OFF = new ResourceLocation("fvtm:textures/gui/icons/engine_off.png");
	public static final ResourceLocation PBRAKE_OFF = new ResourceLocation("fvtm:textures/gui/icons/pbrake_off.png");
	public static final ResourceLocation PBRAKE_ON = new ResourceLocation("fvtm:textures/gui/icons/pbrake_on.png");
	public static final ResourceLocation BRAKE_OFF = new ResourceLocation("fvtm:textures/gui/icons/brake_off.png");
	public static final ResourceLocation BRAKE_ON = new ResourceLocation("fvtm:textures/gui/icons/brake_on.png");
	//
	public static String NO_ENGINE, SPEED, FUEL, TRAILER, THROTTLE, GEAR, RPM;
	//
	protected static final RGB HOVER = new RGB(0, 255, 0, 0.5f);
	protected static final int row = 9, row2 = row + row;
	protected static int scroll, page, timer, clicktimer, lastgear = -100;
	protected static ArrayList<Attribute<?>> attributes = new ArrayList<>();
	protected static ArrayList<String> hard_attr = new ArrayList<>(), offset = new ArrayList<>();
	protected static boolean turnsig = false, warnsig = false, railed;
	public static CopyOnWriteArrayList<Object> STRS = new CopyOnWriteArrayList<>();
	private static int maxspeed = 1;
	private static String gear_label;

	public DefaultSteeringOverlay(VehicleSteeringOverlay root, EntityPlayer player){
		super(root, player);
	}

	@Override
	public void init(){
		scroll = page = 0;
		lastgear = 100;
		NO_ENGINE = I18n.format("gui.fvtm.overlay.default.no_engine");
		SPEED = I18n.format("gui.fvtm.overlay.default.speed");
		FUEL = I18n.format("gui.fvtm.overlay.default.fuel");
		THROTTLE = I18n.format("gui.fvtm.overlay.default.throttle");
		GEAR = I18n.format("gui.fvtm.overlay.default.gear");
		RPM = I18n.format("gui.fvtm.overlay.default.rpm");
		TRAILER = I18n.format("gui.fvtm.overlay.default.trailer");
		//maxspeed = 1;
		loadAttrs();
		hard_attr.clear();
		turnsig = root.seat().root.data.getAttributes().containsKey("turn_lights");
		warnsig = root.seat().root.data.getAttributes().containsKey("warning_lights");
		if(turnsig) hard_attr.add("turn_lights");
		if(warnsig) hard_attr.add("warning_lights");
		railed = root.seat().root.type.isRailVehicle();
		hard_attr.add("lights_fog");
		hard_attr.add("lights_long");
		hard_attr.add("lights");
	}

	@Override
	public boolean handleMouseInput(){
		return false;
	}

	@Override
	public void scroll(int wheel){
		if(root.toggables){
			scroll += wheel > 0 ? -1 : 1;
			checkscr();
		}
		else playerentity.inventory.changeCurrentItem(wheel);
	}

	private void checkscr(){
		if(scroll >= row2){
			scroll = 0;
			page++;
		}
		else if(scroll < 0){
			scroll = row2 - 1;
			page--;
		}
		if(page < 0) page = 0;
		//
		int index = page * row2 + scroll;
		if(index < (root.uni12 ? 4 : 2)){
			Print.bar(root.mc.player, Formatter.format("&a" + offset.get(index)));
		}
		else{
			Attribute<?> attr = index < offset.size() ? root.seat().root.data.getAttribute(offset.get(index)) : getSoftAttr(index - offset.size());
			if(attr == null) return;
			Print.bar(root.mc.player, Formatter.format("&eA&7: &a" + attr.id + " &7: &b" + attr.asString()));
		}
	}

	private void scroll(int x, int y){
		if(timer > 0) return;
		if(x != 0) scroll += x;
		if(y != 0) page += y;
		checkscr();
		timer = 10;
	}

	@Override
	public void mouseClick(int button){
		if(button == 0){
			if(root.toggables) processToggleClick(1);
			else root.seat().onKeyPress(KeyPress.MOUSE_MAIN, player);
		}
		else if(button == 1){
			if(root.toggables) processToggleClick(-1);
			else root.seat().onKeyPress(KeyPress.MOUSE_RIGHT, player);
		}
	}

	protected void processToggleClick(int i){
		if(scroll < 0 || page < 0 || scroll >= row2) return;
		if(clicktimer > 0) return;
		NBTTagCompound packet = new NBTTagCompound();
		int index = page * row + scroll;
		if(index < 2) return;//TODO engine toggle support
		if((index == 1 || index == 2) && root.uni12) return;
		Attribute<?> attr = null;
		if(index < offset.size()){
			attr = root.seat().root.data.getAttribute(offset.get(index));
		}
		else{
			index -= offset.size();
			if(index >= attributes.size()) return;
			attr = getSoftAttr(index);
		}
		if(attr == null) return;
		packet.setString("target_listener", GuiHandler.LISTENERID);
		packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id);
		if(i > 1) packet.setBoolean("reset", true);
		packet.setBoolean("bool", !attr.valuetype.isBoolean() ? i < 0 : i > 0);
		packet.setInteger("entity", root.seat().root.entity.getId());
		Print.debug(packet);
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		clicktimer += 10;
	}
	
	public Attribute<?> getSoftAttr(int index){
		int i = 0;
		for(Attribute<?> attr : attributes){
			if(hard_attr.contains(attr.id)) continue;
			if(i == index) return attr;
			i++;
		}
		return null;
	}

	@Override
	public boolean keyTyped(char c, int key){
		return false;
	}

	@Override
	public void updateScreen(){
		//
	}

	@Override
	public void handleKeyboardInput(){
		if(isKeyDown(root.mc.gameSettings.keyBindForward.getKeyCode())){
			root.seat().onKeyPress(root.seat().root.type.isAirVehicle() ? KeyPress.TURN_DOWN : KeyPress.ACCELERATE, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindBack.getKeyCode())){
			root.seat().onKeyPress(root.seat().root.type.isAirVehicle() ? KeyPress.TURN_UP : KeyPress.DECELERATE, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindLeft.getKeyCode())){
			root.seat().onKeyPress(KeyPress.TURN_LEFT, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindRight.getKeyCode())){
			root.seat().onKeyPress(KeyPress.TURN_RIGHT, player);
		}
		if(isKeyDown(KeyHandler.arrow_up.getKeyCode())){
			if(root.toggables) scroll(0, -1);
			else root.seat().onKeyPress(root.seat().root.type.isAirVehicle() ? KeyPress.ACCELERATE : KeyPress.GEAR_UP, player);
		}
		if(isKeyDown(KeyHandler.arrow_down.getKeyCode())){
			if(root.toggables) scroll(0, 1);
			else root.seat().onKeyPress(root.seat().root.type.isAirVehicle() ? KeyPress.DECELERATE : KeyPress.GEAR_DOWN, player);
		}
		if(isKeyDown(KeyHandler.arrow_left.getKeyCode())){
			if(root.toggables) scroll(-1, 0);
			else root.seat().onKeyPress(KeyPress.ROLL_LEFT, player);
		}
		if(isKeyDown(KeyHandler.arrow_right.getKeyCode())){
			if(root.toggables) scroll(1, 0);
			else root.seat().onKeyPress(KeyPress.ROLL_RIGHT, player);
		}
		if(root.uni12){
			if(isKeyDown(KeyHandler.pbrake.getKeyCode())){
				root.seat().onKeyPress(KeyPress.PBRAKE, player);
			}
			boolean state = isKeyDown(KeyHandler.brake.getKeyCode());
			if(state != root.seat().root.getKeyPressState(KeyPress.BRAKE)){
				root.seat().root.onKeyPress(KeyPress.BRAKE, root.seat().seat, player, state);
			}
		}
		else{
			if(/*isKeyDown(root.mc.gameSettings.keyBindJump.getKeyCode()) ||*/ isKeyDown(KeyHandler.brake.getKeyCode())){
				root.seat().onKeyPress(KeyPress.BRAKE, player);
			}
		}
		if(isKeyDown(KeyHandler.engineToggle.getKeyCode())){
			root.seat().onKeyPress(KeyPress.ENGINE, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindSneak.getKeyCode())){
			root.seat().onKeyPress(KeyPress.DISMOUNT, player);
		}
		if(isKeyDown(KeyHandler.openInventory.getKeyCode())){
			//root.resetview = false;
			root.seat().onKeyPress(KeyPress.INVENTORY, player);
		}
		if(isKeyDown(KeyHandler.doorToggle.getKeyCode())){
			root.seat().onKeyPress(KeyPress.TOGGABLES, player);
		}
		if(isKeyDown(KeyHandler.scriptsGUI.getKeyCode())){
			//root.resetview = false;
			root.seat().onKeyPress(KeyPress.SCRIPTS, player);
		}
		if(isKeyDown(KeyHandler.lightsToggle.getKeyCode())){
			root.seat().onKeyPress(KeyPress.LIGHTS, player);
		}
		if(isKeyDown(KeyHandler.trailerToggle.getKeyCode())){
			root.seat().onKeyPress(KeyPress.COUPLER_REAR, player);
		}
		if(isKeyDown(KeyHandler.wagonToggle.getKeyCode())){
			root.seat().onKeyPress(KeyPress.COUPLER_FRONT, player);
		}
		if(isKeyDown(KeyHandler.reset.getKeyCode())){
			if(root.toggables) processToggleClick(2);
			else root.seat().onKeyPress(KeyPress.RESET, player);
		}
	}

	public boolean isKeyDown(int keycode){
		return keycode < 0 ? Mouse.isButtonDown(keycode + 100) : keycode > 255 ? /* invalid code - PASS */ false : Keyboard.isKeyDown(keycode);
	}

	@Override
	public void guiClosed(){
		//
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks, RootVehicle ent, VehicleData data){
		root.mc.getTextureManager().bindTexture(OVERLAY_TEX);
		int yoff = OVERLAY_ON_BOTTOM ? root.height - 40 : -5;
		root.drawTexturedModalRect(0, yoff, 0, 0, 256, OVERLAY_ON_BOTTOM ? 40 : 45);
		boolean wide = root.width > 256 + 158;
		if(wide){
			root.drawTexturedModalRect(root.width - 158, yoff, 0, root.toggables ? 166 : 211, 158, OVERLAY_ON_BOTTOM ? 40 : 45);
		}
		if(root.toggables) root.drawTexturedModalRect(root.width - 150 + (scroll % row * 16), yoff + 8 + (scroll >= row ? 16 : 0), 240, 240, 16, 16);
		boolean noengine = !data.hasPart("engine") || !data.getPart("engine").hasFunction("fvtm:engine");
		if(page == 0){
			if(noengine){
				root.mc.getTextureManager().bindTexture(ENGINE_MISSING);
			}
			else{
				root.mc.getTextureManager().bindTexture(data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() ? ENGINE_ON : ENGINE_OFF);
			}
			root.drawRectIcon(root.width - 150, yoff + 8, 16, 16);
			offset.clear();
			offset.add("engine");
			if(root.uni12){
				//TODO root.mc.getTextureManager().bindTexture(((ULandVehicle)root.seat().vehicle).braking ? BRAKE_ON : BRAKE_OFF);
				root.drawRectIcon(root.width - 134, yoff + 8, 16, 16);
				//TODO root.mc.getTextureManager().bindTexture(((ULandVehicle)root.seat().vehicle).pbrake ? PBRAKE_ON : PBRAKE_OFF);
				root.drawRectIcon(root.width - 118, yoff + 8, 16, 16);
				offset.add("brake");
				offset.add("parking/hand brake");
			}
			if(!railed){
				root.mc.getTextureManager().bindTexture(data.getAttribute("lights_fog").getCurrentIcon().local());
				root.drawRectIcon(root.width - 150 + offset.size() * 16, yoff + 8, 16, 16);
				offset.add("lights_fog");
				root.mc.getTextureManager().bindTexture(data.getAttribute("lights_long").getCurrentIcon().local());
				root.drawRectIcon(root.width - 150 + offset.size() * 16, yoff + 8, 16, 16);
				offset.add("lights_long");
			}
			root.mc.getTextureManager().bindTexture(data.getAttribute("lights").getCurrentIcon().local());
			root.drawRectIcon(root.width - 150 + offset.size() * 16, yoff + 8, 16, 16);
			offset.add("lights");
			if(turnsig){
				root.mc.getTextureManager().bindTexture(data.getAttribute("turn_lights").getCurrentIcon().local());
				root.drawRectIcon(root.width - 150 + offset.size() * 16, yoff + 8, 16, 16);
				offset.add("turn_lights");
			}
			if(warnsig){
				root.mc.getTextureManager().bindTexture(data.getAttribute("warning_lights").getCurrentIcon().local());
				root.drawRectIcon(root.width - 150 + offset.size() * 16, yoff + 8, 16, 16);
				offset.add("warning_lights");
			}
		}
		//
		int a = offset.size(), m = page * row2;
		for(Attribute<?> attr : attributes){
			if(hard_attr.contains(attr.id)) continue;
			if(a < m){
				a++;
				continue;
			}
			if(a >= m + row2) break;
			int x = root.width - 150 + (a % 9) * 16;
			int y = a - m > 8 ? 24 : 8;
			root.mc.getTextureManager().bindTexture(attr.getCurrentIcon().local());
			root.drawRectIcon(x, yoff + y, 16, 16);
			a++;
		}
		//
		if(timer > 0) timer--;
		if(clicktimer > 0) clicktimer--;
		//
		if(noengine){
			root.mc.fontRenderer.drawString(NO_ENGINE, 8, 8 + yoff, 0xffffff);
			GL11.glPopMatrix();
			return;
		}
		root.mc.fontRenderer.drawString(SPEED, 8, 8 + yoff, 0xffffff);
		if(ent.vehicle.speed > maxspeed) maxspeed = (int)ent.vehicle.speed;
		root.mc.getTextureManager().bindTexture(OVERLAY_TEX);
		RGB.BLUE.glColorApply();
		root.drawTexturedModalRect(66, 8 + yoff, 66, 8, (int)(ent.vehicle.speed / (float)maxspeed * 100), 7);
		GL11.glPushMatrix();
		GL11.glTranslatef(68, 9 + yoff, 0);
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		root.mc.fontRenderer.drawString(Formatter.format("&7" + format((int)ent.vehicle.speed)), 0, 0, 0);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		String str0 = maxspeed + "";
		GL11.glTranslatef(165 - root.mc.fontRenderer.getStringWidth(str0) * 0.8f, 9 + yoff, 0);
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		root.mc.fontRenderer.drawString(Formatter.format("&7" + str0), 0, 0, 0);
		GL11.glPopMatrix();
		//
		root.mc.fontRenderer.drawString(FUEL, 8, 30 + yoff, 0xffffff);
		root.mc.getTextureManager().bindTexture(OVERLAY_TEX);
		RGB.BLACK.glColorApply();
		root.drawTexturedModalRect(66, 30 + yoff, 66, 30, (int)(data.getStoredFuel() / (float)data.getFuelCapacity() * 100), 7);
		RGB.glColorReset();
		GL11.glPushMatrix();
		GL11.glTranslatef(68, 31 + yoff, 0);
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		root.mc.fontRenderer.drawString(Formatter.format(fuelColour(ent.vehicle.data) + format(ent.vehicle.data.getStoredFuel())), 0, 0, 0xffffff);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		str0 = ent.vehicle.data.getFuelCapacity() + "";
		GL11.glTranslatef(165 - root.mc.fontRenderer.getStringWidth(str0) * 0.8f, 31 + yoff, 0);
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		root.mc.fontRenderer.drawString(Formatter.format("&b" + str0), 0, 0, 0);
		GL11.glPopMatrix();
		//
		if(!ent.vehicle.type.isRailVehicle() && ent.vehicle.rear != null){
			root.mc.fontRenderer.drawString(Formatter.format(TRAILER), 170, 30 + yoff, 0xffffff);
		}
		//
		root.mc.fontRenderer.drawString(Formatter.format(THROTTLE + " "), 8, 19 + yoff, 0xffffff);
		root.mc.getTextureManager().bindTexture(OVERLAY_TEX);
		(ent.vehicle.throttle > 0.8 ? ConstGui.RGB_ORANGE : RGB.GREEN).glColorApply();
		root.drawTexturedModalRect(66, 19 + yoff, 66, 19, (int)(ent.vehicle.throttle * 100), 7);
		RGB.glColorReset();
		//
		if(root.uni12){
			/*ULandVehicle veh = (ULandVehicle)root.seat().vehicle;
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
			root.mc.fontRenderer.drawString(Formatter.format(RPM + " " + (veh.crpm / 100 * 100)), 170, 8 + yoff, 0xffffff);
			root.mc.fontRenderer.drawString(Formatter.format(GEAR + " " + gear_label), 170, 19 + yoff, 0xffffff);*/
		}
		if(Command.OTHER && root.seat().root.wheeldata != null){//debug info
			int idx = 0;
			for(WheelSlot wheel : root.seat().root.data.getWheelSlots().values()){
				root.mc.fontRenderer.drawString(Formatter.format(wheel == null ? "none" : (wheel.steering ? "steering, " : "") + (wheel.powered(root.seat().root.data) ? "powered" : "idle")), 7, 62 + (idx++ * 11), 0xffffff);
			}
		}
		else if(STRS.size() > 0){
			int i = 0;
			for(Object str : STRS){
				root.mc.fontRenderer.drawString(Formatter.format(str.toString()), 7, 62 + (i++ * 11), 0xffffff);
			}
		}
		GL11.glPopMatrix();
	}

	private String fuelColour(VehicleData data){
		float d = data.getStoredFuel() / (float)data.getFuelCapacity();
		return d < 0.3 ? d < 0.1 ? "&c" : "&e" : "&a";
	}

	private static final DecimalFormat df = new DecimalFormat("##.##");
	// static { df.setRoundingMode(RoundingMode.DOWN); }

	public static String format(double d){
		return df.format(d);
	}

	@Override
	public void onToggablesToggle(){
		Print.debug("Toggled " + (root.toggables ? "ON" : "OFF"));
		if(!root.toggables) return;
		if(attributes.isEmpty()) loadAttrs();
		Print.debug("ATTRS " + attributes.size());
	}

	private void loadAttrs(){
		attributes.clear();
		if(root.seat() == null || root.seat().root == null) return;
		for(Attribute<?> attr : root.seat().root.data.getAttributes().values()){
			if(attr.access.contains(root.seat().seat.name)){
				attributes.add(attr);
			}
		}
	}

}
