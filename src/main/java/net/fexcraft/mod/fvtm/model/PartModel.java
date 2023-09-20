package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.util.TexUtil.bindTexture;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.render.EffectRenderer;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class PartModel extends DefaultModel implements FCLItemModel {

	public static final PartModel EMPTY = new PartModel();
    //public static final RGB windowcolor = new RGB(0x007208).setAlpha(0.3f);
	@Deprecated public static final String[] defval = new String[]{
		"body", "body_colored_primary", "body_colored_secondary", "body_door_open", "body_door_close",
		"body_door_open_colored_primary", "body_door_close_colored_primary", "turret", "steering",
		//
		"wheels", "wheel_front", "wheel_back",
		"wheel_front_left", "wheel_back_left", "wheel_front_right", "wheel_back_right", 
		//
		"track_wheels", "track_wheels_right", "track_wheels_left",
		//
		"lights", "front_lights", "back_lights", "reverse_lights",
		"fog_lights", "turn_signal_left", "turn_signal_right",
		//
		"windows", "windows_door_open", "windows_door_close"
	};
	@Deprecated public static final String[] defval_bogie = new String[]{ "chassis", "axle0", "axle1", "axle2", "axle3" };
	
	////-///---/---///-////
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof PartItem == false) return;
		PartData data = item.getCapability(Capabilities.VAPDATA, null).getPartData();
		if(data == null) return;
		PartModel model = (PartModel)data.getType().getModel();
		if(model == null) return;
		//
		GL11.glPushMatrix();
		switch(type){
			case GROUND: {
				GL11.glTranslatef(-0.45F, -0.05F, 0);
				break;
			}
			case FIXED: {
				WheelData ihdata = data.getType().getInstallHandlerData();
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glTranslatef(0, 0, ihdata.getWidth() * -.015625f);
				break;
			}
			case THIRD_PERSON_RIGHT_HAND:{
				GL11.glRotatef(90f, 0F, 1F, 0F);
				//GL11.glTranslatef(-(func.getWidth() * Static.sixteenth), -0.2f, 0);
				GL11.glScalef(.75f, .75f, .75f);
				break;
			}
			case THIRD_PERSON_LEFT_HAND: {
				GL11.glRotatef(-90f, 0F, 1F, 0F);
				//GL11.glTranslatef(-(func.getWidth() * Static.sixteenth), -0.2f, 0);
				GL11.glScalef(.75f, .75f, .75f);
				break;
			}
			case FIRST_PERSON_LEFT_HAND: {
				GL11.glRotatef(60f, 0F, 1F, 0F);
				GL11.glScalef(.5f, .5f, .5f);
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				GL11.glRotatef(-60f, 0F, 1F, 0F);
				GL11.glScalef(.5f, .5f, .5f);
				break;
			}
			case GUI: {
				WheelData ihdata = data.getType().getInstallHandlerData();
				if(ihdata.getRadius() > 8){
					for(int i = (int)ihdata.getRadius(); i > 8; i--)
					GL11.glScalef(1 - Static.sixteenth, 1 - Static.sixteenth, 1 - Static.sixteenth);
				}
				break;
			}
			case HEAD: {
				// TODO
				break;
			}
			default: break;
		}
		GL11.glPushMatrix();
		GL11.glRotatef(1, 0, 180, 0);
		model.transforms.apply();
		model.renderItem(item, data);
		model.transforms.deapply();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderItem(ItemStack item, PartData data){
		bindTexture(data.getCurrentTexture());
		for(ModelGroup list : groups) list.render();
	}

	public static void translateAndRotatePartOnSwivelPoint(VehicleData vehicle, PartData data, float ticks){
		SwivelPoint point = vehicle.getRotationPoint(data.getSwivelPointInstalledOn());
		V3D pos = data.getInstalledPos().toV3D();
		V3D temp0 = point.getRelativeVector(pos);
		V3D temp1 = point.getPrevRelativeVector(pos);
		GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
		GL11.glTranslated(temp1.x + (temp0.x - temp1.x) * ticks, temp1.y + (temp0.y - temp1.y) * ticks, temp1.z + (temp0.z - temp1.z) * ticks);
		GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
		Vec3f rot = EffectRenderer.getRotations(point, ticks);
		GL11.glRotatef(rot.z, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(rot.y, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(rot.x, 0.0F, 1.0F, 0.0F);
		data.getInstalledRot().rotate112();
	}

	public static void translateAndRotatePartOnSwivelPointFast(VehicleData vehicle, PartData data){
		SwivelPoint point = vehicle.getRotationPoint(data.getSwivelPointInstalledOn());
		V3D pos = point.getRelativeVector(data.getInstalledPos().toV3D());
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