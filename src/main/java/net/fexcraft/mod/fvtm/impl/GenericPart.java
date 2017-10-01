package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.model.part.NullModel;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericPart implements Part {
	
	private ResourceLocation registryname;
	private Addon addon;
	private String name;
	private String[] description, categories;
	private TreeMap<ResourceLocation, Pos> compatible = new TreeMap<ResourceLocation, Pos>();
	private TreeMap<ResourceLocation, ArrayList<ResourceLocation>> incompatible = new TreeMap<ResourceLocation, ArrayList<ResourceLocation>>();
	private ArrayList<ResourceLocation> textures;
	private boolean removable, available, adjustable;
	@SideOnly(Side.CLIENT) private PartModel model;
	private JsonObject attributedata;
	private HashMap<Class, Attribute> attributes = new HashMap<Class, Attribute>();
	private ArrayList<Class<? extends VehicleScript>> scripts = new ArrayList<Class<? extends VehicleScript>>();
	//Sound
	private TreeMap<String, ResourceLocation> sounds = new TreeMap<String, ResourceLocation>();
	private TreeMap<ResourceLocation, SoundEvent> soundevents = new TreeMap<ResourceLocation, SoundEvent>();
	private TreeMap<String, Integer> soundlenghts = new TreeMap<String, Integer>();
	
	public GenericPart(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "PART");
		this.addon = DataUtil.getAddon(registryname, obj, "PART");
		this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
		this.description = DataUtil.getDescription(obj);
		if(obj.has("Compatible")){
			JsonArray array = obj.get("Compatible").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					JsonObject jsn = elm.getAsJsonObject();
					compatible.put(new ResourceLocation(jsn.get("Vehicle").getAsString()), Pos.fromJSON(jsn));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(obj.has("Incompatible")){
			JsonArray array = obj.get("Incompatible").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					JsonObject jsn = elm.getAsJsonObject();
					ArrayList<ResourceLocation> rslist = JsonUtil.jsonArrayToResourceLocationArray(jsn.get("Parts").getAsJsonArray());
					this.incompatible.put(new ResourceLocation(jsn.get("Vehicle").getAsString()), rslist);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		this.textures = DataUtil.getTextures(obj, registryname, "PART");
		this.categories = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "Category", new JsonArray()).getAsJsonArray()).toArray(new String[]{});
		//this.attributes = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "Attributes", new JsonArray()).getAsJsonArray()).toArray(new String[]{});
		
		this.removable = JsonUtil.getIfExists(obj, "Removable", true);
		this.available = JsonUtil.getIfExists(obj, "Avaible", true);
		this.adjustable = JsonUtil.getIfExists(obj, "Adjustable", false);
		if(Static.side().isClient()){
			this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), PartModel.class, NullModel.get());
		}
		this.attributedata = JsonUtil.getIfExists(obj, "AttributeData", new JsonObject()).getAsJsonObject();
		
		JsonArray atr_array = JsonUtil.getIfExists(obj, "Attributes", new JsonArray()).getAsJsonArray();
		for(JsonElement elm : atr_array){
			try{
				Attribute attr = Resources.PARTATTRIBUTES.getValue(new ResourceLocation(elm.getAsString()));
				if(attr == null){ continue; }
				Attribute partattr = attr.getClass().newInstance();
				partattr.load(this.attributedata);
				this.attributes.put(attr.getClass(), partattr);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//
		ArrayList<Class<? extends VehicleScript>> list = new ArrayList<Class<? extends VehicleScript>>();
		ArrayList<String> json = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "Scripts", new JsonArray()).getAsJsonArray());
		for(String string : json){
			try{
				list.add((Class<? extends VehicleScript>)Class.forName(string.replace(".class", "")));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		this.scripts.addAll(list);
		//
		if(obj.has("Recipes")){
			obj.get("Recipes").getAsJsonArray().forEach((elm) -> {
				try{
					RecipeObject.parse(this.getItemStack(this.getDataClass().getConstructor(Part.class).newInstance(this)), elm.getAsJsonObject(), "FVTM:Parts");
				}
				catch(Exception e){
					e.printStackTrace();
					Static.stop();
				}
			});
		}
		if(obj.has("Sounds")){
			for(JsonElement elm : obj.get("Sounds").getAsJsonArray()){
				JsonObject jsn = elm.getAsJsonObject();
				this.sounds.put(jsn.get("event").getAsString(), new ResourceLocation(jsn.get("sound").getAsString()));
				this.soundlenghts.put(jsn.get("event").getAsString(), JsonUtil.getIfExists(jsn, "length", 0).intValue());
			}
		}
	}

	@Override
	public Part setRegistryName(ResourceLocation name){
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
	public ItemStack getItemStack(PartData data){
		ItemStack stack = new ItemStack(GenericPartItem.INSTANCE);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(PartItem.NBTKEY, this.getRegistryName().toString());
		if(data != null){
			data.writeToNBT(nbt);
		}
		stack.setTagCompound(nbt);
		return stack;
	}

	@Override
	public List<ResourceLocation> getCompatibleVehicles(){
		return new ArrayList<ResourceLocation>(compatible.keySet());
	}

	@Override
	public Pos getOffsetFor(ResourceLocation vehicle){
		return compatible.containsKey(vehicle) ? compatible.get(vehicle) : new Pos(0, 0, 0);
	}

	@Override
	public List<ResourceLocation> getTextures(){
		return textures;
	}

	@Override
	public List<String> getCategories(){
		return Arrays.asList(categories);
	}

	@Override
	public String getCategory(){
		return categories[0];
	}

	@Override
	public List<String> getAttributes(){
		return Arrays.asList(categories);
	}

	@Override
	public boolean isRemovable(){
		return removable;
	}

	@Override
	public boolean isAvailable(){
		return available;
	}

	@Override
	public boolean isAdjustable(){
		return this.adjustable;
	}

	@Override @SideOnly(Side.CLIENT)
	public PartModel getModel(){
		return model;
	}

	@Override
	public JsonObject getAttributeData(){
		return this.attributedata;
	}

	@Override
	public <T extends Attribute> T getAttribute(Class<T> clazz){
		return (T)attributes.get(clazz);
	}

	@Override
	public boolean canInstall(String as, VehicleData data, EntityPlayer player){
		if(this.compatible.containsKey(data.getVehicle().getRegistryName()) || this.compatible.containsKey(new ResourceLocation("all")) || this.compatible.isEmpty()){
			ArrayList<ResourceLocation> arr = this.incompatible.get(data.getVehicle().getRegistryName());
			if(arr == null){
				return true;
			}
			if(arr.contains(new ResourceLocation("all"))){
				Print.chat(player, "Incompatible parts installed in the vehicle.");
				return false;
			}
			for(PartData part : data.getParts().values()){
				if(arr.contains(part.getPart().getRegistryName())){
					Print.chat(player, "Incompatible parts installed in the vehicle.");
					return false;
				}
			}
			return true;
		}
		Print.chat(player, "Incompatible vehicle.");
		return false;
	}

	@Override
	public Collection<Class> getAttributeClasses(){
		return this.attributes.keySet();
	}

	@Override
	public Class<? extends PartData> getDataClass(){
		return GenericPartData.class;
	}

	@Override
	public List<Class<? extends VehicleScript>> getScripts(){
		return this.scripts;
	}

	@Override
	public Collection<ResourceLocation> getSounds(){
		return this.sounds.values();
	}

	@Override
	public SoundEvent getSound(String event){
		ResourceLocation loc = this.sounds.get(event);
		return loc == null ? null : this.soundevents.get(loc);
	}

	@Override
	public void setSound(ResourceLocation sound, SoundEvent soundevent){
		Print.debug(sound, soundevent.getRegistryName());
		this.soundevents.put(sound, soundevent);
	}

	@Override
	public int getFMSoundLength(String event){
		return this.soundlenghts.get(event);
	}
	
}