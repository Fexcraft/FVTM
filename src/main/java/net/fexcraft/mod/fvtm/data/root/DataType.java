package net.fexcraft.mod.fvtm.data.root;

import java.util.ArrayList;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.util.Registry;
import net.fexcraft.mod.fvtm.util.Resources;

public enum DataType {
	
	ADDON(".fvtm", null, Addon.class),
	PART(".part", "parts", Part.class),
	VEHICLE(".vehicle", "vehicles", Vehicle.class),
	MATERIAL(".material", "materials", Material.class),
	CONTAINER(".container", "containers", Container.class),
	CONSUMABLE(".consumable", "consumables", Consumable.class),
	FUEL(".fuel", "fuels", Fuel.class),
	BLOCK(".block", "blocks", Block.class),
	MULTIBLOCK(".multiblock", "blocks", MultiBlock.class),
	RAILGAUGE(".gauge", "railgauges", RailGauge.class),
	CLOTH(".cloth", "clothes", Cloth.class),
	WIRE(".wire", "wires", WireType.class),
	;
	
	public final String suffix, cfg_folder;
	public final Class<? extends TypeCore<?>> core;
	
	DataType(String suffix, String cfg_folder, Class<? extends TypeCore<?>> type){
		this.suffix = suffix; this.cfg_folder = cfg_folder; this.core = type;
	}

	public <T extends TypeCore<T>> Registry<T> getRegistry(){
		switch(this){
			case ADDON: return (Registry<T>)Resources.ADDONS;
			case PART: return (Registry<T>)Resources.PARTS;
			case VEHICLE: return (Registry<T>)Resources.VEHICLES;
			case MATERIAL: return (Registry<T>)Resources.MATERIALS;
			case FUEL: return (Registry<T>)Resources.ALLFUELS;
			case CONSUMABLE: return (Registry<T>)Resources.CONSUMABLES;
			case CONTAINER: return (Registry<T>)Resources.CONTAINERS;
			case BLOCK: return (Registry<T>)Resources.BLOCKS;
			case RAILGAUGE: return (Registry<T>)Resources.RAILGAUGES;
			case CLOTH: return (Registry<T>)Resources.CLOTHES;
			case WIRE: return (Registry<T>)Resources.WIRES;
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
			case CONSUMABLE:{ Resources.CONSUMABLES.register((Consumable)core); return; }
			case CONTAINER:{ Resources.CONTAINERS.register((Container)core); return; }
			case BLOCK:{ Resources.BLOCKS.register((Block)core); return; }
			case RAILGAUGE:{ Resources.RAILGAUGES.register((RailGauge)core); return; }
			case CLOTH:{ Resources.CLOTHES.register((Cloth)core); return; }
			case WIRE:{ Resources.WIRES.register((WireType)core); return; }
			default: return;
		}
	}

	@Deprecated
	public boolean has3DItemModel(){
		return this == VEHICLE || this == CONTAINER || this == PART/* depends on part function */ || this == BLOCK/** depends on block */;
	}
	
}