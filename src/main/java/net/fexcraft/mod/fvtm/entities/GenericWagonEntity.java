package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.util.Vector3D;
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
	public void onUpdateMovement(double amount){
        if(amount != 0){
        	amount = Math.abs(amount);
        	BlockPos current = throttle > 0 ? currentpos : lastpos;
        	BlockPos last    = throttle > 0 ? lastpos : currentpos;
        	double[] own = new double[]{ posX, posY, posZ }, dest = Vector3D.newVector(current);
        	while(Double.compare(amount, Vector3D.distance(own, dest)) >= 0){
        		amount -= Vector3D.distance(own, dest);
        		if(amount < 0.001d){ break; }
        		RailConnTile tile = (RailConnTile)world.getTileEntity(current);
    			if(tile == null){ break; }
    			else{
    				BlockPos ls = new BlockPos(current);
    				current = tile.getNext(current, last);
    				if(current.equals(ls)){ break; }
    				else{
    					last = ls;
    					lastpos = throttle > 0 ? last : current;
    					currentpos = throttle > 0 ? current : last;
    					own = Vector3D.newVector(last); dest = Vector3D.newVector(current);
    				}
    			}
        	}
        	dest = Vector3D.direction(dest[0] - own[0], dest[1] - own[1], dest[2] - own[2]);
        	dest = Vector3D.newVector(own[0] + (dest[0] * amount), own[1] + (dest[1] * amount), own[2] + (dest[2] * amount));
        	this.posX = dest[0]; this.posY = dest[1]; this.posZ = dest[2];
        	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
        }
	}
	
}