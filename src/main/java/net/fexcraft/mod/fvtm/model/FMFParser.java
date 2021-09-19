package net.fexcraft.mod.fvtm.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.BoxBuilder;
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
	
	public static HashMap<String, Object> parse(GenericModel<?, ?> model, InputStream stream) throws IOException {
		int f0 = stream.read(), f1 = stream.read(), f2 = stream.read(), format = stream.read();
		if(f0 != 6 || f1 != 13 || f2 != 6 || format < 0) return null;
		HashMap<String, Object> data = new HashMap<>();
		int r = -1;
		String larray = null;
		while((r = stream.read()) > -1){
			Print.debug("#S " + r);
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
					model.textureX = in[0];
					model.textureY = in[1];
					stream.read();//skipping unused E
					break;
				}
				case G:{
					TurboList list = new TurboList(readString(stream));
					Print.debug(list.name + " parsing");
					readPolygons(stream, list, model.textureX, model.textureY);
					model.groups.add(list);
					Print.debug(list.name + " added");
					break;
				}
				case V:{
					data.put(readString(stream), readString(stream));
					break;
				}
				case A:{
					data.put(larray = readString(stream), new ArrayList<String>());
					break;
				}
				case AE:{
					if(larray == null) continue;
					((ArrayList<String>)data.get(larray)).add(readString(stream));
					break;
				}
				default: continue;
			}
			Print.debug("#E " + r);
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
	
	private static void readPolygons(InputStream stream, TurboList list, int tx, int ty) throws IOException {
		int r = -1;
		boolean end = false;
		while(!end){
			if((r = stream.read()) == -1) break;
			Print.debug("p " + r);
			switch(r){
				case PE:{
					end = true;
					break;
				}
				case PB:{
					BoxBuilder box = new BoxBuilder(new ModelRendererTurbo(list, 0, 0, tx, ty));
					boolean done = false;
					Print.debug(box);
					while(!done){
						if((r = stream.read()) == -1) break;
						Print.debug("b " + r);
						switch(r){
							case PP:{
								float[] fl = readFloats(stream, 3);
								box.getRoot().setPosition(fl[0], fl[1], fl[2]);
								break;
							}
							case PR:{
								float[] fl = readFloats(stream, 3);
								box.getRoot().setRotationAngle(fl[0], fl[1], fl[2]);
								break;
							}
							case PF:{
								float[] fl = readFloats(stream, 3);
								box.setOffset(fl[0], fl[1], fl[2]);
								break;
							}
							case PT:{
								int[] in = readIntegers(stream, 2);
								box.getRoot().setTextureOffset(in[0], in[1]);
								break;
							}
							case PL:{
								box.getRoot().setColor(new RGB(readIntegers(stream, 1)[0]));
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
							case PDF:{
								box.removePolygons(readBooleans(stream, 6));
								break;
							}
							case PDU:{
								box.setDetachedUV(readBooleans(stream, 6));
								break;
							}
							case PCU:{
								int in = stream.read();
								float[] fl = readFloats(stream, stream.read());
								box.setPolygonUV(in, fl);
								break;
							}
							case PM:{
								box.getRoot().boxName = readString(stream);
								break;
							}
							case PRO:{
								int[] ro = new int[]{ stream.read(), stream.read(), stream.read() };
								box.getRoot().setRotationOrder(getRotationOrder(ro));
								break;
							}
							case PTM:{
								box.getRoot().texName = readString(stream);
								break;
							}
							case PE:{
								list.add(box.build());
								done = true;
								break;
							}
						}
					}
					break;
				}
				case PC:{
					CylinderBuilder cyl = new CylinderBuilder(new ModelRendererTurbo(list, 0, 0, tx, ty));
					boolean done = false;
					Print.debug(cyl);
					while(!done){
						if((r = stream.read()) == -1) break;
						Print.debug("c " + r);
						switch(r){
							case PP:{
								float[] fl = readFloats(stream, 3);
								cyl.getRoot().setPosition(fl[0], fl[1], fl[2]);
								break;
							}
							case PR:{
								float[] fl = readFloats(stream, 3);
								cyl.getRoot().setRotationAngle(fl[0], fl[1], fl[2]);
								break;
							}
							case PF:{
								float[] fl = readFloats(stream, 3);
								cyl.setPosition(fl[0], fl[1], fl[2]);
								break;
							}
							case PT:{
								int[] in = readIntegers(stream, 2);
								cyl.getRoot().setTextureOffset(in[0], in[1]);
								break;
							}
							case PL:{
								cyl.getRoot().setColor(new RGB(readIntegers(stream, 1)[0]));
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
							case PDF:{
								cyl.removePolygons(readBooleans(stream, 6));
								break;
							}
							case PDU:{
								cyl.setDetachedUV(readBooleans(stream, 6));
								break;
							}
							case PCU:{
								int in = stream.read();
								float[] fl = readFloats(stream, stream.read());
								cyl.setPolygonUV(in, fl);
								break;
							}
							case PM:{
								cyl.getRoot().boxName = readString(stream);
								break;
							}
							case PRO:{
								int[] ro = new int[]{ stream.read(), stream.read(), stream.read() };
								cyl.getRoot().setRotationOrder(getRotationOrder(ro));
								break;
							}
							case PTM:{
								cyl.getRoot().texName = readString(stream);
								break;
							}
							case PE:{
								list.add(cyl.build());
								done = true;
								break;
							}
						}
					}
					break;
				}
				case PO:{
					boolean done = false;
					ModelRendererTurbo turbo = new ModelRendererTurbo(list, 0, 0, tx, ty);
					ArrayList<TexturedVertex> verts = new ArrayList<>();
					ArrayList<Vec3f> norms = new ArrayList<>();
					int tv = 0;
					while(!done){
						if((r = stream.read()) == -1) break;
						switch(r){
							case PP:{
								float[] fl = readFloats(stream, 3);
								turbo.setPosition(fl[0], fl[1], fl[2]);
								break;
							}
							case PR:{
								float[] fl = readFloats(stream, 3);
								turbo.setRotationAngle(fl[0], fl[1], fl[2]);
								break;
							}
							case PF:{
								float[] fl = readFloats(stream, 3);
								verts.add(new TexturedVertex(fl[0], fl[1], fl[2], 0, 0));
								break;
							}
							case PT:{
								float[] fl = readFloats(stream, 2);
								verts.get(tv++).setTexturePosition(fl[0], fl[1]);
								break;
							}
							case PN:{
								float[] fl = readFloats(stream, 3);
								norms.add(new Vec3f(fl[0], fl[1], fl[2]));
								break;
							}
							case PL:{
								turbo.setColor(new RGB(readIntegers(stream, 1)[0]));
								break;
							}
							case PDF:{
								int a = readIntegers(stream, 1)[0];
								int[] idx = readIntegers(stream, a);
								TexturedVertex[] vrts = new TexturedVertex[a];
								for(int i = 0; i < idx.length; i++){
									vrts[i] = verts.get(idx[i]);
								}
								TexturedPolygon poly = new TexturedPolygon(vrts);
								if(norms.size() > 0){
									idx = readIntegers(stream, a);
									for(int i = 0; i < idx.length; i++){
										poly.getNormalVerts().add(norms.get(idx[i]));
									}
								}
								turbo.copyTo(poly);
								break;
							}
							case PM:{
								turbo.boxName = readString(stream);
								break;
							}
							case PRO:{
								int[] ro = new int[]{ stream.read(), stream.read(), stream.read() };
								turbo.setRotationOrder(getRotationOrder(ro));
								break;
							}
							case PTM:{
								turbo.texName = readString(stream);
								break;
							}
							case PE:{
								list.add(turbo);
								done = true;
								break;
							}
						}
					}
					break;
				}
			}
		}
	}

	private static float[] readFloats(InputStream stream, int t) throws IOException {
		float[] arr = new float[t];
		for(int i = 0; i < t; i++){
			byte[] bit = new byte[4];
			int r = stream.read(bit);
			if(r < 4) return arr;//error
			arr[i] = ByteBuffer.wrap(bit).getFloat();
		}
		return arr;
	}

	private static int[] readIntegers(InputStream stream, int t) throws IOException {
		int[] arr = new int[t];
		for(int i = 0; i < t; i++){
			byte[] bit = new byte[4];
			int r = stream.read(bit);
			if(r < 4) return arr;//error
			arr[i] = ByteBuffer.wrap(bit).getInt();
		}
		return arr;
	}

	private static boolean[] readBooleans(InputStream stream, int t) throws IOException {
		boolean[] arr = new boolean[t];
		for(int i = 0; i < t; i++){
			int r = stream.read();
			if(r < 1) return arr;//error
			arr[i] = r == 1;
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
