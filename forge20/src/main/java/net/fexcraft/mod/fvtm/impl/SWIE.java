package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SWIE extends net.fexcraft.mod.uni.impl.SWI {

	private SWIE(ItemWrapper item){
		super(item);
	}

	private SWIE(ItemStack stack){
		super(stack);
	}

	public static SWIE parse(Object obj){
		if(obj instanceof ItemWrapper) return new SWIE((ItemWrapper)obj);
		if(obj instanceof ItemStack) return new SWIE((ItemStack)obj);
		if(obj instanceof TagCW) return new SWIE(ItemStack.of((CompoundTag)((TagCW)obj).direct()));
		return null;
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
			case FVTM_BLOCK: return stack.getItem() instanceof BlockItem;
			//TODO case CONTAINER: return stack.getItem() instanceof ContainerItem;
			case FVTM_TOOLBOX: return stack.getItem() instanceof ToolboxItem;
			case WIRE: return stack.getItem() instanceof WireItem;
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
			case BLOCK: return (C)((BlockItem)stack.getItem()).getData(this);
			//TODO case MULTIBLOCK: return (C)((MultiBlockItem)stack.getItem()).getData(this);
			case RAILGAUGE: return (C)((RailGaugeItem)stack.getItem()).getContent();
			//TODO case CLOTH: return (C)((ClothItem)stack.getItem()).getContent();
			case WIRE: return (C)((WireItem)stack.getItem()).getContent();
		}
		return null;
	}


}
