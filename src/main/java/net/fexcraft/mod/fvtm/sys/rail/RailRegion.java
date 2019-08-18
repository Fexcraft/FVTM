package net.fexcraft.mod.fvtm.sys.rail;

import java.util.HashMap;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailRegion {
	
	private HashMap<Vec316f, Junction> junctions = new HashMap<>();

	public Junction getJunction(Vec316f vec){
		return junctions.get(vec);
	}

	public void updateTick(){
		//
	} 

}
