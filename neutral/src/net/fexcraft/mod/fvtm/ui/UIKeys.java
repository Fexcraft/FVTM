package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.mod.fvtm.ui.rail.RailJunction;
import net.fexcraft.mod.fvtm.ui.rail.RailJunctionContainer;
import net.fexcraft.mod.fvtm.ui.rail.RailSignal;
import net.fexcraft.mod.fvtm.ui.rail.RailSignalContainer;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCon;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCustomCon;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCustomUI;
import net.fexcraft.mod.fvtm.ui.road.RoadToolUI;
import net.fexcraft.mod.fvtm.ui.vehicle.*;
import net.fexcraft.mod.uni.UniReg;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIKey;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UIKeys {

	public static final int ID12_TOOLBOX_COLORS = 600;
	public static final int ID12_TOOLBOX_TEXTURE = 601;
	public static final int ID12_VEHICLE_CATALOG = 610;
	public static final int ID12_RAIL_JUNCTION = 701;
	public static final int ID12_RAIL_SIGNAL = 704;
	public static final int ID12_RAIL_JUNC_EVENTS = 706;
	public static final int ID12_ROAD_TOOL = 702;
	public static final int ID12_ROAD_TOOL_CUSTOM = 703;
	public static final int ID12_ENTITY_SYSTEM_CHOOSE = 705;
	public static final int ID12_DECORATION_EDITOR = 713;
	public static final int ID12_CONSTRUCTOR = 900;
	public static final int ID12_FUEL_FILLER = 901;
	public static final int ID12_VEHICLE_MAIN = 930;
	public static final int ID12_VEHICLE_INFO = 931;
	public static final int ID12_VEHICLE_FUEL = 933;
	public static final int ID12_VEHICLE_ATTRIBUTES = 934;
	public static final int ID12_VEHICLE_INVENTORIES = 935;
	public static final int ID12_VEHICLE_INVENTORY_ITEM = 9361;
	public static final int ID12_VEHICLE_INVENTORY_STACK = 9362;
	public static final int ID12_VEHICLE_INVENTORY_FLUID = 9363;
	public static final int ID12_VEHICLE_INVENTORY_VAR = 9364;
	public static final int ID12_VEHICLE_CONTAINERS = 937;
	public static final int ID12_VEHICLE_CONNECTORS = 939;
	public static final int ID12_BLOCK_INVENTORY_ITEM = 961;
	public static final int ID12_BLOCK_INVENTORY_FLUID = 962;
	public static final int ID12_BLOCK_INVENTORY_VAR = 963;
	public static final int ID12_MULTIBLOCK_INVENTORY_ITEM = 9511;
	public static final int ID12_MULTIBLOCK_INVENTORY_FLUID = 9512;
	public static final int ID12_MULTIBLOCK_INVENTORY_VAR = 9513;
	public static final int ID12_SIGN_EDITOR = 709;
	public static final UIKey TOOLBOX_COLORS = new UIKey(ID12_TOOLBOX_COLORS, "fvtm:toolbox_colors");
	public static final UIKey TOOLBOX_TEXTURE = new UIKey(ID12_TOOLBOX_TEXTURE, "fvtm:toolbox_texture");
	public static final UIKey RAIL_JUNCTION = new UIKey(ID12_RAIL_JUNCTION, "fvtm:rail_junction");
	public static final UIKey RAIL_SIGNAL = new UIKey(ID12_RAIL_SIGNAL, "fvtm:rail_signal");
	public static final UIKey RAIL_JUNC_EVENTS = new UIKey(ID12_RAIL_JUNC_EVENTS, "fvtm:rail_junc_events");
	public static final UIKey ROAD_TOOL = new UIKey(ID12_ROAD_TOOL, "fvtm:road_tool");
	public static final UIKey ROAD_TOOL_CUSTOM = new UIKey(ID12_ROAD_TOOL_CUSTOM, "fvtm:road_tool_custom");
	public static final UIKey ENTITY_SYSTEM_CHOOSE = new UIKey(ID12_ENTITY_SYSTEM_CHOOSE, "fvtm:entity_system_choose");
	public static final UIKey CONSTRUCTOR = new UIKey(ID12_CONSTRUCTOR, "fvtm:constructor");
	public static final UIKey FUEL_FILLER = new UIKey(ID12_FUEL_FILLER, "fvtm:fuel_filler");
	public static final UIKey VEHICLE_CATALOG = new UIKey(ID12_VEHICLE_CATALOG, "fvtm:vehicle_catalog");
	public static final UIKey VEHICLE_MAIN = new UIKey(ID12_VEHICLE_MAIN, "fvtm:vehicle_main");
	public static final UIKey VEHICLE_INFO = new UIKey(ID12_VEHICLE_INFO, "fvtm:vehicle_info");
	public static final UIKey VEHICLE_FUEL = new UIKey(ID12_VEHICLE_FUEL, "fvtm:vehicle_fuel");
	public static final UIKey VEHICLE_ATTRIBUTES = new UIKey(ID12_VEHICLE_ATTRIBUTES, "fvtm:vehicle_attributes");
	public static final UIKey VEHICLE_INVENTORIES = new UIKey(ID12_VEHICLE_INVENTORIES, "fvtm:vehicle_inventories");
	public static final UIKey VEHICLE_INVENTORY_ITEM = new UIKey(ID12_VEHICLE_INVENTORY_ITEM, "fvtm:vehicle_inv_item");
	public static final UIKey VEHICLE_INVENTORY_STACK = new UIKey(ID12_VEHICLE_INVENTORY_STACK, "fvtm:vehicle_inv_stack");
	public static final UIKey VEHICLE_INVENTORY_FLUID = new UIKey(ID12_VEHICLE_INVENTORY_FLUID, "fvtm:vehicle_inv_fluid");
	public static final UIKey VEHICLE_INVENTORY_VAR = new UIKey(ID12_VEHICLE_INVENTORY_VAR, "fvtm:vehicle_inv_var");
	public static final UIKey VEHICLE_CONTAINERS = new UIKey(ID12_VEHICLE_CONTAINERS, "fvtm:vehicle_containers");
	public static final UIKey VEHICLE_CONNECTORS = new UIKey(ID12_VEHICLE_CONNECTORS, "fvtm:vehicle_connectors");
	public static final UIKey DECORATION_EDITOR = new UIKey(ID12_DECORATION_EDITOR, "fvtm:decoration_editor");
	public static final UIKey BLOCK_INVENTORY_ITEM = new UIKey(ID12_BLOCK_INVENTORY_ITEM, "fvtm:block_inventory_item");
	public static final UIKey BLOCK_INVENTORY_FLUID = new UIKey(ID12_BLOCK_INVENTORY_FLUID, "fvtm:block_inventory_fluid");
	public static final UIKey BLOCK_INVENTORY_VAR = new UIKey(ID12_BLOCK_INVENTORY_VAR, "fvtm:block_inventory_var");
	public static final UIKey MULTIBLOCK_INVENTORY_ITEM = new UIKey(ID12_MULTIBLOCK_INVENTORY_ITEM, "fvtm:mb_inventory_item");
	public static final UIKey MULTIBLOCK_INVENTORY_FLUID = new UIKey(ID12_MULTIBLOCK_INVENTORY_FLUID, "fvtm:mb_inventory_fluid");
	public static final UIKey MULTIBLOCK_INVENTORY_VAR = new UIKey(ID12_MULTIBLOCK_INVENTORY_VAR, "fvtm:mb_inventory_var");
	public static final UIKey SIGN_EDITOR = new UIKey(ID12_SIGN_EDITOR, "fvtm:sign_editor");
	//
	public static Class<? extends VehicleCatalog> VEHICLE_CATALOG_IMPL;

	public static void register(){
		UniReg.registerUI(TOOLBOX_COLORS, ToolboxPainter.class);
		UniReg.registerMenu(TOOLBOX_COLORS, "fvtm:uis/toolbox_colors", ToolboxPaintContainer.class);
		UniReg.registerUI(TOOLBOX_TEXTURE, ToolboxTexture.class);
		UniReg.registerMenu(TOOLBOX_TEXTURE, "fvtm:uis/toolbox_texture", ToolboxTextureContainer.class);
		UniReg.registerUI(VEHICLE_CATALOG, VEHICLE_CATALOG_IMPL);
		UniReg.registerMenu(VEHICLE_CATALOG, "fvtm:uis/vehicle_catalog", VehicleCatalogCon.class);
		UniReg.registerUI(FUEL_FILLER, FuelFillerUI.class);
		UniReg.registerMenu(FUEL_FILLER, "fvtm:uis/fuel_filler", FuelFillerCon.class);
		UniReg.registerUI(SIGN_EDITOR, SignEditor.class);
		UniReg.registerMenu(SIGN_EDITOR, "fvtm:uis/sign_editor", SignContainer.class);
		//
		UniReg.registerUI(RAIL_JUNCTION, RailJunction.class);
		UniReg.registerMenu(RAIL_JUNCTION, "fvtm:uis/rail_junction", RailJunctionContainer.class);
		UniReg.registerUI(RAIL_SIGNAL, RailSignal.class);
		UniReg.registerMenu(RAIL_SIGNAL, "fvtm:uis/rail_signal", RailSignalContainer.class);
		UniReg.registerUI(RAIL_JUNC_EVENTS, UserInterface.class);
		UniReg.registerMenu(RAIL_JUNC_EVENTS, "fvtm:uis/rail_junction_events", ContainerInterface.class);
		UniReg.registerUI(ROAD_TOOL, RoadToolUI.class);
		UniReg.registerMenu(ROAD_TOOL, "fvtm:uis/road_tool", RoadToolCon.class);
		UniReg.registerUI(ROAD_TOOL_CUSTOM, RoadToolCustomUI.class);
		UniReg.registerMenu(ROAD_TOOL_CUSTOM, "fvtm:uis/road_tool_custom", RoadToolCustomCon.class);
		UniReg.registerUI(DECORATION_EDITOR, DecoEditor.class);
		UniReg.registerMenu(DECORATION_EDITOR, "fvtm:uis/deco_editor", DecoContainer.class);
		//
		//TODO entity system chooser
		//
		UniReg.registerUI(VEHICLE_MAIN, VehicleMain.class);
		UniReg.registerMenu(VEHICLE_MAIN, "fvtm:uis/vehicle_main", VehicleMainCon.class);
		UniReg.registerUI(VEHICLE_ATTRIBUTES, VehicleAttributes.class);
		UniReg.registerMenu(VEHICLE_ATTRIBUTES, "fvtm:uis/vehicle_attributes", VehicleAttributesCon.class);
		UniReg.registerUI(VEHICLE_INVENTORIES, VehicleInventories.class);
		UniReg.registerMenu(VEHICLE_INVENTORIES, "fvtm:uis/vehicle_inventories", VehicleInventoriesCon.class);
		UniReg.registerUI(VEHICLE_FUEL, VehicleFuel.class);
		UniReg.registerMenu(VEHICLE_FUEL, "fvtm:uis/vehicle_fuel", VehicleFuelCon.class);
		UniReg.registerUI(VEHICLE_INVENTORY_ITEM, VehicleInvItems.class);
		UniReg.registerMenu(VEHICLE_INVENTORY_ITEM, "fvtm:uis/inventory_item", VehicleInvItemsCon.class);
	}

}
