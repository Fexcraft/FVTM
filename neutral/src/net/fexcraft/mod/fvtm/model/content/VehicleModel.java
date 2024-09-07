package net.fexcraft.mod.fvtm.model.content;

import java.util.ArrayList;

import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.util.TransformMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleModel extends DefaultModel {

	public static final VehicleModel EMPTY = new VehicleModel();
	public final TransformMap item_scale = new TransformMap(0);
	public final TransformMap item_translate = new TransformMap(1);
	public final TransformMap item_rotate = new TransformMap(2);

	@Override
	public VehicleModel parse(ModelData data){
		super.parse(data);
		if(data.has("ItemScale")){
			JsonValue<?> val = data.get("ItemScale");
			if(val.isArray()){
				for(JsonValue<?> v : val.asArray().value){
					try{
						parseItemTransform(0, v.string_value());
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			else{
				try{
					item_scale.setAll(val.float_value());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.has("ItemTranslate")){
			ArrayList<String> list = data.getArray("ItemTranslate").toStringList();
			for(String str : list){
				try{
					parseItemTransform(1, str);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.has("ItemRotate")){
			ArrayList<String> list = data.getArray("ItemRotate").toStringList();
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

	private void parseItemTransform(int type, String str) throws Exception{
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
			String trype = split[1].toUpperCase();
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

}