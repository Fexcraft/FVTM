package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.inv.UniStack;
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

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MaterialItem extends Item implements ContentItem<Material> {

	private Material material;
	private UniStack unistack = null;

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
		unistack = UniStack.get(stack);
		if(unistack != null && material.isFuelContainer()){
			tooltip.add(GenericUtils.format("&9Container: &7" + (material.isUniversalFuelContainer() ? "universal" : ((material.getFuelType() == null) ? material.getFuelGroup() : material.getFuelType().getName()))));
			tooltip.add(GenericUtils.format("&9Fuel Stored: &7" + Fuel.getStoredName(unistack.stack)));
			tooltip.add(GenericUtils.format("&9Fuel Amount: &7" + Fuel.getStoredAmount(unistack.stack) + "mB"));
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

}