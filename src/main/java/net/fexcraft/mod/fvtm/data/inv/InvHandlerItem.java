package net.fexcraft.mod.fvtm.data.inv;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.fexcraft.mod.uni.impl.TagLWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class InvHandlerItem extends InvHandler {
	
	protected ItemStackHandler handler;
	protected ArrayList<StackEntry> stacks = new ArrayList<>();
	protected ContentFilter filter;

	public InvHandlerItem(String filter, int cap, int min){
		super(InvType.ITEM);
		capacity = cap;
		if(filter != null) this.filter = ContentFilter.FILTER_REGISTRY.get(filter);
		handler = new ItemStackHandler(this, min);
	}

	@Override
	public ContentFilter getFilter(){
		return filter;
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
		NBTTagList list = new NBTTagList();
		for(StackEntry entry : stacks){
			NBTTagCompound com = new NBTTagCompound();
			entry.stack.writeToNBT(com);
			com.setInteger("fvtm:stack_amount", entry.amount);
			list.appendTag(com);
		}
        if(list.tagCount() > 0) compound.set(ctag == null ? "Items" : ctag, new TagLWI(list));
        return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		stacks.clear();
		NBTTagList list = (NBTTagList)compound.getList(ctag == null ? "Items" : ctag).direct();
		if(list == null || list.isEmpty()) return;
		for(NBTBase base : list){
			NBTTagCompound com = (NBTTagCompound)base;
			stacks.add(new StackEntry(com));
		}
	}

	public ArrayList<StackEntry> getStacks(){
		return stacks;
	}
	
	@Override
	public ItemStackHandler getStackHandler(){
		return handler;
	}
	
	@Override
	public void dropAllAt(Entity entity){
		for(StackEntry entry : stacks){
			int am = entry.amount;
			while(am - entry.stack.getMaxStackSize() > 0){
	            entity.entityDropItem(entry.stack, 0.5f);
	            am -= entry.stack.getMaxStackSize();
			}
		}
		stacks.clear();
	}

	@Override
	public void dropAllAt(World world, BlockPos pos){
		for(StackEntry entry : stacks){
			int am = entry.amount;
			while(am - entry.stack.getMaxStackSize() > 0){
                EntityItem entity = new EntityItem(world);
                entity.setPosition(pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5);
                entity.setItem(entry.stack);
                world.spawnEntity(entity);
	            am -= entry.stack.getMaxStackSize();
			}
		}
		stacks.clear();
	}
	
	@Override
	public String getContentDesc(){
		return getStacks().stream().filter(is -> is != null && !is.stack.isEmpty()).count() + "";
	}
	
	public static class StackEntry {
		
		public ItemStack stack = ItemStack.EMPTY;
		public int amount = 0;
		
		public StackEntry(NBTTagCompound com){
			stack = new ItemStack(com);
			amount = com.getInteger("fvtm:stack_amount");
		}
		
		public int stacksize(){
			int ret = amount % stack.getMaxStackSize();
			return (amount / stack.getMaxStackSize()) + (ret > 0 ? 1 : 0);
		}

		public boolean overmax(){
			return amount > stack.getMaxStackSize();
		}

		public int max(){
			return stack.getMaxStackSize();
		}

		public int tillfullstack(){
			return stack.getMaxStackSize() - (amount % stack.getMaxStackSize());
		}

		public ItemStack genstack(int size){
			if(amount <= 0) return ItemStack.EMPTY;
			ItemStack nstack = stack.copy();
			nstack.setCount(amount < size ? amount : size);
			return nstack;
		}

		public ItemStack modstack(){
			if(amount < stack.getMaxStackSize()) return ItemStack.EMPTY;
			int mod = amount % stack.getMaxStackSize();
			if(mod == 0) return ItemStack.EMPTY;
			else return genstack(mod);
		}
		
	}

	public StackEntry getEntryFor(ItemStack stack){
		for(StackEntry entry : stacks){
			if(ItemHandlerHelper.canItemStacksStack(stack, entry.stack)) return entry;
		}
		return null;
	}

	public boolean full(){
		int am = 0;
		for(StackEntry entry : stacks) am += entry.stacksize();
		return am >= capacity;
	}

	@Override
	public Object getCapObj(){
		return getStackHandler();
	}
	
}
