package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.lang.FilledList;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class StackUtil {

	public static void loadItems(TagCW tag, FilledList<StackWrapper> stacks, String customtag){
		TagLW list = tag.getList(customtag == null ? "Items" : customtag);
		if(list == null) return;
		for(int i = 0; i < list.size(); i++){
			TagCW com = list.getCompound(i);
			int s = com.getInteger("Slot");
			if(s >= 0 && s < stacks.size()){
				stacks.set(i, FvtmResources.newStack(com));
			}
		}
	}

	public static TagCW saveItems(TagCW tag, FilledList<StackWrapper> stacks, boolean saveempty, String customtag){
		TagLW list = TagLW.create();
		for(int i = 0; i < stacks.size(); ++i){
			StackWrapper stack = stacks.get(i);
			if(!stack.empty()){
				TagCW com = TagCW.create();
				com.set("Slot", i);
				stack.save(com);
				list.add(com);
			}
		}
		if(!list.empty() || saveempty){
			tag.set(customtag != null ? customtag : "Items", list);
		}
		return tag;
	}

}
