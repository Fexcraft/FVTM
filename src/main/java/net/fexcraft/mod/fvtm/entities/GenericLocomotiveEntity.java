package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.MoverType;
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
        Vec3d atmc = new Vec3d(0, 0, 0);
        boolean canThrustCreatively = !Config.VEHICLE_NEEDS_FUEL || (seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode);
        boolean consumed = false;
        Part.PartData enginepart = vehicledata.getPart("engine");
        if(!canThrustCreatively && enginepart != null && enginepart.getAttributeData(EngineAttributeData.class).isOn() && vehicledata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle){
            double d = (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
            consumed = vehicledata.consumeFuel(d > 0 ? d : (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
        }
        double vel = 0d;
        if(enginepart != null && canThrustCreatively || consumed){//TODO multi-engine support
        	vel = 0.1F * throttle * (throttle > 0 ? vehicledata.getVehicle().getFMAttribute("max_positive_throttle") : vehicledata.getVehicle().getFMAttribute("max_negative_throttle")) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
        }
        for(int i = 0; i < 2; i++){
        	BogieEntity bgw = bogies[i];
            if(bgw == null){
                continue;
            }
            onGround = true; bgw.onGround = true;
            bgw.rotationYaw = axes.getYaw();
            bgw.motionX *= 0.9F; bgw.motionY *= 0.9F; bgw.motionZ *= 0.9F;
            bgw.motionY -= 0.98F / 20F;//Gravity
            if(vel > 0){
        		vel = bgw.moveAlongRails(vel);
            }
            //bgw.move(MoverType.SELF, bgw.motionX, bgw.motionY, bgw.motionZ);
            //pull wheels back to car
            Vec3d targetpos = axes.getRelativeVector(vehicledata.getWheelPos().get(bgw.wheelid).to16Double());
            Vec3d current = new Vec3d(bgw.posX - posX, bgw.posY - posY, bgw.posZ - posZ);
            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(vehicledata.getVehicle().getFMAttribute("wheel_spring_strength"));
            if(despos.lengthSquared() > 0.001F){
                bgw.move(MoverType.SELF, despos.x, despos.y, despos.z);
                despos.scale(0.5F);
                atmc = atmc.subtract(despos);
            }
            //
            //TODO check if controlling entity and update anything else
        }
        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
	}
	
}