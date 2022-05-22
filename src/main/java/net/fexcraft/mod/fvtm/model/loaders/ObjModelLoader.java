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
			if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
		}
		//
		List<String> authors = ObjParser.getCommentValues(objdata, new String[]{ "Creators:", "Creator:", "Editors:", "Editor:", "Model Creator:" }, null);
		for(String auth : authors) confdata.creators().add(auth);
		try{
			String tex = ObjParser.getCommentValue(objdata, "TextureSizeX:");
			String tey = ObjParser.getCommentValue(objdata, "TextureSizeY:");
			model.textureX = confdata.values.get(Model.TEXTURE_WIDTH, () -> tex == null ? 256 : Integer.parseInt(tex));
			model.textureY = confdata.values.get(Model.TEXTURE_WIDTH, () -> tey == null ? 256 : Integer.parseInt(tex));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		boolean flip_x = confdata.values.get("FlipAxes", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipAxes:")));
		boolean flip_f = confdata.values.get("FlipFaces", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipFaces:")));
		boolean flip_u = confdata.values.get("FlipU", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipU:")));
		boolean flip_v = confdata.values.get("FlipV", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipV:")));
		confdata.values.set(Model.SMOOTHSHADING, () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SmoothShading:")));
		boolean norm = confdata.values.get("SkipNormals", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SkipNormals:")));
		addObjGroups(model, loc, groups, exclude, flip_x, flip_f, flip_u, flip_v, norm);
		List<String> include = confdata.values.get(Model.OBJ_INCLUDE, () -> new ArrayList<>());
		include.addAll(ObjParser.getCommentValues(objdata, new String[]{ "Include:" }, null));
		for(String str : include){
			filter = str.split(";");
			loc = new ResourceLocation(filter.length > 1 ? filter[filter.length - 1] : str);
			exclude = false;
			groups.clear();
			if(filter.length > 1){
				if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
				if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
			}
			addObjGroups(model, loc, groups, exclude, flip_x, flip_f, flip_u, flip_v, norm);
		}
		//
		confdata.values.get(Model.PROGRAMS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ "Program:" }, null));
		confdata.values.get(Model.CONDPROGRAMS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ "CondPrograms:" }, null));
		confdata.values.get(Model.PIVOTS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ "Pivot:" }, null));
		confdata.values.get(Model.OFFSET, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ "Offset:" }, null));
		confdata.values.get(Model.TRANSFORMS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ "Transform:" }, null));
		return new Object[]{ model, confdata };
	}

	private void addObjGroups(GenericModel model, ResourceLocation loc, ArrayList<String> groups, boolean exclude, boolean flip_x, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		ObjModel objmod = getObjModelFromCache(loc, flip_x, flip_f, flip_u, flip_v, norm);
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
	
	public static ObjModel getObjModelFromCache(ResourceLocation loc, boolean flip_x, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		if(DATA_CACHE.containsKey(loc)){
			return DATA_CACHE.get(loc);
		}
		Object[] stream = Resources.getModelInputStreamWithFallback(loc);
		ObjModel objmod = new ObjParser((InputStream)stream[0]).flipAxes(flip_x).flipFaces(flip_f).flipUV(flip_u, flip_v).readComments(false).noNormals(norm).parse();
		if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) try{ c.close(); } catch(IOException e){ e.printStackTrace();}
		DATA_CACHE.put(loc, objmod);
		return objmod;
	}

	public static void clearCache(){
		INFO_CACHE.clear();
		DATA_CACHE.clear();
	}

}
