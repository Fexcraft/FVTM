package net.fexcraft.mod.fvtm.data.part;

import java.util.Map;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.ContentData;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.fvtm.util.SaveUtils;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartData extends ContentData<Part, PartData> implements TextureUser {
	
	protected TreeMap<String, PartFunction> functions = new TreeMap<>();
	protected Textureable texture;
	protected V3D currentpos = new V3D();
	protected Rot currentrot = new Rot();
	protected String rotpoint;

	public PartData(Part type){
		super(type);
		texture = new Textureable(type);
		for(PartFunction func : type.functions){
			functions.put(func.getId(), func.copy(type));
		}
	}

	@Override
	public TagCW write(TagCW compound){
		if(compound == null) compound = TagCW.create();
		compound.set("Part", type.getIDS());
		compound.set("CurrentPos", SaveUtils.saveV3D(currentpos));
		currentrot.toTag("CurrentRot", compound);
		if(rotpoint != null && !rotpoint.equals("vehicle")) compound.set("SwivelPoint", rotpoint);
		//
		texture.save(compound);
		//
		TagLW flist = TagLW.create();
		for(PartFunction func : functions.values()){
			TagCW com = TagCW.create();
			com.set("id", func.getId());
			com = func.save(com);
			if(com != null) flist.add(com);
		}
		compound.set("Functions", flist);
		return compound;
	}

	@Override
	public PartData read(TagCW compound){
		//if(!compound.hasKey("Part")) return null;
		//type = Resources.getPart(compound.getString("Part"));
		//if(type == null) return null;//TODO add "placeholder" for "missing" items
		if(compound == null || compound.direct() == null) compound = TagCW.create();
		currentpos = SaveUtils.loadV3D(compound.getList("CurrentPos"));
		currentrot = Rot.fromTag("CurrentRot", compound);
		rotpoint = compound.has("SwivelPoint") ? compound.getString("SwivelPoint") : null;
		//
		texture.load(compound);
		//
		if(compound.has("Functions")){
			TagLW list = compound.getList("Functions");
			for(int i = 0; i < list.size(); i++){
				TagCW com = list.getCompound(i);
				PartFunction func = getFunction(com.getString("id"));
				if(func != null) func.load(com);
			}
		}
		return this;
	}

	@Override
	public PartData parse(JsonMap map){
		//ResourceLocation regname = DataUtil.getRegistryName("Part", obj);
		//if(regname == null || Resources.getPart(regname) == null) return null;
		//this.type = Resources.getPart(regname);
		currentpos = SaveUtils.loadV3D(map.getArray("CurrentPos", 0));
		currentrot = Rot.fromJson(map, "CurrentPos");
		//
		return this;
	}

	@Override
	public JsonMap toJson(){
		JsonMap obj = new JsonMap();
		obj.add("Part", type.getIDS());
		obj.add("CurrentPos", SaveUtils.saveV3DJson(currentpos));
		if(!currentrot.isNull()) obj.add("CurrentRot", currentrot.toJson());
		//
		return obj;
	}

	public V3D getInstalledPos(){
		return currentpos;
	}
	
	public void setInstalledPos(V3D pos){
		this.currentpos = pos;
	}

	public Rot getInstalledRot(){
		return currentrot;
	}
	
	public void setInstalledRot(Rot rot){
		currentrot = rot;
	}

	public void setInstalledOnSwivelPoint(String newpoint){
		rotpoint = newpoint;
	}
	
	public String getSwivelPointInstalledOn(){
		return rotpoint;
	}

	public boolean isInstalledOnSwivelPoint(){
		return rotpoint != null;
	}
	
	public Map<String, PartFunction> getFunctions(){
		return functions;
	}
	
	public <F extends PartFunction> F getFunction(String id){
		return (F)functions.get(id);
	}
	
	public <F> F getFunction(Class<F> clazz, String id){
		return (F)functions.get(id);
	}

	public <F> F getFunction(Class<F> clazz, String id, String alt){
		if(!functions.containsKey(id)) return (F)functions.get(alt);
		return (F)functions.get(id);
	}
	
	public <F extends PartFunction> F getFunction(IDL idl){
		return this.getFunction(idl.toString());
	}

	public boolean hasFunction(String string){
		return getFunction(string) != null;
	}

	@Override
	public Textureable getTexture(){
		return texture;
	}

	@Override
	public TextureHolder getTexHolder(){
		return type;
	}

}
