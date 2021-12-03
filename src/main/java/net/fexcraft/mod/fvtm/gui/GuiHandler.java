package net.fexcraft.mod.fvtm.gui;

import java.util.HashMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraft;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraftChoose;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraftChooseContainer;
import net.fexcraft.mod.fvtm.gui.block.GBlockCraftContainer;
import net.fexcraft.mod.fvtm.gui.block.GBlockInvContainer;
import net.fexcraft.mod.fvtm.gui.block.GBlockInventory;
import net.fexcraft.mod.fvtm.gui.constructor.*;
import net.fexcraft.mod.fvtm.gui.container.ContainerFluidInventory;
import net.fexcraft.mod.fvtm.gui.container.ContainerInvContainer;
import net.fexcraft.mod.fvtm.gui.container.ContainerItemInventory;
import net.fexcraft.mod.fvtm.gui.junction.JunctionAdjuster;
import net.fexcraft.mod.fvtm.gui.junction.JunctionAdjusterContainer;
import net.fexcraft.mod.fvtm.gui.other.SpawnSystemChooser;
import net.fexcraft.mod.fvtm.gui.other.SpawnSystemContainer;
import net.fexcraft.mod.fvtm.gui.rail.RailPlacer;
import net.fexcraft.mod.fvtm.gui.rail.RailPlacerContainer;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacer;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerContainer;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerCustomFill;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerCustomFillContainer;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerFill;
import net.fexcraft.mod.fvtm.gui.road.RoadPlacerFillContainer;
import net.fexcraft.mod.fvtm.gui.sign.StreetSignAdjuster;
import net.fexcraft.mod.fvtm.gui.sign.StreetSignAdjusterContainer;
import net.fexcraft.mod.fvtm.gui.vehicle.*;
import net.fexcraft.mod.fvtm.gui.wire.WireEditor;
import net.fexcraft.mod.fvtm.gui.wire.WireRelayChooser;
import net.fexcraft.mod.fvtm.gui.wire.WireRelayContainer;
import net.fexcraft.mod.fvtm.gui.wire.WireRelayEditor;
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
	public static final int ROADTOOL = 702;
	public static final int ROADTOOLFILL = 703;
	public static final int ROADTOOLCUSTOMFILL = 704;
	public static final int SPAWNSYS = 705;
	public static final int RAILPLACER = 706;
	public static final int WIRE_RELAY_MAIN = 710;
	public static final int WIRE_RELAY_EDIT = 711;
	public static final int WIRE_EDIT = 712;
	/* 90x - constructor main */
	public static final int CONSTRUCTOR_MAIN = 900;
	public static final int CONSTRUCTOR_STATUS = 901;
	public static final int CONSTRUCTOR_VEHINFO = 902;
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
	public static final int VEHICLE_MAIN = 930;
	public static final int VEHICLE_FUEL = 933;
	public static final int VEHICLE_TOGGABLES = 934;
	public static final int VEHICLE_INVENTORIES = 935;
	public static final int VEHICLE_INVENTORY = 936;
	public static final int VEHICLE_CONTAINERS = 937;
	public static final int VEHICLE_CONTAINER = 938;
	public static final int VEHICLE_CONNECTORS = 939;
	public static final int VEHICLE_ATTRIBUTE_EDITOR = 932;
	/* 94x - container */
	public static final int CONTAINER_ITEM = 941;
	public static final int CONTAINER_FLUID = 942;
	/* 95x - generated block */
	public static final int MULTIBLOCK_INVENTORY = 951;
	public static final int MULTIBLOCK_CRAFT_MAIN = 952;
	public static final int MULTIBLOCK_CRAFT_CHOOSE = 953;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		switch(ID){
			case STREETSIGN_ADJUSTER: return new StreetSignAdjusterContainer(player, world, x, y, z);
			case JUNCTION_ADJUSTER: return new JunctionAdjusterContainer(player);
			case ROADTOOL: return new RoadPlacerContainer(player, x, y, z);
			case ROADTOOLFILL: return new RoadPlacerFillContainer(player, x, y, z);
			case ROADTOOLCUSTOMFILL: return new RoadPlacerCustomFillContainer(player, x, y, z);
			case SPAWNSYS: return new SpawnSystemContainer(player, x, y, z);
			case RAILPLACER: return new RailPlacerContainer(player, x, y, z);
			case CONSTRUCTOR_MAIN:
			case CONSTRUCTOR_STATUS:
			case CONSTRUCTOR_VEHINFO:
			case CONSTRUCTOR_PARTINFO:
			case CONSTRUCTOR_PARTMANAGER:
			case CONSTRUCTOR_PARTINSTALLER: return new ConstructorContainer(player, world, x, y, z);
			case CONSTRUCTOR_TEXTUREMANAGER: return new ConstructorContainerVTM(player, world, x, y, z);
			case CONSTRUCTOR_PAINTER: return new ConstructorContainer(player, world, x, y, z);
			case VEHICLE_MAIN:
			case VEHICLE_FUEL:
			case VEHICLE_TOGGABLES:
			case VEHICLE_INVENTORIES:
			case VEHICLE_INVENTORY:
			case VEHICLE_CONTAINERS:
			case VEHICLE_CONTAINER:
			case VEHICLE_CONNECTORS: return new VehicleContainer(player, world, x, y, z);
			case CONTAINER_ITEM:
			case CONTAINER_FLUID: return new ContainerInvContainer(player, world, x, y, z);
			case MULTIBLOCK_INVENTORY: return new GBlockInvContainer(player, world, x, y, z);
			case MULTIBLOCK_CRAFT_MAIN: return new GBlockCraftContainer(player, world, x, y, z);
			case MULTIBLOCK_CRAFT_CHOOSE: return new GBlockCraftChooseContainer(player, world, x, y, z);
			case WIRE_RELAY_MAIN:
			case WIRE_RELAY_EDIT:
			case WIRE_EDIT: return new WireRelayContainer(player, world, x, y, z, true);
			case VEHICLE_ATTRIBUTE_EDITOR: return new VehicleContainer(player, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		try{
			switch(ID){
				case STREETSIGN_ADJUSTER: return new StreetSignAdjuster(player, world, x, y, z);
				case JUNCTION_ADJUSTER: return new JunctionAdjuster(player);
				case ROADTOOL: return new RoadPlacer(player, x, y, z);
				case ROADTOOLFILL: return new RoadPlacerFill(player, x, y, z);
				case ROADTOOLCUSTOMFILL: return new RoadPlacerCustomFill(player, x, y, z);
				case SPAWNSYS: return new SpawnSystemChooser(player, x, y, z);
				case RAILPLACER: return new RailPlacer(player, x, y, z);
				case CONSTRUCTOR_MAIN: return new ConstructorMain(player, world, x, y, z);
				case CONSTRUCTOR_STATUS: return new ConstructorStatus(player, world, x, y, z);
				case CONSTRUCTOR_VEHINFO: return new ConstructorVehicleInfo(player, world, x, y, z);
				case CONSTRUCTOR_PARTINFO: return new ConstructorPartCacheInfo(player, world, x, y, z);
				case CONSTRUCTOR_PARTMANAGER: return new ConstructorPartManager(player, world, x, y, z);
				case CONSTRUCTOR_PARTINSTALLER: return new ConstructorPartInstaller(player, world, x, y, z);
				case CONSTRUCTOR_TEXTUREMANAGER: return new ConstructorVTM(player, world, x, y, z);
				case CONSTRUCTOR_PAINTER: return new ConstructorVP(player, world, x, y, z);
				case VEHICLE_MAIN: return new VehicleMain(player, world, x, y, z);
				case VEHICLE_FUEL: return new VehicleFuel(player, world, x, y, z);
				case VEHICLE_TOGGABLES: return new VehicleToggables(player, world, x, y, z);
				case VEHICLE_INVENTORIES: return new VehicleInventories(player, world, x, y, z);
				case VEHICLE_INVENTORY: return new VehicleInventory(player, world, x, y, z);
				case VEHICLE_CONTAINERS: return new VehicleContainers(player, world, x, y, z);
				case VEHICLE_CONTAINER: return new VehicleContainerSlot(player, world, x, y, z);
				case VEHICLE_CONNECTORS: return new VehicleConnectors(player, world, x, y, z);
				case CONTAINER_ITEM: return new ContainerItemInventory(player, world, x, y, z);
				case CONTAINER_FLUID: return new ContainerFluidInventory(player, world, x, y, z);
				case MULTIBLOCK_INVENTORY: return new GBlockInventory(player, world, x, y, z);
				case MULTIBLOCK_CRAFT_MAIN: return new GBlockCraft(player, world, x, y, z);
				case MULTIBLOCK_CRAFT_CHOOSE: return new GBlockCraftChoose(player, world, x, y, z);
				case WIRE_RELAY_MAIN: return new WireRelayChooser(player, world, x, y, z);
				case WIRE_RELAY_EDIT: return new WireRelayEditor(player, world, x, y, z);
				case WIRE_EDIT: return new WireEditor(player, world, x, y, z);
				case VEHICLE_ATTRIBUTE_EDITOR: return new AttributeEditor(player, world, x, y, z);
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
