package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleData extends DataCore<Vehicle, VehicleData> implements Colorable, Textureable {
	
	protected TreeMap<String, Attribute> attributes = new TreeMap<>();
	protected TreeMap<String, PartData> parts = new TreeMap<>();
	protected RGB primary, secondary;
	protected int lightstate, selected_texture;
	protected String external_texture;
	protected ResourceLocation seltex;
	protected boolean isTextureExternal;

	public VehicleData(Vehicle type){
		super(type);
		for(Attribute attr : type.getBaseAttributes().values()){
			Attribute copy = attr.copy(); attributes.put(copy.getId(), copy);
		}
		this.primary = type.primary.copy();
		this.secondary = type.secondary.copy();
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Vehicle", type.getRegistryName().toString());
		//
		return compound;
	}

	@Override
	public VehicleData read(NBTTagCompound compound){
		//if(!compound.hasKey("Vehicle")) return null;
		//type = Resources.getVehicle(compound.getString("Vehicle"));
		//if(type == null) return null;//TODO add "placeholder" for "missing" items
		//
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
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.UpdateCall.INSTALL, true));
			this.updateAttributes(Attribute.UpdateCall.INSTALL, true);
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.UpdateCall.INSTALL, false));
			this.updateAttributes(Attribute.UpdateCall.INSTALL, false);
			return null;
		}
		else return data;
	}

	private void insertAttributesFromPart(PartData data, String category_in){
		data.getType().getBaseAttributes().forEach(attr -> {
			if(attr.getTarget().startsWith("self")){
				if(!data.getAttributes().containsKey(attr.getId()))
					data.getAttributes().put(attr.getId(), attr.copy());
			}
			else if(attr.getTarget().startsWith("part")){
				String id = attr.getTarget().replace("part:", "");
				if(parts.containsKey(id)){
					if(!parts.get(id).getAttributes().containsKey(id))
						parts.get(id).getAttributes().put(attr.getId(), attr.copy());
				}
			}
			else if(attr.getTarget().startsWith("vehicle")){
				if(attr.getTarget().contains("-")){
					String id = attr.getTarget().replace("vehicle-", "");
					if(this.getType().getRegistryName().toString().equals(id))
						this.getAttributes().put(attr.getId(), attr.copy());
				}
				else{
					if(!this.getAttributes().containsKey(attr.getId()))
						this.getAttributes().put(attr.getId(), attr.copy());
				}
			}
		});
		//check if parts have attributes to add into other parts
		for(PartData part : parts.values()){
			if(part == data) continue;
			part.getType().getBaseAttributes().forEach(attr -> {
				if(attr.getTarget().equals("part:" + category_in)){
					if(!data.getAttributes().containsKey(attr.getId()))
						data.getAttributes().put(attr.getId(), attr.copy());
				}
			});
		}
		//add modifiers
		data.getType().getBaseModifiers().forEach(mod -> {
			if(mod.getTarget().contains(":")){
				String[] target = mod.getTarget().split(":");
				if(target[0].equals("self")){
					if(data.getAttributes().containsKey(target[1])){
						data.getAttribute(target[1]).addModifier(mod.copy());
					}
				}
				else if(target[0].startsWith("part-")){
					if(target[0].replace("part-", "").equals(category_in)){}
					else if(parts.containsKey(target[0].replace("part-", ""))){
						PartData part = parts.get(target[0].replace("part-", ""));
						if(part.getAttributes().containsKey(target[1])){
							part.getAttribute(target[1]).addModifier(mod.copy());
						}
					}
				}
				else if(target[0].startsWith("vehicle")){
					if(this.getAttributes().containsKey(target[1])){
						this.getAttributes().get(target[1]).addModifier(mod.copy());
					}
				}
			}
		});
		for(PartData part : parts.values()){ if(part == data) continue;
			part.getType().getBaseModifiers().forEach(mod -> {
				if(mod.getTarget().startsWith("part-" + category_in + ":")){
					String target = mod.getTarget().split(":")[1];
					if(data.getAttributes().containsKey(target))
						data.getAttribute(target).addModifier(mod.copy());
				}
			});
		}
	}

	public boolean deinstallPart(@Nullable ICommandSender sender, String category){
		PartData part = this.getPart(category);
		if(part == null){ Print.chatnn(sender, "No part in that category."); return false; }
		if(!part.getType().getInstallationHandler().allowUninstall(sender, part, category, this)) return false;
		if(part.getType().getInstallationHandler().processUninstall(sender, part, category, this)){
			/*this.insertAttributesFromPart(data, category);
			//
			this.parts.values().forEach(part -> part.resetAttributes(null));
			this.resetAttributes(null);
			//
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.UpdateCall.UNINSTALL, true));
			this.updateAttributes(Attribute.UpdateCall.UNINSTALL, true);
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.UpdateCall.UNINSTALL, false));
			this.updateAttributes(Attribute.UpdateCall.UNINSTALL, false);*/
			//TODO
			return true;
		} else return false;
	}

	public void resetAttributes(Boolean bool){
		if(bool == null || bool){ for(Attribute attr : attributes.values()){ attr.resetBaseValue(); } }
		if(bool == null || !bool){ for(Attribute attr : attributes.values()){ attr.resetCurrentValue(); } }
	}

	public void updateAttributes(UpdateCall call, Boolean bool){
		for(Attribute attr : attributes.values()){ attr.updateValue(call, bool); }
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
		return isTextureExternal ? ExternalTextureHelper.get(external_texture) : seltex;
	}

	@Override
	public boolean isExternalTexture(){
		return isTextureExternal;
	}

}
