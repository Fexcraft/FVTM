package net.fexcraft.mod.fvtm.data.vehicle;

import static net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots.VEHPARTSLOTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.NBTToJson;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.attribute.AttrUpdate;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.Modifier;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.root.Soundable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.function.ColorFunction;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.PartSlotsFunction;
import net.fexcraft.mod.fvtm.util.function.SeatsFunction;
import net.fexcraft.mod.fvtm.util.function.WheelPositionsFunction;
import net.fexcraft.mod.fvtm.util.script.FSVehicleScript;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleData extends DataCore<Vehicle, VehicleData> implements Colorable, Lockable, Soundable, TextureUser {
	
	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();
	protected TreeMap<String, PartData> parts = new TreeMap<>();
	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected Textureable texture;
	protected String preset, lockcode;
	protected boolean locked;
	protected TreeMap<String, WheelSlot> wheels = new TreeMap<>();
	protected TreeMap<String, Vec3d> wheelpos = new TreeMap<>();
	protected ArrayList<Seat> seats = new ArrayList<>();
	protected ArrayList<String> inventories = new ArrayList<>();
	protected ArrayList<VehicleScript> scripts = new ArrayList<>();
	protected Vec3d front_conn, rear_conn;
	protected TreeMap<String, Sound> sounds = new TreeMap<>();
	protected TreeMap<String, SwivelPoint> rotpoints = new TreeMap<>();
	protected TreeMap<String, PartSlots> psproviders = new TreeMap<>();
	protected SwivelPoint rootpoint;
	protected String displayname;

	public VehicleData(Vehicle type){
		super(type);
		texture = new Textureable(type);
		rotpoints.put("vehicle", rootpoint = new SwivelPoint("vehicle", null));
		for(SwivelPoint point : type.getDefaultSwivelPoints().values()){
			rotpoints.put(point.id, point.clone(null));
		}
		for(Attribute<?> attr : type.getBaseAttributes().values()){
			Attribute<?> copy = attr.copy(null);
			attributes.put(copy.id(), copy);
		}
		for(Entry<String, WheelSlot> entry: type.getDefaultWheelPositions().entrySet()){
			this.wheels.put(entry.getKey(), entry.getValue().copy(null));
		}
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
		this.front_conn = type.getDefaultFrontConnector();
		this.rear_conn = type.getDefaultRearConnector();
		if(type.getPreInstalledParts() != null){
			for(java.util.Map.Entry<String, ResourceLocation> entry : type.getPreInstalledParts().entrySet()){
				try{
					Part part = Resources.PARTS.get(entry.getValue());
					if(part == null) continue;
					this.installPart(null, new PartData(part), entry.getKey(), false);
				}
				catch(Exception e){
					e.printStackTrace();
					Static.stop();
				}
			}
		}
		rotpoints.values().forEach(point -> point.linkToParent(this));
		sounds.putAll(type.getSounds());
		psproviders.put(VEHPARTSLOTS, type.getPartSlots());
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
		for(Attribute<?> attr : attributes.values()){
			alist.appendTag(attr.write(new NBTTagCompound()));
		}
		compound.setTag("Attributes", alist);
		//
		texture.save(compound);
		for(String str : channels.keySet()){
			compound.setInteger("RGB_" + str, channels.get(str).packed);
		}
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
		if(!scripts.isEmpty()){
			NBTTagList scrap = new NBTTagList();
			for(VehicleScript script : scripts){
				NBTTagCompound com = script.write(this, new NBTTagCompound());
				if(com != null && !com.isEmpty()){
					com.setString("id", script.getId());
					scrap.appendTag(com);
				}
			}
			if(!scrap.isEmpty()) compound.setTag("Scripts", scrap);
		}
		if(!rotpoints.isEmpty()){
			NBTTagList points = new NBTTagList();
			for(SwivelPoint point : rotpoints.values()){
				if(point.id.equals("vehicle")) continue;
				points.appendTag(point.write(new NBTTagCompound()));
			}
			if(!points.isEmpty()) compound.setTag("SwivelPoints", points);
		}
		compound.setBoolean("Locked", locked);
		if(front_conn != null) compound.setTag("FrontConnector", DataUtil.writeVec3d(front_conn));
		if(rear_conn != null) compound.setTag("RearConnector", DataUtil.writeVec3d(rear_conn));
		//if(customname != null) compound.setString("CustomName", customname);
		if(preset != null) compound.setString("Preset", preset);
		if(displayname != null) compound.setString("DisplayName", displayname);
		if(lockcode != null) compound.setString("LockCode", lockcode);
		/*Print.debug("write", compound);*/ return compound;
	}

	@Override
	public VehicleData read(NBTTagCompound compound){
		//if(!compound.hasKey("Vehicle")) return null;
		//type = Resources.getVehicle(compound.getString("Vehicle"));
		//if(type == null) return null;//TODO add "placeholder" for "missing" items
		//
		//this.parts.entrySet().removeIf(pre -> !type.preinstalled.containsKey(pre.getKey()));
		NBTTagList list = (NBTTagList)compound.getTag("Parts");
		if(list != null){
			parts.clear();
			for(NBTBase base : list){
				NBTTagCompound com = (NBTTagCompound)base; if(!com.hasKey("InstalledAs")) continue;
				PartData data = Resources.getPartData(com);
				if(data != null) this.parts.put(com.getString("InstalledAs"), data);
			}
		}
		//
		NBTTagList alist = (NBTTagList)compound.getTag("Attributes");
		if(alist != null){
			for(NBTBase base : alist){
				NBTTagCompound com = (NBTTagCompound)base; if(!com.hasKey("id")) continue;
				if(com.getString("id").startsWith("turn_light_")) continue;
				Attribute<?> attr = getAttribute(com.getString("id"));
				if(attr != null){
					attr.read(com);
				}
				else{
					attr = Attribute.parse(com);
					if(attr != null) attributes.put(attr.id(), attr);
				}
			}
		}
		for(Attribute<?> attr : type.getBaseAttributes().values()){
			if(!attributes.containsKey(attr.id())){
				Attribute<?> copy = attr.copy(null);
				attributes.put(copy.id(), copy);
			}
			attributes.get(attr.id()).copyAABBs(attr).external(attr.external()).perm(attr.perm());
		}
		if(Static.isClient()) for(Attribute<?> attr : attributes.values()) attr.genDefaultIcons();
		//
		texture.load(compound, type);
		//
		if(compound.hasKey("RGBPrimary")){
			channels.get("primary").packed = compound.getInteger("RGBPrimary");
		}
		if(compound.hasKey("RGBSecondary")){
			channels.get("secondary").packed = compound.getInteger("RGBSecondary");
		}
		for(String str : channels.keySet()){
			if(compound.hasKey("RGB_" + str)){
				channels.get(str).packed = compound.getInteger("RGB_" + str);
			}
		}
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
		NBTTagList scrap = (NBTTagList)compound.getTag("Scripts");
		if(scrap != null){
			for(NBTBase base : scrap){
				NBTTagCompound com = (NBTTagCompound)base;
				if(getVehicleScript(com.getString("id")) != null) getVehicleScript(com.getString("id")).read(this, com);
			}
		}
		NBTTagList points = (NBTTagList)compound.getTag("SwivelPoints");
		if(points != null){
			for(NBTBase base : points){
				NBTTagCompound com = (NBTTagCompound)base;
				if(rotpoints.containsKey(com.getString("id"))){
					rotpoints.get(com.getString("id")).read(null, this, com);
				}
				else{
					SwivelPoint point = new SwivelPoint(this, com);
					rotpoints.put(point.id, point);
				}
			}
		}
		rotpoints.values().forEach(point -> point.linkToParent(this));
		this.locked = compound.getBoolean("Locked");
		this.front_conn = DataUtil.readVec3d(compound.getTag("FrontConnector"));
		if(front_conn == null) front_conn = type.getDefaultFrontConnector();
		this.rear_conn = DataUtil.readVec3d(compound.getTag("RearConnector"));
		if(rear_conn == null) rear_conn = type.getDefaultRearConnector();
		//if(compound.hasKey("CustomName")) customname = compound.getString("CustomName");
		if(compound.hasKey("Preset")) preset = compound.getString("Preset"); else preset = null;
		if(compound.hasKey("DisplayName")) displayname = compound.getString("DisplayName");
		lockcode = compound.hasKey("LockCode") ? compound.getString("LockCode") : Lockable.newCode();
		//
		/*Print.debug("read", compound);*/ return this;
	}

	private void refreshModificableDataByParts(){
		this.wheels.clear();
		type.getDefaultWheelPositions().entrySet().forEach(entry -> wheels.put(entry.getKey(), entry.getValue().copy(null)));
		for(PartData part : parts.values()){
			if(part.hasFunction("fvtm:wheel_positions")){
				WheelPositionsFunction func = part.getFunction("fvtm:wheel_positions");
				func.getPositions().entrySet().forEach(entry -> wheels.put(entry.getKey(), entry.getValue().copy(part.getInstalledPos())));
			}
		}
		//
		this.seats.clear();
		for(PartData part : parts.values()){
			if(!part.hasFunction("fvtm:seats")) continue;
			for(Seat seat : part.getFunction(SeatsFunction.class, "fvtm:seats").getSeats()){
				seats.add(seat.relative ? seat.copy(part.getInstalledPos()) : seat);
			}
		}
		//colors
		TreeMap<String, RGB> chan = new TreeMap<>(channels);
		channels.clear();
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
		for(PartData part : parts.values()){
			if(!part.hasFunction("fvtm:color")) continue;
			TreeMap<String, RGB> colors = part.getFunction(ColorFunction.class, "fvtm:color").getColors();
			for(Entry<String, RGB> entry : colors.entrySet()){
				if(!channels.containsKey(entry.getKey())){
					channels.put(entry.getKey(), entry.getValue().copy());
				}
			}
		}
		for(Entry<String, RGB> entry : chan.entrySet()){
			if(channels.containsKey(entry.getKey())){
				channels.get(entry.getKey()).packed = entry.getValue().packed;
			}
		}
		//
		inventories.clear();
		parts.forEach((key, value) -> {
			if(value.hasFunction("fvtm:inventory")) inventories.add(key);
		});
		//
		sounds.clear(); sounds.putAll(type.getSounds());
		for(PartData data : parts.values()){
			for(Map.Entry<String, Sound> entry : data.getType().getSounds().entrySet()){
				if(!sounds.containsKey(entry.getKey()) || entry.getValue().override) sounds.put(entry.getKey(), entry.getValue());
			}
		}
		//
		for(PartData part : parts.values()){
			if(part.getType().getVehicleScripts().size() > 0){
				for(int i = 0; i < part.getType().getVehicleScripts().size(); i++){
					try{
						Class<? extends VehicleScript> clazz = part.getType().getVehicleScripts().get(i);
						VehicleScript scrapt = clazz.newInstance();
						if(scrapt instanceof FSVehicleScript){
							((FSVehicleScript)scrapt).set(part.getType().getVehicleScriptsData().get(i));
						}
						String id = scrapt.getId();
						boolean found = false;
						for(VehicleScript script : scripts){
							if(script.getId().equals(id)){
								found = true;
								break;
							}
						}
						if(!found) scripts.add(clazz.newInstance().init(this, part.getType().getVehicleScriptsData().get(i)));
					}
					catch(InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e){
						e.printStackTrace();
					}
				}
			}
		}
		//
		for(Attribute<?> attr : attributes.values()){
			if(attr.origin() == null) continue;
			String origin = attr.origin().split("\\|")[0];
			PartData part = parts.get(origin);
			if(part == null) continue;
			for(Attribute<?> ettr : part.getType().getBaseAttributes()){
				if(ettr.id().equals(attr.id())){
					attr.copyAABBs(ettr);
					attr.external(ettr.external());
					break;
				}
			}
		}
		//
		psproviders.clear();
		if(!type.getPartSlots().isEmpty()) psproviders.put(VEHPARTSLOTS, type.getPartSlots());
		for(Entry<String, PartData> data : this.getParts().entrySet()){
			if(data.getValue().hasFunction("fvtm:part_slots")){
				PartSlots ps = data.getValue().getFunction(PartSlotsFunction.class, "fvtm:part_slots").getPartSlotss();
				if(!ps.isEmpty()) psproviders.put(data.getKey(), ps);
			}
		}
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
		return NBTToJson.getJsonFromTag(write(null));
	}
	
	public Attribute<?> getAttribute(String id){
		return attributes.get(id);
	}
	
	public <VAL> Attribute<VAL> getAttributeCasted(String id){
		return (Attribute<VAL>)attributes.get(id);
	}
	
	public TreeMap<String, Attribute<?>> getAttributes(){
		return attributes;
	}

	/** Null-Safe attribute value check. Works with tri-state attributes too. */
	public Boolean getAttributeBoolean(String id, boolean def){
		Attribute<?> attr = getAttribute(id);
		return attr == null ? def : attr.tristate_value();
	}

	/** Null-Safe attribute value check. Works with integer attributes too. */
	public float getAttributeFloat(String id, float def){
		Attribute<?> attr = getAttribute(id);
		return attr == null ? def : attr.float_value();
	}

	/** Null-Safe attribute value check. */
	public int getAttributeInteger(String id, int def){
		Attribute<?> attr = getAttribute(id);
		return attr == null ? def : attr.integer_value();
	}

	/** Null-Safe attribute value check. Works with other attribute types too. */
	public String getAttributeString(String id, String def){
		Attribute<?> attr = getAttribute(id);
		return attr == null ? def : attr.string_value();
	}

	public Boolean getAttributeTristate(String id, Boolean def){
		Attribute<?> attr = getAttribute(id);
		return attr == null ? def : attr.tristate_value();
	}
	
	/** @return null if installed successfully. */
	public PartData installPart(@Nullable ICommandSender engineer, PartData data, String category, boolean hotinst){
		if(!data.getType().getInstallationHandler().allowInstall(engineer, data, category, this)) return data;
		//if(parts.containsKey(category)) return data;//<- actually, let's let the handler check that
		if(data.getType().getInstallationHandler().processInstall(engineer, data, category, this)){
			this.insertSwivelPointsFromPart(data, category);
			this.insertAttributesFromPart(data, category);
			//
			if(!hotinst){
				this.resetAttributes();
				this.updateAttributes(null, AttrUpdate.INITIAL);
			}
			//
			this.refreshModificableDataByParts();
			return null;
		} else return data;
	}

	public boolean deinstallPart(@Nullable ICommandSender sender, String category, boolean hotinst){
		PartData part = this.getPart(category);
		if(part == null){ Print.chatnn(sender, "No part in that category."); return false; }
		if(!part.getType().getInstallationHandler().allowUninstall(sender, part, category, this)) return false;
		if(part.getType().getInstallationHandler().processUninstall(sender, part, category, this)){
			this.removeSwivelPointsFromPart(part, category);
			this.removeAttributesFromPart(part, category);
			//
			if(!hotinst){
				this.resetAttributes();
				this.updateAttributes(null, AttrUpdate.INITIAL);
			}
			//
			this.refreshModificableDataByParts();
			return true;
		} else return false;
	}

	private void insertSwivelPointsFromPart(PartData data, String category){
		if(data.getType().getDefaultSwivelPoints().isEmpty()) return;
		for(SwivelPoint point : data.getType().getDefaultSwivelPoints().values()){
			if(!rotpoints.containsKey(point.id)){
				rotpoints.put(point.id, point.clone(category + "|" + data.getType().getRegistryName().toString()));
			}
		}
		rotpoints.values().forEach(point -> point.linkToParent(this));
	}

	private void removeSwivelPointsFromPart(PartData data, String category){
		String dataid = category + "|" + data.getType().getRegistryName().toString();
		rotpoints.values().removeIf(filter -> filter.origin != null && filter.origin.equals(dataid));
		rotpoints.values().forEach(point -> point.linkToParent(this));
	}

	private void insertAttributesFromPart(PartData data, String catin){
		String dataid = catin + "|" + data.getType().getRegistryName().toString();
		for(Attribute<?> attr : data.getType().getBaseAttributes()){
			String[] valid = attr.target().split(",");
			boolean pass = false;
			boolean not = false;
			for(String val : valid){
				val = val.trim();
				if(val.startsWith("!")){
					not = true;
					val = val.substring(1);
				}
				if(val.equals("vehicle")){
					pass = !not;
					break;
				}
				if(val.contentEquals(this.getType().getRegistryName().toString())){
					pass = !not;
					break;
				}
				if(this.getType().getCategory().contains(val)){
					pass = !not;
					break;
				}
				if(val.startsWith("pack-")){
					ResourceLocation loc = new ResourceLocation(val.substring(5));
					if(loc.equals(this.getType().getAddon().getRegistryName())){
						pass = !not;
						break;
					}
				}
			}
			if(pass && !this.getAttributes().containsKey(attr.id())){
				this.getAttributes().put(attr.id(), attr.copy(dataid));
			}
		}
		//Print.console(data.getType().getBaseAttributes());
		//Print.console(attributes);
		//add modifiers
		for(Modifier<?> mod : data.getType().getBaseModifiers()){
			String target = mod.target().contains(":") ? mod.target().split(":")[1] : mod.target();
			if(this.getAttributes().containsKey(target)){
				this.getAttributes().get(target).addModifier(mod.copy(dataid));
			}
		}
	}

	private void removeAttributesFromPart(PartData data, String category){
		String datain = category + "|" + data.getType().getRegistryName().toString();
		this.attributes.entrySet().removeIf(pre -> pre.getValue().origin() != null && pre.getValue().origin().equals(datain));
		for(Attribute<?> attr : this.attributes.values()){
			attr.getModifiers().removeIf(pre -> pre.origin() != null && pre.origin().equals(datain));
		}
	}

	public void resetAttributes(){
		for(Attribute<?> attr : attributes.values()){ attr.reset(); }
	}

	public void updateAttributes(VehicleEntity ent, AttrUpdate call){
		for(Attribute<?> attr : attributes.values()){ attr.updateValue(this, ent, call); }
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

	@Override
	public RGB getColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public void setColorChannel(String channel, RGB color){
		channels.put(channel, color);
	}

	@Override
	public TreeMap<String, RGB> getColorChannels(){
		return channels;
	}

	public ItemStack newItemStack(){
		ItemStack stack = this.type.newItemStack();
		stack.setTagCompound(this.write(new NBTTagCompound()));
		return stack;
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

	@Override
	public String getLockCode(){
		return lockcode;
	}

	@Override
	public void setLocked(Boolean bool){
		locked = bool == null ? !locked : bool;
	}

	public double getThrottle(){
		return getAttribute("throttle").float_value();
	}

	public ArrayList<String> getInventories(){
		return inventories;
	}

	public String[] getFuelGroup(){
		if(!parts.containsKey("engine")) return new String[]{ "no engine" };
		if(!parts.get("engine").hasFunction("fvtm:engine")) return new String[]{ "disfunctional engine" };
		return parts.get("engine").getFunction(EngineFunction.class, "fvtm:engine").getFuelGroup();
	}

	public boolean getLightsState(){
		return getAttribute("lights").boolean_value();
	}

	public boolean getFogLightsState(){
		return getAttribute("lights_fog").boolean_value();
	}

	public boolean getLongLightsState(){
		return getAttribute("lights_long").boolean_value();
	}

	public boolean getSpecialLightsState(){
		return getAttribute("lights_other").boolean_value();
	}

	public boolean getTurnLightLeft(){
		return Boolean.FALSE.equals(getAttribute("turn_lights").tristate_value());
	}

	public boolean getTurnLightRight(){
		return Boolean.TRUE.equals(getAttribute("turn_lights").tristate_value());
	}

	public boolean getWarningLights(){
		return getAttribute("warning_lights").boolean_value();
	}

	public int getStoredFuel(){
		return getAttribute("fuel_stored").integer_value();
	}

	public int getFuelCapacity(){
		return getAttribute("fuel_capacity").integer_value();
	}

	public VehicleScript getVehicleScript(String string){
		for(VehicleScript script : scripts) if(script.getId().equals(string)) return script; return null;
	}

	public <V extends VehicleScript> V getVehicleScriptCasted(String string){
		for(VehicleScript script : scripts) if(script.getId().equals(string)) return (V)script; return null;
	}

	public ArrayList<VehicleScript> getScripts(){
		return scripts;
	}

	public Vec3d getFrontConnector(){
		return front_conn;
	}

	public Vec3d getRearConnector(){
		return rear_conn;
	}
	
	public void setConnector(Vec3d newcon, boolean front){
		if(newcon == null)
			if(front) front_conn = type.getDefaultFrontConnector();
			else rear_conn = type.getDefaultRearConnector();
		else if(front) front_conn = newcon; else rear_conn = newcon;
	}
	
	public List<Attribute<?>> getAttributes(String group){
		return attributes.values().stream().filter(pre -> pre.group() != null && pre.group().equals(group)).collect(Collectors.toList());
	}
	
	public boolean isPreset(){
		return preset != null;
	}
	
	public String getPreset(){
		return preset;
	}
	
	public void setPreset(String str){
		this.preset = str;
	}

	@Override
	public SoundEvent getSoundEvent(String event){
		Sound sound = getSound(event); return sound == null ? null : sound.event;
	}

	@Override
	public float getSoundVolume(String event){
		Sound sound = getSound(event); return sound == null ? 1f : sound.volume;
	}

	@Override
	public float getSoundPitch(String event){
		Sound sound = getSound(event); return sound == null ? 1f : sound.pitch;
	}

	@Override
	public Sound getSound(String event){
		return sounds.get(event);
	}

	@Override
	public void playSound(Entity at, String event){
		Sound sound = getSound(event);
		if(sound == null) return;
		at.playSound(sound.event, sound.volume, sound.pitch);
	}
	
	public TreeMap<String, SwivelPoint> getRotationPoints(){
		return rotpoints;
	}
	
	/** Falls back to "vehicle" rotpoint if the specified one isn't found. */
	public SwivelPoint getRotationPoint(String id){
		if(id == null) return rootpoint;
		SwivelPoint point = rotpoints.get(id);
		if(point == null) return rootpoint;
		return point;
	}

	public SwivelPoint getRotationPointOfPart(String cat){
		if(cat == null || !parts.containsKey(cat)) return rootpoint;
		cat = parts.get(cat).getSwivelPointInstalledOn();
		return getRotationPoint(cat);
	}
	
	public String getName(){
		return displayname == null ? type.getName() : displayname;
	}

	public void setDisplayName(String string){
		displayname = string;
	}

	public String getDisplayName(){
		return displayname;
	}

	public <F extends Function> F getFunctionInPart(String part, String function){
		return parts.containsKey(part) ? parts.get(part).getFunction(function) : null;
	}

	public VehicleData copy(){
		return new VehicleData(type).read(write(null));
	}
	
	public List<Attribute<?>> getAttributeGroup(String group){
		return attributes.values().stream().filter(attr -> attr.group() != null && attr.group().equals(group)).collect(Collectors.toList());
	}

	public TreeMap<String, PartSlots> getPartSlotProviders(){
		return psproviders;
	}

	public PartSlots getPartSlotsProvider(String psp_id){
		return psproviders.get(psp_id);
	}

	public ArrayList<PartSlot> getAllPartSlots(){
		ArrayList<PartSlot> list = new ArrayList<>();
		psproviders.values().forEach(val -> list.addAll(val));
		return list;
	}

	public boolean hasPartSlot(String str){
		for(PartSlots slots : psproviders.values()){
			for(PartSlot slot : slots){
				if(slot.category.equals(str)) return true;
			}
		}
		return false;
	}

	public int getAttributeIndex(Attribute<?> attribute){
		return new ArrayList<>(attributes.keySet()).indexOf(attribute.id());
	}

	public Attribute<?> getAttributeByIndex(int idx){
		return new ArrayList<>(attributes.values()).get(idx);
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
