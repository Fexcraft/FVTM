package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_VehControl implements IPacket, IMessage {

    public int entid;
    public Vec3d avel;
    public double posX, posY, posZ;
    public float yaw, pitch, roll;
    public double motX, motY, motZ;
    public double throttle, steeringYaw;

    public PKT_VehControl(){}

    public PKT_VehControl(GenericVehicle veh){
    	entid = veh.getEntityId(); posX = veh.posX; posY = veh.posY; posZ = veh.posZ;
        yaw = veh.getAxes().getYaw(); pitch = veh.getAxes().getPitch(); roll = veh.getAxes().getRoll();
        motX = veh.motionX; motY = veh.motionY; motZ = veh.motionZ;
        steeringYaw = veh.wheelsYaw; avel = veh.angularVelocity; throttle = veh.throttle;
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
        buf.writeDouble(motX);
        buf.writeDouble(motY);
        buf.writeDouble(motZ);
        buf.writeDouble(avel.x);
        buf.writeDouble(avel.y);
        buf.writeDouble(avel.z);
        buf.writeDouble(throttle);
        buf.writeDouble(steeringYaw);
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
        motX = buf.readDouble();
        motY = buf.readDouble();
        motZ = buf.readDouble();
        avel = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
        throttle = buf.readDouble();
        steeringYaw = buf.readDouble();
    }

}
