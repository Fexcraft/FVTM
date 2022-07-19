package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RailPlacingUtil {
	
	public static final ConcurrentHashMap<UUID, NewTrack> QUEUE = new ConcurrentHashMap<>();
	public static final ConcurrentHashMap<UUID, UUID> CURRENT = new ConcurrentHashMap<>();
	public static NewTrack CL_CURRENT = null;

	public static void place(World world, EntityPlayer player, ItemStack stack, RailGauge gauge, RailSystem syscap, Vec316f vector){
		UUID trackid = CURRENT.get(player.getGameProfile().getId());
		if(trackid == null){
			UUID newid = genId();
			QUEUE.put(newid, new NewTrack(newid, vector, gauge));
			CURRENT.put(player.getGameProfile().getId(), newid);
			//
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "rail_place_util");
			compound.setString("subtask", "new");
			compound.setLong("uuid_l", newid.getMostSignificantBits());
			compound.setLong("uuid_m", newid.getLeastSignificantBits());
			compound.setBoolean("new", true);
			compound.setTag("vector", vector.write());
			compound.setString("gauge", gauge.getRegistryName().toString());
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
			//
			RailMarker marker = new RailMarker(world, newid);
			marker.position = vector;
			marker.setPosition(vector.vector.x, vector.vector.y, vector.vector.z);
			world.spawnEntity(marker);
			return;
		}
		NewTrack track = QUEUE.get(trackid);
		if(track == null) CURRENT.remove(player.getGameProfile().getId());
		track.add(vector);
		//
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", Resources.UTIL_LISTENER);
		compound.setString("task", "rail_place_util");
		compound.setString("subtask", "add");
		compound.setLong("uuid_l", trackid.getMostSignificantBits());
		compound.setLong("uuid_m", trackid.getLeastSignificantBits());
		compound.setTag("vector", vector.write());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(player.dimension, vector.pos));
		//
		RailMarker marker = new RailMarker(world, trackid);
		marker.position = vector;
		marker.setPosition(vector.vector.x, vector.vector.y, vector.vector.z);
		world.spawnEntity(marker);
	}
	
	private static UUID genId(){
		UUID uuid = UUID.randomUUID();
		while(QUEUE.contains(uuid) || (uuid.getMostSignificantBits() == 0 && uuid.getLeastSignificantBits() == 0)) uuid = UUID.randomUUID();
		return uuid;
	}

	public static class NewTrack {
		
		public ArrayList<Vec316f> points = new ArrayList<>();
		public RailGauge gauge;
		public Track track;
		public int selected = -1;
		public UUID id;

		public NewTrack(UUID uuid, Vec316f vector, RailGauge gauge){
			points.add(vector);
			this.gauge = gauge;
			id = uuid;
		}

		public void add(Vec316f vector){
			points.add(selected == -1 ? points.size() : ++selected, vector);
			gentrack();
		}

		public void gentrack(){
			track = new Track(null, points.toArray(new Vec316f[0]), gauge);
		}

		public void select(EntityPlayer player, Vec316f vector){
			int sel = -1;
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					sel = i;
					break;
				}
			}
			selected = sel;
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "rail_place_util");
			compound.setInteger("selected", selected);
			compound.setString("subtask", "selected");
			compound.setLong("uuid_l", id.getMostSignificantBits());
			compound.setLong("uuid_m", id.getLeastSignificantBits());
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(player.dimension, vector.pos));
		}

		public void remove(EntityPlayer player, Vec316f vector){
			int rem = -1;
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					rem = i;
					break;
				}
			}
			if(rem > -1){
				if(rem <= selected) selected--;
				if(selected < -1) selected = -1;
				points.remove(rem);
				gentrack();
			}
			if(points.size() == 0){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("target_listener", Resources.UTIL_LISTENER);
				compound.setString("task", "rail_place_util");
				compound.setString("subtask", "reset");
				compound.setLong("uuid_l", id.getMostSignificantBits());
				compound.setLong("uuid_m", id.getLeastSignificantBits());
				PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
				return;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "rail_place_util");
			compound.setInteger("remove", rem);
			compound.setString("subtask", "remove");
			compound.setLong("uuid_l", id.getMostSignificantBits());
			compound.setLong("uuid_m", id.getLeastSignificantBits());
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(player.dimension, vector.pos));
		}

		public int indexOf(Vec316f vector){
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					return i;
				}
			}
			return -2;
		}
		
	}

}
