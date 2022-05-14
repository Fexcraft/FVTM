package net.fexcraft.mod.fvtm.data.root;

import java.util.TreeMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * Capability to hold temporary animation data.
 */
public interface RenderCache {

	public TreeMap<String, Float> getValues();
	
	/** Gets a float value if present, else returns null. */
	public Float getValue(String id);
	
	/** Returns the specified default value if entry is missing. */
	public Float getValue(String id, Float def);
	
	/** Set value to `null` to remove the entry. Otherwise, it updates the cache. */
	public Float setValue(String id, Float value);

}