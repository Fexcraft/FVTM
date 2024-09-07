package net.fexcraft.mod.fvtm.data;

import static net.fexcraft.mod.fvtm.FvtmRegistry.*;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum ContentType {

	ADDON(".fvtm", null),
	PART(".part", "parts", Part.class),
	VEHICLE(".vehicle", "vehicles", Vehicle.class),
	MATERIAL(".material", "materials", Material.class),
	CONTAINER(".container", "containers", Container.class),
	CONSUMABLE(".consumable", "consumables", Consumable.class),
	FUEL(".fuel", "fuels", Fuel.class),
	BLOCK(".block", "blocks", Block.class),
	MULTIBLOCK(".multiblock", "blocks"),
	RAILGAUGE(".gauge", "railgauges", RailGauge.class),
	CLOTH(".cloth", "clothes", Cloth.class),
	WIRE(".wire", "wires", WireType.class),
	WIREDECO(".wiredeco", "wires", WireDeco.class),
	DECORATION(".deco", "decos", Decoration.class)
	;

	static{
		VEHICLE.customitemmodel = true;
		CONTAINER.customitemmodel = true;
		PART.customitemmodel = true;
		BLOCK.customitemmodel = true;
		DECORATION.customitemmodel = true;
	}

	public String suffix;
	public String folder;
	public Class<? extends Content<?>> impl;
	private boolean customitemmodel = false;

	ContentType(String suffix, String folder){
		this.suffix = suffix;
		this.folder = folder;
	}

	ContentType(String suffix, String folder, Class<? extends Content<?>> clazz){
		this(suffix, folder);
		impl = clazz;
	}

	public void register(Content<?> content){
		switch(this){
			case PART: PARTS.register(content); return;
			case VEHICLE: VEHICLES.register(content); return;
			case MATERIAL: MATERIALS.register(content); return;
			case CONTAINER: CONTAINERS.register(content); return;
			case CONSUMABLE: CONSUMABLES.register(content); return;
			case FUEL: FUELS.register(content); return;
			case BLOCK: BLOCKS.register(content); return;
			case MULTIBLOCK: return;
			case RAILGAUGE: RAILGAUGES.register(content); return;
			case CLOTH: CLOTHES.register(content); return;
			case WIRE: WIRES.register(content); return;
			case WIREDECO: WIREDECOS.register(content); return;
			case DECORATION: DECORATIONS.register(content); return;
			default: return;
		}
	}

	@Deprecated
	public boolean usesCustomItemModel(){
		return customitemmodel;
	}

}
