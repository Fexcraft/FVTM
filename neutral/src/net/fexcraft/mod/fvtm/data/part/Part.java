package net.fexcraft.mod.fvtm.data.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.sys.event.EventHolder;
import net.fexcraft.mod.fvtm.sys.event.EventListener;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Part extends Content<Part> implements TextureHolder, SoundHolder, WithItem, ItemTextureable {

	protected List<IDL> textures;
	protected ArrayList<String> categories;
	protected ArrayList<PartFunction> functions = new ArrayList<>();
	protected Map<String, Attribute<?>> attributes = new LinkedHashMap<>();
	protected Map<String, SwivelPoint> swivelpoints = new LinkedHashMap<>();
	protected Map<String, String> attr_mods = new LinkedHashMap<>();
	protected Map<String, Sound> sounds = new LinkedHashMap<>();
	protected EventHolder holder = new EventHolder(this);
	protected PartInstallHandler installhandler;
	protected Object installhandler_data;
	protected Model model;
	protected ModelData modeldata;
	protected IDL itemtexloc;
	protected boolean no3ditem;
	protected String modelid;
	protected String ctab;

	public Part(){}

	@Override
	public Part parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Part");
		description = ContentConfigUtil.getStringList(map, "Description");
		textures = ContentConfigUtil.getTextures(map);
		if(map.has("Category")){
			if(map.get("Category").isArray()){
				categories = map.getArray("Category").toStringList();
			}
			else{
				categories = new ArrayList<>();
				categories.add(map.getString("Category", "ballast"));
			}
		}
		else if(map.has("Categories")){
			categories = map.getArray("Categories").toStringList();
		}
		if(categories == null) categories = new ArrayList<>();
		if(categories.isEmpty()) categories.add("undefined");
		//
		if(map.has("Attributes") && map.get("Attributes").isMap()){
			for(Entry<String, JsonValue<?>> entry : map.getMap("Attributes").entries()){
				Attribute<?> attr = Attribute.parse(entry.getKey(), entry.getValue().asMap());
				if(attr != null) attributes.put(attr.id, attr);
			}
		}
		if(map.has("AttributeModifiers")){
			JsonMap mod = map.getMap("AttributeModifiers");
			for(Entry<String, JsonValue<?>> entry : mod.entries()){
				attr_mods.put(entry.getKey(), entry.getValue().string_value());
			}
		}
		if(map.has("Functions") && map.get("Functions").isMap()){
			JsonMap funcs = map.getMap("Functions");
			for(Entry<String, JsonValue<?>> entry : funcs.entries()){
				PartFunction fun = FvtmResources.getFunction(entry.getKey());
				if(fun != null) functions.add(fun.init(this, entry.getValue()));
			}
		}
		//
		JsonValue inst = map.get("Installation");
		String instid = inst == null ? "default": inst.isMap() ? inst.asMap().getString("Handler", "default") : inst.string_value();
		installhandler = PartInstallHandler.getHandler(instid);
		installhandler_data = installhandler.parseData(inst != null && inst.isMap() ? inst.asMap() : new JsonMap());
		//
		if(map.has("SwivelPoints") && map.get("SwivelPoints").isMap()){
			for(Entry<String, JsonValue<?>> entry : map.getMap("SwivelPoints").entries()){
				SwivelPoint point = new SwivelPoint(entry.getKey(), entry.getValue().asMap());
				swivelpoints.put(entry.getKey(), point);
			}
		}
		if(map.has("Sounds")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("Sounds").entries()){
				if(entry.getValue().isMap()){
					JsonMap val = entry.getValue().asMap();
					sounds.put(entry.getKey(), new Sound(IDLManager.getIDLCached(val.getString("sound", "minecraft:block.lever.click")), val.getFloat("volume", 1f), val.getFloat("pitch", 1f)));
				}
				else{
					sounds.put(entry.getKey(), new Sound(IDLManager.getIDLCached(entry.getValue().string_value()), 1f, 1f));
				}
			}
		}
		if(map.has("Events")){
			for(JsonValue<?> val : map.getArray("Events").value){
				EventListener lis = null;
				try{
					lis = EventListener.parse(val);
				}
				catch(Exception e){
					FvtmLogger.log(e, "vehicle event parsing");
				}
				if(lis != null) holder.insert(lis);
			}
		}
		//TODO load scripts
		if(EnvInfo.CLIENT || EnvInfo.is121()){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		no3ditem = map.getBoolean("Disable3DItemModel", false);
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.PART;
	}

	@Override
	public Class<?> getDataClass(){
		return PartData.class;
	}

	@Override
	public List<IDL> getDefaultTextures(){
		return textures;
	}

	public String getCategory(){
		return categories.get(0);
	}

	public Collection<String> getCategories(){
		return categories;
	}

	public PartInstallHandler getInstallHandler(){
		return installhandler;
	}

	@Override
	public Map<String, Sound> getSounds(){
		return sounds;
	}

	public Map<String, Attribute<?>> getDefaultAttributes(){
		return attributes;
	}

	public Map<String, SwivelPoint> getDefaultSwivelPoints(){
		return swivelpoints;
	}

	public <PIHD> PIHD getInstallHandlerData(){
		return (PIHD)installhandler_data;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

	public boolean noCustomItemModel(){
		return no3ditem;
	}

	public ArrayList<PartFunction> getDefaultFunctions(){
		return functions;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public Map<String, String> getStaticModifiers(){
		return attr_mods;
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, DefaultModel.class);
	}

	@Override
	public Model getModel(){
		return model;
	}

	public EventHolder getEvents(){
		return holder;
	}

}
