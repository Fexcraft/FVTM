package net.fexcraft.mod.fvtm.model.vehicle;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.impl.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public abstract class VehicleBaseModel extends GenericModel<VehicleData, Object> implements FCLItemModel {

	public float gui_translate_x = 0;
	public float gui_translate_y = 0;
	public float gui_translate_z = 0;
	public float gui_scale_x = 0.125f;
	public float gui_scale_y = 0.125f;
	public float gui_scale_z = 0.125f;
	
	public VehicleBaseModel(){ super(); }
	
	public VehicleBaseModel(JsonObject obj){ super(obj); }
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof VehicleItem == false){ return; }
		VehicleData data = item.getCapability(VAPDataCache.CAPABILITY, null).getVehicleData();
		if(data == null){ return; }
		VehicleBaseModel model = (VehicleBaseModel)data.getVehicle().getModel();
		if(model == null) { return; }
		float[] scal = new float[]{ model.gui_scale_x, model.gui_scale_y, model.gui_scale_z };
		//
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
				GL11.glRotatef(90F, 0F, 1F, 0F);
				GL11.glTranslatef(0F, 0, 0F);
				GL11.glTranslatef(0, 0, 0);
				break;
			}
			case FIRST_PERSON_LEFT_HAND: {
				if(data.getVehicle().isTrailerOrWagon()){
					GL11.glTranslatef(0, 0, -0.5f);
				}
				GL11.glRotatef(60f, 0F, 1F, 0F);
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				if (data.getVehicle().isTrailerOrWagon()){
					GL11.glTranslatef(0, 0, -0.5f);
				}
				GL11.glRotatef(120f, 0F, 1F, 0F);
				break;
			}
			case GUI: {
				float f = data.getVehicle().isTrailerOrWagon() && !data.getVehicle().getType().isRailVehicle() ? -0.375f : 0;
				GL11.glTranslatef(model.gui_translate_x + f, model.gui_translate_y + f, model.gui_translate_z);
				GL11.glRotatef(-135, 0, 1, 0);
				GL11.glRotatef(-30, 1, 0, 0);
				GL11.glRotatef(-30, 0, 0, 1);
				break;
			}
			case HEAD: {
				// TODO
				break;
			}
			default: break;
		}
		GL11.glScalef(scal[0], scal[1], scal[2]);
		//
		{
			GL11.glPushMatrix();
			GL11.glRotated(180d, 1, 0, 0);
			bindTexture(data.getTexture());
			model.render(data, null, null, 0);
			data.getParts().forEach((key, partdata) -> {
				bindTexture(partdata.getTexture());
				partdata.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translate();
				partdata.getPart().getModel().render(data, key);
				partdata.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translateR();
			});
			GL11.glPopMatrix();
		}
		GL11.glScalef(-scal[0], -scal[1], -scal[2]);
		GL11.glPopMatrix();
	}

}