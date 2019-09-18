package net.fexcraft.mod.fvtm;

import java.io.File;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonTab;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;

@AddonClass(registryname = "fvtm:fvtm", hasJson = false)
public class InternalAddon extends Addon {
	
	public static final ResourceLocation REGNAME = new ResourceLocation("fvtm:fvtm");
	public static final ResourceLocation STANDARD_GAUGE = new ResourceLocation("fvtm:standard");
	public static InternalAddon INSTANCE;

	public InternalAddon(ContainerType type, File file){
		super(type, file); registryname = REGNAME; INSTANCE = this;
		name = "FVTM [Internal Addon]"; version = FVTM.VERSION;
		this.authors.add("FEX___96"); update_id = "null";
		url = "http://fexcraft.net/not_found";
		license = "http://fexcraft.net/license?id=mods";
		registerer = FVTM.getRegisterer();
		if(Static.side().isClient()){ this.creativetab = new AddonTab(this); }
	}
	
	/** This addon is shipped with the FVTM jar, so we don't search for content. Edit: except the default rail gauge now. */ @Override
	public void searchFor(DataType data){
		if(data == DataType.RAILGAUGE){
			JsonObject obj = new JsonObject();
			obj.addProperty("RegistryName", STANDARD_GAUGE.toString());
			obj.addProperty("Addon", REGNAME.toString());
			obj.addProperty("Name", "30px Standard Gauge");
			obj.addProperty("Description", "&9The &a125% &9scale (compared to 1:1 real scale)\n&7&lStandard Gauge &r&9of FVTM.");
			obj.addProperty("InnerWidth", 30); obj.addProperty("RailWidth", 2);
			data.register(new RailGauge().parse(obj));
		}
		return;
	}
	
}
