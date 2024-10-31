package net.fexcraft.mod.fvtm.model.loaders;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;

import static net.fexcraft.mod.fvtm.FvtmLogger.LOGGER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class OldObjModelLoader implements ModelLoader {
	
	private static TreeMap<IDL, ObjModel> INFO_CACHE = new TreeMap<>();
	private static TreeMap<IDL, ObjModel> DATA_CACHE = new TreeMap<>();
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
	//private long start;

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("obj");
	}

	@Override
	public Object[] load(String name, ModelData confdata, Supplier<Model> supplier) throws Exception {
		//if(Static.dev()) start = Time.getDate();
		String[] filter = name.split(";");
		String id = filter.length > 1 ? filter[filter.length - 1] : name;
		IDL loc = IDLManager.getIDLCached(id);
		ObjModel objdata = loadObjData(loc);
		DefaultModel model = (DefaultModel)supplier.get();
		ArrayList<String> groups = new ArrayList<>();
		boolean exclude = false;
		if(filter.length > 1){
			if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
			if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
		}
		//
		List<String> authors = ObjParser.getCommentValues(objdata, new String[]{ keys.get(0), keys.get(1), keys.get(2) }, null);
		for(String auth : authors) model.addToCreators(auth);
		String md_name = ObjParser.getCommentValue(objdata, "Model Name:");
		if(md_name != null) model.name = md_name;
		try{
			String tex = ObjParser.getCommentValue(objdata, keys.get(3));
			String tey = ObjParser.getCommentValue(objdata, keys.get(4));
			model.tex_width = confdata.gsI(Model.TEXTURE_WIDTH, () -> tex == null ? 256 : Integer.parseInt(tex));
			model.tex_height = confdata.gsI(Model.TEXTURE_WIDTH, () -> tey == null ? 256 : Integer.parseInt(tex));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		boolean flip_x = confdata.gsB("FlipAxes", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(5))));
		boolean flip_f = confdata.gsB("FlipFaces", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(6))));
		boolean flip_u = confdata.gsB("FlipU", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(7))));
		boolean flip_v = confdata.gsB("FlipV", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(8))));
		confdata.gsB(Model.SMOOTHSHADING, () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(9))));
		boolean norm = confdata.gsB("SkipNormals", () -> Boolean.parseBoolean(ObjParser.getCommentValue(objdata, keys.get(10))));
		addObjGroups(model, loc, groups, exclude, flip_x, flip_f, flip_u, flip_v, norm);
		List<String> include = ObjParser.getCommentValues(objdata, new String[]{ keys.get(11) }, null);
		if(confdata.has(Model.OBJ_INCLUDE)) include.addAll(confdata.getArray(Model.OBJ_INCLUDE).toStringList());
		for(String str : include){
			filter = str.split(";");
			loc = IDLManager.getIDL(filter.length > 1 ? filter[filter.length - 1] : str);
			exclude = false;
			groups.clear();
			if(filter.length > 1){
				if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
				if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
			}
			addObjGroups(model, loc, groups, exclude, flip_x, flip_f, flip_u, flip_v, norm);
		}
		//
		fillList(objdata, confdata, 12, Model.PROGRAMS);
		fillList(objdata, confdata, 13, Model.CONDPROGRAMS);
		fillList(objdata, confdata, 14, Model.PIVOTS);
		fillList(objdata, confdata, 15, Model.OFFSET);
		fillList(objdata, confdata, 16, Model.TRANSFORMS);
		for(String str : objdata.comments){
			if(!str.contains(":")) continue;
			int idx = str.indexOf(":");
			String key = str.substring(0, idx);
			if(keys.contains(key + ":")) continue;
			String val = str.substring(idx + 2, str.length()).trim();
			if(confdata.has(key)){
				if(confdata.get(key).isArray()){
					confdata.getArray(key).add(val);
				}
				else{
					JsonArray array = new JsonArray();
					array.add(confdata.get(key).string_value());
					array.add(val);
					confdata.add(key, array);
				}
			}
			else confdata.add(key, val);
		}
		return new Object[]{ model, confdata };
	}

	private void fillList(ObjModel model, ModelData data, int idx, String key){
		List<String> list = ObjParser.getCommentValues(model, new String[]{ keys.get(idx) }, null);
		if(list.size() > 0){
			JsonArray array = data.getArray(key, 0);
			for(String str : list) array.add(str);
		}
	}

	private void addObjGroups(DefaultModel model, IDL loc, ArrayList<String> groups, boolean exclude, boolean flip_x, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
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

	public void addGroup(DefaultModel model, String str, ObjModel objmod){
		ModelGroup group = new ModelGroup(str);
		group.add(new Polyhedron().importMRT(new ModelRendererTurbo(null, 0, 0, model.tex_width, model.tex_height).copyTo(objmod.polygons.get(str)), false, 1));
		model.groups.add(group);
	}

	private ObjModel loadObjData(IDL loc) throws IOException {
		ObjModel objdata = null;
		if(INFO_CACHE.containsKey(loc)){
			objdata = INFO_CACHE.get(loc);
		}
		else{
			Object[] stream = FvtmResources.getAssetInputStreamWithFallback(loc);
			objdata = new ObjParser((InputStream)stream[0]).readComments(true).readModel(false).parse();
			INFO_CACHE.put(loc, objdata);
			if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) c.close();
			if(objdata.errors){
				LOGGER.log("Error while loading OBJ model '" + loc + "'!");
			}
		}
		return objdata;
	}
	
	public static ObjModel getObjModelFromCache(IDL loc, boolean flip_x, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		if(DATA_CACHE.containsKey(loc)){
			return DATA_CACHE.get(loc);
		}
		Object[] stream = FvtmResources.getAssetInputStreamWithFallback(loc);
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
