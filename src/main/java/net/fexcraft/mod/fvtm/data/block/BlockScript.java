package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
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

	public void read(MultiBlockData0 data, NBTTagCompound tag);

	public NBTTagCompound write(MultiBlockData0 data, NBTTagCompound compound);

	public void onUpdate(MultiblockTickableTE tile);

	public boolean onTrigger(MultiBlockData0 data, MB_Trigger trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, Vec3d hit);
	
	public default void sendPacket(TileEntity tile, NBTTagCompound packet){
		if(!packet.hasKey("target")) packet.setString("target", "script");
		ApiUtil.sendTileEntityUpdatePacket(tile, packet, 256);
	}

	public void onUpdatePacket(TileEntity tile, NBTTagCompound compound);

}
