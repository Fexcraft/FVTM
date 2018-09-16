package net.fexcraft.mod.fvtm.blocks.rail;

import net.fexcraft.mod.fvtm.util.Vector3D;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailUtil {
	
	public static final Return findNext(World world, Vec3d pos, Vec3d subp, Vec3d last, Connection conn, double amount){
		if(amount == 0) return new Return(conn, pos, subp, last); if(amount < 0) return move(world, pos, last, subp, conn, -amount);
		double[] own = new double[]{ pos.x, pos.y, pos.z }, dest = new double[]{ subp.x, subp.y, subp.z };
		while(amount > 0.001){
			amount -= Vector3D.distance(own, dest);
			if(amount < 0.001D) break; if(conn == null) break;
			Object[] obj = conn.getNext(world, subp, last);
			if(obj == null || obj.length < 2) break;
			Vec3d vec = (Vec3d)obj[0]; conn = (Connection)obj[1];
			if(vec == null || subp.equals(vec)) break;
			last = subp; subp = vec;
			//
			own = new double[]{ last.x, last.y, last.z };
			dest = new double[]{ subp.x, subp.y, subp.z };
		}
    	dest = Vector3D.direction(dest[0] - own[0], dest[1] - own[1], dest[2] - own[2]);
    	dest = Vector3D.newVector(own[0] + (dest[0] * amount), own[1] + (dest[1] * amount), own[2] + (dest[2] * amount));
		return new Return(conn, new Vec3d(dest[0], dest[1], dest[2]), subp, last);
	}
	
	public static final Return move(World world, Vec3d pos, Vec3d subp, Vec3d last, Connection conn, double amount){
		return findNext(world, pos, subp, last, conn, amount);
	}

	public static final Vec3d newVector(BlockPos next){
		return new Vec3d(next.getX(), next.getY(), next.getZ());
	}
	
	public static class Return {
		
		public Vec3d dest, curr, last;
		public Connection connection;
		
		public Return(Connection conn, Vec3d... vecs){
			this.connection = conn; dest = vecs[0]; curr = vecs[1]; last = vecs[2];
		}
		
	}
	
}