package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.*;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class BlockFunction {

    public abstract BlockFunction parse(JsonMap map);

    public abstract BlockFunction load(TagCW com);

    public abstract TagCW save(TagCW com);

    public abstract String id();

    public abstract BlockFunction copy(Block block);

    public static abstract class StaticBlockFunction extends BlockFunction {

        @Override
        public BlockFunction load(TagCW com){
            return this;
        }

        @Override
        public TagCW save(TagCW com){
            return null;
        }

        @Override
        public BlockFunction copy(Block block){
            return this;
        }

    }

    public void addInformation(StackWrapper stack, WorldW world, BlockData data, List<String> list, boolean adv){}

    public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, Passenger player, boolean mainhand){
        return false;
    }

    public static void sendClientUpdate(BlockData blockdata, V3I pos, int dim){
        Packets.INSTANCE.send(blockdata, pos, dim);
    }

    public static void sendClientUpdate(WorldW world, V3I pos){
        Packets.INSTANCE.send(world, pos);
    }

}
