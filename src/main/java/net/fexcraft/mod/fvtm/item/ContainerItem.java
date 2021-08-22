package net.fexcraft.mod.fvtm.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ContainerBlock;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerItem extends TypeCoreItem<Container> implements DataCoreItem<ContainerData> {

    public ContainerItem(Container core){
		super(core); this.setHasSubtypes(true); this.setMaxStackSize(1);
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getPath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(Resources.getCreativeTab(type));
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
    	if(!cache.overridesLang(false)) tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){ tooltip.add(Formatter.format(I18n.format(s, new Object[0]))); }
        ContainerData data = cache.getContainerData();
        if(data == null) return;
        tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
        tooltip.add(Formatter.format("&9Type: &7" + type.getContainerType().name()));
        //
        tooltip.add(Formatter.format("&9Capacity: &7" + (data.getType().getInventoryType() == InventoryType.FLUID ? data.getType().getCapacity() / 1000 : data.getType().getCapacity()) + " " + data.getType().getInventoryType().getUnitSuffix()));
        tooltip.add(Formatter.format("&9Content: &7" + (data.getFluidTank() == null || data.getFluidTank().getFluid() == null ? data.getInventory() == null ? "empty" : data.getInventory().stream().filter(is -> is != null && !is.isEmpty()).count() : data.getFluidTank().getFluidAmount() + "mB " + data.getFluidTank().getFluid().getLocalizedName())));
        if(data.getType().getContentFilter() != null){
            tooltip.add(Formatter.format("&9Content Filter: &7" + data.getType().getContentFilter().id()));
        }
    	tooltip.add(Formatter.format("&9LockCode: &7" + data.getLockCode()));
    }

	private String getTexTitle(ContainerData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).getName();
		} else return data.isExternalTexture() ? "external" : "internal";
	}

	@Override
	public ContainerData getData(ItemStack stack){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound()); return getData(stack.getTagCompound());
	}

	@Override
	public ContainerData getData(NBTTagCompound compound){
		return new ContainerData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || !(side == EnumFacing.UP)){ return EnumActionResult.PASS; }
        ContainerData data = player.getHeldItem(hand).getCapability(Capabilities.VAPDATA, null).getContainerData();
        BlockPos core = world.getBlockState(pos).getBlock().isReplaceable(world, pos) ? pos : pos.add(0, 1, 0);
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
