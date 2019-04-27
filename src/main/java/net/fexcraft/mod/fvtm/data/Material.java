package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class Material extends TypeCore<Material> {
	
	protected byte maxStackSize;
	protected short maxHealth;
	protected MaterialItem item;
	protected String oreDict, container;
	protected int burntime;
	protected boolean isVehicleKey;
	
	public Material(){}

	@Override
	public Material setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<Material> getRegistryType(){
		return Material.class;
	}

	@Override
	public Material parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Material");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.maxStackSize = JsonUtil.getIfExists(obj, "MaxItemStackSize", 64).byteValue();
		this.maxHealth = JsonUtil.getIfExists(obj, "MaxItemDamage", 0).shortValue();
		this.oreDict = obj.has("OreDictionary") ? obj.get("OreDictionary").getAsString() : null;
		this.container = obj.has("ContainerItem") ? obj.get("ContainerItem").getAsString() : null;
		this.burntime = JsonUtil.getIfExists(obj, "ItemBurnTime", 0).intValue();
		this.isVehicleKey = JsonUtil.getIfExists(obj, "VehicleKey", false);
		//
		this.item = new MaterialItem(this); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.MATERIAL;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	public int getMaxStackSize(){
		return this.maxStackSize;
	}
	
	public MaterialItem getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}

	public int getMaxDamage(){
		return this.maxHealth;
	}
	
	public String getOreDictionaryId(){
		return this.oreDict;
	}
	
	public String getContainerItemId(){
		return this.container;
	}

	public void linkContainerItem(){
		if(this.container == null) return;
		this.item.setContainerItem(Item.getByNameOrId(this.container));
	}

	public int getItemBurnTime(){
		return burntime;
	}
	
	public boolean isVehicleKey(){
		return this.isVehicleKey;
	}

	public void registerIntoOreDictionary(){
        if(getOreDictionaryId() != null) OreDictionary.registerOre(getOreDictionaryId(), item); else return;
	}

}
