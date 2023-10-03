package net.fexcraft.mod.fvtm.block;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorBlock extends Block implements ITileEntityProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static ConstructorBlock INSTANCE;
	public static ItemBlock ITEM;

    public ConstructorBlock(){
        super(Material.ANVIL, MapColor.OBSIDIAN);
		setRegistryName("fvtm:constructor");
		setTranslationKey(getRegistryName().toString());
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new ConstructorEntity();
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
		return false;
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
        EnumFacing facing = EnumFacing.byIndex(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{ FACING });
    }

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || hand == EnumHand.OFF_HAND) return false;
		if(player.isSneaking()) return true;
        ConstructorEntity te = (ConstructorEntity)world.getTileEntity(pos);
		if(te == null) return false;
        ItemStack held = player.getHeldItem(hand);
        if(held.isEmpty()){
        	player.openGui(FVTM.getInstance(), CONSTRUCTOR_MAIN, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        else if(held.getItem() instanceof VehicleItem){
        	te.dropIfContainsAnyThing();
        	te.setVehicleData(((VehicleItem)held.getItem()).getData(held), false);
        	te.liftstate = 0;
        	te.updateClient(null);
			held.shrink(1);
        	Print.chat(player, I18n.format("interact.fvtm.constructor.vehicle"));
        }
        else if(held.getItem() instanceof ContainerItem){
        	te.dropIfContainsAnyThing();
        	te.setContainerData(((ContainerItem)held.getItem()).getData(held), false);
        	te.liftstate = 0;
        	te.updateClient(null);
			held.shrink(1);
			Print.chat(player, I18n.format("interact.fvtm.constructor.container"));
        }
        else if(held.getItem() instanceof BlockItem){
        	te.dropIfContainsAnyThing();
        	te.setBlockData(((BlockItem)held.getItem()).getData(held), false);
        	te.liftstate = 0;
        	te.updateClient(null);
			held.shrink(1);
			Print.chat(player, I18n.format("interact.fvtm.constructor.block"));
        }
        //
        return true;
    }

}

