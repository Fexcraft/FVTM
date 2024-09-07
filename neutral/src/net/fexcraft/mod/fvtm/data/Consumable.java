package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.item.ItemWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Consumable extends Content<Consumable> implements WithItem, ItemTextureable {
	
	protected byte max_stack;
	protected ItemWrapper item;
	protected String ore_dict, container, ctab;
    private int healamount, useduration;
    private float saturation;
    private boolean wolffood, drinkable, alwaysedible;
	protected IDL itemtexloc;
	
	public Consumable(){}

	@Override
	public Consumable parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null)return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Consumable");
		description = ContentConfigUtil.getStringList(map, "Description");
		max_stack = (byte)map.getInteger("MaxItemStackSize", 64);
		ore_dict = map.getString("OreDictionary", null);
		container = map.getString("ContainerItem", null);
		//
        healamount = map.getInteger("HealAmount", 1);
        saturation = map.getFloat("Saturation", 0.6f);
        useduration = map.getInteger("UseDuration", 32);
        wolffood = map.getBoolean("WolfFood", false);
        drinkable = map.getBoolean("Drinkable", false);
        alwaysedible = map.getBoolean("AlwaysEdible", false);
		//
        ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.CONSUMABLE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	public int getMaxStack(){
		return max_stack;
	}
	
	public String getOreDictId(){
		return ore_dict;
	}

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

	@Override
	public String getItemContainer(){
		return container;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

}
