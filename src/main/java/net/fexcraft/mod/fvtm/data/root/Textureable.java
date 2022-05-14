package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.util.NamedResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class Textureable {
	
	private ResourceLocation currtex;
	private String custom = "";
	private boolean external;
	private int selected;
	
	public Textureable(TextureHolder holder){
		currtex = holder.getDefaultTextures().get(0);
	}
	
	public ResourceLocation getTexture(){
		return currtex;
	}
	
	public int getSelected(){
		return selected;
	}
	
	public boolean isExternal(){
		return external;
	}

	public String getCustom(){
		return custom;
	}
	
	public void setSelectedTexture(TextureHolder holder, int idx, String tex, boolean ext){
		if(idx < 0){
			external = ext;
			selected = -1;
			custom = tex;
			currtex = /*ext ? ExternalTextureHelper.get(custom) :*/ new ResourceLocation(custom);//TODO external textures
		}
		else{
			external = false;
			if(idx > holder.getDefaultTextures().size()){
				currtex = holder.getDefaultTextures().get(selected = holder.getDefaultTextures().size() - 1);
			}
			else{
				currtex = holder.getDefaultTextures().get(selected = idx);
			}
		}
	}
	
	public static interface TextureHolder {
		
		public java.util.List<NamedResourceLocation> getDefaultTextures();
		
	}
	
	public static interface TextureUser {
		
		public Textureable getTexture();
		
		public TextureHolder getTexHolder();
		
		public default ResourceLocation getCurrentTexture(){
			return getTexture().currtex;
		}
		
		public default int getSelectedTexture(){
			return getTexture().selected;
		}
		
		public default boolean isTextureExternal(){
			return getTexture().external;
		}
		
		public default String getCustomTexture(){
			return getTexture().custom;
		}
		
	}

	public void save(CompoundTag compound){
		compound.putInt("SelectedTexture", selected);
		compound.putBoolean("ExternalTexture", external);
		compound.putString("CurrentTexture", external ? currtex.getPath() : currtex.toString());
	}

	public void load(CompoundTag compound, TextureHolder holder){
		selected = compound.getInt("SelectedTexture");
		external = compound.getBoolean("ExternalTexture");
		if(selected < 0) selected = -1;
		if(!compound.contains("CurrentTexture")){
			custom = compound.getString("CustomTexture");
			if(selected < 0) currtex = /*external ? ExternalTextureHelper.get(custom) :*/ new ResourceLocation(custom);//TODO external textures
			else currtex = holder.getDefaultTextures().get(selected > holder.getDefaultTextures().size() ? 0 : selected);
		}
		else{
			String str = compound.getString("CurrentTexture");
			currtex = /*external ? ExternalTextureHelper.get(str) :*/ new ResourceLocation(str);//TODO external textures
			custom = selected < 0 ? external ? str : currtex.toString() : "";
		}
	}

}
