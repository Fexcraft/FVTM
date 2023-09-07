package net.fexcraft.mod.fvtm.data.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.event.TypeEvents;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.script.FSVehicleScript;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Part extends TypeCore<Part> implements Textureable.TextureHolder, SoundHolder, ItemTextureable {
	
	protected ArrayList<Attribute<?>> attributes = new ArrayList<>();
	protected LinkedHashMap<String, String> attr_mods = new LinkedHashMap<>();
	protected List<IDL> textures;
	protected List<String> categories;
	protected PartItem item;
	protected String modelid, ctab;
	protected Model model;
	protected ModelData modeldata;
	protected PartInstallHandler installhandler;
	protected Object installhandler_data;
	protected ArrayList<PartFunction> functions = new ArrayList<>();
	protected ArrayList<Class<? extends VehicleScript>> scripts = new ArrayList<>();
	protected ArrayList<JsonElement> scripts_data = new ArrayList<>();
	protected TreeMap<String, Sound> sounds = new TreeMap<>();
	protected TreeMap<String, SwivelPoint> rotpoints = new TreeMap<>();
	protected IDL itemloc;
	protected boolean no3ditem;
	
	public Part(){}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Part parse(JsonObject obj){
		if(obj.has("Script")){
			addScript(obj.get("Script"));
		}
		if(obj.has("Scripts")){
			JsonArray array = obj.get("Scripts").getAsJsonArray();
			for(JsonElement elm : array) addScript(elm);
		}
		//
		if(Static.isClient()){
			modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
			modeldata = DataUtil.getModelData(obj);
		}
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
		this.itemloc = IDLManager.getIDLCached(DataUtil.getItemTexture(registryname, getDataType(), obj).toString());
        this.no3ditem = JsonUtil.getIfExists(obj, "DisableItem3DModel", false);
		this.item = new PartItem(this);
		MinecraftForge.EVENT_BUS.post(new TypeEvents.PartCreated(this, obj));
		return this;
	}

	private void addScript(JsonElement elm){
		String clazz = null;
		JsonElement data = null;
		if(elm.isJsonObject()){
			clazz = elm.getAsJsonObject().get("class").getAsString().replace(".class", "");
			data = elm.getAsJsonObject().get("data");
		}
		else{
			clazz = elm.getAsString().replace(".class", "");
			data = new JsonObject();
		}
        try{
        	if(clazz.endsWith(".script")){
        		scripts.add(FSVehicleScript.class);
        		if(data.isJsonObject()){
        			data.getAsJsonObject().addProperty("script_location", clazz);
        			scripts_data.add(data);
        		}
        		else scripts_data.add(new JsonPrimitive(clazz));
        	}
        	else{
            	scripts.add((Class<? extends VehicleScript>)Class.forName(clazz));
            	scripts_data.add(data);
        	}
        }
        catch(Exception e){
        	e.printStackTrace();
        	Static.stop();
        }
	}

	@Override
	public ContentType getDataType(){
		return ContentType.PART;
	}

	@Override
	public Class<?> getDataClass(){
		return PartData.class;
	}

	public String getCategory(){
		return categories.isEmpty() ? null : categories.get(0);
	}
	
	public List<String> getCategories(){
		return categories;
	}
	
	public PartItem getPartItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}
	
	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}
	
	public Model getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		this.model = FvtmResources.getModel(modelid, modeldata, PartModel.class);
	}
	
	@Nullable
	public Collection<Attribute<?>> getBaseAttributes(){
		return attributes;
	}

	@Override
	public List<IDL> getDefaultTextures(){
		return textures;
	}
	
	public PartInstallHandler getInstallationHandler(){
		return installhandler;
	}
	
	/** Not every handler may have additional data. */
	public <U> U getInstallationHandlerData(){
		return (U)installhandler_data;
	}
	
	public List<PartFunction> getDefaultFunctions(){
		return functions;
	}
	
	public List<Class<? extends VehicleScript>> getVehicleScripts(){
		return scripts;
	}
	
	public List<JsonElement> getVehicleScriptsData(){
		return scripts_data;
	}

	@Override
	public Map<String, Sound> getSounds(){
		return sounds;
	}

	public TreeMap<String, SwivelPoint> getDefaultSwivelPoints(){
		return rotpoints;
	}

	//@Override
	public String getCreativeTab(){
		return ctab;
	}

	@Override
	public IDL getItemTexture(){
		return itemloc;
	}
	
	@Override
	public boolean noCustomItemModel(){
		return no3ditem;
	}

	public HashMap<String, String> getStaticModifiers(){
		return attr_mods;
	}

}
