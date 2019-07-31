package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RoadSign;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entity.RoadSignEntity;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RoadSignModel extends GenericModel<RoadSignEntity, RoadSign> implements FCLItemModel {

	public static final RoadSignModel EMPTY = new RoadSignModel();
	
	////-///---/---///-////
	
	public RoadSignModel(){ super(); }
	
	public RoadSignModel(JsonObject obj){ super(obj); }
	
	public RoadSignModel(String type, ResourceLocation loc){ super(type, loc); }

	@Override
	public void render(RoadSignEntity data, RoadSign key){
		for(TurboList list : groups){ list.renderPlain(); }
	}

	@Override
	public void render(RoadSignEntity data, RoadSign key, Entity ent, int meta){
		for(TurboList list : groups){ list.renderPlain(); }
	}
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof VehicleItem == false){ return; }
		VehicleData data = item.getCapability(Capabilities.VAPDATA, null).getVehicleData();
		if(data == null){ return; }
		VehicleModel model = (VehicleModel)data.getType().getModel();
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
				GL11.glRotatef(data.getType().getVehicleType().isAirVehicle() ? -90f : 90f, 0F, 1F, 0F);
				GL11.glTranslatef(0F, 0, 0F);
				GL11.glTranslatef(0, 0, 0);
				break;
			}
			case FIRST_PERSON_LEFT_HAND: {
				if(data.getType().isTrailerOrWagon()){
					GL11.glTranslatef(0, 0, -0.5f);
				}
				GL11.glRotatef(60f, 0F, 1F, 0F);
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				if (data.getType().isTrailerOrWagon()){
					GL11.glTranslatef(0, 0, -0.5f);
				}
				GL11.glRotatef(120f, 0F, 1F, 0F);
				break;
			}
			case GUI: {
				float f = data.getType().isTrailerOrWagon() && !data.getType().getVehicleType().isRailVehicle() ? -0.375f : 0;
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
			for(java.util.Map.Entry<String, PartData> entry : data.getParts().entrySet()){
				bindTexture(entry.getValue().getTexture());
            	entry.getValue().getInstalledPos().translate();
                entry.getValue().getType().getModel().render(data, entry.getKey(), null, -1);
                entry.getValue().getInstalledPos().translateR();
			}
			GL11.glPopMatrix();
		}
		GL11.glScalef(-scal[0], -scal[1], -scal[2]);
		GL11.glPopMatrix();
	}
	
}