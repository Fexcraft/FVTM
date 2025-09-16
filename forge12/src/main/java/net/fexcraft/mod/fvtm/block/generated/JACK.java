package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.uni.inv.UniStack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JACK extends G_4ROT_TE {

    public JACK(Block type){
        super(type);
    }

	@Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta){
		return new JACK_TE(this);
	}

	@Override
	public boolean isFullBlock(IBlockState state){
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(player.getHeldItem(hand).getItem() instanceof ItemDye) return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
        if(!world.isRemote){
			if(player.isSneaking()){
				JACK_TE te = (JACK_TE)world.getTileEntity(pos);
				if(te != null){
					te.dropVehicle(true);
					te.markChanged();
				}
				return true;
			}
			if(player.getHeldItemMainhand().getItem() instanceof VehicleItem){
				JACK_TE te = (JACK_TE)world.getTileEntity(pos);
				if(te != null){
					te.dropVehicle(false);
					te.vehicle = UniStack.get(player.getHeldItemMainhand()).stack.getContent(ContentType.VEHICLE.item_type);
					te.sendVehUpdate();
					te.markChanged();
					if(!player.capabilities.isCreativeMode) player.getHeldItemMainhand().shrink(1);
					return true;
				}
			}
            return false;
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(!world.isRemote){
			JACK_TE te = (JACK_TE)world.getTileEntity(pos);
			if(te != null) te.dropVehicle(false);
			EntityItem item = new EntityItem(world);
			item.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
			item.setItem(type.getNewStack().local());
			world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

}

