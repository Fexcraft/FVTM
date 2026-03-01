package net.fexcraft.mod.fvtm;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.FvtmPlayer;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.render.Renderer20;
import net.fexcraft.mod.fvtm.sys.rail.LongDisRailUtil;
import net.fexcraft.mod.fvtm.sys.uni.UniWheel;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.ui.*;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.ui.UISlot;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FVTM20 {

	public static void init0(){
		StackWrapper.ITEM_TYPES.put(ContentType.ITYPE, item -> item instanceof ContentItem<?>);
		StackWrapper.ITEM_TYPES.put(ContentType.PART.item_type, item -> item instanceof PartItem);
		StackWrapper.ITEM_TYPES.put(ContentType.MATERIAL.item_type, item -> item instanceof MaterialItem);
		StackWrapper.ITEM_TYPES.put(ContentType.VEHICLE.item_type, item -> item instanceof VehicleItem);
		StackWrapper.ITEM_TYPES.put(ContentType.BLOCK.item_type, item -> item instanceof BlockItem20);
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
		StackWrapper.CONTENT_TYPES.put(ContentType.BLOCK.item_type, stack -> ((BlockItem20)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.RAILGAUGE.item_type, stack -> ((RailGaugeItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.WIRE.item_type, stack -> ((WireItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.WIREDECO.item_type, stack -> ((WireDecoItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.SIGN.item_type, stack -> ((SignItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.TOOLBOX.item_type, stack -> ((ToolboxItem)stack.getItem().direct()).var);
		//UniStack.STACK_GETTER = obj -> SWIE.parse(obj);
		BlockType.BLOCK_IMPL = BlockTypeImpl::get;
		if(EnvInfo.CLIENT){
			FvtmRegistry.CONFIG.addListener(DefaultPrograms::setupSignalTimer);
			Renderer.RENDERER = new Renderer20();
			GLO.SUPPLIER = (() -> new GLObject());
		}
		FvtmResources.INSTANCE = new Resources20();
		LoopedSound.ACTIVATE = sound -> {
			sound.localsound = new LoopSound(sound);
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
			ent.stepheight = uw.wtd() == null ? uw.vehicle.spdata == null ? 1f : uw.vehicle.spdata.wheel_step_height : uw.wtd().function.step_height;
		};
		//
		FvtmResources.INSTANCE.init();
	}

	public static void init1(){
		FvtmResources.INSTANCE.registerFvtmBlocks();
		FvtmResources.INSTANCE.registerFvtmItems();
		if(Config.MD_VEHICLE){
			FvtmResources.INSTANCE.registerAttributes();
			FvtmResources.INSTANCE.registerFunctions();
			FvtmResources.INSTANCE.registerHandlers();
		}
		FvtmResources.INSTANCE.searchContent();
		FvtmResources.INSTANCE.createContentBlocks();
		FvtmResources.INSTANCE.createContentItems();
		if(EnvInfo.CLIENT){
			FvtmResources.initModelSystem();
			if(DefaultPrograms.SIGNAL_TIMER[0] == null){
				DefaultPrograms.setupSignalTimer();
			}
		}
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
					Block block = BuiltInRegistries.BLOCK.get(new ResourceLocation(array.get(0).string_value()));
					player.level().setBlock(pos, block.defaultBlockState(), 3);
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
