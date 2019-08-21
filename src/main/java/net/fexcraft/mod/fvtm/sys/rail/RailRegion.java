package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.RailData.XZK;
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
public class RailRegion {
	
	private TreeMap<Vec316f, Junction> junctions = new TreeMap<>();
	public ArrayList<XZK> chucks = new ArrayList<>();
	public long lastaccess;
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
		NBTTagCompound compound = null;
		if(file.exists()){
			try{ compound = CompressedStreamTools.read(file); } catch(IOException e){ e.printStackTrace(); }
		} else compound = new NBTTagCompound();
		//
		return this.read(compound).setAccessed();
	}

	public RailRegion read(NBTTagCompound compound){
		if(compound.hasKey("Junctions")){
			if(!junctions.isEmpty()) junctions.clear();
			NBTTagList list = (NBTTagList)compound.getTag("Junctions");
			for(NBTBase base : list){
				Junction junk = new Junction(world).read((NBTTagCompound)base);
				junctions.put(junk.getVec316f(), junk);
			}
		}
		//TODO entities
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
		//TODO entities
		return compound;
	}

	public Junction getJunction(Vec316f vec){
		return junctions.get(vec);
	}

	public void updateTick(){
		//
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
	
	public void updateClient(Vec316f vector){//TODO fine tuned methods in the future
		if(world.getWorld().isRemote) return;
		NBTTagCompound compound = this.write(); compound.setString("target_listener", "fvtm:gui");
		compound.setString("task", "update_railregion"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound),
			Resources.getTargetPoint(world.getDimension(), vector.pos));
	}

	public void updateClient(EntityPlayerMP player){
		if(world.getWorld().isRemote) return;
		NBTTagCompound compound = this.write(); compound.setString("target_listener", "fvtm:gui");
		compound.setString("task", "update_railregion"); compound.setIntArray("XZ", key.toArray());
		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), player);
	}

}
