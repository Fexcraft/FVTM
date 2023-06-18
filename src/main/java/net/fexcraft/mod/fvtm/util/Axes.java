package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.lib.common.Static.PI;
import static net.fexcraft.lib.common.Static.toRadians;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.util.vector.Matrix4f;
import net.fexcraft.mod.fvtm.util.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

/**
 * 31.10.2021
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Axes {
	
	private float yaw, pitch, roll;//radians
	private float dyaw, dpitch, droll;//degrees
	private Matrix4f matrix = new Matrix4f();
	
	public Axes(){}
	
	@Override
	public String toString(){
		return "Axes[ " + yaw + "y, " + pitch + "p, " + roll + "r ]";
	}

	public Vec3d get_vector(float x, float y, float z){
		double[] arr = VecUtil.rotate(new double[]{ x, y, z }, roll, pitch, yaw);
		return new Vec3d(arr[0], arr[1], arr[2]);
	}

	public Vec3d get_vector(Vec3d vec){
		double[] arr = VecUtil.rotate(new double[]{ vec.x, vec.y, vec.z }, roll, pitch, yaw);
		return new Vec3d(arr[0], arr[1], arr[2]);
	}

	public Vec3d get_vector(Vec3d vec, float yawmod){
		double[] arr = VecUtil.rotate(new double[]{ vec.x, vec.y, vec.z }, roll, pitch, (yaw + yawmod));
		return new Vec3d(arr[0], arr[1], arr[2]);
	}

	public V3D get_vector(V3D relpos){
		return VecUtil.rotate(relpos, roll, pitch, yaw);
	}

	/** Saving as degrees to be compatible with old saves.*/
	public NBTTagCompound write(Entity ent, NBTTagCompound compound){
		if(ent != null){
			compound.setDouble("x", ent.posX);
			compound.setDouble("y", ent.posY);
			compound.setDouble("z", ent.posZ);
		}
		compound.setDouble("yaw", dyaw);
		compound.setDouble("pitch", dpitch);
		compound.setDouble("roll", droll);
		return compound;
	}

	/** Loading as degrees to be compatible with old saves.*/
	public static Axes read(Entity ent, NBTTagCompound nbt){
		Axes axes = new Axes();
		axes.dyaw = nbt.getFloat("yaw");
		axes.dpitch = nbt.getFloat("pitch");
		axes.droll = nbt.getFloat("roll");
		axes.yaw = toRadians(axes.dyaw);
		axes.pitch = toRadians(axes.dpitch);
		axes.roll = toRadians(axes.droll);
		if(ent != null){
			ent.prevPosX = ent.posX;
			ent.prevPosY = ent.posY;
			ent.prevPosZ = ent.posZ;
			ent.posX = nbt.getDouble("x");
			ent.posY = nbt.getDouble("y");
			ent.posZ = nbt.getDouble("z");
		}
		return axes;
	}

	public float yaw(){
		return yaw;
	}

	public float deg_yaw(){
		return dyaw;
	}

	public float pitch(){
		return pitch;
	}

	public float deg_pitch(){
		return dpitch;
	}

	public float roll(){
		return roll;
	}

	public float deg_roll(){
		return droll;
	}

	public void copy(Axes axe){
		yaw = axe.yaw;
		roll = axe.roll;
		pitch = axe.pitch;
		dyaw = axe.dyaw;
		dpitch = axe.dpitch;
		droll = axe.droll;
	}

	@Override
	public Axes clone(){
		Axes axes = new Axes();
		axes.yaw = yaw;
		axes.pitch = pitch;
		axes.roll = roll;
		axes.dyaw = dyaw;
		axes.dpitch = dpitch;
		axes.droll = droll;
		return axes;
	}
	
	public void set_yaw(float value, boolean degree){
		set_rotation(degree ? toRadians(value) : value, pitch, roll, false);
	}
	
	public void set_pitch(float value, boolean degree){
		set_rotation(yaw, degree ? toRadians(value) : value, roll, false);
	}
	
	public void set_roll(float value, boolean degree){
		set_rotation(yaw, pitch, degree ? toRadians(value) : value, false);
	}
	
	public void set_rotation(float y, float p, float r, boolean degrees){
		if(degrees){
			dyaw = y;
			dpitch = p;
			droll = r;
		}
		else{
			yaw = y;
			pitch = p;
			roll = r;
		}
		convert(degrees);
	}
	
	public void set_rot(float y, float p, float r, boolean degrees){
		set_rotation(y, p, r, degrees);
	}
	
	public void set_rotation(double y, double p, double r, boolean degrees){
		set_rotation((float)y, (float)p, (float)r, degrees);
	}
	
	public void set_rot(double y, double p, double r, boolean degrees){
		set_rotation((float)y, (float)p, (float)r, degrees);
	}

	private final void convert(boolean deg){
		Matrix4f.setIdentity(matrix);
		matrix.rotate(deg ? toRadians(droll) : roll, new Vector3f(1F, 0F, 0F));
		matrix.rotate(deg ? toRadians(dpitch) : pitch, new Vector3f(0F, 0F, 1F));
		matrix.rotate(deg ? toRadians(dyaw) : yaw, new Vector3f(0F, 1F, 0F));
		dyaw = (yaw = (float)Math.atan2(matrix.m20, matrix.m00)) * 180f / PI;
		dpitch = (pitch = (float)Math.atan2(-matrix.m10, Math.sqrt(matrix.m12 * matrix.m12 + matrix.m11 * matrix.m11))) * 180f / PI;
		droll = (roll = (float)Math.atan2(matrix.m12, matrix.m11)) * 180f / PI;
	}

	public double[] toArrayD(){
		return new double[]{ dyaw, dpitch, droll };
	}

	public float[] toArrayF(){
		return new float[]{ dyaw, dpitch, droll };
	}

	public Vec3d toVec3d(){
		return new Vec3d(dyaw, dpitch, droll);
	}

}
