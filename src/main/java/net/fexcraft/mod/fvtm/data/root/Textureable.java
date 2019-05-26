package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.minecraft.util.ResourceLocation;

public interface Textureable {
	
	public ResourceLocation getTexture();
	
	public int getSelectedTexture();
	
	public ResourceLocation getCustomTexture();
	
	public boolean isExternalTexture();
	
	public static interface TextureHolder {
		
		public java.util.List<NamedResourceLocation> getDefaultTextures();
		
	}

}
