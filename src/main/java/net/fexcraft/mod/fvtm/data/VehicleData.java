package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class VehicleData extends DataCore<Vehicle, VehicleData> implements Colorable {
	
	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();
	protected TreeMap<String, PartData> parts = new TreeMap<>();
	protected RGB primary, secondary;
	protected int lightstate;

	public VehicleData(Vehicle type){
		super(type);
		for(Attribute<?> attr : type.getAttributes().values()){
			Attribute<?> copy = attr.copy(); attributes.put(copy.getId(), copy);
		}
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
		if(!compound.hasKey("Vehicle")) return null;
		type = Resources.getVehicle(compound.getString("Vehicle"));
		if(type == null) return null;//TODO add "placeholder" for "missing" items
		//
		return this;
	}

	@Override
	public VehicleData parse(JsonObject obj){
		ResourceLocation regname = DataUtil.getRegistryName("Vehicle", obj);
		if(regname == null || Resources.getPart(regname) == null) return null;
		this.type = Resources.getVehicle(regname);
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
	
	@SuppressWarnings("unchecked")
	public <ATTR extends Attribute<?>> ATTR getAttribute(String id){
		return (ATTR)attributes.get(id);
	}
	
	public TreeMap<String, Attribute<?>> getAttributes(){
		return attributes;
	}
	
	/** @return null if installed successfully. */
	public PartData installPart(PartData data, String category){
		//TODO check if part can be installed here
		if(parts.containsKey(category)) return data;
		//check if should add new attributes
		data.getType().getAttributes().forEach(attr -> {
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
			part.getType().getAttributes().forEach(attr -> {
				if(attr.getTarget().equals("part:" + category)){
					if(!data.getAttributes().containsKey(attr.getId()))
						data.getAttributes().put(attr.getId(), attr.copy());
				}
			});
		}
		parts.put(category, data);
		//add modifiers
		data.getType().getAttributeModifiers().forEach(mod -> {
			if(mod.getTarget().contains(":")){
				String[] target = mod.getTarget().split(":");
				if(target[0].equals("self")){
					if(data.getAttributes().containsKey(target[1])){
						data.getAttribute(target[1]).addModifier(mod.copy());
					}
				}
				else if(target[0].startsWith("part-")){
					if(target[0].replace("part-", "").equals(category)){}
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
			part.getType().getAttributeModifiers().forEach(mod -> {
				if(mod.getTarget().startsWith("part-" + category + ":")){
					String target = mod.getTarget().split(":")[1];
					if(data.getAttributes().containsKey(target))
						data.getAttribute(target).addModifier(mod.copy());
				}
			});
		}
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
	
	public void deinstallPart(String category){
		//TODO general code
		//TODO also see about removing attributes related to that part
	}

	public void resetAttributes(Boolean bool){
		if(bool == null || bool){ for(Attribute<?> attr : attributes.values()){ attr.resetBaseValue(); } }
		if(bool == null || !bool){ for(Attribute<?> attr : attributes.values()){ attr.resetCurrentValue(); } }
	}

	public void updateAttributes(UpdateCall call, Boolean bool){
		for(Attribute<?> attr : attributes.values()){ attr.updateValue(call, bool); }
	}

	public int getLightsState(){
		return lightstate;
	}

	//TODO
	public double getThrottle(){
		return 0;
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

}
