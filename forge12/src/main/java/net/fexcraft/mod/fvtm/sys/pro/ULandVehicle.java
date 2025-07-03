package net.fexcraft.mod.fvtm.sys.pro;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

import static net.fexcraft.mod.fvtm.Config.*;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.GRAVITY_200th;
import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.GRAVITY_20th;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ULandVehicle extends RootVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

    public ArrayList<Axle> axles = new ArrayList<>();
    public Axle ax_fron, ax_rear;
    public double wheelbase, cg_height;
	public int rpm, orpm, crpm;

	public ULandVehicle(World world){
		super(world);
		preventEntitySpawning = true; setSize(1f, 1f);
		ignoreFrustumCheck = true; stepHeight = 1f;
        if(world.isRemote){
            setRenderDistanceWeight(1d);
        }
	}
	
	/** Constructor to spawn either by a player or Constructor.
	 * 
	 * @param meta should be -1 or lower if placer rotation yaw matters
	 * */
	public ULandVehicle(World world, VehicleData data, V3D pos, EntityPlayer placer, int meta){
		this(world);
		setPosition(pos.x, pos.y, pos.z);
		vehicle.init(data, null);
		if(placer != null){
			vehicle.setPlacer(placer.getGameProfile().getId());
		}
		float prot = placer != null ? (MathHelper.floor(((placer.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15) * 22.5f : 0;
		vehicle.pivot().set_yaw((placer == null || meta >= 0 ? (meta * 90f) : prot) + -90F, true);
		init(null);
	}

	public ULandVehicle(LandVehicle truck, VehicleData data, EntityPlayer placer){
		this(truck.world, data, truck.vehicle.getV3D(), placer, 0);
		vehicle.front = truck.vehicle;
		truck.vehicle.rear = vehicle;
		vehicle.point.updatePrevAxe();
		vehicle.point.getPivot().copy(truck.vehicle.point.getPivot());
		vehicle.sendUpdate(VehicleInstance.PKT_UPD_CONNECTOR);
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void init(TagCW com){
		super.init(com);
		//setupAxles();
	}

	@Override
	public void writeSpawnData(TagCW com){
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
	}

	@Override
	public void readSpawnData(TagCW com){
		if(com.has("TruckId")){
			vehicle.front = ((ULandVehicle)world.getEntityByID(com.getInteger("TruckId"))).vehicle;
			vehicle.front.rear = vehicle;
		}
	}

	@Override
    public void applyEntityCollision(Entity entity){
    	//Print.debug(entity); return;
    }
    
    @Override
    public void setVelocity(double x, double y, double z){
        motionX = x; motionY = y; motionZ = z; return;
    }

    @Override
    public void onUpdate(){
        super.onUpdate();
		if(vehicle.data == null) return;
        if(world.isRemote){
        	vehicle.data.getAttribute("rpm").set(crpm / 100 * 100);
        }
        /*if(!world.isRemote && ticksExisted % VEHICLE_SYNC_RATE == 0 && truck == null){
            ULandVehicle trailer = this.trailer;
            while(trailer != null){
				trailer.vehicle.sendUpdatePacket();
                trailer = trailer.trailer;
            }
        }*/
    }
    
    @SideOnly(Side.CLIENT)
    private void updateSounds(){
    	/*if(!world.isRemote || vehicle.engine == null) return;
    	if(vehicle.engine.isOn() && engineloop == null){
            SoundEvent event = (SoundEvent)vehicle.data.getSound("engine_running").event;
            if(event != null){
                this.engineloop = new LoopSound(event, SoundCategory.NEUTRAL, this);
                net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(this.engineloop);
                Print.debug("engine_running -> Playing! (LOOP)");
            }
            else{
                Print.debug("engine_running -> Not found.");
            }
    	}
    	else if(!vehicle.engine.isOn()){
    		engineloop = null;
    	}
    	if(engineloop != null){
    		engineloop.patch = 1f;//TODO calc
    	}*///TODO
	}

    public static final float TICKA = 1f / 20f, o132 = Static.sixteenth / 2;
    private double appmass = 0;
    private double accx = 0f;

	//TODO @Override
	public void onUpdateMovement(){
		EntityW driver = vehicle.driver();
		if(!world.isRemote){
			if(driver == null || !(driver.isCreative() || vehicle.data.getAttribute("fuel_stored").asInteger() > 0)){
				vehicle.throttle *= 0.98F;
			}
			if(vehicle.front == null){
				if(vehicle.data.getType().isTrailer()) relign();
				else onUpdateMovement1(driver);
			}
		}
		else updateSounds();
		//
	}

	public void onUpdateMovement1(EntityW driver){
		if(vehicle.rear != null){
			ULandVehicle trailer = vehicle.rear.entity.local();
			while(trailer.vehicle.rear != null) trailer = trailer.vehicle.rear.entity.local();
			ULandVehicle truck = trailer.vehicle.front.entity.local();
			trailer.appmass = trailer.vehicle.data.getAttributeFloat("weight", 1000);
			while(truck != null){
				truck.appmass = truck.vehicle.data.getAttributeFloat("weight", 1000);
				truck.appmass += ((ULandVehicle)truck.vehicle.rear.entity.direct()).appmass * truck.vehicle.rear.data.getAttributeFloat("trailer_weight_ratio", 0.2f);
				truck = truck.vehicle.front.entity.local();
			}
		}
		else appmass = vehicle.data.getAttributeFloat("weight", 1000f);
		double mass = appmass;
		double rr = vehicle.data.getAttributeFloat("roll_resistance", 8f);
		double ar = vehicle.data.getAttributeFloat("air_resistance", 2.5f);
		for(Axle axle : axles) axle.calc(mass, accx, cg_height, wheelbase, 1f);
		boolean overloaded = appmass - vehicle.data.getAttributeFloat("weight", 1000f) > vehicle.data.getAttributeFloat("max_towing", 3500f);
		//
		V3D atmc = new V3D(0, 0, 0);
        boolean consumed = vehicle.consumeFuel();
        boolean nopass = this.getPassengers().isEmpty();
        
        double brkf = vehicle.data.getAttributeFloat("brake_force", 10000f) * vehicle.brake;
    	double brake = Math.min(brkf + (vehicle.pbrake ? vehicle.data.getAttributeFloat("parking_brake_force", 5000f) : 0), brkf);
    	int gear = vehicle.data.getAttributeInteger("gear", 0);
    	float diff = vehicle.data.getAttributeFloat("differential_ratio", 3.5f);
    	if(vehicle.engine != null && vehicle.transmission != null){
        	orpm = rpm;
        	rpm = (int)((vehicle.speed / axles.get(0).wheels.get(0).radius) * vehicle.transmission.getRatio(gear) * diff * 60 / Static.PI2);
        	rpm = (orpm + rpm) / 2;
        	if(rpm < 0) rpm = -rpm;
        	if(rpm < vehicle.engine.minRPM()) rpm = vehicle.engine.minRPM();
        	if(rpm > vehicle.engine.maxRPM()) rpm = vehicle.engine.maxRPM();
    	}
    	double force = 0;
    	if(!overloaded && vehicle.engine != null && vehicle.transmission != null){
    		force = vehicle.engine.getTorque(rpm) * vehicle.transmission.getRatio(gear) * diff * vehicle.transmission.getEfficiency() / axles.get(0).wheels.get(0).radius;
        	if(vehicle.transmission.isAutomatic() && vehicle.autogear_timer <= 0){
        		int ngear = vehicle.transmission.processAutoShift(gear, rpm, vehicle.engine.maxRPM(), vehicle.throttle);
        		if(ngear != gear){
        			vehicle.data.getAttribute("gear").set(ngear);
					vehicle.updateAttr("gear");
        		}
        		vehicle.autogear_timer += vehicle.transmission.getShiftSpeed();
        	}
    	}
    	if(overloaded){
    		//TODO dedicated icon/message in GUI
			driver.bar("&cTEMP: Towing limit reached, vehicle is overloaded.");
    	}
    	double thr = vehicle.throttle * force;
    	double cos = Math.cos(vehicle.pivot().yaw());
    	double sin = Math.sin(vehicle.pivot().yaw());
    	boolean slowdown = vehicle.throttle < 0.001f || gear == 0;
    	double val;
    	onGround = true;
    	accx = 0;
        //
        for(UniWheel ent : vehicle.wheels.values()){
			WheelEntity wheel = (WheelEntity)ent;
            if(wheel == null) continue;
			WheelSlot slot = vehicle.data.getWheelSlots().get(wheel.wheelid);
            wheel.onGround = true;
            wheel.rotationYaw = vehicle.pivot().deg_yaw();
			double wheelrot = Math.toRadians(wheel.rotationYaw);
            BlockPos wheelpos = new BlockPos(wheel.posX, wheel.posY - o132, wheel.posZ);
        	boolean rainfall = world.isRainingAt(wheelpos);
            Material mat = world.getBlockState(wheelpos).getMaterial();
            if(slowdown || vehicle.speed < 3 || nopass){
            	boolean brk = vehicle.brake > 0 || vehicle.pbrake;
            	double by = brk && !slowdown ? 0 : vehicle.speed < 3 ? 0.9 : 0.99;
	            wheel.motionX *= by;
	            wheel.motionY *= by;
	            wheel.motionZ *= by;
            }
            wheel.motionY -= GRAVITY_200th;
            //
        	double motx = cos * wheel.motionX + sin * wheel.motionZ;
        	double moty = cos * wheel.motionZ - sin * wheel.motionX;
            double stew = Math.toRadians(vehicle.steer_yaw);
            double steer = slot.steering ? Math.signum(motx) * stew : 0;
            double slip_angle = Math.atan2(moty + wheel.wheel.axle.yaw_speed, Math.abs(motx)) - steer;
            double grip = wheel.wheel.function.getGripFor(mat, rainfall) * (slot.braking && vehicle.pbrake ? wheel.wheel.function.brake_grip : 1);
        	double frict = Static.clamp((wheel.wheel.function.getCornerStiffnessFor(mat, slot.steering)) * slip_angle, -grip, grip) * wheel.wheel.axle.weight_on;
        	double trac = wheel.wheel.function.getGripFor(mat, rainfall) * ((consumed ? thr : 0) - brake * Math.signum(motx));//grip inclusion here is for testing
        	double dragx = -rr * motx - ar * motx * Math.abs(motx);
        	double dragy = -rr * moty - ar * moty * Math.abs(moty);
        	double totalx = dragx + trac;
        	double totaly = dragy + (slot.steering ? Math.cos(stew) * frict : 0);
        	double acx = (totalx / mass) * TICKA;
        	double acy = (totaly / mass) * TICKA;
        	accx += acx;
        	//
			val = acx * MOTION_SCALE;
			wheel.motionX *= 0.25;
			wheel.motionZ *= 0.25;
			wheel.motionX -= Math.sin(-wheelrot) * (val + motx * 0.75);
			wheel.motionZ -= Math.cos(-wheelrot) * (val + motx * 0.75);
			//
			if(slot.steering){
				val = acy * TICKA;
				wheel.motionX -= Math.sin(-wheelrot) * val * stew;
				wheel.motionZ -= Math.cos(-wheelrot) * val * stew;
			}
            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
            atmc = alignWheel(this, wheel, wheel.wheel.pos, atmc, false);//pulling wheel back to vehicle
        }
        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
        accx /= vehicle.wheels.size();
        rerot();
        //
        ULandVehicle trailer = vehicle.rear == null ? null : vehicle.rear.entity.local();
        while(trailer != null){
        	atmc = new V3D(0, 0, 0);
			V3D opos = new V3D(trailer.posX, trailer.posY, trailer.posZ);
            V3D conn = trailer.vehicle.front.pivot().get_vector(V3D.NULL);//trailer.truck.getVehicleData().getRearConnector());
            val = opos.dis(conn = conn.add(trailer.vehicle.front.getV3D()));
        	//cos = Math.cos(trailer.vehicle.pivot().yaw());
        	//sin = Math.sin(trailer.vehicle.pivot().yaw());
            //
            V3D trax = trailer.vehicle.pivot().get_vector(trailer.ax_rear.pos).add(trailer.posX, trailer.posY, trailer.posZ);
            trailer.vehicle.pivot().set_yaw((float)Math.atan2(conn.z - trax.z, conn.x - trax.x), false);
        	trailer.onGround = true;
			for(UniWheel ent : trailer.vehicle.wheels.values()){
				WheelEntity wheel = (WheelEntity)ent;
        		if(wheel == null) continue;
        		wheel.onGround = true;
                wheel.rotationYaw = trailer.vehicle.pivot().deg_yaw();
                wheel.motionX = wheel.motionZ = 0;
                if(val < GRAVITY_200th) wheel.motionY = 0;
                wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * val;
                wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * val;
                wheel.motionY -= GRAVITY_200th;
                atmc = alignWheel(trailer, wheel, wheel.wheel.pos, atmc, true);
                //trailer.rerott();
        	}
            trailer.move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
            trailer.opos();
            trailer.setPosition(conn.x, conn.y, conn.z);
			for(UniWheel ent : trailer.vehicle.wheels.values()){
				WheelEntity wheel = (WheelEntity)ent;
            	wheel.move(MoverType.SELF, 0, -GRAVITY_200th, 0);
            }
            trailer.rerot();
        	trailer = vehicle.rear == null ? null : vehicle.rear.entity.local();
        }
	}
	
	private void relign(){
		int wheelid = 0;
		V3D atmc = new V3D(0, 0, 0);
		for(UniWheel ent : vehicle.wheels.values()){
			WheelEntity wheel = (WheelEntity)ent;
            if(wheel == null) continue;
            onGround = true; wheel.onGround = true;
            wheel.rotationYaw = vehicle.pivot().deg_yaw();
            wheel.motionX *= 0.9F;
            wheel.motionY *= 0.9F;
            wheel.motionZ *= 0.9F;
            wheel.motionY -= GRAVITY_20th;//Gravity
            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
            atmc = alignWheel(this, wheel, wheel.wheel.pos, atmc, true);
            wheelid++;
        }
        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
        rerot();
	}
	
	private void opos(){ prevPosX = posX; prevPosY = posY; prevPosZ = posZ; }
	
	private static V3D alignWheel(ULandVehicle vehicle, WheelEntity wheel, V3D vec, V3D atmc, boolean corrcheck){
		V3D targetpos = vehicle.vehicle.pivot().get_vector(vec);
		V3D current = new V3D(wheel.posX - vehicle.posX, wheel.posY - vehicle.posY, wheel.posZ - vehicle.posZ);
		V3D despos = new V3D(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(0.5f);//TODO lata.wss
        if(despos.length() > 0.001F){
            wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
            despos = despos.scale(0.5F);
            return atmc.sub(despos);
        }
        if(corrcheck && wheel.getPositionVector().distanceTo(vehicle.getPositionVector()) > 8){//1024
            wheel.posX = despos.x;
            wheel.posY = despos.y;
            wheel.posZ = despos.z;
        }
        return atmc;
	}
    
    public void rerot(){
		V3D fron, rear, left, righ;
		WheelEntity fl = vehicle.wheels.getWheel(vehicle.w_front_l.id);
		WheelEntity fr = vehicle.wheels.getWheel(vehicle.w_front_r.id);
		WheelEntity rl = vehicle.wheels.getWheel(vehicle.w_rear_l.id);
		WheelEntity rr = vehicle.wheels.getWheel(vehicle.w_rear_r.id);
		fron = new V3D((fl.posX + fr.posX) * 0.5, (fl.posY + fr.posY) * 0.5, (fl.posZ + fr.posZ) * 0.5);
		rear = new V3D((rl.posX + rr.posX) * 0.5, (rl.posY + rr.posY) * 0.5, (rl.posZ + rr.posZ) * 0.5);
		left = new V3D((fl.posX + rl.posX) * 0.5, (fl.posY + rl.posY) * 0.5, (fl.posZ + rl.posZ) * 0.5);
		righ = new V3D((fr.posX + rr.posX) * 0.5, (fr.posY + rr.posY) * 0.5, (fr.posZ + rr.posZ) * 0.5);
		double dx = rear.x - fron.x, dy = rear.y - fron.y, dz = rear.z - fron.z;
		double drx = righ.x - left.x, dry = righ.y - left.y, drz = righ.z - left.z;
		double dxz = Math.sqrt(dx * dx + dz * dz);
		double y = -Math.atan2(dx, dz);
		double p = -Math.atan2(dy, dxz);
		double r = Math.atan2(dry, Math.sqrt((drx * drx + drz * drz)));
		vehicle.pivot().set_rotation(y, p, r, false);
    }

}
