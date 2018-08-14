package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RoadLineTile;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.math.Vec3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

/** @author Ferdinand Calo' (FEX___96) **/
@fTESR
public class RoadLineRender extends TileEntitySpecialRenderer<RoadLineTile> {

    @Override
    public void render(RoadLineTile te, double posX, double posY, double posZ, float partialticks, int destroystage, float alpha){
    	//if(te.connections == null || te.connections.length == 0){
            GL11.glPushMatrix();
            GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
            Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotated(90, 0, 1D, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
            RailConnRenderer.model.render();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	/*}
    	else*/ if(te.connections.length > 0){
            GL11.glPushMatrix();
            //GL11.glTranslated(posX, posY, posZ);
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
        	Vec3f pos = new Vec3f(mc.player.prevPosX, mc.player.prevPosY, mc.player.prevPosZ);
    		if(te.coords == null) te.coords = new Vec3f[te.connections.length][];
        	for(int i = 0; i < te.connections.length; i++ ){
        		if(te.coords[i] == null){
        			te.coords[i] = getCoords(te, i);
        		}
        		else{
        			for(int j = 0; j < te.coords[i].length - 1; j++){
        				vec0 = te.coords[i][j].subtract(pos); vec1 = te.coords[i][j + 1].subtract(pos);//TODO replace with translate
                        Tessellator tessellator = Tessellator.getInstance();
                        BufferBuilder bufferbuilder = tessellator.getBuffer(); float[] arr = getColor(j);
                        bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                        bufferbuilder.pos(vec0.xCoord, vec0.yCoord, vec0.zCoord).color(arr[0], arr[1], arr[2], 1F).endVertex();
                        bufferbuilder.pos(vec1.xCoord, vec1.yCoord, vec1.zCoord).color(arr[0], arr[1], arr[2], 1F).endVertex();
                        tessellator.draw();
        			}
        		}
        	}
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            //
    	}
    }
    
    private Minecraft mc = Minecraft.getMinecraft();
    private Vec3f vec0, vec1;
    
    private Vec3f[] getCoords(RoadLineTile te, int i){
    	if(te.segments > 3){
    		return null;
    	}
    	else return new Vec3f[]{
    		te.getVec3f(), new Vec3f(te.connections[i][0], true), new Vec3f(te.connections[i][1], true), new Vec3f(te.connections[i][2], true)
    	};
	}

	private float[] getColor(int length){
		float f = length > 4 ? 1f : length * 0.25f;
    	return new float[]{ 1f, f, f };
    }

}
