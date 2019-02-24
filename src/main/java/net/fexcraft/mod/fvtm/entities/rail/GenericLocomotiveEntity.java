package net.fexcraft.mod.fvtm.entities.rail;

import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.minecraft.world.World;

public class GenericLocomotiveEntity extends GenericWagonEntity {

	public GenericLocomotiveEntity(World world, RailEntity railent){
		super(world, railent);
	}

	public GenericLocomotiveEntity(World world){ super(world); }

	@Override
	public void onUpdateMovement(double amount, boolean call, Boolean frontdir){
		/*if(frontdir != null){
			super.onUpdateMovement(amount, call, frontdir);
			return;
			//TODO
		}
        boolean creativemode = !Config.VEHICLE_NEEDS_FUEL || (seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode);
        boolean consumed = false;
        Part.PartData enginepart = railent.vehdata.getPart("engine");
        if(!creativemode && enginepart != null && enginepart.getAttributeData(EngineAttributeData.class).isOn() && railent.vehdata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * railent.getThrottle()){
            double d = (railent.vehdata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * railent.getThrottle()) / 80;//20, set lower to prevent too fast compsumption.
            consumed = railent.vehdata.consumeFuel(d > 0 ? d : (railent.vehdata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
        }
        double vel = 0d;
        if(enginepart != null && (creativemode || consumed)){//TODO multi-engine support
        	vel = /*0.2f **//* railent.getThrottle() * (railent.getThrottle() > 0 ? railent.vehdata.getVehicle().getFMAttribute("max_positive_throttle") : railent.vehdata.getVehicle().getFMAttribute("max_negative_throttle"));
        	vel *= railent.vehdata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
        }
        //TODO check if connected to another locomotive, etc.
        super.onUpdateMovement(vel, true, null);*/
		//
		//super.onUpdateMovement(0, true, null);
	}
	
}