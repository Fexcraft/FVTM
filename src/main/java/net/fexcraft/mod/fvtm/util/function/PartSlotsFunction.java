package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFuntion;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PartSlotsFunction extends StaticFuntion {
	
	private ArrayList<String> slot_type = new ArrayList<>();
	private ArrayList<Pos> slot_pos = new ArrayList<>();
	private ArrayList<String> slot_cat = new ArrayList<>();

	public PartSlotsFunction(Part part, JsonObject obj){
		super(part, obj);
		JsonArray jslots = obj.get("slots").getAsJsonArray();
		for(int i = 0; i < jslots.size(); i++){
			JsonArray array = jslots.get(i).getAsJsonArray();
			slot_type.add(array.get(3).getAsString());
			slot_pos.add(Pos.fromJson(array, true));
			slot_cat.add(array.size() > 4 ? array.get(4).getAsString() : part.getCategory() + "_" + i);
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

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Provides part slots:"));
    	for(String type : slot_type){
            tooltip.add(Formatter.format("&7- " + type));
    	}
    }
	
}
