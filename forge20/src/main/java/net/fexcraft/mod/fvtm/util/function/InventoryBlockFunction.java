package net.fexcraft.mod.fvtm.util.function;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.uni.tag.TagCW;

public class InventoryBlockFunction extends BlockFunction {

	@Override
	public BlockFunction parse(JsonValue map){
		return this;
	}

	@Override
	public BlockFunction load(TagCW com){
		return this;
	}

	@Override
	public TagCW save(TagCW com){
		return TagCW.create();
	}

	@Override
	public String id(){
		return "2";
	}

	@Override
	public BlockFunction copy(Block block){
		return this;
	}

}
