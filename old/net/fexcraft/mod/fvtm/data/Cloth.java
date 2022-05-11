package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.event.TypeEvents;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.model.ClothModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Cloth extends TypeCore<Cloth> implements Tabbed, ItemTextureable {
	
	protected short maxHealth;
	protected ClothItem item;
	protected String ctab, modelid;
	protected EntityEquipmentSlot eq_slot;
	protected ArmorMaterial material;
	protected ClothModel model;
	protected ResourceLocation texture;
	protected ResourceLocation itemloc;
	
	public Cloth(){}

	@Override
	public Cloth setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<Cloth> getRegistryType(){
		return Cloth.class;
	}

	@Override
	public Cloth parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Clothing");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.maxHealth = JsonUtil.getIfExists(obj, "MaxItemDamage", 0).shortValue();
		this.eq_slot = EntityEquipmentSlot.fromString(JsonUtil.getIfExists(obj, "EquipmentSlot", "head").toLowerCase());
		this.material = parseMaterial(obj);
		//
		this.texture = new NamedResourceLocation(JsonUtil.getIfExists(obj, "Texture", Resources.NULL_TEXTURE.toString()));
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
        this.itemloc = DataUtil.getItemTexture(registryname, getDataType(), obj);
		this.item = new ClothItem(this);
		MinecraftForge.EVENT_BUS.post(new TypeEvents.ClothCreated(this, obj));
		return this;
	}

	private ArmorMaterial parseMaterial(JsonObject obj){
		if(obj.has("ArmorMaterial") || obj.has("ClothMaterial")){
			String mat = (obj.has("ArmorMaterial") ? obj.get("ArmorMaterial") : obj.get("ClothMaterial")).getAsString().toLowerCase();
			if(mat.contains(":")){
				return Resources.getClothMaterial(mat);
			}
			for(ArmorMaterial armat : ArmorMaterial.values()){
				if(armat.getName().equals(mat)) return armat;
			}
		}
		return Resources.NONE_MAT;
	}

	@Override
	public DataType getDataType(){
		return DataType.MATERIAL;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}
	
	public ClothItem getClothItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}

	public int getMaxDamage(){
		return this.maxHealth;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public EntityEquipmentSlot getEquitmentSlot(){
		return eq_slot;
	}

	public ArmorMaterial getArMaterial(){
		return material;
	}

	public ClothModel getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		this.model = (ClothModel)Resources.getModel(modelid, ClothModel.class);
	}
	
	public ResourceLocation getTexture(){
		return texture;
	}

	@Override
	public ResourceLocation getItemTexture(){
		return itemloc;
	}

}
