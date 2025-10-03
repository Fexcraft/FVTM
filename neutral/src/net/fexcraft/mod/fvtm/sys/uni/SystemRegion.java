package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SystemRegion<R extends DetachedSystem<R, V>, V extends SysObj> {

	protected ConcurrentHashMap<V3I, V> objects = new ConcurrentHashMap<>();
	public ConcurrentHashMap<RegionKey, ChunkW> chucks = new ConcurrentHashMap<>();
	public final RegionKey key;
	public final R system;
	public long lastaccess;
	public boolean loaded;
	public int timer;

	public SystemRegion(R root, RegionKey rk){
		system = root;
		key = rk;
	}

	public SystemRegion<R, V> load(){
		if(system.isRemote()){
			TagCW compound = TagCW.create();
			compound.set("xz", key.toArray());
			compound.set("sys", system.getType().ordinal());
			compound.set("dim", system.wtype.rec_key());
			Packets.send(Packet_TagListener.class, "sync_reg", compound);
			return this;
		}
		File file = new File(system.getSaveRoot(), "/" + system.getRegFolderName() + "/" + key.x + "_" + key.z + ".dat");
		FvtmLogger.marker(system.getType() + " " + system.wtype.side_key() + " " + file.getAbsolutePath());
		TagCW compound = null;
		boolean failed = false;
		if(file.exists()){
			try{
				compound = WrapperHolder.read(file);
			}
			catch(Throwable e){
				failed = true;
				e.printStackTrace();
				FvtmLogger.log("FAILED TO LOAD " + system.getType() + " REGION [ " + key.x +  ", " + key.z + " ]! THIS MAY BE NOT GOOD.");
				try{
					File newfile = new File(system.getSaveRoot(), "/" + system.getRegFolderName() + "/" + key.x + "_" + key.z + "_" + Time.getAsString(null, true) + ".dat");
					Files.copy(file.toPath(), newfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					FvtmLogger.log("If things have gone well, created a backup copy of the 'broken' file!");
				}
				catch(Throwable thr){
					thr.printStackTrace();
					FvtmLogger.log("FAILED TO CREATE BACKUP OF BROKEN " + system.getType() + " REGION");
				}
			}
		}
		if(!file.exists() || failed) compound = TagCW.create();
		//
		return read(compound).setAccessed();
	}

	public SystemRegion<R, V> read(TagCW compound){
		try{
			system.readRegion(this, compound);
		}
		catch(Exception e){
			FvtmLogger.log(e, "reading " + system.getType() + " region " + key.toString());
		}
		loaded = true;
		return this;
	}

	public SystemRegion<R, V> setAccessed(){
		lastaccess = Time.getDate();
		return this;
	}

	public SystemRegion<R, V> save(){
		File file = new File(system.getSaveRoot(), "/" + system.getRegFolderName() + "/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		TagCW compound = write(false);
		if(compound.empty()){
			FvtmLogger.debug(system.getType() + "-Region [" + key + "] has no data to save, skipping.");
			return this;
		}
		compound.set("Saved", Time.getDate());
		WrapperHolder.write(compound, file);
		FvtmLogger.debug("Saved " + system.getType() + "-Region [" + key + "].");
		return this;
	}

	private TagCW write(boolean syncpkt){
		TagCW compound = TagCW.create();
		try{
			system.writeRegion(this, compound, syncpkt);
		}
		catch(Exception e){
			FvtmLogger.log(e, "writing " + system.getType() + " region " + key.toString());
		}
		if(syncpkt){
			compound.set("xz", key.toArray());
			compound.set("sys", system.getType().ordinal());
			compound.set("dim", system.wtype.rec_key());
		}
		return compound;
	}

	public void sendSync(V3I pos){
		Packets.sendToAllTrackingPos(Packet_TagListener.class, system.getServerWorld(), pos, "sync_reg", write(true));
	}

	public void sendSync(EntityW ent){
		Packets.sendTo(Packet_TagListener.class, ent, "sync_reg", write(true));
	}

	//

	public V get(V3I pos){
		if(!key.isInRegion(pos)) return system.get(pos);
		return objects.get(pos);
	}

	public V add(V3I pos){
		if(!objects.containsKey(pos)){
			objects.put(pos, system.create(this, pos));
		}
		return objects.get(pos);
	}

	public boolean del(V3I pos){
		V val = get(pos);
		if(val == null) return false;
		val.delete();
		objects.remove(pos);
		return true;
	}

	public Map<V3I, V> getObjects(){
		return objects;
	}

}
