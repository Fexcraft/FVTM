package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
        boolean canThrustCreatively = !Config.VEHICLE_NEEDS_FUEL || (seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode);
        boolean consumed = false;
        Part.PartData enginepart = vehicledata.getPart("engine");
        if(!canThrustCreatively && enginepart != null && enginepart.getAttributeData(EngineAttributeData.class).isOn() && vehicledata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle){
            double d = (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
            consumed = vehicledata.consumeFuel(d > 0 ? d : (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
        }
        double vel = 0d;
        if(enginepart != null && (canThrustCreatively || consumed)){//TODO multi-engine support
        	vel = 0.2f * throttle * (throttle > 0 ? vehicledata.getVehicle().getFMAttribute("max_positive_throttle") : vehicledata.getVehicle().getFMAttribute("max_negative_throttle"));
        	vel *= vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
        }
        if(vel != 0){
        	BlockPos current = throttle > 0 ? currentpos : lastpos;
        	BlockPos last    = throttle > 0 ? lastpos : currentpos;
        	Vec3d own = this.getPositionVector(), dest = newVector(current);
        	while(Double.compare(vel, distance(own, dest)) >= 0){
        		vel -= distance(own, dest);
        		if(vel < 0.001d){ break; }
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
        	dest = new Vec3d(own.x + (dest.x * vel), own.y + (dest.y * vel), own.z + (dest.z * vel));
        	this.posX = dest.x; this.posY = dest.y; this.posZ = dest.z;
        	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
        }
        if(llp == null || lcp == null){ llp = lastpos; lcp = currentpos; }
    	if(!llp.equals(lastpos) || !lcp.equals(currentpos)){
    		NBTTagCompound compound = new NBTTagCompound();
    		compound.setString("task", "direction_update");
    		compound.setLong("last_pos", lastpos.toLong());
    		compound.setLong("current_pos", currentpos.toLong());
    		ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
    	}
	}
	
}