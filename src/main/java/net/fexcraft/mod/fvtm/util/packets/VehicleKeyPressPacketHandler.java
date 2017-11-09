package net.fexcraft.mod.fvtm.util.packets;

import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class VehicleKeyPressPacketHandler implements IMessageHandler<PacketVehicleKeyPress, IMessage>{
	
	@Override
	public IMessage onMessage(final PacketVehicleKeyPress packet, final MessageContext ctx) {
		IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
		ls.addScheduledTask(new Runnable(){
			@Override
			public void run(){
				EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(ctx.getServerHandler().player.getName());
				if(player.getRidingEntity() != null && player.getRidingEntity() instanceof SeatEntity){
					((SeatEntity)player.getRidingEntity()).onKeyPress(packet.key, player);
				}
			}
			
		});
		return null;
	}
	
}