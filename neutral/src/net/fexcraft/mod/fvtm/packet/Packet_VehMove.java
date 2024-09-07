package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_VehMove implements PacketBase<Packet_VehMove> {

    public int entid;
	public int fuel;
    public V3D pos;
    public float yaw;
	public float pitch;
	public float roll;
    public double throttle;
	public double steering;
    public int rpm;

    @Override
    public Packet_VehMove fill(Object[] data){
		EntityW ent = (EntityW)data[0];
        entid = ent.getId();
		pos = ent.getPos();
		VehicleInstance vehicle = (VehicleInstance)data[1];
        yaw = vehicle.pivot().deg_yaw();
        pitch = vehicle.pivot().deg_pitch();
        roll = vehicle.pivot().deg_roll();
        fuel = vehicle.data.getAttribute("fuel_stored").asInteger();
        steering = vehicle.steer_yaw;
        throttle = vehicle.throttle;
        return this;
    }

    @Override
    public void encode(ByteBuf buffer){
        buffer.writeInt(entid);
        buffer.writeDouble(pos.x);
        buffer.writeDouble(pos.y);
        buffer.writeDouble(pos.z);
        buffer.writeFloat(yaw);
        buffer.writeFloat(pitch);
        buffer.writeFloat(roll);
        buffer.writeDouble(throttle);
        buffer.writeDouble(steering);
        buffer.writeInt(rpm);
        buffer.writeInt(fuel);
    }

    @Override
    public void decode(ByteBuf buffer){
    	entid = buffer.readInt();
		pos = new V3D(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        yaw = buffer.readFloat();
        pitch = buffer.readFloat();
        roll = buffer.readFloat();
        throttle = buffer.readDouble();
        steering = buffer.readDouble();
        rpm = buffer.readInt();
        fuel = buffer.readInt();
    }

}
