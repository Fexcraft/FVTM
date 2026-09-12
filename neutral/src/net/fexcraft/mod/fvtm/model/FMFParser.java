package net.fexcraft.mod.fvtm.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3F;
import net.fexcraft.lib.frl.*;
import net.fexcraft.lib.frl.gen.AxisDir;
import net.fexcraft.lib.frl.gen.Generator;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.frl.gen.Generator.Values.*;

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
		ArrayList<Vertex> verts = new ArrayList<>();
		ArrayList<V3F> norms = new ArrayList<>();
		Polyhedron hedron = null;
		Generator gen = null;
		while(true){
			if((r = stream.read()) == -1) break;
			if(r == PE || r > PO) break;
			int type = r;
			hedron = new Polyhedron();
			if(r == PB) gen = new Generator(hedron, Generator.Type.CUBOID);
			else if(r == PC) gen = new Generator(hedron, Generator.Type.CYLINDER);
			if(gen != null){
				gen.set(SCALE, sixteenth).set(TEXTURE_WIDTH, (float)tx).set(TEXTURE_HEIGHT, (float)ty);
			}
			//
			while(true){
				if((r = stream.read()) == -1) break;
				if(r == PE){
					if(type == PB || type == PC){
						hedron.posX *= sixteenth;
						hedron.posY *= sixteenth;
						hedron.posZ *= sixteenth;
						group.add(gen.make());
					}
					else /*if(type == PO)*/{
						group.add(hedron.rescale(sixteenth));
					}
					break;
				}
				switch(r){
					case PP:{
						float[] fl = readFloats(stream, 3);
						hedron.pos(fl[0], fl[1], fl[2]);
						continue;
					}
					case PR:{
						float[] fl = readFloats(stream, 3);
						hedron.rot(fl[0], fl[1], fl[2]);
						continue;
					}
					case PT:{
						if(type == PO){
							float[] fl = readFloats(stream, 2);
							Vertex vert = verts.get(tv).uv(fl[0], fl[1]);
							verts.set(tv++, vert);
							continue;
						}
						int[] in = readIntegers(stream, 2);
						hedron.texU = in[0];
						hedron.texV = in[1];
						continue;
					}
					case PL:{
						hedron.color(new RGB(readIntegers(stream, 1)[0]));
						continue;
					}
					case PDF:{
						if(type == PO){
							if(norms.size() > 0){
								for(int i = 0; i < norms.size(); i++){
									if(i >= verts.size()) break;
									verts.get(i).norm(norms.get(i));
								}
							}
							hedron.polygons.add(new Polygon(verts).genNorm());
							verts.clear();
							norms.clear();
							tv = 0;
							continue;
						}
						gen.set(REMOVE_POLYGONS, readIntegerArray(stream, 6));
						continue;
					}
					case PDU:{
						gen.set(DETACHED_UV, readIntegerArray(stream, 6));
						continue;
					}
					case PCU:{
						int in = stream.read();
						if(!gen.getMap().has(UV)){
							List<float[]> arr = new ArrayList<>();
							for(int i = 0; i < 6; i++) arr.add(new float[0]);
							gen.set(UV, arr);
						}
						List<float[]> uv = gen.getMap().getArray(UV);
						uv.set(in, readFloats(stream, stream.read()));
						continue;
					}
					case PM:{
						hedron.name = readString(stream);
						continue;
					}
					case PRO:{
						int[] ro = new int[]{ stream.read(), stream.read(), stream.read() };
						hedron.rotOrder = getRotationOrder(ro);
						continue;
					}
					default: break;
				}
				if(type == PB){
					switch(r){
						case PF:{
							float[] fl = readFloats(stream, 3);
							gen.set(OFF_X, fl[0]);
							gen.set(OFF_Y, fl[1]);
							gen.set(OFF_Z, fl[2]);
							break;
						}
						case PBS:{
							float[] fl = readFloats(stream, 3);
							gen.set(WIDTH, fl[0]);
							gen.set(HEIGHT, fl[1]);
							gen.set(DEPTH, fl[2]);
							break;
						}
						case PBC:{
							int in = stream.read();
							float[] fl = readFloats(stream, 3);
							if(!gen.getMap().has(CORNERS)){
								List<V3F> corners = new ArrayList<>();
								for(int i = 0; i < 8; i++) corners.add(new V3F());
								gen.set(CORNERS, corners);
							}
							V3F vec = (V3F)gen.getMap().getArray(CORNERS).get(in);
							vec.set(fl[0], fl[1], fl[2]);
							break;
						}
						case PBE:{
							gen.set(EXPANSION, readFloats(stream, 1)[0]);
							break;
						}
						default: break;
					}
				}
				else if(type == PC){
					switch(r){
						case PF:{
							float[] fl = readFloats(stream, 3);
							gen.set(OFF_X, fl[0]);
							gen.set(OFF_Y, fl[1]);
							gen.set(OFF_Z, fl[2]);
							break;
						}
						case PCRL:{
							float[] fl = readFloats(stream, 3);
							gen.set(RADIUS1, fl[0]);
							gen.set(RADIUS2, fl[1]);
							gen.set(LENGTH, fl[2]);
							break;
						}
						case PCD:{
							gen.set(AXIS_DIR, AxisDir.values()[readIntegers(stream, 1)[0]]);
							break;
						}
						case PCSG:{
							int[] in = readIntegers(stream, 2);
							gen.set(SEGMENTS, in[0]);
							gen.set(SEG_LIMIT, in[1]);
							break;
						}
						case PCSL:{
							float[] fl = readFloats(stream, 2);
							gen.set(BASE_SCALE, fl[1]);
							gen.set(TOP_SCALE, fl[1]);
							break;
						}
						case PCTO:{
							float[] fl = readFloats(stream, 3);
							gen.set(TOP_OFFSET, new V3F(fl[0], fl[1], fl[2]));
							break;
						}
						case PCTR:{
							float[] fl = readFloats(stream, 3);
							gen.set(TOP_ROTATION, new V3F(fl[0], fl[1], fl[2]));
							break;
						}
						case PCRT:{
							float[] fl = readFloats(stream, 2);
							gen.set(RADIAL, true);
							gen.set(SEG_WIDTH, fl[0]);
							gen.set(SEG_HEIGHT, fl[1]);
							break;
						}
						case 23:{
							gen.set(SEG_OFFSET, readFloats(stream, 1)[0]);
							break;
						}
						default: break;
					}
				}
				else /*if(type == PO)*/{
					switch(r){
						case PF:{
							float[] fl = readFloats(stream, 3);
							verts.add(new Vertex(fl[0], fl[1], fl[2]));
							break;
						}
						case PN:{
							float[] fl = readFloats(stream, 3);
							norms.add(new V3F(fl[0], fl[1], fl[2]));
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

	private static List<Integer> readIntegerArray(InputStream stream, int t) throws IOException {
		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i < t; i++){
			byte[] bit = new byte[4];
			int r = stream.read(bit);
			if(r < 0) return arr;//error
			arr.add(ByteBuffer.wrap(bit).getInt());
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
