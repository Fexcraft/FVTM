package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.render.VehicleRenderer;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.TransformMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class VehicleModel extends GenericModel implements FCLItemModel {
	
	public static final VehicleModel EMPTY = new VehicleModel();
	@Deprecated public static final String[] defval = new String[]{ "chassis", "body", "body_colored_primary", "body_colored_secondary",
		"body_door_open", "body_door_close", "body_door_open_colored_primary", "body_door_close_colored_primary",
		"turret", "steering", "wheels_import"
	};
	
	////-///---/---///-////
	
	public final TransformMap item_scale = new TransformMap(0);
	public final TransformMap item_translate = new TransformMap(1);
	public final TransformMap item_rotate = new TransformMap(2);
	
	@Override
	public VehicleModel parse(ModelData data){
		super.parse(data);
		if(data.contains("ItemScale")){
			Object obj = data.get("ItemScale");
			if(obj instanceof ArrayList){
				ArrayList<String> list = (ArrayList<String>)obj;
				for(String str : list){
					try{
						parseItemTransform(0, str);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			else{
				try{
					item_scale.setAll(Float.parseFloat(obj.toString()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.contains("ItemTranslate")){
			ArrayList<String> list = data.get("ItemTranslate");
			for(String str : list){
				try{
					parseItemTransform(1, str);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.contains("ItemRotate")){
			ArrayList<String> list = data.get("ItemRotate");
			for(String str : list){
				try{
					parseItemTransform(2, str);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return this;
	}
	
	private void parseItemTransform(int type, String str) throws Exception {
		String[] split = str.split(" ");
		split[1] = split[1].toLowerCase();
		float[] val = new float[3];
		boolean set = split[0].toLowerCase().equals("set");
		if(split.length == 3){
			val[0] = val[1] = val[2] = Float.parseFloat(split[2]);
		}
		else{
			val[0] = Float.parseFloat(split[2]);
			val[1] = Float.parseFloat(split[3]);
			val[2] = Float.parseFloat(split[4]);
		}
		if(split[1].equals("all")){
			switch(type){
				case 0:
					if(set) item_scale.setAll(val[0], val[1], val[2]);
					else item_scale.addAll(val[0], val[1], val[2]);
					return;
				case 1:
					if(set) item_translate.setAll(val[0], val[1], val[2]);
					else item_translate.addAll(val[0], val[1], val[2]);
					return;
				case 2:
					if(set) item_rotate.setAll(val[0], val[1], val[2]);
					else item_rotate.addAll(val[0], val[1], val[2]);
					return;
			}
		}
		else{
			TransformType trype = null;
			switch(split[1]){
				case "none": trype = TransformType.NONE; break;
				case "third_person_left_hand": trype = TransformType.THIRD_PERSON_LEFT_HAND; break;
				case "third_person_right_hand": trype = TransformType.THIRD_PERSON_RIGHT_HAND; break;
				case "first_person_left_hand": trype = TransformType.FIRST_PERSON_LEFT_HAND; break;
				case "first_person_right_hand": trype = TransformType.THIRD_PERSON_RIGHT_HAND; break;
				case "head": trype = TransformType.HEAD; break;
				case "gui": trype = TransformType.GUI; break;
				case "ground": trype = TransformType.GROUND; break;
				case "fixed": trype = TransformType.FIXED; break;
			}
			switch(type){
				case 0:
					if(set) item_scale.set(trype, val[0], val[1], val[2]);
					else item_scale.add(trype, val[0], val[1], val[2]);
					return;
				case 1:
					if(set) item_translate.set(trype, val[0], val[1], val[2]);
					else item_translate.add(trype, val[0], val[1], val[2]);
					return;
				case 2:
					if(set) item_rotate.set(trype, val[0], val[1], val[2]);
					else item_rotate.add(trype, val[0], val[1], val[2]);
					return;
			}
		}
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
		GL11.glTranslatef(translate.x, translate.y, translate.z);
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
		GL11.glRotatef(rotate.y, 0F, 1F, 0F);
		if(type == TransformType.THIRD_PERSON_RIGHT_HAND || type == TransformType.THIRD_PERSON_LEFT_HAND){
			GL11.glRotatef(data.getType().getVehicleType().isAirVehicle() ? -90f : 90f, 0F, 1F, 0F);
		}
		GL11.glRotatef(rotate.x, 1F, 0F, 0F);
		GL11.glRotatef(rotate.z, 0F, 0F, 1F);
		//
		//
		Vec3f scale = model.item_scale.get(type);
		GL11.glScalef(scale.x, scale.y, scale.z);
		//
		{
			GL11.glPushMatrix();
			Model modVehicle = data.getType().getModel();
			if(modVehicle != null){
				GL11.glPushMatrix();
				GL11.glRotatef(180f, 0f, 0f, 1f);
				TexUtil.bindTexture(data.getCurrentTexture());
				modVehicle.render(RENDERDATA.set(data, null, null, false));
				GL11.glPopMatrix();
			}
			else {
				TexUtil.bindTexture(data.getCurrentTexture());
				DebugModels.CENTERSPHERE.render(1);
			}
			if(data.getParts().size() > 0){
				VehicleRenderer.renderPoint(data.getRotationPoint("vehicle"), null, data, null, Minecraft.getMinecraft().getRenderPartialTicks());
			}
			GL11.glPopMatrix();
		}
		//GL11.glScalef(-scale.xCoord, -scale.yCoord, -scale.zCoord);
		GL11.glPopMatrix();
	}

	public void sortparts(VehicleData data){
		data.sorted_parts.clear();
		for(String str : data.getRotationPoints().keySet()) data.sorted_parts.put(str, new ArrayList<>());
		for(Entry<String, PartData> part : data.getParts().entrySet()){
			if(part.getValue().isInstalledOnSwivelPoint()){
				data.sorted_parts.get(part.getValue().getSwivelPointInstalledOn()).add(part);
			}
			else data.sorted_parts.get("vehicle").add(part);
		}
	}

}