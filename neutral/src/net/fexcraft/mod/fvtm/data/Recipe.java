package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.FclRecipe;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.item.StackWrapper;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Recipe extends Content<Recipe> {

    public boolean fcl;
    public String category;
    public StackWrapper output;
    public ArrayList<FclRecipe.Component> fclcomps = new ArrayList<>();

    @Override
    public Recipe parse(JsonMap map){
        if((pack = ContentConfigUtil.getAddon(map)) == null)return null;
        if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
        name = map.getString("Name", "Unnamed Recipe");
        description = ContentConfigUtil.getStringList(map, "Description");
        category = map.getString("Category", "recipe." + pack.id.colon());
        //
        String type = map.getString("Type", "fcl").toLowerCase();
        fcl = type.equals("fcl:crafting");
        output = parseStack(null, map.getMap("Result"));
        boolean v12 = EnvInfo.is112();
        boolean v20 = EnvInfo.is120();
        for(Map.Entry<String, JsonValue<?>> entry : map.get("Components").asMap().entries()){
            JsonMap val = entry.getValue().asMap();
            String ctype = val.getString("type", "item");
            switch(ctype){
                case "item":{
                    if(val.has("1.12") && !v12) continue;
                    StackWrapper item = parseStack(entry.getKey(), val);
                    if(!item.empty()) fclcomps.add(new FclRecipe.Component(item));
                    break;
                }
                case "ore":{
                    if(!v12) continue;
                    fclcomps.add(new FclRecipe.Component(entry.getKey(), val.getInteger("amount", 1)));
                    break;
                }
                case "tag":{
                    if(v12) continue;
                    String key = entry.getKey();
                    if(v20 && key.startsWith("c:")) key = key.replace("c:", "forge:");
                    else if(!v20 && key.startsWith("forge:")) key = key.replace("forge:", "c:");
                    fclcomps.add(new FclRecipe.Component(key, val.getInteger("amount", 1)));
                    break;
                }
            }
        }
        return this;
    }

    private StackWrapper parseStack(String key, JsonMap result){
        StackWrapper stack = FvtmResources.newStack(IDLManager.getIDLCached(key == null ? result.getString("id", "minecraft:stone") : key));
        stack.count(result.getInteger("amount", 1));
        if(result.has("damage")) stack.damage(result.getInteger("damage", 0));
        return stack;
    }

    @Override
    public ContentType getContentType(){
        return ContentType.RECIPE;
    }

    @Override
    public Class<?> getDataClass(){
        return null;
    }

}
