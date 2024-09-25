package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.item.StackWrapper;

public interface JunctionGridItem {
	
	public static float[][] default_grid_colours = new float[][]{
		{ 0f, 1f, 0f, 1f }, { 0f, 1f, 0f, 1f }
	};
	public static QV3D[] EMPTY = new QV3D[0];
	
	public default boolean showJunctionGrid(){ return true; }
	
	public default float[][] getGridColours(){
		return default_grid_colours;
	}
	
	public default boolean hasVectors(){ return false; }
	
	public default QV3D[] getVectors(StackWrapper stack){ return EMPTY; }
	
	public default boolean offsetVectors(){ return false; }
	
	public default int getSegments(){ return 4; }

	public default int getPlacingGrid(){ return 2; };

}
