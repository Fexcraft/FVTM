package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GenericTrailerEntity extends UnboundVehicleEntity {

    public GenericTrailerEntity(World world){
        super(world);
        Print.debug("SPAWNING TRAILER");
    }

    public GenericTrailerEntity(World world, VehicleData data, VehicleEntity parent){
        super(world, data);
        Vec3d vec = parent.getAxes().getRelativeVector(parent.getVehicleData().getRearConnector().to16Double());
        setPosition(parent.getEntity().posX + vec.x, parent.getEntity().posY + vec.y, parent.getEntity().posZ + vec.z);
        this.axes = parent.getAxes().clone();
        initVeh(data, false);
        this.startRiding(parent.getEntity());
        Print.debug("SPAWNING TRAILER");
    }

    public GenericTrailerEntity(World world, float x, float y, float z, EntityPlayer player, VehicleData data){
    	super(world, x, y, z, player, data);
	}

	@Override
    public void onUpdateMovement(){
		Vec3d atmc = new Vec3d(0, 0, 0);
		int wheelid = 0;
        for(WheelEntity wheel : wheels){
            if(wheel == null){ continue; }
            onGround = true;
            wheel.onGround = true;
            wheel.rotationYaw = axes.getYaw();
            if(!vehicledata.getVehicle().getDriveType().hasTracks() && (wheel.wheelid == 2 || wheel.wheelid == 3)){
                wheel.rotationYaw += wheelsYaw;
            }
            wheel.motionX *= 0.9F;
            wheel.motionY *= 0.9F;
            wheel.motionZ *= 0.9F;
            wheel.motionY -= 0.98F / 20F;//Gravity
            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
            Pos s = null;
        	if(wheelid >= this.getVehicleData().getWheelPos().size() && this.getVehicleData().getVehicle().isTrailerOrWagon()){
        		s = this.getVehicleData().getWheelPos().get(wheelid == 2 ? 1 : 0);
        		s = new Pos(0, s.y, s.z);
        	}
        	else{
        		s = this.getVehicleData().getWheelPos().get(wheelid);
        	}
            Vec3d targetpos = axes.getRelativeVector(s.to16Double());
            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(vehicledata.getVehicle().getFMAttribute("wheel_spring_strength"));
            if(despos.lengthSquared() > 0.001F){
                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
                despos.scale(0.5F);
                atmc = atmc.subtract(despos);
            }
            wheelid++;
        }
        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
        return;
    }

    @Override
    public void onUpdate(){
        super.onUpdate();
    }

    @Override
    public void moveTrailer(){
        prevPosX = posX; prevPosY = posY; prevPosZ = posZ;
        if(wheels == null || wheels[0] == null || wheels[1] == null || getParent() == null){
        	return;
        }
        Vec3d conn = getParent().getAxes().getRelativeVector(getParent().getVehicleData().getRearConnector().to16Double());
        this.setPosition(getParent().getEntity().posX + conn.x, getParent().getEntity().posY + conn.y, getParent().getEntity().posZ + conn.z);
        //
        int lw = this.getParent().getVehicleData().getVehicle().getFMAttribute("trailer_adjustment_axe") < 0 ? 3 : 0;
        int rw = lw == 3 ? 2 : 1;
        if(parentent.getWheels() == null || !this.isRiding() || parentent.getWheels()[lw] == null || parentent.getWheels()[rw] == null){
        	return;
        }
        Vec3d front = new Vec3d((getParent().getWheels()[lw].posX + getParent().getWheels()[rw].posX) / 2F, (getParent().getWheels()[lw].posY + getParent().getWheels()[rw].posY) / 2F, (getParent().getWheels()[lw].posZ + getParent().getWheels()[rw].posZ) / 2F);
    	Vec3d back = new Vec3d((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F, (wheels[0].posZ + wheels[1].posZ) / 2F);
    	Vec3d left = new Vec3d((wheels[0].posX + getParent().getWheels()[lw].posX) / 2F, (wheels[0].posY + getParent().getWheels()[lw].posY) / 2F, (wheels[0].posZ + getParent().getWheels()[lw].posZ) / 2F);
    	Vec3d right = new Vec3d((wheels[1].posX + getParent().getWheels()[rw].posX) / 2F, (wheels[1].posY + getParent().getWheels()[rw].posY) / 2F, (wheels[1].posZ + getParent().getWheels()[rw].posZ) / 2F);
        //
        double dx = front.x - back.x, dy = front.y - back.y, dz = front.z - back.z;
        double drx = left.x - right.x, dry = left.y - right.y, drz = left.z - right.z;
        double dxz = Math.sqrt(dx * dx + dz * dz);
        double drxz = Math.sqrt(drx * drx + drz * drz);
        //
        double yaw = Math.atan2(dz, dx);
        double pitch = -Math.atan2(dy, dxz);
        double roll = -(float) Math.atan2(dry, drxz);
        //
        if(vehicledata.getVehicle().getDriveType().hasTracks()){
            yaw = (float)Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float) Math.PI / 2F;
        }
        //
        double thrt = getParent().getThrottle() > 0 ? getParent().getThrottle() : -getParent().getThrottle();
        double rawy = Math.toDegrees(yaw) - axes.getYaw();
        double diff = rawy * thrt * 0.2;
        //Print.debug(rawy, diff);
        diff = rawy > 0 ? (diff > rawy ? rawy : diff) : (diff < rawy ? rawy : diff);
        axes.setRotation(axes.getRadianYaw() + Math.toRadians(diff), pitch, roll);
        //
        alignWheels();
    }

    private final void alignWheels(){
        for(int i = 0; i < wheels.length; i++){
            if(wheels[i] == null ){ continue; }
            WheelEntity wheel = wheels[i];
            onGround = true;
            wheel.onGround = true;
            wheel.rotationYaw = axes.getYaw();
            //
            Pos s = null;
        	if(i >= this.getVehicleData().getWheelPos().size() && this.getVehicleData().getVehicle().isTrailerOrWagon()){
        		s = this.getVehicleData().getWheelPos().get(i == 2 ? 1 : 0);
        		s = new Pos(0, s.y, s.z);
        	}
        	else{ s = this.getVehicleData().getWheelPos().get(i); }
            Vec3d targetpos = axes.getRelativeVector(s.to16Double());
            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(vehicledata.getVehicle().getFMAttribute("wheel_spring_strength"));
            if(despos.lengthSquared() > 0.001F){
                wheel.move(MoverType.SELF, despos.x, (despos.y - (0.98F / 20F)), despos.z);
            }
            //
            if(wheel.getPositionVector().distanceTo(this.getPositionVector()) > 1024){
                wheel.posX = despos.x;
                wheel.posY = despos.y;
                wheel.posZ = despos.z;
            }
        }
    }

    @Override
    public void setDead(){
        super.setDead();
    }

    @Override
    protected void initVeh(VehicleData type, boolean remote){
        super.initVeh(type, remote);
        this.moveTrailer();
    }

    @Override
    public float getWheelsYaw(){
        return getParent() == null ? wheelsYaw : getParent().getWheelsYaw();
    }

    @Override
    public float getWheelsAngle(){
        return getParent() == null ? wheelsAngle : getParent().getWheelsAngle();
    }

}
