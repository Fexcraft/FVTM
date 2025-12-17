package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.uni.world.CubeSide;

/**
 * 
 * MultiBlock Trigger
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MB_Access {
	
	private CubeSide sidefrom;
	private V3I pos;
	private String target;
	
	public MB_Access(JsonArray array, V3I core){
		pos = new V3I(array.toIntegerArray(), 0);
		if(core != null) pos = pos.add(-core.z, -core.y, -core.x);
		target = array.get(3).string_value();
		if(array.size() > 4) sidefrom = CubeSide.valueOf(array.get(5).string_value().toUpperCase());
	}
	
	public boolean isWholeBlock(){
		return sidefrom == null;
	}
	
	public V3I getPos(){
		return pos;
	}
	
	public String getTarget(){
		return target;
	}

	public CubeSide getSide(){
		return sidefrom;
	}
	
	public static class CapabilityContainer {
		
		public CapabilityContainer(String id, Object capability, InvHandler invhandler){
			cap = capability;
			handler = invhandler;
			this.id = id;
		}
		
		public Object cap;
		public InvHandler handler;
		public final String id;
		
	}

}
