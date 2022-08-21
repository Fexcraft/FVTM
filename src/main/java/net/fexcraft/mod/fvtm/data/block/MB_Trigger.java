package net.fexcraft.mod.fvtm.data.block;

import com.google.gson.JsonArray;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * MultiBlock Trigger
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MB_Trigger {
	
	private AxisAlignedBB boundingbox;
	private EnumFacing sidefrom;
	private BlockPos pos;
	//
	private String target;
	private boolean script;
	
	public MB_Trigger(JsonArray array, BlockPos core){
		pos = new BlockPos(array.get(0).getAsInt(), array.get(1).getAsInt(), array.get(2).getAsInt());
		if(core != null) pos = pos.add(-core.getX(), -core.getY(), -core.getZ());
		script = array.get(3).getAsString().equals("script");
		target = array.get(4).getAsString();
		if(array.size() > 5){
			if(array.get(5).isJsonArray()){
				JsonArray arrbox = array.get(5).getAsJsonArray();
				boundingbox = new AxisAlignedBB(
					arrbox.get(0).getAsDouble(), arrbox.get(1).getAsDouble(), arrbox.get(2).getAsDouble(),
					arrbox.get(3).getAsDouble(), arrbox.get(4).getAsDouble(), arrbox.get(5).getAsDouble());
			}
			else{
				sidefrom = EnumFacing.byName(array.get(5).getAsString());
			}
		}
	}
	
	public boolean isWholeBlock(){
		return sidefrom == null && boundingbox == null;
	}
	
	public AxisAlignedBB getBB(){
		return boundingbox;
	}
	
	public EnumFacing getSide(EnumFacing rotate){
		if(rotate != null && rotate.getAxis() != EnumFacing.Axis.Y && sidefrom.getAxis() != EnumFacing.Axis.Y){
			switch(rotate){
				case EAST:
					return sidefrom.rotateY();
				case SOUTH:
					return sidefrom.rotateY().rotateY();
				case WEST:
					return sidefrom.rotateYCCW();
				default:
					return sidefrom;
			}
		}
		return sidefrom;
	}

	public EnumFacing getSide(){
		return sidefrom;
	}
	
	public BlockPos getBlockPos(){
		return pos;
	}
	
	public String getTarget(){
		return target;
	}
	
	public boolean forScript(){
		return script;
	}
	
	public boolean forInventory(){
		return !script;
	}

}
