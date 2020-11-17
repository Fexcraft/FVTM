package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFuntion;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TransmissionFunction extends StaticFuntion {
	
	private ArrayList<Float> ratios = new ArrayList<>();
	private boolean automatic;

	public TransmissionFunction(Part part, JsonObject obj){
		super(part, obj);
		JsonArray rats = obj.has("ratios") ? obj.get("ratios").getAsJsonArray() : null;
		if(rats == null){
			ratios.add(3f);
			ratios.add(2f);
			ratios.add(1f);
			ratios.add(0.5f);
		}
		else for(JsonElement elm : rats){
			ratios.add(elm.getAsFloat());
		}
		automatic = JsonUtil.getIfExists(obj, "automatic", false);
		Collections.sort(ratios);
	}

	@Override
	public String getId(){
		return "fvtm:transmission";
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Gears: &7" + ratios.size()));
        tooltip.add(Formatter.format("&9Range: &7" + ratios.get(0) + "-" + ratios.get(ratios.size() - 1)));
        tooltip.add(Formatter.format("&9Type: &7" + (automatic ? "automatic" : "manual")));
    }
    
    public ArrayList<Float> getRatios(){
    	return ratios;
    }
    
    public boolean isAutomatic(){
    	return automatic;
    }
    
    public boolean isManual(){
    	return !automatic;
    }
	
	public float getRatio(int gear){
		return ratios.get(gear);
	}

}
