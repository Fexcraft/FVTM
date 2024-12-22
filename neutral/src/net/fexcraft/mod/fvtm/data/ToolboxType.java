package net.fexcraft.mod.fvtm.data;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum ToolboxType {

	PART_REMOVAL(0),
	TEXTURE(1),
	COLOR_CHANNEL(2),
	WIRE_REMOVAL(3),
	WIRE_SLACK(4)
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

}
