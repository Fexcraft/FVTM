package net.fexcraft.mod.fvtm.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map.Entry;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public abstract class GenericModel<T, K> extends ModelBase implements Model<T, K> {
	
	protected int textureX, textureY;
	protected ModelMap submodels = new ModelMap();
	private ArrayList<String> creators = new ArrayList<>();
	
	public GenericModel(){
		//import declared fields
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			if(field.getType() == ModelRendererTurbo.class && field.getType().isArray()){
				try{
					boolean access = field.isAccessible();
					if(!access){ field.setAccessible(!access); }
					submodels.put(field.getName(), (ModelRendererTurbo[])field.get(this));
					if(!access){ field.setAccessible( access); }
				}
				catch(IllegalArgumentException | IllegalAccessException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public GenericModel(JsonObject obj){
		this(); if(obj == null){ return; }
        creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
        textureX = obj.get("texture_size_x").getAsInt();
        textureY = obj.get("texture_size_y").getAsInt();
        JsonObject modelobj = obj.get("model").getAsJsonObject();
        for(Entry<String, JsonElement> entry : modelobj.entrySet()){
        	submodels.put(entry.getKey(), JsonToTMT.parse(this, entry.getKey(), entry.getValue().getAsJsonObject(), textureX, textureY));
        }
	}
	
	@Override
	public final java.util.Collection<String> getCreators(){
		return creators;
	}

	@Override
	public void render(){
		if(submodels != null){
			submodels.values().forEach(sub -> { render(sub); });
		}
	}

	@Override
	public void translateAll(float x, float y, float z){
		if(submodels != null){
			submodels.values().forEach(sub -> {
				translate(sub, x, y, z);
			});
		}
	}

	@Override
	public void rotateAll(float x, float y, float z){
		if(submodels != null){
			submodels.values().forEach(sub -> {
				rotate(sub, x, y, z);
			});
		}
	}
	
	/** legacy method **/
	@Override
	public void flipAll(){
		
	}
	
}