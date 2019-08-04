package net.fexcraft.mod.fvtm.block;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
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

@fBlock(modid = FVTM.MODID, name = "constructor", tileentity = ConstructorEntity.class)
public class ConstructorBlock extends Block implements ITileEntityProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static ConstructorBlock INSTANCE;

    public ConstructorBlock(){
        super(Material.ANVIL, MapColor.OBSIDIAN); INSTANCE = this;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new ConstructorEntity();
    }

    @Override
    public boolean isFullBlock(IBlockState state){ return true; }

    @Override
    public boolean isFullCube(IBlockState state){ return true; }

    @Override
    public boolean isOpaqueCube(IBlockState state){ return false; }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return FULL_BLOCK_AABB;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB.offset(pos);
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
        EnumFacing facing = EnumFacing.getFront(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack){
        super.harvestBlock(worldIn, player, pos, state, (TileEntity)null, stack);
    }

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || hand == EnumHand.OFF_HAND) return false; if(player.isSneaking()) return true;
        ConstructorEntity te = (ConstructorEntity) world.getTileEntity(pos); if(te == null) return false;
        ItemStack held = player.getHeldItem(hand);
        if(held.isEmpty()){
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("target_listener", "fcl_gui");
            compound.setString("task", "open_gui");
            compound.setString("guimod", "fvtm");
            compound.setInteger("gui", 900);
            compound.setIntArray("args", new int[]{ pos.getX(), pos.getY(), pos.getZ() });
            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
            return true;
        }
        else if(held.getItem() instanceof MaterialItem){
        	//TODO
        }
        else if(held.getItem() instanceof PartItem){
        	if(te.getPartData() != null) te.dropPart(true);
        	te.setPartData(((PartItem)held.getItem()).getData(held), true);
        	Print.chat(player, "Part put into Constructor."); held.shrink(1);
        	//
        	GenericGui.openGui("fvtm", 906, new int[]{ pos.getX(), pos.getY(), pos.getZ() });
        }
        else if(held.getItem() instanceof VehicleItem){
        	if(te.getContainerData() != null) te.dropContainer(true);
        	if(te.getVehicleData() != null) te.dropVehicle(true);
        	if(te.getPartData() != null) te.dropPart(true);
        	te.setVehicleData(((VehicleItem)held.getItem()).getData(held), false);
        	te.updateClient(null); held.shrink(1);
        	Print.chat(player, "Vehicle put into Constructor.");
        }
        else if(held.getItem() instanceof ContainerItem){
        	if(te.getContainerData() != null) te.dropContainer(true);
        	if(te.getVehicleData() != null) te.dropVehicle(true);
        	if(te.getPartData() != null) te.dropPart(true);
        	te.setContainerData(((ContainerItem)held.getItem()).getData(held), false);
        	te.updateClient(null); held.shrink(1);
        	Print.chat(player, "Vehicle put into Constructor.");
        }
        //
        /*else*/ return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }

}

