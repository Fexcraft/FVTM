package net.fexcraft.mod.fvtm.data.root;

import net.minecraft.resources.ResourceLocation;

public interface ItemTextureable {
	
	public ResourceLocation getItemTexture();
	
	public default boolean no3DItemModel(){
		return false;
	}
	
	public static interface ItemTex<TYCO> {
		
		public TypeCore<TYCO> getDataType();
		
	}

}
