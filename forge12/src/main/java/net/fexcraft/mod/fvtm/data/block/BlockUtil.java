package net.fexcraft.mod.fvtm.data.block;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.function.part.TireFunction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import static net.fexcraft.mod.fvtm.function.part.TireFunction.DEF_MAT_TIRE_ARR;

public class BlockUtil {
	
	public static HashMap<String, Material> VANILLA_MATERIALS = new /*Linked*/HashMap<>();
	static {
		VANILLA_MATERIALS.put("air", Material.AIR);
		VANILLA_MATERIALS.put("grass", Material.GRASS);
		VANILLA_MATERIALS.put("ground", Material.GROUND);
		VANILLA_MATERIALS.put("wood", Material.WOOD);
		VANILLA_MATERIALS.put("rock", Material.ROCK);
		VANILLA_MATERIALS.put("iron", Material.IRON);
		VANILLA_MATERIALS.put("anvil", Material.ANVIL);
		VANILLA_MATERIALS.put("water", Material.WATER);
		VANILLA_MATERIALS.put("lava", Material.LAVA);
		VANILLA_MATERIALS.put("leaves", Material.LEAVES);
		VANILLA_MATERIALS.put("plants", Material.PLANTS);
		VANILLA_MATERIALS.put("vine", Material.VINE);
		VANILLA_MATERIALS.put("sponge", Material.SPONGE);
		VANILLA_MATERIALS.put("cloth", Material.CLOTH);
		VANILLA_MATERIALS.put("fire", Material.FIRE);
		VANILLA_MATERIALS.put("sand", Material.SAND);
		VANILLA_MATERIALS.put("circuits", Material.CIRCUITS);
		VANILLA_MATERIALS.put("carpet", Material.AIR);
		VANILLA_MATERIALS.put("glass", Material.GLASS);
		VANILLA_MATERIALS.put("redstone_light", Material.REDSTONE_LIGHT);
		VANILLA_MATERIALS.put("tnt", Material.TNT);
		VANILLA_MATERIALS.put("coral", Material.CORAL);
		VANILLA_MATERIALS.put("ice", Material.ICE);
		VANILLA_MATERIALS.put("packed_ice", Material.PACKED_ICE);
		VANILLA_MATERIALS.put("snow", Material.SNOW);
		VANILLA_MATERIALS.put("crafted_snow", Material.CRAFTED_SNOW);
		VANILLA_MATERIALS.put("cactus", Material.CACTUS);
		VANILLA_MATERIALS.put("clay", Material.CLAY);
		VANILLA_MATERIALS.put("gourd", Material.GOURD);
		//VANILLA_MATERIALS.put("dragon_egg", Material.DRAGON_EGG);
		VANILLA_MATERIALS.put("portal", Material.PORTAL);
		VANILLA_MATERIALS.put("cake", Material.CAKE);
		VANILLA_MATERIALS.put("web", Material.WEB);
		VANILLA_MATERIALS.put("piston", Material.PISTON);
		VANILLA_MATERIALS.put("barrier", Material.BARRIER);
		//VANILLA_MATERIALS.put("scructure_void", Material.STRUCTURE_VOID);
	}

	public static Material getMaterial(String mat){
		return getMaterial(mat, false);
	}

	public static Material getMaterial(String mat, boolean allownull){
		mat = mat.toLowerCase();
		Material material = VANILLA_MATERIALS.get(mat);
		return material == null ? allownull ? null : Material.ROCK : material;
	}

	public static Material getMaterial(Block type){
		return getMaterial(type.getMaterial(), false);
	}

	public static MapColor getMapColor(Block type){
		return getMapColor(type.getMapColor());
	}

	public static MapColor getMapColor(String mapcol){
		mapcol = mapcol.toLowerCase();
		switch(mapcol){
			case "air": return MapColor.AIR;
			case "grass": return MapColor.GRASS;
			case "sand": return MapColor.SAND;
			case "cloth": return MapColor.CLOTH;
			case "tnt": return MapColor.TNT;
			case "ice": return MapColor.ICE;
			case "iron": return MapColor.IRON;
			case "foliage": return MapColor.FOLIAGE;
			case "snow": return MapColor.SNOW;
			case "clay": return MapColor.CLAY;
			case "dirt": return MapColor.DIRT;
			case "stone": return MapColor.STONE;
			case "water": return MapColor.WATER;
			case "wood": return MapColor.WOOD;
			case "quartz": return MapColor.QUARTZ;
			case "adobe": return MapColor.ADOBE;
			case "magenta": return MapColor.MAGENTA;
			case "light_blue": return MapColor.LIGHT_BLUE;
			case "yellow": return MapColor.YELLOW;
			case "lime": return MapColor.LIME;
			case "pink": return MapColor.PINK;
			case "gray": return MapColor.GRAY;
			case "silver": return MapColor.SILVER;
			case "cyan": return MapColor.CYAN;
			case "purple": return MapColor.PURPLE;
			case "blue": return MapColor.BLUE;
			case "brown": return MapColor.BROWN;
			case "green": return MapColor.GREEN;
			case "red": return MapColor.RED;
			case "black": return MapColor.BLACK;
			case "gold": return MapColor.GOLD;
			case "diamond": return MapColor.DIAMOND;
			case "lapis": return MapColor.LAPIS;
			case "emerald": return MapColor.EMERALD;
			case "obsidian": return MapColor.OBSIDIAN;
			case "netherrack": return MapColor.NETHERRACK;
			case "white_stained_hardenen_clay": return MapColor.WHITE_STAINED_HARDENED_CLAY;
			case "orange_stained_hardenen_clay": return MapColor.ORANGE_STAINED_HARDENED_CLAY;
			case "magenta_stained_hardenen_clay": return MapColor.MAGENTA_STAINED_HARDENED_CLAY;
			case "light_blue_stained_hardenen_clay": return MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY;
			case "yellow_stained_hardenen_clay": return MapColor.YELLOW_STAINED_HARDENED_CLAY;
			case "lime_stained_hardenen_clay": return MapColor.LIME_STAINED_HARDENED_CLAY;
			case "pink_stained_hardenen_clay": return MapColor.PINK_STAINED_HARDENED_CLAY;
			case "gray_stained_hardenen_clay": return MapColor.GRAY_STAINED_HARDENED_CLAY;
			case "silver_stained_hardenen_clay": return MapColor.SILVER_STAINED_HARDENED_CLAY;
			case "cyan_stained_hardenen_clay": return MapColor.CYAN_STAINED_HARDENED_CLAY;
			case "purple_stained_hardenen_clay": return MapColor.PURPLE_STAINED_HARDENED_CLAY;
			case "blue_stained_hardenen_clay": return MapColor.BLUE_STAINED_HARDENED_CLAY;
			case "brown_stained_hardenen_clay": return MapColor.BROWN_STAINED_HARDENED_CLAY;
			case "green_stained_hardenen_clay": return MapColor.GREEN_STAINED_HARDENED_CLAY;
			case "red_stained_hardenen_clay": return MapColor.RED_STAINED_HARDENED_CLAY;
			case "black_stained_hardenen_clay": return MapColor.BLACK_STAINED_HARDENED_CLAY;
		}
		return MapColor.STONE;
	}

	static {
		float dc = TireFunction.MatTireAttr.DEF_COR, ds = TireFunction.MatTireAttr.DEF_COR_STEER;
		DEF_MAT_TIRE_ARR.put(null, new TireFunction.MatTireAttr(TireFunction.MatTireAttr.DEF_GRIP, TireFunction.MatTireAttr.DEF_RAIN_GRIP, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.AIR, new TireFunction.MatTireAttr(0.1f, 0.1f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.GRASS, new TireFunction.MatTireAttr(0.7f, 0.4f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.GROUND, new TireFunction.MatTireAttr(0.9f, 0.75f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.WOOD, new TireFunction.MatTireAttr(1.2f, 0.9f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.ROCK, new TireFunction.MatTireAttr(1f, 0.9f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.IRON, new TireFunction.MatTireAttr(1.2f, 0.9f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.ANVIL, new TireFunction.MatTireAttr(1.5f, 1f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.WATER, new TireFunction.MatTireAttr(0.1f, 0.1f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.LAVA, new TireFunction.MatTireAttr(0.1f, 0.2f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.LEAVES, new TireFunction.MatTireAttr(0.8f, 0.4f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.PLANTS, new TireFunction.MatTireAttr(0.8f, 0.4f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.VINE, new TireFunction.MatTireAttr(0.8f, 0.4f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.SPONGE, new TireFunction.MatTireAttr(0.75f, 0.6f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CLOTH, new TireFunction.MatTireAttr(0.8f, 0.8f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.FIRE, new TireFunction.MatTireAttr(1f, 1.2f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.SAND, new TireFunction.MatTireAttr(0.5f, 0.2f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CIRCUITS, new TireFunction.MatTireAttr(1.25f, 1f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CARPET, new TireFunction.MatTireAttr(1.1f, 0.9f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.GLASS, new TireFunction.MatTireAttr(1.1f, 0.8f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.REDSTONE_LIGHT, new TireFunction.MatTireAttr(1f, 1f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.TNT, new TireFunction.MatTireAttr(1.5f, 1.2f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CORAL, new TireFunction.MatTireAttr(0.5f, 0.5f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.ICE, new TireFunction.MatTireAttr(0.3f, 0.2f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.PACKED_ICE, new TireFunction.MatTireAttr(0.5f, 0.3f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.SNOW, new TireFunction.MatTireAttr(0.75f, 0.5f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CRAFTED_SNOW, new TireFunction.MatTireAttr(1f, 0.8f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CACTUS, new TireFunction.MatTireAttr(0.7f, 0.9f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CLAY, new TireFunction.MatTireAttr(0.8f, 0.5f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.GOURD, new TireFunction.MatTireAttr(0.7f, 0.4f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.PORTAL, new TireFunction.MatTireAttr(2f, 2f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.CAKE, new TireFunction.MatTireAttr(0.45f, 0.1f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.WEB, new TireFunction.MatTireAttr(1f, 0.8f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.PISTON, new TireFunction.MatTireAttr(1f, 0.9f, dc, ds));
		DEF_MAT_TIRE_ARR.put(Material.BARRIER, new TireFunction.MatTireAttr(1.2f, 1.1f, dc, ds));
	}
	
}
