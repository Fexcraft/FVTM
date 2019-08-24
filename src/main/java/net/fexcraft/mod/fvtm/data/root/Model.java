package net.fexcraft.mod.fvtm.data.root;

import java.util.Collection;
import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.vehicle.RenderCache;
import net.minecraft.entity.Entity;

/**
 * @param <T> "Data Type"
 * @param <KD> KeyData
 * @param <K> Key/Argument Type
 * */
public interface Model<T, /*KD, */K> {

	/** 
	 * Entityless rendering.
	 * @param data - self-explaining
	 * @param key - mainly used for parts, "key" under which they are installed, shouldn't be null for parts.
	 * @param keydata - mainly used for parts, the partdata instance
	 */
	public void render(T data, @Nullable K key);
	
	/**
	 * Normal rendering.
	 * @param data - self-explaining
	 * @param key - mainly used for parts, "key" under which they are installed, shouldn't be null for parts.
	 * @param ent - the entity that is being rendered
	 * @param cache - the redered entity's rendercache instance
	 * @param meta - optional metadata if rendering from blocks
	 */
	public void render(T data, @Nullable K key, @Nullable Entity ent, @Nullable RenderCache cache, int meta);
	
	/** Collection containing either the name or UUID of the creator(s) of the model.**/
	public Collection<String> getCreators();
	
	/** Only in use on Model init/generation. **/
	public boolean addToCreators(String str);
	
}