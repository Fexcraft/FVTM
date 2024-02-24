package net.fexcraft.mod.fvtm.packet;


import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.packet.Handler_VehKeyPress;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPress;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packets12 {

	public static class PI_VehKeyPress extends Packet_VehKeyPress implements IMessage {

		@Override
		public void fromBytes(ByteBuf buf){
			decode(buf);
		}

		@Override
		public void toBytes(ByteBuf buf){
			encode(buf);
		}

	}

	public static class HI_VehKeyPress extends Handler_VehKeyPress implements IMessageHandler<PI_VehKeyPress, IMessage> {

		@Override
		public IMessage onMessage(PI_VehKeyPress message, MessageContext ctx){
			FMLCommonHandler.instance().getMinecraftServerInstance()
				.addScheduledTask(handleServer(message, ctx.getServerHandler().player.getCapability(Capabilities.PASSENGER, null).asWrapper()));
			return null;
		}

	}

	//---//---//---//

	public static class PI_SeatUpdate extends Packet_SeatUpdate implements IMessage {

		@Override
		public void fromBytes(ByteBuf buf){
			decode(buf);
		}

		@Override
		public void toBytes(ByteBuf buf){
			encode(buf);
		}

	}

	public static class HI_SeatUpdate_S extends Handler_SeatUpdate implements IMessageHandler<PI_SeatUpdate, IMessage> {

		@Override
		public IMessage onMessage(PI_SeatUpdate message, MessageContext ctx){
			FMLCommonHandler.instance().getMinecraftServerInstance()
				.addScheduledTask(handleServer(message, ctx.getServerHandler().player.getCapability(Capabilities.PASSENGER, null).asWrapper()));
			return null;
		}

	}

	public static class HI_SeatUpdate_C extends Handler_SeatUpdate implements IMessageHandler<PI_SeatUpdate, IMessage> {

		@Override
		public IMessage onMessage(PI_SeatUpdate message, MessageContext ctx){
			FMLCommonHandler.instance().getMinecraftServerInstance()
				.addScheduledTask(handleClient(message, ctx.getServerHandler().player.getCapability(Capabilities.PASSENGER, null).asWrapper()));
			return null;
		}

	}

}
