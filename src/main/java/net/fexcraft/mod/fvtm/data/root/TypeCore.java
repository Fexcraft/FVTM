package net.fexcraft.mod.fvtm.data.root;

import java.util.List;

import com.google.gson.JsonObject;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@Deprecated
public abstract class TypeCore<SELF> {

	public ResourceLocation getRegistryName(){ return registryname; }
	
	public abstract SELF parse(JsonObject obj);
	
	public abstract ContentType getDataType();
	
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
	    	if(type.getDataClass() == null) return super.getItemStackDisplayName(stack);
	    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
	    	if(cache == null || !cache.overridesLang(false)){
	        	String langname = "item." + stack.getItem().getRegistryName().toString() + ".name";
	        	langname = net.minecraft.util.text.translation.I18n.translateToLocal(langname).trim();
	        	if(langname.length() > 0) return langname;
	        	if(cache != null) stack.getCapability(Capabilities.VAPDATA, null).overridesLang(true);
	    	}
	        return Formatter.format(type.getName());
	    }
	    
	    public int getSlotOf(EntityPlayer player, ItemStack stack){
	    	ItemStack istack = null;
	        for(int i = 0; i < player.inventory.mainInventory.size(); ++i){
	        	istack = player.inventory.mainInventory.get(i);
	            if(!istack.isEmpty() && areStacksEqual(stack, istack)) return i;
	        }
	        return -1;
	    }
	    
	    public boolean areStacksEqual(ItemStack stack0, ItemStack stack1){
	    	if(stack0.getItem() != stack1.getItem()) return false;
	    	if(stack0.getHasSubtypes() && stack0.getMetadata() != stack1.getMetadata()) return false;
	        return ItemStack.areItemStackTagsEqual(stack0, stack1);
	    }
		
	}
	
}