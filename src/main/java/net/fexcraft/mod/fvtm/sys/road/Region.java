package net.fexcraft.mod.fvtm.sys.road;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

/**
 * Road Region
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Region {

	public ArrayList<RegionKey> chucks = new ArrayList<>();
	private final RegionKey key;
	private final RoadSys world;
	public long lastaccessed;
	private byte timer = 0;

	public Region(int i, int j, RoadSys root){
		key = new RegionKey(i, j); world = root; load();
	}

	public Region(Vec316f vec, RoadSys root){
		key = new RegionKey(vec); world = root; load().updateClient(vec);
	}
	
	public Region load(){
		if(world.getWorld().isRemote){
			NBTTagCompound compound = new NBTTagCompound(); compound.setString("target_listener", "fvtm:roadsys");
			compound.setString("task", "update_region"); compound.setIntArray("XZ", key.toArray());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound)); return this;
		}
		File file = new File(world.getRootFile(), "/roadregions/" + key.x + "_" + key.z + ".dat");
		NBTTagCompound compound = null; boolean failed = false;
		if(file.exists()){
			try{ compound = CompressedStreamTools.read(file); }
			catch(Throwable e){
				failed = true; e.printStackTrace();
				Print.log("FAILED TO LOAD ROAD REGION [ " + key.x +  ", " + key.z + " ]! THIS MAY BE NOT GOOD.");
				try{
					File newfile = new File(world.getRootFile(), "/roadregions/" + key.x + "_" + key.z + "_" + Time.getAsString(null, true) + ".dat");
					Files.copy(file.toPath(), newfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					Print.log("If things gone well, created a backup copy of the 'broken' file!");
				}
				catch(Throwable thr){
					thr.printStackTrace();
					Print.log("FAILED TO CREATE BACKUP OF BROKEN ROAD REGION");
				}
			}
		} if(!file.exists() || failed) compound = new NBTTagCompound();
		//
		return this.read(compound).setAccessed();
	}

	public Region read(NBTTagCompound compound){
		//TOdo
		return this;
	}
	
	public Region save(){
		File file = new File(world.getRootFile(), "/roadregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		NBTTagCompound compound = write();
		if(compound.hasNoTags()){
			Print.log("RoadRegion [" + key.toString() + "] has no data to save, skipping."); return this;
		}
		try{ CompressedStreamTools.write(compound, file); } catch(IOException e){ e.printStackTrace(); }
		Print.log("Saved RoadRegion [" + key.toString() + "]."); return this;
	}

	private NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("Saved", Time.getDate());
		//TODO
		return compound;
	}
	
	public void updateClient(Vec316f vector){
		updateClient("all", vector);
	}
	
	public void updateClient(String kind, Vec316f vector){
		if(world.getWorld().isRemote) return; NBTTagCompound compound = null;
		switch(kind){
			case "all":{
				compound = this.write(); compound.setString("target_listener", "fvtm:roadsys");
				compound.setString("task", "update_region"); compound.setIntArray("XZ", key.toArray());
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
				compound.setString("target_listener", "fvtm:roadsys");
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
		NBTTagCompound compound = this.write(); compound.setString("target_listener", "fvtm:roadsys");
		compound.setString("task", "update_region"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), player);
	}
	
	public Region setAccessed(){
		lastaccessed = Time.getDate(); return this;
	}

	public RegionKey getKey(){
		return key;
	}

	public void updateTick(){
		//TODO if(!entities.isEmpty()) this.setAccessed();
		//TODO for(RailEntity ent : entities.values()){ ent.onUpdate(); }
		if(timer > 20){ timer = -1;
			//for(Junction junction : junctions.values()){ junction.onUpdate(); }
		} timer++;
	}

}
