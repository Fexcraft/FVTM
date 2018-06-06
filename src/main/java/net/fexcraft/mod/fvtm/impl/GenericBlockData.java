package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.impl.root.GenericColorable;
import net.minecraft.nbt.NBTTagCompound;

public class GenericBlockData extends GenericColorable<BlockData, Block> implements BlockData {
	
	private BlockScript<?> script;

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
	}
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
        tagcompound.setString(BlockItem.NBTKEY, root.getRegistryName().toString());
        NBTTagCompound compound = new NBTTagCompound();
        super.writeToNBT(compound);
        //
        tagcompound.setTag(FVTM.MODID + "_block", compound);
        return tagcompound;
    }

    @Override
    public BlockData readFromNBT(NBTTagCompound tagcompound){
        NBTTagCompound compound = tagcompound.getCompoundTag(FVTM.MODID + "_block");
        super.readFromNBT(compound);
        //
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
	
}