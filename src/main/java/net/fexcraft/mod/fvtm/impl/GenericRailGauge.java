package net.fexcraft.mod.fvtm.impl;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM.InternalAddon;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericRailGauge implements Gauge {

    private Model<TrackTileEntity, Connection> model;
    private ResourceLocation registryname;
    private Addon addon;
    private String name;
    private String[] description;
    private float width;

	public GenericRailGauge(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "CONSUMABLE");
        this.addon = DataUtil.getAddon(registryname, obj, "CONSUMABLE");
        this.name = JsonUtil.getIfExists(obj, "FullName", this.registryname.toString());
        this.description = DataUtil.getDescription(obj);
        this.width = JsonUtil.getIfExists(obj, "GaugeInnerWidth", 30).floatValue();
        if(Static.side().isClient()){
            this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), TrackTileEntity.class, Connection.class, RailGaugeModel.class);
        }
	}

	public GenericRailGauge(InternalAddon addon, ResourceLocation resloc, float f){
		this.registryname = resloc; this.addon = addon; this.width = f;
		this.name = f + "px Standard Gauge"; this.description = new String[]{ "&7&oInCode Created Gauge." };
	}

	@Override
	public ItemStack getItemStack(){
        ItemStack stack = new ItemStack(GenericConsumableItem.INSTANCE);
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString(Gauge.GaugeItem.NBTKEY, this.getRegistryName().toString());
        stack.setTagCompound(compound); return stack;
	}

	@Override
	public Addon getAddon(){
		return addon;
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String[] getDescription(){
		return description;
	}

	@Override
	public Gauge setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public float width(){
		return width;
	}

	@Override
	public Model<TrackTileEntity, Connection> getModel(){
		return model;
	}
	
}