package net.fexcraft.mod.fvtm.data.root;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
		
	}
	
	public static class DataMap extends HashMap<String, Object> {
		
		public <T> T get(String key){
			return (T)super.get(key);
		}
		
	}
	
	public static interface ModelLoader {
		
		public boolean accepts(String name, String suffix);
		
		/**
		 * @param name the model adress/resourcelocation
		 * @param confdata existing model data from config
		 * @return the model, with optionally a ModelData object on 2nd index
		 */
		public Object[] load(String name, ModelData confdata) throws Exception;
		
	}
	
}