package net.fexcraft.mod.fvtm.util;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.*;
import net.fexcraft.mod.fvtm.block.Asphalt.AsphaltItem;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockUtil;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.render.block.BlkItemModel12;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.Transforms.TF_Rotate;
import net.fexcraft.mod.fvtm.model.Transforms.TF_Scale;
import net.fexcraft.mod.fvtm.model.Transforms.TF_Translate;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms12;
import net.fexcraft.mod.fvtm.model.program.WirePrograms;
import net.fexcraft.mod.fvtm.render.block.FvtmBlockModelLoader;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.FclRecipe;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.impl.IWI;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.UUID;

import static net.fexcraft.mod.fvtm.FvtmLogger.LOGGER;
import static net.fexcraft.mod.fvtm.FvtmRegistry.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Resources12 extends FvtmResources {

	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	private final ASMDataTable asmdata;
	private Field respackfile = null;

	public Resources12(ASMDataTable asmdata){
		this.asmdata = asmdata;
	}

	@Override
	public void searchASMPacks(){
		asmdata.getAll(AddonClass.class.getCanonicalName()).forEach(entry -> {
			try{
				Class<?> clazz = Class.forName(entry.getClassName());
				AddonClass adn = clazz.getAnnotation(AddonClass.class);
				String regname = adn.registryname();
				if(regname.contains(":")) regname = regname.split(":")[1];
				String res = clazz.getClassLoader().getResource("assets/" + regname + "/addonpack.fvtm").toString();
				res = res.substring(res.indexOf("file:/") + 6, res.indexOf("!"));
				JsonMap map = JsonHandler.parse(clazz.getClassLoader().getResourceAsStream("assets/" + regname + "/addonpack.fvtm"));
				ADDONS.add(new Addon(new File(res), regname.equals("fvtm") ? AddonLocation.INTERNAL : AddonLocation.MODJAR).parse(map));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		});
	}

	@Override
	public boolean searchPacksInResourcePacks(){
		boolean failed = false;
		if(EnvInfo.CLIENT){
			try{
				respackfile = ReflectionHelper.findField(net.minecraft.client.resources.AbstractResourcePack.class, "resourcePackFile", "field_110597_b");
			}
			catch(Exception e){
				failed = true;
				LOGGER.info("Failed to get field. [RESPACKLOADER:ERR:00]");
				LOGGER.info("Addon loading from ResourcePacks will be limited.");
			}
			catch(Error e){
				failed = true;
				LOGGER.info("Failed to get field. [RESPACKLOADER:ERR:01]");
				LOGGER.info("Addon loading from ResourcePacks will be limited.");
			}
			if(respackfile != null){
				for(net.minecraft.client.resources.ResourcePackRepository.Entry entry : net.minecraft.client.Minecraft.getMinecraft().getResourcePackRepository().getRepositoryEntriesAll()){
					try{
						checkResPackEntry(entry.getResourcePack());
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return failed;
	}

	@SideOnly(Side.CLIENT)
	private void checkResPackEntry(net.minecraft.client.resources.IResourcePack pack){
		for(String str : pack.getResourceDomains()){
			ResourceLocation resloc = new ResourceLocation(str + ":addonpack.fvtm");
			if(!pack.resourceExists(resloc)) continue;
			try{
				Addon addon = new Addon((File)respackfile.get(pack), AddonLocation.RESOURCEPACK);
				if(addon.getFile().isDirectory()){
					addon.parse(JsonHandler.parse(new File(addon.getFile(), "assets/" + str + "/addonpack.fvtm")));
				}
				else{
					JsonArray array = ZipUtils.getValuesAt(addon.getFile(), "assets", "addonpack.fvtm");
					for(JsonValue<?> value : array.value){
						if(!value.isMap()) continue;
						JsonMap map = value.asMap();
						if(isDuplicateOrInvalidPack(map)) continue;
						addon.parse(map);
						break;
					}
				}
				ADDONS.register(addon);
			}
			catch(IllegalArgumentException | IllegalAccessException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void loadPackTextures(){
		ArrayList<Addon> lites = new ArrayList<>();
		for(Addon addon : ADDONS){
			if(addon.getLocation() == AddonLocation.CONFIGPACK) lites.add(addon);
		}
		if(lites.size() == 0) return;
		for(Addon addon : lites){
			if(addon.getFile().isDirectory()){
				TexUtil.searchIn(addon, new File(addon.getFile(), "assets/" + addon.getID().id() + "/textures/"), null);
			}
			else{
				TexUtil.searchInZip(addon);
			}
		}
	}

	@Override
	public void createContentBlocks(){
		BLOCKS.forEach(block -> {
			net.minecraft.block.Block blk = block.getBlock();
			blk.setRegistryName(block.getIDS());
			blk.setTranslationKey(block.getIDS());
			FvtmRegistry.CONTENT_BLOCKS.put(block.getID(), blk);
		});
	}

	@Override
	public void createContentItems(){
		MATERIALS.forEach(mat -> mat.setItemWrapper(wrapwrapper(mat.getID(), new MaterialItem(mat))));
		CONSUMABLES.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), new ConsumableItem(con))));
		PARTS.forEach(part -> part.setItemWrapper(wrapwrapper(part.getID(), new PartItem(part))));
		VEHICLES.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), new VehicleItem(veh))));
		BLOCKS.forEach(blk -> blk.setItemWrapper(wrapwrapper(blk.getID(), new BlockItem(blk))));
		MULTIBLOCKS.forEach(mb -> mb.setItemWrapper(wrapwrapper(mb.getID(), new MultiBlockItem(mb))));
		CLOTHES.forEach(cth -> cth.setItemWrapper(wrapwrapper(cth.getID(), new ClothItem(cth))));
		WIRES.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), new WireItem(wire))));
		WIREDECOS.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), new WireDecoItem(wire))));
		CONTAINERS.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), new ContainerItem(con))));
		RAILGAUGES.forEach(rail -> {
			rail.setItemWrapper(wrapwrapper(rail.getID(), new RailGaugeItem(rail)));
			if(rail.getPresets() == null) return;
			for(RailGauge.Preset preset : rail.getPresets()){
				wrapwrapper(IDLManager.getIDLCached(rail.getIDS() + "." + preset.name.toLowerCase()), new RailPresetItem(rail, preset));
			}
		});
		DECORATIONS.forEach(deco -> deco.setItemWrapper(wrapwrapper(deco.getID(), new DecorationItem(deco))));
		SIGNS.forEach(sign -> sign.setItemWrapper(wrapwrapper(sign.getID(), new SignItem(sign))));
	}

	@Override
	public void registerFvtmRecipes(){
		//StackWrapper.EMPTY = new SWIE(ItemStack.EMPTY);
		String blockcat = "recipe.fvtm.blocks";
		FclRecipe.newBuilder(blockcat).output(new ItemStack(ConstructorBlock.INSTANCE))
			.add(new ItemStack(Blocks.IRON_BLOCK))
			.add(new ItemStack(Items.COMPARATOR, 4))
			.add(new ItemStack(Items.REPEATER, 8))
			.add(new ItemStack(Items.REDSTONE, 16))
			.add(new ItemStack(Items.BOOK, 2))
			.add(new ItemStack(Blocks.LEVER, 8))
			.register();
		FclRecipe.newBuilder(blockcat).output(new ItemStack(VehicleLiftBlock.INSTANCE))
			.add(new ItemStack(Blocks.IRON_BLOCK, 2))
			.add(new ItemStack(Items.IRON_INGOT, 8))
			.add(new ItemStack(Items.COMPARATOR, 2))
			.add(new ItemStack(Items.REPEATER, 4))
			.add(new ItemStack(Items.REDSTONE, 4))
			.add(new ItemStack(Items.BOOK, 1))
			.add(new ItemStack(Blocks.LEVER, 2))
			.add(new ItemStack(Blocks.PISTON, 2))
			.register();
		FclRecipe.newBuilder(blockcat).output(new ItemStack(FuelFillerBlock.INSTANCE))
			.add(new ItemStack(Blocks.IRON_BLOCK))
			.add(new ItemStack(Blocks.HOPPER, 2))
			.add(new ItemStack(Blocks.STONE_BUTTON,4))
			.register();
		/*FclRecipe.newBuilder(blockcat).output(new ItemStack(VPInfo.INSTANCE))
			.add(new ItemStack(Blocks.IRON_BLOCK))
			.add(new ItemStack(Items.BOOK, 16))
			.add(new ItemStack(Items.REDSTONE, 4))
			.add(new ItemStack(Blocks.LEVER, 4))
			.add(new ItemStack(Items.GLASS_BOTTLE, 2))
			.register();*/
		//
		String itemcat = "recipe.fvtm.items";
		for(int i = 0; i < ToolboxType.values().length; i++){
			FclRecipe.newBuilder(itemcat).output(new ItemStack(ToolboxItem.INSTANCE, 1, i))
				.add(new ItemStack(Items.IRON_INGOT, 6))
				.register();
		}
		FclRecipe.newBuilder(itemcat).output(new ItemStack(JunctionToolItem.INSTANCE))
			.add(new ItemStack(Items.IRON_INGOT, 4))
			.add(new ItemStack(Items.REDSTONE, 2))
			.add(new ItemStack(Blocks.LEVER, 2))
			.register();
	}

	private ItemWrapper wrapwrapper(IDL id, Item item){
		ItemWrapper wrapper = new IWI(item);
		FvtmRegistry.CONTENT_ITEMS.put(id, wrapper);
		FvtmRegistry.ITEMS.put(id.colon(), wrapper);
		return wrapper;
	}

	@Override
	public ItemWrapper getItemWrapper(String id){
		Item item = Item.REGISTRY.getObject(new ResourceLocation(id));
		return item == null ? null : new IWI(item);
	}

	@Override
	public StackWrapper newStack0(ItemWrapper item){
		return new SWI(item);
	}

	@Override
	public void initModelPrograms(){
		Transforms.GET_TRANSFORM = args -> {
			switch(args[0]){
				case "translation":
				case "translate":
				case "trans":
				case "tra":
				case "tr":
					return new TF_Translate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "rotation":
				case "rotate":
				case "rot":
					return new TF_Rotate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]));
				case "scale":
					if(args.length < 3){
						float scale = Float.parseFloat(args[1]);
						return new TF_Scale(scale, scale, scale);
					}
					else
						return new TF_Scale(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "gl_rescale_normal":
				case "rescale_normal":
					return Transforms.TF_RESCALE_NORMAL;
				default:
					return null;
			}
		};
		DefaultPrograms12.init();
		ConditionalPrograms.init();
	}

	@Override
	public void initModels(){
		ArrayList<String> tt = new ArrayList<>();
		for(TransformType value : TransformType.values()) tt.add(value.name());
		TransformMap.TYPES = tt.toArray(new String[0]);
		super.initModels();
		getModel("baked|fvtm:models/block/vpinfo.fmf", new ModelData(), BlockModel.class);
	}

	@Override
	public InputStream getAssetInputStream(IDL loc, boolean log){
		try{
			InputStream stream = net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation)loc).getInputStream();
			if(stream != null){
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int read;
				while((read = stream.read(buffer)) != -1) out.write(buffer, 0, read);
				stream = new ByteArrayInputStream(out.toByteArray());
			}
			return stream;
		}
		catch(Throwable e){
			if(log) e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isModPresent(String id){
		if(LOADED_MODS.containsKey(id)) return LOADED_MODS.get(id);
		boolean bool = Loader.isModLoaded(id);
		LOADED_MODS.put(id, bool);
		return bool;
	}

	@Override
	public IDL getExternalTexture0(String custom){
		return ExternalTextureLoader.get(custom);
	}

	@Override
	public void registerFvtmBlocks(){
		ConstructorBlock.INSTANCE = new ConstructorBlock();
		ConstructorBlock.ITEM = new ItemBlock16(ConstructorBlock.INSTANCE);
		ConstructorBlock.ITEM.setRegistryName(ConstructorBlock.INSTANCE.getRegistryName());
		ConstructorBlock.ITEM.setTranslationKey(ConstructorBlock.INSTANCE.getTranslationKey());
		GameRegistry.registerTileEntity(ConstructorEntity.class, new ResourceLocation("fvtm:constructor"));
		//
		FuelFillerBlock.INSTANCE = new FuelFillerBlock();
		FuelFillerBlock.ITEM = new ItemBlock16(FuelFillerBlock.INSTANCE);
		FuelFillerBlock.ITEM.setRegistryName(FuelFillerBlock.INSTANCE.getRegistryName());
		FuelFillerBlock.ITEM.setTranslationKey(FuelFillerBlock.INSTANCE.getTranslationKey());
		GameRegistry.registerTileEntity(FuelFillerEntity.class, new ResourceLocation("fvtm:fuel_filler"));
 		//
		VehicleLiftBlock.INSTANCE = new VehicleLiftBlock();
		VehicleLiftBlock.ITEM = new ItemBlock16(VehicleLiftBlock.INSTANCE);
		VehicleLiftBlock.ITEM.setRegistryName(VehicleLiftBlock.INSTANCE.getRegistryName());
		VehicleLiftBlock.ITEM.setTranslationKey(VehicleLiftBlock.INSTANCE.getTranslationKey());
		GameRegistry.registerTileEntity(VehicleLiftEntity.class, VehicleLiftBlock.INSTANCE.getRegistryName());
		//
		Asphalt.INSTANCE = new Asphalt();
		Asphalt.ITEM = new AsphaltItem(Asphalt.INSTANCE);
		//
		ContainerBlock.INSTANCE = new ContainerBlock();
		GameRegistry.registerTileEntity(ContainerEntity.class, new ResourceLocation("fvtm:container"));
		//
		if(EnvInfo.CLIENT) registerTESR();
	}

	@SideOnly(Side.CLIENT)
	private void registerTESR(){
		net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(VehicleLiftEntity.class, new net.fexcraft.mod.fvtm.render.VehicleLiftRenderer());
		net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(ContainerEntity.class, new net.fexcraft.mod.fvtm.render.ContainerBlockRenderer());
		net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(ConstructorEntity.class, new net.fexcraft.mod.fvtm.render.CatalogRenderer());
		net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(FuelFillerEntity.class, new net.fexcraft.mod.fvtm.render.FuelFillerRenderer());
	}

	@Override
	public void registerFvtmItems(){
		//
	}

	@SideOnly(Side.CLIENT)
	@Override
	public double getMouseSensitivity(){
		return net.minecraft.client.Minecraft.getMinecraft().gameSettings.mouseSensitivity;
	}

	@Override
	public Object getBlockMaterial(String key, boolean allownull){
		return BlockUtil.getMaterial(key, allownull);
	}

	@Override
	public void spawnRoadMarker(WorldW world, QV3D vector, UUID nid){
		RoadMarker marker = new RoadMarker(world.local(), nid);
		marker.position = vector;
		marker.setPosition(vector.vec.x, vector.vec.y + 1, vector.vec.z);
		((World)world.direct()).spawnEntity(marker);
	}

	@Override
	public void spawnRailMarker(WorldW world, QV3D vector, UUID nid){
		RailMarker marker = new RailMarker(world.local(), nid);
		marker.position = vector;
		marker.setPosition(vector.vec.x, vector.vec.y, vector.vec.z);
		((World)world.direct()).spawnEntity(marker);
	}

	@Override
	public void linkItemContainer(ItemWrapper wrap){
		Item item = wrap.local();
		if(item instanceof MaterialItem){
			Material mat = ((MaterialItem)item).getContent();
			if(mat.getItemContainer() != null){
				item.setContainerItem(Item.getByNameOrId(mat.getItemContainer()));
			}
			if(mat.getOreDictId() != null){
				OreDictionary.registerOre(mat.getOreDictId(), (Item)mat.getItemWrapper().direct());
			}
		}
		if(item instanceof ConsumableItem){
			Consumable con = ((ConsumableItem)item).getContent();
			if(con.getItemContainer() != null){
				item.setContainerItem(Item.getByNameOrId(con.getItemContainer()));
			}
			if(con.getOreDictId() != null){
				OreDictionary.registerOre(con.getOreDictId(), (Item)con.getItemWrapper().direct());
			}
		}
		if(item instanceof BlockItem){
			Block blk = ((BlockItem)item).getContent();
			if(blk.getItemContainer() != null){
				item.setContainerItem(Item.getByNameOrId(blk.getItemContainer()));
			}
			if(blk.getOreDictId() != null){
				OreDictionary.registerOre(blk.getOreDictId(), (Item)blk.getItemWrapper().direct());
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(ResourceLocation resloc, boolean log){
		try{
			return net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(resloc).getInputStream();
		}
		catch(IOException e){
			if(log) e.printStackTrace();
			return null;
		}
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<net.minecraft.block.Block> event){
		IForgeRegistry<net.minecraft.block.Block> reg = event.getRegistry();
		for(Object block : CONTENT_BLOCKS.values()){
			reg.register((net.minecraft.block.Block)block);
		}
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> reg = event.getRegistry();
		//
		for(ItemWrapper item : FvtmRegistry.CONTENT_ITEMS.values()){
			reg.register(item.local());
		}
		if(EnvInfo.CLIENT){
			for(ItemWrapper item : FvtmRegistry.CONTENT_ITEMS.values()){
				regItemModelLoc(item.local());
			}
		}
	}

	private void regItemModelLoc(Item item){
		if(item instanceof BlockItem){
			Block block = ((BlockItem)item).getContent();
			if(!block.hasPlainModel() && !block.noCustomItemModel()){
				net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(block.getID().local(), BlkItemModel12.INSTANCE);
			}
			if(block.getModelData().getBoolean("Baked", false)){
				FvtmBlockModelLoader.BLOCKS.put(block.getID().space() + ":models/block/" + block.getID().id(), block);
				FvtmBlockModelLoader.BLOCKS.put(block.getIDS(), block);
			}
			int var = block.getBlockType().getMetaVariants();
			for(int v = 0; v < var; v++){
				net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, v, new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(item.getRegistryName() + "_" + v), "inventory"));
			}
			if(var == 0){
				net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory"));
			}
			return;
		}
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event){
		Ingredient a1 = Ingredient.fromStacks(new ItemStack(Asphalt.INSTANCE, 1, 1));
		Ingredient a2 = Ingredient.fromStacks(new ItemStack(Asphalt.INSTANCE, 1, 2));
		Ingredient a4 = Ingredient.fromStacks(new ItemStack(Asphalt.INSTANCE, 1, 4));
		Ingredient a8 = Ingredient.fromStacks(new ItemStack(Asphalt.INSTANCE, 1, 8));
		event.getRegistry().register(newRecipe("fvtm:asphalt_88_16", new ItemStack(Asphalt.INSTANCE, 1, 0), a8, a8));
		event.getRegistry().register(newRecipe("fvtm:asphalt_44_8", new ItemStack(Asphalt.INSTANCE, 1, 8), a4, a4));
		event.getRegistry().register(newRecipe("fvtm:asphalt_22_4", new ItemStack(Asphalt.INSTANCE, 1, 4), a2, a2));
		event.getRegistry().register(newRecipe("fvtm:asphalt_11_2", new ItemStack(Asphalt.INSTANCE, 1, 2), a1, a1));
		event.getRegistry().register(newRecipe("fvtm:asphalt_4444_16", new ItemStack(Asphalt.INSTANCE, 1, 0), a4, a4, a4, a4));
		event.getRegistry().register(newRecipe("fvtm:asphalt_2222_8", new ItemStack(Asphalt.INSTANCE, 1, 8), a2, a2, a2, a2));
		event.getRegistry().register(newRecipe("fvtm:asphalt_1111_4", new ItemStack(Asphalt.INSTANCE, 1, 4), a1, a1, a1, a1));
		event.getRegistry().register(newRecipe("fvtm:asphalt", new ItemStack(Asphalt.INSTANCE, 4, 0),
			Ingredient.fromStacks(new ItemStack(Blocks.SAND, 1, 0), new ItemStack(Blocks.SAND, 1, 1)),
			Ingredient.fromStacks(new ItemStack(Blocks.SAND, 1, 0), new ItemStack(Blocks.SAND, 1, 1)),
			Ingredient.fromStacks(new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.COBBLESTONE))));
	}

	private IRecipe newRecipe(String str, ItemStack stack, Ingredient... ings){
		NonNullList<Ingredient> list = NonNullList.create();
		for(Ingredient ing : ings) list.add(ing);
		IRecipe rec = new ShapelessRecipes("fvtm:asphalt", stack, list);
		rec.setRegistryName(new ResourceLocation(str));
		return rec;
	}

}
