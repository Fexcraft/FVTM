package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;

/** @author Ferdinand Calo' (FEX___96) */
public class MRWrapper extends ModelRenderer {
	
	private ModelRenderer parent;
	private TurboList list;
	private TurboList turbo = new TurboList("test");
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
    	net.fexcraft.lib.tmt.ModelBase.bindTexture(ConstructorGui.STONE);
    	GL11.glRotatef(90, 0, 1, 0);
		if(list != null) list.renderPlain();
		if(!turbo.isEmpty()){
			if(turbo.size() == 1) turbo.renderPlain();
			else{
				turbo.get(0).render();
		    	net.fexcraft.lib.tmt.ModelBase.bindTexture(ConstructorGui.ANVIL);
				turbo.get(1).render();
			}
		}
		list = null;
		turbo.clear();;
    	DebugModels.center.renderPlain();
    	RGB.glColorReset();
    	GL11.glRotatef(90, 0, -1, 0);
    	renderer.bindTexture(renderer.getEntityTexture((AbstractClientPlayer)player));
	}

	public void set(EntityPlayer player, TurboList list){
		this.player = player;
		this.list = list;
	}

	public void set(EntityPlayer player, ModelRendererTurbo turbo){
		this.player = player;
		this.turbo.add(turbo);
	}

	public ModelRenderer getParent(){
		return parent;
	}

}
