package net.fexcraft.mod.addons.hcp.scripts;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;

public class LCCScript extends VehicleScript {

	@Override
	public String getId(){
		return "hcp:lcc";
	}

	@Override
	public String getName(){
		return "HCP LCC Script";
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data){
		//
	}

	@Override
	public VehicleScript read(VehicleData data, NBTTagCompound compound){
		//
		return this;
	}

	@Override
	public NBTTagCompound write(VehicleData data, NBTTagCompound compound){
		return compound;
	}

	@Override
	public void onSpawn(Entity entity, VehicleData data){
		//
	}

	@Override
	public void onRemove(Entity entity, VehicleData data){
		//
	}

	@Override
	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		//
		return false;
	}

	@Override
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand){
		//
		return false;
	}

	@Override
	public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){
		//
	}

}
