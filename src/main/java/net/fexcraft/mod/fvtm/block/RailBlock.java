package net.fexcraft.mod.fvtm.block;

import java.util.Random;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "rail")
public class RailBlock extends Block {
	
	public static RailBlock INSTANCE;

	public RailBlock(){
		super(Material.ROCK, MapColor.BLACK);
		INSTANCE = this;
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(256.0F);
		this.setResistance(1024f);
        this.setDefaultState(this.blockState.getBaseState().withProperty(HEIGHT, 0));
	}
	
    public static final PropertyInteger HEIGHT = PropertyInteger.create("height", 0, 15);
    public static final AxisAlignedBB[] HEIGHTBOXES = new AxisAlignedBB[16];
    static{
    	HEIGHTBOXES[0] = FULL_BLOCK_AABB;
    	for(int i = 1; i < 16; i++){
    		HEIGHTBOXES[i] = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, i * Static.sixteenth, 1.0D);
    	}
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return HEIGHTBOXES[state.getValue(HEIGHT)];
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
    	return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
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