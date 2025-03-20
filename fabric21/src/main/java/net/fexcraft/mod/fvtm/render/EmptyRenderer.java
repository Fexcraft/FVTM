package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EmptyRenderer extends EntityRenderer<Entity, EntityRenderState> {

	public EmptyRenderer(EntityRendererProvider.Context context){
		super(context);
	}

	@Override
	public EntityRenderState createRenderState(){
		return new EntityRenderState();
	}

	@Override
	public void render(EntityRenderState state, PoseStack pose, MultiBufferSource buffer, int light){
		//
	}

}