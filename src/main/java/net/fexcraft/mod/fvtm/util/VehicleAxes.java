package net.fexcraft.mod.fvtm.util;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

public class VehicleAxes {
	
	public VehicleAxes(){
		matrix = new Matrix4f();
	}
	
	private double yaw, pitch, roll;
	private Matrix4f matrix;//TODO replace

	public Vec3d calcVector(Vec3d vec){
		Matrix4f mat = new Matrix4f();
		mat.m00 = (float)vec.x; mat.m10 = (float)vec.y; mat.m20 = (float)vec.z;
		mat.rotate((float)(roll * 3.14159265F / 180D), new Vector3f(1, 0, 0), mat, mat);
		mat.rotate((float)(pitch * 3.14159265F / 180D), new Vector3f(0, 0F, 1), mat, mat);
		mat.rotate((float)(yaw * 3.14159265F / 180D), new Vector3f(0, 1F, 0), mat, mat);
		return new Vec3d(mat.m00, mat.m10, mat.m20);
	}
	
	public void setRot(float yaw, float pitch, float roll){
		/*this.yaw = yaw;//Math.toRadians(yaw);
		this.pitch = pitch;//Math.toRadians(pitch);
		this.roll = roll;//Math.toRadians(roll);*/
		this.yaw = toRad(yaw);
		this.pitch = toRad(pitch);
		this.roll = toRad(roll);
		matrix = new Matrix4f();
		matrix.rotate((float)this.roll, new Vector3f(1F, 0F, 0F));
		matrix.rotate((float)this.pitch, new Vector3f(0F, 0F, 1F));
		matrix.rotate((float)this.yaw, new Vector3f(0F, 1F, 0F));
		this.yaw = (float)Math.atan2(matrix.m20, matrix.m00) * 180F / 3.14159265F;
		this.pitch = (float)Math.atan2(-matrix.m10, Math.sqrt(matrix.m12 * matrix.m12 + matrix.m11 * matrix.m11)) * 180F / 3.14159265F;
		this.roll = (float)Math.atan2(matrix.m12, matrix.m11) * 180F / 3.14159265F;
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

	public void read(Entity ent, NBTTagCompound nbt){
		yaw = nbt.getDouble("yaw");
		pitch = nbt.getDouble("pitch");
		roll = nbt.getDouble("roll");
		if(ent != null){
			ent.prevPosX = ent.posX;
			ent.prevPosY = ent.posY;
			ent.prevPosZ = ent.posZ;
			//ent.prevRotationPitch = ent.rotationPitch;
			//ent.prevRotationYaw = ent.rotationYaw;
			ent.posX = nbt.getDouble("x");
			ent.posY = nbt.getDouble("y");
			ent.posZ = nbt.getDouble("z");
			//ent.rotationYaw = this.getYaw();
			//ent.rotationPitch = this.getPitch();
		}
	}

	public float getYaw(){
		return (float)yaw;
	}

	public float getPitch(){
		return (float)pitch;
	}

	public float getRoll(){
		return (float)roll;
	}

	public void copy(VehicleAxes axes){
		this.yaw = axes.yaw;
		this.roll = axes.roll;
		this.pitch = axes.pitch;
	}
	
}