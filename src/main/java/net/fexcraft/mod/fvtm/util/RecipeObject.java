package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeObject {

    public static ArrayList<RecipeObject> temp_list = new ArrayList<RecipeObject>();
    private ItemStack stack;
    private Type type;
    //
    private String input;
    private int inputmeta = 0;
    private String container;
    private float exp = 0.0f;
    //
    private String[] components;
    private int[] amount, meta;
    private String category;
    private NBTTagCompound[] compounds;
    //
    private static final TreeMap<String, Boolean> mods = new TreeMap<String, Boolean>();

    public static void parse(ItemStack stack, JsonObject obj, @Nullable String category) throws Exception{
        if(obj.has("Mods")){
            for(JsonElement elm : obj.get("Mods").getAsJsonArray()){
                String string = elm.getAsString();
                if(mods.containsKey(string)){
                    if(!mods.get(string)){
                        return;
                    }
                }
                boolean bool = Loader.isModLoaded(string);
                mods.put(string, bool);
                if(!bool){
                    return;
                }
            }
        }
        if(obj.has("Addons")){
            for(JsonElement elm : obj.get("Addons").getAsJsonArray()){
                String string = elm.getAsString();
                if(!Resources.ADDONS.containsKey(new ResourceLocation(string))){
                    return;
                }
            }
        }
        if(obj.has("NBTTagCompound")){
            stack.setTagCompound(JsonToNBT.getTagFromJson(obj.get("NBTTagCompound").getAsJsonObject().toString()));
        }
        RecipeObject rcp = new RecipeObject();
        rcp.stack = stack;
        rcp.type = Type.fromString(obj.get("Type").getAsString());
        switch(rcp.type){
            case BLUEPRINT: {
                rcp.category = category == null ? "Uncategorised" : category;
                if(obj.has("Category")){
                    rcp.category = obj.get("Category").getAsString();
                }
                JsonArray array = obj.get("Components").getAsJsonArray();
                rcp.components = new String[array.size()];
                rcp.amount = new int[array.size()];
                rcp.meta = new int[array.size()];
                rcp.compounds = new NBTTagCompound[array.size()];
                for(int i = 0; i < array.size(); i++){
                    JsonObject jsn = array.get(i).getAsJsonObject();
                    rcp.components[i] = JsonUtil.getIfExists(jsn, "Item", "minecraft:stone");
                    rcp.amount[i] = JsonUtil.getIfExists(jsn, "Amount", 1).intValue();
                    rcp.meta[i] = JsonUtil.getIfExists(jsn, "Meta", -1).intValue();
                    rcp.compounds[i] = jsn.has("NBTTagCompound") ? JsonToNBT.getTagFromJson(jsn.get("NBTTagCompound").getAsJsonObject().toString()) : null;
                }
                break;
            }
            case SMELTING:
                if(obj.has("Input")){
                    rcp.input = obj.get("Input").getAsString();
                    if(obj.has("InputMeta")){
                        rcp.inputmeta = obj.get("InputMeta").getAsInt();
                    }
                    if(obj.has("Container")){
                        rcp.container = obj.get("Container").getAsString();
                    }
                    if(obj.has("Output")){
                        stack.setCount(obj.get("Output").getAsInt());
                    }
                    if(obj.has("Experience")){
                        rcp.exp = obj.get("Experience").getAsFloat();
                    }
                }
                else{
                    Print.debug("Recipe don't has an input Item!\n" + obj.toString());
                }
                break;
            case NULL:
            default:
                Print.debug("Invalid Recipe Type!\n" + obj.toString());
                break;
        }
        if(rcp.type != Type.NULL){
            temp_list.add(rcp);
        }
    }

    public static void registerRecipes(){
        for(RecipeObject obj : temp_list){
            Print.debug("[FVTM] Registering recipe for " + obj.stack.toString() + ";");
            try{
                switch(obj.type){
                    case BLUEPRINT: {
                        ItemStack[] stacks = new ItemStack[obj.components.length];
                        for(int i = 0; i < stacks.length; i++){
                            stacks[i] = new ItemStack(Item.getByNameOrId(obj.components[i]), obj.amount[i], obj.meta[i]);
                            if(obj.compounds[i] != null){
                                stacks[i].setTagCompound(obj.compounds[i]);
                            }
                        }
                        RecipeRegistry.addBluePrintRecipe(obj.category == null ? "FVTM Categoryless Recipes" : obj.category, obj.stack, stacks);
                        break;
                    }
                    case SMELTING: {
                        ItemStack istack = obj.container == null
                                ? new ItemStack(Item.getByNameOrId(obj.input), 1, obj.inputmeta)
                                : new ItemStack(Item.getByNameOrId(obj.input).setContainerItem(Item.getByNameOrId(obj.container)), 1, obj.inputmeta);
                        GameRegistry.addSmelting(istack, obj.stack, obj.exp);
                        break;
                    }
                    case NULL:
                    default:
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        temp_list.clear();
        temp_list = null;
    }

    private static enum Type {

        BLUEPRINT, SMELTING, NULL;
        //TODO Shaped and Shapeless handle via vanilla json recipes?

        public static Type fromString(String string){
            for(Type type : values()){
                if(type.name().toLowerCase().equals(string.toLowerCase())){
                    return type;
                }
            }
            return NULL;
        }

        @Override
        public String toString(){
            return this.name();
        }
    }

}
