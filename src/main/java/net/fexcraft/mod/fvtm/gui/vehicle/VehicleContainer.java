package net.fexcraft.mod.fvtm.gui.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleContainer extends GenericContainer {
	
	protected GenericGui<VehicleContainer> gui;
	@Nullable protected NBTTagCompound initpacket;

	public VehicleContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
	}
	
	public VehicleContainer(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(player); initpacket = compound;
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//
	}

}
