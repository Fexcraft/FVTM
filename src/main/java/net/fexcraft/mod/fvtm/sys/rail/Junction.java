package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.JunctionTrackingTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SwitchTileEntity;
import net.fexcraft.mod.fvtm.sys.rail.cmds.JEC;
import net.fexcraft.mod.fvtm.sys.rail.signals.SignalType;
import net.fexcraft.mod.fvtm.sys.uni.PathJuncType;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * <i>Junctions are essential!</i>
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Junction {
	
	private GridV3D vecpos;
	public ArrayList<Track> tracks;
	public boolean switch0, switch1;
	public RailSystem root;
	public Region region;
	public SignalType signal;
	public boolean signal0, signal1;
	public EntryDirection signal_dir = EntryDirection.FORWARD;
	public PathJuncType type;
	public String station;
	//
	public ArrayList<BlockPos> entities = new ArrayList<>();
	private ArrayList<JEC> fortrains = new ArrayList<>();
	private ArrayList<JEC> forswitch = new ArrayList<>();
	//
	protected AxisAlignedBB frustumbb;
	//
	@SideOnly(Side.CLIENT)
	public V3D signalpos0;
    @SideOnly(Side.CLIENT)
    public V3D signalpos1;
	@SideOnly(Side.CLIENT)
	public double signalrot0;
	@SideOnly(Side.CLIENT)
	public double signalrot1;
	@SideOnly(Side.CLIENT)
	public Double bufferrot;
	
	/** General Constructor */
	public Junction(Region region, GridV3D pos){
		vecpos = pos; tracks = new ArrayList<Track>(); this.root = region.getWorld();
		this.region = region; this.switch0 = this.switch1 = false; type = PathJuncType.STRAIGHT;
	}
	
	/** Only to be used from RailRegion.class */
	protected Junction(Region region){
		this.root = region.getWorld(); this.region = region; tracks = new ArrayList<>();
	}

	public Junction setRoot(RailSystem data){
		this.root = data; return this;
	}
	
	public Junction read(NBTTagCompound compound){
		this.vecpos = new GridV3D(compound.getCompoundTag("Pos"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		//this.crossing = compound.getBoolean("Crossing");
		int trackam = compound.getInteger("Tracks");
		if(trackam > 0){
			if(root.getWorld().isRemote){
				for(Track track : tracks){
					if(track.railmodel != null) track.railmodel.clearDisplayLists();
					if(track.restmodel != null) track.restmodel.clearDisplayLists();
					track.railmodel = track.restmodel = null;
				}
				signalpos0 = signalpos1 = null; bufferrot = null;
			}
			tracks.clear();
			for(int i = 0; i < trackam; i++){
				try{ tracks.add(new Track(this).read(compound.getCompoundTag("Track" + i))); }
				catch(Exception e){ e.printStackTrace(); }
			}
		} else tracks.clear(); frustumbb = null;
		//TODO see if necessary //if(!root.getWorld().isRemote) checkTrackSectionConsistency();
		if(compound.hasKey("SignalType")) signal = SignalType.valueOf(compound.getString("SignalType"));
		if(compound.hasKey("SignalDir")) signal_dir = EntryDirection.getFromSaveByte(compound.getByte("SignalDir"));
		if(tracks.size() > 2) type = compound.hasKey("Type")? PathJuncType.valueOf(compound.getString("Type")) : PathJuncType.byTracksAmount(size());
		else type = PathJuncType.STRAIGHT;
		station = compound.hasKey("Station") ? compound.getString("Station") : null;
		if(compound.hasKey("JunctionCommands")){
			forswitch.clear(); NBTTagList list = (NBTTagList)compound.getTag("JunctionCommands");
			for(NBTBase base : list){
				JEC cmd = JEC.read((NBTTagCompound)base);
				if(cmd != null) forswitch.add(cmd);
			}
		}
		if(compound.hasKey("EntityCommands")){
			forswitch.clear(); NBTTagList list = (NBTTagList)compound.getTag("EntityCommands");
			for(NBTBase base : list){
				JEC cmd = JEC.read((NBTTagCompound)base);
				if(cmd != null) fortrains.add(cmd);
			}
		}
		if(signal != null){
			signal0 = compound.getBoolean("Signal0");
			signal1 = compound.getBoolean("Signal1");
		}
		entities.clear();
		if(compound.hasKey("LinkedBlocks")){
			NBTTagList list = (NBTTagList)compound.getTag("LinkedBlocks");
			for(int i = 0; i < list.tagCount(); i++){
				entities.add(BlockPos.fromLong(((NBTTagLong)list.get(i)).getLong()));
			}
		}
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
		if(signal_dir != null) compound.setByte("SignalDir", signal_dir.getSaveByte());
		if(tracks.size() > 2) compound.setString("Type", type.name());
		if(station != null) compound.setString("Station", station);
		if(!forswitch.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(JEC cmd : forswitch) list.appendTag(cmd.write(null));
			compound.setTag("JunctionCommands", list);
		}
		if(!fortrains.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(JEC cmd : fortrains) list.appendTag(cmd.write(null));
			compound.setTag("EntityCommands", list);
		}
		if(signal != null){
			compound.setBoolean("Signal0", signal0);
			compound.setBoolean("Signal1", signal1);
		}
		if(!entities.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(BlockPos pos : entities){
				list.appendTag(new NBTTagLong(pos.toLong()));
			}
			compound.setTag("LinkedBlocks", list);
		}
		return compound;
	}
	
	public GridV3D getVec316f(){
		return vecpos;
	}
	
	public V3D getVec(){
		return vecpos.vector;
	}

	public void addnew(Track track){
		tracks.add(track); type = PathJuncType.byTracksAmount(size());
		if(signal != null){ this.setSignal(null, null); } updateClient(); return;
	}
	
	public void checkTrackSectionConsistency(){
		if(tracks.size() < 2) return;
		if(tracks.size() == 2 && signal != null){
			Section sec0 = tracks.get(0).unit.section(), sec1 = tracks.get(1).unit.section();
			if(sec0.getUID() == sec1.getUID()){ sec0.splitAtSignal(this); } return;
		}
		else{
			boolean fuse = false;
			Track zero = tracks.get(0);
			for(int i = 1; i < tracks.size(); i++){
				if(zero.unit.getSectionId() != tracks.get(i).unit.getSectionId()){
					fuse = true; break;
				}
			}
			if(fuse) zero.unit.section().fuseAtTrack(zero);
		}
	}

	public void updateClient(){
		region.updateClient("junction", vecpos);
	}

	public void remove(int index, boolean firstcall){
		Track track = tracks.remove(index); if(track == null) return;
		if(signal != null){ this.setSignal(null, null); }
		//
		if(!firstcall){
			track.unit.section().splitAtTrack(track); track.unit.section().remove(track);
		}
		type = PathJuncType.byTracksAmount(size());
		this.updateClient();
		//
		if(firstcall){
			Junction junk = root.getJunction(track.start.equals(vecpos) ? track.end : track.start);
			if(junk != null) junk.remove(track.getOppositeId(), false);
			//this.checkTrackSectionConsistency();
		} else this.checkTrackSectionConsistency();
	}

	private void remove(PathKey key, boolean firstcall){
		for(int i = 0; i < tracks.size(); i++){
			if(tracks.get(i).getId().equals(key)){ remove(i, firstcall); return; }
		} return;
	}

	public void clear(){
		ArrayList<Track> trecks = new ArrayList<Track>();
		for(Track track : tracks){ trecks.add(track); }
		for(Track track : trecks) this.remove(track.getId(), true);
		tracks.clear(); this.updateClient();
	}
	
	@Nullable
	public Track getNext(@Nullable RailEntity entity, PathKey track, boolean applystate){
		if(entity != null && fortrains.size() > 0){
			Track track0 = getNext0(entity, track, applystate);
			for(JEC cmd : fortrains){
				if(cmd.isTarget(entity)) entity.commands.add(cmd.copy());
			} return track0;
			
		} else return getNext0(entity, track, applystate);
	}
	
	@Nullable
	public Track getNext0(@Nullable RailEntity entity, PathKey track, boolean applystate){
		if(type == null) type = size() <= 2 ? PathJuncType.STRAIGHT : size() == 3 ? PathJuncType.FORK_2 : PathJuncType.CROSSING;
		if(entity != null){
			for(JEC cmd : forswitch) cmd.processSwitch(entity, this, track, getIndex(track), applystate);
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
							region.updateClient("junction_state", vecpos);
							updateLinkedTileEntities(false);
						}
						else if(bool1 && (switch0 || switch1)){
							switch0 = false;
							switch1 = false;
							region.updateClient("junction_state", vecpos);
							updateLinkedTileEntities(false);
						}
						else if(!bool1 && !switch1){
							switch0 = false;
							switch1 = true;
							region.updateClient("junction_state", vecpos);
							updateLinkedTileEntities(false);
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
					if(applystate && !switch1){
						switch1 = true;
						region.updateClient("junction_state", vecpos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch0 ? 1 : 2);
				}
				if(eqTrack(track, 1)){
					if(applystate && !switch0){
						switch0 = true;
						region.updateClient("junction_state", vecpos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 2)){
					if(applystate && switch0){
						switch0 = false;
						region.updateClient("junction_state", vecpos);
						updateLinkedTileEntities(false);
					}
					return tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 3)){
					if(applystate && switch1){
						switch1 = false;
						region.updateClient("junction_state", vecpos);
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
		for(Track track : tracks) if(track.getId().equals(key)) return track; return null;
	}

	public int size(){
		return tracks.size();
	}
	
	//private byte checktimer = 0;

	public void onUpdate(){
		if(this.isDecorational()) return;
		pollSignal(null);
		/*if(checktimer == 0){
			// junction switch entities been updated here,
			// right now there's nothing to update here though
			checktimer = 5;
		}
		checktimer--;*/
	}
	
	private boolean isDecorational(){
		return tracks.size() == 0 || tracks.get(0).gauge.width() < 0;
	}

	public void pollSignal(RailEntity ent){
		if(signal == null) return;
		boolean oldsig0 = signal0, oldsig1 = signal1;
		if(signal.type == SignalType.Kind.BLOCK){
			if(signal_dir.isBoth()){
				signal0 = tracks.get(0).unit.section().isFree(ent);
				signal1 = tracks.get(1).unit.section().isFree(ent);
			}
			else{
				signal0 = tracks.get(signal_dir.isForward() ? 1 : 0).unit.section().isFree(ent);
			}
		}
		//
		if(oldsig0 != signal0 || oldsig1 != signal1){
			this.region.updateClient("junction_signal_state", vecpos);
			updateLinkedTileEntities(true);
		}
	}

	@SuppressWarnings("unused")
	private boolean isInPlayerRange(){
		for(EntityPlayer pl : root.getWorld().playerEntities){
			if(vecpos.vector.dis(new V3D(pl.posX, pl.posY, pl.posZ)) < 1024) return true;
		}
		return false;
	}

	public boolean onSwitchInteract(EntityPlayer player, SwitchTileEntity tile, boolean left){
		if(type == PathJuncType.STRAIGHT){
			Print.chat(player, "&cThis Junction has only 2 tracks! It cannot be switched."); return true;
		}
		if(type.isCrossing()){
			Print.chat(player, "&cThis Junction is a Crossing. It cannot be switched!"); return true;
		}
		if(type.isSwitch()){
			if(type == PathJuncType.FORK_2){
				switch0 = !switch0; Print.bar(player, "&aChanged Junction State. [" + (switch0 ? 0 : 1)+ "]");
			}
			else{
				if(switch1){ switch1 = false; switch0 = true; }
				else if(switch0){ switch1 = false; switch0 = false; }
				else if(!switch1){ switch0 = false; switch1 = true; }
				Print.bar(player, "&aChanged Junction State. [" + (switch0 ? 0 : switch1 ? 2 : 1) + "]");
			}
		}
		if(type.isDouble()){
			if(left) switch1 = !switch1;
			else switch0 = !switch0;
			Print.bar(player, "&aChanged Junction State. [" + (switch0 ? 0 : 1) + "-" + (switch1 ? 0 : 1) + "]");
		}
		region.updateClient("junction_state", vecpos);
		updateLinkedTileEntities(false);
		return true;
	}

	private void updateLinkedTileEntities(boolean signal){
		entities.removeIf(pos -> {
			if(!root.getWorld().isBlockLoaded(pos)) return false;
			TileEntity tile = root.getWorld().getTileEntity(pos);
			if(tile instanceof JunctionTrackingTileEntity){
				JunctionTrackingTileEntity ent = (JunctionTrackingTileEntity)tile;
				if(ent.getJuncPos() == null || !ent.getJuncPos().equals(this.vecpos)) return true;
				if(signal) ent.updateSignalState();
				else ent.updateSwitchState();
			}
			else return true;
			return false;
		});
	}
	
	public void unlinkLinkedTileEntities(){
		for(BlockPos pos : entities){
			if(!root.getWorld().isBlockLoaded(pos)) continue;
			TileEntity tile = root.getWorld().getTileEntity(pos);
			if(tile instanceof JunctionTrackingTileEntity){
				JunctionTrackingTileEntity ent = (JunctionTrackingTileEntity)tile;
				if(!ent.getJuncPos().equals(this.vecpos)) continue;
				ent.setJunction(null);
			}
		}
	}

	public void addLinkedTileEntity(BlockPos pos){
		if(!entities.contains(pos)) entities.add(pos);
	}

	public int getIndex(PathKey key){
		for(int i = 0; i < tracks.size(); i++) if(eqTrack(key, i)) return i; return -1;
	}

	public AxisAlignedBB getAABB(){
		if(frustumbb != null) return frustumbb;
		V3D min = new V3D(), max = new V3D(), other;
		for(Track track : tracks){
			other = track.start.vector;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
			other = track.end.vector;
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

	public void setSignal(SignalType signal, EntryDirection entrydir){
		if(entrydir == null) entrydir = EntryDirection.FORWARD;
		if(signal == null){ this.signal = null; this.signal_dir = entrydir; }
		else{ this.signal = signal; this.signal_dir = entrydir; }
		region.updateClient("junction_signal", vecpos);
	}

	/** @return true, if entry dir differs junction signal dir */
	public boolean getSignalState(EntryDirection dir){
		if(signal_dir.isBoth()) return dir.isForward() ? signal1 : signal0; return dir == signal_dir ? signal0 : true;
	}

	public boolean hasSignal(PathKey track){
		if(track == null || signal == null) return signal != null; if(signal_dir.isBoth()) return true;
		return eqTrack(track, 0) ? signal_dir.isForward() : signal_dir.isBackward();
	}

	public boolean getSignalState(PathKey track){
		return getSignalState(eqTrack(track, 0) ? EntryDirection.FORWARD : EntryDirection.BACKWARD);
	}
	
	@Override
	public String toString(){
		return "Junction{ " + vecpos + ", " + tracks.size() + ", " + signal_dir + " }";
	}

}
