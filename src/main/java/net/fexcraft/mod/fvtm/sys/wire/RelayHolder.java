package net.fexcraft.mod.fvtm.sys.wire;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RelayHolder {
	
	public LinkedHashMap<String, WireRelay> relays = new LinkedHashMap<>();
	protected final WireRegion region;
	protected BlockTileEntity blocktile;
	public BlockPos pos;
	
	public RelayHolder(WireRegion region, BlockPos pos){
		this(region);
		this.pos = pos;
	}

	public RelayHolder(WireRegion region){
		this.region = region;
	}

	public WireRelay add(String key, Vec316f vec, boolean override){
		if(contains(vec)){
			if(override){
				remove(vec);
			}
			else return get(vec);
		}
		WireRelay relay = new WireRelay(this, vec);
		relays.put(key, relay);
		region.system.regRelay(relay);
		return relay;
	}

	public WireRelay get(Vec316f vec){
		for(WireRelay relay : relays.values()) if(relay.getVec316f().equals(vec)) return relay;
		return null;
	}

	public WireRelay get(String key){
		return relays.get(key);
	}

	private boolean contains(Vec316f vec){
		for(WireRelay relay : relays.values()) if(relay.getVec316f().equals(vec)) return true;
		return false;
	}
	
	public WireRelay remove(Vec316f vec){
		String relkey = null;
		for(Entry<String, WireRelay> entry : relays.entrySet()){
			if(entry.getValue().getVec316f().equals(vec)){
				relkey = entry.getKey();
				break;
			}
		}
		if(relkey != null){
			WireRelay relay = relays.remove(relkey);
			int[] key = RegionKey.getRegionXZ(relay.getVec316f());
			if(region.getKey().isInRegion(relay.getVec316f())){
				region.remRelay(relay);
			}
			else this.region.system.getRegions().get(key, true).remRelay(relay);
		}
		return null;
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

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("Pos", pos.toLong());
		NBTTagList list = new NBTTagList();
		for(Entry<String, WireRelay> relay : relays.entrySet()){
			NBTTagCompound com = relay.getValue().write(null);
			com.setString("Key", relay.getKey());
			list.appendTag(com);
		}
		compound.setTag("Relays", list);
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
	
	protected void regRelays(){
		for(WireRelay relay : relays.values()) region.system.regRelay(relay);
	}

}
