package net.fexcraft.mod.fvtm.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.fexcraft.lib.mc.api.KeyItem;
import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Material.MaterialItem;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
@fBlock(modid = FVTM.MODID, name = "container_block", item = ContainerBlock.ITB.class, tileentity = ContainerTileEntity.class)
public class ContainerBlock extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static ContainerBlock INSTANCE;

    public ContainerBlock(){
        super(Material.IRON, MapColor.BLACK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setCreativeTab(Tabs.BLOCKS);
        this.setSoundType(SoundType.METAL);
        //
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(50.0F);
        this.setResistance(280.0F);
        //
        INSTANCE = this;
    }

    public static class ITB extends ItemBlock {

        public ITB(Block block){
            super(block);
        }

        @Override
        public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
            return EnumActionResult.PASS;
        }

    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new ContainerTileEntity();
    }

    @Override
    public boolean isFullBlock(IBlockState state){
        return true;
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return FULL_BLOCK_AABB;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB.offset(pos);
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state, 2);
        ((ContainerTileEntity) world.getTileEntity(pos)).setUp(stack);
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
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(!world.isRemote){
            ContainerTileEntity tile = (ContainerTileEntity)world.getTileEntity(pos);
            tile.notifyBreak(world, pos, state, true);
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){
            ContainerTileEntity te = (ContainerTileEntity) world.getTileEntity(pos);
            if(te == null){
                Print.chat(player, "No TileEntity found.");
                return true;
            }
            if(!te.isCore() && te.getCorePos() == null){
                Print.chat(player, "Linked Core block is null! Removing...");
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                return true;
            }
            ItemStack stack = player.getHeldItem(hand);
            if(stack.getItem() instanceof KeyItem && (stack.getItem() instanceof MaterialItem ? ((MaterialItem) stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
                if(te.isLocked()){
                    te.unlock(world, player, stack, (KeyItem) stack.getItem());
                }
                else{
                    te.lock(world, player, stack, (KeyItem) stack.getItem());
                }
            }
            if(te.isLocked()){
                Print.chat(player, "Container is Locked.");
                return true;
            }
            if(stack.isEmpty()){
                if(te.getCore() == null){
                    Print.chat(player, "Container Core couldn't be found.");
                    return true;
                }
                BlockPos corepos = te.getCore().getPos();
                if(te.getContainerData().getContainer().getInventoryType() == InventoryType.ITEM){
                    player.openGui(FVTM.getInstance(), GuiHandler.CCG_Main, world, corepos.getX(), corepos.getY(), corepos.getZ());
                }
                else if(te.getContainerData().getContainer().getInventoryType() == InventoryType.FLUID){
                    te.sendFluidTankUpdate(player);
                    player.openGui(FVTM.getInstance(), GuiHandler.CONTAINER_FLUID_INVENTORY, world, corepos.getX(), corepos.getY(), corepos.getZ());
                }
                else{
                    Print.chat(player, "Unknown Inventory Type.");
                }
                return true;
            }
            else if(Static.dev()){
                Print.debug(te.getContainerData() == null ? "No Container." : te.getContainerData().writeToNBT(new NBTTagCompound()).toString());
            }
        }
        return false;
    }

    public static ArrayList<BlockPos> getPositions(ContainerData data, BlockPos pos, EnumFacing facing){
        ArrayList<BlockPos> list = new ArrayList<BlockPos>();
        facing = rotate90(facing);
        BlockPos core = new BlockPos(pos);
        boolean m = !data.getContainer().isLargeContainer();
        int xil = facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH ? -1 : m ? -3 : -6;
        int xal = facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH ? 2 : m ? 3 : 6;
        int zil = facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH ? m ? -3 : -6 : -1;
        int zal = facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH ? m ? 3 : 6 : 2;
        for(int x = xil; x < xal; x++){
            for(int y = 0; y < 3; y++){
                for(int z = zil; z < zal; z++){
                    list.add(core.add(x, y, z));
                }
            }
        }
        return list;
    }

    public static EnumFacing rotate90(EnumFacing facing){
        switch(facing){
            case DOWN:
                return EnumFacing.DOWN;
            case EAST:
                return EnumFacing.SOUTH;
            case NORTH:
                return EnumFacing.EAST;
            case SOUTH:
                return EnumFacing.WEST;
            case UP:
                return EnumFacing.UP;
            case WEST:
                return EnumFacing.NORTH;
            default:
                return null;
        }
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
        if(world.getTileEntity(pos) != null){
            try{
                ContainerTileEntity tile = (ContainerTileEntity)world.getTileEntity(pos);
                return tile.getContainerData().getContainer().getItemStack(tile.getContainerData());
            }
            catch(Exception e){
                //e.printStackTrace();
            }
        }
        return ItemStack.EMPTY;
    }
    
    @Override
    public int quantityDropped(Random random){
        return 0;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Items.AIR;
    }
    
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
        return new ItemStack(this);
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }

}
