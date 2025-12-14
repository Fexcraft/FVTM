package net.fexcraft.mod.fvtm;

import com.google.common.collect.ImmutableSet;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.*;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fcl.FCL;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.FvtmPlayer;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.impl.Packets21;
import net.fexcraft.mod.fvtm.impl.WorldWIE;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.rail.LongDisRailUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.UniWheel;
import net.fexcraft.mod.fvtm.ui.RoadSlot;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.ui.VehicleCatalogImpl;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniChunk;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.impl.AABBI;
import net.fexcraft.mod.uni.impl.WrapperHolderImpl;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.ui.UISlot;
import net.fexcraft.mod.uni.world.AABB;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
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
import java.util.function.BiFunction;
import java.util.function.Function;

import static net.fexcraft.mod.fvtm.data.block.Block.BLK_GETTER;

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
		});
		CTab.IMPL[0] = TabInitializer.class;
		StackWrapper.ITEM_TYPES.put(ContentType.ITYPE, item -> item instanceof ContentItem<?>);
		StackWrapper.ITEM_TYPES.put(ContentType.PART.item_type, item -> item instanceof PartItem);
		StackWrapper.ITEM_TYPES.put(ContentType.MATERIAL.item_type, item -> item instanceof MaterialItem);
		StackWrapper.ITEM_TYPES.put(ContentType.VEHICLE.item_type, item -> item instanceof VehicleItem);
		StackWrapper.ITEM_TYPES.put(ContentType.BLOCK.item_type, item -> item instanceof BlockItem21);
		StackWrapper.ITEM_TYPES.put(ContentType.RAILGAUGE.item_type, item -> item instanceof RailGaugeItem);
		StackWrapper.ITEM_TYPES.put(ContentType.TOOLBOX.item_type, item -> item instanceof ToolboxItem);
		StackWrapper.ITEM_TYPES.put(ContentType.WIRE.item_type, item -> item instanceof WireItem);
		StackWrapper.ITEM_TYPES.put(ContentType.WIREDECO.item_type, item -> item instanceof WireDecoItem);
		StackWrapper.ITEM_TYPES.put(ContentType.SIGN.item_type, item -> item instanceof SignItem);
		StackWrapper.CONTENT_TYPES.put(ContentType.PART.item_type, stack -> ((PartItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.VEHICLE.item_type, stack -> ((VehicleItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.MATERIAL.item_type, stack -> {
			return stack.getItem().direct() instanceof MaterialItem ? ((MaterialItem)stack.getItem().direct()).getContent() : null;
		});
		StackWrapper.CONTENT_TYPES.put(ContentType.CONSUMABLE.item_type, stack -> ((ConsumableItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.BLOCK.item_type, stack -> ((BlockItem21)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.RAILGAUGE.item_type, stack -> ((RailGaugeItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.WIRE.item_type, stack -> ((WireItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.WIREDECO.item_type, stack -> ((WireDecoItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.SIGN.item_type, stack -> ((SignItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.TOOLBOX.item_type, stack -> ((ToolboxItem)stack.getItem().direct()).var);
		AABB.SUPPLIER = () -> new AABBI();
		AABB.WRAPPER = obj -> new AABBI((net.minecraft.world.phys.AABB)obj);
		BlockType.BLOCK_IMPL = BlockTypeImpl::get;
		BLK_GETTER = (blk, prop) -> {
			try{
				net.fexcraft.mod.fvtm.data.block.Block.BLK_GETTER_CACHE = blk;
				return BlockType.BLOCK_IMPL.get(blk.getBlockType(), blk.hasEntity() || blk.hasRelay(), blk.hasPlainModel())
					.getConstructor(BlockBehaviour.Properties.class, net.fexcraft.mod.fvtm.data.block.Block.class).newInstance(prop, blk);
			}
			catch(Throwable e){
				FvtmLogger.log(e, "block class creation");
				return null;
			}
		};
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
		UniWheel.SET_STEP = uw -> {
			RootVehicle ent = uw.vehicle.entity.local();
			float stepheight = uw.wtd() == null ? 0.5f : uw.wtd().function.step_height;
			ent.getAttributes().getInstance(Attributes.STEP_HEIGHT).setBaseValue(stepheight);
		};
		//
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
		FabricDefaultAttributeRegistry.register(Resources21.VEHICLE_ENTITY, LivingEntity.createLivingAttributes());
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
		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
			SystemManager.onServerStarting();
		});
		ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
			SystemManager.onServerStopping();
		});
		ServerChunkEvents.CHUNK_LOAD.register((level, chunk) -> {
			SystemManager.onChunkLoad(WrapperHolder.getWorld(level), UniChunk.getChunk(chunk));
		});
		ServerChunkEvents.CHUNK_UNLOAD.register((level, chunk) -> {
			SystemManager.onChunkUnload(WrapperHolder.getWorld(level), UniChunk.getChunk(chunk));
		});
		ServerWorldEvents.LOAD.register((server, level) -> {
			WorldW world = WrapperHolder.getWorld(level);
			SystemManager.initWorldSystems(world, world.type());
			SystemManager.onWorldLoad(world);
		});
		ServerWorldEvents.UNLOAD.register((server, level) -> {
			SystemManager.onWorldUnload(WrapperHolder.getWorld(level));
		});
		ServerTickEvents.START_SERVER_TICK.register(serv -> {
			SystemManager.onServerTick();
		});
		ServerPlayConnectionEvents.JOIN.register((handler, player, server) -> {
			if(server.overworld().isClientSide){
				RoadPlacingUtil.CL_CURRENT = null;
			}
			else{
				RoadPlacingCache.onLogIn(handler.player.getGameProfile().getId());
			}
			EntityW ple = UniEntity.getEntity(handler.player);
			SystemManager.syncPlayer(ple.getWorld().type().side_key(), ple);
		});
		ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
			if(!handler.player.level().isClientSide){
				RoadPlacingCache.onLogOut(handler.player.getGameProfile().getId());
			}
		});
		ServerPlayerEvents.AFTER_RESPAWN.register((old, neo, dim) -> {
			if(!dim) return;
			EntityW ple = UniEntity.getEntity(neo);
			SystemManager.syncPlayer(ple.getWorld().type().side_key(), ple);
		});
		CommandRegistrationCallback.EVENT.register((dis, reg, env) -> dis.register(genCommand()));
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

	public static Pair<Block, BlockItem> regBlock(String idl, Function<Block.Properties, Block> factory, BiFunction<Block, Item.Properties, Item> func){
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(idl));
		Block block = Blocks.register(key, factory, BlockBehaviour.Properties.of());
		Item item = Items.registerBlock(block, func);
		Resources21.addItem(idl, item);
		return Pair.of(block, (BlockItem)item);
	}

	public static <T extends BlockEntity> BlockEntityType<T> regBlockEntity(String idl, FabricBlockEntityTypeBuilder.Factory<BlockEntity> supp, Block... blocks){
		return (BlockEntityType<T>)Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, idl, FabricBlockEntityTypeBuilder.create(supp, blocks).build());
	}

	public static LiteralArgumentBuilder<CommandSourceStack> genCommand(){
		return Commands.literal("fvtm")
			.then(Commands.literal("undo").then(Commands.literal("road").executes(ctx -> {
				Player player = ctx.getSource().getPlayerOrException();
				EntityW pass = UniEntity.getEntity(player);
				JsonMap map = RoadPlacingCache.getLastEntry(player.getGameProfile().getId(), pass.getWorld().type().side_key());
				if(map == null || map.empty()){
					pass.send("No last road data in item.");
					return 0;
				}
				String dim = map.getString("LastRoadDim", "minecraft:overworld-s");
				if(!dim.equals(pass.getWorld().type().side_key())){
					pass.send("Last road was placed in &6DIM" + map.getString("LastRoadDim", "unknown"));
					pass.send("You are currently in &6DIM" + pass.getWorld().type().side_key());
					return 0;
				}
				map.rem("LastRoadDim");
				pass.send("&oUndo-ing last placed road...");
				for(String str : map.value.keySet()){
					JsonArray array = map.getArray(str);
					V3I vec = V3I.fromString(str);
					BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
					Optional<Holder.Reference<Block>> block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(array.get(0).string_value()));
					player.level().setBlock(pos, block.isPresent() ? block.get().value().defaultBlockState() : Blocks.AIR.defaultBlockState(), 3);
				}
				RoadPlacingCache.remLastEntry(player.getGameProfile().getId(), player.level().dimension().location().toString());
				pass.send("&7Last road undone.");
				return 0;
			})))
			.then(Commands.literal("debug").executes(ctx -> {
				Config.DEBUG_ACTIVE = !Config.DEBUG_ACTIVE;
				return 0;
			}))
			.then(Commands.literal("catalog").executes(ctx -> {
				UniEntity.getEntity(ctx.getSource().getPlayer()).openUI(UIKeys.VEHICLE_CATALOG, V3I.NULL);
				return 0;
			}))
			.then(Commands.literal("reload").executes(ctx -> {
				if(EnvInfo.DEV){
					ctx.getSource().sendSystemMessage(Component.literal("Reloading Config..."));
					FvtmRegistry.CONFIG.reload();
				}
				else{
					ctx.getSource().sendSystemMessage(Component.literal("Runtime reloading only available in dev-mode."));
				}
				return 0;
			}))
			.then(Commands.literal("get-key").executes(ctx -> {
				Player player = ctx.getSource().getPlayer();
				EntityW pass = UniEntity.getEntity(player);
				if(player.getVehicle() instanceof RootVehicle){
					RootVehicle ent = (RootVehicle)player.getVehicle();
					VehicleData data = ent.vehicle.data;
					if(data.getLock().isLocked()){
						pass.send("cmd.fvtm.get-key.is-locked");
					}
					else if(!UniEntity.getApp(player, Passenger.class).getSeatOn().seat.driver){
						pass.send("cmd.fvtm.get-key.not-driver");
					}
					else if(data.getAttributeInteger("generated_keys", 0) >= data.getType().getMaxKeys()){
						pass.send("cmd.fvtm.get-key.max-keys");
					}
					else{
						Material km = FvtmRegistry.MATERIALS.get(data.getType().getKeyType());
						if(km == null) km = FvtmRegistry.MATERIALS.get(Lockable.DEFAULT_KEY);
						if(km == null){
							pass.send("cmd.fvtm.get-key.not-found");
							pass.send("cmd.fvtm.get-key.check-gep");
						}
						else{
							StackWrapper keystack = km.getNewStack();
							keystack.updateTag(com -> com.set("LockCode", data.getLock().getCode()));
							pass.addStack(keystack);
							pass.send("cmd.fvtm.get-key.success");
						}
						Attribute<Integer> attr = data.getAttributeCasted("generated_keys");
						attr.set(attr.asInteger() + 1);
					}
				}
				return 0;
			}))
			.then(Commands.literal("long-rail")
				.then(Commands.literal("select").executes(ctx -> {
					LongDisRailUtil.add(UniEntity.get(ctx.getSource().getPlayer()).getApp(FvtmPlayer.class));
					return 0;
				}))
				.then(Commands.literal("status").executes(ctx -> {
					LongDisRailUtil.status(UniEntity.get(ctx.getSource().getPlayer()).getApp(FvtmPlayer.class));
					return 0;
				})).then(Commands.literal("set").then(Commands.argument("segmentation", IntegerArgumentType.integer(4, 32)).executes(ctx -> {
					LongDisRailUtil.seg(UniEntity.get(ctx.getSource().getPlayer()).getApp(FvtmPlayer.class), ctx.getArgument("segmentation", Integer.class));
					return 0;
				})))
				.then(Commands.literal("clear").executes(ctx -> {
					LongDisRailUtil.clear(UniEntity.get(ctx.getSource().getPlayer()).getApp(FvtmPlayer.class));
					return 0;
				}))
				.then(Commands.literal("start").executes(ctx -> {
					LongDisRailUtil.process(UniEntity.get(ctx.getSource().getPlayer()).getApp(FvtmPlayer.class));
					return 0;
				}))
			)
			;
	}

}