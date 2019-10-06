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
import net.fexcraft.mod.fvtm.sys.rail.Compound.Multiple;
import net.fexcraft.mod.fvtm.sys.rail.Compound.Singular;
import net.fexcraft.mod.fvtm.sys.rail.RailData.XZK;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailRegion {
	
	private TreeMap<Vec316f, Junction> junctions = new TreeMap<>();
	private ConcurrentHashMap<Long, RailEntity> entities = new ConcurrentHashMap<>();
	public ArrayList<XZK> chucks = new ArrayList<>();
	public long lastaccess; private int timer = 0;
	private final RailData world;
	private final XZK key;

	public RailRegion(int i, int j, RailData root){
		key = new XZK(i, j); world = root; load();
	}

	public RailRegion(Vec316f vec, RailData root){
		key = new XZK(vec); world = root; load().updateClient(vec);
	}

	public RailRegion load(){
		if(world.getWorld().isRemote){
			NBTTagCompound compound = new NBTTagCompound(); compound.setString("target_listener", "fvtm:gui");
			compound.setString("task", "update_railregion"); compound.setIntArray("XZ", key.toArray());
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

	public RailRegion read(NBTTagCompound compound){
		if(compound.hasKey("Junctions")){
			if(!junctions.isEmpty()){
				for(Junction junction : junctions.values())
					if(junction.entity != null) junction.entity.setDead();
				junctions.clear();
			}
			NBTTagList list = (NBTTagList)compound.getTag("Junctions");
			for(NBTBase base : list){
				Junction junk = new Junction(this).read((NBTTagCompound)base);
				junctions.put(junk.getVec316f(), junk);
			}
		}
		if(compound.hasKey("Entities")){
			if(!entities.isEmpty()) entities.clear();
			NBTTagList list = (NBTTagList)compound.getTag("Entities");
			for(NBTBase base : list){
				if(base instanceof NBTTagCompound){
					NBTTagCompound com = (NBTTagCompound)base;
					Singular singular = new Singular(this, com.getLong("Compound"), com);
					entities.put(singular.entities.get(0).getUID(), singular.entities.get(0));
				}
				else if(base instanceof NBTTagList){
					Multiple multiple = new Multiple(this, (NBTTagList)base);
					int[] arr = null;
					for(RailEntity entity : multiple.entities){
						arr = RailData.getRegionXZ(entity.pos);
						if(key.x == arr[0] && key.z == arr[1]) entities.put(entity.getUID(), entity);
						else{
							RailRegion reg = world.getRegions().get(arr, true);
							reg.getEntities().put(entity.getUID(), entity);
						}
					}
				}
				else if(base instanceof NBTTagIntArray){
					//TODO
				}
				else continue;
			}
		}
		return this;
	}
	
	public RailRegion save(){
		File file = new File(world.getRootFile(), "/railregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		NBTTagCompound compound = write();
		if(compound.hasNoTags()){
			Print.log("RailRegion [" + key.toString() + "] has no data to save, skipping."); return this;
		}
		try{ CompressedStreamTools.write(compound, file); } catch(IOException e){ e.printStackTrace(); }
		Print.log("Saved RailRegion [" + key.toString() + "]."); return this;
	}

	private NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("Saved", Time.getDate());
		if(!junctions.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Junction junk : junctions.values()){
				list.appendTag(junk.write(null));
			}
			compound.setTag("Junctions", list);
		}
		if(!entities.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(RailEntity entity : entities.values()){
				if(entity.com.isSingular()){
					list.appendTag(entity.write(null));
				}
				else if(entity.com.isHead(entity)){
					NBTTagList ents = new NBTTagList();
					ents.appendTag(new NBTTagLong(entity.com.getUID()));
					for(RailEntity ent : entity.com.entities){
						ents.appendTag(ent.write(null));
					}
					list.appendTag(ents);
				}
				else if(entity.com.isEnd(entity)){
					list.appendTag(new NBTTagIntArray(RailData.getRegionXZ(entity.pos)));
				}
				else continue;
			}
			compound.setTag("Entities", list);
		}
		return compound;
	}

	public Junction getJunction(Vec316f vec){
		if(!isInRegion(vec)) return world.getJunction(vec);
		return junctions.get(vec);
	}

	public boolean isInRegion(Vec316f vec){
		int[] id = RailData.getRegionXZ(vec);
		return id[0] == key.x && id[1] == key.z;
	}

	public void updateTick(){
		if(!entities.isEmpty()) this.setAccessed();
		for(RailEntity ent : entities.values()){ ent.onUpdate(); }
		if(timer > 20){ timer = -1;
			for(Junction junction : junctions.values()){ junction.onUpdate(); }
		} timer++;
	}
	
	public RailRegion setAccessed(){
		lastaccess = Time.getDate(); return this;
	}

	public XZK getKey(){
		return key;
	}

	public TreeMap<Vec316f, Junction> getJunctions(){
		return junctions;
	}
	
	public void updateClient(Vec316f vector){
		updateClient("all", vector);
	}
	
	public void updateClient(String kind, Vec316f vector){
		if(world.getWorld().isRemote) return; NBTTagCompound compound = null;
		switch(kind){
			case "all":{
				compound = this.write(); compound.setString("target_listener", "fvtm:gui");
				compound.setString("task", "update_railregion"); compound.setIntArray("XZ", key.toArray());
				break;
			}
			case "junction":{
				Junction junction = getJunction(vector); if(junction == null) return;
				compound = junction.write(new NBTTagCompound());
				compound.setString("target_listener", "fvtm:gui");
				compound.setString("task", "update_junction");
				break;
			}
			case "no_junction":{
				compound = vector.write();
				compound.setString("target_listener", "fvtm:gui");
				compound.setString("task", "rem_junction");
				break;
			}
			case "junction_state":{
				Junction junction = getJunction(vector); if(junction == null) return;
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:gui");
				compound.setString("task", "update_junction_state");
				compound.setTag("pos", junction.getVec316f().write());
				compound.setBoolean("switch0", junction.switch0);
				compound.setBoolean("switch1", junction.switch1);
				break;
			}
			case "junction_signal":{
				Junction junction = getJunction(vector); if(junction == null) return;
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:gui");
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
				Junction junction = getJunction(vector); if(junction == null) return;
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:gui");
				compound.setString("task", "update_junction_signal_state");
				compound.setTag("pos", junction.getVec316f().write());
				compound.setBoolean("signal0", junction.signal0);
				compound.setBoolean("signal1", junction.signal1);
				break;
			}
			case "sections":{
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:gui");
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
		if(world.getWorld().isRemote) return; NBTTagCompound compound = null;
		switch(kind){
			case "removed":{
				compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm:gui");
				compound.setString("task", "remove_entity");
				compound.setLong("uid", entity.uid);
			}
		}
		if(compound == null) return;
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(world.getDimension(),
			new BlockPos(entity.pos.xCoord, entity.pos.yCoord, entity.pos.zCoord)));
	}

	public void updateClient(EntityPlayerMP player){
		if(world.getWorld().isRemote) return;
		NBTTagCompound compound = this.write(); compound.setString("target_listener", "fvtm:gui");
		compound.setString("task", "update_railregion"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), player);
	}

	public ConcurrentHashMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public void spawnEntity(RailEntity ent){
		if(world.getWorld().isRemote) return; entities.put(ent.getUID(), ent);
		NBTTagCompound compound = ent.write(null); compound.setString("target_listener", "fvtm:gui");
		compound.setString("task", "spawn_railentity"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound),
			Resources.getTargetPoint(world.getDimension(), new net.minecraft.util.math.BlockPos(ent.current.start.pos)));
	}
	
	public RailData getWorld(){
		return world;
	}

	public Track getTrack(TrackKey key){
		Junction junction = getJunction(key.toVec3f(0));
		return junction == null ? null : junction.getTrack(key);
	}

}
