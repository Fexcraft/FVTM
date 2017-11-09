package net.fexcraft.mod.fvtm.util;

import java.util.List;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Tabs {
	
	private static int sec = -1;
	private static int mat_id = 0;
	private static int part_id = 0;
	private static int l_veh_id = 0;
	private static int a_veh_id = 0;
	private static int w_veh_id = 0;
	private static int r_veh_id = 0;
	//private static int block_id = 0;
	
	public static final CreativeTabs LANDVEHICLES = new CreativeTabs("fvtm_landvehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);
		}
		@Override
		public ItemStack getIconItemStack(){
			List<Vehicle> list = Resources.getVehiclesByType(VehicleType.LAND);
			return list.size() > 0 ? list.get(l_veh_id).getItemStack(null) : new ItemStack(Items.SADDLE);
		}
	};
	
	public static final CreativeTabs AIRVEHICLES = new CreativeTabs("fvtm_airvehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);
		}
		@Override
		public ItemStack getIconItemStack(){
			List<Vehicle> list = Resources.getVehiclesByType(VehicleType.AIR);
			return list.size() > 0 ? list.get(a_veh_id).getItemStack(null) : new ItemStack(Items.FEATHER);
		}
	};
	
	public static final CreativeTabs WATERVEHICLES = new CreativeTabs("fvtm_watervehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);
		}
		@Override
		public ItemStack getIconItemStack(){
			List<Vehicle> list = Resources.getVehiclesByType(VehicleType.WATER);
			return list.size() > 0 ? list.get(w_veh_id).getItemStack(null) : new ItemStack(Items.DARK_OAK_BOAT);
		}
	};
	
	public static final CreativeTabs RAILVEHICLES = new CreativeTabs("fvtm_railvehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);
		}
		@Override
		public ItemStack getIconItemStack(){
			List<Vehicle> list = Resources.getVehiclesByType(VehicleType.RAIL);
			return list.size() > 0 ? list.get(r_veh_id).getItemStack(null) : new ItemStack(Blocks.DETECTOR_RAIL);
		}
	};
	
	public static final CreativeTabs PARTS = new CreativeTabs("fvtm_parts"){
		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		@Override
		public ItemStack getIconItemStack(){
			return Resources.PARTS.getEntries().size() > 0 ? ((Part)Resources.PARTS.getValues().toArray()[part_id]).getItemStack(null) : new ItemStack(Items.IRON_DOOR);
		}
	};
	
	public static final CreativeTabs MATERIALS = new CreativeTabs("fvtm_materials"){		
		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		@Override
		public ItemStack getIconItemStack(){
			return Resources.MATERIALS.getEntries().size() > 0 ? ((Material)Resources.MATERIALS.getValues().toArray()[mat_id]).getItemStack() : new ItemStack(Items.STONE_AXE);
		}
	};
	
	public static final CreativeTabs BLOCKS = new CreativeTabs("fvtm_blocks"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(ConstructorController.INSTANCE);
		}
	};
	
	public static final void update(){
		if(sec != Time.getSecond()){
			sec = Time.getSecond();
			mat_id++;
			if(mat_id >= Resources.MATERIALS.getEntries().size()){
				mat_id = 0;
			}
			part_id++;
			if(part_id >= Resources.PARTS.getEntries().size()){
				part_id = 0;
			}
			l_veh_id++;
			if(l_veh_id >= Resources.getVehiclesByType(VehicleType.LAND).size()){
				l_veh_id = 0;
			}
			w_veh_id++;
			if(w_veh_id >= Resources.getVehiclesByType(VehicleType.WATER).size()){
				w_veh_id = 0;
			}
			a_veh_id++;
			if(a_veh_id >= Resources.getVehiclesByType(VehicleType.AIR).size()){
				a_veh_id = 0;
			}
			r_veh_id++;
			if(r_veh_id >= Resources.getVehiclesByType(VehicleType.RAIL).size()){
				r_veh_id = 0;
			}
		}
	}
	
}