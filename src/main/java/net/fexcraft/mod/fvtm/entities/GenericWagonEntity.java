package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.rail.RailUtil;
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
        if(amount != 0){ amount = Math.abs(amount);
        	RailUtil.Return arr = RailUtil.move(world, new Vec3d(posX, posY, posZ), currentpos, lastpos, connection, throttle > 0 ? amount : -amount);
        	this.posX = arr.dest.x; this.posY = arr.dest.y; this.posZ = arr.dest.z;
        	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
        	this.currentpos = arr.curr; this.lastpos = arr.last; this.connection = arr.connection;
        }
	}
	
}