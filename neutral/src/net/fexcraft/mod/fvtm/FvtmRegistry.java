package net.fexcraft.mod.fvtm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelGroupList;
import net.fexcraft.mod.fvtm.model.ModelLoader;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.util.PartItemApp;
import net.fexcraft.mod.fvtm.util.Registry;
import net.fexcraft.mod.fvtm.util.VehItemApp;
import net.fexcraft.mod.fvtm.util.ess.RailSpawnSystem;
import net.fexcraft.mod.fvtm.util.ess.SimplePhysSpawnSystem;
import net.fexcraft.mod.uni.*;
import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.UniStack;

/**
 * FVTM Registry
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmRegistry {

	public static final String CORE_VER = "1.0.0";
	public static File CONFIG_DIR;
	public static Config CONFIG;
	public static boolean is112;
	public static boolean is120;
	public static boolean is121;
	//
	public static IDL INTERNAL_ADDON_ID;
	public static IDL NONE_CLOTH_MAT;
	public static IDL AIR;
	public static IDL NULL_TEXTURE;
	public static IDL WHITE_TEXTURE;
	public static IDL STANDARD_GAUGE;
	//
	public static final Registry<Addon> ADDONS = new Registry<>();
	public static final Registry<Fuel> FUELS = new Registry<>();
	public static final Registry<Material> MATERIALS = new Registry<>();
	public static final Registry<Consumable> CONSUMABLES = new Registry<>();
	public static final Registry<Vehicle> VEHICLES = new Registry<>();
	public static final Registry<Part> PARTS = new Registry<>();
	public static final Registry<Block> BLOCKS = new Registry<>();
	public static final Registry<Cloth> CLOTHES = new Registry<>();
	public static final Registry<WireType> WIRES = new Registry<>();
	public static final Registry<WireDeco> WIREDECOS = new Registry<>();
	public static final Registry<Container> CONTAINERS = new Registry<>();
	public static final Registry<RailGauge> RAILGAUGES = new Registry<>();
	public static final Registry<MultiBlock> MULTIBLOCKS = new Registry<>();
	public static final Registry<Decoration> DECORATIONS = new Registry<>();
	public static final Registry<Sign> SIGNS = new Registry<>();
	public static final Registry<Recipe> RECIPES = new Registry<>();
	public static TreeMap<String, TreeMap<String, ArrayList<Fuel>>> SORTED_FUELS = new TreeMap<>();
	public static final HashMap<String, Particle> PARTICLES = new HashMap<>();
	//
	public static final LinkedHashMap<String, Class<? extends Attribute<?>>> ATTRIBUTES = new LinkedHashMap<>();
	public static final LinkedHashMap<String, Class<? extends PartFunction>> PART_FUNCTIONS = new LinkedHashMap<>();
	public static final LinkedHashMap<String, Class<? extends BlockFunction>> BLOCK_FUNCTIONS = new LinkedHashMap<>();
	//
	public static final LinkedHashMap<String, ModelGroupList> MODELS = new LinkedHashMap<>();
	public static final LinkedHashMap<String, ModelData> MODEL_DATAS = new LinkedHashMap<>();
	public static final ArrayList<ModelLoader> MODEL_LOADERS = new ArrayList<>();
	//
	public static final HashMap<IDL, Object> CONTENT_BLOCKS = new HashMap<>();
	public static final HashMap<IDL, ItemWrapper> CONTENT_ITEMS = new HashMap<>();
	public static final HashMap<String, ItemWrapper> ITEMS = new HashMap<>();

	public static final void init(String loadver, File conf){
		UniReg.LOADER_VERSION = loadver;
		is112 = EnvInfo.is112();
		is120 = EnvInfo.is120();
		is121 = EnvInfo.is121();
		CONFIG_DIR = conf;
		if(!CONFIG_DIR.exists()) CONFIG_DIR.mkdirs();
		CONFIG = new Config(new File(conf, "fvtm.json"));
		//
		INTERNAL_ADDON_ID = IDLManager.getIDLCached("fvtm:fvtm");
		AIR = IDLManager.getIDLCached("minecraft:air");
		NULL_TEXTURE = IDLManager.getIDLNamed("No Texture;fvtm:textures/entity/null.png");
		WHITE_TEXTURE = IDLManager.getIDLNamed("No Texture;fvtm:textures/entity/white.png");
		STANDARD_GAUGE = IDLManager.getIDLCached("gep:standard");
		//
		UniStack.register(new VehItemApp(null));
		UniStack.register(new PartItemApp(null));
		UniEntity.register(new FvtmPlayer(null));
		UniEntity.register(new Passenger(null));
		EntitySystem.add(new RailSpawnSystem());
		EntitySystem.add(new SimplePhysSpawnSystem());
	}

	public static Addon getAddon(String id){
		for(Addon addon : ADDONS){
			if(addon.getID().id().equals(id)) return addon;
		}
		return null;
	}

	public static Fuel getFuel(String id){
		return FUELS.get(id);
	}

	public static Fuel getFuel(IDL idl){
		return FUELS.get(idl);
	}

	public static String getFuelName(IDL id){
		return getFuelName(id.colon());
	}

	public static String getFuelName(String id){
		Fuel fuel = getFuel(id);
		return fuel == null ? "not-found" : fuel.getName();
	}

	public static ItemWrapper getItem(String id){
		ItemWrapper wrapper = ITEMS.get(id);
		if(wrapper == null){
			wrapper = FvtmResources.INSTANCE.getItemWrapper(id);
		}
		return wrapper;
	}

}
