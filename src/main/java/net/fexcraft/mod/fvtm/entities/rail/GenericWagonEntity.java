package net.fexcraft.mod.fvtm.entities.rail;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.rail.RailUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GenericWagonEntity extends RailboundVehicleEntity {

	public GenericWagonEntity(World world){
		super(world);
	}

	public GenericWagonEntity(World world, BlockPos pos, EntityPlayer player, VehicleData data){
		super(world, pos, player, data);
	}

	@Override
	public void onUpdateMovement(double amount, boolean call, boolean frontdir){
        if(amount != 0){ amount = Math.abs(amount);
        	RailUtil.Return ret = RailUtil.getExpectedPosition(world, new double[]{ posX, posY, posZ }, reverse ? lastpos : currentpos, reverse ? currentpos : lastpos, amount);
        	this.posX = ret.dest[0]; this.posY = ret.dest[1]; this.posZ = ret.dest[2];
        	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
        	this.currentpos = reverse ? ret.last : ret.curr; this.lastpos = reverse ? ret.curr : ret.last;
        }
        if(call && amount != 0){
            RailboundVehicleEntity ent = null; /*amount = reverse ? -amount : amount;*/ boolean fr;
            if(frontdir && rear != null && rear.getVehicleData().getVehicle().isTrailerOrWagon()){
            	(ent = (RailboundVehicleEntity)rear).onUpdateMovement((fr = ent.front.equals(this)) ? amount : -amount, true, fr);
            }
            if(!frontdir && front != null && front.getVehicleData().getVehicle().isTrailerOrWagon()){
            	(ent = (RailboundVehicleEntity)front).onUpdateMovement((fr = ent.front.equals(this)) ? amount : -amount, true, fr);
            }
        }
	}
	
}