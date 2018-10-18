package net.fexcraft.mod.fvtm.impl.pallet;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Pallet;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericPallet implements Pallet {

    private ResourceLocation registryname;
    private Addon addon;
    private String name;
    private String[] description;
    //
    private Block block;
    private ResourceLocation blockid;

    public GenericPallet(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "PART");
        this.addon = DataUtil.getAddon(registryname, obj, "PART");
        this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
        this.description = DataUtil.getDescription(obj);
        this.blockid = new ResourceLocation(JsonUtil.getIfExists(obj, "block", "fvtm:pallet"));
    }

    public GenericPallet(Block block, ResourceLocation regname){
		this.registryname = regname;
		this.addon = FVTM.INTERNAL_ADDON;
		this.name = "FVTM Pallet";
		this.description = new String[]{ regname.getResourcePath() };
		this.block = block; this.blockid = block.getRegistryName();
	}

	@Override
    public Pallet setRegistryName(ResourceLocation name){
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
    public ItemStack getItemStack(PalletData data){
    	ItemStack stack = new ItemStack(Item.getItemFromBlock(net.fexcraft.mod.fvtm.blocks.Pallet.byRegistryName(registryname)));
    	stack.setTagCompound(data.writeToNBT(new NBTTagCompound()));
    	return stack;
    }

	@Override
	public Class<? extends PalletData> getDataClass(){
		return GenericPalletData.class;
	}

	@Override
	public Block getBlock(){
		return block == null ? Block.REGISTRY.getObject(blockid) : block;
	}

}
