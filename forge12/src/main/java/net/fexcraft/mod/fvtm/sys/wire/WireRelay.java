package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireRelay {
	
	protected String key;
	public V3D pos = new V3D();
	public ArrayList<Wire> wires;
	protected RelayHolder holder;
	//
	protected AxisAlignedBB frustumbb;
	
	/** General Constructor */
	public WireRelay(RelayHolder holder, String key, V3D pos){
		this.key = key;
		wires = new ArrayList<Wire>();
		this.holder = holder;
		this.pos = pos;
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
		pos = new V3D(compound.getDouble("PosX"), compound.getDouble("PosY"), compound.getDouble("PosZ"));
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
		compound.setDouble("PosX", pos.x);
		compound.setDouble("PosY", pos.y);
		compound.setDouble("PosZ", pos.z);
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
		holder.getRegion().updateClient("relay", null, holder.pos, this);
	}

	public void remove(int index, boolean firstcall){
		Wire wire = wires.remove(index);
		if(wire == null) return;
		//
		if(!firstcall){
			//TODO wire.unit.section().splitAtWire(wire);
			//TODO wire.unit.section().remove(wire);
		}
		this.updateClient();
		//
		if(firstcall){
			WireRelay relay = holder.getRegion().system.getRelay(wire.key.start_relay.equals(key) ? wire.okey : wire.key);
			if(relay != null) relay.remove(wire.okey, false);
		}
		else this.checkWireSectionConsistency();
	}

	private void remove(WireKey key, boolean firstcall){
		for(int i = 0; i < wires.size(); i++){
			if(wires.get(i).key.equals(key)){
				remove(i, firstcall);
				return;
			}
		}
		return;
	}

	public void clear(){
		ArrayList<Wire> wirrs = new ArrayList<Wire>();
		for(Wire wire : wires){ wirrs.add(wire); }
		for(Wire wire : wirrs) this.remove(wire.key, true);
		wires.clear();
		this.updateClient();
	}

	public final boolean eqWire(WireKey wire, int i){
		return wires.get(i).key.equals(wire);
	}

	public Wire getWire(WireKey key){
		for(Wire wire : wires) if(wire.key.equals(key)) return wire;
		return null;
	}

	public int size(){
		return wires.size();
	}

	public void onUpdate(){
		//
	}

	public int getIndex(WireKey key){
		for(int i = 0; i < wires.size(); i++) if(eqWire(key, i)) return i;
		return -1;
	}

	public AxisAlignedBB getAABB(){
		if(frustumbb != null) return frustumbb;
		V3D min = new V3D(), max = new V3D(), other;
		for(Wire wire : wires){
			other = wire.start;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
			other = wire.end;
			if(other.x < min.x) min.x = other.x;
			if(other.y < min.y) min.y = other.y;
			if(other.z < min.z) min.z = other.z;
			if(other.x > max.x) max.x = other.x;
			if(other.y > max.y) max.y = other.y;
			if(other.z > max.z) max.z = other.z;
		}
		if(size() == 0){
			min = new V3D(-.1f,-.1f,-.1f);
			max = new V3D(+.1f,+.1f,+.1f);
		}
		return frustumbb = new AxisAlignedBB(min.x, min.y, min.z, max.x, max.y, max.z);
	}
	
	@Override
	public String toString(){
		return "WireRelay{ " + key + ", " + wires.size() + " }";
	}

	public boolean isDuplicate(Wire other){
		for(Wire wire : wires){
			if(wire.key.equals(other.key) || wire.okey.equals(other.key)) return true;
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
