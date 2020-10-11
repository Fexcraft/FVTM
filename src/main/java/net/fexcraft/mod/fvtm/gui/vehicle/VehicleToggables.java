package net.fexcraft.mod.fvtm.gui.vehicle;

import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleToggables extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_toggables.png");
	private ArrayList<Attribute<?>> attributes = new ArrayList<>();
	private int page, edited;
	private GenericVehicle veh;
	private TextField field;

	public VehicleToggables(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 256; this.ySize = 218; edited = -1; page = 0;
		veh = (GenericVehicle)(player.getRidingEntity() instanceof GenericVehicle ? player.getRidingEntity() : world.getEntityByID(y));
		SeatCache seat = veh.getSeatOf(player);
		veh.getVehicleData().getAttributes().values().forEach(attr -> {
			if(seat.seatdata.driver || (attr.seat() != null && attr.seat().equals(seat.seatdata.name))){
				attributes.add(attr);
			}
		});
	}

	@Override
	protected void init(){
		for(int i = 0; i < 14; i++){
			this.texts.put("row" + i, new BasicText(guiLeft + 9, guiTop + 9 + (i * 14), 176, MapColor.BLACK.colorValue, "------"));
			this.texts.put("val" + i, new BasicText(guiLeft + 205, guiTop + 9 + (i * 14), 42, MapColor.BLACK.colorValue, "---"));
			//this.buttons.put("row" + i, new BasicButton("row" + i, guiLeft + 7, guiTop + 7 + (i * 14), 7, 7 + (i * 14), 180, 12, true));
			this.buttons.put("edit" + i, new BasicButton("edit" + i, guiLeft + 190, guiTop + 8 + (i * 14), 190, 8 + (i * 14), 10, 10, true));
		}
		this.texts.put("status", new BasicText(guiLeft + 8, guiTop + 203, 224, MapColor.SNOW.colorValue, "Current page: -/-"));
		this.buttons.put("prev", new BasicButton("prev", guiLeft + 235, guiTop + 204, 235, 204, 6, 6, true));
		this.buttons.put("next", new BasicButton("next", guiLeft + 242, guiTop + 204, 242, 204, 6, 6, true));
		this.fields.put("field", field = new TextField(0, mc.fontRenderer, 0, 0, 46, 12)); field.setVisible(false);
		this.updatePageEdit(0, -1);
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){ updatePageEdit(-1, -1); return true;}
		if(button.name.equals("next")){ updatePageEdit( 1, -1); return true; }
		if(button.name.startsWith("edit")){
			int row = Integer.parseInt(button.name.replace("edit", ""));
			if(field.getVisible() && edited == row){
				if(edited < 0 || edited >= 14) return true; field.x = field.y = 0;
				NBTTagCompound packet = new NBTTagCompound(); Attribute<?> attr = getAttr(edited);
				packet.setString("target_listener", "fvtm:gui"); packet.setString("task", "attr_update");
				packet.setString("attr", attr.id()); packet.setString("value", field.getText());
				packet.setInteger("entity", veh.getEntity().getEntityId()); Print.debug(packet);
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
				field.setVisible(false); updatePageEdit(null, -1);
			}
			else{
				updatePageEdit(null, row);
				Attribute<?> attr = getAttr(page * 14 + edited); if(attr == null) return true;
				if(!attr.editable()){
					texts.get("row" + row).string = " [ Not Editable ]"; return true;
				}
				if(attr.type().isBoolean()){
					NBTTagCompound packet = new NBTTagCompound(); packet.setString("target_listener", "fvtm:gui");
					packet.setString("task", "attr_update"); packet.setString("attr", attr.id());
					packet.setString("value", !attr.getBooleanValue() + ""); attr.setValue(!attr.getBooleanValue());
					packet.setInteger("entity", veh.getEntity().getEntityId()); Print.debug(packet);
					PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
					updatePageEdit(null, -1); return true;
				}
				field.x = guiLeft + 203; field.y = guiTop + 7 + (edited * 14);
				field.setText(attr.getStringValue()); field.setVisible(true);
				return true;
			}
			return true;
		}
		return false;
	}

	private void updatePageEdit(Integer i, Integer j){
		if(i != null){ page += i; if(page < 0) page = 0; }
		if(j != null){ edited = j; }
		texts.get("status").string = "Current page: " + (page + 1) + "/" + (attributes.size() / 14 + 1) + (edited >= 0 ? " | Last edit: " + (edited + 1) : "");
		//
		for(int k = 0; k < 14; k++){ int l = page * 14 + k;
			if(l >= attributes.size()){
				texts.get("row" + k).string = "------"; texts.get("val" + k).string = "---";
			}
			else{
				texts.get("row" + k).string = attributes.get(l).id(); texts.get("val" + k).string = attributes.get(l).getStringValue();
			}
		}
		texts.forEach((key, value) -> { if(key.startsWith("val")) value.visible = true; });
		if(edited >= 0){ texts.get("val" + edited).visible = false; } field.setVisible(false);
	}

	private Attribute<?> getAttr(int edited){
		return edited >= attributes.size() || edited < 0 ? null : attributes.get(edited);
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePageEdit(am > 0 ? -1 : 1, -1);
	}
	
}

