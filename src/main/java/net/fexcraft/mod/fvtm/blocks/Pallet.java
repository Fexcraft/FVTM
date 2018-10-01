package net.fexcraft.mod.fvtm.blocks;

import com.google.common.base.Predicate;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.PalletUtil;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Pallet extends BlockContainer {

	public Pallet(String str){
		super(Material.WOOD, MapColor.GRAY);
		this.setCreativeTab(Tabs.BLOCKS);
        //
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(20.0F);
        this.setResistance(128.0F);
        //
        FVTM.getRegisterer().addBlock("pallet_" + str, this, PalletItem.class, 0, null);
	}
	
	public static class PalletItem extends ItemBlock16 {

		public PalletItem(Block block){ super(block); this.setRegistryName(block.getRegistryName()); this.setUnlocalizedName(this.getRegistryName().toString()); }
		
		public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
			IBlockState iblockstate = world.getBlockState(pos);
			Block block = iblockstate.getBlock();
			if(!block.isReplaceable(world, pos)){ pos = pos.offset(facing); }
			ItemStack itemstack = player.getHeldItem(hand);
			if(hand == EnumHand.OFF_HAND){
				int res = PalletUtil.getRotation(pos);
				if(res == -1){
					Print.bar(player, "Invalid pallet position");
					return EnumActionResult.FAIL;
				}
			}
			if(hand == EnumHand.MAIN_HAND){
				BlockPos blkpos = null, temppos = null;
				for(int x = -1; x < 2; x++){
					if(blkpos != null) break;
					for(int z = -1; z < 2; z++){
						if(x == 0 && z == 0) continue; temppos = pos.add(x, 0, z);
						if(world.getBlockState(temppos).getBlock() instanceof Pallet){ blkpos = temppos; break; }
					}
				}
				if(blkpos != null){
					Print.bar(player, "Colliding with Pallet at " + blkpos.toString() + "!");
					return EnumActionResult.FAIL;
				}
			}
			if(!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && world.mayPlace(this.block, pos, false, facing, (Entity)null)){
				int i = this.getMetadata(itemstack.getMetadata());
				IBlockState iblockstate1 = this.block.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, i, player, hand)
					.withProperty(GRIDPOS, hand == EnumHand.MAIN_HAND ? player.isSneaking() ? GridPos.CENTERED_90 : GridPos.CENTERED : player.isSneaking() ? GridPos.ROT0_90 : GridPos.ROT0);
				if(placeBlockAt(itemstack, player, world, pos, facing, hitX, hitY, hitZ, iblockstate1)){
					iblockstate1 = world.getBlockState(pos);
					SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, world, pos, player);
					world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					itemstack.shrink(1);
				}
				return EnumActionResult.SUCCESS;
			}
			else{
				return EnumActionResult.FAIL;
			}
		}
	}
	
    /*public static final PropertyBool ORIENT = PropertyBool.create("orientation");
    public static final PropertyBool CENTERED = PropertyBool.create("centered");
    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 3);*/
	
	public static final PropertyEnum<GridPos> GRIDPOS = PropertyEnum.<GridPos>create("grid",
		GridPos.class, GridPos.CENTERED, GridPos.ROT0, GridPos.ROT1, GridPos.ROT2, GridPos.ROT3,
		GridPos.CENTERED_90, GridPos.ROT0_90, GridPos.ROT1_90, GridPos.ROT2_90, GridPos.ROT3_90);
	
	public static enum GridPos implements Predicate<EnumFacing>, IStringSerializable {
		
		CENTERED("centered", false), ROT0("rot0", false), ROT1("rot1", false), ROT2("rot2", false), ROT3("rot3", false),
		CENTERED_90("centered_90", true), ROT0_90("rot0_90", true), ROT1_90("rot1_90", true), ROT2_90("rot2_90", true), ROT3_90("rot3_90", true);
		
		private String name;
		private boolean orient, centered;
		
		GridPos(String str, boolean orient){
			this.name = str; this.orient = orient;
			this.centered = str.contains("centered");
		}

		@Override
		public String getName(){
			return name;
		}

		@Override
		public boolean apply(EnumFacing input){
			return false;
		}

		public static GridPos fromInteger(int in, boolean orient){
			switch(in){ case 0: return orient ? ROT0_90 : ROT0; case 1: return orient ? ROT1_90 : ROT1; case 2: return orient ? ROT2_90 : ROT2; case 3: return orient ? ROT3_90 : ROT3; }
			return CENTERED;
		}
		
	}
    
    //@Override public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState){}
    
	@Override @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return super.getBoundingBox(state, source, pos);
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
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
    	if(!state.getValue(GRIDPOS).centered) return state.withProperty(GRIDPOS, GridPos.fromInteger(PalletUtil.getRotationForBlock(pos), state.getValue(GRIDPOS).orient)); else return state;
    }
    
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face){
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { GRIDPOS });
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(GRIDPOS, meta >= 2 ? meta % 2 == 1 ? GridPos.CENTERED_90 : GridPos.CENTERED : meta % 2 == 1 ? GridPos.ROT0_90 : GridPos.ROT0);
    }

    @Override
    public int getMetaFromState(IBlockState state){
    	boolean bool = state.getValue(GRIDPOS).orient, orient = state.getValue(GRIDPOS).centered;
        return bool ? orient ? 3 : 2 : orient ? 1 : 0;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	//
    	return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new PalletEntity(world, meta);
	}

}