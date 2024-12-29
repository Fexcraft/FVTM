package net.fexcraft.mod.fvtm.util.function;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.tag.TagCW;

import java.util.ArrayList;
import java.util.List;

public class InventoryFunction extends PartFunction {

	@Override
	public PartFunction init(Part part, FJson json){
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
		return TagCW.create();
	}

	@Override
	public String getId(){
		return "1";
	}

	@Override
	public PartFunction copy(Part Part){
		return this;
	}

	public InvHandler inventory(){
		return null;
	}

	public ArrayList<String> getSeats(){
		return new ArrayList<>();
	}

}
