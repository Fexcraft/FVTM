package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

/** @author Ferdinand Calo' (FEX___96) */
public class MRWrapper extends ModelRenderer {
	
	private ModelRenderer parent;
	private ArrayList<ArrayList<String>> cloth_models = new ArrayList<>();
	private ArrayList<ClothItem> cloth_items = new ArrayList<>();
	private ArrayList<String> cloth_groups = new ArrayList<>();
	private RenderLivingBase<?> renderer;
	private EntityLivingBase entity;
	private String id;

	public MRWrapper(ModelBase base, ModelRenderer parent, RenderLivingBase<?> renderer, String id){
		super(base);
		this.parent = parent;
		this.renderer = renderer;
		this.id = id;
	}
	
	public static MRWrapper get(ModelBase base, ModelRenderer from, RenderLivingBase<?> renderer, String id){
		if(from.childModels == null || from.childModels.isEmpty()){
			from.addChild(new MRWrapper(base, from, renderer, id));
		}
		for(ModelRenderer ren : from.childModels){
			if(ren instanceof MRWrapper) return (MRWrapper)ren;
		}
		MRWrapper wrap = new MRWrapper(base, from, renderer, id);
		from.addChild(wrap);
		return wrap;
	}
	
	@Override
	public void render(float scale){
		if(cloth_models.isEmpty()) return;
    	GL11.glRotatef(90, 0, 1, 0);
    	int deftex = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
    	RenderCache cache = entity.getCapability(Capabilities.RENDERCACHE, null);
		for(int i = 0; i < cloth_items.size(); i++){
			TexUtil.bindTexture(cloth_items.get(i).getContent().getTexture());
			if(cloth_groups.get(i).startsWith("skirt")){
				GL11.glPushMatrix();
				if(id.contains("right")) GL11.glTranslatef(0, 0, 0.25f);
				GL11.glRotated(parent.rotateAngleX * 5, 0, 0, 1);
			}
			cloth_items.get(i).getContent().getModel().render(RENDERDATA.set(cloth_items.get(i), cloth_models.get(i), entity, cache));
			if(cloth_groups.get(i).startsWith("skirt")) GL11.glPopMatrix();
		}
		cloth_items.clear();
		cloth_models.clear();
		cloth_groups.clear();
    	if(Command.OTHER) DebugModels.center.render();
    	RGB.glColorReset();
    	GL11.glRotatef(90, 0, -1, 0);
    	GlStateManager.bindTexture(deftex);
	}

	public void set(EntityLivingBase entity, ClothItem item, ArrayList<String> list, String key){
		this.entity = entity;
		cloth_items.add(item);
		cloth_models.add(list);
		cloth_groups.add(key);
	}

	public ModelRenderer getParent(){
		return parent;
	}

}
