package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RecClient implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:wiresys";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayer player = (EntityPlayer)objs[0];
		WireSystem system = SystemManager.get(Systems.WIRE, player.world, WireSystem.class);
		try{
			switch(task){
				case "update_region":{
					system.updateRegion(packet.nbt, null);
					return;
				}
				case "update_relay":{
					BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
					RelayHolder holder = system.getHolder(pos);
					String key = packet.nbt.getString("Key");
					if(holder != null && holder.contains(key)){
						holder.get(key).read(packet.nbt);
					}
					return;
				}
				case "remove_relay":{
					BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
					RelayHolder holder = system.getHolder(pos);
					holder.remove(packet.nbt.getString("key"));
					return;
				}
				case "update_holder":{
					BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
					RelayHolder holder = system.getHolder(pos);
					if(holder != null) holder.read(packet.nbt);
					else{
						WireRegion region = system.getRegions().get(pos, false);
						if(region != null) holder = region.addHolder(pos).read(packet.nbt);
					}
					if(holder.blocktile == null){
						BlockTileEntity tile = (BlockTileEntity)system.getWorld().getTileEntity(holder.pos);
						if(tile != null) holder.setTile(tile);
					}
					return;
				}
				case "rem_holder":{
					system.delHolder(BlockPos.fromLong(packet.nbt.getLong("pos")));
					return;
				}
				case "update_sections":{
					NBTTagList list = (NBTTagList)packet.nbt.getTag("units");
					WireUnit unit;
					NBTTagCompound com;
					for(NBTBase base : list){
						com = (NBTTagCompound)base;
						unit = system.getWireUnits().get(com.getString("unit"));
						if(unit != null){
							unit.setSection(system.getSection(com.getLong("section")));
						}
					}
					Print.debug(list);
					return;
				}
				case "update_unit_section":{
					WireUnit unit = system.getWireUnits().get(packet.nbt.getString("unit"));
					if(unit != null) unit.setSection(system.getSection(packet.nbt.getLong("section")));
					return;
				}
				default: Print.debug(packet.nbt); return;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug(packet.nbt);
			Static.stop();
		}
	}

}
