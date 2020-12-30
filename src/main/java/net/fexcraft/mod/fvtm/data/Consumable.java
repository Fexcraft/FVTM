package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.ConsumableItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Consumable extends TypeCore<Consumable> implements Tabbed {
	
	protected byte maxStackSize;
	protected ConsumableItem item;
	protected String oreDict, container, ctab;
	//
    private int healamount, useduration;
    private float saturation;
    private boolean wolffood, drinkable, alwaysedible;
	
	public Consumable(){}

	@Override
	public Consumable setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<Consumable> getRegistryType(){
		return Consumable.class;
	}

	@Override
	public Consumable parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Material");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.maxStackSize = JsonUtil.getIfExists(obj, "MaxItemStackSize", 64).byteValue();
		this.oreDict = obj.has("OreDictionary") ? obj.get("OreDictionary").getAsString() : null;
		this.container = obj.has("ContainerItem") ? obj.get("ContainerItem").getAsString() : null;
		//
        this.healamount = JsonUtil.getIfExists(obj, "HealAmount", 1).intValue();
        this.saturation = JsonUtil.getIfExists(obj, "Saturation", 0.6f).floatValue();
        this.useduration = JsonUtil.getIfExists(obj, "UseDuration", 32).intValue();
        this.wolffood = JsonUtil.getIfExists(obj, "WolfFood", false);
        this.drinkable = JsonUtil.getIfExists(obj, "Drinkable", false);
        this.alwaysedible = JsonUtil.getIfExists(obj, "AlwaysEdible", false);
		//
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
		this.item = new ConsumableItem(this); return this;
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
	
	public ConsumableItem getConsumableItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
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

	public void registerIntoOreDictionary(){
        if(getOreDictionaryId() != null) OreDictionary.registerOre(getOreDictionaryId(), item); else return;
	}
	
	//

    public int getHealAmount(){
        return healamount;
    }

    public float getSaturation(){
        return saturation;
    }

    public int getItemUseDuration(){
        return useduration;
    }

    public boolean isWolfFood(){
        return wolffood;
    }

    public boolean isDrinkable(){
        return drinkable;
    }

    public boolean isAlwaysEdible(){
        return alwaysedible;
    }

	@Override
	public String getCreativeTab(){
		return ctab;
	}

}
