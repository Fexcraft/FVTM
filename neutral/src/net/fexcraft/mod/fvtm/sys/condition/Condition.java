package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Condition {

	public final String id;
	public CondType type;
	public String target;
	public String condi;
	public CondMode mode;
	public String[] targets;
	
	public Condition(String id){
		this.id = id;
	}
	
	public Condition(String id, JsonMap map){
		this(id);
		type = CondType.parse(map.getString("type", CondType.CUSTOM.key));
		if(!map.has("target")){
			targets = new String[]{ target = "null" };
		}
		else if(map.get("target").isArray()){
			JsonArray arr = map.getArray("target");
			targets = new String[arr.size()];
			for(int i = 0; i < targets.length; i++){
				targets[i] = arr.get(i).string_value();
			}
			target = targets[0];
		}
		else{
			target = map.getString("target", "null");
			targets = new String[]{ target };
		}
		condi = map.has("con") ? map.getString("con", "null") : map.getString("condition", "null");
		mode = CondMode.parse(map.getString("mode", CondMode.EQUAL.key));
	}
	
	public Condition(String id, JsonArray array){
		this(id);
		type = CondType.parse(array.get(0).string_value());
		if(array.get(1).isArray()){
			JsonArray arr = array.getArray(1);
			targets = new String[arr.size()];
			for(int i = 0; i < targets.length; i++){
				targets[i] = arr.get(i).string_value();
			}
			target = targets[0];
		}
		else{
			target = array.get(1).string_value();
			targets = new String[]{ target };
		}
		mode = CondMode.parse(array.size() > 2 ? array.get(2).string_value() : "null");
		condi = array.size() > 3 ? array.get(3).string_value() : "null";
	}
	
	public String toCompare(){
		String tars = target;
		if(targets.length > 1){
			for(int i = 1; i < targets.length; i++){
				tars += "-" + targets[1];
			}
		}
		return type + ":" + tars + ":" + mode + ":" + condi;
	}

}
