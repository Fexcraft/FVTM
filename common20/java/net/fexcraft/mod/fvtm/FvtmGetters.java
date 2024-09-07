package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.VehicleLiftBlock;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.item.DecorationItem;
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
	public static Supplier<EntityType<? extends RootVehicle>> ROOTVEHICLE_ENTITY;
	public static Supplier<EntityType<? extends WheelEntity>> WHEEL_ENTITY;
	public static Class<? extends WheelEntity> WHEEL_ENTITY_CLASS;
	//
	public static Supplier<BlockEntityType<VehicleLiftEntity>> LIFT_ENTITY;
	//
	public static Supplier<RoadToolItem> ROAD_TOOL_ITEM;
	public static Supplier<ToolboxItem> TOOLBOX0;
	public static Supplier<ToolboxItem> TOOLBOX1;
	public static Supplier<ToolboxItem> TOOLBOX2;
	public static Supplier<Asphalt>[] ASPHALT = new Supplier[16];
	public static Supplier<BlockItem>[] ASPHALT_ITEM = new Supplier[16];
	public static Supplier<VehicleLiftBlock> LIFT_BLOCK;
	public static Supplier<BlockItem> LIFT_BLOCK_ITEM;
	//
	public static Function<Entity, RenderCache> RENDERCACHE;

	public static DecorationEntity getNewDecoration(Level level){
		return DECORATION_ENTITY.get().create(level);
	}

	public static RoadMarker getNewRoadMarker(Level level){
		return ROAD_MARKER_ENTITY.get().create(level);
	}

	public static RenderCache getRenderCache(Entity entity){
		return RENDERCACHE.apply(entity);
	}

	public static RootVehicle getNewVehicle(Level level){
		return ROOTVEHICLE_ENTITY.get().create(level);
	}

	public static WheelEntity getNewWheel(RootVehicle veh, String wid){
		try{
			return WHEEL_ENTITY_CLASS.getConstructor(RootVehicle.class, String.class).newInstance(veh, wid);
		}
		catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
			throw new RuntimeException(e);
		}
	}

}
