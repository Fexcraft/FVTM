package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.io.InputStream;
import java.util.Set;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Addon;
import net.fexcraft.mod.fvtm.data.AddonClass;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.Part;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {
	
	public static IForgeRegistry<Addon> ADDONS;
	public static IForgeRegistry<Part> PARTS;
	public static IForgeRegistry<Material> MATERIALS;
	//
	private File configroot; 
	
	public Resources(FMLPreInitializationEvent event){
		configroot = new File(event.getModConfigurationDirectory(), "/fvtm/");
		if(!configroot.exists()) configroot.mkdirs(); //addonconfig = new File(configpath, "/addonpacks.fex");
		//
		ADDONS = new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
		PARTS = new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
		MATERIALS = new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
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
		searchInAddonsFor(DataType.MATERIAL);
		searchInAddonsFor(DataType.PART);
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

}
