package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.blocks.ContainerBlock;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericContainerItem extends Item implements ContainerItem {

    public static final GenericContainerItem INSTANCE = new GenericContainerItem();

    public GenericContainerItem(){
        this.setCreativeTab(Tabs.VEHICLE_PRESETS);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setRegistryName("fvtm:container");
        this.setUnlocalizedName(this.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static class ItemMeshDef implements net.minecraft.client.renderer.ItemMeshDefinition {

        @Override
        public final net.minecraft.client.renderer.block.model.ModelResourceLocation getModelLocation(ItemStack stack){
            if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
                return new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
            }
            return new net.minecraft.client.renderer.block.model.ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            ContainerData con = Resources.getContainerData(stack.getTagCompound());
            if(con == null){
                return;
            }
            tooltip.add(Formatter.format("&9Name: &7" + con.getContainer().getName()));
            tooltip.add(Formatter.format("&9Type: &7" + con.getContainer().getType().name()));
            for(String s : con.getContainer().getDescription()){
                tooltip.add(Formatter.format(s));
            }
            tooltip.add(Formatter.format("&9Capacity: &7" + (con.getContainer().getInventoryType() == InventoryType.FLUID ? con.getContainer().getInventorySize() / 1000 : con.getContainer().getInventorySize()) + " " + con.getContainer().getInventoryType().getUnitsName()));
            tooltip.add(Formatter.format("&9Content: &7" + (con.getFluidTank() == null || con.getFluidTank().getFluid() == null ? con.getInventory() == null ? "empty" : con.getInventory().stream().filter(is -> is != null && !is.isEmpty()).count() : con.getFluidTank().getFluidAmount() + "mB " + con.getFluidTank().getFluid().getLocalizedName())));
            if(con.getContainer() instanceof GenericContainer && ((GenericContainer) con.getContainer()).contenttype != null){
                tooltip.add(Formatter.format("&9Content Group: &7" + ((GenericContainer) con.getContainer()).contenttype));
            }
            //tooltip.add(Formatter.format("&9LoadType: &7" + con.getContainer().getInventoryType().getName()));
            tooltip.add(Formatter.format("&9Selected Texture: &7" + con.getSelectedTexture()));
            if(con.getContainer().getModel() != null && con.getContainer().getModel().getCreators().size() > 0){
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
                tooltip.add(Formatter.format("&6Model by:"));
                for(String string : con.getContainer().getModel().getCreators()){
                    try{
                        tooltip.add(Formatter.format("&7- &3" + Static.getPlayerNameByUUID(UUID.fromString(string))));
                    }
                    catch(Exception e){
                        tooltip.add(Formatter.format("&7- &3" + string));
                    }
                }
            }
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
            for(Container con : Resources.CONTAINERS.getValues()){
                if(con.getClass().equals(GenericContainer.class)){
                    for(int i = 0; i < con.getTextures().size(); i++){
                        ItemStack stack = new ItemStack(this);
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString(NBTKEY, con.getRegistryName().toString());
                        NBTTagCompound com = new NBTTagCompound();
                        com.setInteger("SelectedTexture", i);
                        nbt.setTag(FVTM.MODID + "_container", com);
                        stack.setTagCompound(nbt);
                        items.add(stack);
                    }
                }
                else{
                    ItemStack stack = new ItemStack(this);
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString(NBTKEY, con.getRegistryName().toString());
                    stack.setTagCompound(nbt);
                    items.add(stack);
                }
            }
        }
        if(tab instanceof GenericCreativeTab){
            Addon addon = ((GenericCreativeTab)tab).getAddon();
            Collection<Container> coll = Resources.CONTAINERS.getValues().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
            for(Container con : coll){
                if(con.getClass().equals(GenericContainer.class)){
                    for(int i = 0; i < con.getTextures().size(); i++){
                        ItemStack stack = new ItemStack(this);
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString(NBTKEY, con.getRegistryName().toString());
                        NBTTagCompound com = new NBTTagCompound();
                        com.setInteger("SelectedTexture", i);
                        nbt.setTag(FVTM.MODID + "_container", com);
                        stack.setTagCompound(nbt);
                        items.add(stack);
                    }
                }
                else{
                    ItemStack stack = new ItemStack(this);
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString(NBTKEY, con.getRegistryName().toString());
                    stack.setTagCompound(nbt);
                    items.add(stack);
                }
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        if(stack.hasTagCompound()){
            return "item." + stack.getTagCompound().getString(NBTKEY);
        }
        return this.getUnlocalizedName();
    }

    @Override
    public ContainerData getContainer(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.getContainerData(stack.getTagCompound());
        }
        return null;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || !(facing == EnumFacing.UP)){
            return EnumActionResult.PASS;
        }
        ContainerData data = Resources.getContainerData(player.getHeldItem(hand).getTagCompound());
        BlockPos core = pos.add(0, 1, 0);
        if(isValidPostitionForContainer(world, player, core, player.getHorizontalFacing(), data)){
            ItemStack stack = player.getHeldItem(hand);
            stack.getTagCompound().setLong("PlacedPos", core.toLong());
            ContainerBlock.getPositions(data, core, player.getHorizontalFacing()).forEach(blkpos -> {
                IBlockState state = ContainerBlock.INSTANCE.getDefaultState();
                state.getBlock().onBlockPlacedBy(world, blkpos, state.withProperty(ContainerBlock.FACING, player.getHorizontalFacing()), player, stack);
            });
            stack.shrink(64);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    public static boolean isValidPostitionForContainer(World world, EntityPlayer player, BlockPos pos, EnumFacing opposite, ContainerData data){
        ArrayList<BlockPos> list = ContainerBlock.getPositions(data, pos, opposite);
        BlockPos obstacle = null;
        IBlockState state = null;
        for(BlockPos blkpos : list){
            state = world.getBlockState(blkpos);
            if(!state.getBlock().isReplaceable(world, blkpos)){
                obstacle = blkpos;
                break;
            }
        }
        if(obstacle != null){
            Print.bar(player, String.format("Obstacle at position: %sx, %sy, %sz!", obstacle.getX(), obstacle.getY(), obstacle.getZ()));
            return false;
        }
        else{
            return true;
        }
    }

}
