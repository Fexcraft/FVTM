package net.fexcraft.mod.fvtm.data.addon;

public enum AddonLocation {
	
	MODJAR, RESOURCEPACK, LITEPACK;
	
	public boolean isLitePack(){
		return this != MODJAR;
	}
	
	public boolean isFullLite(){
		return this == LITEPACK;
	}

}
