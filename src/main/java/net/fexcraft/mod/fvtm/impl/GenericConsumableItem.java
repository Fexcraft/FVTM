package net.fexcraft.mod.fvtm.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.api.Addon;

import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Consumable.ConsumableItem;
import net.fexcraft.mod.fvtm.util.APIs;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericConsumableItem extends ConsumableItem {

    public static final GenericConsumableItem INSTANCE = new GenericConsumableItem();

    public GenericConsumableItem(){
        //this.setCreativeTab(Tabs.CONSUMABLES);
        this.setHasSubtypes(true);
        this.setMaxStackSize(64);
        this.setRegistryName("fvtm:consumable");
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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            Consumable con = Resources.CONSUMABLES.getValue(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)));
            if(con == null){
                tooltip.add(stack.getTagCompound().getString(NBTKEY));
                return;
            }
            tooltip.add(Formatter.format("&9Name: &7" + con.getName()));
            for(String s : con.getDescription()){
                tooltip.add(Formatter.format(s));
            }
            tooltip.add(Formatter.format("&9Type: &7" + (con.isDrinkable() ? "drink/beverage" : "food")));
            tooltip.add(Formatter.format("&9Heal Amout: &7" + con.getHealAmount()));
            tooltip.add(Formatter.format("&9Saturation: &7" + con.getSaturation()));
            if(con.isWolfMeat()){
                tooltip.add(Formatter.format("&9&oLiked by wolves."));
            }
            if(con.isDrinkable() && con.getTANData() != null){
                tooltip.add(Formatter.format("&3TAN Modifiers: "));
                tooltip.add(Formatter.format("-> &9Thirst: &7" + con.getTANData().getThirst()));
                tooltip.add(Formatter.format("-> &9Hydration: &7" + con.getTANData().getHydration()));
                if(con.getTANData().getPoisonChance() > 0){
                    tooltip.add(Formatter.format("-> &9PoisonChanse: &7" + (con.getTANData().getPoisonChance() * 100) + "%"));
                }
            }
            if(con.alwaysEdible()){
                tooltip.add(Formatter.format("&8&oAlways " + (con.isDrinkable() ? "drinkable" : "edible") + "."));
            }
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(tab == CreativeTabs.SEARCH){
            for(Consumable material : Resources.CONSUMABLES.getValuesCollection()){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, material.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
        if(tab instanceof GenericCreativeTab){
            Addon addon = ((GenericCreativeTab)tab).getAddon();
            Collection<Consumable> coll = Resources.CONSUMABLES.getValuesCollection().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
            for(Consumable material : coll){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, material.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
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
    public Consumable getConsumable(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.CONSUMABLES.getValue(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)));
        }
        return null;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack){
        return getConsumable(stack).isDrinkable() ? EnumAction.DRINK : EnumAction.EAT;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        return getConsumable(stack).getItemUseDuration();
    }

    @Override
    public boolean isWolfsFavoriteMeat(){
        return true;//ou.. we have a problem here, no itemstack provided.
    }

    @Override
    public int getHealAmount(ItemStack stack){
        return getConsumable(stack).getHealAmount();
    }

    @Override
    public float getSaturationModifier(ItemStack stack){
        return getConsumable(stack).getSaturation();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        ItemStack itemstack = player.getHeldItem(hand);
        Consumable con = getConsumable(player.getHeldItem(hand));
        if(con.isDrinkable() && APIs.TOUGHASNAILS){
            if(((toughasnails.thirst.ThirstHandler) toughasnails.api.thirst.ThirstHelper.getThirstData(player)).isThirsty() || con.alwaysEdible()){
                player.setActiveHand(hand);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
            }
            else{
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            }
        }
        else{
            if(player.canEat(con.alwaysEdible())){
                player.setActiveHand(hand);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
            }
            else{
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            }
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity){
        if(world.isRemote || entity instanceof EntityPlayer == false){
            return stack;
        }
        Consumable con = getConsumable(stack);
        if(con.isDrinkable() && APIs.TOUGHASNAILS){
            EntityPlayer player = (EntityPlayer) entity;
            toughasnails.api.stat.capability.IThirst thirst = toughasnails.api.thirst.ThirstHelper.getThirstData(player);
            thirst.addStats(con.getTANData().getThirst(), con.getTANData().getHydration());
            //
            if(player.world.rand.nextFloat() < con.getTANData().getPoisonChance() && APIs.getBooleanValue("toughasnals.enable_thirst")){
                player.addPotionEffect(new PotionEffect(toughasnails.api.TANPotions.thirst, 600));
            }
            //
            if(con.getContainerItemStack() == null){
                stack.shrink(1);
            }
            else{
                return con.getContainerItemStack().copy();
            }
            return stack;
        }
        else{
            return super.onItemUseFinish(stack, world, entity);
        }
    }

}
