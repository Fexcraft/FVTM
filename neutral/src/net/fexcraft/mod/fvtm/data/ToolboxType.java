package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.uni.inv.StackWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum ToolboxType {

	PART_REMOVAL(0),
	TEXTURE(1),
	COLOR_CHANNEL(2),
	WIRE_REMOVAL(3),
	WIRE_SLACK(4),
	SIGN_ADJREM(5),
	DECO_ADJREM(6),
	WIRE_COMPONENT(7),
	;

	public final int idx;

	ToolboxType(int index){
		idx = index;
	}

	public boolean eq(int n){
		return idx == n;
	}

	public static boolean eq(int n, ToolboxType... types){
		for(ToolboxType type : types) if(type.idx == n) return true;
		return false;
	}

	public static interface ToolboxTypeItem {

		public int getType(StackWrapper stack);

		public static int getToolboxType(StackWrapper stack){
			return ((ToolboxTypeItem)stack.getItem().direct()).getType(stack);
		}

	}

}
