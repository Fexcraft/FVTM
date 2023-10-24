package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.uni.world.EntityWI;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity {

	public VehicleInstance vehicle;
	public ArrayList<NWheelEntity> wheels = new ArrayList<>();
	public AxisAlignedBB renderbox;

	public RootVehicle(World world){
		super(world);
		vehicle = new VehicleInstance(new EntityWI(this), null);
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
