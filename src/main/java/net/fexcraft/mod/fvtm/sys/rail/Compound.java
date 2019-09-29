package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

/**
 * "Rail Entities Compound"
 * 
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class Compound {
	
	protected float accumulator;
	protected ArrayList<RailEntity> entities = new ArrayList<>();
	public boolean forward, paused;
	
	public static class Singular extends Compound {
		
		public Singular(RailEntity root){
			super(); entities.add(root); root.com = this;
		}

		@Override
		public boolean isHead(RailEntity root){
			return true;
		}

		@Override
		public boolean isEnd(RailEntity root){
			return true;
		}

		@Override
		public int getIndex(RailEntity root){
			return 0;
		}

		@Override
		public int size(){
			return 1;
		}

		@Override
		public boolean isSingular(){
			return true;
		}

		@Override
		public boolean isMultiple(){
			return false;
		}
		
	}
	
	public static class Multiple extends Compound {

		public Multiple(RailEntity root, RailEntity entity){
			super(); entities.add(root); entities.add(entity);
		}

		public Multiple(Compound recom, int start, int end){
			for(int i = start; i < end; i++){ entities.add(recom.entities.get(i)); }
			for(RailEntity ent : entities) ent.com = this;
		}

		@Override
		public boolean isHead(RailEntity root){
			return entities.get(0).uid == root.uid;
		}

		@Override
		public boolean isEnd(RailEntity root){
			return entities.get(size() - 1).uid == root.uid;
		}

		@Override
		public int getIndex(RailEntity root){
			return entities.indexOf(root);
		}

		@Override
		public int size(){
			return entities.size();
		}

		@Override
		public boolean isSingular(){
			return false;
		}

		@Override
		public boolean isMultiple(){
			return true;
		}
		
	}
	
	public Compound(){}

	public abstract boolean isHead(RailEntity root);

	public abstract boolean isEnd(RailEntity root);
	
	public abstract boolean isSingular();
	
	public abstract boolean isMultiple();

	public abstract int getIndex(RailEntity root);
	
	public abstract int size();

}
