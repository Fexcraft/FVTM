package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DirectPipe {
	
	public String fluidcategory;
	public int transferspeed = 50;
	public Model model;
	public ResourceLocation texture;
	public String id, modelloc;

	public DirectPipe(String id, JsonElement elm){
		this.id = id;
		if(elm.isJsonObject()){
			JsonObject obj = elm.getAsJsonObject();
			fluidcategory = JsonUtil.getIfExists(obj, "category", "general");
			transferspeed = JsonUtil.getIfExists(obj, "transfer", 100).intValue();
			modelloc = JsonUtil.getIfExists(obj, "model", "null");
			texture = obj.has("texture") ? new ResourceLocation(obj.get("texture").getAsString()) : Resources.NULL_TEXTURE;
		}
		else{
			fluidcategory = elm.getAsString();
		}
		Print.debug(id + " " + elm);
		Static.stop();
	}
}
