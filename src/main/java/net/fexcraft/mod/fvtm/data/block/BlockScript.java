package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public interface BlockScript {

	public void read(MultiBlockData data, NBTTagCompound tag);

	public NBTTagCompound write(MultiBlockData data, NBTTagCompound compound);

	public void onUpdate(TickableTE tickableTE);

	public void onTrigger(MultiBlockData data, MB_Trigger trigger, EntityPlayer player, EnumHand hand, BlockPos pos, IBlockState state, EnumFacing side, Vec3d hit);

}
