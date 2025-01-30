package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.util.Properties;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MultiBlockItem extends Item implements ContentItem.ContentDataItem<MultiBlock, MultiBlockData> {

	private MultiBlock mblock;

    public MultiBlockItem(MultiBlock block) {
		super();
		mblock = block;
		setHasSubtypes(true);
		setMaxStackSize(1);
		setRegistryName(mblock.getID().colon());
		setTranslationKey(mblock.getID().colon());
        if(!EnvInfo.CLIENT) return;
        setCreativeTab((CreativeTabs)FvtmResources.INSTANCE.getCreativeTab(mblock));
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	tooltip.add(Formatter.format("&9Name: &7" + mblock.getName()));
        for(String s : mblock.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
    }

	@Override
	public MultiBlockData getData(StackWrapper stack){
        return getData(stack.directTag());
	}

	@Override
	public MultiBlockData getData(TagCW compound){
		return new MultiBlockData(mblock).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == getCreativeTab()){
            items.add(mblock.getNewStack().local());
    	}
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || side != EnumFacing.UP){
        	return EnumActionResult.PASS;
        }
        pos = pos.add(0, 1, 0);
        BlockPos core = world.getBlockState(pos).getBlock().isReplaceable(world, pos) ? pos : pos.add(0, 1, 0);
        ArrayList<V3I> poslist = mblock.getPositions(new V3I(pos.getX(), pos.getY(), pos.getZ()), WrapperHolder.getSide(player.getHorizontalFacing()));
        if(isValidPostitionForMultiBlock(world, player, core, poslist)){
            ItemStack stack = player.getHeldItem(hand);
            if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setLong("PlacedPos", core.toLong());
            EnumFacing facing = player.getHorizontalFacing();
            for(int i = 0; i < poslist.size(); i++){
            	net.minecraft.block.Block block = net.minecraft.block.Block.REGISTRY.getObject(mblock.getBlocks().get(i).getKey().local());
            	IBlockState state = block.getDefaultState().withProperty(Properties.FACING, MultiBlock.rotate(mblock.getBlocks().get(i).getValue(), facing).local());
                BlockPos blkpos = new BlockPos(poslist.get(i).x, poslist.get(i).y, poslist.get(i).z);
				state.getBlock().onBlockPlacedBy(world, blkpos, state.withProperty(Properties.FACING, facing), player, stack);
            }
            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    public static boolean isValidPostitionForMultiBlock(World world, EntityPlayer player, BlockPos pos, ArrayList<V3I> list){
        BlockPos obstacle = null;
		BlockPos.MutableBlockPos mut = new BlockPos.MutableBlockPos();
        IBlockState state = null;
        for(V3I blkpos : list){
            state = world.getBlockState(mut.setPos(blkpos.x, blkpos.y, blkpos.z));
            if(!state.getBlock().isReplaceable(world, mut)){
                obstacle = mut;
                break;
            }
        }
        if(obstacle != null){
            Print.bar(player, String.format("Obstacle at position: %sx, %sy, %sz!", obstacle.getX(), obstacle.getY(), obstacle.getZ()));
            return false;
        }
        else{
            return true;
        }
    }

	@Override
	public MultiBlock getContent(){
		return mblock;
	}

	@Override
	public ContentType getType(){
		return ContentType.MULTIBLOCK;
	}

}
