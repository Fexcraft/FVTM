package net.fexcraft.mod.fvtm.model.loaders;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.tmt.*;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.*;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * All rights reserved, only to be distributed within authorized mods.
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class BEOModelLoader implements ModelLoader {

	private static final int END = 0;
	private static final int NAME = 1;
	private static final int AUTHOR = 2;
	private static final int TEXSIZE = 3;
	private static final int GROUP = 4;
	private static final int OBJECT = 5;
	private static final int POSITION = 2;
	private static final int ROTATION = 3;
	private static final int VECTOR = 4;
	private static final int UV = 5;
	private static final int NORMAL = 6;
	private static final int FACE = 7;

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("bob") || suffix.equals("beo");
	}

	@Override
	public Object[] load(String name, ModelData confdata, Supplier<Model> supplier) throws Exception {
		Object[] streams = FvtmResources.getAssetInputStreamWithFallback(name);
		DefaultModel model = (DefaultModel)supplier.get();
		InputStream stream = (InputStream)streams[0];
		//
		int f0 = stream.read(), f1 = stream.read(), f2 = stream.read(), format = stream.read();
		if(f0 != 6 || f1 != 2 || f2 != 15 || format < 0) return new Object[]{ model, confdata };
		int r;
		while((r = stream.read()) > -1){
			switch(r){
				case NAME:{
					model.name = readString(stream);
					break;
				}
				case AUTHOR:{
					model.addToCreators(readString(stream));
					break;
				}
				case TEXSIZE:{
					int[] in = readIntegers(stream, 2);
					model.tex_width = in[0];
					model.tex_height = in[1];
					break;
				}
				case GROUP:{
					ModelGroup group = new ModelGroup(readString(stream));
					readPolygons(stream, group, model.tex_width, model.tex_height);
					model.groups.add(group);
					break;
				}
				default:
					break;
			}
		}
		//
		if(streams.length > 1) for(Closeable c : (Closeable[])streams[1]) c.close();
		return new Object[]{ model, confdata };
	}

	private static byte[] read(InputStream stream) throws IOException{
		ArrayList<Byte> list = new ArrayList<>();
		while(true){
			int i = stream.read();
			if(i == END || i == -1) break;
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
		ModelRendererTurbo mrt;
		int r;
		while(true){
			if((r = stream.read()) == -1) break;
			if(r != OBJECT) break;
			mrt = new ModelRendererTurbo(group, 0, 0, tx, ty);
			ArrayList<Vec3f> vecs = new ArrayList<>();
			ArrayList<float[]> uvs = new ArrayList<>();
			while(true){
				if((r = stream.read()) == -1) break;
				switch(r){
					case NAME:{
						mrt.boxName = readString(stream);
					}
					case POSITION:{
						float[] fl = readFloats(stream, 3);
						mrt.setRotationPoint(fl[0], fl[1], fl[2]);
						continue;
					}
					case ROTATION:{
						float[] fl = readFloats(stream, 3);
						mrt.setRotationAngle(fl[0], fl[1], fl[2]);
						continue;
					}
					case VECTOR:{
						float[] fl = readFloats(stream, 3);
						vecs.add(new Vec3f(fl[0], fl[1], fl[2]));
						continue;
					}
					case UV:{
						uvs.add(readFloats(stream, 2));
						continue;
					}
					case FACE:{
						int len = readIntegers(stream, 1)[0];
						int[] ids = readIntegers(stream, len + len);
						TexturedVertex[] verts = new TexturedVertex[len];
						for(int i = 0; i < len; i++){
							Vec3f vec = vecs.get(ids[i]);
							float[] uv = uvs.get(ids[i + len]);
							verts[i] = new TexturedVertex(vec.x, vec.y, vec.z, uv[0], uv[1]);
						}
						TexturedPolygon poly = new TexturedPolygon(verts);
						mrt.copyTo(poly);
						continue;
					}
					default: break;
				}
			}
			group.add(new Polyhedron().importMRT(mrt, false, 0.0625f));
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

}
