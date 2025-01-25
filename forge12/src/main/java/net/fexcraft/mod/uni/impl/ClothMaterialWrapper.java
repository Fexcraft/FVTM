package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.inv.ClothMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ClothMaterialWrapper implements ClothMaterial {

	public final IDL id;
	public final ArmorMaterial material;

	public ClothMaterialWrapper(IDL id, ArmorMaterial material){
		super();
		this.id = id;
		this.material = material;
	}

	@Override
	public Object local(){
		return material;
	}
}
