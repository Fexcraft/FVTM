package net.fexcraft.mod.fvtm.gui.vehicle;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_INVENTORY_FLUID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_INVENTORY_ITEM;

import java.util.ArrayList;
import java.util.Map;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleInventories extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_inventories.png");
	private static String INVENTORIES;
	private ArrayList<InventoryFunction> inventories = new ArrayList<>();
	private ArrayList<String> inv_names = new ArrayList<>();
	private RGB[] colors = new RGB[8];
	private GenericVehicle veh;
	private int page;

	public VehicleInventories(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 194;
		this.ySize = 134;
		//if(!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false){ player.closeScreen(); return; }
		veh = (GenericVehicle)(player.getRidingEntity() instanceof GenericVehicle ? player.getRidingEntity() : world.getEntityByID(y));
		SeatCache seat = veh.getSeatOf(player);
		for(Map.Entry<String, PartData> entry : veh.getVehicleData().getParts().entrySet()){
			InventoryFunction inv = entry.getValue().getFunction("fvtm:inventory");
			if(inv == null || inv.inventory().type.isContainer()) continue;
			if(seat == null ? inv.getSeats().contains(veh.isLocked() ? "external-locked" : "external") : (seat.seatdata.driver || (inv.getSeats().contains(seat.seatdata.name)))){
				inventories.add(inv);
				inv_names.add(entry.getKey());
			}
		}
		for(int i = 0; i < 8; i++) colors[i] = RGB.WHITE;
		INVENTORIES = I18n.format("gui.fvtm.vehicle.inventory.inventories");
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 162, MapColor.SNOW.colorValue, INVENTORIES + " [-/-]"));
		for(int i = 0; i < 8; i++){
			texts.put("row" + i, new BasicText(guiLeft + 9, guiTop + 19 + (i * 14), 162, MapColor.SNOW.colorValue, "<---->"));
			buttons.put("inv" + i, new BasicButton("inv" + i, guiLeft + 7, guiTop + 17 + (i * 14), 7, 17, 166, 12, true));
		}
		buttons.put("prev", new BasicButton("prev", guiLeft + 171, guiTop + 6, 171, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 180, guiTop + 6, 180, 6, 8, 8, true));
		this.updatePage(0);
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 8; i++){
			colors[i].glColorApply();
			drawTexturedModalRect(guiLeft + 175, guiTop + 17 + (14 * i), 175, 17 + (14 * i), 12, 12);
			RGB.glColorReset();
		}
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){ updatePage(-1); return true; }
		if(button.name.equals("next")){ updatePage( 1); return true; }
		if(button.name.startsWith("inv")){
			int i = Integer.parseInt(button.name.replace("inv", ""));
			if(i < 0 || (i + (page * 8)) >= inventories.size()) return true;
			int gui = inventories.get(i).inventory().type.isItem() ? VEHICLE_INVENTORY_ITEM : VEHICLE_INVENTORY_FLUID;
			openGui(gui, new int[]{ gui, veh.getEntity().getEntityId(), i }, LISTENERID);
			return true;
		}
		return false;
	}
	
	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? -1 : 1);
	}

	private void updatePage(int i){
		page += i; if(page < 0) page = 0;
		texts.get("top").string = String.format(INVENTORIES + " [%s/%s]", page + 1, inventories.size() / 8 + 1);
		for(int j = 0; j < 8; j++){ int k = j + (page * 8); boolean bool = k >= inventories.size();
			texts.get("row" + j).string = bool ? "" : inv_names.get(k); buttons.get("inv" + j).enabled = !bool;
			if(!bool){ colors[j] = inventories.get(k).inventory().type.color; }
			else{ colors[j] = RGB.WHITE; }
		}
	}
	
}

