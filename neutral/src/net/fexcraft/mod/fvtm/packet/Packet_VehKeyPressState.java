package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_VehKeyPressState implements PacketBase<Packet_VehKeyPressState> {

	public KeyPress keypress;
	public Boolean state;
	public int source;
	public int player;

	@Override
	public Packet_VehKeyPressState fill(Object[] data){
		keypress = (KeyPress)data[0];
		state = (Boolean)data[1];
		source = (int)data[2];
		player = (int)data[3];
		return this;
	}

	@Override
	public void encode(ByteBuf buffer){
		buffer.writeInt(keypress.ordinal());
		buffer.writeBoolean(state);
		buffer.writeInt(source);
		buffer.writeInt(player);
	}

	@Override
	public void decode(ByteBuf buffer){
		keypress = KeyPress.values()[buffer.readInt()];
		state = buffer.readBoolean();
		source = buffer.readInt();
		player = buffer.readInt();
	}

	@Override
	public Object[] data(){
		return new Object[]{ keypress, state, source, player };
	}

}
