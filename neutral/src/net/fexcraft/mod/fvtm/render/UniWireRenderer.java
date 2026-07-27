package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.WireComponent;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.content.WireMD;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RenderUtil.RENDER_UTIL;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniWireRenderer {

	public static Wire CURRENT;
	public static double ANGLE;
	public static double ANGLE_DOWN;
	private static V3D cubepos;
	private static int color;

	public static void renderRelay(RelayHolder holder, WireRelay relay, double cx, double cy, double cz, boolean ih_wire, boolean ih_rem, boolean ih_slack, boolean ih_comp, boolean ih_comp_relay, boolean ih_comp_rem, WireComponent comp){
		if(ih_wire || (ih_rem && relay.wires.size() > 0)){
			RENDERER.push();
			RENDERER.translate(relay.pos.x - cx, relay.pos.y - cy, relay.pos.z - cz);
			RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, ih_wire ? COL_CYN : COL_ORG);
			RENDERER.pop();
		}
		if(relay.wires.size() > 0){
			if(ih_slack || ih_comp || ih_comp_rem){
				for(Wire wire : relay.wires){
					if(wire.copy || (ih_comp_rem && wire.noComponents())) continue;
					color = ih_comp ? (wire.hasComponent(comp.getType()) ? COL_RED : COL_CYN) : COL_ORG;
					cubepos = wire.getVectorPosition(wire.length * 0.5, false);
					RENDERER.push();
					RENDERER.translate(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
					RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
					RENDERER.pop();
				}
			}
			if(ih_comp_relay || ih_comp_rem){
				for(Wire wire : relay.wires){
					if(wire.copy || (ih_comp_rem && wire.noComponents())) continue;
					color = wire.hasComponent("relay_start") ? ih_comp_rem ? COL_ORG : COL_RED : ih_comp_rem ? COL_RED : COL_CYN;
					cubepos = wire.getVectorPosition(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, false);
					RENDERER.push();
					RENDERER.translate(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
					RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
					RENDERER.pop();
					//
					color = wire.hasComponent("relay_end") ? ih_comp_rem ? COL_ORG : COL_RED : ih_comp_rem ? COL_RED : COL_CYN;
					cubepos = wire.getVectorPosition(wire.length - (holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f), false);
					RENDERER.push();
					RENDERER.translate(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
					RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
					RENDERER.pop();
				}
			}
		}
		BlockData data;
		RENDERER.push();
		RENDERER.clear_color();
		for(int i = 0; i < relay.size(); i++){
			if(relay.wires.get(i).copy) continue;
			Wire wire = relay.wires.get(i);
			if(wire.vecpath == null || wire.getWireType() == null) continue;
			if(wire.model == null) new WireMD(wire);
			RENDERER.bind(wire.getWireType().getTexture());
			RENDERER.push();
			RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
			wire.model.wiremodel.render();
			RENDERER.pop();
			data = relay.getTile() == null ? null : ((FvtmBlockEntity)relay.getTile()).getBlockData();
			CURRENT = wire;
			if(wire.model.comp_s != null){
				ANGLE = wire.model.start_angle;
				ANGLE_DOWN = wire.model.start_angle_down;
				RENDERER.push();
				RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
				//RENDERER.rotate(wire.model.start_angle, 0, 1, 0);
				RENDERER.bind(wire.model.comp_s.getTexture());
				RENDER_UTIL.render(wire.model.comp_s.getModel(), RENDERDATA.set(data, relay.getTile(), null));
				RENDERER.pop();
			}
			if(wire.model.comp_e != null){
				ANGLE = wire.model.end_angle;
				ANGLE_DOWN = wire.model.end_angle_down;
				int l = wire.vecpath.length - 1;
				RENDERER.push();
				RENDERER.translate(wire.vecpath[l].x - cx, wire.vecpath[l].y - cy, wire.vecpath[l].z - cz);
				//RENDERER.rotate(wire.model.end_angle, 0, 1, 0);
				RENDERER.bind(wire.model.comp_e.getTexture());
				RENDER_UTIL.render(wire.model.comp_e.getModel(), RENDERDATA.set(data, relay.getTile(), null));
				RENDERER.pop();
			}
			if(wire.model.comp_d.size() > 0){
				WireComponent com;
				WireModel cpm;
				ANGLE = wire.model.start_angle;
				ANGLE_DOWN = 0;
				for(String comkey : wire.model.comp_d.keySet()){
					com = wire.comps.get(comkey);
					cpm = com.getModel();
					for(ModelGroup list : cpm.groups){
						if(wire.model.comp_d.get(comkey).containsKey(list.name)){
							for(V3D vec : wire.model.comp_d.get(comkey).get(list.name)){
								RENDERER.push();
								RENDERER.translate(vec.x - cx, vec.y - cy, vec.z - cz);
								cpm.transforms.apply();
								RENDERER.bind(com.getTexture());
								RENDER_UTIL.render(list, RENDERDATA.set(data, relay.getTile(), null));
								cpm.transforms.deapply();
								RENDERER.pop();
							}
						}
						else{
							RENDERER.push();
							RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
							cpm.transforms.apply();
							RENDERER.bind(com.getTexture());
							RENDER_UTIL.render(list, RENDERDATA.set(data, relay.getTile(), null));
							cpm.transforms.deapply();
							RENDERER.pop();
						}
					}
				}
			}
		}
		RENDERER.pop();
	}

}
