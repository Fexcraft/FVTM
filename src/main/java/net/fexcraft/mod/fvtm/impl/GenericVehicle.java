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
    private TreeMap<String, Pos> wheel_coords = new TreeMap<>();
    private List<String> required;
    @SideOnly(Side.CLIENT)
    private VehicleModel<VehicleData> model;
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
    private TreeMap<String, Float> soundvolumes = new TreeMap<String, Float>();
    private TreeMap<String, Float> soundpitch = new TreeMap<String, Float>();
    //FM
    private float cameradis, maxposthrottle, maxnegthrottle, turnleftmod, turnrightmod, wheelspringstrength, wheelstepheight, bouyancy;

    @SuppressWarnings("unchecked")
    public GenericVehicle(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "VEHICLE");
        this.addon = DataUtil.getAddon(registryname, obj, "VEHICLE");
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
                String event = jsn.get("event").getAsString();
                this.sounds.put(event, new ResourceLocation(jsn.get("sound").getAsString()));
                if(jsn.has("volume")){
                    this.soundvolumes.put(event, jsn.get("volume").getAsFloat());
                }
                if(jsn.has("pitch")){
                    this.soundpitch.put(event, jsn.get("pitch").getAsFloat());
                }
            }
        }
        this.isTrailer = JsonUtil.getIfExists(obj, new String[]{"Trailer", "Wagon", "IsTrailer"}, false);
        this.type = VehicleType.fromJson(obj);
        this.bouyancy = JsonUtil.getIfExists(obj, "Bouyancy", 0.0165F).floatValue();
        this.def_key = new ResourceLocation(JsonUtil.getIfExists(obj, "DefaultKey", "generic:key"));
        if(obj.has("WheelCoords")){
            JsonArray array = obj.get("WheelCoords").getAsJsonArray();
            for(JsonElement elm : array){
                JsonObject jsn = elm.getAsJsonObject();
                String str = jsn.get("id").getAsString();
                Pos pos = Pos.fromJSON(jsn);
                this.wheel_coords.put(str, pos);
            }
        }
        else{
            this.wheel_coords.put("left_front_wheel", new Pos(0, 0, 0));
            this.wheel_coords.put("right_front_wheel", new Pos(0, 0, 0));
            this.wheel_coords.put("left_back_wheel", new Pos(0, 0, 0));
            this.wheel_coords.put("right_back_wheel", new Pos(0, 0, 0));
        }
        //
        {
            accentmods.add(EntityType.INTERNAL);
            accentmods.add(EntityType.PROTOTYPE);
        }
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

    @Override
    @SideOnly(Side.CLIENT)
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
    public boolean canSpawnAs(EntityType type){
        return this.accentmods.contains(type);
    }

    @Override
    public Collection<ResourceLocation> getSounds(){
        return this.sounds.values();
    }

    @Override
    public SoundEvent getSound(String event){
        ResourceLocation loc = sounds.get(event);
        return loc == null ? null : this.soundevents.get(loc);
    }

    @Override
    public void setSoundEvent(SoundEvent soundevent){
        this.soundevents.put(soundevent.getRegistryName(), soundevent);
    }

    @Override
    public float getSoundVolume(String event){
        return soundvolumes.get(event) == null ? 0.5f : soundvolumes.get(event);
    }

    @Override
    public float getSoundPitch(String event){
        return soundpitch.get(event) == null ? 1.0f : soundpitch.get(event);
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

    @Override
    public TreeMap<String, Pos> getWheelPositions(){
        return wheel_coords;
    }

    @Override
    public float getFMAttribute(String attr){
        switch(attr){
            case "camera_distance": return cameradis;
            case "wheel_step_height": return wheelstepheight;
            case "max_negative_throttle": return maxnegthrottle;
            case "max_positive_throttle": return maxposthrottle;
            case "turn_left_modifier": return turnleftmod;
            case "turn_right_modifier": return turnrightmod;
            case "wheel_spring_strength": return wheelspringstrength;
        }
        return 0f;
    }

}
