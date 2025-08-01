package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.Optional;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerEntity extends BlockEntity implements FuelFiller.FuelFillerContainer {

    public FuelFiller filler;

    public FuelFillerEntity(BlockPos pos, BlockState state){
        super(Resources21.FUELFILLER_ENTITY, pos, state);
        filler = new FuelFiller();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider prov){
        CompoundTag tag = new CompoundTag();
        tag.put("filler", filler.save().local());
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket(){
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void saveAdditional(ValueOutput out){
        super.saveAdditional(out);
        out.store("filler", CompoundTag.CODEC, filler.save().local());
    }

    @Override
    public void loadAdditional(ValueInput in){
        super.loadAdditional(in);
        Optional<CompoundTag> com = in.read("filler", CompoundTag.CODEC);
        if(com.isPresent()){
            filler.load(TagCW.wrap(com.get()));
        }
    }

    @Override
    public FuelFiller getFuelFiller(){
        return filler;
    }

    /*@Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing){
        if(capability == ForgeCapabilities.ITEM_HANDLER){
            return LazyOptional.of(filler.items.cast());
        }
        if(capability == ForgeCapabilities.FLUID_HANDLER){
            return LazyOptional.of(filler.tank.local());
        }
        return super.getCapability(capability, facing);
    }*/

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
