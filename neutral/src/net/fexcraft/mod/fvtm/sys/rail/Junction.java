package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.sys.event.EventHolder;
import net.fexcraft.mod.fvtm.sys.event.EventListener;
import net.fexcraft.mod.fvtm.sys.event.EventType;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.SysObj;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * <i>Junctions are essential!</i>
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class Junction implements SysObj {

	private QV3D vecpos;
	public ArrayList<Track> tracks;
	public boolean switch0, switch1;
	public RailSystem root;
	public SystemRegion<RailSystem, Junction> region;
	public SignalType sigtype0 = SignalType.NONE;
	public SignalType sigtype1 = SignalType.NONE;
	public boolean sigstate0;
	public boolean sigstate1;
	public JuncType type;
	public String station;
	//
	public EventHolder holder = new EventHolder(this);
	public ArrayList<V3I> entities = new ArrayList<>();
	//
	protected AABB frustumbb;
	//client side
	public V3D signalpos0;
	public V3D signalpos1;
	public double signalrot0;
	public double signalrot1;
	public Double bufferrot;

	/** General Constructor */
	public Junction(SystemRegion<RailSystem, Junction> reg, QV3D pos){
		this(reg);
		vecpos = pos;
	}

	/** Only to be used from RailRegion.class */
	public Junction(SystemRegion<RailSystem, Junction> region){
		this.root = region.system;
		this.region = region;
		tracks = new ArrayList<>();
		switch0 = switch1 = false;
		type = JuncType.STRAIGHT;
	}

	public Junction setRoot(RailSystem data){
		this.root = data;
		return this;
	}

	public void read(TagCW compound){
		this.vecpos = new QV3D(compound, "Pos");
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		//this.crossing = compound.getBoolean("Crossing");
		int trackam = compound.getInteger("Tracks");
		if(trackam > 0){
			if(root.getWorld().isClient()){
				for(Track track : tracks){
					if(track.railmodel != null) track.railmodel.clearGL();
					if(track.restmodel != null) track.restmodel.clearGL();
					track.railmodel = track.restmodel = null;
				}
				signalpos0 = signalpos1 = null;
				bufferrot = null;
			}
			tracks.clear();
			for(int i = 0; i < trackam; i++){
				try{
					tracks.add(new Track(this).read(compound.getCompound("Track" + i)));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else tracks.clear();
		frustumbb = null;
		//TODO see if necessary //if(!root.getWorld().isRemote) checkTrackSectionConsistency();
		if(tracks.size() > 2){
			type = compound.has("Type") ? JuncType.valueOf(compound.getString("Type")) : JuncType.byTracksAmount(size());
			sigtype0 = sigtype1 = SignalType.NONE;
		}
		else{
			type = JuncType.STRAIGHT;
			sigtype0 = SignalType.parse(compound.getString("SignalType0"));
			sigtype1 = SignalType.parse(compound.getString("SignalType1"));
		}
		station = compound.has("Station") ? compound.getString("Station") : null;
		sigstate0 = !sigtype0.none() && compound.getBoolean("Signal0");
		sigstate1 = !sigtype1.none() && compound.getBoolean("Signal1");
		holder.listeners.clear();
		for(EventType type : EventType.JUNCTION_EVENTS){
			if(!compound.has("Ev_" + type.key)) continue;
			TagLW list = compound.getList("Ev_" + type.key);
			if(list.size() > 0){
				holder.listeners.put(type, new ArrayList<>());
			}
			for(TagCW lt : list){
				String[] arg = lt.has("arg") ? new String[lt.getList("arg").size()] : new String[0];
				if(arg.length > 0){
					TagLW ltl = lt.getList("arg");
					for(int i = 0; i < ltl.size(); i++){
						arg[0] = ltl.getString(i);
					}
				}
				holder.listeners.get(type).add(new EventListener(lt.getString("key"), lt.getString("cond"), lt.getString("act"), arg));
			}
			FvtmLogger.marker(list.direct());
		}
		entities.clear();
		if(compound.has("LinkedBlocks")){
			TagLW list = compound.getList("LinkedBlocks").local();
			for(int i = 0; i < list.size(); i++){
				entities.add(new V3I(list.getList(i)));
			}
		}
	}

	@Override
	public void delete(){

	}

	public TagCW write(){
		TagCW compound = TagCW.create();
		for(int i = 0; i < tracks.size(); i++){
			compound.set("Track" + i, tracks.get(i).write(null));
		}
		compound.set("Tracks", tracks.size());
		compound.set("Switch0", switch0);
		compound.set("Switch1", switch1);
		//compound.setBoolean("Crossing", crossing);
		vecpos.write(compound, "Pos");
		if(!sigtype0.none()) compound.set("SignalType0", sigtype0.save());
		if(!sigtype1.none()) compound.set("SignalType1", sigtype1.save());
		if(tracks.size() > 2) compound.set("Type", type.name());
		if(station != null) compound.set("Station", station);
		if(!sigtype0.none()) compound.set("Signal0", sigstate0);
		if(!sigtype1.none()) compound.set("Signal1", sigstate1);
		for(EventType type : EventType.JUNCTION_EVENTS){
			if(!holder.listeners.containsKey(type)) continue;
			TagLW list = TagLW.create();
			for(EventListener lis : holder.listeners.get(type)){
				TagCW lt = TagCW.create();
				lt.set("key", lis.type.key);
				lt.set("cond", lis.cond.key.toString());
				lt.set("act", lis.action.key);
				if(lis.args.length > 0){
					TagLW ltl = TagLW.create();
					for(String arg : lis.args){
						ltl.add(arg);
					}
					lt.set("arg", ltl);
				}
				list.add(lt);
			}
			if(!list.empty()) compound.set("Ev_" + type.key, list);
			FvtmLogger.marker(list.direct());
		}
		if(!entities.isEmpty()){
			TagLW list = TagLW.create();
			for(V3I pos : entities){
				list.add(pos.toLW());
			}
			compound.set("LinkedBlocks", list);
		}
		return compound;
	}

	public QV3D getPos(){
		return vecpos;
	}

	public V3I getV3I(){
		return vecpos.pos;
	}

	public V3D getV3D(){
		return vecpos.vec;
	}

	public void addnew(Track track){
		tracks.add(track);
		type = JuncType.byTracksAmount(size());
		if(hasSignals()) setSignal(SignalType.NONE, null);
		updateClient();
		return;
	}

	public void checkTrackSectionConsistency(){
		if(tracks.size() < 2) return;
		if(tracks.size() == 2 && hasSignals()){
			Section sec0 = tracks.get(0).unit.section(), sec1 = tracks.get(1).unit.section();
			if(sec0.getUID() == sec1.getUID()){
				sec0.splitAtSignal(this);
			}
			return;
		}
		else{
			boolean fuse = false;
			Track zero = tracks.get(0);
			for(int i = 1; i < tracks.size(); i++){
				if(zero.unit.getSectionId() != tracks.get(i).unit.getSectionId()){
					fuse = true;
					break;
				}
			}
			if(fuse) zero.unit.section().fuseAtTrack(zero);
		}
	}

	public void updateClient(){
		root.updateClient("junction", vecpos.pos);
	}

	public void remove(int index, boolean firstcall){
		Track track = tracks.remove(index);
		if(track == null) return;
		if(hasSignals()) setSignal(SignalType.NONE, null);
		//
		if(!firstcall){
			track.unit.section().splitAtTrack(track);
			track.unit.section().remove(track);
		}
		type = JuncType.byTracksAmount(size());
		this.updateClient();
		//
		if(firstcall){
			Junction junk = root.getJunction(track.start.equals(vecpos) ? track.end.pos : track.start.pos);
			if(junk != null) junk.remove(track.getOppositeId(), false);
			//this.checkTrackSectionConsistency();
		}
		else this.checkTrackSectionConsistency();
	}

	private void remove(PathKey key, boolean firstcall){
		for(int i = 0; i < tracks.size(); i++){
			if(tracks.get(i).getId().equals(key)){
				remove(i, firstcall);
				return;
			}
		}
		return;
	}

	public void clear(){
		ArrayList<Track> trecks = new ArrayList<Track>();
		for(Track track : tracks){
			trecks.add(track);
		}
		for(Track track : trecks) this.remove(track.getId(), true);
		tracks.clear();
		this.updateClient();
	}

	public Track getNext(RailEntity entity, PathKey track, boolean applystate){
		if(type == null)
			type = size() <= 2 ? JuncType.STRAIGHT : size() == 3 ? JuncType.FORK_2 : JuncType.CROSSING;
		if(entity != null && applystate){
			holder.run(EventType.JUNC_SWITCH, entity.vehicle, null, track, getIndex(track));
		}
		switch(type){
			case STRAIGHT:{
				switch(size()){
					case 0:
						return null;
					case 1:
						return eqTrack(track, 0) ? null : tracks.get(0);
					case 2:
						return eqTrack(track, 0) ? tracks.get(1) : tracks.get(0);
				}
				break;
			}
			case FORK_2:{
				if(eqTrack(track, 0)) return tracks.get(switch0 ? 1 : 2);
				else{
					if(applystate){
						boolean bool = eqTrack(track, 1);
						if(switch0 != bool){
							switch0 = bool;
							root.updateClient("junction_state", vecpos.pos);
							updateLinkedTileEntities(false);
						}
					}
					return tracks.get(0);
				}
			}
			case FORK_3:{
				if(eqTrack(track, 0)) return tracks.get(switch0 ? 1 : switch1 ? 3 : 2);
				else{
					if(applystate){
						boolean bool0 = eqTrack(track, 1), bool1 = eqTrack(track, 2);
						if(bool0 && !switch0){
							switch0 = true;
							switch1 = false;
							root.updateClient("junction_state", vecpos.pos);
							updateLinkedTileEntities(false);
						}
						else if(bool1 && (switch0 || switch1)){
							switch0 = false;
							switch1 = false;
							root.updateClient("junction_state", vecpos.pos);
							updateLinkedTileEntities(false);
						}
						else if(!bool1 && !switch1){
							switch0 = false;
							switch1 = true;
							root.updateClient("junction_state", vecpos.pos);
							updateLinkedTileEntities(false);
						}
					}
					return tracks.get(0);
				}
			}
			case CROSSING:{
				if(eqTrack(track, 0)){
					return tracks.get(1);
				}
				if(eqTrack(track, 1)){
					return tracks.get(0);
				}
				if(eqTrack(track, 2)){
					return tracks.get(3);
				}
				if(eqTrack(track, 3)){
					return tracks.get(2);
				}
				break;
			}
			case DOUBLE:{
				if(eqTrack(track, 0)){
					if(applystate && !switch1){
						switch1 = true;
						root.updateClient("junction_state", vecpos.pos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch0 ? 1 : 2);
				}
				if(eqTrack(track, 1)){
					if(applystate && !switch0){
						switch0 = true;
						root.updateClient("junction_state", vecpos.pos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 2)){
					if(applystate && switch0){
						switch0 = false;
						root.updateClient("junction_state", vecpos.pos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 3)){
					if(applystate && switch1){
						switch1 = false;
						root.updateClient("junction_state", vecpos.pos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch0 ? 1 : 2);
				}
				break;
			}
		}
		return null;
	}

	public final boolean eqTrack(PathKey track, int i){
		return tracks.get(i).getId().equals(track);
	}

	public boolean allowsSpawningOn(){
		return true;
	}

	public Track getTrack(PathKey key){
		for(Track track : tracks) if(track.getId().equals(key)) return track;
		return null;
	}

	public int size(){
		return tracks.size();
	}

	//private byte checktimer = 0;

	@Override
	public void update(){
		if(this.isDecorational()) return;
		boolean oldsig0 = sigstate0, oldsig1 = sigstate1;
		if(sigtype1.auto()){
			sigstate1 = tracks.get(0).unit.section().isFree((Compound)null);
		}
		if(sigtype0.auto()){
			sigstate0 = tracks.get(1).unit.section().isFree((Compound)null);
		}
		if(oldsig0 != sigstate0 || oldsig1 != sigstate1){
			root.updateClient("junction_signal_state", vecpos.pos);
			updateLinkedTileEntities(true);
		}
		/*if(checktimer == 0){
			// junction switch entities been updated here,
			// right now there's nothing to update here though
			checktimer = 5;
		}
		checktimer--;*/
	}

	private boolean isDecorational(){
		return tracks.size() == 0 || tracks.get(0).gauge.getWidth() < 0;
	}

	public void pollSignal(RailEntity ent, PathKey key){
		if(sigtype0.none() && sigtype1.none()) return;
		boolean oldsig0 = sigstate0, oldsig1 = sigstate1;
		if(eqTrack(key, 0)){//forward
			if(sigtype1.auto()){
				sigstate1 = tracks.get(0).unit.section().isFree(ent);
			}
			else if(sigtype1.any()){
				holder.run(EventType.JUNC_SIGNAL, ent.vehicle, (Passenger)ent.vehicle.driver(), this, EntryDirection.FORWARD);
			}
		}
		else{
			if(sigtype0.auto()){
				sigstate0 = tracks.get(1).unit.section().isFree(ent);
			}
			else if(sigtype0.any()){
				holder.run(EventType.JUNC_SIGNAL, ent.vehicle, (Passenger)ent.vehicle.driver(), this, EntryDirection.BACKWARD);
			}
		}
		//
		if(oldsig0 != sigstate0 || oldsig1 != sigstate1){
			root.updateClient("junction_signal_state", vecpos.pos);
			updateLinkedTileEntities(true);
		}
	}

	@SuppressWarnings("unused")
	private boolean isInPlayerRange(){
		for(EntityW pl : root.getWorld().getPlayers()){
			if(vecpos.vec.dis(pl.getPos()) < 1024) return true;
		}
		return false;
	}

	public boolean onSwitchInteract(EntityW player, Object tile, boolean left){
		if(type == JuncType.STRAIGHT){
			player.send("&cThis Junction has only 2 tracks! It cannot be switched.");
			return true;
		}
		if(type.isCrossing()){
			player.send("&cThis Junction is a Crossing. It cannot be switched!");
			return true;
		}
		if(type.isSwitch()){
			if(type == JuncType.FORK_2){
				switch0 = !switch0;
				player.bar("&aChanged Junction State. [" + (switch0 ? 0 : 1) + "]");
			}
			else{
				if(switch1){
					switch1 = false;
					switch0 = true;
				}
				else if(switch0){
					switch1 = false;
					switch0 = false;
				}
				else if(!switch1){
					switch0 = false;
					switch1 = true;
				}
				player.bar("&aChanged Junction State. [" + (switch0 ? 0 : switch1 ? 2 : 1) + "]");
			}
		}
		if(type.isDouble()){
			if(left) switch1 = !switch1;
			else switch0 = !switch0;
			player.bar("&aChanged Junction State. [" + (switch0 ? 0 : 1) + "-" + (switch1 ? 0 : 1) + "]");
		}
		root.updateClient("junction_state", vecpos.pos);
		updateLinkedTileEntities(false);
		return true;
	}

	private void updateLinkedTileEntities(boolean signal){
		entities.removeIf(pos -> {
			WorldW world = root.getWorld();
			if(!world.isPositionLoaded(pos)) return false;
			/*TileEntity tile = world.getTileEntity(pos);
			if(tile instanceof JunctionTrackingTileEntity){
				JunctionTrackingTileEntity ent = (JunctionTrackingTileEntity)tile;
				if(ent.getJuncPos() == null || !ent.getJuncPos().equals(this.vecpos)) return true;
				if(signal) ent.updateSignalState();
				else ent.updateSwitchState();
			}
			else return true;*///TODO
			return false;
		});
	}

	public void unlinkLinkedTileEntities(){
		for(V3I pos : entities){
			WorldW world = root.getWorld();
			if(!world.isPositionLoaded(pos)) continue;
			/*TileEntity tile = world.getTileEntity(pos);
			if(tile instanceof JunctionTrackingTileEntity){
				JunctionTrackingTileEntity ent = (JunctionTrackingTileEntity)tile;
				if(!ent.getJuncPos().equals(this.vecpos)) continue;
				ent.setJunction(null);
			}*///TODO
		}
	}

	public void addLinkedTileEntity(V3I pos){
		if(!entities.contains(pos)) entities.add(pos);
	}

	public int getIndex(PathKey key){
		for(int i = 0; i < tracks.size(); i++) if(eqTrack(key, i)) return i;
		return -1;
	}

	public AABB getAABB(){
		if(frustumbb != null) return frustumbb;
		V3D min = new V3D(), max = new V3D(), other;
		for(Track track : tracks){
			other = track.start.vec;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
			other = track.end.vec;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
		}
		if(size() == 0){
			min = vecpos.vec.add(-.5f, -.5f, -.5f);
			max = vecpos.vec.add(+.5f, +.5f, +.5f);
		}
		return frustumbb = AABB.create(min.x, min.y, min.z, max.x, max.y, max.z);
	}

	public void setSignal(SignalType signal, Boolean snd){
		if(tracks.size() > 2){
			signal = SignalType.NONE;
			snd = null;
		}
		boolean had = sigtype0.any() || sigtype1.any();
		if(snd == null || !snd){
			sigtype0 = signal;
		}
		if(snd == null || snd){
			sigtype1 = signal;
		}
		boolean has = sigtype0.any() || sigtype1.any();
		if(had && !has) tracks.get(0).unit.section().fuseAtTrack(tracks.get(0));
		else if(!had && has) tracks.get(0).unit.section().splitAtTrack(tracks.get(0));
		root.updateClient("junction_signal", vecpos.pos);
	}

	public void sendSigState(){
		root.updateClient("junction_signal_state", vecpos.pos);
	}

	public boolean getSignalState(EntryDirection dir){
		return dir.isForward() ? sigtype1.none() || sigstate1 : sigtype0.none() || sigstate0;
	}

	public boolean hasSignal(PathKey track){
		return eqTrack(track, 0) ? !sigtype1.none() : !sigtype0.none();
	}

	public boolean hasSignals(){
		return !sigtype0.none() || !sigtype1.none();
	}

	public boolean getSignalState(PathKey track){
		return getSignalState(eqTrack(track, 0) ? EntryDirection.FORWARD : EntryDirection.BACKWARD);
	}

	@Override
	public String toString(){
		return "Junction{ " + vecpos + ", " + tracks.size() + ", " + sigtype0 + "/" + sigtype1 + " }";
	}

	public String posString(){
		return vecpos.pos.x + ", " + vecpos.pos.y + ", " + vecpos.pos.z;
	}

	public Junction updateVecPos(QV3D vector){
		vecpos = vector;
		return this;
	}

	public boolean full(){
		return tracks.size() >= 4;
	}

}
