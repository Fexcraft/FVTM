package net.fexcraft.mod.fvtm.data.root;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public abstract class TypeCore<SELF> {
	
	public abstract SELF parse(JsonObject obj);
	
	public abstract DataType getDataType();
	
	/** @return null if absent */
	public abstract Class<?> getDataClass();
	
	public Addon getAddon(){ return pack; }

	public String getName(){ return name; }

	public Item getItem(){ return item; }
	
	public Item setItem(TypeCoreItem<?> item){
		return this.item = item;
	}
	
	public List<String> getDescription(){ return description; }
	
	/** Overrride if being a type using a Model. */
	public void loadModel(){}
	
	public ResourceLocation getRegistryName(){
		return registryname;
	}
	
	protected ResourceLocation registryname;
	protected List<String> description;
	protected String name;
	protected Addon pack;
	protected TypeCoreItem<?> item;
	
	//
	
	public static abstract class TypeCoreItem<SELF extends TypeCore<SELF>> extends Item {
		
		public SELF type;
		
		public TypeCoreItem(Properties prop, SELF core){
			super(prop);
			this.type = core;
			this.setRegistryName(core.getRegistryName());
		}
		
		public SELF getType(){
			return type;
		}
		
		/*@Override
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
	    }*///TODO find equivalent if still necessary
	    
	    /*public int getSlotOf(EntityPlayer player, ItemStack stack){
	    	ItemStack istack = null;
	        for(int i = 0; i < player.inventory.mainInventory.size(); ++i){
	        	istack = player.inventory.mainInventory.get(i);
	            if(!istack.isEmpty() && areStacksEqual(stack, istack)) return i;
	        }
	        return -1;
	    }*///TODO check if still necessary
	    
	    /*public boolean areStacksEqual(ItemStack stack0, ItemStack stack1){
	    	if(stack0.getItem() != stack1.getItem()) return false;
	    	if(stack0.getHasSubtypes() && stack0.getMetadata() != stack1.getMetadata()) return false;
	        return ItemStack.areItemStackTagsEqual(stack0, stack1);
	    }*///TODO check if still necessary
		
	}
	
}