package net.fexcraft.mod.fvtm.model;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum RenderOrder {

	NORMAL,
	BLENDED,
	LAST,
	SEPARATE;

	public boolean blended(){
		return this == BLENDED;
	}

	public boolean not_blended(){
		return this != BLENDED;
	}

}
