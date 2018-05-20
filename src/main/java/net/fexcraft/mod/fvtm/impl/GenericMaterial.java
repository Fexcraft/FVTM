package net.fexcraft.mod.fvtm.impl;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericMaterial implements Material {

    private ResourceLocation registryname;
    private Addon addon;
    private String name;
    private String[] description;
    //
    private boolean isFuelContainer, isKey;
    private Integer maxcapacity;
    private Fuel fueltype;

    public GenericMaterial(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "MATERIAL");
        this.addon = DataUtil.getAddon(registryname, obj, "MATERIAL");
        this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
        this.description = DataUtil.getDescription(obj);
        this.isFuelContainer = obj.has("FuelType");
        if(this.isFuelContainer){
            this.fueltype = Resources.FUELS.getValue(new ResourceLocation(JsonUtil.getIfExists(obj, "FuelType", "minecraft:stone")));
            this.maxcapacity = JsonUtil.getIfExists(obj, "MaxCapacity", 100).intValue();
        }
        this.isKey = JsonUtil.getIfExists(obj, "VehicleKey", false);
        if(obj.has("Recipes")){
            obj.get("Recipes").getAsJsonArray().forEach((elm) -> {
                try{
                    RecipeObject.parse(this.getItemStack(), elm.getAsJsonObject(), "FVTM:Materials");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public Material setRegistryName(ResourceLocation name){
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
        ItemStack stack = new ItemStack(GenericMaterialItem.INSTANCE);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(MaterialItem.NBTKEY, this.getRegistryName().toString());
        if(this.isFuelContainer){
            nbt.setDouble("FuelContent", 0);
        }
        if(this.isKey){
            nbt.setBoolean("VehicleKeyType", false);
            nbt.setString("VehicleKeyCode", KeyItem.getNewKeyCode());
            nbt.setString("VehicleKeyCreator", Static.NULL_UUID_STRING);
        }
        stack.setTagCompound(nbt);
        return stack;
    }

    @Override
    public boolean isFuelContainer(){
        return this.isFuelContainer;
    }

    @Override
    public int maxCapacity(){
        return maxcapacity == null ? 0 : maxcapacity;
    }

    @Override
    public boolean isVehicleKey(){
        return isKey;
    }

    @Override
    public Fuel getFuelType(){
        return fueltype;
    }

}
