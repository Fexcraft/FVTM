package net.fexcraft.mod.fvtm.data.container;

import com.sun.istack.internal.Nullable;

import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

/**  @author Ferdinand Calo' (FEX___96) */
public class ContainerSlot {
	
	public ContainerData[] containers;
	public ContainerType onlytype;
	public Vec3d position;
	public float rotation;
	public byte length;
	public String id;
	
	/** Constructor only for loading from NBT. */
	public ContainerSlot(){}
	
	/** Constructor to create new ContainerSlots. */
	public ContainerSlot(String id, byte length, Vec3d pos, float rotation, @Nullable ContainerType lock){
		this.containers = new ContainerData[this.length = length]; onlytype = lock;
		this.id = id; this.position = pos; this.rotation = rotation;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		if(onlytype != null) compound.setString("Type", onlytype.name());
		compound.setByte("Length", length);
		compound.setString("Name", id);
		compound.setDouble("PositionX", position.x);
		compound.setDouble("PositionY", position.y);
		compound.setDouble("PositionX", position.z);
		compound.setFloat("RotationY", rotation);
		for(byte i = 0; i < containers.length; i++){
			if(containers[i] == null) continue;
			compound.setTag("Slot" + i, containers[i].write(new NBTTagCompound()));
		} return compound;
	}
	
	public ContainerSlot read(NBTTagCompound compound){
		if(!compound.hasKey("Length")){
			try{ throw new Exception("Container slot could not be loaded, compound is missing length data."); }
			catch(Exception e){ e.printStackTrace(); }
		} id = compound.getString("Name"); onlytype = null;
		if(compound.hasKey("Type")) onlytype = ContainerType.valueOf(compound.getString("Type"));
		position = new Vec3d(compound.getDouble("PositionX"), compound.getDouble("PositionY"), compound.getDouble("PositionZ"));
		rotation = compound.getFloat("RotationY");
		containers = new ContainerData[length = compound.getByte("Length")];
		for(byte i = 0; i < containers.length; i++){
			if(!compound.hasKey("Slot" + i)) continue;
			containers[i] = Resources.getContainerData(compound.getCompoundTag("Slot" + i));
		} return this;
	}

	public void clear(){
		containers = new ContainerData[length];
	}
	
	@Override
	public String toString(){
		return "ContainerSlot[" + id + ", " + length + ", " + rotation + "];";
	}
	
	/** True if filled, false otherwise. */
	public boolean[] getFillStateArray(){
		boolean[] bools = new boolean[length];
		for(int i = 0; i < containers.length; i++){
			if(containers[i] != null){
				int l = containers[i].getContainerType().length();
				if(l > 1){
					for(int j = 0; j < l; j++){
						if(j + i > bools.length) break;
						bools[j + i] = true;
					}
				}
				else{ bools[i] = true; }
			}
		} return bools;
	}
	
}
