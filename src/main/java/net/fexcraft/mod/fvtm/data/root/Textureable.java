package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.registry.UCResourceLocation;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class Textureable {
	
	private ResourceLocation currtex = Resources.NULL_TEXTURE;
	private String custom;
	private boolean external;
	private int selected;
	
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
			currtex = new UCResourceLocation(custom = tex);
		}
		else{
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
		
	}

	public void save(NBTTagCompound compound){
		compound.setInteger("SelectedTexture", selected);
		if(external) compound.setBoolean("ExternalTexture", external);
		compound.setString("CurrentTexture", currtex.toString());
	}

	public void load(NBTTagCompound compound, TextureHolder holder){
		selected = compound.getInteger("SelectedTexture");
		if(selected < 0){
			external = compound.getBoolean("ExternalTexture");
			custom = compound.getString("CustomTexture");
		}
		if(!compound.hasKey("CurrentTexture")){
			if(selected < 0) currtex = new UCResourceLocation(custom);
			else currtex = holder.getDefaultTextures().get(selected > holder.getDefaultTextures().size() ? 0 : selected);
		}
		else currtex = new UCResourceLocation(compound.getString("CurrentTexture"));
	}

}
