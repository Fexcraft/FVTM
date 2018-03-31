package net.fexcraft.mod.fvtm.blocks;

import net.minecraft.util.EnumFacing;

public enum ConstructorButton {
	
	NULL(-1, new int[]{-1}, new int[]{-1}),
	SPAWN_ITEM(0,   new int[]{14, 15}, new int[]{3, 2}),
	SPAWN_ENTITY(1, new int[]{12, 13}, new int[]{3, 2}),
	REMOVE(2,       new int[]{ 6}, new int[]{ 5}),
	SELECT(3,       new int[]{ 6}, new int[]{ 6}),
	ARROW_DOWN(4,   new int[]{ 6}, new int[]{ 7}),
	ARROW_UP(5,     new int[]{ 6}, new int[]{ 8}),
	ARROW_RIGHT(6,  new int[]{ 6}, new int[]{ 9}),
	ARROW_LEFT(7,   new int[]{ 6}, new int[]{10}),
	RETURN(8,       new int[]{ 6}, new int[]{11}),
	HOME(9,         new int[]{ 6}, new int[]{12}),
	LIFT_DOWN(10,   new int[]{ 9, 10}, new int[]{3, 2}),
	LIFT_UP(11,     new int[]{ 6,  7}, new int[]{3, 2}),
	INPUT(12,       new int[]{ 0}, new int[]{ 0});
	
	public int ID;
	public int[] xc, zc;
	
	ConstructorButton(int id, int[] x, int[] z){
		this.ID = id; this.xc = x; this.zc = z;
	}
	
	public boolean collides(EnumFacing facing, int x, int z){
		int xx = rotate(x, z, facing, true);
		int zz = rotate(z, x, facing, false);
		boolean xcb = false, zcb = false;
		for(int i : xc){
			if(i == xx){ xcb = true; break; }
		}
		for(int i : zc){
			if(i == zz){ zcb = true; break; }
		}
		return xcb && zcb;
	}
	
	private static final int rotate(int i, int o, EnumFacing facing, boolean x){
		switch(facing){
			case NORTH: return x ? (-o) + 17 : o;
			case SOUTH: return x ? o : (-o) + 17;
			case WEST:  return (-i) + 17;
			default: return i;
		}
	}
	
	public static final ConstructorButton fromId(int id){
		for(ConstructorButton button : values()){
			if(button.ID == id){
				return button;
			}
		}
		return NULL;
	}
	
	public static final ConstructorButton findButton(EnumFacing value, int x, int z){
		for(ConstructorButton button : values()){
			if(button.collides(value, x, z)){ return button; }
		}
		return null;
	}
	
	public boolean isVerticalArrow(){
		return this == ARROW_DOWN || this == ARROW_UP;
	}
	
	public boolean isHorizontalArrow(){
		return this == ARROW_RIGHT || this == ARROW_LEFT;
	}
	
	public boolean isLiftConstructorButton(){
		return this == LIFT_DOWN || this == LIFT_UP;
	}
	
	public boolean isSelect(){
		return this == SELECT;
	}
	
	public boolean isReset(){
		return this == REMOVE;
	}
	
	public boolean isReturn(){
		return this == RETURN;
	}
	
	public boolean isHome(){
		return this == HOME;
	}
		public boolean isLeftArrow(){
		return this == ARROW_LEFT;
	}
	
	public boolean isRightArrow(){
		return this == ARROW_RIGHT;
	}
	
	public boolean isUpArrow(){
		return this == ARROW_UP;
	}
	
	public boolean isDownArrow(){
		return this == ARROW_DOWN;
	}
		public boolean isInput(){
		return this == INPUT;
	}
	
}