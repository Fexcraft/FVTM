package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.StackWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartItemApp implements Appendable<StackWrapper> {

	public final PartData data;

	public PartItemApp(StackWrapper stack){
		if(stack == null) data = null;
		else data = stack.getContent(ContentType.PART);
	}

	@Override
	public Appendable<StackWrapper> create(StackWrapper stack){
		if(!stack.isItemOf(ItemType.PART)) return null;
		return new PartItemApp(stack);
	}

	@Override
	public String id(){
		return "fvtm:vehicle";
	}

}
