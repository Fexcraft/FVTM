package net.fexcraft.mod.fvtm;

import java.io.File;

import net.fexcraft.mod.fvtm.data.Addon;
import net.fexcraft.mod.fvtm.data.AddonClass;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.discovery.ContainerType;

@AddonClass(registryname = "fvtm:internal", hasJson = false)
@Mod(modid = "fvtm_internal", name = "FVTM Internal Addon", version = "2.0", useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class InternalAddon extends Addon {
	
	public static final ResourceLocation REGNAME = new ResourceLocation("fvtm:internal");

	/** Parameterless constructor for Forge. */
	public InternalAddon(){
		super(null, null);
	}

	public InternalAddon(ContainerType type, File file){
		super(type, file); registryname = REGNAME;
		name = "FVTM - Internal Addon"; version = FVTM.VERSION;
		this.authors.add("FEX___96"); update_id = "null";
		url = "http://fexcraft.net/not_found";
		license = "http://fexcraft.net/license?id=mods";
	}
	
	@Override /** This addon is shipped with the FVTM jar, so we don't search for content. */
	public void searchFor(DataType data){
		return;
	}
	
}
