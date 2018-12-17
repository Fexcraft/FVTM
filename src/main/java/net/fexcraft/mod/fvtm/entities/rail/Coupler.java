package net.fexcraft.mod.fvtm.entities.rail;

@Deprecated
public class Coupler {
	
	public RailboundVehicleEntity one, sec;
	public boolean one_fr, sec_fr;
	//public UUID id0, id1;
	private boolean copy;
	
	public Coupler(RailboundVehicleEntity caller, boolean front, RailboundVehicleEntity target, boolean front2){
		this(caller, front, target, front2, false);
	}
	
	private Coupler(RailboundVehicleEntity caller, boolean front, RailboundVehicleEntity target, boolean front2, boolean copy){
		this.one = caller; this.sec = target; this.copy = copy; this.one_fr = front; this.sec_fr = front2;
		//this.id0 = one.getPersistentID(); this.id1 = sec.getPersistentID();
	}
	
	/** Automatically becomes a "copy". */
	public Coupler opposite(){
		return new Coupler(sec, sec_fr, one, one_fr, true);
	}
	
	public RailboundVehicleEntity getOtherEntity(){
		return copy ? one : sec;
	}

	public void disconnect(){
		if(copy){
			if(one_fr) one.front = null; else one.rear = null;
		}
		else{
			if(sec_fr) sec.front = null; else sec.rear = null;
		}
		//this.one = this.sec = null;
	}

	public void apply(){
		/*if(one_fr) one.front = this; else one.rear = this;
		if(sec_fr) sec.front = this.opposite(); else sec.rear = this.opposite();*/
	}

	public void unapply(){
		if(one_fr) one.front = null; else one.rear = null;
		if(sec_fr) sec.front = null; else sec.rear = null;
	}
	
	public boolean isCopy(){
		return isOpposite();
	}
	
	public boolean isOpposite(){
		return copy;
	}
	
}