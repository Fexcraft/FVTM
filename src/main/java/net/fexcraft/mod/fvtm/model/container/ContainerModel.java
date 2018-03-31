package net.fexcraft.mod.fvtm.model.container;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.JsonToTMT;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class ContainerModel<T extends ContainerData> extends Model<ContainerData> {
	
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
	
}