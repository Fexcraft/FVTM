package net.fexcraft.mod.fvtm.data.container;

/** @author Ferdinand Calo' (FEX___96) */
public enum ContainerType {

    MICRO(1f), TINY(2f), SMALL(3f), MEDIUM(6f), LARGE(12f);
	
	private boolean even; private float length;
	
	ContainerType(float length){
		this.length = length; even = this.length % 2 == 0;
	}
	
	public float length(){ return length; }
	
	public boolean isEven(){ return even; }

	public ContainerType next(boolean loop, boolean nell){
		switch(this){
			case LARGE: return loop ? TINY : nell ? null : LARGE;
			case MEDIUM: return LARGE;
			case SMALL: return MEDIUM;
			case TINY: return SMALL;
			case MICRO: return TINY;
			default: return nell ? null : MEDIUM;
		}
	}
	
	public ContainerType prev(boolean loop, boolean nell){
		switch(this){
			case LARGE: return MEDIUM;
			case MEDIUM: return SMALL;
			case SMALL: return TINY;
			case TINY: return MICRO;
			case MICRO: return loop ? LARGE : nell ? null : MICRO;
			default: return nell ? null : MEDIUM;
		}
	}

}
