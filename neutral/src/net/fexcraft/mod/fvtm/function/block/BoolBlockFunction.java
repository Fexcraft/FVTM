package net.fexcraft.mod.fvtm.function.block;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockEntity;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BoolBlockFunction extends BlockFunction {

	private String key;
	private boolean value;

	@Override
	public BlockFunction parse(JsonMap map){
		if(map == null) return this;
		key = map.get("key").string_value();
		value = map.has("value") && map.get("value").bool();
		return this;
	}

	@Override
	public BlockFunction load(TagCW com){
		if(com.has(save_id())) value = com.getBoolean(save_id());
		return this;
	}

	@Override
	public TagCW save(TagCW com){
		com.set(save_id(), value);
		return com;
	}

	@Override
	public String id(){
		return "fvtm:bool_value";
	}

	public String save_id(){
		return "fvtm:bool_value_" + key;
	}

	@Override
	public BlockFunction copy(Block block) {
		return new BoolBlockFunction().copy(key, value);
	}

	public BlockFunction copy(String k, boolean v){
		key = k;
		value = v;
		return this;
	}

	@Override
	public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, Passenger player, boolean mainhand){
		if(!mainhand) return false;
		value = !value;
		if(world.isTilePresent(pos)) sendClientUpdate(world, pos);
		return true;
	}

	public String key(){
		return key;
	}

	public boolean val(){
		return value;
	}

	public void toggle(BlockEntity tile, Boolean to){
		value = to == null ? !value : to;
		if(tile == null) return;
		sendClientUpdate(tile.getBlockData(), tile.getV3I(), tile.getDim());
	}

}
