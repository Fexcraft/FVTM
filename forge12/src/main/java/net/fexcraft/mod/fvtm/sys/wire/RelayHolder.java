package net.fexcraft.mod.fvtm.sys.wire;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RelayHolder {
	
	public LinkedHashMap<String, WireRelay> relays = new LinkedHashMap<>();
	private final WireRegion region;
	protected BlockTileEntity blocktile;
	public BlockPos pos;
	
	public RelayHolder(WireRegion region, BlockPos pos){
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

	public void setTile(BlockTileEntity tile){
		blocktile = tile;
	}

	public BlockTileEntity getTile(){
		return blocktile;
	}

	protected void delete(){
		for(WireRelay relay : relays.values()){
			while(relay.wires.size() > 0) relay.remove(0, true);
		}
		relays.clear();
	}

	public TagCW write(){
		TagCW compound = TagCW.create();
		compound.set("Pos", pos.toLong());
		TagLW list = TagLW.create();
		for(Entry<String, WireRelay> relay : relays.entrySet()){
			TagCW com = relay.getValue().write(null);
			com.set("Key", relay.getKey());
			list.add(com);
		}
		compound.set("Relays", list);
		return compound;
	}

	public RelayHolder read(NBTTagCompound compound){
		pos = BlockPos.fromLong(compound.getLong("Pos"));
		NBTTagList list = (NBTTagList)compound.getTag("Relays");
		for(NBTBase base : list){
			NBTTagCompound com = (NBTTagCompound)base;
			WireRelay relay = new WireRelay(this).read(com);
			relays.put(com.getString("Key"), relay);
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
