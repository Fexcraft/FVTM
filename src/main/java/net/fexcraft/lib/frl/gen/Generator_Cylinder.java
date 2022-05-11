package net.fexcraft.lib.frl.gen;

import static net.fexcraft.lib.frl.gen.Generator.detached;
import static net.fexcraft.lib.frl.gen.Generator.intToBoolArray;

import java.util.ArrayList;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Generator_Cylinder {
	
    public static final int FRONT = 0, BACK = 1, LEFT = 2, RIGHT = 3, TOP = 4, BOTTOM = 5;

	public static <GLO> void make(Polyhedron<GLO> poly, ValueMap map){
		float radius = map.getValue("radius", 1f);
		float radius2 = map.getValue("radius2", 0f);
		float length = map.getValue("length", 1f);
		AxisDir dir = map.getValue("axis_dir", AxisDir.X_POSITIVE);
		int segments = map.getValue("segments", 4);
		int seglimit = map.getValue("seg_limit", 0);
		float top_scale = map.getValue("top_scale", 1f);
		float base_scale = map.getValue("base_scale", 1f);
		boolean radial = map.getValue("radial", false);
		float seg_width = map.getValue("seg_width", 1f);
		float seg_height = map.getValue("seg_height", 1f);
		Vec3f topoff = map.getValue("top_offset", null);
		AxisRotator toprot = map.getValue("top_rot", null);
		float x = map.getValue("x"), y = map.getValue("y"), z = map.getValue("z");
		boolean[] rems = intToBoolArray(map.getArray("rem_poly"), 6);
		if(radius2 == 0f) rems[3] = true;
		boolean[] deuv = intToBoolArray(map.getArray("detached_uv"), 6);
		ArrayList<float[]> uv = map.getArray("uv", 6, null);
		float texw = map.getValue("texture_width");
		float texh = map.getValue("texture_height");
		//boolean noinner = radius2 == 0f;
		float diameter = (int)Math.floor(radius * 2F);
		float texheight = (int)Math.floor(length);
		if(radius < 1){
			int rad = radius < 0.5 ? 1 : 2;
			if(diameter < rad) diameter = rad;
		}
		if(length < 1) texheight = 1;
		else if(length % 1 != 0){
			texheight = (int)length + (length % 1 > 0.5f ? 1 : 0);
		}
		boolean dir_y = dir.isY();
		boolean dir_z = dir.isZ();
		boolean dir_x = dir.isX();
		if(base_scale == 0) base_scale = 1f;
		if(top_scale == 0) rems[1] = true;
		if(segments < 3) segments = 3;
		if(seglimit <= 0) seglimit = segments;
		boolean segl = seglimit < segments;
		ArrayList<Polygon> polis = new ArrayList<>();
		float length_x = (dir_x ? length : 0), length_y = (dir_y ? length : 0), length_z = (dir_z ? length : 0);
		float s_x = (dir.positive ? x + length_x : x);
		float s_y = (dir.positive ? y + length_y : y);
		float s_z = (dir.positive ? z + length_z : z);
		float e_x = (!dir.positive ? x + length_x : x) + (topoff == null ? 0 : topoff.x);
		float e_y = (!dir.positive ? y + length_y : y) + (topoff == null ? 0 : topoff.y);
		float e_z = (!dir.positive ? z + length_z : z) + (topoff == null ? 0 : topoff.z);
		float c_x = s_x, c_y = s_y, c_z = s_z, c_s = base_scale;
		//Texture
		float[][] uvs = new float[6][];
		float scale_u = 1.0F / texw, scale_v = 1.0F / texh;
		float circle_u = diameter * scale_u;
		float circle_v = diameter * scale_v;
		float circle2_u = ((int)Math.floor(radius2 * 2F)) * scale_u;
		float circle2_v = ((int)Math.floor(radius2 * 2F)) * scale_v;
		float height_v = texheight * scale_v;
		float seg_u = radius - radius2;
		if(seg_u < 1) seg_u = 1;
		else if(seg_u % 1 != 0){
			seg_u = (int)seg_u + (seg_u % 1 > 0.5f ? 1 : 0);
		}
		seg_u *= scale_u;
		{
			float x0 = poly.texU * scale_u, y0 = poly.texV * scale_v;
			uvs[0] = new float[]{ x0, y0 };
			uvs[1] = new float[]{ x0 + (detached(rems, deuv, 0) || radial ? 0 : circle_u), y0 + (radial && !detached(rems, deuv, 0) ? seg_height : 0) };
			float cirhi = detached(rems, deuv, 0) && detached(rems, deuv, 1) ? 0 : radial ? (seg_height * (detached(rems, deuv, 0) || detached(rems, deuv, 1) ? 1 : 2)) * scale_v : circle_v;
			float cirwi = detached(rems, deuv, 2) && detached(rems, deuv, 3) ? 0 : circle_u + circle_u;
			uvs[2] = new float[]{ x0, y0 + cirhi };
			uvs[3] = new float[]{ x0, y0 + cirhi + (detached(rems, deuv, 2) ? 0 : height_v) };
			uvs[4] = new float[]{ x0 + cirwi, y0 + cirhi, };
			uvs[5] = new float[]{ x0 + cirwi + (detached(rems, deuv, 2) || detached(rems, deuv, 3) ? seg_u : 0), y0 + cirhi + (detached(rems, deuv, 2) || detached(rems, deuv, 3) ? 0 : height_v) };
			for(int i = 0; i < uv.size(); i++){
				if(rems[i]) continue;
				if(uv.get(i) == null || uv.get(i).length != 2) continue;
				uvs[i][0] = uv.get(i)[0] * scale_u;
				uvs[i][1] = uv.get(i)[1] * scale_v;
				if(!deuv[i]){
					uvs[i][0] += x0;
					uvs[i][1] += y0;
				}
			}
		}
		float width_u = (circle_u * 2F) / segments;
		float segpi = Static.PI / segments;
		ArrayList<Vertex> verts0 = new ArrayList<>();
		ArrayList<Vertex> verts1 = new ArrayList<>();
		ArrayList<Vertex> verts2 = new ArrayList<>();
		ArrayList<Vertex> verts3 = new ArrayList<>();
		for(int repeat = 0; repeat < 2; repeat++){//top/base faces
			for(int index = 0; index < segments; index++){
				float size_x = (float)(Math.sin((segpi) * index * 2F + Static.PI) * radius * c_s);
				float size_z = (float)(-Math.cos((segpi) * index * 2F + Static.PI) * radius * c_s);
				float x0 = c_x + (!dir_x ? size_x : 0);
				float y1 = c_y + (!dir_y ? size_z : 0);
				float z1 = c_z + (dir_x ? size_x : dir_y ? size_z : 0);
				verts0.add(new Vertex(x0, y1, z1));
				if(index == segments - 1){
					verts0.add(new Vertex(verts0.get(0)));
				}
				//
				float xSize2 = (float)(Math.sin((segpi) * index * 2F + Static.PI) * radius2 * c_s);
				float zSize2 = (float)(-Math.cos((segpi) * index * 2F + Static.PI) * radius2 * c_s);
				x0 = c_x + (!dir_x ? xSize2 : 0);
				y1 = c_y + (!dir_y ? zSize2 : 0);
				z1 = c_z + (dir_x ? xSize2 : (dir_y ? zSize2 : 0));
				verts1.add(new Vertex(x0, y1, z1));
				if(index == segments - 1){
					verts1.add(new Vertex(verts1.get(0)));
				}
			}
			if(repeat == 0){
				verts2.addAll(verts0);
				verts2.addAll(verts1);
			}
			else{
				verts3.addAll(verts0);
				verts3.addAll(verts1);
			}
			float size_x, size_y;
			boolean bool = repeat == 0 ? !dir_z ? !dir.positive : dir.positive : dir_z ? !dir.positive : dir.positive;
			if(!rems[repeat]){
				for(int i = 0; i < verts0.size(); i++){
					if(i >= (verts0.size() - 1) || i >= seglimit){
						if(repeat != 0 && toprot != null){
							verts0.get(i).vector = toprot.getRelativeVector(verts0.get(i).vector);
							verts1.get(i).vector = toprot.getRelativeVector(verts1.get(i).vector);
						}
						break;
					}
					Vertex[] arr = new Vertex[4];
					if(!radial){
						size_x = (float)(Math.sin((segpi) * i * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle_u));
						size_y = (float)(Math.cos((segpi) * i * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle_v));
						arr[0] = verts0.get(i).nauv(uvs[repeat][0] + .5f * circle_u + size_x, uvs[repeat][1] + 0.5F * circle_v + size_y);
						//
						size_x = (float)(Math.sin((segpi) * i * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle2_u));
						size_y = (float)(Math.cos((segpi) * i * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle2_v));
						arr[1] = verts1.get(i).nauv(uvs[repeat][0] + .5f * circle_u + size_x, uvs[repeat][1] + 0.5F * circle_v + size_y);
						//
						size_x = (float)(Math.sin((segpi) * (i + 1) * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle2_u));
						size_y = (float)(Math.cos((segpi) * (i + 1) * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle2_v));
						arr[2] = verts1.get(i + 1).nauv(uvs[repeat][0] + .5f * circle_u + size_x, uvs[repeat][1] + 0.5F * circle_v + size_y);
						//
						size_x = (float)(Math.sin((segpi) * (i + 1) * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle_u));
						size_y = (float)(Math.cos((segpi) * (i + 1) * 2F + (!dir_y ? 0 : Static.PI)) * (0.5F * circle_v));
						arr[3] = verts0.get(i + 1).nauv(uvs[repeat][0] + .5f * circle_u + size_x, uvs[repeat][1] + 0.5F * circle_v + size_y);
					}
					else{
						float diff = seg_u / 4;
						arr[0] = verts0.get(i).nauv(uvs[repeat][0] + (i * seg_width) * scale_u, uvs[repeat][1]);
						arr[1] = verts1.get(i).nauv(uvs[repeat][0] + (i * seg_width) * scale_u + diff, uvs[repeat][1] + (seg_height * scale_v));
						arr[2] = verts1.get(i + 1).nauv(uvs[repeat][0] + ((i + 1) * seg_width) * scale_u - diff, uvs[repeat][1] + (seg_height * scale_v));
						arr[3] = verts0.get(i + 1).nauv(uvs[repeat][0] + ((i + 1) * seg_width) * scale_u, uvs[repeat][1]);
					}
					if(repeat != 0 && toprot != null){
						arr[0].vector = verts0.get(i).vector = toprot.getRelativeVector(arr[0].vector);
						arr[1].vector = verts1.get(i).vector = toprot.getRelativeVector(arr[1].vector);
						arr[2].vector = /*verts1.get(i + 1).vector =*/ toprot.getRelativeVector(arr[2].vector);
						arr[3].vector = /*verts0.get(i + 1).vector =*/ toprot.getRelativeVector(arr[3].vector);
					}
					polis.add(new Polygon(arr));
					if(bool) polis.get(polis.size() - 1).flip();
				}
			}
			verts0.clear(); verts1.clear(); c_x = e_x; c_y = e_y; c_z = e_z; c_s = top_scale;
		}
		boolean bool = dir_z ? !dir.positive : dir.positive;
		int halfv2 = verts2.size() / 2;
		for(int i = 0; i < halfv2; i++){
			if(i >= seglimit && segl){
				if(!rems[4]){
					Vertex[] arr = new Vertex[4];
					arr[0] = verts2.get(0).nauv(uvs[4][0], uvs[4][1]);
					arr[1] = verts3.get(0).nauv(uvs[4][0], uvs[4][1] + height_v);
					arr[2] = verts3.get(halfv2).nauv(uvs[4][0] + seg_u, uvs[4][1] + height_v);
					arr[3] = verts2.get(halfv2).nauv(uvs[4][0] + seg_u, uvs[4][1]);
					polis.add(new Polygon(arr));
					if(!bool) polis.get(polis.size() - 1).flip();
				}
				if(!rems[5]){
					Vertex[] arr = new Vertex[4];
					arr[0] = verts2.get(seglimit).nauv(uvs[5][0], uvs[5][1]);
					arr[1] = verts3.get(seglimit).nauv(uvs[5][0], uvs[5][1] + height_v);
					arr[2] = verts3.get(seglimit + halfv2).nauv(uvs[5][0] + seg_u, uvs[5][1] + height_v);
					arr[3] = verts2.get(seglimit + halfv2).nauv(uvs[5][0] + seg_u, uvs[5][1]);
					polis.add(new Polygon(arr));
					if(bool) polis.get(polis.size() - 1).flip();
				}
				break;
			}
			if(i >= (halfv2 - 1)) break;
			Vertex[] arr = new Vertex[4];
			if(!rems[2]){
				arr[0] = verts2.get(i + 0).nauv(uvs[2][0] + width_u * (i + 0), uvs[2][1]);
				arr[1] = verts3.get(i + 0).nauv(uvs[2][0] + width_u * (i + 0), uvs[2][1] + height_v);
				arr[2] = verts3.get(i + 1).nauv(uvs[2][0] + width_u * (i + 1), uvs[2][1] + height_v);
				arr[3] = verts2.get(i + 1).nauv(uvs[2][0] + width_u * (i + 1), uvs[2][1]);
				polis.add(new Polygon(arr));
				if(bool) polis.get(polis.size() - 1).flip();
			}
			if(!rems[3]){
				arr = new Vertex[4];
				arr[0] = verts2.get(i + halfv2 + 0).nauv(uvs[3][0] + width_u * (i + 0), uvs[3][1]);
				arr[1] = verts3.get(i + halfv2 + 0).nauv(uvs[3][0] + width_u * (i + 0), uvs[3][1] + height_v);
				arr[2] = verts3.get(i + halfv2 + 1).nauv(uvs[3][0] + width_u * (i + 1), uvs[3][1] + height_v);
				arr[3] = verts2.get(i + halfv2 + 1).nauv(uvs[3][0] + width_u * (i + 1), uvs[3][1]);
				polis.add(new Polygon(arr));
				if(!bool) polis.get(polis.size() - 1).flip();
			}
		}
		float scale = map.getValue("scale", 1f);
		if(scale != 1f) for(Polygon gon : polis) for(Vertex vert : gon.vertices) vert.vector = vert.vector.scale(scale);
        for(Polygon gon : polis) poly.polygons.add(gon);
	}
	
}
