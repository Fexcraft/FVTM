package net.fexcraft.mod.fvtm.sys.rail;

public class PointOnTrack {
	
	public Track curr, last;
	public double passed;
	public RailEntity entity;
	public Type pointtype;
	public LineSection section_on;
	
	public PointOnTrack(RailEntity ent, Type type){
		this.entity = ent; this.curr = ent.current; this.last = ent.last; this.passed = ent.passed;
	}
	
	public static enum Type {
		
		COUPLER_FRONT(false), COUPLER_REAR(true), BOGIE_FRONT(false), BOGIE_REAR(true);
		
		boolean opposite;
		
		Type(boolean opp){
			this.opposite = opp;
		}
		
	}

	public void updateSection(){
		if(this.section_on != null){
			this.section_on.remove(this);
		}
		if(this.curr.line != null){
			this.section_on = this.curr.line;
		}
	}
	
}