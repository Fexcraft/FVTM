package net.fexcraft.mod.fvtm.sys.uni;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity {

	public VehicleInstance vehicle;

	public RootVehicle(World world){
		super(world);
		//
	}

	@Override
	protected void entityInit(){

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){

	}

}
