package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.Print;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

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
			currtex = ext ? ExternalTextureHelper.get(custom) : new ResourceLocation(custom);
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

	public void save(NBTTagCompound compound){
		compound.setInteger("SelectedTexture", selected);
		compound.setBoolean("ExternalTexture", external);
		compound.setString("CurrentTexture", external ? currtex.getPath() : currtex.toString());
		Print.debug(currtex, selected, external, custom);
	}

	public void load(NBTTagCompound compound, TextureHolder holder){
		selected = compound.getInteger("SelectedTexture");
		external = compound.getBoolean("ExternalTexture");
		if(selected < 0) selected = -1;
		if(!compound.hasKey("CurrentTexture")){
			custom = compound.getString("CustomTexture");
			if(selected < 0) currtex = external ? ExternalTextureHelper.get(custom) : new ResourceLocation(custom);
			else currtex = holder.getDefaultTextures().get(selected > holder.getDefaultTextures().size() ? 0 : selected);
		}
		else{
			String str = compound.getString("CurrentTexture");
			currtex = external ? ExternalTextureHelper.get(str) : new ResourceLocation(str);
			custom = selected < 0 ? external ? str : currtex.toString() : "";
		}
		Print.debug(currtex, selected, external, custom);
	}

}
