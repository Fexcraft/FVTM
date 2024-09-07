package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.ArrayList;

import static net.fexcraft.lib.common.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

public class AttributeEditor extends GenericGui<VehicleContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/attribute_editor.png");
	private ArrayList<String> ttip = new ArrayList<String>();
	private BasicText[] info = new BasicText[10];
	private BasicButton help, retn, apply, reset;
	private String INFO[] = new String[info.length], BUTINFO[] = new String[4];
	private String none;
	private Attribute<?> attr;
	private RootVehicle vehent;
	private TextField field;

	public AttributeEditor(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 208;
		this.ySize = 192;
		vehent = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
		attr = vehent.vehicle.data.getAttributeByIndex(x);
		BUTINFO[0] = I18n.format("gui.fvtm.vehicle.attribute_editor.help");
		BUTINFO[1] = I18n.format("gui.fvtm.vehicle.attribute_editor.return");
		BUTINFO[2] = I18n.format("gui.fvtm.vehicle.attribute_editor.apply");
		BUTINFO[3] = I18n.format("gui.fvtm.vehicle.attribute_editor.reset");
		INFO[0] = I18n.format("gui.fvtm.vehicle.attribute_editor.id");
		INFO[1] = I18n.format("gui.fvtm.vehicle.attribute_editor.type");
		INFO[2] = I18n.format("gui.fvtm.vehicle.attribute_editor.default");
		INFO[3] = I18n.format("gui.fvtm.vehicle.attribute_editor.current");
		INFO[4] = I18n.format("gui.fvtm.vehicle.attribute_editor.editable");
		INFO[5] = I18n.format("gui.fvtm.vehicle.attribute_editor.external");
		INFO[6] = I18n.format("gui.fvtm.vehicle.attribute_editor.perm");
		none = I18n.format("gui.fvtm.vehicle.attribute_editor.perm.none");
		INFO[7] = I18n.format("gui.fvtm.vehicle.attribute_editor.seats");
		INFO[8] = I18n.format("gui.fvtm.vehicle.attribute_editor.modifiers");
		INFO[9] = I18n.format("gui.fvtm.vehicle.attribute_editor.group");
	}

	@Override
	protected void init(){
		for(int i = 0; i < info.length; i++){
			this.texts.put("info" + i, info[i] = new BasicText(guiLeft + 9, guiTop + 28 + (i * 14), 190, MapColor.BLACK.colorValue, "------").autoscale().hoverable(true));
		}
		this.texts.put("status", new BasicText(guiLeft + 9, guiTop + 9, 165, MapColor.SNOW.colorValue, "").autoscale());
		this.buttons.put("help", help = new BasicButton("help", guiLeft + 176, guiTop + 7, 176, 7, 12, 12, true));
		this.buttons.put("retn", retn = new BasicButton("retn", guiLeft + 189, guiTop + 7, 189, 7, 12, 12, true));
		this.buttons.put("apply", apply = new BasicButton("apply", guiLeft + 186, guiTop + 169, 186, 169, 7, 12, true));
		this.buttons.put("reset", reset = new BasicButton("reset", guiLeft + 194, guiTop + 169, 194, 169, 7, 12, true));
		this.fields.put("field", field = new TextField(0, fontRenderer, guiLeft + 8, guiTop + 170, 176, 10, true));
		texts.get("status").string = vehent.getEntityId() + " | " + vehent.getName();
		field.setText(attr.asString());
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		info[0].string = INFO[0] + ": " + attr.id;
		info[1].string = INFO[1] + ": " + attr.type();
		info[2].string = INFO[2] + ": " + attr.initial() + (attr.valuetype.isNumber() ? minmax(attr) : "");
		info[3].string = INFO[3] + ": " + attr.asString();
		info[4].string = INFO[4] + ": " + attr.editable;
		info[5].string = INFO[5] + ": " + attr.external;
		info[6].string = INFO[6] + ": " + (attr.hasPerm() ? attr.perm : none);
		info[7].string = INFO[7] + ": " + attr.access.size();
		info[8].string = INFO[8] + ": ----- ";
		info[9].string = INFO[9] + ": " + (attr.group == null ? "" : attr.group);
	}

	private String minmax(Attribute<?> attr){
		if(attr.min == Integer.MIN_VALUE && attr.max == Integer.MAX_VALUE) return "";
		if(attr.min == Integer.MIN_VALUE) return " (max " + attr.max + ")";
		if(attr.max == Integer.MAX_VALUE) return " (min " + attr.min + ")";
		return " (" + attr.min + " - " + attr.max + ")";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "retn":{
				openGui(UIKeys.ID12_VEHICLE_ATTRIBUTES, new int[] { 0, vehent.getEntityId(), 0 }, LISTENERID);
				return true;
			}
			case "help":{
				GuiScreen parent = this;
				this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, "https://fexcraft.net/wiki/mod/fvtm/attribute", 31102009, true){
	                @Override
	                public void drawScreen(int mouseX, int mouseY, float partialTicks){
	                    parent.drawScreen(-1, -1, partialTicks);
	                    super.drawScreen(mouseX, mouseY, partialTicks);
	                }
	            });
				return true;
			}
			case "apply":{
				NBTTagCompound packet = new NBTTagCompound();
				packet.setString("target_listener", "fvtm:gui");
				packet.setString("task", "attr_update");
				packet.setString("value", field.getText());
				packet.setString("attr", attr.id);
				packet.setInteger("entity", vehent.getEntityId());
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
				return true;
			}
			case "reset":{
				NBTTagCompound packet = new NBTTagCompound();
				packet.setString("target_listener", "fvtm:gui");
				packet.setString("task", "attr_update");
				packet.setBoolean("reset", true);
				packet.setString("attr", attr.id);
				packet.setInteger("entity", vehent.getEntityId());
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
				return true;
			}
		}
		return false;
	}

	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		ttip.clear();
		for(int i = 0; i < info.length; i++){
			if(info[i].hovered(mouseX, mouseY)){
				//
			}
		}
		if(info[6].hovered(mouseX, mouseY)){
			ttip.add(PARAGRAPH_SIGN + "6P: " + PARAGRAPH_SIGN + "7" + attr.perm);
		}
		if(info[7].hovered(mouseX, mouseY)){
			for(String str : attr.access){
				ttip.add(str);
			}
		}
		if(info[8].hovered(mouseX, mouseY)){
			//
		}
		if(help.hovered(mouseX, mouseY)){
			ttip.add(I18n.format(BUTINFO[0]));
		}
		if(retn.hovered(mouseX, mouseY)){
			ttip.add(I18n.format(BUTINFO[1]));
		}
		if(apply.hovered(mouseX, mouseY)){
			ttip.add(I18n.format(BUTINFO[2]));
		}
		if(reset.hovered(mouseX, mouseY)){
			ttip.add(I18n.format(BUTINFO[3]));
		}
		if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

}
