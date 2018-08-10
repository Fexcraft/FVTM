package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.lib.fmr.ModelCompound;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public abstract class GenericModel<T, K> extends ModelBase implements Model<T, K> {
	
	protected int textureX, textureY;
	protected ModelMap<ModelRendererTurbo[]> submodels = new ModelMap<ModelRendererTurbo[]>(false);
	protected ModelMap<ModelCompound> fmrmodels = new ModelMap<ModelCompound>(true);
	private ArrayList<String> creators = new ArrayList<>();
	
	public GenericModel(){}
	
	/*public final void importSubModels(){
		searchFields(this.getClass().getDeclaredFields());
		Class<?> clazz = null;
		while((clazz = clazz == null ? this.getClass().getSuperclass() : clazz.getSuperclass()) != GenericModel.class){
			searchFields(clazz.getDeclaredFields());
		}
	}
	
	private void searchFields(Field[] fields){
		for(Field field : fields){
			if(field.getType().getSimpleName().equals("ModelRendererTurbo[]") && field.getType().isArray()){
				try{
					boolean access = field.isAccessible();
					if(!access){ field.setAccessible(!access); }
					submodels.put(field.getName(), (ModelRendererTurbo[])field.get(this));
					if(!access){ field.setAccessible( access); }
					//Print.debug(field.getName(), submodels.get(field.getName()).length);
				}
				catch(IllegalArgumentException | IllegalAccessException e){
					e.printStackTrace();
					Static.stop();
				}
			}
		}
	}*/

	public GenericModel(JsonObject obj){
		this(); if(obj == null){ return; }
        creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
        textureX = obj.get("texture_size_x").getAsInt();
        textureY = obj.get("texture_size_y").getAsInt();
        JsonObject modelobj = obj.get("model").getAsJsonObject();
        for(Entry<String, JsonElement> entry : modelobj.entrySet()){
        	submodels.put(entry.getKey(), JsonToTMT.parse(this, entry.getValue().getAsJsonArray(), textureX, textureY));
        }
	}
	
	@Override
	public final java.util.Collection<String> getCreators(){
		return creators;
	}
	
	public boolean addToCreators(String str){
		return creators.add(str);
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
		if(fmrmodels != null){
			fmrmodels.values().forEach(elm -> {
				elm.translate(x, y, z);
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
		if(fmrmodels != null){
			fmrmodels.values().forEach(elm -> {
				elm.rotate(x, y, z);
			});
		}
	}
	
	/** legacy method **/
	@Override
	public void flipAll(){
		
	}
	
}