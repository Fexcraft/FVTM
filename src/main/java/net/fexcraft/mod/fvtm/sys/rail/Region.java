package net.fexcraft.mod.fvtm.sys.rail;

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
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.impl.TagLWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
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
public class Region {
	
	public static final TreeMap<Long, TagCW> fillqueue = new TreeMap<>();
	//public static final TreeMap<Long, NBTTagCompound> clientqueue = new TreeMap<>();
	private TreeMap<QV3D, Junction> junctions = new TreeMap<>();
	private ConcurrentHashMap<Long, RailEntity> entities = new ConcurrentHashMap<>();
	public ConcurrentHashMap<RegionKey, Chunk> chucks = new ConcurrentHashMap<>();
	public long lastaccess; private int timer = 0;
	public boolean loaded;
	private final RailSystem world;
	private final RegionKey key;

	public Region(int i, int j, RailSystem root, boolean load){
		key = new RegionKey(i, j);
		world = root;
		if(load) load();
	}

	public Region(QV3D vec, RailSystem root, boolean load){
		key = new RegionKey(vec);
		world = root;
		if(load) load();//.updateClient(vec);
	}

	public Region load(){
		if(world.getWorld().isRemote){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", "fvtm:railsys");
			compound.setString("task", "update_region");
			compound.setIntArray("XZ", key.toArray());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
			return this;
		}
		File file = new File(world.getSaveRoot(), "/railregions/" + key.x + "_" + key.z + ".dat");
		NBTTagCompound compound = null;
		boolean failed = false;
		if(file.exists()){
			try{
				compound = CompressedStreamTools.read(file);
			}
			catch(Throwable e){
				failed = true;
				e.printStackTrace();
				Print.log("FAILED TO LOAD RAIL REGION [ " + key.x +  ", " + key.z + " ]! THIS MAY BE NOT GOOD.");
				try{
					File newfile = new File(world.getSaveRoot(), "/railregions/" + key.x + "_" + key.z + "_" + Time.getAsString(null, true) + ".dat");
					Files.copy(file.toPath(), newfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					Print.log("If things gone well, created a backup copy of the 'broken' file!");
				}
				catch(Throwable thr){
					thr.printStackTrace();
					Print.log("FAILED TO CREATE BACKUP OF BROKEN RAIL REGION");
				}
			}
		}
		if(!file.exists() || failed) compound = new NBTTagCompound();
		//
		return this.read(TagCW.wrap(compound)).setAccessed();
	}

	public Region read(TagCW compound){
		if(compound.has("Junctions")){
			if(!junctions.isEmpty()){
				junctions.clear();
			}
			TagLW list = compound.getList("Junctions");
			list.forEach(tag -> {
				Junction junk = new Junction(this).read(tag);
				junctions.put(junk.getVec316f(), junk);
				//MinecraftForge.EVENT_BUS.post(new RailEvents.JunctionEvent.JunctionLoaded(world, junk));
			});
		}
		loaded = true;
		//
		if(compound.has("Entities")){
			if(!entities.isEmpty()) entities.clear();
			compound.getList("Entities").forEach(tag -> {
				fillqueue.put(tag.getLong("Compound"), tag.local());
			});
		}
		return this;
	}
	
	public Region save(){
		File file = new File(world.getSaveRoot(), "/railregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		TagCW compound = write(false);
		if(compound.empty()){
			Print.debug("RailRegion [" + key.toString() + "] has no data to save, skipping.");
			return this;
		}
		compound.set("Saved", Time.getDate());
		try{
			CompressedStreamTools.write(compound.local(), file);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		Print.debug("Saved RailRegion [" + key.toString() + "].");
		return this;
	}

	private TagCW write(boolean clientpacket){
		TagCW compound = TagCW.create();
		if(!junctions.isEmpty()){
			TagLW list = TagLW.create();
			for(Junction junk : junctions.values()){
				list.add(junk.write(null));
			}
			compound.set("Junctions", list);
		}
		if(clientpacket) return compound;
		if(!entities.isEmpty()){
			TagLW list = TagLW.create();
			for(RailEntity entity : entities.values()){
				if(entity.com.isSingular()){
					list.add(entity.write(null));
				}
				else if(entity.com.isMultiple() && entity.com.isHead(entity)){
					TagCW com = TagCW.create();
					com.set("Compound", entity.com.uid);
					com.set("Forward", entity.com.forward);
					com.set("Singular", false);
					//com.setBoolean("Head", true);
					TagLW ents = TagLW.create();
					for(RailEntity ent : entity.com.entities){
						ents.add(ent.write(null));
					}
					com.set("Entities", ents);
					list.add(com);
				}
			}
			compound.set("Entities", list);
		}
		return compound;
	}

	public Junction getJunction(QV3D vec){
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

	public TreeMap<QV3D, Junction> getJunctions(){
		return junctions;
	}
	
	public void updateClient(QV3D vector){
		updateClient("all", vector);
	}
	
	public void updateClient(String kind, QV3D vector){
		if(world.getWorld().isRemote) return;
		TagCW compound = null;
		switch(kind){
			case "all":{
				compound = this.write(true);
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "update_region");
				compound.set("XZ", key.toArray());
				break;
			}
			case "junction":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = junction.write(null);
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "update_junction");
				break;
			}
			case "no_junction":{
				vector.write(compound, "vector");
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "rem_junction");
				break;
			}
			case "junction_state":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = TagCW.create();
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "update_junction_state");
				junction.getVec316f().write(compound, "pos");
				compound.set("switch0", junction.switch0);
				compound.set("switch1", junction.switch1);
				break;
			}
			case "junction_signal":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = TagCW.create();
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "update_junction_signal");
				junction.getVec316f().write(compound, "pos");
				if(junction.signal == null){
					compound.set("nosignal", true);
				}
				else{
					compound.set("signal", junction.signal.ordinal());
					compound.set("signal_dir", junction.signal_dir.ordinal());
				}
				break;
			}
			case "junction_signal_state":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				compound = TagCW.create();
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "update_junction_signal_state");
				junction.getVec316f().write(compound, "pos");
				compound.set("signal0", junction.signal0);
				compound.set("signal1", junction.signal1);
				break;
			}
			case "sections":{
				compound = TagCW.create();
				compound.set("target_listener", "fvtm:railsys");
				compound.set("task", "update_sections");
				TagLW list = TagLW.create();
				for(TrackUnit unit : world.getTrackUnits().values()){
					TagCW com = TagCW.create();
					com.set("unit", unit.getUID());
					com.set("section", unit.getSectionId());
					list.add(com);
				}
				compound.set("units", list);
				break;
			}
		}
		if(compound == null) return;
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound.local()), getTargetPoint(world.getDimension(), vector.pos));
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
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), getTargetPoint(world.getDimension(), new BlockPos(entity.pos.x, entity.pos.y, entity.pos.z)));
	}

	public void updateClient(EntityPlayerMP player){
		if(world.getWorld().isRemote) return;
		TagCW compound = this.write(true);
		compound.set("target_listener", "fvtm:railsys");
		compound.set("task", "update_region");
		compound.set("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound.local()), player);
	}

	public ConcurrentHashMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public void spawnEntity(RailEntity ent){
		Print.debug("Spawning Entity " + ent.uid + "!");
		entities.put(ent.getUID(), ent);
		if(world.getWorld().isRemote) return;
		/*NBTTagCompound compound = ent.write(null); compound.setString("target_listener", "fvtm:railsys");
		compound.setString("task", "spawn_railentity"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound),
			Resources.getTargetPoint(world.getDimension(), new BlockPos(ent.pos.x, ent.pos.y, ent.pos.z)));*/
	}
	
	public RailSystem getWorld(){
		return world;
	}

	public Track getTrack(PathKey key){
		Junction junction = getJunction(key.toQV3D(0));
		return junction == null ? null : junction.getTrack(key);
	}

}
