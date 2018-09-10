package net.fexcraft.mod.fvtm.impl.root;

import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericTextureable<T, B> implements Textureable, Saveloadable<T> {

    protected B root;
    protected int sel;
    protected String url;
    protected ResourceLocation custom;
    protected boolean isexternal;

    public GenericTextureable(B base){
        this.root = base;
    }

    @Override
    public int getSelectedTexture(){
        return sel;
    }

    @Override
    public void setSelectedTexture(int i){
        this.sel = i;
    }

    @Override
    public ResourceLocation getCustomTexture(){
        return isexternal ? ExternalTextureHelper.get(url) : custom;
    }

    @Override
    public void setCustomTexture(String string, boolean external){
        url = external ? string : null;
        custom = external ? null : new ResourceLocation(string);
        isexternal = external;
    }

    @Override
    public boolean isTextureExternal(){
        return isexternal;
    }

    @Override
    public ResourceLocation getTexture(){
        return sel >= 0 ? ((TextureHolder)root).getTextures().get(sel) : this.getCustomTexture();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound.setInteger("SelectedTexture", sel);
        compound.setString("CustomTexture", isexternal ? url == null ? "" : url : custom == null ? "minecraft:stone" : custom.toString());
        compound.setBoolean("IsTextureExternal", isexternal);
        return compound;
    }

    @Override
    public T readFromNBT(NBTTagCompound compound){
        this.sel = compound.getInteger("SelectedTexture");
        isexternal = compound.getBoolean("IsTextureExternal");
        url = isexternal ? compound.getString("CustomTexture") : null;
        custom = isexternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
        return null;
    }

    @Override
    public TextureHolder getTextureHolder(){
        return (TextureHolder) root;
    }

}
