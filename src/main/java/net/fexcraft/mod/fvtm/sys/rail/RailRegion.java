package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.RailData.XZK;
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
	
	private HashMap<Vec316f, Junction> junctions = new HashMap<>();
	public long lastaccess;
	private final RailData world;
	private final XZK key;

	public RailRegion(int i, int j, RailData root){
		key = new XZK(i, j); world = root; load();
	}

	public RailRegion load(){
		File file = new File(world.getRootFile(), "/railregions/" + key.x + "_" + key.z + ".dat");
		NBTTagCompound compound = null;
		if(file.exists()){
			try{ compound = CompressedStreamTools.read(file); } catch(IOException e){ e.printStackTrace(); }
		} else compound = new NBTTagCompound();
		//
		if(compound.hasKey("Junctions")){
			if(!junctions.isEmpty()) junctions.clear();
			NBTTagList list = (NBTTagList)compound.getTag("Junctions");
			for(NBTBase base : list){
				Junction junk = new Junction(world).read((NBTTagCompound)base);
				junctions.put(junk.getVec316f(), junk);
			}
		}
		//TODO entities
		return this.setAccessed();
	}
	
	public RailRegion save(){
		File file = new File(world.getRootFile(), "/railregions/" + key.x + "_" + key.z + ".dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		NBTTagCompound compound = new NBTTagCompound(); compound.setLong("Saved", Time.getDate());
		if(!junctions.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Junction junk : junctions.values()){
				list.appendTag(junk.write(null));
			}
		}
		//TODO entities
		if(compound.hasNoTags()){
			Print.log("RailRegion [" + key.toString() + "] has no data to save, skipping."); return this;
		}
		try{ CompressedStreamTools.write(compound, file); } catch(IOException e){ e.printStackTrace(); }
		Print.log("Saved RailRegion [" + key.toString() + "]."); return this;
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

}
