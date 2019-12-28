package net.fexcraft.mod.fvtm.sys.rail;

import java.util.Collections;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.Compound.Multiple;
import net.fexcraft.mod.fvtm.sys.rail.Compound.Singular;
import net.fexcraft.mod.fvtm.util.MiniBB;


public class Coupler {
	
	public final RailEntity root;
	public RailEntity entity;
	public boolean autocoupler;
	public final boolean frontal;
	public MiniBB mbb = new MiniBB();
	
	public Coupler(RailEntity root, boolean bool){ this.root = root; this.frontal = bool; }

	public boolean isFront(){
		return entity == null ? false : entity.front.entity == root;
	}

	public boolean isRear(){
		return entity == null ? false : entity.rear.entity == root;
	}

	/** Usually called from the vehicle that does currently calcs. */
	public void decouple(){
		if(entity == null) return;
		if(root.com.size() <= 2 || entity.com.size() <= 2){
			root.com = new Singular(root); entity.com = new Singular(entity);
		}
		else if(root.com.isHead(root)){
			root.com.entities.remove(0); root.com = new Singular(root);
		}
		else if(root.com.isEnd(root)){
			root.com.entities.remove(root.com.size() - 1); root.com = new Singular(root);
		}
		else{//split
			int idx0 = root.com.getIndex(root), idx1 = root.com.getIndex(entity), lesser, notlesser;
			if(idx0 < idx1){ lesser = idx0; notlesser = idx1; } else{ lesser = idx1; notlesser = idx0; }
			/*Compound rec0 = new Compound(root.recom, 0, lesser + 1); Compound rec1 = new Compound(root.recom, notlesser, root.recom.entities.size());
			if(rec0.size() < 2) rec0.entities.forEach(ent -> ent.recom = null);
			if(rec1.size() < 2) rec1.entities.forEach(ent -> ent.recom = null);*/
			Compound old = root.com;
			if(lesser == 0) new Singular(root); else new Multiple(old, 0, lesser + 1);
			if(old.entities.size() - 1 == notlesser) new Singular(old.entities.get(notlesser));
			else new Multiple(old, notlesser, old.entities.size()); old.dispose();
		}
		//
		if(isFront()){ entity.front.entity = null; entity = null; }
		if(isRear()){ entity.rear.entity = null; entity = null; }
	}

	public void couple(RailEntity ent, boolean front){
		if(root.com != null && ent.com != null && root.com.equals(ent.com)) return;//abort, we don't want such.
		//(front ? ent.front : ent.rear).coupled = coupled = solid;
		entity = ent; (front ? ent.front : ent.rear).entity = root;
		if(!root.region.getWorld().getWorld().isRemote){
			root.updateClient("couplers"); ent.updateClient("couplers");
		}
		if(root.com.isSingular() && entity.com.isSingular()){
			root.com.dispose(); entity.com.dispose();
			root.com = entity.com = new Multiple(root, entity);//solid ? root : entity, solid ? entity : root);
			Print.debug("REC: created new");
		}
		else if(!root.com.isSingular() && !entity.com.isSingular()){
			if(root.com.isEnd(root)){
				if(!entity.com.isHead(entity)){
					Collections.reverse(entity.com.entities);
				}
				entity.com.dispose();
				root.com.entities.addAll(entity.com.entities);
				root.com.entities.forEach(e -> e.com = root.com);
			}
			else{
				if(entity.com.isHead(entity)){
					Collections.reverse(entity.com.entities);
				}
				entity.com.dispose();
				root.com.entities.addAll(0, entity.com.entities);
				root.com.entities.forEach(e -> e.com = root.com);
			}
			Print.debug("REC: fused");
		}
		else if(root.com.isSingular()){
			if(entity.com.isHead(entity)){
				entity.com.entities.add(0, root);
			}
			else{//assume end
				entity.com.entities.add(root);
			}
			root.com.dispose(); root.com = entity.com;
			Print.debug("REC: attached root");
		}
		else if(entity.com.isSingular()){
			if(root.com.isHead(root)){
				root.com.entities.add(0, entity);
			}
			else{//assume end
				root.com.entities.add(entity);
			}
			entity.com.dispose(); entity.com = root.com;
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
