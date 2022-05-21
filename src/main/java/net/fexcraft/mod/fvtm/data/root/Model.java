package net.fexcraft.mod.fvtm.data.root;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Supplier;

import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

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

	/**  Render call. */
	public void render(ModelRenderData data);
	
	/** Collection containing either the name or UUID of the creator(s) of the model.**/
	public Collection<String> getCreators();
	
	/** Only in use on Model init/generation. **/
	public boolean addToCreators(String str);

	public Model parse(ModelData data);
	
	public void lock();
	
	/** Reusable object for rendering. */
	public static class ModelRenderData {
		
		public Entity entity;
		public TileEntity tile;
		
		public VehicleData vehicle;
		public ContainerData container;
		public BlockData block;
		public Colorable color;
		public PartData part;
		public String key;
		
		public RenderCache cache;
		
	}
	
	public static class ModelData {
		
		public DataMap values = new DataMap();
		public ArrayList<String> filter_groups = new ArrayList<>();
		public boolean exclude_groups;
		
		public ArrayList<String> creators(){
			if(!values.containsKey("creators")) values.put("creators", new ArrayList<String>());
			return values.get("creators");
		}
		
	}
	
	public static class DataMap extends HashMap<String, Object> {
		
		/** Gets the specific value based on key, will return null if missing. */
		public <T> T get(String key){
			return (T)super.get(key);
		}

		/** Gets the specific value based on key, uses supplier to fill in value if missing. */
		public <T> T get(String key, Supplier<T> ifmissing){
			if(!containsKey(key)){
				return (T)set(key, ifmissing.get());
			}
			return (T)super.get(key);
		}

		/** Sets the specific value based on key, returns the set value. */
		public <T> T set(String key, T obj){
			put(key, obj);
			return obj;
		}

		/** Sets the specific value based on key, if missing. */
		public <T> void set(String key, Supplier<T> ifmissing){
			if(!containsKey(key)) set(key, ifmissing.get());
		}

		public boolean contains(String key){
			return containsKey(key);
		}
		
	}
	
	public static interface ModelLoader {
		
		public boolean accepts(String name, String suffix);
		
		/**
		 * @param name the model adress/resourcelocation
		 * @param confdata existing model data from config
		 * @return the model, with optionally a (updated or overridden) ModelData object on 2nd index
		 */
		public Object[] load(String name, ModelData confdata) throws Exception;
		
	}
	
}