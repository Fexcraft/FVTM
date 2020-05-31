package net.fexcraft.mod.addons.gep.scripts;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.fexcraft.mod.fvtm.data.block.MB_Trigger;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.util.script.DefaultCraftBlockScript;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

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
		return heat > 1500;
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
	public boolean onTrigger(MultiBlockData data, MB_Trigger trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, Vec3d hit){
		if(trigger.getTarget().equals("open")){
			open = !open;
			Print.chat(player, "state:" + open);
			return true;
		}
		return super.onTrigger(data, trigger, player, hand, core, pos, side, hit);
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
		return open ? cooldown_speed / 2 : cooldown_speed;
	}
	
	public boolean consume(String value, int amount, boolean simulate){
		if(!value.equals("heat")) return true;
		if(simulate){
			return heat >= amount;
		}
		heat -= amount;
		return true;
	}
	
	@Override
	public int getConsumable(String id){
		if(id.equals("heat")) return heat;
		return 0;
	}

	@Override
	public String[] getConsumables(){
		return new String[]{ "heat" };
	}

	@Override
	public void setConsumable(String id, int value){
		if(id.equals("heat")){
			heat = value;
		}
	}

}
