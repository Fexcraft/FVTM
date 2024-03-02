package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;

import java.util.ArrayList;

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
	public String getFluid(){
		return fluid == null ? null : fluid.getName();
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
        compound.set(ctag, new TagCWI(tank.writeToNBT(new NBTTagCompound())));
        return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		tank.readFromNBT(compound.getCompound(ctag).local());
	}

	@Override
	public FluidTank getTank(){
		return tank;
	}

	@Override
	public String getContentDesc(){
		if(tank.getFluid() == null) return "";
		return tank.getFluidAmount() + "mB " + tank.getFluid().getLocalizedName();
	}

	@Override
	public void dropAllAt(EntityW entity){

	}

	@Override
	public void dropAllAt(WorldW world, V3I pos){

	}

	@Override
	public String getSavePrefix(){
		return "tank-";
	}

	@Override
	public ArrayList<StackEntry> getStacks(){
		return null;
	}

	@Override
	public <ISH> ISH getStackHandler(){
		return null;
	}

	@Override
	public Object getCapability(){
		return tank;
	}

	@Override
	public int getVarValue(){
		return tank.getFluidAmount();
	}

}
