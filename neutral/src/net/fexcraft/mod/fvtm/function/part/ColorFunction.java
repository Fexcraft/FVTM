package net.fexcraft.mod.fvtm.function.part;

import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ColorFunction extends StaticFunction {
	
	private TreeMap<String, RGB> colors = new TreeMap<>();

	@Override
	public PartFunction init(Part part, FJson json){
		if(!json.isMap()) return this;
		for(Entry<String, JsonValue<?>> entry : json.asMap().entries()){
			this.colors.put(entry.getKey(), new RGB(entry.getValue().string_value()));
		}
		return this;
	}

	@Override
	public String getId(){
		return "fvtm:color";
	}
	
	public TreeMap<String, RGB> getColors(){
		return colors;
	}

}
