package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonToTMT;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Model;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 * @param <T>
 * @param <K>
 */
public abstract class GenericModel<T, K> implements Model<T, K> {
	
	protected TreeMap<String, TurboList> groups = new TreeMap<String, TurboList>(){
		@Override
		public TurboList get(Object key){
			return super.get(key) == null ? TurboList.EMPTY : super.get(key);
		}
	};
	private ArrayList<String> creators = new ArrayList<>();
	protected int textureX, textureY;
	//
	private static BiConsumer<String, TurboList> bc_render = new BiConsumer<String, TurboList>(){
		@Override public void accept(String key, TurboList group){ group.render(key); }
	};
	
	public GenericModel(){}

	public GenericModel(JsonObject obj){
		this(); if(obj == null){ return; }
        creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
        textureX = obj.get("texture_size_x").getAsInt();
        textureY = obj.get("texture_size_y").getAsInt();
        JsonObject modelobj = obj.get("model").getAsJsonObject();
        for(Entry<String, JsonElement> entry : modelobj.entrySet()){
        	groups.put(entry.getKey(), new TurboList(JsonToTMT.parse(null, entry.getValue().getAsJsonArray(), textureX, textureY)));
        }
	}
	
	@Override
	public final java.util.Collection<String> getCreators(){
		return ImmutableList.copyOf(creators);
	}
	
	public boolean addToCreators(String str){
		return creators.add(str);
	}

	@Override
	public void render(){
		groups.forEach(bc_render);
	}

	public void render(String key){
		groups.get(key).render(key);
	}

    public void render(String key, RGB color){
		color.glColorApply();
		groups.get(key).render(key);
		RGB.glColorReset();
	}
    
    public void renderGlow(Entity ent, String key){
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.depthMask(true);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 238f, 238f);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        groups.get(key).render(key);//
        int i = ent == null ? MapColor.WHITE_STAINED_HARDENED_CLAY.colorValue : ent.getBrightnessForRender(), j = i % 65536, k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
    
    public void renderGlow(Entity ent, String... keys){
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.depthMask(true);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 238f, 238f);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        for(String str : keys){ groups.get(str).render(str); }
        int i = ent == null ? MapColor.WHITE_STAINED_HARDENED_CLAY.colorValue : ent.getBrightnessForRender(), j = i % 65536, k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

	/** legacy method **/
	public void translateAll(float x, float y, float z){
		groups.values().forEach(group -> group.translate(x, y, z));
	}

	/** legacy method **/
	public void rotateAll(float x, float y, float z, boolean apply){
		groups.values().forEach(group -> group.rotate(x, y, z, apply));
	}

	/** legacy method **/
	public void flipAll(){
		groups.values().forEach(group -> fixRotations(group));
	}

	public void bindTexture(ResourceLocation texture){
		ModelBase.bindTexture(texture);
	}
	
	public static void fixRotations(TurboList group){
        for(ModelRendererTurbo model : group){
            if(model.isShape3D){
                model.rotateAngleY = -model.rotateAngleY;
                model.rotateAngleX = -model.rotateAngleX;
                model.rotateAngleZ = -model.rotateAngleZ + Static.rad180;
            }
            else{
                model.rotateAngleZ = -model.rotateAngleZ;
            }
        }
    }

	public boolean notEmpty(String... strs){
		for(String str : strs){
			if(groups.get(str).size() > 0) return true;
		}
		return false;
	}
	
	public void add(String key, ModelRendererTurbo[] mrts){
		this.groups.put(key, new TurboList(mrts));
	}
	
	public TurboList get(String key){
		return groups.get(key);
	}
	
	public void render(ModelRendererTurbo[] mrts){
		for(ModelRendererTurbo mrt : mrts) mrt.render();
	}
	
}