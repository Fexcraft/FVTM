package net.fexcraft.mod.fvtm.blocks.rail;

import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) **/
@fBlock(modid = FVTM.MODID, name = "rail_connector", tileentity = TrackTileEntity.class, item = TrackItemBlock.class)
public class TrackBlock extends Block implements ITileEntityProvider {
	
	public static TrackBlock INSTANCE;

	public TrackBlock(){
		super(Material.IRON, MapColor.GRAY);
		INSTANCE = this;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TrackTileEntity();//(world);
	}
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
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
    
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 0.25D, 1D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return AABB;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos){
        return AABB.offset(pos);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	world.getCapability(WorldRailDataSerializer.CAPABILITY, null).resetConnectionsAt(pos);
        super.breakBlock(world, pos, state);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || hand == EnumHand.OFF_HAND){ return false; }
        if(player.getHeldItem(hand).isEmpty()){
        	world.getCapability(WorldRailDataSerializer.CAPABILITY, null).toggleSwitch(pos);
        	return true;
        } return false;
    }
    
}