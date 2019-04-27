package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public enum DataType {
	
	ADDON(".fvtm", null, Addon.class),
	PART(".part", "parts", Part.class),
	VEHICLE(".vehicle", "vehicles", Vehicle.class),
	MATERIAL(".material", "materials", Material.class),
	//CONTAINER(".container", "containers"),
	//CONSUMABLE(".consumable", "consumables"),
	;
	
	public final String suffix, cfg_folder;
	public final Class<? extends TypeCore<?>> core;
	
	DataType(String suffix, String cfg_folder, Class<? extends TypeCore<?>> type){
		this.suffix = suffix; this.cfg_folder = cfg_folder; this.core = type;
	}

	@SuppressWarnings("unchecked")
	public <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> getRegistry(){
		switch(this){
			case ADDON: return (IForgeRegistry<T>)Resources.ADDONS;
			case PART: return (IForgeRegistry<T>)Resources.PARTS;
			case VEHICLE: return (IForgeRegistry<T>)Resources.VEHICLES;
			case MATERIAL: return (IForgeRegistry<T>)Resources.MATERIALS;
			default: return null;
		}
	}

	public void register(TypeCore<?> core){
		switch(this){
			case ADDON:{ Resources.ADDONS.register((Addon)core); return; }
			case PART:{ Resources.PARTS.register((Part)core); return; }
			case VEHICLE:{ Resources.VEHICLES.register((Vehicle)core); return; }
			case MATERIAL:{ Resources.MATERIALS.register((Material)core); return; }
			default: return;
		}
	}
	
}