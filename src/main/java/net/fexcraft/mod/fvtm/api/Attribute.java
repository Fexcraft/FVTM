package net.fexcraft.mod.fvtm.api;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Attribute extends IForgeRegistryEntry<Attribute> {

    public void load(JsonObject obj);

    public String getName();

    public default Attribute setRegistryName(ResourceLocation name){
        return this;
    }

    public default Class<Attribute> getRegistryType(){
        return Attribute.class;
    }

    /**
     * For Item Tooltips
     */
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag);

    public boolean hasDataClass();

    public Class<? extends AttributeData> getDataClass();

    public static interface AttributeData {

        public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound);

        public AttributeData readFromNBT(PartData data, NBTTagCompound compound);

    }

}
