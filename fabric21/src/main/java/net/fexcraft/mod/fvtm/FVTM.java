package net.fexcraft.mod.fvtm;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fexcraft.mod.fcl.FCL;
import net.fexcraft.mod.fcl.util.EntityUtil;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.impl.AABBI;
import net.fexcraft.mod.fvtm.impl.EntityWIE;
import net.fexcraft.mod.fvtm.impl.Packets21;
import net.fexcraft.mod.fvtm.impl.WorldWIE;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.ui.RoadSlot;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.ui.VehicleCatalogImpl;
import net.fexcraft.mod.fvtm.util.CTab;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.fvtm.util.TabInitializer;
import net.fexcraft.mod.uni.impl.WrapperHolderImpl;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.ui.UISlot;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.FilePackResources.FileResourcesSupplier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FVTM implements ModInitializer {

	public static LinkedHashSet<RepositorySource> fvtm_packs = new LinkedHashSet<>();
	private boolean regrecipe;

	@Override
	public void onInitialize(){
		FvtmRegistry.init("1.21", new File(FabricLoader.getInstance().getGameDirectory(), "/config/"));
		Logger LOGGER21 = LoggerFactory.getLogger("fvtm");
		FvtmLogger.LOGGER = new FvtmLogger() {
			@Override
			protected void log0(Object obj){
				LOGGER21.info(obj == null ? "null " + new Exception().getStackTrace()[2].toString() : obj.toString());
			}
		};
		//
		FCL.INIT_COMPLETE.add(() -> {
			WrapperHolderImpl.LEVEL_PROVIDER = lvl -> new WorldWIE((Level)lvl);
			EntityUtil.IMPL = EntityWIE.class;
		});
		CTab.IMPL[0] = TabInitializer.class;
		StackWrapper.ITEM_TYPES.put(ContentType.ITYPE, item -> item instanceof ContentItem<?>);
		StackWrapper.ITEM_TYPES.put(ContentType.PART.item_type, item -> item instanceof PartItem);
		StackWrapper.ITEM_TYPES.put(ContentType.MATERIAL.item_type, item -> item instanceof MaterialItem);
		StackWrapper.ITEM_TYPES.put(ContentType.VEHICLE.item_type, item -> item instanceof VehicleItem);
		/*StackWrapper.ITEM_TYPES.put(ContentType.BLOCK.item_type, item -> item instanceof BlockItem);*/
		StackWrapper.ITEM_TYPES.put(ContentType.TOOLBOX.item_type, item -> item instanceof ToolboxItem);
		StackWrapper.ITEM_TYPES.put(ContentType.WIRE.item_type, item -> item instanceof WireItem);
		StackWrapper.CONTENT_TYPES.put(ContentType.PART.item_type, stack -> ((PartItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.VEHICLE.item_type, stack -> ((VehicleItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.MATERIAL.item_type, stack -> {
			return stack.getItem().direct() instanceof MaterialItem ? ((MaterialItem)stack.getItem().direct()).getContent() : null;
		});
		StackWrapper.CONTENT_TYPES.put(ContentType.CONSUMABLE.item_type, stack -> ((ConsumableItem)stack.getItem().direct()).getContent());
		/*StackWrapper.CONTENT_TYPES.put(ContentType.BLOCK.item_type, stack -> ((BlockItem)stack.getItem().direct()).getData(stack));*/
		StackWrapper.CONTENT_TYPES.put(ContentType.RAILGAUGE.item_type, stack -> ((RailGaugeItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.WIRE.item_type, stack -> ((WireItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.TOOLBOX.item_type, stack -> ((ToolboxItem)stack.getItem().direct()).var);
		AABB.SUPPLIER = () -> new AABBI();
		/*BlockType.BLOCK_IMPL = BlockTypeImpl::get;*/
		FvtmResources.INSTANCE = new Resources21();
		LoopedSound.ACTIVATE = sound -> {
			/*sound.localsound = new LoopSound(sound);*/
			net.minecraft.client.Minecraft.getInstance().getSoundManager().play((SoundInstance)sound.localsound);
		};
		FvtmRegistry.CONFIG.addListener(() -> {
			//
		});
		//
		UIKeys.VEHICLE_CATALOG_IMPL = VehicleCatalogImpl.class;
		UIKeys.register();
		UISlot.GETTERS.put("fvtm:roadfill", args -> new RoadSlot(args));
		//
		Resources21.WHEEL_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE, "fvtm:wheel", new EntityType<>(WheelEntity::new,
			MobCategory.MISC, true, false, true, true,
			ImmutableSet.of(), EntityDimensions.fixed(0.25f, 0.25f),
			0, 256, 1, "fvtm.wheel", Optional.empty(), FeatureFlagSet.of()));
		//FabricDefaultAttributeRegistry.register(Resources21.WHEEL_ENTITY, LivingEntity.createLivingAttributes().build());
		Resources21.VEHICLE_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE, "fvtm:vehicle", new EntityType<>(RootVehicle::new,
			MobCategory.MISC, true, false, true, true,
			ImmutableSet.of(), EntityDimensions.fixed(1f, 1f),
			0, 256, 1, "fvtm.vehicle", Optional.empty(), FeatureFlagSet.of()));
		Resources21.RAIL_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE, "fvtm:rail_vehicle", new EntityType<>(RailVehicle::new,
			MobCategory.MISC, true, false, true, true,
			ImmutableSet.of(), EntityDimensions.fixed(1f, 1f),
			0, 256, 1, "fvtm.rail_vehicle", Optional.empty(), FeatureFlagSet.of()));
		Resources21.DECO_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE, "fvtm:decoration", new EntityType<>(DecorationEntity::new,
			MobCategory.MISC, true, false, true, true,
			ImmutableSet.of(), EntityDimensions.fixed(0.25f, 0.25f),
			0, 256, 1, "fvtm.decoration", Optional.empty(), FeatureFlagSet.of()));
		Resources21.RAIL_MARKER_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE, "fvtm:rail_marker", new EntityType<>(RailMarker::new,
			MobCategory.MISC, true, false, true, true,
			ImmutableSet.of(), EntityDimensions.fixed(0.5f, 1f),
			0, 256, 1, "fvtm.rail_marker", Optional.empty(), FeatureFlagSet.of()));
		Resources21.ROAD_MARKER_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE, "fvtm:road_marker", new EntityType<>(RoadMarker::new,
			MobCategory.MISC, true, false, true, true,
			ImmutableSet.of(), EntityDimensions.fixed(0.5f, 1f),
			0, 256, 1, "fvtm.road_marker", Optional.empty(), FeatureFlagSet.of()));
		//
		FvtmResources.INSTANCE.init();
		for(Addon addon : FvtmRegistry.ADDONS){
			if(!addon.getLocation().isConfigPack() || addon.getFile() == null) continue;
			var pli = new PackLocationInfo("fvtm/" + addon.getID().id(), Component.literal(addon.getName()), PackSource.BUILT_IN, Optional.empty());
			var rs = addon.getFile().isDirectory() ? new PathPackResources.PathResourcesSupplier(addon.getFile().toPath()) : new FileResourcesSupplier(addon.getFile());
			var pack = Pack.readMetaAndCreate(pli, rs, PackType.SERVER_DATA, new PackSelectionConfig(true, Pack.Position.BOTTOM, false));
			fvtm_packs.add(cons -> cons.accept(pack));
		}
		FvtmResources.INSTANCE.registerFvtmBlocks();
		FvtmResources.INSTANCE.registerFvtmItems();
		FvtmResources.INSTANCE.registerAttributes();
		FvtmResources.INSTANCE.registerFunctions();
		FvtmResources.INSTANCE.registerHandlers();
		FvtmResources.INSTANCE.searchContent();
		FvtmResources.INSTANCE.createContentBlocks();
		FvtmResources.INSTANCE.createContentItems();
		//
		(Packets.INSTANCE = new Packets21()).init();
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
		CommonLifecycleEvents.TAGS_LOADED.register((ra, bool) -> {
			if(regrecipe) return;
			FvtmResources.INSTANCE.registerRecipes();
			regrecipe = true;
		});
	}

	public static <I extends Item> I regItem(String idl, Function<Item.Properties, Item> func){
		return (I)regItem(idl, func, new Item.Properties());
	}

	public static <I extends Item> I regItem(String idl, Function<Item.Properties, Item> func, Item.Properties prop){
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.parse(idl));
		Item item = Items.registerItem(key, func, prop);
		Resources21.addItem(idl, item);
		return (I)item;
	}

	public static Pair<Block, BlockItem> regBlock(String idl, Function<Block.Properties, Block> factory){
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(idl));
		Block block = Blocks.register(key, factory, BlockBehaviour.Properties.of());
		Item item = Items.registerBlock(block);
		Resources21.addItem(idl, item);
		return Pair.of(block, (BlockItem)item);
	}

	public static <T extends BlockEntity> BlockEntityType<T> regBlockEntity(String idl, FabricBlockEntityTypeBuilder.Factory<BlockEntity> supp, Block... blocks){
		return (BlockEntityType<T>)Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, idl, FabricBlockEntityTypeBuilder.create(supp, blocks).build());
	}

}