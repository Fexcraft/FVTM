package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RoadLineTile;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.util.Axe;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.util.math.Vec3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;

import org.lwjgl.opengl.GL11;

/** @author Ferdinand Calo' (FEX___96) **/
//@fTESR
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
        	Vec3f pos = new Vec3f(mc.player.prevPosX, mc.player.prevPosY, mc.player.prevPosZ);
    		if(te.coords == null) te.coords = new Vec3f[te.connections.length][];
        	for(int i = 0; i < te.connections.length; i++ ){
        		if(te.coords[i] == null){
        			te.coords[i] = getCoords(te, i);
        		}
        		else{
        			Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder bufferbuilder = tessellator.getBuffer();
                    //-//
                    GL11.glPushMatrix();
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    GlStateManager.glLineWidth(2.0F);
                    GlStateManager.disableTexture2D();
                    GlStateManager.depthMask(false);
        			for(int j = 0; j < te.coords[i].length - 1; j++){
        				vec0 = te.coords[i][j].subtract(pos);
        				vec1 = te.coords[i][j + 1].subtract(pos);//TODO replace with translate
                        float[] arr = getColor(j);
                        bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                        bufferbuilder.pos(vec0.xCoord, vec0.yCoord, vec0.zCoord).color(arr[0], arr[1], arr[2], 1F).endVertex();
                        bufferbuilder.pos(vec1.xCoord, vec1.yCoord, vec1.zCoord).color(arr[0], arr[1], arr[2], 1F).endVertex();
                        tessellator.draw();
        			}
                    GlStateManager.depthMask(true);
                    GlStateManager.enableTexture2D();
                    GlStateManager.disableBlend();
                    GL11.glPopMatrix();
        			//-//
                    GL11.glPushMatrix();
                    ModelBase.bindTexture(Resources.NULL_TEXTURE);
        			int l = te.coords[i].length / 4;
        			for(int m = 0; m < l; m++){ int k = m * 4;
        				Vec3f[] arr = new Vec3f[]{ te.coords[i][k], te.coords[i][k + 1], te.coords[i][k + 2], te.coords[i][k + 3]};
        				GL11.glTranslatef(-pos.xCoord, -pos.yCoord, -pos.zCoord);
                        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
                        bufferbuilder.pos(arr[0].xCoord, arr[0].yCoord, arr[0].zCoord).tex(0 * 0.00390625F, 8 * 0.00390625F).endVertex();
                        bufferbuilder.pos(arr[1].xCoord, arr[1].yCoord, arr[1].zCoord).tex(8 * 0.00390625F, 8 * 0.00390625F).endVertex();
                        bufferbuilder.pos(arr[2].xCoord, arr[2].yCoord, arr[2].zCoord).tex(8 * 0.00390625F, 0 * 0.00390625F).endVertex();
                        bufferbuilder.pos(arr[3].xCoord, arr[3].yCoord, arr[3].zCoord).tex(0 * 0.00390625F, 0 * 0.00390625F).endVertex();
                        tessellator.draw();
                        GL11.glTranslatef(pos.xCoord, pos.yCoord, pos.zCoord);
        			}
                    GL11.glPopMatrix();
        		}
        	}
            GL11.glPopMatrix();
            //
    	}
    }
    
    private Minecraft mc = Minecraft.getMinecraft();
    private Vec3f vec0, vec1;
    
    private Vec3f[] getCoords(RoadLineTile te, int conn){
    	//if(te.segments > 3){ return null; } else return new Vec3f[]{ te.getVec3f(), new Vec3f(te.connections[i][0], true), new Vec3f(te.connections[i][1], true), new Vec3f(te.connections[i][2], true) };
    	Vec3f[] arr = new Vec3f[]{
    		te.getVec3f(), new Vec3f(te.connections[conn][0], true), new Vec3f(te.connections[conn][1], true), new Vec3f(te.connections[conn][2], true)
    	};
    	//for(Vec3f vec : arr) vec.yCoord -= 0.48f;
    	Vec3f[] res = new Vec3f[(arr.length * 4) - 4];
    	float xrot = 0, yrot = 0; Axe ax = new Axe();
    	EnumFacing facing = EnumFacing.getFront(te.getBlockMetadata());
        float xx = facing.getAxis() == EnumFacing.Axis.X ? 0 : facing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE ? 0.2f : -0.2f;
        float zz = facing.getAxis() == EnumFacing.Axis.Z ? 0 : facing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE ? 0.2f : -0.2f;;
    	for(int i = 0; i < arr.length; i++){
    		if(i == (arr.length - 1)) break;
            double x = arr[i].xCoord - arr[i + 1].xCoord, y = arr[i].yCoord - arr[i + 1].yCoord, z = arr[i].zCoord - arr[i + 1].zCoord;
            double xz = Math.sqrt(x * x + z * z), yaw = Math.atan2(z, x), pitch = -Math.atan2(y, xz);
			if(i == 0) ax.setRotation(yaw, pitch, 0);
            res[i * 4    ] = arr[i].add(ax.getRelativeVector( xx, 0,  zz));
			res[i * 4 + 1] = arr[i].add(ax.getRelativeVector(-xx, 0, -zz));
            if(i != arr.length - 2) ax.setRotation(xrot += yaw, yrot += pitch, 0);
			res[i * 4 + 2] = arr[i + 1].add(ax.getRelativeVector(-xx, 0, -zz));
			res[i * 4 + 3] = arr[i + 1].add(ax.getRelativeVector( xx, 0,  zz));
    		//
			/*res[i * 4    ] = arr[i].distance(new Vec3f(-arr[i    ].zCoord, arr[i    ].yCoord,  arr[i    ].xCoord), 0.2f);
			res[i * 4 + 1] = arr[i].distance(new Vec3f( arr[i    ].zCoord, arr[i    ].yCoord, -arr[i    ].xCoord), 0.2f);
			res[i * 4 + 2] = arr[i].distance(new Vec3f(-arr[i + 1].zCoord, arr[i + 1].yCoord,  arr[i + 1].xCoord), 0.2f);
			res[i * 4 + 3] = arr[i].distance(new Vec3f( arr[i + 1].zCoord, arr[i + 1].yCoord, -arr[i + 1].xCoord), 0.2f);*/
			//
    		/*Vec3f left = new Vec3f(), right = new Vec3f();
    		if(i < arr.length - 1){
    			left  = arr[i].distance(new Vec3f(-arr[i + 1].zCoord, arr[i + 1].yCoord,  arr[i + 1].xCoord), 0.2f);
    			right = arr[i].distance(new Vec3f( arr[i + 1].zCoord, arr[i + 1].yCoord, -arr[i + 1].xCoord), 0.2f);
    		}
    		else{
    			left  = arr[i].distance(new Vec3f(-arr[i - 1].zCoord, arr[i - 1].yCoord,  arr[i - 1].xCoord), 0.2f);
    			right = arr[i].distance(new Vec3f( arr[i - 1].zCoord, arr[i - 1].yCoord, -arr[i - 1].xCoord), 0.2f);
    		}
    		//
    		res[i * 2] = left; res[(i * 2) + 1] = right;*/
    		//
    		/*rev = i % 2 == 1 && i < arr.length - 1;
    		if(i == 0) ax.setRotation(0, 0, 0);
    		else if(i >= arr.length - 1) ax.setRotation(xrot, yrot, 0);
    		else{
                double x = arr[i].xCoord - arr[i + 1].xCoord, y = arr[i].yCoord - arr[i + 1].yCoord, z = arr[i].zCoord - arr[i + 1].zCoord;
                double xz = Math.sqrt(x * x + z * z), yaw = Math.atan2(z, x), pitch = -Math.atan2(y, xz);
                ax.setRotation(xrot += yaw, yrot += pitch, 0d);
    		}
    		float x = rev ? 0f : 0.2f, z = rev ? 0.2f : -0f;
    		//x = i == 0 ? -x : x; z = i == 0 ? -z : z;
    		res[i * 2] = arr[i].add(ax.getRelativeVector(new Vec3f(-x, 0, -z)));
    		res[(i * 2) + 1] = arr[i].add(ax.getRelativeVector(new Vec3f(x, 0, z)));*/
    	} //Print.debug(res);
    	return res;
	}

	private float[] getColor(int length){
		float f = length > 16? 1f : length * 0.0625f;
    	return new float[]{ f, f, 1f };
    }

}
