package net.fexcraft.mod.fvtm.util.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.block.BlockUtil;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.handler.TireInstallationHandler.TireData;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TireFunction extends Function {
	
	private static HashMap<Part, TireAttr> TIRES = new HashMap<>();
	private String inst_on;
	private WheelSlot wheel;

	public TireFunction(Part part, JsonObject obj){
		super(part, obj);
		TireAttr attr = new TireAttr();
		attr.general_grip = JsonUtil.getIfExists(obj, "general_grip", 1f).floatValue();
		attr.corner_stiffness = JsonUtil.getIfExists(obj, "stiffness", 5f).floatValue();
		attr.corner_stiffness_steering = JsonUtil.getIfExists(obj, "steering_stiffness", 5.2f).floatValue();
		if(obj.has("material_table")){
			JsonObject table = obj.get("material_table").getAsJsonObject();
			for(Map.Entry<String, JsonElement> entry : table.entrySet()){
				Material mat = BlockUtil.getMaterial(entry.getKey(), true);
				if(mat == null) continue;
				JsonArray array = entry.getValue().getAsJsonArray();
				float g = array.size() > 0 ? array.get(0).getAsFloat() : 1f;
				float r = array.size() > 1 ? array.get(1).getAsFloat() : 0.9f;
				float cs = array.size() > 2 ? array.get(2).getAsFloat() : attr.corner_stiffness;
				float css = array.size() > 3 ? array.get(3).getAsFloat() : attr.corner_stiffness_steering;
				attr.table.put(mat, new MatTireAttr(g, r, cs, css));
			}
		}
		TIRES.put(part, attr);
	}

	@Override
	public Function read(NBTTagCompound compound){
		inst_on = compound.hasKey("wheel_on") ? compound.getString("wheel_on") : null;
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(inst_on != null) compound.setString("wheel_on", inst_on);
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
	public Function copy(Part part){
		return new TireFunction(part, null);
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
    	TireData tiredata = data.getType().getInstallationHandlerData();
        tooltip.add(Formatter.format("&9Tire Outer Radius: &7" + tiredata.getOuterRadius()));
        tooltip.add(Formatter.format("&9Tire Inner Radius: &7" + tiredata.getInnerRadius()));
        tooltip.add(Formatter.format("&9Tire Width: &7" + tiredata.getWidth()));
    }
    
    public static class TireAttr {
    	
    	private HashMap<Material, MatTireAttr> table = new HashMap<>();
    	private float general_grip, corner_stiffness, corner_stiffness_steering;

        public float getGripFor(Material mat, boolean rainfall){
        	if(table.containsKey(mat)){
        		return rainfall ? table.get(mat).rainfall : table.get(mat).general;
        	}
    		return general_grip * (rainfall ? DEFAULT_TABLE.get(mat).rainfall : DEFAULT_TABLE.get(mat).general);
        }
        
        public float getCornerStiffnessFor(Material mat, boolean steering){
        	if(table.containsKey(mat)){
        		return steering ? table.get(mat).corner_stiffness_steering : table.get(mat).corner_stiffness;
        	}
    		return steering ? DEFAULT_TABLE.get(mat).corner_stiffness_steering : DEFAULT_TABLE.get(mat).corner_stiffness;
        }
        
    }
    
    public static class MatTireAttr {
    	
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
    	float dc = 5f, ds = 5.2f;
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

}
