package net.fexcraft.mod.fvtm.sys.tsign;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class TrafficSignCapability implements TrafficSigns {
	
	private ConcurrentHashMap<BlockPos, TrafficSignData> signs = new ConcurrentHashMap<>();
	private Chunk chunk;

	public TrafficSignCapability setChunk(Chunk chunk){
		this.chunk = chunk;
		return this;
	}

	@Override
	public NBTBase write(EnumFacing side){
		NBTTagCompound compound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		for(Entry<BlockPos, TrafficSignData> entry : signs.entrySet()){
			NBTTagCompound com = entry.getValue().write();
			com.setLong("pos", entry.getKey().toLong());
			list.appendTag(com);
		}
		compound.setTag("signs", list);
		return new NBTTagCompound();
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){
		if(compound == null || !compound.hasKey("signs")) return;
		NBTTagList list = (NBTTagList)compound.getTag("signs");
		for(NBTBase base : list){
			NBTTagCompound com = (NBTTagCompound)base;
			BlockPos pos = BlockPos.fromLong(com.getLong("pos"));
			TrafficSignData data = new TrafficSignData().read(com);
			signs.put(pos, data);
		}
	}

	@Override
	public void sync(boolean side){
		//
	}

	@Override
	public ItemStack signToItem(BlockPos position){
		//
		return null;
	}

	@Override
	public Map<BlockPos, TrafficSignData> getSigns(){
		return signs;
	}
	
	public Chunk getChunk(){
		return chunk;
	}

	@Override
	public TrafficSignData getSign(BlockPos pos, boolean create){
		if(create && !signs.contains(pos)){
			signs.put(pos, new TrafficSignData());
		}
		return signs.get(pos);
	}

	@Override
	public TrafficSignData getSign(int x, int y, int z, boolean create){
		return getSign(new BlockPos(x, y, z), create);
	}

}
