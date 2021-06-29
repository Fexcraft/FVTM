package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartSlotsFunction extends StaticFunction {
	
	private ArrayList<PartSlot> slots = new ArrayList<>();
	private boolean copy_rot;
	@SideOnly(Side.CLIENT)
	private HashMap<String, Integer> count;

	public PartSlotsFunction(Part part, JsonObject obj){
		super(part, obj);
		JsonArray jslots = obj.get("slots").getAsJsonArray();
		for(int i = 0; i < jslots.size(); i++){
			JsonArray array = jslots.get(i).getAsJsonArray();
			slots.add(new PartSlot(part.getCategory(), array, i));
		}
		copy_rot = obj.has("copy_rot") ? obj.get("copy_rot").getAsBoolean() : false;
		if(Static.side().isClient()){
			count = new HashMap<>();
			for(PartSlot slot : slots){
				if(count.containsKey(slot.type)) count.put(slot.type, count.get(slot.type) + 1);
				else count.put(slot.type, 1);
			}
		}
	}

	@Override
	public String getId(){
		return "fvtm:part_slots";
	}
	
	public ArrayList<PartSlot> getPartSlots(){
		return slots;
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Provides part slots:"));
    	for(String type : count.keySet()){
    		int c  = count.get(type);
            tooltip.add(Formatter.format("&7- " + type + (c > 0 ? " &ex" + c : "")));
    	}
    }

	public boolean copyRot(){
		return copy_rot;
	}
	
}
