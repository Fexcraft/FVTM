package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

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

	public WireRelay add(WireKey origin, String key, V3D vec, boolean override){
		if(origin != null){
			key = genRelayKey();
		}
		else{
			if(relays.containsKey(key)){
				if(override){
					remove(key);
				}
				else return get(key);
			}
		}
		WireRelay relay = new WireRelay(this, key, vec);
		if(origin != null) relay.origin = origin;
		relays.put(key, relay);
		return relay;
	}

	private String genRelayKey(){
		String key = "@" + UUID.randomUUID().toString().substring(0, 7);
		if(relays.containsKey(key)) return genRelayKey();
		return key;
	}

	public WireRelay get(String key){
		return relays.get(key);
	}
	
	public WireRelay remove(String relkey){
		return relays.remove(relkey);
	}

	public void onWireRem(WireKey key){
		ArrayList<WireRelay> rem = new ArrayList<>();
		for(WireRelay relay : relays.values()){
			if(relay.origin != null && relay.origin.equals(key)){
				rem.add(relay);
			}
		}
		if(rem.size() > 0){
			for(WireRelay relay : rem) relay.clear();
			relays.values().removeAll(rem);
			updateClient();
		}
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
		relays.clear();
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
			add(null, entry.getKey(), entry.getValue(), false);
		}
	}

	public boolean hasRef(){
		return blockref != null && blockref.getRelayData() != null;
	}

	public RelayData ref(){
		return blockref.getRelayData();
	}

	public List<String> getTypes(WireRelay rel){
		String key = rel.origin != null ? getRootOrigin(rel.origin).key : rel.key;
		return ref().types.get(key);
	}

	private WireRelay getRootOrigin(WireKey origin){
		WireRelay rel = relays.get(origin.start_relay);
		if(rel.origin != null) return getRootOrigin(rel.origin);
		return rel;
	}

	public int getLimits(WireRelay rel){
		String key = rel.origin != null ? getRootOrigin(rel.origin).key : rel.key;
		return ref().limits.get(key);
	}

	public void updateClient(){
		region.system.updateClient("holder", null, pos, null);
	}

}
