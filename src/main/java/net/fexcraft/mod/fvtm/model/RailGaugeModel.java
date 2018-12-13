package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Collection;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RailGaugeModel implements Model<TrackTileEntity, Connection> {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	private static final ArrayList<String> creators = new ArrayList<>();
	static { creators.add("Ferdinand (FEX___96)"); }
	//
	public ModelRendererTurbo[] base = new ModelRendererTurbo[0];
	
	
	public RailGaugeModel(){ super(); }

	@Override
	public void render(TrackTileEntity te, Connection conn){
		this.render(te, conn, null, 0);
	}

	@Override
	public void render(TrackTileEntity te, Connection conn, VehicleEntity ent, int i){
		if(conn.opposite) return;
		if(Command.DEBUG){
			float[] colr = getColor(te.getWorld(), te.getPos(), te.connections.length, i);
			GL11.glColor4f(colr[0], colr[1], colr[2], 0.25f);
		}
		boolean b = false;
		for(int k = 0; k < conn.vecpoints.length - 1; k++){
			Vec3d vec1 = conn.getVecpoint(k).subtract(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
			Vec3d vec = conn.getVecpoint(k + 1).subtract(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
			if(i > 2) GL11.glTranslated(0, -0.02, 0);
			double dis = vec1.distanceTo(vec);
			/* renderpiece(vec1, vec, dis); while(dis > 0.5){ dis -= 0.5; renderpiece(vec1, vec, dis); } if(dis > 0) renderpiece(vec1, vec, dis); */
			if(b = !b) GL11.glTranslated(0, -0.02, 0);
			while(dis > 0){ renderpiece(vec1, vec, dis); dis -= 0.5; }
			if(b) GL11.glTranslated(0, 0.02, 0);
			/*if(Command.DEBUG && k == 0){
				GL11.glPushMatrix();
				GL11.glTranslated( 0.5,  0.5,  0.5);
				double angle = Math.toDegrees(Math.atan2(vec1.z - vec.z, vec1.x - vec.x));
				GL11.glRotated(-angle, 0, 1, 0);
				ModelBase.bindTexture(Resources.NULL_TEXTURE); model0.render();
				GL11.glRotated( angle, 0, 1, 0);
				GL11.glTranslated(-0.5, -0.5, -0.5);
				GL11.glPopMatrix();
			}*/
			if(i > 2) GL11.glTranslated(0, 0.02, 0);
		}
		if(Command.DEBUG) GL11.glColor4f(1f, 1f, 1f, 1f);
	}

	@Override
	public Collection<String> getCreators(){
		return ImmutableList.<String>copyOf(creators);
	}

	@Override
	public boolean addToCreators(String str){
		return false;
	}

	private void renderpiece(Vec3d vec1, Vec3d vec, double dis){
		double angle = Math.toDegrees(Math.atan2(vec1.z - vec.z, vec1.x - vec.x));
		double[] dest = new double[]{ vec.x, vec.y, vec.z };
		dest = Vector3D.direction(dest[0] - vec1.x, dest[1] - vec1.y, dest[2] - vec1.z);
		dest = Vector3D.newVector(vec1.x + (dest[0] * dis), vec1.y + (dest[1] * dis), vec1.z + (dest[2] * dis));
		GL11.glTranslated( dest[0],  dest[1],  dest[2]);
		GL11.glRotated( 180, 0, 0, 1);
		GL11.glRotated( angle, 0, 1, 0);
		for(ModelRendererTurbo turbo : base) turbo.render();
		GL11.glRotated(-angle, 0, 1, 0);
		GL11.glRotated(-180, 0, 0, 1);
		GL11.glTranslated(-dest[0], -dest[1], -dest[2]);
	}
	
	private float[] getColor(World world, BlockPos pos, int length, int i){
		switch(length){
			case 1:{
				return new float[]{ 0, 0, 1 };
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