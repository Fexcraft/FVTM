package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.TransformMap;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class VehicleModel extends GenericModel<VehicleData, Object> implements FCLItemModel {
	
	public static final VehicleModel EMPTY = new VehicleModel();
	public static final String[] defval = new String[]{ "chassis", "body", "body_colored_primary", "body_colored_secondary",
		"body_door_open", "body_door_close", "body_door_open_colored_primary", "body_door_close_colored_primary",
		"turret", "steering", "wheels_import"
	};
	
	////-///---/---///-////
	
	public final TransformMap item_scale = new TransformMap(0);
	public final TransformMap item_translate = new TransformMap(1);
	public final TransformMap item_rotate = new TransformMap(2);
	
	public VehicleModel(){ super(); }
	
	public VehicleModel(JsonObject obj){ super(obj); }
	
	public VehicleModel(String type, ResourceLocation loc){ super(type, loc); }

	@Override
	public void render(VehicleData data, Object key){
		for(TurboList list : groups){ list.render(null, data, data, null, null); }
	}

	@Override
	public void render(VehicleData data, Object key, Entity ent, RenderCache cache){
		for(TurboList list : groups){ list.render(ent, data, data, null, cache); }
	}
	
	////-///---/---///-////
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof VehicleItem == false){ return; }
		VehicleData data = item.getCapability(Capabilities.VAPDATA, null).getVehicleData();
		if(data == null){ return; }
		VehicleModel model = (VehicleModel)data.getType().getModel();
		if(model == null) { return; }
		//
		Vec3f translate = model.item_translate.get(type);
		GL11.glTranslatef(translate.xCoord, translate.yCoord, translate.zCoord);
		if(data.getType().isTrailerOrWagon() && !data.getType().getVehicleType().isRailVehicle()){
			if(type == TransformType.GUI){
				GL11.glTranslatef(-.375f, -.375f, 0);
			}
			else if(type == TransformType.FIRST_PERSON_LEFT_HAND || type == TransformType.FIRST_PERSON_RIGHT_HAND){
				GL11.glTranslatef(0, 0, -0.5f);
			}
		}
		Vec3f rotate = model.item_rotate.get(type);
		GL11.glPushMatrix();
		GL11.glRotatef(rotate.yCoord, 0F, 1F, 0F);
		if(type == TransformType.THIRD_PERSON_RIGHT_HAND || type == TransformType.THIRD_PERSON_LEFT_HAND){
			GL11.glRotatef(data.getType().getVehicleType().isAirVehicle() ? -90f : 90f, 0F, 1F, 0F);
		}
		GL11.glRotatef(rotate.xCoord, 1F, 0F, 0F);
		GL11.glRotatef(rotate.zCoord, 0F, 0F, 1F);
		//
		//
		Vec3f scale = model.item_scale.get(type);
		GL11.glScalef(scale.xCoord, scale.yCoord, scale.zCoord);
		//
		{
			GL11.glPushMatrix();
			GL11.glRotated(180d, 1, 0, 0);
			bindTexture(data.getTexture());
			model.render(data, null, null, null);
			for(java.util.Map.Entry<String, PartData> entry : data.getParts().entrySet()){
				bindTexture(entry.getValue().getTexture());
            	if(entry.getValue().isInstalledOnSwivelPoint()){
            		GL11.glPushMatrix();
    	            PartModel.translateAndRotatePartOnSwivelPointFast(data, entry.getValue());
                    entry.getValue().getType().getModel().render(data, entry.getKey(), null, null);
    	            GL11.glPopMatrix();
            	}
            	else{
                	entry.getValue().getInstalledPos().translate();
                    entry.getValue().getType().getModel().render(data, entry.getKey(), null, null);
                    entry.getValue().getInstalledPos().translateR();
            	}
			}
			GL11.glPopMatrix();
		}
		//GL11.glScalef(-scale.xCoord, -scale.yCoord, -scale.zCoord);
		GL11.glPopMatrix();
	}

}