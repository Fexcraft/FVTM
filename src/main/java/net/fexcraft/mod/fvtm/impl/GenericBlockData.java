package net.fexcraft.mod.fvtm.impl;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.impl.root.GenericColorable;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.ItemStackHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

public class GenericBlockData extends GenericColorable<BlockData, Block> implements BlockData {
	
	private BlockScript<?> script;
	private TreeMap<String, IFluidHandler> tanks;
	private TreeMap<String, IItemHandler> inventories;
	private TreeMap<String, NonNullList<ItemStack>> stacks;

	public GenericBlockData(Block block){
		super(block);
		if(block.getScriptClass() != null){
			try{
				script = block.getScriptClass().newInstance();
			}
			catch(InstantiationException | IllegalAccessException e){
				e.printStackTrace();
			}
		}
		if(block.getFluidTanks().size() > 0){
			tanks = new TreeMap<>();
			block.getFluidTanks().forEach((key, value) -> {
				tanks.put(key, new FluidTank(value));
			});
		}
		if(block.getInventories().size() > 0){
			inventories = new TreeMap<>();
			stacks = new TreeMap<>();
			block.getInventories().forEach((key, value) -> {
				NonNullList<ItemStack> list = NonNullList.withSize(value, ItemStack.EMPTY);
				stacks.put(key, list);
				if(key.endsWith("_out")){
					inventories.put(key, new net.minecraftforge.items.ItemStackHandler(list));
				}
				else{
					inventories.put(key, new ItemStackHandler(list));
				}
			});
		}
	}
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
        tagcompound.setString(BlockItem.NBTKEY, root.getRegistryName().toString());
        NBTTagCompound compound = new NBTTagCompound();
        super.writeToNBT(compound);
        this.getFluidTanks().forEach((key, value) -> {
        	NBTTagCompound tag = ((FluidTank)value).writeToNBT(new NBTTagCompound());
        	if(tag != null){
        		compound.setTag("FluidTank_" + key, tag);
        	}
        });
        this.getInventories().forEach((key, value) -> {
        	NBTTagCompound tag = DataUtil.saveAllItems(new NBTTagCompound(), stacks.get(key), false);
        	if(tag != null && !tag.hasNoTags()){
        		compound.setTag("ItemStacks_" + key, tag);
        	}
        });
        tagcompound.setTag(FVTM.MODID + "_block", compound);
        return tagcompound;
    }

    @Override
    public BlockData readFromNBT(NBTTagCompound tagcompound){
        NBTTagCompound compound = tagcompound.getCompoundTag(FVTM.MODID + "_block");
        super.readFromNBT(compound);
        this.getFluidTanks().forEach((key, value) -> {
        	if(compound.hasKey("FluidTank_" + key)){
        		((FluidTank)this.tanks.get(key)).readFromNBT(compound.getCompoundTag("FluidTank_" + key));
        	}
        });
        this.getInventories().forEach((key, value) -> {
        	if(compound.hasKey("ItemStacks_" + key)){
        		DataUtil.loadAllItems(compound.getCompoundTag("ItemStacks_" + key), this.stacks.get(key));
				if(key.endsWith("_out")){
					inventories.put(key, new net.minecraftforge.items.ItemStackHandler(this.stacks.get(key)));
				}
				else{
					inventories.put(key, new ItemStackHandler(this.stacks.get(key)));
				}
        	}
        });
        return this;
    }

	@Override
	public Block getBlock(){
		return root;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BlockScript<?>> T getScript(){
		return (T)script;
	}
	
	@Override
	public String toString(){
		return this.writeToNBT(new NBTTagCompound()).toString();
	}

	@Override
	public Map<String, IFluidHandler> getFluidTanks(){
		return tanks == null ? Collections.emptyMap() : tanks;
	}

	@Override
	public Map<String, IItemHandler> getInventories(){
		return inventories == null ? Collections.emptyMap() : inventories;
	}

	@Override
	public Map<String, NonNullList<ItemStack>> getItemStacks(){
		return stacks;
	}
	
}