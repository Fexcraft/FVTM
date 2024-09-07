package net.fexcraft.mod.fvtm.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.tmt.BoxBuilder;
import net.fexcraft.lib.tmt.CustomUVBuilder;
import net.fexcraft.lib.tmt.CylinderBuilder;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.lib.tmt.RotationOrder;

/**
 * "Fex's Model Format" Parser <br>
 * 
 * All rights reserved.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class FMFParser {
	
	private static final int E = 0, N = 1, G = 2, T = 3, C = 4, V = 5, A = 6, AE = 7;
	private static final int PE = 0, PB = 1, PC = 2, PO = 3;
	private static final int PP = 1, PR = 2, PF = 3, PT = 4, PN = 5, PL = 6, PM = 7, PDF = 8, PDU = 9, PCU = 10, PRO = 11, PTM = 12;//, PR0 = 13, PR1 = 14, PR2 = 15;
	private static final int PBS = 16, PBC = 17, PBE = 18;
	private static final int PCRL = 16, PCD = 17, PCSG = 18, PCSL = 19, PCTO = 20, PCTR = 21, PCRT = 22;
	
	public static HashMap<String, Object> parse(DefaultModel model, InputStream stream) throws IOException {
		int f0 = stream.read(), f1 = stream.read(), f2 = stream.read(), format = stream.read();
		if(f0 != 6 || f1 != 13 || f2 != 6 || format < 0) return new HashMap<>();
		HashMap<String, Object> data = new HashMap<>();
		int r = -1;
		String larray = null;
		while((r = stream.read()) > -1){
			switch(r){
				case N:{
					model.name = readString(stream);
					break;
				}
				case C:{
					model.addToCreators(readString(stream));
					break;
				}
				case T:{
					int[] in = readIntegers(stream, 2);
					model.tex_width = in[0];
					model.tex_height = in[1];
					stream.read();//skipping unused E
					break;
				}
				case G:{
					ModelGroup group = new ModelGroup(readString(stream));
					readPolygons(stream, group, model.tex_width, model.tex_height);
					model.groups.add(group);
					break;
				}
				case V:{
					data.put(readString(stream), readString(stream));
					break;
				}
				case A:{
					if(!data.containsKey(larray = readString(stream))) data.put(larray, new ArrayList<String>());
					break;
				}
				case AE:{
					if(larray == null) continue;
					Object obj = data.get(larray);
					if(obj instanceof List == false){
						ArrayList list = new ArrayList<>();
						list.add(obj.toString());
						list.add(readString(stream));
						data.put(larray, list);
					}
					else ((List<String>)obj).add(readString(stream));
					break;
				}
				default: break;
			}
		}
		return data;
	}

	private static byte[] read(InputStream stream) throws IOException {
		ArrayList<Byte> list = new ArrayList<>();
		while(true){
			int i = stream.read();
			if(i == E || i == -1) break;
			list.add((byte)i);
		}
		byte[] arr = new byte[list.size()];
		for(int i = 0; i < list.size(); i++) arr[i] = list.get(i);
		return arr;
	}

	private static String readString(InputStream stream) throws IOException {
		return new String(read(stream), StandardCharsets.UTF_8);
	}
	
	private static void readPolygons(InputStream stream, ModelGroup group, int tx, int ty) throws IOException {
		int r = -1, tv = 0;
		ArrayList<TexturedVertex> verts = new ArrayList<>();
		ArrayList<Vec3f> norms = new ArrayList<>();
		ModelRendererTurbo mrt = null;
		BoxBuilder box = null;
		CylinderBuilder cyl = null;
		CustomUVBuilder cuv = null;
		while(true){
			if((r = stream.read()) == -1) break;
			if(r == PE || r > PO) break;
			int type = r;
			mrt = new ModelRendererTurbo(group, 0, 0, tx, ty);
			if(r == PB) cuv = box = new BoxBuilder(mrt);
			else if(r == PC) cuv = cyl = new CylinderBuilder(mrt);
			//
			while(true){
				if((r = stream.read()) == -1) break;
				if(r == PE){
					if(type == PB) group.add(new Polyhedron().importMRT(box.build(), false, 0.0625f));
					else if(type == PC) group.add(new Polyhedron().importMRT(cyl.build(), false, 0.0625f));
					else if(type == PO) group.add(new Polyhedron().importMRT(mrt, false, 0.0625f));
					break;
				}
				switch(r){
					case PP:{
						float[] fl = readFloats(stream, 3);
						mrt.setRotationPoint(fl[0], fl[1], fl[2]);
						continue;
					}
					case PR:{
						float[] fl = readFloats(stream, 3);
						mrt.setRotationAngle(fl[0], fl[1], fl[2]);
						continue;
					}
					case PT:{
						if(type == PO){
							float[] fl = readFloats(stream, 2);
							TexturedVertex vert = verts.get(tv).setTexturePosition(fl[0], fl[1]);
							verts.set(tv++, vert);
							continue;
						}
						int[] in = readIntegers(stream, 2);
						mrt.setTextureOffset(in[0], in[1]);
						continue;
					}
					case PL:{
						mrt.setColor(new RGB(readIntegers(stream, 1)[0]));
						continue;
					}
					case PDF:{
						if(type == PO){
							TexturedPolygon poly = new TexturedPolygon(verts.toArray(new TexturedVertex[0]));
							if(norms.size() > 0) poly.getNormalVerts().addAll(norms);
							mrt.copyTo(poly);
							verts.clear();
							norms.clear();
							tv = 0;
							continue;
						}
						boolean[] arr = new boolean[6];
						arr[0] = stream.read() > 0;
						arr[1] = stream.read() > 0;
						arr[2] = stream.read() > 0;
						arr[3] = stream.read() > 0;
						arr[4] = stream.read() > 0;
						arr[5] = stream.read() > 0;
						cuv.removePolygons(arr);
						continue;
					}
					case PDU:{
						boolean[] arr = new boolean[6];
						arr[0] = stream.read() > 0;
						arr[1] = stream.read() > 0;
						arr[2] = stream.read() > 0;
						arr[3] = stream.read() > 0;
						arr[4] = stream.read() > 0;
						arr[5] = stream.read() > 0;
						cuv.setDetachedUV(arr);
						continue;
					}
					case PCU:{
						int in = stream.read();
						cuv.setPolygonUV(in, readFloats(stream, stream.read()));
						continue;
					}
					case PM:{
						mrt.boxName = readString(stream);
						continue;
					}
					case PRO:{
						int[] ro = new int[]{ stream.read(), stream.read(), stream.read() };
						mrt.setRotationOrder(getRotationOrder(ro));
						continue;
					}
					case PTM:{
						mrt.texName = readString(stream);
						continue;
					}
					default: break;
				}
				if(type == PB){
					switch(r){
						case PF:{
							float[] fl = readFloats(stream, 3);
							box.setOffset(fl[0], fl[1], fl[2]);
							break;
						}
						case PBS:{
							float[] fl = readFloats(stream, 3);
							box.setSize(fl[0], fl[1], fl[2]);
							break;
						}
						case PBC:{
							int in = stream.read();
							float[] fl = readFloats(stream, 3);
							box.setCorner(in, fl[0], fl[1], fl[2]);
							break;
						}
						case PBE:{
							box.setExpansion(readFloats(stream, 1)[0]);
							break;
						}
						default: break;
					}
				}
				else if(type == PC){
					switch(r){
						case PF:{
							float[] fl = readFloats(stream, 3);
							cyl.setPosition(fl[0], fl[1], fl[2]);
							break;
						}
						case PCRL:{
							float[] fl = readFloats(stream, 3);
							cyl.setRadius(fl[0], fl[1]);
							cyl.setLength(fl[2]);
							break;
						}
						case PCD:{
							cyl.setDirection(readIntegers(stream, 1)[0]);
							break;
						}
						case PCSG:{
							int[] in = readIntegers(stream, 2);
							cyl.setSegments(in[0], in[1]);
							break;
						}
						case PCSL:{
							float[] fl = readFloats(stream, 2);
							cyl.setScale(fl[0], fl[1]);
							break;
						}
						case PCTO:{
							float[] fl = readFloats(stream, 3);
							cyl.setTopOffset(fl[0], fl[1], fl[2]);
							break;
						}
						case PCTR:{
							float[] fl = readFloats(stream, 3);
							cyl.setTopRotation(fl[0], fl[1], fl[2]);
							break;
						}
						case PCRT:{
							float[] fl = readFloats(stream, 2);
							cyl.setRadialTexture(fl[0], fl[1]);
							break;
						}
						case 23:{
							cyl.setSegmentOffset(readFloats(stream, 1)[0]);
							break;
						}
						default: break;
					}
				}
				else if(type == PO){
					switch(r){
						case PF:{
							float[] fl = readFloats(stream, 3);
							verts.add(new TexturedVertex(fl[0], fl[1], fl[2], 0, 0));
							break;
						}
						case PN:{
							float[] fl = readFloats(stream, 3);
							norms.add(new Vec3f(fl[0], fl[1], fl[2]));
							break;
						}
					}
				}
			}
		}
	}

	private static float[] readFloats(InputStream stream, int t) throws IOException {
		float[] arr = new float[t];
		for(int i = 0; i < t; i++){
			byte[] bit = new byte[4];
			int r = stream.read(bit);
			if(r < 0) return arr;//error
			arr[i] = ByteBuffer.wrap(bit).getFloat();
		}
		return arr;
	}

	private static int[] readIntegers(InputStream stream, int t) throws IOException {
		int[] arr = new int[t];
		for(int i = 0; i < t; i++){
			byte[] bit = new byte[4];
			int r = stream.read(bit);
			if(r < 0) return arr;//error
			arr[i] = ByteBuffer.wrap(bit).getInt();
		}
		return arr;
	}

	private static RotationOrder getRotationOrder(int[] ro){
		if(ro[0] == 0 && ro[1] == 1 && ro[2] == 2) return RotationOrder.XYZ;
		if(ro[0] == 0 && ro[1] == 2 && ro[2] == 1) return RotationOrder.XZY;
		if(ro[0] == 1 && ro[1] == 0 && ro[2] == 2) return RotationOrder.YXZ;
		if(ro[0] == 1 && ro[1] == 2 && ro[2] == 0) return RotationOrder.YZX;
		if(ro[0] == 2 && ro[1] == 0 && ro[2] == 1) return RotationOrder.ZXY;
		if(ro[0] == 2 && ro[1] == 1 && ro[2] == 0) return RotationOrder.ZYX;
		return RotationOrder.YZX;
	}

}
