package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;

public class Condition {
	
	public final String id;
	public String type, target, condi, mode;
	
	public Condition(String id){
		this.id = id;
	}
	
	public Condition(String id, JsonMap map){
		this(id);
		type = map.getString("type", "null");
		target = map.getString("target", "null");
		condi = map.has("con") ? map.getString("con", "null") : map.getString("condition", "null");
		mode = map.getString("mode", "equals");
	}
	
	public String toCompare(){
		return type + ":" + target + ":" + mode + ":" + condi;
	}
	
	public Conditional build(){
		return null;
	}
	
	@FunctionalInterface
	public static interface Conditional {
		
		boolean isMet(GenericVehicle ent, VehicleData vehdata, ContainerData condata, BlockData blkdata, PartData partdata, String part, TurboList list, RenderCache cache);
		
	}

}
