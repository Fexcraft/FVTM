package net.fexcraft.mod.fvtm.function.part;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TireFunction extends PartFunction implements GetWheelPos{

	public static HashMap<Object, TireFunction.MatTireAttr> DEF_MAT_TIRE_ARR = new HashMap<>();
	private static HashMap<Part, TireAttr> TIRES = new HashMap<>();
	private String inst_on;
	private WheelSlot wheel;

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.isMap() ? json.asMap() : new JsonMap();
		TireAttr attr = new TireAttr();
		attr.general_grip = map.getFloat("general_grip", 1f);
		attr.brake_grip = map.getFloat("brake_grip", 0.7f);
		attr.corner_stiffness = map.getFloat("stiffness", 5.2f);
		attr.corner_stiffness_steering = map.getFloat("steering_stiffness", 5f);
		attr.step_height = map.getFloat("step_height", 1f);
		if(map.has("material_table")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("material_table").entries()){
				Object mat = FvtmResources.INSTANCE.getBlockMaterial(entry.getKey(), true);
				if(mat == null) continue;
				JsonArray array = entry.getValue().asArray();
				float g = array.size() > 0 ? array.get(0).float_value() : 1f;
				float r = array.size() > 1 ? array.get(1).float_value() : 0.9f;
				float cs = array.size() > 2 ? array.get(2).float_value() : attr.corner_stiffness;
				float css = array.size() > 3 ? array.get(3).float_value() : attr.corner_stiffness_steering;
				attr.table.put(mat, new MatTireAttr(g, r, cs, css));
			}
		}
		TIRES.put(part, attr);
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		inst_on = compound.has("wheel_on") ? compound.getString("wheel_on") : null;
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
		if(inst_on != null) compound.set("wheel_on", inst_on);
		return compound;
	}

	@Override
	public WheelSlot getWheelPos(VehicleData vehicle){
		if(wheel != null) return wheel;
		if(inst_on != null) return wheel = vehicle.getWheelSlots().get(inst_on);
		return null;
	}

	@Override
	public String getId(){
		return "fvtm:tire";
	}

	public void setWheel(String cat, WheelSlot slot){
		this.inst_on = cat; wheel = slot;
	}

	@Override
	public PartFunction copy(Part part){
		return new TireFunction();
	}

    @Override
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
    	if(data.getType().getInstallHandlerData() instanceof TireData){
        	TireData tiredata = data.getType().getInstallHandlerData();
            tooltip.add(Formatter.format("&9Tire Outer Radius: &7" + tiredata.getOuterRadius()));
            tooltip.add(Formatter.format("&9Tire Inner Radius: &7" + tiredata.getInnerRadius()));
            tooltip.add(Formatter.format("&9Tire Width: &7" + tiredata.getWidth()));
    		return;
    	}
        tooltip.add(Formatter.format("&9Climb Height: &7" + TIRES.get(data.getType()).step_height));
    }
    
    public static class TireAttr {
    	
    	private HashMap<Object, MatTireAttr> table = new HashMap<>();
    	private float general_grip, corner_stiffness, corner_stiffness_steering;
    	public float brake_grip, step_height;

        public float getGripFor(Object mat, boolean rainfall){
        	if(table.containsKey(mat)){
        		return rainfall ? table.get(mat).rainfall : table.get(mat).general;
        	}
        	if(DEF_MAT_TIRE_ARR.containsKey(mat)){
        		return general_grip * (rainfall ? DEF_MAT_TIRE_ARR.get(mat).rainfall : DEF_MAT_TIRE_ARR.get(mat).general);
        	}
    		return general_grip * (rainfall ? MatTireAttr.DEF_RAIN_GRIP : MatTireAttr.DEF_GRIP);
        }
        
        public float getCornerStiffnessFor(Object mat, boolean steering){
        	if(table.containsKey(mat)){
        		return steering ? table.get(mat).corner_stiffness_steering : table.get(mat).corner_stiffness;
        	}
        	if(DEF_MAT_TIRE_ARR.containsKey(mat)){
        		return steering ? DEF_MAT_TIRE_ARR.get(mat).corner_stiffness_steering : DEF_MAT_TIRE_ARR.get(mat).corner_stiffness;
        	}
    		return steering ? MatTireAttr.DEF_COR_STEER : MatTireAttr.DEF_COR;
        }
        
    }
    
    public static class MatTireAttr {
    	
    	public static final float DEF_GRIP = 1f, DEF_RAIN_GRIP = 0.75f, DEF_COR = 5.2f, DEF_COR_STEER = 5f;
    	
    	public final float general, rainfall, corner_stiffness, corner_stiffness_steering;

		public MatTireAttr(float g, float r, float cs, float css){
			general = g;
			rainfall = r;
			corner_stiffness = cs;
			corner_stiffness_steering = css;
		}
    	
    }

	public TireAttr getTireAttr(PartData part){
		return TIRES.get(part.getType());
	}

}
