package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VehicleItem extends TypeCoreItem<Vehicle> implements DataCoreItem<VehicleData> {

    public VehicleItem(Vehicle core){
		super(core); this.setHasSubtypes(true); this.setMaxStackSize(1);
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getResourcePath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){ tooltip.add(Formatter.format(s)); }
        VehicleData data = this.getData(stack); if(data == null) return;
        tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
        tooltip.add(Formatter.format("&9Weight: &7" + data.getAttribute("weight").getCurrentString() + "kg"));
        tooltip.add(Formatter.format("&9Seats: &7" + data.getSeats().size()));
        //temporary
        /*if(flag.isAdvanced() && !data.getAttributes().isEmpty()){
        	for(Attribute attr : data.getAttributes().values()){
        		tooltip.add(Formatter.format("&9" + attr.getId() + ": &7" + attr.getCurrentString()));
        	}
        }*/
        //TODO texture/pos data
        //TODO model data
        //TODO other data
    }

	private String getTexTitle(VehicleData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).getName();
		} else return data.isExternalTexture() ? "external" : "internal";
	}

	@Override
	public VehicleData getData(ItemStack stack){
		return getData(stack.getTagCompound() == null ? new NBTTagCompound() : stack.getTagCompound());
	}

	@Override
	public VehicleData getData(NBTTagCompound compound){
		return new VehicleData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
    	if(world.isRemote || side != EnumFacing.UP) return EnumActionResult.PASS; ItemStack stack = player.getHeldItem(hand);
    	if(world.getBlockState(pos).getBlock() instanceof ConstructorBlock) return EnumActionResult.PASS;
    	world.spawnEntity(new LandVehicle(world, ((VehicleItem)stack.getItem()).getData(stack), new Vec3d(pos.up(2)), player, -1));
        return EnumActionResult.SUCCESS;
    }

}
