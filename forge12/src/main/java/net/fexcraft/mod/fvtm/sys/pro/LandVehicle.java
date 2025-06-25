package net.fexcraft.mod.fvtm.sys.pro;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class LandVehicle extends RootVehicle {

	public LandVehicle(World world){
		super(world);
		preventEntitySpawning = true;
		ignoreFrustumCheck = true;
		setSize(1f, 1f);
		stepHeight = 1f;
		if(world.isRemote){
			setRenderDistanceWeight(1D);
		}
	}

	public LandVehicle(World world, VehicleData data, Vec3d pos, EntityPlayer placer, int meta){
		this(world);
		setPosition(pos.x, pos.y, pos.z);
		vehicle.init(data, null);
		if(placer != null){
			vehicle.setPlacer(placer.getGameProfile().getId());
			vehicle.pivot().set_yaw(placer.rotationYaw, true);
		}
		init(null);
	}

	public LandVehicle(LandVehicle truck, VehicleData data, EntityPlayer placer){
		this(truck.world, data, truck.getPositionVector(), placer, 0);
		vehicle.front = truck.vehicle;
		truck.vehicle.rear = vehicle;
		vehicle.point.updatePrevAxe();
		vehicle.point.getPivot().copy(truck.vehicle.point.getPivot());
		vehicle.sendUpdate(VehicleInstance.PKT_UPD_CONNECTOR);
	}

	@Override
	protected void init(TagCW com){
		stepHeight = 0.5f;
		super.init(com);
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
			vehicle.front = ((LandVehicle)world.getEntityByID(com.getInteger("TruckId"))).vehicle;
			vehicle.front.rear = vehicle;
		}
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
	}

}
