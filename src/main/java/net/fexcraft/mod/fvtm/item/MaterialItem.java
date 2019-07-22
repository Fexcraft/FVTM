package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
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

public class MaterialItem extends TypeCoreItem<Material> {

    public MaterialItem(Material material){
		super(material); this.setHasSubtypes(true);
		this.setMaxStackSize(material.getMaxStackSize());
		this.setMaxDamage(material.getMaxDamage());
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getResourcePath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){ tooltip.add(Formatter.format(I18n.format(s, new Object[0]))); }
        if(type.getOreDictionaryId() != null){
        	tooltip.add(Formatter.format("&9OreDict: &7" + type.getOreDictionaryId()));
        }
        if(type.isVehicleKey()){
        	tooltip.add(Formatter.format("&9LockCode: &7" + this.getLockCode(stack)));
        }
    }
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	if(!Static.dev()) return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
        player.getHeldItem(hand).damageItem(1, player); return EnumActionResult.SUCCESS;
    }
    
    @Override
    public int getItemBurnTime(ItemStack stack){
    	return type.getItemBurnTime() * stack.getCount();
    }
    
    public String getLockCode(ItemStack stack){
    	if(!type.isVehicleKey()) return null;
    	if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
    	if(!stack.getTagCompound().hasKey("LockCode")) stack.getTagCompound().setString("LockCode", java.util.UUID.randomUUID().toString().substring(0, 8));
    	return stack.getTagCompound().getString("LockCode");
    }

}
