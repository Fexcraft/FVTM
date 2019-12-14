package net.fexcraft.mod.fvtm.sys.eisen;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.util.Vec316f;

public class BahnRegion {
	
	public final TreeMap<Vec316f, Knotenpunkt> knoten = new TreeMap<>();
	public final TreeMap<Long, Schienenfahrzeug> züge = new TreeMap<>();
	private BahnSystem wurzel;
	public final int x, z;
	
	public BahnRegion(BahnSystem sys, int x, int z){
		this.x = x; this.z = z; wurzel = sys;
	}
	
	public void load(){
		
	}

}
