package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.util.Command;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;

/** @author Ferdinand Calo' (FEX___96) */
public class MRWrapper extends ModelRenderer {
	
	private ModelRenderer parent;
	private ArrayList<ArrayList<String>> cloth_models = new ArrayList<>();
	private ArrayList<ClothItem> cloth_items = new ArrayList<>();
	private RenderPlayer renderer;
	private EntityPlayer player;

	public MRWrapper(ModelBase base, ModelRenderer parent, RenderPlayer renderer){
		super(base);
		this.parent = parent;
		this.renderer = renderer;
	}
	
	public static MRWrapper get(ModelBase base, ModelRenderer from, RenderPlayer renderer){
		if(from.childModels == null || from.childModels.isEmpty()){
			from.addChild(new MRWrapper(base, from, renderer));
		}
		for(ModelRenderer ren : from.childModels){
			if(ren instanceof MRWrapper) return (MRWrapper)ren;
		}
		MRWrapper wrap = new MRWrapper(base, from, renderer);
		from.addChild(wrap);
		return wrap;
	}
	
	@Override
	public void render(float scale){
		if(cloth_models.isEmpty()) return;
    	GL11.glRotatef(90, 0, 1, 0);
    	RenderCache cache = player.getCapability(Capabilities.RENDERCACHE, null);
		for(int i = 0; i < cloth_items.size(); i++){
			net.fexcraft.lib.tmt.ModelBase.bindTexture(cloth_items.get(i).getType().getTexture());
			cloth_items.get(i).getType().getModel().render(cloth_items.get(i), cloth_models.get(i), player, cache);
		}
		cloth_items.clear();
		cloth_models.clear();
    	if(Command.OTHER) DebugModels.center.renderPlain();
    	RGB.glColorReset();
    	GL11.glRotatef(90, 0, -1, 0);
    	renderer.bindTexture(renderer.getEntityTexture((AbstractClientPlayer)player));
	}

	public void set(EntityPlayer player, ClothItem item, ArrayList<String> list){
		this.player = player;
		cloth_items.add(item);
		cloth_models.add(list);
	}

	public ModelRenderer getParent(){
		return parent;
	}

}
