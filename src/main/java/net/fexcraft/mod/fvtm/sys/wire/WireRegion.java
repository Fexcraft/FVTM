package net.fexcraft.mod.fvtm.sys.wire;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.TreeMap;

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

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireRegion {
	
	private TreeMap<Vec316f, WireBlock> blocks = new TreeMap<>();
	public ArrayList<RegionKey> chucks = new ArrayList<>();
	public long lastaccess;
	private int timer = 0;
	public boolean loaded;
	private final WireSystem system;
	private final RegionKey key;

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
		if(compound.hasKey("Blocks")){
			if(!blocks.isEmpty()){
				blocks.clear();
			}
			NBTTagList list = (NBTTagList)compound.getTag("Blocks");
			for(NBTBase base : list){
				WireBlock block = new WireBlock(this).read((NBTTagCompound)base);
				blocks.put(block.getVec316f(), block);
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
		if(!blocks.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(WireBlock block : blocks.values()){
				list.appendTag(block.write(null));
			}
			compound.setTag("Blocks", list);
		}
		if(clientpacket) return compound;
		return compound;
	}

	public WireBlock getBlock(Vec316f vec){
		if(!key.isInRegion(vec)) return system.getBlock(vec);
		return blocks.get(vec);
	}

	public void updateTick(){
		if(timer > 20){
			timer = -1;
			for(WireBlock block : blocks.values()) block.onUpdate();
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

	public TreeMap<Vec316f, WireBlock> getBlocks(){
		return blocks;
	}
	
	public void updateClient(Vec316f vector){
		updateClient("all", vector);
	}
	
	public void updateClient(String kind, Vec316f vector){
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
			case "block":{
				WireBlock block = getBlock(vector);
				if(block == null) return;
				compound = block.write(new NBTTagCompound());
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "update_block");
				break;
			}
			case "no_block":{
				compound = vector.write();
				compound.setString("target_listener", "fvtm:wiresys");
				compound.setString("task", "rem_block");
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
		WireBlock block = getBlock(key.toVec3f(0));
		return block == null ? null : block.getWire(key);
	}

}
