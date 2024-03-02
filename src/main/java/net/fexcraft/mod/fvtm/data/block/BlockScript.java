package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public interface BlockScript {

	public void read(MultiBlockData data, TagCW tag);

	public TagCW write(MultiBlockData data, TagCW compound);

	public void onUpdate(MultiblockTickableTE tile);

	public boolean onTrigger(MultiBlockData data, MB_Interact trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, V3D hit);
	
	public default void sendPacket(TileEntity tile, NBTTagCompound packet){
		if(!packet.hasKey("target")) packet.setString("target", "script");
		ApiUtil.sendTileEntityUpdatePacket(tile, packet, 256);
	}

	public void onUpdatePacket(TileEntity tile, NBTTagCompound compound);

}
