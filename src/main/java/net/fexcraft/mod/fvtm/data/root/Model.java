package net.fexcraft.mod.fvtm.data.root;

import java.util.Collection;

import javax.annotation.Nullable;

import net.minecraft.world.entity.Entity;

/**
 * @param <T> "Data Type"
 * @param <K> Key/Argument Type
 * */
public interface Model {

	/** 
	 * Entity-less rendering.
	 */
	public void render(RenderData data);
	
	/**
	 * Normal rendering.ance
	 */
	public void render(RenderData data, Entity ent, @Nullable RenderCache cache);
	
	/** Collection containing either the name or UUID of the creator(s) of the model.**/
	public Collection<String> getCreators();
	
	/** Only in use on Model init/generation. **/
	public boolean addToCreators(String str);
	
	public static record RenderData(){};
	
}