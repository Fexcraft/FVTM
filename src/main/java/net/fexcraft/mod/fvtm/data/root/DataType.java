package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.util.Resources;

public enum DataType {
	
	ADDON(".fvtm", null, Addon.class),
	/*PART(".part", "parts", Part.class),
	VEHICLE(".vehicle", "vehicles", Vehicle.class),
	MATERIAL(".material", "materials", Material.class),
	CONTAINER(".container", "containers", Container.class),
	CONSUMABLE(".consumable", "consumables", Consumable.class),
	FUEL(".fuel", "fuels", Fuel.class),
	BLOCK(".block", "blocks", Block.class),
	RAILGAUGE(".gauge", "railgauges", RailGauge.class),
	CLOTH(".cloth", "clothes", Cloth.class),
	WIRE(".wire", "wires", WireType.class),*/
	;
	
	public final String suffix, cfg_folder;
	public final Class<? extends TypeCore<?>> core;
	
	DataType(String suffix, String cfg_folder, Class<? extends TypeCore<?>> type){
		this.suffix = suffix; this.cfg_folder = cfg_folder; this.core = type;
	}

	/*public <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> getRegistry(){
		switch(this){
			case ADDON: return (IForgeRegistry<T>)Resources.ADDONS;
			case PART: return (IForgeRegistry<T>)Resources.PARTS;
			case VEHICLE: return (IForgeRegistry<T>)Resources.VEHICLES;
			case MATERIAL: return (IForgeRegistry<T>)Resources.MATERIALS;
			case FUEL: return (IForgeRegistry<T>)Resources.ALLFUELS;
			case CONSUMABLE: return (IForgeRegistry<T>)Resources.CONSUMABLES;
			case CONTAINER: return (IForgeRegistry<T>)Resources.CONTAINERS;
			case BLOCK: return (IForgeRegistry<T>)Resources.BLOCKS;
			case RAILGAUGE: return (IForgeRegistry<T>)Resources.RAILGAUGES;
			case CLOTH: return (IForgeRegistry<T>)Resources.CLOTHES;
			case WIRE: return (IForgeRegistry<T>)Resources.WIRES;
			default: return null;
		}
	}*///TODO check if using forge registries is of use

	public void register(TypeCore<?> core){
		switch(this){
			case ADDON:{ Resources.ADDONS.register((Addon)core); return; }
			/*case PART:{ Resources.PARTS.register((Part)core); return; }
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
			case CONSUMABLE:{ Resources.CONSUMABLES.register((Consumable)core); return; }
			case CONTAINER:{ Resources.CONTAINERS.register((Container)core); return; }
			case BLOCK:{ Resources.BLOCKS.register((Block)core); return; }
			case RAILGAUGE:{ Resources.RAILGAUGES.register((RailGauge)core); return; }
			case CLOTH:{ Resources.CLOTHES.register((Cloth)core); return; }
			case WIRE:{ Resources.WIRES.register((WireType)core); return; }
			default: return;*///TODO data type registry
		}
	}
	
}