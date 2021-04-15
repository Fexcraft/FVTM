package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Region {
	
	public static final TreeMap<Long, NBTTagCompound> fillqueue = new TreeMap<>();
	//public static final TreeMap<Long, NBTTagCompound> clientqueue = new TreeMap<>();
	private TreeMap<Vec316f, Junction> junctions = new TreeMap<>();
	private ConcurrentHashMap<Long, RailEntity> entities = new ConcurrentHashMap<>();
	public ArrayList<RegionKey> chucks = new ArrayList<>();
	public long lastaccess; private int timer = 0;
	public boolean loaded;
	private final RailSys world;
	private final RegionKey key;

	public Region(int i, int j, RailSys root, boolean load){
		key = new RegionKey(i, j); world = root; if(load) load();
	}

	public Region(Vec316f vec, RailSys root, boolean load){
		key = new RegionKey(vec); world = root; if(load) load();//.updateClient(vec);
	}

	public Region load(){
		if(world.getWorld().isRemote){
			NBTTagCompound compound = new NBTTagCompound(); compound.setString("target_listener", "fvtm:railsys");
			compound.setString("task", "update_region"); compound.setIntArray("XZ", key.toArray());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound)); return this;
		}
		File file = new File(world.getRootFile(), "/railregions/" + key.x + "_" + key.z + ".dat");
		NBTTagCompound compound = null; boolean failed = false;
		if(file.exists()){
			try{ compound = CompressedStreamTools.read(file); }
			catch(Throwable e){
				failed = true; e.printStackTrace();
				Print.log("FAILED TO LOAD RAIL REGION [ " + key.x +  ", " + key.z + " ]! THIS MAY BE NOT GOOD.");
				try{
					File newfile = new File(world.getRootFile(), "/railregions/" + key.x + "_" + key.z + "_" + Time.getAsString(null, true) + ".dat");
					Files.copy(file.toPath(), newfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					Print.log("If things gone well, created a backup copy of the 'broken' file!");
				}
				catch(Throwable thr){
					thr.printStackTrace();
					Print.log("FAILED TO CREATE BACKUP OF BROKEN RAIL REGION");
				}
			}
		} if(!file.exists() || failed) compound = new NBTTagCompound();
		//
		return this.read(compound).setAccessed();
	}

	public Region read(NBTTagCompound compound){
		if(compound.hasKey("Junctions")){
			if(!junctions.isEmpty()){
				junctions.clear();
			}
			NBTTagList list = (NBTTagList)compound.getTag("Junctions");
			for(NBTBase base : list){
				Junction junk = new Junction(this).read((NBTTagCompound)base);
				junctions.put(junk.getVec316f(), junk);
				//MinecraftForge.EVENT_BUS.post(new RailEvents.JunctionEvent.JunctionLoaded(world, junk));
			}
		}
		loaded = true;
		//
		if(compound.hasKey("Entities")){
			if(!entities.isEmpty()) entities.clear();
			NBTTagList list = (NBTTagList)compound.getTag("Entities");
			for(NBTBase base : list){
				NBTTagCompound com = (NBTTagCompound)base;
				fillqueue.put(com.getLong("Compound"), com);
			}
		}
		return this;
	}
	
	public Region save(){
		File file = new File(world.getRootFile(), "/railregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		NBTTagCompound compound = write(false);
		if(compound.isEmpty()){
			Print.debug("RailRegion [" + key.toString() + "] has no data to save, skipping."); return this;
		}
		compound.setLong("Saved", Time.getDate());
		try{ CompressedStreamTools.write(compound, file); } catch(IOException e){ e.printStackTrace(); }
		Print.debug("Saved RailRegion [" + key.toString() + "]."); return this;
	}

	private NBTTagCompound write(boolean clientpacket){
		NBTTagCompound compound = new NBTTagCompound();
		if(!junctions.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Junction junk : junctions.values()){
				list.appendTag(junk.write(null));
			}
			compound.setTag("Junctions", list);
		}
		if(clientpacket) return compound;
		if(!entities.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(RailEntity entity : entities.values()){
				if(entity.com.isSingular()){
					list.appendTag(entity.write(null));
				}
				else if(entity.com.isMultiple() && entity.com.isHead(entity)){
					NBTTagCompound com = new NBTTagCompound();
					com.setLong("Compound", entity.com.uid);
					com.setBoolean("Forward", entity.com.forward);
					com.setBoolean("Singular", false);
					//com.setBoolean("Head", true);
					NBTTagList ents = new NBTTagList();
					for(RailEntity ent : entity.com.entities){
						ents.appendTag(ent.write(null));
					}
					com.setTag("Entities", ents);
					list.appendTag(com);
				}
			}
			compound.setTag("Entities", list);
		}
		return compound;
	}

	public Junction getJunction(Vec316f vec){
		if(!key.isInRegion(vec)) return world.getJunction(vec);
		return junctions.get(vec);
	}

	public void updateTick(){
		if(!entities.isEmpty()) this.setAccessed();
		for(RailEntity ent : entities.values()) ent.onUpdate();
		if(timer > 20){ timer = -1;
			for(Junction junction : junctions.values()) junction.onUpdate();
		}
		timer++;
	}
	
	public Region setAccessed(){
		lastaccess = Time.getDate(); return this;
	}

	public RegionKey getKey(){
		return key;
	}

	public TreeMap<Vec316f, Junction> getJunctions(){
		return junctions;
	}
	
	public void updateClient(Vec316f vector){
		updateClient("all", vector);
	}
	
	public void updateClient(String kind, Vec316f vector){
		if(world.getWorld().isRemote) return;
		NBTTagCompound compound = null;
		switch(kind){
			case "all":{
				compound = this.write(true);
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "update_region");
				compound.setIntArray("XZ", key.toArray());
				break;
			}
			case "junction":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = junction.write(new NBTTagCompound());
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "update_junction");
				break;
			}
			case "no_junction":{
				compound = vector.write();
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "rem_junction");
				break;
			}
			case "junction_state":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "update_junction_state");
				compound.setTag("pos", junction.getVec316f().write());
				compound.setBoolean("switch0", junction.switch0);
				compound.setBoolean("switch1", junction.switch1);
				break;
			}
			case "junction_signal":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "update_junction_signal");
				compound.setTag("pos", junction.getVec316f().write());
				if(junction.signal == null){
					compound.setBoolean("nosignal", true);
				}
				else{
					compound.setInteger("signal", junction.signal.ordinal());
					compound.setInteger("signal_dir", junction.signal_dir.ordinal());
				}
				break;
			}
			case "junction_signal_state":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "update_junction_signal_state");
				compound.setTag("pos", junction.getVec316f().write());
				compound.setBoolean("signal0", junction.signal0);
				compound.setBoolean("signal1", junction.signal1);
				break;
			}
			case "sections":{
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "update_sections");
				NBTTagList list = new NBTTagList();
				for(TrackUnit unit : world.getTrackUnits().values()){
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
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(world.getDimension(), vector.pos));
	}

	public void updateClient(String kind, RailEntity entity){
		if(world.getWorld().isRemote) return;
		NBTTagCompound compound = null;
		switch(kind){
			case "removed":{
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:railsys");
				compound.setString("task", "remove_entity");
				compound.setLong("uid", entity.uid);
			}
		}
		if(compound == null) return;
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(world.getDimension(), new BlockPos(entity.pos.x, entity.pos.y, entity.pos.z)));
	}

	public void updateClient(EntityPlayerMP player){
		if(world.getWorld().isRemote) return;
		NBTTagCompound compound = this.write(true); compound.setString("target_listener", "fvtm:railsys");
		compound.setString("task", "update_region"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), player);
	}

	public ConcurrentHashMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public void spawnEntity(RailEntity ent){
		Print.debug("Spawning Entity " + ent.uid + "!"); entities.put(ent.getUID(), ent); if(world.getWorld().isRemote) return;
		/*NBTTagCompound compound = ent.write(null); compound.setString("target_listener", "fvtm:railsys");
		compound.setString("task", "spawn_railentity"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound),
			Resources.getTargetPoint(world.getDimension(), new BlockPos(ent.pos.x, ent.pos.y, ent.pos.z)));*/
	}
	
	public RailSys getWorld(){
		return world;
	}

	public Track getTrack(PathKey key){
		Junction junction = getJunction(key.toVec3f(0));
		return junction == null ? null : junction.getTrack(key);
	}

}
