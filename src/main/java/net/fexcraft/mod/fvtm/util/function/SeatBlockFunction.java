package net.fexcraft.mod.fvtm.util.function;

import static net.fexcraft.mod.fvtm.util.AnotherUtil.toV3;

import java.util.List;

import com.google.gson.JsonObject;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.entity.BlockSeat;
import net.fexcraft.mod.uni.Pos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SeatBlockFunction extends BlockFunction.StaticBlockFunction {

    private Pos offset;

    @Override
    public BlockFunction parse(JsonObject obj){
        if(obj != null && obj.has("pos")) offset = Pos.fromJson(obj.get("pos"), true);
        else offset = new Pos(0, 8, 0);
        return this;
    }

    @Override
    public String id() {
        return "fvtm:seat";
    }

    public Pos getOffset(){
        return offset;
    }

    @Override
    public void addInformation(ItemStack stack, World world, BlockData data, List<String> list, boolean adv){
        list.add(Formatter.format("&eSittable Block."));
    }

    @Override
    public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(hand == EnumHand.OFF_HAND) return false;
        if(!player.isRiding()){
            BlockSeat seat = new BlockSeat(world);
            Vec3d vec = toV3(offset).add(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            seat.setPosition(vec.x, vec.y, vec.z);
            world.spawnEntity(seat);
            player.startRiding(seat);
            //TODO support for leashed entities
            return true;
        }
        return false;
    }

}
