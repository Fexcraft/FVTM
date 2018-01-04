package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "display_block", tileentity = DisplayBlockEntity.class)
public class DisplayBlock extends BlockContainer {

	public static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.9D, 0.0D, 1.0D, 0.0D, 1.0D);
	public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);

	public DisplayBlock(){
		super(Material.IRON, MapColor.SNOW);
		this.setCreativeTab(Tabs.BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new DisplayBlockEntity();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return false;
		}
		if(!player.getHeldItem(hand).isEmpty()){
			DisplayBlockEntity te = (DisplayBlockEntity)world.getTileEntity(pos);
			ItemStack stack = player.getHeldItem(hand);
			if(stack.getItem() instanceof ItemTool){
				if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
					Print.bar(player, "VehicleData is locked.");
				}
				else{
					int i = this.getMetaFromState(state) + 1;
					i = i > 15 ? 0 : i < 0 ? 15 : i;
					world.setBlockState(pos, state.withProperty(ROTATION, i), 2);
					Print.bar(player, "ROT: " + te.getBlockMetadata());
				}
			}
			else if(stack.getItem() instanceof Vehicle.VehicleItem){
				if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
					Print.bar(player, "VehicleData is locked.");
				}
				else{
					Vehicle.VehicleData data = ((Vehicle.VehicleItem)stack.getItem()).getVehicle(stack);
					Vehicle.VehicleData oldata = te.setVehicleData(data);
					te.sendUpdate();
					//
					if(oldata != null){
						EntityItem ent = new EntityItem(world);
						ent.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
						ent.setItem(oldata.getVehicle().getItemStack(oldata));
						world.spawnEntity(ent);
					}
				}
			}
			else if(stack.getItem() instanceof KeyItem && (stack.getItem() instanceof net.fexcraft.mod.fvtm.api.Material.MaterialItem ? ((net.fexcraft.mod.fvtm.api.Material.MaterialItem)stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
				if(te.getVehicleData() == null){
					Print.bar(player, "No VehicleData.");
				}
				else{
					KeyItem item = (KeyItem)stack.getItem();
					Vehicle.VehicleData data = te.getVehicleData();
					if(!data.isLocked()){
						if(item.getCode(stack).equals(data.getLockCode())){
							data.setLocked(true);
							Print.chat(player, "VehicleData locked.");
						}
						else if(item.getType(stack) == KeyItem.KeyType.ADMIN){
							data.setLocked(true);
							Print.chat(player, "&8[&aAO&8] &7VehicleData locked.");
						}
						else{
							Print.chat(player, "Invalid code!");
							Print.chat(player, item.getCode(stack) + " != " + data.getLockCode());
						}
					}
					else{
						if(item.getCode(stack).equals(data.getLockCode())){
							data.setLocked(false);
							Print.chat(player, "VehicleData unlocked.");
						}
						else if(item.getType(stack) == KeyItem.KeyType.ADMIN){
							data.setLocked(false);
							Print.chat(player, "&8[&aAO&8] &7VehicleData unlocked.");
						}
						else{
							Print.chat(player, "Invalid code!");
							Print.chat(player, item.getCode(stack) + " != " + data.getLockCode());
						}
					}
				}
			}
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
		return AABB;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
		return AABB;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(ROTATION, 0);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		worldIn.setBlockState(pos, state.withProperty(ROTATION, 0), 2);
	}

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState().withProperty(ROTATION, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(ROTATION);
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, new IProperty[] {ROTATION});
	}

}
