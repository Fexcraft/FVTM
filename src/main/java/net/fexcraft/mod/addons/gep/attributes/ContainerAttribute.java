package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ContainerAttribute implements Attribute {

    private static final ResourceLocation regname = new ResourceLocation("container");
    private ContainerType type;
    private float rotation;
    private Pos offset;

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
        type = ContainerType.valueOf(JsonUtil.getIfExists(obj, "Container-Type", ContainerType.MEDIUM.name()).toUpperCase());
        offset = Pos.fromJSON(JsonUtil.getIfExists(obj, "Container-Offset", new JsonObject()).getAsJsonObject());
        rotation = JsonUtil.getIfExists(obj, "Container-Rotation", 0f).floatValue();
    }

    @Override
    public String getName(){
        return "Container Holder";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
        tooltip.add(Formatter.format("&9Container Type: &7" + type.name()));
    }

    @Override
    public boolean hasDataClass(){
        return true;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return ContainerAttributeData.class;
    }

    public Pos getContainerOffset(){
        return offset;
    }

    public float getContainerRotation(){
        return rotation;
    }

    public ContainerType getContainerType(){
        return type;
    }

    public static class ContainerAttributeData implements AttributeData {

        private Attribute root;
        public ContainerData main, second;

        public ContainerAttributeData(PartData data, Attribute attr){
            root = attr;
        }

        @Override
        public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
            if(main != null){
                compound.setTag("Container1", main.writeToNBT(new NBTTagCompound()));
            }
            if(second != null){
                compound.setTag("Container2", second.writeToNBT(new NBTTagCompound()));
            }
            return compound;
        }

        @Override
        public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
            main = compound.hasKey("Container1") ? Resources.getContainerData(compound.getCompoundTag("Container1")) : null;
            second = compound.hasKey("Container2") ? Resources.getContainerData(compound.getCompoundTag("Container2")) : null;
            return this;
        }

        public ContainerData getContainer(ContainerPosition pos){
            return pos == ContainerPosition.MEDIUM_DUAL2 ? second : main;
        }

        public ContainerAttribute getAttribute(){
            return (ContainerAttribute) root;
        }

    }

	@Override
	public boolean hasRenderData(){
		return false;
	}

}
