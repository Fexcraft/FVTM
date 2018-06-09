package net.fexcraft.mod.fvtm.impl.caps;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;

public class BlockChunkImplementation implements BlockChunk {
	
	private TreeMap<BlockPos, BlockData> blocks = new TreeMap<>();
	private Chunk chunk;

	@Override
	public void setChunk(Chunk chunk){
		this.chunk = chunk;
	}

	@Override
	public Chunk getChunk(){
		return chunk;
	}

	@Override
	public NBTBase writeToNBT(Capability<BlockChunk> capability, BlockChunk instance, EnumFacing side){
		NBTTagCompound compound = new NBTTagCompound();
		if(blocks.size() > 0){
			NBTTagList list = new NBTTagList();
			for(Entry<BlockPos, BlockData> entry : blocks.entrySet()){
				NBTTagCompound tagc = entry.getValue().writeToNBT(new NBTTagCompound());
				tagc.setLong("BlockPos", entry.getKey().toLong());
				list.appendTag(tagc);
			}
			compound.setTag("Blocks", list);
		}
		return compound;
	}

	@Override
	public void readFromNBT(Capability<BlockChunk> capability, BlockChunk instance, EnumFacing side, NBTBase nbt){
		if(nbt == null){ return; }
		blocks.clear();
		NBTTagCompound compound = (NBTTagCompound)nbt;
		if(compound.hasKey("Blocks")){
			NBTTagList list = (NBTTagList)compound.getTag("Blocks");
			for(NBTBase base : list){
				try{
					NBTTagCompound tagc = (NBTTagCompound)base;
					BlockPos pos = BlockPos.fromLong(tagc.getLong("BlockPos"));
					BlockData data = Resources.getBlockData(tagc);
					if(data != null){
						blocks.put(pos, data);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public BlockData getBlockDataFor(BlockPos corepos){
		return blocks.get(corepos);
	}

	@Override
	public void setBlockAt(@Nullable BlockData data, BlockPos pos){
		if(data == null){
			Print.debug("Removing block data for " + pos.toString() + "!");
			blocks.remove(pos);
		}
		else{
			Print.debug("Setting block data for " + pos.toString() + "!", data);
			blocks.put(pos, data);
		}
	}

	@Override
	public Map<BlockPos, BlockData> getAllBlockData(){
		return blocks;
	}

}
