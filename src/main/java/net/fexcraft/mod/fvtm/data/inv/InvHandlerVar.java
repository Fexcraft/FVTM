package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class InvHandlerVar extends InvHandler {
	
	protected int value, items;
	protected String concat, conid;
	protected NonNullList<ItemStack> stacks;
	protected boolean in;

	public InvHandlerVar(String arg, int cap){
		super(InvType.VARIABLE);
		String[] str = arg.split(":");
		conid = str[0];
		concat = str.length > 1 ? str[1] : "fluid";
		items = str.length > 2 ? Integer.parseInt(str[2]) : 1;
		in = str.length > 3 ? str[3].equals("in") : false;
		stacks = NonNullList.<ItemStack>withSize(items, ItemStack.EMPTY);
		capacity = cap;
	}

	public NBTTagCompound save(NBTTagCompound compound, String ctag){
		compound.setInteger(ctag, value());
		DataUtil.saveAllItems(compound, stacks, false, ctag + "-items");
		return compound;
	}

	public void load(NBTTagCompound compound, String ctag){
		value = compound.getInteger(ctag);
		DataUtil.loadAllItems(compound, stacks, ctag + "-items");
	}

	@Override
	public int getVarValue(){
		return value;
	}

	@Override
	public void setVarValue(int i){
		value = i;
	}

	public int value(){
		return value;
	}

	public void value(int i){
		value = i;
	}
	
	public void shrink(int by){
		value -= by;
	}
	
	public void shrink(){
		value--;
	}
	
	public void grow(int by){
		value += by;
	}
	
	public void grow(){
		value++;
	}

	@Override
	public Object getCapObj(){
		return value;
	}

	public int items(){
		return items;
	}

	public String content_id(){
		return conid;
	}

	public String container_cat(){
		return concat;
	}
}
