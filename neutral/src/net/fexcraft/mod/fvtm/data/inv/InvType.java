package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.ui.UIKeys;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InvType {

	public static InvType ITEM = new InvType("item", new RGB("733f00"), "stacks");
	public static InvType FLUID = new InvType("fluid", new RGB("02d9e0"), "mB");
	public static InvType ENERGY = new InvType("energy", new RGB("0b8c01"), "FE");
	public static InvType CONTAINER = new InvType("container", new RGB("c40202"), "CNTNRS");
	public static InvType VARIABLE = new InvType("variable", null, null, true);

	public final RGB color;
	public final String name;
	public final boolean variable;
	public final String unit_suffix;

	public InvType(String name, RGB color, String suffix){
		this(name, color, suffix, false);
	}

	public InvType(String name, RGB color, String suffix, boolean variable){
		this.color = color == null ? new RGB("db0272") : color;
		unit_suffix = suffix == null ? "vr" : suffix;
		this.variable = variable;
		this.name = name;
	}

	public boolean isFluid(){
		return this == FLUID;
	}

	public boolean isItem(){
		return this == ITEM;
	}

	public boolean isContainer(){
		return this == CONTAINER;
	}

	public boolean isVariable(){
		return variable;
	}

	public static InvType parse(String str, boolean vars){
		str = str.toLowerCase();
		switch(str){
			case "item": return ITEM;
			case "fluid": return FLUID;
			case "energy": return ENERGY;
			case "var":
			case "value":
			case "variable":{
				if(vars) return VARIABLE;
				else break;
			}
			case "container": return CONTAINER;
		}
		return ITEM;
	}

	public String name(){
		return name;
	}

	public int guiId(){
		if(isItem()) return UIKeys.MULTIBLOCK_INVENTORY_ITEM.id;
		if(isFluid()) return UIKeys.MULTIBLOCK_INVENTORY_FLUID.id;
		if(isVariable()) return UIKeys.MULTIBLOCK_INVENTORY_VAR.id;
		return 0;
	}

}
