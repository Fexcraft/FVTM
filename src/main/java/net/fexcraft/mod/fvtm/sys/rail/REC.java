package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

/**
 * "Rail Entities Compound"
 * 
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class REC {
	
	protected float accumulator;
	protected ArrayList<RailEntity> entities = new ArrayList<>();
	
	public REC(){}

	public REC(RailEntity root, RailEntity entity){
		entities.add(root); entities.add(entity);
	}

	public boolean isHead(RailEntity root){
		return entities.get(0).uid == root.uid;
	}

	public boolean isEnd(RailEntity root){
		return entities.get(size() - 1).uid == root.uid;
	}
	
	public int size(){ return entities.size(); }

	public boolean forward(){
		return entities.get(0).forward;
	}

}
