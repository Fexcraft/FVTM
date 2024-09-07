package net.fexcraft.mod.fvtm.data.impl;

import net.fexcraft.mod.fvtm.data.inv.InvHandlerFluid;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InvHandlerFluidImpl extends InvHandlerFluid {

	protected FluidTank tank;
	protected Fluid fluid;

	public InvHandlerFluidImpl(String fluidid, int cap){
		super(cap);
		fluid = FluidRegistry.getFluid(fluidid);
		tank = fluid == null ? new FluidTank(cap) : new FluidTank(fluid, 0, cap);
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
        compound.set(ctag, TagCW.wrap(tank.writeToNBT(new NBTTagCompound())));
		return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		tank.readFromNBT(compound.getCompound(ctag).local());
	}

	@Override
	public String getContentDesc(){
		if(tank.getFluid() == null) return "";
		return tank.getFluidAmount() + "mB " + tank.getFluid().getLocalizedName();
	}

	@Override
	public FluidTank getTank(){
		return tank;
	}

	@Override
	public int getVarValue(){
		return tank.getFluidAmount();
	}

}
