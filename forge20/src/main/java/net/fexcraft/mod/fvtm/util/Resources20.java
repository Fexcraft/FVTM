package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fcl.util.ExternalTextures;
import net.fexcraft.mod.fvtm.*;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.FuelFillerBlock;
import net.fexcraft.mod.fvtm.block.VehicleLiftBlock;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms20;
import net.fexcraft.mod.fvtm.render.Transforms120;
import net.fexcraft.mod.uni.FclRecipe;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.impl.IWI;
import net.fexcraft.mod.uni.impl.IWR;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Supplier;

import static net.fexcraft.mod.fvtm.FvtmRegistry.BLOCKS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Resources20 extends FvtmResources {

	public static Supplier<RoadToolItem> ROAD_TOOL_ITEM;
	public static Supplier<ToolboxItem>[] TOOLBOX = new Supplier[ToolboxType.values().length];
	public static Supplier<JunctionTool> JUNCTION_TOOL;
	public static Supplier<Asphalt>[] ASPHALT = new Supplier[16];
	public static Supplier<BlockItem>[] ASPHALT_ITEM = new Supplier[16];
	public static Supplier<VehicleLiftBlock> LIFT_BLOCK;
	public static Supplier<BlockItem> LIFT_BLOCK_ITEM;
	public static Supplier<ConstructorBlock> CONST_BLOCK;
	public static Supplier<FuelFillerBlock> FUELFILLER_BLOCK;
	public static Supplier<BlockItem> CONST_BLOCK_ITEM;
	public static Supplier<BlockItem> FUELFILLER_ITEM;

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
			FVTM4.BLOCK_REGISTRY.get(block.getID().space()).register(block.getID().id(), () -> block.genBlock(null));
		});
	}

	@Override
	public void createContentItems(){
		FvtmRegistry.MATERIALS.forEach(mat -> mat.setItemWrapper(wrapwrapper(mat.getID(), () -> new MaterialItem(mat))));
		FvtmRegistry.CONSUMABLES.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), () -> new ConsumableItem(con))));
		FvtmRegistry.PARTS.forEach(part -> part.setItemWrapper(wrapwrapper(part.getID(), () -> new PartItem(part))));
		FvtmRegistry.VEHICLES.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), () -> new VehicleItem(veh))));
		FvtmRegistry.BLOCKS.forEach(blk -> blk.setItemWrapper(wrapwrapper(blk.getID(), () -> {
			FvtmRegistry.CONTENT_BLOCKS.put(blk.getID(), blk.getBlock());
			return new net.fexcraft.mod.fvtm.item.BlockItem(blk);
		})));
		FvtmRegistry.DECORATIONS.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), () -> new DecorationItem(veh))));
		FvtmRegistry.RAILGAUGES.forEach(rg -> rg.setItemWrapper(wrapwrapper(rg.getID(), () -> new RailGaugeItem(rg))));
		FvtmRegistry.WIRES.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), () -> new WireItem(wire))));
		FvtmRegistry.WIREDECOS.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), () -> new WireDecoItem(wire))));
		FvtmRegistry.SIGNS.forEach(sign -> sign.setItemWrapper(wrapwrapper(sign.getID(), () -> new SignItem(sign))));
	}

	@Override
	public void registerFvtmRecipes(){
		//StackWrapper.EMPTY = SWIE.parse(ItemStack.EMPTY);
		String blockcat = "recipe.fvtm.blocks";
		FclRecipe.newBuilder(blockcat).output(new ItemStack(CONST_BLOCK_ITEM.get()))
				.add(new ItemStack(Blocks.IRON_BLOCK))
				.add(new ItemStack(Items.COMPARATOR, 4))
				.add(new ItemStack(Items.REPEATER, 8))
				.add(new ItemStack(Items.REDSTONE, 16))
				.add(new ItemStack(Items.BOOK, 2))
				.add(new ItemStack(Blocks.LEVER, 8))
				.register();
		FclRecipe.newBuilder(blockcat).output(new ItemStack(LIFT_BLOCK_ITEM.get()))
				.add(new ItemStack(Blocks.IRON_BLOCK, 2))
				.add(new ItemStack(Items.IRON_INGOT, 8))
				.add(new ItemStack(Items.COMPARATOR, 2))
				.add(new ItemStack(Items.REPEATER, 4))
				.add(new ItemStack(Items.REDSTONE, 4))
				.add(new ItemStack(Items.BOOK, 1))
				.add(new ItemStack(Blocks.LEVER, 2))
				.add(new ItemStack(Blocks.PISTON, 2))
				.register();
		FclRecipe.newBuilder(blockcat).output(new ItemStack(FUELFILLER_ITEM.get()))
			.add(new ItemStack(Blocks.IRON_BLOCK))
			.add(new ItemStack(Blocks.HOPPER, 2))
			.add(new ItemStack(Blocks.STONE_BUTTON,4))
			.register();
		//
		String itemcat = "recipe.fvtm.items";
		for(int i = 0; i < TOOLBOX.length; i++){
			FclRecipe.newBuilder(itemcat).output(new ItemStack(TOOLBOX[i].get()))
				.add(new ItemStack(Items.IRON_INGOT, 4))
				.add(new ItemStack(Items.COPPER_INGOT, 2))
				.register();
		}
		FclRecipe.newBuilder(itemcat).output(new ItemStack(JUNCTION_TOOL.get()))
			.add(new ItemStack(Items.IRON_INGOT, 2))
			.add(new ItemStack(Items.COPPER_INGOT, 2))
			.add(new ItemStack(Items.REDSTONE, 2))
			.add(new ItemStack(Items.LEVER, 2))
			.register();
	}

	private ItemWrapper wrapwrapper(IDL id, Supplier<Item> item){
		if(FvtmRegistry.CONTENT_ITEMS.containsKey(id)){
			return FvtmRegistry.CONTENT_ITEMS.get(id);
		}
		IWR iwr = new IWR(FVTM4.ITEM_REGISTRY.get(id.space()).register(id.id(), item));
		FvtmRegistry.CONTENT_ITEMS.put(id, iwr);
		FvtmRegistry.ITEMS.put(id.colon(), iwr);
		return iwr;
	}

	@Override
	public ItemWrapper getItemWrapper(String id){
		Item item = BuiltInRegistries.ITEM.get(new ResourceLocation(id));
		return item == null ? null : new IWI(item);
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
					return (Transforms.Transformer)new Transforms120.TF_Translate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "rotation":
				case "rotate":
				case "rot":
					return (Transforms.Transformer)new Transforms120.TF_Rotate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]));
				case "scale":
					if(args.length < 3){
						float scale = Float.parseFloat(args[1]);
						return (Transforms.Transformer)new Transforms120.TF_Scale(scale, scale, scale);
					}
					return (Transforms.Transformer)new Transforms120.TF_Scale(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "gl_rescale_normal":
				case "rescale_normal":
					return (Transforms.Transformer)Transforms120.TF_RESCALE_NORMAL;
			}
			return null;
		});
		DefaultPrograms20.init();
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
			return Minecraft.getInstance().getResourceManager().getResource((ResourceLocation)loc).get().open();
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
		for(int idx = 0; idx < ASPHALT.length; idx++){
			int index = idx;
			ASPHALT[idx] = FVTM4.BLOCK_REGISTRY.get("fvtm").register("asphalt_" + idx, () -> new Asphalt(index));
		}
		LIFT_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("vehicle_lift", () -> new VehicleLiftBlock());
		CONST_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("constructor", () -> new ConstructorBlock());
		FUELFILLER_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("fuel_filler", () -> new FuelFillerBlock());
	}

	@Override
	public void registerFvtmItems(){
		ROAD_TOOL_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("road_tool", () -> new RoadToolItem());
		for(ToolboxType val : ToolboxType.values()){
			TOOLBOX[val.idx] = FVTM4.ITEM_REGISTRY.get("fvtm").register("toolbox_" + val.idx, () -> new ToolboxItem(val.idx));
		}
		JUNCTION_TOOL = FVTM4.ITEM_REGISTRY.get("fvtm").register("junction_tool", () -> new JunctionTool());
		for(int idx = 0; idx < ASPHALT.length; idx++){
			int index = idx;
			ASPHALT_ITEM[idx] = FVTM4.ITEM_REGISTRY.get("fvtm").register("asphalt_" + idx, () -> new BlockItem(ASPHALT[index].get(), new Item.Properties()));
		}
		LIFT_BLOCK_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("vehicle_lift", () -> new BlockItem(LIFT_BLOCK.get(), new Item.Properties()));
		CONST_BLOCK_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("constructor", () -> new BlockItem(CONST_BLOCK.get(), new Item.Properties()));
		FUELFILLER_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("fuel_filler", () -> new BlockItem(FUELFILLER_BLOCK.get(), new Item.Properties()));
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
		RoadMarker marker = FVTM4.ROAD_MARKER_ENTITY.get().create(world.local());
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y + 1, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);
	}

	@Override
	public void spawnRailMarker(WorldW world, QV3D vector, UUID nid){
		RailMarker marker = FVTM4.RAIL_MARKER_ENTITY.get().create(world.local());
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);
	}

	@Override
	public void linkItemContainer(ItemWrapper item){

	}

}