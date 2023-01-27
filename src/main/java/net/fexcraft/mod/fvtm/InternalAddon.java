package net.fexcraft.mod.fvtm;

import java.io.File;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Statics;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonTab;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.item.RailPresetItem;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;

@AddonClass(registryname = "fvtm:fvtm", hasJson = false)
public class InternalAddon extends Addon {
	
	public static final ResourceLocation REGNAME = new ResourceLocation("fvtm:fvtm");
	public static final ResourceLocation STANDARD_GAUGE = new ResourceLocation("fvtm:standard");
	public static InternalAddon INSTANCE;

	public InternalAddon(ContainerType type, File file){
		super(type, file);
		registryname = REGNAME;
		INSTANCE = this;
		name = "FVTM [Internal Addon]";
		version = FVTM.VERSION;
		authors.add("FEX___96");
		update_id = "null";//not checking for updates, since this is the internal Addon, FVTM does that
		url = "https://fexcraft.net/minecraft/mod?id=fvtm";
		license = "https://fexcraft.net/license?id=mods";
		registerer = FVTM.getRegisterer();
		if(Statics.side().isClient()){
			(creativetabs = new HashMap<>()).put(AddonTab.DEFAULT, new AddonTab(this, AddonTab.DEFAULT));
		}
	}
	
	/** This addon is shipped with the FVTM jar, so we don't search for content. Edit: except the default rail gauge now. */ @Override
	public void searchFor(DataType data){
		if(data == DataType.RAILGAUGE){
			JsonObject obj = new JsonObject(); RailGauge gauge;
			obj.addProperty("RegistryName", STANDARD_GAUGE.toString());
			obj.addProperty("Addon", REGNAME.toString());
			obj.addProperty("Name", "30px Standard Gauge (FVTM)");
			JsonArray array = new JsonArray();
			array.add("fvtm:standard.gauge_desc0");
			array.add("fvtm:standard.gauge_desc1");
			array.add("fvtm:standard.gauge_desc2");
			obj.add("Description", array);
			obj.addProperty("Width", 30);
			obj.addProperty("Height", 4);
			obj.addProperty("Model", "fvtm:models/gauges/standard_wood_ties.obj");
			obj.addProperty("TiesTexture", "fvtm:textures/blocks/standard_gauge_wood.png");
			obj.addProperty("ModelTexture", "fvtm:textures/blocks/30px_standard_gauge.png");
			obj.add("PreSets", new JsonArray());
			data.register(gauge = new RailGauge().parse(obj)); int r = Config.RAIL_PLACING_GRID;
			gauge.getPresets().add(new RailPresetItem(gauge, "4_straight", new Vec316f(0, 0, 0, r), new Vec316f(4, 0, 0, r)).setSegmentation(8));
			gauge.getPresets().add(new RailPresetItem(gauge, "8_straight", new Vec316f(0, 0, 0, r), new Vec316f(8, 0, 0, r)).setSegmentation(8));
			gauge.getPresets().add(new RailPresetItem(gauge, "16_straight", new Vec316f(0, 0, 0, r), new Vec316f(16, 0, 0, r)).setSegmentation(8));
			gauge.getPresets().add(new RailPresetItem(gauge, "32_straight", new Vec316f(0, 0, 0, r), new Vec316f(32, 0, 0, r)).setSegmentation(8));
			//
			/*gauge.getPresets().add(new RailPresetItem(gauge, "16_curve_90_right",
				new Vec316f(0, 0, 0, r), new Vec316f(2, 0, 0, r),
				new Vec316f(16, 0, 0, r), new Vec316f(16, 0, 14, r),
				new Vec316f(16, 0, 16, r)).setSegmentation(4));
			gauge.getPresets().add(new RailPresetItem(gauge, "16_curve_90_left",
				new Vec316f(0, 0, 0, r), new Vec316f(2, 0, 0, r),
				new Vec316f(16, 0, 0, r), new Vec316f(16, 0, -14, r),
				new Vec316f(16, 0, -16, r)).setSegmentation(4));*/
			//
			gauge.getPresets().add(new RailPresetItem(gauge, "16_straight_slope_up", new Vec316f(0, 0, 0, r), new Vec316f(2, 0, 0, r),new Vec316f(14, 1, 0, r), new Vec316f(16, 1, 0, r)).setSegmentation(8));
			gauge.getPresets().add(new RailPresetItem(gauge, "16_straight_slope_down", new Vec316f(0, 0, 0, r), new Vec316f(2, 0, 0, r),new Vec316f(14, -1, 0, r), new Vec316f(16, -1, 0, r)).setSegmentation(8));
		}
		return;
	}
	
}
