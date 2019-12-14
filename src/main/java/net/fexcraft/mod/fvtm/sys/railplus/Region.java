package net.fexcraft.mod.fvtm.sys.railplus;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.util.Vec316f;

public class Region {
	
	public final TreeMap<Vec316f, Junction> junctions = new TreeMap<>();
	public final TreeMap<Long, Entity> entities = new TreeMap<>();
	public System root;
	public final int x, z;
	
	public Region(System sys, int x, int z){
		this.x = x; this.z = z; root = sys;
	}
	
	public void load(){
		
	}

}
