package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fcl.util.ExternalTextures;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms;
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
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Resources21 extends FvtmResources {

	public static ConcurrentHashMap<String, ConcurrentHashMap<String, Item>> ITEMS = new ConcurrentHashMap<>();
	//public static Supplier<RoadToolItem> ROAD_TOOL_ITEM;
	public static ToolboxItem[] TOOLBOX = new ToolboxItem[ToolboxType.values().length];
	//public static Supplier<JunctionTool> JUNCTION_TOOl;
	//public static Supplier<Asphalt>[] ASPHALT = new Supplier[16];
	public static Supplier<BlockItem>[] ASPHALT_ITEM = new Supplier[16];
	//public static Supplier<VehicleLiftBlock> LIFT_BLOCK;
	public static Supplier<BlockItem> LIFT_BLOCK_ITEM;
	//public static Supplier<ConstructorBlock> CONST_BLOCK;
	//public static Supplier<FuelFillerBlock> FUELFILLER_BLOCK;
	public static Supplier<BlockItem> CONST_BLOCK_ITEM;
	public static Supplier<BlockItem> FUELFILLER_ITEM;

	public static void addItem(String idl, Item item){
		String[] split = idl.split(":");
		if(!ITEMS.containsKey(split[0])) ITEMS.put(split[0], new ConcurrentHashMap<>());
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
	public void checkForCustomModel(AddonLocation loc, ContentType contype, Content<?> content){}

	@Override
	public void createContentBlocks(){
		/*BLOCKS.forEach(block -> {
			FVTM4.BLOCK_REGISTRY.get(block.getID().space()).register(block.getID().id(), () -> block.genBlock());
		});*/
	}

	@Override
	public void createContentItems(){
		FvtmRegistry.MATERIALS.forEach(mat -> mat.setItemWrapper(wrapwrapper(mat.getID(), FVTM.register(mat.getIDS(), prop -> new MaterialItem(prop, mat)))));
		FvtmRegistry.CONSUMABLES.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), FVTM.register(con.getIDS(), prop -> new ConsumableItem(prop, con)))));
		FvtmRegistry.PARTS.forEach(part -> part.setItemWrapper(wrapwrapper(part.getID(), FVTM.register(part.getIDS(), prop -> new PartItem(prop, part)))));
		FvtmRegistry.VEHICLES.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), FVTM.register(veh.getIDS(), prop -> new VehicleItem(prop, veh)))));
		/*FvtmRegistry.BLOCKS.forEach(blk -> blk.setItemWrapper(wrapwrapper(blk.getID(), () -> {
			FvtmRegistry.CONTENT_BLOCKS.put(blk.getID(), blk.getBlock());
			return new net.fexcraft.mod.fvtm.item.BlockItem(blk);
		})));*/
		FvtmRegistry.DECORATIONS.forEach(dec -> dec.setItemWrapper(wrapwrapper(dec.getID(), FVTM.register(dec.getIDS(), prop -> new DecorationItem(prop, dec)))));
		FvtmRegistry.RAILGAUGES.forEach(rg -> rg.setItemWrapper(wrapwrapper(rg.getID(), FVTM.register(rg.getIDS(), prop -> new RailGaugeItem(prop, rg)))));
		FvtmRegistry.WIRES.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), FVTM.register(wire.getIDS(), prop -> new WireItem(prop, wire)))));
	}

	@Override
	public void registerFvtmRecipes(){
		//StackWrapper.EMPTY = SWIE.parse(ItemStack.EMPTY);
		/*String blockcat = "recipe.fvtm.blocks";
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
			.register();*/
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
			/*switch(args[0]){
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
			}*/
			return null;
		});
		//TODO DefaultPrograms20.init();
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
	public IDL getExternalTexture(String custom){
		return ExternalTextures.get("fvtm", custom);
	}

	@Override
	public void registerFvtmBlocks(){
		/*for(int idx = 0; idx < ASPHALT.length; idx++){
			int index = idx;
			ASPHALT[idx] = FVTM4.BLOCK_REGISTRY.get("fvtm").register("asphalt_" + idx, () -> new Asphalt(index));
		}
		LIFT_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("vehicle_lift", () -> new VehicleLiftBlock());
		CONST_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("constructor", () -> new ConstructorBlock());
		FUELFILLER_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("fuel_filler", () -> new FuelFillerBlock());*/
	}

	@Override
	public void registerFvtmItems(){
		//ROAD_TOOL_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("road_tool", () -> new RoadToolItem());
		for(ToolboxType val : ToolboxType.values()){
			TOOLBOX[val.idx] = (ToolboxItem)FVTM.register("fvtm:toolbox_" + val.idx, prop -> new ToolboxItem(prop, val.idx));
		}
		/*JUNCTION_TOOl = FVTM4.ITEM_REGISTRY.get("fvtm").register("junction_tool", () -> new JunctionTool());
		for(int idx = 0; idx < ASPHALT.length; idx++){
			int index = idx;
			ASPHALT_ITEM[idx] = FVTM4.ITEM_REGISTRY.get("fvtm").register("asphalt_" + idx, () -> new BlockItem(ASPHALT[index].get(), new Item.Properties()));
		}
		LIFT_BLOCK_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("vehicle_lift", () -> new BlockItem(LIFT_BLOCK.get(), new Item.Properties()));
		CONST_BLOCK_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("constructor", () -> new BlockItem(CONST_BLOCK.get(), new Item.Properties()));
		FUELFILLER_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("fuel_filler", () -> new BlockItem(FUELFILLER_BLOCK.get(), new Item.Properties()));*/
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
		/*RoadMarker marker = FVTM4.ROAD_MARKER_ENTITY.get().create(world.local());
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y + 1, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);*/
	}

	@Override
	public void spawnRailMarker(WorldW world, QV3D vector, UUID nid){
		/*RailMarker marker = FVTM4.RAIL_MARKER_ENTITY.get().create(world.local());
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);*/
	}

}