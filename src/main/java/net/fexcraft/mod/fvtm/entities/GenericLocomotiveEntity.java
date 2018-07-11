package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GenericLocomotiveEntity extends RailboundVehicleEntity {

	public GenericLocomotiveEntity(World world){
		super(world);
	}

	public GenericLocomotiveEntity(World world, float f, float g, float h, EntityPlayer player, VehicleData data){
		super(world, f, g, h, player, data);
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
        for(BogieEntity bgw : bogies){
            if(bgw == null){
                continue;
            }
            onGround = true; bgw.onGround = true;
            bgw.rotationYaw = axes.getYaw();
            bgw.motionX *= 0.9F; bgw.motionY *= 0.9F; bgw.motionZ *= 0.9F;
            bgw.motionY -= 0.98F / 20F;//Gravity
            if(vel > 0){
            	/*if(vehicledata.getVehicle().getDriveType().hasTracks()){
	                boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
	                //
	                float turningDrag = 0.02F;
	                wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
	                wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
	                //
	                velocityScale = 0.04F * (throttle > 0 ? vehicledata.getVehicle().getFMAttribute("max_positive_throttle") : vehicledata.getVehicle().getFMAttribute("max_negative_throttle")) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
	                float steeringScale = 0.1F * (wheelsYaw > 0 ? vehicledata.getVehicle().getFMAttribute("turn_left_modifier") : vehicledata.getVehicle().getFMAttribute("turn_right_modifier"));
	                double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
	                wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
	                wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
	            }
	            else{
	                velocityScale = 0.1F * throttle * (throttle > 0 ? vehicledata.getVehicle().getFMAttribute("max_positive_throttle") : vehicledata.getVehicle().getFMAttribute("max_negative_throttle")) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
	                wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
	                wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
	                //
	                if(wheel.wheelid == 2 || wheel.wheelid == 3){
	                    velocityScale = 0.01F * (wheelsYaw > 0 ? vehicledata.getVehicle().getFMAttribute("turn_left_modifier") : vehicledata.getVehicle().getFMAttribute("turn_right_modifier")) * (throttle > 0 ? 1 : -1);
	                    wheel.motionX -= wheel.getHorizontalSpeed() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
	                    wheel.motionZ += wheel.getHorizontalSpeed() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
	                }
	                else{
	                    wheel.motionX *= 0.9F;
	                    wheel.motionZ *= 0.9F;
	                }
	            }*/
	            //TODO fancy movement code
            }
            bgw.move(MoverType.SELF, bgw.motionX, bgw.motionY, bgw.motionZ);
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