package net.fexcraft.mod.fvtm.model.container;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.lib.tmt.JsonToTMT;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.Entity;

public class ContainerModel<T extends ContainerData> extends Model<ContainerData> {
	
	public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
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
	}
	
	@Override
	public void render(){
		//cannot render without providing vehicledata;
	}

	@Override
	public void render(ContainerData type, Entity ent){
		//render(type, ContainerPosition.MEDIUM_SINGLE, ent);
	}

	public void render(VehicleData vehdata, String part, ContainerData data, ContainerPosition pos){
		render(body);
		
	}
	
	public void render(VehicleData vehdata, String part, ContainerData data, ContainerPosition pos, Entity vehicle){
		render(body);
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