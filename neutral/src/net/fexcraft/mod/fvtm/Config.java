package net.fexcraft.mod.fvtm;

import java.io.File;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.ConfigBase;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniReg;

/**
 * FVTM Config File
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class Config extends ConfigBase {

	//general
	public static ArrayList<File> PACK_FOLDERS = new ArrayList<>();
	public static boolean VEHICLES_NEED_FUEL;
	public static boolean VEHICLES_DROP_CONTENTS;
	public static boolean UNBREAKABLE_CONTAINERS;
	public static boolean ROADTOOL_FOR_ALL;
	public static boolean DISMOUNT_ON_LOGOUT;
	public static String[] DEFAULT_TRAFFIC_SIGN_LIBRARIES;
	//client
	public static boolean RENDER_OUT_OF_VIEW;
	public static boolean RENDER_VEHILE_MODELS_AS_ITEMS;
	public static boolean DISABLE_LIGHT_BEAMS;
	public static boolean RENDER_VEHICLES_SEPARATELY;
	public static boolean RENDER_BLOCKS_SEPARATELY;
	public static boolean DISABLE_PARTICLES;
	public static int SIGNAL_INTERVAL;
	//uni/proto
	public static float MOTION_SCALE;
	public static byte VEHICLE_SYNC_RATE;
	public static float STEER_RESET_RATE;
	//rail
	public static boolean DISABLE_RAILS;
	public static int UNLOAD_INTERVAL;
	public static int RAIL_SEGMENTATOR;
	public static int MAX_RAIL_TRACK_LENGTH;
	//road
	public static boolean DISABLE_ROADS;
	public static int MAX_ROAD_LENGTH;
	public static int ROAD_UNDO_CACHE_SIZE;
	public static int ROAD_UNDO_CACHE_CLEARTIME;
	//wire
	public static boolean DISABLE_WIRES;
	public static int MAX_WIRE_LENGTH;
	public static float WIRE_SLACK_ADJUSTMENT;
	//deprecated
	public static boolean OVERLAY_ON_BOTTOM;

	public Config(File file){
		super(file, "FVTM");
	}

	@Override
	protected void fillInfo(JsonMap map){
		map.add("info", "FVTM Main Configuration File");
		map.add("wiki", "https://fexcraft.net/wiki/mod/fvtm");
		map.addArray("pack_folders");
	}

	@Override
	protected void fillEntries(){
		//categories
		String catg = "general";
		String catc = "client";
		String catu = "u12/basic";
		String catv = "vehicle";
		String catr = "rail";
		String cato = "road";
		String catw = "wire";

		entries.add(new ConfigEntry(this, catg, "dev_mode", new JsonValue(EnvInfo.DEV))
			.info("If the FVTM Dev Mode (generally more logging) should be enabled.")
			.cons((con, map) -> EnvInfo.DEV = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catg, "vehicles_need_fuel", new JsonValue(true))
			.info("If vehicles need Fuel (in survival mode) to function.")
			.cons((con, map) -> VEHICLES_NEED_FUEL = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catg, "vehicle_drop_contents", new JsonValue(false))
			.info("If vehicles should drop their inventory contents upon being removed.")
			.cons((con, map) -> VEHICLES_DROP_CONTENTS = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catg, "vehicle_drop_contents", new JsonValue(false))
			.info("If containers should be unbreakable (via tools/hand).")
			.cons((con, map) -> UNBREAKABLE_CONTAINERS = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catg, "road_tool_for_all", new JsonValue(false))
			.info("When not using a Forge PermissionsAPI compatible permission manager, to allow any player to use the Road Placing Tool.")
			.cons((con, map) -> ROADTOOL_FOR_ALL = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catg, "dismount_on_logout", new JsonValue(true))
			.info("If players should automatically dismount vehicles on log out (leaving server).")
			.cons((con, map) -> DISMOUNT_ON_LOGOUT = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catg, "traffic_sign_libraries", new JsonArray("default_fexcraft;http://fexcraft.net/files/mod_data/fvtm/default_traffic_sign_library.json"))
			.info("List of External Traffic Sign Libraries. Separate the ID from the URL using a semicolon.")
			.cons((con, map) -> DEFAULT_TRAFFIC_SIGN_LIBRARIES = con.getJson(map).asArray().toStringArray()));
		entries.add(new ConfigEntry(this, catg, "update_packet_range", new JsonValue(256)).rang(64, 4096)
			.info("Range in which ranged update packets are sent.")
			.cons((con, map) -> Packets.RANGE = con.getInteger(map)));

		//client
		entries.add(new ConfigEntry(this, catc, "render_out_of_view", new JsonValue(false))
			.info("If vehicles should be rendered out of default view.")
			.cons((con, map) -> RENDER_OUT_OF_VIEW = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catc, "render_vehicle_models_as_items", new JsonValue(true))
			.info("If the Vehicle's model should be rendered as Item. Could cause lags.")
			.cons((con, map) -> RENDER_VEHILE_MODELS_AS_ITEMS = con.getBoolean(map)));
		/*entries.add(new ConfigEntry(this, catc, "render_block_models_as_items", new JsonValue(true))
			.info("If the (non-vanilla) Block models should be rendered as Item.")
			.cons((con, map) -> RENDER_BLOCK_MODELS_AS_ITEMS = con.getBoolean(map)));*/
		entries.add(new ConfigEntry(this, catc, "disable_light_beams", new JsonValue(false))
			.info("If light beam rendering should be disabled.")
			.cons((con, map) -> DISABLE_LIGHT_BEAMS = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catc, "render_vehicles_separately", new JsonValue(true))
			.info("If vehicles should be rendered separately in a new render pass. Allows for higher view distance.")
			.cons((con, map) -> RENDER_VEHICLES_SEPARATELY = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catc, "render_blocks_separately", new JsonValue(false))
			.info("If blocks (with entity) should be rendered separately in a new render pass. Allows for higher view distance.")
			.cons((con, map) -> RENDER_BLOCKS_SEPARATELY = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catc, "disable_particles", new JsonValue(false))
			.info("If FVTM particles (particle system) should be disabled.")
			.cons((con, map) -> DISABLE_PARTICLES = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catc, "signal_interval", new JsonValue(750))
			.info("Blinker/Turn/Emergency Signal toggle interval, in milliseconds.").rang(100, 2000)
			.cons((con, map) -> SIGNAL_INTERVAL = con.getInteger(map)));

		//u12/basic
		entries.add(new ConfigEntry(this, catu, "motion_scale", new JsonValue(0.2f))
			.info("Physics Motion Scale Multiplier.").rang(0.001f, 2f)
			.cons((con, map) -> MOTION_SCALE = con.getFloat(map)));

		//general vehicle
		entries.add(new ConfigEntry(this, catv, "sync_rate", new JsonValue(5))
			.info("Entity sync rate in ticks. Lesser value means higher sync AND higher bandwidth. Higher value means slower sync and less bandwidth.").rang(1, 10)
			.cons((con, map) -> VEHICLE_SYNC_RATE = (byte)con.getInteger(map)));
		entries.add(new ConfigEntry(this, catv, "steer_reset_rate", new JsonValue(0.90))//0.95
			.info("Steer multiplier per tick. 1 = no reset, 0 = full reset each tick.").rang(0, 1)
			.cons((con, map) -> STEER_RESET_RATE = con.getFloat(map)));

		//rail
		entries.add(new ConfigEntry(this, catr, "disable", new JsonValue(false))
			.info("If FVTM rail system should be disabled.")
			.cons((con, map) -> DISABLE_RAILS = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catr, "unload_interval", new JsonValue(300000))
			.info("Interval (milliseconds) in which it is checked for trains/rails to be unloaded.")
			.cons((con, map) -> UNLOAD_INTERVAL = con.getInteger(map))
			.rang(60000, 86400000));
		entries.add(new ConfigEntry(this, catr, "generation_segmentator", new JsonValue(4))
			.info("Segmentator divider for rail generator, valid are 16, 8, 4, 2 or 1.")
			.cons((con, map) -> {
				RAIL_SEGMENTATOR = con.getInteger(map);
				if(RAIL_SEGMENTATOR > 16) RAIL_SEGMENTATOR = 16;
				if(RAIL_SEGMENTATOR > 8 && RAIL_SEGMENTATOR < 16) RAIL_SEGMENTATOR = 8;
				if(RAIL_SEGMENTATOR > 4 && RAIL_SEGMENTATOR < 8) RAIL_SEGMENTATOR = 4;
				if(RAIL_SEGMENTATOR > 2 && RAIL_SEGMENTATOR < 4) RAIL_SEGMENTATOR = 2;
				if(RAIL_SEGMENTATOR < 1) RAIL_SEGMENTATOR = 1;
			})
			.rang(1, 16));
		entries.add(new ConfigEntry(this, catr, "max_length", new JsonValue(32))
			.info("Max total vector length of new placed rail tracks.")
			.cons((con, map) -> MAX_RAIL_TRACK_LENGTH = con.getInteger(map))
			.rang(1, 256));

		//road
		entries.add(new ConfigEntry(this, cato, "disable", new JsonValue(false))
			.info("If FVTM road system should be disabled.")
			.cons((con, map) -> DISABLE_ROADS = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, cato, "max_length", new JsonValue(256))
			.info("Max total vector length of new placed roads.")
			.cons((con, map) -> MAX_ROAD_LENGTH = con.getInteger(map))
			.rang(4, 4096));
		entries.add(new ConfigEntry(this, cato, "undo_cache_size", new JsonValue(8))
			.info("How many roads should be remembered in the undo cache. Set '0' to disable the undo cache.")
			.cons((con, map) -> ROAD_UNDO_CACHE_SIZE = con.getInteger(map))
			.rang(0, 32));
		entries.add(new ConfigEntry(this, cato, "undo_cache_cleartime", new JsonValue(5))
			.info("After how many minutes the undo cache of a player should reset. Useful if your players have unstable connection. Set to '0' for instant deletion.")
			.cons((con, map) -> ROAD_UNDO_CACHE_CLEARTIME = con.getInteger(map))
			.rang(0, 60));

		//wire
		entries.add(new ConfigEntry(this, catw, "disable", new JsonValue(false))
			.info("If FVTM wire system should be disabled.")
			.cons((con, map) -> DISABLE_WIRES = con.getBoolean(map)));
		entries.add(new ConfigEntry(this, catw, "max_length", new JsonValue(64))
			.info("Max total vector length of new placed wires.")
			.cons((con, map) -> MAX_WIRE_LENGTH = con.getInteger(map))
			.rang(1, 1024));
		entries.add(new ConfigEntry(this, catw, "slack_adjustment", new JsonValue(0.5f))
			.info("Default slack adjustment value when using the toolbox item on a wire.")
			.cons((con, map) -> WIRE_SLACK_ADJUSTMENT = con.getFloat(map))
			.rang(Static.sixteenth, 1f));

		//1.12 specific settings
		if(UniReg.LOADER_VERSION.equals("1.12")){
			entries.add(new ConfigEntry(this, catg, "default_overlay_on_bottom", new JsonValue(true))
				.info("If the default steering overlay should be on bottom rather than on top of screen.")
				.cons((con, map) -> OVERLAY_ON_BOTTOM = con.getBoolean(map)));
		}
	}

	@Override
	protected void onReload(JsonMap map){
		PACK_FOLDERS.clear();
		if(!map.has("pack_folders")) return;
		map.getArray("pack_folders").value.forEach(val -> PACK_FOLDERS.add(new File(val.string_value())));
	}


}
