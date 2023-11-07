package net.fexcraft.mod.fvtm.sys.pro;

import net.fexcraft.mod.fvtm.data.vehicle.SimplePhysData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class NLandVehicle extends RootVehicle {

	public SimplePhysData spdata;

	public NLandVehicle(World world){
		super(world);
		preventEntitySpawning = true;
		ignoreFrustumCheck = true;
		setSize(1f, 1f);
		stepHeight = 1f;
		if(world.isRemote){
			setRenderDistanceWeight(1D);
		}
	}

	public NLandVehicle(World world, VehicleData data, Vec3d pos, EntityPlayer placer, int meta){
		this(world);
		setPosition(pos.x, pos.y, pos.z);
		vehicle.init(data);
		if(placer != null){
			vehicle.setPlacer(placer.getGameProfile().getId());
			vehicle.point.getPivot().set_yaw(placer.rotationYaw, true);
		}
		init();
	}

	public NLandVehicle(NLandVehicle truck, VehicleData data, EntityPlayer placer){
		this(truck.world, data, truck.getPositionVector(), placer, 0);
		vehicle.front = truck.vehicle;
		truck.vehicle.rear = vehicle;
		vehicle.point.updatePrevAxe();
		vehicle.point.getPivot().copy(truck.vehicle.point.getPivot());
	}

	@Override
	protected void init(){
		spdata = vehicle.data.getType().getSphData();
		stepHeight = spdata.wheel_step_height;
		super.init();
	}

}
