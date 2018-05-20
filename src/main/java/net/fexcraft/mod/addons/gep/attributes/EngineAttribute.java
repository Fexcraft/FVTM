package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EngineAttribute implements Attribute {

    private float enginespeed;
    private float fuelconsumption;
    private Fuel fueltype;
    private EngineType type;

    @Override
    public ResourceLocation getRegistryName(){
        return new ResourceLocation("engine");
    }

    @Override
    public void load(JsonObject obj){
        this.enginespeed = JsonUtil.getIfExists(obj, "Engine-Speed", 0.5f).floatValue();
        this.fuelconsumption = JsonUtil.getIfExists(obj, "Fuel-Consumption", 0.5f).floatValue();
        this.fueltype = Resources.FUELS.getValue(new ResourceLocation(JsonUtil.getIfExists(obj, "Fuel-Type", "gasoline")));
        this.type = EngineType.fromString(JsonUtil.getIfExists(obj, "Engine-Type", EngineType.COMBUSTION.name()));
    }

    @Override
    public String getName(){
        return "Engine";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
        tooltip.add(Formatter.format("&9Speed: &7" + enginespeed));
        tooltip.add(Formatter.format("&9Compsumption: &7" + fuelconsumption));
        tooltip.add(Formatter.format("&9Type: &7" + type.getFancyName()));
        tooltip.add(Formatter.format("&9Fuel: &7" + fueltype.getName()));
    }

    public float getFuelCompsumption(){
        return fuelconsumption;
    }

    public Fuel getFuelType(){
        return fueltype;
    }

    public float getEngineSpeed(){
        return enginespeed;
    }

    @Override
    public boolean hasDataClass(){
        return true;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return EngineAttributeData.class;
    }

    public static class EngineAttributeData implements AttributeData {

        private boolean isOn;

        public EngineAttributeData(PartData data, Attribute attr){
            this.isOn = false;
        }

        @Override
        public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
            compound.setBoolean("EngineOn", isOn);
            return compound;
        }

        @Override
        public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
            this.isOn = compound.hasKey("EngineOn") ? compound.getBoolean("EngineOn") : this.isOn;
            return this;
        }

        public boolean isOn(){
            return this.isOn;
        }

        public boolean toggle(){
            return this.isOn = !this.isOn;
        }

        public boolean setOn(boolean bool){
            return this.isOn = bool;
        }

    }

    public static enum EngineType {

        COMBUSTION("Combustion Engine"), STEAM("Steam Engine"), ELECTRIC("Electric Engine"), Illusionary("Illusionary Engine");

        private String name;

        EngineType(String str){
            str = name;
        }

        public static EngineType fromString(String string){
            for(EngineType type : values()){
                if(type.name().toLowerCase().equals(string.toLowerCase())){
                    return type;
                }
            }
            return Illusionary;
        }

        public String getName(){
            return this.getFancyName();
        }

        public String getFancyName(){
            return name;
        }
    }

}
