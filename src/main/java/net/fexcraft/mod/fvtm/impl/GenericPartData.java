package net.fexcraft.mod.fvtm.impl;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Attribute.AttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericPartData implements PartData {
	
	private Part part;
	private int sel;
	private Pos offset;
	private String url;
	private ResourceLocation custom;
	private boolean isexternal;
	private HashMap<Class, AttributeData> attributes = new HashMap<Class, AttributeData>();
	
	public GenericPartData(Part part){
		this.part = part;
	}

	@Override
	public Part getPart(){
		return part;
	}

	@Override
	public int getSelectedTexture(){
		return sel;
	}

	@Override
	public Pos getCurrentOffset(){
		return offset;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
		tagcompound.setString(PartItem.NBTKEY, part.getRegistryName().toString());
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("SelectedTexture", sel);
		compound.setString("CustomTexture", isexternal ? url == null ? "" : url : custom == null ? "minecraft:stone" : custom.toString());
		compound.setBoolean("IsTextureExternal", isexternal);
		part.getAttributeClasses().forEach((clazz) -> {
			Attribute attr = part.getAttribute(clazz);
			if(attr.hasDataClass()){
				AttributeData data = this.attributes.get(attr.getDataClass());
				if(data != null){
					data.writeToNBT(this, compound);
				}
			}
		});
		tagcompound.setTag(FVTM.MODID + "_part", offset == null ? compound : offset.toNBT("Offset", compound));
		return tagcompound;
	}

	@Override
	public PartData readFromNBT(NBTTagCompound compound){
		compound = compound.getCompoundTag(FVTM.MODID + "_part");
		sel = compound.getInteger("SelectedTexture");
		offset = Pos.fromNBT("Offset", compound);
		isexternal = compound.getBoolean("IsTextureExternal");
		url = isexternal ? compound.getString("CustomTexture") : null;
		custom = isexternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
		NBTTagCompound[] tagc = new NBTTagCompound[]{compound};
		part.getAttributeClasses().forEach((clazz) -> {
			Attribute attr = part.getAttribute(clazz);
			if(attr.hasDataClass()){
				try{
					this.attributes.put(attr.getDataClass(), attr.getDataClass().getConstructor(PartData.class, Attribute.class).newInstance(this, attr).readFromNBT(this, tagc[0]));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		return this;
	}

	@Override
	public ResourceLocation getCustomTexture(){
		return isexternal ? ExternalTextureHelper.get(url) : this.custom;
	}

	@Override
	public void setCustomTexture(String string, boolean external){
		this.url = external ? string : null;
		this.custom = external ? null : new ResourceLocation(string);
		this.isexternal = external;
	}

	@Override
	public void setSelectedTexture(int i){
		this.sel = i;
	}

	@Override
	public boolean isTextureExternal(){
		return isexternal;
	}

	@Override
	public ResourceLocation getTexture(){
		return sel >= 0 ? part.getTextures().get(sel) : this.getCustomTexture();
	}

	@Override
	public <T extends AttributeData> T getAttributeData(Class<T> clazz){
		return (T)attributes.get(clazz);
	}
	
}