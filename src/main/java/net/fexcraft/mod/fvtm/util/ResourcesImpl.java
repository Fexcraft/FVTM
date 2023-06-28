package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
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

}
