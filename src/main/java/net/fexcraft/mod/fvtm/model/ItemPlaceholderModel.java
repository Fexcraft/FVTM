package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.ItemTex;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemPlaceholderModel implements FCLItemModel {
	
	public static final ItemPlaceholderModel INSTANCE = new ItemPlaceholderModel();
	private static ModelRendererTurbo model = new ModelRendererTurbo(null, 0, 0, 1, 1).newBoxBuilder().setSize(1, 1, 0).removePolygons(true, true, true, true, false, true).setOffset(-0.5f, -0.5f, 0).build();
	
	@Override
	public void renderItem(TransformType type, ItemStack stack, EntityLivingBase entity){
		if(stack.getItem() instanceof ItemTex == false) return;
		TypeCore<?> tyco = ((ItemTex<?>)stack.getItem()).getDataType();
		if(tyco == null || tyco instanceof ItemTextureable == false) return;
		ResourceLocation itex = ((ItemTextureable)tyco).getItemTexture();
		//
		boolean rd3 = type == TransformType.THIRD_PERSON_LEFT_HAND || type == TransformType.THIRD_PERSON_RIGHT_HAND;
		GL11.glPushMatrix();
		if(rd3) GL11.glTranslatef(0, 0, -.005f);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glDisable(GL11.GL_CULL_FACE);
		if(rd3) GL11.glScalef(.5f, .5f, .5f);
		TexUtil.bindTexture(itex);
		model.render(1f);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

}