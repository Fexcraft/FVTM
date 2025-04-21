package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.ModelGroupList.SeparateModelGroupList;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class SeparateRenderCache {

	public static final Program SEP_VEH_CACHE = new Program.BlankProgram("fvtm:sep_veh_cache");
	public static final ArrayList<VehicleInstance> VEHICLES = new ArrayList<>();
	//
	public static final ArrayList<SeparateModelGroupList> SORTED_BLK_QUEUE = new ArrayList<>();
	public static final ArrayList<BlockData> SORTED_BLK_DATA = new ArrayList<>();
	public static final ArrayList<Object> SORTED_BLK_ENTITY = new ArrayList<>();

	public static void clear(){
		VEHICLES.removeIf(veh -> veh.entity == null || veh.entity.isRemoved());
		for(VehicleInstance vehicle : VEHICLES){
			((SepVehCache)vehicle.cache.get(SEP_VEH_CACHE)).clear();
		}
		//
		SORTED_BLK_QUEUE.clear();
		SORTED_BLK_DATA.clear();
		SORTED_BLK_ENTITY.clear();
	}

	public static class SepVehCache {

		public final ArrayList<String> parts = new ArrayList<>();
		public double[] pos = new double[3];
		public V3D rot;

		public void clear(){
			parts.clear();
		}

		public void set(double x, double y, double z, V3D nrot){
			pos[0] = x;
			pos[1] = y;
			pos[2] = z;
			rot = nrot;
		}
	}

	public static void add(VehicleInstance vehent, String part){
		if(!VEHICLES.contains(vehent)) VEHICLES.add(vehent);
		if(part != null){
			((SepVehCache)vehent.cache.get(SEP_VEH_CACHE)).parts.add(part);
		}
	}

}
