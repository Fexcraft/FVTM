package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.TreeMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * Capability to hold temporary animation data.
 */
public interface RenderCache {

	public TreeMap<String, Float> getValues();
	
	public float getValue(String id);
	
	/** Set value to `null` to remove the entry. */
	public float setValue(String id, Float value);

}