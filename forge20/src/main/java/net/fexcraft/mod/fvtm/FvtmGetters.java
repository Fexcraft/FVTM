package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.fvtm.block.*;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.JunctionTool;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmGetters {

	public static Supplier<EntityType<? extends DecorationEntity>> DECORATION_ENTITY;
	public static Supplier<EntityType<? extends RoadMarker>> ROAD_MARKER_ENTITY;
	public static Supplier<EntityType<? extends RailMarker>> RAIL_MARKER_ENTITY;
	public static Supplier<EntityType<? extends RootVehicle>> ROOTVEHICLE_ENTITY;
	public static Supplier<EntityType<? extends RailVehicle>> RAILVEHICLE_ENTITY;
	public static Supplier<EntityType<? extends WheelEntity>> WHEEL_ENTITY;
	//
	public static Supplier<BlockEntityType<VehicleLiftEntity>> LIFT_ENTITY;
	public static Supplier<BlockEntityType<ConstructorEntity>> CONST_ENTITY;
	public static Supplier<BlockEntityType<BaseBlockEntity>> BLOCK_ENTITY;
	//
	public static Supplier<RoadToolItem> ROAD_TOOL_ITEM;
	public static Supplier<ToolboxItem>[] TOOLBOX = new Supplier[ToolboxType.values().length];
	public static Supplier<JunctionTool> JUNCTION_TOOl;
	public static Supplier<Asphalt>[] ASPHALT = new Supplier[16];
	public static Supplier<BlockItem>[] ASPHALT_ITEM = new Supplier[16];
	public static Supplier<VehicleLiftBlock> LIFT_BLOCK;
	public static Supplier<BlockItem> LIFT_BLOCK_ITEM;
	public static Supplier<ConstructorBlock> CONST_BLOCK;
	public static Supplier<BlockItem> CONST_BLOCK_ITEM;
	//
	public static Function<Entity, RenderCache> RENDERCACHE;

	public static DecorationEntity getNewDecoration(Level level){
		return DECORATION_ENTITY.get().create(level);
	}

	public static RoadMarker getNewRoadMarker(Level level){
		return ROAD_MARKER_ENTITY.get().create(level);
	}

	public static RailMarker getNewRailMarker(Level level){
		return RAIL_MARKER_ENTITY.get().create(level);
	}

	public static RenderCache getRenderCache(Entity entity){
		return RENDERCACHE.apply(entity);
	}

	public static RootVehicle getNewVehicle(Level level){
		return ROOTVEHICLE_ENTITY.get().create(level);
	}

	public static RailVehicle getNewRailVeh(Level level){
		return RAILVEHICLE_ENTITY.get().create(level);
	}

	public static WheelEntity getNewWheel(RootVehicle veh, String wid){
		try{
			return new WheelEntity(veh, wid);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
