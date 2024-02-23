package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.RENDER_BLOCK_MODELS_AS_ITEMS;
import static net.fexcraft.mod.fvtm.Config.RENDER_VEHILE_MODELS_AS_ITEMS;
import static net.fexcraft.mod.fvtm.FvtmLogger.LOGGER;
import static net.fexcraft.mod.fvtm.FvtmRegistry.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.Asphalt.AsphaltItem;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstCenterEntity;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ConstructorEntity;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockUtil;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.function.part.WheelFunction;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.model.Transforms.TF_Rotate;
import net.fexcraft.mod.fvtm.model.Transforms.TF_Scale;
import net.fexcraft.mod.fvtm.model.Transforms.TF_Translate;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.program.TrafficSignPrograms;
import net.fexcraft.mod.fvtm.model.program.WirePrograms;
import net.fexcraft.mod.fvtm.render.block.BlockItemModel;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.util.handler.ToggableHandler;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.impl.IWI;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ResourcesImpl extends FvtmResources {

	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	private final ASMDataTable asmdata;
	private Field respackfile = null;

	public ResourcesImpl(ASMDataTable asmdata){
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
	@SideOnly(Side.CLIENT)
	public void checkForCustomModel(AddonLocation loc, ContentType contype, Content<?> content){
		switch(contype){
			case BLOCK:{
				Block block = (Block)content;
				if(/*!block.hasPlainModel() &&*/ RENDER_BLOCK_MODELS_AS_ITEMS && !block.noCustomItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), BlockItemModel.INSTANCE);
					return;
				}
				break;
			}
			case CONTAINER:{
				Container con = null;//TODO
				if(!con.noCustomItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), ContainerItemModel.INSTANCE);
					return;
				}
				break;
			}
			case PART:{
				Part part = (Part)content;
				if(!part.noCustomItemModel() && part.getDefaultFunctions().stream().filter(pre -> pre instanceof WheelFunction).count() > 0){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), PartItemModel.INSTANCE);
					return;
				}
				break;
			}
			case VEHICLE:{
				Vehicle veh = (Vehicle)content;
				if(RENDER_VEHILE_MODELS_AS_ITEMS && !veh.noCustomItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), VehicleItemModel.INSTANCE);
					return;
				}
				break;
			}
			default: break;
		}
		if(loc.isConfigPack() || isItemModelMissing(content)){
			net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), ItemPlaceholderModel.INSTANCE);
		}
	}

	@SideOnly(Side.CLIENT)
	private boolean isItemModelMissing(Content<?> type){
		try{
			net.minecraft.client.resources.IResource res = net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(type.getID().space(), "models/item/" + type.getID().id() + ".json"));
			return res == null;
		}
		catch(IOException e){
			//e.printStackTrace();
			return true;
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
		CLOTHES.forEach(cth -> cth.setItemWrapper(wrapwrapper(cth.getID(), new ClothItem(cth))));
		WIRES.forEach(wire -> wire.setItemWrapper(wrapwrapper(wire.getID(), new WireItem(wire))));
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
	public StackWrapper newStack(ItemWrapper item){
		return new SWI(item);
	}

	@Override
	public StackWrapper newStack(Object local){
		return new SWI((ItemStack)local);
	}

	@Override
	public JsonMap getJsonC(String loc){
		try{
			return JsonHandler.parse(getModelInputStream(new ResourceLocation(loc), true));
		}
		catch(IOException e){
			if(EnvInfo.DEV) throw new RuntimeException(e);
		}
		return new JsonMap();
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
					else return new TF_Scale(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "gl_rescale_normal":
				case "rescale_normal":
					return Transforms.TF_RESCALE_NORMAL;
				default: return null;
			}
		};
		DefaultPrograms.init();
		ConditionalPrograms.init();
		WirePrograms.init();
		TrafficSignPrograms.init();
	}

	@Override
	public void initModels(){
		ArrayList<String> tt = new ArrayList<>();
		for(TransformType value : TransformType.values()) tt.add(value.name());
		TransformMap.TYPES = tt.toArray(new String[0]);
		super.initModels();
		getModel("baked|fvtm:models/block/vpinfo.fmf", new ModelData(), BlockModel.class);
		//Resources.PARTS.forEach(part -> part.loadModel());
		//Resources.VEHICLES.forEach(veh -> veh.loadModel());
		Resources.CONTAINERS.forEach(con -> con.loadModel());
		Resources.RAILGAUGES.forEach(gauge -> gauge.loadModel());
		//Resources.WIRES.forEach(cloth -> cloth.loadModel());
		TrafficSignLibrary.loadModels();
	}

	@Override
	public InputStream getAssetInputStream(IDL loc, boolean log){
		try{
			return net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation)loc).getInputStream();
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
	public IDL getExternalTexture(String custom) {
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
		ConstCenterBlock.INSTANCE = new ConstCenterBlock();
		ConstCenterBlock.ITEM = new ItemBlock16(ConstCenterBlock.INSTANCE);
		ConstCenterBlock.ITEM.setRegistryName(ConstCenterBlock.INSTANCE.getRegistryName());
		ConstCenterBlock.ITEM.setTranslationKey(ConstCenterBlock.INSTANCE.getTranslationKey());
		GameRegistry.registerTileEntity(ConstCenterEntity.class, new ResourceLocation("fvtm:constructor_lift"));
		//
		Asphalt.INSTANCE = new Asphalt();
		Asphalt.ITEM = new AsphaltItem(Asphalt.INSTANCE);
		//
		if(EnvInfo.CLIENT) registerTESR();
	}

	@SideOnly(Side.CLIENT)
	private void registerTESR(){
		net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(ConstCenterEntity.class, new net.fexcraft.mod.fvtm.render.ConstructorCenterRenderer());
	}

	@Override
	public void registerFvtmItems(){
		DecorationItem.INSTANCE = new DecorationItem();
	}

	@Override
	public boolean handleClick(KeyPress key, EntityW vehicle, SeatInstance seat, EntityW player, StackWrapper stack){
		return ToggableHandler.handleClick(key, vehicle.local(), seat, player.local(), stack == null ? ItemStack.EMPTY : stack.local());
	}

	@Override
	public boolean sendToggle(Attribute<?> attr, EntityW vehicle, KeyPress key, Float val, EntityW player) {
		return ToggableHandler.sendToggle(attr, vehicle.local(), key, val, player.local());
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
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
