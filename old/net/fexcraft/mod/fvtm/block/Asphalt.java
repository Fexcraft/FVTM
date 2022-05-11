package net.fexcraft.mod.fvtm.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fBlock(modid = FVTM.MODID, name = "asphalt", item = Asphalt.AsphaltItem.class, variants = 16)
public class Asphalt extends Block {
	
	public static Asphalt INSTANCE;

	public Asphalt(){
		super(Material.ROCK, MapColor.BLACK); INSTANCE = this;
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(8.0F);
		this.setResistance(2000.0F);
		this.setSoundType(SoundType.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(HEIGHT, 0));
	}
	
    public static final PropertyInteger HEIGHT = PropertyInteger.create("height", 0, 15);
    public static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[16];
    static{
    	BOUNDING_BOXES[0] = FULL_BLOCK_AABB;
    	for(int i = 1; i < 16; i++){
    		BOUNDING_BOXES[i] = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, i * Static.sixteenth, 1.0D);
    	}
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return BOUNDING_BOXES[state.getValue(HEIGHT)];
    }

    @Override
    public boolean isFullBlock(IBlockState state){
        return state.getValue(HEIGHT) == 0;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return state.getValue(HEIGHT) == 0;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return state.getValue(HEIGHT) == 0;
    }
    
	@Override
    public int getLightOpacity(IBlockState state){
    	return state.getValue(HEIGHT) == 0 ? 255 : 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, HEIGHT);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(HEIGHT, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(HEIGHT);
    }
    
    @Override
    public int damageDropped(IBlockState state){
        return state.getValue(HEIGHT);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	if(world.isRemote) return player.getHeldItem(hand).getItem() instanceof AsphaltItem;
    	ItemStack stack = player.getHeldItem(hand);
    	if(stack.getItem() instanceof AsphaltItem && state.getValue(HEIGHT) > 0){
    		int height = state.getValue(HEIGHT) + stack.getMetadata(); if(height >= 16) height = 0; if(height < 0) height = 0;
    		world.setBlockState(pos, state.withProperty(HEIGHT, height), 2);
    		if(!player.capabilities.isCreativeMode) stack.shrink(1);
    		return true;
    	} else return false;
    }
    
    public static class AsphaltItem extends ItemBlock16 {

		public AsphaltItem(Block block){
			super(block); this.setHasSubtypes(true);
		}
		
	    @SideOnly(Side.CLIENT) @Override
	    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
	        tooltip.add(Formatter.format("&9Height: &7" + (stack.getMetadata() == 0 ? 16 : stack.getMetadata())));
	    }
		
	    @Override
	    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
	    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
	    		items.add(new ItemStack(this, 1, 0)); items.add(new ItemStack(this, 1, 12));
	    		items.add(new ItemStack(this, 1, 8)); items.add(new ItemStack(this, 1, 4));
	    		items.add(new ItemStack(this, 1, 2)); items.add(new ItemStack(this, 1, 1));
	    	}
	    }
    	
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
        return getItem(world, pos, state);
    }
    
    @Override
    public int quantityDropped(Random random){
        return 1;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return new ItemStack(this).getItem();
    }
    
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
        return new ItemStack(this, 1, state.getValue(HEIGHT));
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }
    
}