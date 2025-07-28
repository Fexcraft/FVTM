package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.uni.inv.UniFluidTank;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;

public class FuelFillerEntity extends TileEntity implements FuelFiller.FuelFillerContainer, ITickable {

    public FuelFiller filler;

	public FuelFillerEntity(){
        filler = new FuelFiller();
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag(){
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setTag("filler", filler.save().local());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("filler")){
            filler.load(TagCW.wrap(compound.getCompoundTag("filler")));
        }
    }

    @Override
    public FuelFiller getFuelFiller(){
        return filler;
    }

    @Override
    public void update(){
        if(!world.isRemote){
            filler.update();
            markDirty();
        }
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return filler.items.cast();
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
            return filler.tank.local();
        }
        return super.getCapability(capability, facing);
    }

}
