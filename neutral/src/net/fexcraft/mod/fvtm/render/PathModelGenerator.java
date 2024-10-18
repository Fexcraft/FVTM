package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.*;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.VecUtil;

import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;

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
			path.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[0]));
			path.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[1]));
			for(int v = 0; v < track.vecpath.length - 1; v++){
				last = track.vecpath[v]; vec = track.vecpath[v + 1];
				angle = -Math.atan2(last.x - vec.x, last.z - vec.z);
				path.add(vec.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[0])).sub(cen));
				path.add(vec.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[1])).sub(cen));
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
								verts[m] = new TexturedVertex(VecUtil.rotByRad(angle, org.vector.x, org.vector.y, org.vector.z), org.u, org.v);
								double dx = (verts[m].vector.x * sixteenth) + vec.x - cen.x;
								double dy = (verts[m].vector.y * sixteenth) + vec.y - cen.y;
								double dz = (verts[m].vector.z * sixteenth) + vec.z - cen.z;
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

}
