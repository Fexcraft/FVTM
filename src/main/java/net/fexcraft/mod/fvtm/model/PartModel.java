package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

public class PartModel extends GenericModel<VehicleData, String> implements FCLItemModel {

	public static final PartModel EMPTY = new PartModel();
    //public static final RGB windowcolor = new RGB(0x007208).setAlpha(0.3f);
	public static final String[] defval = new String[]{
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
	public static final String[] defval_bogie = new String[]{ "chassis", "axle0", "axle1", "axle2", "axle3" };
	
	////-///---/---///-////
	
	public PartModel(){ super(); }
	
	public PartModel(JsonObject obj){ super(obj); }
	
	public PartModel(String type, ResourceLocation loc){ super(type, loc); }

	@Override
	public void render(VehicleData data, String key){
		for(TurboList list : groups){ list.render(null, data, data, key, null); }
	}

	@Override
	public void render(VehicleData data, String key, Entity ent, RenderCache cache){
		for(TurboList list : groups){ list.render(ent, data, data, key, cache); }
	}
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof PartItem == false){ return; }
		PartData data = item.getCapability(Capabilities.VAPDATA, null).getPartData(); if(data == null){ return; }
		PartModel model = (PartModel)data.getType().getModel(); if(model == null) { return; }
		//
		WheelData func = data.getType().getInstallationHandlerData();
		GL11.glPushMatrix();
		switch(type){
			case GROUND: {
				GL11.glTranslatef(-0.45F, -0.05F, 0);
				break;
			}
			case FIXED: {
				//
				break;
			}
			case THIRD_PERSON_RIGHT_HAND:
			case THIRD_PERSON_LEFT_HAND: {
				GL11.glRotatef(90f, 0F, 1F, 0F);
				GL11.glTranslatef(-(func.getWidth() * Static.sixteenth), -0.2f, 0);
				break;
			}
			case FIRST_PERSON_LEFT_HAND: {
				GL11.glRotatef(60f, 0F, 1F, 0F);
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				GL11.glRotatef(-60f, 0F, 1F, 0F);
				break;
			}
			case GUI: {
				if(func.getRadius() > 8){
					for(int i = (int)func.getRadius(); i > 8; i--)
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
		bindTexture(data.getTexture());
		GL11.glRotatef(1, 0, 180, 0);
		for(TurboList list : model.groups) list.renderPlain();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public static void translateAndRotatePartOnSwivelPoint(VehicleData vehicle, PartData data, float ticks){
		SwivelPoint point = vehicle.getRotationPoint(data.getSwivelPointInstalledOn());
		Vec3d pos = data.getInstalledPos().to16Double();
		Vec3d temp0 = point.getRelativeVector(pos, true);
		Vec3d temp1 = point.getPrevRelativeVector(pos, true);
		GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
        GL11.glTranslated(temp1.x + (temp0.x - temp1.x) * ticks, temp1.y + (temp0.y - temp1.y) * ticks, temp1.z + (temp0.z - temp1.z) * ticks);
		GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
	}

	public static void translateAndRotatePartOnSwivelPointFast(VehicleData vehicle, PartData data){
		SwivelPoint point = vehicle.getRotationPoint(data.getSwivelPointInstalledOn());
		Vec3d pos = point.getRelativeVector(data.getInstalledPos().to16Double(), true);
		GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
        GL11.glTranslated(pos.x, pos.y, pos.z);
		GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
	}
	
}