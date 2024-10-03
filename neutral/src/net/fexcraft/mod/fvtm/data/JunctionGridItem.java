package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.util.QV3D;

public interface JunctionGridItem {
	
	public static float[][] default_grid_colours = new float[][]{
		{ 0f, 1f, 0f, 1f }, { 0f, 1f, 0f, 1f }
	};
	public static QV3D[] EMPTY = new QV3D[0];
	
	public default boolean showJunctionGrid(){ return true; }
	
	public default float[][] getGridColours(){
		return default_grid_colours;
	}

}
