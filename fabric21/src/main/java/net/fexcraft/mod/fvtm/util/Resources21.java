package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fcl.util.ExternalTextures;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.*;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms21;
import net.fexcraft.mod.fvtm.render.Transforms21;
import net.fexcraft.mod.uni.FclRecipe;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.impl.IWI;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.commons.lang3.tuple.Pair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.UUID;

import static net.fexcraft.mod.fvtm.FvtmRegistry.BLOCKS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Resources21 extends FvtmResources {

	public static LinkedHashMap<String, LinkedHashMap<String, Item>> ITEMS = new LinkedHashMap<>();
	public static RoadToolItem ROAD_TOOL_ITEM;
	public static ToolboxItem[] TOOLBOX = new ToolboxItem[ToolboxType.values().length];
	public static JunctionTool JUNCTION_TOOL;
	//
	public static Asphalt[] ASPHALT = new Asphalt[16];
	public static BlockItem[] ASPHALT_ITEM = new BlockItem[16];
	public static BlockEntityType<BaseBlockEntity> BASE_ENTITY;
	public static ArrayList<Block> BLOCK_LIST = new ArrayList<>();
	//
	public static VehicleLiftBlock LIFT_BLOCK;
	public static BlockItem LIFT_BLOCK_ITEM;
	public static BlockEntityType<VehicleLiftEntity> LIFT_ENTITY;
	//
	public static ConstructorBlock CONST_BLOCK;
	public static BlockItem CONST_BLOCK_ITEM;
	public static BlockEntityType<ConstructorEntity> CONST_ENTITY;
	//
	public static FuelFillerBlock FUELFILLER_BLOCK;
	public static BlockItem FUELFILLER_ITEM;
	public static BlockEntityType<FuelFillerEntity> FUELFILLER_ENTITY;
	//
	public static EntityType<WheelEntity> WHEEL_ENTITY;
	public static EntityType<RootVehicle> VEHICLE_ENTITY;
	public static EntityType<RailVehicle> RAIL_ENTITY;
	public static EntityType<RoadMarker> ROAD_MARKER_ENTITY;
	public static EntityType<RailMarker> RAIL_MARKER_ENTITY;
	public static EntityType<DecorationEntity> DECO_ENTITY;

	public static void addItem(String idl, Item item){
		String[] split = idl.split(":");
		if(!ITEMS.containsKey(split[0])) ITEMS.put(split[0], new LinkedHashMap<>());
		ITEMS.get(split[0]).put(idl, item);
	}

	@Override
	public void searchASMPacks(){}

	@Override
	public boolean searchPacksInResourcePacks(){
		return true;
	}

	@Override
	public void loadPackTextures(){}

	@Override
	public void createContentBlocks(){
		BLOCKS.forEach(block -> {
			Pair<Block, BlockItem> pair = FVTM.regBlock(block.getIDS(), block::genBlock, (blk, prop) -> new BlockItem21(prop, blk));
			block.setItemWrapper(wrapwrapper(block.getID(), pair.getRight()));
			BLOCK_LIST.add(pair.getLeft());
		});
		BASE_ENTITY = FVTM.regBlockEntity("fvtm:blockbase", BaseBlockEntity::new, BLOCK_LIST.toArray(new Block[0]));
	}

	@Override
	public void createContentItems(){
		FvtmRegistry.MATERIALS.forEach(mat -> mat.setItemWrapper(wrapwrapper(mat.getID(), FVTM.regItem(mat.getIDS(), prop -> new MaterialItem(prop, mat)))));
		FvtmRegistry.CONSUMABLES.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), FVTM.regItem(con.getIDS(), prop -> new ConsumableItem(prop, con)))));
		FvtmRegistry.PARTS.forEach(part -> part.setItemWrapper(wrapwrapper(part.getID(), FVTM.regItem(part.getIDS(), prop -> new PartItem(prop, part)))));
		FvtmRegistry.VEHICLES.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), FVTM.regItem(veh.getIDS(), prop -> new VehicleItem(prop, veh)))));
		//Block Items
		FvtmRegistry.DECORATIONS.forEach(dec -> dec.setItemWrapper(wrapwrapper(dec.getID(), FVTM.regItem(dec.getIDS(), prop -> new DecorationItem(prop, dec)))));
		FvtmRegistry.RAILGAUGES.forEach(rg -> rg.setItemWrapper(wrapwrapper(rg.getID(), FVTM.regItem(rg.getIDS(), prop -> new RailGaugeItem(prop, rg)))));
		FvtmRegistry.WIRES.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), FVTM.regItem(wire.getIDS(), prop -> new WireItem(prop, wire)))));
		FvtmRegistry.WIREDECOS.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), FVTM.regItem(wire.getIDS(), prop -> new WireDecoItem(prop, wire)))));
		FvtmRegistry.SIGNS.forEach(sign -> sign.setItemWrapper(wrapwrapper(sign.getID(), FVTM.regItem(sign.getIDS(), prop -> new SignItem(prop, sign)))));
	}

	@Override
	public void registerFvtmRecipes(){
		String blockcat = "recipe.fvtm.blocks";
		FclRecipe.newBuilder(blockcat).output(new ItemStack(CONST_BLOCK_ITEM))
				.add(new ItemStack(Blocks.IRON_BLOCK))
				.add(new ItemStack(Items.COMPARATOR, 4))
				.add(new ItemStack(Items.REPEATER, 8))
				.add(new ItemStack(Items.REDSTONE, 16))
				.add(new ItemStack(Items.BOOK, 2))
				.add(new ItemStack(Blocks.LEVER, 8))
				.register();
		FclRecipe.newBuilder(blockcat).output(new ItemStack(LIFT_BLOCK_ITEM))
				.add(new ItemStack(Blocks.IRON_BLOCK, 2))
				.add(new ItemStack(Items.IRON_INGOT, 8))
				.add(new ItemStack(Items.COMPARATOR, 2))
				.add(new ItemStack(Items.REPEATER, 4))
				.add(new ItemStack(Items.REDSTONE, 4))
				.add(new ItemStack(Items.BOOK, 1))
				.add(new ItemStack(Blocks.LEVER, 2))
				.add(new ItemStack(Blocks.PISTON, 2))
				.register();
		FclRecipe.newBuilder(blockcat).output(new ItemStack(FUELFILLER_ITEM))
			.add(new ItemStack(Blocks.IRON_BLOCK))
			.add(new ItemStack(Blocks.HOPPER, 2))
			.add(new ItemStack(Blocks.STONE_BUTTON,4))
			.register();
		//
		String itemcat = "recipe.fvtm.items";
		for(int i = 0; i < TOOLBOX.length; i++){
			FclRecipe.newBuilder(itemcat).output(new ItemStack(TOOLBOX[i]))
				.add(new ItemStack(Items.IRON_INGOT, 4))
				.add(new ItemStack(Items.COPPER_INGOT, 2))
				.register();
		}
		FclRecipe.newBuilder(itemcat).output(new ItemStack(JUNCTION_TOOL))
			.add(new ItemStack(Items.IRON_INGOT, 2))
			.add(new ItemStack(Items.COPPER_INGOT, 2))
			.add(new ItemStack(Items.REDSTONE, 2))
			.add(new ItemStack(Items.LEVER, 2))
			.register();
	}

	private ItemWrapper wrapwrapper(IDL id, Item item){
		if(FvtmRegistry.CONTENT_ITEMS.containsKey(id)){
			return FvtmRegistry.CONTENT_ITEMS.get(id);
		}
		IWI iwr = new IWI(item);
		FvtmRegistry.CONTENT_ITEMS.put(id, iwr);
		FvtmRegistry.ITEMS.put(id.colon(), iwr);
		return iwr;
	}

	@Override
	public ItemWrapper getItemWrapper(String id){
		Optional<Holder.Reference<Item>> item = BuiltInRegistries.ITEM.get(ResourceLocation.parse(id));
		return item.isEmpty() ? null : new IWI(item.get().value());
	}

	@Override
	public StackWrapper newStack0(ItemWrapper item){
		return SWI.parse(item);
	}

	@Override
	public void initModelPrograms(){
		Transforms.GET_TRANSFORM = (args -> {
			switch(args[0]){
				case "translation":
				case "translate":
				case "trans":
				case "tra":
				case "tr":
					return (Transforms.Transformer)new Transforms21.TF_Translate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "rotation":
				case "rotate":
				case "rot":
					return (Transforms.Transformer)new Transforms21.TF_Rotate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]));
				case "scale":
					if(args.length < 3){
						float scale = Float.parseFloat(args[1]);
						return (Transforms.Transformer)new Transforms21.TF_Scale(scale, scale, scale);
					}
					return (Transforms.Transformer)new Transforms21.TF_Scale(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "gl_rescale_normal":
				case "rescale_normal":
					return (Transforms.Transformer)Transforms21.TF_RESCALE_NORMAL;
			}
			return null;
		});
		DefaultPrograms21.init();
		ConditionalPrograms.init();
	}

	@Override
	public void initModels(){
		ArrayList<String> tt = new ArrayList<>();
		for(ItemDisplayContext value : ItemDisplayContext.values()) tt.add(value.name());
		TransformMap.TYPES = tt.toArray(new String[0]);
		super.initModels();
	}

	@Override
	public InputStream getAssetInputStream(IDL loc, boolean log){
		try{
			return Minecraft.getInstance().getResourceManager().getResource(loc.local()).get().open();
		}
		catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isModPresent(String s){
		return false;
	}

	@Override
	public IDL getExternalTexture0(String custom){
		return ExternalTextures.get("fvtm", custom);
	}

	@Override
	public void registerFvtmBlocks(){
		Pair<Block, BlockItem> reg;
		for(int idx = 0; idx < ASPHALT.length; idx++){
			int index = idx;
			reg = FVTM.regBlock("fvtm:asphalt_" + idx, prop -> new Asphalt(prop, index));
			ASPHALT[idx] = (Asphalt)reg.getLeft();
			ASPHALT_ITEM[idx] = reg.getRight();
		}
		reg = FVTM.regBlock("fvtm:vehicle_lift", prop -> new VehicleLiftBlock(prop));
		LIFT_BLOCK = (VehicleLiftBlock)reg.getLeft();
		LIFT_BLOCK_ITEM = reg.getRight();
		LIFT_ENTITY = FVTM.regBlockEntity("fvtm:vehicle_lift", VehicleLiftEntity::new, LIFT_BLOCK);
		reg = FVTM.regBlock("fvtm:constructor", prop -> new ConstructorBlock(prop));
		CONST_BLOCK = (ConstructorBlock)reg.getLeft();
		CONST_BLOCK_ITEM = reg.getRight();
		CONST_ENTITY = FVTM.regBlockEntity("fvtm:constructor", ConstructorEntity::new, CONST_BLOCK);
		reg = FVTM.regBlock("fvtm:fuel_filler", prop -> new FuelFillerBlock(prop));
		FUELFILLER_BLOCK = (FuelFillerBlock)reg.getLeft();
		FUELFILLER_ITEM = reg.getRight();
		FUELFILLER_ENTITY = FVTM.regBlockEntity("fvtm:fuel_filler", FuelFillerEntity::new, FUELFILLER_BLOCK);
	}

	@Override
	public void registerFvtmItems(){
		ROAD_TOOL_ITEM = FVTM.regItem("fvtm:road_tool", prop -> new RoadToolItem(prop));
		for(ToolboxType val : ToolboxType.values()){
			TOOLBOX[val.idx] = (ToolboxItem)FVTM.regItem("fvtm:toolbox_" + val.idx, prop -> new ToolboxItem(prop, val.idx));
		}
		JUNCTION_TOOL = FVTM.regItem("fvtm:junction_tool", prop -> new JunctionTool(prop));
	}

	@Override
	public double getMouseSensitivity(){
		return 0;
	}

	@Override
	public Object getBlockMaterial(String key, boolean allownull){
		return null;
	}

	@Override
	public void spawnRoadMarker(WorldW world, QV3D vector, UUID nid){
		RoadMarker marker = ROAD_MARKER_ENTITY.create(world.local(), EntitySpawnReason.SPAWN_ITEM_USE);
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y + 1, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);
	}

	@Override
	public void spawnRailMarker(WorldW world, QV3D vector, UUID nid){
		RailMarker marker = RAIL_MARKER_ENTITY.create(world.local(), EntitySpawnReason.SPAWN_ITEM_USE);
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);
	}

	@Override
	public void linkItemContainer(ItemWrapper item){

	}

}