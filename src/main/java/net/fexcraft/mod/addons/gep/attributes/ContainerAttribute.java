package net.fexcraft.mod.addons.gep.attributes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ContainerAttribute implements Attribute {

    private static final ResourceLocation regname = new ResourceLocation("container");
    private ContainerType[] supported;
    private ContainerType type;
    private float rotation;
    private Pos offset;

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
        type = ContainerType.valueOf(JsonUtil.getIfExists(obj, "Container-Type", ContainerType.MEDIUM.name()).toUpperCase());
        offset = Pos.fromJSON(JsonUtil.getIfExists(obj, "Container-Offset", new JsonObject()).getAsJsonObject());
        rotation = JsonUtil.getIfExists(obj, "Container-Rotation", 0f).floatValue();
        if(obj.has("Container-SupportedTypes")){
        	ArrayList<String> arrlist = new ArrayList<>();
        	JsonArray array = obj.get("Container-SupportedTypes").getAsJsonArray();
        	for(JsonElement elm : array){ arrlist.add(elm.getAsString()); }
        	ArrayList<ContainerType> conlist = new ArrayList<>();
        	for(String str : arrlist){
        		ContainerType type = ContainerType.valueOf(str);
        		if(type != null) conlist.add(type);
        	}
        	this.supported = conlist.toArray(new ContainerType[0]);
        }
    }

    @Override
    public String getName(){
        return "Container Holder";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
        tooltip.add(Formatter.format("&9Container Type: &7" + type.name()));
    }

    @Override
    public boolean hasDataClass(){
        return false;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return null;
    }

    public Pos getContainerOffset(){
        return offset;
    }

    public float getContainerRotation(){
        return rotation;
    }

    public ContainerType getContainerType(){
        return type;
    }
    
    public ContainerType[] getSupportedTypes(){
    	return supported;
    }

	@Override
	public boolean hasRenderData(){
		return false;
	}

}
