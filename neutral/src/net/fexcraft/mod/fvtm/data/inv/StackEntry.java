package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class StackEntry {

	public StackWrapper stack;
	public int amount = 0;

	public StackEntry(TagCW com){
		stack = FvtmResources.newStack(com);
		amount = com.getInteger("fvtm:stack_amount");
	}

	public int stacksize(){
		int ret = amount % stack.maxsize();
		return (amount / stack.maxsize()) + (ret > 0 ? 1 : 0);
	}

	public boolean overmax(){
		return amount > stack.maxsize();
	}

	public int max(){
		return stack.maxsize();
	}

	public int tillfullstack(){
		return stack.maxsize() - (amount % stack.maxsize());
	}

	public StackWrapper genstack(int size){
		if(amount <= 0) return StackWrapper.EMPTY;
		StackWrapper nstack = stack.copy();
		nstack.count(amount < size ? amount : size);
		return nstack;
	}

	public StackWrapper modstack(){
		if(amount < stack.maxsize()) return StackWrapper.EMPTY;
		int mod = amount % stack.maxsize();
		if(mod == 0) return StackWrapper.EMPTY;
		else return genstack(mod);
	}


}
