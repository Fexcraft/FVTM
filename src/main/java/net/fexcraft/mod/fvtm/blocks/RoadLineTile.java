package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.lib.util.math.Vec3f;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RoadLineTile extends TileEntity {

	public Vec3f[][] lines;

	public RoadLineTile(World world){
		this.world = world;
	}
	
}