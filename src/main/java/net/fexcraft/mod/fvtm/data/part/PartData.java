package net.fexcraft.mod.fvtm.data.part;

import static net.fexcraft.mod.fvtm.util.AnotherUtil.frNBT;
import static net.fexcraft.mod.fvtm.util.AnotherUtil.toNBT;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonObject;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartData extends DataCore<Part, PartData> implements TextureUser {
	
	protected TreeMap<String, PartFunction> functions = new TreeMap<>();
	protected Textureable texture;
	protected Pos currentpos = new Pos(0, 0, 0);
	protected Rot currentrot = new Rot();
	//protected Vec3f currentrot = new Vec3f();//TODO add this?
	protected String rotpoint;

	public PartData(Part type){
		super(type);
		texture = new Textureable(type);
		for(PartFunction func : type.functions){
			this.functions.put(func.getId(), func.copy(type));
		}
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Part", type.getRegistryName().toString());
		toNBT(currentpos, "CurrentPos", compound);
		currentrot.toNBT("CurrentRot", compound);
		if(rotpoint != null && !rotpoint.equals("vehicle")) compound.setString("SwivelPoint", rotpoint);
		//
		texture.save(new TagCWI(compound));
		//
		NBTTagList flist = new NBTTagList();
		for(PartFunction func : functions.values()){
			NBTTagCompound com = new NBTTagCompound();
			com.setString("id", func.getId()); com = func.write(com);
			if(com != null) flist.appendTag(com);
		} compound.setTag("Functions", flist);
		return compound;
	}

	@Override
	public PartData read(NBTTagCompound compound){
		//if(!compound.hasKey("Part")) return null;
		//type = Resources.getPart(compound.getString("Part"));
		//if(type == null) return null;//TODO add "placeholder" for "missing" items
		currentpos = frNBT("CurrentPos", compound);
		currentrot = Rot.fromNBT("CurrentRot", new TagCWI(compound));
		rotpoint = compound.hasKey("SwivelPoint") ? compound.getString("SwivelPoint") : null;
		//
		texture.load(new TagCWI(compound), type);
		//
		NBTTagList flist = (NBTTagList)compound.getTag("Functions");
		if(flist != null){
			for(NBTBase base : flist){
				NBTTagCompound com = (NBTTagCompound)base;
				PartFunction func = this.getFunction(com.getString("id"));
				if(func != null) func.read(com);
			}
		}
		return this;
	}

	@Override
	public PartData parse(JsonObject obj){
		//ResourceLocation regname = DataUtil.getRegistryName("Part", obj);
		//if(regname == null || Resources.getPart(regname) == null) return null;
		//this.type = Resources.getPart(regname);
		currentpos = Pos.fromJson(obj.get("CurrentPos"), true);
		currentrot = Rot.fromJson(obj, "CurrentPos");
		//
		return this;
	}

	@Override
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Part", type.getRegistryName().toString());
		obj.add("CurrentPos", currentpos.toJson(true));
		if(!currentrot.isNull()) obj.add("CurrentRot", currentrot.toJson());
		//
		return obj;
	}

	public ItemStack newItemStack(){
		ItemStack stack = this.type.newItemStack();
		stack.setTagCompound(this.write(new NBTTagCompound()));
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
