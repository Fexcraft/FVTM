package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.impl.UniFluidTank12;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniFluidTank;
import net.fexcraft.mod.uni.inv.UniInventory;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmInvFluid extends FvtmInv {

	public UniFluidTank tank;

	public FvtmInvFluid(){
		super(InvType.ITEM);
	}

	@Override
	public FvtmInvFluid init(JsonMap map){
		init0(map);
		tank = UniFluidTank.create(map.getInteger("capacity", 1000));
		return this;
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
		compound.set(ctag == null ? "Tank" : ctag, tank.save());
		return compound;
	}

	@Override
	public void load(TagCW compound, String ctag){
		tank.load(compound.getCompound(ctag == null ? "Tank" : ctag));
	}

	@Override
	public void clearAt(EntityW entity){
		//
	}

	@Override
	public FvtmInvFluid copy(){
		FvtmInvFluid inv = new FvtmInvFluid();
		copy(inv);
		inv.tank = UniFluidTank.create(tank.capacity());
		return inv;
	}

}
