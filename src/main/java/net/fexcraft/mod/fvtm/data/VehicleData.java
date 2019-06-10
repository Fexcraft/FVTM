package net.fexcraft.mod.fvtm.data;

import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Modifier;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleData extends DataCore<Vehicle, VehicleData> implements Colorable, Textureable {
	
	protected TreeMap<String, Attribute> attributes = new TreeMap<>();
	protected TreeMap<String, PartData> parts = new TreeMap<>();
	protected RGB primary, secondary;
	protected int lightstate, selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean isTextureExternal;

	public VehicleData(Vehicle type){
		super(type);
		for(Attribute attr : type.getBaseAttributes().values()){
			Attribute copy = attr.copy(null); attributes.put(copy.getId(), copy);
		}
		this.primary = type.primary.copy();
		this.secondary = type.secondary.copy();
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Vehicle", type.getRegistryName().toString());
		//
		NBTTagList list = new NBTTagList();
		for(Entry<String, PartData> part : parts.entrySet()){
			NBTTagCompound com = new NBTTagCompound();
			com.setString("InstalledAs", part.getKey());
			list.appendTag(part.getValue().write(com));
		}
		compound.setTag("Parts", list);
		compound.setInteger("SelectedTexture", selected_texture);
		if(seltex != null || extex != null || selected_texture < 0){
			compound.setString("CustomTexture", seltex == null ? extex : seltex.toString());
			compound.setBoolean("ExternalTexture", isTextureExternal);
		}
		return compound;
	}

	@Override
	public VehicleData read(NBTTagCompound compound){
		//if(!compound.hasKey("Vehicle")) return null;
		//type = Resources.getVehicle(compound.getString("Vehicle"));
		//if(type == null) return null;//TODO add "placeholder" for "missing" items
		//
		this.parts.clear();
		NBTTagList list = (NBTTagList)compound.getTag("Parts");
		if(list != null){
			for(NBTBase base : list){
				NBTTagCompound com = (NBTTagCompound)base; if(!com.hasKey("InstalledAs")) continue;
				this.parts.put(com.getString("InstalledAs"), Resources.getPartData(com));
			}
		}
		this.selected_texture = compound.getInteger("SelectedTexture");
		if(selected_texture < 0){
			isTextureExternal = compound.getBoolean("ExternalTexture");
			seltex = isTextureExternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
			extex = isTextureExternal ? compound.getString("CustomTexture") : null;
		}
		return this;
	}

	@Override
	public VehicleData parse(JsonObject obj){
		//ResourceLocation regname = DataUtil.getRegistryName("Vehicle", obj);
		//if(regname == null || Resources.getPart(regname) == null) return null;
		//this.type = Resources.getVehicle(regname);
		//
		return this;
	}

	@Override
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Vehicle", type.getRegistryName().toString());
		//
		return obj;
	}
	
	public Attribute getAttribute(String id){
		return attributes.get(id);
	}
	
	public TreeMap<String, Attribute> getAttributes(){
		return attributes;
	}
	
	/** @return null if installed successfully. */
	public PartData installPart(@Nullable ICommandSender engineer, PartData data, String category){
		if(!data.getType().getInstallationHandler().allowInstall(engineer, data, category, this)) return data;
		//if(parts.containsKey(category)) return data;//<- actually, let's let the handler check that
		if(data.getType().getInstallationHandler().processInstall(engineer, data, category, this)){
			this.insertAttributesFromPart(data, category);
			//
			this.parts.values().forEach(part -> part.resetAttributes(null));
			this.resetAttributes(null);
			//
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.UpdateCall.INITIAL, true));
			this.updateAttributes(Attribute.UpdateCall.INITIAL, true);
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.UpdateCall.INITIAL, false));
			this.updateAttributes(Attribute.UpdateCall.INITIAL, false);
			return null;
		} else return data;
	}

	public boolean deinstallPart(@Nullable ICommandSender sender, String category){
		PartData part = this.getPart(category);
		if(part == null){ Print.chatnn(sender, "No part in that category."); return false; }
		if(!part.getType().getInstallationHandler().allowUninstall(sender, part, category, this)) return false;
		if(part.getType().getInstallationHandler().processUninstall(sender, part, category, this)){
			this.removeAttributesFromPart(part, category);
			part.clearAttributes(); part.clearModifiers();
			//
			this.parts.values().forEach(data -> data.resetAttributes(null));
			this.resetAttributes(null);
			//
			this.parts.values().forEach(data -> data.updateAttributes(Attribute.UpdateCall.INITIAL, true));
			this.updateAttributes(Attribute.UpdateCall.INITIAL, true);
			this.parts.values().forEach(data -> data.updateAttributes(Attribute.UpdateCall.INITIAL, false));
			this.updateAttributes(Attribute.UpdateCall.INITIAL, false);
			return true;
		} else return false;
	}

	private void insertAttributesFromPart(PartData data, String catin){
		String dataid = catin + "|" + data.getType().getRegistryName().toString();
		for(Attribute attr : data.getType().getBaseAttributes()){
			/*if(attr.getTarget().startsWith("self") && !data.getAttributes().containsKey(attr.getId())){
				data.getAttributes().put(attr.getId(), attr.copy(dataid));
			}//this should actually happen on partdata construction else*/
			if(attr.getTarget().startsWith("part")){
				String id = attr.getTarget().replace("part:", "");
				if(!parts.containsKey(id)) continue;
				if(!parts.get(id).getAttributes().containsKey(id))
					parts.get(id).getAttributes().put(attr.getId(), attr.copy(dataid));
			}
			else if(attr.getTarget().startsWith("vehicle") && !this.getAttributes().containsKey(attr.getId())){
				if(attr.getTarget().contains("-")){
					String id = attr.getTarget().replace("vehicle-", "");
					if(this.getType().getRegistryName().toString().equals(id))
						this.getAttributes().put(attr.getId(), attr.copy(dataid));
				} else{ this.getAttributes().put(attr.getId(), attr.copy(dataid)); }
			}
		}
		//check if parts have attributes to add into other parts
		for(Entry<String, PartData> part : parts.entrySet()){
			if(part.getValue() == data) continue;
			String str = part.getKey() + "|" + part.getValue().getType().getRegistryName().toString();
			for(Attribute attr : part.getValue().getType().getBaseAttributes()){
				if(attr.getTarget().equals("part:" + catin)){
					if(!data.getAttributes().containsKey(attr.getId()))
						data.getAttributes().put(attr.getId(), attr.copy(str));
				}
			}
		}
		//add modifiers
		for(Modifier mod : data.getType().getBaseModifiers()){
			if(!mod.getTarget().contains(":")) continue;
			String[] target = mod.getTarget().split(":");
			if(target[0].equals("self")){
				if(data.getAttributes().containsKey(target[1])){
					data.getAttribute(target[1]).addModifier(mod.copy(dataid));
				}
			}
			else if(target[0].startsWith("part-")){
				if(target[0].replace("part-", "").equals(catin)){}
				else if(parts.containsKey(target[0].replace("part-", ""))){
					PartData part = parts.get(target[0].replace("part-", ""));
					if(part.getAttributes().containsKey(target[1])){
						part.getAttribute(target[1]).addModifier(mod.copy(dataid));
					}
				}
			}
			else if(target[0].startsWith("vehicle")){
				if(this.getAttributes().containsKey(target[1])){
					this.getAttributes().get(target[1]).addModifier(mod.copy(dataid));
				}
			}
		}
		for(Entry<String, PartData> part : parts.entrySet()){
			if(part.getValue() == data) continue;
			for(Modifier mod : part.getValue().getType().getBaseModifiers()){
				String str = part.getKey() + "|" + part.getValue().getType().getRegistryName().toString();
				if(mod.getTarget().startsWith("part-" + catin + ":")){
					String target = mod.getTarget().split(":")[1];
					if(data.getAttributes().containsKey(target))
						data.getAttribute(target).addModifier(mod.copy(str));
				}
			}
		}
	}

	private void removeAttributesFromPart(PartData data, String category){
		String datain = category = data.getType().getRegistryName().toString();
		for(PartData part : this.parts.values()){
			part.getAttributes().entrySet().removeIf(pre -> pre.getValue().getOrigin().equals(datain));
			for(Attribute attr : part.getAttributes().values()){
				attr.getModifiers().removeIf(pre -> pre.getOrigin().equals(datain));
			}
		}
		this.attributes.entrySet().removeIf(pre -> pre.getValue().getOrigin().equals(datain));
		for(Attribute attr : this.attributes.values()){
			attr.getModifiers().removeIf(pre -> pre.getOrigin().equals(datain));
		}
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
		for(Attribute attr : type.getBaseAttributes().values()){
			if(!attr.getTarget().startsWith("self")) continue;
			Attribute copy = attr.copy(null); attributes.put(copy.getId(), copy);
		}
	}

	public void clearModifiers(){
		for(Attribute attr : attributes.values()) attr.getModifiers().clear();
	}
	
	public java.util.Map<String, PartData> getParts(){
		return parts;
	}
	
	public PartData getPart(String string){
		return parts.get(string);
	}

	public int getLightsState(){
		return lightstate;
	}

	//TODO
	public double getThrottle(){
		return attributes.containsKey("throttle") ? attributes.get("throttle").getCurrentFloat() : 0;
	}

	@Override
	public RGB getPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getSecondaryColor(){
		return secondary;
	}

	@Override
	public void setPrimaryColor(RGB color){
		this.primary = color;
	}

	@Override
	public void setSecondaryColor(RGB color){
		this.secondary = color;
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
	public boolean isExternalTexture(){
		return isTextureExternal;
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

}
