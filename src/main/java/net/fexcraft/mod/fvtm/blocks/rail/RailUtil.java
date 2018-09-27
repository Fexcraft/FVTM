package net.fexcraft.mod.fvtm.blocks.rail;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.util.Vector3D;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailUtil {
	
	public static final Return getExpectedPosition(World world, double[] own, BlockPos curr, BlockPos last, double amount){
		if(amount == 0) return new Return(own, curr, last); if(amount < 0) return move(world, own, last, curr, -amount);
		if(amount < 0.001 && amount > -0.001) return new Return(own, curr, last);
		double[] dest = Vector3D.newVector(curr);
		while(Double.compare(amount, Vector3D.distance(own, dest)) >= 0){
    		amount -= Vector3D.distance(own, dest);
    		if(amount < 0.001 && amount > -0.001){ break; }
    		//
    		RailLink link = CONNS.get(curr);
    		if(link == null){
        		TrackTileEntity tile = (TrackTileEntity)world.getTileEntity(new BlockPos(curr));
        		if(tile == null) return new Return(own, curr, last);
        		BlockPos pos = tile.getNext(curr, last); //Print.debug(curr, last, pos);
        		last = curr; curr = pos;
    		}
    		else if(link.next.equals(last)){
    			curr = link.prev; last = link.self;
    		}
    		else if(link.prev.equals(last)){
    			curr = link.next; last = link.self;
    		}
    		//
			own = Vector3D.newVector(last); dest = Vector3D.newVector(curr);
		}
    	dest = Vector3D.direction(dest[0] - own[0], dest[1] - own[1], dest[2] - own[2]);
    	dest = Vector3D.newVector(own[0] + (dest[0] * amount), own[1] + (dest[1] * amount), own[2] + (dest[2] * amount));
		return new Return(dest, curr, last);
	}
	
	public static final Return move(World world, double[] own, BlockPos curr, BlockPos last, double amount){
		return getExpectedPosition(world, own, curr, last, amount);
	}

	public static final Return move(World world, double[] own, BlockPos curr, BlockPos last, double amount, boolean reverse){
		return getExpectedPosition(world, own, reverse ? last : curr, reverse ? curr : last, amount);
	}
	
	public static final Return move(World world, Vec3d own, BlockPos curr, BlockPos last, double amount){
		return getExpectedPosition(world, new double[]{ own.x, own.y, own.z }, curr, last, amount);
	}
	
	public static class Return {
		
		public BlockPos curr, last;
		public double[] dest;
		
		public Return(double[] dest, BlockPos curr, BlockPos last){
			this.dest = dest; this.curr = curr; this.last = last;
		}
		
		@Override
		public String toString(){
			return String.format("[ DX:%s, DY: %s, DZ:%s ] || [ CX:%s, CY: %s, CZ:%s ] || [ LX:%s, LY: %s, LZ:%s ]",
				dest[0], dest[1], dest[2], curr.getX(), curr.getY(), curr.getZ(), last.getX(), last.getY(), last.getZ());
		}
		
	}
	
	private static final TreeMap<BlockPos, RailLink> CONNS = new TreeMap<BlockPos, RailLink>();

	public static void update(TrackTileEntity tile, boolean addition){
		attach(tile);
	}

	public static void detach(TrackTileEntity tile){
		for(Connection conn : tile.connections){
			BlockPos[] all = conn.allPositions();
			for(BlockPos pos : all){
				if(CONNS.containsKey(pos)){
					CONNS.remove(pos);
				}
			}
		}
	}

	public static void attach(TrackTileEntity tile){
		detach(tile);
		for(Connection conn : tile.connections){
			BlockPos[] all = conn.getPoints();
			if(all.length < 2) continue;
			CONNS.put(all[0], new RailLink(conn.getBeginning(), all[0], all[1]));
			for(int i = 1; i < all.length - 1; i++) CONNS.put(all[i], new RailLink(all[i - 1], all[i], all[i + 1]));
			CONNS.put(all[all.length - 1], new RailLink(all[all.length - 2], all[all.length - 1], conn.getDestination()));
		}
	}
	
}