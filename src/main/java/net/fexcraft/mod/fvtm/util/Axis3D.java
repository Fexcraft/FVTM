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

	public Axis3D(Matrix4f mat){
		matrix = mat;
		convertMatrixToAngles();
	}

	public Axis3D(float yaw, float pitch, float roll){
		setAngles(yaw, pitch, roll);
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

	public double getRadianYaw(){
		return yaw * 3.14159265F / 180F;
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

	private final void convertMatrixToAngles(){
		yaw = (float)Math.atan2(matrix.m20, matrix.m00) * 180F / 3.14159265F;
		pitch = (float)Math.atan2(-matrix.m10, Math.sqrt(matrix.m12 * matrix.m12 + matrix.m11 * matrix.m11)) * 180F / 3.14159265F;
		roll = (float)Math.atan2(matrix.m12, matrix.m11) * 180F / 3.14159265F;
	}

	private final void convertToMatrix(boolean rad){
		matrix = new Matrix4f();
		matrix.rotate((float)(rad ? roll : roll * 3.14159265F / 180F), new Vector3f(1F, 0F, 0F));
		matrix.rotate((float)(rad ? pitch : pitch * 3.14159265F / 180F), new Vector3f(0F, 0F, 1F));
		matrix.rotate((float)(rad ? yaw : yaw * 3.14159265F / 180F), new Vector3f(0F, 1F, 0F));
		convertMatrixToAngles();
	}

	@Override
	public Axis3D clone(){
		return null;
	}

	public void setAngles(double yaw, double pitch, double roll){
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
		convertToMatrix(false);
	}

	public void setRotation(float yaw, float pitch, float roll){
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
		convertToMatrix(true);
	}

	public void setRotation(double yaw, double pitch, double roll){
		setRotation((float)yaw, (float)pitch, (float)roll);
	}

	public void setRotationYaw(double yaw){
		setRotation((float)yaw, getRadianPitch(), getRadianRoll());
	}

	public void setRotationPitch(double pitch){
		setRotation(getRadianYaw(), (float)pitch, getRadianRoll());
	}

	public double[] toDoubles(){
		return new double[]{ yaw, pitch, roll };
	}

	public Vec3d toVec3d(){
		return new Vec3d(yaw, pitch, roll);
	}

	public void set_yaw(float f, boolean b) {
		// TODO Auto-generated method stub
		
	}

}
