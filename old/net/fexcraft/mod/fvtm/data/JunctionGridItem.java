package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.item.ItemStack;

public interface JunctionGridItem {
	
	public static float[][] default_grid_colours = new float[][]{
		{ 0f, 1f, 0f, 1f }, { 0f, 1f, 0f, 1f }
	};
	public static Vec316f[] EMPTY = new Vec316f[0];
	
	public default boolean showJunctionGrid(){ return true; }
	
	public default float[][] getGridColours(){
		return default_grid_colours;
	}
	
	public default boolean hasVectors(){ return false; }
	
	public default Vec316f[] getVectors(ItemStack stack){ return EMPTY; }
	
	public default boolean offsetVectors(){ return false; }
	
	public default int getSegments(){ return 4; }

	public default int getPlacingGrid(){ return Config.RAIL_PLACING_GRID; };

}
