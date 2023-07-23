package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.RENDER_BLOCK_MODELS_AS_ITEMS;
import static net.fexcraft.mod.fvtm.Config.RENDER_VEHILE_MODELS_AS_ITEMS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.CONSUMABLES;
import static net.fexcraft.mod.fvtm.FvtmRegistry.MATERIALS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.item.ConsumableItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.ItemPlaceholderModel;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.impl.IWI;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ResourcesImpl extends FvtmResources {

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
				Print.log("Failed to get field. [RESPACKLOADER:ERR:00]");
				Print.log("Addon loading from ResourcePacks will be limited.");
			}
			catch(Error e){
				failed = true;
				Print.log("Failed to get field. [RESPACKLOADER:ERR:01]");
				Print.log("Addon loading from ResourcePacks will be limited.");
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
	private void checkResPackEntry(IResourcePack pack){
		for(String str : pack.getResourceDomains()){
			ResourceLocation resloc = new ResourceLocation(str + ":addonpack.fvtm");
			if(!pack.resourceExists(resloc)) continue;
			try{
				Addon addon = new Addon((File)respackfile.get(pack), AddonLocation.RESOURCEPACK);
				File file = addon.getFile().isDirectory() ? new File(addon.getFile(), "assets/" + str + "/addonpack.fvtm") : addon.getFile();
				JsonMap map = JsonHandler.parse(file);
				ADDONS.register(addon.parse(map));
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
				Block block = null;//TODO
				if(!block.hasPlainModel() && RENDER_BLOCK_MODELS_AS_ITEMS && !block.noCustomItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), BlockModel.EMPTY);
					return;
				}
				break;
			}
			case CONTAINER:{
				Container con = null;//TODO
				if(!con.noCustomItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), ContainerModel.EMPTY);
					return;
				}
				break;
			}
			case PART:{
				Part part = null;//TODO
				if(!part.noCustomItemModel() && part.getDefaultFunctions().stream().filter(pre -> pre.getId().equals("fvtm:wheel")).count() > 0){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), PartModel.EMPTY);
					return;
				}
				break;
			}
			case VEHICLE:{
				Vehicle veh = null;//TODO
				if(RENDER_VEHILE_MODELS_AS_ITEMS && !veh.noCustomItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), VehicleModel.EMPTY);
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
			net.minecraft.client.resources.IResource res = net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(type.getID().space(), "textures/item/" + type.getID().id() + ".png"));
			return res == null;
		}
		catch(IOException e){
			//e.printStackTrace();
			return true;
		}
	}

	public void createContentItems(){
		MATERIALS.forEach(mat -> mat.setItemWrapper(wrapwrapper(mat.getID(), new MaterialItem(mat))));
		CONSUMABLES.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), new ConsumableItem((con)))));
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
	public JsonMap getJsonC(String loc){
		try{
			return JsonHandler.parse(getModelInputStream(new ResourceLocation(loc), true));
		}
		catch(IOException e){
			if(EnvInfo.DEV) throw new RuntimeException(e);
		}
		return new JsonMap();
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
