package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.uni.UniEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class F2SW_4ROT_TE extends G_4ROT_TE {

	public F2SW_4ROT_TE(Block type){
		super(type);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new SwitchTileEntity(this);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote) return false;
		if(player.isSneaking()) return true;
		if(hand == EnumHand.MAIN_HAND){
			ItemStack held = player.getHeldItemMainhand();
			if(held.isEmpty()){
				SwitchTileEntity tile = (SwitchTileEntity)world.getTileEntity(pos);
				if(tile.getJunction() != null) tile.junction.onSwitchInteract(UniEntity.getEntity(player), tile, false);
				return true;
			}
			else if(held.getItem() instanceof JunctionToolItem && held.hasTagCompound() && held.getTagCompound().hasKey("fvtm:junction")){
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
        return ((SwitchTileEntity)world.getTileEntity(pos)).getSwitch0State() ? 15 : 0;
    }
    
    @Override
    public int getStrongPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side){
        return ((SwitchTileEntity)world.getTileEntity(pos)).getSwitch0State() ? 15 : 0;
    }

}
