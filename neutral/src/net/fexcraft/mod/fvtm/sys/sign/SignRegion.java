package net.fexcraft.mod.fvtm.sys.sign;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SignRegion {

	private ConcurrentHashMap<V3I, SignInstance> signs = new ConcurrentHashMap<>();
	public ConcurrentHashMap<RegionKey, ChunkW> chucks = new ConcurrentHashMap<>();
	protected final SignSystem system;
	protected final RegionKey key;
	public long lastaccess;
	private int timer = 0;
	public boolean loaded;

	public SignRegion(int x, int z, SignSystem root, boolean load){
		key = new RegionKey(x, z);
		system = root;
		if(load) load();
	}

	public SignRegion(V3I pos, SignSystem root, boolean load){
		key = new RegionKey(RegionKey.getRegionXZ(pos));
		system = root;
		if(load) load();
	}

	public SignRegion load(){
		if(system.getWorld().isClient()){
			TagCW compound = TagCW.create();
			compound.set("XZ", key.toArray());
			Packets.send(Packet_TagListener.class, "sign_udp_region", compound);
			return this;
		}
		File file = new File(system.getSaveRoot(), "/signregions/" + key.x + "_" + key.z + ".dat");
		TagCW compound = null;
		boolean failed = false;
		if(file.exists()){
			try{
				compound = WrapperHolder.read(file);
			}
			catch(Throwable e){
				failed = true;
				e.printStackTrace();
				FvtmLogger.log("FAILED TO LOAD SIGN REGION [ " + key.x +  ", " + key.z + " ]! THIS MAY BE NOT GOOD.");
				try{
					File newfile = new File(system.getSaveRoot(), "/signregions/" + key.x + "_" + key.z + "_" + Time.getAsString(null, true) + ".dat");
					Files.copy(file.toPath(), newfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					FvtmLogger.log("If things gone well, created a backup copy of the 'broken' file!");
				}
				catch(Throwable thr){
					thr.printStackTrace();
					FvtmLogger.log("FAILED TO CREATE BACKUP OF BROKEN SIGN REGION");
				}
			}
		}
		if(!file.exists() || failed) compound = TagCW.create();
		//
		return this.read(compound).setAccessed();
	}

	public SignRegion read(TagCW compound){
		if(compound.has("Signs")){
			if(!signs.isEmpty()) signs.clear();
			TagLW list = compound.getList("Signs");
			for(TagCW tag : list){
				SignInstance sign = new SignInstance(this);
				sign.read(tag);
				signs.put(sign.vec.pos, sign);
			}
		}
		loaded = true;
		return this;
	}
	
	public SignRegion save(){
		File file = new File(system.getSaveRoot(), "/signregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		TagCW compound = write(false);
		if(compound.empty()){
			FvtmLogger.debug("SignRegion [" + key.toString() + "] has no data to save, skipping.");
			return this;
		}
		compound.set("Saved", Time.getDate());
		WrapperHolder.write(compound, file);
		FvtmLogger.debug("Saved SignRegion [" + key.toString() + "].");
		return this;
	}

	private TagCW write(boolean syncpkt){
		TagCW compound = TagCW.create();
		if(!signs.isEmpty()){
			TagLW list = TagLW.create();
			for(SignInstance sign : signs.values()){
				list.add(sign.write());
			}
			compound.set("Signs", list);
		}
		if(syncpkt) return compound;
		return compound;
	}

	public void updateTick(){
		if(timer > 20){
			timer = -1;
			for(SignInstance sign : signs.values()) sign.update();
		}
		timer++;
	}
	
	public SignRegion setAccessed(){
		lastaccess = Time.getDate();
		return this;
	}

	public RegionKey getKey(){
		return key;
	}

	public void updateClient(Passenger player){
		if(system.getWorld().isClient() || player == null) return;
		TagCW compound = this.write(true);
		compound.set("XZ", key.toArray());
		Packets.sendTo(Packet_TagListener.class, player, "sign_upd_region", compound);
	}

	public void updateClient(QV3D pos){
		updateClient("all", null, pos, null);
	}

	public void updateClient(String kind, String key, QV3D pos, SignInstance sign){
		if(system.getWorld().isClient()) return;
		TagCW com = null;
		String task = null;
		switch(kind){
			case "all":{
				task = "sign_reg";
				com = write(true);
				pos.write(com, "pos");
				com.set("XZ", RegionKey.getRegionXZ(pos));
				break;
			}
			case "sign":{
				task = "sign_upd";
				com = TagCW.create();
				pos.write(com, "pos");
				com.set("sign", sign.write());
				break;
			}
			case "no_sign":{
				task = "sign_rem";
				com = TagCW.create();
				pos.write(com, "pos");
				com.set("key", key);
				break;
			}
			default:{
				Static.stop();
				break;
			}
		}
		if(com == null) return;
		Packets.sendInRange(Packet_TagListener.class, system.getWorld(), pos.pos, task, com);
	}
	
	public SignSystem getSystem(){
		return system;
	}

	public SignInstance getSign(QV3D pos){
		if(!key.isInRegion(pos)) return system.getSign(pos);
		return signs.get(pos);
	}

	public SignInstance addSign(QV3D pos){
		if(!signs.containsKey(pos)){
			SignInstance sign = new SignInstance(this, pos);
			signs.put(pos.pos, sign);
			return sign;
		}
		else return signs.get(pos);
	}

	public void delSign(QV3D pos){
		SignInstance sign = getSign(pos);
		if(sign == null) return;
		sign.delete();
		signs.remove(pos);
	}
	
	public ConcurrentHashMap<V3I, SignInstance> getSigns(){
		return signs;
	}

}
