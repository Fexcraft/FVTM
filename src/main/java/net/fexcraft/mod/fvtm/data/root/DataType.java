package net.fexcraft.mod.fvtm.data.root;

import java.util.ArrayList;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
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
	FUEL(".fuel", "fuels", Fuel.class),
	ROADSIGN(".sign", "roadsigns", RoadSign.class)
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
			case FUEL: return (IForgeRegistry<T>)Resources.ALLFUELS;
			case ROADSIGN: return (IForgeRegistry<T>)Resources.ROADSIGNS;
			default: return null;
		}
	}

	public void register(TypeCore<?> core){
		switch(this){
			case ADDON:{ Resources.ADDONS.register((Addon)core); return; }
			case PART:{ Resources.PARTS.register((Part)core); return; }
			case VEHICLE:{ Resources.VEHICLES.register((Vehicle)core); return; }
			case MATERIAL:{ Resources.MATERIALS.register((Material)core); return; }
			case FUEL:{
				Fuel fuel = (Fuel)core;
				if(!Resources.FUELS.containsKey(fuel.getPrimaryGroup())){
					Resources.FUELS.put(fuel.getPrimaryGroup(), new TreeMap<>());
				}
				if(!Resources.FUELS.get(fuel.getPrimaryGroup()).containsKey(fuel.getSecondaryGroup())){
					Resources.FUELS.get(fuel.getPrimaryGroup()).put(fuel.getSecondaryGroup(), new ArrayList<>());
				}
				Resources.FUELS.get(fuel.getPrimaryGroup()).get(fuel.getSecondaryGroup()).add(fuel);
				Resources.ALLFUELS.register((Fuel)core); return;
			}
			case ROADSIGN:{ Resources.ROADSIGNS.register((RoadSign)core); return; }
			default: return;
		}
	}

	public boolean has3DItemModel(){
		return this == VEHICLE;// || this == ROADSIGN;
	}
	
}