package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
        	BlockPos current = throttle > 0 ? currentpos : lastpos;
        	BlockPos last    = throttle > 0 ? lastpos : currentpos;
        	Vec3d own = this.getPositionVector(), dest = newVector(current);
        	while(Double.compare(amount, distance(own, dest)) >= 0){
        		amount -= distance(own, dest);
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
    					own = newVector(last); dest = newVector(current);
    				}
    			}
        	}
        	dest = direction(dest.x - own.x, dest.y - own.y, dest.z - own.z);
        	dest = new Vec3d(own.x + (dest.x * amount), own.y + (dest.y * amount), own.z + (dest.z * amount));
        	this.posX = dest.x; this.posY = dest.y; this.posZ = dest.z;
        	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
        }
	}
	
}