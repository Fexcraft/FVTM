package net.fexcraft.mod.fme.blocks;

import net.fexcraft.mod.fme.FME;
import net.fexcraft.mod.fme.overlay.SelectedPolygon;
import net.fexcraft.mod.fme.overlay.SelectedPolygon.PolygonType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FME.MODID, name = "editor", tileentity = EditorTileEntity.class)
public class EditorBlock extends Block implements ITileEntityProvider {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public EditorBlock(){
		super(Material.IRON, MapColor.GRAY);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new EditorTileEntity();
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
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.INVISIBLE;
    }
	
	public static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 5.0D, 0.75D);
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return PILLAR_AABB;
    }

	@Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return PILLAR_AABB;
    }
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote){
			return true;
		}
		EditorTileEntity te = (EditorTileEntity)w.getTileEntity(pos);
		if(te == null){
			return false;
		}
		if(!p.getHeldItem(hand).isEmpty()){
			ItemStack stack = p.getHeldItem(hand);
			if(stack.getItem() instanceof VehicleItem){
				if(te.vehicledata != null){
					droptilecon(te, w, pos);
				}
				te.vehicledata = ((VehicleItem)stack.getItem()).getVehicle(stack);
				Print.chat(p, "Vehicle: " + te.vehicledata.getVehicle().getName());
				p.getHeldItem(hand).shrink(64);
				//
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setTag("vehicledata", te.vehicledata.writeToNBT(new NBTTagCompound()));
				ApiUtil.sendTileEntityUpdatePacket(w, pos, nbt);
				return true;
			}
			else if(stack.getItem() instanceof ItemTool){
				if(te.vehicledata != null){
					droptilecon(te, w, pos);
				}
			}
		}
		else{
			if(Static.getServer().isSinglePlayer()){
				SelectedPolygon.toggleVisibility();
				if(SelectedPolygon.isVisible()){
					SelectedPolygon.selectNew(PolygonType.BOX, "none", 0);//TODO temporary
				}
			}
			else{
				Print.debug("... this block shouldn't even exists in multiplayer.");
			}
		}
		return true;
	}
	
	private static final void droptilecon(EditorTileEntity te, World w, BlockPos pos){
		ItemStack istack = te.vehicledata.getVehicle().getItemStack(te.vehicledata);
		EntityItem item = new EntityItem(w);
		item.setItem(istack);
		item.setPosition(pos.getX() + 0.5f, pos.getY() + 1.5d, pos.getZ() + 0.5f);
		w.spawnEntity(item);
		//
		te.vehicledata = null;
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("novehicle", true);
		ApiUtil.sendTileEntityUpdatePacket(w, pos, nbt);
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
        if (enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
}