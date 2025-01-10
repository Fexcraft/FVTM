package net.fexcraft.mod.fvtm;

import com.mojang.logging.LogUtils;
import net.fexcraft.mod.fcl.util.StackWrapperProvider;
import net.fexcraft.mod.fvtm.block.ConstructorEntity;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.impl.Packets20F;
import net.fexcraft.mod.fvtm.impl.SWIE;
import net.fexcraft.mod.fvtm.impl.WorldWIE;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.impl.WrapperHolderImpl;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod(FVTM4.MODID)
public class FVTM4 {

	public static final String MODID = "fvtm";
	private static Logger LOGGER4 = LogUtils.getLogger();
	public static final HashMap<String, DeferredRegister<Item>> ITEM_REGISTRY = new HashMap<>();
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "fvtm");
	//
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, "fvtm");
	public static final RegistryObject<EntityType<DecorationF>> DECORATION_ENTITY = ENTITIES.register("decoration", () ->
		EntityType.Builder.of(DecorationF::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.setUpdateInterval(10)
			.setTrackingRange(256)
			.build("decoration")
	);
	public static final RegistryObject<EntityType<RoadMarkerF>> ROAD_MARKER_ENTITY = ENTITIES.register("road_marker", () ->
		EntityType.Builder.of(RoadMarkerF::new, MobCategory.MISC)
			.sized(0.24F, 0.48F)
			.setUpdateInterval(10)
			.setTrackingRange(256)
			.build("road_marker")
	);
	public static final RegistryObject<EntityType<RailMarkerF>> RAIL_MARKER_ENTITY = ENTITIES.register("rail_marker", () ->
		EntityType.Builder.of(RailMarkerF::new, MobCategory.MISC)
			.sized(0.24F, 1F)
			.setUpdateInterval(10)
			.setTrackingRange(256)
			.build("rail_marker")
	);
	public static final RegistryObject<EntityType<WheelEntityF>> WHEEL_ENTITY = ENTITIES.register("wheel", () ->
		EntityType.Builder.of((EntityType.EntityFactory<WheelEntityF>)(type, level) -> new WheelEntityF(type, level), MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.setUpdateInterval(1)
			.setTrackingRange(256)
			.build("wheel")
	);
	public static final RegistryObject<EntityType<RootVehicleF>> VEHICLE_ENTITY = ENTITIES.register("vehicle", () ->
		EntityType.Builder.of(RootVehicleF::new, MobCategory.MISC)
			.sized(1F, 1F)
			.setUpdateInterval(1)
			.setTrackingRange(256)
			.build("vehicle")
	);
	public static final RegistryObject<EntityType<RailVehicleF>> RAILVEH_ENTITY = ENTITIES.register("railveh", () ->
		EntityType.Builder.of(RailVehicleF::new, MobCategory.MISC)
			.sized(1F, 1F)
			.setUpdateInterval(1)
			.setTrackingRange(256)
			.build("railveh")
	);
	//
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("fvtm", "channel"))
		.clientAcceptedVersions(pro -> true)
		.serverAcceptedVersions(pro -> true)
		.networkProtocolVersion(() -> "fvtm4")
		.simpleChannel();
	//
	public static final HashMap<String, DeferredRegister<Block>> BLOCK_REGISTRY = new HashMap<>();
	public static final HashMap<String, DeferredRegister<SoundEvent>> SOUND_REGISTY = new HashMap<>();
	//
	public static final DeferredRegister<BlockEntityType<?>> BLOCKENTS = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "fvtm");
	public static final RegistryObject<BlockEntityType<VehicleLiftEntity>> LIFT_ENTITY = BLOCKENTS.register("vehicle_lift", () ->
		BlockEntityType.Builder.of(VehicleLiftEntity::new, FvtmGetters.LIFT_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<ConstructorEntity>> CONST_ENTITY = BLOCKENTS.register("constructor", () ->
			BlockEntityType.Builder.of(ConstructorEntity::new, FvtmGetters.CONST_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<BaseBlockEntity>> BLOCK_ENTITY = BLOCKENTS.register("blockbase", () ->
		BlockEntityType.Builder.of(BaseBlockEntity::new, getBlockArray()).build(null));

	private static Block[] getBlockArray(){
		ArrayList<Block> list = new ArrayList<>();
		BLOCK_REGISTRY.values().forEach(reg -> {
			reg.getEntries().forEach(obj -> {
				if(obj.get() instanceof BlockBase) list.add(obj.get());
			});
		});
		return list.toArray(new Block[0]);
	}

	public FVTM4(){
		FvtmRegistry.init("1.20", FMLPaths.CONFIGDIR.get().toFile());
		FvtmLogger.LOGGER = new FvtmLogger() {
			@Override
			protected void log0(Object obj){
				LOGGER4.info(obj == null ? "null " + new Exception().getStackTrace()[2].toString() : obj.toString());
			}
		};
		EnvInfo.CLIENT = FMLLoader.getDist().isClient();
		FvtmGetters.DECORATION_ENTITY = () -> DECORATION_ENTITY.get();
		FvtmGetters.ROAD_MARKER_ENTITY = () -> ROAD_MARKER_ENTITY.get();
		FvtmGetters.RAIL_MARKER_ENTITY = () -> RAIL_MARKER_ENTITY.get();
		FvtmGetters.ROOTVEHICLE_ENTITY = () -> VEHICLE_ENTITY.get();
		FvtmGetters.RAILVEHICLE_ENTITY = () -> RAILVEH_ENTITY.get();
		FvtmGetters.WHEEL_ENTITY = () -> WHEEL_ENTITY.get();
		FvtmGetters.WHEEL_ENTITY_CLASS = WheelEntityF.class;
		FvtmGetters.RENDERCACHE = entity -> entity.getCapability(RenderCacheProvider.CAPABILITY).resolve().get();
		FvtmGetters.LIFT_ENTITY = () -> LIFT_ENTITY.get();
		FvtmGetters.CONST_ENTITY = () -> CONST_ENTITY.get();
		FvtmGetters.BLOCK_ENTITY = () -> BLOCK_ENTITY.get();
		StackWrapperProvider.IMPL = SWIE.class;
		if(EnvInfo.CLIENT){
			CTab.IMPL[0] = TabInitializerF.class;
		}
		FVTM20.CONFIG = new Config(new File(FMLPaths.CONFIGDIR.get().toFile(), "fvtm.json"));
		FVTM20.init0();
		FvtmRegistry.ADDONS.forEach(addon -> ITEM_REGISTRY.put(addon.getID().id(), DeferredRegister.create(Registries.ITEM, addon.getID().id())));
		FvtmRegistry.ADDONS.forEach(addon -> BLOCK_REGISTRY.put(addon.getID().id(), DeferredRegister.create(Registries.BLOCK, addon.getID().id())));
		FVTM20.init1();
		regSounds();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::commonSetup);
		bus.register(new PackAdder());
		ITEM_REGISTRY.values().forEach(reg -> reg.register(bus));
		CREATIVE_MODE_TABS.register(bus);
		ENTITIES.register(bus);
		BLOCK_REGISTRY.values().forEach(reg -> reg.register(bus));
		BLOCKENTS.register(bus);
		SOUND_REGISTY.values().forEach(reg -> reg.register(bus));
	}

	private void regSounds(){
		FvtmRegistry.VEHICLES.forEach(vehicle -> {
			vehicle.getSounds().values().forEach(sound -> {
				if(sound.soundid.space().equals("minecraft")) return;
				if(!SOUND_REGISTY.containsKey(sound.soundid.space())){
					SOUND_REGISTY.put(sound.soundid.space(), DeferredRegister.create(Registries.SOUND_EVENT, sound.soundid.space()));
				}
				SOUND_REGISTY.get(sound.soundid.space()).register(sound.soundid.id(), () -> {
					SoundEvent ev = SoundEvent.createVariableRangeEvent(sound.soundid.local());
					sound.event = ev;
					return ev;
				});
			});
		});
		FvtmRegistry.PARTS.forEach(part -> {
			part.getSounds().values().forEach(sound -> {
				if(sound.soundid.space().equals("minecraft")) return;
				if(!SOUND_REGISTY.containsKey(sound.soundid.space())){
					SOUND_REGISTY.put(sound.soundid.space(), DeferredRegister.create(Registries.SOUND_EVENT, sound.soundid.space()));
				}
				SOUND_REGISTY.get(sound.soundid.space()).register(sound.soundid.id(), () -> {
					SoundEvent ev = SoundEvent.createVariableRangeEvent(sound.soundid.local());
					sound.event = ev;
					return ev;
				});
			});
		});
	}

	private void commonSetup(final FMLCommonSetupEvent event){
		new Packets20F().init();
		WrapperHolderImpl.LEVEL_PROVIDER = lvl -> new WorldWIE((Level)lvl);
		FvtmRegistry.VEHICLES.forEach(vehicle -> {
			vehicle.getSounds().values().forEach(sound -> {
				if(sound.soundid.space().equals("minecraft")){
					sound.event = BuiltInRegistries.SOUND_EVENT.get((ResourceLocation)sound.soundid.local());
				}
			});
		});
		FvtmRegistry.PARTS.forEach(part -> {
			part.getSounds().values().forEach(sound -> {
				if(sound.soundid.space().equals("minecraft")){
					sound.event = BuiltInRegistries.SOUND_EVENT.get((ResourceLocation)sound.soundid.local());
				}
			});
		});
		FvtmResources.INSTANCE.registerRecipes();
	}

	public static class PackAdder {

		@SubscribeEvent
		public void addPacks(AddPackFindersEvent event){
			for(Addon addon : FvtmRegistry.ADDONS){
				if(!addon.getLocation().isConfigPack() || addon.getFile() == null) continue;
				Pack pack = Pack.create("fvtm/" + addon.getID().id(), Component.literal(addon.getName()), true, path -> {
					if(addon.getFile().isDirectory()) return new PathPackResources(path, addon.getFile().toPath(), true);
					else return new FilePackResources(addon.getName(), addon.getFile(), true);
				}, new Pack.Info(Component.literal("FVTM Auto-loaded Pack"), 15, 15, FeatureFlagSet.of(), false), event.getPackType(), Pack.Position.BOTTOM, false, PackSource.DEFAULT);
				event.addRepositorySource(cons -> {
					if(pack != null) cons.accept(pack);
				});
			}
		}

	}

	@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class Events {

		@SubscribeEvent
		public static void onAttachEntityCaps(AttachCapabilitiesEvent<Entity> event){
			if(!EnvInfo.CLIENT) return;
			if(event.getObject() instanceof DecorationEntity || event.getObject() instanceof RootVehicle){
				event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheProvider(event.getObject()));
			}
		}

		@SubscribeEvent
		public static void onAttachWorldCaps(AttachCapabilitiesEvent<Level> event){
			SystemManager.onAttachWorldCapabilities(WrapperHolder.getWorld(event.getObject()));
		}

		@SubscribeEvent
		public static void onCmdReg(RegisterCommandsEvent event){
			event.getDispatcher().register(FVTM20.genCommand());
		}

	}

}
