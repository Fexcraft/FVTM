package net.fexcraft.mod.fvtm.util.packet;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_SPUpdate implements IPacket, IMessage {

	public int entid;
	public String pointid;
	public double posX, posY, posZ;
	public float yaw, pitch, roll;;

	public PKT_SPUpdate(){}

	public PKT_SPUpdate(Entity entity, SwivelPoint point){
		entid = entity.getEntityId();
		posX = point.getPos().x;
		posY = point.getPos().y;
		posZ = point.getPos().z;
		yaw = point.getAxes().deg_yaw();
		pitch = point.getAxes().deg_pitch();
		roll = point.getAxes().deg_roll();
		pointid = point.id;
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
		byte[] bytes = pointid.getBytes(StandardCharsets.UTF_8);
        buf.writeInt(bytes.length);
        buf.writeBytes(bytes);
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
		int index = buf.readInt();
		pointid = buf.toString(buf.readerIndex(), index, StandardCharsets.UTF_8);;
	}

}
