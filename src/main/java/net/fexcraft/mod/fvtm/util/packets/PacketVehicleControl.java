package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.entities.rail.RailboundVehicleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketVehicleControl implements IPacket, IMessage {

    public long entId0, entId1;
    public double posX, posY, posZ;
    public float yaw, pitch, roll;
    public double motX, motY, motZ;
    public double avelx, avely, avelz;
    public double throttle, steeringYaw;
    public boolean doors;

    public PacketVehicleControl(){
    }

    public PacketVehicleControl(VehicleEntity vehicle){
        Entity ent = vehicle.getEntity();
        entId0 = ent.getPersistentID().getMostSignificantBits();
        entId1 = ent.getPersistentID().getLeastSignificantBits();
        posX = ent.posX;
        posY = ent.posY;
        posZ = ent.posZ;
        if(vehicle instanceof RailboundVehicleEntity){
        	RailboundVehicleEntity railent = (RailboundVehicleEntity)vehicle.getEntity();
        	//net.fexcraft.lib.mc.utils.Print.debug(railent.railent.accumulator);
            steeringYaw = railent.railent.accumulator; railent.railent.accumulator = 0;
        }
        else{
            steeringYaw = vehicle.getWheelsYaw();
        }
        yaw = vehicle.getAxes().getYaw();
        pitch = vehicle.getAxes().getPitch();
        roll = vehicle.getAxes().getRoll();
        motX = ent.motionX;
        motY = ent.motionY;
        motZ = ent.motionZ;
        Vec3d agl = vehicle.getAngularVelocity();
        avelx = agl.x;
        avely = agl.y;
        avelz = agl.z;
        throttle = vehicle.getThrottle();
        doors = vehicle.getVehicleData().doorsOpen();
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeLong(entId0);
        buf.writeLong(entId1);
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
        buf.writeDouble(steeringYaw);
        buf.writeBoolean(doors);
    }

    @Override
    public void fromBytes(ByteBuf buf){
    	entId0 = buf.readLong();
    	entId1 = buf.readLong();
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
        steeringYaw = buf.readDouble();
        doors = buf.readBoolean();
    }

}
