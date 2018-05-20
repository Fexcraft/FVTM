package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

public class DataUtil {

    public static ResourceLocation getRegistryName(JsonObject obj, String type){
        if(obj.has("RegistryName")){
            return new ResourceLocation(obj.get("RegistryName").getAsString());
        }
        else{
            Print.log(type + " DOES NOT HAVE A REGISTRY NAME, THAT IS AN ISSUE;");
            Print.log(obj);
            Static.halt();
        }
        return null;
    }

    public static Addon getAddon(ResourceLocation registryname, JsonObject obj, String type){
        if(obj.has("Addon")){
            Addon addon = Resources.ADDONS.getValue(new ResourceLocation(obj.get("Addon").getAsString()));
            if(addon == null){
                Print.log("ADDON PACK NOT FOUND FOR " + type + " (" + registryname.toString() + "), OR INCORRECT NAME, THAT IS AN ISSUE;");
                Static.halt();
            }
            return addon;
        }
        else{
            Print.log(type + " (" + registryname + ") DOES NOT HAVE A SET ADDON PACK, THAT IS AN ISSUE;");
            Static.halt();
        }
        return null;
    }

    public static String[] getDescription(JsonObject obj){
        if(obj.has("Description")){
            JsonArray desc = obj.get("Description").getAsJsonArray();
            String[] description = new String[desc.size()];
            for(int i = 0; i < desc.size(); i++){
                description[i] = desc.get(i).getAsString();
            }
            return description;
        }
        return new String[0];
    }

    public static RGB getRGB(JsonObject obj, String string){
        return obj.has(string) ? (obj.get(string).isJsonObject() ? new RGB(obj.get(string).getAsJsonObject()) : new RGB(obj.get(string))) : new RGB();
    }

    public static ArrayList<ResourceLocation> getTextures(JsonObject obj, ResourceLocation registryname, String type){
        ArrayList<ResourceLocation> textures = new ArrayList<ResourceLocation>();
        if(!obj.has("Textures")){
            Print.log("NO TEXTURE FOUND FOR " + type + " (" + registryname.toString() + ")! APPLYING DEFAULT TEXTURE;");
            textures.add(Resources.NULL_TEXTURE);
        }
        else{
            try{
                JsonArray array = obj.get("Textures").getAsJsonArray();
                for(JsonElement elm : array){
                    textures.add(new ResourceLocation(elm.getAsString()));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return textures;
    }

    /*public static Model loadModel(ModelType modeltype, String modelname, Class<? extends Model> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		switch(modeltype){
			case JAVA:
			case TMT:
				Class clasz = Class.forName(modelname.replace(".class", ""));
				return (Model)clasz.newInstance();
			case JSON:
				//TODO;
				return null;
			case JTMT:
				JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(modelname)).getInputStream());
				return clazz.getConstructor(JsonObject.class).newInstance(obj);
			case OBJ:
				//TODO
				return null;
			case NONE:
				if(clazz == PartModel.class){
					return NullModel.get();
				}
			default:
				return null;
		}
	}*/
}
