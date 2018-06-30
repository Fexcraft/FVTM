package net.fexcraft.mod.fmt.various;

import net.fexcraft.mod.fmt.block.EditorTileEntity;
import net.fexcraft.mod.fmt.capabilities.EPDCCU;
import net.fexcraft.mod.fmt.capabilities.EditorPlayerDataContainerCapability;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class GenericReceiver implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fmt:main";
	}
	
	private EditorPlayerDataContainerCapability cap = null;

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		if(!packet.nbt.hasKey("task")){ return; }
		EntityPlayer player = objs.length > 0 && objs[0] instanceof EntityPlayer ? (EntityPlayerSP)objs[0] : Minecraft.getMinecraft().player;
		cap = player.getCapability(EPDCCU.CAPABILITY, null);
		if(cap == null){ return; }
		switch(packet.nbt.getString("task")){
			case "editor_pos_update":{
				boolean bool = packet.nbt.hasKey("reset") && packet.nbt.getBoolean("reset");
				if(bool){
					cap.setEditorTileEntity(null);
				}
				else{
					cap.setEditorTileEntity((EditorTileEntity)player.world.getTileEntity(BlockPos.fromLong(packet.nbt.getLong("pos"))));
				}
				break;
			}
		}
	}
	
}