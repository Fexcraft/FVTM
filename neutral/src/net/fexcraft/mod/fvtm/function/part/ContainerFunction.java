package net.fexcraft.mod.fvtm.function.part;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ContainerFunction extends StaticFunction {
	
	private ContainerType onlytype;
	private V3D position;
	private int rotation;
	//private String name;
	private String rotpoint;
	private int length;

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		if(map.has("type")){
			onlytype = ContainerType.valueOf(map.getString("type", "MEDIUM"));
			length = onlytype.length();
		}
		position = map.has("pos") ? ContentConfigUtil.getVector(map.getArray("pos")) : V3D.NULL;
		rotation = map.getInteger("rot", 0);
		length = map.getInteger("length", 6);
		if(length < 1) length = 6;
		//name = map.getString("name", "unnamed");
		rotpoint = map.getString("point", null);
		return this;
	}

	@Override
	public String getId(){
		return "fvtm:container";
	}

	public ContainerSlot getAsNewSlot(String category){
		return new ContainerSlot(category, (byte)length, position.copy(), rotation, onlytype, rotpoint);
	}

}
