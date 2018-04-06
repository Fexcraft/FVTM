package net.fexcraft.mod.fvtm.util.rail;

import net.minecraft.util.math.Vec3d;

public class RailPiece {
	
	private Vec3d prev, own, next;
	
	public RailPiece(Vec3d start, Vec3d mine, Vec3d end){
		prev = start; own = mine; next = end;
	}
	
}