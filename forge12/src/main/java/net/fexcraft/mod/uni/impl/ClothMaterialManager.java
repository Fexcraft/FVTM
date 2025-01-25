package net.fexcraft.mod.uni.impl;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.inv.ClothMaterial;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;

public class ClothMaterialManager implements ClothMaterial.Manager {

	@Override
	public ClothMaterial create(IDL id, JsonMap map){
		int dur = map.getInteger("durability", 1);
		int[] dre = map.has("damage_reduction") ? map.getArray("damage_reduction").toIntegerArray() : new int[]{ 0, 0, 0, 0 };
		float tou = map.getFloat("toughness", 0f);
		ClothMaterialWrapper wrapper = new ClothMaterialWrapper(id, EnumHelper.addArmorMaterial(id.colon(), FvtmRegistry.NULL_TEXTURE.toString(), dur, dre, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, tou));
		ClothMaterial.MATERIALS.put(wrapper.id, wrapper);
		return wrapper;
	}

	@Override
	public ClothMaterial get(String str){
		return ClothMaterial.MATERIALS.get(IDLManager.getIDLCached(str));
	}

	@Override
	public ClothMaterial get(IDL id){
		return ClothMaterial.MATERIALS.get(id);
	}

}
