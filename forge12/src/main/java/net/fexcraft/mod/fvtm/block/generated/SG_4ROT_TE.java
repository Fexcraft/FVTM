package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SG_4ROT_TE extends G_4ROT_TE {

	public SG_4ROT_TE(Block type){
		super(type);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new SignalTileEntity(this);
	}

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote) return false;
        if(player.isSneaking()) return true;
        if(hand == EnumHand.MAIN_HAND){
            ItemStack held = player.getHeldItemMainhand();
            if(held.isEmpty()){
            	SignalTileEntity tile = (SignalTileEntity)world.getTileEntity(pos);
            	Print.chat(player, "&a[&6FVTM RAIL&a]>>&6==========================");
            	Print.chat(player, "&bSignal Status: " + (tile.getJuncPos() == null ? "&cnot linked" : "&alinked") + " &8| &bDir: &7" + tile.getDirection() + "/" + (tile.getSectionId()));
            	Print.chat(player, "&bJunction Position: " + (tile.getJuncPos() == null ? "&cnull" : "&a" + tile.getJuncPos()));
            	Print.chat(player, "&bJunction Status: " + (tile.getJunction() == null ? "&enot found/loaded" : tile.getValidatedJunctionStatus()));
            	return true;
            }
            else if(held.getItem() instanceof JunctionToolItem){
            	JunctionTrackingTileEntity.updateJunction(player, world.getTileEntity(pos), held);
            	return true;
            }
        }
        return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }
	
	@Override
    public boolean canProvidePower(IBlockState state){
        return true;
    }

    @Override
    public int getWeakPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side){
        return ((SignalTileEntity)world.getTileEntity(pos)).getSignalState() > 0 ? 15 : 0;
    }
    
    @Override
    public int getStrongPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side){
        return ((SignalTileEntity)world.getTileEntity(pos)).getSignalState() > 0 ? 15 : 0;
    }

}
