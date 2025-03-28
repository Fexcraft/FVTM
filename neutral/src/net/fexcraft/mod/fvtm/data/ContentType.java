package net.fexcraft.mod.fvtm.data;

import static net.fexcraft.mod.fvtm.FvtmRegistry.*;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum ContentType {

	ADDON(".fvtm", null),
	TOOLBOX(null, null, "fvtm:toolbox", null),
	//
	PART(".part", "parts", "fvtm:part", Part.class),
	VEHICLE(".vehicle", "vehicles", "fvtm:vehicle", Vehicle.class),
	MATERIAL(".material", "materials", "fvtm:material", Material.class),
	CONTAINER(".container", "containers", "fvtm:container", Container.class),
	CONSUMABLE(".consumable", "consumables", "fvtm:consumable", Consumable.class),
	FUEL(".fuel", "fuels", null, Fuel.class),
	BLOCK(".block", "blocks", "fvtm:block", Block.class),
	MULTIBLOCK(".multiblock", "blocks", "fvtm:multiblock", null),
	RAILGAUGE(".gauge", "railgauges", "fvtm:railgauge", RailGauge.class),
	CLOTH(".cloth", "clothes", "fvtm:cloth", Cloth.class),
	WIRE(".wire", "wires", "fvtm:wire", WireType.class),
	WIREDECO(".wiredeco", "wires", "fvtm:wiredeco", WireDeco.class),
	DECORATION(".deco", "decos", "fvtm:decoration", Decoration.class),
	SIGN(".sign", "signs", "fvtm:sign", Sign.class),
	RECIPE(".json", "recipes", null, Recipe.class),
	;

	public static ArrayList<String> ITYPES = new ArrayList<>();
	public static String ITYPE = "fvtm:content";
	static{
		for(ContentType value : values()){
			if(value.item_type != null) ITYPES.add(value.item_type);
		}
	}

	public String suffix;
	public String folder;
	public String item_type;
	public Class<? extends Content<?>> impl;

	ContentType(String suffix, String folder){
		this.suffix = suffix;
		this.folder = folder;
	}

	ContentType(String suffix, String folder, String itid, Class<? extends Content<?>> clazz){
		this(suffix, folder);
		impl = clazz;
		item_type = itid;
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
			case RECIPE: RECIPES.register(content); return;
			case SIGN: SIGNS.register(content); return;
			default: return;
		}
	}

}
