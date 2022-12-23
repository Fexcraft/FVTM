package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.item.RoadToolItem.Road;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.World;

public class RoadRenderer {
    
    public static void renderRoads(World world, double cx, double cy, double cz, float partialticks){//RenderWorldLastEvent event){
    	//if(Config.DISABLE_ROADS) return;
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
        if(RoadPlacingUtil.CL_CURRENT != null && RoadPlacingUtil.CL_CURRENT.points.size() > 1){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Vec3f vec0, vec1;
			Road road = RoadPlacingUtil.CL_CURRENT.road;
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(4.0F);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
			for(int j = 0; j < road.vecpath.length - 1; j++){
				vec0 = road.vecpath[j]; vec1 = road.vecpath[j + 1];
                bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                bufferbuilder.pos(vec0.x, vec0.y + 1.25, vec0.z).color(0, 0, 1, 1F).endVertex();
                bufferbuilder.pos(vec1.x, vec1.y + 1.25, vec1.z).color(0, 0, 1, 1F).endVertex();
                tessellator.draw();
			}
			if(RoadPlacingUtil.CL_CURRENT.points.size() > 2){
				int size = RoadPlacingUtil.CL_CURRENT.points.size();
				float[] arr = null;
				for(int i = 1; i < size - 1; i++){
					arr = road.getPosition((road.length / (size - 1)) * i);
					vec1 = RoadPlacingUtil.CL_CURRENT.points.get(i).vector;
	                bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
	                bufferbuilder.pos(arr[0], arr[1] + 1.25, arr[2]).color(0, 1, 1, 1F).endVertex();
	                bufferbuilder.pos(vec1.x, vec1.y + 1.25, vec1.z).color(0, 1, 1, 1F).endVertex();
	                tessellator.draw();
				}
			}
			//
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
        }
		GL11.glPopMatrix();
    }

}
