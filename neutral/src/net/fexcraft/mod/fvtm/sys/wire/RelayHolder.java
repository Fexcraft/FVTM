package net.fexcraft.mod.fvtm.sys.wire;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

public class RelayHolder {
	
	public LinkedHashMap<String, WireRelay> relays = new LinkedHashMap<>();
	private final WireRegion region;
	protected Object blocktile;
	public V3I pos;
	
	public RelayHolder(WireRegion region, V3I pos){
		this(region);
		this.pos = pos;
	}

	public RelayHolder(WireRegion region){
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

	protected void delete(){
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
		return compound;
	}

	public RelayHolder read(TagCW compound){
		pos = compound.getV3I("Pos");
		TagLW list = compound.getList("Relays");
		for(TagCW tag : list){
			WireRelay relay = new WireRelay(this).read(tag);
			relays.put(tag.getString("Key"), relay);
		}
		return this;
	}

	public WireRelay get(int index){
		int idx = 0;
		for(WireRelay relay : relays.values()){
			if(idx == index) return relay;
			idx++;
		}
		return null;
	}

	public WireRegion getRegion(){
		return region;
	}

}
