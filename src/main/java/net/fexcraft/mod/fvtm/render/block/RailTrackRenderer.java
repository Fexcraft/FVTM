package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.block.ModelRailSTD125Half;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

@fTESR
public class RailTrackRenderer extends TileEntitySpecialRenderer<TrackTileEntity> {
	
	protected static final ModelRendererTurbo model;
	static{ model = new ModelRendererTurbo(null, 0, 0, 32, 32); model.addCylinder(0, 0, 0, 3, 5, 32, 1, 1, ModelRendererTurbo.MR_TOP); model.setRotationPoint(0, -5, 0); }

	@Override
	public void render(TrackTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
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
			float[] colr = getColor(te.getWorld(), te.getPos(), te.connections.length, i);
			GL11.glColor4f(colr[0], colr[1], colr[2], 0.25f);
			Vec3d vec = RailConnTile.newVector(te.connections[i].getDestination().subtract(te.getPos()));
			vec = new Vec3d((vec1.x + vec.x) * 0.5, (vec1.y + vec.y) * 0.5, (vec1.z + vec.z) * 0.5);
			ModelRailSTD125Half.bindTexture(); double dis = vec1.distanceTo(vec);
			while(dis > 0.5){ dis -= 0.5;
				renderpiece(vec1, vec, dis);
			}
			if(dis > 0.1){
				renderpiece(vec1, vec, dis);
			}
			GL11.glColor4f(1f, 1f, 1f, 1f);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	private void renderpiece(Vec3d vec1, Vec3d vec, double dis){
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
