package net.fexcraft.mod.fvtm.data.root;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class TypeCore<SELF> implements IForgeRegistryEntry<SELF> {
	
	public abstract SELF parse(JsonObject obj);
	
	public abstract DataType getDataType();
	
	/** @return null if absent */
	public abstract Class<?> getDataClass();
	
	public Addon getAddon(){ return pack; }

	public String getName(){ return name; }

	public Item getItem(){ return null; }
	
	public List<String> getDescription(){ return description; }
	
	/** Overrride if being a type using a Model. */
	public void loadModel(){}
	
	protected ResourceLocation registryname;
	protected List<String> description;
	protected String name;
	protected Addon pack;
	
	//
	
	public static abstract class TypeCoreItem<SELF extends TypeCore<SELF>> extends Item {
		
		public SELF type;
		
		public TypeCoreItem(SELF core){
			this.type = core;
		}
		
		public SELF getType(){
			return type;
		}
		
	    @SuppressWarnings("deprecation")
		@Override
	    public String getItemStackDisplayName(ItemStack stack){
	    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
	    	if(cache == null || !cache.overridesLang(false)){
	        	String langname = "item." + stack.getItem().getRegistryName().toString() + ".name";
	        	langname = net.minecraft.util.text.translation.I18n.translateToLocal(langname).trim();
	        	if(langname.length() > 0) return langname;
	        	if(cache != null) stack.getCapability(Capabilities.VAPDATA, null).overridesLang(true);
	    	}
	        return Formatter.format(type.getName());
	    }
		
	}
	
}