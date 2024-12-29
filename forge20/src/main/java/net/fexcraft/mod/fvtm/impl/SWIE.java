package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SWIE extends net.fexcraft.mod.uni.impl.SWI {

	public SWIE(ItemWrapper item){
		super(item);
	}

	public SWIE(ItemStack stack){
		super(stack);
	}

	@Override
	public boolean isItemOf(ItemType type){
		if(stack == null) return false;
		switch(type){
			case LEAD: return stack.getItem() instanceof LeadItem;
			case FOOD: return stack.getItem().isEdible();
			case FVTM_CONTENT: return stack.getItem() instanceof ContentItem<?>;
			case PART: return stack.getItem() instanceof PartItem;
			case MATERIAL: return stack.getItem() instanceof MaterialItem;
			case VEHICLE: return stack.getItem() instanceof VehicleItem;
			//TODO case FVTM_BLOCK: return stack.getItem() instanceof BlockItem;
			//TODO case CONTAINER: return stack.getItem() instanceof ContainerItem;
			case FVTM_TOOLBOX: return stack.getItem() instanceof ToolboxItem;
		}
		return super.isItemOf(type);
	}

	@Override
	public <C> C getContent(Object contenttype){
		ContentType type = (ContentType)contenttype;
		switch(type){
			case PART: return (C)((PartItem)stack.getItem()).getData(this);
			case VEHICLE: return (C)((VehicleItem)stack.getItem()).getData(this);
			case MATERIAL: return (C)((MaterialItem)stack.getItem()).getContent();
			//TODO case CONTAINER: return (C)((ContainerItem)stack.getItem()).getData(this);
			case CONSUMABLE: return (C)((ConsumableItem)stack.getItem()).getContent();
			//TODO case BLOCK: return (C)((BlockItem)stack.getItem()).getData(this);
			//TODO case MULTIBLOCK: return (C)((MultiBlockItem)stack.getItem()).getData(this);
			//TODO case RAILGAUGE: return (C)((RailGaugeItem)stack.getItem()).getContent();
			//TODO case CLOTH: return (C)((ClothItem)stack.getItem()).getContent();
			//TODO case WIRE: return (C)((WireItem)stack.getItem()).getContent();
		}
		return null;
	}


}
