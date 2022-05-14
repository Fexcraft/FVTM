package net.fexcraft.mod.fvtm.test;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;

import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class TestTileRenderer implements BlockEntityRenderer<TestTile> {
	
	public static ResourceLocation resloc = new ResourceLocation("minecraft:textures/block/stone.png");

	public TestTileRenderer(Context context){
	}

	@Override
	public void render(TestTile tile, float ticks, PoseStack stack, MultiBufferSource buffers, int light, int overlay){
        stack.pushPose();
        stack.translate(0, 1.2, 0);
    	stack.mulPose(Vector3f.YP.rotationDegrees(180));
    	stack.mulPose(Vector3f.ZP.rotationDegrees(180));
        //stack.mulPose(Vector3f.YP.rotationDegrees(1));
        VertexConsumer consumer = buffers.getBuffer(RenderType.entityTranslucent(resloc));
        for(Polyhedron<?> poli : T1PModel.MODEL.hedrons){
        	stack.pushPose();
        	stack.translate(poli.posX * 0.0625f, poli.posY * 0.0625f, poli.posZ * 0.0625f);
            PoseStack.Pose pose = stack.last();
            for(Polygon poly : poli.polygons){
               for(Vertex vertex : poly.vertices){
                  Vector4f pos = new Vector4f(vertex.vector.x, vertex.vector.y, vertex.vector.z, 1.0F);
                  pos.transform(pose.pose());
                  Vector3f norm = new Vector3f(vertex.norm.x, vertex.norm.y, vertex.norm.z);
                  norm.transform(pose.normal());
                  consumer.vertex(pos.x(), pos.y(), pos.z(), 1f, 1f, 1f, 1f, vertex.u, vertex.v, overlay, light, 1, 1, 1);
               }
            }
            stack.popPose();
        }
        stack.popPose();
	}

}
