package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.*;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.model.program.WirePrograms;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.util.VecUtil;

import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.util.VecUtil.rotByRad;
import static net.fexcraft.mod.fvtm.util.VecUtil.rotate;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PathModelGenerator {

	public static void generateTrackModel(Track track, RailGaugeModel model){
		double angle, passed = 0;
		float obuf = 0;
		float nbuf = 0;
		V3D last, vec, cen = track.vecpath[0];
		ArrayList<V3D> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3;
		TexturedPolygon poly0;
		//
		PathModelPositioned tarp = new PathModelPositioned(track, RGB.WHITE);
		for(int p = 0; p < model.rail_model.size(); p++){
			path.clear();
			passed = 0;
			obuf = 0;
			nbuf = 0;
			float[] vv = model.rail_vv.get(p);
			vec = track.getVectorPosition0(0.001f, false);
			angle = -Math.atan2(track.vecpath[0].x - vec.x, track.vecpath[0].z - vec.z);
			path.add(rotByRad(angle, model.rail_model.get(p)[0]));
			path.add(rotByRad(angle, model.rail_model.get(p)[1]));
			for(int v = 0; v < track.vecpath.length - 1; v++){
				last = track.vecpath[v]; vec = track.vecpath[v + 1];
				angle = -Math.atan2(last.x - vec.x, last.z - vec.z);
				path.add(vec.add(rotByRad(angle, model.rail_model.get(p)[0])).sub(cen));
				path.add(vec.add(rotByRad(angle, model.rail_model.get(p)[1])).sub(cen));
			}
			for(int k = 0; k < track.vecpath.length - 1; k++){
				nbuf += (float)track.vecpath[k].dis(track.vecpath[k + 1]);
				if(nbuf > 1f){
					nbuf = obuf - nbuf;
					obuf = 0;
				}
				vert0 = new TexturedVertex(path.get(k * 2), obuf, vv[1]);
				vert1 = new TexturedVertex(path.get(k * 2 + 1), obuf, vv[0]);
				vert2 = new TexturedVertex(path.get((k + 1) * 2), nbuf, vv[1]);
				vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), nbuf, vv[0]);
				poly0 = new TexturedPolygon(new TexturedVertex[]{ vert1, vert0, vert2, vert3 });
				int pess = (int)passed; if(pess >= tarp.hedrons.length) pess = tarp.hedrons.length - 1;
				tarp.hedrons[pess].importMRT(poly0, 1f);
				passed += track.vecpath[k].dis(track.vecpath[k + 1]);
				obuf = nbuf;
			}
		}
		track.railmodel = tarp;
		//
		tarp = new PathModelPositioned(track, null);
		if(track.length >  model.ties_distance){
			double half = model.ties_distance * .5, accu = half;
			while(accu < track.length){
				last = track.getVectorPosition0(accu - 0.1, false);
				vec = track.getVectorPosition0(accu + 0.1, false);
				angle = -Math.atan2(last.x - vec.x, last.z - vec.z);
				vec = track.getVectorPosition0(accu, false);
				if(model.get("ties") != null){
					for(Polyhedron<GLObject> hedron : model.get("ties")){
						for(Polygon poly : hedron.polygons){
							TexturedVertex[] verts = new TexturedVertex[poly.vertices.length];
							for(int m = 0; m < verts.length; m++){
								Vertex org = poly.vertices[m];
								verts[m] = new TexturedVertex(rotByRad(angle, org.vector.x, org.vector.y, org.vector.z), org.u, org.v);
								double dx = (verts[m].vector.x) + vec.x - cen.x;
								double dy = (verts[m].vector.y) + vec.y - cen.y;
								double dz = (verts[m].vector.z) + vec.z - cen.z;
								verts[m].vector = new Vec3f(dx, dy, dz);
							}
							tarp.hedrons[(int)accu].importMRT(new TexturedPolygon(verts), 1f);
						}
					}
				}
				accu += model.ties_distance;
			}
		}
		track.restmodel = tarp;
	}

	public static void generateWireModel(Wire wire, WireModel model){
		double angle, passed = 0;
		float obuf = 0;
		float nbuf = 0;
		float abuf = 0;
		float arad = 0;
		V3D last, vec, cen = wire.vecpath[0];
		ArrayList<V3D> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3;
		TexturedPolygon poly0;
		//
		PathModelPositioned tarp = new PathModelPositioned(wire, RGB.WHITE);
		for(int p = 0; p < model.wire_model.size(); p++){
			path.clear();
			passed = 0;
			obuf = 0;
			nbuf = 0;
			abuf = 0;
			arad = model.wire_ang.get(p) * Static.rad1;
			float u = model.wire_u.get(p);
			float[] vv = model.wire_vv.get(p);
			vec = wire.getVectorPosition(0.001f, false);
			angle = -Math.atan2(wire.vecpath[0].x - vec.x, wire.vecpath[0].z - vec.z);
			path.add(rotByRad(angle, model.wire_model.get(p)[0]));
			path.add(rotByRad(angle, model.wire_model.get(p)[1]));
			for(int v = 0; v < wire.vecpath.length - 1; v++){
				last = wire.vecpath[v]; vec = wire.vecpath[v + 1];
				angle = -Math.atan2(last.x - vec.x, last.z - vec.z);
				abuf += arad * (float)last.dis(vec);
				if(abuf >= Static.rad180) abuf -= Static.rad180 + Static.rad180;
				path.add(vec.add(rotate(model.wire_model.get(p)[0], 0, abuf, angle)).sub(cen));
				path.add(vec.add(rotate(model.wire_model.get(p)[1], 0, abuf, angle)).sub(cen));
			}
			for(int k = 0; k < wire.vecpath.length - 1; k++){
				nbuf += (float)wire.vecpath[k].dis(wire.vecpath[k + 1]);
				if(nbuf > 1f){
					nbuf = obuf - nbuf;
					obuf = 0;
				}
				vert0 = new TexturedVertex(path.get(k * 2), obuf * u, vv[1]);
				vert1 = new TexturedVertex(path.get(k * 2 + 1), obuf * u, vv[0]);
				vert2 = new TexturedVertex(path.get((k + 1) * 2), nbuf * u, vv[1]);
				vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), nbuf * u, vv[0]);
				poly0 = new TexturedPolygon(new TexturedVertex[]{ vert1, vert0, vert2, vert3 });
				int pess = (int)passed; if(pess >= tarp.hedrons.length) pess = tarp.hedrons.length - 1;
				tarp.hedrons[pess].importMRT(poly0, 1f);
				passed += wire.vecpath[k].dis(wire.vecpath[k + 1]);
				obuf = nbuf;
			}
		}
		wire.wiremodel = tarp;
		//
		vec = wire.vecpath[wire.vecpath.length - 1];
		wire.model_end_angle = Math.atan2(wire.vecpath[0].z - vec.z, wire.vecpath[0].x - vec.x);
		wire.model_end_angle = Static.toDegrees(wire.model_end_angle);
		wire.model_start_angle = wire.model_end_angle - 180;
		//
		if(wire.deco_start != null) wire.deco_s = FvtmRegistry.WIREDECOS.get(wire.deco_start);
		if(wire.deco_end != null) wire.deco_e = FvtmRegistry.WIREDECOS.get(wire.deco_end);
		float hwl = wire.length / 2;
		if(wire.deco_s != null){
			float len = getLongestDownward(wire.deco_s.getModel());
			vec = wire.getVectorPosition(len > hwl ? hwl : len, false);
			double dx = wire.vecpath[0].x - vec.x, dy = wire.vecpath[0].y - vec.y, dz = wire.vecpath[0].z - vec.z;
			wire.model_start_angle_down = (float)Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
			wire.model_start_angle_down = Static.toDegrees(wire.model_start_angle_down);
		}
		if(wire.deco_e != null){
			float len = getLongestDownward(wire.deco_e.getModel());
			vec = wire.getVectorPosition(wire.length - (len > hwl ? hwl : len), false);
			double dx = wire.vecpath[wire.vecpath.length - 1].x - vec.x, dy = wire.vecpath[wire.vecpath.length - 1].y - vec.y, dz = wire.vecpath[wire.vecpath.length - 1].z - vec.z;
			wire.model_end_angle_down = (float)Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
			wire.model_end_angle_down = Static.toDegrees(wire.model_end_angle_down);
		}
	}

	public static float getLongestDownward(WireModel model){
		float l = 0.01f;
		for(ModelGroup list : model.groups){
			for(Program program : list.getAllPrograms()){
				if(program instanceof WirePrograms.DownwardAngled){
					WirePrograms.DownwardAngled prog = (WirePrograms.DownwardAngled)program;
					if(prog.length() > l) l = prog.length();
				}
			}
		}
		return l;
	}

}
