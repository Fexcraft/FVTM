package net.fexcraft.mod.fvtm.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Material.MaterialItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.item.PaintItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "constructor_controller", tileentity = ConstructorControllerEntity.class)
public class ConstructorController extends Block implements ITileEntityProvider {

    public static ConstructorController INSTANCE;

    public ConstructorController() throws Exception {
        super(Material.ANVIL, MapColor.OBSIDIAN);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setCreativeTab(Tabs.BLOCKS);
        INSTANCE = this;
        //
        //FVTM.getRegisterer().addBlock("constructor_controller", this, null, 1, null);
        //GameRegistry.registerTileEntity(ConstructorControllerEntity.class, this.getRegistryName().toString());
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new ConstructorControllerEntity();
    }

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    /*@Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }*/

    @Override
    public boolean isFullBlock(IBlockState state){
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return true;
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

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack){
        if(te instanceof IWorldNameable && ((IWorldNameable)te).hasCustomName()){
            player.addStat(StatList.getBlockStats(this));
            player.addExhaustion(0.005F);
            if(worldIn.isRemote){ return; }
            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
            Item item = this.getItemDropped(state, worldIn.rand, i);
            if(item == Items.AIR){ return; }
            ItemStack itemstack = new ItemStack(item, this.quantityDropped(worldIn.rand));
            itemstack.setStackDisplayName(((IWorldNameable)te).getName());
            spawnAsEntity(worldIn, pos, itemstack);
        }
        else{
            super.harvestBlock(worldIn, player, pos, state, (TileEntity)null, stack);
        }
    }
    
    @Override
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param){
        /*super.eventReceived(state, worldIn, pos, id, param);*/ TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }

    //<-- VANILLA END -->//
    private void remOld(World world, BlockPos pos, ConstructorControllerEntity te){
        ItemStack istack = null;
        if(te.getVehicleData() != null){
            istack = te.getVehicleData().getVehicle().getItemStack(te.getVehicleData());
        }
        if(te.getContainerData() != null){
            istack = te.getContainerData().getContainer().getItemStack(te.getContainerData());
        }
        if(istack != null){
            EntityItem item = new EntityItem(world);
            item.setItem(istack);
            item.setPosition(pos.getX() + 0.5f, pos.getY() + 1.5d, pos.getZ() + 0.5f);
            world.spawnEntity(item);
        }
    }

    private boolean isLocked(EntityPlayer player, ConstructorControllerEntity te){
        if(te.getVehicleData() == null && te.getContainerData() == null){
            return false;
        }
        else if(te.getVehicleData() != null){
            if(te.getVehicleData().isLocked()){
                Print.chat(player, "Current VehicleData is locked.");
            }
            return te.getVehicleData().isLocked();
        }
        else if(te.getContainerData() != null){
            if(te.getContainerData().isLocked()){
                Print.chat(player, "Current ContainerData is locked.");
            }
            return te.getContainerData().isLocked();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(w.isRemote/* || hand == EnumHand.OFF_HAND*/){
            /*ConstructorControllerEntity te = (ConstructorControllerEntity)w.getTileEntity(pos);
			te.hitX = hitX;
			te.hitY = hitY;
			te.hitZ = hitZ;
			//Print.debugChat("HITX: " + hitX + " | HITY: " + hitY + " | HITZ: " + hitZ);
			//te.setState("0101010101");
			//te.lift += Static.rad10;*/
            return false;
        }
        ConstructorControllerEntity te = (ConstructorControllerEntity) w.getTileEntity(pos);
        if(te == null){
            return false;
        }
        if(!p.getHeldItem(hand).isEmpty()){
            ItemStack stack = p.getHeldItem(hand);
            if(stack.getItem() instanceof VehicleItem || stack.getItem() instanceof ContainerItem){
                boolean vehicle = stack.getItem() instanceof VehicleItem;
                if(isLocked(p, te)){
                    return true;
                }
                remOld(w, pos, te);
                te.setData(stack);
                if(vehicle){
                    Print.chat(p, "Vehicle: " + te.getVehicleData().getVehicle().getName());
                }
                else{
                    Print.chat(p, "Container: " + te.getContainerData().getContainer().getName());
                };
                p.getHeldItem(hand).shrink(64);
                te.sendUpdate(null);
                return true;
            }
            else if(stack.getItem() instanceof PartItem){
                if(isLocked(p, te)){
                    return true;
                }
                /*if(te.getVehicleData() == null){
                    Print.chat(p, te.getContainerData() == null ? "No Vehicle in Constructor." : "Containers do not hold parts.");
                    return true;
                }*/
                PartData data = ((PartItem)stack.getItem()).getPart(stack);
                if(data == null){
                    return false;
                }
                if(te.getVehicleData() == null){
                    te.setPartData(data);
                    Print.chat(p, "Part put into Constructor. (" + data.getPart().getName() + ")");
                    p.getHeldItem(hand).shrink(1);
                    te.sendUpdate(null); p.openGui(FVTM.getInstance(), GuiHandler.CCG_PartInstaller, w, pos.getX(), pos.getY(), pos.getZ());
                	return true;
                }
                if(data.getPart().getCategories().size() > 1 || (p.isSneaking() && !te.getVehicleData().getParts().containsKey(data.getPart().getCategory()))){
                    if(data.getPart().installable(data.getPart().getCategory(), te.getVehicleData(), p)){
                        te.setPartData(data);
                        Print.chat(p, "Part put into Constructor. (" + data.getPart().getName() + ")");
                        p.getHeldItem(hand).shrink(1);
                        te.sendUpdate(null); p.openGui(FVTM.getInstance(), GuiHandler.CCG_PartInstaller, w, pos.getX(), pos.getY(), pos.getZ());
                    }
                }
                else{
                    if(!te.getVehicleData().getParts().containsKey(data.getPart().getCategory())){
                        if(data.getPart().installable(data.getPart().getCategory(), te.getVehicleData(), p)){
                            te.getVehicleData().installPart(data.getPart().getCategory(), data);
                            Print.chat(p, "Part installed. (" + data.getPart().getName() + ")");
                            p.getHeldItem(hand).shrink(1);
                            te.sendUpdate(null);
                        }
                    }
                    else{
                        Print.chat(p, "Part of that category is already installed.");
                    }
                }
                return true;
            }
            else if(stack.getItem() instanceof PaintItem){
                if(isLocked(p, te)){
                    return true;
                }
                if(te.getColorable() == null){
                    Print.chat(p, "No Colorable Objects.");
                    return true;
                }
                if(hand == EnumHand.OFF_HAND){
                    te.getColorable().getSecondaryColor().packed = (((PaintItem) stack.getItem()).getRGBColor()).packed;
                }
                else{
                    te.getColorable().getPrimaryColor().packed = (((PaintItem) stack.getItem()).getRGBColor()).packed;
                }
                te.sendUpdate("rgb");
                Print.chat(p, "Colour updated.");
                return true;
            }
            else if(stack.getItem() instanceof ItemDye){
                if(isLocked(p, te)){
                    return true;
                }
                if(te.getColorable() == null){
                    Print.chat(p, "No Colorable Objects.");
                    return true;
                }
                EnumDyeColor dyecolor = EnumDyeColor.byDyeDamage(stack.getMetadata());
                if(hand == EnumHand.OFF_HAND){
                    te.getColorable().getSecondaryColor().packed = RGB.fromDyeColor(dyecolor).packed;
                }
                else{
                    te.getColorable().getPrimaryColor().packed = RGB.fromDyeColor(dyecolor).packed;
                }
                stack.shrink(1);
                te.sendUpdate("rgb");
            }
            else if(stack.getItem() instanceof KeyItem && (stack.getItem() instanceof MaterialItem ? ((MaterialItem) stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
                if(te.getLockable() == null){
                    Print.bar(p, "No Lockable Objects.");
                }
                else{
                    boolean veh = te.getLockable() instanceof VehicleData;
                    KeyItem item = (KeyItem) stack.getItem();
                    if(!te.getLockable().isLocked()){
                        if(item.getCode(stack).equals(te.getLockable().getLockCode())){
                            te.getLockable().setLocked(true);
                            Print.chat(p, "VehicleData locked.");
                        }
                        else if(item.getType(stack) == KeyItem.KeyType.ADMIN){
                            te.getLockable().setLocked(true);
                            Print.chat(p, "&8[&aAO&8] &7" + (veh ? "Vehicle" : "Container") + "Data locked.");
                        }
                        else{
                            Print.chat(p, "Invalid code!");
                            Print.chat(p, item.getCode(stack) + " != " + te.getLockable().getLockCode());
                        }
                        Print.debug(te.getLockable().isLocked());
                    }
                    else{
                        if(item.getCode(stack).equals(te.getLockable().getLockCode())){
                            te.getLockable().setLocked(false);
                            Print.chat(p, (veh ? "Vehicle" : "Container") + "Data unlocked.");
                        }
                        else if(item.getType(stack) == KeyItem.KeyType.ADMIN){
                            te.getLockable().setLocked(false);
                            Print.chat(p, "&8[&aAO&8] &7" + (veh ? "Vehicle" : "Container") + "Data unlocked.");
                        }
                        else{
                            Print.chat(p, "Invalid code!");
                            Print.chat(p, item.getCode(stack) + " != " + te.getLockable().getLockCode());
                        }
                    }
                    te.sendUpdate(null);
                }
                return true;
            }
        }
        else{
            if(isLocked(p, te)){
                return true;
            }
            if(hand != EnumHand.OFF_HAND){
                if(!findAndPressButton(te, w, pos, state, p, side, hitX, hitY, hitZ)){
                    p.openGui(FVTM.getInstance(), GuiHandler.CCG_Main, w, te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
                }
            }
            return true;
        }
        return false;
    }

    private boolean findAndPressButton(ConstructorControllerEntity te, World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
        boolean found = false;
        if(side == EnumFacing.UP){
            //Print.debugChat(hitX + " ||| " + hitZ);
            int x = calculateCoord(hitX);
            int z = calculateCoord(hitZ);
            //Print.debugChat(x + " ||| " + z);
            //Print.debugChat(state.getValue(FACING).toString());
            ConstructorButton button = ConstructorButton.findButton(state.getValue(FACING), x, z);
            if(button != null){
                //Print.debugChat(button.name());
                if(button.ID < 10){
                    te.onButtonPress(button, p, null);
                }
                else{
                    te.addLift(button.ID == 10 ? 1 : -1);
                }
                found = true;
            }
        }
        return found;
    }

    private final int calculateCoord(float coords){
        int i = 0;
        while((coords - 0.0625) > 0){
            coords -= 0.0625;
            i++;
        }
        if(coords > 0){
            i++;
        }
        return i;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        ConstructorControllerEntity conte = (ConstructorControllerEntity)world.getTileEntity(pos);
        if(conte.getVehicleData() != null){
            ItemStack stack = conte.getVehicleData().getVehicle().getItemStack(conte.getVehicleData());
            EntityItem entity = new EntityItem(world, conte.getPos().getX() + 0.5, conte.getPos().getY() + 1.5f, conte.getPos().getZ() + 0.5, stack);
            world.spawnEntity(entity);
        }
        if(conte.getContainerData() != null){
            ItemStack stack = conte.getContainerData().getContainer().getItemStack(conte.getContainerData());
            EntityItem entity = new EntityItem(world, conte.getPos().getX() + 0.5, conte.getPos().getY() + 1.5f, conte.getPos().getZ() + 0.5, stack);
            world.spawnEntity(entity);
        }
        if(conte.getPartData() != null){
            ItemStack stack = conte.getPartData().getPart().getItemStack(conte.getPartData());
            EntityItem entity = new EntityItem(world, conte.getPos().getX() + 0.5, conte.getPos().getY() + 1.5f, conte.getPos().getZ() + 0.5, stack);
            world.spawnEntity(entity);
        }
        super.breakBlock(world, pos, state); //world.removeTileEntity(pos);
    }

}
