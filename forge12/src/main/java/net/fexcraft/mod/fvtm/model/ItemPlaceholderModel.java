package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ItemPlaceholderModel implements FCLItemModel {
	
	public static final ItemPlaceholderModel INSTANCE = new ItemPlaceholderModel();
	private static ModelRendererTurbo model = new ModelRendererTurbo(null, 0, 0, 1, 1).newBoxBuilder().setSize(1, 1, 0).removePolygons(true, true, true, true, false, true).setOffset(-0.5f, -0.5f, 0).build();
	private static float off = 1.5f * Static.sixteenth, i16 = Static.sixteenth * 0.1f;
	
	@Override
	public void renderItem(TransformType type, ItemStack stack, EntityLivingBase entity){
		if(stack.getItem() instanceof TextureableItem == false) return;
		Content<?> tyco = ((TextureableItem<?>)stack.getItem()).getContent();
		if(tyco == null || tyco instanceof ItemTextureable == false) return;
		IDL itex = ((ItemTextureable)tyco).getItemTexture();
		//
		boolean rd3 = type == TransformType.THIRD_PERSON_LEFT_HAND || type == TransformType.THIRD_PERSON_RIGHT_HAND;
		GL11.glPushMatrix();
		if(rd3) GL11.glTranslatef(0, off, off);
		else if(type == TransformType.FIRST_PERSON_LEFT_HAND || type == TransformType.FIRST_PERSON_RIGHT_HAND){
			GL11.glTranslatef(0, -off, 0);
		}
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glDisable(GL11.GL_CULL_FACE);
		if(rd3) GL11.glScalef(.5f, .5f, .5f);
		TexUtil.bindTexture(itex);
		if(rd3){
			for(int i = 0; i < 8; i++){
				GL11.glTranslatef(0, 0, i16);
				model.render(1f);
			}
		}
		else{
			model.render(1f);
		}
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

}