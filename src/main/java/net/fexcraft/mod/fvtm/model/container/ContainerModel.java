package net.fexcraft.mod.fvtm.model.container;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.tmt.util.TMTItemModel;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ContainerModel<T extends ContainerData> extends Model<ContainerData> implements TMTItemModel {
	
	public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredSecondary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpen[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorClose[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpenColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorCloseColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo other[] = new ModelRendererTurbo[0];
	//
	public ArrayList<String> creators = new ArrayList<String>();
	
	
	private int tx, ty;
	public float gui_translate_x = 0;
	public float gui_translate_y = 0;
	public float gui_translate_z = 0;
	public float gui_scale_x = 0.125f;
	public float gui_scale_y = 0.125f;
	public float gui_scale_z = 0.125f;
	
	public ContainerModel(){}
	
	public ContainerModel(JsonObject obj){
		if(obj == null){
			return;
		}
		creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
		tx = obj.get("texture_size_x").getAsInt();
		ty = obj.get("texture_size_y").getAsInt();
		body = JsonToTMT.parse(this, "body", obj, tx, ty);
		bodyColoredPrimary = JsonToTMT.parse(this, "body_colored_primary", obj, tx, ty);
		bodyColoredSecondary= JsonToTMT.parse(this, "body_colored_secondary", obj, tx, ty);
		bodyDoorOpen = JsonToTMT.parse(this, "body_door_open", obj, tx, ty);
		bodyDoorClose = JsonToTMT.parse(this, "body_door_close", obj, tx, ty);
		bodyDoorOpenColoredPrimary = JsonToTMT.parse(this, "body_door_open_colored_primary", obj, tx, ty);
		bodyDoorCloseColoredPrimary = JsonToTMT.parse(this, "body_door_close_colored_primary", obj, tx, ty);
		other = JsonToTMT.parse(this, "body", obj, tx, ty);
	}
	
	@Override
	public void render(){
		//
	}
	
	/** From Block/TileEntity */
	public void render(ContainerData data){
		render(body);
		//
		if(PartModel.rq(bodyColoredPrimary, bodyDoorCloseColoredPrimary, bodyDoorOpenColoredPrimary)){
			data.getPrimaryColor().glColorApply();
			render(bodyColoredPrimary);
			render(/*data.doorsOpen() ? bodyDoorOpenColoredPrimary : */bodyDoorCloseColoredPrimary);
			RGB.glColorReset();
		}
		//
		if(PartModel.rq(bodyColoredSecondary)){
			data.getSecondaryColor().glColorApply();
			render(bodyColoredSecondary);
			RGB.glColorReset();
		}
		//
		render(other);
	}

	@Override
	public void render(ContainerData data, Entity ent){
		//
	}
	
	/** From Constructor */
	public void render(VehicleData vehdata, String part, ContainerData data, ContainerPosition pos){
		render(data);
	}
	
	/** From Entity/Vehicle */
	public void render(VehicleData vehdata, String part, ContainerData data, ContainerPosition pos, Entity vehicle){
		render(data);
	}
	
	public void rotate(ModelRendererTurbo[] part, float x, float y, float z, boolean mode){
		if(!mode){
			super.rotate(part, x, y, z);
		}
		else{
			for(ModelRendererTurbo model : part){
				model.rotateAngleX = x;
				model.rotateAngleY = y;
				model.rotateAngleZ = z;
			}
		}
	}


	@Override
	public void rotateAll(float x, float y, float z) {
		rotate(body, x, y, z);
	}

	public void translateAll(float x, float y, float z){
		translate(body, x, y, z);
	}
	
	public void flip(ModelRendererTurbo[] model){
		this.fixRotations(model);
	}

	public void flipAll(){
		flip(body);
	}

	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		ContainerData data = ((ContainerItem)item.getItem()).getContainer(item);
		if(data == null){ return; }
		ContainerModel<ContainerData> model = data.getContainer().getModel();
		if(model == null){ return; }
		float[] scal = new float[]{ model.gui_scale_x, model.gui_scale_y, model.gui_scale_z };
		//
		GL11.glPushMatrix();
		{
			switch(type){
				case GROUND:{
					GL11.glTranslatef(-0.45F, -0.05F, 0);
					break;
				}
				case FIXED:{
					//GL11.glRotatef(0, 0, 0, 0);
					break;
				}
				case THIRD_PERSON_RIGHT_HAND:
				case THIRD_PERSON_LEFT_HAND:{
					GL11.glRotatef(90F, 0F, 1F, 0F);
					GL11.glTranslatef(0F, 0/*-0.15F*/, 0F);
					GL11.glTranslatef(0, 0, 0);
					break;
				}
				case FIRST_PERSON_LEFT_HAND:{
					//GL11.glTranslatef(-1F, 0.675F, 0F);
					GL11.glRotatef( 60f, 0F, 1F, 0F);
					break;
				}
				case FIRST_PERSON_RIGHT_HAND:{
					//GL11.glTranslatef(-1F, 0.675F, 0f);
					GL11.glRotatef(120f, 0F, 1F, 0F);
					break;
				}
				case GUI:{
					GL11.glRotatef(-135, 0, 1, 0);
					GL11.glRotatef(-30, 1, 0, 0);
					GL11.glRotatef(-30, 0, 0, 1);
					//
					/*scal[0] = model.gui_scale_x;
					scal[1] = model.gui_scale_y;
					scal[2] = model.gui_scale_z;*/
					break;
				}
				case HEAD:{
					//GL11.glTranslatef(0, 8, 0);
					break;
				}
				default: break;
			}
			GL11.glScalef(scal[0], scal[1], scal[2]);
			//
			{
				GL11.glPushMatrix();
				GL11.glRotated(180d, 1, 0, 0);
				Model.bindTexture(data.getTexture());
				try{
					VehicleData vehdata = ((Vehicle)Resources.VEHICLES.getValues().toArray()[0]).getDataClass().getConstructor(Vehicle.class).newInstance((Vehicle)Resources.VEHICLES.getValues().toArray()[0]);
					data.getContainer().getModel().render(vehdata, "null", data, data.getContainer().getType() == ContainerType.LARGE ? ContainerPosition.LARGE_SINGLE : ContainerPosition.MEDIUM_SINGLE, entity);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				//
				GL11.glPopMatrix();
			}
			GL11.glScalef(-scal[0], -scal[1], -scal[2]);
		}
		GL11.glPopMatrix();
	}
	
}