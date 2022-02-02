package net.fexcraft.mod.fvtm.sys.tsign;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import scala.collection.mutable.LinkedHashMap;

public class TrafficSignData {
	
	private LinkedHashMap<String, String> backgrounds = new LinkedHashMap<>();
	private LinkedHashMap<String, String> components = new LinkedHashMap<>();
	private LinkedHashMap<String, Object> fonts = new LinkedHashMap<>();

	public TrafficSignData(NBTTagCompound com){
		//
	}

	public NBTTagCompound write(){
		//
		return new NBTTagCompound();
	}

	public void render(World world, float partialticks){
		//
	}

}
