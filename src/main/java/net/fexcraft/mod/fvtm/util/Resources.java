package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Addon;
import net.fexcraft.mod.fvtm.data.AddonClass;
import net.fexcraft.mod.fvtm.data.Function;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.Part;
import net.fexcraft.mod.fvtm.data.PartData;
import net.fexcraft.mod.fvtm.data.Vehicle;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {
	
	public static IForgeRegistry<Addon> ADDONS;
	public static IForgeRegistry<Part> PARTS;
	public static IForgeRegistry<Vehicle> VEHICLES;
	public static IForgeRegistry<Material> MATERIALS;
	private static TreeMap<String, Class<? extends Function>> FUNCTIONS = new TreeMap<>();
	public static final HashMap<String, Model<?, ?>> MODELS = new HashMap<>();
	//
	private File configroot; 
	
	public Resources(FMLPreInitializationEvent event){
		configroot = new File(event.getModConfigurationDirectory(), "/fvtm/");
		if(!configroot.exists()) configroot.mkdirs(); //addonconfig = new File(configpath, "/addonpacks.fex");
		//
		ADDONS = new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
		PARTS = new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
		VEHICLES = new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvtm:vehicles")).setType(Vehicle.class).create();
		MATERIALS = new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
		//FUNCTIONS = new RegistryBuilder<Function>().setName(new ResourceLocation("fvtm:part_functions")).setType(Function.class).create();
		/*FUELS = new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
		VEHICLES = new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvtm:vehicles")).setType(Vehicle.class).create();
		PARTATTRIBUTES = new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
		CONTAINERS = new RegistryBuilder<Container>().setName(new ResourceLocation("fvtm:containers")).setType(Container.class).create();
		CONSUMABLES = new RegistryBuilder<Consumable>().setName(new ResourceLocation("fvtm:consumables")).setType(Consumable.class).create();
		BLOCKS = new RegistryBuilder<Block>().setName(new ResourceLocation("fvtm:blocks")).setType(Block.class).create();
		PALLETS = new RegistryBuilder<Pallet>().setName(new ResourceLocation("fvtm:pallets")).setType(Pallet.class).create();
		GAUGES = new RegistryBuilder<Gauge>().setName(new ResourceLocation("fvtm:railgauges")).setType(Gauge.class).create();*/
		//
		String addonclass = AddonClass.class.getCanonicalName();
		Set<ASMData> addons = event.getAsmData().getAll(addonclass);
		for(ASMData entry : addons){
			try{
				Class<?> clazz = Class.forName(entry.getClassName());
				AddonClass addon = clazz.getAnnotation(AddonClass.class);
				String id = addon.registryname().contains(":") ? addon.registryname().split(":")[1] : addon.registryname();
				ContainerType type = entry.getCandidate().getSourceType();
				File file = entry.getCandidate().getModContainer();
				if(addon.hasJson()){
					InputStream stream = Resources.class.getClassLoader().getResourceAsStream("assets/" + id + "/addonpack.fvtm");
					if(stream == null) continue; JsonObject obj = JsonUtil.getObjectFromInputStream(stream);
					ADDONS.register(new Addon(type, file).parse(obj));
				}
				else{
					ADDONS.register((Addon)clazz.getConstructor(ContainerType.class, File.class).newInstance(type, file));
					//TODO find out how to get the actual instance of the mod.
				}
				Print.log("Registered FVTM Addon with ID '" + addon.registryname() + "'!");
			} catch(Exception e){ e.printStackTrace(); }
		}
		//
		//TODO check addon on/off state
		//
		registerFunctions();
		//
		searchInAddonsFor(DataType.MATERIAL);
		searchInAddonsFor(DataType.PART);
		searchInAddonsFor(DataType.VEHICLE);
	}

	private void registerFunctions(){
		registerFunction("fvtm:wheel", WheelFunction.class, true);
	}

	private void searchInAddonsFor(DataType datatype){
		for(Addon addon : ADDONS.getValuesCollection()){
			try{ addon.searchFor(datatype); } catch (Throwable thr){ thr.printStackTrace(); }
		}
	}

	public static Part getPart(String string){
		return getPart(new ResourceLocation(string));
	}

	public static Part getPart(ResourceLocation resloc){
		return PARTS.getValue(resloc);
	}

	public static Vehicle getVehicle(String string){
		return getVehicle(new ResourceLocation(string));
	}

	public static Vehicle getVehicle(ResourceLocation resloc){
		return VEHICLES.getValue(resloc);
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(String string){
		return getModelInputStream(new ResourceLocation(string));
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(ResourceLocation resloc){
		try{
			return net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(resloc).getInputStream();
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public static <T, K> Model<T, K> getModel(String name, Class<? extends Model<T, K>> clazz){
		if(name == null || name.equals("") || name.equals("null")){
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		if(MODELS.containsKey(name)){
			return (Model<T, K>)MODELS.get(name);
		}
		if(FCLRegistry.getModel(name) != null){
			MODELS.put(name, FCLRegistry.getModel(name));
			return FCLRegistry.getModel(name);
		}
		String ext = FilenameUtils.getExtension(name);
		Model<T, K> model = null;
		try{
			switch(ext){
				case "class":
					Class<?> clasz = Class.forName(name.replace(".class", ""));
					model = (Model<T, K>)clasz.newInstance();
					break;
				case "jtmt":
					JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(name)).getInputStream());
					model = clazz.getConstructor(JsonObject.class).newInstance(obj);
					break;
				case "json":
					//TODO create a wrapper.
					break;
				case "obj":
					model = clazz.getConstructor(String.class, ResourceLocation.class).newInstance("obj", new ResourceLocation(name));
					break;
				case "": default: return (Model<T, K>)getEmptyModelFromClass(clazz);
			}
		}
		catch(Throwable thr){
			Print.log("Failed to find/parse model with adress '" + name + "'!");
			thr.printStackTrace(); Static.stop();
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		MODELS.put(name, model);
		return model;
	}

	private static Model<?, ?> getEmptyModelFromClass(Class<? extends Model<?, ?>> clazz){
		//if(clazz == BlockModel.class) return BlockModel.EMPTY;
		//if(clazz == ContainerModel.class) return ContainerModel.EMPTY;
		if(clazz == PartModel.class) return PartModel.EMPTY;
		if(clazz == VehicleModel.class) return VehicleModel.EMPTY;
		return null;
	}

	public static PartData getPartData(NBTTagCompound compound){
		if(!compound.hasKey("Part")) return null;
		Part part = getPart(compound.getString("Part"));
		try{ return ((PartData)part.getDataClass().getConstructor(Part.class).newInstance(part)).read(compound); }
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException
			| InvocationTargetException| NoSuchMethodException | SecurityException e){
			e.printStackTrace(); return null;
		}
	}

	public static VehicleData getVehicleData(NBTTagCompound compound){
		if(!compound.hasKey("Vehicle")) return null;
		Vehicle veh = getVehicle(compound.getString("Vehicle"));
		try{ return ((VehicleData)veh.getDataClass().getConstructor(Vehicle.class).newInstance(veh)).read(compound); }
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException
			| InvocationTargetException| NoSuchMethodException | SecurityException e){
			e.printStackTrace(); return null;
		}
	}
	
	/** Registers a Functon class into FVTM Resources.*/
	public static void registerFunction(ResourceLocation regname, Class<? extends Function> clazz, boolean override){
		registerFunction(regname.toString(), clazz, override);
	}
	
	/** Registers a Functon class into FVTM Resources.*/
	public static void registerFunction(String regname, Class<? extends Function> clazz, boolean override){
		if(FUNCTIONS.containsKey(regname) && !override) return; FUNCTIONS.put(regname, clazz);
	}
	
	public static Class<? extends Function> getFunction(ResourceLocation regname){
		return getFunction(regname.toString());
	}
	
	public static Class<? extends Function> getFunction(String id){
		return FUNCTIONS.get(id);
	}

}
