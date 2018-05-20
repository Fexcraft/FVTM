package net.fexcraft.mod.fme.util;

import java.io.File;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class TempModel extends Model<Object> {

    public TreeMap<String, ArrayList<ModelRendererTurbo>> groups;
    public File file;
    public ResourceLocation texture;

    public TempModel(File file){
        this.file = file;
        this.groups = new TreeMap<String, ArrayList<ModelRendererTurbo>>();
        this.textureWidth = this.textureHeight = 512;
    }

    @Override
    public void render(){
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Object type, Entity entity){
        // TODO Auto-generated method stub

    }

    @Override
    public void translateAll(float x, float y, float z){
        // TODO Auto-generated method stub

    }

    @Override
    public void rotateAll(float x, float y, float z){
        // TODO Auto-generated method stub

    }

    public boolean hasTexture(){
        return texture == null ? false : !this.texture.equals(Resources.NULL_TEXTURE);
    }

    public ResourceLocation getTexture(){
        return hasTexture() ? this.texture : Resources.NULL_TEXTURE;
    }

}
