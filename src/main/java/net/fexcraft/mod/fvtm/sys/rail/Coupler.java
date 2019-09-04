package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.mod.fvtm.util.MiniBB;

public class Coupler {
	
	public final RailEntity root;
	public RailEntity entity;
	public boolean coupled;
	public MiniBB mbb = new MiniBB();
	
	public Coupler(RailEntity root){ this.root = root; }
	
	public Coupler set(RailEntity ent, boolean solid){
		entity = ent; coupled = solid; return this;
	}

	public boolean isFront(){
		return entity == null ? false : entity.front.entity == root;
	}

	public boolean isRear(){
		return entity == null ? false : entity.rear.entity == root;
	}

	public void decouple(){
		if(isFront()){ entity.front.entity = null; entity.front.coupled = false; entity = null; }
		if(isRear()){ entity.rear.entity = null; entity.rear.coupled = false; entity = null; }
	}

	public void couple(RailEntity ent, boolean front, boolean solid){
		(front ? ent.front : ent.rear).coupled = coupled = solid;
		entity = ent; (front ? ent.front : ent.rear).entity = root;
	}

	public boolean hasEntity(){
		return entity != null;
	}

	public boolean inRange(){
		if(isFront()) return entity.front.mbb.contains(mbb.center);
		if(isRear())return entity.rear.mbb.contains(mbb.center);
		return false;
	}

}
