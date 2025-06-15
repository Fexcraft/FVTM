package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.content.WireMD;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;

import java.util.Map;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniWireRenderer {

	public static Wire CURRENT;
	public static double ANGLE;
	public static double ANGLE_DOWN;

	public static void renderRelay(WireRelay relay, double cx, double cy, double cz){
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
			if(wire.model.deco_s != null){
				ANGLE = wire.model.start_angle;
				ANGLE_DOWN = wire.model.start_angle_down;
				RENDERER.push();
				RENDERER.translate(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
				//RENDERER.rotate(wire.model.start_angle, 0, 1, 0);
				RENDERER.bind(wire.model.deco_s.getTexture());
				wire.model.deco_s.getModel().render(RENDERDATA.set(data, relay.getTile(), null));
				RENDERER.pop();
			}
			if(wire.model.deco_e != null){
				ANGLE = wire.model.end_angle;
				ANGLE_DOWN = wire.model.end_angle_down;
				int l = wire.vecpath.length - 1;
				RENDERER.push();
				RENDERER.translate(wire.vecpath[l].x - cx, wire.vecpath[l].y - cy, wire.vecpath[l].z - cz);
				//RENDERER.rotate(wire.model.end_angle, 0, 1, 0);
				RENDERER.bind(wire.model.deco_e.getTexture());
				wire.model.deco_e.getModel().render(RENDERDATA.set(data, relay.getTile(), null));
				RENDERER.pop();
			}
			if(wire.model.deco_d.size() > 0){
				WireModel wm;
				for(Map.Entry<String, WireDeco> dm : wire.decos.entrySet()){
					wm = dm.getValue().getModel();
					for(ModelGroup list : wm.groups){
						if(wire.model.deco_d.get(dm.getKey()).containsKey(list.name)){
							for(V3D vec : wire.model.deco_d.get(dm.getKey()).get(list.name)){
								RENDERER.push();
								RENDERER.translate(vec.x - cx, vec.y - cy, vec.z - cz);
								wm.transforms.apply();
								RENDERER.bind(dm.getValue().getTexture());
								list.render(RENDERDATA.set(data, relay.getTile(), null));
								wm.transforms.deapply();
								RENDERER.pop();
							}
						}
						else{
							RENDERER.push();
							RENDERER.translate(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
							wm.transforms.apply();
							RENDERER.bind(dm.getValue().getTexture());
							list.render(RENDERDATA.set(data, relay.getTile(), null));
							wm.transforms.deapply();
							RENDERER.pop();
						}
					}
				}
			}
		}
		RENDERER.pop();
	}

}
