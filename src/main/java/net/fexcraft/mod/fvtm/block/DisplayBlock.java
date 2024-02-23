package net.fexcraft.mod.fvtm.block;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@fBlock(modid = FVTM.MODID, name = "display_block", tileentity = DisplayEntity.class, item = DisplayBlock.Item.class)
public class DisplayBlock extends Block implements ITileEntityProvider {

	public static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.9D, 0.0D, 1.0D, 0.0D, 1.0D);
    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);
	public static DisplayBlock INSTANCE = null;

    public DisplayBlock(){
        super(Material.IRON, MapColor.SNOW); INSTANCE = this;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new DisplayEntity();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote){
            return false;
        }
        if(!player.getHeldItem(hand).isEmpty()){
            DisplayEntity te = (DisplayEntity) world.getTileEntity(pos);
            ItemStack stack = player.getHeldItem(hand);
            if(stack.getItem() instanceof ItemTool){
                if(te.getVehicleData() != null && te.getVehicleData().getLock().isLocked()){
                    Print.bar(player, "VehicleData is locked.");
                }
                else{
                    int i = this.getMetaFromState(state) + 1;
                    i = i > 15 ? 0 : i < 0 ? 15 : i;
                    world.setBlockState(pos, state.withProperty(ROTATION, i), 2);
                    Print.bar(player, "ROT: " + te.getBlockMetadata());
                }
            }
            else if(stack.getItem() instanceof VehicleItem){
                if(te.getVehicleData() != null && te.getVehicleData().getLock().isLocked()){
                    Print.bar(player, "VehicleData is locked.");
                }
                else{
                    VehicleData data = ((VehicleItem)stack.getItem()).getDataFromTag(stack.getTagCompound());
                    VehicleData oldata = te.setVehicleData(data);
                    te.sendUpdate();
                    //
                    if(oldata != null){
                        EntityItem ent = new EntityItem(world);
                        ent.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                        ent.setItem(oldata.newItemStack().local());
                        world.spawnEntity(ent);
                    }
                }
            }
            else if(stack.getItem() instanceof MaterialItem ){//TODO && ((MaterialItem)stack.getItem()).getType().isVehicleKey()){
                if(te.getVehicleData() == null){
                    Print.bar(player, "No VehicleData.");
                }
                else{
                    /*KeyItem item = (KeyItem) stack.getItem();
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
                    }*///TODO locking.
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
        return AABB.offset(pos);
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
        return new BlockStateContainer(this, new IProperty[]{ ROTATION });
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        DisplayEntity conte = (DisplayEntity) world.getTileEntity(pos);
        if(conte.getVehicleData() != null){
            ItemStack stack = conte.getVehicleData().newItemStack().local();
            EntityItem entity = new EntityItem(world, conte.getPos().getX() + 0.5, conte.getPos().getY() + 1.5f, conte.getPos().getZ() + 0.5, stack);
            world.spawnEntity(entity);
        }
        super.breakBlock(world, pos, state);
    }
    
    public static class Item extends ItemBlock16 {

		public Item(Block block){ super(block); }
		
	    @SideOnly(Side.CLIENT)
	    @Override
	    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
	        tooltip.add(Formatter.format("&9Rightclick with an Vehicle Item to add/replace."));
	        tooltip.add(Formatter.format("&7Rightclick with a Tool Item to rotate."));
	        tooltip.add(Formatter.format("&8Rightclick with a Key Item to lock/unlock."));
	    }

	}

}
