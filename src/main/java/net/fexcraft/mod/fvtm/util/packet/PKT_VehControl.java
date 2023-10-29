package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_VehControl implements IPacket, IMessage {

    public int entid, fuel;
    public double posX, posY, posZ;
    public float yaw, pitch, roll;
    public double throttle, steeringYaw;
    public int rpm;

    public PKT_VehControl(){}

    public PKT_VehControl(GenericVehicle veh){
    	entid = veh.getEntityId();
    	posX = veh.posX; posY = veh.posY; posZ = veh.posZ;
        yaw = veh.getRotPoint().getPivot().deg_yaw();
        pitch = veh.getRotPoint().getPivot().deg_pitch();
        roll = veh.getRotPoint().getPivot().deg_roll();
        fuel = veh.getVehicleData().getAttribute("fuel_stored").asInteger();
        steeringYaw = veh.wheelsYaw; throttle = veh.throttle;
        if(veh instanceof ULandVehicle) rpm = ((ULandVehicle)veh).rpm;
    }

    public PKT_VehControl(EntityW entity){
        this((RootVehicle)entity.direct());
    }

    public PKT_VehControl(RootVehicle veh){
        entid = veh.getEntityId();
        posX = veh.posX; posY = veh.posY; posZ = veh.posZ;
        yaw = veh.vehicle.pivot().deg_yaw();
        pitch = veh.vehicle.pivot().deg_pitch();
        roll = veh.vehicle.pivot().deg_roll();
        fuel = veh.vehicle.data.getAttribute("fuel_stored").asInteger();
        steeringYaw = veh.vehicle.steer_yaw;
        throttle = veh.vehicle.throttle;
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(entid);
        buf.writeDouble(posX);
        buf.writeDouble(posY);
        buf.writeDouble(posZ);
        buf.writeFloat(yaw);
        buf.writeFloat(pitch);
        buf.writeFloat(roll);
        buf.writeDouble(throttle);
        buf.writeDouble(steeringYaw);
        buf.writeInt(rpm);
        buf.writeInt(fuel);
    }

    @Override
    public void fromBytes(ByteBuf buf){
    	entid = buf.readInt();
        posX = buf.readDouble();
        posY = buf.readDouble();
        posZ = buf.readDouble();
        yaw = buf.readFloat();
        pitch = buf.readFloat();
        roll = buf.readFloat();
        throttle = buf.readDouble();
        steeringYaw = buf.readDouble();
        rpm = buf.readInt();
        fuel = buf.readInt();
    }

}
