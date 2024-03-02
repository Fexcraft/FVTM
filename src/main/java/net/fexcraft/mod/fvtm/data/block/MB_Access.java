package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;

import net.fexcraft.mod.fvtm.data.inv.InvHandler;
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
	
	public MB_Access(JsonArray array, BlockPos core){
		pos = new BlockPos(array.get(0).getAsInt(), array.get(1).getAsInt(), array.get(2).getAsInt());
		if(core != null) pos = pos.add(-core.getZ(), -core.getY(), -core.getX());
		target = array.get(3).getAsString();
		if(array.size() > 4) sidefrom = EnumFacing.byName(array.get(4).getAsString());
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
		//Print.debug("filling " + facing);
		facing = MultiBlock0.rotate(facing, rotateby);
		if(!capabilities.containsKey(facing)) capabilities.put(facing, new ArrayList<>());
		InvHandler handler = data.getInventories().get(target);
		Capability<?> cap = null;
		if(handler.type.isFluid()){
			cap = CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
		}
		else if(handler.type.isItem()){
			cap = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
		}
		else if(!handler.type.isVariable()) return;
		capabilities.get(facing).add(new CapabilityContainer(target, cap, handler));
	}
	
	public static class CapabilityContainer {
		
		public CapabilityContainer(String id, Capability<?> capability, InvHandler invhandler){
			cap = capability;
			handler = invhandler;
			this.id = id;
		}
		
		public Capability<?> cap;
		public InvHandler handler;
		public final String id;
		
	}

}
