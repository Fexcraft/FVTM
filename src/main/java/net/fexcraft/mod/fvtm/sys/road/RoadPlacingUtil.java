package net.fexcraft.mod.fvtm.sys.road;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Statics;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem.Road;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RoadPlacingUtil {
	
	public static final ConcurrentHashMap<UUID, NewRoad> QUEUE = new ConcurrentHashMap<>();
	public static final ConcurrentHashMap<UUID, UUID> CURRENT = new ConcurrentHashMap<>();
	public static NewRoad CL_CURRENT = null;

	public static void place(World world, EntityPlayer player, ItemStack stack, Vec316f vector){
		UUID roadid = CURRENT.get(player.getGameProfile().getId());
		int width = stack.getTagCompound().getIntArray("RoadLayers")[0];
		if(roadid == null){
			UUID newid = genId();
			QUEUE.put(newid, new NewRoad(newid, vector, width));
			CURRENT.put(player.getGameProfile().getId(), newid);
			//
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "road_place_util");
			compound.setString("subtask", "new");
			compound.setLong("uuid_l", newid.getMostSignificantBits());
			compound.setLong("uuid_m", newid.getLeastSignificantBits());
			compound.setInteger("width", width);
			compound.setBoolean("new", true);
			compound.setTag("vector", vector.write());
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
			//
			RoadMarker marker = new RoadMarker(world, newid);
			marker.position = vector;
			marker.setPosition(vector.vector.x, vector.vector.y + 1, vector.vector.z);
			world.spawnEntity(marker);
			return;
		}
		NewRoad road = QUEUE.get(roadid);
		if(road == null) CURRENT.remove(player.getGameProfile().getId());
		road.add(vector, width);
		//
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", Resources.UTIL_LISTENER);
		compound.setString("task", "road_place_util");
		compound.setString("subtask", "add");
		compound.setLong("uuid_l", roadid.getMostSignificantBits());
		compound.setLong("uuid_m", roadid.getLeastSignificantBits());
		compound.setInteger("width", width);
		compound.setTag("vector", vector.write());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(player.dimension, vector.pos));
		//
		RoadMarker marker = new RoadMarker(world, roadid);
		marker.position = vector;
		marker.setPosition(vector.vector.x, vector.vector.y + 1, vector.vector.z);
		world.spawnEntity(marker);
	}
	
	private static UUID genId(){
		UUID uuid = UUID.randomUUID();
		while(QUEUE.contains(uuid) || (uuid.getMostSignificantBits() == 0 && uuid.getLeastSignificantBits() == 0)) uuid = UUID.randomUUID();
		return uuid;
	}

	public static class NewRoad {
		
		public ArrayList<Vec316f> points = new ArrayList<>();
		public ArrayList<ArrayList<Vec3f>> preview;
		public Road road;
		public int selected = -1, width;
		public UUID id;

		public NewRoad(UUID uuid, Vec316f vector, int width){
			points.add(vector);
			this.width = width;
			id = uuid;
		}

		public void add(Vec316f vector, int width){
			points.add(selected == -1 ? points.size() : ++selected, vector);
			this.width = width;
			preview = null;
			genroad();
		}

		public void genroad(){
			road = points.size() > 1 ? new Road(points.toArray(new Vec316f[0])) : null;
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
			compound.setString("task", "road_place_util");
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
			if(rem < 0) return;
			if(rem <= selected) selected--;
			if(selected < -1) selected = -1;
			points.remove(rem);
			genroad();
			preview = null;
			//
			if(points.size() == 0){
				reset();
				return;
			}
			//
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", Resources.UTIL_LISTENER);
			compound.setString("task", "road_place_util");
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
			compound.setString("task", "road_place_util");
			compound.setString("subtask", "reset");
			compound.setLong("uuid_l", id.getMostSignificantBits());
			compound.setLong("uuid_m", id.getLeastSignificantBits());
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
		}

		public int indexOf(Vec316f vector){
			for(int i = 0; i < points.size(); i++){
				if(vector.equals(points.get(i))){
					return i;
				}
			}
			return -2;
		}

		public void create(EntityPlayer player, Vec316f vector, ItemStack stack){
			UUID current = CURRENT.get(player.getGameProfile().getId());
			if(current == null){
				Print.chat(player, "no_queue_entry / 0");
				return;
			}
			NewRoad nroad = QUEUE.get(current);
			if(nroad == null){
				Print.chat(player, "no_queue_entry / 1");
				return;
			}
			RoadToolItem tool = (RoadToolItem)stack.getItem();
			if(!tool.placeRoad(player, player.world, stack, vector, new Road(nroad.points.toArray(new Vec316f[0])), player)) return;
			Print.chat(player, "&o> Road Created.");
			nroad.reset();
		}

		public void genpreview(){
			float angle, half = (width * 0.5f);
			preview = new ArrayList<>();
			for(int i = 0; i < width + 1; i++) preview.add(new ArrayList<>());
			Vec3f last, vec = road.vecpath[0];
			for(float pass = 0; pass < road.length + 0.125f; pass += 0.125f){
				last = vec;
				vec = road.getVectorPosition0(pass == 0 ? 0.001f : pass, false);
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x) + Statics.rad90;
				for(int w = 0; w < width + 1; w++){
					preview.get(w).add(vec.add(RoadToolItem.grv(angle, new Vec3f(-half + w, 0, 0))));
				}
			}
		}
		
	}

}
