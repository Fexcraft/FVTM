package net.fexcraft.mod.fvtm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.fexcraft.mod.fcl.local.CraftingEntity;
import net.fexcraft.mod.fcl.util.EntityUtil;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.impl.AABBI;
import net.fexcraft.mod.fvtm.impl.WorldWIE;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.CTab;
import net.fexcraft.mod.fvtm.util.EntityWIE;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.fvtm.util.TabInitializer;
import net.fexcraft.mod.uni.impl.WrapperHolderImpl;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FVTM implements ModInitializer {

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
		EntityUtil.IMPL = EntityWIE.class;
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
		/*UIKeys.VEHICLE_CATALOG_IMPL = VehicleCatalogImpl.class;*/
		UIKeys.register();
		/*UISlot.GETTERS.put("fvtm:roadfill", args -> new RoadSlot(args));*/
		//
		FvtmResources.INSTANCE.init();
		FvtmResources.INSTANCE.registerFvtmBlocks();
		FvtmResources.INSTANCE.registerFvtmItems();
		FvtmResources.INSTANCE.registerAttributes();
		FvtmResources.INSTANCE.registerFunctions();
		FvtmResources.INSTANCE.registerHandlers();
		FvtmResources.INSTANCE.searchContent();
		FvtmResources.INSTANCE.createContentBlocks();
		FvtmResources.INSTANCE.createContentItems();
		//
		//TODO init packets
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