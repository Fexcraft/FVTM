package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

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
        filler.update();
    }

}
