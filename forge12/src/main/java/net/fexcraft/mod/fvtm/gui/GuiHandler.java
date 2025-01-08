package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.uni.ui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import java.util.HashMap;

public class GuiHandler implements IGuiHandler {
	
	public static NBTTagCompound CLIENT_GUIDATA_CACHE;
	public static final HashMap<String, NBTTagCompound> SERVER_GUIDATA_CACHE = new HashMap<>();
	public static final String LISTENERID = "fvtm:gui";

	/* 7xx - other */
	public static final int STREETSIGN_ADJUSTER = 700;
	//public static final int ROADTOOL = 702-704;
	//public static final int SPAWNSYS = 705;
	public static final int RAILPLACER = 706;
	public static final int TSEDITOR = 709;
	public static final int WIRE_RELAY_MAIN = 710;
	public static final int WIRE_RELAY_EDIT = 711;
	public static final int WIRE_EDIT = 712;
	//public static final int DECORATION_EDITOR = 713;
	public static final int VEHICLE_AND_PART_INFO = 714;
	/* 90x - constructor main */
	//
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
	//public static final int VEHICLE_INVENTORY_ITEM = 9361;
	//public static final int VEHICLE_INVENTORY_FLUID = 9362;
	//public static final int VEHICLE_INVENTORY_VAR = 9363;
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
		return UIUtils.getServer("fvtm", ID, player, x, y, z);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		return UIUtils.getClient("fvtm", ID, player, x, y, z);
	}

}
