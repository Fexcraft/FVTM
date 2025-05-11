package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.MAX_RAIL_TRACK_LENGTH;
import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;
import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.grv;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailPlacingUtil {

	public static final ConcurrentHashMap<UUID, NewTrack> QUEUE = new ConcurrentHashMap<>();
	public static final ConcurrentHashMap<UUID, UUID> CURRENT = new ConcurrentHashMap<>();
	public static NewTrack CL_CURRENT = null;

	public static void place(RailSystem system, EntityW pass, RailGauge gauge, QV3D vector){
		UUID trackid = CURRENT.get(pass.getUUID());
		if(trackid == null){
			UUID newid = genId();
			Junction junc = system.getJunction(vector.pos);
			if(junc != null) vector = junc.getPos();
			QUEUE.put(newid, new NewTrack(newid, vector, gauge));
			CURRENT.put(pass.getUUID(), newid);
			//
			TagCW compound = TagCW.create();
			compound.set("subtask", "new");
			compound.set("uuid_l", newid.getMostSignificantBits());
			compound.set("uuid_m", newid.getLeastSignificantBits());
			compound.set("new", true);
			compound.set("gauge", gauge.getIDS());
			vector.write(compound, "vector");
			Packets.sendToAll(PKT_TAG, "rail_place_util", compound);
			//
			FvtmResources.INSTANCE.spawnRailMarker(system.getWorld(), vector, newid);
			return;
		}
		NewTrack track = QUEUE.get(trackid);
		if(track == null) CURRENT.remove(pass.getUUID());
		track.add(vector);
		//
		TagCW compound = TagCW.create();
		compound.set("subtask", "add");
		compound.set("uuid_l", trackid.getMostSignificantBits());
		compound.set("uuid_m", trackid.getLeastSignificantBits());
		vector.write(compound, "vector");
		Packets.sendToAll(PKT_TAG, "rail_place_util", compound);
		//
		FvtmResources.INSTANCE.spawnRailMarker(system.getWorld(), vector, trackid);
	}
	
	private static UUID genId(){
		UUID uuid = UUID.randomUUID();
		while(QUEUE.contains(uuid) || (uuid.getMostSignificantBits() == 0 && uuid.getLeastSignificantBits() == 0)) uuid = UUID.randomUUID();
		return uuid;
	}

	public static class NewTrack {

		public ArrayList<QV3D> points = new ArrayList<>();
		public ArrayList<ArrayList<V3D>> preview;
		public RailGauge gauge;
		public Track track;
		public int selected = -1;
		public UUID id;

		public NewTrack(UUID uuid, QV3D vector, RailGauge gauge){
			points.add(vector);
			this.gauge = gauge;
			id = uuid;
		}

		public void add(QV3D vector){
			points.add(selected == -1 ? points.size() : ++selected, vector);
			preview = null;
			gentrack();
		}

		public void gentrack(){
			track = points.size() > 1 ? new Track(null, points.toArray(new QV3D[0]), gauge) : null;
		}

		public void select(EntityW player, QV3D vector){
			int sel = -1;
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					sel = i;
					break;
				}
			}
			selected = sel;
			TagCW compound = TagCW.create();
			compound.set("selected", selected);
			compound.set("subtask", "selected");
			compound.set("uuid_l", id.getMostSignificantBits());
			compound.set("uuid_m", id.getLeastSignificantBits());
			Packets.sendToAll(PKT_TAG, "rail_place_util", compound);
		}

		public void remove(EntityW player, QV3D vector){
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
			TagCW compound = TagCW.create();
			compound.set("remove", rem);
			compound.set("subtask", "remove");
			compound.set("uuid_l", id.getMostSignificantBits());
			compound.set("uuid_m", id.getLeastSignificantBits());
			vector.write(compound, "vector");
			Packets.sendToAll(PKT_TAG, "rail_place_util", compound);
		}

		public void reset(){
			QUEUE.remove(id);
			CURRENT.entrySet().removeIf(entry -> entry.getValue().equals(id));
			TagCW compound = TagCW.create();
			compound.set("subtask", "reset");
			compound.set("uuid_l", id.getMostSignificantBits());
			compound.set("uuid_m", id.getLeastSignificantBits());
			Packets.sendToAll(PKT_TAG, "rail_place_util", compound);
		}

		public int indexOf(QV3D vector){
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					return i;
				}
			}
			return -2;
		}

		public void create(EntityW player, QV3D vector){
			RailSystem sys = SystemManager.get(Systems.RAIL, player.getWorld());
			Junction junc = sys.getJunction(vector.pos, true);
			UUID current = CURRENT.get(player.getUUID());
			boolean nn = junc != null;
			if(current == null){
				player.send("no_queue_entry / 0");
				return;
			}
			NewTrack ntrack = QUEUE.get(current);
			if(ntrack == null){
				player.send("no_queue_entry / 1");
				return;
			}
			if(junc == null){
				sys.addJunction(vector);
				junc = sys.getJunction(vector.pos, true);
				junc.updateVecPos(vector);
				if(ntrack.points.size() == 1 || ntrack.allsame()){
					player.send("interact.fvtm.rail_marker.junction_created");
					reset();
					return;
				}
				else{
					player.send("interact.fvtm.rail_marker.end_junction_created");
				}
			}
			if(!junc.tracks.isEmpty() && junc.tracks.size() < 2 && !junc.tracks.get(0).isCompatibleGauge(ntrack.gauge)){
				player.send("interact.fvtm.rail_marker.incompatible_gauge");
				return;
			}
			if(junc.signal != null){
				player.send("interact.fvtm.rail_marker.remove_signal");
				return;
			}
			if(junc.tracks.size() >= 4){
				player.send("interact.fvtm.rail_marker.junction_full");
				player.send("interact.fvtm.rail_marker.cache_reset");
				ntrack.reset();
				return;
			}
			else{
				QV3D[] arr = ntrack.points.toArray(new QV3D[0]);
				if(nn) arr[arr.length - 1] = junc.getPos();
				Track track = new Track(junc, arr, gauge);
				if(track.length > MAX_RAIL_TRACK_LENGTH){
					player.send("interact.fvtm.rail_marker.too_long");
					return;
				}
				//track.blockless = DISABLE_RAIL_BLOCKS;
				Junction second = sys.getJunction(track.start.pos);
				if(second == null){
					sys.addJunction(track.start);
					second = sys.getJunction(track.start.pos, true);
					player.send("interact.fvtm.rail_marker.start_junction_created");
				}
				if(second != null){
					//if(!TrackPlacer.set(player, null, track).place()/*.blocks(!track.blockless)*/.consume().result()) return;
					second.addnew(track);
					junc.addnew(track.createOppositeCopy());
					second.checkTrackSectionConsistency();
					player.send("interact.fvtm.rail_marker.track_created");
					ntrack.reset();
				}
				else player.send("interact.fvtm.rail_marker.no_start_junction");
			}
		}

		private boolean allsame(){
			QV3D vec = points.get(0);
			for(int i = 1; i < points.size(); i++){
				if(!vec.equals(points.get(i))) return false;
			}
			return true;
		}

		public void genpreview(){
			double angle, half = gauge.getWidth() * .5f;
			preview = new ArrayList<>();
			preview.add(new ArrayList<>());
			preview.add(new ArrayList<>());
			V3D last, vec = track.vecpath[0];
			for(float pass = 0; pass < track.length + 0.125f; pass += 0.125f){
				last = vec;
				vec = track.getVectorPosition0(pass == 0 ? 0.001f : pass, false);
				angle = (float)Math.atan2(last.x - vec.x, last.z - vec.z);
				preview.get(0).add(vec.add(grv(angle, new V3D(-half, 0, 0))));
				preview.get(1).add(vec.add(grv(angle, new V3D(half, 0, 0))));
			}
		}

	}

}
