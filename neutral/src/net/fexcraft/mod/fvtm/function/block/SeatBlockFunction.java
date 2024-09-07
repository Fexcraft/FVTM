package net.fexcraft.mod.fvtm.function.block;

import java.util.List;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SeatBlockFunction extends BlockFunction.StaticBlockFunction {

    private V3D offset;

    @Override
    public BlockFunction parse(JsonMap map){
        offset = ContentConfigUtil.getVector(map.getArray("pos"));
        return this;
    }

    @Override
    public String id() {
        return "fvtm:seat";
    }

    public V3D getOffset(){
        return offset;
    }

    @Override
    public void addInformation(StackWrapper stack, WorldW world, BlockData data, List<String> list, boolean adv){
        list.add(Formatter.format("&eSittable Block."));
    }

    @Override
    public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, Passenger player, boolean main){
        if(!main) return false;
        if(!player.isRiding()){
            world.spawnBlockSeat(offset.add(pos.x + 0.5, pos.y, pos.z + 0.5), player);
            //TODO support for leashed entities
            return true;
        }
        return false;
    }

}
