package net.fexcraft.mod.fvtm.util.function;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;

public class ColorFunction extends StaticFunction {
	
	private TreeMap<String, RGB> colors = new TreeMap<>();

	public ColorFunction(Part part, JsonObject obj){
		super(part, obj);
		if(obj == null || !obj.has("colors")) return;
		JsonObject colors = obj.get("colors").getAsJsonObject();
		for(Entry<String, JsonElement> entry : colors.entrySet()){
			this.colors.put(entry.getKey(), new RGB(entry.getValue().getAsString()));
		}
	}

	@Override
	public String getId(){
		return "fvtm:color";
	}
	
	public TreeMap<String, RGB> getColors(){
		return colors;
	}

}
