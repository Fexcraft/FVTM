package net.fexcraft.mod.fvtm.gui;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.gui.junction.JunctionAdjuster;
import net.fexcraft.mod.fvtm.gui.junction.JunctionAdjusterContainer;
import net.fexcraft.mod.fvtm.gui.sign.StreetSignAdjuster;
import net.fexcraft.mod.fvtm.gui.sign.StreetSignAdjusterContainer;
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
	//900 - const main
	//910 - part cache
	//920 - installed part
	//930 - vehicle
	//940 - container
	//950 - gen block

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		switch(ID){
			case STREETSIGN_ADJUSTER: return new StreetSignAdjusterContainer(player, world, x, y, z);
			case JUNCTION_ADJUSTER: return new JunctionAdjusterContainer(player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		try{
			switch(ID){
				case STREETSIGN_ADJUSTER: return new StreetSignAdjuster(player, world, x, y, z);
				case JUNCTION_ADJUSTER: return new JunctionAdjuster(player);
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
			compound = CLIENT_GUIDATA_CACHE;
			CLIENT_GUIDATA_CACHE = null;
			return compound;
		}
		else{
			return SERVER_GUIDATA_CACHE.remove(player.getGameProfile().getId().toString());
		}
	}

}
