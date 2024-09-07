package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static net.fexcraft.mod.fvtm.FvtmRegistry.getFuel;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MaterialItem extends Item implements ContentItem<Material>, Fuel.FuelItem {

	private Material material;
	private StackWrapper wrapper = StackWrapper.EMPTY;

	public MaterialItem(Material material){
		super((new Properties())
			.stacksTo(material.isFuelContainer() ? 1 : material.getMaxStack())
			.durability(material.getMaxHealth())
			.defaultDurability(material.getMaxHealth()));
		this.material = material;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		tooltip.add(GenericUtils.format("&9Name: &7" + material.getName()));
		for(String s : material.getDescription())
			tooltip.add(GenericUtils.format(I18n.get(s)));
		if(material.getOreDictId() != null){
			tooltip.add(GenericUtils.format("&9OreDict: &7" + material.getOreDictId()));
		}
		if(material.isVehicleKey()){
			tooltip.add(GenericUtils.format("&9LockCode: &7" + getLockCode(stack)));
		}
		if(material.isFuelContainer()){
			wrapper = StackWrapper.wrap(stack);
			tooltip.add(GenericUtils.format("&9Container: &7" + (material.isUniversalFuelContainer() ? "universal" : ((material.getFuelType() == null) ? material.getFuelGroup() : material.getFuelType().getName()))));
			tooltip.add(GenericUtils.format("&9Fuel Stored: &7" + getStoredFuelName(wrapper)));
			tooltip.add(GenericUtils.format("&9Fuel Amount: &7" + getStoredFuelAmount(wrapper) + "mB"));
		}
	}

	public String getLockCode(ItemStack stack){
		if(!material.isVehicleKey()) return null;
		if(stack.getTag() == null) stack.setTag(new CompoundTag());
		if(!stack.getTag().contains("LockCode"))
			stack.getTag().putString("LockCode", UUID.randomUUID().toString().replace("-", "").substring(0, 7));
		return stack.getTag().getString("LockCode");
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
		if(stack.getTag().getInteger("StoredFuelAmount") > material.getFuelCapacity())
			stack.getTag().set("StoredFuelAmount", material.getFuelCapacity());
	}

}