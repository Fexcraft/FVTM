package net.fexcraft.mod.fvtm.function.part;

import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.inv.FvtmInv;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;

public class InventoryFunction extends PartFunction {
	
	private FvtmInv inventory;

	/** Static Copy in Part. */
	public InventoryFunction(){}

	/** Functional Copy in PartData. */
	public InventoryFunction(InventoryFunction root){
		inventory = root.inventory.copy();
	}

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		InvType type = InvType.parse(map.getString("type", "item"));
		inventory = type.newInv();
		inventory.init(map);
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		inventory.load(compound, "inventory");
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
        inventory.save(compound, "inventory");
		return compound;
	}

	@Override
	public String getId(){
		return "fvtm:inventory";
	}

	@Override
	public PartFunction copy(Part part){
		return new InventoryFunction(this);
	}

	@Override
	public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
		tooltip.add(Formatter.format("&bInvType: &7" + inventory.type));
	}

	public FvtmInv inventory(){
		return inventory;
	}

}
