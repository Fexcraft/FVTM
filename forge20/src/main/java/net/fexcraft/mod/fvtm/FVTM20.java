package net.fexcraft.mod.fvtm;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fcl.util.EntityUtil;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.impl.AABBI;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.render.Renderer120;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.ui.*;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.ui.UISlot;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FVTM20 {

	public static Config CONFIG;

	public static void init0(){
		EntityUtil.IMPL = EntityWIE.class;
		StackWrapper.ITEM_TYPES.put(ContentType.ITYPE, item -> item instanceof ContentItem<?>);
		StackWrapper.ITEM_TYPES.put(ContentType.PART.item_type, item -> item instanceof PartItem);
		StackWrapper.ITEM_TYPES.put(ContentType.MATERIAL.item_type, item -> item instanceof MaterialItem);
		StackWrapper.ITEM_TYPES.put(ContentType.VEHICLE.item_type, item -> item instanceof VehicleItem);
		StackWrapper.ITEM_TYPES.put(ContentType.BLOCK.item_type, item -> item instanceof BlockItem);
		StackWrapper.ITEM_TYPES.put(ContentType.TOOLBOX.item_type, item -> item instanceof ToolboxItem);
		StackWrapper.ITEM_TYPES.put(ContentType.WIRE.item_type, item -> item instanceof WireItem);
		StackWrapper.CONTENT_TYPES.put(ContentType.PART.item_type, stack -> ((PartItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.VEHICLE.item_type, stack -> ((VehicleItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.MATERIAL.item_type, stack -> ((MaterialItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.CONSUMABLE.item_type, stack -> ((ConsumableItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.BLOCK.item_type, stack -> ((BlockItem)stack.getItem().direct()).getData(stack));
		StackWrapper.CONTENT_TYPES.put(ContentType.RAILGAUGE.item_type, stack -> ((RailGaugeItem)stack.getItem().direct()).getContent());
		StackWrapper.CONTENT_TYPES.put(ContentType.WIRE.item_type, stack -> ((WireItem)stack.getItem().direct()).getContent());
		//UniStack.STACK_GETTER = obj -> SWIE.parse(obj);
		AABB.SUPPLIER = () -> new AABBI();
		BlockType.BLOCK_IMPL = BlockTypeImpl::get;
		if(EnvInfo.CLIENT){
			CONFIG.addListener(DefaultPrograms::setupBlinkerTimer);
			Renderer.RENDERER = new Renderer120();
			GLO.SUPPLIER = (() -> new GLObject());
		}
		FvtmResources.INSTANCE = new ResourcesImpl();
		LoopedSound.ACTIVATE = sound -> {
			sound.localsound = new LoopSound(sound);
			net.minecraft.client.Minecraft.getInstance().getSoundManager().play((SoundInstance)sound.localsound);
		};
		CONFIG.addListener(() -> {
			//
		});
		//
		UIKeys.VEHICLE_CATALOG_IMPL = VehicleCatalogImpl.class;
		UIKeys.register();
		UISlot.GETTERS.put("fvtm:roadfill", args -> new RoadSlot(args));
		//
		FvtmResources.INSTANCE.init();
	}

	public static void init1(){
		FvtmResources.INSTANCE.registerFvtmBlocks();
		FvtmResources.INSTANCE.registerFvtmItems();
		FvtmResources.INSTANCE.registerAttributes();
		FvtmResources.INSTANCE.registerFunctions();
		FvtmResources.INSTANCE.registerHandlers();
		FvtmResources.INSTANCE.searchContent();
		FvtmResources.INSTANCE.createContentBlocks();
		FvtmResources.INSTANCE.createContentItems();
		if(EnvInfo.CLIENT){
			FvtmResources.initModelSystem();
			if(DefaultPrograms.BLINKER_TIMER == null){
				DefaultPrograms.setupBlinkerTimer();
			}
		}
	}

	public static LiteralArgumentBuilder<CommandSourceStack> genCommand(){
		return Commands.literal("fvtm")
			.then(Commands.literal("undo").then(Commands.literal("road").executes(ctx -> {
				Player player = ctx.getSource().getPlayerOrException();
				Passenger pass = UniEntity.getCasted(player);
				JsonMap map = RoadPlacingCache.getLastEntry(player.getGameProfile().getId(), player.level().dimension().location().toString());
				if(map == null || map.empty()){
					pass.send("No last road data in item.");
					return 0;
				}
				String dim = map.getString("LastRoadDim", "minecraft:overworld");
				if(!dim.equals(player.level().dimension().location().toString())){
					pass.send("Last road was placed in &6DIM" + map.getString("LastRoadDim", "unknown"));
					pass.send("You are currenctly in &6DIM" + player.level().dimension().location());
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
				DebugUtils.ACTIVE = !DebugUtils.ACTIVE;
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
		;
	}

}
