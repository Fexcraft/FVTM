package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.RENDER_BLOCK_MODELS_AS_ITEMS;
import static net.fexcraft.mod.fvtm.Config.RENDER_VEHILE_MODELS_AS_ITEMS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.ItemPlaceholderModel;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ResourcesImpl extends FvtmResources {

	private Field respackfile = null;

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
				JsonMap map = JsonHandler.parse(addon.getFile());
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
				if(!block.hasPlainModel() && RENDER_BLOCK_MODELS_AS_ITEMS && !block.no3DItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), BlockModel.EMPTY);
					return;
				}
				break;
			}
			case CONTAINER:{
				Container con = null;//TODO
				if(!con.no3DItemModel()){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), ContainerModel.EMPTY);
					return;
				}
				break;
			}
			case PART:{
				Part part = null;//TODO
				if(!part.no3DItemModel() && part.getDefaultFunctions().stream().filter(pre -> pre.getId().equals("fvtm:wheel")).count() > 0){
					net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(content.getID().local(), PartModel.EMPTY);
					return;
				}
				break;
			}
			case VEHICLE:{
				Vehicle veh = null;//TODO
				if(RENDER_VEHILE_MODELS_AS_ITEMS && !veh.no3DItemModel()){
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
			net.minecraft.client.resources.IResource res = net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(type.getID().space(), "textures/items/" + type.getID().id() + ".png"));
			return res == null;
		}
		catch(IOException e){
			//e.printStackTrace();
			return true;
		}
	}

}
