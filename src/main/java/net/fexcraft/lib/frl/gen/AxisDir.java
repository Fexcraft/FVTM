package net.fexcraft.lib.frl.gen;

public enum AxisDir {

	Z_NEGATIVE(false),
	Z_POSITIVE(true),
	X_NEGATIVE(false),
	X_POSITIVE(true),
	Y_NEGATIVE(false),
	Y_POSITIVE(true);
	
	public final boolean positive;
	
	AxisDir(boolean pos){
		positive = pos;
	}
	
	public boolean isX(){
		return this == X_POSITIVE || this == X_NEGATIVE;
	}
	
	public boolean isY(){
		return this == Y_POSITIVE || this == Y_NEGATIVE;
	}
	
	public boolean isZ(){
		return this == Z_POSITIVE || this == Z_NEGATIVE;
	}
	
	public boolean isntX(){
		return this != X_POSITIVE && this != X_NEGATIVE;
	}
	
	public boolean isntY(){
		return this != Y_POSITIVE && this != Y_NEGATIVE;
	}
	
	public boolean isntZ(){
		return this != Z_POSITIVE && this != Z_NEGATIVE;
	}

}
