package net.fexcraft.mod.addons.gep.scripts;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.MB_Trigger;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.util.script.DefaultCraftBlockScript;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SmelteryScript extends DefaultCraftBlockScript {
	
	private static int heatincr;
	private static float lavacon;
	private int heat;
	private int lava;//just copying tank status, for the gui
	private boolean open;

	public SmelteryScript(JsonObject obj){
		super(obj);
		heatincr = obj.has("heat_per_tick") ? obj.get("heat_per_tick").getAsInt() : 10;
		lavacon = obj.has("lava_per_heat") ? obj.get("lava_per_heat").getAsFloat() : 1f;
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
	public boolean ready(MultiblockTickableTE tile){
		lava = tile.getMultiBlockData().getFluidTank("tank").getFluidAmount();
		return heat > 1500;
	}
	
	@Override
	public void prepare(MultiblockTickableTE tile){
		if(lava <= 0){
			if(processed > 0) processed--;
			if(heat > 0) heat--; 
			return;
		}
		int heatby = open ? heatincr * 2 : heatincr;
		int lavat = (int)(heatby * lavacon);
		if(lavat < 1) lavat = 1;
		if(lava < lavat){
			tile.getMultiBlockData().getFluidTank("tank").drain(lava, true);
			heat += heatby > 2 ? heatby / 2 : 1;
			return;
		}
		tile.getMultiBlockData().getFluidTank("tank").drain(lavat, true);
		heat += heatby;
	}
	
	@Override
	public void running(MultiblockTickableTE tile){
		int coolby = open ? 2 : 1;
		if(isCoolingDown()) coolby /= 2;
		if(coolby <= 0) return;
		heat -= coolby;
	}

	@Override
	public boolean onTrigger(MultiBlockData data, MB_Trigger trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, Vec3d hit){
		if(trigger.getTarget().equals("open")){
			open = !open;
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("smeltery_open", open);
			super.sendPacket(player.world.getTileEntity(core), compound);
			return true;
		}
		return super.onTrigger(data, trigger, player, hand, core, pos, side, hit);
	}


	@Override
	public void onUpdatePacket(TileEntity tile, NBTTagCompound compound){
		if(tile.getWorld().isRemote){
			open = compound.hasKey("smeltery_open") ? compound.getBoolean("smeltery_open") : false;
		}
	}
	
	@Override
	public int process_speed(){
		return open ? process_speed * 2 : process_speed;
	}
	
	@Override
	public int process_time(){
		return open && process_time > 1 ? process_time / 2 : process_time;
	}
	
	@Override
	public int cooldown_speed(){
		return open && cooldown_speed > 1 ? cooldown_speed / 2 : cooldown_speed;
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
		if(id.equals("lava")) return lava;
		return 0;
	}

	@Override
	public String[] getConsumables(){
		return new String[]{ "heat", "lava" };
	}

	@Override
	public void setConsumable(String id, int value){
		if(id.equals("heat")){
			heat = value;
		}
		if(id.equals("lava")){
			lava = value;
		}
	}

	@Override
	public List<Object[]> getGuiElements(){
		ArrayList<Object[]> list = new ArrayList<>();
		list.add(new Object[]{ GuiElement.PROGRESS_BAR, "Heat/Temp", "heat", 2000, RGB.RED });
		list.add(new Object[]{ GuiElement.TEXT_VALUE, "Lava Tank: %smB", "lava" });
		return list;
	}

	public boolean isOpen(){
		return open;
	}

}
