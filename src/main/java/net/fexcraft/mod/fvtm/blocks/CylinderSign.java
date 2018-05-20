package net.fexcraft.mod.fvtm.blocks;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fBlock(modid = FVTM.MODID, name = "cyl_sign", tileentity = CylinderSignEntity.class, item = CylinderSign.CylSignItem.class)
public class CylinderSign extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public CylinderSign(){
        super(Material.IRON, MapColor.SNOW);
        //
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setCreativeTab(Tabs.BLOCKS);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new CylinderSignEntity();
    }

    public static final class CylSignItem extends ItemBlock16 {

        public static final String NBT = "CylSignURL";

        public CylSignItem(Block block){
            super(block);
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
            tooltip.add(stack.hasTagCompound() ? stack.getTagCompound().hasKey(NBT) ? stack.getTagCompound().getString(NBT) : "No URL." : "No tag.");
            if(stack.hasTagCompound() && stack.getTagCompound().hasKey("display")){
                stack.getTagCompound().setString(NBT, stack.getTagCompound().getCompoundTag("display").getString("Name"));
                stack.clearCustomName();
            }
        }

    }

    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
        ItemStack stack = new ItemStack(RegistryUtil.getBlock("fvtm:cyl_sign"));
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setString(CylSignItem.NBT, ((CylinderSignEntity) world.getTileEntity(pos)).getTexture().toString());
        if(world.isRemote){
            stack.getTagCompound().setString(CylSignItem.NBT, stack.getTagCompound().getString(CylSignItem.NBT).replace("fcl:remote/", ""));
        }
        //
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(CylSignItem.NBT, stack.getTagCompound().getString(CylSignItem.NBT));
        stack.getTagCompound().setTag("BlockEntityTag", nbt);
        return stack;
    }

    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(w.isRemote){
            return false;
        }
        CylinderSignEntity ent = (CylinderSignEntity) w.getTileEntity(pos);
        if(ent == null){
            return false;
        }
        if(player.getHeldItem(hand).isEmpty()){
            player.openGui(FVTM.getInstance(), 9213, w, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return false;
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return get((EnumFacing) state.getValue(FACING));
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return get((EnumFacing) state.getValue(FACING));
    }

    public static final AxisAlignedBB SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.05);
    public static final AxisAlignedBB NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.95, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB WEST = new AxisAlignedBB(0.95, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB EAST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.05, 1.0D, 1.0D);

    public static final AxisAlignedBB get(EnumFacing facing){
        switch(facing){
            case SOUTH:
                return SOUTH;
            case NORTH:
                return NORTH;
            case WEST:
                return WEST;
            case EAST:
            default:
                return EAST;
        }
    }

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
