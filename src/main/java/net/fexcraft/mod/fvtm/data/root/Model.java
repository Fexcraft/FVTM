package net.fexcraft.mod.fvtm.data.root;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.lang3.math.NumberUtils;

import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.CompDataRoot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
	public static final String PIVOTS = "Pivots";
	public static final String OFFSET = "Offset";
	public static final String TRANSFORMS = "Transforms";

	/**  Render call. */
	public void render(ModelRenderData data);
	
	/** Collection containing either the name or UUID of the creator(s) of the model.**/
	public Collection<String> getCreators();
	
	/** Only in use on Model init/generation. **/
	public boolean addToCreators(String str);

	/** Reads ModelData other than the polygons/vertices. */
	public Model parse(ModelData data);
	
	/** Locks the model. Adding creators and initialising groups is then disabled. */
	public void lock();
	
	/** Reusable object for rendering. */
	public static class ModelRenderData {
		
		public Entity entity;
		public TileEntity tile;
		
		public VehicleData vehicle;
		public ContainerData container;
		public BlockData block;
		public Colorable color;
		public TextureUser texture;
		public PartData part;
		public String part_category;
		public DecorationData decoration;
		public CompDataRoot trafficsign_compdata;
		public ClothItem cloth_item;
		public ArrayList<String> cloth_groups;
		
		public RenderCache cache;
		

		public ModelRenderData set(VehicleData data, Entity ent, RenderCache renca){
			entity = ent;
			vehicle = data;
			color = data;
			texture = data;
			part = null;
			part_category = null;
			cache = renca;
			return this;
		}


		public ModelRenderData set(VehicleData data, Entity ent, RenderCache renca, PartData partdata, String key){
			entity = ent;
			vehicle = data;
			color = data;
			texture = partdata;
			part = partdata;
			part_category = key;
			cache = renca;
			return this;
		}


		public ModelRenderData set(ContainerData data, TileEntity tileent, RenderCache renca){
			container = data;
			tile = tileent;
			cache = renca;
			color = data;
			texture = data;
			return this;
		}


		public ModelRenderData set(BlockData data, TileEntity tileent, RenderCache renca){
			block = data;
			tile = tileent;
			cache = renca;
			color = data;
			texture = data;
			return this;
		}


		public ModelRenderData set(DecorationData data, Entity ent, RenderCache renca){
			decoration = data;
			entity = ent;
			cache = renca;
			color = data;
			return this;
		}


		public ModelRenderData set(ClothItem item, ArrayList<String> list, EntityLivingBase ent, RenderCache renca){
			cloth_item = item;
			cloth_groups = list;
			entity = ent;
			cache = renca;
			return this;
		}


		public ModelRenderData set(CompDataRoot comp){
			trafficsign_compdata = comp;
			return this;
		}
		
	}
	
	public static class ModelData extends HashMap<String, Object> {
		
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
		
		public ArrayList<String> creators(){
			if(!containsKey("creators")) put("creators", new ArrayList<String>());
			return get("creators");
		}

		public void convert(){
			Collection<String> keys = this.keySet();
			for(String key : keys){
				Object obj = get(key);
				if(obj instanceof String == false) continue;
				String val = obj.toString();
				if(val.equals("true") || val.equals("false")){
					put(key, val.equals("true"));
					continue;
				}
				if(NumberUtils.isCreatable(val)){
					try{
						put(key, Float.parseFloat(val));
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}

		public <T> T get(String key, T def){
			Object o = super.get(key);
			return o == null ? def : (T)o;
		}

		public List<String> getList(String key){
			Object obj = super.get(key);
			if(obj == null) return new ArrayList<>();
			if(obj instanceof List == false){
				ArrayList<String> list = new ArrayList<>();
				list.add(obj.toString());
				put(key, list);
				return list;
			}
			return (List<String>)obj;
		}
		
	}
	
	public static interface ModelLoader {
		
		public boolean accepts(String name, String suffix);
		
		/**
		 * @param name the model address/resourcelocation
		 * @param confdata existing model data from config
		 * @param model new model instance if necessary (usually only unused by the class model loader)
		 * @return the model, with optionally a (updated or overridden) ModelData object on 2nd index
		 */
		public Object[] load(String name, ModelData confdata, Supplier<Model> model) throws Exception;
		
	}
	
}