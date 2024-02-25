package net.fexcraft.mod.fvtm.render;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil.NewRoad;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.World;

public class RoadRenderer {
    
    public static void renderRoads(World world, double cx, double cy, double cz, float partialticks){//RenderWorldLastEvent event){
    	//if(Config.DISABLE_ROADS) return;
        if(RoadPlacingUtil.CL_CURRENT == null || RoadPlacingUtil.CL_CURRENT.points.size() < 2) return;
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glTranslated(-cx, -cy, -cz);
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        V3D vec0, vec1;
		NewRoad nroad = RoadPlacingUtil.CL_CURRENT;
		if(nroad.preview == null) nroad.genpreview();
        GL11.glPushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(4.0F);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
		for(int j = 0; j < nroad.road.vecpath.length - 1; j++){
			vec0 = nroad.road.vecpath[j].sub(cx, cy, cz);
            vec1 = nroad.road.vecpath[j + 1].sub(cx, cy, cz);
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(vec0.x, vec0.y + 1.25, vec0.z).color(0, 0, 1, 1F).endVertex();
            bufferbuilder.pos(vec1.x, vec1.y + 1.25, vec1.z).color(0, 0, 1, 1F).endVertex();
            tessellator.draw();
		}
		int size = RoadPlacingUtil.CL_CURRENT.points.size();
		double[] arr = null;
		for(int i = 1; i < size - 1; i++){
			arr = nroad.road.getPosition((nroad.road.length / (size - 1)) * i);
			vec1 = RoadPlacingUtil.CL_CURRENT.points.get(i).vec.sub(cx, cy, cz);;
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(arr[0] - cx, arr[1] + 1.25 - cy, arr[2] - cz).color(0, 1, 1, 1F).endVertex();
            bufferbuilder.pos(vec1.x, vec1.y + 1.25, vec1.z).color(0, 1, 1, 1F).endVertex();
            tessellator.draw();
		}
		for(ArrayList<V3D> l : nroad.preview){
			for(int j = 0; j < l.size() - 1; j++){
				bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
				bufferbuilder.pos((vec0 = l.get(j).sub(cx, cy, cz)).x, vec0.y + 1.05, vec0.z).color(1, 0.75f, 0, 1F).endVertex();
				bufferbuilder.pos((vec1 = l.get(j + 1).sub(cx, cy, cz)).x, vec1.y + 1.05, vec1.z).color(1, 0.75f, 0, 1F).endVertex();
				tessellator.draw();
			}
		}
		//
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GL11.glPopMatrix();
		GL11.glPopMatrix();
    }

}
