package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.mod.fvtm.ui.road.RoadToolCon;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCustomCon;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCustomUI;
import net.fexcraft.mod.fvtm.ui.road.RoadToolUI;
import net.fexcraft.mod.fvtm.ui.vehicle.*;
import net.fexcraft.mod.uni.UniReg;
import net.fexcraft.mod.uni.ui.UIKey;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UIKeys {

	public static final int ID12_TOOLBOX_COLORS = 600;
	public static final int ID12_TOOLBOX_TEXTURE = 601;
	public static final int ID12_VEHICLE_CATALOG = 610;
	public static final int ID12_RAIL_JUNCTION = 701;
	public static final int ID12_ROAD_TOOL = 702;
	public static final int ID12_ROAD_TOOL_CUSTOM = 703;
	public static final int ID12_ENTITY_SYSTEM_CHOOSE = 705;
	public static final int ID12_DECORATION_EDITOR = 713;
	public static final int ID12_CONSTRUCTOR = 900;
	public static final int ID12_FUEL_FILLER = 901;
	public static final int ID12_VEHICLE_MAIN = 930;
	public static final int ID12_VEHICLE_INFO = 931;
	public static final int ID12_VEHICLE_ATTR_EDITOR = 932;
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
	public static final UIKey TOOLBOX_COLORS = new UIKey(ID12_TOOLBOX_COLORS, "fvtm:toolbox_colors");
	public static final UIKey TOOLBOX_TEXTURE = new UIKey(ID12_TOOLBOX_TEXTURE, "fvtm:toolbox_texture");
	public static final UIKey RAIL_JUNCTION = new UIKey(ID12_RAIL_JUNCTION, "fvtm:rail_junction");
	public static final UIKey ROAD_TOOL = new UIKey(ID12_ROAD_TOOL, "fvtm:road_tool");
	public static final UIKey ROAD_TOOL_CUSTOM = new UIKey(ID12_ROAD_TOOL_CUSTOM, "fvtm:road_tool_custom");
	public static final UIKey ENTITY_SYSTEM_CHOOSE = new UIKey(ID12_ENTITY_SYSTEM_CHOOSE, "fvtm:entity_system_choose");
	public static final UIKey CONSTRUCTOR = new UIKey(ID12_CONSTRUCTOR, "fvtm:constructor");
	public static final UIKey FUEL_FILLER = new UIKey(ID12_FUEL_FILLER, "fvtm:fuel_filler");
	public static final UIKey VEHICLE_CATALOG = new UIKey(ID12_VEHICLE_CATALOG, "fvtm:vehicle_catalog");
	public static final UIKey VEHICLE_MAIN = new UIKey(ID12_VEHICLE_MAIN, "fvtm:vehicle_main");
	public static final UIKey VEHICLE_INFO = new UIKey(ID12_VEHICLE_INFO, "fvtm:vehicle_info");
	public static final UIKey VEHICLE_ATTR_EDITOR = new UIKey(ID12_VEHICLE_ATTR_EDITOR, "fvtm:vehicle_attr_editor");
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
	//
	public static Class<? extends VehicleCatalog> VEHICLE_CATALOG_IMPL;

	public static void register(){
		UniReg.registerUI(UIKeys.TOOLBOX_COLORS, ToolboxPainter.class);
		UniReg.registerMenu(UIKeys.TOOLBOX_COLORS, "fvtm:uis/toolbox_colors", ToolboxPaintContainer.class);
		UniReg.registerUI(UIKeys.TOOLBOX_TEXTURE, ToolboxTexture.class);
		UniReg.registerMenu(UIKeys.TOOLBOX_TEXTURE, "fvtm:uis/toolbox_texture", ToolboxTextureContainer.class);
		UniReg.registerUI(UIKeys.VEHICLE_CATALOG, VEHICLE_CATALOG_IMPL);
		UniReg.registerMenu(UIKeys.VEHICLE_CATALOG, "fvtm:uis/vehicle_catalog", VehicleCatalogCon.class);
		UniReg.registerUI(UIKeys.FUEL_FILLER, FuelFillerUI.class);
		UniReg.registerMenu(UIKeys.FUEL_FILLER, "fvtm:uis/fuel_filler", FuelFillerCon.class);
		//
		UniReg.registerUI(UIKeys.RAIL_JUNCTION, RailJunction.class);
		UniReg.registerMenu(UIKeys.RAIL_JUNCTION, "fvtm:uis/rail_junction", RailJunctionContainer.class);
		UniReg.registerUI(UIKeys.ROAD_TOOL, RoadToolUI.class);
		UniReg.registerMenu(UIKeys.ROAD_TOOL, "fvtm:uis/road_tool", RoadToolCon.class);
		UniReg.registerUI(UIKeys.ROAD_TOOL_CUSTOM, RoadToolCustomUI.class);
		UniReg.registerMenu(UIKeys.ROAD_TOOL_CUSTOM, "fvtm:uis/road_tool_custom", RoadToolCustomCon.class);
		UniReg.registerUI(UIKeys.DECORATION_EDITOR, DecoEditor.class);
		UniReg.registerMenu(UIKeys.DECORATION_EDITOR, "fvtm:uis/deco_editor", DecoContainer.class);
		//
		//TODO entity system chooser
		//
		UniReg.registerUI(UIKeys.VEHICLE_MAIN, VehicleMain.class);
		UniReg.registerMenu(UIKeys.VEHICLE_MAIN, "fvtm:uis/vehicle_main", VehicleMainCon.class);
		UniReg.registerUI(UIKeys.VEHICLE_ATTRIBUTES, VehicleAttributes.class);
		UniReg.registerMenu(UIKeys.VEHICLE_ATTRIBUTES, "fvtm:uis/vehicle_attributes", VehicleAttributesCon.class);
		UniReg.registerUI(UIKeys.VEHICLE_INVENTORIES, VehicleInventories.class);
		UniReg.registerMenu(UIKeys.VEHICLE_INVENTORIES, "fvtm:uis/vehicle_inventories", VehicleInventoriesCon.class);
		UniReg.registerUI(UIKeys.VEHICLE_FUEL, VehicleFuel.class);
		UniReg.registerMenu(UIKeys.VEHICLE_FUEL, "fvtm:uis/vehicle_fuel", VehicleFuelCon.class);
		UniReg.registerUI(UIKeys.VEHICLE_INVENTORY_ITEM, VehicleInvItems.class);
		UniReg.registerMenu(UIKeys.VEHICLE_INVENTORY_ITEM, "fvtm:uis/inventory_item", VehicleInvItemsCon.class);
	}

}
