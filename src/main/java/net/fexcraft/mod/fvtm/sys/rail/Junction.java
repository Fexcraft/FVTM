package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.fexcraft.mod.fvtm.sys.rail.cmds.JunctionCommand;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Junction {
	
	private Vec316f vecpos;
	public ArrayList<Track> tracks;
	public boolean switch0, switch1;
	public RailData root;
	public RailRegion region;
	public SignalType signal;
	public JunctionType type;
	public String station;
	//
	private Vec3f switchlocation;
	public JunctionSwitchEntity entity;
	public EnumFacing entityFacing;
	private ArrayList<JunctionCommand> fortrains = new ArrayList<>();
	private ArrayList<JunctionCommand> forswitch = new ArrayList<>();
	
	/** General Constructor */
	public Junction(RailRegion region, Vec316f pos){
		vecpos = pos; tracks = new ArrayList<Track>(); this.root = region.getWorld();
		this.region = region; this.switch0 = this.switch1 = false; type = JunctionType.STRAIGHT;
	}
	
	/** Only to be used from RailRegion.class */
	protected Junction(RailRegion region){
		this.root = region.getWorld(); this.region = region; tracks = new ArrayList<>();
	}

	public Junction setRoot(RailData data){
		this.root = data; return this;
	}
	
	public Junction read(NBTTagCompound compound){
		this.vecpos = new Vec316f(compound.getCompoundTag("Pos"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		//this.crossing = compound.getBoolean("Crossing");
		int trackam = compound.getInteger("Tracks");
		if(trackam > 0){
			if(trackam != tracks.size()){
				tracks.clear();//TODO dispose of the models properly
				for(int i = 0; i < trackam; i++){
					try{ tracks.add(new Track(this).read(compound.getCompoundTag("Track" + i))); }
					catch(Exception e){ e.printStackTrace(); }
				}
			}
			else{
				for(int i = 0; i < trackam; i++){
					tracks.get(i).read(compound.getCompoundTag("Track" + i));
					if(Static.side().isClient()){//TODO dispose of the models properly
						tracks.get(i).railmodel = tracks.get(i).restmodel = null;
					}
				}
			}
		}
		if(compound.hasKey("SignalType")) signal = SignalType.valueOf(compound.getString("SignalType"));
		if(tracks.size() > 2) type = compound.hasKey("Type")? JunctionType.valueOf(compound.getString("Type")) : JunctionType.byTracksAmount(size());
		else type = JunctionType.STRAIGHT;
		if(compound.hasKey("SwitchPos")) this.switchlocation = DataUtil.readVec3f(compound.getTag("SwitchPos"));
		else this.switchlocation = null;
		if(compound.hasKey("SwitchFacing")) this.entityFacing = EnumFacing.getFront(compound.getInteger("SwitchFacing"));
		if(switchlocation != null && entityFacing == null) entityFacing = EnumFacing.NORTH;
		if(entity != null){
			if(switchlocation != null) entity.setPosition(switchlocation.xCoord, switchlocation.yCoord, switchlocation.zCoord);
			else entity.setDead();
		}
		station = compound.hasKey("Station") ? compound.getString("Station") : null;
		return this;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(int i = 0; i < tracks.size(); i++){
			compound.setTag("Track" + i, tracks.get(i).write(null));
		}
		compound.setInteger("Tracks", tracks.size());
		compound.setBoolean("Switch0", switch0);
		compound.setBoolean("Switch1", switch1);
		//compound.setBoolean("Crossing", crossing);
		compound.setTag("Pos", vecpos.write());
		if(signal != null) compound.setString("SignalType", signal.name());
		if(tracks.size() > 2) compound.setString("Type", type.name());
		if(switchlocation != null){
			compound.setTag("SwitchPos", DataUtil.writeVec3f(switchlocation));
			compound.setInteger("SwitchFacing", entityFacing == null ? EnumFacing.NORTH.getIndex() : entityFacing.getIndex());
		}
		if(station != null) compound.setString("Station", station);
		return compound;
	}
	
	public Vec316f getVec316f(){
		return vecpos;
	}
	
	public Vec3f getVec3f(){
		return vecpos.vector;
	}

	public void addnew(Track track){
		tracks.add(track); type = JunctionType.byTracksAmount(size()); updateClient();
	}

	public void updateClient(){
		root.getRegions().get(RailData.getRegionXZ(vecpos)).updateClient("junction", vecpos);
	}

	public void remove(TrackKey trackid, boolean firstcall){
		Track track = null;
		for(int i = 0; i < tracks.size(); i++){
			if(tracks.get(i).getId().equals(trackid)){ track = tracks.remove(i); break; }
		}
		if(track == null) return;
		if(firstcall){
			Junction junk = root.getJunction(track.start.equals(vecpos) ? track.end : track.start);
			if(junk != null) junk.remove(track.getOppositeId(), false);
		}
		type = JunctionType.byTracksAmount(size()); this.updateClient();
	}

	public void remove(int index, boolean firstcall){
		Track track = tracks.remove(index); Print.debug(index, track) ;if(track == null) return;
		if(firstcall){
			Junction junk = root.getJunction(track.start.equals(vecpos) ? track.end : track.start);
			if(junk != null) junk.remove(track.getOppositeId(), false);
		}
		type = JunctionType.byTracksAmount(size()); this.updateClient();
	}

	public void clear(){
		ArrayList<Track> trecks = new ArrayList<Track>();
		for(Track track : tracks){ trecks.add(track); }
		for(Track track : trecks) this.remove(track.getId(), true);
		tracks.clear(); this.updateClient();
	}
	
	@Nullable
	public Track getNext(@Nullable RailEntity entity, TrackKey track, boolean applystate){
		if(entity != null && fortrains.size() > 0){
			Track track0 = getNext0(entity, track, applystate);
			for(JunctionCommand cmd : fortrains){
				if(cmd.isTarget(entity)) entity.commands.add(cmd.copy());
			} return track0;
			
		} else return getNext0(entity, track, applystate);
	}
	
	@Nullable
	public Track getNext0(@Nullable RailEntity entity, TrackKey track, boolean applystate){
		if(type == null) type = size() <= 2 ? JunctionType.STRAIGHT : size() == 3 ? JunctionType.FORK_2 : JunctionType.CROSSING;
		if(entity != null){
			for(JunctionCommand cmd : forswitch) cmd.processSwitch(entity, this, track, getIndex(track), applystate);
		}
		switch(type){
			case STRAIGHT:{
				switch(size()){
					case 0: return null;
					case 1: return eqTrack(track, 0) ? null : tracks.get(0);
					case 2: return eqTrack(track, 0) ? tracks.get(1) : tracks.get(0);
				} break;
			}
			case FORK_2:{
				if(eqTrack(track, 0)) return tracks.get(switch0 ? 1 : 2);
				else{
					if(applystate){
						boolean bool = eqTrack(track, 1);
						if(switch0 != bool){ switch0 = bool;
							region.updateClient("junction_state", vecpos);
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
							switch0 = true; switch1 = false; region.updateClient("junction_state", vecpos);
						}
						else if(bool1 && (switch0 || switch1)){
							switch0 = false; switch1 = false; region.updateClient("junction_state", vecpos);
						}
						else if(!bool1 && !switch1){
							switch0 = false; switch1 = true; region.updateClient("junction_state", vecpos);
						}
					}
					return tracks.get(0);
				}
			}
			case CROSSING:{
				if(eqTrack(track, 0)){ return tracks.get(1); }
				if(eqTrack(track, 1)){ return tracks.get(0); }
				if(eqTrack(track, 2)){ return tracks.get(3); }
				if(eqTrack(track, 3)){ return tracks.get(2); }
				break;
			}
			case DOUBLE:{
				if(eqTrack(track, 0)){
					if(applystate && !switch1){ switch1 = true; region.updateClient("junction_state", vecpos); }
					return tracks.get(switch0 ? 1 : 2);
				}
				if(eqTrack(track, 1)){
					if(applystate && !switch0){ switch0 = true; region.updateClient("junction_state", vecpos); }
					return tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 2)){
					if(applystate && switch0){ switch0 = false; region.updateClient("junction_state", vecpos); }
					return tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 3)){
					if(applystate && switch1){ switch1 = false; region.updateClient("junction_state", vecpos); }
					return tracks.get(switch0 ? 1 : 2);
				}
				break;
			}
		}
		return null;
	}

	private boolean eqTrack(TrackKey track, int i){
		return tracks.get(i).getId().equals(track);
	}
	
	public boolean allowsSpawningOn(){
		return true;
	}

	public Track getTrack(TrackKey key){
		for(Track track : tracks) if(track.getId().equals(key)) return track; return null;
	}

	public int size(){
		return tracks.size();
	}
	
	private byte checktimer = 0;

	public void onUpdate(){
		if(checktimer == 0){
			if(switchlocation != null){
				if(entity != null && !isInPlayerRange()){
					entity.setDead(); entity = null;
				}
				else{
					if(isInPlayerRange()){
						entity = new JunctionSwitchEntity(root.getWorld(), this);
						entity.setPosition(switchlocation.xCoord, switchlocation.yCoord, switchlocation.zCoord);
						root.getWorld().spawnEntity(entity);
					}
				}
			}
			checktimer = 5;
		} checktimer--;
	}
	
	private boolean isInPlayerRange(){
		for(EntityPlayer pl : root.getWorld().playerEntities){
			if(vecpos.vector.distanceTo(new Vec3f(pl.posX, pl.posY, pl.posZ)) < 256) return true;
		} return false;
	}

	public void updateSwitchLocation(Vec3f vector, EnumFacing opposite){
		this.switchlocation = vector; entityFacing = opposite;
		if(entity != null) entity.setPosition(switchlocation.xCoord, switchlocation.yCoord, switchlocation.zCoord);
	}

	public boolean onSwitchInteract(EntityPlayer player, JunctionSwitchEntity entity, boolean left){
		if(type == JunctionType.STRAIGHT){
			Print.chat(player, "&cThis Junction has only 2 tracks! It cannot be switched."); return true;
		}
		if(type.isCrossing()){
			Print.chat(player, "&cThis Junction is a Crossing. It cannot be switched!"); return true;
		}
		if(type.isSwitch()){
			if(type == JunctionType.FORK_2){
				switch0 = !switch0; Print.bar(player, "&aChanged Junction State.");
			}
			else{
				if(switch1){ switch1 = false; switch0 = true; }
				else if(switch0){ switch1 = false; switch0 = false; }
				else if(!switch1){ switch0 = false; switch1 = true; }
				Print.bar(player, "&aChanged Junction State.");
			}
		}
		if(type.isDouble()){
			if(left){ switch1 = !switch1; Print.bar(player, "&aChanged Junction State. [1]"); }
			else{ switch0 = !switch0; Print.bar(player, "&aChanged Junction State. [0]"); }
		}
		region.updateClient("junction_state", vecpos); return true;
	}

	public void resetSwitchPosition(){
		this.switchlocation = null; entityFacing = null; if(entity != null) entity.setDead(); region.updateClient("junction", vecpos);
	}

	public int getIndex(TrackKey key){
		for(int i = 0; i < tracks.size(); i++) if(eqTrack(key, i)) return i; return -1;
	}

}
