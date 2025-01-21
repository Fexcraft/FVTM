package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.item.UniStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartItemApp implements Appendable<UniStack> {

	public final PartData data;

	public PartItemApp(UniStack stack){
		if(stack == null) data = null;
		else data = stack.stack.getContent(ContentType.PART);
	}

	@Override
	public Appendable<UniStack> create(UniStack stack){
		if(!stack.stack.isItemOf(ItemType.PART)) return null;
		return new PartItemApp(stack);
	}

	@Override
	public String id(){
		return "fvtm:vehicle";
	}

}
