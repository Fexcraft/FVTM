package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_UT implements IMessage {

    public NBTTagCompound compound;

    public PKT_UT(){}

    public PKT_UT(NBTTagCompound com){
    	compound = com;
    }

    public PKT_UT(TagCW com){
        compound = (NBTTagCompound)com.local();
    }

    @Override
    public void toBytes(ByteBuf buf){
        ByteBufUtils.writeTag(buf, compound);
    }

    @Override
    public void fromBytes(ByteBuf buf){
    	compound = ByteBufUtils.readTag(buf);
    }

}
