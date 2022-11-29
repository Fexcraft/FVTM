package net.fexcraft.mod.fvtm.data.inv;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;

public class InvHandlerFluid extends InvHandler {
	
	protected FluidTank tank;
	protected Fluid fluid;

	public InvHandlerFluid(String fluidid, int cap){
		super(InvType.FLUID);
		capacity = cap;
		fluid = FluidRegistry.getFluid(fluidid);
		tank = fluid == null ? new FluidTank(cap) : new FluidTank(fluid, 0, cap);
	}

	@Override
	public Fluid getFluid(){
		return fluid;
	}

	@Override
	public NBTTagCompound save(NBTTagCompound compound){
        tank.writeToNBT(compound);
        return compound;
	}

	@Override
	public void load(NBTTagCompound compound){
        tank.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound save(NBTTagCompound compound, String ctag){
        compound.setTag(ctag, tank.writeToNBT(new NBTTagCompound()));
        return compound;
	}

	@Override
	public void load(NBTTagCompound compound, String ctag){
		tank.readFromNBT(compound.getCompoundTag(ctag));
	}

	public FluidTank getTank(){
		return tank;
	}

	@Override
	public String getContentDesc(){
		if(tank.getFluid() == null) return super.getContentDesc();
		return tank.getFluidAmount() + "mB " + tank.getFluid().getLocalizedName();
	}

	@Override
	public Object getCapObj(){
		return tank;
	}

	@Override
	public int getVarValue(){
		return tank.getFluidAmount();
	}

}
