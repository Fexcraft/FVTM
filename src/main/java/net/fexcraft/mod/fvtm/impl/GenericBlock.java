package net.fexcraft.mod.fvtm.impl;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericBlock implements Block {

    private ResourceLocation registryname;
    private Addon addon;
    private Model<BlockData, BlockTileEntity> model;
    private List<ResourceLocation> textures;
    private String[] description;
    private String name;
    private RGB primary, secondary;
    private boolean functional;
    private Class<? extends BlockScript<?>> clazz;

    @SuppressWarnings("unchecked")
	public GenericBlock(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "CONTAINER");
        this.addon = DataUtil.getAddon(registryname, obj, "CONTAINER");
        if(Static.side().isClient()){
            this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), BlockData.class, BlockTileEntity.class, BlockModel.class);
        }
        this.name = JsonUtil.getIfExists(obj, "FullName", this.getRegistryName().toString());
        this.textures = DataUtil.getTextures(obj, registryname, "CONTAINER");;
        this.description = DataUtil.getDescription(obj);
        this.primary = DataUtil.getRGB(obj, "PrimaryColor");
        this.secondary = DataUtil.getRGB(obj, "SecondaryColor");
        this.functional = JsonUtil.getIfExists(obj, "Functional", false);
        if(obj.has("Script")){
        	try{
        		clazz = (Class<? extends BlockScript<?>>)Class.forName(obj.get("Script").getAsString().replace(".class", ""));
        	}
        	catch(Exception e){
				e.printStackTrace();
			}
        }
    }

    @Override
    public Block setRegistryName(ResourceLocation name){
        this.registryname = name;
        return this;
    }

    @Override
    public ResourceLocation getRegistryName(){
        return this.registryname;
    }

    @Override
    public Model<BlockData, BlockTileEntity> getModel(){
        return model;
    }

    @Override
    public Class<? extends BlockData> getDataClass(){
        return GenericBlockData.class;
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
    public List<ResourceLocation> getTextures(){
        return textures;
    }

    @Override
    public Addon getAddon(){
        return addon;
    }

    @Override
    public ItemStack getItemStack(BlockData data){
        ItemStack stack = new ItemStack(GenericBlockItem.INSTANCE);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(BlockItem.NBTKEY, this.getRegistryName().toString());
        if(data != null){
            data.writeToNBT(nbt);
        }
        stack.setTagCompound(nbt);
        return stack;
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
	public boolean isFunctional(){
		return functional;
	}

	@Override
	public Class<? extends BlockScript<?>> getScriptClass(){
		return clazz;
	}

}
