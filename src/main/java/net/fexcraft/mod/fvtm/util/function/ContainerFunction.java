package net.fexcraft.mod.fvtm.util.function;

import static net.fexcraft.mod.fvtm.util.AnotherUtil.toV3;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;

public class ContainerFunction extends StaticFunction {
	
	private ContainerType onlytype;
	private Pos position;
	private int rotation;
	//private String name;
	private String rotpoint;
	private int length;

	public ContainerFunction(Part part, JsonObject obj){
		super(part, obj); if(obj == null) return;
		if(obj.has("Type")){ onlytype = ContainerType.valueOf(JsonUtil.getIfExists(obj, "type", "MEDIUM")); length = onlytype.length(); }
		position = Pos.fromJson(obj, false); rotation = JsonUtil.getIfExists(obj, "rot", 0).intValue();
		length = JsonUtil.getIfExists(obj, "length", 6).intValue(); if(length < 1) length = 6;
		//name = JsonUtil.getIfExists(obj, "name", "unnamed");
		rotpoint = obj.has("rot_point") ? obj.get("rot_point").getAsString() : null;
	}

	@Override
	public String getId(){
		return "fvtm:container";
	}

	public ContainerSlot getAsNewSlot(String category){
		return new ContainerSlot(category, (byte)length, toV3(position), rotation, onlytype, rotpoint);
	}

}
