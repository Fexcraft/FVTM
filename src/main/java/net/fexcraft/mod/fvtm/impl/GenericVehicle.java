package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.DriveType;
import net.fexcraft.mod.fvtm.api.EntityType;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.model.vehicle.EmptyVehicleModel;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericVehicle implements Vehicle {
	
	private ResourceLocation registryname, def_key;
	private Addon addon;
	private String name;
	private String[] description;
	private float yoffset, wheeloffset;
	private List<ResourceLocation> textures;
	private TreeMap<String, ResourceLocation> preinstalled = new TreeMap<String, ResourceLocation>();
	private List<String> required;
	@SideOnly(Side.CLIENT) private VehicleModel<VehicleData> model;
	private List<Pos> wheelpos;
	private RGB primary, secondary;
	private int constructionlength;
	private DriveType drivetype;
	private VehicleType type;
	private ArrayList<EntityType> accentmods = new ArrayList<EntityType>();
	private boolean isTrailer;
	//Sound
	private TreeMap<String, ResourceLocation> sounds = new TreeMap<String, ResourceLocation>();
	private TreeMap<ResourceLocation, SoundEvent> soundevents = new TreeMap<ResourceLocation, SoundEvent>();
	private TreeMap<String, Integer> soundlenghts = new TreeMap<String, Integer>();
	//FM
	private float cameradis, maxposthrottle, maxnegthrottle, turnleftmod, turnrightmod, wheelspringstrength, wheelstepheight, bouyancy;
	
	@SuppressWarnings("unchecked")
	public GenericVehicle(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj, "LANDVEHICLE");
		this.addon = DataUtil.getAddon(registryname, obj, "LANDVEHICLE");
		this.name = JsonUtil.getIfExists(obj, "FullName", registryname);
		this.description = DataUtil.getDescription(obj);
		this.textures = DataUtil.getTextures(obj, registryname, "LANDVEHICLE");
		this.yoffset = JsonUtil.getIfExists(obj, "ConstructionYOffSet", 0).floatValue();
		this.constructionlength = JsonUtil.getIfExists(obj, "ConstructionLength", 4).intValue();
		this.wheeloffset = JsonUtil.getIfExists(obj, "ConstructionWheelOffset", 0).floatValue();
		//this.preinstalled = JsonUtil.jsonArrayToResourceLocationArray(JsonUtil.getIfExists(obj, "PreInstalledParts", new JsonArray()).getAsJsonArray());
		if(obj.has("PreInstalled")){
			JsonArray array = JsonUtil.getIfExists(obj, "PreInstalled", new JsonArray()).getAsJsonArray();
			array.forEach((element) -> {
				JsonObject jsn = element.getAsJsonObject();
				preinstalled.put(jsn.get("as").getAsString(), new ResourceLocation(jsn.get("part").getAsString()));
			});
		}
		this.required = JsonUtil.jsonArrayToStringArray(JsonUtil.getIfExists(obj, "RequiredParts", new JsonArray()).getAsJsonArray());
		if(Static.side().isClient()){
			this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), VehicleModel.class, EmptyVehicleModel.INSTANCE);//TODO
		}
		this.wheelpos = new ArrayList<Pos>();
		if(obj.has("WheelPos")){
			JsonArray array = obj.get("WheelPos").getAsJsonArray();
			for(JsonElement elm : array){
				if(wheelpos.size() < 4){
					wheelpos.add(Pos.fromJSON(elm.getAsJsonObject()));
				}
			}
		}
		else{
			this.wheelpos.add(new Pos(0, 0, 0));
			this.wheelpos.add(new Pos(0, 0, 0));
			this.wheelpos.add(new Pos(0, 0, 0));
			this.wheelpos.add(new Pos(0, 0, 0));
		}
		this.primary = DataUtil.getRGB(obj, "PrimaryColor");
		this.secondary = DataUtil.getRGB(obj, "SecondaryColor");
		this.drivetype = DriveType.fromString(JsonUtil.getIfExists(obj, "DriveType", "fwd"));
		//FM
		this.cameradis = JsonUtil.getIfExists(obj, "FM-CameraDistance", 5f).floatValue();
		this.maxposthrottle = JsonUtil.getIfExists(obj, "FM-MaxPositiveThrottle", 1f).floatValue();
		this.maxnegthrottle = JsonUtil.getIfExists(obj, "FM-MaxNegativeThrottle", 0.2f).floatValue();
		this.turnleftmod = JsonUtil.getIfExists(obj, "FM-TurnLeftModifier", 1f).floatValue();
		this.turnrightmod = JsonUtil.getIfExists(obj, "FM-TurnRightModifier", 1f).floatValue();
		this.wheelspringstrength = JsonUtil.getIfExists(obj, "FM-WheelSpringStrength", 0.25f).floatValue();
		this.wheelstepheight = JsonUtil.getIfExists(obj, "FM-WheelStepHeight", 1f).floatValue();
		if(obj.has("Recipes")){
			obj.get("Recipes").getAsJsonArray().forEach((elm) -> {
				try{
					RecipeObject.parse(this.getItemStack(this.getDataClass().getConstructor(Vehicle.class).newInstance(this)), elm.getAsJsonObject(), "FVTM:Vehicles");
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
		this.isTrailer = JsonUtil.getIfExists(obj, new String[]{"Trailer", "Wagon", "IsTrailer"}, false);
		this.type = VehicleType.fromJson(obj);
		this.bouyancy = JsonUtil.getIfExists(obj, "Bouyancy", 0.0165F).floatValue();
		this.def_key = new ResourceLocation(JsonUtil.getIfExists(obj,"DefaultKey", "generic:key"));
		//
		{ accentmods.add(EntityType.INTERNAL); accentmods.add(EntityType.PROTOTYPE); }
	}

	@Override
	public Vehicle setRegistryName(ResourceLocation name){
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
	public ItemStack getItemStack(VehicleData data){
		ItemStack stack = new ItemStack(GenericVehicleItem.INSTANCE);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(VehicleItem.NBTKEY, this.getRegistryName().toString());
		if(data != null){
			data.writeToNBT(nbt);
		}
		stack.setTagCompound(nbt);
		return stack;
	}

	@Override
	public Map<String, ResourceLocation> getPreinstalledParts(){
		return preinstalled;
	}

	@Override
	public float getYAxisConstructorOffset(){
		return this.yoffset;
	}

	@Override
	public float getWheelConstructorOffset(){
		return this.wheeloffset;
	}

	@Override
	public List<ResourceLocation> getTextures(){
		return this.textures;
	}

	@Override @SideOnly(Side.CLIENT)
	public VehicleModel<VehicleData> getModel(){
		return model;
	}

	@Override
	public List<Pos> getDefaultWheelPos(){
		return wheelpos;
	}

	@Override
	public RGB getDefPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getDefSecondaryolor(){
		return secondary;
	}

	@Override
	public List<String> getRequiredParts(){
		return this.required;
	}

	@Override
	public int getConstructionLength(){
		return constructionlength;
	}

	@Override
	public Class<? extends VehicleData> getDataClass(){
		return GenericVehicleData.class;
	}

	@Override
	public DriveType getDriveType(){
		return drivetype;
	}

	@Override
	public float getFMCameraDistance(){
		return this.cameradis;
	}

	@Override
	public float getFMWheelStepHeight(){
		return this.wheelstepheight;
	}

	@Override
	public float getFMMaxNegativeThrottle(){
		return this.maxnegthrottle;
	}

	@Override
	public float getFMMaxPositiveThrottle(){
		return this.maxposthrottle;
	}

	@Override
	public float getFMTurnLeftModifier(){
		return this.turnleftmod;
	}

	@Override
	public float getFMTurnRightModifier(){
		return this.turnrightmod;
	}

	@Override
	public float getFMWheelSpringStrength(){
		return this.wheelspringstrength;
	}

	@Override
	public boolean canSpawnAs(EntityType type){
		return this.accentmods.contains(type);
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
		this.soundevents.put(sound, soundevent);
	}

	@Override
	public int getFMSoundLength(String event){
		return this.soundlenghts.get(event);
	}

	@Override
	public boolean isTrailerOrWagon(){
		return isTrailer;
	}

	@Override
	public ResourceLocation getDefaultKey(){
		return def_key;
	}

	@Override
	public VehicleType getType(){
		return type;
	}

	@Override
	public double getBuoyancy(){
		return bouyancy;
	}
	
}