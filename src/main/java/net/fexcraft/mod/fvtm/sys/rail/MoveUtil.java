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

	public static double moveEntity(RailEntity entity, double amount){//, boolean reverse){
		WorldRailData raildata = entity.getRegion().getUtil();
		boolean reverse = amount < 0;
		amount = testDistance(raildata, entity.current, entity.passed, amount);//+ (reverse ? entity.rearconndis : entity.frontconndis)
		//amount -= reverse ? entity.rearconndis : entity.frontconndis;
		ObjCon<Track, Double, Vec3f> obj = travelDistance(raildata, new ObjCon<Track, Double, Double>(entity.current, entity.passed, amount = reverse ? -amount : amount));
		entity.last = entity.current; entity.current = obj.fir; entity.passed = obj.sec;
		//if(!entity.last_track.equals(entity.curr_track)) entity.reverse = false;
		//
		entity.updateRailRegion();
		entity.ppx = entity.px; entity.ppy = entity.py; entity.ppz = entity.pz;
		entity.px = obj.tir.xCoord; entity.py = obj.tir.yCoord; entity.pz = obj.tir.zCoord;
		return amount;
		//
		//
		/*if(reverse) amount = -amount;
		boolean negative = amount < 0; amount = testDistance(raildata, entity.curr_track, entity.passed, amount);
		//if(negative) amount = -amount;
		//
		if(negative){
			if(amount < entity.passed){
				float[] pos = entity.curr_track.getPosition((float)(entity.passed -= amount));
				entity.setPosition(pos[0], pos[1], pos[2]);
			}
			else{
				entity.last_track = entity.curr_track; entity.curr_track = getPrev(raildata, entity.curr_track);
				amount -= entity.passed; entity.passed = 0;
			}
		}
		float[] newpos = new float[]{ (float)amount };
		while(newpos.length == 1){
			amount = newpos[0];
			entity.last_track = entity.curr_track; entity.curr_track = getNext(raildata, entity.curr_track);
			if(entity.curr_track == null){
				entity.curr_track = entity.last_track;
				newpos = Track.blkposToVec3f(entity.curr_track.end).toFloatArray();
				entity.passed = entity.curr_track.length;
			}
			else{
				newpos = entity.curr_track.getPosition((float)amount);
				entity.passed = amount;
			}
		}
		entity.setPosition(newpos[0], newpos[1], newpos[2]);*/
	}
	
	private static Track getPrev(WorldRailData raildata, Track track){
		if(track == null) Static.exception(null, false);
		Junction junk = raildata.getJunction(track.start);
		return junk == null ? null : junk.getNext(track.getId());
	}
	
	private static Track getNext(WorldRailData raildata, Track track){
		if(track == null) Static.exception(null, false);
		Junction junk = raildata.getJunction(track.end);
		return junk == null ? null : junk.getNext(track.getOppositeId());
	}

	/** Returns the possible amount of movement on this path, based on position and expected input. */
	public static double testDistance(WorldRailData raildata, Track at, double passed, double expected){
		double travel = passed + expected;
		if(travel > at.length){
			Track track = getNext(raildata, at);
			if(track == null) return at.length - passed;
			else return testDistance(raildata, track, 0, travel - at.length);
		}
		else if(travel < 0){
			Track track = getPrev(raildata, at);
			if(track == null) return 0;//passed;
			else return testDistance(raildata, track, 0, Math.abs(travel));
		}
		else{
			return expected;
		}
	}
	
	/** 
	 * @param obj Track-At / Passed / Expected
	 * @return Track-At / Passed / Position
	**/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ObjCon<Track, Double, Vec3f> travelDistance(WorldRailData raildata, ObjCon<Track, Double, Double> obj){
		double travel = obj.sec + obj.tir;
		if(travel > obj.fir.length){
			Track track = getNext(raildata, obj.fir);
			if(track == null){
				return new ObjCon(obj.fir, obj.fir.length + 0D, Track.blkposToVec3f(obj.fir.end));
			}
			else{
				return travelDistance(raildata, new ObjCon(track, 0D, travel - obj.fir.length));
			}
		}
		else if(travel < 0){
			Track track = getPrev(raildata, obj.fir);
			if(track == null){
				return new ObjCon(obj.fir, 0, Track.blkposToVec3f(obj.fir.start));
			}
			else return travelDistance(raildata, new ObjCon(track, 0D, Math.abs(travel)));
		}
		else{
			return new ObjCon(obj.fir, travel, obj.fir.getVectorPosition((float)travel));
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