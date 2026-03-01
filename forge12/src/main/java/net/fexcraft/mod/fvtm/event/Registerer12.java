package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.block.*;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.resource.VanillaResourceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Registerer12 {

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<net.minecraft.block.Block> event){
		if(Config.MD_VEHICLE){
			event.getRegistry().register(ConstructorBlock.INSTANCE);
			event.getRegistry().register(FuelFillerBlock.INSTANCE);
		}
		if(Config.MD_ROAD){
			event.getRegistry().register(Asphalt.INSTANCE);
		}
		if(Config.MD_CONTAINER){
			event.getRegistry().register(ContainerBlock.INSTANCE);
		}
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<net.minecraft.item.Item> event){
		if(Config.MD_VEHICLE){
			event.getRegistry().register(ConstructorBlock.ITEM);
			event.getRegistry().register(FuelFillerBlock.ITEM);
		}
		if(Config.MD_ROAD){
			event.getRegistry().register(Asphalt.ITEM);
			event.getRegistry().register(RoadToolItem.INSTANCE = new RoadToolItem());
		}
		if(Config.MD_RAIL){
			event.getRegistry().register(JunctionToolItem.INSTANCE = new JunctionToolItem());
		}
		event.getRegistry().register(ToolboxItem.INSTANCE = new ToolboxItem());
		if(EnvInfo.CLIENT){
			if(Config.MD_VEHICLE){
				regModel(ConstructorBlock.ITEM);
				regModel(FuelFillerBlock.ITEM);
			}
			if(Config.MD_ROAD){
				regModel(Asphalt.ITEM, 16);
				regModel(RoadToolItem.INSTANCE);
			}
			if(Config.MD_RAIL){
				regModel(JunctionToolItem.INSTANCE);
			}
			regModel(ToolboxItem.INSTANCE, ToolboxType.values().length);
		}
	}

	private void regModel(Item item){
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private void regModel(Item item, int vars){
		for(int v = 0; v < vars; v++){
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, v, new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(item.getRegistryName().toString() + "_" + v), "inventory"));
		}
	}

	/** Similar forced pack as resourcepack loading as in https://github.com/FlansMods/FlansMod/ */
	@SideOnly(Side.CLIENT)
	public static void regPacks(){
		URLClassLoader cl = (URLClassLoader)Minecraft.class.getClassLoader();
		Method method = null;
		try{
			method = cl.getClass().getDeclaredMethod("addURL", URL.class);
			method.setAccessible(true);
		}
		catch(Exception e){
			FvtmLogger.log(e, "force registration of packs as resourcepacks");
		}
		if(method == null) return;
		for(Addon addon : FvtmRegistry.ADDONS){
			if(addon.getFile() == null || !addon.getFile().exists()) continue;
			try{
				method.invoke(cl, addon.getFile().toURI().toURL());
				HashMap<String, Object> map = new LinkedHashMap<>();
				map.put("modid", addon.getID().path());
				map.put("name", addon.getName());
				map.put("version", addon.getVersion());
				ModCandidate can = new ModCandidate(addon.getFile(), addon.getFile(), addon.getFile().isDirectory() ? ContainerType.DIR : ContainerType.JAR);
				FMLModContainer con = new FMLModContainer("net.fexcraft.mod.fvtm.FVTM", can, map);
				con.bindMetadata(MetadataCollection.from(null, "FVTM"));
				FMLClientHandler.instance().addModAsResource(con);
			}
			catch(Exception e){
				FvtmLogger.log(e, "force registration '" + addon.getID() + "' as resourcepack");
			}
		}
		Registerer12.refresh();
	}

	@SideOnly(Side.CLIENT)
	public static void refresh(){
		FMLClientHandler.instance().refreshResources(VanillaResourceType.values());
	}

}
