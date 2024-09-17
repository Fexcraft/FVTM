package net.fexcraft.mod.fvtm.sys.wire;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.uni.world.ChunkW;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.getTargetPoint;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireRegion {
	
	private ConcurrentHashMap<BlockPos, RelayHolder> holders = new ConcurrentHashMap<>();
	public ConcurrentHashMap<RegionKey, ChunkW> chucks = new ConcurrentHashMap<>();
	public long lastaccess;
	private int timer = 0;
	public boolean loaded;
	protected final WireSystem system;
	protected final RegionKey key;

	public WireRegion(int i, int j, WireSystem root, boolean load){
		key = new RegionKey(i, j);
		system = root;
		if(load) load();
	}

	public WireRegion(BlockPos pos, WireSystem root, boolean load){
		key = new RegionKey(RegionKey.getRegionXZ(pos));
		system = root;
		if(load) load();
	}

	public WireRegion load(){
		if(system.getWorld().isClient()){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", "fvtm:wiresys");
			compound.setString("task", "update_region");
			compound.setIntArray("XZ", key.toArray());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
			return this;
		}
		File file = new File(system.getSaveRoot(), "/wireregions/" + key.x + "_" + key.z + ".dat");
		NBTTagCompound compound = null;
		boolean failed = false;
		if(file.exists()){
			try{
				compound = CompressedStreamTools.read(file);
			}
			catch(Throwable e){
				failed = true;
				e.printStackTrace();
				Print.log("FAILED TO LOAD WIRE REGION [ " + key.x +  ", " + key.z + " ]! THIS MAY BE NOT GOOD.");
				try{
					File newfile = new File(system.getSaveRoot(), "/wireregions/" + key.x + "_" + key.z + "_" + Time.getAsString(null, true) + ".dat");
					Files.copy(file.toPath(), newfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					Print.log("If things gone well, created a backup copy of the 'broken' file!");
				}
				catch(Throwable thr){
					thr.printStackTrace();
					Print.log("FAILED TO CREATE BACKUP OF BROKEN WIRE REGION");
				}
			}
		}
		if(!file.exists() || failed) compound = new NBTTagCompound();
		//
		return this.read(compound).setAccessed();
	}

	public WireRegion read(NBTTagCompound compound){
		if(compound.hasKey("RelayHolders")){
			if(!holders.isEmpty()) holders.clear();
			NBTTagList list = (NBTTagList)compound.getTag("RelayHolders");
			for(NBTBase base : list){
				RelayHolder holder = new RelayHolder(this);
				holder.read((NBTTagCompound)base);
				holders.put(holder.pos, holder);
			}
		}
		loaded = true;
		return this;
	}
	
	public WireRegion save(){
		File file = new File(system.getSaveRoot(), "/wireregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		NBTTagCompound compound = write(false);
		if(compound.isEmpty()){
			Print.debug("WireRegion [" + key.toString() + "] has no data to save, skipping.");
			return this;
		}
		compound.setLong("Saved", Time.getDate());
		try{
			CompressedStreamTools.write(compound, file);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		Print.debug("Saved WireRegion [" + key.toString() + "].");
		return this;
	}

	private NBTTagCompound write(boolean clientpacket){
		NBTTagCompound compound = new NBTTagCompound();
		if(!holders.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(RelayHolder holder : holders.values()){
				list.appendTag(holder.write());
			}
			compound.setTag("RelayHolders", list);
		}
		if(clientpacket) return compound;
		return compound;
	}

	public WireRelay getRelay(WireKey wkey){
		if(!key.isInRegion(wkey.start_pos)) return system.getRelay(wkey);
		RelayHolder holder = getHolder(wkey.start_pos);
		return holder == null ? null : holder.get(wkey.start_relay);
	}

	public void updateTick(){
		if(timer > 20){
			timer = -1;
			for(RelayHolder holder : holders.values()){
				for(WireRelay relay : holder.relays.values()) relay.onUpdate();
			}
		}
		timer++;
	}
	
	public WireRegion setAccessed(){
		lastaccess = Time.getDate();
		return this;
	}

	public RegionKey getKey(){
		return key;
	}
	
	public void updateClient(BlockPos pos){
		updateClient("all", null, pos, null);
	}
	
	public void updateClient(String kind, String key, BlockPos pos, Object obj){
		if(system.getWorld().isClient()) return;
		NBTTagCompound compound = null;
		switch(kind){
			case "all":{
				compound = this.write(true);
				compound.setString("task", "update_region");
				compound.setLong("pos", pos.toLong());
				compound.setIntArray("XZ", RegionKey.getRegionXZ(pos));
				break;
			}
			case "relay":{
				compound = new NBTTagCompound();
				compound.setString("task", "update_relay");
				compound.setLong("pos", ((WireRelay)obj).holder.pos.toLong());
				((WireRelay)obj).write(compound);
				break;
			}
			case "no_relay":{
				compound = new NBTTagCompound();
				compound.setString("task", "remove_relay");
				compound.setLong("pos", pos.toLong());
				compound.setString("key", key);
				break;
			}
			case "holder":{
				RelayHolder holder = getHolder(pos);
				if(holder == null) return;
				compound = holder.write();
				compound.setString("task", "update_holder");
				break;
			}
			case "no_holder":{
				compound = new NBTTagCompound();
				compound.setLong("pos", pos.toLong());
				compound.setString("task", "rem_holder");
				break;
			}
			case "sections":{
				compound = new NBTTagCompound();
				compound.setString("task", "update_sections");
				NBTTagList list = new NBTTagList();
				for(WireUnit unit : system.getWireUnits().values()){
					NBTTagCompound com = new NBTTagCompound();
					com.setString("unit", unit.getUID());
					com.setLong("section", unit.getSectionId());
					list.appendTag(com);
				}
				compound.setTag("units", list);
				break;
			}
			default:{
				Static.stop();
				break;
			}
		}
		if(compound == null) return;
		compound.setString("target_listener", "fvtm:wiresys");
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), getTargetPoint(system.getDimension(), pos));
	}

	public void updateClient(EntityPlayerMP player){
		if(system.getWorld().isClient() || player == null) return;
		NBTTagCompound compound = this.write(true);
		compound.setString("target_listener", "fvtm:wiresys");
		compound.setString("task", "update_region");
		compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), player);
	}
	
	public WireSystem getSystem(){
		return system;
	}

	public Wire getWire(WireKey key){
		WireRelay relay = getRelay(key);
		return relay == null ? null : relay.getWire(key);
	}

	public RelayHolder getHolder(BlockPos pos){
		return holders.get(pos);
	}

	public RelayHolder addHolder(BlockPos pos){
		if(!holders.containsKey(pos)){
			RelayHolder holder = new RelayHolder(this, pos);
			holders.put(pos, holder);
			return holder;
		}
		else return holders.get(pos);
	}

	public void delHolder(BlockPos pos){
		RelayHolder holder = getHolder(pos);
		if(holder == null) return;
		holder.delete();
		holders.remove(pos);
	}
	
	public ConcurrentHashMap<BlockPos, RelayHolder> getHolders(){
		return holders;
	}

}
