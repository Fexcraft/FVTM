package net.fexcraft.mod.fvtm.render;

import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.SortedModelGroup.SeparateSortedModelGroup;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.minecraft.tileentity.TileEntity;

public class SeparateRenderCache {

	public static final ArrayList<SeparateSortedModelGroup> SORTED_VEH_QUEUE = new ArrayList<>();
	public static final ArrayList<VehicleData> SORTED_VEH_DATA = new ArrayList<>();
	public static final ArrayList<RootVehicle> SORTED_VEH_ENTITY = new ArrayList<>();
	public static final HashMap<Integer, V3D> SORTED_VEH_ROT = new HashMap<>();
	public static final HashMap<Integer, double[]> SORTED_VEH_POS = new HashMap<>();
	//
	public static final ArrayList<SeparateSortedModelGroup> SORTED_BLK_QUEUE = new ArrayList<>();
	public static final ArrayList<BlockData> SORTED_BLK_DATA = new ArrayList<>();
	public static final ArrayList<TileEntity> SORTED_BLK_ENTITY = new ArrayList<>();

	public static void clear(){
		SORTED_VEH_QUEUE.clear();
		SORTED_VEH_DATA.clear();
		SORTED_VEH_ENTITY.clear();
		SORTED_VEH_ROT.clear();
		SORTED_VEH_POS.clear();
		//
		SORTED_BLK_QUEUE.clear();
		SORTED_BLK_DATA.clear();
		SORTED_BLK_ENTITY.clear();
	}

}
