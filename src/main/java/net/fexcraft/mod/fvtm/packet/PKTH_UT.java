package net.fexcraft.mod.fvtm.packet;

import java.util.HashMap;
import java.util.function.BiConsumer;

import net.fexcraft.lib.mc.utils.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_UT {

    public static HashMap<String, BiConsumer<NBTTagCompound, EntityPlayer>> LIS_CLIENT = new HashMap<>();
    public static HashMap<String, BiConsumer<NBTTagCompound, EntityPlayer>> LIS_SERVER = new HashMap<>();

    public static class Server implements IMessageHandler<PKT_UT, IMessage> {

        @Override
        public IMessage onMessage(final PKT_UT packet, final MessageContext ctx){
            Static.getServer().addScheduledTask(() -> {
                BiConsumer<NBTTagCompound, EntityPlayer> cons = LIS_SERVER.get(packet.compound.getString("to"));
                if(cons != null) cons.accept(packet.compound, ctx.getServerHandler().player);
            });
            return null;
        }
    }

    public static class Client implements IMessageHandler<PKT_UT, IMessage> {

        @Override
        public IMessage onMessage(final PKT_UT packet, final MessageContext ctx){
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run(){
                    BiConsumer<NBTTagCompound, EntityPlayer> cons = LIS_CLIENT.get(packet.compound.getString("to"));
                    if(cons != null) cons.accept(packet.compound, net.minecraft.client.Minecraft.getMinecraft().player);
                }
            }); return null;
        }
    }

}
