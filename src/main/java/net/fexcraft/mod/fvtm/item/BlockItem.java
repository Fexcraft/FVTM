package net.fexcraft.mod.fvtm.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
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

public class BlockItem extends ItemBlock16 implements DataCoreItem<BlockData> {
	
	private Block type;

    public BlockItem(net.minecraft.block.Block block) throws Exception {
		super(block); type = ((PlainBase)block).type;
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.getMaxStackSize());
		this.setRegistryName(block.getRegistryName());
		this.setTranslationKey(block.getTranslationKey());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        if(type.isFunctional()) tooltip.add(Formatter.format("&b&oFunctional Block"));
        if(type.isDecoration()) tooltip.add(Formatter.format("&e&oDecoration Block"));
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s, new Object[0])));
        }
        if(type.getBlockType().isGenericRoad()){
        	tooltip.add(Formatter.format("&9Height: &7" + (stack.getMetadata() == 0 ? 16 : stack.getMetadata())));
        }
        BlockData data = stack.getCapability(Capabilities.VAPDATA, null).getBlockData(); if(data == null) return;
        if(!data.getType().hasPlainModel()) tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
        if(type.getModel().getCreators().size() > 0){
            tooltip.add(Formatter.format("&9Model by:"));
            for(String str : type.getModel().getCreators()){
            	tooltip.add(Formatter.format("&7- " + str));
            }
        }
    }

	private String getTexTitle(BlockData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).getName();
		} else return data.isExternalTexture() ? "external" : "internal";
	}

	@Override
	public BlockData getData(ItemStack stack){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound()); return getData(stack.getTagCompound());
	}

	@Override
	public BlockData getData(NBTTagCompound compound){
		return new BlockData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(type.getBlockType().isMultiBlock() && !type.isFunctional()) return;
    	if(tab == CreativeTabs.SEARCH || tab == type.getAddon().getCreativeTab()){
    		if(type.getBlockType().isGenericRoad()){
	    		items.add(new ItemStack(this, 1, 0)); items.add(new ItemStack(this, 1, 12));
	    		items.add(new ItemStack(this, 1, 8)); items.add(new ItemStack(this, 1, 4));
	    		items.add(new ItemStack(this, 1, 2)); items.add(new ItemStack(this, 1, 1));
    		}
    		else{
        		items.add(type.newItemStack());
    		}
    	}
    }
    
    @Override
    public CreativeTabs getCreativeTab(){
        return type.getAddon().getCreativeTab();
    }
    
    @Override
    public int getItemBurnTime(ItemStack stack){
    	return type.getItemBurnTime() * stack.getCount();
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!type.getBlockType().isMultiBlock()) return super.onItemUse(player, world, pos, hand, side, hitX, hitY, hitZ);
        if(world.isRemote || side != EnumFacing.UP){
        	return EnumActionResult.PASS;
        }
        pos = pos.add(0, 1, 0);
        BlockPos core = world.getBlockState(pos).getBlock().isReplaceable(world, pos) ? pos : pos.add(0, 1, 0);
        ArrayList<BlockPos> poslist = type.getMultiBlock().getPositions(type, pos, player.getHorizontalFacing());
        if(isValidPostitionForMultiBlock(world, player, core, poslist)){
            ItemStack stack = player.getHeldItem(hand);
            stack.getTagCompound().setLong("PlacedPos", core.toLong());
            MultiBlock multi = type.getMultiBlock();
            for(int i = 0; i < poslist.size(); i++){
            	net.minecraft.block.Block block = net.minecraft.block.Block.REGISTRY.getObject(multi.getBlocks().get(i).getKey());
            	EnumFacing facing = player.getHorizontalFacing();
            	IBlockState state = block.getDefaultState().withProperty(Properties.FACING, MultiBlock.rotate(multi.getBlocks().get(i).getValue(), facing));
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

}
