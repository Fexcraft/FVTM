package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GenericTrailerEntity extends UnboundVehicleEntity {

	public GenericTrailerEntity(World world){
		super(world);
	}
	
	public GenericTrailerEntity(World world, VehicleData data, VehicleEntity parent){
		super(world, data);
		Vec3d vec = parent.getAxes().getRelativeVector(parent.getVehicleData().getRearConnector().to16Double());
		setPosition(parent.getEntity().posX + vec.x, parent.getEntity().posY + vec.y, parent.getEntity().posZ + vec.z);
		this.parentid = parent.getEntity().getUniqueID();
		this.axes = parent.getAxes().clone();
		initVeh(data, false);
		Print.debug("SPAWNING TRAILER");
	}

	@Override
	public void onUpdateMovement(){
		return;
	}
	
	@Override
	public void onUpdate(){
		if(parent == null){
        	try{
        		Entity ent = null;
        		for(Entity e : world.loadedEntityList){
        			if(e.getUniqueID().equals(parentid)){
        				ent = e; break;
        			}
        		}
        		if(ent instanceof VehicleEntity == false){
        			Print.debug(String.format("Tried to connect to %s (%s) but that's not a Vehicle!", ent == null ? "NULL" : ent.toString(), parentid));
        			return;
        		}
            	parent = (VehicleEntity)ent;
        		((UnboundVehicleEntity)parent).trailer = this;//TODO
        		//
        		this.posX = parent.getEntity().posX;
        		this.posY = parent.getEntity().posY;
        		this.posZ = parent.getEntity().posZ;
        		Print.debug("Found vehicle. ");
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }
		super.onUpdate();
	}
	
	@Override
	public void moveTrailer(){
		prevPosX = posX; prevPosY = posY; prevPosZ = posZ;
		if(parent == null || wheels.length > 2){
			//TODO add alternative code for 4 wheeled trailers
			return;
		}
		//
		Vec3d conn = parent.getAxes().getRelativeVector(parent.getVehicleData().getRearConnector().to16Double());
		this.setPosition(parent.getEntity().posX + conn.x, parent.getEntity().posY + conn.y, parent.getEntity().posZ + conn.z);
		//
		alignWheels();
		//
		//Vec3d axle = new Vec3d((wheels[0].posX + wheels[1].posX) * 0.5, (wheels[0].posY + wheels[1].posY) * 0.5, (wheels[0].posZ + wheels[1].posZ) * 0.5);
		//double grr = Math.atan2(conn.z - axle.z, conn.x - axle.x);
		//double yaw = axes.getYaw(), grs = grr;
		//axes.setAngles((grr = (float)(grr * 180 / Math.PI)) > Static.rad1 || grr < -Static.rad1 ? grr : 0, 0, 0);
		//Print.debug(yaw, grs, axes.getYaw(), grr);
		//
		//
		Vec3d front = new Vec3d((parent.getWheels()[0].posX + parent.getWheels()[1].posX) / 2F, (parent.getWheels()[0].posY + parent.getWheels()[1].posY) / 2F, (parent.getWheels()[0].posZ + parent.getWheels()[1].posZ) / 2F);
		Vec3d back  = new Vec3d((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F, (wheels[0].posZ + wheels[1].posZ) / 2F);
		Vec3d left = new Vec3d((wheels[0].posX + parent.getWheels()[0].posX) / 2F, (wheels[0].posY + parent.getWheels()[0].posY) / 2F, (wheels[0].posZ + parent.getWheels()[0].posZ) / 2F);
		Vec3d right = new Vec3d((wheels[1].posX + parent.getWheels()[1].posX) / 2F, (wheels[1].posY + parent.getWheels()[1].posY) / 2F, (wheels[1].posZ + parent.getWheels()[1].posZ) / 2F);
		//
		double dx = front.x - back.x, dy = front.y - back.y, dz = front.z - back.z;
		double drx = left.x - right.x, dry = left.y - right.y, drz = left.z - right.z;
		double dxz = Math.sqrt(dx * dx + dz * dz);
		double drxz = Math.sqrt(drx * drx + drz * drz);
		//
		double yaw = Math.atan2(dz, dx);
		double pitch = -Math.atan2(dy, dxz);
		double roll = 0F;
		roll = -(float)Math.atan2(dry, drxz);
		//
		if(vehicledata.getVehicle().getDriveType().hasTracks()){
			yaw = (float)Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float)Math.PI / 2F;
		}
		//Print.debug(axes.getYaw(), axes.getRadianYaw());
		double thrt = parent.getThrottle() > 0 ? parent.getThrottle() : -parent.getThrottle();
		double rawy = Math.toDegrees(yaw) - axes.getYaw();
		double diff = rawy * thrt * 0.2;
		diff = rawy > 0 ? diff > rawy ? rawy : diff : diff < rawy ? rawy : diff;
		axes.setRotation(axes.getRadianYaw() + Math.toRadians(diff), pitch, roll);
		//Print.debug(axes.getYaw(), axes.getRadianYaw());
		//alignWheels();
	}
	
	private final void alignWheels(){
		for(int i = 0; i < wheels.length; i++){
			if(wheels[i] == null){ continue; }
			WheelEntity wheel = wheels[i];
			onGround = true;
			wheel.onGround = true;
			wheel.rotationYaw = axes.getYaw();
			//
			Vec3d targetpos = axes.getRelativeVector(vehicledata.getWheelPos().get(i).to16Double());
			Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
			Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(vehicledata.getVehicle().getFMWheelSpringStrength());
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
		if(this.parent != null && parent instanceof UnboundVehicleEntity){
			((UnboundVehicleEntity)parent).trailer = null;
		}
	}
	
	@Override
	protected void initVeh(VehicleData type, boolean remote){
		super.initVeh(type, remote);
		this.moveTrailer();
	}
	
	@Override
	public float getWheelsYaw(){
		return parent == null ? 0 : parent.getWheelsYaw();
	}
	
	@Override
	public float getWheelsAngle(){
		return parent == null ? 0 : parent.getWheelsAngle();
	}
	
}