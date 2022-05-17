package net.fexcraft.mod.fvtm.data.addon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AddonTab extends CreativeModeTab {
	
    private static TreeMap<ResourceLocation, AddonTab> TABS = new TreeMap<>();
    public static final String DEFAULT = "default";
    private ArrayList<ItemStack> list;
    private int icon, sec;
	private Addon addon;

	public AddonTab(Addon addon, String string){
		super(addon.getRegistryName().toString() + (string.equals(DEFAULT) ? "" : "." + string));
		TABS.put(new ResourceLocation(addon.getRegistryName().toString() + (string.equals(DEFAULT) ? "" : "." + string)), this);
		this.addon = addon;
	}

	@Override
	public ItemStack makeIcon(){
		return new ItemStack(Items.STONE);
	}

    public String getTranslatedTabLabel(){
        return addon.getName();
    }

    public Addon getAddon(){
        return addon;
    }

    /*@Override
    public ItemStack getIcon(){
        if(list == null){ list = NonNullList.create(); this.displayAllRelevantItems(list); }
        if(sec != Time.getSecond()){
        	sec = Time.getSecond(); this.icon++; if(icon >= list.size()){ icon = 0; }
        } return icon >= list.size() ? ItemStack.EMPTY : list.get(icon);
    }*/
    
    public static final AddonTab getTab(ResourceLocation addonid){
    	return TABS.get(addonid);
    }

	public static Collection<AddonTab> getTabs(){
		return TABS.values();
	}

}
