package net.fexcraft.mod.fvtm.data.block;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
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
	
	public MB_Trigger(JsonObject obj){
		if(obj.has("block")){
			JsonArray array = obj.get("block").getAsJsonArray();
			pos = new BlockPos(array.get(0).getAsInt(), array.get(1).getAsInt(), array.get(2).getAsInt());
		}
		if(obj.has("hitbox")){
			if(obj.get("hitbox").isJsonArray()){
				JsonArray array = obj.get("hitbox").getAsJsonArray();
				boundingbox = new AxisAlignedBB(
					array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble(),
					array.get(3).getAsDouble(), array.get(4).getAsDouble(), array.get(5).getAsDouble());
			}
			else{
				sidefrom = EnumFacing.byName(obj.get("hitbox").getAsString());
			}
		}
		if(obj.has("target")){
			target = obj.get("target").getAsString();
		}
		else{
			Print.log("ERROR: Trigger has NO target! " + obj.toString());
			Static.stop();
		}
		if(obj.has("type")){
			switch(obj.get("type").getAsString()){
				case "inventory": case "inv":{
					script = false;
					break;
				}
				case "script":{
					script = true;
					break;
				}
			}
		}
	}
	
	public boolean isWholeBlock(){
		return sidefrom == null && boundingbox == null;
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
