package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SWIE extends SWI {

	public SWIE(ItemWrapper item){
		super(item);
	}

	public SWIE(ItemStack is){
		super(is);
	}

	@Override
	public boolean isItemOf(ItemType type){
		switch(type){
			case LEAD: return stack.getItem() instanceof ItemLead;
			case FOOD: return stack.getItem() instanceof ItemFood;
			case FVTM_CONTENT: return stack.getItem() instanceof ContentItem<?>;
			case PART: return stack.getItem() instanceof PartItem;
			case MATERIAL: return stack.getItem() instanceof MaterialItem;
			case VEHICLE: return stack.getItem() instanceof VehicleItem;
			case FVTM_BLOCK: return stack.getItem() instanceof BlockItem;
			case CONTAINER: return stack.getItem() instanceof ContainerItem;
			case FVTM_TOOLBOX: return stack.getItem() instanceof ToolboxItem;
			case WIRE: return stack.getItem() instanceof WireItem;
		}
		return false;
	}

	@Override
	public <C> C getContent(Object contenttype){
		ContentType type = (ContentType)contenttype;
		switch(type){
			case PART: return (C)((PartItem)stack.getItem()).getData(this);
			case VEHICLE: return (C)((VehicleItem)stack.getItem()).getData(this);
			case MATERIAL: return (C)((MaterialItem)stack.getItem()).getContent();
			case CONTAINER: return (C)((ContainerItem)stack.getItem()).getData(this);
			case CONSUMABLE: return (C)((ConsumableItem)stack.getItem()).getContent();
			case BLOCK: return (C)((BlockItem)stack.getItem()).getData(this);
			case MULTIBLOCK: return (C)((MultiBlockItem)stack.getItem()).getData(this);
			case RAILGAUGE: return (C)((RailGaugeItem)stack.getItem()).getContent();
			case CLOTH: return (C)((ClothItem)stack.getItem()).getContent();
			case WIRE: return (C)((WireItem)stack.getItem()).getContent();
		}
		return null;
	}

}
