package net.fexcraft.mod.fvtm.sys.wire;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireRegion {
	
	private TreeMap<Vec316f, WireRelay> relays = new TreeMap<>();
	private TreeMap<BlockPos, RelayHolder> holders = new TreeMap<>();
	public ConcurrentHashMap<RegionKey, Chunk> chucks = new ConcurrentHashMap<>();
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

	public WireRegion(Vec316f vec, WireSystem root, boolean load){
		key = new RegionKey(vec);
		system = root;
		if(load) load();
	}

	public WireRegion load(){
		if(system.getWorld().isRemote){
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
			if(!relays.isEmpty()) relays.values().removeIf(value -> !RegionKey.getRegionXZ(value.holder.pos).equals(key));
			if(!holders.isEmpty()) holders.clear();
			NBTTagList list = (NBTTagList)compound.getTag("RelayHolders");
			for(NBTBase base : list){
				RelayHolder holder = new RelayHolder(this);
				holder.read((NBTTagCompound)base);
				holders.put(holder.pos, holder);
				holder.regRelays();
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
		if(!relays.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(RelayHolder holder : holders.values()){
				list.appendTag(holder.write());
			}
			compound.setTag("RelayHolders", list);
		}
		if(clientpacket) return compound;
		return compound;
	}

	public WireRelay getRelay(Vec316f vec){
		if(!key.isInRegion(vec)) return system.getRelay(vec);
		return relays.get(vec);
	}

	public void updateTick(){
		if(timer > 20){
			timer = -1;
			for(WireRelay relay : relays.values()) relay.onUpdate();
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

	public TreeMap<Vec316f, WireRelay> getRelays(){
		return relays;
	}
	
	public void updateClient(Vec316f vector){
		updateClient("all", vector, null);
	}
	
	public void updateClient(String kind, Vec316f vector, BlockPos pos){
		if(system.getWorld().isRemote) return;
		NBTTagCompound compound = null;
		switch(kind){
			case "all":{
				compound = this.write(true);
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "update_region");
				compound.setIntArray("XZ", key.toArray());
				break;
			}
			case "relay":{
				WireRelay relay = getRelay(vector);
				if(relay == null) return;
				compound = relay.write(new NBTTagCompound());
				compound.setLong("holder", relay.holder.pos.toLong());
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "update_relay");
				break;
			}
			case "no_relay":{
				compound = vector.write();
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "rem_relay");
				break;
			}
			case "holder":{
				RelayHolder holder = getHolder(pos);
				if(holder == null) return;
				compound = holder.write();
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "update_holder");
				break;
			}
			case "no_holder":{
				compound = new NBTTagCompound();
				compound.setLong("pos", pos.toLong());
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "rem_holder");
				break;
			}
			case "sections":{
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:wiresys");
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
		}
		if(compound == null) return;
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(system.getDimension(), vector.pos));
	}

	public void updateClient(EntityPlayerMP player){
		if(system.getWorld().isRemote) return;
		NBTTagCompound compound = this.write(true);
		compound.setString("target_listener", "fvtm:wiresys");
		compound.setString("task", "update_region");
		compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), player);
	}
	
	public WireSystem getSystem(){
		return system;
	}

	public Wire getWire(PathKey key){
		WireRelay relay = getRelay(key.toVec3f(0));
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

	public void remRelay(WireRelay relay){
		if(relays.containsKey(relay.getVec316f())){
			relays.remove(relay.getVec316f());
			updateClient("no_relay", relay.getVec316f(), null);
			setAccessed();
		}
	}

}
