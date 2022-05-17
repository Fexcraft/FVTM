package net.fexcraft.mod.fvtm;

import java.io.File;
import java.util.HashMap;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.addon.AddonTab;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.minecraft.resources.ResourceLocation;

public class InternalAddon extends Addon {

	public static ResourceLocation REGNAME = new ResourceLocation("fvtm:fvtm");
	public static InternalAddon INSTANCE;
	
	public InternalAddon(){
		super(ContainerType.ZIP, new File("."), AddonLocation.MODJAR);
		this.registryname = REGNAME;
		this.creativetabs = new HashMap<>();
		INSTANCE = this;
	}
	
	@Override
	public void searchFor(DataType data){
		return;
	}
	
	@Override
	public Addon parse(JsonObject obj){
		this.name = "FVTM Internal Addon";
		creativetabs.put(AddonTab.DEFAULT, new AddonTab(this, AddonTab.DEFAULT));
		return this;
	}

}
