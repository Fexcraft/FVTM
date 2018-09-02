package net.fexcraft.mod.fvtm.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//@fBlock(modid = FVTM.MODID, name = "road_line", item = GenericRoadLine.Item.class, tileentity = RoadLineTile.class)
public class GenericRoadLine extends BlockContainer {

	public GenericRoadLine(){
		super(Material.IRON, MapColor.CYAN);
		this.setCreativeTab(Tabs.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new RoadLineTile(world);
	}
	
	public static class Item extends ItemBlock {

		public Item(Block block){
			super(block);
			this.setCreativeTab(Tabs.BLOCKS);
		}
		
	    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
	    	if(!stack.hasTagCompound()){ tooltip.add("No Tag/Pos Data."); return; }
	    	for(int i = 0; i < 4; i++){
    			String str = stack.getTagCompound().hasKey("fvtm:roadconn" + i) ? BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadconn" + i)).toString() : "unset";
    			tooltip.add(Formatter.format("&9POS%s: &7%s", i + 1, str));
	    	}
	    }
		
		@Override
	    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        if(world.isRemote){
	        	return EnumActionResult.PASS;
	        }
	        IBlockState state = world.getBlockState(pos); Block block = state.getBlock(); ItemStack stack = player.getHeldItem(hand);
	        if(block instanceof GenericRoadLine){
	        	RoadLineTile rct = (RoadLineTile)world.getTileEntity(pos);
        		if(rct == null){
        			Print.bar(player, "No TileEntity at position.");
        			return EnumActionResult.SUCCESS;
        		}
	        	if(player.isSneaking()){
	        		rct.reset(); Print.bar(player, "&cResetting...");
	        		return EnumActionResult.SUCCESS;
	        	}
	        	else if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:roadconn")){
	        		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
	        		stack.getTagCompound().setLong("fvtm:roadconn0", pos.toLong());
	        		stack.getTagCompound().setByte("fvtm:roadconn", (byte)0);
	        		Print.bar(player, "&1First position cached (into itemstack).");
		            return EnumActionResult.SUCCESS;
	        	}
	        }
	        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:roadconn")){
	        	byte b = stack.getTagCompound().getByte("fvtm:roadconn");
	        	if(b >= 2 /*3*/){
		        	RoadLineTile rct = (RoadLineTile)world.getTileEntity(BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadconn0")));
	        		if(rct == null){
	        			Print.bar(player, "No TileEntity at position.");
	        			return EnumActionResult.SUCCESS;
	        		}
	        		BlockPos[] arr = new BlockPos[4];
	        		arr[0] = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadconn0"));
	        		arr[1] = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadconn1"));
	        		arr[2] = BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadconn2"));
	        		arr[3] = block.isReplaceable(world, pos) || block instanceof GenericRoadLine ? pos : pos.up();//BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:roadconn3"));
	        		rct.addLink(arr); Print.bar(player, "&1Link/Connection created.");
	        		stack.getTagCompound().removeTag("fvtm:roadconn");
	        		stack.getTagCompound().removeTag("fvtm:roadconn0");
	        		stack.getTagCompound().removeTag("fvtm:roadconn1");
	        		stack.getTagCompound().removeTag("fvtm:roadconn2");
		            return EnumActionResult.SUCCESS;
	        	}
	        	else{
	        		stack.getTagCompound().setLong("fvtm:roadconn" + ++b, block.isReplaceable(world, pos) || block instanceof GenericRoadLine ? pos.toLong() : pos.up().toLong());
	        		stack.getTagCompound().setByte("fvtm:roadconn", b);
	        		Print.bar(player, "&1Position " + (b + 1) + " cached (into itemstack).");
		            return EnumActionResult.SUCCESS;
	        	}
	        }
	        else{
		        if(!block.isReplaceable(world, pos)){
		            pos = pos.offset(facing);
		        }
		        if(!stack.isEmpty() && player.canPlayerEdit(pos, facing, stack) && world.mayPlace(this.block, pos, false, facing, (Entity)null)){
		            int i = this.getMetadata(stack.getMetadata());
		            IBlockState nstate = this.block.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, i, player, hand);
		            if(placeBlockAt(stack, player, world, pos, facing, hitX, hitY, hitZ, nstate)){
		                nstate = world.getBlockState(pos); SoundType soundtype = nstate.getBlock().getSoundType(nstate, world, pos, player);
		                world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
		                stack.shrink(1);
		            }
		            return EnumActionResult.SUCCESS;
		        }
	        }
	        return EnumActionResult.FAIL;
	    }
		
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
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	RoadLineTile rct = (RoadLineTile)world.getTileEntity(pos);
        if(rct != null && rct.connections.length > 0){
            for(BlockPos[] blkpos : rct.connections){
            	RoadLineTile tile = (RoadLineTile)world.getTileEntity(blkpos[2]);
            	if(tile != null){ tile.delLink(pos); }
            }
        }
        super.breakBlock(world, pos, state);
    }
    
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return AABB;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos){
        return AABB.offset(pos);
    }
    
    //
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if(enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }
	
}