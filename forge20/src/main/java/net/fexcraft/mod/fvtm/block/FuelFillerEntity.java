package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerEntity extends BlockEntity implements FuelFiller.FuelFillerContainer {

    public FuelFiller filler;

    public FuelFillerEntity(BlockPos pos, BlockState state){
        super(FvtmGetters.FUELFILLER_ENT.get(), pos, state);
        filler = new FuelFiller();
    }

    @Override
    public CompoundTag getUpdateTag(){
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket(){
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void saveAdditional(CompoundTag compound){
        super.saveAdditional(compound);
        compound.put("filler", filler.save().local());
    }

    @Override
    public void load(CompoundTag compound){
        super.load(compound);
        if(compound.contains("filler")){
            filler.load(TagCW.wrap(compound.getCompound("filler")));
        }
    }

    @Override
    public FuelFiller getFuelFiller(){
        return filler;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing){
        if(capability == ForgeCapabilities.ITEM_HANDLER){
            return LazyOptional.of(filler.items.cast());
        }
        if(capability == ForgeCapabilities.FLUID_HANDLER){
            return LazyOptional.of(filler.tank.local());
        }
        return super.getCapability(capability, facing);
    }

    public static class Ticker implements BlockEntityTicker<FuelFillerEntity> {

        @Override
        public void tick(Level level, BlockPos pos, BlockState state, FuelFillerEntity ent){
            if(!level.isClientSide){
                ent.filler.update();
                ent.setChanged();
            }
        }

    }

}
