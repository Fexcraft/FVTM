package net.fexcraft.mod.fvtm.data.block;

import com.google.gson.JsonObject;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class BlockFunction {

    public abstract BlockFunction parse(JsonObject obj);

    public abstract BlockFunction load(NBTTagCompound com);

    public abstract NBTTagCompound save(NBTTagCompound com);

    public abstract String id();

    public abstract BlockFunction copy(Block block);

    public static abstract class StaticBlockFunction extends BlockFunction {

        @Override
        public BlockFunction load(NBTTagCompound com){
            return this;
        }

        @Override
        public NBTTagCompound save(NBTTagCompound com){
            return null;
        }

        @Override
        public BlockFunction copy(Block block){
            return this;
        }

    }

    public void addInformation(ItemStack stack, World world, BlockData data, List<String> list, boolean adv){}

    public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        return false;
    }

}
