package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.world.EntityW;

import java.nio.charset.StandardCharsets;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_SPUpdate implements PacketBase<Packet_SPUpdate> {

	public int entid;
	public String pointid;
	public double posX;
    public double posY;
    public double posZ;
	public float yaw;
    public float pitch;
    public float roll;

    @Override
    public Packet_SPUpdate fill(Object[] data){
        entid = ((EntityW)data[0]).getId();
        SwivelPoint point = (SwivelPoint)data[1];
		posX = point.getPos().x;
		posY = point.getPos().y;
		posZ = point.getPos().z;
		yaw = point.getPivot().deg_yaw();
		pitch = point.getPivot().deg_pitch();
		roll = point.getPivot().deg_roll();
		pointid = point.id;
        return this;
    }

    @Override
    public void encode(ByteBuf buffer){
        buffer.writeInt(entid);
		buffer.writeDouble(posX);
		buffer.writeDouble(posY);
		buffer.writeDouble(posZ);
		buffer.writeFloat(yaw);
		buffer.writeFloat(pitch);
		buffer.writeFloat(roll);
		byte[] bytes = pointid.getBytes(StandardCharsets.UTF_8);
        buffer.writeInt(bytes.length);
        buffer.writeBytes(bytes);
    }

    @Override
    public void decode(ByteBuf buffer){
		entid = buffer.readInt();
		posX = buffer.readDouble();
		posY = buffer.readDouble();
		posZ = buffer.readDouble();
		yaw = buffer.readFloat();
		pitch = buffer.readFloat();
		roll = buffer.readFloat();
		int length = buffer.readInt();
		pointid = buffer.readCharSequence(length, StandardCharsets.UTF_8).toString();
    }

}
