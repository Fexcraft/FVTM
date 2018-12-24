package net.fexcraft.mod.fvtm.prototype;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.rail.RailUtil;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class GlobalEntity {
	
	public double posX, posY, posZ, prevPosX, prevPosY, prevPosZ;
	public BlockPos currentpos, lastpos;
	public VehicleData data;
	public boolean reverse;
	public Chain chain;
	
	public GlobalEntity(Chain chain){
		this.chain = chain;
	}

	public void update(int chainid, boolean chainreverse){
		this.rear = (chainid + 1) >= chain.size() ? null : chain.get(chainid + 1);
		this.front = chainid == 0 ? null : chain.get(chainid - 1);
		//TODO
	}

	private GlobalEntity rear, front;
	
	public void onUpdateMovement(int chainid, double amount, boolean call, Boolean frontdir){
        if((amount > 0.001 || amount < -0.001)){ /*amount = Math.abs(amount);*/
        	set(RailUtil.move(chain.getWorld(), new double[]{ posX, posY, posZ }, currentpos, lastpos, amount, reverse), reverse);
        } if(!call) return;
	}
	
	public void set(RailUtil.Return ret, boolean reverse){
    	this.posX = ret.dest[0]; this.posY = ret.dest[1]; this.posZ = ret.dest[2];
    	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
    	this.currentpos = reverse ? ret.last : ret.curr; this.lastpos = reverse ? ret.curr : ret.last;
	}
	
}