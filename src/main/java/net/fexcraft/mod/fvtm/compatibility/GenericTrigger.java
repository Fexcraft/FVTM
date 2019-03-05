package net.fexcraft.mod.fvtm.compatibility;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.EntityType;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GenericTrigger {

	@Nullable
	public static EntityType AM_TRAINS_ET;
	public static boolean TOUGHASNAILS, TRACK_API, AM_TRAINS, MTS, TiM, IR;

	public static void preInit(FMLPreInitializationEvent event){
		TOUGHASNAILS = Loader.isModLoaded("toughasnails");
		AM_TRAINS = Loader.isModLoaded("trainsmod");
		MTS = Loader.isModLoaded("mts");
		TiM = Loader.isModLoaded("tim") || Loader.isModLoaded("trainsinmotion");
		IR = Loader.isModLoaded("immersiverailroading");
		TRACK_API = Loader.isModLoaded("trackapi") || AM_TRAINS || IR;
		//
		if(AM_TRAINS) registerAMTrains(event);
		//
	}

	public static void properInit(FMLInitializationEvent event){
		//
	}

	public static void postInit(FMLPostInitializationEvent event){
		//
	}
	
	//-//-//-//
	
	private static void registerAMTrains(FMLPreInitializationEvent event){
		/*alemax.trainsmod.util.FVTMCompatibility.load(event);
		//
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:trainsmod"), TrainsModEntityConverter.class, "fvtm:trainsmod", 29910, FVTM.getInstance(), 256, 1, false);
		AM_TRAINS_ET = new EntityType(new ResourceLocation("trainsmod:internal"), "TrainsMod - FVTM Internal Compatibility Module", VehicleType.RAIL){
			@Override
			public boolean spawnEntity(World world, EntityPlayer player, ItemStack stack, VehicleData data, VehicleType type){
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public boolean spawnEntity(World world, BlockPos pos, VehicleData data){
				return world.spawnEntity(new TrainsModEntityConverter(world, pos, data));
			}
		};
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(TrainsModEntityConverter.class, RenderTrainsModGeneric::new);
		}*/
	}
	
	//-//-//-//
	
	public static boolean getTaNBooleanValue(String string){
		return DetachedTaN.getBooleanValue(string);
	}
	
	public static class DetachedTaN {
		
		public static boolean getBooleanValue(String string){
			try{
				if(string.equals("thoughasnails.enable_thirst")){
					return toughasnails.api.config.SyncedConfig.getBooleanValue(toughasnails.api.config.GameplayOption.ENABLE_THIRST);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
		
	}
	
}