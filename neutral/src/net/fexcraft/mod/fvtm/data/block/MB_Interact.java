package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.world.CubeSide;

/**
 * 
 * MultiBlock Interaction
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MB_Interact {
	
	private AABB aabb;
	private CubeSide sidefrom;
	private V3I pos;
	private String target;
	private boolean script;
	
	public MB_Interact(JsonArray array, V3I core){
		pos = new V3I(array.toIntegerArray(), 0);
		if(core != null) pos = pos.add(-core.z, -core.y, -core.x);
		script = array.get(3).string_value().equals("script");
		target = array.get(4).string_value();
		if(array.size() > 5){
			if(array.get(5).isArray()){
				aabb = AABB.create(array.get(5).asArray().toFloatArray());
			}
			else{
				sidefrom = CubeSide.valueOf(array.get(5).string_value().toUpperCase());
			}
		}
	}
	
	public boolean isWholeBlock(){
		return sidefrom == null && aabb == null;
	}
	
	public AABB getBB(){
		return aabb;
	}
	
	public CubeSide getSide(CubeSide rotate){
		if(rotate != null && rotate.axe() != CubeSide.Axe.Y && sidefrom.axe() != CubeSide.Axe.Y){
			switch(rotate){
				case EAST:
					return sidefrom.rotate();
				case SOUTH:
					return sidefrom.rotate().rotate();
				case WEST:
					return sidefrom.rotateCC();
				default:
					return sidefrom;
			}
		}
		return sidefrom;
	}

	public CubeSide getSide(int idx){
		return getSide(CubeSide.fromIndex(idx, null));
	}

	public CubeSide getSide(){
		return sidefrom;
	}
	
	public V3I getPos(){
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
