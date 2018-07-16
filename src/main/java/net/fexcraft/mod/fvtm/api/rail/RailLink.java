package net.fexcraft.mod.fvtm.api.rail;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class RailLink {
	
	private Vec3d _2x, _1x, _0x;
	private BlockPos pos, dest, next;
	
	public RailLink(BlockPos start, BlockPos dest, BlockPos next){
		this.pos = start; this.dest = dest; this.next = next;
		this.initVectors();
	}
	
	private void initVectors(){
		_2x = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		_1x = new Vec3d(dest.getX() + 0.5, dest.getY() + 0.5, dest.getZ() + 0.5);;
		_0x = new Vec3d(next.getX() + 0.5, next.getY() + 0.5, next.getZ() + 0.5);
	}
	
	public RailLink(NBTTagCompound compound){
		pos = BlockPos.fromLong(compound.getLong("origin"));
		dest = BlockPos.fromLong(compound.getLong("dest"));
		next = BlockPos.fromLong(compound.getLong("next"));
		this.initVectors();
	}

	public double length(){
	    double dx = _2x.x - _1x.x, dy = _2x.y - _1x.y;
	    double etr = Math.sqrt(dx * dx + dy * dy);
	    return etr < 0.001 ? 0 : etr;
	}
	
	public double lengthB(){
	    double dx = _2x.x - _0x.x, dy = _2x.y - _0x.y;
	    double etr = Math.sqrt(dx * dx + dy * dy);
	    return etr < 0.001 ? 0 : etr;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		compound = compound == null ? new NBTTagCompound() : compound;
		compound.setLong("origin", pos.toLong());
		compound.setLong("dest", dest.toLong());
		compound.setLong("next", next.toLong());
		return compound;
	}
	
	public Vec3d getStart(){
		return _2x;
	}
	
	public Vec3d getDestination(){
		return _1x;
	}
	
	public Vec3d getNext(){
		return _0x;
	}
	
	public BlockPos getStartPos(){
		return pos;
	}
	
	public BlockPos getDestinationPos(){
		return dest;
	}
	
	public BlockPos getNextPos(){
		return next;
	}
	
}