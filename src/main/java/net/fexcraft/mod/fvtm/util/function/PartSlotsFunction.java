package net.fexcraft.mod.fvtm.util.function;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PartSlotsFunction extends StaticFunction {
	
	private PartSlots partslots;

	public PartSlotsFunction(Part part, JsonObject obj){
		super(part, obj);
		partslots = new PartSlots(part, JsonHandler.parse(obj.toString(), true).asMap());
	}

	@Override
	public String getId(){
		return "fvtm:part_slots";
	}
	
	public PartSlots getPartSlotss(){
		return partslots;
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Provides part slots:"));
    	for(String type : partslots.count.keySet()){
    		int c  = partslots.count.get(type);
            tooltip.add(Formatter.format("&7- " + type + (c > 0 ? " &ex" + c : "")));
    	}
    }

	public boolean copyRot(){
		return partslots.copy_rot;
	}
	
}
