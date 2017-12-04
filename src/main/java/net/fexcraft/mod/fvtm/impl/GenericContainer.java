package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.addons.gep.models.containers.GenericContainerModel;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.compatibility.InventoryType;
import net.fexcraft.mod.fvtm.model.part.ContainerModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericContainer implements Container {
	
	private ResourceLocation registryname;
	private ContainerType type;
	private Addon addon;
	@SideOnly(Side.CLIENT) private ContainerModel<ContainerData> model;
	private List<ResourceLocation> textures;
	private String[] description;
	private String name;
	private int inventory;
	private InventoryType invtype;
	private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
	private ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();

	@SuppressWarnings("unchecked")
	public GenericContainer(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "CONTAINER");
		this.addon = DataUtil.getAddon(registryname, obj, "CONTAINER");
		this.type = ContainerType.valueOf(obj.has("Type") ? obj.get("Type").getAsString().toUpperCase() : obj.has("ContainerType") ? obj.get("ContainerType").getAsString().toUpperCase() : Container.ContainerType.MEDIUM.name());
		if(Static.side().isClient()){
			this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), ContainerModel.class, GenericContainerModel.get());
		}
		this.name = JsonUtil.getIfExists(obj, "FullName", this.getRegistryName().toString());
		this.textures = DataUtil.getTextures(obj, registryname, "CONTAINER");;
		this.description = DataUtil.getDescription(obj);
		this.inventory = JsonUtil.getIfExists(obj, "InventorySize", 4).intValue();
		this.invtype = InventoryType.fromString(JsonUtil.getIfExists(obj, "InventoryType", "item"));
		//
		if(obj.has("InventoryWhitelist")){
			obj.get("InventoryWhitelist").getAsJsonArray().forEach((elm) -> {
				JsonObject jsn = elm.getAsJsonObject();
				try{
					whitelist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		if(obj.has("InventoryBlacklist")){
			obj.get("InventoryBlacklist").getAsJsonArray().forEach((elm) -> {
				JsonObject jsn = elm.getAsJsonObject();
				try{
					blacklist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		//
	}

	@Override
	public Container setRegistryName(ResourceLocation name){
		this.registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public ContainerType getType(){
		return type;
	}

	@Override
	public ContainerModel<ContainerData> getModel(){
		return model;
	}

	@Override
	public Class<? extends ContainerData> getDataClass(){
		return GenericContainerData.class;
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
	public List<ResourceLocation> getTextures(){
		return textures;
	}

	@Override
	public int getInventorySize(){
		return inventory;
	}

	@Override
	public InventoryType getInventoryType(){
		return invtype;
	}

	@Override
	public boolean isItemValid(ItemStack stack){
		Print.debug("CHECKING");
		Print.debug(stack.toString());
		for(ItemStack itemstack : blacklist){
			if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
				if(itemstack.getMetadata() == 0 || stack.getItemDamage() == itemstack.getItemDamage()){
					return false;
				}
			}
		}
		//
		if(!whitelist.isEmpty()){
			boolean found = false;
			for(ItemStack itemstack : whitelist){
				if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
					if(itemstack.getMetadata() == 0 || stack.getItemDamage() == itemstack.getItemDamage()){
						found = true;
						break;
					}
				}
			}
			Print.debug(found);
			return found;
		}
		return true;
	}

	@Override
	public Addon getAddon(){
		return addon;
	}
	
}