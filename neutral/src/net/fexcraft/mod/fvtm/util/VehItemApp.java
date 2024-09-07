package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.StackWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehItemApp implements Appendable<StackWrapper> {

	public final VehicleData data;

	public VehItemApp(StackWrapper stack){
		if(stack == null) data = null;
		else data = stack.getContent(ContentType.VEHICLE);
	}

	@Override
	public Appendable<StackWrapper> create(StackWrapper stack){
		if(!stack.isItemOf(ItemType.VEHICLE)) return null;
		return new VehItemApp(stack);
	}

	@Override
	public String id(){
		return "fvtm:vehicle";
	}

}
