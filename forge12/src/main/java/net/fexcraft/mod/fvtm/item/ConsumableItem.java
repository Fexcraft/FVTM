package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.uni.EnvInfo;
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

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConsumableItem extends ItemFood implements ContentItem<Consumable>, TextureableItem<Consumable> {
	
	private Consumable consumable;

    public ConsumableItem(Consumable consumable){
		super(consumable.getHealAmount(), consumable.isAlwaysEdible());
        this.consumable = consumable;
		setMaxStackSize(consumable.getMaxStack());
        setHasSubtypes(true);
        setRegistryName(consumable.getID().colon());
        setTranslationKey(consumable.getID().colon());
        if(!EnvInfo.CLIENT) return;
        setCreativeTab((CreativeTabs) FvtmResources.INSTANCE.getCreativeTab(consumable));
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + consumable.getName()));
        for(String s : consumable.getDescription()) tooltip.add(Formatter.format(I18n.format(s)));
        tooltip.add(Formatter.format("&9Type: &7" + (consumable.isDrinkable() ? "drink/beverage" : "food")));
        tooltip.add(Formatter.format("&9Heal Amout: &7" + consumable.getHealAmount()));
        tooltip.add(Formatter.format("&9Saturation: &7" + consumable.getSaturation()));
        if(consumable.isWolfFood()){
            tooltip.add(Formatter.format("&9&oLiked by wolves."));
        }
        if(consumable.isAlwaysEdible()){
            tooltip.add(Formatter.format("&8&oAlways " + (consumable.isDrinkable() ? "drinkable" : "edible") + "."));
        }
        if(consumable.getOreDictId() != null){
        	tooltip.add(Formatter.format("&9OreDict: &7" + consumable.getOreDictId()));
        }
    }
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(consumable.getNewStack().local());
    	}
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack){
        return consumable.isDrinkable() ? EnumAction.DRINK : EnumAction.EAT;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        return consumable.getItemUseDuration();
    }

    @Override
    public boolean isWolfsFavoriteMeat(){
        return consumable.isWolfFood();
    }

    @Override
    public int getHealAmount(ItemStack stack){
        return consumable.getHealAmount();
    }

    @Override
    public float getSaturationModifier(ItemStack stack){
        return consumable.getSaturation();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        ItemStack itemstack = player.getHeldItem(hand);
        if(player.canEat(consumable.isAlwaysEdible())){
            player.setActiveHand(hand);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else{
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }

    @Override
    public Consumable getContent(){
        return consumable;
    }

    @Override
    public ContentType getType(){
        return ContentType.CONSUMABLE;
    }

}
