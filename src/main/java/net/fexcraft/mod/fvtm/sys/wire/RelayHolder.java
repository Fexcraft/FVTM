package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RelayHolder {
	
	public ArrayList<WireRelay> relays = new ArrayList<>();
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

	public void add(Vec316f vec, boolean override){
		if(contains(vec)){
			if(override){
				remove(vec);
			}
			else return;
		}
		WireRelay relay = new WireRelay(region, vec);
		relays.add(relay);
		region.system.regRelay(relay);
	}

	private boolean contains(Vec316f vec){
		for(WireRelay relay : relays) if(relay.getVec316f().equals(vec)) return true;
		return false;
	}
	
	public WireRelay remove(Vec316f vec){
		int idx = -1;
		for(int i = 0; i < relays.size(); i++){
			if(relays.get(i).getVec316f().equals(vec)){
				idx = i;
				break;
			}
		}
		if(idx != -1){
			WireRelay relay = relays.remove(idx);
			int[] key = RegionKey.getRegionXZ(relay.getVec316f());
			if(region.getKey().isInRegion(relay.getVec316f())){
				region.remRelay(relay);
			}
			else this.region.system.getRegions().get(key, true).remRelay(relay);
			return relay;
		}
		else return null;
	}

	public void setTile(BlockTileEntity tile){
		blocktile = tile;
		for(WireRelay relay : relays) relay.tile = tile;
	}

	protected void delete(){
		for(WireRelay relay : relays){
			while(relay.wires.size() > 0) relay.remove(0, true);
		}
		relays.clear();
	}

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("Pos", pos.toLong());
		NBTTagList list = new NBTTagList();
		for(WireRelay relay : relays){
			list.appendTag(relay.write(null));
		}
		compound.setTag("Relays", list);
		return compound;
	}

	public RelayHolder read(NBTTagCompound compound){
		pos = BlockPos.fromLong(compound.getLong("Pos"));
		NBTTagList list = (NBTTagList)compound.getTag("Relays");
		for(NBTBase base : list){
			WireRelay relay = new WireRelay(region).read((NBTTagCompound)base);
			relays.add(relay);
		}
		return this;
	}
	
	protected void regRelays(){
		for(WireRelay relay : relays) region.system.regRelay(relay);
	}

}
