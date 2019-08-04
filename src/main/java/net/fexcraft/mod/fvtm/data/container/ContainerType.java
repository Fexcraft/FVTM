package net.fexcraft.mod.fvtm.data.container;

/** @author Ferdinand Calo' (FEX___96) */
public enum ContainerType {

    MICRO(1), TINY(2), SMALL(3), MEDIUM(6), LARGE(12);
	
	private boolean even; private int length;
	
	ContainerType(int length){
		this.length = length; even = this.length % 2 == 0;
	}
	
	public int length(){ return length; }
	
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

	public boolean isLarge(){
		return this == LARGE;
	}

	public boolean isMedium(){
		return this == MEDIUM;
	}

	public boolean isSmall(){
		return this == SMALL;
	}

	public boolean isTiny(){
		return this == TINY;
	}

	public boolean isMicro(){
		return this == MICRO;
	}

}
