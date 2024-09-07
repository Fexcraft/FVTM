package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface ItemTextureable {
	
	public IDL getItemTexture();
	
	public default boolean noCustomItemModel(){
		return false;
	}

	public static interface TextureableItem<CT> {

		public Content<CT> getContent();

	}

}
