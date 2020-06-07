package net.fexcraft.mod.fvtm.data.part;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartData extends DataCore<Part, PartData> implements Textureable {
	
	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();
	protected TreeMap<String, Function> functions = new TreeMap<>();
	protected int selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean isTextureExternal;
	protected Pos currentpos = new Pos(0, 0, 0);
	//protected Vec3f currentrot = new Vec3f();//TODO add this?
	protected String rotpoint;

	public PartData(Part type){
		super(type); this.clearAttributes();
		for(Function func : type.functions){
			this.functions.put(func.getId(), func.copy(type));
		}
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Part", type.getRegistryName().toString());
		currentpos.toNBT("CurrentPos", compound);
		if(rotpoint != null && !rotpoint.equals("vehicle")) compound.setString("SwivelPoint", rotpoint);
		//
		compound.setInteger("SelectedTexture", selected_texture);
		if(seltex != null || extex != null || selected_texture < 0){
			compound.setString("CustomTexture", seltex == null ? extex : seltex.toString());
			compound.setBoolean("ExternalTexture", isTextureExternal);
		}
		//
		NBTTagList flist = new NBTTagList();
		for(Function func : functions.values()){
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
		currentpos = Pos.fromNBT("CurrentPos", compound);
		rotpoint = compound.hasKey("SwivelPoint") ? compound.getString("SwivelPoint") : null;
		//
		this.selected_texture = compound.getInteger("SelectedTexture");
		if(selected_texture < 0){
			isTextureExternal = compound.getBoolean("ExternalTexture");
			seltex = isTextureExternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
			extex = isTextureExternal ? compound.getString("CustomTexture") : null;
		} else{ seltex = null; extex = null; isTextureExternal = false; }
		//
		NBTTagList flist = (NBTTagList)compound.getTag("Functions");
		if(flist != null){
			for(NBTBase base : flist){
				NBTTagCompound com = (NBTTagCompound)base;
				Function func = this.getFunction(com.getString("id"));
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
		//
		return this;
	}

	@Override
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Part", type.getRegistryName().toString());
		obj.add("CurrentPos", currentpos.toJson(true));
		//
		return obj;
	}
	
	public Attribute<?> getAttribute(String id){
		return attributes.get(id);
	}
	
	@SuppressWarnings("unchecked")
	public <VAL> Attribute<VAL> getAttributeCasted(String id){
		return (Attribute<VAL>)attributes.get(id);
	}
	
	public TreeMap<String, Attribute<?>> getAttributes(){
		return attributes;
	}

	public void resetAttributes(){
		for(Attribute<?> attr : attributes.values()){ attr.reset(); }
	}

	public void updateAttributes(Attribute.Update call){
		for(Attribute<?> attr : attributes.values()){ attr.updateValue(call); }
	}

	public void clearAttributes(){
		if(!attributes.isEmpty()) attributes.clear();
		for(Attribute<?> attr : type.getBaseAttributes()){
			if(attr.target() != null && !attr.target().startsWith("self")) continue;
			Attribute<?> copy = attr.copy(null); attributes.put(copy.id(), copy);
		}
	}

	public void clearModifiers(){
		for(Attribute<?> attr : attributes.values()) attr.getModifiers().clear();
	}

	public ItemStack newItemStack(){
		ItemStack stack = this.type.newItemStack();
		stack.setTagCompound(this.write(new NBTTagCompound()));
		return stack;
	}

	@Override
	public ResourceLocation getTexture(){
		return selected_texture < 0 ? this.getCustomTexture() : type.getDefaultTextures().get(selected_texture);
	}

	@Override
	public int getSelectedTexture(){
		return selected_texture;
	}

	@Override
	public ResourceLocation getCustomTexture(){
		return isTextureExternal ? ExternalTextureHelper.get(extex) : seltex;
	}

	@Override
	public String getCustomTextureString(){
		return isTextureExternal ? extex : seltex == null ? "" : seltex.toString();
	}

	@Override
	public boolean isExternalTexture(){
		return isTextureExternal;
	}

	public Pos getInstalledPos(){
		return currentpos;
	}
	
	public void setInstalledPos(Pos pos){
		this.currentpos = pos; return;
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

	@Override
	public void setSelectedTexture(int i, String tex, boolean ex){
		if(i < 0){
			this.isTextureExternal = ex; this.selected_texture = -1;
			this.seltex = ex ? null : new ResourceLocation(tex);
			this.extex = ex ? tex : null;
		}
		else{
			this.selected_texture = i >= type.getDefaultTextures().size() ? type.getDefaultTextures().size() - 1 : i;
			this.seltex = null; this.extex = null;
		}
	}

	@Override
	public TextureHolder getHolder(){
		return type;
	}
	
	public Map<String, Function> getFunctions(){
		return functions;
	}
	
	@SuppressWarnings("unchecked")
	public <F extends Function> F getFunction(String id){
		return (F)functions.get(id);
	}
	
	@SuppressWarnings("unchecked")
	public <F> F getFunction(Class<F> clazz, String id){
		return (F)functions.get(id);
	}
	
	public <F extends Function> F getFunction(ResourceLocation resloc){
		return this.getFunction(resloc.toString());
	}

	public boolean hasFunction(String string){
		return getFunction(string) != null;
	}

}
