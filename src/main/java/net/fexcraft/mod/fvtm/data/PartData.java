package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class PartData extends DataCore<Part, PartData> {
	
	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();

	public PartData(Part type){
		super(type);
		for(Attribute<?> attr : type.getAttributes()){
			if(!attr.getTarget().startsWith("self")) continue;
			Attribute<?> copy = attr.clone(); attributes.put(copy.getId(), copy);
		}
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Part", type.getRegistryName().toString());
		//
		return compound;
	}

	@Override
	public PartData read(NBTTagCompound compound){
		if(!compound.hasKey("Part")) return null;
		type = Resources.getPart(compound.getString("Part"));
		if(type == null) return null;//TODO add "placeholder" for "missing" items
		//
		return this;
	}

	@Override
	public PartData parse(JsonObject obj){
		ResourceLocation regname = DataUtil.getRegistryName("Part", obj);
		if(regname == null || Resources.getPart(regname) == null) return null;
		this.type = Resources.getPart(regname);
		//
		return this;
	}

	@Override
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Part", type.getRegistryName().toString());
		//
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public <ATTR extends Attribute<?>> ATTR getAttribute(String id){
		return (ATTR)attributes.get(id);
	}
	
	public TreeMap<String, Attribute<?>> getAttributes(){
		return attributes;
	}

}
