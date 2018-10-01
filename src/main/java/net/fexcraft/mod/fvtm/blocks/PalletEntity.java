package net.fexcraft.mod.fvtm.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PalletEntity extends TileEntity {

	public PalletEntity(World world, int meta){
		this(); if(world == null) this.world = world;
	}

	public PalletEntity(){}

}
