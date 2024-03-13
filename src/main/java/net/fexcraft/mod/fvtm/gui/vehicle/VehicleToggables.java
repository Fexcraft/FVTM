package net.fexcraft.mod.fvtm.gui.vehicle;

import static net.fexcraft.lib.common.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.ui.UIKey;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleToggables extends GenericGui<VehicleContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_attributes.png");
	private static String SCROLL, OPEN_EDITOR, NOT_EDITABLE, TOGGLE_VALUE, TOGGLE_INFO;
	private ArrayList<Attribute<?>> attributes = new ArrayList<>();
	private ArrayList<String> ttip = new ArrayList<String>();
	private BasicButton[] edit = new BasicButton[14], togg = new BasicButton[14], sort = new BasicButton[4];
	private BasicText[] rows = new BasicText[14];
	private String SORT_TEXT[] = new String[4];
	private static int scroll, lv = -1;
	private RootVehicle veh;

	public VehicleToggables(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 218;
		veh = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
		SeatInstance seat = veh.getSeatOf(player);
		veh.vehicle.data.getAttributes().values().forEach(attr -> {
			if(seat == null){
				if(attr.external) attributes.add(attr);
			}
			else if(seat.seat.driver || (attr.access.contains(seat.seat.name))){
				attributes.add(attr);
			}
		});
		if(lv != veh.getEntityId()) scroll = 0;
		lv = veh.getEntityId();
		SCROLL = I18n.format("gui.fvtm.vehicle.attribute.scroll_value");
		OPEN_EDITOR = I18n.format("gui.fvtm.vehicle.attribute.open_editor");
		TOGGLE_VALUE = I18n.format("gui.fvtm.vehicle.attribute.toggle_value");
		TOGGLE_INFO = I18n.format("gui.fvtm.vehicle.attribute.toggle_info");
		NOT_EDITABLE = I18n.format("gui.fvtm.vehicle.attribute.not_editable");
		SORT_TEXT[0] = I18n.format("gui.fvtm.vehicle.attribute.sort_all");
		SORT_TEXT[1] = I18n.format("gui.fvtm.vehicle.attribute.sort_editable");
		SORT_TEXT[2] = I18n.format("gui.fvtm.vehicle.attribute.sort_external");
		SORT_TEXT[3] = I18n.format("gui.fvtm.vehicle.attribute.sort_seat");
	}

	@Override
	protected void init(){
		for(int i = 0; i < 14; i++){
			this.texts.put("row" + i, rows[i] = new BasicText(guiLeft + 9, guiTop + 9 + (i * 14), 210, MapColor.BLACK.colorValue, "------").hoverable(true));
			this.buttons.put("edit" + i, edit[i] = new BasicButton("edit" + i, guiLeft + 237, guiTop + 7 + (i * 14), 12, 244, 12, 12, true).alpha(false));
			this.buttons.put("togg" + i, togg[i] = new BasicButton("togg" + i, guiLeft + 223, guiTop + 7 + (i * 14), 0, 244, 12, 12, true).alpha(false));
		}
		this.texts.put("status", new BasicText(guiLeft + 44, guiTop + 203, 224, MapColor.SNOW.colorValue, SCROLL + " -/-"));
		this.buttons.put("prev", new BasicButton("prev", guiLeft + 235, guiTop + 204, 235, 204, 6, 6, true));
		this.buttons.put("next", new BasicButton("next", guiLeft + 242, guiTop + 204, 242, 204, 6, 6, true));
		this.buttons.put("sall", sort[0] = new BasicButton("sall", guiLeft + 7, guiTop + 203, 7, 203, 8, 8, true));
		this.buttons.put("sedt", sort[1] = new BasicButton("sedt", guiLeft + 16, guiTop + 203, 16, 203, 8, 8, true));
		this.buttons.put("sext", sort[2] = new BasicButton("sext", guiLeft + 25, guiTop + 203, 25, 203, 8, 8, true));
		this.buttons.put("seat", sort[3] = new BasicButton("seat", guiLeft + 34, guiTop + 203, 34, 203, 8, 8, true));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		updateTexts();
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){
			updatePage(-1);
			return true;
		}
		if(button.name.equals("next")){
			updatePage(1);
			return true;
		}
		if(button.name.equals("sall")){
			attributes.clear();
			veh.vehicle.data.getAttributes().values().forEach(attr -> attributes.add(attr));
			return true;
		}
		if(button.name.equals("sedt")){
			attributes.removeIf(attr -> !attr.editable);
			return true;
		}
		if(button.name.equals("sext")){
			attributes.clear();
			veh.vehicle.data.getAttributes().values().forEach(attr -> {
				if(attr.external){
					attributes.add(attr);
				}
			});
			return true;
		}
		if(button.name.equals("seat")){
			attributes.clear();
			SeatInstance seat = veh.getSeatOf(player);
			if(seat == null) return true;
			veh.vehicle.data.getAttributes().values().forEach(attr -> {
				if(seat.seat.driver || (attr.access.contains(seat.seat.name))){
					attributes.add(attr);
				}
			});
			return true;
		}
		if(button.name.startsWith("togg")){
			int row = Integer.parseInt(button.name.replace("togg", ""));
			NBTTagCompound packet = new NBTTagCompound();
			Attribute<?> attr = attributes.get(scroll + row);
			packet.setString("target_listener", UTIL_LISTENER);
			packet.setString("task", "attr_toggle");
			packet.setString("attr", attr.id);
			if(!attr.valuetype.isBoolean() && mouseButton != 0){
				packet.setBoolean("reset", true);
			}
			packet.setBoolean("bool", !attr.asBoolean());
			packet.setInteger("entity", veh.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
			return true;
		}
		if(button.name.startsWith("edit")){
			int row = Integer.parseInt(button.name.replace("edit", "")) + scroll;
			if(row >= attributes.size()) return true;
			openGui(UIKey.VEHICLE_ATTR_EDITOR.id, new int[] { veh.vehicle.data.getAttributeIndex(attributes.get(row)), veh.getEntityId(), 0 }, LISTENERID);
			return true;
		}
		return false;
	}

	private void updatePage(Integer i){
		if(i != null){
			scroll += i;
			if(scroll < 0) scroll = 0;
		}
		texts.get("status").string = SCROLL + " " + scroll;
	}

	private void updateTexts(){
		for(int k = 0; k < 14; k++){
			int l = scroll + k;
			if(l >= attributes.size()){
				rows[k].string = "------";
				edit[k].enabled = edit[k].visible = false;
				togg[k].enabled = togg[k].visible = false;
			}
			else{
				rows[k].string = attributes.get(l).id;
				edit[k].enabled = edit[k].visible = true;
				togg[k].enabled = togg[k].visible = attributes.get(l).valuetype.isTristate();
			}
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? 1 : -1);
	}

	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		ttip.clear();
		for(int i = 0; i < rows.length; i++){
			if(rows[i].hovered(mouseX, mouseY)){
				int k = scroll + i;
				if(k < attributes.size()){
					Attribute<?> attr = attributes.get(k);
					ttip.add(PARAGRAPH_SIGN + "6V: " + PARAGRAPH_SIGN + "7" + attr.asString());
					if(attr.group != null){
						ttip.add(PARAGRAPH_SIGN + "bG: " + PARAGRAPH_SIGN + "7" + attr.group);
					}
					if(attr.hasPerm()){
						ttip.add(PARAGRAPH_SIGN + "6P: " + PARAGRAPH_SIGN + "7" + attributes.get(i).perm);
					}
					if(!attr.editable){
						ttip.add(PARAGRAPH_SIGN + "o" + PARAGRAPH_SIGN + "e" + NOT_EDITABLE);
					}
				}
			}
		}
		for(BasicButton button : edit){
			if(button.visible && button.hovered){
				ttip.add(OPEN_EDITOR);
			}
		}
		for(BasicButton button : togg){
			if(button.visible && button.hovered){
				ttip.add(TOGGLE_VALUE);
				ttip.add(TOGGLE_INFO);
			}
		}
		for(int i = 0; i < sort.length; i++){
			if(sort[i].hovered){
				ttip.add(SORT_TEXT[i]);
			}
		}
		if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

}
