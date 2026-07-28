package net.fexcraft.mod.fvtm.model.content;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.WireComponent;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
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
public class WireMD extends ModelRenderData {

	public PathModelPositioned wiremodel;
	public double start_angle, end_angle;
	public double start_angle_down, end_angle_down;
	public WireComponent comp_s, comp_e;
	public HashMap<String, HashMap<String, ArrayList<V3D>>> comp_d;
	public FvtmBlockEntity block_entity;
	public WCRD rd_s, rd_e, rd_c;
	public Wire wire;

	public WireMD(Wire wire){
		super();
		(this.wire = wire).model = this;
		PathModelGenerator.generateWireModel(wire, wire.getWireType().getModel());//, getWireBreak(wire));
		comp_d = new HashMap<>();
		if(wire.comps == null) return;
		rd_c = new WireMD.WCRD(this, start_angle, 0);
		WireComponent deco;
		for(Map.Entry<String, WireComponent> entry : wire.comps.entrySet()){
			if(entry.getKey().startsWith("relay_")) continue;
			deco = entry.getValue();
			comp_d.put(entry.getKey(), new HashMap<>());
			for(ModelGroup list : deco.getModel().groups){
				for(Program program : list.getAllPrograms()){
					if(program instanceof WirePrograms.SpacedComponent == false) continue;
					comp_d.get(entry.getKey()).put(list.name, ((WirePrograms.SpacedComponent)program).generate(wire.getRelay(), wire, list, entry.getKey(), true));
					break;
				}
			}
		}
	}

	private WireBreak getWireBreak(Wire wire){
		if(wire.comps == null) return null;
		for(WireComponent value : wire.comps.values()){
			if(value.getModel() == null) continue;
			for(ModelGroup group : value.getModel().getGroups()){
				for(Program prog : group.getAllPrograms()){
					if(prog instanceof WireBreak) return (WireBreak)prog;
				}
			}
		}
		return null;
	}

	public ModelRenderData update(FvtmBlockEntity tile, float ticks){
		block_entity = tile;
		return update(ticks);
	}

	@Override
	public FvtmBlockEntity block_entity(){
		return block_entity;
	}

	@Override
	public Wire wire(){
		return wire;
	}

	public static class WCRD extends ModelRenderData {

		public double angle, slack;

		public WCRD(WireMD md, double ang, double slk){
			super(md.cache);
			angle = ang;
			slack = slk;
		}

		@Override
		public double wire_angle(){
			return angle;
		}

		@Override
		public double wire_slack(){
			return slack;
		}

	}

}
