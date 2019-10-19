package net.fexcraft.mod.fvtm.data.block;

import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
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
public class Block extends TypeCore<Block> implements Textureable.TextureHolder, Colorable.ColorHolder {
	
	protected List<NamedResourceLocation> textures;
	protected BlockItem item;
	protected net.minecraft.block.Block block;
	protected String modelid;
	protected Model<BlockData, Object> model;
	//
	protected boolean functional, plain_model;
	protected RGB primary, secondary;
	protected byte maxstacksize;
	protected TreeMap<String, AxisAlignedBB> aabbs = new TreeMap<>();
	protected BlockType blocktype;
	protected int burntime;
	protected String oredict;
	//
	protected Material material;
	protected MapColor colour;
	protected float hardness, lightlevel, resistance, damage;
	protected int lightopacity, harveresttoollevel;
	protected String harveresttoolclass;
	protected boolean isweblike, fullblock, fullcube, opaque;
	
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
		if(obj.has("Functional")) functional = obj.get("Functional").getAsBoolean();
		if(obj.has("Decoration")) functional = !obj.get("Decoration").getAsBoolean();
		this.primary = DataUtil.getColor(obj, "Primary");
		this.secondary = DataUtil.getColor(obj, "Secondary");
		this.maxstacksize = JsonUtil.getIfExists(obj, "MaxItemStackSize", 64).byteValue();
		this.burntime = JsonUtil.getIfExists(obj, "ItemBurnTime", 0).intValue();
		this.oredict = obj.has("OreDictionary") ? obj.get("OreDictionary").getAsString() : null;
		//
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		if(modelid == null || modelid.equals("null")) plain_model = true;//in other words, json models
		if(obj.has("AABBs")){
			obj.get("AABBs").getAsJsonObject().entrySet().forEach(entry -> {
				try{
					JsonArray array = entry.getValue().getAsJsonArray();
					aabbs.put(entry.getKey(), new AxisAlignedBB(array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble(),
						array.get(3).getAsDouble(), array.get(4).getAsDouble(), array.get(5).getAsDouble()));
				}
				catch(Exception e){
					e.printStackTrace(); Print.log("Failed to load AABB for block '" + this.registryname.toString() + "' with JSON: " + entry.toString());
				}
			});
		}
		this.blocktype = BlockType.valueOf(JsonUtil.getIfExists(obj, "BlockType", "GENERIC_4ROT"));
		this.material = getMaterial(JsonUtil.getIfExists(obj, "Material", "ROCK").toLowerCase());
		//TODO eventually allow creation of custom materials
		this.colour = getMapColor(JsonUtil.getIfExists(obj, "MapColor", "STONE").toLowerCase());
		this.hardness = JsonUtil.getIfExists(obj, "Hardness", 1f).floatValue();
		this.lightlevel = JsonUtil.getIfExists(obj, "LightLevel", 0f).floatValue();
		this.resistance = JsonUtil.getIfExists(obj, "Resistance", 0f).floatValue();
		this.lightopacity = JsonUtil.getIfExists(obj, "LightOpacity", 0f).byteValue();
		this.harveresttoolclass = JsonUtil.getIfExists(obj, "HarverestToolClass", "pickaxe");
		this.harveresttoollevel = JsonUtil.getIfExists(obj, "HarverestToolLevel", 0).intValue();
		this.damage = JsonUtil.getIfExists(obj, "CollisionDamage", 0).floatValue();
		this.isweblike = JsonUtil.getIfExists(obj, "WebLike", false);
		this.fullblock = JsonUtil.getIfExists(obj, "FullBlock", true);
		this.fullcube = JsonUtil.getIfExists(obj, "FullCube", true);
		this.opaque = JsonUtil.getIfExists(obj, "Opaque", false);
		try{
			this.block = blocktype.getApplicableClass(functional, plain_model).getConstructor(Block.class).newInstance(this);
		} catch(Exception e){ e.printStackTrace(); Static.stop(); } return this;
	}

	private Material getMaterial(String mat){
		switch(mat){
			case "air": return Material.AIR;
			case "grass": return Material.GRASS;
			case "ground": return Material.GROUND;
			case "wood": return Material.WOOD;
			case "rock": return Material.ROCK;
			case "iron": return Material.IRON;
			case "anvil": return Material.ANVIL;
			case "water": return Material.WATER;
			case "lava": return Material.LAVA;
			case "leaves": return Material.LEAVES;
			case "plants": return Material.PLANTS;
			case "vine": return Material.VINE;
			case "sponge": return Material.SPONGE;
			case "cloth": return Material.CLOTH;
			case "fire": return Material.FIRE;
			case "sand": return Material.SAND;
			case "circuits": return Material.CIRCUITS;
			case "carpet": return Material.AIR;
			case "glass": return Material.GLASS;
			case "redstone_light": return Material.REDSTONE_LIGHT;
			case "tnt": return Material.TNT;
			case "coral": return Material.CORAL;
			case "ice": return Material.ICE;
			case "packed_ice": return Material.PACKED_ICE;
			case "snow": return Material.SNOW;
			case "crafted_snow": return Material.CRAFTED_SNOW;
			case "cactus": return Material.CACTUS;
			case "clay": return Material.CLAY;
			case "gourd": return Material.GOURD;
			//case "dragon_egg": return Material.DRAGON_EGG;
			case "portal": return Material.PORTAL;
			case "cake": return Material.CAKE;
			case "web": return Material.WEB;
			case "piston": return Material.PISTON;
			case "barrier": return Material.BARRIER;
			//case "scructure_void": return Material.STRUCTURE_VOID;
		} return Material.ROCK;
	}

	private MapColor getMapColor(String mapcol){
		switch(mapcol){
			case "air": return MapColor.AIR;
			case "grass": return MapColor.GRASS;
			case "sand": return MapColor.SAND;
			case "cloth": return MapColor.CLOTH;
			case "tnt": return MapColor.TNT;
			case "ice": return MapColor.ICE;
			case "iron": return MapColor.IRON;
			case "foliage": return MapColor.FOLIAGE;
			case "snow": return MapColor.SNOW;
			case "clay": return MapColor.CLAY;
			case "dirt": return MapColor.DIRT;
			case "stone": return MapColor.STONE;
			case "water": return MapColor.WATER;
			case "wood": return MapColor.WOOD;
			case "quartz": return MapColor.QUARTZ;
			case "adobe": return MapColor.ADOBE;
			case "magenta": return MapColor.MAGENTA;
			case "light_blue": return MapColor.LIGHT_BLUE;
			case "yellow": return MapColor.YELLOW;
			case "lime": return MapColor.LIME;
			case "pink": return MapColor.PINK;
			case "gray": return MapColor.GRAY;
			case "silver": return MapColor.SILVER;
			case "cyan": return MapColor.CYAN;
			case "purple": return MapColor.PURPLE;
			case "blue": return MapColor.BLUE;
			case "brown": return MapColor.BROWN;
			case "green": return MapColor.GREEN;
			case "red": return MapColor.RED;
			case "black": return MapColor.BLACK;
			case "gold": return MapColor.GOLD;
			case "diamond": return MapColor.DIAMOND;
			case "lapis": return MapColor.LAPIS;
			case "emerald": return MapColor.EMERALD;
			case "obsidian": return MapColor.OBSIDIAN;
			case "netherrack": return MapColor.NETHERRACK;
			case "white_stained_hardenen_clay": return MapColor.WHITE_STAINED_HARDENED_CLAY;
			case "orange_stained_hardenen_clay": return MapColor.ORANGE_STAINED_HARDENED_CLAY;
			case "magenta_stained_hardenen_clay": return MapColor.MAGENTA_STAINED_HARDENED_CLAY;
			case "light_blue_stained_hardenen_clay": return MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY;
			case "yellow_stained_hardenen_clay": return MapColor.YELLOW_STAINED_HARDENED_CLAY;
			case "lime_stained_hardenen_clay": return MapColor.LIME_STAINED_HARDENED_CLAY;
			case "pink_stained_hardenen_clay": return MapColor.PINK_STAINED_HARDENED_CLAY;
			case "gray_stained_hardenen_clay": return MapColor.GRAY_STAINED_HARDENED_CLAY;
			case "silver_stained_hardenen_clay": return MapColor.SILVER_STAINED_HARDENED_CLAY;
			case "cyan_stained_hardenen_clay": return MapColor.CYAN_STAINED_HARDENED_CLAY;
			case "purple_stained_hardenen_clay": return MapColor.PURPLE_STAINED_HARDENED_CLAY;
			case "blue_stained_hardenen_clay": return MapColor.BLUE_STAINED_HARDENED_CLAY;
			case "brown_stained_hardenen_clay": return MapColor.BROWN_STAINED_HARDENED_CLAY;
			case "green_stained_hardenen_clay": return MapColor.GREEN_STAINED_HARDENED_CLAY;
			case "red_stained_hardenen_clay": return MapColor.RED_STAINED_HARDENED_CLAY;
			case "black_stained_hardenen_clay": return MapColor.BLACK_STAINED_HARDENED_CLAY;
		}
		return MapColor.STONE;
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
	
	public Model<BlockData, Object> getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		this.model = Resources.getModel(modelid, BlockModel.class);
	}

	@Override
	public List<NamedResourceLocation> getDefaultTextures(){
		return textures;
	}

	@Override
	public RGB getDefaultPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getDefaultSecondaryColor(){
		return secondary;
	}

	public boolean isFunctional(){
		return functional;
	}

	public boolean isDecoration(){
		return !functional;
	}

	public byte getMaxStackSize(){
		return maxstacksize;
	}
	
	public boolean hasPlainModel(){
		return plain_model;
	}
	
	public TreeMap<String, AxisAlignedBB> getAABBs(){
		return aabbs;
	}
	
	public AxisAlignedBB getAABB(String type, String state){
		if(type.equals("selection")){
			if(aabbs.containsKey("selection#" + state)) return aabbs.get("selection#" + state);
			if(aabbs.containsKey("selection#normal")) return aabbs.get("selection#normal");
		}
		else if(type.equals("collision")){
			if(aabbs.containsKey("collision#" + state)) return aabbs.get("collision#" + state);
			if(aabbs.containsKey("collision#normal")) return aabbs.get("collision#normal");
		}
		return aabbs.containsKey(state) ? aabbs.get(state) : aabbs.containsKey("normal") ? aabbs.get("normal") : net.minecraft.block.Block.FULL_BLOCK_AABB;
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

}
