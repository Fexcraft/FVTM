package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.lang.FilledList;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InvHandlerVar extends InvHandler {

	protected int value, items;
	protected String concat, conid;
	protected FilledList<StackWrapper> stacks;
	protected boolean in;

	public InvHandlerVar(String arg, int cap){
		super(InvType.VARIABLE);
		String[] str = arg.split(":");
		conid = str[0];
		concat = str.length > 1 ? str[1] : "fluid";
		items = str.length > 2 ? Integer.parseInt(str[2]) : 1;
		in = str.length > 3 ? str[3].equals("in") : false;
		stacks = new FilledList<>(items, () -> StackWrapper.EMPTY, elm -> elm.empty());
		capacity = cap;
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
		compound.set(ctag, value());
		StackUtil.saveItems(compound, stacks, false, ctag + "-items");
		return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		value = compound.getInteger(ctag);
		if(compound.has(ctag + "-items")) StackUtil.loadItems(compound, stacks, ctag + "-items");
	}

	@Override
	public String getContentDesc(){
		return "";
	}

	@Override
	public String getSavePrefix(){
		return "var-";
	}

	@Override
	public ArrayList<StackEntry> getStacks(){
		return null;
	}

	@Override
	public <FT> FT getTank(){
		return null;
	}

	@Override
	public <ISH> ISH getStackHandler(){
		return null;
	}

	@Override
	public Object getCapability(){
		return value;
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

	public int items(){
		return items;
	}

	public String content_id(){
		return conid;
	}

	public String container_cat(){
		return concat;
	}

	public StackWrapper stackAt(int index){
		return stacks.get(index);
	}

	private int i = 0, s = 0;

	@Override
	public void update(Object otile, String key, boolean remote){
		if(remote) return;
		if(in){
			for(StackWrapper stack : stacks){
				if(stack.empty()) continue;
				if(!stack.directTag().has("BlockFunction")){
					BlockData data = FvtmResources.getBlockData(stack.directTag());
					stack.updateTag(tag -> data.write(tag));
				}
				/*TagCW com = stack.getTag().getCompound("BlockFunction").getCompound("fvtm:barrel");
				if(com.empty()) return;
				if(!com.has("fvtm:barrel")) com.set("fvtm:barrel", TagCW.create());
				com = com.getCompound("fvtm:barrel");
				s = com.getInteger("stored");
				if(s < 1 || !com.getString("stored_id").equals(conid)) continue;
				if(s > 0){
					if(s > 10){
						com.set("stored", s - 10);
						value -= 10;
					}
					else{
						com.set("stored", 0);
						value += s;
					}
				}*///TODO
			}
		}
		else{
			for(StackWrapper stack : stacks){
				if(stack.empty()) continue;
				/*if(!stack.getTag().has("BlockFunction")){
					BlockData data = FvtmResources.getBlockData(stack.getTag());
					data.write(stack.getTag());
				}
				TagCW com = stack.getTag().getCompound("BlockFunction").getCompound("fvtm:barrel");
				if(com.empty()) return;
				s = com.getInteger("stored");
				if(s > 0 && !com.getString("stored_id").equals(conid)) continue;
				s = com.getInteger("stored");
				i = com.getInteger("capacity") - s;
				if(i > 0){
					com.set("stored_id", conid);
					if(i < 10){
						com.set("stored", com.getInteger("capacity"));
						value -= i;
					}
					else{
						com.set("stored", s + 10);
						value -= 10;
					}
				}*///TODO
			}
		}
	}

}
