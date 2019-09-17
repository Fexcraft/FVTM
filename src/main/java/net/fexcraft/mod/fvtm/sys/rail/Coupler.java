package net.fexcraft.mod.fvtm.sys.rail;

import java.util.Collections;

import net.fexcraft.lib.mc.utils.Print;
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

	/** Usually called from the vehicle that does currently calcs. */
	public void decouple(){
		if(entity == null) return;
		if(root.recom == null || entity.recom == null){}//pass
		else if(root.recom.size() <= 2 || entity.recom.size() <= 2){
			root.recom = entity.recom = null;
		}
		else if(root.recom.isHead(root)){
			root.recom.entities.remove(0); root.recom = null;
		}
		else if(root.recom.isEnd(root)){
			root.recom.entities.remove(root.recom.size() - 1); root.recom = null;
		}
		else{//split
			int idx0 = root.recom.getIndex(root), idx1 = root.recom.getIndex(entity), lesser, notlesser;
			if(idx0 < idx1){ lesser = idx0; notlesser = idx1; } else{ lesser = idx1; notlesser = idx0; }
			REC rec0 = new REC(root.recom, 0, lesser + 1); REC rec1 = new REC(root.recom, notlesser, root.recom.entities.size());
			if(rec0.size() < 2) rec0.entities.forEach(ent -> ent.recom = null);
			if(rec1.size() < 2) rec1.entities.forEach(ent -> ent.recom = null);
		}
		//
		if(isFront()){ entity.front.entity = null; entity.front.coupled = false; entity = null; }
		if(isRear()){ entity.rear.entity = null; entity.rear.coupled = false; entity = null; }
	}

	public void couple(RailEntity ent, boolean front, boolean solid){
		if(root.recom != null && ent.recom != null && root.recom.equals(ent.recom)) return;//abort, we don't want such.
		(front ? ent.front : ent.rear).coupled = coupled = solid;
		entity = ent; (front ? ent.front : ent.rear).entity = root;
		if(!root.region.getWorld().getWorld().isRemote){
			root.updateClient("couplers"); ent.updateClient("couplers");
		}
		if(root.recom == null && entity.recom == null){
			root.recom = entity.recom = new REC(solid ? root : entity, solid ? entity : root);
			Print.debug("REC: created new");
		}
		else if(root.recom != null && entity.recom != null){
			if(root.recom.isEnd(root)){
				if(!entity.recom.isHead(entity)){
					Collections.reverse(entity.recom.entities);
				}
				root.recom.entities.addAll(entity.recom.entities);
				root.recom.entities.forEach(e -> e.recom = root.recom);
			}
			else{
				if(entity.recom.isHead(entity)){
					Collections.reverse(entity.recom.entities);
				}
				root.recom.entities.addAll(0, entity.recom.entities);
				root.recom.entities.forEach(e -> e.recom = root.recom);
			}
			Print.debug("REC: fused");
		}
		else if(root.recom == null){
			if(entity.recom.isHead(root)){
				entity.recom.entities.add(0, root);
			}
			else{//assume end
				entity.recom.entities.add(root);
			}
			root.recom = entity.recom;
			Print.debug("REC: attached root");
		}
		else if(root.recom != null){
			if(root.recom.isHead(root)){
				root.recom.entities.add(0, entity);
			}
			else{//assume end
				root.recom.entities.add(entity);
			}
			entity.recom = root.recom;
			Print.debug("REC: attached entity");
		}
	}

	public boolean hasEntity(){
		return entity != null;
	}

	public boolean inRange(){
		if(isFront()) return /*entity.cfront.distanceTo(mbb.center) < 1f;*/entity.front.mbb.contains(mbb.center);
		if(isRear()) return /*entity.crear.distanceTo(mbb.center) < 1f;*/entity.rear.mbb.contains(mbb.center);
		return false;
	}

	public Coupler getOpposite(){
		return frontal ? root.rear : root.front;
	}

	public Coupler getCounterpart(){
		return isFront() ? entity.front : isRear() ? entity.rear : null;
	}

	public boolean isFrontal(){
		return frontal;
	}

}
