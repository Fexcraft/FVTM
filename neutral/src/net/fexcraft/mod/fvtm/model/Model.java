package net.fexcraft.mod.fvtm.model;

import java.util.Collection;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public interface Model {
	
	public static final String CREATORS = "Authors";
	public static final String TEXTURE_WIDTH = "TextureWidth";
	public static final String TEXTURE_HEIGHT = "TextureHeight";
	public static final String PROGRAMS = "Programs";
	public static final String CONDPROGRAMS = "CondPrograms";
	public static final String SMOOTHSHADING = "SmoothShading";
	public static final String OBJ_INCLUDE = "Include";
	public static final String PIVOTS = "Pivots";
	public static final String OFFSET = "Offset";
	public static final String TRANSFORMS = "Transforms";

	/**  Render call. */
	public void render(ModelRenderData data);
	
	/** Collection containing either the name or UUID of the creator(s) of the model.**/
	public Collection<String> getCreators();
	
	/** Only in use on Model init/generation. **/
	public boolean addToCreators(String str);

	public void setGroups(ModelGroupList list);

	public ModelGroupList getGroups();

	/** Reads ModelData other than the polygons/vertices. */
	public Model parse(ModelData data);
	
	/** Locks the model. Adding creators and initialising groups is then disabled. */
	public void lock();

	/** Sorts all groups based on render order. */
	public void sort();

	public void clearGLData();

	public ModelGroupList getSeparateGroups();

}