package net.fexcraft.mod.fvtm.util;


import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.packet.*;
import net.fexcraft.mod.uni.UniEntity;
import net.minecraft.client.Minecraft;
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
				.addScheduledTask(handleServer(message, UniEntity.getEntity(ctx.getServerHandler().player)));
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
				.addScheduledTask(handleServer(message, UniEntity.getEntity(ctx.getServerHandler().player)));
			return null;
		}

	}

	public static class HI_SeatUpdate_C extends Handler_SeatUpdate implements IMessageHandler<PI_SeatUpdate, IMessage> {

		@Override
		public IMessage onMessage(PI_SeatUpdate message, MessageContext ctx){
			Minecraft.getMinecraft()
				.addScheduledTask(handleClient(message, UniEntity.getEntity(Minecraft.getMinecraft().player)));
			return null;
		}

	}

	//---//---//---//

	public static class PI_SPUpdate extends Packet_SPUpdate implements IMessage {

		@Override
		public void fromBytes(ByteBuf buf){
			decode(buf);
		}

		@Override
		public void toBytes(ByteBuf buf){
			encode(buf);
		}

	}

	public static class HI_SPUpdate_S extends Handler_SPUpdate implements IMessageHandler<PI_SPUpdate, IMessage> {

		@Override
		public IMessage onMessage(PI_SPUpdate message, MessageContext ctx){
			FMLCommonHandler.instance().getMinecraftServerInstance()
				.addScheduledTask(handleServer(message, UniEntity.getEntity(ctx.getServerHandler().player)));
			return null;
		}

	}

	public static class HI_SPUpdate_C extends Handler_SPUpdate implements IMessageHandler<PI_SPUpdate, IMessage> {

		@Override
		public IMessage onMessage(PI_SPUpdate message, MessageContext ctx){
			Minecraft.getMinecraft()
				.addScheduledTask(handleClient(message, UniEntity.getEntity(Minecraft.getMinecraft().player)));
			return null;
		}

	}

	//---//---//---//

	public static class PI_VehKeyPressState extends Packet_VehKeyPressState implements IMessage {

		@Override
		public void fromBytes(ByteBuf buf){
			decode(buf);
		}

		@Override
		public void toBytes(ByteBuf buf){
			encode(buf);
		}

	}

	public static class HI_VehKeyPressState_S extends Handler_VehKeyPressState implements IMessageHandler<PI_VehKeyPressState, IMessage> {

		@Override
		public IMessage onMessage(PI_VehKeyPressState message, MessageContext ctx){
			FMLCommonHandler.instance().getMinecraftServerInstance()
				.addScheduledTask(handleServer(message, UniEntity.getEntity(ctx.getServerHandler().player)));
			return null;
		}

	}

	public static class HI_VehKeyPressState_C extends Handler_VehKeyPressState implements IMessageHandler<PI_VehKeyPressState, IMessage> {

		@Override
		public IMessage onMessage(PI_VehKeyPressState message, MessageContext ctx){
			Minecraft.getMinecraft()
				.addScheduledTask(handleClient(message, UniEntity.getEntity(Minecraft.getMinecraft().player)));
			return null;
		}

	}

	//---//---//---//

	public static class PI_TagListener extends Packet_TagListener implements IMessage {

		@Override
		public void fromBytes(ByteBuf buf){
			decode(buf);
		}

		@Override
		public void toBytes(ByteBuf buf){
			encode(buf);
		}

	}

	public static class HI_TagListener_S extends Handler_TagListener implements IMessageHandler<PI_TagListener, IMessage> {

		@Override
		public IMessage onMessage(PI_TagListener message, MessageContext ctx){
			try{
				FMLCommonHandler.instance().getMinecraftServerInstance()
					.addScheduledTask(handleServer(message, UniEntity.getEntity(ctx.getServerHandler().player)));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

	}

	public static class HI_TagListener_C extends Handler_TagListener implements IMessageHandler<PI_TagListener, IMessage> {

		@Override
		public IMessage onMessage(PI_TagListener message, MessageContext ctx){
			try{
				Minecraft.getMinecraft()
					.addScheduledTask(handleClient(message, UniEntity.getEntity(Minecraft.getMinecraft().player)));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

	}

	//---//---//---//

	public static class PI_VehMove extends Packet_VehMove implements IMessage {

		@Override
		public void fromBytes(ByteBuf buf){
			decode(buf);
		}

		@Override
		public void toBytes(ByteBuf buf){
			encode(buf);
		}

	}

	public static class HI_VehMove_S extends Handler_VehMove implements IMessageHandler<PI_VehMove, IMessage> {

		@Override
		public IMessage onMessage(PI_VehMove message, MessageContext ctx){
			FMLCommonHandler.instance().getMinecraftServerInstance()
				.addScheduledTask(handleServer(message, UniEntity.getEntity(ctx.getServerHandler().player)));
			return null;
		}

	}

	public static class HI_VehMove_C extends Handler_VehMove implements IMessageHandler<PI_VehMove, IMessage> {

		@Override
		public IMessage onMessage(PI_VehMove message, MessageContext ctx){
			if(Minecraft.getMinecraft().player == null) return null;
			Minecraft.getMinecraft()
				.addScheduledTask(handleClient(message, UniEntity.getEntity(Minecraft.getMinecraft().player)));
			return null;
		}

	}

}
