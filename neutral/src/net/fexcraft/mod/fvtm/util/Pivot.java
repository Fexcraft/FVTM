package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.lib.common.Static.PI;
import static net.fexcraft.lib.common.Static.toDegrees;
import static net.fexcraft.lib.common.Static.toRadians;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * 19.08.2021
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Pivot {
	
	private float ryaw;
	private float rpitch;
	private float rroll;
	private float dyaw;
	private float dpitch;
	private float droll;
	private Matrix matrix = new Matrix();
	
	public Pivot(){}
	
	@Override
	public String toString(){
		return "Pivot[ " + ryaw + "y, " + rpitch + "p, " + rroll + "r ]";
	}

	public V3D get_vector(V3D relpos){
		return VecUtil.rotate(relpos, rroll, rpitch, ryaw);
	}

	public V3D get_vector(double x, double y, double z){
		double[] d3 = VecUtil.rotate(new double[]{ x, y, z }, rroll, rpitch, ryaw);
		return new V3D(d3[0], d3[1], d3[2]);
	}

	public void save(TagCW tag){
		tag.set("yaw", ryaw);
		tag.set("pitch", rpitch);
		tag.set("roll", rroll);
	}

	public static Pivot load(TagCW tag){
		Pivot piv = new Pivot();
		piv.ryaw = tag.getFloat("yaw");
		piv.rpitch = tag.getFloat("pitch");
		piv.rroll = tag.getFloat("roll");
		piv.dyaw = toDegrees(piv.ryaw);
		piv.dpitch = toDegrees(piv.rpitch);
		piv.droll = toDegrees(piv.rroll);
		return piv;
	}

	public float yaw(){
		return ryaw;
	}

	public float deg_yaw(){
		return dyaw;
	}

	public float pitch(){
		return rpitch;
	}

	public float deg_pitch(){
		return dpitch;
	}

	public float roll(){
		return rroll;
	}

	public float deg_roll(){
		return droll;
	}

	public void copy(Pivot axe){
		ryaw = axe.ryaw;
		rroll = axe.rroll;
		rpitch = axe.rpitch;
		dyaw = axe.dyaw;
		dpitch = axe.dpitch;
		droll = axe.droll;
	}

	public Pivot copy(){
		Pivot piv = new Pivot();
		piv.ryaw = ryaw;
		piv.rpitch = rpitch;
		piv.rroll = rroll;
		piv.dyaw = dyaw;
		piv.dpitch = dpitch;
		piv.droll = droll;
		return piv;
	}
	
	public void set_yaw(float value, boolean degree){
		set_rotation(degree ? toRadians(value) : value, rpitch, rroll, false);
	}
	
	public void set_pitch(float value, boolean degree){
		set_rotation(ryaw, degree ? toRadians(value) : value, rroll, false);
	}
	
	public void set_roll(float value, boolean degree){
		set_rotation(ryaw, rpitch, degree ? toRadians(value) : value, false);
	}
	
	public void set_rotation(float y, float p, float r, boolean degrees){
		if(degrees){
			dyaw = y;
			dpitch = p;
			droll = r;
		}
		else{
			ryaw = y;
			rpitch = p;
			rroll = r;
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

	private void convert(boolean deg){
		matrix.reset();
		matrix.rotateX(deg ? toRadians(droll) : rroll, 1f);
		matrix.rotateZ(deg ? toRadians(dpitch) : rpitch, 1f);
		matrix.rotateY(deg ? toRadians(dyaw) : ryaw, 1f);
		dyaw = (ryaw = (float)Math.atan2(matrix.m2[0], matrix.m0[0])) * 180f / PI;
		dpitch = (rpitch = (float)Math.atan2(-matrix.m1[0], Math.sqrt(matrix.m1[2] * matrix.m1[2] + matrix.m1[1] * matrix.m1[1]))) * 180f / PI;
		droll = (rroll = (float)Math.atan2(matrix.m1[2], matrix.m1[1])) * 180f / PI;
	}

	public double[] toArray(){
		return new double[]{ dyaw, dpitch, droll };
	}

}
