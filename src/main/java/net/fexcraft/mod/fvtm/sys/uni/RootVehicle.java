package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;
import java.util.Map.Entry;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityWI;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RootVehicle extends Entity implements IEntityAdditionalSpawnData {

	public VehicleInstance vehicle;
	public WheelTireData w_front_l;
	public WheelTireData w_front_r;
	public WheelTireData w_rear_l;
	public WheelTireData w_rear_r;
	public ArrayList<NWheelEntity> wheels = new ArrayList<>();
	public AxisAlignedBB renderbox;
	public float prevRotationRoll = 0;
	public float wheel_radius = 0;

	public RootVehicle(World world){
		super(world);
		vehicle = new VehicleInstance(new EntityWI(this), null);
	}

	protected void init(){
		wheels.clear();
		wheel_radius = 0;
		for(Entry<String, V3D> entry : vehicle.data.getWheelPositions().entrySet()){
			WheelTireData wheel = new WheelTireData(entry.getKey());
			wheel.pos = entry.getValue();
			PartData part = vehicle.data.getPart(entry.getKey());
			if(!((WheelData)part.getType().getInstallHandlerData()).hasTire()){
				part = vehicle.data.getPart(entry.getKey()+ ":tire");
				wheel_radius += ((TireData)part.getType().getInstallHandlerData()).getOuterRadius();
			}
			else{
				wheel_radius += ((WheelData)part.getType().getInstallHandlerData()).getRadius();
			}
			wheel.function = part.getFunction(TireFunction.class, "fvtm:tire").getTireAttr(part);
			vehicle.wheeldata.put(entry.getKey(), wheel);
			//
			if(w_front_l == null || (wheel.pos.x <= w_front_l.pos.x && wheel.pos.z <= w_front_l.pos.z)){
				w_front_l = wheel;
			}
			if(w_front_r == null || (wheel.pos.x >= w_front_r.pos.x && wheel.pos.z <= w_front_r.pos.z)){
				w_front_r = wheel;
			}
			if(w_rear_l == null || (wheel.pos.x <= w_rear_l.pos.x && wheel.pos.z >= w_rear_l.pos.z)){
				w_rear_l = wheel;
			}
			if(w_rear_r == null || (wheel.pos.x >= w_rear_r.pos.x && wheel.pos.z >= w_rear_r.pos.z)){
				w_rear_r = wheel;
			}
		}
		wheel_radius /= vehicle.wheeldata.size();
		vehicle.seats.clear();
		for(int i = 0; i < vehicle.data.getSeats().size(); i++){
			vehicle.seats.add(new SeatInstance(vehicle, i));
		}
		setSize(vehicle.data.getAttribute("hitbox_width").asFloat(), vehicle.data.getAttribute("hitbox_height").asFloat());
		//TODO spawn script/event
		if(!world.isRemote && vehicle.front != null){
			//TODO send connection state update
		}
		if(world.isRemote){
			float cr = vehicle.data.getAttributeFloat("collission_range", 2f);
			renderbox = new AxisAlignedBB(-cr, -cr, -cr, cr, cr, cr);
			//TODO register for particles
		}
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		TagCW com = new TagCWI(compound);
		if(vehicle.data == null){
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
		}
		else{
			vehicle.data.read(com);
		}
		prevRotationYaw = com.getFloat("RotationYaw");
		prevRotationPitch = com.getFloat("RotationYaw");
		prevRotationRoll = com.getFloat("RotationYaw");
		vehicle.point.loadPivot(com);
		init();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		TagCW com = new TagCWI(compound);
		vehicle.data.write(com);
		vehicle.point.savePivot(com);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		TagCW com = TagCW.create();
		vehicle.point.savePivot(com);
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
		vehicle.data.write(com);
		ByteBufUtils.writeTag(buffer, com.local());
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		try{
			TagCW com = new TagCWI(ByteBufUtils.readTag(buffer));
			vehicle.init(FvtmResources.INSTANCE.getVehicleData(com));
			vehicle.point.loadPivot(com);
			prevRotationYaw = vehicle.point.getPivot().deg_yaw();
			prevRotationPitch = vehicle.point.getPivot().deg_pitch();
			prevRotationRoll = vehicle.point.getPivot().deg_roll();
			if(com.has("TruckId")){
				vehicle.front = ((NLandVehicle)world.getEntityByID(com.getInteger("TrickId"))).vehicle;
				vehicle.front.rear = vehicle;
			}
			init();
		}
		catch(Exception e){
			e.printStackTrace();
			FvtmLogger.LOGGER.log("Failed to receive additional spawn data for vehicle entity with ID " + getEntityId() + "!");
		}
	}

}
