package net.fexcraft.mod.fvtm.blocks.rail;

import net.minecraft.util.math.Vec3d;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailUtil {
	
	public Vec3d findNext(Vec3d pos, Vec3d subp, Connection current, Connection last, double amount){
		if(amount < -0.001) return move(pos, subp, last, current, -amount);
		return subp;
	}
	
	public Vec3d move(Vec3d pos, Vec3d curr, Connection current, Connection last, double amount){
		return findNext(pos, curr, current, last, amount);
	}
	
}