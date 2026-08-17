package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.MAX_RAIL_TRACK_LENGTH;
import static net.fexcraft.mod.fvtm.Config.infoIfNoPerm;
import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;
import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.grv;
import static net.fexcraft.mod.uni.ui.ContainerInterface.SEND_TO_SERVER;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.ui.rail.RailPresetEditorCon;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.uni.UniPerm;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailPlacingUtil {

	public static final ConcurrentHashMap<UUID, NewTrack> QUEUE = new ConcurrentHashMap<>();
	public static final ConcurrentHashMap<UUID, UUID> CURRENT = new ConcurrentHashMap<>();
	public static NewTrack CL_CURRENT = null;

	public static void place(RailSystem system, EntityW pass, StackWrapper stack, RailGauge gauge, QV3D vector){
		if(infoIfNoPerm(pass, vector.pos)) return;
		if(stack != null){
			if(pass.isShiftDown()){
				pass.openUI(UIKeys.RAIL_PRESET, 0, 0, 0);
				return;
			}
			if(stack.directTag().getBoolean("fvtm:preset_mode")){
				placePreset(system, pass, stack, gauge, vector);
				return;
			}
		}
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
			FvtmResources.INSTANCE.spawnRailMarker(pass.getWorld(), vector, newid);
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
		FvtmResources.INSTANCE.spawnRailMarker(pass.getWorld(), vector, trackid);
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

		public NewTrack(EntityW player, RailGauge.Preset preset, QV3D vector){
			double deg = preset.rot == 4 ? 90 : preset.rot == 8 ? 45 : 22.5;
			deg = Math.floor(player.getYaw() / deg + 0.5) * deg;
			for(QV3D vec : preset.path){
				points.add(new QV3D(vector.vec.add(VecUtil.rotByDeg(deg, vec.vec))));
			}
			gauge = preset.gauge;
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
			if(infoIfNoPerm(player, vector.pos)) return;
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
			HashMap<RailGauge.UseMat, int[]> needs = new HashMap<>();
			HashMap<String, List<StackWrapper>> tags = fillTags(needs);
			if(!player.isCreative()){
				List<StackWrapper> stacks = player.copyInventory();
				if(fillNeeds(player, tags, needs)) return;
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
			if(junc.tracks.size() == 1 && !junc.tracks.get(0).isCompatibleGauge(ntrack.gauge)){
				player.send("interact.fvtm.rail_marker.incompatible_gauge");
				return;
			}
			if(junc.hasSignals()){
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
				V3I mut = new V3I();
				for(float f = 0; f < track.length; f += 0.5f){
					V3D vec = track.getVectorPosition(f, false);
					if(!UniPerm.can_place(player, mut.set((int)vec.x, (int)vec.y, (int)vec.z))){
						player.send("interact.fvtm.rail_marker.no_perm_on_pos", mut.toString());
						return;
					}
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
					if(second.tracks.size() == 1 && !second.tracks.get(0).isCompatibleGauge(ntrack.gauge)){
						player.send("interact.fvtm.rail_marker.incompatible_gauge");
						return;
					}
					if(second.hasSignals()){
						player.send("interact.fvtm.rail_marker.remove_signal");
						return;
					}
					if(second.tracks.size() >= 4){
						player.send("interact.fvtm.rail_marker.junction_full");
						player.send("interact.fvtm.rail_marker.cache_reset");
						ntrack.reset();
						return;
					}
					second.addnew(track);
					junc.addnew(track.createOppositeCopy());
					second.checkTrackSectionConsistency();
					player.send("interact.fvtm.rail_marker.track_created");
					ntrack.reset();
					//
					consume(player, tags, needs);
					if(player.isShiftDown()){
						place(sys, player, null, gauge, vector);
					}
				}
				else player.send("interact.fvtm.rail_marker.no_start_junction");
			}
		}

		public static void fillFound(int[] arr, int idx, StackWrapper stack){
			int need = arr[0] - arr[idx];
			if(need <= 0) return;
			if(need > stack.count()){
				arr[idx] += stack.count();
				stack.count(0);
			}
			else{
				arr[idx] += need;
				stack.decr(need);
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

		public boolean fillNeeds(EntityW player, HashMap<String, List<StackWrapper>> tags, HashMap<RailGauge.UseMat, int[]> needs){
			List<StackWrapper> stacks = player.copyInventory();
			boolean missing = false;
			for(Map.Entry<RailGauge.UseMat, int[]> entry : needs.entrySet()){
				if(entry.getKey().tag){
					List<StackWrapper> tag = tags.get(entry.getKey().id);
					for(StackWrapper stack : stacks){
						if(stack.empty()) continue;
						for(StackWrapper stag : tag){
							if(stack.getID().equals(stag.getID())){
								fillFound(entry.getValue(), 1, stack);
								break;
							}
						}
					}
				}
				else{
					for(StackWrapper stack : stacks){
						if(stack.empty()) continue;
						if(stack.getID().equals(entry.getKey().id)){
							fillFound(entry.getValue(), 1, stack);
						}
					}
				}
				if(entry.getValue()[0] > entry.getValue()[1]) missing = true;
			}
			if(missing){
				player.send("interact.fvtm.rail_marker.missing_materials");
				for(Map.Entry<RailGauge.UseMat, int[]> entry : needs.entrySet()){
					if(entry.getKey().tag){
						StackWrapper stack = tags.get(entry.getKey().id).get(0);
						player.send("interact.fvtm.rail_marker.material_tag_entry", stack.getName(), entry.getKey().id, entry.getValue()[1], entry.getValue()[0]);
					}
					else{
						StackWrapper stack = UniStack.createStack(FvtmRegistry.getItem(entry.getKey().id));
						player.send("interact.fvtm.rail_marker.material_entry", stack.getName(), entry.getValue()[1], entry.getValue()[0]);
					}
				}
				return true;
			}
			return false;
		}

		public void consume(EntityW player, HashMap<String, List<StackWrapper>> tags, HashMap<RailGauge.UseMat,int[]> needs){
			StackWrapper stack;
			for(Map.Entry<RailGauge.UseMat, int[]> entry : needs.entrySet()){
				if(entry.getKey().tag){
					List<StackWrapper> tag = tags.get(entry.getKey().id);
					for(int i = 0; i < player.getInventorySize(); i++){
						stack = player.getStackAt(i);
						if(stack.empty()) continue;
						for(StackWrapper stag : tag){
							if(stack.getID().equals(stag.getID())){
								fillFound(entry.getValue(), 2, stack);
								break;
							}
						}
					}
				}
				else{
					for(int i = 0; i < player.getInventorySize(); i++){
						stack = player.getStackAt(i);
						if(stack.empty()) continue;
						if(stack.getID().equals(entry.getKey().id)){
							fillFound(entry.getValue(), 2, stack);
						}
					}
				}
			}
		}

		public HashMap<String, List<StackWrapper>> fillTags(HashMap<RailGauge.UseMat, int[]> needs){
			HashMap<String, List<StackWrapper>> tags = new HashMap<>();
			for(RailGauge.UseMat mat : gauge.getMaterials()){
				if(mat.tag){
					List<StackWrapper> tag = UniStack.getTagAsList(mat.id);
					if(tag.isEmpty()) continue;
					tags.put(mat.id, tag);
				}
				double v = mat.amount * track.length;
				int n = (int)v + ((v % 1 > 0) ? 1 : 0);
				needs.put(mat, new int[]{ n, 0, 0 });
			}
			return tags;
		}

	}

	private static void placePreset(RailSystem system, EntityW player, StackWrapper is, RailGauge gauge, QV3D vector){
		if(infoIfNoPerm(player, vector.pos)) return;
		if(!is.hasTag() || !is.directTag().getBoolean("fvtm:preset_mode")){
			player.send("error, no preset selected");
			return;
		}
		RailSystem sys = SystemManager.get(Systems.RAIL, player.getWorld());
		Junction j_start = sys.getJunction(vector.pos, true);
		RailGauge.Preset preset = RailGauge.getPreset(is.directTag().getString("fvtm:rail_preset"));
		if(preset == null){
			player.send("error, preset not found");
			return;
		}
		boolean nn = j_start != null;
		if(nn) vector = j_start.getPos();
		NewTrack ntrack = new NewTrack(player, preset, vector);
		ntrack.gentrack();
		HashMap<RailGauge.UseMat, int[]> needs = new HashMap<>();
		HashMap<String, List<StackWrapper>> tags = ntrack.fillTags(needs);
		if(!player.isCreative()){
			if(ntrack.fillNeeds(player, tags, needs)) return;
		}
		if(!nn){
			sys.addJunction(vector);
			j_start = sys.getJunction(vector.pos, true);
			j_start.updateVecPos(vector);
			player.send("interact.fvtm.rail_marker.start_junction_created");
		}
		if(j_start.tracks.size() == 1 && !j_start.tracks.get(0).isCompatibleGauge(ntrack.gauge)){
			player.send("interact.fvtm.rail_marker.incompatible_gauge");
			return;
		}
		if(j_start.hasSignals()){
			player.send("interact.fvtm.rail_marker.remove_signal");
			return;
		}
		if(j_start.tracks.size() >= 4){
			player.send("interact.fvtm.rail_marker.junction_full");
		}
		else{
			QV3D[] arr = ntrack.points.toArray(new QV3D[0]);
			if(nn) arr[0] = j_start.getPos();
			Track track = new Track(j_start, arr, gauge);
			if(track.length > MAX_RAIL_TRACK_LENGTH){
				player.send("interact.fvtm.rail_marker.too_long");
				return;
			}
			V3I mut = new V3I();
			for(float f = 0; f < track.length; f += 0.5f){
				V3D vec = track.getVectorPosition(f, false);
				if(!UniPerm.can_place(player, mut.set((int)vec.x, (int)vec.y, (int)vec.z))){
					player.send("interact.fvtm.rail_marker.no_perm_on_pos", mut.toString());
					return;
				}
			}
			Junction j_end = sys.getJunction(track.end.pos);
			if(j_end == null){
				sys.addJunction(track.end);
				j_end = sys.getJunction(track.end.pos, true);
				player.send("interact.fvtm.rail_marker.end_junction_created");
			}
			if(j_end != null){
				if(j_end.tracks.size() == 1 && !j_end.tracks.get(0).isCompatibleGauge(ntrack.gauge)){
					player.send("interact.fvtm.rail_marker.incompatible_gauge");
					return;
				}
				if(j_end.hasSignals()){
					player.send("interact.fvtm.rail_marker.remove_signal");
					return;
				}
				if(j_end.tracks.size() >= 4){
					player.send("interact.fvtm.rail_marker.junction_full");
					return;
				}
				j_start.addnew(track);
				j_end.addnew(track.createOppositeCopy());
				j_start.checkTrackSectionConsistency();
				player.send("interact.fvtm.rail_marker.track_created");
				//
				ntrack.consume(player, tags, needs);
			}
			else player.send("interact.fvtm.rail_marker.no_start_junction");
		}
	}

	public static void createPreset(RailPresetEditorCon menu){
		NewTrack track = CL_CURRENT;
		if(track == null){
			menu.player.entity.send("error.no_track");
			return;
		}
		if(track.points.size() < 2){
			menu.player.entity.send("error.less_than_two_points");
			return;
		}
		ArrayList<V3D> points = new ArrayList<>();
		V3D start = track.points.get(0).vec;
		points.add(new V3D());
		for(int i = 1; i < track.points.size(); i++){
			points.add(track.points.get(i).vec.sub(start));
		}
		RailGauge.Preset preset = new RailGauge.Preset();
		preset.path = new QV3D[points.size()];
		for(int i = 0; i < points.size(); i++){
			preset.path[i] = new QV3D(points.get(i));
		}
		preset.name = "preset_" + UUID.randomUUID().toString().substring(0, 7);
		preset.rot = 4;
		preset.gauge = track.gauge;
		RailGauge.PRESETS.add(preset);
		TagCW com = TagCW.create();
		com.set("task", "reset");
		SEND_TO_SERVER.accept(com);
	}

}
