package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.lib.common.Static.PI;
import static net.fexcraft.lib.common.Static.toDegrees;
import static net.fexcraft.lib.common.Static.toRadians;

import net.fexcraft.lib.common.math.Vec3f;
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
	
	//radians
	private float yaw, pitch, roll;
	private float dyaw, dpitch, droll;
	
	public Axes(){}
	
	public Axes(Axes axes){
		this.yaw = axes.yaw;
		this.pitch = axes.pitch;
		this.roll = axes.roll;
	}
	
	public Axes(float y, float p, float r){
		yaw = y;
		pitch = p;
		roll = r;
	}
	
	@Override
	public String toString(){
		return "Axes[ " + yaw + "y, " + pitch + "p, " + roll + "r ]";
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
		this.yaw = axe.yaw;
		this.roll = axe.roll;
		this.pitch = axe.pitch;
	}

	@Override
	public Axes clone(){
		Axes axes = new Axes();
		axes.yaw = yaw;
		axes.pitch = pitch;
		axes.roll = roll;
		return axes;
	}
	
	public void set_yaw(float value, boolean degree){
		if(degree) yaw = toRadians(dyaw = value);
		else dyaw = toDegrees(yaw = value);
	}
	
	public void set_pitch(float value, boolean degree){
		if(degree) pitch = toRadians(dpitch = value);
		else dpitch = toDegrees(pitch = value);
	}
	
	public void set_roll(float value, boolean degree){
		if(degree) roll = toRadians(droll = value);
		else droll = toDegrees(roll = value);
	}
	
	public void set_rotation(float y, float p, float r, boolean degrees){
		set_yaw(y, degrees);
		set_pitch(p, degrees);
		set_roll(r, degrees);
	}
	
	public void set_rot(float y, float p, float r, boolean degrees){
		set_rotation(y, p, r, degrees);
	}
	
	public void set_rotation(double y, double p, double r, boolean degrees){
		set_yaw((float)y, degrees);
		set_pitch((float)p, degrees);
		set_roll((float)r, degrees);
	}
	
	public void set_rot(double y, double p, double r, boolean degrees){
		set_rotation(y, p, r, degrees);
	}

}
