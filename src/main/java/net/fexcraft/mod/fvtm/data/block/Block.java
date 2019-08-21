package net.fexcraft.mod.fvtm.data.block;

import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Block extends TypeCore<Block> implements Textureable.TextureHolder, Colorable.ColorHolder {
	
	protected List<NamedResourceLocation> textures;
	protected BlockItem item;
	protected String modelid;
	protected Model<BlockData, String> model;
	//
	protected boolean functional, plain_model;
	protected RGB primary, secondary;
	protected byte maxstacksize;
	protected TreeMap<String, AxisAlignedBB> aabbs = new TreeMap<>();
	
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
		this.item = new BlockItem(this); return this;
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
	
	public Model<BlockData, String> getModel(){
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
	
	public AxisAlignedBB getAABB(String state){
		return aabbs.containsKey(state) ? aabbs.get(state) : net.minecraft.block.Block.FULL_BLOCK_AABB;
	}

}
