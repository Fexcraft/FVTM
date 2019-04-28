package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorContainer extends GenericContainer {

	public ConstructorContainer(EntityPlayer player, World world, int x, int y, int z){
		
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//TODO
	}

}
