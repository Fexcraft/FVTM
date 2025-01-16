package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.tag.TagCW;

import java.nio.charset.StandardCharsets;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_TagListener implements PacketBase<Packet_TagListener> {

	public String to;
	public TagCW tag;

	@Override
	public Packet_TagListener fill(Object[] data){
		to = (String)data[0];
		tag = (TagCW)data[1];
		return this;
	}

	@Override
	public void encode(ByteBuf buffer){
		Packets.INSTANCE.writeTag(buffer, tag);
		byte[] bytes = to.getBytes(StandardCharsets.UTF_8);
		buffer.writeInt(bytes.length);
		buffer.writeBytes(bytes);
	}

	@Override
	public void decode(ByteBuf buffer){
		tag = Packets.INSTANCE.readTag(buffer);
		int length = buffer.readInt();
		to = buffer.toString(buffer.readerIndex(), length, StandardCharsets.UTF_8);
	}

}
