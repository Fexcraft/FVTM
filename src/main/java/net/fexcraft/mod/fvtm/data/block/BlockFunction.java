package net.fexcraft.mod.fvtm.data.block;

import com.google.gson.JsonObject;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

}
