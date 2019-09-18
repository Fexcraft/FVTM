package net.fexcraft.mod.fvtm.data;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGauge extends TypeCore<RailGauge> {
	
	/** In "micro blocks" (1 = 1/16th of a block). */
	protected int width;
	protected RailGaugeItem item;
	protected List<String> compatible;
	
	public RailGauge(){}

	@Override
	public RailGauge setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<RailGauge> getRegistryType(){
		return RailGauge.class;
	}

	@Override
	public RailGauge parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Rail Gauge");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.width = JsonUtil.getIfExists(obj, "Width", 30).intValue();
		this.compatible = DataUtil.getStringArray(obj, "Compatible", false, true);
		//
		this.item = new RailGaugeItem(this); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.RAILGAUGE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}
	
	public RailGaugeItem getRailGaugeItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}

	public int width(){
		return width;
	}

	public List<String> getCompatible(){
		return compatible;
	}

}
