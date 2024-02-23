package net.fexcraft.mod.fvtm;

import java.io.File;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonOld;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;

@AddonClass(registryname = "fvtm:fvtm")
public class InternalAddon extends AddonOld {
	
	public static final IDL REGNAME = IDLManager.getIDLCached("fvtm:fvtm");
	public static final IDL STANDARD_GAUGE = IDLManager.getIDLCached("fvtm:standard");
	public static InternalAddon INSTANCE;

	public InternalAddon(ContainerType type, File file){
		super(type, file);
		//registryname = REGNAME;
		INSTANCE = this;
		name = "FVTM [Internal Addon]";
		version = FVTM.VERSION;
		authors.add("FEX___96");
		update_id = "null";//not checking for updates, since this is the internal Addon, FVTM does that
		url = "https://fexcraft.net/minecraft/mod?id=fvtm";
		license = "https://fexcraft.net/license?id=mods";
		if(Static.side().isClient()){
			//(creativetabs = new HashMap<>()).put(AddonTab.DEFAULT, new AddonTab(this, AddonTab.DEFAULT));
		}
	}
	
	/** This addon is shipped with the FVTM jar, so we don't search for content. Edit: except the default rail gauge now. */
	public void searchFor(ContentType data){
		if(data == ContentType.RAILGAUGE){
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
			//data.register(gauge = new RailGauge().parse(obj)); int r = RAIL_PLACING_GRID;
			//gauge.getPresets().add(new RailPresetItem(gauge, "4_straight", new GridV3D(0, 0, 0, r), new GridV3D(4, 0, 0, r)).setSegmentation(8));
			//gauge.getPresets().add(new RailPresetItem(gauge, "8_straight", new GridV3D(0, 0, 0, r), new GridV3D(8, 0, 0, r)).setSegmentation(8));
			//gauge.getPresets().add(new RailPresetItem(gauge, "16_straight", new GridV3D(0, 0, 0, r), new GridV3D(16, 0, 0, r)).setSegmentation(8));
			//gauge.getPresets().add(new RailPresetItem(gauge, "32_straight", new GridV3D(0, 0, 0, r), new GridV3D(32, 0, 0, r)).setSegmentation(8));
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
			//gauge.getPresets().add(new RailPresetItem(gauge, "16_straight_slope_up", new GridV3D(0, 0, 0, r), new GridV3D(2, 0, 0, r),new GridV3D(14, 1, 0, r), new GridV3D(16, 1, 0, r)).setSegmentation(8));
			//gauge.getPresets().add(new RailPresetItem(gauge, "16_straight_slope_down", new GridV3D(0, 0, 0, r), new GridV3D(2, 0, 0, r),new GridV3D(14, -1, 0, r), new GridV3D(16, -1, 0, r)).setSegmentation(8));
		}
		return;
	}
	
}
