package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.SeatCache;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_VehKeyPress implements IMessageHandler<PKT_VehKeyPress, IMessage> {

    @Override
    public IMessage onMessage(final PKT_VehKeyPress packet, final MessageContext ctx){
        IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
        ls.addScheduledTask(new Runnable() {
            @Override
            public void run(){
                EntityPlayerMP player = ctx.getServerHandler().player;
                if(player.getRidingEntity() != null && player.getRidingEntity() instanceof GenericVehicle){
                	SeatCache seat = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
                    seat.onKeyPress(packet.keypress, player);
                }
            }
        }); return null;
    }

}
