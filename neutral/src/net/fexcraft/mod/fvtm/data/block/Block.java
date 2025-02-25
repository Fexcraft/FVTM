package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.root.*;
import net.fexcraft.mod.fvtm.data.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Block extends Content<Block> implements TextureHolder, ColorHolder, SoundHolder, WithItem, ItemTextureable {

	protected List<IDL> textures;
	protected ArrayList<BlockFunction> functions = new ArrayList<>();
	protected Map<String, RGB> channels = new LinkedHashMap<>();
	protected Map<String, Sound> sounds = new LinkedHashMap<>();
	protected Map<String, AABBs> aabbs = new LinkedHashMap<>();
	protected ModelData modeldata;
	protected BlockType blocktype;
	protected RelayData relaydata;
	protected Model model;
	protected Boolean passable;
	protected boolean plain_model;
	protected boolean no3ditem;
	protected boolean weblike;
	protected boolean fullblock;
	protected boolean fullcube;
	protected boolean opaque;
	protected boolean cutout;
	protected boolean translucent;
	protected boolean invisible;
	protected boolean hideitem;
	protected boolean randomrot;
	protected boolean ladder;
	protected boolean tickable;
	protected boolean hastile;
	protected boolean plantableon;
	protected String modelid;
	protected String ctab;
	protected String oredict;
	protected String material;
	protected String mapcolor;
	protected String harverest_class;
	protected String soundtype;
	protected float hardness;
	protected float lightlevel;
	protected float resistance;
	protected float damage;
	protected int lightopacity;
	protected int harverest_level;
	protected int maxstacksize;
	protected int burntime;
	protected IDL itemtexloc;
	public Supplier block20;
	protected Object block;

	@Override
	public Block parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Block");
		description = ContentConfigUtil.getStringList(map, "Description");
		textures = ContentConfigUtil.getTextures(map);
		if(map.has("ColorChannels")){
			for(Map.Entry<String, JsonValue<?>> entry : map.get("ColorChannels").asMap().entries()){
				channels.put(entry.getKey(), new RGB(entry.getValue().string_value()));
			}
		}
		if(channels.isEmpty()){
			channels.put("primary", RGB.WHITE.copy());
			channels.put("secondary", RGB.WHITE.copy());
		}
		maxstacksize = map.getInteger("MaxItemStackSize", 64);
		if(maxstacksize < 1) maxstacksize = 1;
		if(maxstacksize > 64) maxstacksize = 64;
		burntime = map.getInteger("ItemBurnTime", 0);
		oredict = map.getString("OreDictionary", null);
		modelid = map.getString("Model", null);
		if(modelid == null || modelid.equals("null") || modelid.startsWith("baked|")) plain_model = true;
		if(EnvInfo.CLIENT){
			modeldata = new ModelData(map);
			if(modeldata.getBoolean("Baked", false)) plain_model = true;
		}
		if(map.has("AABBs")){
			map.getMap("AABBs").entries().forEach(entry -> {
				JsonArray value = entry.getValue().asArray();
				if(value.get(0).isArray()){
					ArrayList<AABB> list = new ArrayList<>();
					for(JsonValue<?> elm : value.value){
						JsonArray arr = elm.asArray();
						list.add(AABB.create(arr.get(0).float_value(), arr.get(1).float_value(), arr.get(2).float_value(),
							arr.get(3).float_value(), arr.get(4).float_value(), arr.get(5).float_value()));
					}
					aabbs.put(entry.getKey(), new AABBs(list));
				}
				else{
					JsonArray array = entry.getValue().asArray();
					if(entry.getKey().startsWith("collision") && array.get(0).string_value().equals("null")){
						aabbs.put(entry.getKey(), AABBs.EMPTY);
					}
					else{
						aabbs.put(entry.getKey(), new AABBs(array.get(0).float_value(), array.get(1).float_value(), array.get(2).float_value(),
							array.get(3).float_value(), array.get(4).float_value(), array.get(5).float_value()));
					}
				}
			});
		}
		if(map.has("Sounds")){
			for(Map.Entry<String, JsonValue<?>> entry : map.getMap("Sounds").entries()){
				if(entry.getValue().isMap()){
					JsonMap val = entry.getValue().asMap();
					sounds.put(entry.getKey(), new Sound(IDLManager.getIDLCached(val.getString("sound", "minecraft:block.lever.click")), val.getFloat("volume", 1f), val.getFloat("pitch", 1f)));
				}
				else{
					sounds.put(entry.getKey(), new Sound(IDLManager.getIDLCached(entry.getValue().string_value()), 1f, 1f));
				}
			}
		}
		blocktype = BlockType.valueOf(map.getString("BlockType", "GENERIC_SIMPLE"));
		material = map.getString("Material", "ROCK");
		mapcolor = map.getString("MapColor", "STONE");
		hardness = map.getFloat("Hardness", 1f);
		lightlevel = map.getFloat("LightLevel", 0f);
		resistance = map.getFloat("Resistance", 0f);
		lightopacity = map.getInteger("LightOpacity", 0);
		if(map.has("HarverestTool")){
			JsonArray array = map.getArray("HarverestTool");
			harverest_class = array.get(0).string_value();
			harverest_level = array.get(1).integer_value();
		}
		damage = map.getFloat("CollisionDamage", 0);
		weblike = map.getBoolean("WebLike", false);
		fullblock = map.getBoolean("FullBlock", true);
		fullcube = map.getBoolean("FullCube", true);
		opaque = map.getBoolean("Opaque", false);
		cutout = map.getBoolean("RenderCutout", false);
		translucent = map.getBoolean("RenderTranslucent", false);
		invisible = map.getBoolean("Invisible", false);
		hideitem = map.getBoolean("HideItem", false);
		randomrot = map.getBoolean("RandomRotation", false);
		ladder = map.getBoolean("Ladder", false);
		passable = map.has("Passable") ? map.getBoolean("Passable", false) : null;
		plantableon = map.getBoolean("PlantableOn", false);
		tickable = map.getBoolean("Tickable", false);
		hastile = map.getBoolean("MultiSubBlock", false);
		hastile = map.getBoolean("HasBlockEntity", hastile);
		if(map.has("Functions") && map.get("Functions").isMap()){
			map.getMap("Functions").entries().forEach(entry -> {
				parseFunction(entry.getKey(), entry.getValue());
			});
		}
		if(map.has("WireRelay")){
			relaydata = new RelayData(map.getMap("WireRelay"));
		}
		soundtype = map.getString("SoundType", "stone");
		//
		ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		no3ditem = map.getBoolean("Disable3DItemModel", false);
		//
		block20 = () -> {
			try{
				return BlockType.BLOCK_IMPL.get(blocktype, hastile || relaydata != null, plain_model).getConstructor(Block.class).newInstance(this);
			}
			catch(Throwable e){
				FvtmLogger.log(e, "block class creation");
				return null;
			}
		};
		if(EnvInfo.is112()) genBlock();
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.BLOCK;
	}

	@Override
	public Class<?> getDataClass(){
		return BlockData.class;
	}

	@Override
	public List<IDL> getDefaultTextures(){
		return textures;
	}

	@Override
	public Map<String, Sound> getSounds(){
		return sounds;
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
	public RGB getDefaultColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public Map<String, RGB> getDefaultColorChannels(){
		return channels;
	}

	private void parseFunction(String key, JsonValue elm){
		try{
			BlockFunction func = FvtmRegistry.BLOCK_FUNCTIONS.get(key).getConstructor().newInstance();
			functions.add(func.parse(elm));
		}
		catch(Exception e){
			FvtmLogger.log("Failed to load BlockFunction for '" + id.colon() + "' with JSON: " + elm);
			e.printStackTrace();
		}
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, BlockModel.class);
	}

	@Override
	public Model getModel(){
		return model;
	}

	public AABBs getAABB(String type, String... states){
		if(type.equals("selection")){
			for(String state : states){
				if(aabbs.containsKey("selection#" + state)) return aabbs.get("selection#" + state);
			}
			if(aabbs.containsKey("selection#normal")) return aabbs.get("selection#normal");
		}
		else if(type.equals("collision")){
			for(String state : states){
				if(aabbs.containsKey("collision#" + state)) return aabbs.get("collision#" + state);
			}
			if(aabbs.containsKey("collision#normal")) return aabbs.get("collision#normal");
		}
		for(String state : states){
			if(aabbs.containsKey(state)) return aabbs.get(state);
		}
		return aabbs.containsKey("normal") ? aabbs.get("normal") : AABBs.FULL;
	}

	public AABBs getAABB(String type, String state){
		if(type.equals("selection")){
			if(aabbs.containsKey("selection#" + state)) return aabbs.get("selection#" + state);
			if(aabbs.containsKey("selection#normal")) return aabbs.get("selection#normal");
		}
		else if(type.equals("collision")){
			if(aabbs.containsKey("collision#" + state)) return aabbs.get("collision#" + state);
			if(aabbs.containsKey("collision#normal")) return aabbs.get("collision#normal");
		}
		else if(type.equals("render") && aabbs.containsKey("render")){
			return aabbs.get("render");
		}
		return aabbs.containsKey(state) ? aabbs.get(state) : aabbs.containsKey("normal") ? aabbs.get("normal") : AABBs.FULL;
	}

	public BlockType getBlockType(){
		return blocktype;
	}

	public RelayData getRelayData(){
		return relaydata;
	}

	public ArrayList<BlockFunction> getFunctions(){
		return functions;
	}

	public boolean hasRelay(){
		return relaydata != null;
	}

	public String getMaterial(){
		return material;
	}

	public String getMapColor(){
		return mapcolor;
	}

	public float getHardness(){
		return hardness;
	}

	public float getLightLevel(){
		return lightlevel;
	}

	public float getResistance(){
		return resistance;
	}

	public int getLightOpacity(){
		return lightopacity;
	}

	public String getHarverestToolClass(){
		return harverest_class;
	}

	public int getHarverestToolLevel(){
		return harverest_level;
	}

	public boolean isFullBlock(){
		return fullblock;
	}

	public boolean isFullCube(){
		return fullcube;
	}

	public boolean isOpaque(){
		return opaque;
	}

	public float getCollisionDamage(){
		return damage;
	}

	public boolean isWebLike(){
		return weblike;
	}

	public boolean isCutout(){
		return cutout;
	}

	public boolean isTranslucent(){
		return translucent;
	}

	public boolean isInvisible(){
		return invisible;
	}

	public boolean isLadder(){
		return ladder;
	}

	public boolean hasPlainModel(){
		return plain_model;
	}

	public boolean isTickable(){
		return tickable;
	}

	public int getMaxStackSize(){
		return maxstacksize;
	}

	public boolean shouldHideItem(){
		return hideitem;
	}

	public int getItemBurnTime(){
		return burntime;
	}

	public boolean hasFunction(String key){
		for(BlockFunction func : functions) if(func.id().equals(key)) return true;
		return false;
	}

	public String getOreDictId(){
		return oredict;
	}

	public <BLK> BLK getBlock(){
		return (BLK)block;
	}

	public <BLK> BLK genBlock(){
		return (BLK)(block = block20.get());
	}

	public boolean isRandomRot(){
		return randomrot;
	}

	public ModelData getModelData(){
		return modeldata;
	}

	public Boolean getPassable(){
		return passable;
	}

	public boolean isPlantableOn(){
		return plantableon;
	}

	public String getSoundTypeId(){
		return soundtype;
	}

}
