package net.fexcraft.mod.fvtm.gui.other;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleAndPartInfoContainer extends GenericContainer {
	
	public VehicleAndPartInfoContainer(EntityPlayer player){
		super(player);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//
	}

}
