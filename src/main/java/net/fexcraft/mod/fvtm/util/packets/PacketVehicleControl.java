package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketVehicleControl implements IPacket, IMessage {

    public int entityId;
    public double posX, posY, posZ;
    public float yaw, pitch, roll;
    public double motX, motY, motZ;
    public double avelx, avely, avelz;
    public double throttle;
    public float steeringYaw;
    public boolean doors;

    public PacketVehicleControl(){
    }

    public PacketVehicleControl(VehicleEntity vehicle){
        Entity ent = vehicle.getEntity();
        entityId = ent.getEntityId();
        posX = ent.posX;
        posY = ent.posY;
        posZ = ent.posZ;
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
        steeringYaw = vehicle.getWheelsYaw();
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
