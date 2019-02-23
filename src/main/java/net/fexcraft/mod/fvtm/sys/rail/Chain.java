package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;

/** @author Ferdinand Calo' (FEX___96) **/
public class Chain {
	
	private double throttle;
	private List<RailEntity> entities = new ArrayList<>();
	
	public Chain(List<RailEntity> ents){
		this.entities = ents;
	}
	
	public Chain(RailEntity ent){
		this.entities = new ArrayList<>(); this.entities.add(ent);
	}
	
	public Chain(NBTTagCompound com){
		
	}
	
	public void update(){
		
	}
	
	public void attach(RailEntity ent, boolean end){
		if(end) entities.add(ent); else entities.add(0, ent);
	}
	
	public void dettach(boolean last){
		if(last) entities.remove(entities.size() - 1); else entities.remove(0);
	}
	
	public Chain[] split(int at, int et, boolean clear){
		if(at < 0 || at >= entities.size() || et < 0 || et >= entities.size() || at == et) return new Chain[]{ this };
		if(at > et){ int it = at; et = at; at = it; }
		List<RailEntity> top = entities.subList(0, at);
		List<RailEntity> bot = entities.subList(et, entities.size() - 1);
		if(clear) entities.clear();
		return new Chain[]{ new Chain(top), new Chain(bot) };
	}
	
	public double getThrottle(){
		return throttle;
	}
	
}