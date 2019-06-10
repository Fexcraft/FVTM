package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.minecraft.util.ResourceLocation;

public interface Textureable {
	
	public ResourceLocation getTexture();
	
	public int getSelectedTexture();
	
	public ResourceLocation getCustomTexture();
	
	public String getCustomTextureString();
	
	public boolean isExternalTexture();
	
	public void setSelectedTexture(int i, String tex, boolean ex);
	
	public static interface TextureHolder {
		
		public java.util.List<NamedResourceLocation> getDefaultTextures();
		
	}

}
