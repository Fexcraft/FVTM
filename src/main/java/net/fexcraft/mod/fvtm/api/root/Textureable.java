package net.fexcraft.mod.fvtm.api.root;

import java.util.List;

import net.minecraft.util.ResourceLocation;

public interface Textureable {
	
	public int getSelectedTexture();
	
	public void setSelectedTexture(int i);
	
	public ResourceLocation getCustomTexture();
	
	public void setCustomTexture(String string, boolean external);
	
	public boolean isTextureExternal();
	
	public ResourceLocation getTexture();
	
	//
	
	public static interface TextureHolder {
		
		public List<ResourceLocation> getTextures();
		
	}

	public TextureHolder getTextureHolder();
	
}