package net.fexcraft.mod.fvtm.test;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;

public class TestTileRenderer implements BlockEntityRenderer<TestTile> {

	public TestTileRenderer(Context context){
		//
	}

	@Override
	public void render(TestTile tile, float ticks, PoseStack stack, MultiBufferSource buffers, int light, int overlay){
		//
		FVTM.getLogger().info("test " + ticks);
	}

}
