package net.fexcraft.mod.fvtm.data.addon;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum AddonLocation {
	
	MODJAR, RESOURCEPACK, CONFIGPACK, INTERNAL;
	
	public boolean isInAMod(){
		return this == MODJAR || this == INTERNAL;
	}

	public boolean isNotAMod(){
		return this != MODJAR && this != INTERNAL;
	}

	public boolean isConfigPack(){
		return this == CONFIGPACK;
	}

}
