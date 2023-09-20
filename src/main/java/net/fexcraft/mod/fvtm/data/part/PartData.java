package net.fexcraft.mod.fvtm.data.part;

import static net.fexcraft.mod.fvtm.util.AnotherUtil.frNBT;
import static net.fexcraft.mod.fvtm.util.AnotherUtil.toTag;

import java.util.Map;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.ContentData;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartData extends ContentData<Part, PartData> implements TextureUser {
	
	protected TreeMap<String, PartFunction> functions = new TreeMap<>();
	protected Textureable texture;
	protected Pos currentpos = new Pos(0, 0, 0);
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
		toTag(currentpos, "CurrentPos", compound);
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
		currentpos = frNBT("CurrentPos", compound);
		currentrot = Rot.fromTag("CurrentRot", compound);
		rotpoint = compound.has("SwivelPoint") ? compound.getString("SwivelPoint") : null;
		//
		texture.load(compound, type);
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
		currentpos = Pos.frJson(map.getMap("CurrentPos"), true);
		//TODO currentrot = Rot.fromJson(map, "CurrentPos");
		//
		return this;
	}

	@Override
	public JsonMap toJson(){
		JsonMap obj = new JsonMap();
		obj.add("Part", type.getIDS());
		//TODO obj.add("CurrentPos", currentpos);
		//TODO if(!currentrot.isNull()) obj.add("CurrentRot", currentrot.toJson());
		//
		return obj;
	}

	public ItemStack newItemStack(){
		ItemStack stack = this.type.getNewStack().local();
		stack.setTagCompound(this.write(new TagCWI()).local());
		return stack;
	}

	public Pos getInstalledPos(){
		return currentpos;
	}
	
	public void setInstalledPos(Pos pos){
		this.currentpos = pos;
	}

	public Rot getInstalledRot(){
		return currentrot;
	}
	
	public void setInstalledRot(Rot rot){
		currentrot = rot;
	}

	public void setInstalledOnSwivelPoint(String rotpoint){
		this.rotpoint = rotpoint;
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
	
	public <F extends PartFunction> F getFunction(ResourceLocation resloc){
		return this.getFunction(resloc.toString());
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
