package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.MAX_RAIL_TRACK_LENGTH;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RailPlacingUtil {
	
	public static final ConcurrentHashMap<UUID, NewTrack> QUEUE = new ConcurrentHashMap<>();
	public static final ConcurrentHashMap<UUID, UUID> CURRENT = new ConcurrentHashMap<>();
	public static NewTrack CL_CURRENT = null;

	public static void place(World world, EntityPlayer player, ItemStack stack, RailGauge gauge, RailSystem syscap, GridV3D vector){
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
		
		public ArrayList<GridV3D> points = new ArrayList<>();
		public ArrayList<ArrayList<V3D>> preview;
		public RailGauge gauge;
		public Track track;
		public int selected = -1;
		public UUID id;

		public NewTrack(UUID uuid, GridV3D vector, RailGauge gauge){
			points.add(vector);
			this.gauge = gauge;
			id = uuid;
		}

		public void add(GridV3D vector){
			points.add(selected == -1 ? points.size() : ++selected, vector);
			preview = null;
			gentrack();
		}

		public void gentrack(){
			track = points.size() > 1 ? new Track(null, points.toArray(new GridV3D[0]), gauge) : null;
		}

		public void select(EntityPlayer player, GridV3D vector){
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

		public void remove(EntityPlayer player, GridV3D vector){
			int rem = -1;
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					rem = i;
					break;
				}
			}
			if(rem < 0) return;
			if(rem <= selected) selected--;
			if(selected < -1) selected = -1;
			points.remove(rem);
			gentrack();
			preview = null;
			//
			if(points.size() == 0){
				reset();
				return;
			}
			//
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "rail_place_util");
			compound.setInteger("remove", rem);
			compound.setString("subtask", "remove");
			compound.setLong("uuid_l", id.getMostSignificantBits());
			compound.setLong("uuid_m", id.getLeastSignificantBits());
			compound.setTag("vector", vector.write());
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(player.dimension, vector.pos));
		}
		
		public void reset(){
			QUEUE.remove(id);
			CURRENT.entrySet().removeIf(entry -> entry.getValue().equals(id));
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "rail_place_util");
			compound.setString("subtask", "reset");
			compound.setLong("uuid_l", id.getMostSignificantBits());
			compound.setLong("uuid_m", id.getLeastSignificantBits());
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
		}

		public int indexOf(GridV3D vector){
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					return i;
				}
			}
			return -2;
		}

		public void create(EntityPlayer player, GridV3D vector){
			RailSystem sys = SystemManager.get(Systems.RAIL, player.world);
			Junction junc = sys.getJunction(vector, true);
			UUID current = CURRENT.get(player.getGameProfile().getId());
			if(current == null){
				Print.chat(player, "no_queue_entry / 0");
				return;
			}
			NewTrack ntrack = QUEUE.get(current);
			if(ntrack == null){
				Print.chat(player, "no_queue_entry / 1");
				return;
			}
			if(junc == null){
				sys.addJunction(vector);
				junc = sys.getJunction(vector, true);
				if(ntrack.points.size() == 1 || ntrack.allsame()){
					Print.chat(player, "&o> Junction Created.");
					reset();
					return;
				}
				else{
					Print.chat(player, "&o> End Junction Created.");
				}
			}
			if(!junc.tracks.isEmpty() && junc.tracks.size() < 2 && !junc.tracks.get(0).isCompatibleGauge(ntrack.gauge)){
				Print.chat(player, "&9Item/Track Gauge not compatible with the &7Junction's Gauge&9.");
				return;
			}
			if(junc.signal != null){
				Print.chat(player, "&9Please remove the signal first.");
				return;
			}
			if(junc.tracks.size() >= 4){
				Print.chat(player, "&9Junction reached track limit (4)\n&c&oPoint cache reset.");
				ntrack.reset();
				return;
			}
			else{
				Track track = new Track(junc, ntrack.points.toArray(new GridV3D[0]), gauge);
				if(track.length > MAX_RAIL_TRACK_LENGTH){
					Print.chat(player, "&cTrack length exceeds the configured max length.");
					return;
				}
				//track.blockless = DISABLE_RAIL_BLOCKS;
				Junction second = sys.getJunction(track.start);
				if(second == null){
					sys.addJunction(track.start);
					second = sys.getJunction(track.start, true);
					Print.chat(player, "&o> Start Junction Created.");
				}
				if(second != null){
					if(!TrackPlacer.set(player, player, player.world, null, track).place()/*.blocks(!track.blockless)*/.consume().result()) return;
					second.addnew(track);
					junc.addnew(track.createOppositeCopy());
					second.checkTrackSectionConsistency();
					Print.chat(player, "&o> Track Created.");
					ntrack.reset();
				}
				else Print.chat(player, "&cNo Junction at starting point found!");
			}
		}

		private boolean allsame(){
			GridV3D vec = points.get(0);
			for(int i = 1; i < points.size(); i++){
				if(!vec.equals(points.get(i))) return false;
			}
			return true;
		}

		public void genpreview(){
			double angle, half = gauge.width() * 0.03125f;
			preview = new ArrayList<>();
			preview.add(new ArrayList<>());
			preview.add(new ArrayList<>());
			V3D last, vec = track.vecpath[0];
			for(float pass = 0; pass < track.length + 0.125f; pass += 0.125f){
				last = vec;
				vec = track.getVectorPosition0(pass == 0 ? 0.001f : pass, false);
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x) + Static.rad90;
				preview.get(0).add(vec.add(RoadToolItem.grv(angle, new V3D(-half, 0, 0))));
				preview.get(1).add(vec.add(RoadToolItem.grv(angle, new V3D(half, 0, 0))));
			}
		}
		
	}

}
