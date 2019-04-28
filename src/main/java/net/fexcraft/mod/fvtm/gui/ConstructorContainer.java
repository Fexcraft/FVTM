package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.mod.fvtm.block.ConstructorEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorContainer extends GenericContainer {
	
	protected ConstructorEntity entity;

	public ConstructorContainer(EntityPlayer player, World world, int x, int y, int z){
		this.entity = (ConstructorEntity)world.getTileEntity(new BlockPos(x, y, z));
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		entity.processGUIPacket(side, packet, player);
	}

}
