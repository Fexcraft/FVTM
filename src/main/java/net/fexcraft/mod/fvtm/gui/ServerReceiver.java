package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.fexcraft.mod.fvtm.util.handler.AttrReqHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ServerReceiver implements IPacketListener<PacketNBTTagCompound> {

	public static ServerReceiver INSTANCE;

	public ServerReceiver(){
		INSTANCE = this;
	}

	@Override
	public String getId(){
		return GuiHandler.LISTENERID;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		World world = objs[0] == null ? (World)objs[1] : player.world;
		switch(task){
			case "update_container_holder":{
				Entity ent = world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null){
					Print.debug("Entity not found. CHP " + packet.nbt.getInteger("entity"));
					return;
				}
				ContainerHolderUtil.Implementation impl = (Implementation)ent.getCapability(Capabilities.CONTAINER, null);
				if(impl == null) Print.debug("Capability is null. CHP " + packet.nbt.getInteger("entity"));
				else impl.sync(false);
				return;
			}
			case "update_region":
				Static.stop();
				return;
			case "open_gui":{
				if(packet.nbt.hasKey("data")){
					GuiHandler.SERVER_GUIDATA_CACHE.put(player.getGameProfile().getId().toString(), packet.nbt.getCompoundTag("data"));
					PacketHandler.getInstance().sendTo(packet, player);
				}
				int gui = packet.nbt.getInteger("gui");
				int[] args = packet.nbt.hasKey("args") ? packet.nbt.getIntArray("args") : new int[3];
				player.openGui(FVTM.getInstance(), gui, player.world, args[0], args[1], args[2]);
				return;
			}
			default:
				return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(compound, player, null);
	}

	public void process(NBTTagCompound compound, EntityPlayer player, World world){
		this.process(new PacketNBTTagCompound(compound), new Object[] { player, world == null ? player.world : world });
	}

}
