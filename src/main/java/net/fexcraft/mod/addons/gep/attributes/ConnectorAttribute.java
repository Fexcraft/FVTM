package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ConnectorAttribute implements Attribute {

    private static final ResourceLocation regname = new ResourceLocation("connector");
    private Pos front, rear;
    private TreeMap<String, Pos> frontAlt = new TreeMap<String, Pos>(), rearAlt = new TreeMap<String, Pos>();

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
        if(obj.has("Front-Connector")){
            JsonElement elm = obj.get("Front-Connector");
            if(elm.isJsonArray()){
                JsonArray array = elm.getAsJsonArray();
                for(JsonElement e : array){
                    JsonObject jsn = e.getAsJsonObject();
                    if(jsn.has("Vehicle")){
                        frontAlt.put(jsn.get("Vehicle").getAsString(), Pos.fromJSON(jsn));
                    }
                    else{
                        front = Pos.fromJSON(jsn);
                    }
                }
            }
            else if(elm.isJsonObject()){
                front = Pos.fromJSON(elm.getAsJsonObject());
            }
        }
        else{
            front = null;
        }
        if(obj.has("Rear-Connector")){
            JsonElement elm = obj.get("Rear-Connector");
            if(elm.isJsonArray()){
                JsonArray array = elm.getAsJsonArray();
                for(JsonElement e : array){
                    JsonObject jsn = e.getAsJsonObject();
                    if(jsn.has("Vehicle")){
                        rearAlt.put(jsn.get("Vehicle").getAsString(), Pos.fromJSON(jsn));
                    }
                    else{
                        rear = Pos.fromJSON(jsn);
                    }
                }
            }
            else if(elm.isJsonObject()){
                front = Pos.fromJSON(elm.getAsJsonObject());
            }
        }
        else{
            rear = null;
        }
    }

    @Override
    public String getName(){
        return "Trailer Connector";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
        tooltip.add(Formatter.format("&9Front Connector: &7" + (front == null && frontAlt.isEmpty() ? "none" : "exists") + " (alt: " + (frontAlt.size() - (front == null ? -1 : 0)) + ");"));
        tooltip.add(Formatter.format("&9Rear Connector: &7" + (rear == null && rearAlt.isEmpty() ? "none" : "exists") + " (alt: " + (rearAlt.size() - (rear == null ? -1 : 0)) + ");"));
    }

    @Override
    public boolean hasDataClass(){
        return false;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return null;
    }

    public boolean hasFrontConnector(ResourceLocation rs){
        return frontAlt.containsKey(rs.toString()) ? true : !(front == null);
    }

    public Pos getFrontConnector(ResourceLocation rs){
        return frontAlt.containsKey(rs.toString()) ? frontAlt.get(rs.toString()) : front;
    }

    public boolean hasRearConnector(ResourceLocation rs){
        return rearAlt.containsKey(rs.toString()) ? true : !(rear == null);
    }

    public Pos getRearConnector(ResourceLocation rs){
        return rearAlt.containsKey(rs.toString()) ? rearAlt.get(rs.toString()) : rear;
    }

	@Override
	public boolean hasRenderData(){
		return false;
	}

}
