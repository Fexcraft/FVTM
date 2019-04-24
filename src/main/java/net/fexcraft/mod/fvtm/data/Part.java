package net.fexcraft.mod.fvtm.data;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Part extends TypeCore<Part> {
	
	protected List<String> categories;
	protected PartItem item;
	
	public Part(){}

	@Override
	public Part setRegistryName(ResourceLocation name){
		registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Part> getRegistryType(){
		return Part.class;
	}

	@Override
	public Part parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Part");
		this.categories = DataUtil.getStringArray(obj, "Category", true, true);
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		//
		this.item = new PartItem(this); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.PART;
	}

	@Override
	public Class<?> getDataClass(){
		return PartData.class;
	}

	public String getCategory(){
		return categories.isEmpty() ? null : categories.get(0);
	}
	
	public List<String> getCategories(){
		return categories;
	}
	
	public PartItem getItem(){
		return item;
	}
	
	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}

}
