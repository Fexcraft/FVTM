package net.fexcraft.mod.fvtm.sys.wire;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.data.block.RelayData;
import net.fexcraft.mod.fvtm.sys.uni.SysObj;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RelayHolder implements SysObj {
	
	public LinkedHashMap<String, WireRelay> relays = new LinkedHashMap<>();
	private final SystemRegion<WireSystem, RelayHolder> region;
	protected Block blockref;
	protected Object blocktile;
	public V3I pos;
	
	public RelayHolder(SystemRegion<WireSystem, RelayHolder> region, V3I pos){
		this(region);
		this.pos = pos;
	}

	public RelayHolder(SystemRegion<WireSystem, RelayHolder> region){
		this.region = region;
	}

	public WireRelay add(String key, V3D vec, boolean override){
		if(relays.containsKey(key)){
			if(override){
				remove(key);
			}
			else return get(key);
		}
		WireRelay relay = new WireRelay(this, key, vec);
		relays.put(key, relay);
		return relay;
	}

	public WireRelay get(String key){
		return relays.get(key);
	}
	
	public WireRelay remove(String relkey){
		return relays.remove(relkey);
	}

	public boolean contains(String key){
		return relays.containsKey(key);
	}

	public void setTile(Object tile){
		blocktile = tile;
	}

	public <TE> TE getTile(){
		return (TE)blocktile;
	}

	public void delete(){
		for(WireRelay relay : relays.values()){
			while(relay.wires.size() > 0) relay.remove(0, true);
		}
		relays.clear();
	}

	public TagCW write(){
		TagCW compound = TagCW.create();
		compound.set("Pos", pos, false);
		TagLW list = TagLW.create();
		for(Entry<String, WireRelay> relay : relays.entrySet()){
			TagCW com = relay.getValue().write(null);
			com.set("Key", relay.getKey());
			list.add(com);
		}
		compound.set("Relays", list);
		if(blockref != null) compound.set("Block", blockref.getIDS());
		return compound;
	}

	public void read(TagCW compound){
		pos = compound.getV3I("Pos");
		TagLW list = compound.getList("Relays");
		for(TagCW tag : list){
			WireRelay relay = new WireRelay(this).read(tag);
			relays.put(tag.getString("Key"), relay);
		}
		if(compound.has("Block")){
			blockref = FvtmRegistry.BLOCKS.get(compound.getString("Block"));
		}
	}

	@Override
	public void update(){

	}

	public WireRelay get(int index){
		int idx = 0;
		for(WireRelay relay : relays.values()){
			if(idx == index) return relay;
			idx++;
		}
		return null;
	}

	public SystemRegion<WireSystem, RelayHolder> getRegion(){
		return region;
	}

	public void integrate(FvtmBlockEntity tile){
		blockref = tile.getBlockData().getType();
		for(Entry<String, V3D> entry : blockref.getRelayData().getVectors(tile).entrySet()){
			add(entry.getKey(), entry.getValue(), false);
		}
	}

	public boolean hasRef(){
		return blockref != null && blockref.getRelayData() != null;
	}

	public RelayData ref(){
		return blockref.getRelayData();
	}

}
