package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.block.ModelRailSTD125Half;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

@fTESR
public class RailConnRenderer extends TileEntitySpecialRenderer<RailConnTile> {
	
	protected static final ModelRendererTurbo model;
	static{ model = new ModelRendererTurbo(null, 0, 0, 32, 32); model.addCylinder(0, 0, 0, 3, 5, 32, 1, 1, ModelRendererTurbo.MR_TOP); model.setRotationPoint(0, -5, 0); }

	@Override
	public void render(RailConnTile te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
		if(te.connections == null || te.connections.length < 2){
			GL11.glPushMatrix();
			GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
			ModelBase.bindTexture(ModelConstructorCenter.getTexture());
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotated(90, 0, 1D, 0);
			ModelBase.bindTexture(Resources.NULL_TEXTURE);
			model.render();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		GL11.glTranslated(posX, posY - 0.5, posZ);
		GL11.glPushMatrix();
		Vec3d vec1 = new Vec3d(0.5, 0.5, 0.5);
		for(int i = 0; i < te.connections.length; i++){
			Vec3d vec = RailConnTile.newVector(te.connections[i].subtract(te.getPos()));
			vec = new Vec3d((vec1.x + vec.x) * 0.5, (vec1.y + vec.y) * 0.5, (vec1.z + vec.z) * 0.5);
			ModelRailSTD125Half.bindTexture(); double dis = vec1.distanceTo(vec);
			while(dis > 0.5){ dis -= 0.5;
				double angle = Math.toDegrees(Math.atan2(vec1.z - vec.z, vec1.x - vec.x));
				double[] dest = new double[]{ vec.x, vec.y, vec.z };
				dest = Vector3D.direction(dest[0] - vec1.x, dest[1] - vec1.y, dest[2] - vec1.z);
				dest = Vector3D.newVector(vec1.x + (dest[0] * dis), vec1.y + (dest[1] * dis), vec1.z + (dest[2] * dis));
				GL11.glTranslated( dest[0],  dest[1],  dest[2]);
				GL11.glRotated( 180, 0, 0, 1);
				GL11.glRotated( angle, 0, 1, 0);
				ModelRailSTD125Half.INSTANCE.render();
				GL11.glRotated(-angle, 0, 1, 0);
				GL11.glRotated(-180, 0, 0, 1);
				GL11.glTranslated(-dest[0], -dest[1], -dest[2]);
			}
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		/*if(te.connections.length > 0 && Minecraft.getMinecraft().gameSettings.showDebugInfo){
			GL11.glPushMatrix();
			GL11.glTranslated(posX, posY, posZ);
			GL11.glPushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.glLineWidth(2.0F);
			GlStateManager.disableTexture2D();
			GlStateManager.depthMask(false);
			Minecraft mc = Minecraft.getMinecraft();
			Vec3d pos = new Vec3d(posX + mc.player.prevPosX, posY + mc.player.prevPosY, posZ + mc.player.prevPosZ);
			for(int i = 0; i < te.connections.length; i++){
				Vec3d vec0 = RailConnTile.newVector(te.getPos()).subtract(pos);
				Vec3d vec = RailConnTile.newVector(te.connections[i]).subtract(pos);
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
		}*/
	}
	
	/*private float[] getColor(World world, BlockPos pos, int length, int i){
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
	}*/

}
