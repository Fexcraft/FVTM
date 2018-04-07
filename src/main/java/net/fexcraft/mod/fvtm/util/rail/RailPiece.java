package net.fexcraft.mod.fvtm.util.rail;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class RailPiece {
	
	public BlockPos ownpos;
	public Vec3d prev, own, next;
	
	public RailPiece(Vec3d start, Vec3d mid, BlockPos mine, Vec3d end){
		prev = start; ownpos = mine; next = end; own = mid;
	}
	
	public RailPiece(NBTTagCompound compound){
		ownpos = BlockPos.fromLong(compound.getLong("pos"));
		prev = new Vec3d(compound.getDouble("prev_x"), compound.getDouble("prev_y"), compound.getDouble("prev_z"));
		own = new Vec3d(compound.getDouble("own_x"), compound.getDouble("own_y"), compound.getDouble("own_z"));
		next = new Vec3d(compound.getDouble("next_x"), compound.getDouble("next_y"), compound.getDouble("next_z"));
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Vec3d){
			return own.equals(obj);
		}
		return super.equals(obj);
	}

	public NBTTagCompound writeToNBT(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setDouble("prev_x", prev.x);
		compound.setDouble("prev_y", prev.y);
		compound.setDouble("prev_z", prev.z);
		compound.setDouble("own_x", own.x);
		compound.setDouble("own_y", own.y);
		compound.setDouble("own_z", own.z);
		compound.setDouble("next_x", next.x);
		compound.setDouble("next_y", next.y);
		compound.setDouble("next_z", next.z);
		compound.setLong("pos", ownpos.toLong());
		return compound;
	}
	
}