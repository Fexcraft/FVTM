package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.lib.common.Static.PI;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.util.vector.Matrix4f;
import net.fexcraft.mod.fvtm.util.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

/**
 * Earlier "VehicleAxe", initially based on Flansmod's RotatedAxes.
 * 
 * @author Ferdinand Calo' (FEX___96)
 */
public class Axis3D {

	private Matrix4f matrix = new Matrix4f();
	private double yaw, pitch, roll;

	public Axis3D(){}

	public Axis3D(float yaw, float pitch, float roll){
		set_rotation(yaw, pitch, roll, false);
	}

	@Override
	public String toString(){
		return "[ " + yaw + "y, " + pitch + "p, " + roll + "r ]";
	}

	public Vec3d getRelativeVector(float x, float y, float z){
		float[] arr = VecUtil.rotate(new float[]{ x, y, z }, (float)roll * PI / 180f, (float)pitch * PI / 180f, (float)yaw * PI / 180f);
		return new Vec3d(arr[0], arr[1], arr[2]);
	}

	public Vec3d getRelativeVector(Vec3d vec){
		return getRelativeVector(vec, 0);
	}

	public Vec3d getRelativeVector(Vec3d vec, float yawmod){
		float[] arr = VecUtil.rotate(new float[]{ (float)vec.x, (float)vec.y, (float)vec.z }, (float)roll * PI / 180f, (float)pitch * PI / 180f, (float)(yaw + yawmod) * PI / 180f);
		return new Vec3d(arr[0], arr[1], arr[2]);
	}

	public Vec3f getRelativeVector(Vec3f relpos){
		return VecUtil.rotate(relpos, (float)roll * PI / 180f, (float)pitch * PI / 180f, (float)yaw * PI / 180f);
	}

	public static final double toRad(double d){
		return d * Math.PI / 180d;
	}

	public NBTTagCompound write(Entity ent, NBTTagCompound compound){
		if(ent != null){
			compound.setDouble("x", ent.posX);
			compound.setDouble("y", ent.posY);
			compound.setDouble("z", ent.posZ);
		}
		compound.setDouble("yaw", yaw);
		compound.setDouble("pitch", pitch);
		compound.setDouble("roll", roll);
		return compound;
	}

	public static Axis3D read(Entity ent, NBTTagCompound nbt){
		Axis3D axes = new Axis3D();
		axes.yaw = nbt.getDouble("yaw");
		axes.pitch = nbt.getDouble("pitch");
		axes.roll = nbt.getDouble("roll");
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

	public float getYaw(){
		return (float)yaw;
	}

	public float getRadianYaw(){
		return (float) (yaw * 3.14159265F / 180F);
	}

	public float getPitch(){
		return (float)pitch;
	}

	public double getRadianPitch(){
		return pitch * 3.14159265F / 180F;
	}

	public float getRoll(){
		return (float)roll;
	}

	public double getRadianRoll(){
		return roll * 3.14159265F / 180F;
	}

	public void copy(Axis3D axes){
		this.yaw = axes.yaw;
		this.roll = axes.roll;
		this.pitch = axes.pitch;
	}

	@Override
	public Axis3D clone(){
		Axis3D axes = new Axis3D();
		axes.yaw = yaw;
		axes.pitch = pitch;
		axes.roll = roll;
		return axes;
	}
	
	public void set_rotation(float y, float p, float r, boolean degrees){
		yaw = degrees ? toRad(y) : y;
		pitch = degrees ? toRad(p) : p;
		roll = degrees ? toRad(r) : r;
		convert();
	}

	public double[] toDoubles(){
		return new double[]{ yaw, pitch, roll };
	}

	public Vec3d toVec3d(){
		return new Vec3d(yaw, pitch, roll);
	}

	public void set_yaw(float f, boolean b){
		set_rotation(b ? toRad(f) : f, pitch, roll, false);
	}

	public void set_rotation(double d, double e, double f, boolean degrees){
		yaw = degrees ? toRad(d) : d;
		pitch = degrees ? toRad(e) : e;
		roll = degrees ? toRad(f) : f;
		convert();
	}

	private final void convert(){
		matrix = new Matrix4f();
		matrix.rotate((float)roll, new Vector3f(1F, 0F, 0F));
		matrix.rotate((float)pitch, new Vector3f(0F, 0F, 1F));
		matrix.rotate((float)yaw, new Vector3f(0F, 1F, 0F));
		yaw = (float)Math.atan2(matrix.m20, matrix.m00) * 180F / 3.14159265F;
		pitch = (float)Math.atan2(-matrix.m10, Math.sqrt(matrix.m12 * matrix.m12 + matrix.m11 * matrix.m11)) * 180F / 3.14159265F;
		roll = (float)Math.atan2(matrix.m12, matrix.m11) * 180F / 3.14159265F;
	}

}
