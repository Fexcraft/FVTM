package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

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
	protected double last_stop_passed;
	
	public static class Singular extends Compound {
		
		public Singular(RailEntity root){
			super(root.region.getSystem().getNewCompoundId());
			entities.add(root);
			root.com = this;
			COMPOUNDS.put(uid, this);
		}

		public Singular(Region region, long uid, TagCW compound){
			super(uid);
			RailEntity root = new RailEntity(region, this);
			root = root.read(compound);
			if(root == null) return;
			entities.add(root);
			COMPOUNDS.put(uid, this);
		}

		public Singular(RailEntity ent, long uid){
			super(uid);
			entities.add(ent);
			COMPOUNDS.put(uid, this);
		}

		@Override
		public boolean isHead(RailEntity root){
			return isThis(root);
		}

		@Override
		public boolean isEnd(RailEntity root){
			return isThis(root);
		}

		@Override
		public int getIndex(RailEntity root){
			return isThis(root) ? 0 : -1;
		}

		private boolean isThis(RailEntity root){
			return root.uid == entities.get(0).uid;
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

		@Override
		protected boolean getOrient(RailEntity ent){
			return forward;
		}
		
	}
	
	public static class Multiple extends Compound {

		public Multiple(RailEntity root, RailEntity entity){
			super(root.region.getSystem().getNewCompoundId());
			entities.add(root);
			entities.add(entity);
			COMPOUNDS.put(uid, this);
		}

		public Multiple(Compound recom, int start, int end){
			super(recom.entities.get(start).region.getSystem().getNewCompoundId());
			for(int i = start; i < end; i++) entities.add(recom.entities.get(i));
			for(RailEntity ent : entities) ent.com = this;
			COMPOUNDS.put(uid, this);
		}

		public Multiple(RailSystem system, Region region, Long id, TagLW list){
			super(id);
			RailEntity prev = null, curr;
			for(TagCW compound : list){
				if(compound == null) continue;
				if(!compound.has("region")) return;
				if(FvtmRegistry.VEHICLES.get(compound.getString("Vehicle")) == null){
					FvtmLogger.log("COMPOUND(" + id + ") Rail Vehicle with id '" + compound.getString("Vehicle") + "' not found, removing.");
					FvtmLogger.log("NBT:" + compound);
					continue;
				}
				curr = new RailEntity(region == null ? system.getRegions().get(compound.getIntArray("region")) : region, this).read(compound);
				if(curr == null) continue;
				if(prev != null){
					if(compound.has("front_coupled") && compound.getLong("front_coupled") == prev.uid){
						(compound.getBoolean("front_coupler") ? prev.front : prev.rear).entity = curr;
						curr.front.entity = prev;
					}
					else if(compound.has("rear_coupled") && compound.getLong("rear_coupled") == prev.uid){
						(compound.getBoolean("rear_coupler") ? prev.front : prev.rear).entity = curr;
						curr.rear.entity = prev;
					}
				}
				entities.add(prev = curr);
			}
			if(entities.isEmpty()) return;
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

		@Override
		protected boolean getOrient(RailEntity ent){
			RailEntity head = entities.get(0);
			boolean rev = head.front.hasEntity();
			if(ent == head) return rev ? !forward : forward;
			Coupler coupler = rev ? head.rear : head.front;
			while(coupler.getOpposite().hasEntity()){
				coupler = coupler.getOpposite();
				if(coupler.isFrontal() ? coupler.isFront() : coupler.isRear()) rev = !rev;
				coupler = coupler.getCounterpart();
				if(coupler.root == ent) break;
			}
			return rev ? !forward : forward;
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

	public static Compound getNewClientCompound(RailEntity entity){
		long id = COMPOUNDS.size(); while(COMPOUNDS.containsKey(id)) id++;
		FvtmLogger.debug("Creating new placeholder client compound for '" + entity.uid + "'/" + id + "!");
		return new Singular(entity, id);
	}
	
	public ArrayList<RailEntity> getEntitites(){
		return entities;
	}

	protected void stop(Track track, double pass){
		if(last_stop == null || last_stop != track) for(RailEntity ent : entities) ent.vehicle.throttle = 0;
		last_stop = track;
		last_stop_passed = pass;
	}

	protected abstract boolean isActive();

	protected void dispose(){
		COMPOUNDS.remove(uid);
	}

	protected abstract boolean getOrient(RailEntity ent);
	
	public <V> void forEachMirror(boolean head, V value, Consumer<V> flip, Consumer<V> pass, BiConsumer<RailEntity, V> process){
		if(this.isSingular()) return;
		RailEntity ent = entities.get(head ? 0 : entities.size() - 1);
		Coupler coupler = ent.front.hasEntity() ? ent.rear : ent.front;
		while(coupler.getOpposite().hasEntity()){
			coupler = coupler.getOpposite();
			if(coupler.isFrontal() ? coupler.isFront() : coupler.isRear()) flip.accept(value);
			else pass.accept(value);
			coupler = coupler.getCounterpart();
			if(coupler.root != ent) process.accept(coupler.root, value);
		}
	}

}
