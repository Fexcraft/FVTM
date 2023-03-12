package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.item.BlockItem;
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
		if(compound.hasKey(ctag + "-items")) DataUtil.loadAllItems(compound, stacks, ctag + "-items");
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

	private int i = 0, s = 0;

	@Override
	public void update(MultiblockTickableTE tile, String key){
		if(tile.getWorld().isRemote) return;
		if(in){
			for(ItemStack stack : stacks){
				if(stack.isEmpty()) continue;
				if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
				if(!stack.getTagCompound().hasKey("BlockFunction")){
					BlockData data = ((BlockItem)stack.getItem()).getData(stack.getTagCompound());
					data.write(stack.getTagCompound());
				}
				NBTTagCompound com = stack.getTagCompound().getCompoundTag("BlockFunction").getCompoundTag("fvtm:barrel");
				if(com.isEmpty()) return;
				if(!com.hasKey("fvtm:barrel")) com.setTag("fvtm:barrel", new NBTTagCompound());
				com = com.getCompoundTag("fvtm:barrel");
				s = com.getInteger("stored");
				if(s < 1 || !com.getString("stored_id").equals(conid)) continue;
				if(s > 0){
					if(s > 10){
						com.setInteger("stored", s - 10);
						value -= 10;
					}
					else{
						com.setInteger("stored", 0);
						value += s;
					}
				}
			}
		}
		else{
			for(ItemStack stack : stacks){
				if(stack.isEmpty()) continue;
				if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
				if(!stack.getTagCompound().hasKey("BlockFunction")){
					BlockData data = ((BlockItem)stack.getItem()).getData(stack.getTagCompound());
					data.write(stack.getTagCompound());
				}
				NBTTagCompound com = stack.getTagCompound().getCompoundTag("BlockFunction").getCompoundTag("fvtm:barrel");
				if(com.isEmpty()) return;
				s = com.getInteger("stored");
				if(s > 0 && !com.getString("stored_id").equals(conid)) continue;
				s = com.getInteger("stored");
				i = com.getInteger("capacity") - s;
				if(i > 0){
					com.setString("stored_id", conid);
					if(i < 10){
						com.setInteger("stored", com.getInteger("capacity"));
						value -= i;
					}
					else{
						com.setInteger("stored", s + 10);
						value -= 10;
					}
				}
			}
		}
	}

}
