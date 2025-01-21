package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.item.UniStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehItemApp implements Appendable<UniStack> {

	public final VehicleData data;

	public VehItemApp(UniStack stack){
		if(stack == null) data = null;
		else data = stack.stack.getContent(ContentType.VEHICLE);
	}

	@Override
	public Appendable<UniStack> create(UniStack stack){
		if(!stack.stack.isItemOf(ItemType.VEHICLE)) return null;
		return new VehItemApp(stack);
	}

	@Override
	public String id(){
		return "fvtm:vehicle";
	}

}
