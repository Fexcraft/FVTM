package net.fexcraft.mod.fvtm.gui.tsign;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;

public class TrafficSignEditorContainer extends GenericContainer {
	
	protected GenericGui<TrafficSignEditorContainer> gui;
	protected TrafficSignData data;
	protected TrafficSignEntity entity;
	
	public TrafficSignEditorContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		entity = (TrafficSignEntity)player.world.getEntityByID(x);
		data = player.world.getChunk(entity.chunkCoordX, entity.chunkCoordZ).getCapability(Capabilities.TRAFFIC_SIGNS, null).getSign(entity.getPosition());//, true);
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("signdata")) return;
		data.read(packet.getCompoundTag("signdata"));
		if(side == Side.SERVER){
			//send(Side.CLIENT, packet);
			NBTTagCompound com = packet.copy();
			com.setString("target_listener", "fvtm:utils");
			com.setString("task", "ts_update");
			com.setLong("pos", entity.getPosition().toLong());
			PacketHandler.getInstance().sendToAllTracking(new PacketNBTTagCompound(com), new TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 0));
			player.closeScreen();
		}
	}

	@Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
