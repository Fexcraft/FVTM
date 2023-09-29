package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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

}
