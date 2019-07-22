package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleToggables extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_toggables.png");
	private int page, edited;
	private VehicleEntity veh;
	private TextField field;

	public VehicleToggables(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 256; this.ySize = 218; edited = -1; page = 0;
		if(!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false){ player.closeScreen(); return; }
		veh = ((SeatEntity)player.getRidingEntity()).getVehicle();
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
			updatePageEdit(null, Integer.parseInt(button.name.replace("edit", "")));
			Attribute attr = getAttr(page * 14 + edited); if(attr == null) return false;
			field.x = guiLeft + 203; field.y = guiTop + 7 + (edited * 14);
			field.setText(attr.getCurrentString()); field.setVisible(true);
			return true;
		}
		return false;
	}

	private void updatePageEdit(Integer i, Integer j){
		if(i != null){ page += i; if(page < 0) page = 0; }
		if(j != null){ edited = j; }
		texts.get("status").string = "Current page: " + (page + 1) + "/" + (veh.getVehicleData().getAttributes().size() / 14 + 1) + (edited >= 0 ? " | Last edit: " + (edited + 1) : "");
		//
		Attribute[] arr = veh.getVehicleData().getAttributes().values().toArray(new Attribute[0]);
		for(int k = 0; k < 14; k++){ int l = page * 14 + k;
			if(l >= arr.length){
				texts.get("row" + k).string = "------"; texts.get("val" + k).string = "---";
			}
			else{
				texts.get("row" + k).string = arr[l].getId(); texts.get("val" + k).string = arr[l].getCurrentString();
			}
		}
		texts.forEach((key, value) -> { if(key.startsWith("val")) value.visible = true; });
		if(edited >= 0) texts.get("val" + edited).visible = false;
	}

	private Attribute getAttr(int edited){
		Attribute[] arr = veh.getVehicleData().getAttributes().values().toArray(new Attribute[0]);
		return edited >= arr.length || edited < 0 ? null : arr[edited];
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePageEdit(am > 0 ? -1 : 1, -1);
	}
	
}

