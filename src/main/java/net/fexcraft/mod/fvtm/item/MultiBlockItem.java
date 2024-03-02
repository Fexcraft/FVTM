package net.fexcraft.mod.fvtm.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.block.MultiBlock0;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.Properties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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

public class MultiBlockItem extends TypeCore.TypeCoreItem<MultiBlock0> implements DataCoreItem<MultiBlockData>{;//}, ItemTex<MultiBlock> {

	@SideOnly(Side.CLIENT)
	private CreativeTabs ctab;

    public MultiBlockItem(MultiBlock0 block) {
		super(block);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		//TODO item registry this.type.getAddon().getFCLRegisterer().addItem(type.getRegistryName().getPath(), this, 0, null);
		if(Static.side().isServer()) return;
		//TODO ctab = Resources.getCreativeTab(type);
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
    }

	@Override
	public MultiBlockData getData(ItemStack stack){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
        return getData(stack.getTagCompound());
	}

	@Override
	public MultiBlockData getData(NBTTagCompound compound){
		return new MultiBlockData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == ctab){
            items.add(type.newItemStack());
    	}
    }
    
    @Override
    public CreativeTabs getCreativeTab(){
        return ctab;
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || side != EnumFacing.UP){
        	return EnumActionResult.PASS;
        }
        pos = pos.add(0, 1, 0);
        BlockPos core = world.getBlockState(pos).getBlock().isReplaceable(world, pos) ? pos : pos.add(0, 1, 0);
        ArrayList<BlockPos> poslist = type.getPositions(pos, player.getHorizontalFacing());
        if(isValidPostitionForMultiBlock(world, player, core, poslist)){
            ItemStack stack = player.getHeldItem(hand);
            if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setLong("PlacedPos", core.toLong());
            EnumFacing facing = player.getHorizontalFacing();
            for(int i = 0; i < poslist.size(); i++){
            	net.minecraft.block.Block block = net.minecraft.block.Block.REGISTRY.getObject(type.getBlocks().get(i).getKey());
            	IBlockState state = block.getDefaultState().withProperty(Properties.FACING, MultiBlock0.rotate(type.getBlocks().get(i).getValue(), facing));
                state.getBlock().onBlockPlacedBy(world, poslist.get(i), state.withProperty(Properties.FACING, facing), player, stack);
            }
            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    public static boolean isValidPostitionForMultiBlock(World world, EntityPlayer player, BlockPos pos, ArrayList<BlockPos> list){
        BlockPos obstacle = null;
        IBlockState state = null;
        for(BlockPos blkpos : list){
            state = world.getBlockState(blkpos);
            if(!state.getBlock().isReplaceable(world, blkpos)){
                obstacle = blkpos;
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

    //@Override
    public TypeCore<MultiBlock0> getDataType(){
        return type;
    }
}
