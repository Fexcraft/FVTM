package net.fexcraft.mod.fvtm.block;

import static net.fexcraft.mod.fvtm.util.Properties.FACING;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
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
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorBlock extends Block implements ITileEntityProvider {

	public static ConstructorBlock INSTANCE;
	public static ItemBlock ITEM;

    public ConstructorBlock(){
        super(Material.ANVIL, MapColor.OBSIDIAN);
		setRegistryName("fvtm:constructor");
		setTranslationKey(getRegistryName().toString());
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing facing = EnumFacing.byIndex(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return getDefaultState().withProperty(FACING, facing);
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
		if(te.getLiftPos() == null){
			player.sendMessage(new TextComponentTranslation("interact.fvtm.constructor.nolift"));
			MutableBlockPos mpos = new MutableBlockPos();
			boolean found = false;
			for(int y = -1; y < 2; y++){
				if(found) break;
				for(int x = -7; x < 8; x++){
					if(found) break;
					for(int z = -7; z < 8; z++){
						TileEntity tile = world.getTileEntity(mpos.setPos(te.getPos().getX() + x, te.getPos().getY() + y, te.getPos().getZ() + z));
						/*if(tile == null || tile instanceof ConstCenterEntity == false) continue;
						ConstCenterEntity lte = (ConstCenterEntity)tile;
						if(lte.getConstPos() == null || lte.getConstTile() == null){
							lte.setConst(te);
							te.setLiftPos(lte.getPos());
							found = true;
							break;
						}*/
					}
				}
			}
			if(found){
				player.sendMessage(new TextComponentTranslation("interact.fvtm.constructor.liftfound", mpos.getX(), mpos.getY(), mpos.getZ()));
			}
			else{
				player.sendMessage(new TextComponentTranslation("interact.fvtm.constructor.noliftfound"));
			}
			return true;
		}
        ItemStack held = player.getHeldItem(hand);
        if(held.isEmpty()){
			Passenger pass = player.getCapability(Capabilities.PASSENGER, null).asWrapper();
			pass.openUI(UIKeys.CONSTRUCTOR, new V3I(pos.getX(), pos.getY(), pos.getZ()));
            return true;
        }
        else if(held.getItem() instanceof VehicleItem){
        	te.dropIfContainsAnyThing();
        	te.setVehicleData(((VehicleItem)held.getItem()).getDataFromTag(held.getTagCompound()), false);
        	te.liftstate = 0;
        	te.updateClient(null);
			held.shrink(1);
        	Print.chat(player, I18n.format("interact.fvtm.constructor.vehicle"));
        }
        else if(held.getItem() instanceof ContainerItem){
        	te.dropIfContainsAnyThing();
        	te.setContainerData(((ContainerItem)held.getItem()).getDataFromTag(held.getTagCompound()), false);
        	te.liftstate = 0;
        	te.updateClient(null);
			held.shrink(1);
			Print.chat(player, I18n.format("interact.fvtm.constructor.container"));
        }
        else if(held.getItem() instanceof BlockItem){
        	te.dropIfContainsAnyThing();
        	te.setBlockData(((BlockItem)held.getItem()).getDataFromTag(held.getTagCompound()), false);
        	te.liftstate = 0;
        	te.updateClient(null);
			held.shrink(1);
			Print.chat(player, I18n.format("interact.fvtm.constructor.block"));
        }
        //
        return true;
    }

}

