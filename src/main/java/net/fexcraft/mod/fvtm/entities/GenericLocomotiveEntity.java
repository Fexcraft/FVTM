package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GenericLocomotiveEntity extends RailboundVehicleEntity {

	public GenericLocomotiveEntity(World world){
		super(world);
	}

	public GenericLocomotiveEntity(World world, BlockPos pos, EntityPlayer player, VehicleData data){
		super(world, pos, player, data);
	}

	@Override
	public void onUpdateMovement(){
        //Vec3d atmc = new Vec3d(0, 0, 0);
        boolean canThrustCreatively = !Config.VEHICLE_NEEDS_FUEL || (seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode);
        boolean consumed = false;
        Part.PartData enginepart = vehicledata.getPart("engine");
        if(!canThrustCreatively && enginepart != null && enginepart.getAttributeData(EngineAttributeData.class).isOn() && vehicledata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle){
            double d = (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
            consumed = vehicledata.consumeFuel(d > 0 ? d : (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
        }
        double vel = 0d;
        if(enginepart != null && (canThrustCreatively || consumed)){//TODO multi-engine support
        	vel = 0.1F * throttle * (throttle > 0 ? vehicledata.getVehicle().getFMAttribute("max_positive_throttle") : vehicledata.getVehicle().getFMAttribute("max_negative_throttle")) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
        }
        if(vel > 0){
        	Vec3d curr = this.getPositionVector(); Vec3d dest = RailConnTile.newVector(currentpos);
        	curr = curr.addVector((dest.x - curr.x) * vel, (dest.y - curr.y) * vel, (dest.z - curr.z) * vel);
        	//
        	if(new BlockPos(curr).equals(currentpos)){
        		BlockPos old = new BlockPos(currentpos);
        		currentpos = ((RailConnTile)world.getTileEntity(currentpos)).getNext(currentpos, lastpos);
        		if(!currentpos.equals(old)){
        			lastpos = old;
        		}
        	}
        	Print.logOAS(dest.toString() + " " + curr.toString());
        	this.posX = curr.x; this.posY = curr.y; this.posZ = curr.z;
        }
        //move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
	}
	
}