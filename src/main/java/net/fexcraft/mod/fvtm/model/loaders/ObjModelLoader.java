package net.fexcraft.mod.fvtm.model.loaders;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

public class ObjModelLoader implements ModelLoader {
	
	private static TreeMap<String, ObjModel> INFO_CACHE = new TreeMap<>();
	private static TreeMap<ResourceLocation, ObjModel> DATA_CACHE = new TreeMap<>();

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("obj");
	}

	@Override
	public Object[] load(String name, ModelData confdata) throws Exception {
		String[] filter = name.split(";");
		String id = filter.length > 1 ? filter[filter.length - 1] : name;
		ResourceLocation loc = new ResourceLocation(id);
		ObjModel objdata = loadObjData(loc);
		GenericModel model = new GenericModel();
		ArrayList<String> groups = new ArrayList<>();
		boolean exclude = false;
		if(filter.length > 1){
			if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
			if(!exclude || filter.length > 2){
				for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
			}
		}
		//
		List<String> authors = ObjParser.getCommentValues(objdata, new String[]{ "Creators:", "Creator:", "Editors:", "Editor:", "Model Creator:" }, null);
		for(String auth : authors) confdata.creators().add(auth);
		int tx = 256, ty = 256;
		try{
			String tex = ObjParser.getCommentValue(objdata, "TextureSizeX:");
			String tey = ObjParser.getCommentValue(objdata, "TextureSizeY:");
			tx = confdata.values.get(Model.TEXTURE_WIDTH, () -> tex == null ? 256 : Integer.parseInt(tex));
			tx = confdata.values.get(Model.TEXTURE_WIDTH, () -> tey == null ? 256 : Integer.parseInt(tex));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		boolean flip_x = confdata.values.get("FlipAxes", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipAxes:")));
		boolean flip_f = confdata.values.get("FlipFaces", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipFaces:")));
		boolean flip_u = confdata.values.get("FlipU", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipU:")));
		boolean flip_v = confdata.values.get("FlipV", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipV:")));
		confdata.values.set("SmoothShading", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SmoothShading:")));
		boolean norm = confdata.values.get("SkipNormals", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SkipNormals:")));
		ObjModel objmod = Resources.getObjModelFromCache(loc, flip_x, flip_f, flip_u, flip_v, norm);
		if(groups.isEmpty()){
			for(String str : objmod.polygons.keySet()) model.addGroup(str, objmod);
		}
		else{
			if(exclude){
				for(String str : objmod.polygons.keySet()){
					if(groups.contains(str) && exclude) continue;
					model.addGroup(str, objmod);
				}
			}
			else{
				for(String str : groups){
					if(!objmod.polygons.containsKey(str)) continue;
					model.addGroup(str, objmod);
				}
			}
		}
		return new Object[]{ model };
	}

	private ObjModel loadObjData(ResourceLocation loc) throws IOException {
		ObjModel objdata = null;
		if(INFO_CACHE.containsKey(loc.toString())){
			objdata = INFO_CACHE.get(loc.toString());
		}
		else{
			Object[] stream = Resources.getModelInputStreamWithFallback(loc);
			objdata = new ObjParser((InputStream)stream[0]).readComments(true).readModel(false).parse();
			INFO_CACHE.put(loc.toString(), objdata);
			if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) c.close();
		}
		return objdata;
	}

	public static void clearCache(){
		INFO_CACHE.clear();
		DATA_CACHE.clear();
	}

}
