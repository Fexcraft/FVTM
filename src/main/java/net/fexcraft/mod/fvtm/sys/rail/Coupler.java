package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.mod.fvtm.util.MiniBB;

public class Coupler {
	
	public final RailEntity root;
	public RailEntity entity;
	public boolean coupled;
	public final boolean frontal;
	public MiniBB mbb = new MiniBB();
	
	public Coupler(RailEntity root, boolean bool){ this.root = root; this.frontal = bool; }
	
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
		if(root.chain != null) root.chain.remove(root);
		if(isFront()){ entity.front.entity = null; entity.front.coupled = false; entity = null; }
		if(isRear()){ entity.rear.entity = null; entity.rear.coupled = false; entity = null; }
	}

	public void couple(RailEntity ent, boolean front, boolean solid){
		(front ? ent.front : ent.rear).coupled = coupled = solid;
		entity = ent; (front ? ent.front : ent.rear).entity = root;
		if(!root.region.getWorld().getWorld().isRemote){
			root.updateClient("couplers"); ent.updateClient("couplers");
		}
		if(root.chain == null && entity.chain == null){
			Chain chain = root.chain = entity.chain = new Chain();
			chain.entities.add(root); chain.entities.add(entity);
		}
		else if(root.chain != null){ root.chain.insert(root, entity); }
		else if(entity.chain != null){ entity.chain.insert(entity, root); }
	}

	public boolean hasEntity(){
		return entity != null;
	}

	public boolean inRange(){
		if(isFront()) return entity.front.mbb.contains(mbb.center);
		if(isRear()) return entity.rear.mbb.contains(mbb.center);
		return false;
	}

	public Coupler getOpposite(){
		return frontal ? root.rear : root.front;
	}

	public Coupler getCounterpart(){
		return hasEntity() ? isFront() ? entity.front : entity.rear : null;
	}

}
