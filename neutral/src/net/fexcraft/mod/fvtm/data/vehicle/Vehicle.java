package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.inv.FvtmInv;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.VehicleModel;
import net.fexcraft.mod.fvtm.sys.event.EventHolder;
import net.fexcraft.mod.fvtm.sys.event.EventListener;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Vehicle extends Content<Vehicle> implements TextureHolder, ColorHolder, SoundHolder, WithItem, ItemTextureable {//texture, color, sound

	protected Map<String, Attribute<?>> attributes = new LinkedHashMap<>();
	protected Map<String, WheelSlot> wheelpos = new LinkedHashMap<>();
	protected Map<String, V3D> connectors = new LinkedHashMap<>();
	protected Map<String, FvtmInv> definvs = new LinkedHashMap<>();
	protected Model model;
	protected ModelData modeldata;
	protected List<IDL> textures;
	protected List<String> categories;
	protected Map<String, RGB> channels = new LinkedHashMap<>();
	protected String modelid;
	protected String ctab;
	protected SimplePhysData sphdata;
	protected boolean trailer;
	protected boolean tracked;
	protected Map<String, IDL> installed;
	protected Map<String, Sound> sounds = new LinkedHashMap<>();
	protected Map<String, SwivelPoint> swivelpoints = new LinkedHashMap<>();
	protected float coupler_range = 1f;
	protected Map<String, LiftingPoint> liftingpoints = new HashMap<>();
	protected Map<String, LiftingPoint[]> gliftingpoints = new HashMap<>();
	protected List<InteractZone> interact_zones = new ArrayList<>();
	protected List<CatalogPreset> catalog = new ArrayList<>();
	protected List<Seat> defseats = new ArrayList<>();
	protected EventHolder holder = new EventHolder(this);
	protected IDL keytype;
	protected int maxkeys;
	protected int impactlevel;
	protected PartSlots partslots;
	protected IDL itemtexloc;
	protected boolean no3ditem;
	protected VehicleType type;

	public Vehicle(){}

	@Override
	public Vehicle parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Vehicle");
		description = ContentConfigUtil.getStringList(map, "Description");
		type = VehicleType.valueOf(map.getString("VehicleType", "LAND").toUpperCase());
		textures = ContentConfigUtil.getTextures(map);
		if(map.has("ColorChannels")){
			for(Entry<String, JsonValue<?>> entry : map.get("ColorChannels").asMap().entries()){
				channels.put(entry.getKey(), new RGB(entry.getValue().string_value()));
			}
		}
		if(channels.isEmpty()){
			channels.put("primary", RGB.WHITE.copy());
			channels.put("secondary", RGB.WHITE.copy());
		}
		categories = map.has("Categories") ? map.getArray("Categories").toStringList() : new ArrayList<>();
		if(map.has("Category")){
			String cat = map.get("Category").string_value();
			if(cat.contains(",")){
				String[] cats = cat.split(",");
				for(String str : cats) categories.add(str.trim());
			}
			else categories.add(cat);
		}
		maxkeys = map.getInteger("MaxKeys", 5);
		impactlevel = map.getInteger("ImpactWrench", 0);
		keytype = map.has("KeyType") ? IDLManager.getIDLCached(map.getString("KeyType", null)) : null;
		if(map.has("Attributes") && map.get("Attributes").isMap()){
			for(Entry<String, JsonValue<?>> entry : map.getMap("Attributes").entries()){
				Attribute<?> attr = Attribute.parse(entry.getKey(), entry.getValue().asMap());
				if(attr != null) attributes.put(attr.id, attr);
			}
		}
		List<Attribute<?>> attrs = type.getDefaultAttributesForType(trailer);
		for(Attribute<?> attr : attrs){
			if(!attributes.containsKey(attr.id)){
				attributes.put(attr.id, attr);
			}
			else{
				Attribute<?> attri = attributes.get(attr.id);
				attri.limit(attr.min, attr.max);
				attri.group(attr.group);
				attri.sync(attr.sync);
				attri.icons.putAll(attr.icons);
			}
		}
		if(map.has("WheelPositions") && map.get("WheelPositions").isMap()){
			for(Entry<String, JsonValue<?>> entry : map.get("WheelPositions").asMap().entries()){
				wheelpos.put(entry.getKey(), new WheelSlot(entry.getValue().asMap()));
			}
		}
		sphdata = new SimplePhysData(map.getMap("SimplePhysics"));
		trailer = map.getBoolean("Trailer", false) || map.getBoolean("Wagon", false);
		tracked = map.getBoolean("Tracked", false) || map.getBoolean("Catenary", false);
		coupler_range = map.getFloat("CouplerRange", coupler_range);
		if(map.has("InstalledParts")){
			installed = new LinkedHashMap<>();
			for(Entry<String, JsonValue<?>> entry : map.getMap("InstalledParts").entries()){
				installed.put(entry.getKey(), IDLManager.getIDLCached(entry.getValue().string_value()));
			}
		}
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
		if(map.has("LiftingPoints")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("LiftingPoints").entries()){
				if(entry.getValue().isArray()) liftingpoints.put(entry.getKey(), new LiftingPoint(entry.getKey(), entry.getValue().asArray()));
				else liftingpoints.put(entry.getKey(), new LiftingPoint(entry.getKey(), entry.getValue().asMap()));
			}
		}
		else{
			liftingpoints.put("ph0", new LiftingPoint("ph0", new V3D(0, 0, -20), null, 0));
			liftingpoints.put("ph1", new LiftingPoint("ph1", new V3D(0, 0, 20), null, 0));
		}
		for(LiftingPoint point : liftingpoints.values()){
			if(!gliftingpoints.containsKey(point.id) && !gliftingpoints.containsKey(point.second)){
				LiftingPoint[] arr = new LiftingPoint[point.isSingular() ? 1 : 2];
				arr[0] = point;
				if(arr.length > 1) arr[1] = liftingpoints.get(point.second);
				gliftingpoints.put(point.id, arr);
			}
		}
		partslots = new PartSlots(map.has("PartSlots") && map.get("PartSlots").isMap() ? map.getMap("PartSlots") : new JsonMap());
		if(EnvInfo.CLIENT){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		no3ditem = map.getBoolean("Disable3DItemModel", false);
		if(map.has("Catalog")){
			for(Entry<String, JsonValue<?>> catlog : map.getMap("Catalog").entries()){
				try{
					catalog.add(new CatalogPreset(this, catlog.getKey(), catlog.getValue().asMap()));
				}
				catch(Exception e){
					FvtmLogger.log(e, "vehicle catalog entry loading of " + id.colon());
				}
			}
		}
		if(map.has("InteractZones")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("InteractZones").entries()){
				interact_zones.add(new InteractZone(entry.getKey(), entry.getValue()));
			}
		}
		if(interact_zones.isEmpty()){
			interact_zones.add(new InteractZone("default", V3D.NULL, 4, SwivelPoint.DEFAULT));
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
		if(map.has("DefaultSeats")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("DefaultSeats").entries()){
				defseats.add(new Seat(entry.getKey(), entry.getValue().asMap()));
			}
		}
		if(map.has("Connectors")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("Connectors").entries()){
				try{
					connectors.put(entry.getKey(), ContentConfigUtil.getVector(entry.getValue().asArray(), 0));
				}
				catch(Exception e){
					FvtmLogger.log(e, "vehicle connector parsing");
				}
			}
		}
		if(map.has("Inventories")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("Inventories").entries()){
				try{
					JsonMap mep = entry.getValue().asMap();
					InvType type = InvType.parse(mep.getString("type", "item"));
					definvs.put(entry.getKey(), type.newInv());
				}
				catch(Exception e){
					FvtmLogger.log(e, "vehicle inventory parsing");
				}
			}
		}
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.VEHICLE;
	}

	@Override
	public Class<?> getDataClass(){
		return VehicleData.class;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

	@Override
	public boolean noCustomItemModel(){
		return no3ditem;
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, VehicleModel.class);
	}

	@Override
	public Model getModel(){
		return model;
	}

	@Override
	public List<IDL> getDefaultTextures(){
		return textures;
	}

	@Override
	public RGB getDefaultColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public Map<String, RGB> getDefaultColorChannels(){
		return channels;
	}

	@Override
	public Map<String, Sound> getSounds(){
		return sounds;
	}

	public <A extends Attribute<?>> A getDefaultAttribute(String id){
		return (A)attributes.get(id);
	}

	public <C, A extends Attribute<C>> A getDefaultAttributeCasted(String id){
		return (A)attributes.get(id);
	}

	public Map<String, Attribute<?>> getDefaultAttributes(){
		return attributes;
	}

	public Map<String, WheelSlot> getWheelPositions(){
		return wheelpos;
	}

	public SimplePhysData getSphData(){
		return sphdata;
	}

	public boolean isTrailer(){
		return trailer;
	}

	public boolean isWagon(){
		return trailer;
	}

	public Map<String, IDL> getInstalled(){
		return installed;
	}

	public float getCouplerRange(){
		return coupler_range;
	}

	public Map<String, SwivelPoint> getDefaultSwivelPoints(){
		return swivelpoints;
	}

	public Map<String, LiftingPoint> getLiftingPoints(){
		return liftingpoints;
	}

	public Map<String, LiftingPoint[]> getGroupedLiftingPoints(){
		return gliftingpoints;
	}

	public List<String> getCategories(){
		return categories;
	}

	public IDL getKeyType(){
		return keytype;
	}

	public PartSlots getPartSlots(){
		return partslots;
	}

	public int getMaxKeys(){
		return maxkeys;
	}

	public VehicleType getVehicleType(){
		return type;
	}

	public boolean isTracked(){
		return tracked;
	}

	public List<CatalogPreset> getCatalog(){
		return catalog;
	}

	public CatalogPreset getCatalogEntry(String rec){
		for(CatalogPreset preset : catalog){
			if(preset.id.equals(rec)) return preset;
		}
		return null;
	}

	public List<InteractZone> getDefaultInteractZones(){
		return interact_zones;
	}

	public int getImpactWrenchLevel(){
		return impactlevel;
	}

	public EventHolder getEvents(){
		return holder;
	}

	public List<Seat> getDefaultSeats(){
		return defseats;
	}

	public Map<String, V3D> getDefaultConnectors(){
		return connectors;
	}

	public Map<String, FvtmInv> getDefaultInventories(){
		return definvs;
	}

}
