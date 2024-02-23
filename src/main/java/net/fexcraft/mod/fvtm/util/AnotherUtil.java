package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.render.EffectRenderer;
import net.fexcraft.mod.uni.Pos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AnotherUtil {

	public static Vec3d toV3(Pos pos){
		if(pos == null) return new Vec3d(0, 0, 0);
		return new Vec3d(pos.x16, pos.y16, pos.z16);
	}

	public static void translateAndRotatePartOnSwivelPoint(VehicleData vehicle, PartData data, float ticks){
		SwivelPoint point = vehicle.getRotationPoint(data.getSwivelPointInstalledOn());
		V3D pos = data.getInstalledPos();
		V3D temp0 = point.getRelativeVector(pos);
		V3D temp1 = point.getPrevRelativeVector(pos);
		GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
		GL11.glTranslated(temp1.x + (temp0.x - temp1.x) * ticks, temp1.y + (temp0.y - temp1.y) * ticks, temp1.z + (temp0.z - temp1.z) * ticks);
		GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
		V3D rot = EffectRenderer.getRotations(point, ticks);
		GL11.glRotated(rot.z, 1.0F, 0.0F, 0.0F);
		GL11.glRotated(rot.y, 0.0F, 0.0F, 1.0F);
		GL11.glRotated(rot.x, 0.0F, 1.0F, 0.0F);
		data.getInstalledRot().rotate112();
	}

	public static void translateAndRotatePartOnSwivelPointFast(VehicleData vehicle, PartData data){
		SwivelPoint point = vehicle.getRotationPoint(data.getSwivelPointInstalledOn());
		V3D pos = point.getRelativeVector(data.getInstalledPos());
		GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
		GL11.glTranslated(pos.x, pos.y, pos.z);
		GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(point.getPivot().deg_roll(), 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(point.getPivot().deg_pitch(), 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(point.getPivot().deg_yaw(), 0.0F, 1.0F, 0.0F);
		data.getInstalledRot().rotate112();
	}

}
