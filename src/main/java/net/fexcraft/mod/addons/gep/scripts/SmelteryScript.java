package net.fexcraft.mod.addons.gep.scripts;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.util.script.DefaultCraftBlockScript;
import net.minecraft.nbt.NBTTagCompound;

public class SmelteryScript extends DefaultCraftBlockScript {
	
	private static int heatincr;
	private int heat;
	private boolean open;

	public SmelteryScript(JsonObject obj){
		super(obj);
		heatincr = obj.has("heat_per_tick") ? obj.get("heat_per_tick").getAsInt() : 10;
	}

	@Override
	public void read(MultiBlockData data, NBTTagCompound tag){
		super.read(data, tag);
		heat = tag.hasKey("smeltery_heat") ? tag.getInteger("smeltery_heat") : 0;
		open = tag.hasKey("smeltery_open") ? tag.getBoolean("smeltery_open") : false;
	}

	@Override
	public NBTTagCompound write(MultiBlockData data, NBTTagCompound compound){
		super.write(data, compound);
		compound.setInteger("smeltery_heat", heat);
		compound.setBoolean("smeltery_open", open);
		return compound;
	}
	
	@Override
	public boolean ready(TickableTE tile){
		return heat > 1000;
	}
	
	@Override
	public void prepare(TickableTE tile){
		int heatby = open ? heatincr * 2 : heatincr;
		if(tile.getMultiBlockData().getFluidTank("tank").getFluidAmount() < heatby) return;
		heat += heatby;
		tile.getMultiBlockData().getFluidTank("tank").drain(heatby, true);
	}
	
	@Override
	public void running(TickableTE tile){
		int coolby = open ? 2 : 1;
		if(isCoolingDown()) coolby /= 2;
		if(coolby <= 0) return;
		heat -= coolby;
	}
	
	@Override
	public int process_speed(){
		return open ? process_speed * 2 : process_speed;
	}
	
	@Override
	public int process_time(){
		return open ? process_time / 2 : process_time;
	}
	
	@Override
	public int cooldown_speed(){
		return open ? cooldown_speed * 2 : cooldown_speed;
	}
	
	public boolean consume(String value, int amount, boolean simulate){
		if(!value.equals("heat")) return true;
		if(simulate){
			return heat >= amount;
		}
		heat -= amount;
		return true;
	}

}
