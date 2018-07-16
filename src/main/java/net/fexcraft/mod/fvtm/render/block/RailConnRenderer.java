package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

@fTESR
public class RailConnRenderer extends TileEntitySpecialRenderer<RailConnTile> {
	
	private static final ModelRendererTurbo model;
	static {
        model = new ModelRendererTurbo(null, 0, 0, 32, 32);
        model.addCylinder(0, 0, 0, 2, 16, 32, 1, 1, ModelRendererTurbo.MR_TOP);
        model.setRotationPoint(0, -16, 0);
	}

    @Override
    public void render(RailConnTile te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	//if(te.links == null || te.links.length == 0){
            GL11.glPushMatrix();
            GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
            Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotated(90, 0, 1D, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
            model.render();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	//}
    	if(te.connections.length > 0){
            GL11.glPushMatrix();
            GL11.glTranslated(posX, posY, posZ);
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
            Minecraft mc = Minecraft.getMinecraft();
        	Vec3d pos = new Vec3d(posX + mc.player.posX, posY + mc.player.posY, posZ + mc.player.posZ);
        	for(int i = 0; i < te.connections.length; i++){
            	Vec3d vec0 = RailConnTile.newVector(te.getPos()).subtract(pos);
        		Vec3d vec = RailConnTile.newVector(te.connections[i]).subtract(pos);
        		//vec = new Vec3d(vec.x * 0.5, vec.y, vec.z * 0.5);
        		vec = new Vec3d((vec0.x + vec.x) * 0.5, (vec0.y + vec.y) * 0.5, (vec0.z + vec.z) * 0.5);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferbuilder = tessellator.getBuffer();
                float[] arr = getColor(te.getWorld(), te.getPos(), te.connections.length, i);
                bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                bufferbuilder.pos(vec0.x, vec0.y, vec0.z).color(arr[0], arr[1], arr[2], 1F).endVertex();
                bufferbuilder.pos( vec.x,  vec.y,  vec.z).color(arr[0], arr[1], arr[2], 1F).endVertex();
                tessellator.draw();
        	}
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	}
    }
    
    private float[] getColor(World world, BlockPos pos, int length, int i){
    	switch(length){
    		case 1:{
    			return new float[]{ 0, 1, 0.5f };
    		}
    		case 2:{
    			return new float[]{ 0, 1, 0 };
    		}
    		case 3:{
    			switch(i){
    				case 0: return new float[]{ 0, 1, 0 };
    				case 1: return new float[]{ 1, world.isBlockPowered(pos) ? 0.5f : 1, 0 };
    				case 2: return new float[]{ 1, world.isBlockPowered(pos) ? 1 : 0.5f, 0 };
    			}
    			break;
    		}
    		case 4:{
    			if(i < 2){
        			return new float[]{ 1, 0.5f, 0 };
    			}
    			else{
        			return new float[]{ 1, 1, 0 };
    			}
    		}
    	}
		return new float[]{ 1, 0, 0 };
    }

}
