package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.uni.ui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final String LISTENERID = "fvtm:gui";

	/* 7xx - other */
	public static final int WIRE_RELAY_EDIT = 711;
	public static final int WIRE_EDIT = 712;
	public static final int VEHICLE_AND_PART_INFO = 714;
	/* 90x - constructor main */
	/* 91x - part cache */
	/* 92x - installed part */
	/* 93x - vehicle */
	public static final int VEHICLE_CONTAINER = 938;
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
