package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.TreeMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * "Rail Entities Compound"
 * 
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class Compound {
	
	//TODO removal of unused/unliked compounds from list;
	public static final TreeMap<Long, Compound> COMPOUNDS = new TreeMap<>();
	//
	protected float accumulator;
	protected ArrayList<RailEntity> entities = new ArrayList<>();
	public boolean forward, paused;
	protected final long uid;
	//
	protected Track last_stop;
	protected float last_stop_passed;
	
	public static class Singular extends Compound {
		
		public Singular(RailEntity root){
			super(root.region.getWorld().getNewCompoundId());
			entities.add(root); root.com = this; COMPOUNDS.put(uid, this);
		}

		public Singular(Region region, long uid, NBTTagCompound compound){
			super(uid); RailEntity root = new RailEntity(region, this);
			entities.add(root.read(compound)); COMPOUNDS.put(uid, this);
		}

		public Singular(RailEntity ent, long uid){
			super(uid); entities.add(ent); COMPOUNDS.put(uid, this);
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

		@Override
		protected boolean isActive(){
			return entities.get(0).isActive();
		}
		
	}
	
	public static class Multiple extends Compound {

		public Multiple(RailEntity root, RailEntity entity){
			super(root.region.getWorld().getNewCompoundId());
			entities.add(root); entities.add(entity); COMPOUNDS.put(uid, this);
		}

		public Multiple(Compound recom, int start, int end){
			super(recom.entities.get(start).region.getWorld().getNewCompoundId());
			for(int i = start; i < end; i++){ entities.add(recom.entities.get(i)); }
			for(RailEntity ent : entities) ent.com = this; COMPOUNDS.put(uid, this);
		}

		public Multiple(Region region, Long id, NBTTagList list){
			super(id); RailEntity prev = null, curr; NBTTagCompound compound;
			for(int i = 1; i < list.tagCount(); i++){
				compound = (NBTTagCompound)list.get(i);
				curr = new RailEntity(region, this).read(compound);
				if(prev != null){
					if(compound.hasKey("front_coupled") && compound.getLong("front_coupled") == prev.uid){
						(compound.getBoolean("front_coupler") ? prev.front : prev.rear).entity = curr;
						curr.front.entity = prev;
					}
					else if(compound.hasKey("rear_coupled") && compound.getLong("rear_coupled") == prev.uid){
						(compound.getBoolean("rear_coupler") ? prev.front : prev.rear).entity = curr;
						curr.rear.entity = prev;
					}
				}
				entities.add(prev = curr);
			}
			COMPOUNDS.put(uid, this);
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

		@Override
		protected boolean isActive(){
			for(RailEntity ent : entities) if(ent.isActive()) return true; return false;
		}
		
	}
	
	public Compound(long uid){ this.uid = uid; }

	public abstract boolean isHead(RailEntity root);

	public abstract boolean isEnd(RailEntity root);
	
	public abstract boolean isSingular();
	
	public abstract boolean isMultiple();

	public abstract int getIndex(RailEntity root);
	
	public abstract int size();
	
	public long getUID(){
		return uid;
	}

	public static Compound get(RailEntity ent, long uid){
		if(COMPOUNDS.containsKey(uid)) return COMPOUNDS.get(uid); return new Singular(ent, uid);
	}
	
	public ArrayList<RailEntity> getEntitites(){
		return entities;
	}

	protected void stop(Track track, float pass){
		if(last_stop == null || last_stop != track) for(RailEntity ent : entities) ent.throttle = 0; last_stop = track; last_stop_passed = pass;
	}

	protected abstract boolean isActive();

}
