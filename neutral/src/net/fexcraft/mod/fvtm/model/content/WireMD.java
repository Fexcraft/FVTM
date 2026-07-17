package net.fexcraft.mod.fvtm.model.content;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.WireComponent;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.program.WirePrograms;
import net.fexcraft.mod.fvtm.model.program.WirePrograms.WireBreak;
import net.fexcraft.mod.fvtm.render.PathModelGenerator;
import net.fexcraft.mod.fvtm.render.PathModelPositioned;
import net.fexcraft.mod.fvtm.sys.wire.Wire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Wire Model Data
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireMD {

	public PathModelPositioned wiremodel;
	public double start_angle, end_angle;
	public double start_angle_down, end_angle_down;
	public WireComponent deco_s, deco_e;
	public HashMap<String, HashMap<String, ArrayList<V3D>>> deco_d;
	//public HashMap<String, HashMap<String, ArrayList<Polyhedron>>> deco_g;

	public WireMD(Wire wire){
		wire.model = this;
		PathModelGenerator.generateWireModel(wire, wire.getWireType().getModel());//, getWireBreak(wire));
		deco_d = new HashMap<>();
		//deco_g = new HashMap<>();
		if(wire.decos == null) return;
		WireComponent deco;
		for(Map.Entry<String, WireComponent> entry : wire.decos.entrySet()){
			deco = entry.getValue();
			deco_d.put(entry.getKey(), new HashMap<>());
			//deco_g.put(entry.getKey(), new HashMap<>());
			for(ModelGroup list : deco.getModel().groups){
				for(Program program : list.getAllPrograms()){
					if(program instanceof WirePrograms.SpacedDeco == false) continue;
					deco_d.get(entry.getKey()).put(list.name, ((WirePrograms.SpacedDeco)program).generate(wire.getRelay(), wire, list, entry.getKey(), true));
					break;
				}
			}
		}
	}

	private WireBreak getWireBreak(Wire wire){
		if(wire.decos == null) return null;
		for(WireComponent value : wire.decos.values()){
			if(value.getModel() == null) continue;
			for(ModelGroup group : value.getModel().getGroups()){
				for(Program prog : group.getAllPrograms()){
					if(prog instanceof WireBreak) return (WireBreak)prog;
				}
			}
		}
		return null;
	}

}
