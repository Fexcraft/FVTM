package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.ui.UIKey;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum InvType {

	STACK("stack", new RGB("733f00"), "stacks"),
	ITEM("item", new RGB("c96f02"), "stacks"),
	FLUID("fluid", new RGB("02d9e0"), "mB"),
	ENERGY("energy", new RGB("0b8c01"), "FE"),
	CONTAINER("container", new RGB("c40202"), "con"),
	VARIABLE("variable", new RGB("db0272"), "var");

	public final RGB color;
	public final String name;
	public final String unit_suffix;

	InvType(String nome, RGB rgb, String suffix){
		color = rgb;
		unit_suffix = suffix;
		name = nome;
	}

	public boolean isItem(){
		return this == ITEM;
	}

	public boolean isStack(){
		return this == STACK;
	}

	public boolean isFluid(){
		return this == FLUID;
	}

	public boolean isEnergy(){
		return this == ENERGY;
	}

	public boolean isVariable(){
		return this == VARIABLE;
	}

	public boolean isContainer(){
		return this == CONTAINER;
	}

	public static InvType parse(String str){
		str = str.toLowerCase();
		for(InvType type : values()){
			if(type.name.equals(str)) return type;
		}
		switch(str){
			case "items": return ITEM;
			case "stacks": return STACK;
			case "var":
			case "value": return VARIABLE;
		}
		return ITEM;
	}

	public UIKey getMBUI(){
		switch(this){
			case ITEM: return UIKeys.MULTIBLOCK_INVENTORY_ITEM;
			case FLUID: return UIKeys.MULTIBLOCK_INVENTORY_FLUID;
			case VARIABLE: return UIKeys.MULTIBLOCK_INVENTORY_VAR;
		}
		return null;
	}

	public FvtmInv newInv(){
		switch(this){
			case STACK: return new FvtmInvStacks();
			case ITEM: return new FvtmInvItems();
			case FLUID:
			case ENERGY:
			case CONTAINER:
			case VARIABLE:
			default:
				return null;
		}
	}

}
