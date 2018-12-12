package net.fexcraft.mod.fvtm.entities.rail;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GenericLocomotiveEntity extends GenericWagonEntity {

	public GenericLocomotiveEntity(World world){
		super(world);
	}

	public GenericLocomotiveEntity(World world, BlockPos pos, EntityPlayer player, VehicleData data){
		super(world, pos, player, data);
	}

	@Override
	public void onUpdateMovement(double amount, boolean call, Boolean frontdir){
		if(frontdir != null){
			super.onUpdateMovement(amount, call, frontdir);
			//TODO
		}
        boolean creativemode = !Config.VEHICLE_NEEDS_FUEL || (seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode);
        boolean consumed = false;
        Part.PartData enginepart = vehicledata.getPart("engine");
        if(!creativemode && enginepart != null && enginepart.getAttributeData(EngineAttributeData.class).isOn() && vehicledata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle){
            double d = (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
            consumed = vehicledata.consumeFuel(d > 0 ? d : (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
        }
        double vel = 0d;
        if(enginepart != null && (creativemode || consumed)){//TODO multi-engine support
        	vel = /*0.2f **/ throttle * (throttle > 0 ? vehicledata.getVehicle().getFMAttribute("max_positive_throttle") : vehicledata.getVehicle().getFMAttribute("max_negative_throttle"));
        	vel *= vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
        }
        //TODO check if connected to another locomotive, etc.
        super.onUpdateMovement(vel, true, null);
	}
	
}