package net.fexcraft.mod.fme;

import net.fexcraft.mod.fme.overlay.SelectedPolygon;
import net.fexcraft.mod.lib.util.registry.RegistryUtil.AutoRegisterer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * Currently shipped together with FVTM,
 * separate is distribution forbidden.
 * 
 * @author Ferdinand (FEX___96)
 *
 */

@Mod(modid = FME.MODID, name = "Fex's Model Editor", version = "1.0", clientSideOnly = true, dependencies = "required-after:fcl")
public class FME {
	
	public static final String MODID = "fme";
	public static AutoRegisterer autoreg;
	
	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		autoreg = new AutoRegisterer(MODID);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new SelectedPolygon());
		//
		for(int i = 0; i < SelectedPolygon.keys.length; i++){
			ClientRegistry.registerKeyBinding(SelectedPolygon.keys[i]);
		}
	}
	
}