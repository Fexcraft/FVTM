package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.data.PartData;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorEntity extends TileEntity {
	
	private VehicleData vdata;
	private PartData pdata;
	
	public ConstructorEntity(){
		
	}

	public void processGUIPacket(Side side, NBTTagCompound packet, EntityPlayer player){
		//TODO
	}
	
	public VehicleData getVehicleData(){
		return vdata;
	}
	
	public PartData getPartData(){
		return pdata;
	}

}
