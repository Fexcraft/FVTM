package net.fexcraft.mod.fvtm.gui;

import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_BACK;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_FALSE;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_TRI0;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_TRI1;
import static net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.ICON_BOOL_TRUE;

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
import net.fexcraft.mod.fvtm.data.addon.AddonSteeringOverlay;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.handler.KeyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

/**
 * Default Steering Overlay
 * 
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultSteeringOverlay extends AddonSteeringOverlay {
	
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
	//
	protected static final RGB HOVER = new RGB(0, 255, 0, 0.5f);
	protected static final int perpage = 8;
	protected static int scroll = 0, page, timer, clicktimer, lastgear = -100;
	protected static ArrayList<Attribute<?>> attributes = new ArrayList<>();
	public static CopyOnWriteArrayList<String> STRS = new CopyOnWriteArrayList<String>();
	private static String gear_label;

	public DefaultSteeringOverlay(VehicleSteeringOverlay root, EntityPlayer player){
		super(root, player);
	}

	@Override
	public void init(){
		scroll = 0;
		page = 0;
		lastgear = 100;
		attributes.clear();
	}

	@Override
	public boolean handleMouseInput(){
		return false;
	}

	@Override
	public void scroll(int wheel){
		if(root.toggables){
			scroll(wheel, false);
		}
		else player.inventory.changeCurrentItem(wheel);
	}

	private void scroll(int wheel, boolean usetimer){
		if(usetimer) if(timer > 0) return;
		scroll += wheel > 0 ? -1 : 1;
		if(scroll >= perpage) scroll = 0;
		if(scroll < 0) scroll = 0; // 0 was -1;
		if(usetimer) timer = 10;
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
		if(scroll < 0 || scroll > perpage) return;
		if(clicktimer > 0) return;
		NBTTagCompound packet = new NBTTagCompound();
		Attribute<?> attr = attributes.get((page * perpage) + scroll);
		packet.setString("target_listener", GuiHandler.LISTENERID);
		packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id());
		if(i > 1) packet.setBoolean("reset", true);
		packet.setBoolean("bool", !attr.valuetype().isBoolean() ? i < 0 : i > 0);
		packet.setInteger("entity", root.seat().vehicle.getEntityId());
		Print.debug(packet);
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		clicktimer += 10;
	}

	protected void page(int am){
		if(timer > 0) return;
		page += am;
		if(page > attributes.size() / perpage) page = 0;
		if(page < 0) page = 0;
		timer = 15;
		scroll = 0;
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
			root.seat().onKeyPress(root.seat().vehicle.getVehicleType().isAirVehicle() ? KeyPress.TURN_DOWN : KeyPress.ACCELERATE, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindBack.getKeyCode())){
			root.seat().onKeyPress(root.seat().vehicle.getVehicleType().isAirVehicle() ? KeyPress.TURN_UP : KeyPress.DECELERATE, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindLeft.getKeyCode())){
			root.seat().onKeyPress(KeyPress.TURN_LEFT, player);
		}
		if(isKeyDown(root.mc.gameSettings.keyBindRight.getKeyCode())){
			root.seat().onKeyPress(KeyPress.TURN_RIGHT, player);
		}
		if(isKeyDown(KeyHandler.arrow_up.getKeyCode())){
			if(root.toggables) scroll(1, true);
			else root.seat().onKeyPress(root.seat().vehicle.getVehicleType().isAirVehicle() ? KeyPress.ACCELERATE : KeyPress.GEAR_UP, player);
		}
		if(isKeyDown(KeyHandler.arrow_down.getKeyCode())){
			if(root.toggables) scroll(-1, true);
			else root.seat().onKeyPress(root.seat().vehicle.getVehicleType().isAirVehicle() ? KeyPress.DECELERATE : KeyPress.GEAR_DOWN, player);
		}
		if(isKeyDown(KeyHandler.arrow_left.getKeyCode())){
			if(root.toggables) page(-1);
			else root.seat().onKeyPress(KeyPress.ROLL_LEFT, player);
		}
		if(isKeyDown(KeyHandler.arrow_right.getKeyCode())){
			if(root.toggables) page(1);
			else root.seat().onKeyPress(KeyPress.ROLL_RIGHT, player);
		}
		if(root.uni12){
			if(isKeyDown(KeyHandler.pbrake.getKeyCode())){
				root.seat().onKeyPress(KeyPress.PBRAKE, player);
			}
			boolean state = isKeyDown(KeyHandler.brake.getKeyCode());
			if(state != root.seat().vehicle.getKeyPressState(KeyPress.BRAKE)){
				root.seat().vehicle.onKeyPress(KeyPress.BRAKE, root.seat().seatdata, player, state);
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
			root.resetview = false;
			root.seat().onKeyPress(KeyPress.INVENTORY, player);
		}
		if(isKeyDown(KeyHandler.doorToggle.getKeyCode())){
			root.seat().onKeyPress(KeyPress.TOGGABLES, player);
		}
		if(isKeyDown(KeyHandler.scriptsGUI.getKeyCode())){
			root.resetview = false;
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
	public void drawScreen(int mouseX, int mouseY, float partialTicks, GenericVehicle ent, VehicleData data){
		root.mc.getTextureManager().bindTexture(ConstructorGui.STONE);
		int yoff = Config.OVERLAY_ON_BOTTOM ? root.height - 34 : 0;
		root.drawTexturedModalRect(0, yoff, 0, 0, root.width, 34);
		boolean noengine = false;
		if(!data.hasPart("engine") || !data.getPart("engine").hasFunction("fvtm:engine")){
			root.mc.getTextureManager().bindTexture(ENGINE_MISSING);
			noengine = true;
		}
		else{
			root.mc.getTextureManager().bindTexture(data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() ? ENGINE_ON : ENGINE_OFF);
		}
		root.drawRectIcon(root.width - 33, 1 + yoff, 32, 32);
		//
		if(!ent.isRailType()){
			//this.mc.getTextureManager().bindTexture(ConstructorGui.ANVIL);
			//drawRectIcon(width - 97 - 16, 1, 80, 16);
			boolean turnleft = DefaultPrograms.BLINKER_TOGGLE && (data.getTurnLightLeft() || data.getWarningLights());
			root.mc.getTextureManager().bindTexture(turnleft ? INDICATOR_LEFT_ON : INDICATOR_LEFT_OFF);
			root.drawRectIcon(root.width - 97 - 16, 1 + yoff, 16, 16);
			boolean turnright = DefaultPrograms.BLINKER_TOGGLE && (data.getTurnLightRight() || data.getWarningLights());
			root.mc.getTextureManager().bindTexture(turnright ? INDICATOR_RIGHT_ON : INDICATOR_RIGHT_OFF);
			root.drawRectIcon(root.width - 65 + 16, 1 + yoff, 16, 16);
			//
			root.mc.getTextureManager().bindTexture(data.getAttribute("lights").boolean_value() ? LIGHTS_LOW_ON : LIGHTS_LOW_OFF);
			root.drawRectIcon(root.width - 97 + 32, 1 + yoff, 16, 16);
			root.mc.getTextureManager().bindTexture(data.getAttribute("lights_long").boolean_value() ? LIGHTS_HIGH_ON : LIGHTS_HIGH_OFF);
			root.drawRectIcon(root.width - 97 + 16, 1 + yoff, 16, 16);
			root.mc.getTextureManager().bindTexture(data.getAttribute("lights_fog").boolean_value() ? LIGHTS_FOG_ON : LIGHTS_FOG_OFF);
			root.drawRectIcon(root.width - 97, 1 + yoff, 16, 16);
			//
			if(root.uni12){
				root.mc.getTextureManager().bindTexture(((ULandVehicle)root.seat().vehicle).pbrake ? PBRAKE_ON : PBRAKE_OFF);
				root.drawRectIcon(root.width - 97 - 34, 1 + yoff, 16, 16);
				root.mc.getTextureManager().bindTexture(((ULandVehicle)root.seat().vehicle).braking ? BRAKE_ON : BRAKE_OFF);
				root.drawRectIcon(root.width - 97 - 50, 1 + yoff, 16, 16);
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
				offset = j * 12 + (yoff > 0 ? 0 : 34);
				root.mc.renderEngine.bindTexture(ICON_BOOL_BACK);
				if(attr.valuetype().isTristate()){
					int width = root.fontRenderer().getStringWidth(attr.id());
					if(scroll == j) HOVER.glColorApply();
					root.drawTexturedModalRect(root.width - width - 14, offset, 0, 0, width + 2, 12);
					if(scroll == j) RGB.glColorReset();
					root.mc.fontRenderer.drawString(attr.id(), root.width - width - 12, offset + 3, 0xffffff);
					if(attr.valuetype().isBoolean()){
						root.mc.renderEngine.bindTexture(attr.boolean_value() ? ICON_BOOL_TRUE : ICON_BOOL_FALSE);
					}
					else{
						root.mc.renderEngine.bindTexture(attr.conditional_tristate(ICON_BOOL_FALSE, ICON_BOOL_TRI1, ICON_BOOL_TRI0));
					}
					root.drawRectIcon(root.width - 12, offset, 12, 12);
				}
				else{
					String str = attr.id() + " - " + attr.float_value();
					int width = root.fontRenderer().getStringWidth(str);
					if(scroll == j) HOVER.glColorApply();
					root.drawTexturedModalRect(root.width - width - 2, offset, 0, 0, width + 2, 12);
					if(scroll == j) RGB.glColorReset();
					root.mc.fontRenderer.drawString(str, root.width - width, offset + 3, 0xffffff);
				}
			}
			if(attributes.size() > 8){
				root.mc.renderEngine.bindTexture(ICON_BOOL_BACK);
				String string = "Page " + (page + 1) + "/" + (attributes.size() / perpage + 1);
				int width = root.fontRenderer().getStringWidth(string) + 4;
				root.drawTexturedModalRect(root.width - width, offset + 12, 0, 0, width, 12);
				root.mc.fontRenderer.drawString(string, root.width - width + 2, offset + 15, 0xffffff);
			}
		}
		//
		if(timer > 0) timer--;
		if(clicktimer > 0) clicktimer--;
		//
		if(noengine){
			root.mc.fontRenderer.drawString("No Engine installed.", 7, 7 + yoff, 0xffffff);
			GL11.glPopMatrix();
			return;
		}
		root.mc.fontRenderer.drawString(Formatter.format("Speed: " + format((int)ent.getSpeed())), 7, 3 + yoff, 0xffffff);
		root.mc.fontRenderer.drawString(Formatter.format("Fuel: " + fuelColour(ent.getVehicleData()) + format(ent.getVehicleData().getStoredFuel()) + "&f/&b" + ent.getVehicleData().getFuelCapacity()), 7, 25 + yoff, 0xffffff);
		if(!ent.isRailType() && ent.getCoupledEntity(false) != null){
			root.mc.fontRenderer.drawString(Formatter.format("&a&oTrailer Attached."), 167, 25 + yoff, 0xffffff);
		}
		if(root.uni12){
			root.mc.fontRenderer.drawString(Formatter.format("Throttle: "), 7, 14 + yoff, 0xffffff);
			{
				RGB.BLACK.glColorApply();
				root.mc.getTextureManager().bindTexture(ConstructorGui.STONE);
				root.drawTexturedModalRect(59, 13 + yoff, 0, 0, 102, 10);
				RGB.glColorReset();
				(ent.throttle > 0.8 ? ConstructorGui.RGB_ORANGE : RGB.GREEN).glColorApply();
				root.drawTexturedModalRect(60, 14 + yoff, 0, 0, (int)(ent.throttle * 100), 8);
				RGB.glColorReset();
			}
			ULandVehicle veh = (ULandVehicle)root.seat().vehicle;
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
			root.mc.fontRenderer.drawString(Formatter.format("RPM: " + (veh.crpm / 100 * 100)), 167, 3 + yoff, 0xffffff);
			root.mc.fontRenderer.drawString(Formatter.format("Gear: " + gear_label), 167, 14 + yoff, 0xffffff);
		}
		else{
			root.mc.fontRenderer.drawString(Formatter.format("Throttle: " + throttleColour(ent.throttle) + pc(ent.throttle) + "%"), 7, 14 + yoff, 0xffffff);
		}
		if(Command.OTHER && root.seat().vehicle.wheels != null){//debug info
			for(int i = 0; i < root.seat().vehicle.wheels.length; i++){
				WheelEntity wheel = root.seat().vehicle.wheels[i];
				root.mc.fontRenderer.drawString(Formatter.format(wheel == null ? "none" : wheel.slot == null ? "no_slot" : (wheel.slot.steering() ? "steering, " : "") + (wheel.slot.powered(root.seat().vehicle.getVehicleData()) ? "powered" : "idle")), 7, 62 + (i * 11), 0xffffff);
			}
		}
		else if(STRS.size() > 0){
			int i = 0;
			for(String str : STRS){
				root.mc.fontRenderer.drawString(Formatter.format(str), 7, 62 + (i++ * 11), 0xffffff);
			}
		}
		GL11.glPopMatrix();
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

	@Override
	public void onToggablesToggle(){
		Print.debug("Toggled " + (root.toggables ? "ON" : "OFF"));
		attributes.clear();
		if(!root.toggables) return;
		if(root.seat() == null || root.seat().vehicle == null) return;
		for(Attribute<?> attr : root.seat().vehicle.getVehicleData().getAttributes().values()){
			if(attr.seats().contains(root.seat().seatdata.name)){
				attributes.add(attr);
			}
		}
		Print.debug("ATTRS " + attributes.size());
	}

}
