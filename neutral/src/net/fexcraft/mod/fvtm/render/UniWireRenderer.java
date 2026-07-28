package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.WireComponent;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.content.WireMD;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.render.RenderUtil.RENDER_UTIL;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniWireRenderer {

	public static class UniWireRenderData {

		public boolean ih_wire;
		public boolean ih_tb_rem;
		public boolean ih_tb_slack;
		public boolean ih_tb_comp;
		public boolean ih_comp_relay;
		public boolean ih_comp;
		public WireComponent comp;
		public WireType wiretype;

	}

	public static double ANGLE;
	public static double ANGLE_DOWN;
	public static UniWireRenderData DATA = new UniWireRenderData();
	private static V3D cubepos;
	private static int color;

	public static void renderRelay(RelayHolder holder, WireRelay relay, double cx, double cy, double cz, UniWireRenderData rdata, float ticks){
		if(rdata.ih_wire || (rdata.ih_tb_rem && relay.wires.size() > 0)){
			color = rdata.ih_wire ? holder.isValidType(relay, rdata.wiretype) ? COL_CYN : COL_RED : COL_ORG;
			RENDERER.push();
			RENDERER.translate(relay.pos.x - cx, relay.pos.y - cy, relay.pos.z - cz);
			RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
			RENDERER.pop();
		}
		if(relay.wires.size() > 0){
			if(rdata.ih_tb_slack || rdata.ih_comp || rdata.ih_tb_comp){
				for(Wire wire : relay.wires){
					if(wire.copy || (rdata.ih_tb_comp && wire.noComponents())) continue;
					color = rdata.ih_comp ? (wire.hasComponent(rdata.comp.getType()) ? COL_RED : COL_CYN) : COL_ORG;
					cubepos = wire.getVectorPosition(wire.length * 0.5, false);
					RENDERER.push();
					RENDERER.translate(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
					RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
					RENDERER.pop();
				}
			}
			if(rdata.ih_comp_relay || rdata.ih_tb_comp){
				for(Wire wire : relay.wires){
					if(wire.copy || (rdata.ih_tb_comp && wire.noComponents())) continue;
					color = wire.hasComponent("relay_start") ? rdata.ih_tb_comp ? COL_ORG : COL_RED : rdata.ih_tb_comp ? COL_RED : COL_CYN;
					cubepos = wire.getVectorPosition(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, false);
					RENDERER.push();
					RENDERER.translate(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
					RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
					RENDERER.pop();
					//
					color = wire.hasComponent("relay_end") ? rdata.ih_tb_comp ? COL_ORG : COL_RED : rdata.ih_tb_comp ? COL_RED : COL_CYN;
					cubepos = wire.getVectorPosition(wire.length - (holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f), false);
					RENDERER.push();
					RENDERER.translate(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
					RENDER_UTIL.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, color);
					RENDERER.pop();
				}
			}
		}
		RENDERER.push();
		RENDERER.clear_color();
		for(int i = 0; i < relay.size(); i++){
			if(relay.wires.get(i).copy) continue;
			Wire wire = relay.wires.get(i);
			if(wire.vecpath == null || wire.getWireType() == null) continue;
			if(wire.model == null) new WireMD(wire);
			FvtmBlockEntity tile = relay.getTile();
			RENDERER.bind(wire.getWireType().getTexture());
			RENDERER.push();
			RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
			wire.model.wiremodel.render();
			RENDERER.pop();
			wire.model.update(tile, ticks);
			if(wire.model.comp_s != null){
				ANGLE = wire.model.start_angle;
				ANGLE_DOWN = wire.model.start_angle_down;
				RENDERER.push();
				RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
				//RENDERER.rotate(wire.model.start_angle, 0, 1, 0);
				RENDERER.bind(wire.model.comp_s.getTexture());
				RENDER_UTIL.render(wire.model.comp_s.getModel(), wire.model);
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
				RENDER_UTIL.render(wire.model.comp_e.getModel(), wire.model);
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
								RENDER_UTIL.render(list, wire.model);
								cpm.transforms.deapply();
								RENDERER.pop();
							}
						}
						else{
							RENDERER.push();
							RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
							cpm.transforms.apply();
							RENDERER.bind(com.getTexture());
							RENDER_UTIL.render(list, wire.model);
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
