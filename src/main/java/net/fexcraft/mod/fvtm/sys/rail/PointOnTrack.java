package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.sys.rail.MoveUtil.ObjCon;
import net.minecraft.util.math.AxisAlignedBB;

public class PointOnTrack {
	
	public Track curr, last;
	//public double passed;
	public RailEntity entity;
	public Type pointtype;
	public LineSection section_on;
	private double offset;
	public Vec3f position;
	
	public PointOnTrack(RailEntity ent, Type type){
		this.entity = ent; this.pointtype = type;
		this.offset = type.getOffset(ent);
		this.curr = ent.current; this.last = ent.last;
	}
	
	public static enum Type {
		
		COUPLER_FRONT(false), COUPLER_REAR(true), BOGIE_FRONT(false), BOGIE_REAR(true);
		
		boolean opposite;
		
		Type(boolean opp){
			this.opposite = opp;
		}

		public double getOffset(RailEntity ent){
			switch(this){
				case BOGIE_FRONT: return ent.vehdata.getWheelPos().get(0).to16FloatX();
				case BOGIE_REAR: return ent.vehdata.getWheelPos().get(1).to16FloatX();
				case COUPLER_FRONT: return ent.vehdata.getFrontConnectorPos().to16FloatX();
				case COUPLER_REAR: return ent.vehdata.getRearConnectorPos().to16FloatX();
				default: return 0;
			}
		}

		public boolean isCoupler(){
			return this == COUPLER_FRONT || this == COUPLER_REAR;
		}
		
	}

	public void updateSection(){
		if(this.section_on != null){
			this.section_on.remove(this);
		}
		if(entity.current.line != null){
			this.section_on = entity.current.line;
		}
	}

	public AxisAlignedBB getAABB(){
		return new AxisAlignedBB(position.xCoord - 0.5, position.yCoord - 0.5, position.zCoord - 0.5,
			position.xCoord + 0.5, position.yCoord + 0.5, position.zCoord + 0.5);
	}

	public void update(){
    	ObjCon<Track, Double, Vec3f> con = MoveUtil.travelDistance(entity.getRegion().getUtil(),
    		new MoveUtil.ObjCon<Track, Double, Double>(entity.current, entity.passed, offset), entity.reverse);
    	this.last = this.curr; this.curr = con.fir; this.position = con.tir;
    	if(!last.equals(curr)) this.updateSection();
	}
	
}