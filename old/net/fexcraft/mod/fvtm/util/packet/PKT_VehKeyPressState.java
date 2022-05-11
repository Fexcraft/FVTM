package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_VehKeyPressState implements IPacket, IMessage {

    public KeyPress keypress;
    public Boolean state;
    public int source, player;

    public PKT_VehKeyPressState(){}
    
    public PKT_VehKeyPressState(Entity source, Entity player, KeyPress key, boolean state){
		this.keypress = key;
		this.state = state;
		this.source = source.getEntityId();
		this.player = player.getEntityId();
	}

	@Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(keypress.ordinal());
        buf.writeBoolean(state);
        buf.writeInt(source);
        buf.writeInt(player);
    }

    @Override
    public void fromBytes(ByteBuf buf){
        keypress = KeyPress.values()[buf.readInt()];
        state = buf.readBoolean();
        source = buf.readInt();
        player = buf.readInt();
    }

}
