package net.fexcraft.mod.addons.gmp.impl;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.impl.GenericMaterial;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.EnumDyeColor;

public class GenericDyePowderMaterial extends GenericMaterial {
	
	private EnumDyeColor color;

	public GenericDyePowderMaterial(EnumDyeColor color){
		super(getStaticJsonObject(color)); this.color = color;
	}

	private static JsonObject getStaticJsonObject(EnumDyeColor color){
		JsonObject obj = new JsonObject();
		obj.addProperty("RegistryName", "gmp:dye_powder_" + color.getName());
		obj.addProperty("Addon", "fvtm:gmp");
		obj.addProperty("FullName", "Dye Powder (" + color.name() + ")");
		obj.addProperty("OreDictionary", "dye" + (color.getUnlocalizedName().substring(0, 1).toUpperCase()) + (color.getUnlocalizedName().substring(1)));
		return obj;
	}
	
	public EnumDyeColor getColor(){
		return color;
	}
	
	public RGB getRGBColor(){
		return RGB.fromDyeColor(color);
	}
	
}