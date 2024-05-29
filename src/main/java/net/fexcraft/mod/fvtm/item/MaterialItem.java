package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Lockable.LockableItem;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.client.resources.I18n;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.FvtmRegistry.FUELS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.getFuel;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MaterialItem extends Item implements ContentItem<Material>, LockableItem, TextureableItem<Material>, Fuel.FuelItem {

	private SWI wrapper = new SWI(ItemStack.EMPTY);
	private Material material;

    public MaterialItem(Material content){
		super();
		material = content;
		setHasSubtypes(true);
		setMaxStackSize(material.isFuelContainer() ? 1 : material.getMaxStack());
		setMaxDamage(material.getMaxHealth());
		setRegistryName(material.getID().colon());
		setTranslationKey(material.getID().colon());
        if(!EnvInfo.CLIENT) return;
        setCreativeTab((CreativeTabs)FvtmResources.INSTANCE.getCreativeTab(material));
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + material.getName()));
        for(String s : material.getDescription()) tooltip.add(Formatter.format(I18n.format(s)));
        if(material.getOreDictId() != null){
        	tooltip.add(Formatter.format("&9OreDict: &7" + material.getOreDictId()));
        }
        if(material.isVehicleKey()){
        	tooltip.add(Formatter.format("&9LockCode: &7" + this.getLockCode(new SWI(stack))));
        }
        if(material.isFuelContainer()){
			wrapper.stack = stack;
        	tooltip.add(Formatter.format("&9Container: &7" + (material.isUniversalFuelContainer() ? "universal" : material.getFuelType() == null ? material.getFuelGroup() : material.getFuelType().getName())));
        	tooltip.add(Formatter.format("&9Fuel Stored: &7" + this.getStoredFuelName(wrapper)));
        	tooltip.add(Formatter.format("&9Fuel Amount: &7" + this.getStoredFuelAmount(wrapper) + "mB"));
        }
        if(material.getImpactLevel() > -1){
        	tooltip.add(Formatter.format("&9Impact Wrench Level: &7" + material.getImpactLevel()));
        }
    }
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
		if(tab != CreativeTabs.SEARCH && tab != this.getCreativeTab()) return;
		items.add(material.getNewStack().local());
		if(!material.isFuelContainer() || material.isUniversalFuelContainer()) return;
		for(Fuel fuel : FUELS){
			if(!material.isValidFuel(fuel)) continue;
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("StoredFuelType", fuel.getID().colon());
			compound.setInteger("StoredFuelAmount", material.getFuelCapacity());
			ItemStack stack = material.getNewStack().local();
			stack.setTagCompound(compound);
			items.add(stack);
		}
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	if(!Static.dev()) return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
        player.getHeldItem(hand).getItem().setDamage(player.getHeldItem(hand), player.getHeldItem(hand).getItemDamage() - 1); return EnumActionResult.SUCCESS;
    }
    
    @Override
    public int getItemBurnTime(ItemStack stack){
    	return material.getItemBurnTime() * stack.getCount();
    }

	@Override
	public Material getContent(){
		return material;
	}

	@Override
	public ContentType getType(){
		return ContentType.MATERIAL;
	}

	@Override
	public String getLockCode(StackWrapper stack){
		if(!material.isVehicleKey()) return null;
		if(stack.getTag().direct() == null) stack.setTag(TagCW.create());
		if(!stack.getTag().has("LockCode")) stack.getTag().set("LockCode", Lockable.newCode());
		return stack.getTag().getString("LockCode");
	}

	@Override
	public Fuel getStoredFuelType(StackWrapper stack){
    	if(!material.isFuelContainer()) return null;
		if(material.getFuelType() != null) return material.getFuelType();
    	if(stack.hasTag()) return getFuel(stack.getTag().getString("StoredFuelType"));
    	else return null;
	}

	@Override
    public String getStoredFuelName(StackWrapper stack){
    	if(!material.isFuelContainer()) return "Nothing.";
		if(material.getFuelType() != null) return material.getFuelType().getName();
    	if(stack.hasTag()) return FvtmRegistry.getFuelName(stack.getTag().getString("StoredFuelType"));
    	else return "none";
    }

	@Override
	public int getStoredFuelAmount(StackWrapper stack){
    	if(!material.isFuelContainer() || !stack.hasTag()) return 0;
    	return stack.getTag().getInteger("StoredFuelAmount");
	}

	@Override
	public void extractFuel(StackWrapper stack, int stored){
		stack.createTagIfMissing();
		stack.getTag().set("StoredFuelAmount", stack.getTag().getInteger("StoredFuelAmount") - stored);
		if(stack.getTag().getInteger("StoredFuelAmount") < 0) stack.getTag().set("StoredFuelAmount", 0);
	}

	@Override
	public void insertFuel(StackWrapper stack, int stored){
		stack.createTagIfMissing();
		stack.getTag().set("StoredFuelAmount", stack.getTag().getInteger("StoredFuelAmount") + stored);
		if(stack.getTag().getInteger("StoredFuelAmount") > material.getFuelCapacity()) stack.getTag().set("StoredFuelAmount", material.getFuelCapacity());
	}

}
