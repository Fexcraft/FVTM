package net.fexcraft.mod.fvtm.sys.railplus;

public class Junction {

	public System root;
	public Region region;
	
	public Junction(Region region){
		this.region = region; this.root = region.root;
	}

}
