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
public class RoadPoint {
	
	public ArrayList<Road> roads = new ArrayList<>();
	protected AxisAlignedBB frustumbb;
	public PathJuncType type;
	//private Signalbox singal;
	private Integer channel;
	private Vec316f vecpos;
	public Region region;
	public RoadSys root;
	
	/** General Constructor */
	public RoadPoint(Region region, Vec316f pos){
		this.region = region; vecpos = pos; root = region.getWorld();
	}
	
	/** Only to used with read() afterwards! */
	public RoadPoint(Region region){
		this.region = region; root = region.getWorld();
	}
	
	public RoadPoint read(NBTTagCompound compound){
		this.vecpos = new Vec316f(compound.getCompoundTag("Pos"));
		int roadam = compound.getInteger("Roads");
		if(roadam > 0){
			for(int i = 0; i < roadam; i++){
				try{ roads.add(new Road(this).read(compound.getCompoundTag("Road" + i))); }
				catch(Exception e){ e.printStackTrace(); }
			}
		} else roads.clear(); frustumbb = null;
		//TODO if(!root.getWorld().isRemote) checkTrackSectionConsistency();
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
			if(other.xCoord < min.xCoord) min.xCoord = other.xCoord;
			if(other.yCoord < min.yCoord) min.yCoord = other.yCoord;
			if(other.zCoord < min.zCoord) min.zCoord = other.zCoord;
			if(other.xCoord > max.xCoord) max.xCoord = other.xCoord;
			if(other.yCoord > max.yCoord) max.yCoord = other.yCoord;
			if(other.zCoord > max.zCoord) max.zCoord = other.zCoord;
			other = road.end.vector;
			if(other.xCoord < min.xCoord) min.xCoord = other.xCoord;
			if(other.yCoord < min.yCoord) min.yCoord = other.yCoord;
			if(other.zCoord < min.zCoord) min.zCoord = other.zCoord;
			if(other.xCoord > max.xCoord) max.xCoord = other.xCoord;
			if(other.yCoord > max.yCoord) max.yCoord = other.yCoord;
			if(other.zCoord > max.zCoord) max.zCoord = other.zCoord;
		}
		if(size() == 0){
			min = vecpos.vector.addVector(-.5f,-.5f,-.5f);
			max = vecpos.vector.addVector(+.5f,+.5f,+.5f);
		}
		return frustumbb = new AxisAlignedBB(min.xCoord, min.yCoord, min.zCoord, max.xCoord, max.yCoord, max.zCoord);
	}

}
