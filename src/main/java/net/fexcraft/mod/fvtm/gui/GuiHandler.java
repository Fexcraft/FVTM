package net.fexcraft.mod.fvtm.gui;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATION_CATEGORIES;

import java.util.HashMap;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraft;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraftChoose;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraftChooseContainer;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraftContainer;
import net.fexcraft.mod.fvtm.gui.construct.*;
import net.fexcraft.mod.fvtm.gui.inv.UniFluidInvContainer;
import net.fexcraft.mod.fvtm.gui.inv.UniFluidInvUi;
import net.fexcraft.mod.fvtm.gui.inv.UniItemInvContainer;
import net.fexcraft.mod.fvtm.gui.inv.UniItemInvUi;
import net.fexcraft.mod.fvtm.gui.inv.UniVarInvContainer;
import net.fexcraft.mod.fvtm.gui.inv.UniVarInvUi;
import net.fexcraft.mod.fvtm.gui.junction.JunctionAdjuster;
import net.fexcraft.mod.fvtm.gui.junction.JunctionAdjusterContainer;
import net.fexcraft.mod.fvtm.gui.other.SpawnSystemChooser;
import net.fexcraft.mod.fvtm.gui.other.SpawnSystemContainer;
import net.fexcraft.mod.fvtm.gui.other.VehicleAndPartInfo;
import net.fexcraft.mod.fvtm.gui.other.VehicleAndPartInfoContainer;
import net.fexcraft.mod.fvtm.gui.rail.RailPlacer;
import net.fexcraft.mod.fvtm.gui.rail.RailPlacerContainer;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerCustomFill;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerCustomFillContainer;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerFill;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerFillContainer;
import net.fexcraft.mod.fvtm.gui.sign.StreetSignAdjuster;
import net.fexcraft.mod.fvtm.gui.sign.StreetSignAdjusterContainer;
import net.fexcraft.mod.fvtm.gui.tsign.TrafficSignEditor;
import net.fexcraft.mod.fvtm.gui.tsign.TrafficSignEditorContainer;
import net.fexcraft.mod.fvtm.gui.vehicle.*;
import net.fexcraft.mod.fvtm.gui.wire.WireEditor;
import net.fexcraft.mod.fvtm.gui.wire.WireRelayChooser;
import net.fexcraft.mod.fvtm.gui.wire.WireRelayContainer;
import net.fexcraft.mod.fvtm.gui.wire.WireRelayEditor;
import net.fexcraft.mod.fvtm.ui.*;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleFuel;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleFuelCon;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleMain;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleMainCon;
import net.fexcraft.mod.uni.ui.UniCon;
import net.fexcraft.mod.uni.ui.UniUI;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static NBTTagCompound CLIENT_GUIDATA_CACHE;
	public static final HashMap<String, NBTTagCompound> SERVER_GUIDATA_CACHE = new HashMap<>();
	public static final String LISTENERID = "fvtm:gui";

	/* 7xx - other */
	public static final int STREETSIGN_ADJUSTER = 700;
	public static final int JUNCTION_ADJUSTER = 701;
	//public static final int ROADTOOL = 702;
	public static final int ROADTOOLFILL = 703;
	public static final int ROADTOOLCUSTOMFILL = 704;
	public static final int SPAWNSYS = 705;
	public static final int RAILPLACER = 706;
	public static final int TSEDITOR = 709;
	public static final int WIRE_RELAY_MAIN = 710;
	public static final int WIRE_RELAY_EDIT = 711;
	public static final int WIRE_EDIT = 712;
	//public static final int DECORATION_EDITOR = 713;
	public static final int VEHICLE_AND_PART_INFO = 714;
	/* 90x - constructor main */
	public static final int CONSTRUCTOR_MAIN = 900;
	public static final int CONSTRUCTOR_STATUS = 901;
	public static final int CONSTRUCTOR_CONTENTINFO = 902;
	public static final int CONSTRUCTOR_PARTINFO = 904;
	public static final int CONSTRUCTOR_PARTMANAGER = 905;
	public static final int CONSTRUCTOR_PARTINSTALLER = 906;
	public static final int CONSTRUCTOR_TEXTUREMANAGER = 908;
	public static final int CONSTRUCTOR_PAINTER = 909;
	/* 91x - part cache */
	//
	/* 92x - installed part */
	//
	/* 93x - vehicle */
	//public static final int VEHICLE_MAIN = 930;
	//public static final int VEHICLE_ATTRIBUTE_EDITOR = 932;
	//public static final int VEHICLE_FUEL = 933;
	//public static final int VEHICLE_TOGGABLES = 934;
	//public static final int VEHICLE_INVENTORIES = 935;
	public static final int VEHICLE_INVENTORY_ITEM = 9361;
	public static final int VEHICLE_INVENTORY_FLUID = 9362;
	public static final int VEHICLE_INVENTORY_VAR = 9363;
	//public static final int VEHICLE_CONTAINERS = 937;
	public static final int VEHICLE_CONTAINER = 938;
	//public static final int VEHICLE_CONNECTORS = 939;
	/* 94x - container */
	public static final int CONTAINER_INVENTORY_ITEM = 941;
	public static final int CONTAINER_INVENTORY_FLUID = 942;
	public static final int CONTAINER_INVENTORY_VAR = 943;
	/* 95x - multiblock block */
	public static final int MULTIBLOCK_CRAFT_MAIN = 952;
	public static final int MULTIBLOCK_CRAFT_CHOOSE = 953;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		EntityW entity = player.getCapability(Capabilities.PASSENGER, null).asWrapper();
		V3I pos = new V3I(x, y, z);
		switch(ID){
			case UIKey.ID12_TOOLBOX_COLORS:{
				return new UniCon(new ToolboxPaintContainer(FvtmResources.getJson("assets/fvtm/uis/toolbox_colors.json"), player, x), player);
			}
			case STREETSIGN_ADJUSTER: return new StreetSignAdjusterContainer(player, world, x, y, z);
			case JUNCTION_ADJUSTER: return new JunctionAdjusterContainer(player);
			//case ROADTOOL: return new RoadPlacerContainer(player, x, y, z);
			case ROADTOOLFILL: return new RoadPlacerFillContainer(player, x, y, z);
			case ROADTOOLCUSTOMFILL: return new RoadPlacerCustomFillContainer(player, x, y, z);
			case SPAWNSYS: return new SpawnSystemContainer(player, x, y, z);
			case RAILPLACER: return new RailPlacerContainer(player, x, y, z);
			case TSEDITOR: return new TrafficSignEditorContainer(player, x, y, z);
			case CONSTRUCTOR_MAIN:
				return new UniCon(new ConstructorContainer(FvtmResources.getJson("assets/fvtm/uis/constructor_main.json"), player, x, y, z), player);
			case CONSTRUCTOR_STATUS:
			case CONSTRUCTOR_CONTENTINFO:
			case CONSTRUCTOR_PARTINFO:
			case CONSTRUCTOR_PARTMANAGER:
			case CONSTRUCTOR_PARTINSTALLER: return new ConstContainer(player, world, x, y, z);
			case CONSTRUCTOR_TEXTUREMANAGER: return new ConstContainerTex(player, world, x, y, z);
			case CONSTRUCTOR_PAINTER: return new ConstContainer(player, world, x, y, z);
			case UIKey.ID12_VEHICLE_MAIN:
				return new UniCon(new VehicleMainCon(FvtmResources.getJson("assets/fvtm/uis/vehicle_main.json"), entity, pos), player);
			case UIKey.ID12_VEHICLE_FUEL:
				return new UniCon(new VehicleFuelConImpl(FvtmResources.getJson("assets/fvtm/uis/vehicle_fuel.json"), entity, pos), player);
			case UIKey.ID12_VEHICLE_TOGGABLES:
			case UIKey.ID12_VEHICLE_INVENTORIES:
			case UIKey.ID12_VEHICLE_CONTAINERS:
			case VEHICLE_CONTAINER:
			case UIKey.ID12_VEHICLE_CONNECTORS: return new VehicleContainer(player, world, x, y, z);
			case MULTIBLOCK_CRAFT_MAIN: return new GBlockCraftContainer(player, world, x, y, z);
			case MULTIBLOCK_CRAFT_CHOOSE: return new GBlockCraftChooseContainer(player, world, x, y, z);
			case WIRE_RELAY_MAIN:
			case WIRE_RELAY_EDIT:
			case WIRE_EDIT: return new WireRelayContainer(player, world, x, y, z, true);
			case UIKey.ID12_VEHICLE_ATTR_EDITOR: return new VehicleContainer(player, world, x, y, z);
			//case DECORATION_EDITOR: return new DecoEditorContainer(player, world, x);
			case UIKey.ID12_DECORATION_EDITOR:{
				if(DECORATION_CATEGORIES.isEmpty()) return null;
				return new UniCon(new DecoContainer(FvtmResources.getJson("assets/fvtm/uis/deco_editor.json"), player, x), player);
			}
			case VEHICLE_AND_PART_INFO: return new VehicleAndPartInfoContainer(player);
			//
			case UIKey.ID12_BLOCK_INVENTORY_ITEM:
			case VEHICLE_INVENTORY_ITEM:
			case CONTAINER_INVENTORY_ITEM:
			case UIKey.ID12_MULTIBLOCK_INVENTORY_ITEM: return new UniItemInvContainer(player, world, ID, x, y, z);
			case UIKey.ID12_BLOCK_INVENTORY_FLUID:
			case VEHICLE_INVENTORY_FLUID:
			case CONTAINER_INVENTORY_FLUID:
			case UIKey.ID12_MULTIBLOCK_INVENTORY_FLUID: return new UniFluidInvContainer(player, world, ID, x, y, z);
			case UIKey.ID12_BLOCK_INVENTORY_VAR:
			case VEHICLE_INVENTORY_VAR:
			case CONTAINER_INVENTORY_VAR:
			case UIKey.ID12_MULTIBLOCK_INVENTORY_VAR: return new UniVarInvContainer(player, world, ID, x, y, z);
			
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		try{
			EntityW entity = player.getCapability(Capabilities.PASSENGER, null).asWrapper();
			V3I pos = new V3I(x, y, z);
			switch(ID){
				case UIKey.ID12_TOOLBOX_COLORS: {
					JsonMap map = FvtmResources.INSTANCE.getJsonC("fvtm:uis/toolbox_colors.json");
					return new UniUI(new ToolboxPainter(map, new ToolboxPaintContainer(map, player, x)), player);
				}
				case STREETSIGN_ADJUSTER: return new StreetSignAdjuster(player, world, x, y, z);
				case JUNCTION_ADJUSTER: return new JunctionAdjuster(player);
				//case ROADTOOL: return new RoadPlacer(player, x, y, z);
				case ROADTOOLFILL: return new RoadPlacerFill(player, x, y, z);
				case ROADTOOLCUSTOMFILL: return new RoadPlacerCustomFill(player, x, y, z);
				case SPAWNSYS: return new SpawnSystemChooser(player, x, y, z);
				case RAILPLACER: return new RailPlacer(player, x, y, z);
				case TSEDITOR: return new TrafficSignEditor(player, x, y, z);
				//case CONSTRUCTOR_MAIN: return new ConstMain(player, world, x, y, z);
				case CONSTRUCTOR_MAIN:{
					JsonMap map = FvtmResources.INSTANCE.getJsonC("fvtm:uis/constructor_main.json");
					return new UniUI(new ConstructorMain(map, new ConstructorContainer(map, player, x, y, z)), player);
				}
				//case CONSTRUCTOR_STATUS: return new ConstStatus(player, world, x, y, z);
				case CONSTRUCTOR_CONTENTINFO: return new ConstContentData(player, world, x, y, z);
				//case CONSTRUCTOR_PARTINFO: return new ConstPartCache(player, world, x, y, z);
				case CONSTRUCTOR_PARTMANAGER: return new ConstPartManager(player, world, x, y, z);
				case CONSTRUCTOR_PARTINSTALLER: return new ConstPartInstaller(player, world, x, y, z);
				case CONSTRUCTOR_TEXTUREMANAGER: return new ConstTextureManager(player, world, x, y, z);
				case CONSTRUCTOR_PAINTER: return new ConstPainter(player, world, x, y, z);
				case UIKey.ID12_VEHICLE_MAIN:{
					JsonMap map = FvtmResources.INSTANCE.getJsonC("fvtm:uis/vehicle_main.json");
					return new UniUI(new VehicleMain(map, new VehicleMainCon(map, entity, pos)), player);
				}
				case UIKey.ID12_VEHICLE_FUEL: {
					JsonMap map = FvtmResources.INSTANCE.getJsonC("fvtm:uis/vehicle_fuel.json");
					return new UniUI(new VehicleFuel(map, new VehicleFuelConImpl(map, entity, pos)), player);
				}
				case UIKey.ID12_VEHICLE_TOGGABLES: return new VehicleToggables(player, world, x, y, z);
				case UIKey.ID12_VEHICLE_INVENTORIES: return new VehicleInventories(player, world, x, y, z);
				case UIKey.ID12_VEHICLE_CONTAINERS: return new VehicleContainers(player, world, x, y, z);
				case VEHICLE_CONTAINER: return new VehicleContainerSlot(player, world, x, y, z);
				case UIKey.ID12_VEHICLE_CONNECTORS: return new VehicleConnectors(player, world, x, y, z);
				case MULTIBLOCK_CRAFT_MAIN: return new GBlockCraft(player, world, x, y, z);
				case MULTIBLOCK_CRAFT_CHOOSE: return new GBlockCraftChoose(player, world, x, y, z);
				case WIRE_RELAY_MAIN: return new WireRelayChooser(player, world, x, y, z);
				case WIRE_RELAY_EDIT: return new WireRelayEditor(player, world, x, y, z);
				case WIRE_EDIT: return new WireEditor(player, world, x, y, z);
				case UIKey.ID12_VEHICLE_ATTR_EDITOR: return new AttributeEditor(player, world, x, y, z);
				//case DECORATION_EDITOR: return new DecoEditor(player, world, x);
				case UIKey.ID12_DECORATION_EDITOR: {
					if(DECORATION_CATEGORIES.isEmpty()) return null;
					JsonMap map = FvtmResources.INSTANCE.getJsonC("fvtm:uis/deco_editor.json");
					return new UniUI(new DecoEditor(map, new DecoContainer(map, player, x)), player);
				}
				case VEHICLE_AND_PART_INFO: return new VehicleAndPartInfo(player);
				//
				case UIKey.ID12_BLOCK_INVENTORY_ITEM:
				case VEHICLE_INVENTORY_ITEM:
				case CONTAINER_INVENTORY_ITEM:
				case UIKey.ID12_MULTIBLOCK_INVENTORY_ITEM: return new UniItemInvUi(player, world, ID, x, y, z);
				case UIKey.ID12_BLOCK_INVENTORY_FLUID:
				case VEHICLE_INVENTORY_FLUID:
				case CONTAINER_INVENTORY_FLUID:
				case UIKey.ID12_MULTIBLOCK_INVENTORY_FLUID: return new UniFluidInvUi(player, world, ID, x, y, z);
				case UIKey.ID12_BLOCK_INVENTORY_VAR:
				case VEHICLE_INVENTORY_VAR:
				case CONTAINER_INVENTORY_VAR:
				case UIKey.ID12_MULTIBLOCK_INVENTORY_VAR: return new UniVarInvUi(player, world, ID, x, y, z);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static NBTTagCompound validate(EntityPlayer player, NBTTagCompound compound, boolean client){
		if(compound != null) return compound;
		if(client){
			if(Static.dev()) Print.log("Getting client compound " + CLIENT_GUIDATA_CACHE);
			compound = CLIENT_GUIDATA_CACHE;
			CLIENT_GUIDATA_CACHE = null;
			return compound;
		}
		else{
			if(Static.dev()) Print.log("Getting server compound " + SERVER_GUIDATA_CACHE.get(player.getGameProfile().getId().toString()));
			return SERVER_GUIDATA_CACHE.remove(player.getGameProfile().getId().toString());
		}
	}

}
