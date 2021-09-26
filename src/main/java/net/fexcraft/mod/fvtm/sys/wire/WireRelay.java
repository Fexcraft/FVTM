package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireRelay {
	
	protected String key;
	public ArrayList<Wire> wires;
	protected RelayHolder holder;
	//
	protected AxisAlignedBB frustumbb;
	
	/** General Constructor */
	public WireRelay(RelayHolder holder, String key){
		this.key = key;
		wires = new ArrayList<Wire>();
		this.holder = holder;
	}
	
	/** Only to be used from WireRegion.class/Internally */
	protected WireRelay(RelayHolder holder){
		this.holder = holder;
		wires = new ArrayList<>();
	}
	
	public WireRelay read(NBTTagCompound compound){
		key = compound.getString("Key");
		int wiream = compound.getInteger("Wires");
		if(wiream > 0){
			wires.clear();
			for(int i = 0; i < wiream; i++){
				try{
					wires.add(new Wire(this).read(compound.getCompoundTag("Wire" + i)));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else wires.clear();
		frustumbb = null;
		return this;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(int i = 0; i < wires.size(); i++){
			compound.setTag("Wire" + i, wires.get(i).write(null));
		}
		compound.setInteger("Wires", wires.size());
		compound.setString("Key", key);
		return compound;
	}
	
	public String getKey(){
		return key;
	}

	public void addnew(Wire wire){
		wires.add(wire);
		updateClient();
		return;
	}
	
	public void checkWireSectionConsistency(){
		if(wires.size() < 2) return;
		//
	}

	public void updateClient(){
		holder.region.updateClient("relay", vecpos, null);
	}

	public void remove(int index, boolean firstcall){
		Wire wire = wires.remove(index);
		if(wire == null) return;
		//
		if(!firstcall){
			wire.unit.section().splitAtWire(wire);
			wire.unit.section().remove(wire);
		}
		this.updateClient();
		//
		if(firstcall){
			WireRelay relay = holder.region.system.getRelay(wire.start.equals(vecpos) ? wire.end : wire.start);
			if(relay != null) relay.remove(wire.getOppositeId(), false);
		}
		else this.checkWireSectionConsistency();
	}

	private void remove(PathKey key, boolean firstcall){
		for(int i = 0; i < wires.size(); i++){
			if(wires.get(i).getId().equals(key)){
				remove(i, firstcall);
				return;
			}
		}
		return;
	}

	public void clear(){
		ArrayList<Wire> wirrs = new ArrayList<Wire>();
		for(Wire wire : wires){ wirrs.add(wire); }
		for(Wire wire : wirrs) this.remove(wire.getId(), true);
		wires.clear();
		this.updateClient();
	}

	public final boolean eqWire(PathKey wire, int i){
		return wires.get(i).getId().equals(wire);
	}

	public Wire getWire(PathKey key){
		for(Wire wire : wires) if(wire.getId().equals(key)) return wire;
		return null;
	}

	public int size(){
		return wires.size();
	}

	public void onUpdate(){
		//
	}

	public int getIndex(PathKey key){
		for(int i = 0; i < wires.size(); i++) if(eqWire(key, i)) return i;
		return -1;
	}

	public AxisAlignedBB getAABB(){
		if(frustumbb != null) return frustumbb;
		Vec3f min = new Vec3f(), max = new Vec3f(), other;
		for(Wire track : wires){
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
	
	@Override
	public String toString(){
		return "WireRelay{ " + vecpos + ", " + wires.size() + " }";
	}

	public boolean isDuplicate(Wire other){
		for(Wire wire : wires){
			if(wire.getId().equals(other.getId()) || wire.getOppositeId().equals(other.getId())) return true;
		}
		return false;
	}

	public RelayHolder getHolder(){
		return holder;
	}

	public BlockTileEntity getTile(){
		return holder.blocktile;
	}

}
