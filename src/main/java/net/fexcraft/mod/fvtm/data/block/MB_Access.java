package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

/**
 * 
 * MultiBlock Trigger
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MB_Access {
	
	private EnumFacing sidefrom;
	private BlockPos pos;
	private String target;
	
	public MB_Access(JsonObject obj){
		if(obj.has("block")){
			JsonArray array = obj.get("block").getAsJsonArray();
			pos = new BlockPos(array.get(0).getAsInt(), array.get(1).getAsInt(), array.get(2).getAsInt());
		}
		else pos = new BlockPos(0, 0, 0);
		if(obj.has("side")){
			sidefrom = EnumFacing.byName(obj.get("side").getAsString());
		}
		if(obj.has("target")){
			target = obj.get("target").getAsString();
		}
		else{
			Print.log("ERROR: Trigger has NO target! " + obj.toString());
			Static.stop();
		}
	}
	
	public boolean isWholeBlock(){
		return sidefrom == null;
	}
	
	public BlockPos getBlockPos(){
		return pos;
	}
	
	public String getTarget(){
		return target;
	}

	public EnumFacing getSide(){
		return sidefrom;
	}

	public void fill(MultiBlockData data, EnumFacing facing, EnumFacing rotateby, Map<EnumFacing, List<CapabilityContainer>> capabilities){
		if(facing == null){
			if(sidefrom == null){
				for(EnumFacing face : EnumFacing.VALUES){
					fill(data, face, rotateby, capabilities);
				}
			}
			else fill(data, sidefrom, rotateby, capabilities);
			return;
		}
		Print.debug("filling " + facing);
		facing = MultiBlock.rotate(facing, rotateby);
		if(!capabilities.containsKey(facing)) capabilities.put(facing, new ArrayList<>());
		InventoryType type = data.getType().getInventoryTypes().get(target);
		Capability<?> cap = null;
		Object value = null;
		switch(type){
			case ENERGY:
				//TODO
				break;
			case FLUID:
				cap = CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
				value = data.getFluidTank(target);
				break;
			case ITEM:
				cap = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
				value = data.getInventoryHandler(target);
				break;
			default: return;
			
		}
		capabilities.get(facing).add(new CapabilityContainer(cap, value));
	}
	
	public static class CapabilityContainer {
		
		public CapabilityContainer(Capability<?> cap2, Object value2){
			cap = cap2;
			value = value2;
		}
		
		public Capability<?> cap;
		public Object value;
		
	}

}
