package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.ModelGroupList.SeparateModelGroupList;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class SeparateRenderCache {

	public static final ArrayList<SeparateModelGroupList> SORTED_VEH_QUEUE = new ArrayList<>();
	public static final ArrayList<VehicleData> SORTED_VEH_DATA = new ArrayList<>();
	public static final ArrayList<VehicleInstance> SORTED_VEH_ENTITY = new ArrayList<>();
	public static final HashMap<Integer, V3D> SORTED_VEH_ROT = new HashMap<>();
	public static final HashMap<Integer, double[]> SORTED_VEH_POS = new HashMap<>();
	//
	public static final ArrayList<SeparateModelGroupList> SORTED_BLK_QUEUE = new ArrayList<>();
	public static final ArrayList<BlockData> SORTED_BLK_DATA = new ArrayList<>();
	public static final ArrayList<Object> SORTED_BLK_ENTITY = new ArrayList<>();

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
