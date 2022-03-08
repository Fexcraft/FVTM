package net.fexcraft.mod.fvtm.sys.tsign;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.item.TrafficSignItem;
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
	public NBTTagCompound write(EnumFacing side){
		NBTTagCompound compound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		for(Entry<BlockPos, TrafficSignData> entry : signs.entrySet()){
			NBTTagCompound com = entry.getValue().write();
			com.setLong("pos", entry.getKey().toLong());
			list.appendTag(com);
		}
		compound.setTag("signs", list);
		return compound;
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){
		if(compound == null || !compound.hasKey("signs")) return;
		NBTTagList list = (NBTTagList)compound.getTag("signs");
		for(NBTBase base : list){
			NBTTagCompound com = (NBTTagCompound)base;
			BlockPos pos = BlockPos.fromLong(com.getLong("pos"));
			TrafficSignData data = new TrafficSignData(pos).read(com);
			signs.put(pos, data);
		}
	}

	@Override
	public ItemStack signToItem(BlockPos position){
		//
		return new ItemStack(TrafficSignItem.INSTANCE);
	}

	@Override
	public Map<BlockPos, TrafficSignData> getSigns(){
		return signs;
	}
	
	public Chunk getChunk(){
		return chunk;
	}

	@Override
	public TrafficSignData getSign(BlockPos pos){
		/*if(create && !signs.containsKey(pos)){
			signs.put(pos, new TrafficSignData(pos));
		}*/
		return signs.get(pos);
	}

	@Override
	public TrafficSignData getSign(int x, int y, int z){
		return getSign(new BlockPos(x, y, z));
	}

	@Override
	public TrafficSignData remove(BlockPos pos){
		TrafficSignData data = signs.remove(pos);
		if(data != null && !chunk.getWorld().isRemote){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", "fvtm:utils");
			compound.setString("task", "ts_removed");
			compound.setLong("pos", pos.toLong());
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
		}
		return data;
	}

	@Override
	public void addSignAt(BlockPos pos, float rot, float off, boolean client){
		Print.debug(pos, rot, off, client);
		if(!signs.containsKey(pos)){
			signs.put(pos, new TrafficSignData(pos, rot, off));
		}
		else return;
		if(client) return;
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", "fvtm:utils");
		compound.setString("task", "ts_added");
		compound.setLong("pos", pos.toLong());
		compound.setFloat("rotation", rot);
		compound.setFloat("offset", off);
		PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
	}

}
