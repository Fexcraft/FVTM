package net.fexcraft.mod.fvtm.sys.condition;

import java.util.ArrayList;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.event.ConditionEvent;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
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
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeBoolean(target, false) == bool;
						};
					}
					case "n=":{
						Float val = Float.parseFloat(condi);
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeFloat(target, 0f) == val;
						};
					}
					case "!n=":{
						Float val = Float.parseFloat(condi);
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeFloat(target, 0f) != val;
						};
					}
					case "equal":
					case "=":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeString(target, "null").equals(condi);
						};
					}
					case "nequal":
					case "!=":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return !v.getAttributeString(target, "null").equals(condi);
						};
					}
					case "lequal":
					case "<=":{
						float val = Float.parseFloat(condi);
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeFloat(target, 0f) <= val;
						};
					}
					case "gequal":
					case ">=":{
						float val = Float.parseFloat(condi);
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeFloat(target, 0f) >= val;
						};
					}
					case "less":
					case "<":{
						float val = Float.parseFloat(condi);
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeFloat(target, 0f) < val;
						};
					}
					case "greater":
					case ">":{
						float val = Float.parseFloat(condi);
						return (e, t, v, c, b, p, s, tl, r) -> {
							return v.getAttributeFloat(target, 0f) > val;
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
						return (e, t, v, c, b, p, s, tl, r) -> {
							return t.getBlockMetadata() == meta;
						};
					}
					case "nequal":
					case "!=":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return t.getBlockMetadata() != meta;
						};
					}
					case "lequal":
					case "<=":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return t.getBlockMetadata() <= meta;
						};
					}
					case "gequal":
					case ">=":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return t.getBlockMetadata() >= meta;
						};
					}
					case "less":
					case "<":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return t.getBlockMetadata() < meta;
						};
					}
					case "greater":
					case ">":{
						return (e, t, v, c, b, p, s, tl, r) -> {
							return t.getBlockMetadata() > meta;
						};
					}
				}
				break;
			}
			case "part_function":
			case "part_func":
			case "partfunc":{
				return (e, t, v, c, b, p, s, tl, r) -> {
					PartData data = s.equals(target) ? p : v.getPart(target);
					Function func = data == null ? null : data.getFunction(targets[1]);
					return func == null ? false : func.onCondition(target, mode, condi);
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
				return (e, t, v, c, b, p, s, tl, r) -> {
					for(Conditional con : cons){
						if(con.isMet(e, t, v, c, b, p, s, tl, r)){
							if(m == 1) return true;
							else if(m == 2) return false;
						}
						else if(m == 0) return false;
					}
					return true;
				};
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
		
		boolean isMet(GenericVehicle ent, BlockTileEntity tile, VehicleData vehdata, ContainerData condata, BlockData blkdata, PartData partdata, String part, TurboList list, RenderCache cache);
		
	}

}
