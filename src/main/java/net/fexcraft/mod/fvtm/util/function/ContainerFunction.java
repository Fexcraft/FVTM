package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFuntion;
import net.minecraft.nbt.NBTTagCompound;

@SuppressWarnings("unused")
public class ContainerFunction extends StaticFuntion {
	
	private ContainerType onlytype;
	private Pos position;
	private int rotation;
	private String name;
	private int length;

	public ContainerFunction(JsonObject obj){
		super(obj); if(obj == null) return;
		if(obj.has("Type")){ onlytype = ContainerType.valueOf(JsonUtil.getIfExists(obj, "type", "MEDIUM")); length = onlytype.length(); }
		position = Pos.fromJson(obj, false); rotation = JsonUtil.getIfExists(obj, "rot", 0).intValue();
		length = JsonUtil.getIfExists(obj, "length", 6).intValue(); if(length < 1) length = 6;
		name = JsonUtil.getIfExists(obj, "name", "unnamed");
		
	}

	@Override
	public String getId(){
		return "fvtm:container";
	}

	public ContainerSlot getAsNewSlot(){
		return new ContainerSlot(name, (byte)length, position.to16Double(), rotation, onlytype);
	}

}
