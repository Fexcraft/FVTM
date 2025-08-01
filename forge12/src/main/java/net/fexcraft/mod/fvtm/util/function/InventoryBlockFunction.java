package net.fexcraft.mod.fvtm.util.function;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerInit;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.function.block.BoolBlockFunction;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.UIKey;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

public class InventoryBlockFunction extends BlockFunction {

	private InvHandler handler;
	private String key;
	private boolean bool = true;

	public BlockFunction parse(JsonValue val){
		if(val == null) return this;
		JsonMap map = val.asMap();
		handler = new InvHandlerInit(InvType.parse(map.get("type").string_value()));
		if(map.has("capacity")) handler.setCapacity(map.get("capacity").integer_value());
		if(map.has("stacks")) handler.setCapacity(map.get("stacks").integer_value());
		if(map.has("var")) handler.setArg(map.get("var").string_value());
		if(map.has("fluid")) handler.setArg(map.get("fluid").string_value());
		if(map.has("bool_key")) key = map.get("bool_key").string_value();
		if(map.has("bool_val")) bool = map.get("bool_val").bool();
		return this;
	}

	@Override
	public BlockFunction load(TagCW com){
		if(com.has(id())) handler.load(com, id());
		return this;
	}

	@Override
	public TagCW save(TagCW com){
		handler.save(com, id());
		return com;
	}

	@Override
	public String id(){
		return "fvtm:inventory";
	}

	@Override
	public BlockFunction copy(Block block){
		return new InventoryBlockFunction().set(handler.gen(1), key, bool);
	}

	public BlockFunction set(InvHandler invhandler, String k, boolean b){
		handler = invhandler;
		key = k;
		bool = b;
		return this;
	}

	@Override
	public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, EntityW player, boolean main){
		if(!main) return false;
		UIKey ui = handler.type.isFluid() ? UIKeys.BLOCK_INVENTORY_FLUID : UIKeys.BLOCK_INVENTORY_ITEM;
		if(key != null){
			FvtmBlockEntity tile = (FvtmBlockEntity)world.getBlockEntity(pos);
			if(tile.getBlockData().getFunctionBool(key) != bool) return false;
		}
		player.openUI(ui, pos);
		return true;
	}

	public InvHandler inventory(){
		return handler;
	}

	public void onClose(FvtmBlockEntity tile){
		BoolBlockFunction func = tile.getBlockData().getFunctionBool();
		if(func != null) func.toggle(tile, key, !bool);
	}

	public boolean hasBool(){
		return key != null;
	}

}
