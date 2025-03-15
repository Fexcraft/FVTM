package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_VehMove implements PacketBase<Packet_VehMove> {

    public int entid;
	public int fuel;
    public double[] pos;
    public double[] rot;
    public double throttle;
	public double steering;
    public int rpm;

    @Override
    public Packet_VehMove fill(Object[] data){
		EntityW ent = (EntityW)data[0];
        entid = ent.getId();
		pos = ent.getPos().toDoubleArray();
		VehicleInstance vehicle = (VehicleInstance)data[1];
        rot = vehicle.pivot().toArray();
        fuel = vehicle.data.getAttribute("fuel_stored").asInteger();
        steering = vehicle.steer_yaw;
        throttle = vehicle.throttle;
        return this;
    }

    @Override
    public void encode(ByteBuf buffer){
        buffer.writeInt(entid);
        buffer.writeDouble(pos[0]);
        buffer.writeDouble(pos[1]);
        buffer.writeDouble(pos[2]);
        buffer.writeDouble(rot[0]);
        buffer.writeDouble(rot[1]);
        buffer.writeDouble(rot[2]);
        buffer.writeDouble(throttle);
        buffer.writeDouble(steering);
        buffer.writeInt(rpm);
        buffer.writeInt(fuel);
    }

    @Override
    public void decode(ByteBuf buffer){
    	entid = buffer.readInt();
        pos = new double[3];
        pos[0] = buffer.readDouble();
        pos[1] = buffer.readDouble();
        pos[2] = buffer.readDouble();
        rot = new double[3];
        rot[0] = buffer.readDouble();
        rot[1] = buffer.readDouble();
        rot[2] = buffer.readDouble();
        throttle = buffer.readDouble();
        steering = buffer.readDouble();
        rpm = buffer.readInt();
        fuel = buffer.readInt();
    }

}
