package net.fexcraft.mod.fvtm.model;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * Capability to hold temporary animation data.
 */
public interface RenderCache {

	public Map<Program, Object> map();

	/** Gets an object if present, else returns null. */
	public <V> V get(Program prog);

	/** Returns a new default object if entry is missing. */
	public <V> V get(Program prog, Function<ModelRenderData, V> def);

	/** Set object to `null` to remove the entry. Otherwise, it updates the cache. */
	public <V> V set(Program prog, V value);

}