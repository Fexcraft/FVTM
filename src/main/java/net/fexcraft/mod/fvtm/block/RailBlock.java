package net.fexcraft.mod.fvtm.block;

import java.util.Map.Entry;
import java.util.Random;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "rail")
public class RailBlock extends BlockContainer {
	
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
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return HEIGHTBOXES[state.getValue(HEIGHT)].offset(pos);
    }

    @Override
    public boolean isFullBlock(IBlockState state){
        return state.getValue(HEIGHT) == 0;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return false;//state.getValue(HEIGHT) == 0;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;//state.getValue(HEIGHT) == 0;
    }
    
	@Override
    public int getLightOpacity(IBlockState state){
    	return 0;//state.getValue(HEIGHT) == 0 ? 255 : 0;
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
    	if(Static.dev() && !world.isRemote && hand == EnumHand.MAIN_HAND && isJuncOrTool(player.getHeldItemMainhand())){
    		RailEntity tile = (RailEntity)world.getTileEntity(pos);
    		for(Entry<PathKey, Integer> key : tile.getTracks().entrySet()){
    			Print.bar(player, key.getKey() + " / " + key.getValue());
    		}
    		if(tile.control(world, true, player)) return true;
    	}
    	return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

    private boolean isJuncOrTool(ItemStack item){
		return item.getItem() instanceof JunctionToolItem || item.getItem() instanceof ItemTool;
	}

	@Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
		RailEntity tile = (RailEntity)world.getTileEntity(pos);
		if(tile == null || tile.getTracks().isEmpty()) return ItemStack.EMPTY;
		RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
		if(system == null) return ItemStack.EMPTY;
		Track track = system.getTrack((PathKey)tile.getTracks().keySet().toArray()[0]);
		if(track == null) return ItemStack.EMPTY;
		if(track.preset != null){
			return new ItemStack(Item.getByNameOrId(track.preset));
		}
		else{
			return new ItemStack(track.gauge.getItem());
		}
    }
    
    @Override
    public int quantityDropped(Random random){
        return 0;//1;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Items.AIR;//new ItemStack(this).getItem();
    }
    
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
        return ItemStack.EMPTY;//new ItemStack(this, 1, state.getValue(HEIGHT));
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new RailEntity();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(!world.isRemote){
    		((RailEntity)world.getTileEntity(pos)).remTracks(world);
        }
        super.breakBlock(world, pos, state);
    }
    
}