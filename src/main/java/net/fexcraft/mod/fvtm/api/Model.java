package net.fexcraft.mod.fvtm.api;

import java.util.Collection;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;

/**
 * @param <T> "Data Type"
 * @param <K> Key/Argument Type
 * */
public interface Model<T, K> {
	
	/** Parameterless rendering. **/
	public void render();
	
	/** 
	 * Entityless rendering.
	 * @param data - self-explaining?
	 * @param key - mainly used for parts, "key" under which they are installed, shouldn't be null for parts.
	 */
	public void render(T data, @Nullable K key);
	
	/**
	 * Normal rendering.
	 * @param data - self-explaining?
	 * @param key - mainly used for parts, "key" under which they are installed, shouldn't be null for parts.
	 * @param ent - the entity that is being rendered
	 * @param meta - optional metadata if rendering from blocks
	 */
	public void render(T data, @Nullable K key, @Nullable Entity ent, int meta);
	
	public Collection<String> getCreators();
	
}