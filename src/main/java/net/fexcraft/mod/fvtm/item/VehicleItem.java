package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Vehicle;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
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
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(s));
        }
        VehicleData data = this.getData(stack); if(data == null) return;
        tooltip.add(Formatter.format("&9Weight: &7" + data.getAttribute("weight").getCurrentValue() + "kg"));
        //TODO texture/pos data
        //TODO model data
        //TODO other data
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

}
