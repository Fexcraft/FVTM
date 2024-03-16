package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SWI extends StackWrapper {

	public ItemStack stack;

	public SWI(ItemWrapper item){
		super(item);
		stack = new ItemStack((Item)item.direct());
	}

	public SWI(ItemStack is){
		super(FvtmResources.INSTANCE.getItemWrapper(is.getItem().getRegistryName().toString()));
		stack = is;
	}

	@Override
	public ItemStack local(){
		return stack;
	}

	@Override
	public Object direct(){
		return stack;
	}

	@Override
	public StackWrapper setTag(TagCW tag){
		stack.setTagCompound(tag.local());
		return this;
	}

	@Override
	public TagCW getTag(){
		return new TagCWI(stack.getTagCompound());
	}

	@Override
	public boolean hasTag(){
		return stack.hasTagCompound();
	}

	@Override
	public String getName(){
		return stack.getDisplayName();
	}

	@Override
	public int maxsize(){
		return stack.getMaxStackSize();
	}

	@Override
	public int damage(){
		return stack.getItemDamage();
	}

	@Override
	public int count(){
		return stack.getCount();
	}

	@Override
	public void count(int am){
		stack.setCount(am);
	}

	@Override
	public StackWrapper copy(){
		return FvtmResources.wrapStack(stack.copy());
	}

	@Override
	public void save(TagCW com){
		stack.writeToNBT(com.local());
	}

	@Override
	public boolean empty(){
		return stack.isEmpty();
	}

	@Override
	public void createTagIfMissing(){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
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
