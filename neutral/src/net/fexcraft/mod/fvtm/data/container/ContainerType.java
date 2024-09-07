package net.fexcraft.mod.fvtm.data.container;

import net.fexcraft.lib.common.math.RGB;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum ContainerType {

    MICRO(1, 0x404040), TINY(2, 0xe20000), SMALL(3, 0x007f7f), MEDIUM(6, 0x007f0e), LARGE(12, 0x00137f);
	
	private boolean even; private int length; private RGB color;
	
	ContainerType(int length, int color){
		this.length = length; even = this.length % 2 == 0; this.color = new RGB(color);
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
	
	public int getColor(){
		return color.packed;
	}
	
	public RGB getRGB(){
		return color;
	}

}
