package net.fexcraft.mod.fvtm.sys.uni;

import java.util.HashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelMap extends HashMap<String, UniWheel> {

	public <T> T getWheel(String key){
		return (T)get(key);
	}

}
