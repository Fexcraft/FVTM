package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConsumableItem extends ItemFood {
	
	private Consumable type;

    public ConsumableItem(Consumable consumable){
		super(consumable.getHealAmount(), consumable.isAlwaysEdible()); this.type = consumable;
		this.setMaxStackSize(consumable.getMaxStackSize()); this.setHasSubtypes(true);
        this.type.getAddon().getFCLRegisterer().addItem(type.getRegistryName().getPath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab(type.getCreativeTab()));
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){ tooltip.add(Formatter.format(I18n.format(s, new Object[0]))); }
        tooltip.add(Formatter.format("&9Type: &7" + (type.isDrinkable() ? "drink/beverage" : "food")));
        tooltip.add(Formatter.format("&9Heal Amout: &7" + type.getHealAmount()));
        tooltip.add(Formatter.format("&9Saturation: &7" + type.getSaturation()));
        if(type.isWolfFood()){
            tooltip.add(Formatter.format("&9&oLiked by wolves."));
        }
        //TAN data
        if(type.isAlwaysEdible()){
            tooltip.add(Formatter.format("&8&oAlways " + (type.isDrinkable() ? "drinkable" : "edible") + "."));
        }
        if(type.getOreDictionaryId() != null){
        	tooltip.add(Formatter.format("&9OreDict: &7" + type.getOreDictionaryId()));
        }
    }
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack){
        return type.isDrinkable() ? EnumAction.DRINK : EnumAction.EAT;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        return type.getItemUseDuration();
    }

    @Override
    public boolean isWolfsFavoriteMeat(){
        return type.isWolfFood();
    }

    @Override
    public int getHealAmount(ItemStack stack){
        return type.getHealAmount();
    }

    @Override
    public float getSaturationModifier(ItemStack stack){
        return type.getSaturation();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        ItemStack itemstack = player.getHeldItem(hand);
        /*if(con.isDrinkable() && GenericTrigger.TOUGHASNAILS){
            if(((toughasnails.thirst.ThirstHandler) toughasnails.api.thirst.ThirstHelper.getThirstData(player)).isThirsty() || con.alwaysEdible()){
                player.setActiveHand(hand);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
            }
            else{
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            }
        }
        else{*/
            if(player.canEat(type.isAlwaysEdible())){
                player.setActiveHand(hand);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
            }
            else{
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            }
        //}
    }

    /*@Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity){
        if(world.isRemote || entity instanceof EntityPlayer == false){
            return stack;
        }
        if(type.isDrinkable() && GenericTrigger.TOUGHASNAILS){
            EntityPlayer player = (EntityPlayer) entity;
            toughasnails.api.stat.capability.IThirst thirst = toughasnails.api.thirst.ThirstHelper.getThirstData(player);
            thirst.addStats(type.getTANData().getThirst(), type.getTANData().getHydration());
            //
            if(player.world.rand.nextFloat() < type.getTANData().getPoisonChance() && GenericTrigger.getTaNBooleanValue("toughasnals.enable_thirst")){
                player.addPotionEffect(new PotionEffect(toughasnails.api.TANPotions.thirst, 600));
            }
            //
            if(type.getContainerItemStack() == null){
                stack.shrink(1);
            }
            else{
                return type.getContainerItemStack().copy();
            }
            return stack;
        }
        else{
            return super.onItemUseFinish(stack, world, entity);
        }
    }*/

}
