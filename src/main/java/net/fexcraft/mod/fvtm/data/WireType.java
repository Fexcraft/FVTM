package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.WireModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireType extends TypeCore<WireType> implements Tabbed {
	
	protected String type;
	protected float def_slack;
	protected boolean customisable;
	protected WireItem item;
	protected ResourceLocation wire_texture, model_texture;
	//
	protected String modelid, ctab;
	protected WireModel model;
	
	public WireType(){}

	@Override
	public WireType setRegistryName(ResourceLocation name){
		this.registryname = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<WireType> getRegistryType(){
		return WireType.class;
	}

	@Override
	public WireType parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Rail Gauge");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.type = JsonUtil.getIfExists(obj, "Type", "universal");
		this.def_slack = JsonUtil.getIfExists(obj, "Slack", 1f).floatValue();
		this.customisable = JsonUtil.getIfExists(obj, "Customisable", true);
		this.wire_texture = new ResourceLocation(JsonUtil.getIfExists(obj, "WireTexture", "minecraft:textures/blocks/anvil_base.png"));
		this.model_texture = new ResourceLocation(JsonUtil.getIfExists(obj, "ModelTexture", "fvtm:textures/entity/null.png"));
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		//
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
		this.item = new WireItem(this);
		return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.WIRE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}
	
	public WireItem getWireItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}
	
	public String wire_type(){
		return type;
	}

	public float default_slack(){
		return def_slack;
	}
	
	public boolean customisable(){
		return customisable;
	}
	
	@Override
	public void loadModel(){
		this.model = (WireModel)Resources.getModel(modelid, WireModel.class);
	}
	
	public ResourceLocation getWireTexture(){
		return wire_texture;
	}
	
	public ResourceLocation getModelTexture(){
		return model_texture;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public WireModel getModel(){
		return model;
	}

}
