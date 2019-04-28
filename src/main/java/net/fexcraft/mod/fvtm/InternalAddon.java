package net.fexcraft.mod.fvtm;

import java.io.File;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Addon;
import net.fexcraft.mod.fvtm.data.AddonClass;
import net.fexcraft.mod.fvtm.data.AddonTab;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;

@AddonClass(registryname = "fvtm:fvtm", hasJson = false)
public class InternalAddon extends Addon {
	
	public static final ResourceLocation REGNAME = new ResourceLocation("fvtm:fvtm");
	public static InternalAddon INSTANCE;

	public InternalAddon(ContainerType type, File file){
		super(type, file); registryname = REGNAME; INSTANCE = this;
		name = "FVTM [Internal Addon]"; version = FVTM.VERSION;
		this.authors.add("FEX___96"); update_id = "null";
		url = "http://fexcraft.net/not_found";
		license = "http://fexcraft.net/license?id=mods";
		if(Static.side().isClient()){ this.creativetab = new AddonTab(this); }
	}
	
	@Override /** This addon is shipped with the FVTM jar, so we don't search for content. */
	public void searchFor(DataType data){
		return;
	}
	
}
