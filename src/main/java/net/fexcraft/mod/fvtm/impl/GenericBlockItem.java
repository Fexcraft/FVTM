package net.fexcraft.mod.fvtm.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.blocks.ContainerBlock;
import net.fexcraft.mod.fvtm.blocks.UniversalBlock;
import net.fexcraft.mod.fvtm.impl.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericBlockItem extends Item implements BlockItem {

    public static GenericBlockItem INSTANCE = new GenericBlockItem();

    public GenericBlockItem(){
    	//super(UniversalBlock.INSTANCE);
    	INSTANCE = this;
        //this.setCreativeTab(Tabs.BLOCKS);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setRegistryName("fvtm:block");
        this.setUnlocalizedName(this.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static class ItemMeshDef implements net.minecraft.client.renderer.ItemMeshDefinition {

        @Override
        public final net.minecraft.client.renderer.block.model.ModelResourceLocation getModelLocation(ItemStack stack){
            if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
                return new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
            }
            return new net.minecraft.client.renderer.block.model.ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            BlockData con = stack.getCapability(VAPDataCache.CAPABILITY, null).getBlockData();
            if(con == null){ return; }
        	this.setMaxStackSize(con.getBlock().isFunctional() ? 1 : 64);
            tooltip.add(Formatter.format("&9Name: &7" + con.getBlock().getName()));
            tooltip.add(Formatter.format("&9Type: &7" + (con.getBlock().isFunctional() ? "functional" : "decorational")));
            for(String s : con.getBlock().getDescription()){
                tooltip.add(Formatter.format(s));
            }
            tooltip.add(Formatter.format("&9Selected Texture: &7" + con.getSelectedTexture()));
            if(con.getBlock().getModel() != null && con.getBlock().getModel().getCreators().size() > 0){
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
                tooltip.add(Formatter.format("&6Model by:"));
                for(String string : con.getBlock().getModel().getCreators()){
                    try{
                        tooltip.add(Formatter.format("&7- &3" + Static.getPlayerNameByUUID(UUID.fromString(string))));
                    }
                    catch(Exception e){
                        tooltip.add(Formatter.format("&7- &3" + string));
                    }
                }
            }
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
            for(Block con : Resources.BLOCKS.getValuesCollection()){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, con.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
        if(tab instanceof GenericCreativeTab){
            Addon addon = ((GenericCreativeTab)tab).getAddon();
            Collection<Block> coll = Resources.BLOCKS.getValuesCollection().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
            for(Block con : coll){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, con.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        if(stack.hasTagCompound()){
            return "item." + stack.getTagCompound().getString(NBTKEY);
        }
        return this.getUnlocalizedName();
    }

	@Override
	public BlockData getBlock(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.getBlockData(stack.getTagCompound());
        }
        return null;
	}
	
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || !(facing == EnumFacing.UP)){
            return EnumActionResult.PASS;
        }
        BlockData data = Resources.getBlockData(player.getHeldItem(hand).getTagCompound());
        BlockPos core = pos.add(0, 1, 0);
        if(isValidPostitionForBlock(world, player, core, player.getHorizontalFacing(), data)){
            ItemStack stack = player.getHeldItem(hand);
            stack.getTagCompound().setLong("PlacedPos", core.toLong());
            UniversalBlock.getPositions(data, core, player.getHorizontalFacing()).forEach((relpos, blkpos) -> {
                IBlockState state = UniversalBlock.INSTANCE.getDefaultState();
                stack.getTagCompound().setLong("RelativePos", relpos.toLong());
                state.getBlock().onBlockPlacedBy(world, blkpos, state.withProperty(ContainerBlock.FACING, player.getHorizontalFacing()), player, stack);
            });
            stack.shrink(64);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    public static boolean isValidPostitionForBlock(World world, EntityPlayer player, BlockPos pos, EnumFacing opposite, BlockData data){
        Collection<BlockPos> list = UniversalBlock.getPositions(data, pos, opposite).values();
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
