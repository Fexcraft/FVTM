package net.fexcraft.mod.fvtm.sys.condition;

import java.util.ArrayList;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelRenderData;
import net.fexcraft.mod.fvtm.event.ConditionEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class Condition {
	
	public final String id;
	public String type, target, condi, mode;
	public String[] targets;
	
	public Condition(String id){
		this.id = id;
	}
	
	public Condition(String id, JsonMap map){
		this(id);
		type = map.getString("type", "null");
		if(map.has("target")){
			if(map.get("target").isArray()){
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
		}
		else{
			target = "null";
			targets = new String[]{ target };
		}
		condi = map.has("con") ? map.getString("con", "null") : map.getString("condition", "null");
		mode = map.getString("mode", "equal");
	}
	
	public Condition(String id, JsonArray array){
		this(id);
		type = array.get(0).string_value();
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
		mode = array.size() > 2 ? array.get(2).string_value() : "null";
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
	
	public Conditional build(){
		switch(type){
			case "attribute":{
				switch(mode){
					case "bequal":
					case "b=":{
						boolean bool = Boolean.parseBoolean(condi);
						return data -> {
							return data.vehicle.getAttributeBoolean(target, false) == bool;
						};
					}
					case "n=":{
						Float val = Float.parseFloat(condi);
						return data -> {
							return data.vehicle.getAttributeFloat(target, 0f) == val;
						};
					}
					case "!n=":{
						Float val = Float.parseFloat(condi);
						return data -> {
							return data.vehicle.getAttributeFloat(target, 0f) != val;
						};
					}
					case "equal":
					case "=":{
						return data -> {
							return data.vehicle.getAttributeString(target, "null").equals(condi);
						};
					}
					case "nequal":
					case "!=":{
						return data -> {
							return !data.vehicle.getAttributeString(target, "null").equals(condi);
						};
					}
					case "lequal":
					case "<=":{
						float val = Float.parseFloat(condi);
						return data -> {
							return data.vehicle.getAttributeFloat(target, 0f) <= val;
						};
					}
					case "gequal":
					case ">=":{
						float val = Float.parseFloat(condi);
						return data -> {
							return data.vehicle.getAttributeFloat(target, 0f) >= val;
						};
					}
					case "less":
					case "<":{
						float val = Float.parseFloat(condi);
						return data -> {
							return data.vehicle.getAttributeFloat(target, 0f) < val;
						};
					}
					case "greater":
					case ">":{
						float val = Float.parseFloat(condi);
						return data -> {
							return data.vehicle.getAttributeFloat(target, 0f) > val;
						};
					}
				}
				break;
			}
			case "metadata":{
				int meta = Integer.parseInt(condi);
				switch(mode){
					case "equal":
					case "=":{
						return data -> {
							return data.tile.getBlockMetadata() == meta;
						};
					}
					case "nequal":
					case "!=":{
						return data -> {
							return data.tile.getBlockMetadata() != meta;
						};
					}
					case "lequal":
					case "<=":{
						return data -> {
							return data.tile.getBlockMetadata() <= meta;
						};
					}
					case "gequal":
					case ">=":{
						return data -> {
							return data.tile.getBlockMetadata() >= meta;
						};
					}
					case "less":
					case "<":{
						return data -> {
							return data.tile.getBlockMetadata() < meta;
						};
					}
					case "greater":
					case ">":{
						return data -> {
							return data.tile.getBlockMetadata() > meta;
						};
					}
				}
				break;
			}
			case "part_function":
			case "part_func":
			case "partfunc":{
				return mrdata -> {
					PartData data = mrdata.part_category.equals(target) ? mrdata.part : mrdata.vehicle.getPart(target);
					Function func = data == null ? null : data.getFunction(targets[1]);
					return func == null ? false : func.onCondition(targets, mode, condi);
				};
			}
			case "multiple":
			case "multi":
			case "group":{
				int m = mode.equals("any") ? 1 : mode.equals("none") ? 2 : 0;
				ArrayList<Conditional> cons = new ArrayList<>();
				for(String str : targets){
					Conditional con = ConditionRegistry.get(str);
					if(con != null) cons.add(con);
				}
				return data -> {
					for(Conditional con : cons){
						if(con.isMet(data)){
							if(m == 1) return true;
							else if(m == 2) return false;
						}
						else if(m == 0) return false;
					}
					return true;
				};
			}
			case "world_time":{
				int value = Integer.parseInt(condi);
				switch(mode){
					case "equal":
					case "=":{
						return data -> {
							World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
							return world == null ? false : world.getWorldTime() == value;
						};
					}
					case "nequal":
					case "!=":{
						return data -> {
							World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
							return world == null ? false : world.getWorldTime() != value;
						};
					}
					case "lequal":
					case "<=":{
						return data -> {
							World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
							return world == null ? false : world.getWorldTime() <= value;
						};
					}
					case "gequal":
					case ">=":{
						return data -> {
							World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
							return world == null ? false : world.getWorldTime() >= value;
						};
					}
					case "less":
					case "<":{
						return data -> {
							World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
							return world == null ? false : world.getWorldTime() < value;
						};
					}
					case "greater":
					case ">":{
						return data -> {
							World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
							return world == null ? false : world.getWorldTime() > value;
						};
					}
				}
				break;
			}
			default:{
				ConditionEvent.ConditionalCreate event = new ConditionEvent.ConditionalCreate(this);
				MinecraftForge.EVENT_BUS.post(event);
				return event.getConditional();
			}
		}
		return null;
	}

	@FunctionalInterface
	public static interface Conditional {
		
		boolean isMet(ModelRenderData data);
		
	}

}
