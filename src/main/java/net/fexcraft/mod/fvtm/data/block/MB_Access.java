package net.fexcraft.mod.fvtm.data.block;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

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

}
