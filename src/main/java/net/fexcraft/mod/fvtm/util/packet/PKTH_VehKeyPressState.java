package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_VehKeyPressState implements IMessageHandler<PKT_VehKeyPressState, IMessage> {

    @Override
    public IMessage onMessage(final PKT_VehKeyPressState packet, final MessageContext ctx){
        IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
        ls.addScheduledTask(new Runnable() {
            @Override
            public void run(){
                EntityPlayerMP player = ctx.getServerHandler().player;
                if(player.getRidingEntity() != null && player.getRidingEntity() instanceof GenericVehicle){
                	SeatCache seat = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
                    seat.vehicle.onKeyPress(packet.keypress, seat.seatdata, player, packet.state);
                }
            }
        }); return null;
    }

}
