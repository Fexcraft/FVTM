package net.fexcraft.mod.addons.gep.attributes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class FMSeatAttribute implements Attribute {

    private static final ResourceLocation regname = new ResourceLocation("seat");
    private FMSeat[] seats;

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
        JsonArray array = obj.has("FM-Seats") ? obj.get("FM-Seats").getAsJsonArray() : new JsonArray();
        seats = new FMSeat[array.size()];
        for(int i = 0; i < seats.length; i++){
            seats[i] = new FMSeat(array.get(i).getAsJsonObject());
        }
    }

    @Override
    public String getName(){
        return "FM Seat";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
        tooltip.add(Formatter.format("&9Seats: &7" + seats.length));
    }

    public Collection<FMSeat> getSeats(){
        return Arrays.asList(seats);
    }

    @Override
    public boolean hasDataClass(){
        return false;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return null;
    }

	@Override
	public boolean hasRenderData(){
		return false;
	}

}
