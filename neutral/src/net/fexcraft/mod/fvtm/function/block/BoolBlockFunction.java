package net.fexcraft.mod.fvtm.function.block;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockEntity;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BoolBlockFunction extends BlockFunction {

	private LinkedHashMap<String, Boolean> bools = new LinkedHashMap<>();
	private String key;

	@Override
	public BlockFunction parse(JsonValue val){
		if(val == null) return this;
		for(Map.Entry<String, JsonValue<?>> entry : val.asMap().entries()){
			if(key == null) key = entry.getKey();
			bools.put(entry.getKey(), entry.getValue().bool());
		}
		return this;
	}

	@Override
	public BlockFunction load(TagCW com){
		if(!com.has(id())) return this;
		TagCW tag = com.getCompound(id());
		for(String key : tag.keys()){
			bools.put(key, tag.getBoolean(key));
		}
		return this;
	}

	@Override
	public TagCW save(TagCW com){
		TagCW tag = TagCW.create();
		for(Map.Entry<String, Boolean> entry : bools.entrySet()){
			tag.set(entry.getKey(), entry.getValue());
		}
		com.set(id(), tag);
		return com;
	}

	@Override
	public String id(){
		return "fvtm:boolean";
	}

	@Override
	public BlockFunction copy(Block block) {
		return new BoolBlockFunction().copy(key, bools);
	}

	public BlockFunction copy(String k, Map<String, Boolean> v){
		key = k;
		bools.putAll(v);
		return this;
	}

	@Override
	public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, Passenger player, boolean mainhand){
		if(!mainhand) return false;
		bools.put(key, !bools.get(key));
		if(world.isTilePresent(pos)) sendClientUpdate(world, pos);
		return true;
	}

	public String key(){
		return key;
	}

	public boolean valOf(String key){
		return bools.containsValue(key) ? bools.get(key) : false;
	}

	public void toggle(BlockEntity tile, String key, Boolean to){
		if(key == null) key = this.key;
		bools.put(key, to == null ? !bools.get(key) : to);
		if(tile == null) return;
		sendClientUpdate(tile.getBlockData(), tile.getV3I(), tile.getDim());
	}
}
