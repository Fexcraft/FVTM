package net.fexcraft.mod.fvtm.impl;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericConsumable implements Consumable {
	
	private ResourceLocation registryname;
	private Addon addon;
	private String name;
	private String[] description;
	//
	private int healamount, useduration;
	private float saturation;
	private boolean wolfmeat, drinkable, alwaysedible;
	
	public GenericConsumable(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "CONSUMABLE");
		this.addon = DataUtil.getAddon(registryname, obj, "CONSUMABLE");
		this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
		this.description = DataUtil.getDescription(obj);
		//
		this.healamount = JsonUtil.getIfExists(obj, "HealAmount", 1).intValue();
		this.saturation = JsonUtil.getIfExists(obj, "Saturation", 0.6f).floatValue();
		this.useduration = JsonUtil.getIfExists(obj, "UseDuration", 32).intValue();
		this.wolfmeat = JsonUtil.getIfExists(obj, "WolfMeat", false);
		this.drinkable = JsonUtil.getIfExists(obj, "Drinkable", false);
		this.alwaysedible = JsonUtil.getIfExists(obj, "AlwaysEdible", false);
	}

	@Override
	public Consumable setRegistryName(ResourceLocation name){
		this.registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Addon getAddon(){
		return addon;
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String[] getDescription(){
		return description;
	}

	@Override
	public ItemStack getItemStack(){
		ItemStack stack = new ItemStack(GenericConsumableItem.INSTANCE);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString(Consumable.ConsumableItem.NBTKEY, this.getRegistryName().toString());
		stack.setTagCompound(compound);
		return stack;
	}

	@Override
	public int getHealAmount(){
		return healamount;
	}

	@Override
	public float getSaturation(){
		return saturation;
	}

	@Override
	public int getItemUseDuration(){
		return useduration;
	}

	@Override
	public boolean isWolfMeat(){
		return wolfmeat;
	}

	@Override
	public boolean isDrinkable(){
		return drinkable;
	}

	@Override
	public boolean alwaysEdible(){
		return alwaysedible;
	}
	
}