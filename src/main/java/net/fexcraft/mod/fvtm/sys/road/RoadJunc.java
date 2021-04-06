package net.fexcraft.mod.fvtm.sys.road;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.sys.uni.PathJuncType;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * Generic Road Point / Road Container
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RoadJunc {
	
	public ArrayList<Road> roads = new ArrayList<>();
	protected AxisAlignedBB frustumbb;
	public PathJuncType type;
	//private Signalbox singal;
	private Integer channel;
	private Vec316f vecpos;
	public Region region;
	public RoadSys root;
	
	/** General Constructor */
	public RoadJunc(Region region, Vec316f pos){
		this.region = region; vecpos = pos; root = region.getWorld();
	}
	
	/** Only to used with read() afterwards! */
	public RoadJunc(Region region){
		this.region = region; root = region.getWorld();
	}
	
	public RoadJunc read(NBTTagCompound compound){
		this.vecpos = new Vec316f(compound.getCompoundTag("Pos"));
		int roadam = compound.getInteger("Roads");
		if(roadam > 0){
			for(int i = 0; i < roadam; i++){
				try{ roads.add(new Road(this).read(compound.getCompoundTag("Road" + i))); }
				catch(Exception e){ e.printStackTrace(); }
			}
		} else roads.clear(); frustumbb = null;
		if(!root.getWorld().isRemote) checkRoadSectionConsistency();
		//if(compound.hasKey("SignalBox") signalbox = root.getSignalBox(compound.getLong("SignalBox"));
		channel = compound.hasKey("Channel") ? compound.getInteger("channel") : null;
		if(roads.size() > 2) type = compound.hasKey("Type")? PathJuncType.valueOf(compound.getString("Type")) : PathJuncType.byTracksAmount(size());
		else type = PathJuncType.STRAIGHT;
		return this;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setTag("Pos", vecpos.write());
		for(int i = 0; i < roads.size(); i++){
			compound.setTag("Road" + i, roads.get(i).write(null));
		}
		compound.setInteger("Road", roads.size());
		//if(signalbox != null) compound.getLong("SignalBox", signalbox.getPos().toLong());
		if(channel != null) compound.setInteger("Channel", channel);
		if(roads.size() > 2) compound.setString("Type", type.name());
		return compound;
	}

	public void updateClient(){
		region.updateClient("point", vecpos);
	}
	
	public Vec316f getVec316f(){
		return vecpos;
	}
	
	public Vec3f getVec3f(){
		return vecpos.vector;
	}
	
	@Nullable
	public Road getNext(@Nullable Object entity, PathKey road, PathKey expected){
		if(type == null) type = size() <= 2 ? PathJuncType.STRAIGHT : size() == 3 ? PathJuncType.FORK_2 : PathJuncType.FORK_3;
		switch(type){
			case STRAIGHT:{
				switch(size()){
					case 0: return null;
					case 1: return eqRoad(road, 0) ? null : roads.get(0);
					case 2: return eqRoad(road, 0) ? roads.get(1) : roads.get(0);
				} break;
			}
			case FORK_2:{
				if(eqRoad(road, 0)) return roads.get(expected == null ? Static.random.nextInt(2) + 1 : eqRoad(expected, 1) ? 1 : 2);
				else return roads.get(0);
			}
			case FORK_3:{
				if(eqRoad(road, 0)){
					if(expected == null) return roads.get(Static.random.nextInt(3) + 1);
					for(int i = 1; i <= 3; i++){
						if(eqRoad(expected, i)) return roads.get(i);
					} return roads.get(1);
				} else return roads.get(0);
			}
			case CROSSING:{
				if(eqRoad(road, 0)){ return roads.get(1); }
				if(eqRoad(road, 1)){ return roads.get(0); }
				if(eqRoad(road, 2)){ return roads.get(3); }
				if(eqRoad(road, 3)){ return roads.get(2); }
				break;
			}
			case DOUBLE:{
				if(eqRoad(road, 0) || eqRoad(road, 3)){
					return roads.get(expected == null ? Static.random.nextInt(2) + 1 : eqRoad(expected, 1) ? 1 : 2);
				}
				if(eqRoad(road, 1) || eqRoad(road, 2)){
					return roads.get((expected == null ? Static.random.nextInt(1) == 0 : eqRoad(expected, 0)) ? 0 : 3);
				}
				break;
			}
		}
		return null;
	}

	public final boolean eqRoad(PathKey road, int i){
		return roads.get(i).getId().equals(road);
	}

	public Road getRoad(PathKey key){
		for(Road road : roads) if(road.getId().equals(key)) return road; return null;
	}

	public int size(){
		return roads.size();
	}

	public int getIndex(PathKey key){
		for(int i = 0; i < roads.size(); i++) if(eqRoad(key, i)) return i; return -1;
	}

	public AxisAlignedBB getAABB(){
		if(frustumbb != null) return frustumbb;
		Vec3f min = new Vec3f(), max = new Vec3f(), other;
		for(Road road : roads){
			other = road.start.vector;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
			other = road.end.vector;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
		}
		if(size() == 0){
			min = vecpos.vector.add(-.5f,-.5f,-.5f);
			max = vecpos.vector.add(+.5f,+.5f,+.5f);
		}
		return frustumbb = new AxisAlignedBB(min.x, min.y, min.z, max.x, max.y, max.z);
	}

	public void addnew(Road road){
		roads.add(road); type = PathJuncType.byTracksAmount(size());
		//TODO if(signalbox != null) signalbox = null;
		updateClient(); return;
	}

	public void checkRoadSectionConsistency(){
		// TODO Auto-generated method stub
		
	}

	public void remove(int index, boolean firstcall){
		Road road = roads.remove(index); if(road == null) return;
		//TODO if(signalbox != null) signalbox = null;
		//
		if(!firstcall){
			//TODO road.unit.section().splitAtTrack(road); road.unit.section().remove(road);
		}
		type = PathJuncType.byTracksAmount(size()); this.updateClient();
		//
		if(firstcall){
			RoadJunc point = root.getRoadPoint(road.start.equals(vecpos) ? road.end : road.start);
			if(point != null) point.remove(road.getOppositeId(), false);
			//this.checkTrackSectionConsistency();
		} else this.checkRoadSectionConsistency();
	}

	private void remove(PathKey key, boolean firstcall){
		for(int i = 0; i < roads.size(); i++){
			if(roads.get(i).getId().equals(key)){ remove(i, firstcall); return; }
		} return;
	}

	public void clear(){
		ArrayList<Road> reads = new ArrayList<Road>();
		for(Road road : roads){ reads.add(road); }
		for(Road road : reads) this.remove(road.getId(), true);
		roads.clear(); this.updateClient();
	}

}
