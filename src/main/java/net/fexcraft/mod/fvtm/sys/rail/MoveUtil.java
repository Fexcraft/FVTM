package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailData;

/**
 * Movement Utility
 * @author Ferdinand Calo' (FEX___96)
**/
public class MoveUtil {

	public static void attach(RailRegion region){
		// TODO Auto-generated method stub
		
	}

	public static void detach(RailRegion region){
		// TODO Auto-generated method stub
		
	}

	public static ObjCon<Double, Boolean, Object> moveEntity(RailEntity entity, double amount, boolean reverse){
		if(amount == 0f || (amount < 0.001 && amount > 0.001)){
			new ObjCon<Double, Boolean, Object>(amount, reverse, null);
		}
		WorldRailData raildata = entity.getRegion().getUtil();
		amount = testDistance(raildata, entity.current, entity.passed, reverse ? -amount : amount);
		if(amount == 0f || (amount < 0.001 && amount > 0.001)){
			new ObjCon<Double, Boolean, Object>(amount, reverse, null);
		}
		ObjCon<Track, Double, Vec3f> obj = travelDistance(raildata, new ObjCon<Track, Double, Double>(entity.current, entity.passed, amount), reverse);
		entity.last = entity.current; entity.current = obj.fir; entity.passed = obj.sec;
		//if(!entity.last_track.equals(entity.curr_track)) entity.reverse = false;
		//
		entity.updateRailRegion();
		entity.ppx = entity.px; entity.ppy = entity.py; entity.ppz = entity.pz;
		entity.px = obj.tir.xCoord; entity.py = obj.tir.yCoord; entity.pz = obj.tir.zCoord;
		return new ObjCon<Double, Boolean, Object>(amount, reverse, null);
	}
	
	private static Track getPrev(WorldRailData raildata, Track track, boolean reverse){
		if(track == null) Static.exception(null, false);
		Junction junk = raildata.getJunction(track.start);
		track = junk == null ? null : junk.getNext(track.getId());
		return track == null ? null : reverse ? track.oppositeCopy() : track;
	}
	
	private static Track getNext(WorldRailData raildata, Track track, boolean reverse){
		if(track == null) Static.exception(null, false);
		Junction junk = raildata.getJunction(track.end);
		return junk == null ? null : junk.getNext(track.getOppositeId());
	}

	/** Returns the possible amount of movement on this path, based on position and expected input. */
	public static double testDistance(WorldRailData raildata, Track at, double passed, double expected){
		double travel = passed + expected;
		if(travel > at.length){
			Track track = getNext(raildata, at, false);
			if(track == null) return at.length - passed;
			else return testDistance(raildata, track, 0, travel - at.length);
		}
		else if(travel < 0){
			Track track = getPrev(raildata, at, false);
			if(track == null) return 0;//passed;
			else return testDistance(raildata, track, 0, Math.abs(travel));
		}
		else{
			return expected;
		}
	}
	
	/** 
	 * @param obj Track-At / Passed / Expected
	 * @param reverse REVERSE
	 * @return Track-At / Passed / Position
	**/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ObjCon<Track, Double, Vec3f> travelDistance(WorldRailData raildata, ObjCon<Track, Double, Double> obj, boolean reverse){
		double travel = obj.sec + (reverse ? -obj.tir : obj.tir);
		if(travel > obj.fir.length){
			Track track = getNext(raildata, obj.fir, reverse);
			if(track == null){
				return new ObjCon(obj.fir, obj.fir.length + 0D, Track.blkposToVec3f(obj.fir.end));
			}
			else{
				return travelDistance(raildata, new ObjCon(track, 0D, travel - obj.fir.length), reverse);
			}
		}
		else if(travel < 0){
			Track track = getPrev(raildata, obj.fir, reverse);
			if(track == null){
				return new ObjCon(obj.fir, 0D, Track.blkposToVec3f(obj.fir.start));
			}
			else{
				travel = Math.abs(travel); //if(reverse) travel = track.length - travel;
				return travelDistance(raildata, new ObjCon(track, reverse ? track.length : 0D, travel), reverse);
			}
		}
		else{
			return new ObjCon(obj.fir, travel, obj.fir.getVectorPosition((float)travel, reverse));
		}
	}
	
	/** Object Container **/
	public static class ObjCon<A, B, C> {
		
		public A fir; public B sec; public C tir;
		
		public ObjCon(A aa, B bb, C cc){
			this.fir = aa; this.sec = bb; this.tir = cc;
		}
		
	}
	
}