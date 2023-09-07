package net.fexcraft.mod.fvtm.util.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.block.BlockUtil;
import net.fexcraft.mod.fvtm.data.part.Part2;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.util.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.block.material.Material;

public class TireFunction extends PartFunction {
	
	private static HashMap<Part2, TireAttr> TIRES = new HashMap<>();
	private String inst_on;
	private WheelSlot wheel;

	@Override
	public PartFunction init(Part2 part, FJson json){
		JsonMap map = json.isMap() ? json.asMap() : new JsonMap();
		TireAttr attr = new TireAttr();
		attr.general_grip = map.getFloat("general_grip", 1f);
		attr.brake_grip = map.getFloat("break_grip", 0.7f);
		attr.corner_stiffness = map.getFloat("stiffness", 5.2f);
		attr.corner_stiffness_steering = map.getFloat("steering_stiffness", 5f);
		attr.step_height = map.getFloat("step_height", 1f);
		if(map.has("material_table")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("material_table").entries()){
				Material mat = BlockUtil.getMaterial(entry.getKey(), true);
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
	
	public @Nullable WheelSlot getWheelPos(){
		return wheel;
	}
	
	public @Nullable WheelSlot getWheelPos(VehicleData vehicle){
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
	public PartFunction copy(Part2 part){
		return new TireFunction();
	}

    @Override
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
    	if(data.getType().getInstallationHandlerData() instanceof TireData){
        	TireData tiredata = data.getType().getInstallationHandlerData();
            tooltip.add(Formatter.format("&9Tire Outer Radius: &7" + tiredata.getOuterRadius()));
            tooltip.add(Formatter.format("&9Tire Inner Radius: &7" + tiredata.getInnerRadius()));
            tooltip.add(Formatter.format("&9Tire Width: &7" + tiredata.getWidth()));
    		return;
    	}
        tooltip.add(Formatter.format("&9Climb Height: &7" + TIRES.get(data.getType()).step_height));
    }
    
    public static class TireAttr {
    	
    	private HashMap<Material, MatTireAttr> table = new HashMap<>();
    	private float general_grip, corner_stiffness, corner_stiffness_steering;
    	public float brake_grip, step_height;

        public float getGripFor(Material mat, boolean rainfall){
        	if(table.containsKey(mat)){
        		return rainfall ? table.get(mat).rainfall : table.get(mat).general;
        	}
        	if(DEFAULT_TABLE.containsKey(mat)){
        		return general_grip * (rainfall ? DEFAULT_TABLE.get(mat).rainfall : DEFAULT_TABLE.get(mat).general);
        	}
    		return general_grip * (rainfall ? MatTireAttr.DEF_RAIN_GRIP : MatTireAttr.DEF_GRIP);
        }
        
        public float getCornerStiffnessFor(Material mat, boolean steering){
        	if(table.containsKey(mat)){
        		return steering ? table.get(mat).corner_stiffness_steering : table.get(mat).corner_stiffness;
        	}
        	if(DEFAULT_TABLE.containsKey(mat)){
        		return steering ? DEFAULT_TABLE.get(mat).corner_stiffness_steering : DEFAULT_TABLE.get(mat).corner_stiffness;
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
    
    private static HashMap<Material, MatTireAttr> DEFAULT_TABLE = new HashMap<>();
    static {
    	float dc = MatTireAttr.DEF_COR, ds = MatTireAttr.DEF_COR_STEER;
    	DEFAULT_TABLE.put(null, new MatTireAttr(MatTireAttr.DEF_GRIP, MatTireAttr.DEF_RAIN_GRIP, dc, ds));
    	DEFAULT_TABLE.put(Material.AIR, new MatTireAttr(0.1f, 0.1f, dc, ds));
    	DEFAULT_TABLE.put(Material.GRASS, new MatTireAttr(0.7f, 0.4f, dc, ds));
    	DEFAULT_TABLE.put(Material.GROUND, new MatTireAttr(0.9f, 0.75f, dc, ds));
    	DEFAULT_TABLE.put(Material.WOOD, new MatTireAttr(1.2f, 0.9f, dc, ds));
    	DEFAULT_TABLE.put(Material.ROCK, new MatTireAttr(1f, 0.9f, dc, ds));
    	DEFAULT_TABLE.put(Material.IRON, new MatTireAttr(1.2f, 0.9f, dc, ds));
    	DEFAULT_TABLE.put(Material.ANVIL, new MatTireAttr(1.5f, 1f, dc, ds));
    	DEFAULT_TABLE.put(Material.WATER, new MatTireAttr(0.1f, 0.1f, dc, ds));
    	DEFAULT_TABLE.put(Material.LAVA, new MatTireAttr(0.1f, 0.2f, dc, ds));
    	DEFAULT_TABLE.put(Material.LEAVES, new MatTireAttr(0.8f, 0.4f, dc, ds));
    	DEFAULT_TABLE.put(Material.PLANTS, new MatTireAttr(0.8f, 0.4f, dc, ds));
    	DEFAULT_TABLE.put(Material.VINE, new MatTireAttr(0.8f, 0.4f, dc, ds));
    	DEFAULT_TABLE.put(Material.SPONGE, new MatTireAttr(0.75f, 0.6f, dc, ds));
    	DEFAULT_TABLE.put(Material.CLOTH, new MatTireAttr(0.8f, 0.8f, dc, ds));
    	DEFAULT_TABLE.put(Material.FIRE, new MatTireAttr(1f, 1.2f, dc, ds));
    	DEFAULT_TABLE.put(Material.SAND, new MatTireAttr(0.5f, 0.2f, dc, ds));
    	DEFAULT_TABLE.put(Material.CIRCUITS, new MatTireAttr(1.25f, 1f, dc, ds));
    	DEFAULT_TABLE.put(Material.CARPET, new MatTireAttr(1.1f, 0.9f, dc, ds));
    	DEFAULT_TABLE.put(Material.GLASS, new MatTireAttr(1.1f, 0.8f, dc, ds));
    	DEFAULT_TABLE.put(Material.REDSTONE_LIGHT, new MatTireAttr(1f, 1f, dc, ds));
    	DEFAULT_TABLE.put(Material.TNT, new MatTireAttr(1.5f, 1.2f, dc, ds));
    	DEFAULT_TABLE.put(Material.CORAL, new MatTireAttr(0.5f, 0.5f, dc, ds));
    	DEFAULT_TABLE.put(Material.ICE, new MatTireAttr(0.3f, 0.2f, dc, ds));
    	DEFAULT_TABLE.put(Material.PACKED_ICE, new MatTireAttr(0.5f, 0.3f, dc, ds));
    	DEFAULT_TABLE.put(Material.SNOW, new MatTireAttr(0.75f, 0.5f, dc, ds));
    	DEFAULT_TABLE.put(Material.CRAFTED_SNOW, new MatTireAttr(1f, 0.8f, dc, ds));
    	DEFAULT_TABLE.put(Material.CACTUS, new MatTireAttr(0.7f, 0.9f, dc, ds));
    	DEFAULT_TABLE.put(Material.CLAY, new MatTireAttr(0.8f, 0.5f, dc, ds));
    	DEFAULT_TABLE.put(Material.GOURD, new MatTireAttr(0.7f, 0.4f, dc, ds));
    	DEFAULT_TABLE.put(Material.PORTAL, new MatTireAttr(2f, 2f, dc, ds));
    	DEFAULT_TABLE.put(Material.CAKE, new MatTireAttr(0.45f, 0.1f, dc, ds));
    	DEFAULT_TABLE.put(Material.WEB, new MatTireAttr(1f, 0.8f, dc, ds));
    	DEFAULT_TABLE.put(Material.PISTON, new MatTireAttr(1f, 0.9f, dc, ds));
    	DEFAULT_TABLE.put(Material.BARRIER, new MatTireAttr(1.2f, 1.1f, dc, ds));
    }
	public TireAttr getTireAttr(PartData part){
		return TIRES.get(part.getType());
	}

}
