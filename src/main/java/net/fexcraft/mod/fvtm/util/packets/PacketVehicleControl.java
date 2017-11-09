package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.entities.LandVehicleEntity;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketVehicleControl implements IPacket, IMessage{
	
	public int entityId;
	public double posX, posY, posZ;
	public float yaw, pitch, roll;
	public double motX, motY, motZ;
	public double avelx, avely, avelz;
	public double throttle;
	public float steeringYaw;
	public boolean doors;
	
	public PacketVehicleControl(){}
	
	public PacketVehicleControl(LandVehicleEntity vehicle){
		entityId = vehicle.getEntityId();
		posX = vehicle.posX;
		posY = vehicle.posY;
		posZ = vehicle.posZ;
		yaw = vehicle.axes.getYaw();
		pitch = vehicle.axes.getPitch();
		roll = vehicle.axes.getRoll();
		motX = vehicle.motionX;
		motY = vehicle.motionY;
		motZ = vehicle.motionZ;
		avelx = vehicle.angularVelocity.x;
		avely = vehicle.angularVelocity.y;
		avelz = vehicle.angularVelocity.z;
		throttle = vehicle.throttle;
		steeringYaw = vehicle.wheelsYaw;
		doors = vehicle.getVehicleData().doorsOpen();
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entityId);
		buf.writeDouble(posX);
		buf.writeDouble(posY);
		buf.writeDouble(posZ);
		buf.writeFloat(yaw);
		buf.writeFloat(pitch);
		buf.writeFloat(roll);
		buf.writeDouble(motX);
		buf.writeDouble(motY);
		buf.writeDouble(motZ);
		buf.writeDouble(avelx);
		buf.writeDouble(avely);
		buf.writeDouble(avelz);
		buf.writeDouble(throttle);
		buf.writeFloat(steeringYaw);
		buf.writeBoolean(doors);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entityId = buf.readInt();
		posX = buf.readDouble();
		posY = buf.readDouble();
		posZ = buf.readDouble();
		yaw = buf.readFloat();
		pitch = buf.readFloat();
		roll = buf.readFloat();
		motX = buf.readDouble();
		motY = buf.readDouble();
		motZ = buf.readDouble();
		avelx = buf.readDouble();
		avely = buf.readDouble();
		avelz = buf.readDouble();
		throttle = buf.readDouble();
		steeringYaw = buf.readFloat();
		doors = buf.readBoolean();
	}
	
}