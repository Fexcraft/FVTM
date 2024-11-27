package net.fexcraft.mod.fvtm.function.block;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

public class BarrelBlockFunction extends BlockFunction {

	private int stored, capacity;
	private String content_cat, stored_id;
	private ArrayList<String> compatible = new ArrayList<>();

	@Override
	public BlockFunction parse(JsonValue val){
		if(val == null) return this;
		JsonMap map = val.asMap();
		capacity = map.getInteger("capacity", 1000);
		content_cat = map.getString("category", "barrel");
		if(map.has("compatible")){
			JsonArray array = map.get("compatible").asArray();
			for(JsonValue<?> elm : array.value){
				compatible.add(elm.string_value());
			}
		}
		return this;
	}

	@Override
	public BlockFunction load(TagCW com){
		if(com.has(id())){
			TagCW nbt = com.getCompound(id());
			stored = nbt.getInteger("stored");
			stored_id = nbt.getString("stored_id");
		}
		return this;
	}

	@Override
	public TagCW save(TagCW com){
		TagCW nbt = TagCW.create();
		nbt.set("stored", stored);
		if(stored_id != null) nbt.set("stored_id", stored_id);
		nbt.set("capacity", capacity);
		com.set(id(), nbt);
		return com;
	}

	@Override
	public String id(){
		return "fvtm:barrel";
	}

	@Override
	public BlockFunction copy(Block block){
		return new BarrelBlockFunction().set(capacity, content_cat, compatible);
	}

	public BlockFunction set(int c, String cc, ArrayList<String> ccc){
		capacity = c;
		content_cat = cc;
		compatible.addAll(ccc);
		return this;
	}

	@Override
	public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, Passenger player, boolean main){
		if(!main) return false;
		//
		return true;
	}

	@Override
	public void addInformation(StackWrapper stack, WorldW world, BlockData data, List<String> list, boolean adv){
		list.add(Formatter.format("&eContent Category: &7" + content_cat));
		for(String str : compatible){
			list.add(Formatter.format("&e- &7" + str));
		}
		list.add(Formatter.format("&eStored: &7" + stored + "/" + capacity));
		list.add(Formatter.format("&e of &7" + (stored_id == null || stored_id.length() == 0 ? "nothing" : stored_id)));
	}

}
