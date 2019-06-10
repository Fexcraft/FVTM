package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartData extends DataCore<Part, PartData> implements Textureable {
	
	protected TreeMap<String, Attribute> attributes = new TreeMap<>();
	protected int selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean isTextureExternal;
	protected Pos currentpos = new Pos(0, 0, 0);

	public PartData(Part type){
		super(type); this.clearAttributes();
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Part", type.getRegistryName().toString());
		currentpos.toNBT("CurrentPos", compound);
		//
		return compound;
	}

	@Override
	public PartData read(NBTTagCompound compound){
		//if(!compound.hasKey("Part")) return null;
		//type = Resources.getPart(compound.getString("Part"));
		//if(type == null) return null;//TODO add "placeholder" for "missing" items
		currentpos = Pos.fromNBT("CurrentPos", compound);
		//
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
	
	public Attribute getAttribute(String id){
		return attributes.get(id);
	}
	
	public TreeMap<String, Attribute> getAttributes(){
		return attributes;
	}

	public void resetAttributes(Boolean bool){
		if(bool == null || bool){ for(Attribute attr : attributes.values()){ attr.resetBaseValue(); } }
		if(bool == null || !bool){ for(Attribute attr : attributes.values()){ attr.resetCurrentValue(); } }
	}

	public void updateAttributes(UpdateCall call, Boolean bool){
		for(Attribute attr : attributes.values()){ attr.updateValue(call, bool); }
	}

	public void clearAttributes(){
		if(!attributes.isEmpty()) attributes.clear();
		for(Attribute attr : type.getBaseAttributes()){
			if(!attr.getTarget().startsWith("self")) continue;
			Attribute copy = attr.copy(null); attributes.put(copy.getId(), copy);
		}
	}

	public void clearModifiers(){
		for(Attribute attr : attributes.values()) attr.getModifiers().clear();
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
		return isTextureExternal ? extex : seltex.toString();
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

	@Override
	public void setSelectedTexture(int i, String tex, boolean ex){
		if(i < 0){
			this.isTextureExternal = ex;
			this.seltex = ex ? null : new ResourceLocation(tex);
			this.extex = ex ? tex : null;
		}
		else{
			this.selected_texture = i >= type.getDefaultTextures().size() ? type.getDefaultTextures().size() - 1 : i; 
		}
	}

}
