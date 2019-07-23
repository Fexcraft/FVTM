package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Modifier;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.function.SeatsFunction;
import net.fexcraft.mod.fvtm.util.function.WheelPositionsFunction;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleData extends DataCore<Vehicle, VehicleData> implements Colorable, Textureable, Lockable {
	
	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();
	protected TreeMap<String, PartData> parts = new TreeMap<>();
	protected RGB primary, secondary;
	protected int lightstate, selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean isTextureExternal, locked;
	protected TreeMap<String, WheelSlot> wheels = new TreeMap<>();
	protected TreeMap<String, Vec3d> wheelpos = new TreeMap<>();
	protected ArrayList<Seat> seats = new ArrayList<>();
	protected ArrayList<String> inventories = new ArrayList<>();

	public VehicleData(Vehicle type){
		super(type);
		for(Attribute<?> attr : type.getBaseAttributes().values()){
			Attribute<?> copy = attr.copy(null); attributes.put(copy.id(), copy);
		}
		for(Entry<String, WheelSlot> entry: type.getDefaultWheelPositions().entrySet()){
			this.wheels.put(entry.getKey(), entry.getValue().copy());
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
		//
		NBTTagList alist = new NBTTagList();
		for(Attribute<?> attr : attributes.values()){ alist.appendTag(attr.write(new NBTTagCompound())); }
		compound.setTag("Attributes", alist);
		//
		compound.setInteger("SelectedTexture", selected_texture);
		if(seltex != null || extex != null || selected_texture < 0){
			compound.setString("CustomTexture", seltex == null ? extex : seltex.toString());
			compound.setBoolean("ExternalTexture", isTextureExternal);
		}
		compound.setInteger("RGBPrimary", primary.packed);
		compound.setInteger("RGBSecondary", secondary.packed);
		NBTTagList wlist = new NBTTagList();
		for(Entry<String, WheelSlot> entry : wheels.entrySet()){
			NBTTagCompound com = new NBTTagCompound();
			com.setString("id", entry.getKey());
			entry.getValue().write(com);
			wlist.appendTag(com);
		}
		compound.setTag("WheelSlots", wlist);
		wlist = new NBTTagList();
		for(Entry<String, Vec3d> vec : wheelpos.entrySet()){
			NBTTagCompound com = new NBTTagCompound();
			com.setString("id", vec.getKey());
			com.setDouble("pos_x", vec.getValue().x);
			com.setDouble("pos_y", vec.getValue().y);
			com.setDouble("pos_z", vec.getValue().z);
			wlist.appendTag(com);
		}
		compound.setTag("WheelPos", wlist);
		compound.setBoolean("Locked", locked);
		/*Print.debug("write", compound);*/ return compound;
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
		//
		NBTTagList alist = (NBTTagList)compound.getTag("Attributes");
		if(alist != null){
			for(NBTBase base : alist){
				NBTTagCompound com = (NBTTagCompound)base; if(!com.hasKey("id")) continue;
				Attribute<?> attr = getAttribute(com.getString("id")); if(attr != null){ attr.read(com); }
				else{ attr = Attribute.parse(com); if(attr != null) attributes.put(attr.id(), attr); }
			}
		}
		//
		this.selected_texture = compound.getInteger("SelectedTexture");
		if(selected_texture < 0){
			isTextureExternal = compound.getBoolean("ExternalTexture");
			seltex = isTextureExternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
			extex = isTextureExternal ? compound.getString("CustomTexture") : null;
		} else{ seltex = null; extex = null; isTextureExternal = false; }
		if(compound.hasKey("RGBPrimary")) primary.packed = compound.getInteger("RGBPrimary");
		if(compound.hasKey("RGBSecondary")) secondary.packed = compound.getInteger("RGBSecondary");
		//
		this.refreshModificableDataByParts();
		//
		NBTTagList wlist = (NBTTagList)compound.getTag("WheelSlots");
		if(wlist != null){
			for(NBTBase base : wlist){
				NBTTagCompound com = (NBTTagCompound)base;
				WheelSlot slot = wheels.get(com.getString("id"));
				if(slot != null) slot.read(com); else continue;
			}
		}
		wlist = (NBTTagList)compound.getTag("WheelPos");
		if(wlist != null){ wheelpos.clear();
			for(NBTBase base : wlist){
				NBTTagCompound com = (NBTTagCompound)base;
				wheelpos.put(com.getString("id"), new Vec3d(com.getDouble("pos_x"), com.getDouble("pos_y"), com.getDouble("pos_z")));
			}
		}
		this.locked = compound.getBoolean("Locked");
		//
		/*Print.debug("read", compound);*/ return this;
	}

	private void refreshModificableDataByParts(){
		this.wheels.clear(); type.getDefaultWheelPositions().entrySet().forEach(entry -> wheels.put(entry.getKey(), entry.getValue().copy()));
		for(PartData part : parts.values()){
			if(part.hasFunction("fvtm:wheel_positions")){
				WheelPositionsFunction func = part.getFunction("fvtm:wheel_positions");
				func.getPositions().entrySet().forEach(entry -> wheels.put(entry.getKey(), entry.getValue().copy()));
			}
		}
		//
		this.seats.clear();
		for(PartData part : parts.values()){
			if(!part.hasFunction("fvtm:seats")) continue;
			seats.addAll(part.getFunction(SeatsFunction.class, "fvtm:seats").getSeats());
		}
		//
		inventories.clear(); parts.forEach((key, value) -> { if(value.hasFunction("fvtm:inventory")) inventories.add(key); });
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
	
	/** @return null if installed successfully. */
	public PartData installPart(@Nullable ICommandSender engineer, PartData data, String category){
		if(!data.getType().getInstallationHandler().allowInstall(engineer, data, category, this)) return data;
		//if(parts.containsKey(category)) return data;//<- actually, let's let the handler check that
		if(data.getType().getInstallationHandler().processInstall(engineer, data, category, this)){
			this.insertAttributesFromPart(data, category);
			//
			this.parts.values().forEach(part -> part.resetAttributes());
			this.resetAttributes();
			//
			this.parts.values().forEach(part -> part.updateAttributes(Attribute.Update.INITIAL));
			this.updateAttributes(Attribute.Update.INITIAL);
			//
			this.refreshModificableDataByParts();
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
			this.parts.values().forEach(data -> data.resetAttributes());
			this.resetAttributes();
			//
			this.parts.values().forEach(data -> data.updateAttributes(Attribute.Update.INITIAL));
			this.updateAttributes(Attribute.Update.INITIAL);
			//
			this.refreshModificableDataByParts();
			return true;
		} else return false;
	}

	private void insertAttributesFromPart(PartData data, String catin){
		String dataid = catin + "|" + data.getType().getRegistryName().toString();
		for(Attribute<?> attr : data.getType().getBaseAttributes()){
			/*if(attr.getTarget().startsWith("self") && !data.getAttributes().containsKey(attr.getId())){
				data.getAttributes().put(attr.getId(), attr.copy(dataid));
			}//this should actually happen on partdata construction else*/
			if(attr.target().startsWith("part")){
				String id = attr.target().replace("part:", "");
				if(!parts.containsKey(id)) continue;
				if(!parts.get(id).getAttributes().containsKey(id))
					parts.get(id).getAttributes().put(attr.id(), attr.copy(dataid));
			}
			else if(attr.target().startsWith("vehicle") && !this.getAttributes().containsKey(attr.id())){
				if(attr.target().contains("-")){
					String id = attr.target().replace("vehicle-", "");
					if(this.getType().getRegistryName().toString().equals(id))
						this.getAttributes().put(attr.id(), attr.copy(dataid));
				} else{ this.getAttributes().put(attr.id(), attr.copy(dataid)); }
			}
		}
		Print.console(data.getType().getBaseAttributes());
		Print.console(attributes);
		//check if parts have attributes to add into other parts
		for(Entry<String, PartData> part : parts.entrySet()){
			if(part.getValue() == data) continue;
			String str = part.getKey() + "|" + part.getValue().getType().getRegistryName().toString();
			for(Attribute<?> attr : part.getValue().getType().getBaseAttributes()){
				if(attr.target().equals("part:" + catin)){
					if(!data.getAttributes().containsKey(attr.id()))
						data.getAttributes().put(attr.id(), attr.copy(str));
				}
			}
		}
		//add modifiers
		for(Modifier<?> mod : data.getType().getBaseModifiers()){
			if(!mod.target().contains(":")) continue;
			String[] target = mod.target().split(":");
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
			for(Modifier<?> mod : part.getValue().getType().getBaseModifiers()){
				String str = part.getKey() + "|" + part.getValue().getType().getRegistryName().toString();
				if(mod.target().startsWith("part-" + catin + ":")){
					String target = mod.target().split(":")[1];
					if(data.getAttributes().containsKey(target))
						data.getAttribute(target).addModifier(mod.copy(str));
				}
			}
		}
	}

	private void removeAttributesFromPart(PartData data, String category){
		String datain = category + "|" + data.getType().getRegistryName().toString();
		for(PartData part : this.parts.values()){
			part.getAttributes().entrySet().removeIf(pre -> pre.getValue().origin() != null && pre.getValue().origin().equals(datain));
			for(Attribute<?> attr : part.getAttributes().values()){
				attr.getModifiers().removeIf(pre -> pre.origin() != null && pre.origin().equals(datain));
			}
		}
		this.attributes.entrySet().removeIf(pre -> pre.getValue().origin() != null && pre.getValue().origin().equals(datain));
		for(Attribute<?> attr : this.attributes.values()){
			attr.getModifiers().removeIf(pre -> pre.origin() != null && pre.origin().equals(datain));
		}
	}

	public void resetAttributes(){
		for(Attribute<?> attr : attributes.values()){ attr.reset(); }
	}

	public void updateAttributes(Attribute.Update call){
		for(Attribute<?> attr : attributes.values()){ attr.updateValue(call); }
	}

	public void clearAttributes(){
		if(!attributes.isEmpty()) attributes.clear();
		for(Attribute<?> attr : type.getBaseAttributes().values()){
			if(!attr.target().startsWith("self")) continue;
			Attribute<?> copy = attr.copy(null); attributes.put(copy.id(), copy);
		}
	}

	public void clearModifiers(){
		for(Attribute<?> attr : attributes.values()) attr.getModifiers().clear();
	}
	
	public java.util.Map<String, PartData> getParts(){
		return parts;
	}
	
	public PartData getPart(String string){
		return parts.get(string);
	}

	public boolean hasPart(String string){
		return getPart(string) != null;
	}

	public int getLightsState(){
		return lightstate;
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
	public String getCustomTextureString(){
		return isTextureExternal ? extex : seltex.toString();
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

	@Override
	public TextureHolder getHolder(){
		return type;
	}
	
	public TreeMap<String, WheelSlot> getWheelSlots(){
		return wheels;
	}
	
	public TreeMap<String, Vec3d> getWheelPositions(){
		return wheelpos;
	}

	public List<Seat> getSeats(){
		return seats;
	}

	public Seat getSeat(String id){
		for(Seat seat : seats) if(seat.name.equals(id)) return seat; return null;
	}

	public Seat getSeat(int index){
		return index < 0 ? null : index >= seats.size() ? null : seats.get(index);
	}

	@Override
	public boolean isLocked(){
		return locked;
	}

	public double getThrottle(){
		return getAttribute("throttle").getFloatValue();
	}

	public ArrayList<String> getInventories(){
		return inventories;
	}

}
