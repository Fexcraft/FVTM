package net.fexcraft.mod.fvtm.gui.vehicle;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_CONNECTORS;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_CONTAINERS;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_FUEL;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_INVENTORIES;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_TOGGABLES;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleMain extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_main.png");
	private final GenericVehicle vehicle;

	public VehicleMain(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.width = 169; this.height = 125;
		if(player.getRidingEntity() instanceof SeatEntity){
			vehicle = ((SeatEntity)player.getRidingEntity()).getVehicle();
		} else{ vehicle = (GenericVehicle)world.getEntityByID(y); }
	}

	@Override
	protected void init(){
		this.texts.put("row0", new BasicText(20,  10, 160, MapColor.SNOW.colorValue, "Status/Info"));
		this.texts.put("row1", new BasicText(20,  24, 160, MapColor.SNOW.colorValue, "Settings"));
		this.texts.put("row2", new BasicText(20,  38, 160, MapColor.SNOW.colorValue, "Fuel"));
		this.texts.put("row3", new BasicText(20,  52, 160, MapColor.SNOW.colorValue, "Attributes"));
		this.texts.put("row4", new BasicText(20,  66, 160, MapColor.SNOW.colorValue, "Inventories"));
		this.texts.put("row5", new BasicText(20,  80, 160, MapColor.SNOW.colorValue, "Containers"));
		this.texts.put("row6", new BasicText(20,  94, 160, MapColor.SNOW.colorValue, "Connectors"));
		this.texts.put("row7", new BasicText(20, 108, 160, MapColor.SNOW.colorValue, "Exit"));
		for(int i = 0; i < 8; i++){
			this.buttons.put("row" + i, new BasicButton("row" + i, 7, 7 + (i * 14), 7, 7 + (i * 14), 155, 12, true));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 8; i++){
			texts.get("row" + i).x = guiLeft + 20;
			texts.get("row" + i).y = guiTop + 10 + (i * 14);
			buttons.get("row" + i).x = guiLeft + 7;
			buttons.get("row" + i).y = guiTop + 7 + (i * 14);
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("row7")){
			player.closeScreen();
			return true;
		}
		if(button.name.equals("row2")){
			openGui(VEHICLE_FUEL, new int[] { VEHICLE_FUEL, vehicle.getEntityId(), 0 }, LISTENERID);
			return true;
		}
		if(button.name.equals("row3")){
			openGui(VEHICLE_TOGGABLES, new int[] { 0, vehicle.getEntityId(), 0 }, LISTENERID);
			return true;
		}
		if(button.name.equals("row4")){
			openGui(VEHICLE_INVENTORIES, new int[] { 0, vehicle.getEntityId(), 0 }, LISTENERID);
			return true;
		}
		if(button.name.equals("row5")){
			openGui(VEHICLE_CONTAINERS, new int[] { 0, vehicle.getEntityId(), 0 }, LISTENERID);
			return true;
		}
		if(button.name.equals("row6")){
			openGui(VEHICLE_CONNECTORS, new int[] { 0, vehicle.getEntityId(), 0 }, LISTENERID);
			return true;
		}
		//
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

