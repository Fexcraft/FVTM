package net.fexcraft.mod.fvtm.model.loaders;

import java.util.*;

import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.gen.FRLObjParser;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelLoader;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ObjModelLoader implements ModelLoader {

	private static LinkedHashMap<IDL, Map<String, ArrayList<Polyhedron>>> DATA_CACHE = new LinkedHashMap<>();

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("obj");
	}

	@Override
	public boolean load(String loc, ModelData confdata, DefaultModel model) throws Exception {
		String[] filter = loc.split(";");
		String id = filter.length > 1 ? filter[filter.length - 1] : loc;
		IDL idl = IDLManager.getIDLCached(id);
		ArrayList<String> groups = new ArrayList<>();
		boolean exclude = false;
		if(filter.length > 1){
			if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
			if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
		}
		boolean flip_f = confdata.getBoolean("FlipFaces", false);
		boolean flip_u = confdata.getBoolean("FlipU", false);
		boolean flip_v = confdata.getBoolean("FlipV", false);
		boolean norm = !confdata.getBoolean("SkipNormals", false);
		addObjGroups(model, idl, groups, exclude, flip_f, flip_u, flip_v, norm);
		List<String> include = new ArrayList<>();
		if(confdata.has(Model.OBJ_INCLUDE)) include.addAll(confdata.getArray(Model.OBJ_INCLUDE).toStringList());
		for(String str : include){
			filter = str.split(";");
			idl = IDLManager.getIDL(filter.length > 1 ? filter[filter.length - 1] : str);
			exclude = false;
			groups.clear();
			if(filter.length > 1){
				if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
				if(!exclude || filter.length > 2) for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
			}
			addObjGroups(model, idl, groups, exclude, flip_f, flip_u, flip_v, norm);
		}
		return true;
	}

	private void addObjGroups(DefaultModel model, IDL loc, ArrayList<String> groups, boolean exclude, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		Map<String, ArrayList<Polyhedron>> polis = getObjModelFromCache(loc, flip_f, flip_u, flip_v, norm);
		if(groups.isEmpty()){
			for(String str : polis.keySet()) addGroup(model, str, polis);
		}
		else{
			if(exclude){
				for(String str : polis.keySet()){
					if(groups.contains(str) && exclude) continue;
					addGroup(model, str, polis);
				}
			}
			else{
				for(String str : groups){
					if(!polis.containsKey(str)) continue;
					addGroup(model, str, polis);
				}
			}
		}
	}

	public void addGroup(DefaultModel model, String str, Map<String, ArrayList<Polyhedron>> polis){
		ModelGroup group = new ModelGroup(str);
		for(Polyhedron poly : polis.get(str)){
			group.add(poly.copy(false));
		}
		model.groups.add(group);
	}
	
	public static Map<String, ArrayList<Polyhedron>> getObjModelFromCache(IDL loc, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		if(DATA_CACHE.containsKey(loc)){
			return DATA_CACHE.get(loc);
		}
		InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback(loc);
		Map<String, ArrayList<Polyhedron>> polis = new FRLObjParser(loc.colon(), iswf.stream()).flipFaces(flip_f).flipUV(flip_u, flip_v).normals(norm).parse();
		iswf.close();
		DATA_CACHE.put(loc, polis);
		return polis;
	}

	public static void clearCache(){
		DATA_CACHE.clear();
	}

}
