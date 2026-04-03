package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MaterialItem extends Item implements ContentItem<Material> {

	private Material material;
	private UniStack unistack = null;

	public MaterialItem(Properties prop, Material material){
		super(prop
			.stacksTo(material.isFuelContainer() ? 1 : material.getMaxStack())
			.durability(material.getMaxHealth()));
			//.defaultDurability(material.getMaxHealth()));
		this.material = material;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		cons.accept(GenericUtils.format("&9Name: &7" + material.getName()));
		for(String s : material.getDescription()) cons.accept(GenericUtils.format(I18n.get(s)));
		if(material.isVehicleKey()){
			cons.accept(GenericUtils.format("&9LockCode: &7" + getLockCode(stack)));
		}
		unistack = UniStack.get(stack);
		if(unistack != null && material.isFuelContainer()){
			cons.accept(GenericUtils.format("&9Container: &7" + (material.isUniversalFuelContainer() ? "universal" : ((material.getFuelType() == null) ? material.getFuelGroup() : material.getFuelType().getName()))));
			cons.accept(GenericUtils.format("&9Fuel Stored: &7" + Fuel.getStoredName(unistack.stack)));
			cons.accept(GenericUtils.format("&9Fuel Amount: &7" + Fuel.getStoredAmount(unistack.stack) + "mB"));
		}
	}

	public String getLockCode(ItemStack stack){
		if(!material.isVehicleKey()) return null;
		StackWrapper sw = UniStack.getStack(stack);
		if(!sw.directTag().has("LockCode")){
			sw.updateTag(com -> com.set("LockCode", UUID.randomUUID().toString().replace("-", "").substring(0, 7)));
		}
		return sw.directTag().getString("LockCode");
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