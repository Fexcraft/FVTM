package net.fexcraft.mod.fvtm.gui.construct;

public enum ConstGuiElement {
	
	TOP(0, 0, 256, 16),
	HELP(165, 18, 11, 16),
	BACK(177, 18, 11, 16),
	SAVE(189, 18, 11, 16),
	SPAWN(201, 18, 11, 16),
	SPACER(0, 16, 144, 1),
	FOOTER(0, 245, 144, 10),
	//
	LIFT(139, 17, 24, 48),
	LIFT_UP(142, 41, 7, 12),
	LIFT_DW(150, 41, 7, 12),
	//
	GENERIC_SEG(0, 65, 144, 12),
	GENERIC_1B_SEG(0, 89, 144, 12),
	INPUT3_SEG(0, 77, 144, 12),
	INPUT_1B_SEG(0, 89, 144, 12),
	INPUT_2B_SEG(0, 101, 144, 12),
	SWITCH_SEG(0, 101, 144, 12),
	EMPTY_SEG(0, 221, 144, 12),
	BLANK_SEG(0, 233, 144, 12),
	WHITE_SEG(0, 209, 144, 12),
	//
	CONFIRM_ICON(145, 77, 12, 12),
	PREV_ICON(145, 89, 12, 12),
	NEXT_ICON(145, 101, 12, 12),
	CANCEL_ICON(145, 113, 12, 12),
	EDIT_ICON(157, 77, 12, 12),
	LEFT_ICON(157, 89, 12, 12),
	RIGHT_ICON(157, 101, 12, 12),
	EDITTEX_ICON(157, 113, 12, 12),
	;
	
	protected int x, y, w, h;
	
	private ConstGuiElement(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public ConstGuiElement[] asarray(){
		return new ConstGuiElement[]{ this };
	}

	public ConstGuiElement[] asarray(ConstGuiElement... other){
		ConstGuiElement[] arr = new ConstGuiElement[other.length + 1];
		arr[0] = this;
		for(int i = 1; i < arr.length; i++) arr[i] = other[i - 1];
		return arr;
	}

}
