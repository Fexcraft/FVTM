package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Block extends TypeCore<Block> implements Textureable.TextureHolder, Colorable.ColorHolder, Tabbed, ItemTextureable {
	
	public static final AxisAlignedBB[] FULL_BLOCK_AABB_ARRAY = new AxisAlignedBB[]{ net.minecraft.block.Block.FULL_BLOCK_AABB };
	//
	protected List<NamedResourceLocation> textures;
	protected BlockItem item;
	protected net.minecraft.block.Block block;
	protected String modelid, ctab;
	protected Model model;
	protected ModelData modeldata;
	protected ResourceLocation itemloc;
	protected boolean no3ditem;
	//
	protected boolean plain_model, hideitem;
	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected byte maxstacksize;
	protected TreeMap<String, AxisAlignedBB[]> aabbs = new TreeMap<>();
	protected BlockType blocktype;
	protected int burntime;
	protected String oredict;
	//
	protected Material material;
	protected MapColor colour;
	protected float hardness, lightlevel, resistance, damage;
	protected int lightopacity, harveresttoollevel;
	protected String harveresttoolclass;
	protected boolean isweblike, fullblock, fullcube, opaque, cutout, translucent, invisible, randomrot;
	//
	protected MultiBlock multiblock;
	protected RelayData relaydata;
	
	public Block(){}

	@Override
	public Block setRegistryName(ResourceLocation name){
		registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Block> getRegistryType(){
		return Block.class;
	}

	@Override
	public Block parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Part");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.textures = DataUtil.getTextures(obj);
		//
		channels.put("primary", DataUtil.getColor(obj, "Primary", false));
		channels.put("secondary", DataUtil.getColor(obj, "Secondary", false));
		if(obj.has("Colors")){
			for(Entry<String, JsonElement> entry : obj.get("Colors").getAsJsonObject().entrySet()){
				channels.put(entry.getKey(), new RGB(entry.getValue().getAsString()));
			}
		}
		//
		this.maxstacksize = JsonUtil.getIfExists(obj, "MaxItemStackSize", 64).byteValue();
		this.burntime = JsonUtil.getIfExists(obj, "ItemBurnTime", 0).intValue();
		this.oredict = obj.has("OreDictionary") ? obj.get("OreDictionary").getAsString() : null;
		//
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		if(modelid == null || modelid.equals("null") || modelid.startsWith("baked|")) plain_model = true;//in other words, json models
		modeldata = DataUtil.getModelData(obj);
		if(obj.has("AABBs")){
			obj.get("AABBs").getAsJsonObject().entrySet().forEach(entry -> {
				try{
					JsonArray array = entry.getValue().getAsJsonArray();
					if(array.get(0).isJsonArray()){
						ArrayList<AxisAlignedBB> list = new ArrayList<>();
						for(JsonElement elm : array){
							JsonArray arr = elm.getAsJsonArray();
							list.add(new AxisAlignedBB(arr.get(0).getAsDouble(), arr.get(1).getAsDouble(), arr.get(2).getAsDouble(),
								arr.get(3).getAsDouble(), arr.get(4).getAsDouble(), arr.get(5).getAsDouble()));
						}
						aabbs.put(entry.getKey(), list.toArray(new AxisAlignedBB[0]));
					}
					else{
						aabbs.put(entry.getKey(), new AxisAlignedBB[]{
							new AxisAlignedBB(array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble(),
							array.get(3).getAsDouble(), array.get(4).getAsDouble(), array.get(5).getAsDouble())
						});
					}
				}
				catch(Exception e){
					e.printStackTrace(); Print.log("Failed to load AABB for block '" + this.registryname.toString() + "' with JSON: " + entry.toString());
				}
			});
		}
		this.blocktype = BlockType.valueOf(JsonUtil.getIfExists(obj, "BlockType", "GENERIC_4ROT"));
		this.material = BlockUtil.getMaterial(JsonUtil.getIfExists(obj, "Material", "ROCK").toLowerCase());
		//TODO eventually allow creation of custom materials
		this.colour = BlockUtil.getMapColor(JsonUtil.getIfExists(obj, "MapColor", "STONE").toLowerCase());
		this.hardness = JsonUtil.getIfExists(obj, "Hardness", 1f).floatValue();
		this.lightlevel = JsonUtil.getIfExists(obj, "LightLevel", 0f).floatValue();
		this.resistance = JsonUtil.getIfExists(obj, "Resistance", 0f).floatValue();
		this.lightopacity = JsonUtil.getIfExists(obj, "LightOpacity", 0f).byteValue();
		if(obj.has("HarverestTool")){
			JsonArray ht = obj.get("HarverestTool").getAsJsonArray();
			harveresttoolclass = ht.get(0).getAsString();
			harveresttoollevel = ht.get(1).getAsInt();
		}
		else{
			this.harveresttoolclass = JsonUtil.getIfExists(obj, "HarverestToolClass", "pickaxe");
			this.harveresttoollevel = JsonUtil.getIfExists(obj, "HarverestToolLevel", 0).intValue();
		}
		this.damage = JsonUtil.getIfExists(obj, "CollisionDamage", 0).floatValue();
		this.isweblike = JsonUtil.getIfExists(obj, "WebLike", false);
		this.fullblock = JsonUtil.getIfExists(obj, "FullBlock", true);
		this.fullcube = JsonUtil.getIfExists(obj, "FullCube", true);
		this.opaque = JsonUtil.getIfExists(obj, "Opaque", false);
		this.cutout = JsonUtil.getIfExists(obj, "RenderCutout", false);
		this.translucent = JsonUtil.getIfExists(obj, "RenderTranslucent", false);
		this.invisible = JsonUtil.getIfExists(obj, "Invisible", false);
		this.hideitem = JsonUtil.getIfExists(obj, "HideItem", false);
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
        this.itemloc = DataUtil.getItemTexture(registryname, getDataType(), obj);
        this.no3ditem = JsonUtil.getIfExists(obj, "DisableItem3DModel", false);
        this.randomrot = JsonUtil.getIfExists(obj, "RandomRotation", false);
		if(obj.has("MultiBlock")){
			this.multiblock = new MultiBlock(registryname, obj.get("MultiBlock").getAsJsonObject());
		}
		boolean sub = obj.has("MultiSubBlock") && obj.get("MultiSubBlock").getAsBoolean();
		if(obj.has("WireRelay")){
			relaydata = new RelayData(obj.get("WireRelay").getAsJsonObject());
		}
		try{
			this.block = blocktype.getApplicableClass(sub || isFunctional() || canBeWired(), plain_model).getConstructor(Block.class).newInstance(this);
		}
		catch(Exception e){
			e.printStackTrace(); Static.stop();
		}
		return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.BLOCK;
	}

	@Override
	public Class<?> getDataClass(){
		return BlockData.class;
	}
	
	public BlockItem getBlockItem(){
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
		this.model = Resources.getModel(modelid, modeldata, BlockModel.class);
	}

	@Override
	public List<NamedResourceLocation> getDefaultTextures(){
		return textures;
	}

	public boolean isFunctional(){
		return multiblock != null;
	}

	public boolean isDecoration(){
		return multiblock == null;
	}

	public boolean isRailBlock(){
		return blocktype.isRailBlock();
	}

	public byte getMaxStackSize(){
		return maxstacksize;
	}
	
	public boolean hasPlainModel(){
		return plain_model;
	}
	
	public TreeMap<String, AxisAlignedBB[]> getAABBs(){
		return aabbs;
	}
	
	public AxisAlignedBB[] getAABB(String type, String state){
		if(type.equals("selection")){
			if(aabbs.containsKey("selection#" + state)) return aabbs.get("selection#" + state);
			if(aabbs.containsKey("selection#normal")) return aabbs.get("selection#normal");
		}
		else if(type.equals("collision")){
			if(aabbs.containsKey("collision#" + state)) return aabbs.get("collision#" + state);
			if(aabbs.containsKey("collision#normal")) return aabbs.get("collision#normal");
		}
		return aabbs.containsKey(state) ? aabbs.get(state) : aabbs.containsKey("normal") ? aabbs.get("normal") : FULL_BLOCK_AABB_ARRAY;
	}

	public Material getMaterial(){
		return material;
	}

	public MapColor getMapColor(){
		return colour;
	}
	
	public BlockType getBlockType(){
		return blocktype;
	}

	public int getItemBurnTime(){
		return burntime;
	}
	
	public String getOreDictionaryId(){
		return this.oredict;
	}

	public void registerIntoOreDictionary(){
		if(getOreDictionaryId() != null) OreDictionary.registerOre(getOreDictionaryId(), item); else return;
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
		return harveresttoolclass;
	}

	public int getHarverestToolLevel(){
		return harveresttoollevel;
	}

	public void linkItem(){
		item = (BlockItem)Item.REGISTRY.getObject(registryname);
	}

	public float getCollisionDamage(){
		return damage;
	}

	public boolean isWebLike(){
		return isweblike;
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

	public boolean isCutout(){
		return cutout;
	}

	public boolean isTranslucent(){
		return translucent;
	}

	public MultiBlock getMultiBlock(){
		return multiblock;
	}

	public boolean isInvisible(){
		return invisible;
	}

	public boolean shouldHideItem(){
		return hideitem;
	}

	@Override
	public RGB getDefaultColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public TreeMap<String, RGB> getDefaultColorChannels(){
		return channels;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}
	
	public boolean canBeWired(){
		return relaydata != null;
	}
	
	public RelayData getRelayData(){
		return relaydata;
	}

	@Override
	public ResourceLocation getItemTexture(){
		return itemloc;
	}
	
	@Override
	public boolean no3DItemModel(){
		return no3ditem;
	}

	public boolean getRandomRot(){
		return randomrot;
	}

}
