package net.fexcraft.mod.fme;

import net.fexcraft.mod.lib.util.registry.RegistryUtil.AutoRegisterer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * Currently shipped together with FVTM,
 * separate is distribution forbidden.
 * 
 * @author Ferdinand (FEX___96)
 *
 */

@Mod(modid = FME.MODID, name = "Fex's Model Editor", version = "1.0", dependencies = "required-after:fcl")
public class FME {
	
	public static final String MODID = "fme";
	public static AutoRegisterer autoreg;
	
	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		autoreg = new AutoRegisterer(MODID);
	}
	
}