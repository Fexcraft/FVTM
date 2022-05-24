package net.fexcraft.mod.fvtm.model.loaders;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

public class ObjModelLoader implements ModelLoader {
	
	private static TreeMap<String, ObjModel> INFO_CACHE = new TreeMap<>();
	private static TreeMap<ResourceLocation, ObjModel> DATA_CACHE = new TreeMap<>();
	public static ArrayList<String> keys = new ArrayList<>();
	static {
		keys.add("Creator:");
		keys.add("Editor:");
		keys.add("Author:");
		keys.add("TextureSizeX:");
		keys.add("TextureSizeY:");
		keys.add("FlipAxes:");
		keys.add("FlipFaces:");
		keys.add("FlipU:");
		keys.add("FlipV:");
		keys.add("SmoothShading:");
		keys.add("SkipNormals:");
		keys.add("Include:");
		keys.add("Program:");
		keys.add("CondPrograms:");
		keys.add("Pivot:");
		keys.add("Offset:");
		keys.add("Transform:");
	}

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("obj");
	}

	@Override
	public Object[] load(String name, ModelData confdata, Supplier<Model> supp_model) throws Exception {
		String[] filter = name.split(";");
		String id = filter.length > 1 ? filter[filter.length - 1] : name;
		ResourceLocation loc = new ResourceLocation(id);
		ObjModel objdata = loadObjData(loc);
		GenericModel model = (GenericModel)supp_model.get();
		ArrayList<String> groups = new ArrayList<>();
		boolean exclude = false;
		if(filter.length > 1){
			if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
			if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
		}
		//
		List<String> authors = ObjParser.getCommentValues(objdata, new String[]{ keys.get(0), keys.get(1), keys.get(2) }, null);
		for(String auth : authors) confdata.creators().add(auth);
		try{
			String tex = ObjParser.getCommentValue(objdata, keys.get(3));
			String tey = ObjParser.getCommentValue(objdata, keys.get(4));
			model.textureX = confdata.get(Model.TEXTURE_WIDTH, () -> tex == null ? 256 : Integer.parseInt(tex));
			model.textureY = confdata.get(Model.TEXTURE_WIDTH, () -> tey == null ? 256 : Integer.parseInt(tex));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		boolean flip_x = confdata.get("FlipAxes", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(5))));
		boolean flip_f = confdata.get("FlipFaces", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(6))));
		boolean flip_u = confdata.get("FlipU", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(7))));
		boolean flip_v = confdata.get("FlipV", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(8))));
		confdata.set(Model.SMOOTHSHADING, () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(9))));
		boolean norm = confdata.get("SkipNormals", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(10))));
		addObjGroups(model, loc, groups, exclude, flip_x, flip_f, flip_u, flip_v, norm);
		List<String> include = confdata.get(Model.OBJ_INCLUDE, () -> new ArrayList<>());
		include.addAll(ObjParser.getCommentValues(objdata, new String[]{ keys.get(11) }, null));
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
		confdata.get(Model.PROGRAMS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ keys.get(12) }, null));
		confdata.get(Model.CONDPROGRAMS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ keys.get(13) }, null));
		confdata.get(Model.PIVOTS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ keys.get(14) }, null));
		confdata.get(Model.OFFSET, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ keys.get(15) }, null));
		confdata.get(Model.TRANSFORMS, () -> new ArrayList<>()).addAll(ObjParser.getCommentValues(objdata, new String[]{ keys.get(16) }, null));
		Pattern pattern = Pattern.compile("# (.+): (.+)");
		for(String str : objdata.comments){
			Matcher mat = pattern.matcher(str);
			if(mat.matches()){
				String key = mat.group(1);
				String value = mat.group(2);
				if(confdata.contains(key)){
					if(confdata.get(key) instanceof Collection){
						((Collection<Object>)confdata.get(key)).add(value);
					}
					else{
						ArrayList<String> list = new ArrayList<String>();
						list.add(confdata.get(key));
						confdata.set(key, list);
					}
				}
				else confdata.set(key, value);
			}
		}
		return new Object[]{ model, confdata };
	}

	private void addObjGroups(GenericModel model, ResourceLocation loc, ArrayList<String> groups, boolean exclude, boolean flip_x, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		ObjModel objmod = getObjModelFromCache(loc, flip_x, flip_f, flip_u, flip_v, norm);
		if(groups.isEmpty()){
			for(String str : objmod.polygons.keySet()) addGroup(model, str, objmod);
		}
		else{
			if(exclude){
				for(String str : objmod.polygons.keySet()){
					if(groups.contains(str) && exclude) continue;
					addGroup(model, str, objmod);
				}
			}
			else{
				for(String str : groups){
					if(!objmod.polygons.containsKey(str)) continue;
					addGroup(model, str, objmod);
				}
			}
		}
	}

	public void addGroup(GenericModel model, String str, ObjModel objmod){
		model.groups.add(new ModelGroup(str, new ModelRendererTurbo(null, 0, 0, model.textureX, model.textureY).copyTo(objmod.polygons.get(str))));
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
