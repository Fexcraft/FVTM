package net.fexcraft.mod.fvtm.impl;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Attribute.AttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.impl.root.GenericTextureable;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.nbt.NBTTagCompound;

public class GenericPartData extends GenericTextureable<PartData, Part> implements PartData {

    private Pos offset;
    private HashMap<Class<?>, AttributeData> attributes = new HashMap<Class<?>, AttributeData>();

    public GenericPartData(Part part){
        super(part);
    }

    @Override
    public Part getPart(){
        return root;
    }

    @Override
    public Pos getCurrentOffset(){
        return offset;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
        tagcompound.setString(PartItem.NBTKEY, root.getRegistryName().toString());
        NBTTagCompound compound = new NBTTagCompound();
        super.writeToNBT(compound);
        //
        root.getAttributeClasses().forEach((clazz) -> {
            Attribute attr = root.getAttribute(clazz);
            if(attr.hasDataClass()){
                AttributeData data = this.attributes.get(attr.getDataClass());
                if(data != null){
                    data.writeToNBT(this, compound);
                }
            }
        });
        tagcompound.setTag(FVTM.MODID + "_part", offset == null ? compound : offset.toNBT("Offset", compound));
        return tagcompound;
    }

    @Override
    public PartData readFromNBT(NBTTagCompound compound){
        compound = compound.getCompoundTag(FVTM.MODID + "_part");
        super.readFromNBT(compound);
        offset = Pos.fromNBT("Offset", compound);
        NBTTagCompound[] tagc = new NBTTagCompound[]{compound};
        root.getAttributeClasses().forEach((clazz) -> {
            Attribute attr = root.getAttribute(clazz);
            if(attr.hasDataClass()){
                try{
                    this.attributes.put(attr.getDataClass(), attr.getDataClass().getConstructor(PartData.class, Attribute.class).newInstance(this, attr).readFromNBT(this, tagc[0]));
                }
                catch(Exception e){
                    Print.debug(root.getRegistryName().toString(), clazz);
                    e.printStackTrace();
                }
            }
        });
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends AttributeData> T getAttributeData(Class<T> clazz){
        return (T) attributes.get(clazz);
    }

}
