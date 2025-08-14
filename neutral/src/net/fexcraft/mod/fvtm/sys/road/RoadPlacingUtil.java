package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool.Road;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;
import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.TAG_KEY;
import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.gen;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadPlacingUtil {
	
	public static final ConcurrentHashMap<UUID, NewRoad> QUEUE = new ConcurrentHashMap<>();
	public static final ConcurrentHashMap<UUID, UUID> CURRENT = new ConcurrentHashMap<>();
	public static NewRoad CL_CURRENT = null;

	public static void place(WorldW world, EntityW pass, TagCW com, QV3D vector){
		UUID roadid = CURRENT.get(pass.getUUID());
		if(!com.has(TAG_KEY)){
			pass.send("interact.fvtm.road_tool.empty");
			return;
		}
		int width = com.getCompound(TAG_KEY).getInteger("Width");
		if(roadid == null){
			UUID newid = genId();
			QUEUE.put(newid, new NewRoad(newid, vector, width));
			CURRENT.put(pass.getUUID(), newid);
			//
			TagCW compound = TagCW.create();
			compound.set("uuid_l", newid.getMostSignificantBits());
			compound.set("uuid_m", newid.getLeastSignificantBits());
			compound.set("width", width);
			vector.write(compound, "vector");
			Packets.sendToAll(PKT_TAG, "road_tool_new", compound);
			//
			FvtmResources.INSTANCE.spawnRoadMarker(world, vector, newid);
			return;
		}
		NewRoad road = QUEUE.get(roadid);
		if(road == null) CURRENT.remove(pass.getUUID());
		road.add(vector, width);
		//
		TagCW compound = TagCW.create();
		compound.set("uuid_l", roadid.getMostSignificantBits());
		compound.set("uuid_m", roadid.getLeastSignificantBits());
		compound.set("width", width);
		vector.write(compound, "vector");
		Packets.sendToAll(PKT_TAG, "road_tool_add", compound);
		//
		FvtmResources.INSTANCE.spawnRoadMarker(world, vector, roadid);
	}
	
	private static UUID genId(){
		UUID uuid = UUID.randomUUID();
		while(QUEUE.contains(uuid) || (uuid.getMostSignificantBits() == 0 && uuid.getLeastSignificantBits() == 0)) uuid = UUID.randomUUID();
		return uuid;
	}

	public static class NewRoad {
		
		public ArrayList<QV3D> points = new ArrayList<>();
		public ArrayList<ArrayList<V3I>> coords;
		public Road road;
		public int selected = -1, width;
		public UUID id;

		public NewRoad(UUID uuid, QV3D vector, int width){
			points.add(vector);
			this.width = width;
			id = uuid;
		}

		public void add(QV3D vector, int width){
			points.add(selected == -1 ? points.size() : ++selected, vector);
			this.width = width;
			coords = null;
			genroad();
		}

		public void genroad(){
			road = points.size() > 1 ? new Road(points.toArray(new QV3D[0])) : null;
		}

		public void select(EntityW pass, QV3D vector){
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
			compound.set("uuid_l", id.getMostSignificantBits());
			compound.set("uuid_m", id.getLeastSignificantBits());
			Packets.sendToAll(PKT_TAG, "road_tool_selected", compound);
		}

		public void remove(EntityW pass, QV3D vector){
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
			genroad();
			coords = null;
			//
			if(points.size() == 0){
				reset();
				return;
			}
			//
			TagCW compound = TagCW.create();
			compound.set("remove", rem);
			compound.set("uuid_l", id.getMostSignificantBits());
			compound.set("uuid_m", id.getLeastSignificantBits());
			vector.write(TagCW.wrap(compound), "vector");
			Packets.sendToAll(PKT_TAG, "road_tool_remove", compound);
		}
		
		public void reset(){
			QUEUE.remove(id);
			CURRENT.entrySet().removeIf(entry -> entry.getValue().equals(id));
			TagCW compound = TagCW.create();
			compound.set("uuid_l", id.getMostSignificantBits());
			compound.set("uuid_m", id.getLeastSignificantBits());
			Packets.sendToAll(PKT_TAG, "road_tool_reset", compound);
		}

		public int indexOf(QV3D vector){
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					return i;
				}
			}
			return -2;
		}

		public void create(EntityW pass, QV3D vector, StackWrapper stack){
			UUID current = CURRENT.get(pass.getUUID());
			if(current == null){
				pass.send("no_queue_entry / 0");
				return;
			}
			NewRoad nroad = QUEUE.get(current);
			if(nroad == null){
				pass.send("no_queue_entry / 1");
				return;
			}
			if(!UniRoadTool.placeRoad(pass, stack, new Road(nroad.points.toArray(new QV3D[0])))) return;
			pass.send("interact.fvtm.road_tool.complete");
			nroad.reset();
		}

		public void genpreview(){
			ArrayList<ArrayList<V3D>> preview = new ArrayList<>();
			coords = new ArrayList<>();
			double angle;
			double passed = 0.001;
			double half = width * 0.5 - 0.5;
			V3D last;
			V3D vec;
			vec = road.vecpath[0];
			while(passed < road.length){
				last = vec;
				vec = road.getVectorPosition(passed, false);
				angle = Math.atan2(last.x - vec.x, last.z - vec.z);
				ArrayList<V3D> list = new ArrayList<>();
				for(int i = 0; i < width; i++){
					list.add(gen(vec, angle, -half + 0.25 + i, 0).vec);
				}
				preview.add(list);
				if(passed < 0.1) passed = 0;
				passed += 0.125;
			}
			coords = new ArrayList<>();
			for(ArrayList<V3D> vecs : preview){
				ArrayList<V3I> list = new ArrayList<>();
				for(V3D v : vecs){
					V3I pos = new V3I(v);
					if(list.contains(pos)) continue;
					list.add(pos);
				}
				coords.add(list);
			}
		}
		
	}

}
