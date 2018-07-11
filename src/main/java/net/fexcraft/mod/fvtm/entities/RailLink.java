package net.fexcraft.mod.fvtm.entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class RailLink {
	
	public Vec3d _2x, _1x;
	
	public RailLink(BlockPos pos0, BlockPos pos){
		_2x = new Vec3d(pos0.getX() + 0.5, pos0.getY() + 0.5, pos0.getZ() + 0.5);
		_1x = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
	}
	
	public RailLink(NBTTagCompound compound){
		_2x = new Vec3d(compound.getDouble("origin_x"), compound.getDouble("origin_y"), compound.getDouble("origin_z"));
		_1x = new Vec3d(compound.getDouble("dest_x"), compound.getDouble("dest_y"), compound.getDouble("dest_z"));
	}

	public double length(){
	    double dx = _2x.x - _1x.x, dy = _2x.y - _1x.y;
	    double etr = Math.sqrt(dx * dx + dy * dy);
	    return etr < 0.001 ? 0 : etr;
	}

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setDouble("origin_x", _2x.x);
		compound.setDouble("origin_y", _2x.y);
		compound.setDouble("origin_z", _2x.z);
		compound.setDouble("dest_x", _1x.x);
		compound.setDouble("dest_y", _1x.y);
		compound.setDouble("dest_z", _1x.z);
		return compound;
	}
	
}