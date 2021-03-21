package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartSlotsFunction extends StaticFunction {
	
	private ArrayList<String> slot_type = new ArrayList<>();
	private ArrayList<Pos> slot_pos = new ArrayList<>();
	private ArrayList<String> slot_cat = new ArrayList<>();
	private ArrayList<Float> slot_rad = new ArrayList<>();
	@SideOnly(Side.CLIENT)
	private HashMap<String, Integer> count = new HashMap<>();

	public PartSlotsFunction(Part part, JsonObject obj){
		super(part, obj);
		JsonArray jslots = obj.get("slots").getAsJsonArray();
		for(int i = 0; i < jslots.size(); i++){
			JsonArray array = jslots.get(i).getAsJsonArray();
			slot_type.add(array.get(3).getAsString());
			slot_pos.add(Pos.fromJson(array, true));
			slot_cat.add(array.size() > 4 ? array.get(4).getAsString() : part.getCategory() + "_" + i);
			slot_rad.add(array.size() > 5 ? array.get(5).getAsInt() * Static.sixteenth : 0.25f);
		}
		if(Static.side().isClient()){
			for(String slot : slot_type){
				if(count.containsKey(slot)) count.put(slot, count.get(slot) + 1);
				else count.put(slot, 1);
			}
		}
	}

	@Override
	public String getId(){
		return "fvtm:part_slots";
	}
	
	public ArrayList<String> getSlotTypes(){
		return slot_type;
	}
	
	public ArrayList<Pos> getSlotPositions(){
		return slot_pos;
	}
	
	public ArrayList<String> getSlotCategories(){
		return slot_cat;
	}
	
	public ArrayList<Float> getSlotRadius(){
		return slot_rad;
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Provides part slots:"));
    	for(String type : count.keySet()){
    		int c  = count.get(type);
            tooltip.add(Formatter.format("&7- " + type + (c > 0 ? " &ex" + c : "")));
    	}
    }
	
}
